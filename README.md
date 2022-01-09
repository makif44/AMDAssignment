# RestAssured Cucumber

This test suite is a  BDD Java test automation framework. Built on RestAssured Library and Cucumber.

## Prerequisites

To use this project, you'll need:
- Java Runtime Environment (JRE) or a Java Development Kit (JDK) version 8 or later
- Maven


### Execution
```
mvn test
```
```
run the "src/test/com/AMD/runners/CukesRuner.java" class
```
### Folder structure

- features - This folder contains all `.feature` files with test steps
- stepDefinitions - This folder contains the required implementation files
- runners - This folder contains the runner class

### Some Explanations

 a) Create a contact:
- The "vip" variable should be boolean
- POST :  
  {
    "firstName": "Bob",
    "lastName": "John",
    "mobiles": "+306984512555",
    "vip": true ,
    "email" : "bob@example.com"
  }

 b) Analyze Bulk Messages-Campaigns:
- The "to" variable also must be in the payload
- POST :
{
  "body": "Service 003 is offline",
  "groups" : [ "Admins" ],
  "from": "Routee",
  "to": ["+306982563221"]
}