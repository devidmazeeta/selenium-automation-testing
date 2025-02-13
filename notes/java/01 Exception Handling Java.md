# **Exception Handling in Java**  

Exception handling in Java is a mechanism that ensures the normal flow of the program even when runtime errors occur. It helps manage errors like dividing by zero, accessing invalid array indices, and handling missing files without crashing the program.  

Java provides a structured way to handle exceptions using **`try`**, **`catch`**, **`finally`**, **`throw`**, and **`throws`**.

---

## **Key Components of Exception Handling**
### **1. `try-catch` Block**
- **`try` block**: Contains the code that might throw an exception.
- **`catch` block**: Catches and handles the exception.

### **2. `finally` Block**
- Executes **whether an exception occurs or not**.
- Typically used for cleanup code (e.g., closing files or database connections).

### **Example of `try-catch-finally`**
```java
public class ExceptionHandlingExample {
    public static void main(String[] args) {
        try {
            int result = divide(10, 0); // This will throw ArithmeticException
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
        } finally {
            System.out.println("This block runs regardless of an exception.");
        }

        try {
            int[] numbers = {1, 2, 3};
            System.out.println("Element at index 5: " + numbers[5]); // ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Index out of bounds.");
        }
    }

    // Method to divide two numbers
    public static int divide(int num1, int num2) {
        return num1 / num2; // Division by zero throws an exception
    }
}
```

### **Output**
```
Error: Cannot divide by zero.
This block runs regardless of an exception.
Error: Index out of bounds.
```
---

## **`throw` and `throws` in Java**
Java provides **`throw`** and **`throws`** keywords to handle exceptions in a more controlled way.

### **1. `throw` Keyword**
- Used to **explicitly throw an exception** inside a method or block.
- Stops the execution of the current method and transfers control to the nearest `catch` block.
- Used for **custom or predefined exceptions**.

### **Example of `throw`**
```java
public class ThrowExample {
    public static void checkAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("Age must be 18 or above."); // Throwing an exception
        }
        System.out.println("Access granted.");
    }

    public static void main(String[] args) {
        try {
            checkAge(15);  // This will throw an exception
        } catch (IllegalArgumentException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
```

### **Output**
```
Exception caught: Age must be 18 or above.
```

---

### **2. `throws` Keyword**
- Used in **method declarations** to indicate that a method **might throw an exception**.
- It **does not handle** exceptions but tells the caller to handle them.
- Mainly used for **checked exceptions** (`IOException`, `SQLException`).

### **Example of `throws`**
```java
import java.io.*;

public class ThrowsExample {
    public static void readFile() throws IOException {
        FileReader file = new FileReader("nonexistent.txt");  // This file does not exist
        BufferedReader br = new BufferedReader(file);
        System.out.println(br.readLine());
    }

    public static void main(String[] args) {
        try {
            readFile();  // May throw IOException
        } catch (IOException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
```

### **Output (if file is missing)**
```
Exception caught: nonexistent.txt (No such file or directory)
```

---

## **Key Differences: `throw` vs `throws`**
| Feature        | `throw` | `throws` |
|--------------|--------|---------|
| Purpose | Used to **explicitly throw** an exception | Used to **declare** exceptions that a method might throw |
| Placement | Inside a method or block | In the method signature |
| Type | Throws **one** exception at a time | Can declare **multiple** exceptions (comma-separated) |
| Handling | Must be handled using `try-catch` | Does not handle exceptions; just informs the caller |
| Used For | Both checked and unchecked exceptions | Mostly checked exceptions |

---

## **Example Combining `throw` and `throws`**
```java
public class ThrowVsThrows {
    public static void validateAge(int age) throws IllegalArgumentException {
        if (age < 18) {
            throw new IllegalArgumentException("Not eligible to vote.");
        }
    }

    public static void main(String[] args) {
        try {
            validateAge(16); // This will throw an exception
        } catch (IllegalArgumentException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}
```

### **Output**
```
Caught Exception: Not eligible to vote.
```

---

## **Summary**
1. **Exception Handling** ensures smooth program execution.
2. **`try-catch-finally`** handles runtime exceptions gracefully.
3. **`throw`** is used to explicitly throw an exception inside a method.
4. **`throws`** is used in method declarations to indicate potential exceptions.
5. Proper exception handling prevents program crashes and improves reliability.

