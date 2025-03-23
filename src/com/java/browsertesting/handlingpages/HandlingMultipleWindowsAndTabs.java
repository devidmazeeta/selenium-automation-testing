package com.java.browsertesting.handlingpages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingMultipleWindowsAndTabs {
	public static void main(String Args[]) {
		WebDriver driver = new ChromeDriver();
		driver.get(
				"https://in.search.yahoo.com/yhs/search?hspart=sz&hsimp=yhs-002&p=google+search&type=type80160-405445667&param1=1663736415");

		String mainWindow = driver.getWindowHandle();

		System.out.println(mainWindow);

		driver.findElement(By.linkText("google.com")).click(); // Opens a new window or tab

		Set<String> allWindows = driver.getWindowHandles();

		System.out.println(allWindows);

		for (String handle : allWindows) {
			if (!handle.equals(mainWindow)) {
				driver.switchTo().window(handle);
				System.out.println("Switched to new window: " + driver.getTitle());
				break;
			}
		}

		driver.quit();
	}
}
