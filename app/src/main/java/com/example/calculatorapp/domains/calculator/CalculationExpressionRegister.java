package com.example.calculatorapp.domains.calculator;

import javax.inject.Inject;

public class CalculationExpressionRegister {
    private final CalculationExpression calculationExpression;

    @Inject
    public CalculationExpressionRegister(CalculationExpression calculationExpression) {
        this.calculationExpression = calculationExpression;
    }

    public String getCalculationExpression() {
        return this.calculationExpression.getCalculationExpression();
    }

    public void setCalculationExpression(String newExpression) {
        this.calculationExpression.setCalculationExpression(newExpression);
    }

    public void addCharacterToCalculationExpression(CalculatorCharacters calculatorCharacters) {
        String currentCalculationExpression = this.calculationExpression.getCalculationExpression();
        String calculationExpressionWithNewCharacter =
                currentCalculationExpression.concat(calculatorCharacters.value);

        this.calculationExpression.setCalculationExpression(calculationExpressionWithNewCharacter);
    }
}
