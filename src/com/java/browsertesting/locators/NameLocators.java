package com.java.browsertesting.locators;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;

public class NameLocators {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navigate to Instagram
		driver.get("https://www.instagram.com/");

		// Test Negative Case
		while (true) {
			try {
				// Find username & password input fields and enter the values
				driver.findElement(By.name("username")).sendKeys("testingcourse19");
				driver.findElement(By.name("password")).sendKeys("incorrectpassword");

				// CSS Selector Locator
				// driver.findElement(By.cssSelector("button[type='submit']")).click();
				WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
				loginButton.click();

				break;
			} catch (Exception e) {
				TimeUnit.SECONDS.sleep(1);
				System.out.println("Retrying!");
			}
		}

		TimeUnit.SECONDS.sleep(2);

		// Test Positive Case
		while (true) {
			try {
				// Clear password input field and re enter the value
				WebElement password = driver.findElement(By.name("password"));
				password.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
				password.sendKeys("correctpassword");

				// CSS Selector Locator
				// driver.findElement(By.cssSelector("button[type='submit']")).click();
				WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
				loginButton.click();

				break;
			} catch (Exception e) {
				TimeUnit.SECONDS.sleep(1);
				System.out.println("Retrying!");
			}
		}

		TimeUnit.SECONDS.sleep(5);

		driver.close();
		driver.quit();

	}

}
