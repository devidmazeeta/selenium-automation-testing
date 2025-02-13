package com.java.browsertesting.projects;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectTextFromPageSource {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://ednue.com/course");

		List<WebElement> titlesElement = driver.findElements(By.xpath("//div[@class='content']/h6/a"));

		File file = new File("../selenium-automation-testing/src/com/java/browsertesting/projects/output/SelectTextFromPageSource.txt");
		String filePath = file.getAbsolutePath();

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

			for (Iterator<WebElement> iterator = titlesElement.iterator(); iterator.hasNext();) {
				WebElement webElement = (WebElement) iterator.next();

				String courseTitle = webElement.getText();
				System.out.println(courseTitle);
				writer.write(courseTitle);
				writer.newLine();
			}

			writer.close();
		} catch (IOException e) {
			System.err.println("Error writing to file: " + e.getMessage());
		}

		driver.close();
		driver.quit();
	}

}
