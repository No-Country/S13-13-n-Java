package com.s13nocoutry.LearnConnect.service.abstraction;

import com.s13nocoutry.LearnConnect.models.user.User;

import java.util.List;

public interface UserService {

    User getById(Long id);
    List<User> getAllUsers();
    User create(User user);
    User update(User user);
    void deleteById(Long id);
}
