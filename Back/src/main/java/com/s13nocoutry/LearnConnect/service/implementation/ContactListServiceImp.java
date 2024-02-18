package com.s13nocoutry.LearnConnect.service.implementation;

import com.s13nocoutry.LearnConnect.models.contactList.ContactList;
import com.s13nocoutry.LearnConnect.models.contactList.ContactListRequest;
import com.s13nocoutry.LearnConnect.models.contactList.ContactListResponse;
import com.s13nocoutry.LearnConnect.repository.ContactListRepository;
import com.s13nocoutry.LearnConnect.service.abstraction.ContactListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactListServiceImp implements ContactListService {
    private final ContactListRepository contactListRepository;

    @Override
    public ContactListResponse getById(Long id) {
        ContactList contactList = contactListRepository.findById(id).orElse(null);
        return (contactList != null) ? new ContactListResponse(contactList) : null;
    }

    @Override
    public List<ContactListResponse> getAllContactList() {
        List<ContactList> contactLists = contactListRepository.findAll();
        List<ContactListResponse> contactListResponseList = contactLists.stream().map(
                contactList -> ContactListResponse
                        .builder()
                        .id(contactList.getId())
                        .userId(contactList.getUserId())
                        //.contacts(contactList.getContactList())
                        .build()
        ).toList();
        return contactListResponseList;
    }

    @Override
    public ContactListResponse create(ContactListRequest contactListRequest) {
        ContactList contactList = ContactList
                .builder()
                .id(contactListRequest.getId())
                .userId(contactListRequest.getUserId())
                //.contacts(contactListRequest.getContacts)
                .build();
        contactListRepository.save(contactList);
        return ContactListResponse
                .builder()
                .id(contactList.getId())
                .userId(contactList.getUserId())
                //.contacts(contactList.getContacts)
                .build();
    }

    @Override
    public ContactListResponse update(Long id, ContactListRequest contactListRequest) {
        return null;
    }

    @Override
    public ContactListResponse delete(ContactListRequest contactListRequest) {
        ContactList contactList = ContactList
                .builder()
                .id(contactListRequest.getId())
                .userId(contactListRequest.getUserId())
                //.contacts(contactListRequest.getContacts)
                .build();
        contactListRepository.delete(contactList);
        return ContactListResponse
                .builder()
                .id(contactListRequest.getId())
                .userId(contactListRequest.getUserId())
                //.contacts(contactListRequest.getContacts)
                .build();
    }

    @Override
    public boolean existsById(Long id) {
        return contactListRepository.existsById(id);
    }
}
