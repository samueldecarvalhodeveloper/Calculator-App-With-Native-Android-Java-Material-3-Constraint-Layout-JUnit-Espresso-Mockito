package com.example.calculatorapp.unitaries.activities;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static com.example.calculatorapp.constants.domains.CalculatorConstants.SIMPLE_CALCULATION_EXPRESSION;
import static org.junit.Assert.assertEquals;

import android.content.Context;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.calculatorapp.R;
import com.example.calculatorapp.activities.MainActivity;
import com.example.calculatorapp.domains.calculator.CalculatorCharacters;
import com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications;
import com.example.calculatorapp.user_interface_theme_store.UserInterfaceThemeStore;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ActivityMainTest {
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
    public void testIfInitialThemeIsRetrievedFromThemeStoreAndConfiguredOnTheUserInterface() {
        boolean storedUiMode = UserInterfaceThemeStore.isNightModeEnabled(curretActivityContext);
        boolean currentUiMode = UserInterfaceSpecifications.isUserInterfaceInNightMode();

        assertEquals(currentUiMode, storedUiMode);
    }

    @Test
    public void testIfMenuItemClickMethodOnViewModelDispatchesTheToggleModeItemAndChangeApplicationMode() {
        onView(withId(R.id.toggle_night_mode_menu_item)).perform(click());
        
        int currentUserInterfaceMode = AppCompatDelegate.getDefaultNightMode();

        assertEquals(AppCompatDelegate.MODE_NIGHT_YES, currentUserInterfaceMode);

        onView(withId(R.id.toggle_night_mode_menu_item)).perform(click());
    }

    @Test
    public void testIfViewfinderIsObservingCalculatorViewmodelCalculationExpression() {
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
    public void testIfCleanButtonWhenClickedDispatchesClearCalculationExpressionMethodOnViewModel() {
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.clean_button)).perform(click());

        activityRule.getScenario().onActivity(activity -> {
            String currentViewfinderValue =
                    ((TextView) activity.findViewById(R.id.viewfinder_value_textview))
                            .getText()
                            .toString();

            assertEquals("", currentViewfinderValue);
        });
    }

    @Test
    public void testIfDivisionButtonWhenClickedDispatchesAddCharacterMethodOnViewModelAndAddsTheDivisionCharacterToCalculationExpression() {
        onView(withId(R.id.division_button)).perform(click());

        activityRule.getScenario().onActivity(activity -> {
            String currentViewfinderValue =
                    ((TextView) activity.findViewById(R.id.viewfinder_value_textview))
                            .getText()
                            .toString();
            String characterOfClickedButton = CalculatorCharacters.DIVISION.value;

            assertEquals(characterOfClickedButton, currentViewfinderValue);
        });
    }

    @Test
    public void testIfMultiplicationButtonWhenClickedDispatchesAddCharacterMethodOnViewModelAndAddsTheMultiplicationCharacterToCalculationExpression() {
        onView(withId(R.id.multiplication_button)).perform(click());

        activityRule.getScenario().onActivity(activity -> {
            String currentViewfinderValue =
                    ((TextView) activity.findViewById(R.id.viewfinder_value_textview))
                            .getText()
                            .toString();
            String characterOfClickedButton = CalculatorCharacters.MULTIPLICATION.value;

            assertEquals(characterOfClickedButton, currentViewfinderValue);
        });
    }

    @Test
    public void testIfBackspaceBackspaceWhenClickedDispatchesBackspaceMethodOnViewModelAndRemovesLastCharacterFromCalculationExpression() {
        onView(withId(R.id.one_button)).perform(click());
        onView(withId(R.id.backspace_button)).perform(click());

        activityRule.getScenario().onActivity(activity -> {
            String currentViewfinderValue =
                    ((TextView) activity.findViewById(R.id.viewfinder_value_textview))
                            .getText()
                            .toString();

            assertEquals("", currentViewfinderValue);
        });
    }

    @Test
    public void testIfSevenButtonWhenClickedDispatchesAddCharacterMethodOnViewModelAndAddsTheSevenCharacterToCalculationExpression() {
        onView(withId(R.id.seven_button)).perform(click());

        activityRule.getScenario().onActivity(activity -> {
            String currentViewfinderValue =
                    ((TextView) activity.findViewById(R.id.viewfinder_value_textview))
                            .getText()
                            .toString();
            String characterOfClickedButton = CalculatorCharacters.SEVEN.value;

            assertEquals(characterOfClickedButton, currentViewfinderValue);
        });
    }

    @Test
    public void testIfEightButtonWhenClickedDispatchesAddCharacterMethodOnViewModelAndAddsTheEightCharacterToCalculationExpression() {
        onView(withId(R.id.eight_button)).perform(click());

        activityRule.getScenario().onActivity(activity -> {
            String currentViewfinderValue =
                    ((TextView) activity.findViewById(R.id.viewfinder_value_textview))
                            .getText()
                            .toString();
            String characterOfClickedButton = CalculatorCharacters.EIGHT.value;

            assertEquals(characterOfClickedButton, currentViewfinderValue);
        });
    }

    @Test
    public void testIfNineButtonWhenClickedDispatchesAddCharacterMethodOnViewModelAndAddsTheNineCharacterToCalculationExpression() {
        onView(withId(R.id.nine_button)).perform(click());

        activityRule.getScenario().onActivity(activity -> {
            String currentViewfinderValue =
                    ((TextView) activity.findViewById(R.id.viewfinder_value_textview))
                            .getText()
                            .toString();
            String characterOfClickedButton = CalculatorCharacters.NINE.value;

            assertEquals(characterOfClickedButton, currentViewfinderValue);
        });
    }

    @Test
    public void testIfSubtractionButtonWhenClickedDispatchesAddCharacterMethodOnViewModelAndAddsTheSubtractionCharacterToCalculationExpression() {
        onView(withId(R.id.subtraction_button)).perform(click());

        activityRule.getScenario().onActivity(activity -> {
            String currentViewfinderValue =
                    ((TextView) activity.findViewById(R.id.viewfinder_value_textview))
                            .getText()
                            .toString();
            String characterOfClickedButton = CalculatorCharacters.SUBTRACTION.value;

            assertEquals(characterOfClickedButton, currentViewfinderValue);
        });
    }

    @Test
    public void testIfFourButtonWhenClickedDispatchesAddCharacterMethodOnViewModelAndAddsTheFourCharacterToCalculationExpression() {
        onView(withId(R.id.four_button)).perform(click());

        activityRule.getScenario().onActivity(activity -> {
            String currentViewfinderValue =
                    ((TextView) activity.findViewById(R.id.viewfinder_value_textview))
                            .getText()
                            .toString();
            String characterOfClickedButton = CalculatorCharacters.FOUR.value;

            assertEquals(characterOfClickedButton, currentViewfinderValue);
        });
    }

    @Test
    public void testIfFiveButtonWhenClickedDispatchesAddCharacterMethodOnViewModelAndAddsTheFiveCharacterToCalculationExpression() {
        onView(withId(R.id.five_button)).perform(click());

        activityRule.getScenario().onActivity(activity -> {
            String currentViewfinderValue =
                    ((TextView) activity.findViewById(R.id.viewfinder_value_textview))
                            .getText()
                            .toString();
            String characterOfClickedButton = CalculatorCharacters.FIVE.value;

            assertEquals(characterOfClickedButton, currentViewfinderValue);
        });
    }

    @Test
    public void testIfSixButtonWhenClickedDispatchesAddCharacterMethodOnViewModelAndAddsTheSixCharacterToCalculationExpression() {
        onView(withId(R.id.six_button)).perform(click());

        activityRule.getScenario().onActivity(activity -> {
            String currentViewfinderValue =
                    ((TextView) activity.findViewById(R.id.viewfinder_value_textview))
                            .getText()
                            .toString();
            String characterOfClickedButton = CalculatorCharacters.SIX.value;

            assertEquals(characterOfClickedButton, currentViewfinderValue);
        });
    }

    @Test
    public void testIfAdditionButtonWhenClickedDispatchesAddCharacterMethodOnViewModelAndAddsTheAdditionCharacterToCalculationExpression() {
        onView(withId(R.id.addition_button)).perform(click());

        activityRule.getScenario().onActivity(activity -> {
            String currentViewfinderValue =
                    ((TextView) activity.findViewById(R.id.viewfinder_value_textview))
                            .getText()
                            .toString();
            String characterOfClickedButton = CalculatorCharacters.ADDITION.value;

            assertEquals(characterOfClickedButton, currentViewfinderValue);
        });
    }

    @Test
    public void testIfOneButtonWhenClickedDispatchesAddCharacterMethodOnViewModelAndAddsTheOneCharacterToCalculationExpression() {
        onView(withId(R.id.one_button)).perform(click());

        activityRule.getScenario().onActivity(activity -> {
            String currentViewfinderValue =
                    ((TextView) activity.findViewById(R.id.viewfinder_value_textview))
                            .getText()
                            .toString();
            String characterOfClickedButton = CalculatorCharacters.ONE.value;

            assertEquals(characterOfClickedButton, currentViewfinderValue);
        });
    }

    @Test
    public void testIfTwoButtonWhenClickedDispatchesAddCharacterMethodOnViewModelAndAddsTheTwoCharacterToCalculationExpression() {
        onView(withId(R.id.two_button)).perform(click());

        activityRule.getScenario().onActivity(activity -> {
            String currentViewfinderValue =
                    ((TextView) activity.findViewById(R.id.viewfinder_value_textview))
                            .getText()
                            .toString();
            String characterOfClickedButton = CalculatorCharacters.TWO.value;

            assertEquals(characterOfClickedButton, currentViewfinderValue);
        });
    }

    @Test
    public void testIfThreeButtonWhenClickedDispatchesAddCharacterMethodOnViewModelAndAddsTheThreeCharacterToCalculationExpression() {
        onView(withId(R.id.three_button)).perform(click());

        activityRule.getScenario().onActivity(activity -> {
            String currentViewfinderValue =
                    ((TextView) activity.findViewById(R.id.viewfinder_value_textview))
                            .getText()
                            .toString();
            String characterOfClickedButton = CalculatorCharacters.THREE.value;

            assertEquals(characterOfClickedButton, currentViewfinderValue);
        });
    }

    @Test
    public void testIfZeroButtonWhenClickedDispatchesAddCharacterMethodOnViewModelAndAddsTheZeroCharacterToCalculationExpression() {
        onView(withId(R.id.zero_button)).perform(click());

        activityRule.getScenario().onActivity(activity -> {
            String currentViewfinderValue =
                    ((TextView) activity.findViewById(R.id.viewfinder_value_textview))
                            .getText()
                            .toString();
            String characterOfClickedButton = CalculatorCharacters.ZERO.value;

            assertEquals(characterOfClickedButton, currentViewfinderValue);
        });
    }

    @Test
    public void testIfPointButtonWhenClickedDispatchesAddCharacterMethodOnViewModelAndAddsThePointCharacterToCalculationExpression() {
        onView(withId(R.id.point_button)).perform(click());

        activityRule.getScenario().onActivity(activity -> {
            String currentViewfinderValue =
                    ((TextView) activity.findViewById(R.id.viewfinder_value_textview))
                            .getText()
                            .toString();
            String characterOfClickedButton = CalculatorCharacters.POINT.value;

            assertEquals(characterOfClickedButton, currentViewfinderValue);
        });
    }

    @Test
    public void testIfEvaluationButtonWhenClickedDispatchesEvaluateMethodOnViewModelAndEvaluatesCalculationExpression() {
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
