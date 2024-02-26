package com.s13nocoutry.LearnConnect.service.implementation;

import com.s13nocoutry.LearnConnect.models.Message.Message;
import com.s13nocoutry.LearnConnect.models.user.User;
import com.s13nocoutry.LearnConnect.models.user.UserResponse;
import com.s13nocoutry.LearnConnect.repository.MessageRepository;
import com.s13nocoutry.LearnConnect.service.abstraction.MessageService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImp implements MessageService {

    private ModelMapper modelMapper;
    private static final MessageRepository messageRepository = null;

    @Override
    public Message sendMessage(String content, UserResponse user) {
        Message message = new Message();
        message.setContent(content);
        message.setUser(modelMapper.map(user, User.class));
        message.setHour(new Date());
        return messageRepository.save(message);
    }

    @Override
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }


    @Autowired
    public void saveMessage(Message message) {
        messageRepository.save(message);
    }
}





