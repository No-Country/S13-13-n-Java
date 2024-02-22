package com.s13nocoutry.LearnConnect.models.room;

import com.s13nocoutry.LearnConnect.models.Chat.ChatResponse;
import com.s13nocoutry.LearnConnect.models.user.UserResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class RoomRequest {
    // ToDO: revisar el formato del dto
    private Long id;
    private ChatResponse chat;
    private List<UserResponse> users;
    private Boolean block;
    private Boolean silent;
}
