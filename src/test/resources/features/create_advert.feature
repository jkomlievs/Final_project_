Feature: Create advert

  Scenario: Successful advert creation and deletion
    Given the main page is opened
    And user is logged in
    When user creates a new advert
    And user fills advert data
    And user publishes the advert
    Then advert should be visible in search results
    And user deletes the advert
    And advert should be removed
    And user logs out