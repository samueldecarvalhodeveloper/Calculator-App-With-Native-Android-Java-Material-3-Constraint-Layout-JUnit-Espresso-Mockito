package com.example.calculatorapp.unitaries.activity_events.main_activity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertNotEquals;

import android.widget.HorizontalScrollView;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.calculatorapp.R;
import com.example.calculatorapp.activities.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainActivityOnClickListenerEventHandlerTest {
    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void testIfMethodOnClickDispatchesOnButtonsAndUpdatesViewfinderValue() {
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
