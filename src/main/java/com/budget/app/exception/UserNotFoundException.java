package com.budget.app.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String username) {
        super(String.format("username %s not found", username));
    }

    public UserNotFoundException(long userId) {
        super(String.format("username %d not found", userId));
    }
}
