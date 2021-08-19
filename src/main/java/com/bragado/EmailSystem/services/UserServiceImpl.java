package com.bragado.EmailSystem.services;

import com.bragado.EmailSystem.entities.User;
import com.bragado.EmailSystem.repositories.UserRepository;
import com.bragado.userregistration.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User createNewUser(UserDTO userDTO) {
        return userRepository.save(userDTO.toUser());
    }

    @Override
    public User updateUser(UserDTO userDTO) {
        User user = userRepository.findByEmail(userDTO.getEmail());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setBirthDay(userDTO.getBirthDay());
        user.setEmail(userDTO.getEmail());
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(UserDTO userDTO) {
        User user = userRepository.findByEmail(userDTO.getEmail());
        userRepository.delete(user);
    }

    @Override
    public User getUser(UserDTO userDTO) {
        User user = userRepository.findByEmail(userDTO.getEmail());
        if (user == null) {
            return userRepository.save(userDTO.toUser());
        }
        return user;
    }


}