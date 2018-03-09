# Your.MD coding test

## Uses maven as build and dependency tool (as I have used it before)

## To build:
mvn clean package

## To run
In root directory, java -jar target/phrases-rest-service-0.1.0.jar

Browse to http://localhost:8080/?text=<your text here>

# version notes

## 0.1.0
Naive implementation. Fails if no text parameter passed without error message.
Loads phrases.txt into memory on startup, checks to see if any of those are substrings of text param
and returns them as JSON.
Not scaleable with a larger dictionaru file (memory), not threaded.

