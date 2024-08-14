package com.mindhub.todolist.services;

import com.mindhub.todolist.models.UserEntity;

public interface UserService {

    UserEntity findById(Long id);
}
