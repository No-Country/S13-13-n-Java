package com.s13nocoutry.LearnConnect.controller;

import com.s13nocoutry.LearnConnect.models.profile.ProfileRequest;
import com.s13nocoutry.LearnConnect.models.profile.ProfileResponse;
import com.s13nocoutry.LearnConnect.models.user.UserRequest;
import com.s13nocoutry.LearnConnect.models.user.UserResponse;
import com.s13nocoutry.LearnConnect.service.abstraction.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/profiles")
public class ProfileController {

    private final ProfileService profileService;
    @GetMapping("/{id}")
    public ResponseEntity<ProfileResponse> getById(@PathVariable Long id) {
        return new ResponseEntity<>(profileService.getById(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<ProfileResponse>> getAllProfiles() {
        return new ResponseEntity<>(profileService.getAllProfiles(), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<ProfileResponse> create(@RequestBody ProfileRequest profileRequest) {
        return new ResponseEntity<>(profileService.create(profileRequest), HttpStatus.CREATED);
    }

    @PutMapping()
    public ResponseEntity<ProfileResponse> update(@RequestBody ProfileRequest profileRequest) {
        return new ResponseEntity<>(profileService.update(profileRequest), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        profileService.deleteById(id);
    }
}
