package com.s13nocoutry.LearnConnect.service.impl;

import com.s13nocoutry.LearnConnect.model.dao.ContactListDao;
import com.s13nocoutry.LearnConnect.service.ContactListService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactListImplService implements ContactListService {
    private final ContactListDao contactListDao;
}
