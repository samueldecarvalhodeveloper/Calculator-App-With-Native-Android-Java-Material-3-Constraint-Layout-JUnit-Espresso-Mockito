package com.example.calculatorapp.unitaries.infrastructure.specifications;

import static com.example.calculatorapp.constants.UserInterfaceConstants.ANY_VIEW_ID;
import static com.example.calculatorapp.constants.UserInterfaceConstants.LAST_SESSION_CALCULATION_EXPRESSION_KEY;
import static com.example.calculatorapp.constants.domains.CalculatorConstants.SIMPLE_CALCULATION_EXPRESSION;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isDeviceInNightMode;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isKeyWithinMap;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isMenuItemIdEqualToToggleNightModeMenuItem;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isUserInterfaceInNightMode;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isViewAdditionButton;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isViewBackspaceButton;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isViewCleanButton;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isViewDivisionButton;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isViewEightButton;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isViewEvaluationButton;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isViewFiveButton;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isViewFourButton;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isViewMultiplicationButton;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isViewNineButton;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isViewOneButton;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isViewPointButton;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isViewSevenButton;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isViewSixButton;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isViewSubtractionButton;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isViewThreeButton;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isViewTwoButton;
import static com.example.calculatorapp.infrastructure.specifications.UserInterfaceSpecifications.isViewZeroButton;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatDelegate;

import com.example.calculatorapp.R;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class UserInterfaceSpecificationsTest {
    private static final Map<String, Object> map = new HashMap<>();
    private static Context context;
    private static View view;

    @BeforeClass
    public static void beforeAll() {
        map.put(LAST_SESSION_CALCULATION_EXPRESSION_KEY, SIMPLE_CALCULATION_EXPRESSION);
        context = mock(Context.class);
        view = mock(View.class);

        Resources resources = mock(Resources.class);

        when(context.getResources()).thenReturn(resources);
    }

    @Test
    public void testIfMethodIsKeyWithinMapReturnsTrueIfKeyIsContainerInMap() {
        boolean keyContainedInMap = isKeyWithinMap(LAST_SESSION_CALCULATION_EXPRESSION_KEY, map);
        boolean keyNotContainedInMap = isKeyWithinMap("", map);

        assertTrue(keyContainedInMap);
        assertFalse(keyNotContainedInMap);
    }

    @Test
    public void testIfMethodIsUserInterfaceInNightModeReturnsTrueIfUserInterfaceIsNightMode() {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);

        boolean userInterfaceIsInNightMode = isUserInterfaceInNightMode();

        assertTrue(userInterfaceIsInNightMode);

        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        boolean userInterfaceIsNotInNightMode = isUserInterfaceInNightMode();

        assertFalse(userInterfaceIsNotInNightMode);
    }

    @Test
    public void testIfMethodIsMenuItemIdEqualToToggleNightModeMenuItemReturnsTrueIfMenuItemIdIsEqualToToggleNightModeMenuItem() throws Exception {
        MenuItem menuItem = mock(MenuItem.class);

        when(menuItem.getItemId()).thenReturn(R.id.toggle_night_mode_menu_item);

        boolean itemIsEqualToNightModeMenuItem = isMenuItemIdEqualToToggleNightModeMenuItem(menuItem);

        assertTrue(itemIsEqualToNightModeMenuItem);

        when(menuItem.getItemId()).thenReturn(ANY_VIEW_ID);

        boolean itemIsNotEqualToNightModeMenuItem = isMenuItemIdEqualToToggleNightModeMenuItem(menuItem);

        assertFalse(itemIsNotEqualToNightModeMenuItem);
    }

    @Test
    public void testIfMethodIsDeviceInNightModeReturnsTrueIfDeviceIsNightMode() {
        Resources resources = mock(Resources.class);
        Configuration configuration = mock(Configuration.class);

        when(context.getResources()).thenReturn(resources);
        when(resources.getConfiguration()).thenReturn(configuration);

        configuration.uiMode = Configuration.UI_MODE_NIGHT_YES;

        boolean deviceIsInNightMode = isDeviceInNightMode(context);

        assertTrue(deviceIsInNightMode);

        configuration.uiMode = Configuration.UI_MODE_NIGHT_NO;

        boolean deviceIsNotInNightMode = isDeviceInNightMode(context);

        assertFalse(deviceIsNotInNightMode);
    }

    @Test
    public void testIfMethodIsViewCleanButtonReturnsTrueIfViewHasIdEqualsToCleanButtonId() {
        when(view.getId()).thenReturn(R.id.clean_button);

        boolean viewIdIsEqualCleanButton = isViewCleanButton(view);

        assertTrue(viewIdIsEqualCleanButton);

        when(view.getId()).thenReturn(R.id.viewfinder);

        boolean viewIdIsEqualNotCleanButton = isViewCleanButton(view);

        assertFalse(viewIdIsEqualNotCleanButton);
    }

    @Test
    public void testIfMethodIsViewDivisionButtonReturnsTrueIfViewHasIdEqualsToDivisionButtonId() {
        when(view.getId()).thenReturn(R.id.division_button);

        boolean viewIdIsEqualDivisionButton = isViewDivisionButton(view);

        assertTrue(viewIdIsEqualDivisionButton);

        when(view.getId()).thenReturn(R.id.viewfinder);

        boolean viewIdIsEqualNotDivisionButton = isViewDivisionButton(view);

        assertFalse(viewIdIsEqualNotDivisionButton);
    }

    @Test
    public void testIfMethodIsViewMultiplicationButtonReturnsTrueIfViewHasIdEqualsToMultiplicationButtonId() {
        when(view.getId()).thenReturn(R.id.multiplication_button);

        boolean viewIdIsEqualMultiplicationButton = isViewMultiplicationButton(view);

        assertTrue(viewIdIsEqualMultiplicationButton);

        when(view.getId()).thenReturn(R.id.viewfinder);

        boolean viewIdIsEqualNotMultiplicationButton = isViewMultiplicationButton(view);

        assertFalse(viewIdIsEqualNotMultiplicationButton);
    }

    @Test
    public void testIfMethodIsViewBackspaceButtonReturnsTrueIfViewHasIdEqualsToBackspaceButtonId() {
        when(view.getId()).thenReturn(R.id.backspace_button);

        boolean viewIdIsEqualBackspaceButton = isViewBackspaceButton(view);

        assertTrue(viewIdIsEqualBackspaceButton);

        when(view.getId()).thenReturn(R.id.viewfinder);

        boolean viewIdIsEqualNotBackspaceButton = isViewBackspaceButton(view);

        assertFalse(viewIdIsEqualNotBackspaceButton);
    }

    @Test
    public void testIfMethodIsViewSevenButtonReturnsTrueIfViewHasIdEqualsToSevenButtonId() {
        when(view.getId()).thenReturn(R.id.seven_button);

        boolean viewIdIsEqualSevenButton = isViewSevenButton(view);

        assertTrue(viewIdIsEqualSevenButton);

        when(view.getId()).thenReturn(R.id.viewfinder);

        boolean viewIdIsEqualNotSevenButton = isViewSevenButton(view);

        assertFalse(viewIdIsEqualNotSevenButton);
    }

    @Test
    public void testIfMethodIsViewEightButtonReturnsTrueIfViewHasIdEqualsToEightButtonId() {
        when(view.getId()).thenReturn(R.id.eight_button);

        boolean viewIdIsEqualEightButton = isViewEightButton(view);

        assertTrue(viewIdIsEqualEightButton);

        when(view.getId()).thenReturn(R.id.viewfinder);

        boolean viewIdIsEqualNotEightButton = isViewEightButton(view);

        assertFalse(viewIdIsEqualNotEightButton);
    }

    @Test
    public void testIfMethodIsViewNineButtonReturnsTrueIfViewHasIdEqualsToNineButtonId() {
        when(view.getId()).thenReturn(R.id.nine_button);

        boolean viewIdIsEqualNineButton = isViewNineButton(view);

        assertTrue(viewIdIsEqualNineButton);

        when(view.getId()).thenReturn(R.id.viewfinder);

        boolean viewIdIsEqualNotNineButton = isViewNineButton(view);

        assertFalse(viewIdIsEqualNotNineButton);
    }

    @Test
    public void testIfMethodIsViewSubtractionButtonReturnsTrueIfViewHasIdEqualsToSubtractionButtonId() {
        when(view.getId()).thenReturn(R.id.subtraction_button);

        boolean viewIdIsEqualSubtractionButton = isViewSubtractionButton(view);

        assertTrue(viewIdIsEqualSubtractionButton);

        when(view.getId()).thenReturn(R.id.viewfinder);

        boolean viewIdIsEqualNotSubtractionButton = isViewSubtractionButton(view);

        assertFalse(viewIdIsEqualNotSubtractionButton);
    }

    @Test
    public void testIfMethodIsViewFourButtonReturnsTrueIfViewHasIdEqualsToFourButtonId() {
        when(view.getId()).thenReturn(R.id.four_button);

        boolean viewIdIsEqualFourButton = isViewFourButton(view);

        assertTrue(viewIdIsEqualFourButton);

        when(view.getId()).thenReturn(R.id.viewfinder);

        boolean viewIdIsEqualNotFourButton = isViewFourButton(view);

        assertFalse(viewIdIsEqualNotFourButton);
    }

    @Test
    public void testIfMethodIsViewFiveButtonReturnsTrueIfViewHasIdEqualsToFiveButtonId() {
        when(view.getId()).thenReturn(R.id.five_button);

        boolean viewIdIsEqualFiveButton = isViewFiveButton(view);

        assertTrue(viewIdIsEqualFiveButton);

        when(view.getId()).thenReturn(R.id.viewfinder);

        boolean viewIdIsEqualNotFiveButton = isViewFiveButton(view);

        assertFalse(viewIdIsEqualNotFiveButton);
    }

    @Test
    public void testIfMethodIsViewSixButtonReturnsTrueIfViewHasIdEqualsToSixButtonId() {
        when(view.getId()).thenReturn(R.id.six_button);

        boolean viewIdIsEqualSixButton = isViewSixButton(view);

        assertTrue(viewIdIsEqualSixButton);

        when(view.getId()).thenReturn(R.id.viewfinder);

        boolean viewIdIsEqualNotSixButton = isViewSixButton(view);

        assertFalse(viewIdIsEqualNotSixButton);
    }

    @Test
    public void testIfMethodIsViewAdditionButtonReturnsTrueIfViewHasIdEqualsToAdditionButtonId() {
        when(view.getId()).thenReturn(R.id.addition_button);

        boolean viewIdIsEqualAdditionButton = isViewAdditionButton(view);

        assertTrue(viewIdIsEqualAdditionButton);

        when(view.getId()).thenReturn(R.id.viewfinder);

        boolean viewIdIsEqualNotAdditionButton = isViewAdditionButton(view);

        assertFalse(viewIdIsEqualNotAdditionButton);
    }

    @Test
    public void testIfMethodIsViewOneButtonReturnsTrueIfViewHasIdEqualsToOneButtonId() {
        when(view.getId()).thenReturn(R.id.one_button);

        boolean viewIdIsEqualOneButton = isViewOneButton(view);

        assertTrue(viewIdIsEqualOneButton);

        when(view.getId()).thenReturn(R.id.viewfinder);

        boolean viewIdIsEqualNotOneButton = isViewOneButton(view);

        assertFalse(viewIdIsEqualNotOneButton);
    }

    @Test
    public void testIfMethodIsViewTwoButtonReturnsTrueIfViewHasIdEqualsToTwoButtonId() {
        when(view.getId()).thenReturn(R.id.two_button);

        boolean viewIdIsEqualTwoButton = isViewTwoButton(view);

        assertTrue(viewIdIsEqualTwoButton);

        when(view.getId()).thenReturn(R.id.viewfinder);

        boolean viewIdIsEqualNotTwoButton = isViewTwoButton(view);

        assertFalse(viewIdIsEqualNotTwoButton);
    }

    @Test
    public void testIfMethodIsViewThreeButtonReturnsTrueIfViewHasIdEqualsToThreeButtonId() {
        when(view.getId()).thenReturn(R.id.three_button);

        boolean viewIdIsEqualThreeButton = isViewThreeButton(view);

        assertTrue(viewIdIsEqualThreeButton);

        when(view.getId()).thenReturn(R.id.viewfinder);

        boolean viewIdIsEqualNotThreeButton = isViewThreeButton(view);

        assertFalse(viewIdIsEqualNotThreeButton);
    }

    @Test
    public void testIfMethodIsViewZeroButtonReturnsTrueIfViewHasIdEqualsToZeroButtonId() {
        when(view.getId()).thenReturn(R.id.zero_button);

        boolean viewIdIsEqualZeroButton = isViewZeroButton(view);

        assertTrue(viewIdIsEqualZeroButton);

        when(view.getId()).thenReturn(R.id.viewfinder);

        boolean viewIdIsEqualNotZeroButton = isViewZeroButton(view);

        assertFalse(viewIdIsEqualNotZeroButton);
    }

    @Test
    public void testIfMethodIsViewPointButtonReturnsTrueIfViewHasIdEqualsToPointButtonId() {
        when(view.getId()).thenReturn(R.id.point_button);

        boolean viewIdIsEqualPointButton = isViewPointButton(view);

        assertTrue(viewIdIsEqualPointButton);

        when(view.getId()).thenReturn(R.id.viewfinder);

        boolean viewIdIsEqualNotPointButton = isViewPointButton(view);

        assertFalse(viewIdIsEqualNotPointButton);
    }

    @Test
    public void testIfMethodIsViewEvaluationButtonReturnsTrueIfViewHasIdEqualsToEvaluationButtonId() {
        when(view.getId()).thenReturn(R.id.evaluation_button);

        boolean viewIdIsEqualEvaluationButton = isViewEvaluationButton(view);

        assertTrue(viewIdIsEqualEvaluationButton);

        when(view.getId()).thenReturn(R.id.viewfinder);

        boolean viewIdIsEqualNotEvaluationButton = isViewEvaluationButton(view);

        assertFalse(viewIdIsEqualNotEvaluationButton);
    }
}
