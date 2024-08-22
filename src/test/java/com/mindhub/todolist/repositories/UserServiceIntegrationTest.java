package com.mindhub.todolist.repositories;

import static org.assertj.core.api.Assertions.assertThat;

import com.mindhub.todolist.dtos.UserDTO;
import com.mindhub.todolist.models.UserEntity;
import com.mindhub.todolist.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
public class UserServiceIntegrationTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserEntityRepository userRepository;

    private UserDTO user;

    @BeforeEach
    public void setUp() {
        user = new UserDTO();
        user.setUsername("testuser");
        user.setPassword("password");
    }

    @Test
    public void whenRegisterUser_thenUserShouldBeStored() {
        // Register the user
        userService.createNewUser(user);

        // Retrieve the user from the repository
        UserEntity foundUser = userRepository.findByUsername(user.getUsername());

        // Assert that the user was saved and retrieved correctly
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getUsername()).isEqualTo("testuser");
    }
}

