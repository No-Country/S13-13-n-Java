package com.s13nocoutry.LearnConnect.models.user;

import com.s13nocoutry.LearnConnect.models.contactList.ContactList;
import com.s13nocoutry.LearnConnect.models.room.Room;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String state;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private ContactList contactList;
    @ManyToMany(mappedBy = "users")
    private List<Room> rooms;
}
