package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class leftNav {
    public void left_Nav() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "div[id='leftPanel'] ul li:nth-child(1)")
    WebElement openNewAcc;
    @FindBy(css = "div[id='leftPanel'] ul li:nth-child(2)")
    WebElement accOverview;
    @FindBy(css = "div[id='leftPanel'] ul li:nth-child(3)")
    WebElement transferFunds;
    @FindBy(css = "div[id='leftPanel'] ul li:nth-child(4)")
    WebElement billPay;
    @FindBy(css = "div[id='leftPanel'] ul li:nth-child(5)")
    WebElement findTransactions;
    @FindBy(css = "div[id='leftPanel'] ul li:nth-child(6)")
    WebElement updateContactInfo;
    @FindBy(css = "div[id='leftPanel'] ul li:nth-child(7)")
    WebElement requestLoan;
    @FindBy(css = "div[id='leftPanel'] ul li:nth-child(8)")
    WebElement logOut;
}
