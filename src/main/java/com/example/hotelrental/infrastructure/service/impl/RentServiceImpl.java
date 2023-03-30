package com.example.hotelrental.infrastructure.service.impl;

import com.example.hotelrental.infrastructure.dao.AdditionalFeatureEntity;
import com.example.hotelrental.infrastructure.dao.RentEntity;
import com.example.hotelrental.infrastructure.mapper.RentMapper;
import com.example.hotelrental.infrastructure.repository.AdditionalFeatureRepository;
import com.example.hotelrental.infrastructure.repository.RentRepository;
import com.example.hotelrental.infrastructure.service.RentService;
import com.example.hotelrental.infrastructure.service.RoomService;
import com.example.hotelrental.infrastructure.service.dto.rent.CreateRentRequest;
import com.example.hotelrental.infrastructure.service.dto.rent.RentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RentServiceImpl implements RentService {
  public static final int PAGE_SIZE = 1000000;

  private final RentMapper rentMapper = RentMapper.INSTANCE;
  private final RoomService roomService;
  private final RentRepository rentRepository;
  private final AdditionalFeatureRepository additionalFeatureRepository;

  @Override
  public boolean rentRoom(final CreateRentRequest createRentRequest) {
    if (roomService.isRoomAvailable(createRentRequest.getRoomId())
      && createRentRequest.getEntryDate().isBefore(createRentRequest.getDepartureDate())
    ) {
      RentEntity rent = new RentEntity();
      rent.setUser(createRentRequest.getUser());
      rent.setRoom(
        roomService.getRoomByRoomId(createRentRequest.getRoomId())
      );
      rent.setDepartureDate(createRentRequest.getDepartureDate());
      rent.setEntryDate(createRentRequest.getEntryDate());
      rent.setAdditionalFeaturesEntities(
        convertToEntitiesFromIds(
          createRentRequest.getAdditionalFeatureIds()
        )
      );
      rent.setTotalPrice(
        calculateTotalRentPrice(
          roomService.getRoomByRoomId(createRentRequest.getRoomId()).getPricePerDay(),
          convertToEntitiesFromIds(createRentRequest.getAdditionalFeatureIds())
        )
      );
      rentRepository.save(rent);
      return true;
    } else {
      return false;
    }
  }

  @Override
  public boolean isRentExpired(final Long rentId) {
    RentEntity rent = rentRepository.findById(rentId).orElseThrow(
      () -> new IllegalArgumentException("Аренды номера с таким ID нет")
    );
    if (rent.isState()) {
      return rent.getDepartureDate().isBefore(LocalDate.now());
    } else {
      return true;
    }
  }

  @Override
  public boolean idRentExpired(final RentEntity rent) {
    if (rent != null && rent.isState()) {
      return rent.getDepartureDate().isBefore(LocalDate.now());
    } else {
      return true;
    }
  }

  @Override
  public boolean cancelRent(final Long id) {
    RentEntity rent = rentRepository.findById(id).orElseThrow(
      () -> new IllegalArgumentException("Аренды номера с таким ID нет")
    );
    if (rent.getRoom().isState() && !rent.isState()) {
      return false;
    } else {
      roomService.changeRoomState(rent.getRoom().getId());
      rent.setState(false);
      rentRepository.save(rent);
      return true;
    }
  }

  public void cancelRent(RentEntity rent) {
    if (!(rent != null && rent.getRoom().isState() && !rent.isState())) {
      roomService.changeRoomState(rent.getRoom().getId());
      rent.setState(false);
      rentRepository.save(rent);
    }
  }

  @Override
  public boolean cancelAllExpiredTasks() {
    Pageable pageRequest = PageRequest.of(0, PAGE_SIZE, Sort.by("entryDate"));
    Page<RentEntity> page = rentRepository.findAllByState(
      true,
      pageRequest
    );

    while (!page.isEmpty()) {
      page.stream().filter(this::idRentExpired).forEach(this::cancelRent);
      pageRequest = pageRequest.next();
      page = rentRepository.findAllByState(
        true,
        pageRequest
      );
    }
    return true;
  }

  @Override
  public RentDto getRentDtoById(final Long id) {
    return rentMapper.toDto(
      rentRepository.findById(id)
        .orElseThrow(
          () -> new IllegalArgumentException("Аренды номера с таким ID нет")
        )
    );
  }

  @Override public List<RentDto> getAllRents() {
    return rentRepository.findAll()
      .stream()
      .map(rentMapper::toDto)
      .collect(Collectors.toList());
  }

  private BigDecimal calculateTotalRentPrice(
    BigDecimal roomPrice,
    Set<AdditionalFeatureEntity> additionalFeatureEntityList
  ) {
    BigDecimal calculatedTotalRentPrice = roomPrice;
    for (AdditionalFeatureEntity entity : additionalFeatureEntityList) {
      calculatedTotalRentPrice = calculatedTotalRentPrice.add(entity.getPrice());
    }
    return calculatedTotalRentPrice;
  }

  private Set<AdditionalFeatureEntity> convertToEntitiesFromIds(Set<Long> idSet) {
    Set<AdditionalFeatureEntity> additionalFeatureEntityList = new HashSet<>();
    for (Long id : idSet) {
      AdditionalFeatureEntity entity = additionalFeatureRepository.findById(id)
        .orElseThrow(
          () ->
            new IllegalArgumentException(
              "Дополнительной услуги с таким ID не существует"
            )
        );
      additionalFeatureEntityList.add(entity);
    }
    return additionalFeatureEntityList;
  }
}
