package com.example.cryptodataconnector.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@Transactional
public class OrderBookRepositoryTest {

//    @Autowired
//    private OrderBookRepository orderBookRepository;
//
//    private OrderBook orderBook;
//
//    @BeforeEach
//    public void setUp() {
//        orderBook = new OrderBook();
//    }
//
//    @Test
//    public void testSaveAndFindById() {
//        // 저장
//        Long savedId = orderBookRepository.save(orderBook);
//
//        // 조회
//        OrderBook foundOrderBook = orderBookRepository.findById(savedId);
//
//        // 검증
//        assertThat(foundOrderBook).isNotNull();
//        assertThat(foundOrderBook.getId()).isEqualTo(savedId);
//    }
}