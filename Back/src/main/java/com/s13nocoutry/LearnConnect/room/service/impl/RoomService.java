package com.s13nocoutry.LearnConnect.room.service.impl;

import com.s13nocoutry.LearnConnect.room.model.Room;
import com.s13nocoutry.LearnConnect.room.repository.RoomRepository;
import com.s13nocoutry.LearnConnect.room.service.IRoomService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoomService implements IRoomService {

    private final RoomRepository roomRepository;
    @Override
    public Room getById(Long id) {
        return roomRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("The room with ID: " + id + " does not exist in the database."));
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Room create(Room room) {
        return roomRepository.save(room);
    }

    @Override
    public Room update(Room room) {
        if (roomRepository.existsById(room.getId()))
            return roomRepository.save(room);

        throw new EntityNotFoundException("The room with ID: " + room.getId() + "does not exist");
    }

    @Override
    public void deleteById(Long id) {
        roomRepository.deleteById(id);
    }
}
