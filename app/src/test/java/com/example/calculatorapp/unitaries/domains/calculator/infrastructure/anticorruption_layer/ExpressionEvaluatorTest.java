package com.example.calculatorapp.unitaries.domains.calculator.infrastructure.anticorruption_layer;

import static com.example.calculatorapp.constants.domains.CalculatorConstants.EVALUATED_SIMPLE_CALCULATION_EXPRESSION;
import static com.example.calculatorapp.constants.domains.CalculatorConstants.NOT_VALID_EXPRESSION;
import static com.example.calculatorapp.constants.domains.CalculatorConstants.NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE;
import static com.example.calculatorapp.constants.domains.CalculatorConstants.SIMPLE_CALCULATION_EXPRESSION;
import static com.example.calculatorapp.domains.calculator.infrastructure.anticorruption_layer.ExpressionEvaluator.getEvaluatedCalculationExpression;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ExpressionEvaluatorTest {
    @Test
    public void testIfMethodGetEvaluatedCalculationExpressionReturnsEvaluatedExpression() {
        String evaluatedExpression = getEvaluatedCalculationExpression(SIMPLE_CALCULATION_EXPRESSION);

        assertEquals(EVALUATED_SIMPLE_CALCULATION_EXPRESSION, evaluatedExpression);
    }

    @Test
    public void testIfMethodGetEvaluatedCalculationExpressionReturnsNotValidExpressionIfExpressionIsNotValid() {
        String evaluatedExpression =
                getEvaluatedCalculationExpression(NOT_VALID_EXPRESSION);

        assertEquals(NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE, evaluatedExpression);
    }
}