package com.budget.app.services;

import com.budget.app.entity.User;

import java.util.List;

public interface IUsersService {

    long save(User user);

    List<User> findAll();

    User findById(long userId) throws Exception;

    User findByUsername(String username) throws Exception;

    User getCurrentUser() throws Exception;
}
