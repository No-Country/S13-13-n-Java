package com.s13nocoutry.LearnConnect.models.profilePicture;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ProfilePictureResponse {
    private Long id;
    private String publicId;
    private String name;
    private String url;
}
