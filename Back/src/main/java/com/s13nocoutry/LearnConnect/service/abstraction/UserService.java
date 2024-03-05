package com.s13nocoutry.LearnConnect.service.abstraction;

import com.s13nocoutry.LearnConnect.models.user.User;
import com.s13nocoutry.LearnConnect.models.user.UserRequest;
import com.s13nocoutry.LearnConnect.models.user.UserResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface UserService {

    UserResponse getById(Long id);
    List<UserResponse> getAllUsers();
    UserResponse create(UserRequest userRequest, MultipartFile multipartFile) throws IOException;
    UserResponse update(UserRequest userRequest, MultipartFile multipartFile)throws IOException;
    void deleteById(Long id) throws IOException;
}
