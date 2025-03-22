package com.java.browsertesting.iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class IFrameDragAndDrop {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.get("https://jqueryui.com/droppable/");

		// driver.findElement(By.id("draggable")); // This line throws an error.
		// Because, this element is inside the iframe.

		// Switching to iframe (if drag and drop is inside an iframe)
		// Method 1
		driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[class='demo-frame']")));

		// Method 2
		// System.out.println(driver.findElements(By.tagName("iframe")).size());
		// driver.switchTo().frame(0);

		// Method 3
		// Switching to iframe by Name or ID
		// driver.switchTo().frame("iframe_name"); // This will throw an error. Because,
		// the page used here doesn't have a frame name or id

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

		// Thread.sleep(5000);

		// Switching back to the main content
		driver.switchTo().defaultContent();

		driver.quit();
	}
}
