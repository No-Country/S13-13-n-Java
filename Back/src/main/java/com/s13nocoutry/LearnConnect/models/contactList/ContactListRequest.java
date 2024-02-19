package com.s13nocoutry.LearnConnect.models.contactList;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ContactListRequest {
    private Long id;
    private Long userId;
    // private Set<User> contacts;
}
