package com.example.calculatorapp.infrastructure.specifications;

import android.content.Context;
import android.content.res.Configuration;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatDelegate;

import com.example.calculatorapp.R;

import java.util.Map;

public class UserInterfaceSpecifications {
    private UserInterfaceSpecifications() {
    }

    public static boolean isKeyWithinMap(String key, Map<String, ?> map) {
        return map.containsKey(key);
    }

    public static boolean isUserInterfaceInNightMode() {
        return AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES;
    }

    public static boolean isDeviceInNightMode(Context context) {
        return (context.getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES;
    }

    public static boolean isMenuItemIdEqualToToggleNightModeMenuItem(MenuItem item) {
        return item.getItemId() == R.id.toggle_night_mode_menu_item;
    }

    public static boolean isViewCleanButton(View view) {
        return view.getId() == R.id.clean_button;
    }

    public static boolean isViewDivisionButton(View view) {
        return view.getId() == R.id.division_button;
    }

    public static boolean isViewMultiplicationButton(View view) {
        return view.getId() == R.id.multiplication_button;
    }

    public static boolean isViewBackspaceButton(View view) {
        return view.getId() == R.id.backspace_button;
    }

    public static boolean isViewSevenButton(View view) {
        return view.getId() == R.id.seven_button;
    }

    public static boolean isViewEightButton(View view) {
        return view.getId() == R.id.eight_button;
    }

    public static boolean isViewNineButton(View view) {
        return view.getId() == R.id.nine_button;
    }

    public static boolean isViewSubtractionButton(View view) {
        return view.getId() == R.id.subtraction_button;
    }

    public static boolean isViewFourButton(View view) {
        return view.getId() == R.id.four_button;
    }

    public static boolean isViewFiveButton(View view) {
        return view.getId() == R.id.five_button;
    }

    public static boolean isViewSixButton(View view) {
        return view.getId() == R.id.six_button;
    }

    public static boolean isViewAdditionButton(View view) {
        return view.getId() == R.id.addition_button;
    }

    public static boolean isViewOneButton(View view) {
        return view.getId() == R.id.one_button;
    }

    public static boolean isViewTwoButton(View view) {
        return view.getId() == R.id.two_button;
    }

    public static boolean isViewThreeButton(View view) {
        return view.getId() == R.id.three_button;
    }

    public static boolean isViewZeroButton(View view) {
        return view.getId() == R.id.zero_button;
    }

    public static boolean isViewPointButton(View view) {
        return view.getId() == R.id.point_button;
    }

    public static boolean isViewEvaluationButton(View view) {
        return view.getId() == R.id.evaluation_button;
    }
}
