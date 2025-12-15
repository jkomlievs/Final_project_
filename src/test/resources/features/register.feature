Feature: User registration

  @success
  Scenario: Successful registration of a new user
    Given the main page is opened
    When the user opens the registration form
    And the user enters valid registration data
    And the user clicks the create account button
    Then the user is successfully registered
    And  user logs out

  @negative
  Scenario: Registration with an existing email should fail
    Given the main page is opened
    And the user is already registered via API
    When the user opens the registration form
    And the user enters existing registration data
    And the user clicks the create account button
    Then the registration error message is displayed