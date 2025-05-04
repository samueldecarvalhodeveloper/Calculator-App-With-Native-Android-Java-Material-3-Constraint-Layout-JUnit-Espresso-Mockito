package com.example.calculatorapp.integrations;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;

import android.widget.TextView;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import com.example.calculatorapp.R;
import com.example.calculatorapp.activities.MainActivity;
import com.example.calculatorapp.domains.calculator.CalculatorCharacters;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class UserInterfaceExecutingCalculationExpressionTest {
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
    public void testIfCalculationExpressionIsExecutedOnUserInterface() {
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
