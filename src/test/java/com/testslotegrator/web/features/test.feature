Feature: test

 Scenario: A success authorization
    Given Navigate to Page Login
    When A User enters a valid login
    And A User enters a valid password
    And A User clicks on Submit button
    Then Application open Dashboard page

 Scenario: A valid email id is allowed
    Given Navigate to Page Login
    When A User enters a valid login
    And A User enters a valid password
    When A User clicks on Submit button
    Then Application open Dashboard page
    Given Navigate to Page Players
    Then Application open Players page





  # TODO - the below step is not be implemented because feature is still not available
    # And Application shows an error message "Invalid Email"