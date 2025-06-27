package com.budget.app.services;

import com.budget.app.entity.User;
import com.budget.app.exception.UserNotFoundException;

import java.util.List;

public interface IUsersService {

    long save(User user);

    List<User> findAll();

    User findById(long userId) throws UserNotFoundException;

    User findByUsername(String username) throws UserNotFoundException;

    User getCurrentUser() throws UserNotFoundException;
}
