package com.s13nocoutry.LearnConnect.service.implementation;

import com.s13nocoutry.LearnConnect.repository.PhotoRepository;
import com.s13nocoutry.LearnConnect.models.photo.Photo;
import com.s13nocoutry.LearnConnect.service.abstraction.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PhotoServiceImp implements PhotoService {
    private final PhotoRepository photoRepository;
    private final CloudinaryService cloudinaryService;

    @Override
    public Photo deletePhotoById(Photo photo) throws IOException {
        String publicId = photo.getPublicId();
        Map value = cloudinaryService.deletePhoto(publicId);
        Photo response = Photo
                .builder()
                .publicId(value.get("public_id").toString())
                .name(value.get("original_filename").toString())
                .url(value.get("url").toString())
                .build();
        photoRepository.delete(photo);
        return response;
    }

    @Override
    public Photo savePhoto(MultipartFile multipartFile) throws IOException {
        Map value = cloudinaryService.upPhoto(multipartFile);
        Photo response = Photo
                .builder()
                .publicId(value.get("public_id").toString())
                .name(value.get("original_filename").toString())
                .url(value.get("url").toString())
                .build();
        photoRepository.save(response);
        return response;
    }

    @Override
    public Photo updatePhoto(Photo photo) {
        return null;
    }
}
