package com.example.calculatorapp.domains.calculator.infrastructure.specifications;

import static com.example.calculatorapp.constants.domains.CalculatorConstants.*;

import java.util.Objects;

public class CalculatorSpecifications {
    private CalculatorSpecifications() {
    }

    public static boolean isCalculationExpressionRationalNumber(double evaluatedCalculationExpression) {
        return evaluatedCalculationExpression != (int) evaluatedCalculationExpression;
    }

    public static boolean isCalculationExpressionEmpty(String calculationExpression) {
        return Objects.equals(calculationExpression, "");
    }

    public static boolean isCalculationExpressionNotValidExpressionExceptionMessage(String calculationExpression) {
        return Objects.equals(calculationExpression, NOT_VALID_EXPRESSION_EXCEPTION_MESSAGE);
    }
}