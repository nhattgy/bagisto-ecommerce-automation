# 🛒 Bagisto E-Commerce Automation Framework

## Project Overview
This repository contains a complete Selenium automation framework for the **Bagisto E-Commerce Platform**, developed from scratch using:

- **Java 17**
- **Selenium WebDriver 4.x**
- **TestNG**
- **Maven**
- **Faker** (runtime test data)
- **Docker-based Selenium Grid**
- **Allure Reporting**

The framework covers a full set of **User**, **Admin**, and **End-to-End** automation scenarios.

---

## Test Case Screenshots
This section summarizes automation coverage across all Bagisto modules.

### User Module Test Cases (U01–U17)
<img width="2048" height="1844" alt="UserModule_Combined" src="https://github.com/user-attachments/assets/10837865-9ab9-4a79-8fef-3d08093a2fa4" />

Includes key flows:
- **Registration**
- **Login**
- **Product browsing**
- **Cart & Checkout**
- **Order detail**
- **Profile updates**

### Admin Module Test Cases (A01–A20)
<img width="2048" height="1653" alt="AdminModule_Combined" src="https://github.com/user-attachments/assets/91bae9cf-b1d8-41d7-94fd-cc26b5c57bdc" />

Includes:
- **Category CRUD**
- **Product CRUD**
- **Pricing & Stock**
- **Customer Management**
- **Coupon & Marketing**
- **CMS & Localization**

### End-to-End Test Cases (E01–E35)
<img width="2048" height="2119" alt="E2E_Module_Combined" src="https://github.com/user-attachments/assets/2d8451da-b86f-43fc-a367-0edf249246ff" />

Covers:
- **Product visibility sync**
- **Order lifecycle**
- **Invoice / Refund**
- **Comments & Reviews**
- **Maintenance mode**
- **Marketing email**

---

## Test Coverage Summary

### User Module (U01–U17)
Full coverage of:  
**Registration, login, search, filters, cart, checkout (guest + logged-in), PayPal payment, profile updates.**

### Admin Module (A01–A20)
Covers:  
**Category CRUD, product, customer, coupon, marketing, CMS, orders, shipping, tax, localization, maintenance.**

### End-to-End (E01–E35)
Ensures integration between admin actions and user flows:  
**product visibility, inventory sync, order status, refunds, invoices, reviews, maintenance mode.**

---

## Technology Stack

| **Category**        | **Tools** |
|---------------------|-----------|
| Programming         | **Java 17** |
| Automation          | **Selenium WebDriver** |
| Test Runner         | **TestNG** |
| Test Data           | **Faker** |
| Reporting           | **Allure** |
| Grid Execution      | **Docker + Selenium Grid** |
| CI/CD               | **Jenkins** |
| Version Control     | **GitHub** |

---

## How to Run

### Clone project
```bash
git clone https://github.com/nhattgy/bagisto-ecommerce-automation.git
cd bagisto-ecommerce-automation
Start Selenium Grid using Docker
docker-compose up -d

Run tests
mvn clean test

Generate Allure Report
allure serve allure-results

Reporting & Demo (Placeholders)

Allure Summary

Allure Detailed Steps

Failure Screenshot

Parallel Execution Grid
