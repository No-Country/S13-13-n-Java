package com.s13nocoutry.LearnConnect.service.implementation;

import com.s13nocoutry.LearnConnect.models.room.Room;
import com.s13nocoutry.LearnConnect.repository.RoomRepository;
import com.s13nocoutry.LearnConnect.service.abstraction.IRoomService;
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
    } // como manejamos la creacion del chat para el room? lo hacemos persistencia por cascada, y lo manjemaos desde el controller de room?

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

    // TODO: agregar servicios de busqueda de room por bloqueados o silenciados

    // Como vamos a hacer para recuperar el room por alguna identificacion? por el idDelChat?, por los usuarios que participan en la room? no deberia tener la room un nombre del grupo?
}
