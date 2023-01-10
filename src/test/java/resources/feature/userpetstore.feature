Feature: Testing different request on the petstore

  Scenario: Check if the user account can be created by the user
    When I send a create request for user
    Then I must get back a valid user status code 200

  Scenario: Check if the user account can be accessed by the user
    When I send a get request for user
    Then I must get back a valid user status code 200

  Scenario: Check if the user account can be updated by the user
    When I send an update request for user
    Then I must get back a valid user status code 200

  Scenario: Check if the user account can be deleted by the user
    When I send a delete request for user
    Then I must get back a valid user status code 200