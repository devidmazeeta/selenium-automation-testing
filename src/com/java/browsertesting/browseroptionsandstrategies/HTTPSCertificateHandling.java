package com.java.browsertesting.browseroptionsandstrategies;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HTTPSCertificateHandling {
	public static void main(String[] args) {
		ChromeOptions options = new ChromeOptions();
		options.setAcceptInsecureCerts(true); // Accept untrusted certificates

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://self-signed.badssl.com/");
		System.out.println("Page title: " + driver.getTitle());
		driver.quit();
	}
}
