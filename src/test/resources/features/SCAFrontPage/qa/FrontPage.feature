@suite
Feature: As a user of SCA (Single Customer Account) web Application I should be able to login and access the list of services available on home page menu.

  Scenario: User logins to SCA web application and should see default GOV.UK header and footer along with service name so user is reassured they have signed into Government service.
    Given User login to the GG Login Page
    And User is on SCA start page
    Then User should see SCA title page Header contain logo text as GOV.UK in govuk-header__logotype-text
    Then User should see SCA title page Header contain service name as Single Customer Account in govuk-header__content
    Then User should see SCA title page footer contain © Crown copyright in govuk-footer__meta-item
    When User click Home on SCA landing page menu by id nav-home
    Then User should see SCA user name as Edward Robertson

  Scenario: User logins to SCA web application and should see following services available on SCA home page menu.
    When User click Home on SCA landing page menu by id nav-home
    Then User should see following services on home page menu Your taxes and benefits, Messages and Your details

  Scenario: Given an individual who has SA subscribed (trading or incorporated) signs into SCA web application then the user should see following service tiles under Your taxes and benefits.
    When User click Your Taxes and Benefits on SCA landing page menu by id nav-taxes-and-benefits
    Then User should see following tiles on the page Income from employment, Self Assessment and Your State Pension

  Scenario: As an Individual I want to have the ability from the SCA WAT service to go to Pension /NI information so that, I can have the ability to easily navigate between pages and access various features available in Pension and NI service.
    When User selects Check your State Pension summary link in State Pension tile
    Then System directs the user to State Pension summary page
    Then User see Your State Pension summary in govuk-heading-xl
    Then The user should be able to return to 'Your taxes and benefits' page
    When User selects Check your National Insurance record link in State Pension tile
    Then System directs the user to National Insurance record page
    Then User see Your National Insurance record in govuk-heading-xl
    Then The user should be able to return to 'Your taxes and benefits' page

  Scenario: As a user of SCA web Application I should be able to access CHOCS (Change of Circumstances) service from SCA home page menu
    When User click Your Details on SCA landing page menu by id nav-details
    Then User should see CHOCS title page Header contain service name as View and update your details with HMRC in govuk-header__content

  Scenario: As a user of SCA web Application I should be able to provide new service feedback, report any technical problems and provide feedback after sign-out from application.
    When User click Home on SCA landing page menu by id nav-home
    Then User should see if there is a link present on homepage to report Technical Problems Is this page not working properly? (opens in new tab)
    When User click on new service feedback link
    Then User should see feedback page contain text as Send your feedback
    Then User should return back to SCA home page
    When User click Sign out button on SCA landing page menu by id nav-signout
    Then User should get re-directed to customer feedback page
    Then User should see customer feedback page contain text as Give feedback