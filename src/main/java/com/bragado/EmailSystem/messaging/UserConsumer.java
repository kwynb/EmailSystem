package com.bragado.EmailSystem.messaging;


import com.bragado.EmailSystem.repositories.UserRepository;
import com.bragado.EmailSystem.services.UserServiceImpl;
import com.bragado.userregistration.entities.UserEvent;
import lombok.extern.slf4j.Slf4j;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class UserConsumer {
    private static final String TOPIC = "userdata-topic";

    private final UserRepository userRepository;
    private final UserServiceImpl userService;
    public UserConsumer(UserRepository userRepository, UserServiceImpl userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }



    @KafkaListener(topics = TOPIC, groupId = "user-group")
    public void receiveUser(UserEvent userEvent) {
        if (userEvent.getEvent().equals("new")) {
            userService.createNewUser(userEvent.getUserDTO());
        }
        if (userEvent.getEvent().equals("update")) {
            userService.updateUser(userEvent.getUserDTO());
        }
        if (userEvent.getEvent().equals("delete")) {
            userService.deleteUser(userEvent.getUserDTO());
        }
        if (userEvent.getEvent().equals("get")) {
            userService.getUser(userEvent.getUserDTO());
        }
//        System.out.println(userEvent.getEvent());

    }

}
