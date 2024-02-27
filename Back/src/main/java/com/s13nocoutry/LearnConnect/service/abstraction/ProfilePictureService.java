package com.s13nocoutry.LearnConnect.service.abstraction;

import com.s13nocoutry.LearnConnect.models.photo.PhotoRequest;
import com.s13nocoutry.LearnConnect.models.profilePicture.ProfilePictureRequest;
import com.s13nocoutry.LearnConnect.models.profilePicture.ProfilePictureResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ProfilePictureService {
    ProfilePictureResponse getById(Long id);
    ProfilePictureResponse create(MultipartFile multipartFile) throws IOException;
    ProfilePictureResponse update(Long id, MultipartFile multipartFile) throws IOException;
    ProfilePictureResponse delete(Long id) throws IOException;
    boolean existsById(Long id);
}
