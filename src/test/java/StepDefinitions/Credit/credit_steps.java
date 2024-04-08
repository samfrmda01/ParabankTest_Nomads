package StepDefinitions.Credit;

import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Pages.ParentPage.WaitNano;

public class credit_steps {
    static int num = 0;
    credit_pom cP = new credit_pom();

    @Given("Navigate to the website")
    public void navigateToTheWebsite() {
        GWD.getDriver().get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
    }

    @When("User logs in with valid credentials")
    public void userLogsInWithValidCredentials(DataTable table) {
        List<List<String>> buttons = table.asLists(String.class);
        for (int i = 0; i < buttons.size(); i++) {
            WebElement a = cP.getWebElement(buttons.get(i).get(0));
            cP.mySendKeys(a, buttons.get(i).get(1));
        }
    }


    @Then("Click on login button")
    public void clickOnLoginButton(DataTable table) {
        List<String> buttons = table.asList(String.class);
        for (int i = 0; i < buttons.size(); i++) {
            WebElement a = cP.getWebElement(buttons.get(i));
            cP.myClick(a);
        }
        cP.scrollToElement(GWD.getDriver().findElement(By.cssSelector("h1[class='title']")));
        Assert.assertEquals(GWD.getDriver().getCurrentUrl(), "https://parabank.parasoft.com/parabank/overview.htm", "buggy");
    }

    @And("Click on request loan button")
    public void clickOnRequestLoanButton(DataTable table) {
        List<String> buttons = table.asList(String.class);
        for (int i = 0; i < buttons.size(); i++) {
            WebElement a = cP.getWebElement(buttons.get(i));
            cP.myClick(a);
        }
    }

    @And("Enter loan and downpayment amount")
    public void enterLoanAndDownpaymentAmount(DataTable table) {
        List<List<String>> buttons = table.asLists(String.class);
        for (int i = 0; i < buttons.size(); i++) {
            WebElement a = cP.getWebElement(buttons.get(i).get(0));
            cP.mySendKeys(a, buttons.get(i).get(1));
        }
    }

    @Then("Select an account")
    public void selectAnAccount(DataTable table) {
        List<String> buttons = table.asList(String.class);
        for (int i = 0; i < buttons.size(); i++) {
            WebElement a = cP.getWebElement(buttons.get(i));
            Select x = new Select(a);
            x.selectByIndex(0);
        }


    }

    @And("Click on the apply button")
    public void clickOnTheApplyButton(DataTable table) {
        List<String> buttons = table.asList(String.class);
        for (int i = 0; i < buttons.size(); i++) {
            WebElement a = cP.getWebElement(buttons.get(i));
            cP.myClick(a);
        }
    }

    @Then("Check helper texts")
    public void checkHelperTexts() {
        num++;
        WaitNano(10);
        List<String> helperTexts = new ArrayList<>(Arrays.asList("Error!", "Status: Denied", "Status: Approved"));
        if (num == 1) {
            cP.verifyContainsText(cP.helperText, helperTexts.get(0));
        } else if (num == 2) {
            cP.verifyContainsText(cP.helperText, helperTexts.get(1));
        } else if (num == 3) {
            cP.verifyContainsText(cP.helperText, helperTexts.get(0));
        } else if (num == 4) {
            cP.verifyContainsText(cP.helperText, helperTexts.get(1));
        } else if (num == 5) {
            cP.verifyContainsText(cP.helperText, helperTexts.get(2));
            String account = cP.helperText.getText().substring(cP.helperText.getText().length() - 5);
            cP.myClick(cP.accountOverview);
            WaitNano(4);
            for (WebElement x : cP.accounts) {
                if (x.getText().contains(account)) {
                    String[] amount = x.getText().split(" ");
                    String dollaSign = amount[1].replaceAll("[^\\d.]", "");
                    double amountD = Double.parseDouble(dollaSign);
                    Assert.assertEquals(amountD, 1000.0, "buggyz");
                }
            }
        }


    }
}
