package com.example.calculatorapp.unitaries.domains.calculator;

import static com.example.calculatorapp.constants.domains.CalculatorConstants.SIMPLE_CALCULATION_EXPRESSION;
import static org.junit.Assert.assertEquals;

import com.example.calculatorapp.domains.calculator.CalculationExpression;
import com.example.calculatorapp.domains.calculator.CalculationExpressionRegister;
import com.example.calculatorapp.domains.calculator.CalculatorCharacters;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculationExpressionRegisterTest {
    private static CalculationExpression calculationExpression;
    private static CalculationExpressionRegister calculationExpressionRegister;

    @BeforeClass
    public static void beforeAll() {
        calculationExpression = new CalculationExpression("");

        calculationExpressionRegister = new CalculationExpressionRegister(calculationExpression);
    }

    @Before
    public void beforeEach() {
        calculationExpression.setCalculationExpression("");
    }

    @Test
    public void testIfMethodGetCalculationExpressionReturnsTheCurrentCalculationExpression() {
        String currentCalculationExpression = calculationExpressionRegister.getCalculationExpression();

        assertEquals("", currentCalculationExpression);
    }

    @Test
    public void testIfMethodSetCalculationExpressionReplacesTheCalculationExpression() {
        calculationExpressionRegister.setCalculationExpression(SIMPLE_CALCULATION_EXPRESSION);

        String currentCalculationExpression = calculationExpression.getCalculationExpression();

        assertEquals(SIMPLE_CALCULATION_EXPRESSION, currentCalculationExpression);
    }

    @Test
    public void testIfMethodAddCharacterToCalculationExpressionAddsChoseCharacterToCalculationExpression() {
        calculationExpressionRegister.addCharacterToCalculationExpression(CalculatorCharacters.ONE);

        String currentCalculationExpression = calculationExpression.getCalculationExpression();

        assertEquals(CalculatorCharacters.ONE.value, currentCalculationExpression);
    }
}