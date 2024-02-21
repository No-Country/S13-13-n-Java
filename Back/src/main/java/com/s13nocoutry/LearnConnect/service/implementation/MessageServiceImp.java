package com.s13nocoutry.LearnConnect.service.implementation;

import com.s13nocoutry.LearnConnect.models.Message.Message;
import com.s13nocoutry.LearnConnect.models.user.User;
import com.s13nocoutry.LearnConnect.repository.MessageRepository;
import com.s13nocoutry.LearnConnect.service.abstraction.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImp implements MessageService {

    private static final MessageRepository messageRepository = null;
    private final RoomService roomService;

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


    @Autowired

    public static void saveMessage(Message message) {
        // aca habria que analizar tmb el modo de guardado de los mensajes dentro de un chat? para donde va el cascade de persistencia?
        messageRepository.save(message);
    }
}





