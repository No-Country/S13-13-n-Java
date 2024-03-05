package com.s13nocoutry.LearnConnect.controller;

import com.s13nocoutry.LearnConnect.models.contactList.ContactList;
import com.s13nocoutry.LearnConnect.models.contactList.ContactListResponse;
import com.s13nocoutry.LearnConnect.models.user.User;
import com.s13nocoutry.LearnConnect.repository.ContactListRepository;
import com.s13nocoutry.LearnConnect.repository.UserRepository;
import com.s13nocoutry.LearnConnect.service.abstraction.ContactListService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contactos")
public class ContactListController {
    private final ContactListService contactListService;
    @GetMapping("/{userId}/{contactoId}")
    public ResponseEntity<ContactListResponse> agregarContacto(@PathVariable Long userId, @PathVariable Long contactoId){
        ContactListResponse contactList = contactListService.addContact(userId, contactoId);
        return new ResponseEntity<>(contactList, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ContactList> obtenerContactListPorUserId(@PathVariable Long userId){

        return new ResponseEntity<>(contactListService.getByUserId(userId), HttpStatus.OK);
    }
}
