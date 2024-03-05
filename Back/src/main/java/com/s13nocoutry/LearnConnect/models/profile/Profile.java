package com.s13nocoutry.LearnConnect.models.profile;

import com.s13nocoutry.LearnConnect.models.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    private String description;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
