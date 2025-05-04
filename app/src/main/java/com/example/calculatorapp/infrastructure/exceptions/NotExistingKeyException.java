package com.example.calculatorapp.infrastructure.exceptions;

import static com.example.calculatorapp.constants.UserInterfaceConstants.NOT_EXISTING_KEY_EXCEPTION_MESSAGE;

public class NotExistingKeyException extends Exception {
    public NotExistingKeyException(String key) {
        super(NOT_EXISTING_KEY_EXCEPTION_MESSAGE(key));
    }
}
