package Tests;

import Config.Configuration;
import Pages.LaunchAppPage;
import org.testng.annotations.Test;

public class LaunchAppTest extends Configuration {

    @Test
    public void Launch_Application() throws InterruptedException {
        LaunchAppPage launchapp = new LaunchAppPage(driver);
        launchapp.Verify_Application_Launched();
    }
}