package com.example.calculatorapp.domains.calculator;

public enum CalculatorCharacters {
    ZERO("0"),

    ONE("1"),

    TWO("2"),

    THREE("3"),

    FOUR("4"),

    FIVE("5"),

    SIX("6"),

    SEVEN("7"),

    EIGHT("8"),

    NINE("9"),

    ADDITION("+"),

    SUBTRACTION("-"),

    DIVISION("/"),

    MULTIPLICATION("*"),

    POINT(".");

    public final String value;

    CalculatorCharacters(String value) {
        this.value = value;
    }
}
