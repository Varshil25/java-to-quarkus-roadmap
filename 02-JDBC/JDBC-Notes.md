# JDBC Notes — Complete Reference

---

## 1. What is JDBC?
- **JDBC** stands for **Java Database Connectivity**
- JDBC is the **bridge** between Java Application and Database (local, cloud, or remote)

---

## 2. Steps to Develop a JDBC Application

```
1. Import required packages + Download & Add DB-specific JAR
2. Load and Register the Driver
3. Establish the Connection
4. Create the Statement
5. Execute the CRUD Queries
6. Process the Result
7. Close the Connection
```

---

## 3. Load and Register the Driver

```java
Class.forName("com.mysql.cj.jdbc.Driver");
```

- Loads the driver class dynamically at runtime
- Triggers the **static block** inside the driver → auto registers with `DriverManager`
- Must handle **`ClassNotFoundException`** — Java tried to load a class by name (String) but could not find it on the classpath

### Two Ways to Load Driver

```java
// Way 1 — Indirect, Loosely Coupled ✅ (Recommended)
Class.forName("com.mysql.cj.jdbc.Driver");

// Way 2 — Direct, Tightly Coupled ⚠️
DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
```

| | `Class.forName()` | `registerDriver()` |
|---|---|---|
| Coupling | Loosely coupled ✅ | Tightly coupled ❌ |
| Registration | Via static block (auto) | Manual |
| Double Registration | ❌ No risk | ⚠️ Risk of registering twice |
| Flexibility | Load from config file ✅ | Hardcoded ❌ |

---

## 4. Establish the Connection

```java
Connection con = DriverManager.getConnection(url, user, password);
```

- Only **opens the door** to DB — cannot execute SQL alone
- Must handle **`SQLException`** — something went wrong communicating with the database

---

## 5. Create the Statement

```java
Statement st = con.createStatement();
```

- The **messenger** — carries SQL from Java to Database
- `Connection` has no method to run SQL directly — Statement is required

### 3 Types of Statement

| Type | Use For |
|---|---|
| `Statement` | Fixed SQL, no user input |
| `PreparedStatement` | Dynamic values, user input (safer) |
| `CallableStatement` | Stored procedures |

---

## 6. Execute Methods

| Method | Use For | Returns |
|---|---|---|
| `executeQuery()` | SELECT only | `ResultSet` |
| `executeUpdate()` | INSERT, UPDATE, DELETE | `int` (rows affected) |
| `execute()` | ANY SQL — universal | `boolean` |

### `execute()` — Universal Method

```java
boolean status = st.execute(sql);

if(status) {
    // true = SELECT — get the ResultSet
    ResultSet rs = st.getResultSet();
    while(rs.next()) {
        System.out.println(rs.getInt(1) + " " + rs.getString(2));
    }
} else {
    // false = INSERT / UPDATE / DELETE — get rows affected
    int rowsAffected = st.getUpdateCount();
}
```

> Use `execute()` when you **don't know in advance** what type of SQL will run.

---

## 7. CRUD with Statement

### INSERT
```java
String sql = "INSERT INTO studentinfo(id, sname, sage, scity) VALUES(2, 'Tisha', 23, 'Roxboury')";
int rowAffected = st.executeUpdate(sql);

if(rowAffected == 0) {
    System.out.println("Insertion not executed!");
} else {
    System.out.println("Insertion done successfully!");
}
```

### UPDATE
```java
String sql = "UPDATE studentinfo SET sage = 23 WHERE id = 1";
int rowAffected = st.executeUpdate(sql);

if(rowAffected == 0) {
    System.out.println("Data not updated!");
} else {
    System.out.println("Data updated successfully!");
}
```

### DELETE
```java
String sql = "DELETE FROM studentinfo WHERE id = 1";
int rowAffected = st.executeUpdate(sql);

if(rowAffected == 0) {
    System.out.println("Data not deleted!");
} else {
    System.out.println("Data deleted successfully!");
}
```

### SELECT (Retrieve)
```java
String sql = "SELECT * FROM studentinfo";
ResultSet rs = st.executeQuery(sql);

while(rs.next()) {
    // Way 1 — Column Index (starts from 1, NOT 0)
    System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4));

    // Way 2 — Column Name (Recommended ✅)
    System.out.println(rs.getInt("id") + " " + rs.getString("sname") + " " + rs.getInt("sage") + " " + rs.getString("scity"));
}
rs.close();
```

> `ResultSet` is a **cursor** that holds SELECT data — `rs.next()` moves row by row, `rs.getXxx("columnName")` retrieves each value.

---

## 8. PreparedStatement

> Use `PreparedStatement` **always** when SQL has dynamic values from user input — safer, cleaner, and faster than `Statement`.

### Statement vs PreparedStatement

| | `Statement` | `PreparedStatement` |
|---|---|---|
| SQL | Fixed, hardcoded | Template with `?` placeholders |
| Compilation | Every execution | Once — reused many times |
| Performance | ❌ Slower | ✅ Faster |
| SQL Injection | ❌ Vulnerable | ✅ Safe |
| Dynamic Values | ❌ Concatenation | ✅ `setXxx()` methods |
| Best For | Fixed SQL | User input / dynamic values |

### INSERT
```java
String sql = "INSERT INTO studentinfo(id, sname, sage, scity) VALUES(?,?,?,?)";
pst = connect.prepareStatement(sql);

pst.setInt(1, 101);
pst.setString(2, "John");
pst.setInt(3, 22);
pst.setString(4, "Boston");

int rowAffected = pst.executeUpdate();
System.out.println("Inserted: " + rowAffected + " row");
```

### UPDATE
```java
String sql = "UPDATE studentinfo SET sname=?, sage=?, scity=? WHERE id=?";
pst = connect.prepareStatement(sql);

pst.setString(1, "Tisha");
pst.setInt(2, 25);
pst.setString(3, "NewYork");
pst.setInt(4, 101);   // ← WHERE condition always LAST

int rowAffected = pst.executeUpdate();
System.out.println("Updated: " + rowAffected + " row");
```

### DELETE
```java
String sql = "DELETE FROM studentinfo WHERE id=?";
pst = connect.prepareStatement(sql);

pst.setInt(1, 101);   // ← just the WHERE value

int rowAffected = pst.executeUpdate();
System.out.println("Deleted: " + rowAffected + " row");
```

### SELECT — All Data
```java
String sql = "SELECT * FROM studentinfo";
pst = connect.prepareStatement(sql);

ResultSet rs = pst.executeQuery(); // ← no ? so no setXxx needed

while(rs.next()) {
    System.out.println(rs.getInt("id") + " " + rs.getString("sname") + " " + rs.getInt("sage") + " " + rs.getString("scity"));
}
```

### SELECT — With WHERE Condition
```java
String sql = "SELECT * FROM studentinfo WHERE id=?";
pst = connect.prepareStatement(sql);

pst.setInt(1, 101); // ← set the WHERE value

ResultSet rs = pst.executeQuery();

if(rs.next()) {
    System.out.println(rs.getInt("id") + " " + rs.getString("sname") + " " + rs.getInt("sage") + " " + rs.getString("scity"));
} else {
    System.out.println("No record found!");
}
```

---

## 9. Batch Update

> Instead of sending SQL to DB **one by one**, Batch Update sends **multiple statements together in one trip.**

```java
connect.setAutoCommit(false); // ← Always turn off auto commit for batch

String sql = "INSERT INTO studentinfo(id, sname, sage, scity) VALUES(?,?,?,?)";
pst = connect.prepareStatement(sql);

// Row 1
pst.setInt(1, 1); pst.setString(2, "John"); pst.setInt(3, 22); pst.setString(4, "Boston");
pst.addBatch();

// Row 2
pst.setInt(1, 2); pst.setString(2, "Tisha"); pst.setInt(3, 23); pst.setString(4, "Roxboury");
pst.addBatch();

// Row 3
pst.setInt(1, 3); pst.setString(2, "Alex"); pst.setInt(3, 25); pst.setString(4, "NewYork");
pst.addBatch();

try {
    int[] results = pst.executeBatch(); // ← ONE trip — sends all together
    connect.commit();                   // ← Save all on success
    System.out.println("Batch inserted: " + results.length + " rows");
} catch (SQLException e) {
    connect.rollback();                 // ← Undo all if error
    System.out.println("Batch failed! Rolled back.");
}
```

| Method | Purpose |
|---|---|
| `addBatch()` | Adds SQL to the batch queue |
| `executeBatch()` | Sends ALL at once — returns `int[]` |
| `setAutoCommit(false)` | Always use with batch |
| `commit()` | Save all on success |
| `rollback()` | Undo all on failure |

---

## 10. JDBCUtil — Reusable Helper Class

```java
public class JDBCUtil {

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // loads driver ONCE
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/jdbclearning";
        String user = "root";
        String password = "root";
        return DriverManager.getConnection(url, user, password);
    }

    public static void closeConnection(Connection connect, Statement st) throws SQLException {
        if(st != null) st.close();       // close Statement first
        if(connect != null) connect.close(); // then close Connection
    }
}
```

- `static block` → loads driver **once** when class is first used
- `static methods` → no object needed to call
- Same package → JVM **auto finds and loads** it when first referenced

---

## 11. Exceptions Reference

| Exception | Means | Fix |
|---|---|---|
| `ClassNotFoundException` | Driver JAR missing or wrong class name | Add MySQL JAR / fix class name |
| `SQLException` | DB error — wrong credentials, bad SQL, server down | Check URL, credentials, SQL |
| `InstantiationException` | Cannot create object — abstract class or interface | Make class concrete with constructor |
| `IllegalAccessException` | Constructor is private — no permission | Make constructor `public` |

---

## 12. Close Order — Always Reverse ⚠️

```
Open  : Connection → Statement → ResultSet
Close : ResultSet → Statement → Connection
```

```java
rs.close();       // 1st
st.close();       // 2nd
connect.close();  // 3rd
```

---

## 13. Golden Rules

| Rule | Why |
|---|---|
| Always use `try-catch-finally` | Prevents crash and resource leak |
| Use `PreparedStatement` | Prevents SQL Injection |
| Always use `WHERE` in UPDATE/DELETE | Prevents mass data change |
| Use column **name** over index | Safer and more readable |
| Check for **null** values | Prevents NullPointerException |
| Use `while(rs.next())` for multiple rows | Iterates all rows |
| Use `if(rs.next())` for single row | Checks if record exists |
| Always put WHERE `?` last in UPDATE | Correct placeholder order |
| Use `setAutoCommit(false)` with batch | All succeed or all fail together |
| Close `ResultSet` in finally | Prevents memory leak |

---

## 14. One Line Summaries 🔑

| | |
|---|---|
| `Class.forName()` | Load driver by name |
| `Connection` | Open door to DB |
| `Statement` | Send fixed SQL to DB |
| `PreparedStatement` | Send safe dynamic SQL to DB |
| `ResultSet` | Hold SELECT results |
| `execute()` | Universal SQL runner |
| `finally` | Always closes resources |
| `JDBCUtil` | Reusable DB helper class |
| `addBatch()` + `executeBatch()` | Send multiple SQL in one trip |
