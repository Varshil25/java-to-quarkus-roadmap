# ☕ Apache Maven — End-to-End Complete Guide

> A complete reference from basics to advanced concepts — GAV, POM, Lifecycle, Plugins, Transitive Dependencies, Vulnerabilities, and more.

---

## 📚 Table of Contents

1. [What is Maven?](#1-what-is-maven)
2. [What is POM?](#2-what-is-pom-project-object-model)
3. [GAV Coordinates](#3-gav-coordinates--every-library-has-3-things)
4. [How to Add Dependencies](#4-how-to-add-dependencies-in-pomxml)
5. [Transitive Dependencies](#5-transitive-dependencies)
6. [How Maven Works](#6-how-maven-works--the-repository-system)
7. [Build Lifecycle](#7-maven-build-lifecycle)
8. [Effective POM](#8-what-is-the-effective-pom)
9. [Maven Archetype](#9-maven-archetype)
10. [Maven Plugins](#10-maven-plugins)
11. [Vulnerabilities](#11-vulnerabilities-in-dependencies--how-to-handle)
12. [dependencyManagement](#12-dependencymanagement--centralizing-versions)
13. [Multi-Module Projects](#13-multi-module-projects)
14. [Common Commands](#14-common-maven-commands)
15. [Best Practices](#15-best-practices--tips)
16. [Quick Reference Card](#16-quick-reference-card)

---

## 1. What is Maven?

Apache Maven is an open-source **build automation and project management tool** primarily used for Java projects. It is maintained by the Apache Software Foundation and uses a declarative XML-based configuration file called `pom.xml`.

Maven does two core things:

| # | Task | Description |
|---|------|-------------|
| ① | **Build Automation** | Compiles code, runs tests, packages JARs/WARs/EARs |
| ② | **Dependency Management** | Downloads and manages external libraries automatically |

> 💡 Think of Maven as a smart assistant for your Java project — it knows how to build, test, package, and deploy your app, and it fetches every library your code needs automatically.

---

## 2. What is POM? (Project Object Model)

**POM** stands for **Project Object Model**. It is the fundamental unit of work in Maven. Every Maven project has a `pom.xml` file at its root, which contains all the information Maven needs to build the project.

### What `pom.xml` contains:

- ✅ Project metadata (name, description, version)
- ✅ Dependencies (external libraries your project needs)
- ✅ Plugins (build tools like compiler, surefire, etc.)
- ✅ Build lifecycle configuration
- ✅ Repository information
- ✅ Developer and organization info

### Minimal `pom.xml` Example:

```xml
<project>
  <modelVersion>4.0.0</modelVersion>

  <groupId>com.mycompany</groupId>
  <artifactId>my-app</artifactId>
  <version>1.0.0</version>
  <packaging>jar</packaging>

  <dependencies>
    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>4.13.2</version>
      <scope>test</scope>
    </dependency>
  </dependencies>

</project>
```

---

## 3. GAV Coordinates — Every Library Has 3 Things

Every artifact (library/project) in Maven is uniquely identified by three coordinates, collectively called **GAV**:

| Coordinate | Full Name | Description & Example |
|---|---|---|
| **G** | `groupId` | Organization/group. Reverse domain name. e.g. `org.springframework`, `com.google.guava` |
| **A** | `artifactId` | The specific project name. e.g. `spring-core`, `guava`, `junit` |
| **V** | `version` | The specific version. e.g. `5.3.20`, `31.1-jre`, `4.13.2` |

### GAV in `pom.xml`:

```xml
<dependency>
  <groupId>org.springframework</groupId>      <!-- G -->
  <artifactId>spring-core</artifactId>        <!-- A -->
  <version>5.3.20</version>                   <!-- V -->
</dependency>
```

> 💡 GAV coordinates are like a GPS address for a library. Without all three, Maven cannot find the exact dependency you need.

---

## 4. How to Add Dependencies in `pom.xml`

Dependencies are declared inside the `<dependencies>` block. Maven will automatically download them from the configured repository.

### Basic Structure:

```xml
<dependencies>

  <!-- Dependency 1 -->
  <dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-core</artifactId>
    <version>5.3.20</version>
  </dependency>

  <!-- Dependency 2 (test scope) -->
  <dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.13.2</version>
    <scope>test</scope>
  </dependency>

</dependencies>
```

### Dependency Scopes:

| Scope | When it is Used |
|---|---|
| `compile` *(default)* | Available in all classpaths. Included in final package. |
| `test` | Only for compiling and running tests. Not in final package. |
| `provided` | Needed for compilation but provided by runtime (e.g., servlet-api by Tomcat). |
| `runtime` | Not needed for compilation, but needed at runtime (e.g., JDBC drivers). |
| `system` | Like `provided`, but you specify the JAR path manually. |

### Where to Find Dependencies — `mavenrepository.com`

Visit 👉 **[https://mvnrepository.com](https://mvnrepository.com)** to search for any Java library.

Steps:
1. Search for the library name (e.g., `Jackson`, `Hibernate`, `Log4j`)
2. Click the version you want
3. Copy the `<dependency>` XML block
4. Paste it inside your `<dependencies>` section in `pom.xml`

---

## 5. Transitive Dependencies

When you add a dependency, that dependency itself may depend on other libraries. Maven automatically downloads those too — these are called **transitive dependencies**.

### Example:

```
Your Project
  └── spring-webmvc         (your direct dependency)
        ├── spring-core      (transitive)
        ├── spring-beans     (transitive)
        └── spring-context   (transitive)
              └── commons-logging  (transitive of transitive)
```

You only declare `spring-webmvc` — Maven handles the rest! ✅

### Excluding a Transitive Dependency:

Sometimes a transitive dependency causes conflicts. You can exclude it:

```xml
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-webmvc</artifactId>
  <version>5.3.20</version>
  <exclusions>
    <exclusion>
      <groupId>commons-logging</groupId>
      <artifactId>commons-logging</artifactId>
    </exclusion>
  </exclusions>
</dependency>
```

> ⚠️ **Dependency conflicts:** If two libraries need different versions of the same transitive dependency, Maven uses **"nearest wins"** — the version closest to your project in the dependency tree wins.

### Viewing the Dependency Tree:

```bash
mvn dependency:tree
```

---

## 6. How Maven Works — The Repository System

Maven follows a **three-tier repository system** to find and cache dependencies.

### Step-by-Step: What Happens When You Add a Dependency

| Step | What Maven Does |
|------|-----------------|
| **Step 1** | You declare a dependency in `pom.xml` with its GAV coordinates. |
| **Step 2** | Maven checks your **Local Repository** (`~/.m2/repository`) first. |
| **Step 3** | If not found locally, Maven checks **Maven Central** (remote repository). |
| **Step 4** | Maven downloads the JAR and its POM file from the remote repository. |
| **Step 5** | Downloaded files are stored in `~/.m2/repository` for future use (no re-download). |
| **Step 6** | Maven reads the dependency's POM to find its transitive dependencies and repeats. |

### The `.m2` Folder (Local Repository):

| OS | Location |
|----|----------|
| Windows | `C:\Users\YourName\.m2\repository` |
| Mac/Linux | `~/.m2/repository` |

- This is Maven's **local cache**. Every downloaded JAR is stored here.
- If you delete `.m2`, Maven will re-download everything on the next build.
- Structure mirrors the GAV: `org/springframework/spring-core/5.3.20/`

### Types of Repositories:

| Repository Type | Description |
|---|---|
| **Local** (`~/.m2`) | Your machine's cache. Maven checks here first. |
| **Central** (Maven Central) | Default public repo at `https://repo1.maven.org/maven2`. Millions of libraries. |
| **Remote** (Corporate) | Private repos like **Nexus** or **Artifactory** used in companies. |

---

## 7. Maven Build Lifecycle

Maven has three built-in lifecycles: **default**, **clean**, and **site**.

### Default Lifecycle Phases (in order):

| Phase | What it Does |
|-------|-------------|
| `validate` | Validates the project structure is correct. |
| `initialize` | Initializes build state, sets properties. |
| `generate-sources` | Generates source code (e.g., from WSDL or XSD). |
| `compile` | Compiles the source code (`src/main/java`). |
| `test-compile` | Compiles the test source code (`src/test/java`). |
| `test` | Runs unit tests using the Surefire plugin. |
| `package` | Packages the compiled code into JAR/WAR/EAR. |
| `verify` | Runs integration tests and quality checks. |
| `install` | Installs the package into the local `~/.m2` repository. |
| `deploy` | Copies the package to a remote repository for sharing. |

> 💡 When you run `mvn package`, Maven runs **ALL phases** from `validate` up to `package` in order. You don't need to run them one by one.

### Clean Lifecycle:

```
pre-clean → clean → post-clean
```

- `mvn clean` deletes the `/target` folder (compiled classes, JARs).
- Always run `mvn clean install` for a fresh, reliable build.

### Site Lifecycle:

```
pre-site → site → post-site → site-deploy
```

- Generates project documentation and reports.

---

## 8. What is the Effective POM?

The **Effective POM** is the final, merged POM that Maven actually uses to build your project. It combines:

1. Your project's `pom.xml`
2. Parent POM (if you have a parent project)
3. **Super POM** (Maven's built-in defaults — every project inherits from this)

### What the Super POM defines by default:

- Source directory: `src/main/java`
- Test directory: `src/test/java`
- Output directory: `target/`
- Default plugins (compiler, surefire, jar, etc.)

### How to View the Effective POM:

```bash
# Command line:
mvn help:effective-pom

# In Eclipse:
# Open pom.xml → click 'Effective POM' tab at the bottom
```

> 💡 The Effective POM is very useful for **debugging**. If a build behaves unexpectedly, check the Effective POM to see exactly what configuration Maven is using.

---

## 9. Maven Archetype

A **Maven Archetype** is a **project template**. It generates a pre-configured project structure so you don't have to create folders and files manually.

### Common Archetypes:

| Archetype | Use Case |
|---|---|
| `maven-archetype-quickstart` | Basic Java application with `src/main/java` and `src/test/java`. |
| `maven-archetype-webapp` | Java web application with `WEB-INF/web.xml` structure. |
| `maven-archetype-simple` | Minimal project with no extra setup. |
| Spring Boot archetype | Spring Boot project. Better to use [start.spring.io](https://start.spring.io) instead. |

### Creating a Project from Archetype (Command Line):

```bash
mvn archetype:generate \
  -DgroupId=com.mycompany \
  -DartifactId=my-app \
  -DarchetypeArtifactId=maven-archetype-quickstart \
  -DarchetypeVersion=1.4 \
  -DinteractiveMode=false
```

### Standard Project Structure (from quickstart archetype):

```
my-app/
├── pom.xml
└── src/
    ├── main/
    │   └── java/
    │       └── com/mycompany/App.java
    └── test/
        └── java/
            └── com/mycompany/AppTest.java
```

---

## 10. Maven Plugins

Almost everything Maven does is through **plugins**. A plugin is a collection of **goals** (tasks).

- **Build plugins** — execute during the build lifecycle
- **Reporting plugins** — generate reports during the site lifecycle

### Important Built-in Plugins:

| Plugin | What it Does |
|---|---|
| `maven-compiler-plugin` | Compiles Java source code. Configure Java version here. |
| `maven-surefire-plugin` | Runs unit tests (JUnit/TestNG). |
| `maven-jar-plugin` | Creates the JAR file. |
| `maven-war-plugin` | Creates the WAR file for web apps. |
| `maven-clean-plugin` | Deletes the `target/` directory. |
| `maven-install-plugin` | Installs artifact into local `.m2` repository. |
| `maven-deploy-plugin` | Deploys artifact to remote repository. |

### Configuring a Plugin in `pom.xml`:

```xml
<build>
  <plugins>
    <plugin>
      <groupId>org.apache.maven.plugins</groupId>
      <artifactId>maven-compiler-plugin</artifactId>
      <version>3.10.1</version>
      <configuration>
        <source>17</source>
        <target>17</target>
      </configuration>
    </plugin>
  </plugins>
</build>
```

---

## 11. Vulnerabilities in Dependencies — How to Handle

When you use third-party libraries, some may have known **security vulnerabilities** (CVEs — Common Vulnerabilities and Exposures).

### How Vulnerabilities Happen:

- A library has a bug that can be exploited by attackers
- Transitive dependencies can also carry vulnerabilities
- Example: **Log4Shell** (CVE-2021-44228) — a critical bug in Log4j2 that affected thousands of apps

### Tools to Detect Vulnerabilities:

| Tool | How to Use |
|---|---|
| **OWASP Dependency-Check** | Maven plugin that scans deps against the NVD (National Vulnerability Database). |
| **Snyk** | CLI tool. Run `snyk test` to check for known CVEs. |
| **mvnrepository.com** | Shows vulnerability badges on library pages. |
| **GitHub Dependabot** | Automatically alerts you about vulnerable dependencies in your repo. |

### Adding OWASP Dependency-Check Plugin:

```xml
<build>
  <plugins>
    <plugin>
      <groupId>org.owasp</groupId>
      <artifactId>dependency-check-maven</artifactId>
      <version>8.2.1</version>
    </plugin>
  </plugins>
</build>
```

```bash
# Then run:
mvn dependency-check:check
```

### How to Fix Vulnerabilities:

1. ✅ Upgrade to a newer, patched version of the library
2. ✅ If it's a transitive dep, explicitly declare the safe version in your `pom.xml`
3. ✅ Exclude the vulnerable transitive dependency and replace with a safe alternative
4. ✅ Check the CVE report for mitigation options

> ⚠️ **Security Rule:** Always keep dependencies up to date. Before releasing to production, run a vulnerability scan. Never ignore HIGH or CRITICAL severity CVEs.

---

## 12. `dependencyManagement` — Centralizing Versions

The `<dependencyManagement>` section lets you declare versions in one place. This is especially useful for **multi-module projects** where child modules inherit versions without specifying them.

```xml
<!-- In parent pom.xml -->
<dependencyManagement>
  <dependencies>
    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-core</artifactId>
      <version>5.3.20</version>  <!-- Declared ONCE here -->
    </dependency>
  </dependencies>
</dependencyManagement>

<!-- In actual <dependencies> section (no version needed): -->
<dependencies>
  <dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-core</artifactId>
    <!-- Version inherited from dependencyManagement -->
  </dependency>
</dependencies>
```

### Using Properties for Version Management:

```xml
<properties>
  <spring.version>5.3.20</spring.version>
  <junit.version>4.13.2</junit.version>
</properties>

<dependencies>
  <dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-core</artifactId>
    <version>${spring.version}</version>
  </dependency>
</dependencies>
```

---

## 13. Multi-Module Projects

A **multi-module Maven project** is a parent project containing multiple sub-projects (modules). Common in enterprise applications.

### Structure:

```
parent-project/
├── pom.xml              ← parent POM (packaging = pom)
├── module-web/
│   └── pom.xml
├── module-service/
│   └── pom.xml
└── module-dao/
    └── pom.xml
```

### Parent `pom.xml`:

```xml
<packaging>pom</packaging>

<modules>
  <module>module-web</module>
  <module>module-service</module>
  <module>module-dao</module>
</modules>
```

### Child `pom.xml`:

```xml
<parent>
  <groupId>com.mycompany</groupId>
  <artifactId>parent-project</artifactId>
  <version>1.0.0</version>
</parent>

<artifactId>module-web</artifactId>
```

Running `mvn install` from the parent builds **all modules in order**.

---

## 14. Common Maven Commands

| Command | Description |
|---------|-------------|
| `mvn compile` | Compiles the main source code. |
| `mvn test` | Runs unit tests. |
| `mvn package` | Creates JAR/WAR in `target/` folder. |
| `mvn clean` | Deletes `target/` folder. |
| `mvn clean install` | Clean + full build + save to local repo. **Most used!** |
| `mvn clean package` | Clean + build (without installing to `.m2`). |
| `mvn dependency:tree` | Shows full dependency tree including transitive deps. |
| `mvn help:effective-pom` | Shows the final merged POM Maven uses. |
| `mvn dependency:resolve` | Downloads all dependencies without building. |
| `mvn -X clean install` | Debug mode — shows detailed logs. |
| `mvn versions:display-dependency-updates` | Shows available version upgrades for your deps. |
| `mvn dependency-check:check` | Scans for known security vulnerabilities (OWASP). |

---

## 15. Best Practices & Tips

- 🔵 Always use `mvn clean install` for a reliable build — avoids stale compiled files.
- 🔵 Never hardcode versions everywhere — use `<properties>` or `<dependencyManagement>`.
- 🔵 Use `<properties>` for version numbers: `<spring.version>5.3.20</spring.version>`.
- 🔵 Run `mvn dependency:tree` to debug transitive dependency conflicts.
- 🔵 Check [mvnrepository.com](https://mvnrepository.com) before adding a library — look at download stats and vulnerability info.
- 🔵 Keep your `pom.xml` clean — remove unused dependencies regularly.
- 🔵 For Spring Boot projects, use **[Spring Initializr](https://start.spring.io)** instead of manual archetype selection.
- 🔵 Use the Effective POM (`mvn help:effective-pom`) when debugging unexpected build behavior.
- 🔵 In Eclipse: right-click project → **Maven → Update Project** (`Alt+F5`) after changing `pom.xml`.
- 🔵 Always run a vulnerability scan before releasing to production.

---

## 16. Quick Reference Card

| Concept | One-Line Summary |
|---------|-----------------|
| **POM** | `pom.xml` — the heart of every Maven project. Defines everything. |
| **GAV** | `groupId:artifactId:version` — the unique address of every library. |
| **Dependency** | A library your project needs, declared in `pom.xml`. |
| **Transitive Dep** | A dependency's dependencies — Maven fetches these automatically. |
| **Local Repo** | `~/.m2/repository` — Maven's cache on your machine. |
| **Central Repo** | Maven Central — the internet's library store for Java. |
| **Archetype** | A project template to generate standard folder structure. |
| **Lifecycle** | Ordered phases: `compile → test → package → install → deploy`. |
| **Plugin** | A tool that performs tasks (compile, test, package). |
| **Effective POM** | Your POM + parent POM + Super POM merged together. |
| **Vulnerability** | A known security bug in a library — check & upgrade regularly. |
| **Scope** | When a dep is available: `compile`, `test`, `provided`, `runtime`. |
| **dependencyManagement** | Centralize version declarations for multi-module projects. |

---

## 📎 Useful Links

| Resource | URL |
|----------|-----|
| Maven Central (find JARs) | https://mvnrepository.com |
| Official Maven Docs | https://maven.apache.org/guides/ |
| Spring Initializr | https://start.spring.io |
| OWASP Dependency-Check | https://owasp.org/www-project-dependency-check/ |
| Snyk Vulnerability DB | https://snyk.io |

---

*Made with ❤️ for Java developers learning Apache Maven*
