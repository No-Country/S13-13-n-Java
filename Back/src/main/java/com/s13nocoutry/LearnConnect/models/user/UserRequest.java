package com.s13nocoutry.LearnConnect.models.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserRequest {
    private Long id;
    private String email;
    private String password;
    private String state;
}
