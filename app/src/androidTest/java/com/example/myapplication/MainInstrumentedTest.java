package com.example.myapplication;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;

import org.junit.Test;
import org.junit.Rule;
import org.junit.runner.RunWith;

import android.support.test.runner.AndroidJUnit4;
import android.support.v7.view.menu.ActionMenuItem;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withResourceName;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainInstrumentedTest {
    TriangleTest triangleTest = new TriangleTest();

    @Rule
    public ActivityTestRule<MainActivity> activityRule
            = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void triangleTesting_sameActivity() {
        logoutTest_sameActivity();
        triangleTest.changeTriangleText_sameActivity();
    }

    @Test
    public void logoutTest_sameActivity() {
        loginTest_sameActivity();
        //(withId(R.id.action_logout)).perform(click());
        onView(withId(R.id.toolbar));
        onData(allOf(is(instanceOf(ActionMenuItem.class)),hasItem(onView(withId(R.id.action_logout)))));
        onView(withId(R.id.goHome)).perform(click());
    }

    @Test
    public void loginTest_sameActivity() {
        onView(withId(R.id.calculateBtn)).perform(click());
        onView(withId(R.id.firstNameTxt))
                .check((matches(withText(LoggedInUser.getInstance().getFirstName()))));
    }
}
