Feature: Update contact information

  Background:
    Given Navigate to the parabank
    When Enter username and password and click login button
    Then Navigate to the uptade contact info

  Scenario: Positive update contact information
    When The user enters new information in the relevant fields
    Then Click the "Update Profile" button to save user updates
    And User should receive an appropriate error message

    Scenario: Negative uptade contact information
      And Leave three fields blank
      And Click the "Update Profile" button
      Then Confirm error messages
      Then User switches the session


