package com.example.beautysalonrestspring.exception;

import com.example.beautysalonrestspring.model.enums.ErrorType;

public class UserAlreadyExistsException extends ServiceException {

    private static final String DEFAULT_MESSAGE = "User already exist!";

    public UserAlreadyExistsException() {
        super(DEFAULT_MESSAGE);
    }


    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}
