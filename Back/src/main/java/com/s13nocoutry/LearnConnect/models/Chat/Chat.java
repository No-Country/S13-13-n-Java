package com.s13nocoutry.LearnConnect.models.Chat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.s13nocoutry.LearnConnect.models.Message.Message;
import com.s13nocoutry.LearnConnect.models.photo.Photo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "chat")
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "chat", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("chat")
    private List<Photo> photos;

    @OneToMany(mappedBy = "chat", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("chat")
    private List<Message> messages;
}
