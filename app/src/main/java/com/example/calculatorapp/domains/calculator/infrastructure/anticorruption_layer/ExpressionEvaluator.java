package com.example.calculatorapp.domains.calculator.infrastructure.anticorruption_layer;

import static com.example.calculatorapp.constants.domains.CalculatorConstants.*;
import static com.example.calculatorapp.domains.calculator.infrastructure.specifications.CalculatorSpecifications.isCalculationExpressionRationalNumber;

import net.objecthunter.exp4j.ExpressionBuilder;

public class ExpressionEvaluator {
    private ExpressionEvaluator() {
    }

    public static String getEvaluatedCalculationExpression(String calculationExpression) {
        try {
            double evaluatedCalculationExpression = new ExpressionBuilder(calculationExpression)
                    .build()
                    .evaluate();

            return isCalculationExpressionRationalNumber(evaluatedCalculationExpression) ?
                    String.valueOf(evaluatedCalculationExpression) :
                    String.valueOf((int) evaluatedCalculationExpression);
        } catch (Exception exception) {
            return NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE;
        }
    }
}