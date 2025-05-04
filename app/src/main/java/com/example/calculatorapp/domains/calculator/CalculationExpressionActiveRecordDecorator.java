package com.example.calculatorapp.domains.calculator;

import static com.example.calculatorapp.domains.calculator.infrastructure.specifications.CalculatorSpecifications.isCalculationExpressionEmpty;
import static com.example.calculatorapp.domains.calculator.infrastructure.specifications.CalculatorSpecifications.isCalculationExpressionNotValidExpressionExceptionMessage;

public class CalculationExpressionActiveRecordDecorator extends CalculationExpressionActiveRecord {
    public CalculationExpressionActiveRecordDecorator(CalculationExpressionRegister calculationExpressionRegister) {
        super(calculationExpressionRegister);
    }

    public String getCalculationExpression() {
        return super.getCalculationExpression();
    }

    public void addCharacterToCalculationExpression(CalculatorCharacters character) {
        String currentCalculationExpression = super.getCalculationExpression();

        if (isCalculationExpressionNotValidExpressionExceptionMessage(currentCalculationExpression)) {
            super.turnCalculationExpressionEmpty();
        } else {
            super.addCharacterToCalculationExpression(character);
        }
    }

    public void removeLastCharacterFromCalculationExpression() {
        String currentCalculationExpression = super.getCalculationExpression();

        if (isCalculationExpressionNotValidExpressionExceptionMessage(currentCalculationExpression)) {
            super.turnCalculationExpressionEmpty();
        } else {
            super.removeLastCharacterFromCalculationExpression();
        }
    }

    public void turnCalculationExpressionEmpty() {
        super.turnCalculationExpressionEmpty();
    }

    public void evaluateCalculationExpression() {
        String currentCalculationExpression = super.getCalculationExpression();

        if (isCalculationExpressionNotValidExpressionExceptionMessage(currentCalculationExpression) &&
                isCalculationExpressionEmpty(currentCalculationExpression))
            return;

        super.evaluateCalculationExpression();
    }
}
