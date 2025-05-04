package com.example.calculatorapp.activity_events.main_activity;

import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isMenuItemIdEqualToToggleNightModeMenuItem;

import android.content.Context;
import android.view.MenuItem;

import androidx.appcompat.widget.Toolbar;

import com.example.calculatorapp.user_interface_theme_state_adapter.UserInterfaceThemeStateAdapter;

public class MainActivityOnMenuItemClickEventHandler implements Toolbar.OnMenuItemClickListener {
    private final Context context;

    public MainActivityOnMenuItemClickEventHandler(Context context) {
        this.context = context;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        if (isMenuItemIdEqualToToggleNightModeMenuItem(item)) {
            UserInterfaceThemeStateAdapter.toggleTheme(context);
        }

        return true;
    }
}
