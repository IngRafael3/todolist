package com.mindhub.todolist.dtos;

import com.mindhub.todolist.models.UserEntity;
import jakarta.persistence.Column;

public class UserDTO {

    private Long id;

    private String username;
    private String password;

    private String  email;

    public UserDTO(UserEntity userEntity) {
       this.username = userEntity.getUsername();
       this.email = userEntity.getEmail();
       this.id = userEntity.getId();
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public Long getId() {
        return id;
    }
}
