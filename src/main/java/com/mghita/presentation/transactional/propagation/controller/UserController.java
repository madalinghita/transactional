package com.mghita.presentation.transactional.propagation.controller;

import com.mghita.presentation.transactional.propagation.model.User;
import com.mghita.presentation.transactional.propagation.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RequestMapping(path = "/users")
@RestController
public class UserController {

    UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return this.userService.getUsers();
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return this.userService.addUser(user);
    }

    @PutMapping(path = "/{id}")
    public User editUser(@PathVariable Integer id, @RequestBody User user) {
        return this.userService.editUser(id, user);
    }
}
