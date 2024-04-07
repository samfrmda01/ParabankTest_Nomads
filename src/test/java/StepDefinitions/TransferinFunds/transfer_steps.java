package StepDefinitions.TransferinFunds;

import Pages.ParentPage;
import Utilities.GWD;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class transfer_steps extends ParentPage {
    transfer_pom tp = new transfer_pom();
    List<String> accountsIDs = new ArrayList<>();
    List<Double> accountsBalances = new ArrayList<>();
    String[] transferAccounts = new String[2];
    double[] balances = new double[2];
    int transferAmount;
    String transferAmountStr;

    @Given("navigate to ParaBank")
    public void navigate_to_parabank() {
        GWD.getDriver().get("https://parabank.parasoft.com/");
    }

    @And("user has logged in username as {string} password as {string}")
    public void user_has_logged_in(String username, String password) {
        tp.mySendKeys(tp.username, username);
        tp.mySendKeys(tp.password, password);
        tp.myClick(tp.loginButton);
    }

    @And("user has at least two accounts")
    public void userHasAtLeastTwoAccounts() {
        tp.myClick(tp.accountsOverview);
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

    @When("user transfers money")
    public void userTransfersMoney() {
        tp.myClick(tp.transferFunds);
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
        tp.mySendKeys(tp.amount, String.valueOf(transferAmount));
        tp.myClick(tp.transferButton);
    }

    @Then("success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        String strAmount= String.valueOf(transferAmount);
        if (strAmount.length()>=7){
            transferAmountStr=strAmount.substring(0,strAmount.length()-3)+","+strAmount.substring(strAmount.length()-3);
        }
        verifyContainsText(tp.result,transferAmountStr);
        verifyContainsText(tp.result,transferAccounts[0]);
        verifyContainsText(tp.result,transferAccounts[1]);
    }
}