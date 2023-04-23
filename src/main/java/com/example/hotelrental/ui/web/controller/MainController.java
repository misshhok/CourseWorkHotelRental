package com.example.hotelrental.ui.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class MainController {

    @GetMapping
    public ResponseEntity<String> mainRoute() {
        return ResponseEntity.ok().body("Ура победа");
    }

    @GetMapping("test/")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok().body("Ура победа test");
    }
}
