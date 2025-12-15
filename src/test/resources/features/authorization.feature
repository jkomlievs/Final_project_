Feature: User authorization

  Scenario Outline: Successful authorization
    Given the main page is opened
    When I open login form
    And  I login with valid credentials
    Then user should be logged in


    Examples:
      | existingEmail         | existingPassword |
      | mariatest13@yandex.ru | 12345678         |