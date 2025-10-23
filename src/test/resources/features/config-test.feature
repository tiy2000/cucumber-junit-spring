@Cfg
Feature: Configuration test

  Scenario: Test explicitly specified application platform configuration
    Given Application was started
    When I get platform "android"
    Then I should receive app name "android app name"

  Scenario: Test application platform configuration
    Given Application was started
    When I get current platform
    Then I should receive app name "ios app name"

  Scenario: Test explicitly specified appium configuration
    Given Application was started
    When I get appium running profile "saucelab"
    Then I should receive url "http://saucelab.com"

  Scenario: Test current appium configuration
    Given Application was started
    When I use current appium running profile
    Then I should receive url "http://localhost"
