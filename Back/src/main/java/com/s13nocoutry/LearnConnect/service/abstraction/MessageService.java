package com.s13nocoutry.LearnConnect.service.abstraction;

import com.s13nocoutry.LearnConnect.models.Message.Message;
import com.s13nocoutry.LearnConnect.models.user.UserResponse;

import java.util.List;

public interface MessageService {
    Message sendMessage(String content, UserResponse user);

    List<Message> getAllMessages();


    void saveMessage(Message message);
}
