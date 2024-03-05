package com.s13nocoutry.LearnConnect.repository;

import com.s13nocoutry.LearnConnect.models.Chat.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {
}
