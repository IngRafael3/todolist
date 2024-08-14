package com.mindhub.todolist.repositories;

import com.mindhub.todolist.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {


    boolean existsById(Long id);


}
