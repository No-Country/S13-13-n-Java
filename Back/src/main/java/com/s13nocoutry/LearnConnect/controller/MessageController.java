package com.s13nocoutry.LearnConnect.controller;

import com.s13nocoutry.LearnConnect.models.Message.Message;
import com.s13nocoutry.LearnConnect.models.user.UserResponse;
import com.s13nocoutry.LearnConnect.service.abstraction.MessageService;
import com.s13nocoutry.LearnConnect.service.abstraction.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {
   @Autowired
   private MessageService messageService;
   private UserService userService;

   @PostMapping("/send")
    public ResponseEntity<Message> sendMessage(@RequestParam String content, @RequestParam Long userId ){
       UserResponse userResponse = userService.getById(userId);
       Message savedMessage = messageService.sendMessage(content, userResponse);
       return ResponseEntity.ok(savedMessage);
   }

   @GetMapping("/all")
    public ResponseEntity<List<Message>> getAllMessages(){
       List<Message> allMessages = messageService.getAllMessages();
       return ResponseEntity.ok(allMessages);
   }

   @PostMapping("/save")
    public ResponseEntity<Void> saveMessage(@RequestBody Message message){
       messageService.saveMessage(message);
       return ResponseEntity.ok().build();
   }
}
