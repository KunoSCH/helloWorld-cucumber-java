Feature: Hello World
  Scenario: Print "Hello World"
    Given The browser is open
    And The user is on the homepage
    Then The page should display "Hello World!"