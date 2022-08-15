Feature: Login into web portal

  @Register
  Scenario: Login into web portal
    Given Open Test web portal
    When User inputs user details
    Then Register should be successful