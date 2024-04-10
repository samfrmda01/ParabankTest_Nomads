package StepDefinitions.Paying_bills;

import Pages.ParentPage;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class payingBills_steps {
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(20));
    payingBills_pom pb = new payingBills_pom();
    List<String> accountIdList = new ArrayList<>();
    List<Double> accountBalanceList = new ArrayList<>();
    double billAmount;
    String billId;
    double accountAmountFirst;
    String transactionsName;

    @Given("Navigate to ParaBank")
    public void navigateToParaBank() {
        GWD.getDriver().get("https://parabank.parasoft.com/");
    }

    @When("Enter username and password and click login buttton")
    public void enterUsernameAndPasswordAndClickLoginButtton() {
        pb.mySendKeys(pb.username, "1");
        pb.mySendKeys(pb.password, "1");
        pb.myClick(pb.login);
    }

    @Then("You should be able to log in successfully.")
    public void youShouldBeAbleToLogInSuccessfully() {
        pb.verifyContainsText(pb.smallText, "Welcome");
    }

    @And("Account table should be displayed")
    public void accountTableShouldBeDisplayed() {
        wait.until(ExpectedConditions.visibilityOfAllElements(pb.accountList));
        List<WebElement> accounts = pb.accountList;
        billAmount = ParentPage.RandomGenerator(1000, 100);

        for (WebElement account : accounts) {
            WebElement accountId = account.findElement(By.cssSelector("td>a"));
            WebElement accountBalance = account.findElement(By.cssSelector("td[class='ng-binding']"));
            double balance = Double.parseDouble(accountBalance.getText().replaceAll("[$,]", ""));

            if (balance > billAmount) {
                accountIdList.add(accountId.getText());
                accountBalanceList.add(balance);
            }
        }
        int randomIdIndex = ParentPage.RandomGenerator(accountIdList.size() - 1, 0);
        billId = accountIdList.get(randomIdIndex);
        accountAmountFirst = accountBalanceList.get(randomIdIndex);
    }

    @When("Determine the invoice type as {string}")
    public void determineTheInvoiceTypeAs(String payeeName) {
        pb.mySendKeys(pb.payeeName, payeeName);
        transactionsName = payeeName;
    }

    @And("Perform transaction verification")
    public void performTransactionVerification() {
        wait.until(ExpectedConditions.visibilityOfAllElements(pb.accountList));
        for (WebElement account : pb.accountList) {
            WebElement accountId = account.findElement(By.cssSelector("td>a"));

            if (accountId.getText().equals(billId)) {
                pb.myClick(accountId);
                break;
            }
        }
        wait.until(ExpectedConditions.visibilityOfAllElements(pb.transactionList));
        List<WebElement> transactions = pb.transactionList;
        WebElement transaction = transactions.get(transactions.size() - 1);
        LocalDate date = LocalDate.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy");

        String accountAmountLast = String.valueOf(accountAmountFirst - billAmount);
        pb.verifyContainsText(pb.balance, accountAmountLast);
        pb.verifyContainsText(transaction, date.format(format));
        pb.verifyContainsText(transaction, transactionsName);
        pb.verifyContainsText(transaction, String.valueOf(billAmount));
    }

    @And("Click on the element in LeftPanel")
    public void clickOnTheElementInLeftPanel(DataTable dt) {
        List<String> strDtList = dt.asList(String.class);

        for (String s : strDtList) {
            WebElement dtWebElement = pb.getWebElementLeft(s);
            pb.myClick(dtWebElement);
        }
    }

    @And("Send keys to item in RightPanel")
    public void sendKeysToItemInRightPanel(DataTable dt) {
        List<String> listElement = dt.asList(String.class);
        String accountNumber = RandomStringUtils.randomNumeric(5);
        for (int i = 0; i < listElement.size(); i++) {

            switch (i) {
                case 0:
                case 1:
                case 2:
                    pb.mySendKeys(pb.getWebElementRight(listElement.get(i)), RandomStringUtils.randomAlphanumeric(8));
                    break;
                case 3:
                    pb.mySendKeys(pb.getWebElementRight(listElement.get(i)), RandomStringUtils.randomNumeric(5));
                    break;
                case 4:
                    pb.mySendKeys(pb.getWebElementRight(listElement.get(i)), RandomStringUtils.randomNumeric(11));
                    break;
                case 5:
                case 6:
                    pb.mySendKeys(pb.getWebElementRight(listElement.get(i)), accountNumber);
                    break;
                case 7:
                    pb.mySendKeys(pb.getWebElementRight(listElement.get(i)), String.valueOf(billAmount));
                    break;
            }
        }
    }

    @And("Determine the payment account")
    public void determineThePaymentAccount() {
        wait.until(ExpectedConditions.visibilityOf(pb.fromAccountSelect));
        Select fromAccount = new Select(pb.fromAccountSelect);
        fromAccount.selectByValue(billId);
    }

    @And("Click on the element in RightPanel")
    public void clickOnTheElementInRightPanel(DataTable dt) {
        List<String> strDtList = dt.asList(String.class);

        for (String s : strDtList) {
            WebElement dtWebElement = pb.getWebElementRight(s);
            pb.myClick(dtWebElement);
        }
    }

    @Then("The successful completion of the payment should be displayed.")
    public void theSuccessfulCompletionOfThePaymentShouldBeDisplayed() {
        pb.verifyContainsText(pb.billPaymentResult, "Complete");
        double amountControl = Double.parseDouble(pb.amountResult.getText().replaceAll("[$,]", ""));
        Assert.assertEquals(amountControl, billAmount, "The payment amount could not be verified.");
        Assert.assertEquals(pb.fromAccountId.getText(), billId, "Account number could not be verified.");
    }
}