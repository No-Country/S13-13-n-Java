package com.s13nocoutry.LearnConnect.models.Chat;

import com.s13nocoutry.LearnConnect.models.photo.PhotoResponse;
import lombok.Data;

import java.util.List;

@Data
public class ChatResponse {
    private Long id;
    private List<PhotoResponse> photoResponseList;
    //private List<MessageResponse> messageResponseList;
}
