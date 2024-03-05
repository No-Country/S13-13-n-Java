package com.s13nocoutry.LearnConnect.repository;

import com.s13nocoutry.LearnConnect.models.profilePicture.ProfilePicture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfilePictureRepository extends JpaRepository<ProfilePicture, Long> {
    ProfilePicture findByUser_id(Long id);
}
