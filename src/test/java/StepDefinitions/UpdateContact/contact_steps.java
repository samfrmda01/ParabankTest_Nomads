package StepDefinitions.UpdateContact;

import Pages.ParentPage;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
        cp.mySendKeys(cp.username, "ew");
        cp.mySendKeys(cp.password, "ew");
        cp.myClick(cp.loginButton);
    }
    @And("Navigate to the update contact info")
    public void navigateToTheUptadeContactInfo() {
        cp.myClick(cp.updateContact);
    }
    @When("The user enters new information in the relevant fields")
    public void theUserEntersNewInformationInTheRelevantFields() {
        cp.mySendKeys(cp.firstName, "eser");
        cp.mySendKeys(cp.lastName, "eser");
        cp.mySendKeys(cp.address, "c");
        cp.mySendKeys(cp.city, "d");
        cp.mySendKeys(cp.state, "e");
        cp.mySendKeys(cp.zipCode, "f");
        cp.mySendKeys(cp.phoneNumber, "123456");
    }
    @Then("Click the update profile button to save user updates")
    public void clickTheUpdateProfileButtonToSaveUserUpdates() {
        cp.myClick(cp.updateProfile);
    }
    @And("User should display an appropriate message")
    public void userShouldDisplayAnAppropriateMessage(DataTable message) {

        List<List<String>> strLinkList = message.asLists(String.class);
        for (int i = 0; i < strLinkList.size(); i++) {
            WebElement text=cp.getWebElement(strLinkList.get(i).get(0));
            cp.verifyContainsText(text,strLinkList.get(i).get(1));
        }
    }

    @And("Leave three fields blank")
    public void leaveThreeFieldsBlank() {
      // cp.mySendKeys(cp.firstName, "");
      // cp.mySendKeys(cp.lastName, "");
      // cp.mySendKeys(cp.address, "");

        wait.until(ExpectedConditions.visibilityOf(cp.firstName));
        cp.firstName.clear();
        wait.until(ExpectedConditions.visibilityOf(cp.lastName));
        cp.lastName.clear();
        wait.until(ExpectedConditions.visibilityOf(cp.address));
        cp.address.clear();
    }
    @And("Click the button")
    public void clickTheButton() {
        cp.myClick(cp.updateProfile);
    }
    @Then("Confirm error messages")
    public void confirmErrorMessages() {
        cp.verifyContainsText(cp.firstNameError, "First name is required.");
        cp.verifyContainsText(cp.lastNameError, "Last name is required.");
        cp.verifyContainsText(cp.addressError, "Address is required.");
    }
    @Then("User switches the session")
    public void userSwitchesTheSession() {
        cp.myClick(cp.logOut);

    }

}

