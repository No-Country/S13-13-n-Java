package com.s13nocoutry.LearnConnect.service.implementation;

import com.s13nocoutry.LearnConnect.models.contactList.ContactList;
import com.s13nocoutry.LearnConnect.models.contactList.ContactListRequest;
import com.s13nocoutry.LearnConnect.models.profilePicture.ProfilePicture;
import com.s13nocoutry.LearnConnect.models.profilePicture.ProfilePictureResponse;
import com.s13nocoutry.LearnConnect.models.room.Room;
import com.s13nocoutry.LearnConnect.models.user.User;
import com.s13nocoutry.LearnConnect.models.user.UserRequest;
import com.s13nocoutry.LearnConnect.models.user.UserResponse;
import com.s13nocoutry.LearnConnect.repository.ContactListRepository;
import com.s13nocoutry.LearnConnect.repository.ProfilePictureRepository;
import com.s13nocoutry.LearnConnect.repository.RoomRepository;
import com.s13nocoutry.LearnConnect.repository.UserRepository;
import com.s13nocoutry.LearnConnect.service.abstraction.ContactListService;
import com.s13nocoutry.LearnConnect.service.abstraction.ProfilePictureService;
import com.s13nocoutry.LearnConnect.service.abstraction.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final ContactListService contactListService;
    private final ContactListRepository contactListRepository;
    private final RoomRepository roomRepository;
    private final ProfilePictureService profilePictureService;
    private final ProfilePictureRepository profilePictureRepository;

    @Override
    public UserResponse getById(Long id) throws EntityNotFoundException {
        User user = userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("El usuario con id: " + id + " no existe en base de datos"));
        return modelMapper.map(user, UserResponse.class);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        List<UserResponse> users = new ArrayList<>();
        for (User user : userRepository.findAll()) {
            UserResponse userResponse = modelMapper.map(user, UserResponse.class);
            users.add(userResponse);
        }
        return users;
    }

    @Override
    public UserResponse create(UserRequest userRequest, MultipartFile multipartFile) throws IOException {
        User user = userRepository.save(modelMapper.map(userRequest, User.class));
        UserResponse userResponse;
        if (!multipartFile.isEmpty()) {
            ProfilePicture profilePicture = profilePictureService.create(multipartFile);
            profilePicture.setUser(user);
            profilePictureRepository.save(profilePicture);
            userResponse = modelMapper.map(user, UserResponse.class);
            userResponse.setProfilePictureResponse(modelMapper.map(profilePicture, ProfilePictureResponse.class));
        }else{
            userResponse = modelMapper.map(user, UserResponse.class);
        }
        ContactListRequest contactListRequest = new ContactListRequest();
        contactListRequest.setUserId(user.getId());
        contactListService.create(contactListRequest);

        return userResponse;
    }//cuando creamos un usuario tambien creamos una contactList y le seteamos el userId

    @Transactional
    @Override
    public UserResponse update(UserRequest userRequest, MultipartFile multipartFile) throws IOException {
        if (!userRepository.existsById(userRequest.getId())) {
            throw new EntityNotFoundException("El usuario con id: " + userRequest.getId() + " no existe en base de datos" );
        }
        User user = userRepository.save(modelMapper.map(userRequest, User.class));
        UserResponse userResponse;
        if (!multipartFile.isEmpty()) {
            ProfilePicture profilePicture = profilePictureRepository.findByUser_id(user.getId());
            profilePictureService.update(profilePicture.getId(), multipartFile);
            userResponse = modelMapper.map(user, UserResponse.class);
            userResponse.setProfilePictureResponse(modelMapper.map(profilePicture, ProfilePictureResponse.class));
        }else{
            userResponse = modelMapper.map(user, UserResponse.class);
        }

        return userResponse;
    }

    @Transactional
    @Override
    public void deleteById(Long id) throws EntityNotFoundException, IOException {
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("El usuario con id: " + id + " no existe en base de datos" );
        }
        Optional<User> userOpt = userRepository.findById(id);
        User user = userOpt.get();

        //Eliminamos todos los contactos relacionados en la lista de usuarios
        ContactList contactList = contactListRepository.findByUser_Id(user.getId());
        contactListRepository.deleteContactListUser(contactList.getId());
        contactListRepository.deleteUserListContactList(user.getId());
        contactListService.delete(contactList.getId());
        //Eliminamos Todos los room
        for (Room room : user.getRooms()) {
            //if (room.getId().equals(roomId)) {
            roomRepository.deleteById(room.getId());
        }
        //Eliminamos la ProfilePicture relacionada
        ProfilePicture profilePicture = profilePictureRepository.findByUser_id(user.getId());
        if (profilePicture != null) {
            profilePictureService.delete(profilePicture.getId());
        }
        userRepository.delete(user);

    }//TODO despues revisar como eliminar
}
