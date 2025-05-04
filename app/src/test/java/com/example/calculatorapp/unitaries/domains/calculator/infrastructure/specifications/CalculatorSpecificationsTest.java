package com.example.calculatorapp.unitaries.domains.calculator.infrastructure.specifications;

import static com.example.calculatorapp.constants.domains.CalculatorConstants.NOT_RATIONAL_NUMBER;
import static com.example.calculatorapp.constants.domains.CalculatorConstants.NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE;
import static com.example.calculatorapp.constants.domains.CalculatorConstants.RATIONAL_NUMBER;
import static com.example.calculatorapp.constants.domains.CalculatorConstants.SIMPLE_CALCULATION_EXPRESSION;
import static com.example.calculatorapp.domains.calculator.infrastructure.specifications.CalculatorSpecifications.isCalculationExpressionEmpty;
import static com.example.calculatorapp.domains.calculator.infrastructure.specifications.CalculatorSpecifications.isCalculationExpressionNotValidExpressionExceptionMessage;
import static com.example.calculatorapp.domains.calculator.infrastructure.specifications.CalculatorSpecifications.isCalculationExpressionRationalNumber;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CalculatorSpecificationsTest {
    @Test
    public void testIfMethodIsCalculationExpressionRationalNumberReturnsTrueIfNumberIsAFloatingNumber() {
        boolean rationalNumber = isCalculationExpressionRationalNumber(RATIONAL_NUMBER);
        boolean notRationalNumber = isCalculationExpressionRationalNumber(NOT_RATIONAL_NUMBER);

        assertTrue(rationalNumber);
        assertFalse(notRationalNumber);
    }

    @Test
    public void testIfMethodIsCalculationExpressionEmptyReturnsTrueIfCalculationExpressionIsEmpty() {
        boolean emptyExpression = isCalculationExpressionEmpty("");
        boolean notEmptyExpression = isCalculationExpressionEmpty(SIMPLE_CALCULATION_EXPRESSION);

        assertTrue(emptyExpression);
        assertFalse(notEmptyExpression);
    }

    @Test
    public void testIfMethodIsCalculationExpressionNotValidExpressionExceptionMessageReturnsTrueIfCalculationExpressionIsNotValidExpressionMessage() {
        boolean calculationExpressionIsNotValidExpressionMessage =
                isCalculationExpressionNotValidExpressionExceptionMessage(
                        NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE
                );
        boolean notValidExpressionMessage =
                isCalculationExpressionNotValidExpressionExceptionMessage(SIMPLE_CALCULATION_EXPRESSION);

        assertTrue(calculationExpressionIsNotValidExpressionMessage);
        assertFalse(notValidExpressionMessage);
    }
}