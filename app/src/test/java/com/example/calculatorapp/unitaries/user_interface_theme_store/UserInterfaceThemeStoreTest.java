package com.example.calculatorapp.unitaries.user_interface_theme_store;

import static com.example.calculatorapp.constants.ApplicationConstants.APPLICATION_KEY_VALUE_DATABASE_NAME;
import static com.example.calculatorapp.constants.UserInterfaceConstants.THEME_KEY;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.anyBoolean;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;

import com.example.calculatorapp.user_interface_theme_store.UserInterfaceThemeStore;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class UserInterfaceThemeStoreTest {
    public static Context context;
    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor sharedPreferencesEditor;
    public static Map emptyMap;
    public static Map mapWithTrueThemeState;

    @BeforeClass
    public static void beforeAll() {
        context = mock(Context.class);
        sharedPreferences = mock(SharedPreferences.class);
        sharedPreferencesEditor = mock(SharedPreferences.Editor.class);

        emptyMap = new HashMap();
        mapWithTrueThemeState = new HashMap<String, Object>();

        mapWithTrueThemeState.put(THEME_KEY, true);

        when(context.getSharedPreferences(APPLICATION_KEY_VALUE_DATABASE_NAME, Context.MODE_PRIVATE)).thenReturn(sharedPreferences);
        when(sharedPreferences.getAll()).thenReturn(mapWithTrueThemeState);
        when(sharedPreferences.edit()).thenReturn(sharedPreferencesEditor);
        when(sharedPreferences.edit().putBoolean(anyString(), anyBoolean())).thenReturn(sharedPreferencesEditor);

        Resources resources = mock(Resources.class);
        Configuration configuration = mock(Configuration.class);

        when(context.getResources()).thenReturn(resources);
        when(resources.getConfiguration()).thenReturn(configuration);

        configuration.uiMode = Configuration.UI_MODE_NIGHT_NO;
    }

    @Before
    public void beforeEach() {
        when(sharedPreferences.getAll()).thenReturn(mapWithTrueThemeState);
    }

    @Test
    public void testIfMethodIsNightModeThemeStateReturnsTheStoredEnabled() {
        boolean storedThemeState = UserInterfaceThemeStore.isNightModeEnabled(context);

        assertTrue(storedThemeState);
    }

    @Test
    public void testIfMethodIsNightModeThemeStateReturnsTheDeviceEnabledIsNotSet() {
        when(sharedPreferences.getAll()).thenReturn(emptyMap);

        boolean storedThemeState = UserInterfaceThemeStore.isNightModeEnabled(context);

        assertFalse(storedThemeState);
    }

    @Test
    public void testIfMethodSetIsNightModeEnabledToKeyValueDatabase() {
        UserInterfaceThemeStore.setIsNightModeEnabled(true, context);

        boolean storedThemeState = UserInterfaceThemeStore.isNightModeEnabled(context);

        assertTrue(storedThemeState);
    }
}