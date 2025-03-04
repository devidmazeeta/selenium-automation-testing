package com.java.browsertesting.webelements;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandlingDropdowns {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.facebook.com/r.php/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		WebElement dropdown = driver.findElement(By.id("day"));

		// Selecting an Option from a Dropdown
		Select select = new Select(dropdown);
		select.selectByVisibleText("22");		// Select by visible text
//		select.selectByIndex(5);				// Select by index
//		select.selectByValue("20");				// Select by value

		TimeUnit time = TimeUnit.SECONDS;
		time.sleep(5);

		driver.quit();
	}
}
