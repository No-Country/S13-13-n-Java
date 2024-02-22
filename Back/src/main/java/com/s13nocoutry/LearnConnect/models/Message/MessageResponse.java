package com.s13nocoutry.LearnConnect.models.Message;

import com.s13nocoutry.LearnConnect.models.Chat.Chat;
import com.s13nocoutry.LearnConnect.models.user.User;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class MessageResponse {

    private String content;
    private User user;
    private Date hour;
    private Chat chat;
}
