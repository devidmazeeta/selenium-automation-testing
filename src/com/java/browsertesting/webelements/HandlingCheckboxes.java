package com.java.browsertesting.webelements;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingCheckboxes {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://demoqa.com/checkbox");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebElement checkBox = driver.findElement(By.cssSelector("span.rct-checkbox"));

		// Checking and Selecting a Checkbox
		if (!checkBox.isSelected()) {
			checkBox.click();
		}

		TimeUnit time = TimeUnit.SECONDS;
		time.sleep(5);

		driver.quit();
	}
}
