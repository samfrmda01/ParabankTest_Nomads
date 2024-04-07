package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    public void login() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css = "input[name='username']")
    WebElement username;
    @FindBy(css = "input[name='password']")
    WebElement password;
    @FindBy(css = "input[type='submit']")
    WebElement loginButton;

    public WebElement getWebElement(String element) {
        switch (element) {
            case "username":
                return this.username;
            case "password":
                return this.password;
            case "loginButton":
                return this.loginButton;
        }
        return null;
    }
}
