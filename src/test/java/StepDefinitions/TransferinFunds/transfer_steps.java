package StepDefinitions.TransferinFunds;

import Pages.ParentPage;
import Utilities.GWD;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class transfer_steps extends ParentPage {
    transfer_pom tp = new transfer_pom();
    private static List<String> accountsID= new ArrayList<>();
    private static List<Double> accountsBalance= new ArrayList<>();


    @Given("navigate to ParaBank")
    public void navigate_to_parabank() {
        GWD.getDriver().get("https://parabank.parasoft.com/");
    }

    @And("user has logged in username as {string} password as {string}")
    public void user_has_logged_in(String username, String password) {
        tp.mySendKeys(tp.username, username);
        tp.mySendKeys(tp.password, password);
        tp.myClick(tp.loginButton);
    }

    @And("user has at least two accounts")
    public void userHasAtLeastTwoAccounts() {
        tp.myClick(tp.accountsOverview);
        wait.until(ExpectedConditions.visibilityOfAllElements(tp.accounts));
        Assert.assertTrue(tp.accounts.size()>=2,"There are less than two accounts!");
        for (WebElement x: tp.accounts){
            WebElement y= x.findElement(By.cssSelector("a"));
            WebElement z= x.findElement(By.cssSelector("td[class='ng-binding']"));
            accountsID.add(y.getText());
//            int j= z.getText().indexOf(".00") ,1-8 out of bounds exception
            double d= Double.parseDouble(z.getText().replace(',','.').substring(1,8));
            Assert.assertTrue(d>=0,y+"'s balance is not sufficient!");
            accountsBalance.add(d);
        }
    }

    @When("user transfer money")
    public void userTransferMoney() {
        tp.myClick(tp.transferFunds);
        for (int i = 0; i < accountsID.size(); i++) {
            System.out.println(accountsID.get(i)+" "+accountsBalance.get(i));
        }
    }
}