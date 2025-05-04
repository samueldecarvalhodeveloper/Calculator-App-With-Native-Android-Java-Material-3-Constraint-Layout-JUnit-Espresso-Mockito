package com.example.calculatorapp.unitaries.domains.calculator;

import static com.example.calculatorapp.constants.domains.CalculatorConstants.EVALUATED_SIMPLE_CALCULATION_EXPRESSION;
import static com.example.calculatorapp.constants.domains.CalculatorConstants.SIMPLE_CALCULATION_EXPRESSION;
import static com.example.calculatorapp.constants.domains.CalculatorConstants.SIMPLE_CALCULATION_EXPRESSION_WITHOUT_LAST_CHARACTER;
import static org.junit.Assert.assertEquals;

import com.example.calculatorapp.domains.calculator.CalculationExpression;
import com.example.calculatorapp.domains.calculator.CalculationExpressionActiveRecord;
import com.example.calculatorapp.domains.calculator.CalculationExpressionRegister;
import com.example.calculatorapp.domains.calculator.CalculatorCharacters;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculationExpressionActiveRecordTest {
    private static CalculationExpressionActiveRecord calculationExpressionActiveRecord;
    private static CalculationExpressionRegister calculationExpressionRegister;

    @BeforeClass
    public static void beforeAll() {
        CalculationExpression calculationExpression = new CalculationExpression("");
        calculationExpressionRegister = new CalculationExpressionRegister(calculationExpression);

        calculationExpressionActiveRecord =
                new CalculationExpressionActiveRecord(calculationExpressionRegister);
    }

    @Before
    public void beforeEach() {
        calculationExpressionRegister.setCalculationExpression("");
    }

    @Test
    public void testIfMethodGetCalculationExpressionReturnCurrentCalculationExpression() {
        String currentCalculationExpression = calculationExpressionActiveRecord.getCalculationExpression();

        assertEquals("", currentCalculationExpression);
    }

    @Test
    public void testIfMethodAddCharacterToCalculatorExpressionAddChoseCharacterToCalculationExpression() {
        calculationExpressionActiveRecord.addCharacterToCalculationExpression(CalculatorCharacters.ONE);

        String currentCalculationExpression = calculationExpressionRegister.getCalculationExpression();

        assertEquals(CalculatorCharacters.ONE.value, currentCalculationExpression);
    }

    @Test
    public void testIfMethodRemoveLastCharacterFromCalculationExpressionRemovesLastCharacterFromExpression() {
        calculationExpressionRegister.setCalculationExpression(SIMPLE_CALCULATION_EXPRESSION);

        calculationExpressionActiveRecord.removeLastCharacterFromCalculationExpression();

        String currentCalculationExpression = calculationExpressionRegister.getCalculationExpression();

        assertEquals(SIMPLE_CALCULATION_EXPRESSION_WITHOUT_LAST_CHARACTER, currentCalculationExpression);
    }

    @Test
    public void testIfMethodTurnCalculationExpressionEmptyMakesTheCalculationExpressionIntoEmptyString() {
        calculationExpressionRegister.setCalculationExpression(SIMPLE_CALCULATION_EXPRESSION);

        String currentCalculationExpression = calculationExpressionRegister.getCalculationExpression();

        assertEquals(SIMPLE_CALCULATION_EXPRESSION, currentCalculationExpression);

        calculationExpressionActiveRecord.turnCalculationExpressionEmpty();

        String updatedCalculationExpression = calculationExpressionRegister.getCalculationExpression();

        assertEquals("", updatedCalculationExpression);
    }

    @Test
    public void testIfMethodEvaluateCalculationExpressionTurnsTheCalculationExpressionIntoEvaluatedValue() {
        calculationExpressionRegister.setCalculationExpression(SIMPLE_CALCULATION_EXPRESSION);

        calculationExpressionActiveRecord.evaluateCalculationExpression();

        String currentCalculationExpression = calculationExpressionRegister.getCalculationExpression();

        assertEquals(EVALUATED_SIMPLE_CALCULATION_EXPRESSION, currentCalculationExpression);
    }
}