Feature: Petstore Application User
  As a user I want to test petstore application user registry

  Scenario Outline: CRUD Test
    Given I am in the pet store creating new user data
    When I create new user by providing the information id "<id>" username "<username>" firstName "<firstName>" lastName "<lastName>" email "<email>" password "<password>" phone "<phone>" userStatus "<userStatus>"
    Then I verify that the user with username "<username>" is created
    And I update the user with information id "<id>" username "<username>" firstName "<firstName>" lastName "<lastName>" email "<email>" password "<password>" phone "<phone>" userStatus "<userStatus>"
    And I verify the user with username "<username>" is updated successfully
    And I delete the user with username "<username>"
    Then the user with username "<username>" is deleted successfully from the application
    Examples:
      | id  | username   | firstName | lastName | email                    | password     | phone      | userStatus |
      | 44  | mdiglin2   | Michelina | Diglin   | mdiglin2@noaa.gov        | d02QhHDnFoG5 | 2718615609 | 1      |
      | 218 | rboltwood3 | Reggis    | Boltwood | rboltwood3@artisteer.com | 0DgGIH       | 5294466768 | 1      |