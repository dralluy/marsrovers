# Mars Rovers 
The projects includes the main MarsRover code challenge plus the optional
exercise for remote access.

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
4. Remote client: 

Examples:
curl http://localhost:8000/mars?command="4 4 1 1 N M"