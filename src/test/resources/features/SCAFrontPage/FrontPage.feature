@suite @ZAP
Feature: As a user of SCA (Single Customer Account) web Application I should be able to login and access the list of services available on home page menu.

Feature:  Post a JSON payload to message service to stub messages on SCA message page

  Scenario Outline:: Post an API call to message service to mimic messages on SCA message page
    Given message service is running i.e. get API call return '<getStatusCode>'
    Then I should post a test message to message service and get the '<postStatusCode>'

    Examples:
      | getStatusCode | postStatusCode |
      | 200           | 201            |

  Scenario: User logins to SCA web application and should see default GOV.UK header and footer along with service name so user is reassured they have signed into Government service.

    Given I log into the GG Login Page
    And I am on SCA start page
    Then I should see SCA title page Header contain logo text as "GOV.UK"
    Then I should see SCA title page Header contain service name as "Single Customer Account"
    Then I should see SCA title page footer contain "© Crown copyright"
    When I click on 'Home' on SCA landing page menu
    Then I should see SCA name as "John Johnson"

  Scenario: User logins to SCA web application and should see following services available on SCA home page menu.

    When I click on 'Home' on SCA landing page menu
    Then I should see following services on home page menu "Your taxes and benefits" "Messages" "Your details"

  Scenario: Given an individual who has SA subscribed (trading or incorporated) signs into SCA web application then the user should be able to access existing Self Assessment service via Tax and Benefits on SCA home page menu.

    When I click on 'Your Taxes and Benefits' on SCA landing page menu
    Then I should see following services available "Self Assessment" "Pay As You Earn (PAYE)" "National Insurance" "State Pension"

  Scenario: As an Individual, I want to have the ability to navigate from the SCA sign in page to a Messages page So that, I can access and read all messages and communication including documents from HMRC in one place.
    When User selects 'Messages' from the SCA home page menu
    Then The user can see all their messages under messages home page
    """
    SCA Test Message
    """
    When User click on a Message
    Then More information related to that message can be seen under message focus page
    """
    SCA Test Message
    """
    Then The user should be able to return to Messages home page

  Scenario: As a user of SCA web Application I should be able to access CHOCS (Change of Circumstances) service from SCA home page menu

    When I click on 'Your Details' on SCA landing page menu
    Then I should see CHOCS title page Header contain service name as "View and update your details with HMRC"

  Scenario: As a user of SCA web Application I should be able to provide new service feedback, report any technical problems and provide feedback after sign-out from application.

    When I click on 'Home' on SCA landing page menu
    Then I should see if there is a link present on homepage to report Technical Problems "Is this page not working properly? (opens in new tab)"
    When I click on new service feedback link
    Then I should see feedback page contain text as "Send your feedback"
    Then I should return back to SCA home page
    Then I should see if there is a link present on homepage to report Technical Problems "Is this page not working properly? (opens in new tab)"
    When I click on Sign out button on SCA title page header
    Then I should get re-directed to customer feedback page
    Then I should see customer feedback page contain text as "Give feedback"
