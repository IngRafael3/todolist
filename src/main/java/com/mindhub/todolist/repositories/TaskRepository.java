package com.mindhub.todolist.repositories;

import com.mindhub.todolist.models.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<Tasks,Long> {


}
