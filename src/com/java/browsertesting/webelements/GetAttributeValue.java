package com.java.browsertesting.webelements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetAttributeValue {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\training\\other\\browser_drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.instagram.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		WebElement inputField = driver.findElement(By.name("username"));

		// Getting an Attribute Value
		// System.out.println(inputField.getAttribute("aria-label")); // Use of getAttribute() is deprecated
		System.out.println(inputField.getDomAttribute("aria-label"));

		driver.quit();
	}
}
