package com.example.hotelrental;

import com.example.hotelrental.infrastructure.service.impl.RoleServiceImpl;
import com.example.hotelrental.infrastructure.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling
@SpringBootApplication
@RequiredArgsConstructor
public class HotelRentalApplication implements CommandLineRunner {

    private final UserServiceImpl userService;
    private final RoleServiceImpl roleService;

    public static void main(String[] args) {
        SpringApplication.run(HotelRentalApplication.class, args);
    }

    @Override
    public void run(final String... args) throws Exception {
        roleService.saveRole("ROLE_ADMIN");
        roleService.saveRole("ROLE_USER");
        userService.saveAdmin();
    }
}

