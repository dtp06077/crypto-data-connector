package com.example.cryptodataconnector.controller;

import com.example.cryptodataconnector.service.TickerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticker")
@RequiredArgsConstructor
public class TickerController {

    private final TickerService tickerService;
    
}
