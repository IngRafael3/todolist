package com.mindhub.todolist.services.impl;


import com.mindhub.todolist.dtos.TaskDTO;
import com.mindhub.todolist.exceptions.NotFoundTaskException;
import com.mindhub.todolist.models.Tasks;
import com.mindhub.todolist.models.UserEntity;
import com.mindhub.todolist.repositories.TaskRepository;
import com.mindhub.todolist.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Tasks findById(Long id) {
        return taskRepository.findById(id).orElseThrow( ()-> new NotFoundTaskException("no existe una tarea con id "+ id));
    }

    @Override
    public List<Tasks> findAll(){
        return taskRepository.findAll();
    }

    @Override
    public Tasks createTask(TaskDTO taskDTO){
        Tasks tasks = new Tasks();
        tasks.setTitle(taskDTO.getTitle());
        tasks.setDescription(taskDTO.getDescription());
        tasks.setStatus(taskDTO.getStatus());

        return taskRepository.save(tasks);
    }

    @Override
    public Tasks updateTask(Long id, TaskDTO taskDTO){
        Tasks updatedTask = taskRepository.findById(id).get();
        updatedTask.setTitle(taskDTO.getTitle());
        updatedTask.setStatus(taskDTO.getStatus());
        updatedTask.setDescription(taskDTO.getDescription());

        return taskRepository.save(updatedTask);
    }

    @Override
    public void deleteTask(Long id){
        if (taskRepository.existsById(id)){
            taskRepository.deleteById(id);
        }

    }
}
