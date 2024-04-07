package StepDefinitions.UpdateContact;

import Pages.ParentPage;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class contact_steps extends ParentPage {

    contact_pom cp = new contact_pom();

    @Given("Navigate to the parabank")
    public void navigateToTheParabank() {
        GWD.getDriver().get("https://parabank.parasoft.com/");
    }
    @When("Enter username and password and click login button")
    public void enterUsernameAndPasswordAndClickLoginButton(String username, String password) {
        cp.mySendKeys(cp.username, "asd");
        cp.mySendKeys(cp.password, "asd");
        cp.myClick(cp.loginButton);

    }
    @And("Navigate to the uptade contact info")
    public void navigateToTheUptadeContactInfo() {
        cp.myClick(cp.updateContact);
    }
    @When("The user enters new information in the relevant fields")
    public void theUserEntersNewInformationInTheRelevantFields(String firstname, String lastname) {
        cp.mySendKeys(cp.firstName, "a");
        cp.mySendKeys(cp.lastName, "b");
        cp.mySendKeys(cp.address, "c");
        cp.mySendKeys(cp.city, "d");
        cp.mySendKeys(cp.state, "e");
        cp.mySendKeys(cp.zipCode, "f");
        cp.mySendKeys(cp.phoneNumber, "123456");

    }
    @Then("Click the {string} button to save user updates")
    public void clickTheButtonToSaveUserUpdates(String arg0) {
        cp.myClick(cp.updateProfile);

    }
    @And("User should receive an appropriate error message")
    public void userShouldReceiveAnAppropriateErrorMessage() {
        if (cp.helperText.isDisplayed());

    }
    @And("Leave three fields blank")
    public void leaveThreeFieldsBlank() {
        cp.mySendKeys(cp.firstName, "");
        cp.mySendKeys(cp.lastName, "");
        cp.mySendKeys(cp.address, "");

    }
    @And("Click the {string} button")
    public void clickTheButton(String arg0) {
        cp.myClick(cp.updateProfile);
    }
    @Then("Confirm error messages")
    public void confirmErrorMessages(WebElement element, String value) {
      // wait.until(ExpectedConditions.textToBePresentInElement(element,value));
      // Assert.assertTrue(cp.requiredMessage.isDisplayed());

      // Assert.assertSame(cp.requiredMessage, "Firs name is required");

        cp.verifyContainsText(cp.requiredMessage, "already");
    }

    @Then("User switches the session")
    public void userSwitchesTheSession() {
        cp.myClick(cp.logOut);
        cp.myClick(cp.loginButton);
    }



}
