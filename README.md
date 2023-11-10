# UserApp Project: Clean Code and SOLID Principles


## Clean Code

### 1. Making Code Readable
- **Naming**: We chose names for classes and methods and fields that clearly tell what they do. For example, `UserService` handles user-related tasks.
- **Keeping Methods Focused**: Every method in our project does one specific thing which makes them easier to understand.

### 2. Organizing Code
- **Comments**: Wherever our code gets a bit complex, we've added comments to help explain what's going on.
- **Clean Formatting**: We've paid attention to how the code is formatted, using consistent spacing and indentation.

## SOLID Principles

### 1. Single Responsibility Principle
- Every class in our project has a single job. `UserService` is all about managing users, `UserList` is for storing user data, and `UserInterface` handles interactions with users. And also Try to separate buisness logic from the user interface.

### 2. Open/Closed Principle
- Our classes are designed to be open for adding new features but closed for modifications to the existing functionalities. This means we can add new things without breaking what's already there.

### 3. Liskov Substitution Principle
- Right now, our project doesn't use much inheritance, but if we add any, we'll make sure that new classes will work seamlessly in place of their parent classes.

### 4. Interface Segregation Principle
- The `IUserService` interface includes exactly what we need for user-related operations. It's tailored to avoid any unnecessary methods.

### 5. Dependency Inversion Principle
- We rely on abstractions, not concrete implementations. For example, `UserService` uses the `IUserService` interface, which makes our code more flexible and less dependent on specific implementations.

## How We Structured Our App

- **Data Layer (`UserList`)**: Manages our user data.
- **Service Layer (`UserService`)**: Handles the business logic for user operations.
- **Presentation Layer (`UserInterface`)**: Deals with showing options to the user and gathering their input.
- **Entry Point (`Main`)**: This is where our application starts and sets everything in motion.

## Testing Our App

- We've used JUnit and Mockito to write tests, ensuring each part of our application functions as intended.


## Prerequisites

- You have installed the latest version of [Java JDK](https://jdk.java.net/21/)
- You have installed [Maven](https://maven.apache.org/download.cgi)

## Building the project
clone this repository to your local machine:
```bash
https://github.com/PantaKoda/UserApp.git
```

Navigate to the root directory of the project (where the `pom.xml` file is located) and use the following commands:



To build the project without running tests, use:

```bash
mvn clean install -DskipTests
```
or with tests

```bash
mvn clean install
```
Then run the application using the JAR created

```bash
java -jar target/JensenUserApplication-1.0-SNAPSHOT.jar
```

