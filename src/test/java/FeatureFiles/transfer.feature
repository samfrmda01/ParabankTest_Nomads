@Payment @Regression
Feature: Inter-Account Money Transfer

  Background:
    Given the user navigates to ParaBank
    And the user logs in username as "testt" password as "tt"
    And the user has at least two accounts


  Scenario: Successful Money Transfer
    When the user initiates a money transfer between accounts
    Then a success message should be displayed


  Scenario: Verify Transfer
    When the user clicks on the Account Overview
    And the user clicks on the senders ID
    Then the user verifies the transaction via Account Details
    When the user clicks on the transaction's name
    And the user records the transaction ID
    And the user clicks on the Find Transactions
    And the user enters the transaction ID into the relevant box
    And the user clicks on the Find Transactions button
    Then the user verifies the transaction via Transaction Details