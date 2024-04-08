package StepDefinitions.Paying_bills;

import Pages.ParentPage;
import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;

import java.util.List;

public class payingBills_pom extends ParentPage {
    public payingBills_pom() {
        PageFactory.initElements(GWD.getDriver(), this);
    }
    // LeftPanel

    @FindBy(name = "username")
    public WebElement username;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(xpath = "//div/input[@value='Log In']")
    public WebElement login;

    @FindBy(css = "div[id='leftPanel']>p")
    public WebElement smallText;

    @FindBy(linkText = "Bill Pay")
    public WebElement billPay;

    @FindBy(linkText = "Accounts Overview")
    public WebElement accountsOverview;

    public WebElement getWebElementLeft(String strElement) {
        switch (strElement) {
            case "billPay":
                return this.billPay;
            case "accountsOverview":
                return this.accountsOverview;

        }
        return null;
    }

    // RightPanel

    @FindBy(name = "payee.name")
    public WebElement payeeName;

    @FindBy(name = "payee.address.street")
    public WebElement payeeAddress;

    @FindBy(name = "payee.address.city")
    public WebElement payeeCity;

    @FindBy(name = "payee.address.state")
    public WebElement payeeState;

    @FindBy(name = "payee.address.zipCode")
    public WebElement payeeZipCode;

    @FindBy(name = "payee.phoneNumber")
    public WebElement payeePhoneNumber;

    @FindBy(name = "payee.accountNumber")
    public WebElement accountNumber;

    @FindBy(name = "verifyAccount")
    public WebElement verifyAccount;

    @FindBy(name = "amount")
    public WebElement amount;

    @FindBy(css = "select[name ='fromAccountId']")
    public WebElement fromAccountSelect;

    @FindBy(css = "input[value='Send Payment']")
    public WebElement sendPaymentButton;

    @FindBy(css = "div[ng-show='showResult']>h1")
    public WebElement billPaymentResult;

    @FindBy(id = "amount")
    public WebElement amountResult;

    @FindBy(id = "fromAccountId")
    public WebElement fromAccountId;

    @FindBy(id="balance")
    public WebElement balance;

    @FindBy(css = "tr[ng-repeat='transaction in transactions']")
    public List<WebElement> transactionList;

    @FindBy(css = "tr[ng-repeat='account in accounts']")
    public List<WebElement> accountList;

    public WebElement getWebElementRight(String strElement) {
        switch (strElement) {
            case "payeeName":
                return this.payeeName;
            case "payeeAddress":
                return this.payeeAddress;
            case "payeeCity":
                return this.payeeCity;
            case "payeeState":
                return this.payeeState;
            case "payeeZipCode":
                return this.payeeZipCode;
            case "payeePhoneNumber":
                return this.payeePhoneNumber;
            case "accountNumber":
                return this.accountNumber;
            case "verifyAccount":
                return this.verifyAccount;
            case "amount":
                return this.amount;
            case "sendPaymentButton":
                return this.sendPaymentButton;
        }
        return null;
    }
}

