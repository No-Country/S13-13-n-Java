package com.s13nocoutry.LearnConnect.repository;

import com.s13nocoutry.LearnConnect.models.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByStatus(String status);
}
