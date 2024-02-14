package com.s13nocoutry.LearnConnect.service.implementation;

import com.s13nocoutry.LearnConnect.repository.PhotoRepository;
import com.s13nocoutry.LearnConnect.models.photo.Photo;
import com.s13nocoutry.LearnConnect.service.abstraction.PhotoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PhotoServiceImp implements PhotoService {
    private final PhotoRepository photoDao;

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
