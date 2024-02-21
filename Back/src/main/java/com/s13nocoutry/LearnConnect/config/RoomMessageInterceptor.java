package com.s13nocoutry.LearnConnect.config;

import com.s13nocoutry.LearnConnect.models.room.Room;
import com.s13nocoutry.LearnConnect.service.implementation.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.support.ChannelInterceptor;

public class RoomMessageInterceptor implements ChannelInterceptor {
    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Autowired
    private RoomService roomService;

    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        String destination = (String) message.getHeaders().get(SimpMessageHeaderAccessor.DESTINATION_HEADER);

        if (destination != null && destination.startsWith("/room/")) {
            Long roomId = extractRoomId(destination);

            Room room = roomService.getById(roomId);

            if (room != null) {
                // crea un destino dinamico usando el id del room ("/topic/room/{id}").
                String dynamicDestination = "/topic/room/" + room.getId();

                SimpMessageHeaderAccessor accessor = SimpMessageHeaderAccessor.wrap(message);
                accessor.setDestination(dynamicDestination);
            }
        }

        return message;
    }

    private Long extractRoomId(String destination){
        // Asegúrate de que la URL sea "/room/{roomId}"
        String[] parts = destination.split("/");

        if (parts.length == 3 && "room".equals(parts[1])) {
            try {
                return Long.parseLong(parts[2]);
            } catch (NumberFormatException e) {
                // Manejar la excepción si el roomId no es un número válido
                // Puedes lanzar una excepción personalizada o simplemente retornar null, dependiendo de tus necesidades.
                return null;
            }
        }

        // Si la URL no coincide con el formato esperado, puedes lanzar una excepción o manejarla según tus necesidades.
        // En este ejemplo, simplemente retornamos null.
        return null;
    }
}
