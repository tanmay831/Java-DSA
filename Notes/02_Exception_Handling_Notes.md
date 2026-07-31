# Exception Handling in Java - Comprehensive Study Notes ⚠️

Exception Handling is a mechanism in Java to handle runtime errors so that the normal flow of the application is maintained.

---

## 📌 Table of Contents
1. [What is an Exception?](#1-what-is-an-exception)
2. [Java Exception Hierarchy](#2-java-exception-hierarchy)
3. [Checked vs Unchecked Exceptions](#3-checked-vs-unchecked-exceptions)
4. [Try, Catch, and Finally Keywords](#4-try-catch-and-finally-keywords)
5. [Throw and Throws Keywords](#5-throw-and-throws-keywords)
6. [Custom Exceptions](#6-custom-exceptions)

---

## 1. What is an Exception?
An **Exception** is an unwanted or unexpected event that occurs during the execution of a program (at runtime) and disrupts the normal flow of instructions.

---

## 2. Java Exception Hierarchy

```
                   java.lang.Throwable
                            |
           +----------------+----------------+
           |                                 |
     java.lang.Error               java.lang.Exception
  (OutOfMemoryError, etc.)                   |
                             +---------------+---------------+
                             |                               |
                   RuntimeException                  IOException, SQLException
                 (ArithmeticException,                      (Checked)
                 NullPointerException)
                      (Unchecked)
```

---

## 3. Checked vs Unchecked Exceptions

| Feature | Checked Exceptions | Unchecked Exceptions |
| :--- | :--- | :--- |
| **Check Time** | Checked at compile-time by compiler. | Occur at runtime. |
| **Handling** | Must be handled via `try-catch` or declared via `throws`. | Optional to handle, but good to prevent crashes. |
| **Examples** | `IOException`, `SQLException`, `ClassNotFoundException` | `ArithmeticException`, `NullPointerException`, `ArrayIndexOutOfBoundsException` |

---

## 4. Try, Catch, and Finally Keywords

- **`try` block**: Encloses code that might throw an exception.
- **`catch` block**: Handles the specific exception thrown by the try block.
- **`finally` block**: Always executes whether an exception is thrown/handled or not. Used for resource cleanup (closing files, DB connections).

```java
try {
    int data = 100 / 0; // Throws ArithmeticException
} catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero: " + e.getMessage());
} finally {
    System.out.println("Finally block executed cleanly.");
}
```

---

## 5. Throw and Throws Keywords

- **`throw`**: Used to explicitly throw an exception object inside a method.
  ```java
  if (age < 18) {
      throw new IllegalArgumentException("Must be 18 or older!");
  }
  ```
- **`throws`**: Used in method signatures to declare that the method may throw certain checked exceptions.
  ```java
  public void readFile() throws IOException { ... }
  ```

---

## 6. Custom Exceptions
You can create custom exceptions by extending `Exception` (for checked) or `RuntimeException` (for unchecked).

```java
// Custom Unchecked Exception
class InvalidBalanceException extends Exception {
    public InvalidBalanceException(String message) {
        super(message);
    }
}
```
