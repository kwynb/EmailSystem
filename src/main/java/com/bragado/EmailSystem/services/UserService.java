package com.bragado.EmailSystem.services;

import com.bragado.EmailSystem.entities.User;
import com.bragado.userregistration.dto.UserDTO;

public interface UserService {

    User createNewUser(UserDTO userDTO);
    User updateUser(UserDTO userDTO);
    void deleteUser(UserDTO userDTO);
    User getUser(UserDTO userDTO);
}
