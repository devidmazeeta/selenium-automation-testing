package com.java.browsertesting.browseroptionsandstrategies;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.StandardCopyOption;

import java.io.File;
import java.nio.file.Files;

public class ScreenshotCapture {
	public static void main(String[] args) throws Exception {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--disable-popup-blocking");
		options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://ednue.com/course");

		// Take a screenshot and store it in a temporary file
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		// Define the destination path where the screenshot should be saved
		File destinationFile = new File("../selenium-automation-testing/output/screenshot.png");

		// Copy the screenshot file to the destination using NIO
		Files.copy(screenshotFile.toPath(), destinationFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

		System.out.println("Screenshot saved as screenshot.png");
		driver.quit();
	}
}
