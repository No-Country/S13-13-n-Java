package com.s13nocoutry.LearnConnect.models.room;

import com.s13nocoutry.LearnConnect.models.Chat.Chat;
import com.s13nocoutry.LearnConnect.models.user.User;
import jakarta.persistence.Entity;
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
public class RoomResponse {
    // ToDO: revisar el formato del dto
    private Long id;
    private Chat chat;
    private List<User> users;
    private Boolean block;
    private Boolean silent;
}
