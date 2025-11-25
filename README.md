# 🌦️ Weather Data Reader & Summarizer (Java)

This is a simple Java project that demonstrates how to use **Streams** and **Records** (Java 16+) to read, parse, and summarize weather data from a CSV file.
The program calculates basic weather statistics such as average temperature, maximum/minimum temperatures, and the number of humid days.

---

## 🚀 Features

* Uses **Java Records** for clean, immutable data models
* Uses **Java Streams** for parsing and summarizing weather data
* Reads from a CSV file (`data.csv`)
* Calculates:

  * Average temperature
  * Maximum temperature
  * Minimum temperature
  * Number of days with humidity above 70%
* Lightweight and beginner-friendly

---

## 📁 Project Structure

```
Weather Project/
 ├── src/
 │    └── WeatherApp.java
 └── data.csv
```

---

## 📄 Sample Data (`data.csv`)

```
date,temperature,humidity
2025-01-01,12,70
2025-01-02,15,65
2025-01-03,10,80
2025-01-04,8,75
2025-01-05,14,60
```

---

## 🧾 Code Overview

The project uses a **record**:

```java
record WeatherReading(String date, double temperature, double humidity) {}
```

And reads the CSV using **Streams**:

```java
List<WeatherReading> readings = Files.lines(path)
    .skip(1)
    .map(line -> line.split(","))
    .map(parts -> new WeatherReading(
            parts[0],
            Double.parseDouble(parts[1]),
            Double.parseDouble(parts[2])
    ))
    .toList();
```

---

## ▶️ Running the Project (Command Line)

### **1. Compile**

```sh
javac .\src\WeatherApp.java
```

### **2. Run**

```sh
java -cp .\src WeatherApp
```

Ensure `data.csv` is located in the **project root**, not inside `src`.

---

# 💻 Setup in VS Code

Follow these steps to run the project in **Visual Studio Code**.

---

### **1. Install Java**

You need **JDK 17 or higher**.

Download from:
👉 [https://adoptium.net](https://adoptium.net)

Check installation:

```sh
java -version
```

---

### **2. Install VS Code Extensions**

In VS Code, open **Extensions (Ctrl + Shift + X)** and install:

* **Extension Pack for Java** (by Microsoft)
* **Code Runner** (optional)

---

### **3. Open the Project**

1. Go to **File → Open Folder**
2. Select your:

```
Weather Project/
```

VS Code will automatically detect it as a Java project.

---

### **4. Verify Folder Structure**

```
Weather Project/
 ├── src/
 │    └── WeatherApp.java
 └── data.csv
```

> ❗ `data.csv` must be in the **root folder**.

---

### **5. Run the Program**

#### **Option A — Run Button**

* Open `WeatherApp.java`
* Click the ▶ **Run** button above the `main` method

#### **Option B — Terminal**

Open a terminal:

```
Terminal → New Terminal
```

Compile:

```sh
javac .\src\WeatherApp.java
```

Run:

```sh
java -cp .\src WeatherApp
```

---

### **6. Expected Output**

```
=== Weather Summary ===
Total days: 5
Average temperature: 11.8
Max temperature: 15.0
Min temperature: 8.0
Days with humidity > 70%: 2
```

---

## 🛠️ Requirements

* Java **17+**
* VS Code or any Java-compatible IDE

---

## 📚 Concepts Demonstrated

* Java **Records**
* Java **Streams**
* File handling (`Files.lines`)
* Functional programming with lambdas
* Basic data summarization

---

## 🤝 Contributing

Feel free to fork this repository and submit pull requests!
