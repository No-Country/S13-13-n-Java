package com.s13nocoutry.LearnConnect.models.contactList;

import com.s13nocoutry.LearnConnect.models.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "contact-list")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ContactList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
    private User user;

    @ManyToMany
    //private Set<User> users = new HashSet<>();
    private List<User> userList = new ArrayList<>();
}
