package com.s13nocoutry.LearnConnect.room.service;

import com.s13nocoutry.LearnConnect.models.user.User;
import com.s13nocoutry.LearnConnect.room.model.Room;

import java.util.List;

public interface IRoomService {

    Room getById(Long id);
    List<Room> getAllRooms();
    Room create(Room room);
    Room update(Room room);
    void deleteById(Long id);
}
