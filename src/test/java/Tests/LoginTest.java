package Tests;

import Config.Configuration;
import Pages.LaunchAppPage;
import Pages.LoginPage;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import java.io.IOException;

public class LoginTest extends Configuration {

    @Test
    public void Verify_Login_And_Logout_Functionality() throws InterruptedException, IOException, ParseException {
        LaunchAppPage launchApp = new LaunchAppPage(driver);
        LoginPage login = new LoginPage(driver);
        launchApp.Verify_Application_Launched();
        login.Verify_User_Login_And_Logout_Functionality();
    }
}