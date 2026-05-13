# Java Methods & Method Overloading — Complete Guide

---

## Table of Contents
1. [What is a Method?](#1-what-is-a-method)
2. [Types of Methods — By Return & Parameters](#2-types-of-methods--by-return--parameters)
3. [Types of Methods — By Category](#3-types-of-methods--by-category)
4. [What is Method Overloading?](#4-what-is-method-overloading)
5. [Valid Ways to Overload](#5-valid-ways-to-overload)
6. [Invalid Overloading](#6-invalid-overloading)
7. [Type Promotion in Overloading](#7-type-promotion-in-overloading)
8. [Ambiguity in Overloading](#8-ambiguity-in-overloading)
9. [Overloading with Varargs](#9-overloading-with-varargs)
10. [Overloading with null Argument](#10-overloading-with-null-argument)
11. [Can We Overload main()?](#11-can-we-overload-main)
12. [Overloading vs Overriding](#12-overloading-vs-overriding)
13. [Quick Reference Summary](#13-quick-reference-summary)

---

## 1. What is a Method?

A **method** is a block of code that performs a specific task, defined inside a class.  
It promotes **reusability** and **modularity** in your program.

### Syntax
```java
accessModifier returnType methodName(parameterList) {
    // method body
    return value; // only if returnType is not void
}
```

### Example
```java
public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Calculator obj = new Calculator();
        System.out.println(obj.add(3, 5)); // 8
    }
}
```

### Key Parts of a Method

| Part | Description | Example |
|---|---|---|
| Access Modifier | Who can access the method | `public`, `private` |
| Return Type | What the method returns | `int`, `void`, `String` |
| Method Name | Name to call the method | `add`, `greet` |
| Parameters | Input values | `int a, int b` |
| Return Statement | Value to return | `return a + b` |

---

## 2. Types of Methods — By Return & Parameters

### 2.1 Void Method (No Return Value)
A method that performs an action but **does not return anything**.

```java
public class Example {

    public void greet(String name) {
        System.out.println("Hello, " + name);
    }

    public static void main(String[] args) {
        Example obj = new Example();
        obj.greet("Alice"); // Hello, Alice
    }
}
```

---

### 2.2 Return Type Method (Returns a Value)
A method that **returns a value** after execution using the `return` keyword.

```java
public class Example {

    public int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        Example obj = new Example();
        int result = obj.add(5, 3);
        System.out.println(result); // 8
    }
}
```

---

### 2.3 Method With Parameters
A method that **accepts input values** to work with.

```java
public class Example {

    public void showInfo(String name, int age) {
        System.out.println(name + " is " + age + " years old.");
    }

    public static void main(String[] args) {
        Example obj = new Example();
        obj.showInfo("Bob", 25); // Bob is 25 years old.
    }
}
```

---

### 2.4 Method Without Parameters
A method that **takes no input** and works on its own.

```java
public class Example {

    public void displayMessage() {
        System.out.println("Welcome to Java!");
    }

    public static void main(String[] args) {
        Example obj = new Example();
        obj.displayMessage(); // Welcome to Java!
    }
}
```

---

### 2.5 All 4 Combinations Together

```java
public class Calculator {

    // 1. Void + No Parameter
    public void showWelcome() {
        System.out.println("Welcome!");
    }

    // 2. Void + With Parameter
    public void printSquare(int n) {
        System.out.println("Square = " + (n * n));
    }

    // 3. Return Type + No Parameter
    public int getHundred() {
        return 100;
    }

    // 4. Return Type + With Parameter
    public int multiply(int a, int b) {
        return a * b;
    }

    public static void main(String[] args) {
        Calculator obj = new Calculator();

        obj.showWelcome();                          // Welcome!
        obj.printSquare(5);                         // Square = 25
        System.out.println(obj.getHundred());       // 100
        System.out.println(obj.multiply(4, 5));     // 20
    }
}
```

### Summary Table

| Type | Returns Value? | Has Parameters? | Example |
|---|---|---|---|
| Void + No Param | No | No | `void showWelcome()` |
| Void + With Param | No | Yes | `void printSquare(int n)` |
| Return + No Param | Yes | No | `int getHundred()` |
| Return + With Param | Yes | Yes | `int multiply(int a, int b)` |

> **Simple Rule:**
> - Use `void` when you want to just **perform an action**
> - Use a **return type** when you need a result back

---

## 3. Types of Methods — By Category

### 3.1 Predefined Methods
Already defined in Java libraries — ready to use directly.

```java
public class Main {
    public static void main(String[] args) {
        System.out.println(Math.sqrt(25));        // 5.0
        System.out.println(Math.max(10, 20));     // 20
        System.out.println("hello".toUpperCase()); // HELLO
        System.out.println(Math.abs(-99));        // 99
    }
}
```

---

### 3.2 User-Defined Methods
Methods created by the programmer for custom logic.

```java
public class Greet {

    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }

    public static void main(String[] args) {
        Greet g = new Greet();
        g.sayHello("Alice"); // Hello, Alice!
    }
}
```

---

### 3.3 Static Methods
Belong to the **class**, not an object. Called without creating an instance.

```java
public class MathUtils {

    public static int square(int n) {
        return n * n;
    }

    public static void main(String[] args) {
        System.out.println(MathUtils.square(5)); // 25 — no object needed!
    }
}
```

---

### 3.4 Instance Methods
Belong to an **object**. Require object creation to call.

```java
public class BankAccount {
    double balance = 1000;

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Balance: " + balance);
    }

    public static void main(String[] args) {
        BankAccount acc = new BankAccount();
        acc.deposit(500); // Balance: 1500.0
    }
}
```

---

### 3.5 Abstract Methods
No body — declared in abstract classes. Must be overridden in subclasses.

```java
abstract class Animal {
    public abstract void sound(); // no body
}

class Dog extends Animal {
    public void sound() {
        System.out.println("Dog barks!");
    }
}

class Cat extends Animal {
    public void sound() {
        System.out.println("Cat meows!");
    }
}
```

---

### 3.6 Final Methods
Cannot be **overridden** by any subclass.

```java
class Vehicle {
    public final void fuelType() {
        System.out.println("Uses petrol or diesel");
    }
}

class Car extends Vehicle {
    // ❌ Cannot override fuelType() — Compile Error!
}
```

---

### Category Summary Table

| Type | Key Feature | Needs Object? |
|---|---|---|
| Predefined | Built into Java libraries | Depends |
| User-defined | Written by programmer | Depends |
| Static | Belongs to class | No |
| Instance | Belongs to object | Yes |
| Abstract | No body, must be overridden | Yes |
| Final | Cannot be overridden | Yes |

---

## 4. What is Method Overloading?

Method overloading means defining **multiple methods with the same name** in the same class,  
but with **different parameter lists**.

Java decides which method to call based on arguments at **compile time**  
— this is called **Static / Compile-Time Polymorphism**.

```java
public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        Calculator obj = new Calculator();
        System.out.println(obj.add(2, 3));       // 5
        System.out.println(obj.add(2.5, 3.5));   // 6.0
        System.out.println(obj.add(1, 2, 3));    // 6
    }
}
```

---

## 5. Valid Ways to Overload

### 5.1 Different Number of Parameters
```java
public void show(int a) { }
public void show(int a, int b) { }      // ✅ Valid
public void show(int a, int b, int c) { } // ✅ Valid
```

### 5.2 Different Types of Parameters
```java
public void show(int a) { }     // ✅ Valid
public void show(double a) { }  // ✅ Valid
public void show(String a) { }  // ✅ Valid
```

### 5.3 Different Order of Parameters
```java
public void show(int a, double b) { }  // ✅ Valid
public void show(double a, int b) { }  // ✅ Valid
```

---

## 6. Invalid Overloading

### Changing Only the Return Type — NOT Valid
```java
public int getValue()    { return 1; }
public double getValue() { return 1.0; } // ❌ Compile Error!
```
> Java cannot distinguish methods by return type alone.

---

## 7. Type Promotion in Overloading

If an **exact match** isn't found, Java **automatically promotes** smaller types to larger ones.

### Promotion Chain
```
byte → short → int → long → float → double
```

```java
public class Demo {

    public void show(long a) {
        System.out.println("long method: " + a);
    }

    public static void main(String[] args) {
        Demo obj = new Demo();
        obj.show(10); // int 10 promoted to long → "long method: 10"
    }
}
```

### More Examples
```java
public class TypePromotion {

    public void display(float a) {
        System.out.println("float method");
    }

    public static void main(String[] args) {
        TypePromotion obj = new TypePromotion();
        obj.display(10);    // int → float → "float method"
        obj.display(10L);   // long → float → "float method"
    }
}
```

> **Note:** Exact match always wins over promoted match.

---

## 8. Ambiguity in Overloading

Sometimes Java **cannot decide** which overloaded method to call — causes a Compile Error.

### Case 1 — Same-level Type Promotion
```java
public class Demo {

    public void show(int a, double b) {
        System.out.println("int, double");
    }

    public void show(double a, int b) {
        System.out.println("double, int");
    }

    public static void main(String[] args) {
        Demo obj = new Demo();
        obj.show(10, 20); // ❌ Ambiguous — Compile Error!
        // Java confused: promote first arg or second arg?
    }
}
```

### Case 2 — Null Argument
```java
public class Demo {

    public void show(String s) {
        System.out.println("String method");
    }

    public void show(Integer i) {
        System.out.println("Integer method");
    }

    public static void main(String[] args) {
        Demo obj = new Demo();
        obj.show(null); // ❌ Ambiguous — null fits both String and Integer!
    }
}
```

> **Fix:** Cast null explicitly — `obj.show((String) null);`

---

## 9. Overloading with Varargs

Varargs (`...`) allows a method to accept variable number of arguments.

```java
public class Demo {

    public void show(int a) {
        System.out.println("Single int: " + a);
    }

    public void show(int... nums) {
        System.out.println("Varargs method");
    }

    public static void main(String[] args) {
        Demo obj = new Demo();
        obj.show(5);       // calls show(int) — exact match wins!
        obj.show(1, 2, 3); // calls show(int...) — varargs
    }
}
```

> **Rule:** Exact match always wins over varargs.

---

## 10. Overloading with null Argument

```java
public class Demo {

    public void show(String s) {
        System.out.println("String method");
    }

    public void show(Object o) {
        System.out.println("Object method");
    }

    public static void main(String[] args) {
        Demo obj = new Demo();
        obj.show(null); // calls show(String) — String is more specific than Object
    }
}
```

> **Rule:** Java picks the **most specific type** when null is passed.

---

## 11. Can We Overload main()?

### YES! — main() CAN be overloaded

```java
public class MainOverload {

    // Original main — entry point called by JVM
    public static void main(String[] args) {
        System.out.println("Original main — called by JVM");

        // Manually calling overloaded mains
        main(10);
        main("Hello");
        main(10, 20);
    }

    // Overloaded main — int parameter
    public static void main(int a) {
        System.out.println("main(int) = " + a);
    }

    // Overloaded main — String parameter
    public static void main(String s) {
        System.out.println("main(String) = " + s);
    }

    // Overloaded main — two int parameters
    public static void main(int a, int b) {
        System.out.println("main(int, int) = " + (a + b));
    }
}
```

**Output:**
```
Original main — called by JVM
main(int) = 10
main(String) = Hello
main(int, int) = 30
```

### Key Rules for main() Overloading

| Rule | Explanation |
|---|---|
| JVM always calls `main(String[] args)` | Only this is the entry point |
| Overloaded mains are ignored by JVM | Treated as regular static methods |
| Must be called manually | JVM won't call them automatically |
| Should be `static` | To be called without object creation |

---

## 12. Overloading vs Overriding

| Feature | Overloading | Overriding |
|---|---|---|
| Where | Same class | Parent & Child class |
| Method Name | Same | Same |
| Parameters | Must differ | Must be same |
| Return Type | Can differ | Must be same |
| Access Modifier | Can differ | Cannot be more restrictive |
| Resolved at | Compile time | Runtime |
| Polymorphism | Static (compile-time) | Dynamic (runtime) |
| `@Override` annotation | Not used | Used |

```java
// Overloading — same class
class Demo {
    public void show(int a) { }
    public void show(String s) { } // overloaded
}

// Overriding — parent & child
class Parent {
    public void show() {
        System.out.println("Parent show");
    }
}

class Child extends Parent {
    @Override
    public void show() {
        System.out.println("Child show"); // overriding
    }
}
```

---

## 13. Quick Reference Summary

### Method Basics
```
Method = Access Modifier + Return Type + Name + Parameters + Body
void   → no return value
return → must return a matching type value
```

### 4 Combinations
```
Void   + No Param  → just performs action, no input
Void   + Param     → performs action with input
Return + No Param  → gives output, no input
Return + Param     → takes input and gives output
```

### Overloading Rules
```
✅ Valid   → different number of params
✅ Valid   → different types of params
✅ Valid   → different order of param types
❌ Invalid → only return type differs
```

### Overloading Special Cases
```
Type Promotion → byte → short → int → long → float → double
Ambiguity      → compile error when Java can't decide
Varargs        → exact match always wins over varargs
null           → most specific type is chosen
main()         → YES, can be overloaded; JVM calls only main(String[] args)
```

### Overloading vs Overriding in One Line
```
Overloading  = Same name, Different params, Same class,   Compile-time
Overriding   = Same name, Same params,      Child class,  Runtime
```

---

*End of Java Methods & Method Overloading — Complete Guide*
