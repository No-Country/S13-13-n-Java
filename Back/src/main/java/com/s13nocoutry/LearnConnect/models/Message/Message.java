package com.s13nocoutry.LearnConnect.models.Message;

import com.s13nocoutry.LearnConnect.models.Chat.Chat;
import com.s13nocoutry.LearnConnect.models.user.User;
import jakarta.persistence.*;
import lombok.*;

import javax.print.attribute.standard.MediaSize;
import java.util.Date;

@Entity
@Table(name = "message")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 // aqui no falta el id de la entidad?
 private String content;
@ManyToOne
@JoinColumn(name = "id")
 private User user;
 private Date hour;
@ManyToOne
@JoinColumn(name = "id")
private Chat chat;

}
