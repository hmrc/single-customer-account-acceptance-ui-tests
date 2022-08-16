@suite
  Feature: As a user of SCA (Single Customer Account) application
    I should login to SCA so that I can see title page header, footer and customer name.

    Scenario: User logins to SCA application and should see default GOV.UK header and footer along with service name
    so user is reassured they have signed into Government service.

      Given I log into the GG Login Page
      And I am on SCA start page
      Then I should see SCA title page Header contain logo text as
         """
         GOV.UK
         """
      Then I should see SCA title page Header contain service name as
         """
         Single Customer Account
         """
      Then I should see SCA title page footer contain
         """
         © Crown copyright
         """
      When I click on Sign out button on SCA title page header
      Then I should get re-directed to customer feedback page
      Then I should see customer feedback page contain body text as
         """
         Give feedback
         """

