package com.s13nocoutry.LearnConnect.repository;

import com.s13nocoutry.LearnConnect.models.profile.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
}
