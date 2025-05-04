package com.example.calculatorapp.unitaries.domains.calculator.infrastructure.formatters;

import static com.example.calculatorapp.constants.domains.CalculatorConstants.SIMPLE_CALCULATION_EXPRESSION;
import static com.example.calculatorapp.constants.domains.CalculatorConstants.SIMPLE_CALCULATION_EXPRESSION_WITHOUT_LAST_CHARACTER;
import static com.example.calculatorapp.domains.calculator.infrastructure.formatters.CalculatorFormatter.getCalculationExpressionWithoutLastCharacter;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorFormatterTest {
    @Test
    public void testIfMethodGetCalculationExpressionWithoutLastCharacterReturnExpressionWithoutLastCharacter() {
        String calculationExpressionWithoutLastCharacter = getCalculationExpressionWithoutLastCharacter(SIMPLE_CALCULATION_EXPRESSION);

        assertEquals(SIMPLE_CALCULATION_EXPRESSION_WITHOUT_LAST_CHARACTER, calculationExpressionWithoutLastCharacter);
    }
}