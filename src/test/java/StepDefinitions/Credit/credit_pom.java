package StepDefinitions.Credit;

import Pages.ParentPage;
import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class credit_pom extends ParentPage {
    public credit_pom() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "input[name='username']")
    WebElement username;
    @FindBy(css = "input[name='password']")
    WebElement password;
    @FindBy(css = "input[type='submit']")
    WebElement loginButton;
    @FindBy(css = "div[id='leftPanel'] ul li:nth-child(7)")
    WebElement requestLoan;
    @FindBy(css = "[id='amount']")
    WebElement loanAmount;
    @FindBy(css = "[id='downPayment']")
    WebElement downPayment;
    @FindBy(css = "select[id='fromAccountId']")
    WebElement selectAcc;
    @FindBy(css = "input[type='submit']")
    WebElement applyLoan;
    @FindBy(css = "div[ng-if^='show']")
    WebElement helperText;
    @FindBy(css = "div[id='leftPanel'] li:nth-child(2)")
    WebElement accountOverview;
    @FindBy(css = "tbody tr[ng-repeat]")
    List<WebElement> accounts;


    public WebElement getWebElement(String element) {
        switch (element) {
            case "username":
                return this.username;
            case "password":
                return this.password;
            case "loginButton":
                return this.loginButton;
            case "requestLoan":
                return this.requestLoan;
            case "loanAmount":
                return this.loanAmount;
            case "downPayment":
                return this.downPayment;
            case "applyLoan":
                return this.applyLoan;
            case "selectAcc":
                return this.selectAcc;
        }
        return null;
    }


}
