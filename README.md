# Playwright Cucumber Framework with Allure Reporting

This is a test automation framework built with Playwright, Cucumber, and Allure Reporting for testing the practice test automation website.

## Prerequisites

- Java 11 or higher
- Maven
- Node.js (for Playwright installation)

## Setup

1. Clone the repository
2. Install Playwright browsers:
   ```bash
   mvn exec:java -e -D exec.mainClass=com.microsoft.playwright.CLI -D exec.args="install"
   ```

## Project Structure

```
src/
├── main/
│   └── java/
│       └── com/
│           └── pages/
│               └── LoginPage.java
└── test/
    └── java/
        ├── features/
        │   └── Login.feature
        ├── stepdefinitions/
        │   └── LoginSteps.java
        ├── utils/
        │   ├── Hooks.java
        │   └── PlaywrightManager.java
        └── runner/
            └── CucumberTest.java
```

## Running Tests

1. Run all tests:
   ```bash
   mvn clean test
   ```

2. Run specific tags:
   ```bash
   mvn clean test -Dcucumber.filter.tags="@positive"
   ```

## Generating Allure Reports

1. Generate the report:
   ```bash
   mvn allure:report
   ```

2. Serve the report:
   ```bash
   mvn allure:serve
   ```

## Test Scenarios

The framework includes the following test scenarios:

### Positive Scenarios
- Valid login with correct credentials

### Negative Scenarios
- Invalid login with incorrect username
- Invalid login with incorrect password
- Invalid login with empty credentials

## Features

- Page Object Model design pattern
- Cucumber BDD framework
- Allure reporting
- Thread-safe browser management
- Configurable test execution
- Cross-browser testing support 