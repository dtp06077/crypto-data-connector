package com.example.cryptodataconnector.repository;

import com.example.cryptodataconnector.domain.OrderBook;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class OrderBookRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(OrderBook orderBook) {
        em.persist(orderBook);
        return orderBook.getId();
    }

    public OrderBook findById(Long id) {
        return em.find(OrderBook.class, id);
    }
}
