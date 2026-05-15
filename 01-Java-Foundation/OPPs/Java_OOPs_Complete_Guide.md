# Java OOPs — Complete Study Guide
### Everything from Fundamentals to Advanced OOP

---

## Table of Contents

| # | Topic |
|---|---|
| 1 | [Java Fundamentals](#1-java-fundamentals) |
| 2 | [Data Types & Variables](#2-data-types--variables) |
| 3 | [Type Casting](#3-type-casting) |
| 4 | [Operators](#4-operators) |
| 5 | [Control Flow](#5-control-flow) |
| 6 | [Class & Object](#6-class--object) |
| 7 | [Stack & Heap Memory](#7-stack--heap-memory) |
| 8 | [Methods & Method Overloading](#8-methods--method-overloading) |
| 9 | [Encapsulation & Access Modifiers](#9-encapsulation--access-modifiers) |
| 10 | [this Keyword](#10-this-keyword) |
| 11 | [Constructors](#11-constructors) |
| 12 | [static Keyword](#12-static-keyword) |
| 13 | [Inheritance](#13-inheritance) |
| 14 | [Abstract Classes](#14-abstract-classes) |
| 15 | [Polymorphism](#15-polymorphism) |
| 16 | [Interfaces](#16-interfaces) |
| 17 | [Loose Coupling](#17-loose-coupling) |
| 18 | [Lambda Functions](#18-lambda-functions) |
| 19 | [OOP Pillars — Big Picture](#19-oop-pillars--big-picture) |
| 20 | [Quick Cheat Sheet](#20-quick-cheat-sheet) |

---

## 1. Java Fundamentals

### Why Java?
- **Platform Independent** — Write Once, Run Anywhere (WORA)
- **Object Oriented** — everything is modelled as objects
- Java compiles to **bytecode**, not machine code — runs on any OS with a JVM

### How Java Runs
```
Demo.java → Java Compiler (javac) → Demo.class (bytecode) → JVM → CPU
```
- The Java compiler produces **bytecode**, not platform-specific machine code
- The **JVM (Java Virtual Machine)** on each platform translates bytecode to native instructions
- Different OS → different JVM → same bytecode → **platform independence**

### Language Levels (Low → High)
| Level | Examples | Converted by |
|---|---|---|
| Machine code | `10010`, `00111` | — |
| Assembly | `ADD`, `SUB`, `MUL` | Assembler |
| High-Level | Java, C++, Python | Compiler |

### Computer Memory Hierarchy
| Storage | Type | Speed | Notes |
|---|---|---|---|
| HDD / SSD | Non-volatile | Slow | Permanent, loses nothing on power off |
| RAM | Volatile | Fast | Loses data on power off |
| Register / Cache | Volatile | Fastest | Inside CPU, tiny but very fast |

### Naming Conventions
| Entity | Convention | Example |
|---|---|---|
| Class | PascalCase | `BankAccount`, `StudentInfo` |
| Method | camelCase | `calculateSalary()`, `getName()` |
| Variable | camelCase | `averageMarks`, `employeeSalary` |
| Constant | UPPER_CASE | `MAX_VALUE`, `PI` |

---

## 2. Data Types & Variables

### What is a Variable?
```java
int age = 15;
 ↑        ↑    ↑
data    var   value
type   name
```
> `=` is the **assignment operator**, not equality.

### Primitive Data Types
| Type | Size | Range | Default | Example |
|---|---|---|---|---|
| `byte` | 1 byte | -128 to 127 | 0 | `byte a = 45;` |
| `short` | 2 bytes | -32768 to 32767 | 0 | `short b = 45;` |
| `int` | 4 bytes | ~-2.1B to 2.1B | 0 | `int c = 5;` |
| `long` | 8 bytes | very large | 0L | `long d = 45l;` |
| `float` | 4 bytes | decimal (IEEE) | 0.0f | `float f = 45.65f;` |
| `double` | 8 bytes | decimal (IEEE) | 0.0 | `double d = 45.4;` |
| `char` | 2 bytes | Unicode (65,536) | '\u0000' | `char c = 'f';` |
| `boolean` | — | true / false | false | `boolean b = true;` |

> Default integer literal → `int`. Default decimal literal → `double`.
> Append `l` or `L` for long, `f` or `F` for float.

### Non-Primitive (Object) Types
- `String`, arrays, classes, interfaces, etc.
- Examples: `String name = "Alice";`

### Characters, ASCII & Unicode
- Every character maps to a number
- **ASCII** covers 128 characters: `A` = 65, `a` = 97
- Java uses **Unicode (UTF-16)** — 65,536 characters → 16 bits → **2 bytes**
- That's why `char` is 2 bytes in Java (unlike C/C++ where it's 1 byte)

```java
char a = 'a';       // valid
char b = '@';       // valid
char c = '4';       // valid — digits are chars too
// char x = 'ha';   // ❌ ILLEGAL — char holds exactly ONE character
```

### Instance Variable vs Local Variable
| | Instance Variable | Local Variable |
|---|---|---|
| Declared | Inside class, outside methods | Inside a method |
| Scope | Entire class | That method only |
| Default value | Yes (0, null, false) | No — must be set manually |
| Lives in memory | Heap (inside the object) | Stack (inside the method frame) |
| Destroyed when | Object is garbage collected | Method returns |

```java
class Dog {
    String name;    // instance variable — default null

    void barks() {
        int age = 4; // local variable — must initialize
        System.out.println(age);
    }
}
```

---

## 3. Type Casting

### Implicit Type Casting (Widening)
Java automatically promotes smaller types — no data lost:
```
byte → short → int → long → float → double
```
```java
byte a = 45;
double b = a;          // implicit — Java widens automatically
System.out.println(b); // 45.0
```

### Explicit Type Casting (Narrowing)
Must manually cast when going from larger to smaller — possible data loss:
```java
double c = 45.9;
int d = (int) c;       // explicit cast — truncates decimal
System.out.println(d); // 45 (not 46 — truncates toward zero)
```

### Integer Division Trap ⚠️
```java
int a = 12, b = 5;
float c = a / b;        // result: 2.0 — NOT 2.4!
// int/int → int result (2), then widened to float (2.0)

// Fix: cast first
float d = (float) a / b; // 2.4 ✅
```

---

## 4. Operators

### Arithmetic Operators
| Operator | Meaning | Example | Result |
|---|---|---|---|
| `+` | Addition | `5 + 6` | `11` |
| `-` | Subtraction | `6 - 5` | `1` |
| `*` | Multiplication | `5 * 6` | `30` |
| `/` | Division | `10 / 5` | `2` |
| `%` | Modulus | `5 % 2` | `1` |

### Relational Operators (always return boolean)
| Operator | Meaning | Example | Result |
|---|---|---|---|
| `==` | Equal to | `5 == 5` | `true` |
| `!=` | Not equal | `5 != 5` | `false` |
| `<` | Less than | `5 < 5` | `false` |
| `>` | Greater than | `5 > 4` | `true` |
| `<=` | Less than or equal | `5 <= 5` | `true` |
| `>=` | Greater than or equal | `5 >= 4` | `true` |

### Logical Operators
| Operator | Name | Rule |
|---|---|---|
| `\|\|` | OR | `true` if at least one is `true` |
| `&&` | AND | `true` only if ALL are `true` |
| `!` | NOT | flips the boolean |

### Increment / Decrement
```java
int a = 5;
System.out.println(a++); // 5 — use THEN increment (post)
System.out.println(++a); // 7 — increment THEN use (pre)
```

---

## 5. Control Flow

### if / else if / else
```java
int age = 22;

if (age > 18) {
    System.out.println("Adult");
} else if (age == 18) {
    System.out.println("Just turned 18!");
} else {
    System.out.println("Kiddo");
}
```

### Ternary Operator
```java
int number = 4;
String result = (number % 2 == 0) ? "Even" : "Odd";
System.out.println(result); // Even
```

### switch Statement
```java
int day = 3;
switch (day) {
    case 1: System.out.println("Monday");    break;
    case 2: System.out.println("Tuesday");   break;
    case 3: System.out.println("Wednesday"); break;
    default: System.out.println("Other");
}
```

### Loops
```java
// for — when you know how many times
for (int i = 0; i < 5; i++) {
    System.out.println(i);
}

// while — repeat while condition is true
int i = 0;
while (i < 5) {
    System.out.println(i);
    i++;
}

// do-while — runs at least once
int j = 5;
do {
    System.out.println(j); // prints once even if condition false
    j++;
} while (j < 5);

// for-each — for arrays/collections
int[] nums = {1, 2, 3, 4, 5};
for (int n : nums) {
    System.out.println(n);
}
```

---

## 6. Class & Object

### What is a Class?
A **class** is a blueprint/template. It defines what an object will have (data) and will do (behaviour). No memory is used just by defining a class.

```java
class Car {
    // Fields (instance variables)
    String brand;
    String color;
    int    year;

    // Constructor
    Car(String brand, String color, int year) {
        this.brand = brand;
        this.color = color;
        this.year  = year;
    }

    // Method
    void run() {
        System.out.println(brand + " | " + color + " | " + year);
    }
}
```

### What is an Object?
An **object** is a real instance created from a class using the `new` keyword.

```java
public class Main {
    public static void main(String[] args) {

        Car car1 = new Car("Mercedes", "Dark Brown", 2032);
        Car car2 = new Car("Toyota",   "White",      2030);

        car1.run(); // Mercedes | Dark Brown | 2032
        car2.run(); // Toyota | White | 2030

        // Each object has its own data
        car1.color = "Red";
        car1.run(); // Mercedes | Red | 2032
        car2.run(); // Toyota | White | 2030 — unchanged!
    }
}
```

### What `new` Does — 3 Steps
1. **Allocates memory** on the Heap for all instance variables
2. **Runs the constructor** — initializes the data
3. **Returns the address** — stored in the reference variable on the Stack

### Real-World Analogy
| Concept | Real World | Java |
|---|---|---|
| Class | Cookie cutter mold | `class Car { ... }` |
| Object | The actual cookie | `Car c = new Car(...)` |
| Instance variable | Each cookie's flavor | `c.color = "Red"` |
| Constructor | The recipe | `Car(String b, ...)` |
| Method | What the cookie can do | `c.run()` |
| Reference | A label on the cookie | `Car c` |
| `null` | Label stuck on thin air | `Car c = null` |

### Static vs Dynamic Typing
| | Statically Typed | Dynamically Typed |
|---|---|---|
| Examples | Java, C, C++ | Python, JavaScript |
| Type declaration | Explicit | Inferred at runtime |

```java
// Java (static)
int age = 16;
String name = "Alice";
```

---

## 7. Stack & Heap Memory

### Stack Memory
Stores: method call frames, local variables, reference variables (addresses)
- **LIFO** — Last In, First Out
- Method called → frame **pushed**; method returns → frame **popped**
- Error when full: `StackOverflowError`

### Heap Memory
Stores: all objects created with `new`, instance variables
- Object lives as long as at least one reference points to it
- **Garbage Collector** reclaims memory when no references remain
- Error when full: `OutOfMemoryError`

```
Stack                     Heap
┌──────────────────┐      ┌──────────────────────┐
│  main() frame    │      │  @1000 Car object    │
│  car1 → @1000    │ ──►  │    brand = "Toyota"  │
│  car2 → @2000    │      │    color = "White"   │
└──────────────────┘      ├──────────────────────┤
                          │  @2000 Car object    │
                          │    brand = "Honda"   │
                          │    color = "Red"     │
                          └──────────────────────┘
```

### Stack vs Heap — Quick Reference
| | Stack | Heap |
|---|---|---|
| Stores | Method frames, local vars, references | Objects, instance variables |
| Size | Small and fixed | Large and dynamic |
| Speed | Very fast | Slightly slower |
| Managed by | JVM automatically | Garbage Collector |
| Lifetime | Until method returns | Until no references remain |
| Error | `StackOverflowError` | `OutOfMemoryError` |

### Common Mistakes
```java
// 1. NullPointerException
Car car = null;
car.run(); // ❌ NPE — car points to nothing!

// 2. Reference copy is not object copy
Car car1 = new Car("Toyota", "Red", 2030);
Car car2 = car1;           // copies ADDRESS, not object!
car2.color = "Blue";
System.out.println(car1.color); // Blue — same object modified!
```

---

## 8. Methods & Method Overloading

### What is a Method?
A block of code that performs a specific task, defined inside a class.

```java
accessModifier returnType methodName(parameterList) {
    // method body
    return value; // only if returnType is not void
}
```

### Types of Methods — By Return & Parameters

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
}
```

| Type | Returns? | Parameters? | Example |
|---|---|---|---|
| Void + No Param | No | No | `void showWelcome()` |
| Void + With Param | No | Yes | `void printSquare(int n)` |
| Return + No Param | Yes | No | `int getHundred()` |
| Return + With Param | Yes | Yes | `int multiply(int a, int b)` |

### Types of Methods — By Category
| Type | Key Feature | Needs Object? |
|---|---|---|
| Predefined | Built into Java libraries | Depends |
| User-defined | Written by programmer | Depends |
| Static | Belongs to class | No |
| Instance | Belongs to object | Yes |
| Abstract | No body, must override | Yes |
| Final | Cannot be overridden | Yes |

### What is Method Overloading?
Same method name, **different parameter lists** in the same class. Resolved at **compile time**.

```java
public class Calculator {
    public int    add(int a, int b)          { return a + b; }
    public double add(double a, double b)    { return a + b; }
    public int    add(int a, int b, int c)   { return a + b + c; }
}
```

### Valid Ways to Overload
```java
// ✅ Different number of params
public void show(int a) { }
public void show(int a, int b) { }

// ✅ Different types
public void show(int a) { }
public void show(double a) { }

// ✅ Different order
public void show(int a, double b) { }
public void show(double a, int b) { }

// ❌ Only return type — INVALID
public int getValue()    { return 1; }
public double getValue() { return 1.0; } // Compile Error!
```

### Type Promotion in Overloading
```
byte → short → int → long → float → double
```
If exact match not found, Java promotes. Exact match always wins.

### Ambiguity Problems
```java
// ❌ Ambiguous — Java can't decide
obj.show(10, 20); // show(int,double) or show(double,int)?

// ❌ Null ambiguity — fits both String and Integer
obj.show(null);

// Fix: cast explicitly
obj.show((String) null); // ✅
```

### Overloading with Varargs
```java
public void show(int a)       { }  // exact match wins
public void show(int... nums) { }  // varargs — last resort
```

### Can We Overload main()?
```java
public class Main {
    public static void main(String[] args) {   // JVM calls ONLY this
        main(10);       // manually call overloaded
        main("Hello");
    }
    public static void main(int a)    { System.out.println("int: " + a); }
    public static void main(String s) { System.out.println("String: " + s); }
}
```
> JVM always calls `main(String[] args)`. Overloaded mains are regular static methods.

### Overloading vs Overriding
| Feature | Overloading | Overriding |
|---|---|---|
| Where | Same class | Parent & Child class |
| Parameters | Must differ | Must be same |
| Return Type | Can differ | Must be same |
| Resolved at | Compile time | Runtime |
| Polymorphism | Static | Dynamic |
| `@Override` | Not used | Used |

---

## 9. Encapsulation & Access Modifiers

### What is Encapsulation?
Wrapping **data (variables) and methods together** in a single unit (class), and **restricting direct access** from outside.

> Think of it like a **medicine capsule** — everything packed inside, protected.

### How to Achieve Encapsulation
1. Declare variables as **`private`**
2. Provide **`public` getters and setters**

```java
public class Student {
    private String name;  // hidden!
    private int age;

    // Getter — read value
    public String getName() { return name; }

    // Setter — set value with validation
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Invalid age!");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Student s = new Student();
        s.setName("Alice");
        s.setAge(20);
        System.out.println(s.getName()); // Alice
        // s.name = "Bob"; ❌ Cannot access private field!
    }
}
```

### Read-Only & Write-Only Fields
```java
public class Demo {
    private String id;
    private String password;

    // Read-only — only getter
    public String getId() { return id; }

    // Write-only — only setter
    public void setPassword(String password) { this.password = password; }
}
```

### Access Modifiers
| Modifier | Same Class | Same Package | Subclass | Everywhere |
|---|---|---|---|---|
| `private` | ✅ | ❌ | ❌ | ❌ |
| (default) | ✅ | ✅ | ❌ | ❌ |
| `protected` | ✅ | ✅ | ✅ | ❌ |
| `public` | ✅ | ✅ | ✅ | ✅ |

### Benefits of Encapsulation
| Benefit | Explanation |
|---|---|
| Data Hiding | Private fields can't be accessed directly |
| Validation | Setters validate before setting values |
| Flexibility | Change internal logic without affecting outside |
| Read/Write control | Expose only getter or only setter |
| Security | Sensitive data is protected |

---

## 10. this Keyword

`this` is a **reference variable** that refers to the **current object** of the class.

### Use 1 — Resolve Variable Shadowing (Most Common)
```java
public class Student {
    private String name;

    public void setName(String name) {
        this.name = name; // this.name = instance var, name = parameter
    }
}
```
> Without `this` → Java reads the parameter, not the instance variable — data not saved!

### Use 2 — Constructor Chaining (`this()`)
```java
public class Student {
    String name;
    int age;
    String grade;

    public Student(String name, int age) {
        this.name = name;
        this.age  = age;
    }

    public Student(String name, int age, String grade) {
        this(name, age);       // calls above constructor
        this.grade = grade;
    }
}
```
> **Rule:** `this()` must always be the **first statement** in a constructor.

### Use 3 — Pass Current Object as Argument
```java
void sendToPrinter() {
    Printer p = new Printer();
    p.print(this);  // passing current object
}
```

### Use 4 — Return Current Object (Method Chaining)
```java
public Builder setName(String name) {
    this.name = name;
    return this;  // enables method chaining
}

// Usage:
new Builder().setName("Alice").setAge(25).display();
```

### Summary Table
| Use | Syntax | Purpose |
|---|---|---|
| Variable shadowing | `this.name = name` | Distinguish instance var from parameter |
| Constructor chaining | `this(args)` | Call one constructor from another |
| Pass current object | `method(this)` | Send current object as argument |
| Return current object | `return this` | Enable method chaining |

---

## 11. Constructors

### What is a Constructor?
A special method automatically called when an object is created. Used to **initialize** the object.

**Key Rules:**
- Same name as class
- No return type (not even `void`)
- Called automatically with `new`

### Types of Constructors

#### 1. Default Constructor
Java auto-provides if you write none. Sets default values.
```java
public class Student {
    String name; // null
    int age;     // 0
    // Java provides: public Student() { }
}
```

#### 2. No-Arg Constructor
Explicitly written with no parameters.
```java
public Student() {
    this.name = "Unknown";
    this.age  = 0;
    System.out.println("Student created!");
}
```

#### 3. Parameterized Constructor
Accepts parameters to initialize with custom values.
```java
public Student(String name, int age) {
    this.name = name;
    this.age  = age;
}
```

#### 4. Constructor Overloading
Multiple constructors with different parameter lists.
```java
public Student() { ... }
public Student(String name) { ... }
public Student(String name, int age) { ... }
public Student(String name, int age, String grade) { ... }
```

#### 5. Constructor Chaining using `this()`
```java
public Student(String name, int age, String grade) {
    this(name, age); // calls Student(String, int)
    this.grade = grade;
}
```

### Constructor vs Method
| Feature | Constructor | Method |
|---|---|---|
| Name | Same as class | Any name |
| Return type | None | Must have (`void` or type) |
| Called | Automatically on `new` | Manually |
| Purpose | Initialize object | Perform action |
| Overloading | Yes | Yes |

### Constructor Behavior in Inheritance
```java
class A { public A() { System.out.println("A"); } }
class B extends A { public B() { System.out.println("B"); } }
class C extends B { public C() { System.out.println("C"); } }

new C();
// Output: A → B → C (always Parent first, then Child)
```

---

## 12. static Keyword

`static` means the member **belongs to the class**, not to any specific object.

### 1. Static Variable (Class Variable)
Shared by all objects — only ONE copy exists in memory.
```java
public class Student {
    String name;         // each object has its own
    static int count = 0; // shared by ALL objects

    public Student(String name) {
        this.name = name;
        count++;
    }

    public static void main(String[] args) {
        new Student("Alice");
        new Student("Bob");
        System.out.println(Student.count); // 2
    }
}
```

### 2. Static Method
Belongs to class. No object needed. Cannot use `this` or `super`. Cannot access instance variables directly.
```java
public static int square(int n) {
    return n * n;
}
// Call: MathUtils.square(5) — no object!
```

### 3. Static Block
Runs **once when the class is loaded** — before `main()` or any object.
```java
static {
    System.out.println("Class loaded!"); // runs first
}

public static void main(String[] args) {
    System.out.println("Main method");
}
// Output: Class loaded! → Main method
```

### 4. Multiple Static Blocks
Execute **top to bottom** in order.
```java
static { System.out.println("Block 1"); }
static { System.out.println("Block 2"); }
// Block 1 → Block 2
```

### 5. static final — Constants
```java
static final double PI    = 3.14159;
static final int    MAX   = 100;
// PI = 3.0; ❌ Cannot change!
```
> Convention: constant names are always **UPPER_CASE**

### 6. Static Import
```java
import static java.lang.Math.*;
import static java.lang.System.out;

out.println(sqrt(25)); // no Math. or System. needed!
out.println(PI);
```

### 7. Can We Override Static Methods? — NO (Method Hiding)
```java
Parent obj = new Child();
obj.staticMethod();  // Parent's version — reference type decides (NOT polymorphic)
obj.instanceMethod(); // Child's version — object type decides (polymorphic)
```

### 8. Why is main() Static?
JVM calls `main()` **without creating any object**. If it were instance, JVM would need an object first — which is a chicken-and-egg problem.

### static vs Instance Summary
| Feature | Static | Instance |
|---|---|---|
| Belongs to | Class | Object |
| Memory | One shared copy | Per object |
| Access | `ClassName.member` | `objectName.member` |
| `this` keyword | ❌ Cannot use | ✅ Can use |
| Access instance members | ❌ Cannot directly | ✅ Can |
| Called without object | ✅ Yes | ❌ No |

---

## 13. Inheritance

### What is Inheritance?
One class **acquires properties and behaviors** of another class.

- **Parent Class** = Superclass / Base Class
- **Child Class** = Subclass / Derived Class
- Keyword: **`extends`**

```java
class Animal {
    public void eat() { System.out.println("Animal eats"); }
}

class Dog extends Animal {     // Dog inherits Animal
    public void bark() { System.out.println("Dog barks"); }
}

Dog d = new Dog();
d.eat();  // ✅ inherited
d.bark(); // ✅ Dog's own
```

### Types of Inheritance

#### 1. Single Inheritance
```
Animal → Dog
```
```java
class Animal { }
class Dog extends Animal { }
```

#### 2. Multilevel Inheritance
```
Animal → Dog → Puppy
```
```java
class Animal { }
class Dog extends Animal { }
class Puppy extends Dog { }
```

#### 3. Hierarchical Inheritance
```
Animal → Dog, Cat, Cow
```
```java
class Dog extends Animal { }
class Cat extends Animal { }
class Cow extends Animal { }
```

#### 4. Multiple Inheritance — NOT Supported ❌
```java
// ❌ Compile Error — Diamond Problem
class C extends A, B { }
```
> Java solves this using **Interfaces**.

#### 5. Hybrid Inheritance — via Interfaces ✅
```java
class Child extends Parent implements InterfaceA, InterfaceB { }
```

### super Keyword
`super` refers to the **parent class**.

```java
// Use 1 — Access parent variable
System.out.println(super.name); // parent's name

// Use 2 — Call parent method
super.eat(); // calls parent's eat()

// Use 3 — Call parent constructor (must be first statement)
super(name, age); // calls parent constructor
```

### Method Overriding Rules
| Rule | Detail |
|---|---|
| Same name | Must match exactly |
| Same parameters | Must match exactly |
| Access modifier | Same or wider (never narrower) |
| `@Override` | Not mandatory but best practice |
| Static methods | ❌ Cannot override — method hiding |
| Final methods | ❌ Cannot override |
| Private methods | ❌ Not inherited — cannot override |

### final with Inheritance
```java
final class Vehicle { }       // cannot be extended ❌
class Car extends Vehicle { } // ❌ Compile Error!

class Vehicle {
    public final void fuelType() { } // cannot be overridden ❌
}
```

### instanceof Operator
```java
Dog d = new Dog();
System.out.println(d instanceof Dog);    // true
System.out.println(d instanceof Animal); // true — Dog IS-A Animal
System.out.println(d instanceof Object); // true — everything IS-A Object
```

### IS-A vs HAS-A
```java
// IS-A → Inheritance
class Dog extends Animal { } // Dog IS-A Animal

// HAS-A → Composition
class Car {
    Engine engine = new Engine(); // Car HAS-A Engine
}
```

---

## 14. Abstract Classes

### What is an Abstract Class?
A class that is **incomplete by design** — has abstract (no body) and concrete (with body) methods. **Cannot be instantiated**.

```java
abstract class Shape {
    String color;

    // Abstract — MUST be overridden by child
    public abstract double area();

    // Concrete — inherited as-is
    public void display() {
        System.out.println("Color: " + color);
    }
}

Shape s = new Shape(); // ❌ Cannot instantiate!
```

### Full Example
```java
abstract class Animal {
    private String name;

    public Animal(String name) { this.name = name; }

    public abstract void sound();     // child must implement
    public abstract String getType(); // child must implement

    public void eat() { System.out.println(name + " eats"); }

    // Template method — uses abstract methods
    public void describe() {
        System.out.println("I am " + name + ", a " + getType());
        sound();
    }
}

class Dog extends Animal {
    public Dog(String name) { super(name); }

    @Override public void sound()        { System.out.println("Woof!"); }
    @Override public String getType()    { return "Dog"; }
}

class Cat extends Animal {
    public Cat(String name) { super(name); }

    @Override public void sound()        { System.out.println("Meow!"); }
    @Override public String getType()    { return "Cat"; }
}
```

### Template Method Pattern
Abstract class defines the **skeleton** — children fill in the steps.

```java
abstract class DataProcessor {
    // Template — fixed order of steps
    public final void process() {
        readData();
        processData();
        writeData();
    }

    public abstract void readData();
    public abstract void processData();
    public abstract void writeData();
}
```

### Abstract Class vs Interface vs Concrete Class
| Feature | Abstract Class | Interface | Concrete Class |
|---|---|---|---|
| Instantiate | ❌ No | ❌ No | ✅ Yes |
| Abstract methods | ✅ Yes | ✅ Yes (default) | ❌ No |
| Concrete methods | ✅ Yes | ✅ (default/static) | ✅ Yes |
| Constructor | ✅ Yes | ❌ No | ✅ Yes |
| Variables | Any type | `public static final` only | Any type |
| Multiple inherit | ❌ No | ✅ Yes | ❌ No |
| When to use | Shared base + partial abstraction | Pure contract / capability | Full implementation |

---

## 15. Polymorphism

### What is Polymorphism?
**One thing in many forms** — same method name, different behaviors.

```
Polymorphism
├── Compile-Time (Static)  → Method Overloading
└── Run-Time (Dynamic)     → Method Overriding
```

### Compile-Time Polymorphism
Resolved by **compiler** based on method signature.
```java
obj.add(2, 3);      // add(int, int)
obj.add(2.5, 3.5);  // add(double, double)
obj.add(1, 2, 3);   // add(int, int, int)
```

### Run-Time Polymorphism (Dynamic Method Dispatch)
Parent reference → Child object. JVM decides at **runtime** based on actual object.

```java
Animal a1 = new Dog(); // Parent ref, Child object
Animal a2 = new Cat();

a1.sound(); // Dog barks  ← JVM decides at runtime
a2.sound(); // Cat meows  ← JVM decides at runtime
```

### Upcasting & Downcasting
```java
// Upcasting — automatic (Child → Parent ref)
Animal a = new Dog(); // ✅ implicit

// Downcasting — manual (Parent → Child ref)
Dog d = (Dog) a;      // ✅ explicit
d.bark();

// Wrong downcast — ClassCastException at runtime!
Animal a = new Cat();
Dog d = (Dog) a; // ❌ RuntimeError!

// Safe downcast — always check with instanceof first
if (a instanceof Dog) {
    Dog d = (Dog) a;
    d.bark(); // ✅ safe
}
```

### What is NOT Polymorphic
```java
Parent obj = new Child();

obj.staticMethod();  // Parent's — reference type wins (NOT polymorphic)
obj.privateMethod(); // Not inherited — NOT polymorphic
obj.finalMethod();   // Cannot override — NOT polymorphic
```

### Covariant Return Type
```java
class Animal {
    public Animal getInstance() { return new Animal(); }
}

class Dog extends Animal {
    @Override
    public Dog getInstance() { return new Dog(); } // ✅ Dog is subtype of Animal
}
```

### Compile-Time vs Run-Time
| Feature | Compile-Time | Run-Time |
|---|---|---|
| Achieved by | Overloading | Overriding |
| Resolved at | Compile time | Runtime |
| Decided by | Method signature | Actual object type |
| Inheritance needed | ❌ No | ✅ Yes |
| Performance | Faster | Slightly slower |

---

## 16. Interfaces

### What is an Interface?
A **100% abstract blueprint** — defines **what** a class must do, not **how**.
It's a **contract** — if you implement it, you MUST fulfill all its terms.

```java
interface Animal {
    void sound(); // public abstract by default
    void eat();
}

class Dog implements Animal {
    @Override public void sound() { System.out.println("Dog barks"); }
    @Override public void eat()   { System.out.println("Dog eats"); }
}
```

### Key Rules of Interface
```java
interface Demo {
    int MAX = 100;              // public static final (constant)
    void show();                // public abstract (must implement)

    default void greet() {      // default method — Java 8+
        System.out.println("Hello!");
    }

    static void info() {        // static method — Java 8+
        System.out.println("Interface static");
    }

    private void helper() {     // private method — Java 9+
        System.out.println("Private helper");
    }
}
```

### Multiple Interface Implementation
```java
interface Flyable  { void fly(); }
interface Swimmable{ void swim(); }
interface Runnable { void run(); }

class Duck implements Flyable, Swimmable, Runnable {
    public void fly()  { System.out.println("Duck flies"); }
    public void swim() { System.out.println("Duck swims"); }
    public void run()  { System.out.println("Duck runs"); }
}
```

### Interface Extending Interface
```java
interface Vehicle { void start(); void stop(); }

interface ElectricVehicle extends Vehicle {
    void charge(); // adds to Vehicle contract
}
```

### Default Method — Diamond Problem Resolution
```java
interface A { default void greet() { System.out.println("A"); } }
interface B { default void greet() { System.out.println("B"); } }

class C implements A, B {
    @Override
    public void greet() {
        A.super.greet(); // explicitly choose A's version
    }
}
```

### Functional Interface — Backbone of Lambda
```java
@FunctionalInterface
interface Greeting {
    void sayHello(String name); // ONLY ONE abstract method
}
```

| Built-in Interface | Method | Use |
|---|---|---|
| `Runnable` | `run()` | Thread task |
| `Predicate<T>` | `test()` | Returns boolean |
| `Function<T,R>` | `apply()` | Input → Output |
| `Consumer<T>` | `accept()` | Takes input, returns nothing |
| `Supplier<T>` | `get()` | No input, returns value |
| `Comparator<T>` | `compare()` | Sorting |

---

## 17. Loose Coupling

### What is Coupling?
How **dependent** one class is on another.
```
Tight Coupling → depends on concrete class → hard to change, hard to test
Loose Coupling → depends on abstraction   → easy to swap, easy to test
```

### Tight Coupling — Problem
```java
class UserService {
    MySQLDatabase db = new MySQLDatabase(); // directly depends!

    public void getUser() {
        db.connect();
        // if we switch to MongoDB — must CHANGE UserService!
    }
}
```

### Loose Coupling — Solution (Interface + Dependency Injection)
```java
// Step 1 — Define contract
interface Database {
    void connect();
    void getData();
}

// Step 2 — Multiple implementations
class MySQLDatabase  implements Database { ... }
class MongoDatabase  implements Database { ... }
class OracleDatabase implements Database { ... }

// Step 3 — Depend on interface, not implementation
class UserService {
    private Database db;  // depends on abstraction!

    public UserService(Database db) {
        this.db = db;     // inject from outside
    }

    public void getUser() {
        db.connect();
        db.getData();
    }
}

// Usage — swap database with ZERO changes to UserService
new UserService(new MySQLDatabase()).getUser();
new UserService(new MongoDatabase()).getUser();
```

### Tight vs Loose — Comparison
| Feature | Tight Coupling | Loose Coupling |
|---|---|---|
| Dependency | On concrete class | On interface |
| Flexibility | Hard to change | Easy to swap |
| Testability | Hard to mock | Easy to mock |
| Reusability | Low | High |
| Maintenance | Costly | Cheap |

> **Rule:** Program to an **interface**, not an implementation.

---

## 18. Lambda Functions

### What is a Lambda?
A **short, anonymous function** — no name, no class, just logic. Works only with **Functional Interfaces**. Introduced in **Java 8**.

```java
// Normal anonymous class
Greeting g = new Greeting() {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello " + name);
    }
};

// Lambda — same thing, much shorter!
Greeting g = name -> System.out.println("Hello " + name);
```

### Lambda Syntax
```java
// No params
() -> System.out.println("Hello!")

// Single param — parentheses optional
name -> System.out.println(name)

// Multiple params
(a, b) -> a + b

// Multi-line body
(a, b) -> {
    int sum = a + b;
    return sum;
}
```

### Built-in Functional Interfaces

#### Predicate — Returns boolean
```java
Predicate<Integer> isEven = n -> n % 2 == 0;
System.out.println(isEven.test(4)); // true

// Combining
Predicate<Integer> isPos   = n -> n > 0;
Predicate<Integer> both    = isEven.and(isPos);
System.out.println(both.test(4));   // true
System.out.println(both.test(-4));  // false
```

#### Function — Input → Output
```java
Function<String, Integer> length = s -> s.length();
Function<Integer, Integer> square = n -> n * n;

System.out.println(length.apply("Hello")); // 5
System.out.println(square.apply(4));       // 16

// Chaining
Function<String, Integer> lengthThenSquare = length.andThen(square);
System.out.println(lengthThenSquare.apply("Hello")); // 25
```

#### Consumer — Takes input, returns nothing
```java
Consumer<String> print    = s -> System.out.println(s);
Consumer<String> printUp  = s -> System.out.println(s.toUpperCase());
Consumer<String> combined = print.andThen(printUp);

combined.accept("java");
// java
// JAVA
```

#### Supplier — No input, returns value
```java
Supplier<String>  greeting = () -> "Hello World!";
Supplier<Integer> random   = () -> new Random().nextInt(100);

System.out.println(greeting.get()); // Hello World!
System.out.println(random.get());   // random 0-99
```

### Lambda with Collections
```java
List<String> names = Arrays.asList("Charlie", "Alice", "Bob");

// Sort with lambda
names.sort((a, b) -> a.compareTo(b));

// forEach with lambda
names.forEach(name -> System.out.println(name));

// forEach with method reference
names.forEach(System.out::println);
```

### Lambda + Stream API
```java
List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

// Filter evens, square them
List<Integer> result = numbers.stream()
    .filter(n -> n % 2 == 0)       // [2, 4, 6, 8, 10]
    .map(n -> n * n)                // [4, 16, 36, 64, 100]
    .collect(Collectors.toList());

// Sum all
int sum = numbers.stream()
    .reduce(0, (a, b) -> a + b);   // 55
```

### Method References — Shorthand for Lambda
```java
// 1. Static method reference
Function<String, Integer> parse = Integer::parseInt;

// 2. Instance method reference (specific object)
Supplier<String> upper = str::toUpperCase;

// 3. Instance method reference (arbitrary object)
Function<String, String> toUpper = String::toUpperCase;

// 4. Constructor reference
Supplier<ArrayList> listFactory = ArrayList::new;
```

### Custom Functional Interface + Lambda
```java
@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}

public static int apply(int a, int b, MathOperation op) {
    return op.operate(a, b);
}

// Usage
System.out.println(apply(5, 3, (a, b) -> a + b)); // 8
System.out.println(apply(5, 3, (a, b) -> a * b)); // 15
System.out.println(apply(5, 3, (a, b) -> (int) Math.pow(a, b))); // 125
```

### Interface + Loose Coupling + Lambda Together
```java
@FunctionalInterface
interface Notification {
    void send(String message);
}

class NotificationService {
    public void notify(Notification n, String message) {
        n.send(message); // polymorphic!
    }
}

// Lambda replaces entire implementation class!
service.notify(msg -> System.out.println("Email: " + msg), "Welcome!");
service.notify(msg -> System.out.println("SMS: " + msg),   "OTP: 1234");
service.notify(msg -> System.out.println("Push: " + msg),  "New message!");
```

---

## 19. OOP Pillars — Big Picture

### The 4 Pillars of OOP

```
OOP
│
├── Encapsulation
│   ├── private fields
│   ├── public getters/setters
│   └── Validation in setters
│
├── Inheritance
│   ├── extends keyword
│   ├── super keyword
│   ├── Types: Single, Multilevel, Hierarchical
│   └── NOT Multiple (use Interface instead)
│
├── Polymorphism
│   ├── Compile-Time → Overloading
│   └── Run-Time     → Overriding + Dynamic Dispatch
│
└── Abstraction
    ├── Abstract Class → partial abstraction
    └── Interface      → full abstraction / contract
```

### When to Use What — Decision Guide
```
Need an object created directly?
├── YES → Concrete Class
└── NO  →
        Share common code/state among related classes?
        ├── YES → Abstract Class
        └── NO  →
                Define capability across unrelated classes?
                └── YES → Interface
```

### Full Hierarchy Example
```java
// Interface — pure contract
interface Payable { double calculatePay(); }

// Abstract Class — partial implementation
abstract class Staff implements Payable {
    private String name;
    public Staff(String name) { this.name = name; }
    public abstract String getRole();
    public void display() {
        System.out.println(name + " | " + getRole() + " | ₹" + calculatePay());
    }
}

// Concrete Classes
class FullTime extends Staff {
    double salary;
    public FullTime(String name, double salary) { super(name); this.salary = salary; }
    public String getRole()       { return "Full-Time"; }
    public double calculatePay()  { return salary; }
}

class PartTime extends Staff {
    double rate; int hours;
    public PartTime(String name, double rate, int hours) { super(name); this.rate=rate; this.hours=hours; }
    public String getRole()       { return "Part-Time"; }
    public double calculatePay()  { return rate * hours; }
}

// Polymorphism in action
Staff[] team = { new FullTime("Alice", 80000), new PartTime("Bob", 500, 80) };
for (Staff s : team) s.display(); // runtime polymorphism
```

---

## 20. Quick Cheat Sheet

### Java Basics
```
int → 4 bytes, double → 8 bytes, char → 2 bytes (Unicode), boolean → true/false
int/int → int result (beware integer division!)
Widening: byte→short→int→long→float→double (automatic)
Narrowing: must cast explicitly → (int) 45.9 = 45
```

### Class & Object
```
Class = blueprint (no memory)
Object = instance (heap memory)
new   = allocate heap + run constructor + return address
null  = reference pointing to nothing → NullPointerException if used
```

### Stack & Heap
```
Stack → method frames, local vars, references → StackOverflowError
Heap  → objects, instance vars → OutOfMemoryError → Garbage Collected
```

### Encapsulation
```
private fields + public getters/setters + validation = Encapsulation
```

### this Keyword
```
this.variable   → instance var vs parameter
this()          → constructor chain (must be first line)
return this     → method chaining
```

### Constructors
```
No return type + same name as class + called on new
Default → auto-provided if no constructor written
Chaining → this() must be first line
Order in Inheritance → Parent constructor first, then Child
```

### static Keyword
```
static variable → shared by all objects, one copy, Method Area
static method   → no object needed, no this/super
static block    → runs once on class load, before main()
static final    → constant, UPPER_CASE
Can override static? NO → Method Hiding
Why main() is static? JVM calls without object
```

### Inheritance
```
extends    → inherit from parent class
super      → access parent variable/method/constructor
super()    → must be first line in constructor
IS-A       → inheritance
HAS-A      → composition (object as field)
Multiple   → NOT allowed with classes, use Interface
final class  → cannot extend
final method → cannot override
```

### Abstract Class
```
abstract class → cannot instantiate
abstract method → no body, MUST be overridden
has constructor → called via super()
Template Method → final method using abstract methods
```

### Polymorphism
```
Compile-Time → Overloading → same class → compiler decides
Run-Time     → Overriding  → child class → JVM decides

Upcasting    → Animal a = new Dog() → automatic
Downcasting  → Dog d = (Dog) a      → manual + check instanceof first

NOT polymorphic: static (method hiding), private, final
Covariant return type → override with subtype return
```

### Interface
```
implements  → implement interface
interface   → public abstract methods (default)
            → public static final variables
            → default methods (Java 8)
            → static methods (Java 8)
Multiple    → class implements A, B, C ✅
Functional  → exactly 1 abstract method → Lambda ready
Diamond fix → A.super.method() or B.super.method()
```

### Loose Coupling
```
Tight  → depends on concrete class → brittle
Loose  → depends on interface      → flexible
Dependency Injection → pass implementation from outside
Program to interface, not implementation!
```

### Lambda Functions
```
(params) -> body
() -> no params
name -> single param (parens optional)
(a,b) -> { multiple lines; return x; }

Predicate → test()   → boolean
Function  → apply()  → T → R
Consumer  → accept() → void
Supplier  → get()    → no input

Method Reference: Class::method, obj::method, Class::new
Stream: .filter().map().reduce().collect()
```

### OOP Decision Rule
```
Concrete Class  → full working implementation
Abstract Class  → shared base code + forced structure on children
Interface       → pure contract + multiple capability + loose coupling
Lambda          → short implementation of functional interface
```

---

*Java OOPs — Complete Study Guide | Covers: Fundamentals → OOP → Advanced*
