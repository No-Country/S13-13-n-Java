package com.s13nocoutry.LearnConnect.models.profile;

import com.s13nocoutry.LearnConnect.models.user.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class ProfileResponse {
    private Long id;
    private String fullName;
    private String description;
    private User user;
}
