package com.budget.app.services;

import com.budget.app.exception.UserNotFoundException;
import com.budget.app.exception.WrongCredentialsException;

public interface IAuthenticationService {
    String authenticate(String username, String password) throws WrongCredentialsException, UserNotFoundException;
}
