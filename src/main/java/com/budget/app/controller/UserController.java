package com.budget.app.controller;

import com.budget.app.entity.User;
import com.budget.app.repository.UserRepository;
import com.budget.app.services.IUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUsersService usersService;

    @PostMapping
    public long createUser(@RequestBody User user) {
        return usersService.save(user);
    }

    @GetMapping
    public List<User> getUsers() {
        return usersService.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) throws Exception {
        return usersService.findById(id);
    }
}