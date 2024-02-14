package com.s13nocoutry.LearnConnect.service;

import com.s13nocoutry.LearnConnect.model.entity.Photo;

public interface PhotoService {
    void deletePhotoById(String id);
    Photo savePhoto(Photo photo);
}
