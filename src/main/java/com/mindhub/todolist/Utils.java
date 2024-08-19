package com.mindhub.todolist;

import com.mindhub.todolist.exceptions.NotFoundTaskException;
import com.mindhub.todolist.models.RolEnum;
import com.mindhub.todolist.models.Tasks;
import com.mindhub.todolist.models.UserEntity;
import com.mindhub.todolist.repositories.TaskRepository;
import com.mindhub.todolist.repositories.UserEntityRepository;
import com.mindhub.todolist.utils.EnumTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Utils {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner initData(UserEntityRepository userEntityRepository, TaskRepository taskRepository){
        return args ->{

            UserEntity user = new UserEntity("Rafael",passwordEncoder.encode("12345"),"rafael@gmail.com", RolEnum.ADMIN);
            userEntityRepository.save(user);

            UserEntity user2 = new UserEntity("Jose",passwordEncoder.encode("123456"),"jose@gmail.com", RolEnum.USER);
            userEntityRepository.save(user2);

            Tasks task = new Tasks("Tarea1","Ejercicio1", EnumTask.PENDING);
            user.addTasks(task);
            taskRepository.save(task);

            Tasks tarea = taskRepository.findById(1L).orElseThrow(()->new NotFoundTaskException("No se encontro la tarea con ese id"));
        };
    }
}
