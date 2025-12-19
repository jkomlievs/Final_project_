Feature: Delete advert

  Scenario: User deletes own advert and it should not appear in search results
    Given the main page is opened
    And the user is logged in
    And the user has created an advert with title "Mustang"
    When the user searches for advert "Mustang"
    And the user opens the advert card
    And the user deletes the advert
    Then the advert "Mustang" should not be found in search results
    And the user logs out