package com.example.calculatorapp.unitaries.view_models;

import static com.example.calculatorapp.constants.domains.CalculatorConstants.EVALUATED_SIMPLE_CALCULATION_EXPRESSION;
import static com.example.calculatorapp.constants.domains.CalculatorConstants.NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE;
import static com.example.calculatorapp.constants.domains.CalculatorConstants.SIMPLE_CALCULATION_EXPRESSION;
import static com.example.calculatorapp.constants.domains.CalculatorConstants.SIMPLE_CALCULATION_EXPRESSION_WITHOUT_LAST_CHARACTER;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.example.calculatorapp.domains.calculator.CalculatorCharacters;
import com.example.calculatorapp.view_models.CalculatorViewModel;

import org.junit.BeforeClass;
import org.junit.Test;

public class CalculatorViewModelTest {
    public static CalculatorViewModel calculatorViewModel;
    public static MutableLiveData<String> calculationExpressionLiveData;
    public static Context context;

    @BeforeClass
    public static void beforeAll() {
        calculatorViewModel = mock(CalculatorViewModel.class);
        calculationExpressionLiveData = mock(MutableLiveData.class);
        context = mock(Context.class);
    }

    @Test
    public void testIfMethodGetCalculationExpressionReturnsTheCurrentCalculationExpression() {
        when(calculatorViewModel.getCalculationExpression(context))
                .thenReturn(calculationExpressionLiveData);
        when(calculatorViewModel.getCalculationExpression(context).getValue())
                .thenReturn(SIMPLE_CALCULATION_EXPRESSION);

        String currentCalculationExpression = calculatorViewModel
                .getCalculationExpression(context)
                .getValue();

        assertEquals(SIMPLE_CALCULATION_EXPRESSION, currentCalculationExpression);
    }

    @Test
    public void testIfMethodGetCalculationExpressionReturnsTheCalculationExpressionOnDeviceLanguage() {
        when(calculatorViewModel.getCalculationExpression(context))
                .thenReturn(calculationExpressionLiveData);
        when(calculatorViewModel.getCalculationExpression(context).getValue())
                .thenReturn(NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE);

        String currentCalculationExpression = calculatorViewModel
                .getCalculationExpression(context)
                .getValue();

        assertEquals(
                NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE,
                currentCalculationExpression
        );
    }

    @Test
    public void testIfMethodAddCharacterAddsChoseCharacterToCalculationExpression() {
        when(calculatorViewModel.getCalculationExpression(context))
                .thenReturn(calculationExpressionLiveData);
        when(calculatorViewModel.getCalculationExpression(context).getValue())
                .thenReturn(SIMPLE_CALCULATION_EXPRESSION);

        calculatorViewModel.addCharacter(CalculatorCharacters.ONE, context);
        calculatorViewModel.addCharacter(CalculatorCharacters.ADDITION, context);
        calculatorViewModel.addCharacter(CalculatorCharacters.ONE, context);

        String currentCalculationExpression = calculatorViewModel
                .getCalculationExpression(context)
                .getValue();

        assertEquals(
                SIMPLE_CALCULATION_EXPRESSION,
                currentCalculationExpression
        );
    }

    @Test
    public void testIfMethodBackspaceRemovesLastCharacterFromCalculationExpression() {
        when(calculatorViewModel.getCalculationExpression(context))
                .thenReturn(calculationExpressionLiveData);
        when(calculatorViewModel.getCalculationExpression(context).getValue())
                .thenReturn(SIMPLE_CALCULATION_EXPRESSION_WITHOUT_LAST_CHARACTER);

        calculatorViewModel.addCharacter(CalculatorCharacters.ONE, context);
        calculatorViewModel.addCharacter(CalculatorCharacters.ADDITION, context);
        calculatorViewModel.addCharacter(CalculatorCharacters.ONE, context);
        calculatorViewModel.backspace(context);

        String currentCalculationExpression = calculatorViewModel
                .getCalculationExpression(context)
                .getValue();

        assertEquals(
                SIMPLE_CALCULATION_EXPRESSION_WITHOUT_LAST_CHARACTER,
                currentCalculationExpression
        );
    }

    @Test
    public void testIfMethodCleanRemovesAllCharactersFromCalculationExpression() {
        when(calculatorViewModel.getCalculationExpression(context))
                .thenReturn(calculationExpressionLiveData);
        when(calculatorViewModel.getCalculationExpression(context).getValue())
                .thenReturn("");

        calculatorViewModel.addCharacter(CalculatorCharacters.ONE, context);
        calculatorViewModel.addCharacter(CalculatorCharacters.ADDITION, context);
        calculatorViewModel.addCharacter(CalculatorCharacters.ONE, context);
        calculatorViewModel.clean(context);

        String currentCalculationExpression = calculatorViewModel
                .getCalculationExpression(context)
                .getValue();

        assertEquals(
                "",
                currentCalculationExpression
        );
    }

    @Test
    public void testIfMethodEvaluateEvaluatesCalculationExpression() {
        when(calculatorViewModel.getCalculationExpression(context))
                .thenReturn(calculationExpressionLiveData);
        when(calculatorViewModel.getCalculationExpression(context).getValue())
                .thenReturn(EVALUATED_SIMPLE_CALCULATION_EXPRESSION);

        calculatorViewModel.addCharacter(CalculatorCharacters.ONE, context);
        calculatorViewModel.addCharacter(CalculatorCharacters.ADDITION, context);
        calculatorViewModel.addCharacter(CalculatorCharacters.ONE, context);
        calculatorViewModel.evaluate(context);

        String currentCalculationExpression = calculatorViewModel
                .getCalculationExpression(context)
                .getValue();

        assertEquals(
                EVALUATED_SIMPLE_CALCULATION_EXPRESSION,
                currentCalculationExpression
        );
    }

    @Test
    public void testIfMethodEvaluateAddsNotValidExpressionExceptionMessageToCalculationExpression() {
        when(calculatorViewModel.getCalculationExpression(context))
                .thenReturn(calculationExpressionLiveData);
        when(calculatorViewModel.getCalculationExpression(context).getValue())
                .thenReturn(NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE);

        calculatorViewModel.addCharacter(CalculatorCharacters.ADDITION, context);
        calculatorViewModel.addCharacter(CalculatorCharacters.ADDITION, context);
        calculatorViewModel.evaluate(context);

        String currentCalculationExpression = calculatorViewModel
                .getCalculationExpression(context)
                .getValue();

        assertEquals(
                NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE,
                currentCalculationExpression
        );
    }
}