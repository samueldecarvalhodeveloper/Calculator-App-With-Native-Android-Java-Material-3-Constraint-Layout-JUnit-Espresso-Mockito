package com.example.calculatorapp.domains.calculator;

public class CalculationExpression {
    private String calculationExpression;

    public CalculationExpression(String calculationExpression) {
        this.calculationExpression = calculationExpression;
    }

    public String getCalculationExpression() {
        return calculationExpression;
    }

    public void setCalculationExpression(String calculationExpression) {
        this.calculationExpression = calculationExpression;
    }
}
