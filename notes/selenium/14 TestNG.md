## 🧪 **1. Introduction to TestNG**

### 🔹 **Definition**  
**TestNG** (Test Next Generation) is a **testing framework** for Java that simplifies writing and managing tests. It is inspired by JUnit and NUnit but offers advanced features like:

- Annotations
- Test configurations
- Grouping
- Data-driven testing
- Parallel execution
- Built-in reporting

### ✅ **Key Benefits**
- More flexible than JUnit
- Easily integrates with Selenium, Maven, Jenkins, etc.
- Supports functional, regression, and smoke testing

---

## ⚙️ **2. TestNG Installation Steps**

### 🔹 **Definition**  
Installing TestNG means setting up the library in your Java project using an IDE or build tool like Maven.

### ✅ **Step-by-Step Installation**

**Option A: In Eclipse**
1. Go to `Help > Eclipse Marketplace`
2. Search for “TestNG”
3. Install and restart Eclipse

**Option B: Using Maven**
Add this to your `pom.xml`:

```xml
<dependency>
  <groupId>org.testng</groupId>
  <artifactId>testng</artifactId>
  <version>7.9.0</version>
  <scope>test</scope>
</dependency>
```

**Option C: Manual JAR**
- Download from [https://testng.org](https://testng.org)
- Add to Build Path in your project

---

## 🔖 **3. TestNG Annotations**

### 🔹 **Definition**  
Annotations define **how and when** your test methods are executed. They help manage test lifecycle events like setup and teardown.

### ✅ **Common Annotations & Example**

| Annotation         | Purpose                        |
|--------------------|--------------------------------|
| `@BeforeSuite`     | Before all tests in the suite  |
| `@AfterSuite`      | After all tests in the suite   |
| `@BeforeClass`     | Before all methods in the class|
| `@AfterClass`      | After all methods in the class |
| `@BeforeMethod`    | Before each test method        |
| `@AfterMethod`     | After each test method         |
| `@Test`            | Marks a method as a test       |

### ✅ Java Code:
```java
import org.testng.annotations.*;

public class AnnotationExample {

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method");
    }

    @Test
    public void test1() {
        System.out.println("Test 1");
    }

    @Test
    public void test2() {
        System.out.println("Test 2");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class");
    }
}
```

### 🖨️ Output:
```
Before Class
Before Method
Test 1
After Method
Before Method
Test 2
After Method
After Class
```

### 🧠 Code Explanation:
- `@BeforeClass`: Runs once before any `@Test` method
- `@BeforeMethod`: Runs before each `@Test`
- `@Test`: Actual test logic
- `@AfterMethod`: Cleans up after each `@Test`
- `@AfterClass`: Runs once after all tests

---

## ✅ **4. Assertions (Hard & Soft)**

### 🔹 **Definition**  
Assertions are **conditions** that check whether the test passed or failed.

- **Hard Assertions**: Stop test execution when they fail.
- **Soft Assertions**: Allow the test to continue even if one assertion fails.

---

### 🔸 Hard Assertion Example

```java
import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertExample {
    @Test
    public void test() {
        Assert.assertEquals("Hello", "Hello");
        System.out.println("Checkpoint 1");
        Assert.assertTrue(10 > 20); // Fails here
        System.out.println("Checkpoint 2"); // Not executed
    }
}
```

### 🔸 Soft Assertion Example

```java
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertExample {
    @Test
    public void test() {
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(1, 2); // Fail
        System.out.println("Checkpoint 1");
        sa.assertTrue(false); // Fail
        System.out.println("Checkpoint 2");
        sa.assertAll(); // Collects and shows both failures
    }
}
```

### 🧠 Code Explanation:
- `Assert`: Immediately fails the test
- `SoftAssert`: Allows multiple assertions; test fails at `assertAll()`

---

## 👥 **5. Running Tests in Groups**

### 🔹 **Definition**  
**Grouping** allows you to organize and run a subset of tests based on tags like `smoke`, `regression`, etc.

### ✅ Java Code:
```java
import org.testng.annotations.Test;

public class GroupTestExample {

    @Test(groups = "smoke")
    public void smokeTest() {
        System.out.println("Smoke Test");
    }

    @Test(groups = "regression")
    public void regressionTest() {
        System.out.println("Regression Test");
    }

    @Test(groups = {"smoke", "regression"})
    public void bothTest() {
        System.out.println("Common Test");
    }
}
```

### 🔧 testng.xml:
```xml
<suite name="Grouped Tests">
  <test name="Smoke Tests">
    <groups>
      <run>
        <include name="smoke"/>
      </run>
    </groups>
    <classes>
      <class name="GroupTestExample"/>
    </classes>
  </test>
</suite>
```

### 🧠 Explanation:
- Executes only the tests tagged with `smoke`
- Great for managing large test suites

---

## 🧪 **6. Data-Driven Testing using Data Providers**

### 🔹 **Definition**  
**Data Providers** supply multiple sets of data to a single test method.

### ✅ Java Code:
```java
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {

    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return new Object[][] {
            {"admin", "admin123"},
            {"user", "userpass"}
        };
    }

    @Test(dataProvider = "loginData")
    public void loginTest(String username, String password) {
        System.out.println("Login with: " + username + ", " + password);
    }
}
```

### 🧠 Explanation:
- Test runs twice, once for each dataset
- Useful for login forms, search tests, etc.

---

## 📊 **7. Generating TestNG Reports**

### 🔹 **Definition**  
TestNG automatically generates HTML and XML reports after running the tests.

### 📁 Location:
Navigate to your project's `test-output/` folder.

- `index.html` → Full report
- `emailable-report.html` → Compact version
- `testng-results.xml` → Machine-readable for CI tools

---

## ⚡ **8. Parallel Test Execution with TestNG**

### 🔹 **Definition**  
Run multiple test cases simultaneously to **save time** and increase efficiency.

### ✅ Java Code:
```java
import org.testng.annotations.Test;

public class ParallelExample {

    @Test
    public void testA() {
        System.out.println("Test A - Thread: " + Thread.currentThread().getId());
    }

    @Test
    public void testB() {
        System.out.println("Test B - Thread: " + Thread.currentThread().getId());
    }
}
```

### 🔧 testng.xml:
```xml
<suite name="Parallel Suite" parallel="methods" thread-count="2">
  <test name="Parallel Execution">
    <classes>
      <class name="ParallelExample"/>
    </classes>
  </test>
</suite>
```

### 🧠 Explanation:
- Each test runs in a separate thread
- Improves test performance

---

## 🌐 **9. Selenium + TestNG Automation Example**

### 🔹 **Definition**  
Integrate Selenium WebDriver with TestNG to automate browser-based tests with assertions, parallelism, and data providers.

---

### ✅ Maven Dependencies:
```xml
<dependencies>
  <dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.19.0</version>
  </dependency>
  <dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.9.0</version>
    <scope>test</scope>
  </dependency>
</dependencies>
```

---

### ✅ Selenium + TestNG Code:
```java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SeleniumTestNGExample {

    WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @Test
    public void verifyGoogleHomePageTitle() {
        driver.get("https://www.google.com");
        String actualTitle = driver.getTitle();
        System.out.println("Page Title: " + actualTitle);
        Assert.assertTrue(actualTitle.contains("Google"));
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
```

---

### 🧠 Code Explanation:
- `@BeforeClass`: Opens Chrome before running tests
- `@Test`: Navigates to Google and verifies title
- `Assert`: Validates that title contains “Google”
- `@AfterClass`: Closes the browser

---

## ✅ Final Summary

| Feature                     | Description & Purpose                                       |
|-----------------------------|-------------------------------------------------------------|
| **TestNG Annotations**      | Control test execution order                                |
| **Hard/Soft Assertions**    | Validate expected vs actual results                         |
| **Groups**                  | Organize test execution (e.g., smoke, regression)           |
| **Data Providers**          | Provide multiple data sets to the same test                 |
| **Reports**                 | View pass/fail/skipped results post-execution               |
| **Parallel Execution**      | Run multiple test methods simultaneously                    |
| **Selenium + TestNG**       | Automate real browser testing with structured assertions     |

---
