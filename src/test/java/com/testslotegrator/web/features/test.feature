Feature: test

 Scenario: A success authorization
    Given Navigate to Page Login
    When A User enters a valid login
    And A User enters a valid password
    And A User clicks on Submit button
    Then Application open Dashboard page

 Scenario: A success authorization and open Player page
    Given Navigate to Page Login
    When A User enters a valid login
    And A User enters a valid password
    When A User clicks on Submit button
    Then Application open Dashboard page
    Given Navigate to Page Players
    Then Application open Players page

   Scenario: A success authorization and change sorting on player page
      Given Navigate to Page Login
      When A User enters a valid login
      And A User enters a valid password
      When A User clicks on Submit button
      Then Application open Dashboard page
      Given Navigate to Page Players
      Then Application open Players page
      And A specify sorting status as "Not active"
      Then All line in table have status "Not active"
