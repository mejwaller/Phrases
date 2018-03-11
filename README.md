# Your.MD coding test

## Uses maven as build and dependency tool (as I have used it before)

## To test
mvn test

## To build (also runs tests):
mvn clean package

## To run
In root directory, java -jar target/phrases-rest-service-0.1.0.jar

Browse to http://localhost:8080/?text=<your text here>

# version notes

## 0.1.0
Naive implementation:
I have concentrated on getting minimal application to work, rather than a scaleable production instance.
Why? Not applying for a programmer role, just trying to prove I can knock something up that works and meets the basic reqs.
Loads phrases.txt into memory on startup, checks to see if any of those are substrings of text param
and returns them as JSON.
Not scaleable with a larger dictionaru file (memory), not threaded.
Tests check base case works, blank URI works and wrong URI gives 404 (uses JUnit, mockito, springframework,hamcrest)


