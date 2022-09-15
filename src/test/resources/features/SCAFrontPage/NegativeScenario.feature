@suite
Feature: As a user of SCA (Single Customer Account) application
  I should see error message if user confidence level is less than 200 during GG Login

  Scenario: User confidence level is less than 200 during GG Login
    Given I log into the GGLogin Page
    When Confidence level less is less than 200
    Then I should see SCA home page with an error "You can’t access this service with this account"

