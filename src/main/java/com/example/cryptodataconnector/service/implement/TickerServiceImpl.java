package com.example.cryptodataconnector.service.implement;

import com.example.cryptodataconnector.dto.request.SaveTickerRequestDto;
import com.example.cryptodataconnector.dto.response.ResponseDto;
import com.example.cryptodataconnector.dto.response.SaveTickerResponseDto;
import com.example.cryptodataconnector.repository.TickerRepository;
import com.example.cryptodataconnector.service.TickerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TickerServiceImpl implements TickerService {

    private final TickerRepository tickerRepository;

    /**
     * 현재가 저장
     */
    @Override
    @Transactional
    public ResponseEntity<? super SaveTickerResponseDto> saveTicker(SaveTickerRequestDto saveTickerRequestDto) {

        try {

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseDto.databaseError();
        }

        return SaveTickerResponseDto.success();
    }
}
