package com.example.bmicalculator;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.*;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void BMIvalues() {
        onView(withId(R.id.weightInput)).perform(typeText("65"), closeSoftKeyboard());
        onView(withId(R.id.heightInput)).perform(typeText("170"), closeSoftKeyboard());

        try { Thread.sleep(500); } catch (InterruptedException e) {}

        onView(withId(R.id.resultText))
                .check(matches(withText(org.hamcrest.Matchers.containsString("BMI:"))));
    }
}