package com.java.browsertesting.introduction;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class EdnueTest {

	public static void main(String[] args) throws InterruptedException {

//		Selenium Manager takes care of pointing to default driver
//		Manually pointing to a selective driver
//		System.setProperty("webdriver.chrome.driver", "C:\\BrowserDrivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

//		System.setProperty("webdriver.gecko.driver", "C:\\BrowserDrivers\\geckodriver.exe");
//		WebDriver driver = new FirefoxDriver();

//		System.setProperty("webdriver.edge.driver", "C:\\BrowserDrivers\\msedgedriver.exe");
//		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		// Navigate to Ednue
		driver.get("https://google.com/");

		// Validate the page title
		String title = driver.getTitle();
		System.out.println("Page Title: " + title);

		// Validate the current URL
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL: " + currentUrl);

		TimeUnit.SECONDS.sleep(2);

		driver.close();

		// Close the browser
		if (driver != null) {
			driver.quit();
		}
	}
}
