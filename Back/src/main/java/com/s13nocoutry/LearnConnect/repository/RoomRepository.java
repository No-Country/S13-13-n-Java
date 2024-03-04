package com.s13nocoutry.LearnConnect.repository;

import com.s13nocoutry.LearnConnect.models.room.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {
    //DELETE FROM `learnconnect`.`room_user` WHERE (`room_id` = '1');
}
