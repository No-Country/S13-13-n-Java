package com.s13nocoutry.LearnConnect.service.abstraction;

import com.s13nocoutry.LearnConnect.models.photo.Photo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PhotoService {
    Photo deletePhotoById(Photo photo) throws IOException;
    Photo savePhoto(MultipartFile multipartFile) throws IOException;
    Photo updatePhoto(Photo photo);
}
