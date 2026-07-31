# Exception Handling Quick Notes ⚠️

## 1. What is an Exception?
An event that interrupts the normal flow of program execution at runtime.

## 2. Exception Hierarchy
- `Throwable` is the root class.
  - `Error` (e.g. `OutOfMemoryError`)
  - `Exception`
    - `RuntimeException` (Unchecked - e.g. `ArithmeticException`, `NullPointerException`)
    - Checked Exceptions (e.g. `IOException`, `SQLException`)

## 3. Keywords
- `try`: Contains code that might throw an exception.
- `catch`: Catches and handles the exception.
- `finally`: Block that always executes (used for resource cleanup).
- `throw`: Explicitly throw an exception (`throw new Exception()`).
- `throws`: Declare exceptions in method signature (`void func() throws Exception`).

## 4. Custom Exception
Extend `Exception` (checked) or `RuntimeException` (unchecked):
```java
class MyCustomException extends Exception {
    public MyCustomException(String msg) {
        super(msg);
    }
}
```
