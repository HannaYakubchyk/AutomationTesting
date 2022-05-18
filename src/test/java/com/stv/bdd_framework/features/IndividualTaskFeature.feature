Feature: Testing of wiggle.com as per Individual Task

  Scenario: Entering Your account page from Main page
    Given Main page is loaded
    When user accepts cookie consent banner if the one appears and clicks on Your Account link
    Then Sign in page is loaded


  Scenario Outline: Repeated Password Input
    When user inputs "<password>" into password field
    And user clicks on checkbox Show Password
    And checkbox is switched on
    And user clicks on checkbox to disable it
    And user deletes input from password field
    Then validation message for password field appears
  Examples:
    |password|
    |111     |
    |222     |


  Scenario: Check of validation messages after clicking Sign In Button
    When user clicks on Sign in securely button
    Then validation messages for email address field and password field appear

