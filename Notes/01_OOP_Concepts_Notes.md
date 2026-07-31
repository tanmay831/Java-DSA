# Object-Oriented Programming (OOP) - Comprehensive Study Notes 📚

Object-Oriented Programming (OOP) is a programming paradigm based on the concept of **objects**, which contain data (fields/attributes) and code (methods/functions).

---

## 📌 Table of Contents
1. [Class and Object](#1-class-and-object)
2. [Encapsulation](#2-encapsulation)
3. [Inheritance](#3-inheritance)
4. [Polymorphism](#4-polymorphism)
5. [Abstraction](#5-abstraction)
6. [Interface](#6-interface)
7. [Abstract Class](#7-abstract-class)
8. [Method Overriding](#8-method-overriding)
9. [Upcasting and Downcasting](#9-upcasting-and-downcasting)
10. [Association, Aggregation, and Composition](#10-association-aggregation-and-composition)

---

## 1. Class and Object
- **Class**: A blueprint or template from which objects are created. It defines state (attributes) and behavior (methods).
- **Object**: An instance of a class that possesses a state and behavior. Memory is allocated when an object is instantiated using the `new` keyword.

```java
// Class Definition
class Car {
    String color;
    int speed;

    void drive() {
        System.out.println("Car is driving at " + speed + " km/h");
    }
}

// Object Instantiation
Car myCar = new Car(); // Object created in heap memory
```

---

## 2. Encapsulation
- **Definition**: The mechanism of wrapping data (variables) and code acting on data (methods) together into a single unit (class).
- **Implementation**:
  1. Declare class variables as `private`.
  2. Provide public **getter** and **setter** methods to modify and view variable values.
- **Benefits**: Data hiding, security, ease of maintenance.

---

## 3. Inheritance
- **Definition**: The mechanism by which one class inherits the properties and behaviors of another class using the `extends` keyword.
- **Types of Inheritance in Java**:
  - Single Inheritance (`B extends A`)
  - Multilevel Inheritance (`C extends B extends A`)
  - Hierarchical Inheritance (`B extends A`, `C extends A`)
  - *Multiple Inheritance is NOT supported via classes (to avoid Diamond Problem), but supported via Interfaces.*

---

## 4. Polymorphism
- **Definition**: The ability of an object or method to take on many forms.
- **Types**:
  1. **Compile-Time Polymorphism (Method Overloading)**: Same method name with different parameter lists within the same class.
  2. **Runtime Polymorphism (Method Overriding)**: Subclass provides a specific implementation of a method declared in parent class.

---

## 5. Abstraction
- **Definition**: The process of hiding internal implementation details and showing only essential features to the user.
- **Achieved via**:
  1. Abstract Classes (0% to 100% abstraction).
  2. Interfaces (100% abstraction prior to Java 8).

---

## 6. Interface
- A contract in Java that specifies what a class must do, but not how.
- Declared using the `interface` keyword.
- All variables are `public static final` by default.
- Classes use `implements` keyword to provide method implementations.

---

## 7. Abstract Class
- A class declared with the `abstract` keyword.
- Cannot be instantiated directly (`new AbstractClass()` is invalid).
- Can contain both abstract methods (without body) and concrete methods (with body).

| Feature | Abstract Class | Interface |
| :--- | :--- | :--- |
| **Multiple Inheritance** | No | Yes |
| **Methods** | Abstract & Concrete | Abstract (by default), `default`, `static` |
| **Variables** | Final, non-final, static, non-static | `public static final` only |

---

## 8. Method Overriding
- Occurs when a subclass has a method with the **same name, same parameters, and same return type** as a method in its superclass.
- Uses `@Override` annotation.
- Resolved at **runtime** (Dynamic Method Dispatch).

---

## 9. Upcasting and Downcasting
- **Upcasting**: Casting a subclass object to a superclass reference type. Always safe and done automatically.
  ```java
  Animal a = new Dog(); // Upcasting
  ```
- **Downcasting**: Casting a superclass reference back to a subclass object. Requires explicit cast and should be verified using `instanceof`.
  ```java
  if (a instanceof Dog) {
      Dog d = (Dog) a; // Downcasting
  }
  ```

---

## 10. Association, Aggregation, and Composition

### 🔹 Association
A general relationship where one object uses or interacts with another object (e.g., Teacher and Student).

### 🔹 Aggregation (HAS-A / Weak Bond)
A specialized form of Association where objects have an independent lifecycle. If parent object is destroyed, child object still exists.
- *Example*: `Department` HAS-A `Teacher`. (If Department closes, Teacher still exists).

### 🔹 Composition (HAS-A / Strong Bond)
A strict form of Aggregation where child object cannot exist without parent object.
- *Example*: `Car` HAS-A `Engine`. (If Car is destroyed, Engine is also destroyed).
