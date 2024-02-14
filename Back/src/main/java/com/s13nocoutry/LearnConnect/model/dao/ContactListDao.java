package com.s13nocoutry.LearnConnect.model.dao;

import com.s13nocoutry.LearnConnect.model.entity.ContactList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactListDao extends JpaRepository<ContactList, Long>{
}
