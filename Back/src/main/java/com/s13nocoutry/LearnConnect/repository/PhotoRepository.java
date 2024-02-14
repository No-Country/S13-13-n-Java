package com.s13nocoutry.LearnConnect.repository;

import com.s13nocoutry.LearnConnect.models.photo.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
