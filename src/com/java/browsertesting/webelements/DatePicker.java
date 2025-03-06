package com.java.browsertesting.webelements;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.irctc.co.in/nget/train-search");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//		 Method 1
//		driver.findElement(By.id("jDate")).click();
//
//		driver.findElement(By.xpath("//td/a[contains(text(), '20')]")).click();

//		 Method 2
		WebElement dateElement = driver.findElement(By.xpath("//p-calendar/span/input"));
		dateElement.click();
		dateElement.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
		dateElement.sendKeys("20/03/2025");
		dateElement.sendKeys(Keys.chord(Keys.ENTER));

		TimeUnit time = TimeUnit.SECONDS;
		time.sleep(5);

		driver.quit();
	}

}
