@suite
Feature: As a user of SCA (Single Customer Account) application
  I should login to SCA so that I can see title page header, footer and customer name.

  Scenario: User logins to SCA application and should see default GOV.UK header and footer along with service name
  so user is reassured they have signed into Government service.

    Given I log into the GG Login Page
    And I am on SCA start page
    Then I should see SCA title page Header contain logo text as "GOV.UK"
    Then I should see SCA title page Header contain service name as "Single Customer Account"
    Then I should see SCA title page footer contain "© Crown copyright"
    Then I should see if there is a link present on homepage to report Technical Problems "Is this page not working properly? (opens in new tab)"
    When I click on 'Home' on SCA landing page menu
    Then I should see SCA name as "John Johnson"
    When I click on 'Your Taxes and Benefits' on SCA landing page menu
    Then I should see following services available "Self Assessment" "Pay As You Earn (PAYE)" "National Insurance" "State Pension"
    When I click on 'Your Details' on SCA landing page menu
    Then I should see CHOCS title page Header contain service name as "View and update your details with HMRC"
    When I click on new service feedback link
    Then I should see feedback page contain text as "Send your feedback"
    Then I should return back to SCA home page
    When I click on Sign out button on SCA title page header
    Then I should get re-directed to customer feedback page
    Then I should see customer feedback page contain text as "Give feedback"