package com.s13nocoutry.LearnConnect.controller;

import com.s13nocoutry.LearnConnect.models.user.UserRequest;
import com.s13nocoutry.LearnConnect.models.user.UserResponse;
import com.s13nocoutry.LearnConnect.service.abstraction.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<UserResponse> create(@RequestPart(value = "user") UserRequest user, @RequestPart(value = "photo") MultipartFile multipartFile) throws IOException {
        return new ResponseEntity<>(userService.create(user, multipartFile), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<UserResponse> update(@RequestPart(value = "user") UserRequest user, @RequestPart(value = "photo") MultipartFile multipartFile) throws IOException {
        return new ResponseEntity<>(userService.update(user, multipartFile), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws IOException {
        userService.deleteById(id);
    }
}
