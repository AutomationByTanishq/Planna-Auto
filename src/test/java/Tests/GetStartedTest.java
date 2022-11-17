package Tests;

import Config.Configuration;
import Pages.GetStartedPage;
import Pages.LaunchAppPage;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;
import java.awt.*;
import java.io.IOException;

public class GetStartedTest extends Configuration {

    @Test
    public void Verify_Get_Started_page_And_SignUp_Functionality() throws InterruptedException, IOException, ParseException, AWTException {
        LaunchAppPage launchapp = new LaunchAppPage(driver);
        GetStartedPage getStarted = new GetStartedPage(driver);
        launchapp.Verify_Application_Launched();
//        getStarted.Verify_Get_Started_page_And_SignUp();
        getStarted.Create_Account();
    }
}