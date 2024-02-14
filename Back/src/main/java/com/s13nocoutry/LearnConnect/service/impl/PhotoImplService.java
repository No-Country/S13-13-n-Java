package com.s13nocoutry.LearnConnect.service.impl;

import com.s13nocoutry.LearnConnect.model.dao.PhotoDao;
import com.s13nocoutry.LearnConnect.model.entity.Photo;
import com.s13nocoutry.LearnConnect.service.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhotoImplService implements PhotoService {
    private final PhotoDao photoDao;

    @Override
    public void deletePhotoById(String id) {
        photoDao.deleteById(id);
    }

    @Override
    public Photo savePhoto(Photo photo) {
        return photoDao.save(Photo
                .builder()
                .name(photo.getName())
                .url(photo.getUrl())
                .build());
    }
}
