package com.turfhub.turfhub_backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    //Health check
    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("TurfHub backend is running");
    }
}
