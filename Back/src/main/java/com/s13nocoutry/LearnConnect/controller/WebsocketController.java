package com.s13nocoutry.LearnConnect.controller;

import com.s13nocoutry.LearnConnect.models.Message.MessageResponse;
import com.s13nocoutry.LearnConnect.models.exampleModel.MessageExample;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class WebsocketController {

    private final SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    public MessageExample receiveMessage(@Payload MessageExample message){
        return message;
    }

    @MessageMapping("/private-message")
    public MessageExample recMessage(@Payload MessageExample message){
        simpMessagingTemplate.convertAndSendToUser(message.getReceiverName(),"/private",message);
        System.out.println(message.toString());
        return message;
    }

    @MessageMapping("/group-message/{roomId}")
    public void groupMessage(@DestinationVariable Long roomId, @Payload MessageExample message) {
        // Lógica para enviar el mensaje al grupo específico
        simpMessagingTemplate.convertAndSend("/group/" + roomId, message);
    }
}
