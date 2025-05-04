package com.example.calculatorapp.dependencies_injection;

import android.content.Context;

import com.example.calculatorapp.calculation_expression_store.CalculationExpressionStore;
import com.example.calculatorapp.domains.calculator.CalculationExpression;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class CalculationExpressionModule {

    @Provides
    public CalculationExpression provideCalculationExpression(@ApplicationContext Context context) {
        String storedCalculationExpression = CalculationExpressionStore.getStoredCalculationExpression(context);

        return new CalculationExpression(storedCalculationExpression);
    }
}
