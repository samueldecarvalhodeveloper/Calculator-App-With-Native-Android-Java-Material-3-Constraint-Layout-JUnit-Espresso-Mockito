package com.example.calculatorapp.calculation_expression_store;

import static com.example.calculatorapp.constants.UserInterfaceConstants.LAST_SESSION_CALCULATION_EXPRESSION_KEY;

import android.content.Context;

import com.example.calculatorapp.infrastructure.anticorruption_layer.KeyValueDatabase;
import com.example.calculatorapp.infrastructure.exceptions.NotExistingKeyException;

public class CalculationExpressionStore {
    private CalculationExpressionStore() {
    }

    public static String getStoredCalculationExpression(Context context) {
        try {
            return KeyValueDatabase.getValue(LAST_SESSION_CALCULATION_EXPRESSION_KEY, context);
        } catch (NotExistingKeyException exception) {
            KeyValueDatabase.setValue(LAST_SESSION_CALCULATION_EXPRESSION_KEY, "", context);

            return "";
        }
    }

    public static void setStoredCalculationExpression(String newCalculationExpression, Context context) {
        KeyValueDatabase.setValue(LAST_SESSION_CALCULATION_EXPRESSION_KEY, newCalculationExpression, context);
    }
}
