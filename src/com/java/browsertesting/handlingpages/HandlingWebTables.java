package com.java.browsertesting.handlingpages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingWebTables {
	public static void main(String Args[]) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");

		WebElement table = driver.findElement(By.id("customers"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));

		for (WebElement row : rows) {
			List<WebElement> cols = row.findElements(By.tagName("td"));

			for (WebElement cell : cols) {
				System.out.print(cell.getText() + " | ");
			}

			System.out.println();
		}

		driver.quit();
	}
}
