package com.s13nocoutry.LearnConnect.controller;

import com.s13nocoutry.LearnConnect.models.profilePicture.ProfilePictureResponse;
import com.s13nocoutry.LearnConnect.service.abstraction.ProfilePictureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/profile-photo")
public class ProfilePictureController {
    private final ProfilePictureService profilePictureService;

    @GetMapping("/{id}")
    public ResponseEntity<ProfilePictureResponse> getProfilePictureById(@PathVariable Long id) {
        return new ResponseEntity<>(profilePictureService.getById(id), HttpStatus.OK);
    }

    @PostMapping("/upload")
    public ResponseEntity<ProfilePictureResponse> uploadProfilePicture(@RequestParam("photo") MultipartFile multipartFile) throws IOException {
        return new ResponseEntity<>(profilePictureService.create(multipartFile), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfilePictureResponse> updateProfilePicture(@PathVariable Long id, @RequestParam("photo") MultipartFile multipartFile) throws IOException {
        return new ResponseEntity<>(profilePictureService.update(id, multipartFile), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProfilePictureResponse> deleteProfilePicture(@PathVariable Long id) throws IOException {
        return new ResponseEntity<>(profilePictureService.delete(id), HttpStatus.OK);
    }
}
