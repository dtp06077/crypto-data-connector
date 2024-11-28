package com.example.cryptodataconnector.service.implement;

import com.example.cryptodataconnector.domain.Ticker;
import com.example.cryptodataconnector.dto.request.SaveTickerRequestDto;
import com.example.cryptodataconnector.dto.response.ResponseDto;
import com.example.cryptodataconnector.dto.response.SaveTickerResponseDto;
import com.example.cryptodataconnector.repository.TickerRepository;
import com.example.cryptodataconnector.service.TickerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
    public ResponseEntity<? super SaveTickerResponseDto> saveTicker(SaveTickerRequestDto requestDto) {

        try {
            Ticker ticker = new Ticker(requestDto);
            //DB 저장 시간 설정
            String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
            ticker.setBufferTime(now);

            tickerRepository.save(ticker);

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ResponseDto.databaseError();
        }

        return SaveTickerResponseDto.success();
    }

}
