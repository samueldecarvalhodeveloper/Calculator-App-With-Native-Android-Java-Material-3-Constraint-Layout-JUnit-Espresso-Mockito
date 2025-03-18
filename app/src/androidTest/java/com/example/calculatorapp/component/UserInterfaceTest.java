package com.example.calculatorapp.component;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import android.content.Context;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.calculatorapp.R;
import com.example.calculatorapp.activities.MainActivity;
import com.example.calculatorapp.domains.calculator.CalculatorCharacters;
import com.example.calculatorapp.user_interface_theme_store.UserInterfaceThemeStore;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class UserInterfaceTest {
    private final Context curretActivityContext = ApplicationProvider.getApplicationContext();

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void beforeEach() {
        activityRule.getScenario().onActivity(
                activity -> activity.findViewById(R.id.clean_button).performClick()
        );
    }

    @Test
    public void testIfCalculationIsExecutedAndStoredInKeyValueDatabaseOnUserInterface() {
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.addition_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.evaluation_button)).perform(click());

        activityRule.getScenario().onActivity(activity -> {
            String currentViewfinderValue =
                    ((TextView) activity.findViewById(R.id.viewfinder_value_textview))
                            .getText()
                            .toString();
            String evaluatedViewfinderValue = CalculatorCharacters.TWO.value;

            assertEquals(evaluatedViewfinderValue, currentViewfinderValue);
        });
    }

    @Test
    public void testIfToggleThemeIsExecutedOnAndStoredInKeyValueDatabaseOnUserInterface() {
        onView(withId(R.id.toggle_night_mode_menu_item)).perform(click());

        int currentUserInterfaceMode = AppCompatDelegate.getDefaultNightMode();

        boolean storedUserInterfaceThemeState =
                UserInterfaceThemeStore.isNightModeEnabled(curretActivityContext);

        assertEquals(AppCompatDelegate.MODE_NIGHT_YES, currentUserInterfaceMode);

        assertTrue(storedUserInterfaceThemeState);

        onView(withId(R.id.toggle_night_mode_menu_item)).perform(click());
    }
}
