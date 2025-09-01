
## 🎮 NumberGuessGame

A simple Java web application that allows users to guess a random number.  
Built with **Servlets, JSP, and Maven**, and packaged as a `.war` file for deployment on a servlet container (e.g., Tomcat).

---

## 📂 Project Structure
```

NumberGuessGame/
│-- src/
│   ├── main/
│   │   ├── java/com/studentapp/NumberGuessServlet.java
│   │   ├── webapp/WEB-INF/web.xml
│   │   └── webapp/index.jsp
│   └── test/
│       └── java/com/studentapp/NumberGuessServletTest.java
│-- pom.xml
│-- README.md
│-- .gitignore

````

---

## 🚀 Getting Started

### 1. Clone the Repository
```bash
git clone https://github.com/your-username/NumberGuessGame.git
cd NumberGuessGame
````

### 2. Build the Project

```bash
mvn clean install
```

### 3. Run Tests

```bash
mvn test
```

### 4. Deploy to Tomcat/Jetty

Copy the generated `.war` file from `target/` to your servlet container’s `webapps/` folder.

---

## 🧪 Testing

Unit tests are written with **JUnit 5** and run automatically with:

```bash
mvn test
```

---

## ⚙️ Technologies

* Java 11+
* Maven
* Servlet API
* JSP
* JUnit 5

---


