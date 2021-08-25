package com.example.beautysalonrestspring.exception;

import com.example.beautysalonrestspring.model.enums.ErrorType;

public class PasswordAndRepeatPasswordException extends ServiceException{

    private static final String DEFAULT_MESSAGE = "password and repeatPassword must be the same";

    public PasswordAndRepeatPasswordException() {
        super(DEFAULT_MESSAGE);
    }
    @Override
    public ErrorType getErrorType() {
        return ErrorType.VALIDATION_ERROR_TYPE;
    }
}
