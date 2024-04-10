package StepDefinitions.NewBankAccount;

import Pages.ParentPage;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import java.util.ArrayList;
import java.util.List;

public class newBankAccount_steps extends ParentPage {
    newBankAccount_pom ns = new newBankAccount_pom();

    @Given("Navigate to ParaBankk")
    public void navigateToParaBankk() {
        GWD.getDriver().get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
    }

    @When("Enterr username and password and click login button")
    public void enterrUsernameAndPasswordAndClickLoginButton() {
        mySendKeys(ns.username, "1");
        mySendKeys(ns.password, "1");
        myClick(ns.loginButton);
    }

    @Then("User should login successfully")
    public void userShouldLoginSuccessfully() {
        Assert.assertTrue(ns.overview.isDisplayed(), "login failed");
    }

    @And("Click on the Element in LeftNav")
    public void clickOnTheElementInLeftNav() {
        myClick(ns.newAcc);
    }

    @And("Click on the Element in Dialog")
    public void clickOnTheElementInDialog() {
        Select dropDown = new Select(ns.selectDrDo);
        List<WebElement> opts = dropDown.getOptions();
        List<String> optNames = new ArrayList<>();
        int s = 0;
        for (WebElement x : opts) {
            optNames.add(x.getText());
        }
        if ((!optNames.isEmpty() && optNames.size() < 3)) {


            for (String x : optNames) {
                if (x.equals("SAVINGS")) {
                    s++;
                } else if (x.equals("CHECKING")) {
                    s++;
                } else {
                    Assert.fail("fail");
                }
            }
        } else {
            Assert.fail("fail2");
        }
        verifyContainsText(ns.limitAmount, "A minimum");
        dropDown.selectByIndex(0);
        WaitNano(3);
        myClick(ns.submit);
    }

    @When("Select savings account")
    public void selectSavingsAccount() {
        Select dropDown = new Select(ns.selectDrDo);
        List<WebElement> opts = dropDown.getOptions();
        List<String> optNames = new ArrayList<>();
        int s = 0;
        for (WebElement x : opts) {
            optNames.add(x.getText());
        }
        if (!optNames.isEmpty() && optNames.size() < 3) {
            for (String x : optNames) {
                if (x.equals("SAVINGS")) {
                    s++;
                } else if (x.equals("CHECKING")) {
                    s++;
                } else {
                    Assert.fail("fail");
                }
            }
        } else {
            Assert.fail("fail2");
        }
        verifyContainsText(ns.limitAmount, "A minimum");
        dropDown.selectByIndex(1);
        WaitNano(2);
        myClick(ns.submit);
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        verifyContainsText(ns.successMessage, "Congratulations,");
        Assert.assertTrue(ns.newAccId.isDisplayed());
    }


}

