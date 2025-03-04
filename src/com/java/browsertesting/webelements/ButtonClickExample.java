package com.java.browsertesting.webelements;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ButtonClickExample {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\training\\other\\browser_drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.instagram.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Typing Text into an Input Field
		driver.findElement(By.name("username")).sendKeys("TestingUserName");
		driver.findElement(By.name("password")).sendKeys("TestingPassword");

		WebElement button = driver.findElement(By.cssSelector("button[type='submit']"));

		// Clicking an Element
		button.click();

		driver.quit();
	}
}
