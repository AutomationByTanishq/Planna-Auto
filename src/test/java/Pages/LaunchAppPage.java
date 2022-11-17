package Pages;

import Config.Common;
import io.appium.java_client.MobileDriver;
import org.openqa.selenium.By;

public class LaunchAppPage {

    public MobileDriver driver;
    Common common = new Common();

    public LaunchAppPage(MobileDriver driver) {
        this.driver=driver;
    }

    String Welcome_Text = "//android.widget.TextView[@text='Welcome to Planna']";

    public void Verify_Application_Launched() throws InterruptedException {
        common.log("Application Launched");
        driver.findElement(By.xpath(Welcome_Text));
        common.log("Welcome Text Verified");
    }
}