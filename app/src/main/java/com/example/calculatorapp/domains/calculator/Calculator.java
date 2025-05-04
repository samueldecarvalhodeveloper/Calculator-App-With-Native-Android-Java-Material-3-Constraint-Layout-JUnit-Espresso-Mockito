package com.example.calculatorapp.domains.calculator;

import static com.example.calculatorapp.domains.calculator.infrastructure.specifications.CalculatorSpecifications.isCalculationExpressionEmpty;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Calculator {
    private final CalculationExpressionActiveRecord calculatorExpressionActiveRecord;

    @Inject
    public Calculator(CalculationExpressionActiveRecord calculatorExpressionActiveRecord) {
        this.calculatorExpressionActiveRecord = calculatorExpressionActiveRecord;
    }

    public String getCalculationExpression() {
        return calculatorExpressionActiveRecord.getCalculationExpression();
    }

    public void addCharacter(CalculatorCharacters calculatorCharacters) {
        calculatorExpressionActiveRecord.addCharacterToCalculationExpression(calculatorCharacters);
    }

    public void backspace() {
        String currentCalculationExpression = calculatorExpressionActiveRecord.getCalculationExpression();

        if (isCalculationExpressionEmpty(currentCalculationExpression)) return;

        calculatorExpressionActiveRecord.removeLastCharacterFromCalculationExpression();
    }

    public void clean() {
        String currentCalculationExpression = calculatorExpressionActiveRecord.getCalculationExpression();

        if (isCalculationExpressionEmpty(currentCalculationExpression)) return;

        calculatorExpressionActiveRecord.turnCalculationExpressionEmpty();
    }

    public void evaluate() {
        String currentCalculationExpression = calculatorExpressionActiveRecord.getCalculationExpression();

        if (isCalculationExpressionEmpty(currentCalculationExpression)) return;

        calculatorExpressionActiveRecord.evaluateCalculationExpression();
    }
}
