# REST_ASSUERED_2024
# Java Rest Assured Testing with Maven Project

This project demonstrates how to perform API testing using Rest Assured framework in Java, managed by Maven. It includes configuration for generating test reports using Surefire and Extent HTML reports.

## Tools and Frameworks Used

- **Rest Assured**: Java library for API testing.
- **Maven**: Build automation tool and dependency management.
- **Surefire Plugin**: Maven plugin for executing tests and generating reports.
- **Extent HTML Reporter**: Reporting tool for better visualization of test results.

## Requirements

- Java Development Kit (JDK) - Install JDK 8 or higher
- Maven - Dependency management tool
- IDE (Integrated Development Environment) - IntelliJ IDEA, Eclipse, etc.

  ## Setup Instructions

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/anurag3263/REST_ASSUERED_2024.git
   ```

2. **Navigate to the Project Directory:**
   ```bash
   cd path of project
   ```

3. **Import the Project into your IDE:**
   - For IntelliJ IDEA: Open IntelliJ IDEA, go to `File > Open` and select the project directory.
   - For Eclipse: Select `File > Import`, choose `Maven > Existing Maven Projects`, and then select the project directory.

4. **Install Dependencies:**
   Maven will automatically download the required dependencies mentioned in the `pom.xml` file. If not, you can manually trigger dependency download using:
   ```bash
   mvn clean install
   ```

## Running Tests

- **Run All Tests:** Execute the Cucumber Runner class (e.g., `TestRunner.java`) to run all feature files.
- **Run Individual Tests:** You can run individual feature files or scenarios by specifying the tags in the Cucumber Runner class.
## Project Structure

The project is structured as follows:

The project follows the standard Maven directory structure:

```
java-selenium-bdd-cucumber/
│
├── src/main/java/           # Source code files
│   └── com.example.util/    # Utility classes
│
├── src/test/java/           # Test code files
│   ├── com.example.tests/   # Test classes
│   └── dto&PojoClasses.java # Cucumber runner class
│
├── src/test/resources/      # Feature files and test resources
│   ├── extent.properties    # config file
│   └── testdata/            # Test data files
│
└── pom.xml                  # Maven project configuration file
```
## Dependencies

- **JAVA:** java to write test cases.
- **TestNG :** Testing framework for running tests.
- **Rest-Assured:** Java library to test Restful API.
- **Maven:** Dependency management tool for Java projects.

## Contribution

Contributions to improve this project are welcome. Feel free to submit issues or pull requests.

```

Feel free to customize and expand upon this template based on your project's specific requirements and structure.
