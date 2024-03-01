package com.s13nocoutry.LearnConnect.repository;

import com.s13nocoutry.LearnConnect.models.contactList.ContactList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactListRepository extends JpaRepository<ContactList, Long>{
    ContactList findByUser_Id(Long id);

    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM `learnconnect`.`contact-list_user_list` WHERE (`contact_list_id` =:contactListId)")
    void deleteContactListUser(@Param("contactListId") Long contactListId);

    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM `learnconnect`.`contact-list_user_list` WHERE (`user_list_id` =:userId)")
    void deleteUserListContactList(@Param("userId") Long userId);

}
