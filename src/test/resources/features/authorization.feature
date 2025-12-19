Feature: User authorization

  Scenario: Successful authorization
    Given the main page is opened
    When I open login form
    And  I login with valid credentials
    Then The user should be logged In
