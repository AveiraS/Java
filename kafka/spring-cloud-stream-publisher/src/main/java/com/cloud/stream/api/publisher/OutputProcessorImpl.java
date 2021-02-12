package com.cloud.stream.api.publisher;

import com.cloud.stream.api.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Component
@RestController
@AllArgsConstructor
public class OutputProcessorImpl {
    private OutputProcessor processor;

    @PostMapping("/user")
    public User eventSend(@RequestBody User user) {
        processor.output().send(MessageBuilder.withPayload(user).build());
        return user;
    }
}
