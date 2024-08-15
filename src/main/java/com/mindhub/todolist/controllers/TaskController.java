package com.mindhub.todolist.controllers;


import com.mindhub.todolist.dtos.TaskDTO;
import com.mindhub.todolist.models.Tasks;
import com.mindhub.todolist.services.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/{id}")
    @Operation(summary = "Get ", description = "Retrieve a Task entity by its ID.")
    public ResponseEntity<TaskDTO> geTaskById(@PathVariable Long id){
        return ResponseEntity.ok(new TaskDTO(taskService.findById(id)));
    }

    @GetMapping("/alltask")
    @Operation(summary = "Get ", description = "Retrieve all Task entities.")
    public ResponseEntity<List<Tasks>> geTaskById(){
        List<Tasks> allTask =  taskService.findAll();
        return new ResponseEntity<>( allTask, HttpStatus.OK);
    }


    @PostMapping("/createdTask")
    @Operation(summary = "POST ", description = "Create a new Task entity.")
    public ResponseEntity<TaskDTO> createdNewTask(@RequestBody TaskDTO taskDTO){
        TaskDTO create = taskService.createNewTask(taskDTO);
        return new ResponseEntity<>(create, HttpStatus.CREATED);
    }

    @PutMapping("/updatetask/{id}")
    @Operation(summary = "UPDATE ", description = "Update an existing Task entity.")
    public ResponseEntity<Tasks> updateTask(@PathVariable Long id, @RequestBody TaskDTO taskDTO){
        Tasks updateTask = taskService.updateTask(id, taskDTO);
        return new ResponseEntity<>(updateTask, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete ", description = "Delete a Task entity by its ID.")
    public ResponseEntity<String> deleteTask(@PathVariable Long id){
        taskService.deleteTask(id);
        return ResponseEntity.ok("");
    }
}
