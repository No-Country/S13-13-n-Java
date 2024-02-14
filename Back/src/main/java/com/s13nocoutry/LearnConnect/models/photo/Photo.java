package com.s13nocoutry.LearnConnect.models.photo;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "photo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "publicId")
    private String publicId;

    @Column(name = "name")
    private String name;

    @Column(name = "url")
    private String url;
}
