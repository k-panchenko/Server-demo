# Server Demo

# Requirements

* Java 11
* Maven

## Endpoints

* `GET /hello`
  * Parameters:
    * name: string
  * Returns a "Hello ${name}" string
* `POST /tokenize`
  * Parameters:
    * raw string - some sentence 
  * Returns a Map<String,Integer> word count 

## Run

`mvn spring-boot:run`
