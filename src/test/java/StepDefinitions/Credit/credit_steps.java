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

import java.util.List;

public class credit_steps {
    credit_pom cP = new credit_pom();

    @Given("Navigate to the website")
    public void navigateToTheWebsite() {
        GWD.getDriver().get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
        System.out.println("on the website");
    }

    @When("User logs in with valid credentials")
    public void userLogsInWithValidCredentials(DataTable table) {
        List<List<String>> buttons = table.asLists(String.class);
        for (int i = 0; i < buttons.size(); i++) {
            WebElement a = cP.getWebElement(buttons.get(i).get(0));
            cP.mySendKeys(a, buttons.get(i).get(1));
        }
        System.out.println("entered credentials successfully");
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
        System.out.println("on the site");
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
    }
}
