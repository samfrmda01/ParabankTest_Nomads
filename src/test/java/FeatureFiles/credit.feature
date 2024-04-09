@Loan @Accounts @Regression
Feature: Take Loan

  Scenario Outline: Application of Loan
    Given Navigate to the website
    When User logs in with valid credentials
      | username | ew |
      | password | ew |
    Then Click on login button
      | loginButton |
    And Click on request loan button
      | requestLoan |
    And Enter loan and downpayment amount
      | loanAmount  | <loan>         |
      | downPayment | <downPaymentt> |
    Then Select an account
      | selectAcc |
    And Click on the apply button
      | applyLoan |
    Then Check helper texts
    Examples:
      | loan    | downPaymentt |
      | 0       | 0            |
      | 10000   | 5            |
      | 0       | 50           |
      | 10      | 50           |
      | 1000000 | 999999       |
      | 1000    | 500          |