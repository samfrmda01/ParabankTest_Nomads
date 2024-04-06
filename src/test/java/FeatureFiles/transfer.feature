@Payment @Regression
Feature: Inter-Account Money Transfer
#  Background:
  Scenario: temporary
    Given navigate to ParaBank
    And user has logged in username as "testnomads" password as "Nomad07+"
    And user has at least two accounts
    When user transfer money
#    Then success message should be displayed
#    And the message should include transaction details
#
#
#  Scenario: Money Transfer Case 1
#    And user verifies the transaction via "Account Details"
    # buyer id, date, amount of money
#
#  Scenario: Money Transfer Case 2
#    And user verifies the transaction via "Find Transactions"
    # transaction ID,