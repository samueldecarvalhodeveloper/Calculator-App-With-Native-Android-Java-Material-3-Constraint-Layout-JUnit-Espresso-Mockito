package com.example.calculatorapp.user_interface_theme_state_adapter;

import static androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO;
import static androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES;

import android.content.Context;

import androidx.appcompat.app.AppCompatDelegate;

import com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications;
import com.example.calculatorapp.user_interface_theme_store.UserInterfaceThemeStore;

public class UserInterfaceThemeStateAdapter {
    private UserInterfaceThemeStateAdapter() {
    }

    public static void setInitialAppTheme(Context context) {
        boolean isUserInterfaceInNightMode = UserInterfaceThemeStore.isNightModeEnabled(context);

        if (isUserInterfaceInNightMode) {
            AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO);
        }
    }

    public static void toggleTheme(Context context) {
        if (UserInterfaceSpecifications.isUserInterfaceInNightMode()) {
            UserInterfaceThemeStore.setIsNightModeEnabled(false, context);

            AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO);
        } else {
            UserInterfaceThemeStore.setIsNightModeEnabled(true, context);

            AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES);
        }
    }
}
