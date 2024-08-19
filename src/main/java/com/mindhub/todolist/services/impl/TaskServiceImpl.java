package com.mindhub.todolist.services.impl;


import com.mindhub.todolist.dtos.TaskDTO;
import com.mindhub.todolist.exceptions.NotFoundTaskException;
import com.mindhub.todolist.models.Tasks;
import com.mindhub.todolist.models.UserEntity;
import com.mindhub.todolist.repositories.TaskRepository;
import com.mindhub.todolist.repositories.UserEntityRepository;
import com.mindhub.todolist.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserEntityRepository userEntityRepository;

  /*  @Override
    public Tasks findById(Long id) {
        return taskRepository.findById(id).orElseThrow( ()-> new NotFoundTaskException("no existe una tarea con id "+ id));
    }*/

      @Override
    public Optional<TaskDTO> findById(Long id) {
          return taskRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public List<TaskDTO> findAll(){
          return taskRepository.findAll().stream()
                  .map(this::convertToDTO)
                  .collect(Collectors.toList());
    }
/*    public List<Tasks> findAll(){
        return taskRepository.findAll();
    }*/

//

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
  public TaskDTO updateTask(Long id, TaskDTO taskDTO) {
      Tasks task = taskRepository.findById(id).orElseThrow();
      task.setTitle(taskDTO.getTitle());
      task.setDescription(taskDTO.getDescription());
      task.setStatus(taskDTO.getStatus());
      task = taskRepository.save(task);
      return convertToDTO(task);
  }

    @Override
    public void deleteTask(Long id){
        if (taskRepository.existsById(id)){
            taskRepository.deleteById(id);
        }

    }
}
