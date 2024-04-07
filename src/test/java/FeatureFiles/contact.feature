Feature: Update contact information

  Background:
    Given Navigate to the parabank
    When Enter username and password and click login button
    Then Navigate to the uptade contact info
    And Click the update profile button to save user updates

  Scenario: Positive update contact information
    When The user enters new information in the relevant fields
    Then User should receive an appropriate error message

    Scenario: Negative uptade contact information
      When Leave three fields blank
      Then Confirm error messages
      And User switches the session


