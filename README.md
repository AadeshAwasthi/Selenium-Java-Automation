# Selenium with Java Automation Examples

![Java](https://img.shields.io/badge/Java-11-ED8B00?logo=openjdk&logoColor=white) ![Selenium](https://img.shields.io/badge/Selenium-4-43B02A?logo=selenium&logoColor=white) ![TestNG](https://img.shields.io/badge/TestNG-7-red) ![Maven](https://img.shields.io/badge/Maven-Build-C71A36?logo=apachemaven&logoColor=white) ![Status](https://img.shields.io/badge/Project-Demo%20%7C%20Learning-orange)

Sample UI automation scripts written by **Aadesh Awasthi** while learning Selenium with Java. The scripts automate some of the manual test cases from my [Test-Case-Documentation](https://github.com/AadeshAwasthi/Test-Case-Documentation) repository.

> **Note:** This is a **demo and learning project** on [SauceDemo](https://www.saucedemo.com), a public practice website by Sauce Labs. I am currently learning automation; this repository shows my progress.

## Tech Stack

| Tool | Use |
|---|---|
| Java 11 | Programming language |
| Selenium WebDriver 4 | Browser automation |
| TestNG | Test framework, assertions, data provider |
| Maven | Build and dependency management |
| Page Object Model | Design pattern: one class per page |

## Project Structure

```
Selenium-Java-Automation
├── pom.xml                      Maven dependencies
├── testng.xml                   Test suite file
└── src/test/java
    ├── base
    │   └── BaseTest.java        Opens and closes the browser
    ├── pages                    Page Objects (locators + actions)
    │   ├── LoginPage.java
    │   ├── ProductsPage.java
    │   ├── CartPage.java
    │   └── CheckoutPage.java
    └── tests                    Test classes (assertions)
        ├── LoginTest.java
        ├── ProductTest.java
        ├── CartTest.java
        └── CheckoutTest.java
```

## Automated Test Cases

| Test Class | Test | Manual TC |
|---|---|---|
| LoginTest | Valid login | TC_001 |
| LoginTest | Invalid login, 5 data sets (DataProvider) | TC_002 to TC_006 |
| LoginTest | Logout | TC_046 |
| ProductTest | Six products displayed | TC_013 |
| ProductTest | Sort by name Z to A | TC_015 |
| ProductTest | Sort by price low to high / high to low | TC_016, TC_017 |
| CartTest | Add single / multiple products | TC_023, TC_024 |
| CartTest | Remove from Products page / Cart page | TC_025, TC_026, TC_027 |
| CheckoutTest | Mandatory field validation | TC_034, TC_036 |
| CheckoutTest | Price calculation | TC_038, TC_039 |
| CheckoutTest | End-to-end order | TC_040 |

## How to Run

**Requirements:** Java 11 or above, Maven, Google Chrome.

```bash
# 1. Clone the repository
git clone https://github.com/AadeshAwasthi/Selenium-Java-Automation.git
cd Selenium-Java-Automation

# 2. Run all tests
mvn test

# 3. Run without opening the browser window
mvn test -Dheadless=true
```

Selenium 4 downloads the correct ChromeDriver automatically (Selenium Manager), so no driver setup is needed.

## Test Result

| Item | Result |
|---|---|
| Test methods | 15 |
| Test executions | 19 (the invalid login test runs with 5 data sets) |
| Passed | 19 |
| Failed | 0 |
| Browser | Google Chrome (headless) |

## Concepts Shown

- Page Object Model (locators kept separate from tests)
- Locators: `id`, `className`, `cssSelector`
- TestNG annotations: `@Test`, `@BeforeMethod`, `@AfterMethod`, `@DataProvider`
- Data-driven testing with `@DataProvider`
- Handling dropdown with `Select`
- Implicit and explicit wait (`WebDriverWait`)
- Assertions with `Assert`

## Next Learning Goals

- [ ] Screenshot on test failure
- [ ] Extent or Allure report
- [ ] Cross-browser run (Firefox, Edge)
- [ ] Read test data from Excel
