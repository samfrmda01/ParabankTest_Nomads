package StepDefinitions.UpdateContact;

import Pages.ParentPage;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class contact_steps extends ParentPage {

    contact_pom cp = new contact_pom();

    @Given("Navigate to the parabank")
    public void navigateToTheParabank() {
        GWD.getDriver().get("https://parabank.parasoft.com/");
    }
    @When("Enter username and password and click login buttonn")
    public void enterUsernameAndPasswordAndClickLoginButtonn() {
        cp.mySendKeys(cp.username, "1");
        cp.mySendKeys(cp.password, "1");
        cp.myClick(cp.loginButton);
    }
    @And("Navigate to the update contact info")
    public void navigateToTheUptadeContactInfo() {
        cp.myClick(cp.updateContact);
    }
    @When("The user enters new information in the relevant fields")
    public void theUserEntersNewInformationInTheRelevantFields() {
       mySendKeys(cp.firstName, "eser");
        mySendKeys(cp.lastName, "eser");
        mySendKeys(cp.address, "c");
        mySendKeys(cp.city, "d");
        mySendKeys(cp.state, "e");
        mySendKeys(cp.zipCode, "f");
        mySendKeys(cp.phoneNumber, "123456");
        myClick(cp.updateProfile);
    }
    @Then("Click the update profile button to save user updates")
    public void clickTheUpdateProfileButtonToSaveUserUpdates() {
        myClick(cp.updateProfile);
    }
    @And("User should display an appropriate message")
    public void userShouldDisplayAnAppropriateMessage(DataTable message) {

        List<List<String>> strLinkList = message.asLists(String.class);
        for (int i = 0; i < strLinkList.size(); i++) {
            WebElement text=cp.getWebElement(strLinkList.get(i).get(0));
            verifyContainsText(text,strLinkList.get(i).get(1));
        }
    }

    @And("Leave three fields blank")
    public void leaveThreeFieldsBlank() {

        wait.until(ExpectedConditions.visibilityOf(cp.firstName));
        cp.firstName.clear();
        wait.until(ExpectedConditions.visibilityOf(cp.lastName));
        cp.lastName.clear();
        wait.until(ExpectedConditions.visibilityOf(cp.address));
        cp.address.clear();
WaitNano(4);
        mySendKeys(cp.firstName, "");
        mySendKeys(cp.lastName, "");
        mySendKeys(cp.address, "");
    }
    @And("Click the button")
    public void clickTheButton() {
        cp.myClick(cp.updateProfile);
    }
    @Then("Confirm error messages")
    public void confirmErrorMessages() {
//        WaitNano(5);
        ListContainsString(cp.tablee,"First name is required.");
        ListContainsString(cp.tablee,"Last name is required.");
        ListContainsString(cp.tablee,"Address is required.");
    }
    @Then("User switches the session")
    public void userSwitchesTheSession() {
        cp.myClick(cp.logOut);

    }
    @When("Enter username and password and click login buttoon")
    public void Enterusernameandpasswordandclickloginbuttoon() {
        mySendKeys(cp.username, "1");
        mySendKeys(cp.password, "1");
        myClick(cp.loginButton);
    }

}

