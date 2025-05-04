package com.example.calculatorapp.activity_events.main_activity;

import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isViewAdditionButton;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isViewBackspaceButton;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isViewCleanButton;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isViewDivisionButton;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isViewEightButton;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isViewEvaluationButton;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isViewFiveButton;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isViewFourButton;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isViewMultiplicationButton;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isViewNineButton;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isViewOneButton;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isViewPointButton;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isViewSevenButton;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isViewSixButton;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isViewSubtractionButton;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isViewThreeButton;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isViewTwoButton;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isViewZeroButton;

import android.content.Context;
import android.view.View;

import com.example.calculatorapp.components.Viewfinder;
import com.example.calculatorapp.domains.calculator.CalculatorCharacters;
import com.example.calculatorapp.view_models.CalculatorViewModel;

public class MainActivityOnClickListenerEventHandler implements View.OnClickListener {
    private final CalculatorViewModel calculatorViewModel;
    private final Viewfinder viewfinder;
    private final Context context;

    public MainActivityOnClickListenerEventHandler(CalculatorViewModel calculatorViewModel, Viewfinder viewfinder, Context context) {
        this.calculatorViewModel = calculatorViewModel;
        this.viewfinder = viewfinder;
        this.context = context;
    }

    @Override
    public void onClick(View view) {
        if (isViewCleanButton(view)) {
            calculatorViewModel.clean(context);
        } else if (isViewDivisionButton(view)) {
            calculatorViewModel.addCharacter(CalculatorCharacters.DIVISION, context);
        } else if (isViewMultiplicationButton(view)) {
            calculatorViewModel.addCharacter(CalculatorCharacters.MULTIPLICATION, context);
        } else if (isViewBackspaceButton(view)) {
            calculatorViewModel.backspace(context);
        } else if (isViewSevenButton(view)) {
            calculatorViewModel.addCharacter(CalculatorCharacters.SEVEN, context);
        } else if (isViewEightButton(view)) {
            calculatorViewModel.addCharacter(CalculatorCharacters.EIGHT, context);
        } else if (isViewNineButton(view)) {
            calculatorViewModel.addCharacter(CalculatorCharacters.NINE, context);
        } else if (isViewSubtractionButton(view)) {
            calculatorViewModel.addCharacter(CalculatorCharacters.SUBTRACTION, context);
        } else if (isViewFourButton(view)) {
            calculatorViewModel.addCharacter(CalculatorCharacters.FOUR, context);
        } else if (isViewFiveButton(view)) {
            calculatorViewModel.addCharacter(CalculatorCharacters.FIVE, context);
        } else if (isViewSixButton(view)) {
            calculatorViewModel.addCharacter(CalculatorCharacters.SIX, context);
        } else if (isViewAdditionButton(view)) {
            calculatorViewModel.addCharacter(CalculatorCharacters.ADDITION, context);
        } else if (isViewOneButton(view)) {
            calculatorViewModel.addCharacter(CalculatorCharacters.ONE, context);
        } else if (isViewTwoButton(view)) {
            calculatorViewModel.addCharacter(CalculatorCharacters.TWO, context);
        } else if (isViewThreeButton(view)) {
            calculatorViewModel.addCharacter(CalculatorCharacters.THREE, context);
        } else if (isViewZeroButton(view)) {
            calculatorViewModel.addCharacter(CalculatorCharacters.ZERO, context);
        } else if (isViewPointButton(view)) {
            calculatorViewModel.addCharacter(CalculatorCharacters.POINT, context);
        } else if (isViewEvaluationButton(view)) {
            calculatorViewModel.evaluate(context);
        }

        viewfinder.scrollToTheEnd();
    }
}
