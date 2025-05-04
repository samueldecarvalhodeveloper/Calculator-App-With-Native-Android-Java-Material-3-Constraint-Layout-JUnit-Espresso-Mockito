package com.example.calculatorapp.unitaries.components;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static com.example.calculatorapp.constants.domains.CalculatorConstants.SIMPLE_CALCULATION_EXPRESSION;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import android.widget.HorizontalScrollView;
import android.widget.TextView;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.calculatorapp.R;
import com.example.calculatorapp.activities.MainActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ViewfinderTest {
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
    public void testIfMethodSetViewfinderValueUpdatesViewfinderValueTextviewText() {
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.addition_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());

        activityRule.getScenario().onActivity(activity -> {
            String currentViewfinderValue =
                    ((TextView) activity.findViewById(R.id.viewfinder_value_textview))
                            .getText()
                            .toString();

            assertEquals(SIMPLE_CALCULATION_EXPRESSION, currentViewfinderValue);
        });
    }

    @Test
    public void testIfMethodScrollToTheEndScrollsViewfinderValueHorizontalScrollViewToTheEnd() {
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());

        activityRule.getScenario().onActivity(activity -> {
            HorizontalScrollView viewfinderValueHorizontalScrollView = activity.findViewById(R.id.viewfinder_value_scrollview);

            int viewfinderValueHorizontalScrollviewScrollX = viewfinderValueHorizontalScrollView.getScrollX();

            assertNotEquals(
                    0,
                    viewfinderValueHorizontalScrollviewScrollX
            );
        });
    }
}
