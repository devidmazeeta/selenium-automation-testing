package com.java.browsertesting.webelements;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingRadioButtons {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://demowebshop.tricentis.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		WebElement radioButton = driver.findElement(By.id("pollanswers-3"));

		// Selecting a Radio Button
		radioButton.click();

		TimeUnit time = TimeUnit.SECONDS;
		time.sleep(5);

		driver.quit();
	}
}
