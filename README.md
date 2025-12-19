# Capstone 3 – EasyShop (Backend + Frontend)

EasyShop is a full-stack web application that simulates an online shopping experience. This app allows users to browse 
products and interact with a storefront on the frontend, while the system manages data behind the scenes. This project 
can be used in the real-world as a foundation for e-commerce platforms. 

When you unzip the archive, you should get a folder named `capstone-3` with this structure:

```text
capstone-3/
  backend-api/      # Java Spring Boot backend (Maven)
  frontend-ui/         # Static HTML, CSS, JS
````

## Software Requirements

### The Programs and Tools Needed:

* **Java Development Kit (JDK) 17**
* **IntelliJ IDEA Community Edition** (latest)
* **MySQL Server** (e.g., MySQL 8.x)
* **MySQL Workbench** (to run the database script)
* Internet browser (Chrome, Firefox, Edge, Safari, etc.)

---

## Application Features

* Product Browsing- Users can view available products through the website interface.
* Data Management- Product and application data are stored and retrieved from a database.
* Separation of Frontend and Backend- The website and server work together but are built as separate parts of the application.
* Local Web Access- The application runs locally and can be accessed through a web browser. 

* IntelliJ will load the project with two modules:

    * `backend-api` – Java Spring Boot backend
    * `frontend-ui` – static HTML/CSS/JS

---

## How the Application Works

The website displays information and sends user requests. The server processes those requests and talks to the database.
The database stores all product and application data securely. 

---

## What I Learned

Throughout this project, I gained a better understanding of how complete applications are built and how different pieces work together.

The areas I learned about include:

* Application Structure – How large projects are organized into clear sections.

* Frontend and Backend Interaction – How a website communicates with a server.

* Database Usage – How data can be stored and reused instead of being lost.

* Problem Solving – How to troubleshoot issues when parts of the application don’t work as expected.

* Attention to Detail – How small configuration issues can affect the entire application.
---

## Where to make changes

* **Backend logic** (controllers, models, data access, etc.) is in:

  ```text
  backend-api/src/main/java/
  ```

* **Backend configuration** (including database settings) is in:

  ```text
  backend-api/src/main/resources/
  ```

* **Frontend HTML/CSS/JS** is in the `frontend-ui` folder:

  ```text
  frontend-ui/index.html
  frontend-ui/css/
  frontend-ui/js/
  frontend-ui/images/
  ```
  
---
  

## Personal Growth and Reflection

This project demonstrated that application development extends far beyond writing individual lines of code, it requires understanding how multiple systems and components interact within a complete architecture. I learned how front-end logic, data handling, and overall application flow must work together to produce a reliable and maintainable solution.This project helped me build confidence in my ability to understand larger systems overall. I also learned the value of asking questions and using available resources when I felt stuck. Completing this project helped me reflect on my current skill set and identify specific areas for growth, such as system design and optimization, which I plan to focus on in future projects. Ultimately, this experience strengthened my confidence and clarified my long-term goals as a developer.
