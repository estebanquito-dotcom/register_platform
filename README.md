# Online Course Platform - Simple Backend Simulation

## What is this?
This is a small project I built in two days to practice Java fundamentals. It’s a console-based simulation of an online school where you can manage students, create courses, and handle enrollments.

The main goal was to move away from basic arrays and start using more professional tools like Lists and Services.

## What I learned and implemented

### 1. Goodbye Arrays, Hello Lists
In my previous exercises, I used standard Arrays, but they are a headache because you have to "rebuild" them every time you want to add an item. 
* In this project, I used **Java Lists** (`ArrayList`).
* I learned how to iterate through them efficiently and how to filter data in a single pass to keep the program fast.

### 2. Organizing the Code (Services)
Instead of putting all the logic inside the Student or Course classes, I created **Services**. 
* The entities (Student, Course) only hold the data.
* The **Services** do the heavy lifting (searching, validating if a course is full, checking for duplicates).
* This made the code much easier to read and debug.

### 3. Handling Errors without Crashing
I wanted a program that doesn't just "break" when something goes wrong. 
* I created **Custom Exceptions** for specific business rules (e.g., `CourseFullException` or `StudentNotFound`).
* The program is now resilient: if you enter a wrong ID, it shows a warning and takes you back to the menu instead of closing the app.

### 4. Testing and Logging
* **JUnit:** I wrote unit tests for the main functions to make sure the creation and enrollment logic actually works.
* **Log4j2:** I added logging to both the console and a file. This helps to track what the program is doing and where the warnings are happening without filling the user screen with technical mess.

## Features
* Register students and courses.
* Enroll students in courses (with a maximum capacity limit).
* Search for all courses a specific student is taking.
* List all available courses in the system.

## How to run it
1. Make sure you have Java 17.
2. Run the `Main.java` file.
3. Use the types to navigate the menu.

---
