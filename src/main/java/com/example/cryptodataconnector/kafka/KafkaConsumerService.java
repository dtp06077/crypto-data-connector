package com.example.cryptodataconnector.kafka;

import com.example.cryptodataconnector.dto.request.SaveTickerRequestDto;
import com.example.cryptodataconnector.service.TickerService;
import com.example.cryptodataconnector.transfer.JsonToRequestTransfer;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

@Service
public class KafkaConsumerService {

    private final KafkaConsumer<String, String> consumer;
    @Autowired
    private TickerService tickerService;
    @Autowired
    private JsonToRequestTransfer jsonToRequestTransfer;

    public KafkaConsumerService(@Value("${kafka.bootstrap-servers}") String bootstrapServers) {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "consumer-group-1");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        this.consumer = new KafkaConsumer<>(props);
    }

    @PostConstruct
    public void startConsuming() {
        consumer.subscribe(Collections.singletonList("crypto_topic_dev"));
        // 스레드 분리
        new Thread(this::consumeMessages).start();
    }

    private void consumeMessages() {
        try {
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, String> record : records) {
                    System.out.printf("Consumed message: %s from topic %s%n", record.value(), record.topic());
                    // TODO : json data DB 저장 로직
                    SaveTickerRequestDto requestDto = jsonToRequestTransfer.transfer(record.value());
                    tickerService.saveTicker(requestDto);
                }
            }
        } catch (Exception e) {
            System.err.println("Error in consumer thread: " + e.getMessage());
        }
    }

    @PreDestroy
    public void close() {
        consumer.close();
    }
}
