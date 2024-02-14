package com.s13nocoutry.LearnConnect.service.abstraction;

import com.s13nocoutry.LearnConnect.models.photo.Photo;

public interface PhotoService {
    void deletePhotoById(String id);
    Photo savePhoto(Photo photo);
}
