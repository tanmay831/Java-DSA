# Object-Oriented Programming (OOP) Quick Notes 📝

## 1. Class and Object
- **Class**: Blueprint or template (defines variables & methods).
- **Object**: Real-world entity / Instance of a class created using `new`.

## 2. Encapsulation
- Wrapping data (variables) and methods into a single unit (class).
- Declaring fields as `private` and providing `public` getters/setters for controlled access.

## 3. Inheritance
- Reusing code from a parent class using `extends`.
- Types: Single, Multilevel, Hierarchical.

## 4. Polymorphism
- **Overloading** (Compile-time): Same method name with different parameters in same class.
- **Overriding** (Runtime): Subclass provides specific implementation of parent class method.

## 5. Abstraction
- Hiding implementation details and showing only essential functionality.
- Achieved using Abstract Classes and Interfaces.

## 6. Interface vs Abstract Class
- **Interface**: 100% abstraction (before Java 8), uses `implements`, supports multiple inheritance.
- **Abstract Class**: Partial abstraction (can have abstract & concrete methods), uses `extends`.

## 7. Upcasting & Downcasting
- **Upcasting**: Subclass object assigned to Parent reference (`Parent p = new Child()`). Safe.
- **Downcasting**: Parent reference converted back to Subclass (`Child c = (Child) p`).

## 8. Object Relationships
- **Association**: General link between objects.
- **Aggregation**: HAS-A relationship (Weak bond - child exists independently).
- **Composition**: HAS-A relationship (Strong bond - child lifetime bound to parent).
