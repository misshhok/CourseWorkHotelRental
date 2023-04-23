package com.example.hotelrental.infrastructure.task;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@ConditionalOnProperty(prefix = "tasks.checkExpiredRents", name = "enabled")
@RequiredArgsConstructor
public class CheckExpiredRentsTask {
    private final CheckExpiredRentsService checkExpiredRentsService;

    @Scheduled(cron = "${tasks.checkExpiredRents.cron}")
    private void checkExpiredRents() {
        checkExpiredRentsService.fireTask();
    }
}
