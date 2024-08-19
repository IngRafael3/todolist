package com.mindhub.todolist.services;

import com.mindhub.todolist.dtos.TaskDTO;
import com.mindhub.todolist.models.Tasks;

import java.util.List;
import java.util.Optional;

public interface TaskService {

    //Tasks findById(Long id);

    Optional<TaskDTO> findById(Long id);

    //List<Tasks> findAll();
    List<TaskDTO> findAll();

    TaskDTO createNewTask(TaskDTO taskDTO);

    TaskDTO updateTask(Long id, TaskDTO taskDTO);

    void deleteTask(Long id);


}
