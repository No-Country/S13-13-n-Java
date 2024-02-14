package com.s13nocoutry.LearnConnect.service.implementation;

import com.s13nocoutry.LearnConnect.repository.ContactListRepository;
import com.s13nocoutry.LearnConnect.service.abstraction.ContactListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactListServiceImp implements ContactListService {
    private final ContactListRepository contactListDao;
}
