package com.s13nocoutry.LearnConnect.service.implementation;

import com.s13nocoutry.LearnConnect.models.Chat.Chat;
import com.s13nocoutry.LearnConnect.models.Chat.ChatRequest;
import com.s13nocoutry.LearnConnect.models.Chat.ChatResponse;
import com.s13nocoutry.LearnConnect.repository.ChatRepository;
import com.s13nocoutry.LearnConnect.service.abstraction.ChatService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {
    
    private final ChatRepository chatRepository;
    
    private final ModelMapper modelMapper;
    
    private final MessageServiceImp messageServiceImp;

    @Override
    public ChatResponse getChatById(Long chatId) {
        Chat chat = chatRepository.findById(chatId).orElseThrow(() -> new EntityNotFoundException("Chat No existe"));
        return modelMapper.map(chat, ChatResponse.class);
    }

    @Override
    public List<ChatResponse> getAllChats() {
        List<Chat> users = chatRepository.findAll();
        return users.stream()
                .map(chat -> modelMapper.map(chat, ChatResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public ChatResponse createChat(ChatRequest chatRequest) {
        
        Chat chat = chatRepository.save(modelMapper.map(chatRequest, Chat.class));
        return modelMapper.map(chat, ChatResponse.class);
    }

    @Override
    public ChatResponse updateChat(ChatRequest chatRequest) {
        if( !chatRepository.existsById(chatRequest.getId())){
            throw new EntityNotFoundException("Chat No encontrado");
        }
        Chat chat = chatRepository.save(modelMapper.map(chatRequest, Chat.class));
        return modelMapper.map(chat, ChatResponse.class);
    }

    @Override
    public void deleteChatById(Long chatId) {
        if( !chatRepository.existsById(chatId)){ throw new EntityNotFoundException("Chat No encontrado");}
        chatRepository.deleteById(chatId);
    }
}
