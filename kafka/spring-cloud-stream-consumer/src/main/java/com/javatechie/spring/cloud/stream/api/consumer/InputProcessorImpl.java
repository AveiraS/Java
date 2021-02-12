package com.javatechie.spring.cloud.stream.api.consumer;

import com.javatechie.spring.cloud.stream.api.SpringCloudStreamConsumerApplication;
import com.javatechie.spring.cloud.stream.api.User;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class InputProcessorImpl {

    Logger logger = LoggerFactory.getLogger(SpringCloudStreamConsumerApplication.class);

    @StreamListener(InputProcessor.INPUT)
    public void consumeMessage(User user) {
        logger.info("Consume load : " + user);
    }

}
