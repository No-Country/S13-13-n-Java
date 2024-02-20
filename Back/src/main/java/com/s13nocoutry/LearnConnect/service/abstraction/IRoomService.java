package com.s13nocoutry.LearnConnect.service.abstraction;

import com.s13nocoutry.LearnConnect.models.room.Room;

import java.util.List;

public interface IRoomService {

    Room getById(Long id);
    List<Room> getAllRooms();
    Room create(Room room);
    Room update(Room room);
    void deleteById(Long id);
}
