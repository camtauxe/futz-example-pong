# Futz Blank Project

## For Futz Version: 0.2

**See the main Futz repository: [HERE](https://github.com/camtauxe/futz)**

This is an blank template project for a Futz game. It contains the bare-minimum, boilerplate code needed to create and compile a game with Futz.

## How to use

1. Build and install the Futz library (see [the main repository](https://github.com/camtauxe/futz) for directions, requries Maven)

2. Write your source code in **src/main/kotlin**.

3. Add any assets into their respective directories in **src/main/resources**.

4. Package with Maven

```
mvn package
```

5. Run the compiled jar file

```
java -jar target/myfutzgame-1.0-jar-with-dependencies.jar
```