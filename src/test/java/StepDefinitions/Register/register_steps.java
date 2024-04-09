package StepDefinitions.Register;

import Pages.ParentPage;
import Utilities.GWD;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class register_steps extends ParentPage {

    register_pom rp =
            new register_pom();

    @Given("Navigate to website")
    public void navigateToWebsite() {
        GWD.getDriver().get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
        System.out.println("on the website");
    }

    @When("Register new account")
    public void registerNewAccount() {

        rp.myClick(rp.Register);
        rp.mySendKeys(rp.FirstName, "ali");
        rp.mySendKeys(rp.LastName, "veli");
        rp.mySendKeys(rp.Address, "Esenler");
        rp.mySendKeys(rp.City, "Istanbul");
        rp.mySendKeys(rp.State, "1.Bolge");
        rp.mySendKeys(rp.ZipCode, "ali101010");
        rp.mySendKeys(rp.Phone, "3434343434");
        rp.mySendKeys(rp.SSN, "Bilmem");
        rp.mySendKeys(rp.Username, String.valueOf(ax));
        rp.mySendKeys(rp.Password, String.valueOf(bx));
        rp.mySendKeys(rp.Confirm, String.valueOf(bx));
        rp.myClick(rp.REGISTER);
    }

    @Then("Should be available success message")
    public void shouldBeAvailableSuccessMessage() {
        rp.verifyContainsText(rp.Sonuc, "Your account was created successfully. You are now logged in");
    }
}
