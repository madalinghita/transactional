package com.mghita.presentation.transactional.intro.controller;

import com.mghita.presentation.transactional.intro.model.User;
import com.mghita.presentation.transactional.intro.service.UserService;
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
    public User addUser(@RequestBody User user) throws Exception {
        System.out.println(userService.getClass()); // UserService.class ?? NO // UserService$$EnhancerBySpringCGLIB$$9ab2b162
        return this.userService.addUser(user);
    }

    @PutMapping(path = "/{id}")
    public User editUser(@PathVariable Integer id, @RequestBody User user) {
        return this.userService.editUser(id, user);
    }
}
