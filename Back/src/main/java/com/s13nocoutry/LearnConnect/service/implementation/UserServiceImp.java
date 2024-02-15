package com.s13nocoutry.LearnConnect.service.implementation;

import com.s13nocoutry.LearnConnect.models.user.User;
import com.s13nocoutry.LearnConnect.repository.UserRepository;
import com.s13nocoutry.LearnConnect.service.abstraction.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;

    @Override
    public User getById(Long id) throws EntityNotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("El usuario con id: " + id + " no existe en base de datos"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        if (!userRepository.existsById(user.getId())) {
            throw new EntityNotFoundException("El usuario con id: " + user.getId() + " no existe en base de datos" );
        }
        return userRepository.save(user);
    }

    @Override
    public void deleteById(Long id) throws EntityNotFoundException{
        if (!userRepository.existsById(id)) {
            throw new EntityNotFoundException("El usuario con id: " + id + " no existe en base de datos" );
        }
        userRepository.deleteById(id);
    }
}
