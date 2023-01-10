Feature: Petstore Application
  As a user I want to test petstore application

  Scenario Outline: CRUD Test
    Given I am in the pet store creating new pet data
    When I create new pet by providing the information id "<id>" idFirst "<idFirst>" name "<name>" nameFirst "<nameFirst>" photoUrl"<photoUrl>"idsecond "<idsecond>" namesecond "<namesecond>" status"<status>"
    Then I verify that the pet with id "<id>" is created
    And I update the pet with information id "<id>" idFirst "<idFirst>" name "<name>" nameFirst "<nameFirst>" photoUrl"<photoUrl>"idsecond "<idsecond>" namesecond "<namesecond>" status"<status>"
    And I verify the pet with id "<id>" is updated successfully
    And I delete the pet with id "<id>"
    Then the pet is deleted successfully from the application
    Examples:
      | id  | idFirst | name      | nameFirst             | photoUrl                                        | idsecond | namesecond             | status    |
      | 74  | 374     | Christian | Vulture, white-headed | http://dummyimage.com/163x100.png/cc0000/ffffff | 419      | Coatimundi white-nosed | active    |
      | 711 | 139     | Nelson    | Hawk red-tailed       | http://dummyimage.com/108x100.png/5fa2dd/ffffff | 507      | Tokay gecko            | available |
