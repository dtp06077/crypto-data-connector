package com.example.cryptodataconnector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CryptoDataConnectorApplication {

    public static void main(String[] args) {
        SpringApplication.run(CryptoDataConnectorApplication.class, args);
    }

}
