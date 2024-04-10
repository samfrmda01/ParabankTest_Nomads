@Contact @Accounts
Feature: Update contact information

  Background:
    Given Navigate to the parabank
    When Enter username and password and click login buttonn
    Then Navigate to the update contact info
    And Click the update profile button to save user updates

  Scenario: Positive update contact information
    When The user enters new information in the relevant fields
    Then User should display an appropriate message
      | helperText | have been added |
    And User switches the session
    When Enter username and password and click login buttoon
    Then User should display an appropriate message
      | smallTextMessage | eser |

  Scenario: Negative update contact information
    When Leave three fields blank
    Then Confirm error messages





