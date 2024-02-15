package com.s13nocoutry.LearnConnect.service.implementation;

import com.s13nocoutry.LearnConnect.models.profile.Profile;
import com.s13nocoutry.LearnConnect.repository.ProfileRepository;
import com.s13nocoutry.LearnConnect.service.abstraction.ProfileService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileServiceImp implements ProfileService {

    private final ProfileRepository profileRepository;
    @Override
    public Profile getById(Long id) {
        return profileRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("El perfil de usuario con id: " + id + " no existe en base de datos"));
    }

    @Override
    public List<Profile> getAllProfiles() {
        return profileRepository.findAll();
    }

    @Override
    public Profile create(Profile profile) {
        return profileRepository.save(profile);
    }

    @Override
    public Profile update(Profile profile) {
        if (!profileRepository.existsById(profile.getId())) {
            throw new EntityNotFoundException("El perfil de usuario con id: " + profile.getId() + " no existe en base de datos");
        }
        return profileRepository.save(profile);
    }

    @Override
    public void deleteById(Long id) {
        if (!profileRepository.existsById(id)) {
            throw new EntityNotFoundException("El perfil de usuario con id: " + id + " no existe en base de datos");
        }
        profileRepository.deleteById(id);
    }
}
