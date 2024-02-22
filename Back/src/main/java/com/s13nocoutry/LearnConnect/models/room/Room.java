package com.s13nocoutry.LearnConnect.models.room;

import com.s13nocoutry.LearnConnect.models.Chat.Chat;
import com.s13nocoutry.LearnConnect.models.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "id")
    private Chat chat;
//    @OneToMany
//    private List<User> users;
    private Boolean block;
    private Boolean silent;
}
