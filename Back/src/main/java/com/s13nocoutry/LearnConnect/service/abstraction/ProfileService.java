package com.s13nocoutry.LearnConnect.service.abstraction;

import com.s13nocoutry.LearnConnect.models.profile.Profile;

import java.util.List;


public interface ProfileService {
    Profile getById(Long id);
    List<Profile> getAllProfiles();
    Profile create(Profile profile);
    Profile update(Profile profile);
    void deleteById(Long id);
}
