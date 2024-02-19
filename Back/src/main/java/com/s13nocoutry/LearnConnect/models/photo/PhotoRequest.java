package com.s13nocoutry.LearnConnect.models.photo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PhotoRequest {
    private Long id;
    private String publicId;
    private String name;
    private String url;
}
