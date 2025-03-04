Feature: Login Functionality

  Scenario: Valid login
    Given I am on the login page
    When I enter username "student" and password "Password123"
    Then I should be redirected to the dashboard
