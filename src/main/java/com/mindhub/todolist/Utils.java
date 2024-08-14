package com.mindhub.todolist;

import com.mindhub.todolist.exceptions.NotFoundTaskException;
import com.mindhub.todolist.models.Tasks;
import com.mindhub.todolist.models.UserEntity;
import com.mindhub.todolist.repositories.TaskRepository;
import com.mindhub.todolist.repositories.UserEntityRepository;
import com.mindhub.todolist.utils.EnumTask;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Utils {

    @Bean
    public CommandLineRunner initData(UserEntityRepository userEntityRepository, TaskRepository taskRepository){
        return args ->{

            UserEntity user = new UserEntity("Rafael","1234","hola@gmail.com");
            userEntityRepository.save(user);

            Tasks task = new Tasks("Tarea1","Ejercicio1", EnumTask.PENDING);
            //user.addTasks(task);
            taskRepository.save(task);

            Tasks tarea = taskRepository.findById(1L).orElseThrow(()->new NotFoundTaskException("No se encontro la tarea con ese id"));
        };
    }
}
