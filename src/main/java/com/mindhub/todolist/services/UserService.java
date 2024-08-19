package com.mindhub.todolist.services;

import com.mindhub.todolist.dtos.TaskDTO;
import com.mindhub.todolist.dtos.UserDTO;
import com.mindhub.todolist.models.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserService {

    //UserEntity findById(Long id);
    Optional<UserDTO> findById(Long id);

    List<UserDTO> findAll();

    UserDTO createNewUser(UserDTO userDTO);

    UserDTO updateUser(Long id, UserDTO userDTO);

    void deleteUser(Long id);
}
