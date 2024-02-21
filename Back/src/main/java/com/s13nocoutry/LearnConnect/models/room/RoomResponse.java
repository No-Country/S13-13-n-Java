package com.s13nocoutry.LearnConnect.models.room;

import com.s13nocoutry.LearnConnect.models.Chat.Chat;
import com.s13nocoutry.LearnConnect.models.Chat.ChatResponse;
import com.s13nocoutry.LearnConnect.models.user.User;
import com.s13nocoutry.LearnConnect.models.user.UserResponse;
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
    private ChatResponse chatResponse;
    private List<UserResponse> userResponseList;
    private Boolean block;
    private Boolean silent;
}
