package com.example.calculatorapp.infrastructure.anticorruption_layer;

import static com.example.calculatorapp.constants.ApplicationConstants.APPLICATION_KEY_VALUE_DATABASE_NAME;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isKeyWithinMap;

import android.content.Context;

import com.example.calculatorapp.infrastructure.exceptions.NotExistingKeyException;

import java.util.Map;

public class KeyValueDatabase {
    private KeyValueDatabase() {
    }

    public static <T> T getValue(String key, Context context) throws NotExistingKeyException {
        Map<String, ?> allStoredValue = context.getSharedPreferences(APPLICATION_KEY_VALUE_DATABASE_NAME, Context.MODE_PRIVATE)
                .getAll();

        if (isKeyWithinMap(key, allStoredValue)) {
            return (T) allStoredValue.get(key);
        } else {
            throw new NotExistingKeyException(key);
        }
    }

    public static void setValue(String key, String value, Context context) {
        context.getSharedPreferences(APPLICATION_KEY_VALUE_DATABASE_NAME, Context.MODE_PRIVATE)
                .edit()
                .putString(key, value)
                .apply();
    }

    public static void setValue(String key, Boolean value, Context context) {
        context.getSharedPreferences(APPLICATION_KEY_VALUE_DATABASE_NAME, Context.MODE_PRIVATE)
                .edit()
                .putBoolean(key, value)
                .apply();
    }
}
