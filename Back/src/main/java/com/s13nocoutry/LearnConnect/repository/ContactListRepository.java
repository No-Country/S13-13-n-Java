package com.s13nocoutry.LearnConnect.repository;

import com.s13nocoutry.LearnConnect.models.contactList.ContactList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactListRepository extends JpaRepository<ContactList, Long>{
    ContactList findByUser_Id(Long id);
}
