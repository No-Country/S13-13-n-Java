package com.s13nocoutry.LearnConnect.models.profilePicture;

import com.s13nocoutry.LearnConnect.models.user.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProfilePicture {
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

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
