Feature: Login Functionality

  @positive @login
  Scenario: Valid login with correct credentials
    Given I am on the login page
    When I enter username "student" and password "Password123"
    Then I should be logged in successfully
    And I should see the success message "Logged In Successfully"

  @negative @login
  Scenario: Invalid login with incorrect username
    Given I am on the login page
    When I enter username "incorrectUser" and password "Password123"
    Then I should see the error message "Your username is invalid!"

  @negative @login
  Scenario: Invalid login with incorrect password
    Given I am on the login page
    When I enter username "student" and password "incorrectPassword"
    Then I should see the error message "Your password is invalid!"

  @negative @login
  Scenario: Invalid login with empty credentials
    Given I am on the login page
    When I enter username "" and password ""
    Then I should see the error message "Your username is invalid!"
