package com.java.testng;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAssertExample {
    @Test
    public void test() {
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(10, 5);
        sa.assertTrue(false);
        System.out.println("Soft assert: continues execution");
        sa.assertAll(); // Collects all failed assertions
    }
}
