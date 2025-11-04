# String Calculator TDD Kata - Incubyte Assessment

This project implements the String Calculator kata using Test-Driven Development (TDD) principles.

## Author
Backend Software Engineer | Java & Spring Boot Specialist

## Project Overview
A simple string calculator that adds numbers from a string input, supporting various delimiters and validation rules.

## Features Implemented

### 1. Basic Addition
- Empty string returns 0
- Single number returns the number
- Two comma-separated numbers return their sum

### 2. Multiple Numbers
- Handles any amount of comma-separated numbers

### 3. New Line Support
- Supports new line characters (\n) as delimiters
- Can mix commas and new lines

### 4. Custom Delimiters
- Supports custom delimiter definition: `//[delimiter]\n[numbers]`
- Examples: `//;\n1;2` returns 3

### 5. Negative Number Validation
- Throws exception when negative numbers are present
- Shows all negative numbers in the exception message

## Technology Stack
- Java 11
- JUnit 5.9.2
- Maven


## Running the Tests

### Prerequisites
- Java 11 or higher
- Maven 3.6 or higher

# Run all tests
mvn test

# Run tests with detailed output
mvn test -X

# Clean and test
mvn clean test
