package com.example.calculatorapp.unitaries.activity_events.main_activity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.calculatorapp.R;
import com.example.calculatorapp.activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityOnMenuItemClickEventHandlerTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testIfMethodOnMenuItemClickDispatchesActionBarToggleNightModeAction() {
        onView(withId(R.id.toggle_night_mode_menu_item)).perform(click());

        int currentUserInterfaceMode = AppCompatDelegate.getDefaultNightMode();

        assertEquals(AppCompatDelegate.MODE_NIGHT_YES, currentUserInterfaceMode);

        onView(withId(R.id.toggle_night_mode_menu_item)).perform(click());
    }
}
