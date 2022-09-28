@suite

Feature: As a user of SCA web application I should be able to access existing Self Assessment service via Tax and Benefits on SCA home page menu.

  Scenario: Given an individual who has SA subscribed (trading or incorporated) signs into SCA web application then the user should be able to access existing Self Assessment service via Tax and Benefits on SCA home page menu.

    Given I log into the GG Login Page
    And I am on SCA start page
    When I click on 'Your Taxes and Benefits' on SCA landing page menu
    Then I should see following services available "Self Assessment" "Pay As You Earn (PAYE)" "National Insurance" "State Pension"
    When User selects the SA service from the tax and benefits page
    Then The user is directed to the existing SA service to view or perform various SA activities

  Scenario: Given an individual with no business interest (no SA registration) signs into SCA web application then the user shouldn't see Self Assessment service under Tax and Benefits on SCA home page menu.

    Given I log into the GG Login Page with no SA enrolment
    And I am on SCA start page
    When I click on 'Your Taxes and Benefits' on SCA landing page menu
    Then I should only see following services available "Pay As You Earn (PAYE)" "National Insurance" "State Pension"
