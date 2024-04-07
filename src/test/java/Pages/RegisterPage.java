package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
    public void register_Page(){
        PageFactory.initElements(GWD.getDriver(),this);
    }
    @FindBy(css = "form[name='login']+p+p>a")
    WebElement Register;
    @FindBy(xpath = "//table[@class='form2']/tbody/tr[1]/td[2]/input")
    WebElement FirstName;
    @FindBy(xpath = "//table[@class='form2']/tbody/tr[2]/td[2]/input")
    WebElement LastName;
    @FindBy(xpath = "//table[@class='form2']/tbody/tr[3]/td[2]/input")
    WebElement Address;
    @FindBy(xpath = "//table[@class='form2']/tbody/tr[4]/td[2]/input")
    WebElement City;
    @FindBy(xpath = "//table[@class='form2']/tbody/tr[5]/td[2]/input")
    WebElement State;
    @FindBy(xpath = "//table[@class='form2']/tbody/tr[6]/td[2]/input")
    WebElement ZipCode;
    @FindBy(xpath = "//table[@class='form2']/tbody/tr[7]/td[2]/input")
    WebElement Phone;
    @FindBy(xpath = "//table[@class='form2']/tbody/tr[8]/td[2]/input")
    WebElement SSN;
    @FindBy(xpath = "//table[@class='form2']/tbody/tr[10]/td[2]/input")
    WebElement Username;
    @FindBy(xpath = "//table[@class='form2']/tbody/tr[11]/td[2]/input")
    WebElement Password;
    @FindBy(xpath = "//table[@class='form2']/tbody/tr[12]/td[2]/input")
    WebElement Confirm;
    @FindBy(xpath = "//table[@class='form2']/tbody/tr[13]/td[2]/input")
    WebElement REGISTER;
    @FindBy(css = "div[id='rightPanel']>p")
    WebElement Sonuc;

}
