# OOP in Java — Class, Object, Stack & Heap

---

## 1. Class

A **class** is a blueprint or template. It defines what an object *will have* (data) and *will do* (behaviour). No memory is used just by defining a class.

A class has three parts:

| Part | What it is | Example |
|---|---|---|
| Fields | Instance variables — the data | `String brand;` |
| Constructor | Sets up the object at creation | `Car(String b) { brand = b; }` |
| Methods | Behaviours the object can perform | `void run() { ... }` |

```java
class Car {

    // Fields (instance variables)
    String brand;
    String color;
    int    year;
    int    hspeed;

    // Constructor — runs automatically when new Car() is called
    Car(String brand, String color, int year, int hspeed) {
        this.brand  = brand;
        this.color  = color;
        this.year   = year;
        this.hspeed = hspeed;
    }

    // Method — reads the fields, never overwrites them
    void run() {
        System.out.println(brand + " | " + color + " | " + year + " | " + hspeed);
    }
}
```

> **Golden rule:** A class is just a plan. It takes up no heap memory until you create an object from it.

---

## 2. Object

An **object** is a real instance created from a class using the `new` keyword. Each object:

- Gets its **own separate copy** of all instance variables
- Shares method definitions with every other object of the same class
- Lives on the **Heap** in memory

```java
public class Main {
    public static void main(String[] args) {

        // Two independent objects from one class
        Car car1 = new Car("Mercedes", "Dark Brown", 2032, 240);
        Car car2 = new Car("Mercedes", "White",      2030, 240);

        car1.run(); // Mercedes | Dark Brown | 2032 | 240
        car2.run(); // Mercedes | White      | 2030 | 240

        // Changing car1 does NOT affect car2
        car1.color = "Red";
        car1.run(); // Mercedes | Red | 2032 | 240
        car2.run(); // Mercedes | White | 2030 | 240  ← unchanged
    }
}
```

### What `new` does — 3 steps

When Java sees `Car car1 = new Car("Mercedes", "Dark Brown", 2032, 240)`:

1. **Allocates memory** on the Heap for all instance variables
2. **Runs the constructor** — sets brand, color, year, hspeed
3. **Returns the address** — stores it in `car1` on the Stack

### Real-world analogy

| Concept | Real-world | Java |
|---|---|---|
| Class | Cookie cutter mold | `class Car { ... }` |
| Object | The actual cookie | `Car c = new Car(...)` |
| Instance variable | Each cookie's own flavor | `c.color = "Red"` |
| Constructor | The recipe | `Car(String b, ...)` |
| Method | What the cookie can do | `c.run()` |
| Reference | A label stuck on the cookie | `Car c` |
| `null` | A label stuck on thin air | `Car c = null` |

---

## 3. Instance Variable vs Local Variable

```java
class Dog {

    String name;   // instance variable — belongs to the whole object
                   // scope: every method in this class
                   // default value: null

    void barks() {
        int age = 4; // local variable — lives only inside barks()
                     // scope: this method only
                     // must be initialised manually — no default
        System.out.println(age); // 4
    }

    void run() {
        // age = 5;  <-- compile error! age doesn't exist here
        System.out.println(name); // fine — name is an instance variable
    }
}
```

| | Instance variable | Local variable |
|---|---|---|
| Declared | Inside class, outside methods | Inside a method |
| Scope | Entire class | That method only |
| Default value | Yes (0, null, false) | No — must be set |
| Lives in memory | Heap (inside the object) | Stack (inside the method frame) |
| Destroyed when | Object is garbage collected | Method returns |

---

## 4. Stack Memory

The **Stack** stores:
- Method call frames (one per active method call)
- Local variables
- Reference variables (the addresses that point to heap objects)

**How it works:**
- When a method is called → a new frame is **pushed** on top
- When the method returns → that frame is **popped and destroyed**
- Last in, first out (LIFO)

```
When main() calls std.info():

┌──────────────────────┐  ← top
│  info() frame        │  currently running
│  (no local vars)     │
├──────────────────────┤
│  main() frame        │  waiting
│  std → @1000         │
│  car → @2000         │
└──────────────────────┘

When info() returns, its frame is destroyed:

┌──────────────────────┐  ← top
│  main() frame        │  running again
│  std → @1000         │
│  car → @2000         │
└──────────────────────┘
```

---

## 5. Heap Memory

The **Heap** stores:
- All objects created with `new`
- Instance variables (they live inside their object on the heap)

**How it works:**
- An object is created when you call `new` → memory allocated on the heap
- The object lives as long as at least one reference points to it
- When no references remain → the **Garbage Collector** reclaims the memory

```
Heap after:  Student std = new Student();
             Car     car = new Car(...);

┌─────────────────────────────┐
│  @1000  Student object      │
│    id         = 101         │
│    name       = "Varshil"   │
│    age        = 21          │
│    department = "CS"        │
├─────────────────────────────┤
│  @2000  Car object          │
│    brand  = "Mercedes"      │
│    color  = "Dark Brown"    │
│    year   = 2032            │
│    hspeed = 240             │
└─────────────────────────────┘
```

---

## 6. Stack + Heap Together

```java
public class Main {
    public static void main(String[] args) {
        Student std = new Student();   // std(@1000) → Stack, object → Heap
        std.info();                    // info() frame pushed then popped

        Car car = new Car();           // car(@2000) → Stack, object → Heap
        car.run();                     // run() frame pushed, writes to @2000, popped
        car.color = "White";           // directly updates @2000 on Heap
        car.year  = 2030;             // directly updates @2000 on Heap
        car.run();                     // run() pushed again — OVERWRITES color + year!
    }
}
```

Step-by-step memory trace:

| Line | Stack | Heap @2000 (Car) |
|---|---|---|
| `Car car = new Car()` | `car → @2000` added | color=null, year=0 |
| `car.run()` | run() frame pushed/popped | color="Dark Brown", year=2032 |
| `car.color = "White"` | nothing changes | color="White" ✓ |
| `car.year = 2030` | nothing changes | year=2030 ✓ |
| `car.run()` again | run() frame pushed/popped | color="Dark Brown" ✗, year=2032 ✗ |

> **The bug explained:** `car.color` and `car.year` were correctly set on the Heap.
> But `run()` contained hardcoded assignments (`color = "Dark Brown"`) that
> overwrote them the moment it was called. The fix: move data into the constructor,
> and keep `run()` as a read-only method.

---

## 7. Stack vs Heap — Quick Reference

| | Stack | Heap |
|---|---|---|
| Stores | Method frames, local vars, references | Objects and instance variables |
| Size | Small and fixed | Large and dynamic |
| Speed | Very fast | Slightly slower |
| Managed by | JVM automatically | Garbage Collector |
| Lifetime | Until method returns | Until no references remain |
| Error when full | `StackOverflowError` | `OutOfMemoryError` |

---

## 8. Common Mistakes to Avoid

**1. Hardcoding values inside methods (your bug)**
```java
// Wrong — run() overwrites heap data every call
void run() {
    color = "Dark Brown"; // this kills any value set before calling run()
}

// Right — constructor sets data, method only reads it
Car(String color) { this.color = color; }
void run() { System.out.println(color); }
```

**2. Calling a method on null**
```java
Car car = null;
car.run(); // NullPointerException — car points to nothing!

// Fix: always create the object before using it
Car car = new Car("Mercedes", "Red", 2030, 240);
car.run(); // works fine
```

**3. Thinking `car2 = car1` copies the object**
```java
Car car1 = new Car("Toyota", "Red", 2030, 200);
Car car2 = car1;          // copies the ADDRESS, not the object!
car2.color = "Blue";
System.out.println(car1.color); // Blue — same object was modified!

// Fix: create a new object if you want independence
Car car2 = new Car(car1.brand, "Blue", car1.year, car1.hspeed);
```

---

*Notes based on Java OOP lecture — Class 5*
