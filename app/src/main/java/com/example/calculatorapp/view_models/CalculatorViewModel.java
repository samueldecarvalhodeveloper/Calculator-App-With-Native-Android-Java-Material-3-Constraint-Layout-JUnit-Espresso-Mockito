package com.example.calculatorapp.view_models;

import static com.example.calculatorapp.domains.calculator.infrastructure.specifications.CalculatorSpecifications.isCalculationExpressionNotValidExpressionExceptionMessage;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.calculatorapp.R;
import com.example.calculatorapp.calculation_expression_store.CalculationExpressionStore;
import com.example.calculatorapp.domains.calculator.Calculator;
import com.example.calculatorapp.domains.calculator.CalculatorCharacters;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.schedulers.Schedulers;

@HiltViewModel
public class CalculatorViewModel extends ViewModel {
    private final MutableLiveData<String> calculationExpression;
    private final Calculator calculator;

    @Inject
    public CalculatorViewModel(Calculator calculator) {
        this.calculator = calculator;

        String initialExpression = calculator.getCalculationExpression();

        calculationExpression = new MutableLiveData<>(initialExpression);
    }

    public LiveData<String> getCalculationExpression(Context context) {
        String currentCalculationExpression = calculator.getCalculationExpression();

        calculationExpression.setValue(isCalculationExpressionNotValidExpressionExceptionMessage(
                currentCalculationExpression
        ) ?
                context.getString(R.string.not_valid_expression_message) :
                currentCalculationExpression);

        return calculationExpression;
    }

    public void addCharacter(CalculatorCharacters calculatorCharacters, Context context) {
        Completable.fromAction(() -> {
                    calculator.addCharacter(calculatorCharacters);

                    String currentCalculationExpression = calculator.getCalculationExpression();

                    calculationExpression.postValue(currentCalculationExpression);

                    CalculationExpressionStore.setStoredCalculationExpression(
                            currentCalculationExpression,
                            context
                    );
                })
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.computation())
                .subscribe();
    }

    public void backspace(Context context) {
        Completable.fromAction(() -> {
                    calculator.backspace();

                    String currentCalculationExpression = calculator.getCalculationExpression();

                    calculationExpression.postValue(currentCalculationExpression);

                    CalculationExpressionStore.setStoredCalculationExpression(
                            currentCalculationExpression,
                            context
                    );
                })
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.computation())
                .subscribe();
    }

    public void clean(Context context) {
        Completable.fromAction(() -> {
                    calculator.clean();

                    String currentCalculationExpression = calculator.getCalculationExpression();

                    calculationExpression.postValue(currentCalculationExpression);

                    CalculationExpressionStore.setStoredCalculationExpression(
                            currentCalculationExpression,
                            context
                    );
                })
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.computation())
                .subscribe();
    }

    public void evaluate(Context context) {
        Completable.fromAction(() -> {
                    calculator.evaluate();

                    String currentCalculationExpression = calculator.getCalculationExpression();

                    calculationExpression.postValue(isCalculationExpressionNotValidExpressionExceptionMessage(
                            currentCalculationExpression
                    ) ?
                            context.getString(R.string.not_valid_expression_message) :
                            currentCalculationExpression);

                    CalculationExpressionStore.setStoredCalculationExpression(
                            currentCalculationExpression,
                            context
                    );
                })
                .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.computation())
                .subscribe();
    }
}
