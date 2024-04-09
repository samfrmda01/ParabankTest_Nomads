Feature: New Account Functionality

  @SmokeTest @Regression
  Scenario: Create the Open New Account

    Given Navigate to ParaBank
    When Enterr username and password and click login button
    Then User should login successfully
    And Click on the Element in LeftNav
      |openNewAcc|
    And Click on the Element in Dialog
      |AccountType|
      |Checkingoption|
    And Click on the Element in Dialog
      |existingaccount|
      |option13|
    And Click on the Element in Dialog
      |OpenAccountButton|

    Then Success message should be displayed

