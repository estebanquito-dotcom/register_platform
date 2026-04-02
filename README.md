# Online Course Platform Simulation - Backend

## Overview
This project is a functional simulation of an online course enrollment system. It manages students, courses, and the registration process using a robust service-oriented architecture. The system is designed to handle business rules, such as course capacity limits and duplicate record prevention, while maintaining high performance through efficient data handling.

Developed as part of the **Java Senior with AI** program at **DevSenior Code Startup**, this project marks a transition from basic programming to professional software development practices.

## Technical Milestones

### 1. Data Structure Optimization
I moved from using traditional **Arrays** to **Java Collections (Lists)**. 
* **The Problem:** Arrays are static and require full reconstruction to change their size, which is a major performance bottleneck.
* **The Solution:** Implementing `ArrayList` allowed for dynamic data management and more efficient iteration. I learned to navigate, filter, and process these lists using a "single-pass" approach to minimize computational costs.

### 2. Service-Oriented Architecture (SOA)
I decoupled the business logic from the entities (Models). 
* **Entities:** Now act as POJOs (Plain Old Java Objects) focusing only on data representation.
* **Services:** Specific classes like `StudentService`, `CourseService`, and `RegistrationService` contain all the logic. This makes the code modular, easier to maintain, and testable.

### 3. Advanced Error Handling
The application is built to be resilient. Instead of crashing on invalid input, it uses a custom exception hierarchy:
* **Business Exceptions:** Created specific classes like `CourseDuplicateException`, `StudentNotFoundException`, and `CourseFullException`.
* **Resilience:** Implemented a "Fail-Fast" strategy where errors are thrown early in the services and caught at the interface level (Main), allowing the program to recover and continue running.

### 4. Quality Assurance with JUnit
Reliability was verified through **Unit Testing**:
* **Functional Tests:** Validated the correct creation and storage of entities.
* **Edge Case Testing:** Specifically tested exceptions to ensure business rules are enforced (e.g., ensuring a student cannot register for a full course).

### 5. Professional Logging
I replaced standard console prints with **Apache Log4j2** for better auditing:
* **Console Logs:** For real-time monitoring of the application flow.
* **File Logs:** Persistent storage of warnings and errors, allowing for historical review of system behavior and warnings.

## Features
* **Student Management:** System-wide registration and search by ID.
* **Course Catalog:** Management of courses with unique codes and specific seat capacities.
* **Enrollment Engine:** Handles the link between students and courses with automatic capacity validation.
* **Single-Pass Reports:** Efficiently lists all registrations for a specific student without redundant loops.

## Technical Stack
* **Language:** Java 17+
* **Testing Framework:** JUnit 5
* **Logging Library:** Log4j2
* **Project Structure:** Modular Service-Repository pattern

## How to Run
1. Clone the repository.
2. Ensure Java 17 is installed in your environment.
3. Run the `Main.java` class to start the console interface.
4. Use the numeric menu to navigate through the management modules.

---
*Developed by [Your Name/Github Username]*
