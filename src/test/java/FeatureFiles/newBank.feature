@Accounts @SmokeTest @Regression
Feature: New Account Functionality

  Background:
    Given Navigate to ParaBankk
    When Enterr username and password and click login button
    Then User should login successfully
    And Click on the Element in LeftNav

  Scenario: Checking Account
    And Click on the Element in Dialog
    Then Success message should be displayed

  Scenario: Savings Account
    When Select savings account
    Then Success message should be displayed
