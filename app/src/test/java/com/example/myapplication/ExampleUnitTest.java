package com.example.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    CreateActivity createActivity = new CreateActivity();
    @Test
    public void triangleTestEquilateral() { assertEquals(createActivity.triangle(1,1,1),CreateActivity.EQUILATERAL);}

    @Test
    public void triangleTestScalene() { assertEquals(createActivity.triangle(2,3,4),CreateActivity.SCALENE);}

    @Test
    public void triangleTestIsoseles() { assertEquals(createActivity.triangle(2,2,3),CreateActivity.ISOSELES);}

    @Test
    public void triangleTestInvalid() { assertEquals(createActivity.triangle(-1,1,1),CreateActivity.INVALID);}

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
}