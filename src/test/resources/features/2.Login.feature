Feature: Login into web portal

  @Login
  Scenario: Login into web portal
    Given Open Test web portal
    When I Login into the Portal
    Then Login should be Successful