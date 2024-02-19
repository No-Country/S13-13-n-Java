package com.s13nocoutry.LearnConnect.service.abstraction;

import com.s13nocoutry.LearnConnect.models.user.User;
import com.s13nocoutry.LearnConnect.models.user.UserRequest;
import com.s13nocoutry.LearnConnect.models.user.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse getById(Long id);
    List<UserResponse> getAllUsers();
    UserResponse create(UserRequest userRequest);
    UserResponse update(UserRequest userRequest);
    void deleteById(Long id);
}
