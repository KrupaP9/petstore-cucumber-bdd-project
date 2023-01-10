Feature: Testing different request on the petstore

  Scenario: Check if the pet can be created by the user
    When I send a create request for pet
    Then I must get back a valid pet status code 200

  Scenario: Check if the pet can be accessed by the user
    When I send a get request for pet
    Then I must get back a valid pet status code 200

  Scenario: Check if the pet can be updated by the user
    When I send an update request for pet
    Then I must get back a valid pet status code 200

  Scenario: Check if the pet can be deleted by the user
    When I send a delete request for pet
    Then I must get back a valid pet status code 200