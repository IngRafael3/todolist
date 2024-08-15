package com.mindhub.todolist.services.impl;


import com.mindhub.todolist.dtos.TaskDTO;
import com.mindhub.todolist.exceptions.NotFoundTaskException;
import com.mindhub.todolist.exceptions.NotFoundUserException;
import com.mindhub.todolist.models.Tasks;
import com.mindhub.todolist.models.UserEntity;
import com.mindhub.todolist.repositories.TaskRepository;
import com.mindhub.todolist.repositories.UserEntityRepository;
import com.mindhub.todolist.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserEntityRepository userEntityRepository;

    @Override
    public Tasks findById(Long id) {
        return taskRepository.findById(id).orElseThrow( ()-> new NotFoundTaskException("no existe una tarea con id "+ id));
    }

    @Override
    public List<Tasks> findAll(){
        return taskRepository.findAll();
    }

//
    private Tasks convertToEntity(TaskDTO taskDTO) {
        Tasks task = new Tasks();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setStatus(taskDTO.getStatus());
        return task;
    }

    private TaskDTO convertToDTO(Tasks task) {
        TaskDTO taskDTO = new TaskDTO();
        taskDTO.setId(task.getId());
        taskDTO.setTitle(task.getTitle());
        taskDTO.setDescription(task.getDescription());
        taskDTO.setStatus(task.getStatus());
        taskDTO.setUserId(task.getUser().getId());
        return taskDTO;

    }

    @Override
    public TaskDTO createNewTask(TaskDTO taskDTO){
        Tasks tasks1 = new Tasks();
        tasks1.setTitle(taskDTO.getTitle());
        tasks1.setDescription(taskDTO.getDescription());
        tasks1.setStatus(taskDTO.getStatus());
        UserEntity user1 = userEntityRepository.findById(1L).orElse(null);
        tasks1.setUser(user1);
        Tasks savedTask = taskRepository.save(tasks1);
        return convertToDTO(savedTask);
    }
 //



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
