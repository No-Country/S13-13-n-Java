package com.s13nocoutry.LearnConnect.service.abstraction;

import com.s13nocoutry.LearnConnect.models.Message.Message;

import java.util.List;

public interface MessageService {
    Message sendMessage(String content, User user);

    List<Message> getAllMessages();
}
