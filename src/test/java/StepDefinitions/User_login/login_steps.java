package StepDefinitions.User_login;

import Utilities.GWD;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class login_steps {
    boolean kosull = false;
    login_pom lp = new login_pom();

    @When("Enter username and password and click login button")
    public void Enterusernameandpasswordandclickloginbutton() {
        lp.mySendKeys(lp.username, "1");
        lp.mySendKeys(lp.password, "1");
        lp.myClick(lp.loginButton);
    }

    @Then("Should be available success message.")
    public void shouldBeAvailableSuccessMessage() {
        lp.verifyContainsText(lp.sonuc,"Account Services");
    }
/////////////////////////////////negative


    @When("Enter username as {string} password as {string} and click login button")
    public void enterUsernameAsPasswordAsAndClickLoginButton(String userName, String Password) {
        lp.mySendKeys(lp.username, userName);
        lp.mySendKeys(lp.password, Password);
        lp.myClick(lp.loginButton);
        if (userName.isEmpty()|| Password.isEmpty()) {
            kosull =true;
        }
        else kosull=false;

    }

    @Then("Should be available difrent message")
    public void shouldBeAvailableDifrentMessage() {
        if (!kosull){
            Assert.assertTrue(lp.sonuc2.getText().contains("An internal error has occurred and has been logged."));
        }
        else
            Assert.assertTrue(lp.sonuc2.getText().contains("Please enter a username and password."));
    }
}
//Please enter a username and password.
//An internal error has occurred and has been logged.