@Accounts @SmokeTest @Regression
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
      | haAASSSAta45zxcqweqwceqwxda15866100000 | $#@wsopkcsaSA1x,02c3e |
      |          | hata45   |
      | hata45   |          |
      |          |          |


