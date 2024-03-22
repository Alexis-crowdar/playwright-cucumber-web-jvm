# Playwright - Cucumber Sample Project

## Purpose:
This is an Sample Project designed to work with Playwright in Java environments using Cucumber. It allows for efficient and structured end-to-end testing of web applications.


Por supuesto, aquí tienes un ejemplo de cómo podría ser el archivo `README.md` en inglés para tu proyecto de framework de automatización con Playwright, Java y Cucumber:

----------

# Automated Testing Framework with Playwright, Java, and Cucumber

This is an automated testing framework designed to work with Playwright in Java environments using Cucumber. It allows for efficient and structured end-to-end testing of web applications.

## Key Features

-   Integration of Playwright for interacting with web elements.
-   Uses Cucumber for writing test cases in natural language.
-   Configuration management through a `config.properties` file.
-   Modular structure with Page Objects for easy maintenance.

## System Requirements:
-   JDK: [https://docs.oracle.com/en/java/javase/index.html](https://docs.oracle.com/en/java/javase/index.html)
-   Maven: [https://maven.apache.org/download.cgi]-   Java 8 or higher
-   Playwright
-   Cucumber

# Getting started
**Clone the Repository**

    git clone https://github.com/your-username/your-project.git
**Install Dependencies**

    cd your-project
    mvn clean install
**Configure Properties**
-   Set up your properties in the `config.properties` file located in `src/main/resources`.
-   Example:

        browser=chromium

### Running Tests

You can execute the tests using Maven from the command line:
`$ mvn clean test`

## Lippia Test Manager
This integration uses an adaptar that automatically ingests results of Scenarios into Lippia Test Manager.
You just simply need to implement [_LTM-adapter-cucumber4-JVM_](https://github.com/Crowdar/LTM-adapter-cucumber4-JVM) and you can see the results in Lippia Test Manager as an Automated Run Result.
To configure your automation project to inject results into LTM, you should do the following things:

Include property reference ${test-manager.report} in cucumber options (pom.xml)
To set following properties, you need obtain an account in LTM (visit the web https://www.lippia.io/ to start free trial account)
Properties:

TEST_MANAGER_API_HOST: https://example.com

TEST_MANAGER_RUN_NAME: id run in project

TEST_MANAGER_PROJECT_CODE: id project to inject test execution results

TEST_MANAGER_USERNAME: username Account LTM

TEST_MANAGER_PASSWORD: password Account LTM



Folder's description:

|Path   |Description     |
|-------|----------------|
|src/main/java/utils/PropertyManager.java  | Handles project configuration properties, such as the browser type to use.|
|src/main/java/utils/LocatorUtils.java|Provides methods to interact with page elements using Playwright locators.|
|src/main/java/setup/Context.java|Manages the browser session and current page for test.|
|src/main/java/tests/steps/LoginPageDefinitions.java|Defines test steps for scenarios.|
|src/main/java/tests/locators/LoginPageComponents.java|Store selectors (locators) for page elements. These classes contain static constants for  selectors of relevant elements on the pages, making it easy to reference them in tests.|
