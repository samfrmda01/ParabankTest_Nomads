package StepDefinitions.TransferinFunds;

import Pages.ParentPage;
import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.List;

public class transfer_pom extends ParentPage {
    public transfer_pom() {
        PageFactory.initElements(GWD.getDriver(), this);
    }
    // login
    @FindBy(name = "username")
    public WebElement username;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(css = "[value='Log In']")
    public WebElement loginButton;

    // left nav
    @FindBy(linkText = "Accounts Overview")
    public WebElement accountsOverview;

    @FindBy(linkText = "Transfer Funds")
    public WebElement transferFunds;

    // dialog content
    @FindBy(css = "tr[class='ng-scope']")
    public List<WebElement> accounts;


}
