package com.example.calculatorapp.unitaries.components;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;

import android.widget.TextView;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.calculatorapp.R;
import com.example.calculatorapp.activities.MainActivity;
import com.example.calculatorapp.domains.calculator.CalculatorCharacters;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ButtonTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testIfComponentIsRenderedOnMainActivityAndDispatchesClickEvent() {
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
}
