package com.s13nocoutry.LearnConnect.service.abstraction;

import com.s13nocoutry.LearnConnect.models.Chat.ChatRequest;
import com.s13nocoutry.LearnConnect.models.Chat.ChatResponse;

import java.util.List;

public interface ChatService {
    ChatResponse getChatById(Long chatId);
    List<ChatResponse> getAllChats();
    ChatResponse createChat(ChatRequest chatRequest);
    ChatResponse updateChat(ChatRequest chatRequest);
    void deleteChatById(Long chatId);
}
