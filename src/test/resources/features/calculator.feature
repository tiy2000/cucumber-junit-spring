@Calc @Smoke
Feature: Calculator
  As a user of the calculator
  I want to perform basic arithmetic operations
  So that I can get correct results

  @Plus
  Scenario: Adding two numbers
    Given I have a calculator
    When I add 5 and 3
    Then the result should be 8

  @Minus
  Scenario: Subtracting two numbers
    Given I have a calculator
    When I subtract 10 and 8
    Then the result should be 2
