package com.s13nocoutry.LearnConnect.service.implementation;

import com.s13nocoutry.LearnConnect.models.photo.PhotoRequest;
import com.s13nocoutry.LearnConnect.models.photo.PhotoResponse;
import com.s13nocoutry.LearnConnect.repository.PhotoRepository;
import com.s13nocoutry.LearnConnect.models.photo.Photo;
import com.s13nocoutry.LearnConnect.service.abstraction.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PhotoServiceImp implements PhotoService {
    private final PhotoRepository photoRepository;
    private final CloudinaryService cloudinaryService;

    @Override
    public PhotoResponse getById(Long id) {
        Photo photo = photoRepository.findById(id).orElse(null);
        return (photo != null) ? new PhotoResponse(photo) : null;
    }

    @Override
    public PhotoResponse create(MultipartFile multipartFile) throws IOException {
        Map value = cloudinaryService.upPhoto(multipartFile);
        PhotoResponse photoResponse = PhotoResponse
                .builder()
                .publicId(value.get("public_id").toString())
                .name(value.get("original_filename").toString())
                .url(value.get("url").toString())
                .build();
        Photo photo = Photo
                .builder()
                .publicId(value.get("public_id").toString())
                .name(value.get("original_filename").toString())
                .url(value.get("url").toString())
                .build();
        photoRepository.save(photo);
        return photoResponse;
    }

    @Override
    public PhotoResponse update(Long id, MultipartFile multipartFile) throws IOException {
        Photo photo = new Photo();
        Optional<Photo> response =photoRepository.findById(id);
        if (response.isPresent()) {
            photo = response.get();
            cloudinaryService.deletePhoto(photo.getPublicId());
            Map newPhotoCloudinary = cloudinaryService.upPhoto(multipartFile);
            photo.setPublicId(newPhotoCloudinary.get("public_id").toString());
            photo.setName(newPhotoCloudinary.get("original_filename").toString());
            photo.setUrl(newPhotoCloudinary.get("url").toString());
            photoRepository.save(photo);
            return PhotoResponse
                    .builder()
                    .id(photo.getId())
                    .publicId(photo.getPublicId())
                    .name(photo.getName())
                    .url(photo.getUrl())
                    .build();
        }
        return null;
    }

    @Override
    public PhotoResponse delete(PhotoRequest photoRequest) throws IOException {
        String publicId = photoRequest.getPublicId();
        Map value = cloudinaryService.deletePhoto(publicId);
        PhotoResponse photoResponse = PhotoResponse
                .builder()
                .publicId(value.get("public_id").toString())
                .name(value.get("original_filename").toString())
                .url(value.get("url").toString())
                .build();
        Photo photo = Photo
                .builder()
                .id(photoRequest.getId())
                .publicId(photoRequest.getPublicId())
                .name(photoRequest.getName())
                .url(photoRequest.getUrl())
                .build();
        photoRepository.delete(photo);
        return photoResponse;
    }

    @Override
    public boolean existsById(Long id) {
        return photoRepository.existsById(id);
    }
}
