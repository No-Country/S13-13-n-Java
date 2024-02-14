package com.s13nocoutry.LearnConnect.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "contact-list")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ContactList implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    //@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    //private Set<User> contacts = new HashSet<>();;
}
