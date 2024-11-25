package com.example.cryptodataconnector.service;

import com.example.cryptodataconnector.dto.request.SaveTickerRequestDto;
import com.example.cryptodataconnector.dto.response.SaveTickerResponseDto;
import org.springframework.http.ResponseEntity;

public interface TickerService {

    //현재가 등록
    ResponseEntity<? super SaveTickerResponseDto> saveTicker(SaveTickerRequestDto saveTickerRequestDto);

}
