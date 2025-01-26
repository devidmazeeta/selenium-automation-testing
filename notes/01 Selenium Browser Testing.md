
# Selenium Browser Testing with Java

## **1. Importance of WebDriver in Selenium**

Selenium WebDriver is a powerful automation framework that allows users to interact with web browsers programmatically. It is essential for building end-to-end test cases for web applications. Key benefits include:

- **Cross-Browser Compatibility**: WebDriver supports major browsers like Chrome, Firefox, Edge, and Safari.
- **Dynamic Content Handling**: It can handle JavaScript-heavy applications.
- **Native Interaction**: WebDriver directly interacts with browser elements, offering efficient automation.
- **Multi-Language Support**: You can write tests in Java, Python, C#, and other languages.

---

## **2. Setting Up the Environment**

### **Step 1: Install JDK 21 (LTS)**
1. Download JDK 21 from the [Oracle website](https://www.oracle.com/java/technologies/javase-downloads.html).
2. Install the JDK and set up environment variables:
   - **JAVA_HOME**: Point to the JDK installation directory.
   - Add `JAVA_HOME/bin` to the system `PATH`.

Verify the installation:
```bash
java -version
```
Expected output: `java version "21"`

---

### **Step 2: Install Eclipse IDE**
1. Download the **Eclipse IDE for Java Developers** from the [official Eclipse website](https://www.eclipse.org/downloads/).
2. Install and launch Eclipse.

---

### **Step 3: Create a Java Project**
1. Open Eclipse.
2. Create a new Java project:
   - Go to **File > New > Java Project**.
   - Enter the project name, e.g., `SeleniumBrowserTesting`.

---

### **Step 4: Convert to Maven Project**
1. Right-click on the project in the **Package Explorer**.
2. Select **Configure > Convert to Maven Project**.
3. Update the `pom.xml` file to include Selenium and TestNG dependencies.

---

## **3. Add Maven Dependencies**
Add the following dependencies to the `pom.xml` file for Selenium, TestNG, and WebDriverManager:

```xml
<dependencies>
    <!-- Selenium Java Dependency -->
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.15.0</version>
    </dependency>

    <!-- TestNG Dependency -->
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.8.0</version>
        <scope>test</scope>
    </dependency>

    <!-- WebDriverManager for Automatic Driver Management -->
    <dependency>
        <groupId>io.github.bonigarcia</groupId>
        <artifactId>webdrivermanager</artifactId>
        <version>5.5.1</version>
    </dependency>
</dependencies>
```

---

## **4. Browser Testing Using WebDriver**

### **Code Example: Testing Google Homepage**
Here’s a sample test case for launching Chrome, navigating to Google, and validating the title.

```java
package com.browser.testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GoogleTest {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        // Automatically manage the ChromeDriver
        WebDriverManager.chromedriver().setup();
        
        // Initialize the WebDriver
        driver = new ChromeDriver();
        
        // Maximize the browser window
        driver.manage().window().maximize();
    }

    @Test
    public void testGoogleHomePage() {
        // Navigate to Google
        driver.get("https://www.google.com");
        
        // Validate the page title
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);
        assert title.contains("Google") : "Test Failed: Title does not contain 'Google'";
        
        // Validate the current URL
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);
        assert currentUrl.equals("https://www.google.com/") : "Test Failed: URL does not match.";
    }

    @AfterClass
    public void teardown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}
```

---

## **5. Output**

When you run the test:
- **Console Output**:
  ```
  Page Title: Google
  Current URL: https://www.google.com/
  ```
- If the test passes:
  ```
  Test passed successfully.
  ```
- If the test fails (e.g., due to incorrect title or URL):
  ```
  java.lang.AssertionError: Test Failed: Title does not contain 'Google'
  ```

- **Browser Activity**:
  1. Chrome will launch.
  2. Navigate to `https://www.google.com`.
  3. The test will validate the title and URL, then close the browser.

---

## **6. Configuring TestNG Reports**

### **Step 1: Create TestNG XML**
1. Create a `testng.xml` file in the project root directory.
2. Add the following configuration:

```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="Selenium Test Suite">
    <test name="Google Page Test">
        <classes>
            <class name="com.browser.testing.GoogleTest" />
        </classes>
    </test>
</suite>
```

### **Step 2: Run the Test Suite**
1. Right-click on the `testng.xml` file.
2. Select **Run As > TestNG Suite**.

### **Step 3: View the Report**
1. After execution, navigate to the `test-output` folder in the project directory.
2. Open `index.html` in a browser.
3. The report will display:
   - **Passed/Failed Tests**.
   - **Execution Time**.
   - **Error Messages** for failures.

---

## **7. Additional Validations**
Enhance the test case with more validations:
1. **Check the Search Bar Presence**:
   ```java
   WebElement searchBar = driver.findElement(By.name("q"));
   assert searchBar.isDisplayed() : "Test Failed: Search bar is not visible.";
   ```
2. **Search for a Term**:
   ```java
   searchBar.sendKeys("Selenium WebDriver");
   searchBar.submit();
   ```

---

## **Conclusion**

This document provided a step-by-step guide for setting up Selenium with Java for browser testing. It included:
- JDK 21 installation and setup.
- Maven configuration.
- Writing and executing a test using TestNG and WebDriver.
- Generating TestNG reports for detailed test results.


