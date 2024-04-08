Feature: Update contact information

  Background:
    Given Navigate to the parabank
    When Enter username and password and click login buttonn
    Then Navigate to the update contact info
    And Click the update profile button to save user updates

  Scenario: Positive update contact information
    When The user enters new information in the relevant fields
    Then User should display an appropriate message
      | helperText | has been added |
    And User switches the session
    When Enter username and password and click login button
    Then User should display an appropriate message
      | smallTextMessage |umit |

  Scenario: Negative update contact information
    When Leave three fields blank
    Then Confirm error messages





