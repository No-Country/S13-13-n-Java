package com.s13nocoutry.LearnConnect.models.contactList;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ContactListResponse {
    private Long id;
    private Long userId;
    // private Set<User> contacts;

    public ContactListResponse(ContactList contactList) {
        this(contactList.getId(), contactList.getUserId());
        // this(
        // contactList.getId(),
        // contactList.getUserId(),
        // contactList.contacts.isEmpty() ? null : contactList.contacts.stream().get()
        // );
    }
}
