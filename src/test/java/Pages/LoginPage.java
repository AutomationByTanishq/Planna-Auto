package Pages;

import Config.Common;
import io.appium.java_client.MobileDriver;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;

import java.io.IOException;

public class LoginPage {

    public MobileDriver driver;
    Common common = new Common();

    public LoginPage(MobileDriver driver) {
        this.driver=driver;
    }

    String LoginButton = "//android.widget.TextView[@text='Log In']";
    String ContinueWithUsername = "//android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup";
    String SignInFormUserNameField = "//android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[1]";
    String SignInFormPasswordField = "//android.view.View/android.view.View[2]/android.view.View[2]/android.widget.EditText[2]";
    String SignInButton = "//android.widget.Button[@text='submit']";
    String SkipButton = "//android.widget.TextView[@text='Skip']";
    String AccountMenu ="//android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]";
    String LogoutButton = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[3]/android.view.ViewGroup[6]";

    public void Verify_User_Login_And_Logout_Functionality() throws InterruptedException, IOException, ParseException {
        driver.findElement(By.xpath(LoginButton)).click();
        common.log("Clicked On Login Button");
        driver.findElement(By.xpath(ContinueWithUsername)).click();
        common.log("Clicked On Continue with username Button");
        Thread.sleep(4000);
        String UserName = common.readJson("UserName");
        String Password = common.readJson("Password");
        driver.findElement(By.xpath(SignInFormUserNameField)).sendKeys(UserName);
        common.log("Entered UserName :- " +UserName);
        driver.findElement(By.xpath(SignInFormPasswordField)).sendKeys(Password);
        common.log("Entered UserName :- " +Password);
        driver.findElement(By.xpath(SignInButton)).click();
        common.log("Clicked On Sign In Button");
        Thread.sleep(6000);
        driver.findElement(By.xpath(SkipButton)).click();
        common.log("Clicked On Skip Button");
        Thread.sleep(2000);
        driver.findElement(By.xpath(AccountMenu)).click();
        common.log("Clicked On Account Menu Button");
        driver.findElement(By.xpath(LogoutButton)).click();
        common.log("Clicked On Logout Button");
        Thread.sleep(5000);
        driver.findElement(By.xpath(LoginButton)).isDisplayed();
        common.log("Back to Welcome Screen");
    }
}