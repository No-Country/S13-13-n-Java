package com.s13nocoutry.LearnConnect.models.Message;

import com.s13nocoutry.LearnConnect.models.Chat.Chat;
import com.s13nocoutry.LearnConnect.models.user.User;
import jakarta.persistence.Id;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MessageRequest {
private String content;
private User user;
private Date hour;
private Chat chat;
}
