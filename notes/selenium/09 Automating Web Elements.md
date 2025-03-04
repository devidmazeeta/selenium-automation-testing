# **Selenium WebDriver - Automating Web Elements**

Selenium WebDriver is widely used for automating web applications by interacting with web elements like buttons, input fields, forms, drop-downs, and dynamic elements. This guide covers various interactions with Selenium WebDriver using **Java**, along with detailed examples.

---

# **1. Basic Web Element Interaction**

Selenium provides methods to interact with web elements effectively.

## **1.1 Clicking an Element**
The `.click()` method is used to simulate a mouse click on elements like buttons, links, and checkboxes.

### **Example: Clicking a Button**
```java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClickExample {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com");

        WebElement button = driver.findElement(By.id("submitBtn"));
        button.click();

        driver.quit();
    }
}
```

---

## **1.2 Typing Text into an Input Field**
The `.sendKeys()` method is used to enter text into input fields.

### **Example: Entering Text into a Textbox**
```java
WebElement username = driver.findElement(By.name("username"));
username.sendKeys("testuser");
```

---

## **1.3 Getting Text from an Element**
The `.getText()` method is used to retrieve the visible text from elements like headings, paragraphs, and labels.

### **Example: Extracting Text from a Web Element**
```java
WebElement heading = driver.findElement(By.tagName("h1"));
System.out.println("Page Heading: " + heading.getText());
```

---

## **1.4 Getting an Attribute Value**
The `.getAttribute("attribute_name")` method is used to fetch the value of an attribute, such as `href`, `class`, or `value`.

### **Example: Retrieving a Link’s URL**
```java
WebElement link = driver.findElement(By.linkText("Click here"));
String url = link.getAttribute("href");
System.out.println("URL: " + url);
```

---

# **2. Handling Form Elements**
Forms include elements like radio buttons, checkboxes, and dropdown lists.

## **2.1 Handling Radio Buttons**
To select a radio button, use the `.click()` method.

### **Example: Selecting a Radio Button**
```java
WebElement maleRadio = driver.findElement(By.id("male"));
maleRadio.click();
```

---

## **2.2 Handling Checkboxes**
Before clicking a checkbox, use `.isSelected()` to check if it is already selected.

### **Example: Checking and Selecting a Checkbox**
```java
WebElement termsCheckbox = driver.findElement(By.id("agreeTerms"));
if (!termsCheckbox.isSelected()) {
    termsCheckbox.click();
}
```

---

## **2.3 Handling Dropdowns using the Select Class**
For `<select>` dropdowns, Selenium provides the `Select` class.

### **Example: Selecting an Option from a Dropdown**
```java
import org.openqa.selenium.support.ui.Select;

WebElement dropdown = driver.findElement(By.id("country"));
Select select = new Select(dropdown);
select.selectByVisibleText("India");  // Select by visible text
select.selectByIndex(2);              // Select by index
select.selectByValue("IN");           // Select by value
```

---

# **3. Handling Calendar in Selenium (Date Picker Automation)**

Calendars can be handled in different ways based on the design of the web application.

## **3.1 Selecting a Date from a Date Picker**
Many web applications use JavaScript-based calendars. You can interact with them using `.click()` or `.sendKeys()`.

### **Example: Clicking a Date from a Date Picker**
```java
WebElement dateField = driver.findElement(By.id("datePicker"));
dateField.click();

// Selecting a specific date (e.g., 15th of the current month)
WebElement date = driver.findElement(By.xpath("//td[@data-day='15']"));
date.click();
```

If the date picker allows manual input, you can send the date directly using `.sendKeys()`:

```java
dateField.sendKeys("2025-03-10");
dateField.sendKeys(Keys.ENTER);
```

---

# **4. Handling Dynamic Elements**
Dynamic elements change frequently, so static locators like `id` or `name` may not work reliably. XPath and explicit waits help handle them.

## **4.1 Using XPath with `contains()`**
The `contains()` function in XPath helps locate elements with dynamic attributes.

### **Example: Finding a Dynamic Button**
```java
WebElement dynamicElement = driver.findElement(By.xpath("//button[contains(text(), 'Start')]"));
dynamicElement.click();
```

---

## **4.2 Using Explicit Waits for Elements that Load Late**
Some elements take time to load. The `WebDriverWait` class helps handle them dynamically.

### **Example: Waiting for an Element to be Visible**
```java
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("dynamicElement")));
element.click();
```

---

# **5. Handling Alerts and Popups**
Many web applications display JavaScript alerts and popups.

## **5.1 Handling JavaScript Alerts**
### **Example: Accepting an Alert**
```java
import org.openqa.selenium.Alert;

Alert alert = driver.switchTo().alert();
System.out.println(alert.getText());  // Get alert message
alert.accept();  // Click OK
```

### **Example: Dismissing an Alert**
```java
alert.dismiss();  // Click Cancel
```

---

## **5.2 Handling Authentication Popups**
If a login popup appears in the browser, use a URL with credentials.

### **Example: Handling a Login Popup**
```java
driver.get("https://username:password@example.com");
```

---

# **6. Handling Frames and IFrames**
Some web applications use `<iframe>` tags. Selenium allows switching between them.

## **6.1 Switching to an IFrame**
### **Example: Handling an IFrame**
```java
driver.switchTo().frame("iframe_id");
WebElement insideFrame = driver.findElement(By.id("elementInsideFrame"));
insideFrame.click();
driver.switchTo().defaultContent();  // Switch back to main page
```

---

# **7. Handling Multiple Browser Windows**
When a link opens a new tab, Selenium can switch between windows.

## **7.1 Switching Between Windows**
### **Example: Handling Multiple Windows**
```java
String mainWindow = driver.getWindowHandle();
Set<String> allWindows = driver.getWindowHandles();

for (String window : allWindows) {
    if (!window.equals(mainWindow)) {
        driver.switchTo().window(window);
    }
}
```

---

# **Conclusion**
This guide covered essential Selenium WebDriver interactions, including:
✅ Clicking and typing into elements  
✅ Handling forms, radio buttons, checkboxes, and dropdowns  
✅ Automating date pickers  
✅ Handling dynamic elements using XPath and waits  
✅ Managing alerts, popups, and iFrames  
✅ Switching between browser windows  

---

