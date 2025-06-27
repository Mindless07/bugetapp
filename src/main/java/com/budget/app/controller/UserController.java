package com.budget.app.controller;

import com.budget.app.entity.User;
import com.budget.app.exception.UserNotFoundException;
import com.budget.app.services.IUsersService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/users")
@AllArgsConstructor
public class UserController {
    private final IUsersService usersService;

    @PostMapping
    public long createUser(@RequestBody User user) {
        return usersService.save(user);
    }

    @GetMapping
    public List<User> getUsers() {
        return usersService.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) throws UserNotFoundException {
        return usersService.findById(id);
    }
}