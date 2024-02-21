package com.s13nocoutry.LearnConnect.controller;

import com.s13nocoutry.LearnConnect.models.Chat.ChatRequest;
import com.s13nocoutry.LearnConnect.models.Chat.ChatResponse;
import com.s13nocoutry.LearnConnect.service.implementation.ChatServiceImpl;
import lombok.RequiredArgsConstructor;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MessageController {

    private final ChatServiceImpl chatServiceImpl;
    
    @MessageMapping("/message")
    @SendTo("/topic/message")
    public ChatResponse handleMessage(@DestinationVariable Long roomId, ChatRequest chat) throws Exception {
        ChatResponse chatResponse = chatServiceImpl.createChat(chat);
        return chatResponse;
    }
}