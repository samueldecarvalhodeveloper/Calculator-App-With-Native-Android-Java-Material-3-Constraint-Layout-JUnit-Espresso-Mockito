package com.example.calculatorapp.domains.calculator;

import static com.example.calculatorapp.domains.calculator.infrastructure.formatters.CalculatorFormatter.getCalculationExpressionWithoutLastCharacter;

import com.example.calculatorapp.domains.calculator.infrastructure.anticorruption_layer.ExpressionEvaluator;

public class CalculationExpressionActiveRecord {
    private final CalculationExpressionRegister calculationExpressionRegister;

    public CalculationExpressionActiveRecord(CalculationExpressionRegister calculationExpressionRegister) {
        this.calculationExpressionRegister = calculationExpressionRegister;
    }

    public String getCalculationExpression() {
        return calculationExpressionRegister.getCalculationExpression();
    }

    public void addCharacterToCalculationExpression(CalculatorCharacters character) {
        calculationExpressionRegister.addCharacterToCalculationExpression(character);
    }

    public void removeLastCharacterFromCalculationExpression() {
        String currentCalculationExpression = this.calculationExpressionRegister.getCalculationExpression();
        String currentCalculationExpressionWithoutLastCharacter = getCalculationExpressionWithoutLastCharacter(currentCalculationExpression);

        calculationExpressionRegister.setCalculationExpression(currentCalculationExpressionWithoutLastCharacter);
    }

    public void turnCalculationExpressionEmpty() {
        this.calculationExpressionRegister.setCalculationExpression("");
    }

    public void evaluateCalculationExpression() {
        String currentCalculationExpression = calculationExpressionRegister.getCalculationExpression();
        String evaluatedCalculationExpression = ExpressionEvaluator.getEvaluatedCalculationExpression(currentCalculationExpression);

        calculationExpressionRegister.setCalculationExpression(evaluatedCalculationExpression);
    }
}
