package com.s13nocoutry.LearnConnect.service.implementation;

import com.s13nocoutry.LearnConnect.models.Chat.Chat;
import com.s13nocoutry.LearnConnect.models.contactList.ContactList;
import com.s13nocoutry.LearnConnect.models.contactList.ContactListRequest;
import com.s13nocoutry.LearnConnect.models.contactList.ContactListResponse;
import com.s13nocoutry.LearnConnect.models.room.Room;
import com.s13nocoutry.LearnConnect.models.user.User;
import com.s13nocoutry.LearnConnect.repository.ContactListRepository;
import com.s13nocoutry.LearnConnect.repository.RoomRepository;
import com.s13nocoutry.LearnConnect.repository.UserRepository;
import com.s13nocoutry.LearnConnect.service.abstraction.ContactListService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactListServiceImp implements ContactListService {
    private final ContactListRepository contactListRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RoomRepository roomRepository;

    @Override
    public ContactListResponse getById(Long id) {
        ContactList contactList = contactListRepository.findById(id).orElse(null);
        return (contactList != null) ? modelMapper.map(contactList, ContactListResponse.class) : null;
    }

    @Override
    public ContactList getByUserId(Long id) {
        return contactListRepository.findByUser_Id(id);
    }

    @Override
    public List<ContactListResponse> getAllContactList() {
        List<ContactListResponse> contactListResponses = new ArrayList<>();
        for (ContactList contactList : contactListRepository.findAll()) {
            ContactListResponse contactListResponse = modelMapper.map(contactList, ContactListResponse.class);
            contactListResponses.add(contactListResponse);
        }
        return contactListResponses;
    }

    @Override
    public ContactListResponse create(ContactListRequest contactListRequest) {
        ContactList contactList = contactListRepository.save(modelMapper.map(contactListRequest, ContactList.class));
        return modelMapper.map(contactList, ContactListResponse.class);
    }

    @Override
    public ContactListResponse update(Long id, ContactListRequest contactListRequest) {
        return null;
    }

    @Override
    public void delete(Long id) {
        contactListRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return contactListRepository.existsById(id);
    }

    @Override
    public ContactListResponse addContact(Long userId, Long contactId){
        //Obtengo la lista de contactos del usuario
        ContactList contactList = contactListRepository.findByUser_Id(userId);
        //Obtengo el contacto a agregar
        User user = userRepository.findById(contactId).orElseThrow(() -> new EntityNotFoundException("Usuario No encontrado"));
        //agrego el contacto a la lista de contactos del usuario
        contactList.getUserList().add(user);
        //-----------------creacion de room
        Room room = new Room();
        List<User> users = new ArrayList<>();
        users.add(user);

        //room.getUsers().add(user);
        Optional<User> user2 = userRepository.findById(userId);
        //room.getUsers().add(user2.get());
        users.add(user2.get());
        room.setChat(new Chat());
        room.setUsers(users);
        roomRepository.save(room);
        contactList = contactListRepository.save(contactList);
        return modelMapper.map(contactList, ContactListResponse.class);


    }

}
