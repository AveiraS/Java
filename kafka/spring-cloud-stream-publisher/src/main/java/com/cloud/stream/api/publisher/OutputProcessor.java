package com.cloud.stream.api.publisher;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OutputProcessor {

    String OUTPUT = "output";

    /*
     * Отправка в Кафку
     */

    @Output(OUTPUT)
    MessageChannel output();
}
