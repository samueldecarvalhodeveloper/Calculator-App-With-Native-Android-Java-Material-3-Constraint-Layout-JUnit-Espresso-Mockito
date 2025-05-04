package com.example.calculatorapp.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.calculatorapp.R;

public class Button extends FrameLayout {
    public Button(Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.button, this, true);
    }

    public Button(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.button, this, true);

        TypedArray arrayOfAttributes = context.obtainStyledAttributes(attrs, R.styleable.Button);
        String buttonCharacterAttributeValue = arrayOfAttributes.getString(R.styleable.Button_buttonCharacter);

        int buttonCharacterColorAttributeValue = arrayOfAttributes.getColor(R.styleable.Button_buttonCharacterColor, Color.TRANSPARENT);
        Drawable buttonBackgroundAttributeValue = arrayOfAttributes.getDrawable(R.styleable.Button_buttonBackground);

        TextView buttonCharacterView = findViewById(R.id.button_character);

        buttonCharacterView.setText(buttonCharacterAttributeValue);
        buttonCharacterView.setTextColor(buttonCharacterColorAttributeValue);

        this.setBackground(buttonBackgroundAttributeValue);

        this.setClickable(true);
    }

    public Button(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.button, this, true);

        TypedArray arrayOfAttributes = context.obtainStyledAttributes(attrs, R.styleable.Button);
        String buttonCharacterAttributeValue = arrayOfAttributes.getString(R.styleable.Button_buttonCharacter);

        int buttonCharacterColorAttributeValue = arrayOfAttributes.getColor(R.styleable.Button_buttonCharacterColor, Color.TRANSPARENT);
        Drawable buttonBackgroundAttributeValue = arrayOfAttributes.getDrawable(R.styleable.Button_buttonBackground);

        TextView buttonCharacterView = findViewById(R.id.button_character);

        buttonCharacterView.setText(buttonCharacterAttributeValue);
        buttonCharacterView.setTextColor(buttonCharacterColorAttributeValue);

        this.setBackground(buttonBackgroundAttributeValue);

        this.setClickable(true);
    }

    public Button(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        LayoutInflater.from(context).inflate(R.layout.button, this, true);

        TypedArray arrayOfAttributes = context.obtainStyledAttributes(attrs, R.styleable.Button);
        String buttonCharacterAttributeValue = arrayOfAttributes.getString(R.styleable.Button_buttonCharacter);

        int buttonCharacterColorAttributeValue = arrayOfAttributes.getColor(R.styleable.Button_buttonCharacterColor, Color.TRANSPARENT);
        Drawable buttonBackgroundAttributeValue = arrayOfAttributes.getDrawable(R.styleable.Button_buttonBackground);

        TextView buttonCharacterView = findViewById(R.id.button_character);

        buttonCharacterView.setText(buttonCharacterAttributeValue);
        buttonCharacterView.setTextColor(buttonCharacterColorAttributeValue);

        this.setBackground(buttonBackgroundAttributeValue);

        this.setClickable(true);
    }
}
