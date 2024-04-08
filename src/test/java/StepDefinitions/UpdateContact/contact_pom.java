package StepDefinitions.UpdateContact;

import Pages.ParentPage;
import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contact_pom extends ParentPage {
    public contact_pom(){
        PageFactory.initElements(GWD.getDriver(),this);
    }

    @FindBy(name = "username")
    public WebElement username;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(css = "[value='Log In']")
    public WebElement loginButton;

    @FindBy(css = "[href='/parabank/updateprofile.htm']")
    public WebElement updateContact;

    @FindBy(name = "customer.firstName")
    public WebElement firstName;

    @FindBy(name = "customer.lastName")
    public  WebElement lastName;

    @FindBy(name = "customer.address.street")
    public WebElement address;

    @FindBy(name = "customer.address.city")
    public WebElement city;

    @FindBy(name = "customer.address.state")
    public WebElement state;

    @FindBy(name = "customer.address.zipCode")
    public WebElement zipCode;

    @FindBy(name = "customer.phoneNumber")
    public WebElement phoneNumber;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement updateProfile;

    @FindBy(css = "h1[class='title']")
    public WebElement helperText;

    @FindBy(xpath = "//span[@class='error ng-scope']")
    public WebElement requiredMessage;

    @FindBy(css = "[href='/parabank/logout.htm']")
    public WebElement logOut;

    @FindBy(css = "[id='customer.firstName.errors']")
    public WebElement firstNameError;

    @FindBy(css = "[id='customer.lastName.errors']")
    public WebElement lastNameError;

    @FindBy(css = "[id='customer.address.street.errors']")
    public WebElement addressError;

    @FindBy(css = "[class='smallText']")
    public WebElement smallTextMessage;

    public WebElement getWebElement(String element) {
        switch (element) {
            case "helperText":
                return this.helperText;
            case "smallTextMessage":
                return this.smallTextMessage;

        }
        return null;
    }

}
