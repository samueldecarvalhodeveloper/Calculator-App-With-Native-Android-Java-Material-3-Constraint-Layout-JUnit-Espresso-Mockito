package com.example.calculatorapp.dependencies_injection;

import com.example.calculatorapp.domains.calculator.CalculationExpressionActiveRecord;
import com.example.calculatorapp.domains.calculator.CalculationExpressionActiveRecordDecorator;
import com.example.calculatorapp.domains.calculator.CalculationExpressionRegister;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class CalculationExpressionActivityRecordModule {
    @Provides
    public CalculationExpressionActiveRecord provideCalculationExpressionActiveRecord(CalculationExpressionRegister calculationExpressionRegister) {
        return new CalculationExpressionActiveRecordDecorator(calculationExpressionRegister);
    }
}
