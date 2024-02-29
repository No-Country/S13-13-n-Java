package com.s13nocoutry.LearnConnect.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ExampleWebSocketController {

    @MessageMapping("7chat-socket")
    public String proccessChat(String mensaje) {
        return "esta es una prueba del endpoint chat-socket en la suscripcion topic, y este es el mensaje: " + mensaje;
    }


    // probar desde el front suscribirse a topic, y mandar un mensaje a /app/chat-socket
    // usar socketjs
}
