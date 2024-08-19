package com.mindhub.todolist.controllers;

import com.mindhub.todolist.dtos.UserDTO;
import com.mindhub.todolist.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admin")
@CrossOrigin("*")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable Long id){
        return userService.findById(id).orElse(null);
    }

    @PostMapping("/createUser")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        UserDTO created = userService.createNewUser(userDTO);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
}
