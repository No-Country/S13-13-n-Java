package com.s13nocoutry.LearnConnect.repository;

import com.s13nocoutry.LearnConnect.models.Message.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

}
