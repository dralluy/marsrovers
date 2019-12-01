# Mars Rovers 
The project includes the main MarsRovers code challenge plus the optional
exercise for remote access.
The main design goal was doing a clear separation of concerns. For that, the final 
application layers follow a clean architecture convention. 
The domain layer has all the entities with the business rules.
The application layer represent the use cases (in that particular case, executing a NASA command)
The infrastructure layer is about exposing the uses case to be remotely accesible.
It is developed following a classicist TDD approach.

## Prerequisites

1. JDK 11
2. Gradle 4.10.2

## Installation

1. Clone repository from Github: https://github.com/dralluy/marsrovers.git
2. Build project: gradlew build
2. Running tests: gradlew test


## Web server
1. Run server app: java -classpath ./build/classes/java/main org.code.marsrover.infrastructure.WebServerApp
2. Browser:  http://localhost:8000/mars?command=COMMAND
3. CURL: curl http://localhost:8000/mars?command="COMMAND"
4. Remote client: java -classpath ./build/classes/java/main org.code.marsrover.infrastructure.RemoteClientApp "COMMAND"

COMMAND Examples:
4 4 1 1 N MMLRM -> 1 4 N

4 4 1 2 E MMRMLMLMML 1 1 N RMMLMMLMM -> 4 3 W 1 3 W

5 5 1 2 N LMLMLMLMM 3 3 E MMRMMRMRRM -> 1 3 N 5 1 E

6 6 1 1 E MMLMRMM 2 2 N MRMMLMRML 3 4 W MMLMLM -> 5 2 E 5 4 N 2 3 E

Malformed command -> ERROR
