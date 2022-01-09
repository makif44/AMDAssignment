@api @create_contact
Feature: Create contact

  Scenario: 1. Create contact as a user and verify status code 200
    Given authorization token is provided for user
    And user accepts content type as "application/json"
    When user sends POST request to "https://connect.routee.net/contacts/my" with following information:
      | firstName | lastName | mobile        | country | vip  | email           |
      | Bob       | John     | +306984512555 | gr      | true | bob@example.com |
    And user verifies that response status code is 200


  Scenario: 2. Analyze an SMS campaign and verify status code 200
    Given authorization token is provided for user
    And user accepts content type as "application/json"
    And user creates a body from "data" file
    When user sends POST request to "https://connect.routee.net/sms/analyze/campaign"
    And user verifies that response status code is 200