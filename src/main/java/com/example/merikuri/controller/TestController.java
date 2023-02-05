package com.example.merikuri.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController implements TestApi {

    @Override
    public ResponseEntity<Void> testGet() {
        return ResponseEntity.ok().build();
    }
}
