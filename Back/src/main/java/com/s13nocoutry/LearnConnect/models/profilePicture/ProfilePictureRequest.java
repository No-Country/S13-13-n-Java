package com.s13nocoutry.LearnConnect.models.profilePicture;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ProfilePictureRequest {
    private Long id;
    private String publicId;
    private String name;
    private String url;
}
