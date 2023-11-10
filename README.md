# UserApp

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
Then run the application using 
```bash
java -cp target/classes org.userapplication.Main
```

