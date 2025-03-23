package com.java.browsertesting.ajax;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HandlingAjaxElements {
	public static void main(String Args[]) {
		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://www.qatarairways.com/app/booking/flight-selection?widget=QR&searchType=F&addTaxToFare=Y&minPurTime=0&selLang=en&tripType=R&fromStation=MAA&toStation=DXB&departing=2025-04-16&returning=2025-04-17&bookingClass=E&adults=1&children=0&infants=0&ofw=0&teenager=0&flexibleDate=off");

		// Wait for the AJAX-loaded content to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement ajaxElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[contains(text(), \"results\")]")));

		System.out.println("Loaded content: " + ajaxElement.getText());
		
		driver.quit();
	}
}
