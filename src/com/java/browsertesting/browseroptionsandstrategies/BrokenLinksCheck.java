package com.java.browsertesting.browseroptionsandstrategies;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.List;

public class BrokenLinksCheck {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://ednue.com/blog");

		List<WebElement> links = driver.findElements(By.tagName("a"));

		for (WebElement link : links) {
			String urlString = link.getDomAttribute("href");

			try {
				URI uri = URI.create(urlString);
				URL url = uri.toURL(); // Safe conversion

				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("HEAD");
				conn.setInstanceFollowRedirects(true);
				conn.connect();

				int code = conn.getResponseCode();
				System.out.println(url + " --> " + code);
			} catch (Exception e) {
				System.out.println(urlString + " --> Broken or Malformed Link");
			}
		}
		driver.quit();
	}
}
