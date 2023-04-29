package com.example.hotelrental.infrastructure.task;

import com.example.hotelrental.infrastructure.service.RentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class CheckExpiredRentsService {
  private final RentService rentService;

  public void fireTask() {
    log.info("[JOB][CANCEL_RENTS] Cancel all expired rents task was fired!");
    boolean result = rentService.cancelAllExpiredTasks();
    if (result) {
      log.info("[JOB][CANCEL_RENTS] All expired rents are canceled!");
    } else {
      log.error("[JOB][CANCEL_RENTS] Something was wrong");
    }
  }
}
