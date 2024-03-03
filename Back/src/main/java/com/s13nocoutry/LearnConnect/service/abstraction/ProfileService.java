package com.s13nocoutry.LearnConnect.service.abstraction;

import com.s13nocoutry.LearnConnect.models.profile.Profile;
import com.s13nocoutry.LearnConnect.models.profile.ProfileRequest;
import com.s13nocoutry.LearnConnect.models.profile.ProfileResponse;

import java.util.List;


public interface ProfileService {
    ProfileResponse getById(Long id);
    List<ProfileResponse> getAllProfiles();
    ProfileResponse create(ProfileRequest profile);
    ProfileResponse update(ProfileRequest profile);
    void deleteById(Long id);
}
