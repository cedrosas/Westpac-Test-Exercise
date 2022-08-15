Feature: User Navigate into UI

 @NavigateIU @PopularMake
  Scenario Outline: Vote a for model in Popular make
    Given Open Test web portal
    And I Login into the Portal
    When User votes "<CAR>" in Popular make
    Then Vote should be successful
    Examples:
      | CAR       |
      | 4c Spider |

  @NavigateIU @PopularCar
  Scenario: Post comment on the Popular car
    Given Open Test web portal
    And I Login into the Portal
    When User select Popular Model
    Then Vote should be successful
  @NavigateIU @AllinRaing
  Scenario Outline: Vote a for model in Popular make
    Given Open Test web portal
    And I Login into the Portal
    When User votes "<CAR>" in all over rating
    Then Vote should be successful
    Examples:
      | CAR       |
      | Diablo |

