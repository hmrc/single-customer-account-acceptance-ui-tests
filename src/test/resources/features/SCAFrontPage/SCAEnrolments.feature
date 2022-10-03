@suite

Feature: SCA web application user should only see the services they have enrolled.

  Scenario: Given an individual with no business interest (no SA registration) signs into SCA web application then the user shouldn't see Self Assessment service under Tax and Benefits on SCA home page menu.

    Given I log into the GG Login Page with no SA enrolment
    And I am on SCA start page
    When I click on 'Your Taxes and Benefits' on SCA landing page menu
    Then I should not see "Self Assessment" under Your Taxes and Benefits
