package com.java.browsertesting.browseroptionsandstrategies;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookieManagement {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://ednue.com");

		System.out.println("All cookies: " + driver.manage().getCookies());

		Cookie cookie = new Cookie("testCookie", "12345");
		driver.manage().addCookie(cookie);

		System.out.println("All cookies: " + driver.manage().getCookies());
		driver.quit();
	}
}
