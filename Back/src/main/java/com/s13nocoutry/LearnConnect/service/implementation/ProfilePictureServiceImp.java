package com.s13nocoutry.LearnConnect.service.implementation;

import com.s13nocoutry.LearnConnect.models.profilePicture.ProfilePicture;
import com.s13nocoutry.LearnConnect.models.profilePicture.ProfilePictureRequest;
import com.s13nocoutry.LearnConnect.models.profilePicture.ProfilePictureResponse;
import com.s13nocoutry.LearnConnect.repository.ProfilePictureRepository;
import com.s13nocoutry.LearnConnect.service.abstraction.ProfilePictureService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfilePictureServiceImp implements ProfilePictureService {
    private final ProfilePictureRepository profilePictureRepository;
    private final CloudinaryService cloudinaryService;
    private final ModelMapper modelMapper;

    @Override
    public ProfilePictureResponse getById(Long id) {
        ProfilePicture profilePicture = profilePictureRepository.findById(id).orElse(null);
        return (profilePicture != null) ? modelMapper.map(profilePicture, ProfilePictureResponse.class) : null;
    }

    @Override
    public ProfilePictureResponse create(MultipartFile multipartFile) throws IOException {
        Map value = cloudinaryService.upPhoto(multipartFile);
        ProfilePictureResponse profilePictureResponse = ProfilePictureResponse
                .builder()
                .publicId(value.get("public_id").toString())
                .name(value.get("original_filename").toString())
                .url(value.get("url").toString())
                .build();
        ProfilePicture profilePicture = ProfilePicture
                .builder()
                .publicId(value.get("public_id").toString())
                .name(value.get("original_filename").toString())
                .url(value.get("url").toString())
                .build();
        profilePictureRepository.save(profilePicture);
        return profilePictureResponse;
    }

    @Override
    public ProfilePictureResponse update(Long id, MultipartFile multipartFile) throws IOException {
        ProfilePicture profilePicture = new ProfilePicture();
        Optional<ProfilePicture> response = profilePictureRepository.findById(id);
        if (response.isPresent()) {
            profilePicture = response.get();
            cloudinaryService.deletePhoto(profilePicture.getPublicId());
            Map newProfilePictureCloudinary = cloudinaryService.upPhoto(multipartFile);
            profilePicture.setPublicId(newProfilePictureCloudinary.get("public_id").toString());
            profilePicture.setName(newProfilePictureCloudinary.get("original_filename").toString());
            profilePicture.setUrl(newProfilePictureCloudinary.get("url").toString());
            profilePictureRepository.save(profilePicture);
            return modelMapper.map(profilePicture, ProfilePictureResponse.class);
        }
        return null;
    }

    @Override
    public ProfilePictureResponse delete(ProfilePictureRequest profilePictureRequest) throws IOException {
        String publicId = profilePictureRequest.getPublicId();
        Map value = cloudinaryService.deletePhoto(publicId);
        ProfilePictureResponse profilePictureResponse = ProfilePictureResponse
                .builder()
                .publicId(value.get("public_id").toString())
                .name(value.get("original_filename").toString())
                .url(value.get("url").toString())
                .build();
        profilePictureRepository.delete(modelMapper.map(profilePictureRequest, ProfilePicture.class));
        return profilePictureResponse;
    }

    @Override
    public boolean existsById(Long id) {
        return profilePictureRepository.existsById(id);
    }
}
