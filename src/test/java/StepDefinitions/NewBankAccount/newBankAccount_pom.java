package StepDefinitions.NewBankAccount;

import Pages.ParentPage;
import Utilities.GWD;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class newBankAccount_pom extends ParentPage {
    public newBankAccount_pom() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "//*[@name=\"username\"]")
    public WebElement username;

    @FindBy(xpath = "//*[@name=\"password\"]")
    public WebElement password;

    @FindBy(xpath = "//a[text()='Open New Account']")
    public WebElement OpenNewAccount;

    @FindBy(xpath = "//input[@value=\"Log In\"]")
    public WebElement LoginButton;

    @FindBy(xpath = "//*[@id=\"leftPanel\"]/p")
    public WebElement LoginSuccessText;

    @FindBy(xpath = "//*[@id=\"type\"]")
    public WebElement AccountType;

    @FindBy(xpath = "//*[@id=\"type\"]/option[1]")
    public WebElement Checkingoption;

    @FindBy(xpath = "//select[@id=\"fromAccountId\"]")
    public WebElement existingaccount;

    @FindBy(xpath = "//option[@value='13788']")
    public WebElement option13;


    @FindBy(xpath = "//*[@value=\"Open New Account\"]")
    public WebElement OpenAccountButton;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/div/div/h1")
    public WebElement AccountOpenTest;
    @FindBy(xpath = "//a[text()='Open New Account']")
    public WebElement openNewAcc;

    public WebElement getWebElement(String strElement) {

        switch (strElement) {
            case "username":
                return this.username;
            case "password":
                return this.password;
            case "OpenNewAccount":
                return this.OpenNewAccount;
            case "LoginButton":
                return this.LoginButton;
            case "LoginSuccessText":
                return this.LoginSuccessText;
            case "AccountType":
                return this.AccountType;
            case "Checkingoption":
                return this.Checkingoption;
            case "existingaccount":
                return this.existingaccount;
            case "OpenAccountButton":
                return this.OpenAccountButton;
            case "AccountOpenTest":
                return this.AccountOpenTest;
            case "option13":
                return this.option13;
            case "openNewAcc":
                return this.openNewAcc;


        }

        return null;
    }


}