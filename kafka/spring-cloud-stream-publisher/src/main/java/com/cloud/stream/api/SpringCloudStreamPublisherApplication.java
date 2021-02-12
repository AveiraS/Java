package com.cloud.stream.api;

import com.cloud.stream.api.publisher.OutputProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;


@SpringBootApplication
@EnableBinding(OutputProcessor.class)
public class SpringCloudStreamPublisherApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudStreamPublisherApplication.class, args);
    }

}
