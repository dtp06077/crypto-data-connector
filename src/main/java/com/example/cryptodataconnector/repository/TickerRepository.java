package com.example.cryptodataconnector.repository;

import com.example.cryptodataconnector.domain.Ticker;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Queue;

@Repository
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TickerRepository {

    private final EntityManager em;
    private final Queue<Ticker> tickerQueue = new LinkedList<>();

    //현재가 저장
    public void save(Ticker ticker) {
        synchronized (tickerQueue) {
            tickerQueue.add(ticker);
        }
    }

    @Scheduled(fixedRate = 60000)
    @Transactional
    public void buffer() {
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        synchronized (tickerQueue) {
            while (!tickerQueue.isEmpty()) {
                Ticker ticker = tickerQueue.poll();
                ticker.setBufferTime(now);
                em.persist(ticker);
            }
        }
    }
}
