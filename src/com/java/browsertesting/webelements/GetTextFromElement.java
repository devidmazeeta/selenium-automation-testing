package com.java.browsertesting.webelements;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetTextFromElement {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\training\\other\\browser_drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.instagram.com/");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebElement button = driver.findElement(By.cssSelector("button[type='button']"));

		// Extracting Text from a Web Element
		System.out.println(button.getText());

		driver.quit();
	}
}
