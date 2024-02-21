package com.s13nocoutry.LearnConnect.controller;

import com.s13nocoutry.LearnConnect.models.room.Room;
import com.s13nocoutry.LearnConnect.models.user.User;
import com.s13nocoutry.LearnConnect.service.abstraction.IRoomService;
import com.s13nocoutry.LearnConnect.service.implementation.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class RoomController {

    private final UserServiceImp userService;
    private final IRoomService roomService;

    @MessageMapping("/room/{roomId}/addUser")
    @SendTo("/topic/room/{roomId}")
    public Room addUser(
            @Payload User user,
            @DestinationVariable Long roomId
    ) {
        var room = roomService.getById(roomId);
        if (room != null) {
            userService.connectUser(user);
            var usuariosEnElRoom = room.getUsers();
            usuariosEnElRoom.add(user);
            room.setUsers(usuariosEnElRoom);
            roomService.update(room);
        }

        return room;
    }

    @MessageMapping("/room/{roomId}/disconnectUser")
    @SendTo("/topic/room/{roomId}")
    public Room disconnect(
            @Payload User user,
            @DestinationVariable Long roomId
    ) {
        var room = roomService.getById(roomId);
        if (room != null) {
            userService.disconnect(user);
            var usuariosEnElRoom = room.getUsers();
            usuariosEnElRoom.remove(user);
            room.setUsers(usuariosEnElRoom);
            roomService.update(room);
        }
        return room;
    }

    @GetMapping("room/{roomId}/users")
    public ResponseEntity<Set<User>> findConnectedUsers(@PathVariable Long roomId) {

        var roomEnBaseDeDatos = roomService.getById(roomId); // TODO: crear exception para cuando la Room no existe.

        if (roomEnBaseDeDatos != null) {
            Set<User> listaUsuariosConectados = roomEnBaseDeDatos.getUsers()
                    .stream()
                    .filter(user -> "ONLINE".equals(user.getStatus()))
                    .collect(Collectors.toSet());

            return ResponseEntity.ok(listaUsuariosConectados);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


