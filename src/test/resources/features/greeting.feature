@Greeting
Feature: Greeting service test

  Scenario: Greeting Alice
    Given the greeting service is running
    When I send a request to greet "Alice"
    Then I should receive a greeting message "Hello, Alice!"

  Scenario: Greeting Bob
    Given the greeting service is running
    When I send a request to greet "Bob"
    Then I should receive a greeting message "Hello, Bob!"