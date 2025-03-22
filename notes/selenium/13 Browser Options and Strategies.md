## ✅ 1. HTTPS Certificate Handling

### 🔎 Topic Explanation:
Some testing environments use **self-signed or invalid SSL certificates**, which modern browsers block. To bypass this in Selenium, you can **instruct the browser to accept insecure certificates**.

### ✅ Java Code:
```java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HTTPSCertificateHandling {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);  // Accept untrusted certificates

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://self-signed.badssl.com/");
        System.out.println("Page title: " + driver.getTitle());
        driver.quit();
    }
}
```

### 💡 Code Explanation:
- `setAcceptInsecureCerts(true)`: Tells the browser to ignore invalid SSL certificates.
- The test opens a site with a self-signed certificate.
  
### 📘 Output:
```
Page title: self-signed.badssl.com
```

---

## ✅ 2. Proxy Settings, Plugins, Cookies

---

### 🔎 a. Proxy Settings

**Explanation**: Proxy is useful for **intercepting requests**, **location testing**, or **bypassing firewalls**.

### ✅ Java Code:
```java
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ProxySettings {
    public static void main(String[] args) {
        Proxy proxy = new Proxy();
        proxy.setHttpProxy("localhost:8080");

        ChromeOptions options = new ChromeOptions();
        options.setProxy(proxy);

        WebDriver driver = new ChromeDriver(options);
        driver.get("http://example.com");
        driver.quit();
    }
}
```

### 💡 Code Explanation:
- A proxy is configured using `Proxy` class.
- It is injected into the ChromeOptions to launch browser with it.

---

### 🔎 b. Plugins / Extensions

**Explanation**: You can load `.crx` extension files into the browser for testing **ad blockers**, **SEO tools**, etc.

### ✅ Java Code:
```java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;

public class AddExtensionExample {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("path/to/extension.crx"));

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com");
        driver.quit();
    }
}
```

### 💡 Code Explanation:
- `addExtensions(File)`: Loads the `.crx` plugin into Chrome.
- Used for simulating users with browser add-ons.

---

### 🔎 c. Cookies

**Explanation**: Cookies store login states or preferences. Useful for **session handling** or bypassing login UI in tests.

### ✅ Java Code:
```java
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookieManagement {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com");

        Cookie cookie = new Cookie("testCookie", "12345");
        driver.manage().addCookie(cookie);

        System.out.println("All cookies: " + driver.manage().getCookies());
        driver.quit();
    }
}
```

### 💡 Code Explanation:
- Adds a custom cookie named `testCookie` with a value `12345`.
- Useful for restoring a session without login.

---

## ✅ 3. Managing Browser Options & Capabilities

### 🔎 Topic Explanation:
Browser options are used to control the browser's behavior — like disabling popups, starting maximized, or enabling headless mode.

### ✅ Java Code:
```java
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserOptionsCapabilities {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-popup-blocking");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://example.com");
        driver.quit();
    }
}
```

### 💡 Code Explanation:
- `--start-maximized`: Opens browser in full screen.
- `--disable-popup-blocking`: Ensures popups won’t be blocked.
- `excludeSwitches`: Removes “Chrome is being controlled” banner.

---

## ✅ 4. Handling Popups & Alerts

### 🔎 Topic Explanation:
JavaScript alerts (like `alert()`, `confirm()`, `prompt()`) need to be handled using the `Alert` interface in Selenium.

### ✅ Java Code:
```java
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

public class HandleAlerts {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
        Alert alert = driver.switchTo().alert();

        System.out.println("Alert Text: " + alert.getText());
        alert.accept();  // Accept or use alert.dismiss()

        driver.quit();
    }
}
```

### 💡 Code Explanation:
- `switchTo().alert()` switches context to the active alert box.
- `alert.getText()` fetches message, `accept()` clicks "OK".

### 📘 Output:
```
Alert Text: I am a JS Alert
```

---

## ✅ 5. Automating Broken Links Verification

### 🔎 Topic Explanation:
This strategy finds all `<a>` tags and validates their `href` links using **HTTP response codes**.

### ✅ Java Code:
```java
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLinksCheck {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com");

        List<WebElement> links = driver.findElements(By.tagName("a"));

        for (WebElement link : links) {
            String url = link.getAttribute("href");
            try {
                HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
                conn.setRequestMethod("HEAD");
                conn.connect();
                int code = conn.getResponseCode();
                System.out.println(url + " --> " + code);
            } catch (Exception e) {
                System.out.println(url + " --> Broken or Malformed Link");
            }
        }
        driver.quit();
    }
}
```

### 💡 Code Explanation:
- Extracts all anchor tags and checks each link.
- Sends `HEAD` requests to reduce response size.

### 📘 Output:
```
https://example.com/contact --> 200  
https://example.com/dead-link --> 404
```

---

## ✅ 6. Checking HTTP Response Codes

### 🔎 Topic Explanation:
Validate whether a website or API is reachable and working by checking the HTTP status codes programmatically.

### ✅ Java Code:
```java
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPResponseChecker {
    public static void main(String[] args) {
        String url = "https://www.google.com";

        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int code = conn.getResponseCode();
            System.out.println("Response Code: " + code);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

### 💡 Code Explanation:
- Opens an HTTP connection and prints the response code.
- Helps check whether a site is up (`200`), down (`404`), or forbidden (`403`).

### 📘 Output:
```
Response Code: 200
```

---

## ✅ 7. Taking Screenshots for Test Evidence

### 🔎 Topic Explanation:
Taking screenshots is essential for **reporting**, **debugging**, and **proof of execution** in automation testing.

### ✅ Java Code:
```java
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.nio.file.Files;

public class ScreenshotCapture {
    public static void main(String[] args) throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.get("https://example.com");

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Files.copy(screenshot.toPath(), new File("screenshot.png").toPath());

        System.out.println("Screenshot saved as screenshot.png");
        driver.quit();
    }
}
```

### 💡 Code Explanation:
- Casts `WebDriver` to `TakesScreenshot`.
- Captures and saves the screenshot to a PNG file.

### 📘 Output:
```
Screenshot saved as screenshot.png
```

---
