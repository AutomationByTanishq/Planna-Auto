package Pages;

import Config.Common;
import Config.Configuration;
import io.appium.java_client.MobileDriver;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import java.awt.*;
import java.io.IOException;

public class GetStartedPage {

    public MobileDriver driver;
    Common common = new Common();

    public GetStartedPage(MobileDriver driver) throws AWTException {
        this.driver=driver;
    }

    String GetStartedButton = "//android.widget.TextView[@text='Get Started']";
    String GetStartedPageHeader = "//android.widget.TextView[@text='Get Started']";
    String PostcodeTextField = "//android.widget.EditText[starts-with(@text,'Enter your postcode')]";
    String SelectFirstAddressFromList = "//android.widget.TextView[@text='10 IRVING ROAD']";
    String TermsAndConditionsCheckBox = "//android.widget.TextView[starts-with(@text,'I agree')]//..//android.view.ViewGroup";
    String NextButton = "//android.widget.TextView[@text='Next']";
    String PropertyUserType = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]";
    String HomeownerOption = "//android.widget.TextView[@text='Homeowner']";
    String RenterOption = "//android.widget.TextView[@text='Renter']";
    String PropertyType = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]";
    String TerracedHouseOption = "//android.widget.TextView[@text='Terraced house']";
    String EndTerracedHouseOption = "//android.widget.TextView[@text='End terraced house']";
    String MidTerracedHouseOption = "//android.widget.TextView[@text='Mid terraced house']";
    String DetachedHouseOption = "//android.widget.TextView[@text='Detached house']";
    String BungalowOption = "//android.widget.TextView[@text='Bungalow']";
    String FlatOption = "//android.widget.TextView[@text='Flat']";
    String MaisonetteOption = "//android.widget.TextView[@text='Maisonette']";
    String SelectBedroom = "//android.widget.TextView[@text='bedroom']";
    String IncreaseBedroomCount = "//android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup[3]/android.widget.TextView";
    String SaveAndContinueButton = "//android.widget.TextView[@text='Save & Continue']";
    String WhoLivesWithYouPage = "//android.widget.TextView[@text='Who else lives with you?']";
    String SelectWhoLivesWithYou = "//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup";
    String PlanSuccessMsgScreen = "//android.widget.TextView[starts-with(@text,'Success')]";
    String CreateYourAccountButton = "//android.widget.TextView[@text='Create your account']";
    String ContinueWithUsername = "//android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[4]/android.view.ViewGroup";
    String CreateYourAccountPage = "//android.widget.TextView[@text='Create your account']";
    String FirstNameTextField = "//android.widget.EditText[@text='First Name']";
    String LastNameTextField = "//android.widget.EditText[@text='Last Name']";
    String CreateUsernameTextField = "//android.widget.EditText[@text='Create a username']";
    String EmailTextField = "//android.widget.EditText[@text='Email']";
    String TermsOfServiceCheckbox_CreateAccountPage = "//android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup";
    String Password_TextField ="//android.widget.EditText[@text='Password']";
    String Re_EnterPasswordTextField ="//android.widget.EditText[@text='Re-enter Password']";
    String SignUpButton = "//android.widget.TextView[@text='Sign Up']";
    String UserMailVerificationScreen = "//android.widget.TextView[@text='Please check your email for a verification code.']";

    public void Verify_Get_Started_page_And_SignUp() throws IOException, ParseException, InterruptedException {
        Actions action=new Actions(driver);
        driver.findElement(By.xpath(GetStartedButton)).click();
        common.log("Clicked On Get Started Button");
        driver.findElement(By.xpath(GetStartedPageHeader));
        common.log("Get Started Page Header Verified");
        String PostCode = common.readJson("PostCode");
        driver.findElement(By.xpath(PostcodeTextField)).click();
        driver.findElement(By.xpath(PostcodeTextField)).sendKeys(PostCode);
        common.log("Entered PostCode :- " + PostCode);
        action.sendKeys(Keys.ENTER).perform();
        Thread.sleep(7000);
        driver.findElement(By.xpath(SelectFirstAddressFromList)).click();
        common.log("Selected FirstAddress Form the list");
        driver.findElement(By.xpath(TermsAndConditionsCheckBox)).click();
        common.log("Clicked on Terms And Conditions Checkbox");
        driver.findElement(By.xpath(NextButton)).click();
        common.log("Clicked Next Button on Get Started Page");
        Thread.sleep(4000);
        driver.findElement(By.xpath(PropertyUserType)).click();
        common.log("Clicked On first dropdown for the selection between HomeOwner and Renter");
        driver.findElement(By.xpath(RenterOption)).click();
        common.log("Selected Renter");
        driver.findElement(By.xpath(PropertyType)).click();
        common.log("Clicked On first dropdown for the selection between types of property");
        driver.findElement(By.xpath(EndTerracedHouseOption)).click();
        common.log("Selected End terraced house property");
        driver.findElement(By.xpath(SelectBedroom)).click();
        common.log("Clicked On bedroom count");
        driver.findElement(By.xpath(IncreaseBedroomCount)).click();
        common.log("Increased bedroom count to 1");
        driver.findElement(By.xpath(SaveAndContinueButton)).click();
        common.log("Clicked On Save & Continue Button");
        driver.findElement(By.xpath(WhoLivesWithYouPage)).isDisplayed();
        common.log("Who else lives with you page is displayed now");
        driver.findElement(By.xpath(SelectWhoLivesWithYou)).click();
        common.log("Selected Partner as option");
        driver.findElement(By.xpath(SaveAndContinueButton)).click();
        common.log("Clicked On Save & Continue Button");
        Thread.sleep(3000);
        driver.findElement(By.xpath(PlanSuccessMsgScreen)).isDisplayed();
        common.log("Your Plan Is Ready screen is displayed");
    }

    public void Create_Account() throws IOException, ParseException, InterruptedException {
        driver.findElement(By.xpath(CreateYourAccountButton)).click();
        common.log("Clicked On Create Your Account Button");
        driver.findElement(By.xpath(ContinueWithUsername)).click();
        common.log("Clicked On Continue with username Button");
        Thread.sleep(2000);
        String FirstName = common.readJson("FirstName");
        String LastName = common.readJson("LastName");
        String UserName = common.generateRandomChars(5);
        String Email = common.generateRandomChars(5) + "@mailinator.com";
        String Password = common.readJson("Password");
        driver.findElement(By.xpath(FirstNameTextField)).sendKeys(FirstName);
        common.log("Entered First Name :- "+FirstName);
        Thread.sleep(1000);
        driver.findElement(By.xpath(LastNameTextField)).sendKeys(LastName);
        common.log("Entered First Name :- "+LastName);
        Thread.sleep(1000);
        driver.findElement(By.xpath(CreateUsernameTextField)).sendKeys(UserName);
        common.log("Entered First Name :- " + UserName);
        Thread.sleep(1000);
        driver.findElement(By.xpath(EmailTextField)).sendKeys(Email);
        common.log("Entered First Name :- " + Email);
        Thread.sleep(1000);
        driver.findElement(By.xpath(TermsOfServiceCheckbox_CreateAccountPage)).click();
        common.log("Clicked On terms of service and privacy police checkbox");
        driver.findElement(By.xpath(NextButton)).click();
        common.log("Clicked Next Button on Create Account Page");
        driver.findElement(By.xpath(Password_TextField)).sendKeys(Password);
        common.log("Entered Password :- "+Password);
        driver.findElement(By.xpath(Re_EnterPasswordTextField)).sendKeys(Password);
        common.log("Re-Entered Password  :- "+Password);
        driver.findElement(By.xpath(SignUpButton)).click();
        common.log("Clicked On Sign Up");
        driver.findElement(By.xpath(UserMailVerificationScreen)).isDisplayed();
        common.log("User Is now on Mail Verification Screen");
    }
}