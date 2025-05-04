package com.example.calculatorapp.unitaries.domains.calculator;

import static com.example.calculatorapp.constants.domains.CalculatorConstants.SIMPLE_CALCULATION_EXPRESSION;
import static org.junit.Assert.assertEquals;

import com.example.calculatorapp.domains.calculator.CalculationExpression;

import org.junit.Test;

public class CalculationExpressionTest {
    @Test
    public void testIfClassRepresentsHowCalculationExpressionShouldBeUsedOnClient() {
        CalculationExpression calculationExpression = new CalculationExpression("");

        String currentCalculationExpression = calculationExpression.getCalculationExpression();

        assertEquals("", currentCalculationExpression);

        calculationExpression.setCalculationExpression(SIMPLE_CALCULATION_EXPRESSION);

        String updateCalculationExpression = calculationExpression.getCalculationExpression();

        assertEquals(SIMPLE_CALCULATION_EXPRESSION, updateCalculationExpression);
    }
}