Home to a collection of java apps, primarily for learning Java and its ecosystem. Will range from a simple CLI application to a fully-integrated application, dockerized with a CI/CD pipeline. Below are assumed requirements and the setup for launching the applications. Inside each application, will exist a README.md, explaining in detail what each application does.

# Requirements
- Java 21
- Gradle
- Maven

# Setup
- `cd` into `./scripts`
- Run `test-all.sh`
- Optionally, add a parameter of either `maven` or `gradle` to test/run only with either (`test-all.sh raven`)