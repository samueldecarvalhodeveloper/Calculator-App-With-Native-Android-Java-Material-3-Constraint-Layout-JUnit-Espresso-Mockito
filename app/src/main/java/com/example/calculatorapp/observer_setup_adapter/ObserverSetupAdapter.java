package com.example.calculatorapp.observer_setup_adapter;

import android.content.Context;

import androidx.lifecycle.LifecycleOwner;

import com.example.calculatorapp.components.Viewfinder;
import com.example.calculatorapp.view_models.CalculatorViewModel;

public class ObserverSetupAdapter {
    public static void setupViewfinderValueObserver(Viewfinder viewfinderView,
                                                    CalculatorViewModel calculatorViewModel,
                                                    Context context,
                                                    LifecycleOwner lifecycleOwner
    ) {

        calculatorViewModel.getCalculationExpression(context).observe(lifecycleOwner,
                viewfinderView::setViewfinderValue);
    }
}
