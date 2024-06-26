package StepDefinitions.Credit;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class credit_pom {
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
    WebElement helperText; //gidici
    @FindBy(css = "div[id='leftPanel'] li:nth-child(2)")
    WebElement accountOverview;
    @FindBy(css = "tbody tr[ng-repeat]")
    List<WebElement> accounts;
    @FindBy(css = "[id='newAccountId']")
    WebElement newAccountId;
    @FindBy(css = "[id='accountType']")
    WebElement accountType;
    @FindBy(css = "p[ng-if]")
    WebElement helperText2;

    @FindBy(css = "td[ng-if]")
    WebElement approvedOdenied;
    @FindBy(css = "p[class='error']")
    WebElement error;
    @FindBy(css = "div[ng-if] p")
    WebElement success;


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
