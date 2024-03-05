package com.s13nocoutry.LearnConnect.models.photo;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class PhotoResponse {
    private Long id;
    private String publicId;
    private String name;
    private String url;

    public PhotoResponse(Photo photo) {
        this(photo.getId(), photo.getPublicId(), photo.getName(), photo.getUrl());
    }
}
