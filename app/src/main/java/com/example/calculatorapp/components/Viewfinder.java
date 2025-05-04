package com.example.calculatorapp.components;

import static com.example.calculatorapp.constants.UserInterfaceConstants.VIEWFINDER_SCROLL_TO_END_VALUE;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.calculatorapp.R;

public class Viewfinder extends FrameLayout {
    public Viewfinder(@NonNull Context context) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.viewfinder,
                this,
                true);
    }

    public Viewfinder(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.viewfinder,
                this,
                true);

        TypedArray arrayOfAttributes = context.obtainStyledAttributes(attrs,
                R.styleable.Viewfinder);
        String calculationExpressionAttributeValue = arrayOfAttributes.getString(
                R.styleable.Viewfinder_value
        );

        TextView viewfinderValueView = findViewById(R.id.viewfinder_value_textview);

        viewfinderValueView.setText(calculationExpressionAttributeValue);
    }

    public Viewfinder(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        LayoutInflater.from(context).inflate(R.layout.viewfinder,
                this,
                true);

        TypedArray arrayOfAttributes = context.obtainStyledAttributes(attrs,
                R.styleable.Viewfinder);
        String calculationExpressionAttributeValue = arrayOfAttributes.getString(
                R.styleable.Viewfinder_value
        );

        TextView viewfinderValueView = findViewById(R.id.viewfinder_value_textview);

        viewfinderValueView.setText(calculationExpressionAttributeValue);
    }

    public Viewfinder(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        LayoutInflater.from(context).inflate(R.layout.viewfinder,
                this,
                true);

        TypedArray arrayOfAttributes = context.obtainStyledAttributes(attrs,
                R.styleable.Viewfinder);
        String calculationExpressionAttributeValue = arrayOfAttributes.getString(
                R.styleable.Viewfinder_value
        );

        TextView viewfinderValueView = findViewById(R.id.viewfinder_value_textview);

        viewfinderValueView.setText(calculationExpressionAttributeValue);
    }

    public void setViewfinderValue(String viewfinderValueView) {
        TextView viewfinderValueTextView = findViewById(R.id.viewfinder_value_textview);

        viewfinderValueTextView.setText(viewfinderValueView);
    }

    public void scrollToTheEnd() {
        HorizontalScrollView viewfinderScrollView = findViewById(R.id.viewfinder_value_scrollview);
        TextView viewfinderValueTextView = findViewById(R.id.viewfinder_value_textview);

        int viewfinderValueTextWidth = viewfinderValueTextView.getWidth();

        viewfinderScrollView.setScrollX(VIEWFINDER_SCROLL_TO_END_VALUE(viewfinderValueTextWidth));
    }
}