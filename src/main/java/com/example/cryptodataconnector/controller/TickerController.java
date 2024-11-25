package com.example.cryptodataconnector.controller;

import com.example.cryptodataconnector.dto.request.SaveTickerRequestDto;
import com.example.cryptodataconnector.dto.response.SaveTickerResponseDto;
import com.example.cryptodataconnector.service.TickerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticker")
@RequiredArgsConstructor
public class TickerController {

    private final TickerService tickerService;

    @PostMapping("")
    public ResponseEntity<? super SaveTickerResponseDto> saveTicker(
            @RequestBody @Valid SaveTickerRequestDto tickerRequestDto) {

        return tickerService.saveTicker(tickerRequestDto);
    }
}
