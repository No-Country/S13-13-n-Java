package com.s13nocoutry.LearnConnect.model.dao;

import com.s13nocoutry.LearnConnect.model.entity.Photo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoDao extends JpaRepository<Photo, String> {
}
