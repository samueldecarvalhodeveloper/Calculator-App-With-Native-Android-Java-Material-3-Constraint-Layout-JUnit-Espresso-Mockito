package com.example.calculatorapp.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.ViewModelProvider;

import com.example.calculatorapp.databinding.ActivityMainBinding;
import com.example.calculatorapp.activity_events.main_activity.MainActivityOnClickListenerEventHandler;
import com.example.calculatorapp.activity_events.main_activity.MainActivityOnMenuItemClickEventHandler;
import com.example.calculatorapp.observer_setup_adapter.ObserverSetupAdapter;
import com.example.calculatorapp.user_interface_theme_state_adapter.UserInterfaceThemeStateAdapter;
import com.example.calculatorapp.view_models.CalculatorViewModel;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        ConstraintLayout rootLayout = binding.getRoot();

        setContentView(rootLayout);

        UserInterfaceThemeStateAdapter.setInitialAppTheme(this);

        CalculatorViewModel calculatorViewModel = new ViewModelProvider(this).get(CalculatorViewModel.class);

        MainActivityOnMenuItemClickEventHandler onMenuItemClickEventHandler =
                new MainActivityOnMenuItemClickEventHandler(this);
        MainActivityOnClickListenerEventHandler mainActivityOnClickListenerEventHandler =
                new MainActivityOnClickListenerEventHandler(calculatorViewModel, binding.viewfinder, getApplicationContext());

        binding.toolbar.setOnMenuItemClickListener(onMenuItemClickEventHandler);

        ObserverSetupAdapter.setupViewfinderValueObserver(binding.viewfinder,
                calculatorViewModel,
                this,
                this
        );

        binding.cleanButton.setOnClickListener(mainActivityOnClickListenerEventHandler);
        binding.divisionButton.setOnClickListener(mainActivityOnClickListenerEventHandler);
        binding.multiplicationButton.setOnClickListener(mainActivityOnClickListenerEventHandler);
        binding.backspaceButton.setOnClickListener(mainActivityOnClickListenerEventHandler);
        binding.sevenButton.setOnClickListener(mainActivityOnClickListenerEventHandler);
        binding.eightButton.setOnClickListener(mainActivityOnClickListenerEventHandler);
        binding.nineButton.setOnClickListener(mainActivityOnClickListenerEventHandler);
        binding.subtractionButton.setOnClickListener(mainActivityOnClickListenerEventHandler);
        binding.fourButton.setOnClickListener(mainActivityOnClickListenerEventHandler);
        binding.fiveButton.setOnClickListener(mainActivityOnClickListenerEventHandler);
        binding.sixButton.setOnClickListener(mainActivityOnClickListenerEventHandler);
        binding.additionButton.setOnClickListener(mainActivityOnClickListenerEventHandler);
        binding.oneButton.setOnClickListener(mainActivityOnClickListenerEventHandler);
        binding.twoButton.setOnClickListener(mainActivityOnClickListenerEventHandler);
        binding.threeButton.setOnClickListener(mainActivityOnClickListenerEventHandler);
        binding.zeroButton.setOnClickListener(mainActivityOnClickListenerEventHandler);
        binding.pointButton.setOnClickListener(mainActivityOnClickListenerEventHandler);
        binding.evaluationButton.setOnClickListener(mainActivityOnClickListenerEventHandler);
    }
}
