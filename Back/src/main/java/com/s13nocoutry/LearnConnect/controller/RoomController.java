package com.s13nocoutry.LearnConnect.controller;

import com.s13nocoutry.LearnConnect.models.room.Room;
import com.s13nocoutry.LearnConnect.service.abstraction.IRoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.HtmlUtils;
@RestController
@RequestMapping("/room")
@RequiredArgsConstructor
public class RoomController {
    private final IRoomService roomService;

    @GetMapping("/{roomId}")
    public ResponseEntity<?> obtenerRoomPorId(@PathVariable Long roomId){
        return new ResponseEntity<>(roomService.getById(roomId), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> crearRoom(){
        Room room = new Room();
        return new ResponseEntity<>(roomService.create(room),HttpStatus.CREATED);
    }
    /*@PutMapping
    public ResponseEntity<?> actualizarRoom(@RequestBody Room room){

    }*/
}
