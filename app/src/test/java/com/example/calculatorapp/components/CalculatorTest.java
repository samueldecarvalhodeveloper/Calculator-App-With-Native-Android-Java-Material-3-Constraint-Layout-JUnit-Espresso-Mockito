package com.example.calculatorapp.components;

import static org.junit.Assert.assertEquals;

import com.example.calculatorapp.domains.calculator.CalculationExpression;
import com.example.calculatorapp.domains.calculator.CalculationExpressionActiveRecord;
import com.example.calculatorapp.domains.calculator.CalculationExpressionActiveRecordDecorator;
import com.example.calculatorapp.domains.calculator.CalculationExpressionRegister;
import com.example.calculatorapp.domains.calculator.Calculator;
import com.example.calculatorapp.domains.calculator.CalculatorCharacters;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorTest {
    private static Calculator calculator;
    private static CalculationExpressionActiveRecord calculationExpressionActiveRecord;

    @BeforeClass
    public static void beforeAll() {
        CalculationExpression calculationExpression = new CalculationExpression("");
        CalculationExpressionRegister calculationExpressionRegister = new CalculationExpressionRegister(calculationExpression);
        calculationExpressionActiveRecord = new CalculationExpressionActiveRecordDecorator(calculationExpressionRegister);
        
        calculator = new Calculator(calculationExpressionActiveRecord);
    }

    @Before
    public void beforeEach() {
        calculationExpressionActiveRecord.turnCalculationExpressionEmpty();
    }

    @Test
    public void testIfCalculationExpressionIsGet() {
        String currentCalculationExpression = calculator.getCalculationExpression();

        assertEquals("", currentCalculationExpression);
    }

    @Test
    public void testIfCharacterIsAddedToCalculationExpression() {
        calculator.addCharacter(CalculatorCharacters.ONE);

        String currentCalculationExpression = calculator.getCalculationExpression();

        assertEquals(CalculatorCharacters.ONE.value, currentCalculationExpression);
    }

    @Test
    public void testIfLastCharacterIsRemovedFromCalculationExpression() {
        calculationExpressionActiveRecord.addCharacterToCalculationExpression(CalculatorCharacters.ONE);
        calculationExpressionActiveRecord.addCharacterToCalculationExpression(CalculatorCharacters.ONE);

        calculator.backspace();

        String currentCalculationExpression = calculator.getCalculationExpression();

        assertEquals(CalculatorCharacters.ONE.value, currentCalculationExpression);
    }

    @Test
    public void testIfCalculationExpressionIsCleaned() {
        calculationExpressionActiveRecord.addCharacterToCalculationExpression(CalculatorCharacters.ONE);

        calculator.clean();

        String currentCalculationExpression = calculator.getCalculationExpression();

        assertEquals("", currentCalculationExpression);
    }

    @Test
    public void testIfCalculationExpressionIsEvaluated() {
        calculationExpressionActiveRecord.addCharacterToCalculationExpression(CalculatorCharacters.ONE);
        calculationExpressionActiveRecord.addCharacterToCalculationExpression(CalculatorCharacters.ADDITION);
        calculationExpressionActiveRecord.addCharacterToCalculationExpression(CalculatorCharacters.ONE);

        calculator.evaluate();

        String currentCalculationExpression = calculator.getCalculationExpression();

        assertEquals(CalculatorCharacters.TWO.value, currentCalculationExpression);
    }
}
