package com.java.browsertesting.functionaltesting;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ecommerce {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://thethriftkart.com/search");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebElement searchBoxElement = driver.findElement(By.id("Search-In-Template"));
		searchBoxElement.sendKeys("Tshirt");

//		searchBoxElement.sendKeys(Keys.chord(Keys.ENTER));
		driver.findElement(By.xpath("//form/div/button[@type='submit']")).click();

		List<WebElement> productsElements = driver.findElements(By.className("full-unstyled-link"));

		for (WebElement productsElement : productsElements) {
			String productName = productsElement.getText();
			System.out.println(productName);

			if (productName.contains("Zara Orange Rugged")) {
				productsElement.click();
				break;
			}
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		WebElement addToCartElement = driver.findElement(By.xpath("//div[@class='product-form__buttons']/button"));
		addToCartElement.submit();

		TimeUnit time = TimeUnit.SECONDS;
		time.sleep(2);

		WebElement checkoutButton = driver.findElement(By.xpath("//button[@name='checkout']"));
		checkoutButton.submit();

		time.sleep(5);

		driver.quit();
	}

}
