package com.s13nocoutry.LearnConnect.models.profile;

import com.s13nocoutry.LearnConnect.models.user.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class ProfileRequest {
    private Long id;
    private String fullName;
    private String description;
    private User user;
}
