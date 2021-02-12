package com.javatechie.spring.cloud.stream.api;

import com.javatechie.spring.cloud.stream.api.consumer.InputProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableBinding(InputProcessor.class)
public class SpringCloudStreamConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudStreamConsumerApplication.class, args);
    }

}
