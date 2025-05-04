package com.example.calculatorapp.unitaries.infrastructure.exceptions;

import static com.example.calculatorapp.constants.UserInterfaceConstants.LAST_SESSION_CALCULATION_EXPRESSION_KEY;
import static com.example.calculatorapp.constants.UserInterfaceConstants.NOT_EXISTING_KEY_EXCEPTION_MESSAGE;
import static org.junit.Assert.assertEquals;

import com.example.calculatorapp.infrastructure.exceptions.NotExistingKeyException;

import org.junit.Test;

public class NotExistingKeyExceptionTest {
    @Test
    public void testIfClassDeclaresHowNotExistingKeyExceptionShouldBeThrown() {
        try {
            throw new NotExistingKeyException(LAST_SESSION_CALCULATION_EXPRESSION_KEY);
        } catch (Exception exception) {
            String exceptionMessage = exception.getMessage();

            assertEquals(NOT_EXISTING_KEY_EXCEPTION_MESSAGE(LAST_SESSION_CALCULATION_EXPRESSION_KEY), exceptionMessage);
        }
    }
}