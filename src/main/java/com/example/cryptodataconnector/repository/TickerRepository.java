package com.example.cryptodataconnector.repository;

import com.example.cryptodataconnector.domain.Ticker;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class TickerRepository {

    private final EntityManager em;

    //현재가 저장
    public long save(Ticker ticker) {
        em.persist(ticker);
        return ticker.getId();
    }
}
