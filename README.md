# Server Demo

# Requirements

* Java 11
* Maven

## Endpoints

### `GET /fee`

Parameter: 
* `network` - one of: OMNI, ERC20, TRC20

Returns:
* `double` (OMNI - 15.0, ERC20 - 5.0, TRC20 - 1.0)

Example: GET http://localhost:8080/fee?network=OMNI

### `POST /transfer`

Request body:
```json
{
  "amount": 100.0,
  "network": "OMNI",
  "address": "1755AvhuzisnxxrRWrnRkAGGrJyN2akHdo",
  "currency": "USDT"
}
```
Response body:
```json
{
  "amount": 85.0,
  "commission": 15.0,
  "status": "SUCCESS",
  "error": null
}
```

## Run

`mvn spring-boot:run`
