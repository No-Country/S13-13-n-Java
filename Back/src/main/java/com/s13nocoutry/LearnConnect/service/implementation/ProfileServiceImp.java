package com.s13nocoutry.LearnConnect.service.implementation;

import com.s13nocoutry.LearnConnect.models.profile.Profile;
import com.s13nocoutry.LearnConnect.models.profile.ProfileRequest;
import com.s13nocoutry.LearnConnect.models.profile.ProfileResponse;
import com.s13nocoutry.LearnConnect.repository.ProfileRepository;
import com.s13nocoutry.LearnConnect.service.abstraction.ProfileService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileServiceImp implements ProfileService {

    private final ProfileRepository profileRepository;
    private final ModelMapper modelMapper;
    @Override
    public ProfileResponse getById(Long id) {
        Profile profile = profileRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("El perfil de usuario con id: " + id + " no existe en base de datos"));
        return modelMapper.map(profile, ProfileResponse.class);
    }

    @Override
    public List<ProfileResponse> getAllProfiles() {
        return profileRepository.findAll().stream().map((element) -> modelMapper.map(element, ProfileResponse.class)).toList();
    }

    @Override
    public ProfileResponse create(ProfileRequest profileRequest) {
        Profile profile = profileRepository.save(modelMapper.map(profileRequest, Profile.class));
        return modelMapper.map(profile, ProfileResponse.class);
    }

    @Override
    public ProfileResponse update(ProfileRequest profileRequest) {
        if (!profileRepository.existsById(profileRequest.getId())) {
            throw new EntityNotFoundException("El perfil de usuario con id: " + profileRequest.getId() + " no existe en base de datos");
        }
        Profile profile = profileRepository.save(modelMapper.map(profileRequest, Profile.class));
        return modelMapper.map(profile, ProfileResponse.class);
    }

    @Override
    public void deleteById(Long id) {
        if (!profileRepository.existsById(id)) {
            throw new EntityNotFoundException("El perfil de usuario con id: " + id + " no existe en base de datos");
        }
        profileRepository.deleteById(id);
    }
}
