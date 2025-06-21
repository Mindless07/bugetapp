package com.budget.app.controller;

import com.budget.app.entity.User;
import com.budget.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if(user.isEmpty()) throw new Exception("No User");

        return user.get();
    }
}