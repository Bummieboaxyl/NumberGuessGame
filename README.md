
## 🎮 NumberGuessGame

A simple Java web application  allows users to guess a random number.  
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
|-- Jenkinsfile
|-- Dockerfile

````


### Features
✅ Random number guessing game  
✅ Fully automated CI/CD pipeline    
✅ SonarQube integration for code quality analysis  
✅ Docker & Tomcat for containerization and image management

## 🚀 Getting Started

### Prerequisites  
Java 17, Maven, Docker, Jenkins, SonarQube, DockerHub

### Clone the Repository
```bash
git clone https://github.com/your-username/NumberGuessGame.git
cd NumberGuessGame
```

###  Build the Project

```bash
mvn clean package
```

### Deploy the generated WAR file to Tomcat.

Run the CI/CD Pipeline in Jenkins
Push changes to GitHub → Jenkins automatically triggers build & deployment.

### Access the Application
After deployment, open                 
*http://<Server-IP:9090/NumberGuessGame*

### CI/CD Pipeline Workflow
Code push to GitHub → Jenkins triggers build
Maven compiles, tests, and packages the app
SonarQube scans for code quality
Docker builds an image and pushes it to DockerHub. WAR file is deployed to Tomcat


### Deploy to Tomcat

The generated WAR file from target/ is copied into the Tomcat Docker image as ROOT.war during the build, and Tomcat automatically deploys it when the container runs.

---
## 🧪 Testing

Unit tests are written with **JUnit 5** and run automatically with:

```bash
mvn test
```

---

## ⚙️ Technologies

* Java 17
* Maven
* Servlet API
* JSP
* JUnit 5

---


