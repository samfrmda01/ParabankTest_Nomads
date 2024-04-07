@Payment @Regression
Feature: Inter-Account Money Transfer

  Background:
    Given navigate to ParaBank
    And user has logged in username as "nnn" password as "nn"
    And user has at least two accounts


  Scenario: Money Transfer
    When user transfers money
    Then success message should be displayed


#  Scenario: Verification of the transfer
#    When user clicks on the Account Overview
#    And user clicks on the senders ID
#    Then user verifies the transaction via "Account Details"
#    When user clicks on the transaction's name
#    And user records the transaction ID
#    And user clicks on the Find Transactions
#    And user enters the transaction ID into the relevant box
#    And user clicks on the
#    # buyer id, date, amount of money
#    And user verifies the transaction via "Find Transactions"
#    # transaction ID