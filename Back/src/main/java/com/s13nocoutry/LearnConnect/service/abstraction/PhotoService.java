package com.s13nocoutry.LearnConnect.service.abstraction;

import com.s13nocoutry.LearnConnect.models.photo.PhotoRequest;
import com.s13nocoutry.LearnConnect.models.photo.PhotoResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PhotoService {
    PhotoResponse getById(Long id);
    PhotoResponse create(MultipartFile multipartFile) throws IOException;
    PhotoResponse update(Long id, MultipartFile multipartFile) throws IOException;
    PhotoResponse delete(PhotoRequest photoRequest) throws IOException;
    boolean existsById(Long id);
}
