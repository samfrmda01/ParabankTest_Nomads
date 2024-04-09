package StepDefinitions.NewBankAccount;

import Pages.ParentPage;
import StepDefinitions.UpdateContact.contact_pom;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class newBankAccount_steps extends ParentPage {
    newBankAccount_pom ns = new newBankAccount_pom();
    @Given("Navigate to ParaBank")
    public void navigateToParaBank() {

        System.out.println("System open");
        GWD.getDriver().get("https://parabank.parasoft.com/parabank/index.htm");
    }

    @When("Enterr username and password and click login button")
    public void enterrUsernameAndPasswordAndClickLoginButton() {
        ns.mySendKeys(ns.username, "fatos");
        ns.mySendKeys(ns.password, "demo123");
        ns.myClick(ns.LoginButton);
    }

    @Then("User should login successfully")
    public void userShouldLoginSuccessfully() {
       // ns.verifyContainsText(ns.LoginSuccessText, "fatos");
    }

    @And("Click on the Element in LeftNav")
    public void clickOnTheElementInLeftNav(DataTable linkler) {
        List<String> strLinkList = linkler.asList(String.class);

        for (int i = 0; i < strLinkList.size(); i++) {
            System.out.println(strLinkList.get(i));
            WebElement linkWebElemnt = ns.getWebElement(strLinkList.get(i));
            ns.myClick(linkWebElemnt);
        }
    }

    @And("Click on the Element in Dialog")
    public void clickOnTheElementInDialog(DataTable butonlar) {
        List<String> strButtonList = butonlar.asList(String.class);

        for (int i = 0; i < strButtonList.size(); i++) {
            //System.out.println(strLinkList.get(i));
            WebElement linkWebElemnt = ns.getWebElement(strButtonList.get(i));
            ns.myClick(linkWebElemnt);
        }
    }

    @Then("Success message should be displayed")
    public void successMessageShouldBeDisplayed() {
        ns.verifyContainsText(ns.AccountOpenTest, "Account Opened!");
    }

}

