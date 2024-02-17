package com.s13nocoutry.LearnConnect.models.Message;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "message")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Message {
 private String content;
 private User user;
 private Date hour;
}
