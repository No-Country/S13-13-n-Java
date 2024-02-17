package com.s13nocoutry.LearnConnect.models.contactList;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Entity
@Table(name = "contact-list")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ContactList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    //@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    //private Set<User> contacts = new HashSet<>();;
}