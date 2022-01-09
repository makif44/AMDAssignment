# RestAssured Cucumber

This test suite is a debuggable BDD Javascript test automation framework. Built on WebdriverIO v7 and Cucumber v7 with page object model.

## Prerequisites

To use this project, you'll need:
- Java Runtime Environment (JRE) or a Java Development Kit (JDK) version 8 or later
- Maven


### Installation and Run
```
mvn verify
```
### Report used

`maven-cucumber-reporting`
- report location : target/cucumber-html-reports/

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