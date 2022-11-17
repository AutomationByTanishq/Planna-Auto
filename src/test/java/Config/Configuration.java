package Config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Configuration {

	public AppiumDriver driver = null;
	Common common = new Common();

	@BeforeMethod
	public void init(ITestResult testResult) throws IOException {
		String testName = testResult.getName();
		Properties config = common.readConfigFile("runConfig");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", config.getProperty("platformName"));
		capabilities.setCapability("platformVersion", config.getProperty("platformVersion"));
		capabilities.setCapability("deviceName", config.getProperty("deviceName"));
		capabilities.setCapability("app", config.getProperty("appPath"));
		capabilities.setCapability("fullReset",true);
		capabilities.setCapability("automationName", config.getProperty("automationName"));
		driver = new AppiumDriver<MobileElement>(new URL(config.getProperty("server")), capabilities);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		common.log("Test Started : " + testName + "<br>");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown(ITestResult testResult) throws IOException, AWTException {
			String testName = testResult.getName();
			File img = new File("target" + File.separator + "surefire-reports" + File.separator + testName + ".png");
			if (testResult.getStatus()==1) {
				common.log("PASS : " + testResult.getName()+ "<br>"+ "<br>");
				testResult.getThrowable();
			}
			else if (testResult.getStatus()==2) {
				common.makeScreenshot(driver,testName);
				Reporter.log("Failed : This test is failed at the above screen"+ "<br>"+ "<br>");
			}
		driver.quit();
	}
}