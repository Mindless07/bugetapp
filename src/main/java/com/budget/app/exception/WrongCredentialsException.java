package com.budget.app.exception;

public class WrongCredentialsException extends RuntimeException {
    public WrongCredentialsException() {
        super("Wrong Credentials");
    }
}
