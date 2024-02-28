package com.s13nocoutry.LearnConnect.service.abstraction;

import com.s13nocoutry.LearnConnect.models.contactList.ContactList;
import com.s13nocoutry.LearnConnect.models.contactList.ContactListRequest;
import com.s13nocoutry.LearnConnect.models.contactList.ContactListResponse;

import java.util.List;

public interface ContactListService {
    ContactListResponse getById(Long id);
    ContactList getByUserId(Long id);
    List<ContactListResponse> getAllContactList();
    ContactListResponse create(ContactListRequest contactListRequest);
    ContactListResponse update(Long id, ContactListRequest contactListRequest);
    void delete(Long id);
    boolean existsById(Long id);

}
