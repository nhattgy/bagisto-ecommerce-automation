# 🛒 Bagisto E-Commerce Automation Framework

## 1. Project Overview

This repository contains a complete Selenium automation framework for the **Bagisto E-Commerce Platform**, developed from scratch using:

- **Java 17**
- **Selenium WebDriver 4.x**
- **TestNG**
- **Maven**
- **Faker** (runtime test data generation)
- **Docker-based Selenium Grid** (parallel, distributed execution)
- **Allure Reporting**
- **Jenkins CI** (pipeline integration)

The framework covers a full set of **User**, **Admin**, and **End-to-End** scenarios, focusing on realistic e-commerce flows and stable cross-browser execution.

---

## 2. Framework Features & Architecture

**Design & Patterns**

- **Page Object Model (POM)**
  - Reusable page classes for User and Admin areas.
  - Centralized locators in `PageUI` package.
- **BasePage / BaseTest**
  - Common browser actions and custom waits.
  - Centralized WebDriver initialization and teardown.
- **Factory Pattern**
  - `factoryBrowser` – create WebDriver instances for different browsers.
  - `factoryEnvironment` – switch between local, Docker Selenium Grid, and cloud if needed.
- **Data-Driven & Utilities**
  - Dynamic test data with **Faker**.
  - Utility classes for common helpers, file handling, and randomization.
- **Reporting**
  - **Allure** with custom listener in `reportConfigs`.
  - Screenshots on failure and detailed step reporting.
- **Parallel & Distributed Execution**
  - Execution on **Docker-based Selenium Grid** (Chrome / Firefox / Edge nodes).
  - Optimized for running multiple suites in parallel.
- **CI/CD Integration**
  - Designed to run in **Jenkins** pipeline using Maven commands.
  - Allure report generation step after test execution.

---

## 3. Project Structure

```text
src
├─ main
│  └─ java
│      ├─ PageUI
│      │   ├─ admin
│      │   └─ user
│      ├─ actions
│      │   ├─ PageObjects          # Page Object classes (User/Admin)
│      │   ├─ commons              # BasePage, BaseTest, custom waits, helpers
│      │   ├─ factoryBrowser       # Browser factory (Chrome, Firefox, Edge…)
│      │   ├─ factoryEnvironment   # Local / Docker Grid / other environments
│      │   └─ reportConfigs        # Allure listener, reporting configuration
│      └─ utilities                # Shared utilities & helpers
│
└─ test
   ├─ java
   │   ├─ admin
   │   │   ├─ authenticationAdmin
   │   │   ├─ categoryAdmin
   │   │   ├─ customerAdminTest
   │   │   ├─ marketingTestAdmin
   │   │   ├─ ordersAdmin
   │   │   └─ productAdmin
   │   ├─ user
   │   │   ├─ authenticationUser
   │   │   ├─ cartUser
   │   │   ├─ checkoutUser
   │   │   ├─ orderUser
   │   │   ├─ productUser
   │   │   └─ profileUser
   │   └─ e2efollow               # End-to-End cross-module flows
   └─ resources                   # TestNG XML suites / configs

uploadFiles                        # Test data / attachments (if any)
docker-compose.yml                 # Docker Selenium Grid configuration
pom.xml                            # Maven configuration
```
## 4. Test Case Screenshots

This section summarizes automation coverage across all Bagisto modules.

### 4.1 User Module Test Cases (U01–U17)

<img width="2048" height="1844" alt="UserModule_Combined" src="https://github.com/user-attachments/assets/10837865-9ab9-4a79-8fef-3d08093a2fa4" />

Includes key flows:

- Registration  
- Login  
- Product browsing & search  
- Cart & Checkout (guest + logged-in)  
- Order details  
- Profile updates  

---

### 4.2 Admin Module Test Cases (A01–A20)

<img width="2048" height="1653" alt="AdminModule_Combined" src="https://github.com/user-attachments/assets/91bae9cf-b1d8-41d7-94fd-cc26b5c57bdc" />

Includes:

- Category CRUD  
- Product CRUD  
- Pricing & Stock Management  
- Customer Management  
- Coupon & Marketing  
- CMS & Localization  

---

### 4.3 End-to-End Test Cases (E01–E35)

<img width="1305" height="1177" alt="E2E_Combined" src="https://github.com/user-attachments/assets/32b2b58d-c79f-460b-a8d0-7f0f219dc238" />

Covers cross-module business flows such as:

- Admin creates a new Customer account and verifies email & login.  
- Validation triggered when required fields are missing.  
- Customer updates personal information (Profile) and Admin verifies changes.  
- Admin creates an additional Admin account and logs in with new credentials.  
- Admin changes password with incorrect confirmation to verify validation.  
- Admin and User interaction on orders, status updates, reviews, and notifications.  

---

## 5. Test Coverage Summary

### 5.1 User Module (U01–U17)

Full coverage of:

- Registration & Login (valid + invalid)  
- Product search, filtering, and detail pages  
- Cart operations (add / update / remove items)  
- Checkout flows: guest + logged-in user  
- Payment with Cash on Delivery and PayPal  
- Order history & order details  
- Profile & address management  

---

### 5.2 Admin Module (A01–A20)

Covers:

- Category management (create / update / delete)  
- Product management (attributes, price, stock, visibility)  
- Customer management & segmentation  
- Coupon & marketing campaigns  
- Order lifecycle (processing, completed, cancelled, refunded)  
- Shipping & tax configuration  
- Localization, CMS pages, and maintenance mode  

---

### 5.3 End-to-End Flows (E01–E35)

Ensures integration between Admin configuration and User experience, including:

- Product visibility and inventory sync between Admin and storefront  
- Order creation → Admin verification → invoice / shipment  
- Order status updates and customer notifications  
- Review submission from User and approval in Admin  
- Maintenance mode and storefront behavior during downtime  

---

## 6. Technology Stack

| **Category**    | **Tools / Technologies** |
|-----------------|---------------------------|
| Programming     | Java 17                   |
| Automation      | Selenium WebDriver 4.x    |
| Test Runner     | TestNG                    |
| Build Tool      | Maven                     |
| Test Data       | Faker                     |
| Reporting       | Allure                    |
| Grid Execution  | Docker + Selenium Grid    |
| CI/CD           | Jenkins                   |
| Version Control | Git & GitHub              |

---

## 7. Reporting & Demo

### 7.1 Allure Summary Dashboard

<img width="1919" height="895" alt="Allure_Summary" src="https://github.com/user-attachments/assets/3da5feda-51e1-4b33-9013-3184c0dd5853" />

### 7.2 Allure Detailed Steps

<img width="1625" height="1422" alt="Allure_Detailed" src="https://github.com/user-attachments/assets/564d9c5c-f367-4cca-8b27-9c5b57dea848" />

### 7.3 Failure Screenshot Example

<img width="1708" height="1468" alt="Failure_Screenshot" src="https://github.com/user-attachments/assets/b75fb154-58c0-49c0-b9fd-7bbcf976766a" />

### 7.4 Parallel Execution on Docker Selenium Grid

<img width="1919" height="1023" alt="Grid_Overview_1" src="https://github.com/user-attachments/assets/9e313c02-0612-40a9-83cc-74f27909c816" />  
<img width="1919" height="1025" alt="Grid_Overview_2" src="https://github.com/user-attachments/assets/e24c9424-6bf1-4cf4-b558-957ea0a2703b" />

---

## 8. How to Run

### 8.1 Prerequisites

- JDK 17  
- Maven  
- Docker & Docker Compose  
- Allure command-line (for local report viewing)  
- (Optional) Jenkins if you want to run in CI  

---

### 8.2 Clone Project

```bash
git clone https://github.com/nhattgy/bagisto-ecommerce-automation.git
cd bagisto-ecommerce-automation

```
### 8.3 Start Selenium Grid using Docker
```bash
docker-compose up -d
```

This will start Selenium Hub and browser nodes (Chrome / Firefox / Edge) defined inside docker-compose.yml.

### 8.4 Run Tests (Local or Docker Grid)

Run the default TestNG suite via Maven:
```bash
mvn clean test
```

The main suite file is configured to execute User, Admin, and End-to-End tests using Docker Selenium Grid.

If you have multiple suite files (e.g., user / admin / e2e), you can pass them via parameter:
```bash
mvn clean test -DsuiteXmlFile=src/test/resources/bagisto-ecommerce-e2e.xml
```
### 8.5 Generate Allure Report
```bash
allure serve allure-results
```

This command will start a local Allure server and open the interactive report in your browser.

### 9. Jenkins Integration (Optional)

Pipeline step:
```bash
pipeline {
    agent any

    stages {
        stage('Automation Bagisto full') {
            steps {
                git branch: 'master',
                    url: 'https://github.com/nhattgy/bagisto-ecommerce-automation.git',
                    credentialsId: 'Github_Token'
            }
        }

        stage('Prepare Allure History') {
            steps {
                script {
                    if (fileExists('allure-report\\history')) {
                        bat 'xcopy /E /I /Y allure-report\\history allure-results\\history'
                    } else {
                        echo 'No previous Allure history found'
                    }
                }
            }
        }

        stage('Run Test') {
            steps {
                bat 'mvn clean test'
            }
        }
    }

    post {
        always {
            allure([
                includeProperties: false,
                results: [[path: 'allure-results']]
            ])
        }
    }
}
```

