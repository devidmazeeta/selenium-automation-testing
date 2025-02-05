package com.browser.testing;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locators {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// Navigate to Instagram
		driver.get("https://www.instagram.com/");

		// Wait for 5 seconds to load the page
		// driver.manage().wait(5000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Find username & password input fields and enter the values
		driver.findElement(By.name("username")).sendKeys("testingcourse19");
		driver.findElement(By.name("password")).sendKeys("incorrectpassword");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// CSS Selector Locator
		/*
		 * WebElement loginButton = driver.findElement(By.linkText("Log in")); // no
		 * such element: Unable to locate element: {"method":"link text","selector":"Log
		 * in"}
		 */
		WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
		loginButton.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\"loginForm\"]/span/div"));

		String errMsg = errorMsg.getText();
		System.out.println(errMsg);

		driver.close();
		driver.quit();

	}

}
