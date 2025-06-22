package com.budget.app.services;

public interface IAuthenticationService {
    String authenticate(String username, String password) throws Exception;
}
