package com.javatechie.spring.cloud.stream.api.consumer;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface InputProcessor {
    String INPUT = "input";

    /**
     * Чтение из Кафки
     */

     @Input(INPUT)
    SubscribableChannel input();
}
