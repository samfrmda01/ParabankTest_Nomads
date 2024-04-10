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

    @FindBy(css = "input[name='username']")
    public WebElement username;
    @FindBy(css = "input[name='password']")
    public WebElement password;
    @FindBy(css = "input[type='submit']")
    public WebElement loginButton;
    @FindBy(css = "[id='rightPanel'] div div h1")
    public WebElement overview;
    @FindBy(css = "div[id='rightPanel'] select:nth-child(2)")
    public WebElement selectDrDo;
    @FindBy(css = "div[id='leftPanel'] ul li:nth-child(1)")
    public WebElement newAcc;
    @FindBy(css = "[id='rightPanel'] div div p:nth-child(5) b")
    public WebElement limitAmount;
    @FindBy(css = "[id='rightPanel'] div div p:nth-child(2)")
    public WebElement successMessage;
    @FindBy(css = "input[type='submit']")
    public WebElement submit;
    @FindBy(css = "a[id='newAccountId']")
    public WebElement newAccId;


}