package StepDefinitions.TransferinFunds;

import Pages.ParentPage;
import Utilities.GWD;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class transfer_steps extends ParentPage {
    transfer_pom tp = new transfer_pom();
    List<String> accountsIDs = new ArrayList<>();
    List<Double> accountsBalances = new ArrayList<>();
    static String[] transferAccounts = new String[2];
    static double[] balances = new double[2];
    static int transferAmount;
    static String transferAmountStr;
    static String transactionID;
    LocalDate date = LocalDate.now();
    DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy");
    DateTimeFormatter format2 = DateTimeFormatter.ofPattern("MM-d-yyyy");

    @Given("the user navigates to ParaBank")
    public void navigate_to_parabank() {
        GWD.getDriver().get("https://parabank.parasoft.com/");
    }

    @And("the user logs in username as {string} password as {string}")
    public void user_has_logged_in(String username, String password) {
        mySendKeys(tp.username, username);
        mySendKeys(tp.password, password);
        myClick(tp.loginButton);
    }

    @And("the user has at least two accounts")
    public void userHasAtLeastTwoAccounts() {
        myClick(tp.accountsOverview);
        wait.until(ExpectedConditions.visibilityOfAllElements(tp.accounts));
        Assert.assertTrue(tp.accounts.size() >= 2, "There are less than two accounts!");
        for (WebElement x : tp.accounts) {
            WebElement y = x.findElement(By.cssSelector("a"));
            WebElement z = x.findElement(By.cssSelector("td[class='ng-binding']"));
            accountsIDs.add(y.getText());
            double d = Double.parseDouble(z.getText().replaceAll("[$,]", "")); //5000000.00
            Assert.assertTrue(d >= 0, y + "'s balance is not sufficient!");
            accountsBalances.add(d);
        }
    }

    @When("the user initiates a money transfer between accounts")
    public void userTransfersMoney() {
        myClick(tp.transferFunds);
        int randomFrom = RandomGenerator(accountsIDs.size() - 1, 0);
        transferAccounts[0] = accountsIDs.get(randomFrom);
        balances[0] = accountsBalances.get(randomFrom);
        Select selectF = new Select(tp.fromAccount);
        wait.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("[id='fromAccountId']>option"), accountsIDs.size()));
        selectF.selectByVisibleText(transferAccounts[0]);
        accountsIDs.remove(randomFrom);
        int randomTo = RandomGenerator(accountsIDs.size() - 1, 0);
        transferAccounts[1] = accountsIDs.get(randomTo);
        balances[1] = accountsBalances.get(randomTo);
        Select selectT = new Select(tp.toAccount);
        selectT.selectByVisibleText(accountsIDs.get(randomTo));
        transferAmount = RandomGenerator((int) balances[0], 1);
        mySendKeys(tp.amount, String.valueOf(transferAmount));
        myClick(tp.transferButton);
    }

    @Then("a success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        transferAmountStr = String.valueOf(transferAmount);
        if (transferAmountStr.length() >= 7) {
            transferAmountStr = transferAmountStr.substring(0, transferAmountStr.length() - 3) + "," + transferAmountStr.substring(transferAmountStr.length() - 3);
        }
        verifyContainsText(tp.result, transferAmountStr);
        verifyContainsText(tp.result, transferAccounts[0]);
        verifyContainsText(tp.result, transferAccounts[1]);
    }

    @When("the user clicks on the Account Overview")
    public void userClicksOnTheAccountOverview() {
        myClick(tp.accountsOverview);
    }

    @And("the user clicks on the senders ID")
    public void userClicksOnTheSendersID() {
        wait.until(ExpectedConditions.visibilityOfAllElements(tp.accounts));
        for (WebElement e : tp.accounts) {
            if (e.findElement(By.cssSelector("a")).getText().equals(transferAccounts[0])) {
                myClick(e.findElement(By.cssSelector("a")));
                break;
            }
        }
    }

    @Then("the user verifies the transaction via Account Details")
    public void userVerifiesTheTransactionViaAccountDetails() {
        wait.until(ExpectedConditions.visibilityOfAllElements(tp.accountDetails));
        verifyContainsText(tp.accountDetails.get(tp.accountDetails.size() - 1), date.format(format));
        verifyContainsText(tp.accountDetails.get(tp.accountDetails.size() - 1), transferAmountStr);
    }

    @When("the user clicks on the transaction's name")
    public void userClicksOnTheTransactionSName() {
        myClick(tp.accountDetails.get(tp.accountDetails.size() - 1).findElement(By.cssSelector("a")));
    }

    @And("the user records the transaction ID")
    public void userRecordsTheTransactionID() {
        wait.until(ExpectedConditions.visibilityOf(tp.ID));
        transactionID = tp.ID.getText();
    }

    @And("the user clicks on the Find Transactions")
    public void userClicksOnTheFindTransactions() {
        myClick(tp.findTransactions);
    }

    @And("the user enters the transaction ID into the relevant box")
    public void userEntersTheTransactionIDIntoTheRelevantBox() {
        mySendKeys(tp.IDtextbox, transactionID);
    }

    @And("the user clicks on the Find Transactions button")
    public void userClicksOnTheFindTransactionsButton() {
        myClick(tp.findTransactionsButton);
    }

    @Then("the user verifies the transaction via Transaction Details")
    public void userVerifiesTheTransactionViaTransactionDetails() {
        wait.until(ExpectedConditions.visibilityOfAllElements(tp.accountDetails));
        verifyContainsText(tp.accountDetails.get(0), date.format(format2));
        verifyContainsText(tp.accountDetails.get(0), String.valueOf(transferAmount));
    }
}