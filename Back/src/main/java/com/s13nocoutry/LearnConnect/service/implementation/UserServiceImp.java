package com.s13nocoutry.LearnConnect.service.implementation;

import com.s13nocoutry.LearnConnect.models.contactList.ContactList;
import com.s13nocoutry.LearnConnect.models.contactList.ContactListRequest;
import com.s13nocoutry.LearnConnect.models.user.User;
import com.s13nocoutry.LearnConnect.models.user.UserRequest;
import com.s13nocoutry.LearnConnect.models.user.UserResponse;
import com.s13nocoutry.LearnConnect.repository.ContactListRepository;
import com.s13nocoutry.LearnConnect.repository.UserRepository;
import com.s13nocoutry.LearnConnect.service.abstraction.ContactListService;
import com.s13nocoutry.LearnConnect.service.abstraction.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public UserResponse create(UserRequest userRequest) {
        User user = userRepository.save(modelMapper.map(userRequest, User.class));
        ContactListRequest contactListRequest = new ContactListRequest();
        contactListRequest.setUserId(user.getId());
        contactListService.create(contactListRequest);
        return modelMapper.map(user, UserResponse.class);
    }//cuando creamos un usuario tambien creamos una contactList y le seteamos el userId

    @Transactional
    @Override
    public UserResponse update(UserRequest userRequest) {
        if (!userRepository.existsById(userRequest.getId())) {
            throw new EntityNotFoundException("El usuario con id: " + userRequest.getId() + " no existe en base de datos" );
        }
        User user = userRepository.save(modelMapper.map(userRequest, User.class));
        return modelMapper.map(user, UserResponse.class);
    }

    @Transactional
    @Override
    public void deleteById(Long id) throws EntityNotFoundException{
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("El usuario con id: " + id + " no existe en base de datos" );
        }
        Optional<User> userOpt = userRepository.findById(id);
        User user = userOpt.get();

        ContactList contactList = contactListRepository.findByUser_Id(user.getId());
        contactListRepository.deleteContactListUser(contactList.getId());
        contactListRepository.deleteUserListContactList(user.getId());
        contactListService.delete(contactList.getId());
        userRepository.delete(user);

    }//TODO despues revisar como eliminar
}
