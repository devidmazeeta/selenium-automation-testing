package com.java.browsertesting.frames;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class IFramesDragAndDrop {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();

        driver.get("https://jqueryui.com/droppable/");

        // Switching to iframe (if drag and drop is inside an iframe)
        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));

        // Locate draggable element
        WebElement source = driver.findElement(By.id("draggable"));

        // Locate droppable element
        WebElement target = driver.findElement(By.id("droppable"));

        // Performing Drag and Drop action
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source, target).build().perform();

        // Verification
        String textAfterDrop = target.getText();
        if (textAfterDrop.contains("Dropped!")) {
            System.out.println("Drag and Drop Successful!");
        } else {
            System.out.println("Drag and Drop Failed!");
        }

        driver.quit();
    }
}