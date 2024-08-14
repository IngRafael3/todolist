package com.mindhub.todolist.services.impl;

import com.mindhub.todolist.exceptions.NotFoundUserException;
import com.mindhub.todolist.models.UserEntity;
import com.mindhub.todolist.repositories.UserEntityRepository;
import com.mindhub.todolist.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Override
    public UserEntity findById(Long id) {
        return userEntityRepository.findById(id).orElseThrow( ()-> new NotFoundUserException("no existe usuario con id "+ id));
    }
}
