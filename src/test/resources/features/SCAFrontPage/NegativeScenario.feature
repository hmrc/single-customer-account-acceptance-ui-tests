@suite
Feature: As a user of SCA (Single Customer Account) application
  I should see error message:
  1. If invalid NINO format is provided during GG Login
  2. If user confidence level is less than 200 during GG Login


  Scenario: User enters invalid NINO format during GG Login
  Given I log into the GGLoginPage
  When Invalid NINO format is entered
  Then I should see error on GG Login Page as "You must supply a valid Nino"

  Scenario: User confidence level is less than 200 during GG Login
    Given I log into the GGLogin Page
    When Confidence level less is less than 200
    Then I should see SCA home page with an error "You can’t access this service with this account"

