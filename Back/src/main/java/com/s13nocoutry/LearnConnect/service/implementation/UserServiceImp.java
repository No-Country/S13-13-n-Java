package com.s13nocoutry.LearnConnect.service.implementation;

import com.s13nocoutry.LearnConnect.models.user.User;
import com.s13nocoutry.LearnConnect.models.user.UserRequest;
import com.s13nocoutry.LearnConnect.models.user.UserResponse;
import com.s13nocoutry.LearnConnect.repository.UserRepository;
import com.s13nocoutry.LearnConnect.service.abstraction.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

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
        return modelMapper.map(user, UserResponse.class);
    }

    @Override
    public UserResponse update(UserRequest userRequest) {
        if (!userRepository.existsById(userRequest.getId())) {
            throw new EntityNotFoundException("El usuario con id: " + userRequest.getId() + " no existe en base de datos" );
        }
        User user = userRepository.save(modelMapper.map(userRequest, User.class));
        return modelMapper.map(user, UserResponse.class);
    }

    @Override
    public void deleteById(Long id) throws EntityNotFoundException{
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("El usuario con id: " + id + " no existe en base de datos" );
        }
        userRepository.deleteById(id);
    }

    public void connectUser(User user){
        user.setStatus("ONLINE");
        userRepository.save(user);
    }

    public void disconnect(User user){

        var storedUser = userRepository.findById(user.getId())
                .orElse(null);

        if (storedUser != null) {
            storedUser.setStatus("OFFLINE");
            userRepository.save(storedUser);
        }


    }

    public List<User> findConnectedUsers(){
        return userRepository.findAllByStatus("ONLINE");
    }
}
