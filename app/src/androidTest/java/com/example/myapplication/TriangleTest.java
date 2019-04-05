package com.example.myapplication;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.is;

public class TriangleTest {
    private int length1 = 3;
    private int length2 = 4;
    private int length3 = 5;
    private int length4 = -1;

    @Rule
    public ActivityTestRule<MainActivity> activityRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void triangleEquilateral_sameActivity() {
        loginTest_sameActivity();
        onView(withId(R.id.length1)).perform(typeText(String.valueOf(length1)),closeSoftKeyboard());
        onView(withId(R.id.length2)).perform(typeText(String.valueOf(length1)),closeSoftKeyboard());
        onView(withId(R.id.length3)).perform(typeText(String.valueOf(length1)),closeSoftKeyboard());
        onView(withId(R.id.calculateBtn)).perform(click());
        onView(withId(R.id.triangleTxt))
                .check(matches(withText("Equilateral")));
    }

    @Test
    public void triangleIsoseles_sameActivity() {
        loginTest_sameActivity();
        onView(withId(R.id.length1)).perform(typeText(String.valueOf(length1)),closeSoftKeyboard());
        onView(withId(R.id.length2)).perform(typeText(String.valueOf(length1)),closeSoftKeyboard());
        onView(withId(R.id.length3)).perform(typeText(String.valueOf(length2)),closeSoftKeyboard());
        onView(withId(R.id.calculateBtn)).perform(click());
        onView(withId(R.id.triangleTxt))
                .check(matches(withText("Isoseles")));
    }

    @Test
    public void triangleScalene_sameActivity() {
        loginTest_sameActivity();
        onView(withId(R.id.length1)).perform(typeText(String.valueOf(length1)),closeSoftKeyboard());
        onView(withId(R.id.length2)).perform(typeText(String.valueOf(length2)),closeSoftKeyboard());
        onView(withId(R.id.length3)).perform(typeText(String.valueOf(length3)),closeSoftKeyboard());
        onView(withId(R.id.calculateBtn)).perform(click());
        onView(withId(R.id.triangleTxt))
                .check(matches(withText("Scalene")));
    }

    @Test
    public void triangleInvalid_sameActivity() {
        loginTest_sameActivity();
        onView(withId(R.id.length1)).perform(typeText(String.valueOf(length4)),closeSoftKeyboard());
        onView(withId(R.id.length2)).perform(typeText(String.valueOf(length4)),closeSoftKeyboard());
        onView(withId(R.id.length3)).perform(typeText(String.valueOf(length4)),closeSoftKeyboard());
        onView(withId(R.id.calculateBtn)).perform(click());
        onView(withId(R.id.triangleTxt))
                .check(matches(withText("Invalid")));
    }

    @Test
    public void changeTriangleText_sameActivity() {
        triangleInvalid_sameActivity();
        onView(withId(R.id.length1)).perform(replaceText(String.valueOf(length1)));
        onView(withId(R.id.length2)).perform(replaceText(String.valueOf(length1)));
        onView(withId(R.id.length3)).perform(replaceText(String.valueOf(length1)));
        onView(withId(R.id.calculateBtn)).perform(click());
        onView(withId(R.id.triangleTxt))
                .check(matches(withText("Equilateral")));
    }

    @Test
    public void loginTest_sameActivity() {
        onView(withId(R.id.createUserBtn)).perform(click());
        onView(withId(R.id.calculateBtn))
                .check((matches(withText("Calculate"))));
    }
}
