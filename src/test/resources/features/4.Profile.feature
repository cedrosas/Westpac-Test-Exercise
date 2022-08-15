Feature: Update profile

  @Profile @UpdateProfile
  Scenario: User Updates profile once logged in
    Given Open Test web portal
    And I Login into the Portal
    When user update profile additional info
    Then Update profile should be successful

  @Profile @password
  Scenario: User Updates the password
    Given Open Test web portal
    And I Login into the Portal
    When User updates the password
    Then Update profile password should be successful