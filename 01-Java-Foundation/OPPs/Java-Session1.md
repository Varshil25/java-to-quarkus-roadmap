# Java Fundamentals — Class 1 Notes

---

## Overview

### Why Java?
- **Platform Independent** — Write Once, Run Anywhere (WORA)
- **Object Oriented** — everything is modelled as objects

Java compiles to **bytecode**, not machine code, so it runs on any OS that has a JVM installed.

### Language Levels (Low → High)
| Level | Examples | Converted by |
|---|---|---|
| Machine code (MLL) | `10010`, `00111` | — |
| Assembly (ALL) | `ADD`, `SUB`, `MUL` | Assembler |
| High-Level Language (HLL) | Java, C++, Python | Compiler |

### Computer Memory Hierarchy
| Storage | Type | Speed | Notes |
|---|---|---|---|
| HDD / SSD | Non-volatile | Slow | Permanent, magnetic/flash |
| RAM | Volatile | Fast | Semiconductor, compact, loses data on power off |
| Register / Cache | Volatile | Fastest | Inside CPU, tiny but extremely fast |

---

## How Java Runs

```
Demo.java  →  Java Compiler (javac)  →  Demo.class (bytecode)  →  JVM  →  CPU
```

- The Java compiler produces **bytecode**, not platform-specific machine code.
- The **JVM (Java Virtual Machine)** on each platform translates bytecode to native CPU instructions.
- Different OS → different JVM → same bytecode → platform independence.

---

## Data Types

### What is a Variable?

```java
int age = 15;
 ↑        ↑    ↑
data    var   data/info
type   name   (value)
```

- `=` is the **assignment operator**, not equality.

### Primitive Data Types

| Type | Size | Range | Default? | Example |
|---|---|---|---|---|
| `byte` | 1 byte | -128 to 127 | | `byte a = 45;` |
| `short` | 2 bytes | -32768 to 32767 | | `short b = 45;` |
| `int` | 4 bytes | ~-2.1B to 2.1B | ✅ integer | `int c = 5;` |
| `long` | 8 bytes | very large | | `long d = 45l;` |
| `float` | 4 bytes | decimal (IEEE) | | `float f = 45.65f;` |
| `double` | 8 bytes | decimal (IEEE) | ✅ decimal | `double d = 45.4;` |
| `char` | 2 bytes | Unicode (65,536) | | `char c = 'f';` |
| `boolean` | — | `true` / `false` | | `boolean b = true;` |

> **Default types:** integer literals default to `int`; decimal literals default to `double`.  
> Append `l` or `L` for long, `f` or `F` for float.

### Non-Primitive (Object) Types
- `String`, arrays, classes, etc.
- Examples: Image, Video, Audio

---

## Characters, ASCII & Unicode

- Every character maps to a number.
- **ASCII** covers 128 characters:
  - `A` = 65 → `01000001`
  - `a` = 97 → `01100001`
  - Range covers: A–Z, a–z, 0–9, `%$#!`…

- Java uses **Unicode (UTF-16)** — 65,536 possible characters → 16 bits → **2 bytes**
- That's why `char` is 2 bytes in Java (unlike C/C++ where it's 1 byte).

```java
char a = 'a';       // valid
char b = '@';       // valid
char c = '4';       // valid — digits are chars too
// char x = 'ha';   // ILLEGAL — char holds exactly ONE character
```

---

## Memory Size Facts

- 1 byte = **8 bits**
- 1 bit = 2 transistors (stores 0 or 1)
- 1 MB = 1024 × 8 × 2 transistors worth of data
- For `short` (2 bytes = 16 bits): range = -2¹⁵ to 2¹⁵ − 1 → **-32768 to 32767**
- For `byte` (1 byte = 8 bits): range = -2⁷ to 2⁷ − 1 → **-128 to 127**

---

## OOP Basics

### The OOP Mindset
- Consider the **whole world as an object**.
- Objects belong to certain types (**classes**) — they represent something with properties and behaviours.
- A class doesn't need to exist physically; it's a **blueprint**.

### Class vs Object
- **Class** = blueprint / template
- **Object** = a real instance created from that blueprint

```java
class Dog {
    String name;
    int age;
    String color;

    void bark()  { }
    void sleep() { }
    void run()   { }
    void eat()   { }
}
```

```java
class Student {
    String name;
    int age;

    void sleep() { }
    void study() { }
}
```

### Static vs Dynamic Typing

| | Statically Typed | Dynamically Typed |
|---|---|---|
| Examples | Java, C, C++ | Python, JavaScript |
| Type declaration | Explicit | Inferred at runtime |

```java
// Java (static)
int age = 16;
String name = "Rohan";
```

```python
# Python (dynamic)
age = 16
name = "rohan"
```

> **Real-world lesson:** The **Ariane 5 rocket failure** (1996) was caused by a data type overflow — a 64-bit float was converted to a 16-bit integer. This destroyed a $500M rocket. Data types matter.

### OOP Concepts Ahead
- Encapsulation, Inheritance, Polymorphism, Abstraction, Interface

---

## Naming Conventions

| Entity | Convention | Example |
|---|---|---|
| Class | PascalCase | `TeluskoAlien` |
| Method | camelCase | `listTheAvg()`, `mainMethod()` |
| Variable | camelCase | `averageOfMarks`, `salaryOfEmployee` |

---

## Code Walkthrough

### LaunchDemo1 — Declaring All Primitive Types

```java
public class LaunchDemo1 {
    public static void main(String[] args) {

        byte  a = 45;           // 1 byte
        short b = 45;           // 2 bytes
        int   c = 5;            // 4 bytes (default integer type)
        long  d = 45l;          // 8 bytes — suffix 'l'

        // Real numbers
        float  data  = 45.65656f;   // 4 bytes — suffix 'f'
        double data2 = 5454.444444; // 8 bytes (default decimal type)

        char gf = 'f';
        char bf = '4';
        // char bf = 'ha';  // ILLEGAL — only one character allowed

        boolean agree = true;
        boolean ag    = false;
    }
}
```

### LaunchDemo2 — Increment / Decrement Preview

```java
public class LaunchDemo2 {
    public static void main(String[] args) {

        int a = 5;
        int b;

        // Post-increment (a++): use value THEN increment
        // Pre-increment (++a):  increment THEN use value

        // b = a++ + a++ + ++a + ++a + a++;

        // Operators coming up:
        // arithmetic, relational, logical, if-else, loops
    }
}
```

### Key Syntax Rules

| Rule | Example |
|---|---|
| `long` literal needs `l` suffix | `long d = 45l;` |
| `float` literal needs `f` suffix | `float f = 45.65f;` |
| `char` uses single quotes, one character only | `char c = 'a';` |
| `String` uses double quotes | `String s = "Rohan";` |
| Reserved words can't be variable names | `class`, `int`, `void`, `try`, `catch`… |

---

## Type Casting (LaunchDemo3)

Converting data from one type to another.

### Implicit Type Casting (Widening / Numeric Promotion)
Java automatically promotes smaller types to larger ones — no data is lost:

```
byte → short → int → long → float → double
```

```java
byte a = 45;
double b = a;        // implicit — Java widens automatically
System.out.println(b); // 45.0
```

### Explicit Type Casting (Narrowing)
You must manually cast when going from a larger type to a smaller one — possible loss of data:

```java
double c = 45.0;
byte d = (byte) c;   // explicit cast required
System.out.println(d); // 45
```

### Integer Division Trap ⚠️

```java
int a = 12;
int b = 5;
float c = a / b;       // result: 2.0 — NOT 2.4!
```

> **Why?** `a / b` is `int / int` → result is always `int` (truncated toward zero → **2**).  
> That `2` is then widened to `float` → `2.0`.  
> To get `2.4`, cast first: `float c = (float) a / b;`

Also known as: **truncation / rounding toward zero**.

---

## Operators (LaunchOperator)

### Arithmetic Operators

| Operator | Meaning | Example | Result |
|---|---|---|---|
| `+` | Addition | `5 + 6` | `11` |
| `-` | Subtraction | `6 - 5` | `1` |
| `*` | Multiplication | `5 * 6` | `30` |
| `/` | Division | `10 / 5` | `2` |
| `%` | Modulus (remainder) | `5 % 6` | `5` |

```java
int a = 5, b = 6, c = 10;
System.out.println(a + b);  // 11
System.out.println(a * b);  // 30
System.out.println(c / a);  // 2
System.out.println(b - a);  // 1
System.out.println(a % b);  // 5   (5 divided by 6 → remainder 5)
System.out.println(b % a);  // 1   (6 divided by 5 → remainder 1)
```

### Relational Operators
Always return a `boolean` (`true` or `false`):

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
| `\|\|` | OR | `true` if **at least one** is `true` |
| `&&` | AND | `true` only if **all** are `true` |
| `!` | NOT | flips the boolean |

```java
// OR — true if any one is true
System.out.println((5==5) || (5<=5) || (5>4));   // true
System.out.println((5==5) || (5<=4) || (5>6));   // true  (first is true)
System.out.println((5==4) || (5<=4) || (5>6));   // false (all false)

// AND — true only when ALL are true
System.out.println((5==5) && (10>5) && (5>4));   // true
System.out.println((5==5) && (10>5) && (5<4));   // false (last is false)

// NOT
System.out.println(!true);  // false
```

---

## User Input (LaunchUserInput)

Use `Scanner` from `java.util` to read input from the user:

```java
import java.util.Scanner;

public class LaunchUserInput {
    public static void main(String[] args) {
        System.out.println("Enter a number");

        Scanner scan = new Scanner(System.in);

        // scan.nextInt()    → reads int
        // scan.nextFloat()  → reads float
        double c = scan.nextDouble(); // reads double

        System.out.println(c);
    }
}
```

> **Pattern:** create a `Scanner` object → call the appropriate `next___()` method for the data type you expect.

---

## Conditionals (LaunchConditional)

### if / else if / else

```java
int age = 22;

if (age > 18) {
    System.out.println("You're adult now");
} else if (age == 18) {
    System.out.println("Just turned 18!");
} else {
    System.out.println("Kiddo");
}
```

### Nested if-else

```java
if (age >= 18 && age <= 60) {
    if (age > 20) {
        if (age > 30) {
            System.out.println("I hope you're married");
        } else {
            System.out.println("Still acting like a teen?");
        }
    } else {
        System.out.println("You're legal but still a teen");
    }
} else if (age > 60) {
    System.out.println("Uncle! Please be careful!");
} else {
    System.out.println("Kiddo");
}
```

### Ternary Operator

Shorthand for a simple `if-else` that returns a value:

```
(condition) ? value_if_true : value_if_false
```

```java
int number = 4;
String result = (number % 2 == 0) ? "Even" : "ODD";
System.out.println(result); // Even
```

### Finding Maximum of 3 Numbers

```java
int n1 = 5, n2 = 10, n3 = 15;
int maxNum;

if (n1 > n2) {
    maxNum = (n1 > n3) ? n1 : n3;
} else {
    maxNum = (n2 > n3) ? n2 : n3;
}
System.out.println(maxNum); // 15
```

---

## Loops (LaunchLoops & LaunchLoop2)

### Types of Loops
- `for` — when you know how many times to repeat
- `while` — repeat as long as a condition is true
- `do-while` — runs at least once, then checks condition
- `for-each` — used with arrays and collections (coming later)

### for Loop

```java
int n = 5;
for (int i = 0; i < n; i++) {
    System.out.println("*");
}
```

### while Loop

```java
int i = 0, n = 4;
while (i < n) {
    System.out.println("*");
    i++;
}
```

### do-while Loop
Executes the body **at least once**, even if condition is false:

```java
int i = 5, n = 4;
do {
    System.out.println("*");  // prints once even though i > n
    i++;
} while (i < n);
```

### Nested Loops — Printing a Grid (LaunchLoop2)

```java
int n = 5;
for (int i = 0; i < n; i++) {       // rows
    for (int j = 0; j < n; j++) {   // columns
        System.out.print("* ");
    }
    System.out.println();            // move to next line
}
```

Output:
```
* * * * *
* * * * *
* * * * *
* * * * *
* * * * *
```

---

## Patterns with Nested Loops (LaunchPattern1)

Use conditions inside nested loops to control where `*` prints vs spaces.

```java
int n = 8;
for (int i = 0; i <= n; i++) {
    for (int j = 0; j <= n; j++) {
        if ((i == 0 && j < n) || (i == n && j < n) || j == 0 || (j == n && i > 0 && i < n))
            System.out.print("* ");
        else
            System.out.print("  ");
    }
    System.out.println();
}
```

This prints a **rectangular border** pattern. Variations explored in class:

| Condition | Pattern produced |
|---|---|
| `i==0 \|\| j==0 \|\| i==n \|\| j==n` | Full border rectangle |
| `i==0 \|\| j==0 \|\| i==n` | Three-sided border (no right wall) |
| `i==0 \|\| j==n/2` | Top edge + vertical mid-line |
| `i==0 \|\| j==0 \|\| i==n/2 \|\| i==n` | Top, bottom, and two horizontal mid-lines |

> **Key insight:** The outer loop controls **rows**, inner loop controls **columns**. The `if` condition decides what to print at each `(i, j)` cell.

---

## Coming Up Next
- `switch` statement
- `for-each` loop (arrays & collections)
- Methods & Objects (deep dive)
- Encapsulation, Inheritance, Polymorphism, Abstraction, Interface
