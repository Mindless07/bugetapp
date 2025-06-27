package com.budget.app.exception;

public class NoCategoryFound extends RuntimeException {

    public NoCategoryFound(long categoryId, long userId) {
        super(String.format("No category of Id %d for userId %d found", categoryId, userId));
    }
}
