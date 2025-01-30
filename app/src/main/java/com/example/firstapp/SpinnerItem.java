package com.example.firstapp;

public class SpinnerItem {
    private String displayText;
    private int value;

    public SpinnerItem(String displayText, int value) {
        this.displayText = displayText;
        this.value = value;
    }

    public String getDisplayText() {
        return displayText;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        // This is what will be displayed in the spinner
        return displayText;
    }
}
