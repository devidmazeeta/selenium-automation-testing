package com.java.browsertesting.browseroptionsandstrategies;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.By;

public class HandlingPopupsAndAlerts {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-popup-blocking");
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");

		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
		Alert alert = driver.switchTo().alert();

		System.out.println("Alert Text: " + alert.getText());
		alert.accept(); // Accept or use alert.dismiss()

		Thread.sleep(3000);

		driver.quit();
	}
}
