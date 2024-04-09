Feature: : Bill Payment Functionality

  Scenario Outline: Different Types of Bill Payment Transactions
    Given Navigate to ParaBank
    When Enter username and password and click login button
    Then You should be able to log in successfully.
    And Account table should be displayed
    And Click on the element in LeftPanel
      | billPay |

    When Determine the invoice type as "<payeeName>"

    And Send keys to item in RightPanel
      | payeeAddress     |
      | payeeCity        |
      | payeeState       |
      | payeeZipCode     |
      | payeePhoneNumber |
      | accountNumber    |
      | verifyAccount    |
      | amount           |

    And Determine the payment account

    And Click on the element in RightPanel
      | sendPaymentButton |

    Then The successful completion of the payment should be displayed.

    And Click on the element in LeftPanel
      | accountsOverview |

    And Perform transaction verification

    Examples:
      | payeeName                   |
      | Electric Bill Payment       |
      | Water Bill Payment          |
      | Natural Gas Invoice Payment |