package StepDefinitions.User_login;

import Pages.ParentPage;
import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class login_pom extends ParentPage {
    public login_pom() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "input[name='username']")
    WebElement username;
    @FindBy(css = "input[name='password']")
    WebElement password;
    @FindBy(css = "input[type='submit']")
    WebElement loginButton;
    @FindBy(css = "p[class='smallText']+h2")
    WebElement sonuc;
    @FindBy(css = "div[id='rightPanel']>p")
    WebElement sonuc2;
}
