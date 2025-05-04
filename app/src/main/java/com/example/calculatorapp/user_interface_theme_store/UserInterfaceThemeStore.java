package com.example.calculatorapp.user_interface_theme_store;

import static com.example.calculatorapp.constants.UserInterfaceConstants.THEME_KEY;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isDeviceInNightMode;

import android.content.Context;

import com.example.calculatorapp.infrastructure.anticorruption_layer.KeyValueDatabase;
import com.example.calculatorapp.infrastructure.exceptions.NotExistingKeyException;

public class UserInterfaceThemeStore {
    private UserInterfaceThemeStore() {
    }

    public static boolean isNightModeEnabled(Context context) {
        try {
            return KeyValueDatabase.getValue(THEME_KEY, context);
        } catch (NotExistingKeyException exception) {
            return isDeviceInNightMode(context);
        }
    }

    public static void setIsNightModeEnabled(boolean state, Context context) {
        KeyValueDatabase.setValue(THEME_KEY, state, context);
    }
}
