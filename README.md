# Employee managment project

## Technical overview

Project is implemented by 
- Java Spring framework
- Gradle build tool
- PostgreSQL DB (docker-compose file includes db setup)
- checkstyle to keep the right code style in the project
- Flyway to manage db migrations (Note: rollback is avaialble for extended licence only)
- extra packages mentioned in the Gradle configuration

## Useful commands

- `gradle checkstyleMain` (run code style check)
- `gradle build` (build the source code)
- `./gradlew bootRun` (build & start the spring project)
- `docker-compose up` (prepare db instance)

## Docs

See Postman collection in the docs folder.
Import it to the Postman to see the list of endpoints.

## Implemented functionality

Application is created to manage departments and employees connected to these departments. There is the many-to-many relation
between entities designed on the DB level. However for now according to requirement employee can be connected only to one department (designed for the easier change).

## TODO List

- cover the codebase by unit tests (services) & integration tests for endpoints
- write the javadoc to generate javadoc docs
- dockerize the application
- define the deployment pipeline (GitHub Actions etc)
- swagger documentation
