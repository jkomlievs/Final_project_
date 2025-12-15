Feature: Edit advert

  Scenario: Edit advert price and verify changes
    Given the main page is opened
    And user is logged in
    And user creates a new advert with price "200000000"
    When user opens the advert card
    And user edits the advert price to "200000001"
    Then updated advert price should be visible
    And user deletes the advert
    And user logs out