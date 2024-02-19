package com.s13nocoutry.LearnConnect.service.implementation;

import com.s13nocoutry.LearnConnect.models.Message.Message;
import com.s13nocoutry.LearnConnect.repository.MessageRepository;
import com.s13nocoutry.LearnConnect.service.abstraction.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImp implements MessageService {

    private final MessageRepository messageRepository;

@Override
    public Message sendMessage(String content, User user) {
        Message message = new Message();
        message.setContent(content);
        message.setUser(user);
        message.setHour(new Date());
        return messageRepository.save(message);
    }

    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }


}
