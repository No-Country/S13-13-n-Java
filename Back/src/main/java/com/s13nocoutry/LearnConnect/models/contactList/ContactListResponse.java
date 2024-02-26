package com.s13nocoutry.LearnConnect.models.contactList;

import com.s13nocoutry.LearnConnect.models.user.User;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class ContactListResponse {
    private Long id;
    private Long userId;
    private Set<User> contacts;


}
