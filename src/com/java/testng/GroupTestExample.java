package com.java.testng;

import org.testng.annotations.Test;

public class GroupTestExample {

    @Test(groups = "smoke")
    public void smokeTest() {
        System.out.println("Smoke Test");
    }

    @Test(groups = "regression")
    public void regressionTest() {
    	System.out.println("Regression Test");
    }

    @Test(groups = {"smoke", "regression"})
    public void commonTest() {
        System.out.println("Common Test");
    }
}
