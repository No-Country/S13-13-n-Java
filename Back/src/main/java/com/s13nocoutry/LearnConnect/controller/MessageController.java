package com.s13nocoutry.LearnConnect.controller;

import com.s13nocoutry.LearnConnect.models.Message.Message;
import com.s13nocoutry.LearnConnect.service.abstraction.MessageService;
import com.s13nocoutry.LearnConnect.service.implementation.MessageServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MessageController {

    @MessageMapping("/message")
    @SendTo("/topic/message")


    public Message handleMessage(Message message) throws Exception {
        MessageServiceImp.saveMessage(message);

        return message;

    }
}