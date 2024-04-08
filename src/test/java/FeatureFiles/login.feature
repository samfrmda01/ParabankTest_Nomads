Feature: Login

  Scenario: Login positive
    Given Navigate to website
    When Enter username and password and click login button

    Then Should be available success message.


  Scenario Outline: Login negative
    Given Navigate to website
    When Enter username as "<userName>" password as "<Password>" and click login button
    Then Should be available difrent message
    Examples:
      | userName | Password |
      | hata45   | hata45   |
      |          | hata45   |
      | hata45   |          |
      |          |          |


