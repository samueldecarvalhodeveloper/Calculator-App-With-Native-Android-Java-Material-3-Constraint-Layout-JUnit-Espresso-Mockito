package com.example.calculatorapp.unitaries.domains.calculator;

import static com.example.calculatorapp.constants.domains.CalculatorConstants.EVALUATED_SIMPLE_CALCULATION_EXPRESSION;
import static com.example.calculatorapp.constants.domains.CalculatorConstants.NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE;
import static com.example.calculatorapp.constants.domains.CalculatorConstants.SIMPLE_CALCULATION_EXPRESSION;
import static org.junit.Assert.assertEquals;

import com.example.calculatorapp.domains.calculator.CalculationExpression;
import com.example.calculatorapp.domains.calculator.CalculationExpressionActiveRecordDecorator;
import com.example.calculatorapp.domains.calculator.CalculationExpressionRegister;
import com.example.calculatorapp.domains.calculator.CalculatorCharacters;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculationExpressionActiveRecordDecoratorTest {
    private static CalculationExpressionActiveRecordDecorator calculationExpressionActiveRecordDecorator;
    private static CalculationExpressionRegister calculationExpressionRegister;

    @BeforeClass
    public static void beforeAll() {
        CalculationExpression calculationExpression = new CalculationExpression("");
        calculationExpressionRegister = new CalculationExpressionRegister(calculationExpression);

        calculationExpressionActiveRecordDecorator =
                new CalculationExpressionActiveRecordDecorator(calculationExpressionRegister);
    }

    @Before
    public void beforeEach() {
        calculationExpressionRegister.setCalculationExpression("");
    }

    @Test
    public void testIfMethodGetCalculationExpressionReturnCurrentCalculationExpression() {
        String currentCalculationExpression = calculationExpressionActiveRecordDecorator.getCalculationExpression();

        assertEquals("", currentCalculationExpression);
    }

    @Test
    public void testIfMethodAddCharacterToCalculationExpressionTurnsCalculationToEmptyWhenIsNotValidExpressionExceptionMessage() {
        calculationExpressionRegister.setCalculationExpression(NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE);

        calculationExpressionActiveRecordDecorator.addCharacterToCalculationExpression(CalculatorCharacters.ONE);

        String currentCalculationExpression = calculationExpressionRegister.getCalculationExpression();

        assertEquals("", currentCalculationExpression);

        calculationExpressionActiveRecordDecorator.addCharacterToCalculationExpression(CalculatorCharacters.ONE);

        String updateCalculationExpression = calculationExpressionRegister.getCalculationExpression();

        assertEquals(CalculatorCharacters.ONE.value, updateCalculationExpression);
    }

    @Test
    public void testIfMethodRemoveLastCharacterFromCalculationExpressionTurnsCalculationEmptyIfExpressionIsNotValidExpressionExceptionMessage() {
        calculationExpressionRegister.setCalculationExpression(NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE);

        calculationExpressionActiveRecordDecorator.removeLastCharacterFromCalculationExpression();

        String currentCalculationExpression = calculationExpressionRegister.getCalculationExpression();

        assertEquals("", currentCalculationExpression);
    }

    @Test
    public void testIfMethodTurnCalculationExpressionEmptyCallsTheSuperTypeMethodAndTurnsExpressionEmpty() {
        calculationExpressionRegister.setCalculationExpression(SIMPLE_CALCULATION_EXPRESSION);

        calculationExpressionActiveRecordDecorator.turnCalculationExpressionEmpty();

        String currentCalculationExpression = calculationExpressionRegister.getCalculationExpression();

        assertEquals("", currentCalculationExpression);
    }

    @Test
    public void testIfMethodEvaluateCalculationExpressionDoNotDoNothingIfExpressionIsNotValidExpressionExceptionMessage() {
        calculationExpressionRegister.setCalculationExpression(NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE);

        calculationExpressionActiveRecordDecorator.evaluateCalculationExpression();

        String currentCalculationExpression = calculationExpressionRegister.getCalculationExpression();

        assertEquals(NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE, currentCalculationExpression);

        calculationExpressionRegister.setCalculationExpression(SIMPLE_CALCULATION_EXPRESSION);

        calculationExpressionActiveRecordDecorator.evaluateCalculationExpression();

        String syntaxCorrectCalculationExpression = calculationExpressionRegister.getCalculationExpression();

        assertEquals(EVALUATED_SIMPLE_CALCULATION_EXPRESSION, syntaxCorrectCalculationExpression);
    }
}