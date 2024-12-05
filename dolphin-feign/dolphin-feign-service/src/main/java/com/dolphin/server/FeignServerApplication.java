package com.dolphin.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class FeignServerApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(FeignServerApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}