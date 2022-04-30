Feature:Sign in and Sign up page

  Scenario: New customer registration
    Given Sign in and Sign up page is loaded
    When user enters valid email into Email address field and clicks Continue button
    Then new Customer account creation page is loaded
