package com.browser.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EdnueTest {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navigate to Ednue
		driver.get("https://ednue.com");

		// Validate the page title
		String title = driver.getTitle();
		System.out.println("Page Title: " + title);

		// Validate the current URL
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL: " + currentUrl);

		// Close the browser
		if (driver != null) {
			driver.quit();
		}
	}

	
	
}
