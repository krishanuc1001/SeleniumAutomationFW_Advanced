# Test Automation Framework

A comprehensive test automation framework supporting various tools and design patterns.

## Features

- **Selenium Integration:** Seamless integration with Selenium WebDriver for UI automation.
- **TestNG Support:** Leverages TestNG for test management, execution, and reporting.
- **ExtentReports:** Beautiful and interactive test reports generated using ExtentReports.
- **AssertJ:** Fluent assertions for writing readable and maintainable tests.
- **Data-Driven Testing:** Support for data-driven testing using Excel and JSON files.
- **Docker Support:** Enables running tests in containerized environments using Docker.
- **Page Object Model (POM):** Encourages the use of POM design pattern for better test organization and maintainability.
- **Custom Annotations and Listeners:** Provides flexibility with custom annotations and TestNG listeners.
- **Robust Exception Handling:** Built-in mechanisms for effective exception handling during test execution.
- **Utility Classes:** A rich set of utility classes for common operations like taking screenshots, handling Excel and JSON files, and more.

## Getting Started

This section will guide you through setting up the project on your local machine and running the tests.

### Prerequisites

Make sure you have the following software installed on your system:

- **Java Development Kit (JDK):** Version 8 or higher.
- **Apache Maven:** Version 3.5 or higher.
- **Docker:** (Optional) If you plan to run tests in a containerized environment.
- **IDE (Integrated Development Environment):** IntelliJ IDEA or Eclipse are recommended.

### Cloning the Repository

To get a local copy of the project, clone the repository using Git:

```bash
git clone <repository_url>
cd <repository_directory>
```

### Importing the Project into an IDE

**IntelliJ IDEA:**

1.  Open IntelliJ IDEA.
2.  Select "Open" or "Import".
3.  Navigate to the cloned repository directory and select the `pom.xml` file.
4.  Choose "Open as Project".
5.  IntelliJ IDEA will automatically import the project and download Maven dependencies.

**Eclipse:**

1.  Open Eclipse IDE.
2.  Go to `File -> Import...`.
3.  Select `Maven -> Existing Maven Projects`.
4.  Click `Next`.
5.  Browse to the directory where you cloned the repository.
6.  Ensure the `pom.xml` is selected.
7.  Click `Finish`. Eclipse will import the project and download Maven dependencies.

### Running the Tests

You can run the tests using either TestNG directly within your IDE or via Maven from the command line.

**Using TestNG in IDE:**

1.  Open your IDE (IntelliJ IDEA or Eclipse).
2.  Navigate to the test class or TestNG XML suite file (e.g., `src/test/resources/testng.xml`).
3.  Right-click on the file or within the test class.
4.  Select "Run 'TestName'" or "Run 'testng.xml'".

**Using Maven:**

Open a terminal or command prompt, navigate to the root directory of the project, and execute the following Maven command:

```bash
mvn clean test
```

This command will compile the project, download dependencies (if not already present), and execute the tests as defined in the TestNG XML file (typically `testng.xml` configured in the `maven-surefire-plugin` section of the `pom.xml`).

## Contributing

We welcome contributions to improve and expand this test automation framework! Please follow these guidelines to contribute:

### 1. Fork the Repository

Start by forking the main repository to your GitHub account. Click the "Fork" button at the top right of the repository page.

### 2. Clone Your Fork

Clone your forked repository to your local machine:

```bash
git clone https://github.com/YourUsername/YourForkedRepository.git
cd YourForkedRepository
```

### 3. Create a New Branch

Create a new branch for your feature or bug fix. Use a descriptive name for your branch (e.g., `feature/add-new-utility` or `fix/login-test-issue`).

```bash
git checkout -b feature/your-new-feature
```

### 4. Make Your Changes

Make the necessary code changes, additions, or bug fixes. Ensure your code adheres to the project's coding standards and practices.

- Write clean, readable, and maintainable code.
- Add or update unit tests for your changes.
- Ensure all existing tests pass with your changes.
- Update documentation if necessary.

### 5. Commit Your Changes

Commit your changes with a clear and descriptive commit message:

```bash
git add .
git commit -m "feat: Describe your feature or fix"
```
(You can use conventional commit messages like `feat:`, `fix:`, `docs:`, `style:`, `refactor:`, `test:`, `chore:`)

### 6. Push to Your Fork

Push your changes to your forked repository on GitHub:

```bash
git push origin feature/your-new-feature
```

### 7. Submit a Pull Request (PR)

Go to the original repository on GitHub. You should see a prompt to create a Pull Request from your recently pushed branch. If not, navigate to the "Pull requests" tab and click "New pull request".

- Select your forked repository and the branch containing your changes.
- The base repository should be the original project's main branch.
- Provide a clear title and a detailed description for your PR. Explain the changes you've made and why.
- Link any relevant issues if your PR addresses them (e.g., "Closes #123").
- Submit the PR.

Your PR will be reviewed by the maintainers. Be prepared to address any feedback or make further changes if requested. Thank you for your contribution!

## License

This project is licensed under the MIT License.

The MIT License is a permissive free software license originating at the Massachusetts Institute of Technology (MIT). As a permissive license, it puts only very limited restriction on reuse and has, therefore, high license compatibility.

A copy of the MIT License can typically be found in the `LICENSE` file in the root of this repository. If not, the terms of the license are as follows:

```
MIT License

Copyright (c) 2024 The Project Contributors

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
