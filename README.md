# Automation Framework - Java, Playwright, Selenium, ZeroStep, Applitools Eyes, and TeamCity CI

Welcome to the repository for our Automation Framework built using Java alongside Playwright, Selenium, ZeroStep, and Applitools Eyes. This framework is fully integrated with TeamCity for continuous integration (CI), offering a powerful solution for end-to-end testing in modern software development.
Overview
This automation framework is designed to provide comprehensive testing capabilities across various web applications. By leveraging a combination of popular tools and services, it delivers a robust and scalable testing environment that ensures both functional and visual aspects of your application are thoroughly validated.

## Key Components
### Java: 
Core programming language for the framework, providing a stable and widely-used environment for test scripting.
### Playwright: 
Used for advanced web testing, particularly in handling modern, dynamic web applications with cross-browser support.
### Selenium: 
A well-established tool for browser automation, enabling broad compatibility and mature support for web application testing.
### ZeroStep: 
Build tests quickly by expressing actions and assertions as plain text instructions. If you can express what you want tested, you can automate it.
### Applitools 
Eyes: Integrates visual validation into the testing process, ensuring consistent UI/UX across different browsers and devices.
### TeamCity:
CI/CD tool that automates test execution within the development pipeline, providing fast feedback on code changes and ensuring continuous quality.

## Features
### Cross-Browser Testing: 
Ensures your application works flawlessly on different browsers, using Playwright and Selenium.
### Visual Testing: 
Applitools Eyes checks for visual consistency across browsers and devices, catching UI bugs that functional tests might miss.
### Modular Test Design: 
ZeroStep enables easy reuse of test components, improving test maintenance and scalability.
### Continuous Integration: 
Seamlessly integrated with TeamCity, allowing automated test runs with every code commit or on a schedule.

### !!! In order to run the tests you may need to download and install some dependencies for @ZeroStep
@ZeroStep - https://github.com/zerostep-ai/zerostep/blob/main/README.md


## Executing ZeroStep tests:
npx playwright test src/myZeroStep.test.js

## Executing PlayWright and ApplitoolsEyes tests:
mvn clean test

