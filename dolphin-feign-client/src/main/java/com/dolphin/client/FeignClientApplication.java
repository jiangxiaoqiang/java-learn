package com.dolphin.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {

},scanBasePackages = {
        "com.dolphin.server.api"
})
public class FeignClientApplication {
    public static void main(String[] args) {
        try {
            SpringApplication.run(FeignClientApplication.class, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}