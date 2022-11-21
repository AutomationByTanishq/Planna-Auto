package com.auction.pages;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.text.ParseException;

//import org.omg.CORBA.portable.CustomValue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.interactions.PauseAction;
//import org.openqa.selenium.remote.server.handler.FindElement;
//import org.openqa.selenium.support.FindBy;
import org.openqa.grid.selenium.*;

import com.auction.init.Common;
import com.auction.pages.auctionregistration.AbstractPage;
import java.awt.event.*;
import java.io.File;

/**
 * 
 * @author Rahul
 * 
 * @param <signupUser>
 */
public class SignupPage extends AbstractPage {

	Common common = new Common(driver);

	/**
	 * Constructor
	 * 
	 * @param Dashboard driver
	 */
	public SignupPage(WebDriver driver) {
		super(driver);

	}

	/**
	 * Verify Signup Feature
	 * 
	 */
	public void verifySignupFeature() {

		System.out.println("Step :: verify signup page elements");
		common.log("<br></br>verify signup page elements");
		common.waitForConditionIsElementPresent("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']");
		System.out.println("Step :: Verify username text");
		common.log("<br><br>Step :: Verify username text");

		System.out.println("Step :: Username text.");
		common.log("<br></br>Step :: Username text.");
		common.assertElementPresent("//div[@class='" + LEGACY_TXT_SIGNUP_USERNAME + "']");

		System.out.println("Step :: Verify Password,");
		common.log("<br></br>Step :: Verify Password,");
		common.assertElementPresent("//div[text()='" + LEGACY_TXT_SIGNUP_PASSWORD + "']");

		System.out.println("Step :: Verify ConfirmPassword,");
		common.log("<br></br>Step :: Verify ConfirmPassword,");
		common.assertElementPresent("//div[@class='" + LEGACY_TXT_SIGNUP_CONFIRM_PASSWORD + "']");

		System.out.println("Step :: Verify email,");
		common.log("<br></br>Step :: Verify email,");
		common.assertElementPresent("//div[@class='" + LEGACY_TXT_SIGNUP_EMAIL + "']");

		System.out.println("Step :: Verify firstname,");
		common.log("<br></br>Step :: Verify firstname,");
		common.assertElementPresent("//div[@class='" + LEGACY_TXT_SIGNUP_FIRST_NAME + "']");

		System.out.println("Step :: Verify lastname,");
		common.log("<br></br>Step :: Verify lastname,");

		common.assertElementPresent("//div[@class='" + LEGACY_TXT_SIGNUP_LAST_NAME + "']");

		System.out.println("Step :: Verify phone,");
		common.log("<br></br>Step :: Verify phone,");
		common.assertElementPresent("//div[@class='" + LEGACY_TXT_SIGNUP_PHONE + "']");

		System.out.println("Step :: Verify Phone Type,");
		common.log("<br></br>Step :: Verify Phone Type,");
		common.assertElementPresent("//div[@class='" + LEGACY_TXT_SIGNUP_PHONE_TYPE + "']");

		System.out.println("Step :: Verify Bill Contact Type,");
		common.log("<br></br>Step :: Verify Bill Contact Type,");
		common.assertElementPresent("//div[@class='" + LEGACY_TXT_SIGNUP_BILL_CONTACT_TYPE + "']/div[@class='label']");

		System.out.println("Step :: Verify BillFirstname,");
		common.log("<br></br>Step :: Verify BillFirstname,");
		common.assertElementPresent("//div[@class='" + LEGACY_TXT_SIGNUP_BILL_FIRST_NAME + "']/div[@class='label']");

		System.out.println("Step :: Verify BillLastname,");
		common.log("<br></br>Step :: Verify BillLastname,");
		common.assertElementPresent("//div[@class='" + LEGACY_TXT_SIGNUP_BILL_LAST_NAME + "']/div[@class='label']");

		System.out.println("Step :: Verify billPhone,");
		common.log("<br></br>Step :: Verify billPhone,");
		common.assertElementPresent("//div[@class='" + LEGACY_TXT_SIGNUP_BILL_PHONE + "']/div[@class='label']");

	}

	/**
	 * Mandatory Fields
	 * 
	 */
	public void mandatoryFields() {

		// common.waitForElement("//input[@id='c5']");
		common.jsClick(signUp);

		common.waitForElement("//span[@id='pip1_ctl']//span[text()='Required']");
		common.assertElementPresent("//span[@id='pip1_ctl']//span[text()='Required']");
	}

	/**
	 * Sign Up User
	 * 
	 * @return
	 * @throws InterruptedException
	 */

	public LandingPage signupUser() throws InterruptedException {

		String FistName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		common.pause(20);
		System.out.println("Step :: Admin logout front");
		common.log("<br></br> Step :: Admin logout front");

		common.pause(25);

		common.jsClick(signUpLink);
		common.pause(80);

		System.out.println("Step :: Enter SignupUser Details");
		common.log("<br></br> Step :: SignupUSer Details.");
		// common.waitForElementIsDisplayed(By.xpath("//input[@id='" +
		// LEGACY_USER_SIGNUP_TXT_USERNAME + "']"));

		String signUpUser = common.generateRandomChars(6);

		common.waitForElement(By.xpath("//input[@id='\" + LEGACY_USER_SIGNUP_TXT_USERNAME + \"']\""));
		System.out.println("Step :: Enter Username ::" + signUpUser);
		common.log("<br></br>Step :: Enter New User");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']", signUpUser);

		common.log("<br></br>Step :: Random Value :: " + signUpUser);
		System.out.println("Step :: Random Value :: " + signUpUser);

		System.out.println("Step :: Enter First Name");
		common.log("<br></br> Step :: Enter First Name");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_FIRST_NAME + "']", signUpUser);

		System.out.println("Step :: Enter Last Name");
		common.log("<br></br> Step :: Enter Last Name");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_LAST_NAME + "']", signUpUser);

		System.out.println("Step :: New User >>" + "  " + signUpUser);
		common.log("<br></br>Step : New User >>" + "  " + signUpUser);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']", signUpUser);

		System.out.println("Step :: Enter Password");
		common.log("<br></br> Step :: Enter Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PASSWORD + "']", LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);

		System.out.println("Step :: Enter Confirm Password");
		common.log("<br></br> Step :: Enter Confirm Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_PASSWORD + "']",
				LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);

		System.out.println("Step :: Enter EmailUser :: " + EmailUser);
		common.log("<br></br>Step :: Enter EmailUser :: " + EmailUser);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_EMAIL + "']",
				EmailUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);
		common.pause(20);

		if (common.isElementPresent("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_EMAIL + "']"))

		{
			System.out.println("Step :: Enter Confim Email :: " + EmailUser);
			common.log("<br></br>Step :: Enter Confirm Email :: " + EmailUser);
			common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_EMAIL + "']",
					EmailUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);
		}

		else {
			System.out.println("Step :: Enter Confim Email is not display");
		}

		System.out.println("Step :: Enter Phone Number.");
		common.log("<br></br>Step :: Enter Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		Select_User_Info_Phone_Type(); // Select USer info Phone Type

		System.out.println("Step :: Identification Number.");
		common.log("<br></br>Step :: Identification Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_IDENTIFICATION + "']",
				LEGACY_USER_SIGNUP_TXT_IDENTIFICATION_VALUE);

		Select_Identification_Type(); // Select Identification Type

		return new LandingPage(driver);

	}

	/**
	 * Enter Bill Info
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void enterBillInfo(String signUpUser) throws InterruptedException {

		System.out.println("::: Billing Info :::");

		System.out.println("Step :: Verify that Contact type Combox box is peresent");
		common.log("Step :: Verify that Contact type Combox box is peresent");

		common.assertElementPresent("//span[@id='rbp25_ctl']");
		Select_Billing_Info_Phone_Type(); // Select Billing Info Phone Type

		System.out.println("Step :: Verfiy that Billing Firstname field is present");
		common.log("Step :: Verfiy that Billing Firstname field is present");
		common.assertElementPresent("//input[@id='rbp3']");

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", signUpUser);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", signUpUser);

		// common.wait(PASSED);
		common.pause(5);
		String company = common.generateRandomChars(8);
		System.out.println("Step :: Enter Company name");
		common.log("<br></br>Step :: Enter Company name.");
		driver.findElement(By.xpath("//*[@id='" + LEGACY_USER_SIGNUP_TXT_COMPANY1 + "']")).sendKeys(company);
		// common.type("//*[@id='" + LEGACY_USER_SIGNUP_TXT_COMPANY + "']", company);

		common.pause(5);
		System.out.println("Step :: Entering Phone Number.");
		common.log("<br></br>Step :: Entering Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		Select_Counrty_and_State(); // Select Country and State from dropdown

		System.out.println("Step :: Enter Address.");
		common.log("<br></br>Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		System.out.println("Step :: Verify City field is present");
		common.log("Step :: Verify City field is present");
		common.assertElementPresent("//input[@id='rbp10']");

		System.out.println("Step :: City.");
		common.log("<br></br>Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		System.out.println("Step :: Verify Zip field is present");
		common.log("Step:: Verify Zip field is present ");
		common.assertElementPresent("//input[@id='rbp12']");

		System.out.println("Step :: Enter Zip.");
		common.log("<br></br>Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		System.out.println("Step :: Verify Same as billing check box is present");
		common.log("Step :: Verfiy Same as billing checkbox is present");
		common.assertElementPresent("//input[@id='sip1']");

		System.out.println("Step :: Click on Same as billing check box.");
		common.log("<br></br>Step :: Click on Same as billing check box.");
		common.checkChkBox(ship);
		common.pause(10);

		System.out.println("Step :: Verify that captcha code filed is present");
		common.log("Step :: Verify that captcha code field is present");
		common.assertElementPresent("//input[@id='rf3']");

		System.out.println("Step :: Entering Captcha.");
		common.log("<br></br>Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		System.out.println("Step :: Verify that selecting terms checkbox is present");
		common.log("Step :: Verify that selecting terms checkbox is present");
		common.assertElementPresent("//input[@id='rf1']");

		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);
		common.pause(10);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		driver.findElement(By.xpath("//input[@value='Signup']")).click();
		// common.jsClick(signUp);
		common.pause(20);

	}

	/**
	 * Signup Success Message
	 * 
	 */
	public void signup_Success_Message() {

		common.pause20Sec();
		common.highlightElement("//a[contains(text(),'"+LEGACY_ADMIN_LNK_LOGOUT+"')]//..//p");
		common.assertElementPresent("//a[contains(text(),'"+LEGACY_ADMIN_LNK_LOGOUT+"')]//..//p");
		String SuccessMessage = driver.findElement(By.xpath("//a[contains(text(),'"+LEGACY_ADMIN_LNK_LOGOUT+"')]//..//p")).getText();
		System.out.println("Step :: Verify Success Message >> " + SuccessMessage);
		common.log("<br></br>Step :: Verify Success Message >> " + SuccessMessage);
		common.pause20Sec();
	}

	/**
	 * Enter Bill Info with "No" Captcha
	 * 
	 */
	public void enterBillInfoWithoutCaptcha() {

		common.waitForConditionIsElementPresent(
				"//select[@id='" + LEGACY_USER_SIGNUP_BILL_LST_CONTACT_TYPE_ELEMENT_PRESENT + "']");

		Select_Billing_Info_Phone_Type(); // Select Billing Phone Type

		System.out.println("Step :: Billing First Name :");
		common.log("<br></br>Step :: Billing First Name :");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Billing Last Name :");
		common.log("<br></br>Step :: Billing Last Name :");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		System.out.println("Step :: Billing Phone Number :");
		common.log("<br></br>Step :: Billing Phone Number :");
		System.out.println("Enter Phone Number...");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		Select_Counrty_and_State(); // Select Country and State from dropdown

		System.out.println("Step :: Enter Address.");
		common.log("<br></br>Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		System.out.println("Step :: Enter City.");
		common.log("<br></br>Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		System.out.println("Step :: Enter Zip.");
		common.log("<br></br>Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		System.out.println("Step :: Click on Same as billing check box.");
		common.log("<br></br>Step :: Click on Same as billing check box.");
		common.checkChkBox(ship);
		common.pause(5);

		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(15);

	}

	/**
	 * Enter Bill Info with Wrong Captcha
	 * 
	 */
	public void enterBillInfoWrongCaptcha() {

		Select_Billing_Info_Phone_Type(); // Select Billing info Phonetype

		common.log("<br></br>Step :: Billing First Name :");
		System.out.println("Step :: Billing First Name :");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		common.log("<br></br>Step :: Billing Last Name :");
		System.out.println("Step :: Billing Last Name :");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		System.out.println("Step :: Enter Phone Number...");
		common.log("<br></br>Step :: Enter Phone Number...");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		Select_Counrty_and_State(); // Select Country and State from dropdown

		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		common.log("<br></br>Step :: Clicking on Shipbox checkbox:");
		System.out.println("Step :: Clicking on Shipbox checkbox:");
		common.checkChkBox(ship);
		common.pause(5);

		common.log("<br></br>Step :: Entering Captcha: \" Wrong Value \"");
		System.out.println("Step :: Entering Captcha: \" Wrong Value \"");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", "PerfectQA Services");

		common.log("<br></br>Step :: Selecting Terms Checkbox :");
		System.out.println("Step :: Selecting Terms Checkbox :");
		common.checkChkBox(terms);

		common.jsClick(signUp);

	}

	/**
	 * Verify Regular SignUp No Captcha Value
	 * 
	 * @throws InterruptedException
	 */
	public void regularSignUpNoCaptcha() throws InterruptedException {

		signupUser(); // SignUp User
		enterBillInfoWithoutCaptcha(); // Regular SignUp With No Captcha

		System.out.println("Step :: Verify Alert Message");
		common.log("<br></br>Step :: Verify Alert Message");
		common.pause(30);

		String captchawarning = driver.findElement(By.xpath("//div[@class='validation-error']")).getText();
		System.out.println("Step :: Verify Warning Message >> " + captchawarning);
		common.log("<br></br>Step :: Verify Warning Message >>" + captchawarning);
		common.assertElementPresent("//div[@class='validation-error']");

	}

	/**
	 * Regular Signup
	 * 
	 * @throws InterruptedException
	 */
	public void regularSignUp(String FirstName, String LastName, String EmailUser, String signUpUser)
			throws InterruptedException {
		common.pause20Sec();
		System.out.println("Step :: SignupUSer Details.");
		common.log("<br></br> Step :: SignupUSer Details.");
		common.jsClick(signUpLink);

		common.pause20Sec();
		System.out.println("Step :: Enter User Name");
		common.log("<br></br> Step :: Enter User Name");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']", signUpUser);

		System.out.println("Step :: Enter Password");
		common.log("<br></br> Step :: Enter Password");
		common.type("//input[@id= '" + LEGACY_USER_SIGNUP_TXT_PASSWORD + "']", LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);
		

		System.out.println("Step :: Enter Confirm Password");
		common.log("<br></br> Step :: Enter Confirm Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_PASSWORD + "']", signUpUser);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_PASSWORD + "']",
				LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);

		System.out.println("Step :: Enter Email");
		common.log("<br></br> Step :: Enter Email");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_EMAIL + "']",EmailUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);

//		System.out.println("Step :: Enter Confirm Email :: " + EmailUser);
//		common.log("<br></br>Step :: Enter Confirm Email :: " + EmailUser);
//		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_EMAIL + "']",EmailUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);

		System.out.println("Step :: Enter First Name.");
		common.log("<br></br> Step :: Enter First Name.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_FIRST_NAME + "']", signUpUser);

		System.out.println("Step :: Enter Last Name.");
		common.log("<br></br> Step :: Enter Last Name.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_LAST_NAME + "']", signUpUser);

		
		common.log("<br></br>Enter Phone Number...");
		System.out.println("Enter Phone Number...");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		Select_User_Info_Phone_Type(); // Select Phone Type

		Select_Identification_Type(); // Select Identification type

		enterBillInfo(signUpUser);

		common.waitForElement(By.xpath("//ul[@id='"+LEGACY_USER_SIGNUP_MESSAGES_VALUE+"']"));
		common.highlightElement("//ul[@id='"+LEGACY_USER_SIGNUP_MESSAGES_VALUE+"']");
		common.assertElementPresent("//ul[@id='"+LEGACY_USER_SIGNUP_MESSAGES_VALUE+"']");
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='"+LEGACY_USER_SIGNUP_MESSAGES_VALUE+"']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

	}
	/**
	 * Verify User Edit Profile
	 * 
	 * @param signUpUser
	 * @param EmailUser
	 * @throws InterruptedException
	 */
	public void verifyUserEditProfile(String signUpUser, String EmailUser) throws InterruptedException

	{

		String IdentificationType = "0"; // Identification Type
		String Identification = "Perfect QA Services";
		String UserRole = "1"; // 1 = "Bidder"
		String Country = "2"; // 1 = Canada
		String State = "1"; // 8 = Alberta
		String PhoneType = "1"; // 1 = work
		String PhoneNumber = "718-343-2012";
		String billingAddress = "466 green st";
		String billingCity = "san francisco";

		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		common.pause(15);
		System.out.println("Step :: Click on profile");
		common.waitForElement(By.xpath("//header//a[text()='Profile']"));
		common.jsClick(selectprofile);
		common.pause(50);
		String editprofileUsername = common.getValue("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']");
		System.out.println("Step :: Edit Profile User name >> " + editprofileUsername);
		common.log("<br></br> Step :: Edit profile username");

		String editprofileFirstname = common.getValue("//*[@id='" + LEGACY_USER_TXT_PROFILE_FIRST_NAME + "']");
		System.out.println("Step :: Edit Profile first name >> " + editprofileFirstname);
		common.log("<br></br> Step :: Edit profile Firstname");

		String editprofileLastname = common.getValue("//*[@id='" + LEGACY_USER_TXT_PROFILE_LAST_NAME + "']");
		System.out.println("Step :: Edit Profile last name >> " + editprofileLastname);
		common.log("<br></br> Step :: Edit profile last name");

		String editprofileEmail = common.getValue("//*[@id='" + LEGACY_USER_TXT_PROFILE_EMAIL + "']");
		System.out.println("Step :: Edit Profile Email Address >> " + editprofileEmail);
		common.log("<br></br> Step :: Edit profile Email Address");

		String editprofilePhone = common.getValue("//*[@id='" + LEGACY_USER_TXT_PROFILE_PHONE + "']");
		System.out.println("Step :: Edit Profile Phone >> " + editprofilePhone);
		common.log("<br></br> Step :: Edit profile phone");

		String editprofilePhonetype = common.getValue("//*[@id='" + LEGACY_USER_TXT_PROFILE_PHONE_TYPE + "']");
		System.out.println("Step :: Edit Profile Phone Type >> " + editprofilePhonetype);
		common.log("<br></br> Step :: Edit profile phone type");

		String editprofileIdentification = common.getValue("//*[@id='" + LEGACY_USER_TXT_PROFILE_IDENTIFICATION + "']");
		System.out.println("Step :: Edit Profile Identification >> " + editprofileIdentification);
		common.log("<br></br> Step :: Edit Profile Identification");

		String editprofileIdentificationtype = common
				.getValue("//*[@id='" + LEGACY_USER_TXT_PROFILE_IDENTIFICATION_TYPE + "']");
		System.out.println("Step :: Edit Profile Identification Type >> " + editprofileIdentificationtype);
		common.log("<br></br> Step :: Edit profile identificationtype");

		// Billing type

		String editbillingContacttype = common.getValue("//*[@id='" + LEGACY_USER_LST_BILLING_CONTACT_TYPE + "']");
		System.out.println("Step :: Edit Billing contact type >> " + editbillingContacttype);
		common.log("<br></br> Step :: Edit profile billing contact type");

		String editbillingFirstname = common.getValue("//*[@id='" + LEGACY_USER_TXT_BILLING_FIRST_NAME + "']");
		System.out.println("Step :: Edit Billing First Name >> " + editbillingFirstname);
		common.log("<br></br> Step :: Edit profile billing first name");

		String editbillingLastname = common.getValue("//*[@id='" + LEGACY_USER_TXT_BILLING_LAST_NAME + "']");
		System.out.println("Step :: Edit Billing Last Name >> " + editbillingLastname);
		common.log("<br></br> Step :: Edit profile billing last name");

		String editbillingPhone = common.getValue("//*[@id='" + LEGACY_USER_TXT_BILLING_PHONE + "']");
		System.out.println("Step :: Edit Billing Phone >> " + editbillingPhone);
		common.log("<br></br> Step :: Edit profile billing phone");

		String editbillingCountry = common.getValue("//*[@id='" + LEGACY_USER_LST_BILLING_COUNTRY + "']");
		System.out.println("Step :: Edit Billing Country >> " + editbillingCountry);
		common.log("<br></br> Step :: Edit profile billing country");

		String editbillingAddress = common.getValue("//input[@id='" + LEGACY_USER_TXT_BILLING_ADDRESS + "']");
		System.out.println("Step :: Edit Billing Address >> " + editbillingAddress);
		common.log("<br></br> Step :: Edit profile billing address");

		String editbillingCity = common.getValue("//*[@id='" + LEGACY_USER_TXT_BILLING_CITY + "']");
		System.out.println("Step :: Edit Billing City >> " + editbillingCity);
		common.log("<br></br> Step :: Edit profile billing city");

		String editbillingState = common.getValue("//select[@id='" + LEGACY_USER_LST_BILLING_STATE + "']");
		System.out.println("Step :: Edit Billing State >> " + editbillingState);
		common.log("<br></br> Step :: Edit profile billing state");

		// Shipping info

		String editshippingInfocontacttype = common
				.getValue("//*[@id='" + LEGACY_USER_LST_SHIPPING_INFO_EDIT_CONTACT_TYPE + "']");
		System.out.println("Step :: Edit shipping info contact type >> " + editshippingInfocontacttype);
		common.log("<br></br> Step :: Edit profile shipping info contact type");

		String editshippingInfofirstname = common
				.getValue("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_FIRST_NAME + "']");
		System.out.println("Step :: Edit shipping info First Name >> " + editshippingInfofirstname);
		common.log("<br></br> Step :: Edit profile shipping info first name");

		String editshippingInfolastname = common
				.getValue("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_LAST_NAME + "']");
		System.out.println("Step :: Edit shipping info Last Name >> " + editshippingInfolastname);
		common.log("<br></br> Step :: Edit profile shipping info last name");

		String editshippingInfophone = common.getValue("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_PHONE + "']");
		System.out.println("Step :: Edit shipping info Phone >> " + editshippingInfophone);
		common.log("<br></br> Step :: Edit profile shipping info phonetype");

		String editshippingInfocountry = common
				.getValue("//*[@id='" + LEGACY_USER_LST_SHIPPING_INFO_EDIT_COUNTRY + "']");
		System.out.println("Step :: Edit shipping info Country >> " + editshippingInfocountry);
		common.log("<br></br> Step :: Edit profile shipping info country");

		String editshippingInfoaddress = common
				.getValue("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_ADDRESS + "']");
		System.out.println("Step :: Edit shipping info Address >> " + editshippingInfoaddress);
		common.log("<br></br> Step :: Edit profile shipping info address");

		String editshippingInfocity = common.getValue("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_CITY + "']");
		System.out.println("Step :: Edit shipping info City >> " + editshippingInfocity);
		common.log("<br></br> Step :: Edit profile shipping info city");

		String editshippingInfostate = common.getValue("//*[@id='" + LEGACY_USER_LST_SHIPPING_INFO_EDIT_STATE + "']");
		System.out.println("Step :: Edit shipping info State >> " + editshippingInfostate);
		common.log("<br></br> Step :: Edit profile shipping info state");

		// Regular Signup

		common.assertTwoValuesAreEqual(editprofileUsername, signUpUser);
		common.assertTwoValuesAreEqual(editprofileFirstname, signUpUser);
		common.assertTwoValuesAreEqual(editprofileLastname, signUpUser);
		common.assertTwoValuesAreEqual(editprofileEmail.substring(0, editprofileEmail.length() - 22), EmailUser);
		common.assertTwoValuesAreEqual(editprofilePhone, PhoneNumber);
		common.assertTwoValuesAreEqual(editprofilePhonetype, PhoneType);
		common.assertTwoValuesAreEqual(editprofileIdentificationtype, IdentificationType);

		// Billing

		// common.assertTwoValuesAreEqual(editbillingContacttype, PhoneType);
		common.assertTwoValuesAreEqual(editbillingFirstname, signUpUser);
		common.assertTwoValuesAreEqual(editbillingLastname, signUpUser);
		common.assertTwoValuesAreEqual(editbillingPhone, PhoneNumber);
		common.assertTwoValuesAreEqual(editbillingCountry, Country);
		common.assertTwoValuesAreEqual(editbillingAddress, billingAddress);
		common.assertTwoValuesAreEqual(editbillingCity, billingCity);
		common.assertTwoValuesAreEqual(editbillingState, State);

		// shipping

		// common.assertTwoValuesAreEqual(editshippingInfocontacttype, PhoneType);
		common.assertTwoValuesAreEqual(editshippingInfofirstname, signUpUser);
		common.assertTwoValuesAreEqual(editshippingInfolastname, signUpUser);
		common.assertTwoValuesAreEqual(editshippingInfophone, PhoneNumber);
		common.assertTwoValuesAreEqual(editshippingInfocountry, Country);
		common.assertTwoValuesAreEqual(editshippingInfoaddress, billingAddress);
		common.assertTwoValuesAreEqual(editshippingInfocity, billingCity);
		common.assertTwoValuesAreEqual(editshippingInfostate, State);

	}

	/**
	 * Verify Regular SignUp Wrong Captcha Value
	 * 
	 * @throws InterruptedException
	 */
	public void regularSignUpWrongCaptcha() throws InterruptedException {

		signupUser(); // SignUp User
		enterBillInfoWrongCaptcha(); // Regular SignUp With Wrong Captcha

		common.pause(20);
		common.waitForElement(By.xpath("//div[@class='validation-error']"));
		String captchawarning = driver.findElement(By.xpath("//div[@class='validation-error']")).getText();
		System.out.println("Step :: Verify Warning Message >> " + captchawarning);
		common.log("<br></br>Step :: Verify Warning Message >>" + captchawarning);
		common.assertElementPresent("//div[@class='validation-error']");

	}

	/**
	 * Verify Regular SignUp Confirmation Is Not Checked
	 * 
	 * @throws InterruptedException
	 */
	public void regularSignUpConfirmationIsNotChecked(String signUpUser) throws InterruptedException {

		signupUser(); // SignUp User
		enterBillingInformationWithConfirmationIsNotChecked(signUpUser); // Confirmation
		// Is Not
		// Checked

		common.pause(25);
		String chkwarning = driver.findElement(By.xpath("//div[@class='validation-error']")).getText();
		System.out.println("Step :: Verify Warning Message >> " + chkwarning);
		common.log("<br></br>Step :: Verify Warning Message >>" + chkwarning);
		common.assertElementPresent("//div[@class='validation-error']");

	}

	/**
	 * Enter Billing Information With Confirmation Is Not Checked
	 * 
	 */
	public void enterBillingInformationWithConfirmationIsNotChecked(String signUpUser) {

		Select_Billing_Info_Phone_Type(); // Select Phone Type

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", signUpUser);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", signUpUser);

		System.out.println("Step :: Enter Phone Number.");
		common.log("<br></br>Step :: Enter Phone Number.");

		System.out.println("Enter Phone Number...");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		Select_Counrty_and_State(); // Select Country and State from dropdown

		System.out.println("Step :: Enter Address.");
		common.log("<br></br>Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		System.out.println("Step :: Enter City.");
		common.log("<br></br>Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		System.out.println("Step :: Enter Zip.");
		common.log("<br></br>Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		System.out.println("Step :: Click on Same as billing check box.");
		common.log("<br></br>Step :: Click on Same as billing check box.");
		common.checkChkBox(ship);
		common.pause(5);

		System.out.println("Step :: Entering Captcha.");
		common.log("<br></br>Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		System.out.println("Step :: Without Selecting Terms Checkbox(Confirmaion).");
		common.log("<br></br>Step :: Without Selecting Terms Checkbox(Confirmaion).");
		common.pause(10);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);

	}

	/**
	 * Verify NewUser Logged Properly
	 * 
	 * @param signUpUser
	 * 
	 * @throws InterruptedException
	 */
	public void verifyNewUserLoggedProperly(String signUpUser) throws InterruptedException {

		System.out.println("Step :: Verify New users logged in properly.");
		common.log("<br></br> Step :: Verify New users logged in properly.");
		common.pause(50);

		System.out.println("Click on login link.");
		common.log("<br></br> Step :: Click on Login link.");
		common.jsClick(logout);

		common.pause(15);

		System.out.println("Username ::" + signUpUser);
		common.pause(30);
		common.type("//input[@id='" + LEGACY_FRONT_LOGIN_TXT_USERNAME + "']", signUpUser);

		String password = "rahul123";
		System.out.println("Password ::" + password);
		common.pause(5);
		common.log("<br></br>Password ::" + password);

		common.type("//input[@id='" + LEGACY_FRONT_LOGIN_TXT_PASSWORD + "']", password);

		System.out.println("Step :: Click on submit button.");
		common.log("<br></br>Step :: Click on submit button");
		common.jsClick(submitbutton);
		common.pause(25);

		// common.waitForElement("//p[@class='welcome-text']");
		// String Loggedinuser =
		// driver.findElement(By.xpath("//p[@class='welcome-text']")).getText();
		common.log("<br></br Logged User >>" + signUpUser);
		System.out.println("Logged User >> " + signUpUser);

	}

	/**
	 * Regular Signup with Existing User
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignupWithExistingUser() throws InterruptedException {

		System.out.println("Step :: Verify New users logged in properly.");
		common.log("<br></br>Step :: Verify New users logged in properly.");
		String FistName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);

		common.pause(20);

		common.jsClick(signUpLink);
		System.out.println("Step :: SignupUSer Details.");
		common.log("<br></br> Step :: SignupUSer Details.");
		common.pause(80);

		String signUpUser = "rahulqa";
		System.out.println("Step ::Random Value :" + signUpUser);
		common.log("<br></br> Step ::Random Value :" + signUpUser);

		System.out.println("Step :: Enter First Name");
		common.log("<br></br> Step :: Enter First Name");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_FIRST_NAME + "']", "rahulqa");

		System.out.println("Step :: Enter Last Name");
		common.log("<br></br> Step :: Enter Last Name");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_LAST_NAME + "']", "rahulqa");

		System.out.println("New User >>" + "  " + signUpUser);
		common.log("<br></br> New User >>" + "  " + signUpUser);

		System.out.println("Step :: Enter User Name");
		common.log("<br></br> Step :: Enter User Name");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']", LEGACY_USER_SIGNUP_TXT_USERNAME_VALUE);

		System.out.println("Step :: Enter Password");
		common.log("<br></br> Step :: Enter Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PASSWORD + "']", LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);

		System.out.println("Step :: Enter Confirm Password");
		common.log("<br></br> Step :: Enter Confirm Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_PASSWORD + "']",
				LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);

		System.out.println("Step :: Enter Email Id");
		common.log("<br></br> Step :: Enter Email Id");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_EMAIL + "']",
				EmailUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);

		System.out.println("Step ::Enter Phone Number...");
		common.log("<br></br>Step ::Enter Phone Number...");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		System.out.println("Step :: Identification Type.");
		common.log("<br></br>Step :: Identification Type.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_IDENTIFICATION + "']",
				LEGACY_USER_SIGNUP_TXT_IDENTIFICATION_VALUE);

		Select_User_Info_Phone_Type(); // Select Phone Type

		Select_Identification_Type(); // Select Identification type

		enterBillInfo(signUpUser); // Enter Bill Info
		common.pause(30);

		String Alertmsg = driver.findElement(By.xpath("//span[contains(text(),'Username *: Username already exists')]"))
				.getText();

		System.out.println("Step :: Verify Alert Message >> " + Alertmsg);
		common.log("<br></br>Step :: Verify Alert Message >> " + Alertmsg);

		common.assertElementPresent("//span[contains(text(),'Username *: Username already exists')]");

	}

	/**
	 * Regular Signup with Existing Email User
	 * 
	 * @throws InterruptedException
	 * 
	 */

	public void regularSignupWithExistingEmailUser() throws InterruptedException {

		String FistName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);

		common.pause(25);
		System.out.println("Step :: Admin logout front");
		common.log("<br></br> Step :: Admin logout front");

		common.pause(15);
		common.jsClick(signUpLink);

		System.out.println("Step :: SignupUSer Details.");
		common.log("<br></br> Step :: SignupUSer Details.");
		common.waitForElement(By.xpath(
				"\"//input[@id='\" + LEGACY_USER_SIGNUP_TXT_PASSWORD + \"']\", LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE"));
		// common.pause(80);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PASSWORD + "']", LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);
		System.out.println("Step :: Random Value :" + signUpUser);
		common.log("<br></br>Step ::  Random Value :" + signUpUser);

		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_FIRST_NAME + "']", signUpUser);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_LAST_NAME + "']", signUpUser);

		System.out.println("New User >>" + "  " + signUpUser);
		common.log("<br></br>New User >>" + "  " + signUpUser);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']", signUpUser);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_PASSWORD + "']",
				LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_EMAIL + "']",
				"rahul" + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);
		// Enter
		// Existing
		// Email
		// User

		System.out.println("Enter Phone Number...");
		common.log("<br></br>Enter Phone Number...");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		Select_User_Info_Phone_Type(); // Select Phone Type

		Select_Identification_Type(); // Select Identification type

		enterBillInfo(signUpUser); // Enter Bill Info

		common.pause(25);

		common.waitForElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][1][1]"));
		String EmailErrorText = this.driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][1][1]")).getText();
		common.log("<br></br> Step :: Alert Message for Already Exist Email >> " + EmailErrorText);
		System.out.println("Step :: Alert Message for Already Exist Email :: " + EmailErrorText);

		common.assertElementPresent("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][1]");
		common.pause(5);
	}

	/**
	 * Regular SignUp With Basic Information Mandatory
	 * 
	 * @throws InterruptedException
	 */
	public void regularSignUpWithBasicInfoMandatory() throws InterruptedException {

		signupUser(); // SignUp User

		System.out.println("Step :: Entering Captcha.");
		common.log("<br></br>Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(20);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(20);

		String validationmsg = driver.findElement(By.xpath("//div[@class='validation-error']")).getText();
		System.out.println("Step :: Validation Message for First Name and Last Name Fields >> " + validationmsg);

		Select_Billing_Info_Phone_Type(); // Select Billing Info Phone Type

		System.out.println("Step :: Verfiy that Billing Firstname field is present");
		common.log("Step :: Verfiy that Billing Firstname field is present");
		common.assertElementPresent("//input[@id='rbp3']");

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(6);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(6);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		// common.wait(PASSED);
		common.pause(5);

		System.out.println("Step :: Entering Phone Number.");
		common.log("<br></br>Step :: Entering Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		// Select_Counrty_and_State(); // Select Country and State from dropdown

//		System.out.println("Step :: Enter Address.");
//		common.log("<br></br>Step :: Enter Address.");
//		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
//				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);
//
//		System.out.println("Step :: Verify City field is present");
//		common.log("Step :: Verify City field is present");
//		common.assertElementPresent("//input[@id='rbp10']");
//
//		System.out.println("Step :: City.");
//		common.log("<br></br>Step :: Enter City.");
//		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);
//
//		System.out.println("Step :: Verify Zip field is present");
//		common.log("Step:: Verify Zip field is present ");
//		common.assertElementPresent("//input[@id='rbp12']");
//
//		System.out.println("Step :: Enter Zip.");
//		common.log("<br></br>Step :: Enter Zip.");
//		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
//				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);
//		common.pause(15);
//		System.out.println("Step :: Veify Same as billing check box is present");
//		common.log("Step :: Verfiy Same as billing checkbox is present");
//		common.assertElementPresent("//input[@id='sip1']");
//
//		System.out.println("Step :: Click on Same as billing check box.");
//		common.log("<br></br>Step :: Click on Same as billing check box.");
//		common.checkChkBox(ship);
//		common.pause(10);
//		common.pause(5);

		System.out.println("Step :: Entering Captcha.");
		common.log("<br></br>Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(30);

		common.waitForElement(By.xpath("//ul[@id='messages']"));
		String SuccessMessage = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Step :: Verify Success Message >> " + SuccessMessage);
		common.log("<br></br>Step :: Verify Success Message >> " + SuccessMessage);

		common.assertElementPresent("//ul[@id='messages']");
		common.pause(5);
	}

	/**
	 * Regular SignUp With Billing Information Mandatory
	 * 
	 * @throws InterruptedException
	 */
	public void regularSignUpWithBillingInfoMandatory() throws InterruptedException {

		signupUser(); // SignUp User

		System.out.println("Step :: Entering Captcha.");
		common.log("<br></br>Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);
		common.pause(10);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(50);

//		String getFirstNameWarningMessage = driver
//				.findElement(By.xpath("//div//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][1]"))
//				.getText();
//		String getLastNameWarningMessage = driver
//				.findElement(By.xpath("//div//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][2]"))
//				.getText();
//		String getPhoneWarningMessage = driver
//				.findElement(By.xpath("//div//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][3]"))
//				.getText();

		String getAddressWarningMessage = driver
				.findElement(By.xpath("//div//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][1]"))
				.getText();
		String getCityWarningMessage = driver
				.findElement(By.xpath("//div//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][2]"))
				.getText();
		String getCountryWarningMessage = driver
				.findElement(By.xpath("//div//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][3]"))
				.getText();
		String getStateWarningMessage = driver
				.findElement(By.xpath("//div//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][4]"))
				.getText();

		String getZipWarningMessage = driver
				.findElement(By.xpath("//div//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][5]"))
				.getText();

//		System.out.println("Step :: Warning Message >> " + getFirstNameWarningMessage);
//		System.out.println("Step :: Warning Message >> " + getLastNameWarningMessage);
//		System.out.println("Step :: Warning Message >> " + getPhoneWarningMessage);

		System.out.println("Step :: Warning Message >> " + getAddressWarningMessage);
		System.out.println("Step :: Warning Message >> " + getCityWarningMessage);
		System.out.println("Step :: Warning Message >> " + getCountryWarningMessage);
		System.out.println("Step :: Warning Message >> " + getStateWarningMessage);
		System.out.println("Step :: Warning Message >> " + getZipWarningMessage);

		System.out.println("Step :: Verify Text Messages with Assertion");
		// common.waitForElement(By.xpath("//div//span[@class='sub-titles'][1]"));
		common.assertTwoValuesAreEqual(getCountryWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_COUNTRY_ALERT_MESSAGE);
		// common.assertTwoValuesAreEqual(getAddressWarningMessage,
		// LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCityWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CITY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getZipWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ZIP_ALERT_MESSAGE);
		common.pause(10);

		System.out.println("Step :: Verfiy that Billing Firstname field is present");
		common.log("Step :: Verfiy that Billing Firstname field is present");
		// common.assertElementPresent("//input[@id='rbp3']");
		common.pause(80);
//		System.out.println("Step :: Billing First Name.");
//		common.log("<br></br>Step :: Billing First Name.");
//		String contactFirst = common.generateRandomChars(6);
//		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);
//
//		System.out.println("Step :: Billing Last Name.");
//		common.log("<br></br>Step :: Billing Last Name.");
//		String contactLast = common.generateRandomChars(6);
//		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		// common.wait(PASSED);
		common.pause(5);

//		System.out.println("Step :: Entering Phone Number.");
//		common.log("<br></br>Step :: Entering Phone Number.");
//		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		Select_Counrty_and_State(); // Select Country and State from dropdown

		System.out.println("Step :: Enter Address.");
		common.log("<br></br>Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		System.out.println("Step :: Verify City field is present");
		common.log("Step :: Verify City field is present");
		common.assertElementPresent("//input[@id='rbp10']");

		System.out.println("Step :: City.");
		common.log("<br></br>Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		System.out.println("Step :: Verify Zip field is present");
		common.log("Step:: Verify Zip field is present ");
		common.assertElementPresent("//input[@id='rbp12']");

		System.out.println("Step :: Enter Zip.");
		common.log("<br></br>Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		System.out.println("Step :: Veify Same as billing check box is present");
		common.log("Step :: Verfiy Same as billing checkbox is present");
		// common.assertElementPresent("//input[@id='sip1']");

		System.out.println("Step :: Click on Same as billing check box.");
		common.log("<br></br>Step :: Click on Same as billing check box.");
		// common.checkChkBox(ship);
		common.pause(10);

		System.out.println("Step :: Entering Captcha.");
		common.log("<br></br>Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);
		common.pause(10);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(40);

		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);
		common.pause(10);
	}

	/**
	 * Regular SignUp With CC Information Mandatory
	 * 
	 * @throws InterruptedException
	 */
	public void regularSignUpWithCCInfoMandatory() throws InterruptedException {

		signupUser(); // SignUp User

		System.out.println("Step :: Entering Captcha.");
		common.log("<br></br>Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);
		common.pause(10);
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(100);
		String getSecurityCodeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getSecurityCodeWarningMessage);

		String getExpirationDateWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][4]")).getText();
		System.out.println("Step :: Warning Message >> " + getExpirationDateWarningMessage);

		String getCCNumberWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][3]")).getText();
		System.out.println("Step :: Warning Message >> " + getCCNumberWarningMessage);

		String getCCTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][4]")).getText();

		System.out.println("Step :: Warning Message >>" + getCCTypeWarningMessage);

		common.assertTwoValuesAreEqual(getCCTypeWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCCNumberWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_NUMBER_ALERT_MESSAGE);
		// common.assertTwoValuesAreEqual(getExpirationMonthWarningMessage,
		// LEGACY_USER_SIGNUP_BILL_TXT_CC_MONTH_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getSecurityCodeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_SECURITY_CODE_ALERT_MESSAGE);

		Enter_CC_Details(); // Enter CC Details

		System.out.println("Step :: Entering Captcha.");
		common.log("<br></br>Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);
		common.pause(10);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(50);
		common.waitForElement(By.xpath("//ul[@id='messages']"));
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

	}

	/**
	 * Regular SignUp With CC Information Mandatory
	 * 
	 * @throws InterruptedException
	 */
	public void regularSignUpWithACHInfoMandatory() throws InterruptedException {

		signupUser(); // SignUp User

		System.out.println("Step :: Entering Captcha.");
		common.log("<br></br>Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(40);

		String getBankRoutingTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][5]")).getText();
		System.out.println("Step :: Bank Routing Warning Message >> " + getBankRoutingTypeWarningMessage);

		String getBankAccountWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][2]")).getText();
		System.out.println("Step :: Bank Account Warning Message >> " + getBankAccountWarningMessage);

		String getBankAccountTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][3]")).getText();
		System.out.println("Step :: Bank Account Type Warning Message >> " + getBankAccountTypeWarningMessage);

		String getBankNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][4]")).getText();
		System.out.println("Step :: Bank Name Warning Message >> " + getBankNameWarningMessage);

		String getBankAccountNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getBankAccountNameWarningMessage);

		common.assertTwoValuesAreEqual(getBankRoutingTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ROUTING_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankNameWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_BANK_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountNameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_NAME_ALERT_MESSAGE);

		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_BANK_ROUTING + "']", "123456789");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_BANK_ACCOUNT + "']", "1234554321");

		Select_Bank_Account_Type();// Select Bank Account Type

		System.out.println("Step :: Entering Captcha.");
		common.log("<br></br>Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(30);

		common.waitForConditionIsElementPresent("//ul[@id='messages']");
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

	}

	/**
	 * Regular SignUp With Basic Info Mandatory And Billing Address Info Not
	 * Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBasicInfoMandatoryAndBillingAddressInfoNotMandatory() throws InterruptedException {

		signupUser(); // SignUp User

		Select_Billing_Info_Phone_Type(); // Select Phone Type

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		System.out.println("Step :: Entering Phone Number.");
		common.log("<br></br>Step :: Entering Phone Number.");
		System.out.println("Enter Phone Number...");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		System.out.println("Step :: Entering Captcha.");
		common.log("<br></br>Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(25);

		common.waitForElement(By.xpath("//ul[@id='messages']"));
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

		System.out.println("Step :: signup successful\n");

	}

	/**
	 * Regular SignUp With Basic Info Not Mandatory And Billing Address Info
	 * Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void verifyCheckedCheckboxBasicInfoNotMandatoryAndBillingAddressInfoMandatory() throws InterruptedException {

		signupUser(); // SignUp User

		Enter_CC_Details(); // Enter CC Details

		common.log("<br></br>Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(15);

		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

	}

	/**
	 * Regular SignUp With Basic Info Not Mandatory And Billing Address Info
	 * Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBasicInfoNotMandatoryAndBillingAddressInfoMandatory() throws InterruptedException {

		signupUser(); // SignUp User

		System.out.println("Step :: Entering Captcha.");
		common.log("<br></br>Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);
		common.pause(10);
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		System.out.println("<br></br>Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(40);
		common.waitForElement("//span[@id='" + LEGACY_USER_SIGNUP_BILL_LST_COUNTRY + "']");

		String getAddressWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getAddressWarningMessage);

		String getCityWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][2]")).getText();
		System.out.println("Step :: Warning Message >> " + getCityWarningMessage);
		String getCountryWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][3]")).getText();
		System.out.println("Step :: Warning Message >> " + getCountryWarningMessage);

		String getStateWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][4]")).getText();
		System.out.println("Step :: Warning Message >> " + getStateWarningMessage);

		String getZipWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][5]")).getText();
		System.out.println("Step :: Warning Message >> " + getZipWarningMessage);

		common.assertTwoValuesAreEqual(getCountryWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_COUNTRY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getAddressWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCityWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CITY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getStateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_STATE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getZipWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ZIP_ALERT_MESSAGE);

		Select_Counrty_and_State(); // Select Country and State from dropdown

		System.out.println("Step :: Address.");
		common.log("<br></br>Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		System.out.println("Step :: City.");
		common.log("<br></br>Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		System.out.println("Step :: Entering Captcha.");
		common.log("<br></br>Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		System.out.println("Step :: Zip.");
		common.log("<br></br>Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(40);

		String SuccessMessage = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Step :: Verify Success Message >> " + SuccessMessage);
		common.log("<br></br>Step :: Verify Success Message >> " + SuccessMessage);

	}

	/**
	 * Regular SignUp With Basic Info Not Mandatory And Billing Address Info
	 * Mandatory
	 * 
	 * @throws InterruptedException
	 */
	public void regularSignUpWithBasicInfoMandatoryAndBillingAddressInfoMandatory() throws InterruptedException {

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);
		common.pause(10);
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(25);

		String getAddressWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getAddressWarningMessage);

		String getCityWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][2]")).getText();
		System.out.println("Step :: Warning Message >> " + getCityWarningMessage);

		String getcontactMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][3]")).getText();
		System.out.println("Step :: Warning Message >> " + getcontactMessage);

		String getCountryWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][4]")).getText();
		System.out.println("Step :: Warning Message >> " + getCountryWarningMessage);

		String getFirstMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][5]")).getText();
		System.out.println("Step :: Warning Message >> " + getFirstMessage);

		common.assertTwoValuesAreEqual(getCountryWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_COUNTRY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getAddressWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCityWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CITY_ALERT_MESSAGE);
//		common.assertTwoValuesAreEqual(getStateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_STATE_ALERT_MESSAGE);
//		common.assertTwoValuesAreEqual(getZipWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ZIP_ALERT_MESSAGE);

		Select_Billing_Info_Phone_Type(); // Select Phone Type

		Select_Counrty_and_State(); // Select Country and State from dropdown

		common.log("<br></br>Step :: Billing First Name.");
		System.out.println("Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		common.log("<br></br>Step :: Billing Last Name.");
		System.out.println("Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		common.log("<br></br>Step :: Billing Phone Number.");
		System.out.println("Step :: Billing Phone Number.");
		System.out.println("Enter Phone Number...");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		System.out.println("Step :: Address.");
		common.log("<br></br>Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		System.out.println("Step :: City.");
		common.log("<br></br>Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		System.out.println("Step :: Zip.");
		common.log("<br></br>Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		System.out.println("Step :: Entering Captcha.");
		common.log("<br></br>Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(30);

		String SuccessMessage = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Step :: Verify Success Message >> " + SuccessMessage);
		common.log("<br></br>Step :: Verify Success Message >> " + SuccessMessage);

		common.log("<br></br>Step :: signup successful<br>");
	}

	/**
	 * Regular SignUp With Basic Info Not Mandatory And Billing Address Info
	 * Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBasicInfoMandatoryAndCCInfoNotMandatory() throws InterruptedException {

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(30);

		common.waitForConditionIsElementPresent("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']");

		common.log("<br></br> Steps :: Verify Basic Info Mandatory Fields");
		System.out.println("Steps :: Verify Basic Info Mandatory Fields");

		Select_Billing_Info_Phone_Type(); // Select Billing info Phone Type

		System.out.println("<br></br>Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		System.out.println("<br></br>Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		common.log("<br></br>Step :: Billing Phone Number.");
		System.out.println("Step :: Billing Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		System.out.println("<br></br>Step :: Entering Captcha.");
		common.log("<br></br>Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		System.out.println("<br></br>Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(30);
		common.waitForElement(By.xpath("//ul[@id='messages']"));
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

		System.out.println("Step :: signup successful\n");
		common.pause(10);
	}

	/**
	 * Regular SignUp With Basic Info Not Mandatory And CC Info Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBasicInfoNotMandatoryAndCCInfoMandatory() throws InterruptedException {

		signupUser(); // SignUp User

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		System.out.println("Step :: Entering Captcha.");
		common.log("<br></br>Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(40);
		common.waitForElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][4]"));

		String getSecurityCodeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getSecurityCodeWarningMessage);

		String getExpirationDateWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][2]")).getText();
		System.out.println("Step :: Warning Message >> " + getExpirationDateWarningMessage);

		String getCCNumberWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][3]")).getText();
		System.out.println("Step :: Warning Message >> " + getCCNumberWarningMessage);

		String getCCTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][4]")).getText();

		System.out.println("Step :: Warning Message >>" + getCCTypeWarningMessage);

		common.assertTwoValuesAreEqual(getCCTypeWarningMessage, "CC type: Required");
		common.assertTwoValuesAreEqual(getCCNumberWarningMessage, "CC number *: Required");
		// common.assertTwoValuesAreEqual(getExpirationMonthWarningMessage, "CC Month:
		// Required");
		common.assertTwoValuesAreEqual(getExpirationDateWarningMessage, "Billing CC Expiry Date: Required");
		common.assertTwoValuesAreEqual(getSecurityCodeWarningMessage, "Security code *: Required");

//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("window.scrollBy(0,650)", "");
		Enter_CC_Details(); // Enter CC Details
		common.pause(10);

		System.out.println("Step :: Entering Captcha.");
		common.log("<br></br>Step :: Entering Captcha.");

		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(40);
		common.waitForElement(By.xpath("//ul[@id='messages']"));

		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

	}

	/**
	 * Regular SignUp With Basic Info Mandatory And CC Info Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBasicInfoMandatoryAndCCInfoMandatory() throws InterruptedException {

		// common.waitForConditionIsElementPresent("//div[@id='" +
		// LEGACY_USER_SIGNUP_REGISTRATION_PANEL + "']");

		signupUser(); // SignUp User

		System.out.println("Step :: Entering Captcha.");
		common.log("<br></br>Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(30);
		common.waitForConditionIsElementPresent("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']");

		System.out.println("Steps : Verify Basic Info Mandatory Fields");
		common.log("<br></br> Steps :: Verify Basic Info Mandatory Fields");

		common.log("<br></br>Steps :: Verify CC Info Mandatory Fields");
		System.out.println("Steps :: Verify CC Info Mandatory Fields");
//		String getFirstnameWarningMessage = driver
//				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][5]")).getText();
//		System.out.println("Step :: Warning Message >> " + getFirstnameWarningMessage);
//
//		String getLastnameWarningMessage = driver
//				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][6]")).getText();
//		System.out.println("Step :: Warning Message >> " + getLastnameWarningMessage);

		common.waitForElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][4]"));

		String getSecurityCodeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getSecurityCodeWarningMessage);

		String getExpirationDateWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][2]")).getText();
		System.out.println("Step :: Warning Message >> " + getExpirationDateWarningMessage);

		String getCCNumberWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][3]")).getText();
		System.out.println("Step :: Warning Message >> " + getCCNumberWarningMessage);

		String getCCTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][4]")).getText();

		System.out.println("Step :: Warning Message >>" + getCCTypeWarningMessage);

		common.assertTwoValuesAreEqual(getCCTypeWarningMessage, "CC type: Required");
		common.assertTwoValuesAreEqual(getCCNumberWarningMessage, "CC number *: Required");
		// common.assertTwoValuesAreEqual(getExpirationMonthWarningMessage, "CC Month:
		// Required");
		common.assertTwoValuesAreEqual(getExpirationDateWarningMessage, "Billing CC Expiry Date: Required");
		common.assertTwoValuesAreEqual(getSecurityCodeWarningMessage, "Security code *: Required");
		Select_Billing_Info_Phone_Type(); // Select Phone Type

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		common.log("<br></br>Step :: Billing Phone Number.");
		System.out.println("Step :: Billing Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		Enter_CC_Details(); // Enter CC Details

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");

		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(30);
		common.waitForElement(By.xpath("//ul[@id='messages']"));

		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

	}

	/**
	 * Regular SignUp With Basic Info Mandatory And ACH Info Not Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBasicInfoMandatoryAndACHInfoNotMandatory() throws InterruptedException {

		signupUser(); // SignUp User

		System.out.println("Step :: Entering Captcha.");
		common.log("<br></br>Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(30);
		common.waitForConditionIsElementPresent("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']");

		System.out.println("Steps : Verify Basic Info Mandatory Fields");
		common.log("<br></br> Steps :: Verify Basic Info Mandatory Fields");

		String getContactMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getContactMessage);
		String getFirstnameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][2]")).getText();
		System.out.println("Step :: Warning Message >> " + getFirstnameWarningMessage);

		common.assertTwoValuesAreEqual(getFirstnameWarningMessage, "First name: Required");
		common.assertTwoValuesAreEqual(getContactMessage, LEGACY_USER_SIGNUP_BILL_TXT_CONTACT_TYPE_ALERT_MESSAGE);

		Select_Billing_Info_Phone_Type(); // Select Phone Type

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		common.log("<br></br>Step :: Billing Phone Number.");
		System.out.println("Step :: Billing Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(30);

		common.waitForElement(By.xpath("//ul[@id='messages']"));
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

	}

	/**
	 * Regular SignUp With Basic Info Not Mandatory And ACH Info Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBasicInfoNotMandatoryAndACHInfoMandatory() throws InterruptedException {

		signupUser(); // SignUp User

		System.out.println("Step :: Entering Captcha.");
		common.log("<br></br>Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		System.out.println("Step :: Selecting Terms Checkbox(Confirmation).");
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmation).");
		common.checkChkBox(terms);

		common.pause(100);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);

		// String getFirstnameWarningMessage =
		// driver.findElement(By.xpath("//span[@class='sub-titles
		// 0']")).getText();
		// System.out.println("Step :: Warning Message >> " +
		// getFirstnameWarningMessage);
		//
		// String getLastnameWarningMessage =
		// driver.findElement(By.xpath("//span[@class='sub-titles
		// 1']")).getText();
		// System.out.println("Step :: Warning Message >> " +
		// getLastnameWarningMessage);
		common.pause(30);

		String getBankAccountNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getBankAccountNameWarningMessage);

		String getBankAccountWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][2]")).getText();
		System.out.println("Step :: Bank Account Warning Message >> " + getBankAccountWarningMessage);

		String getBankAccountTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][3]")).getText();
		System.out.println("Step :: Bank Account Type Warning Message >> " + getBankAccountTypeWarningMessage);

		String getBankNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][4]")).getText();
		System.out.println("Step :: Bank Name Warning Message >> " + getBankNameWarningMessage);

		String getBankRoutingTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][5]")).getText();
		System.out.println("Step :: Bank Routing Warning Message >> " + getBankRoutingTypeWarningMessage);

		// common.assertTwoValuesAreEqual(getFirstnameWarningMessage,
		// LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME_ALERT_MESSAGE);
		// common.assertTwoValuesAreEqual(getLastnameWarningMessage,
		// LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankRoutingTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ROUTING_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankNameWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_BANK_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountNameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_NAME_ALERT_MESSAGE);

		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_BANK_ROUTING + "']", "123456789");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_BANK_ACCOUNT + "']", "1234554321");

		Select_Billing_Info_Phone_Type(); // Select Phone Type

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		common.log("<br></br>Step :: Billing Phone Number.");
		System.out.println("Step :: Billing Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_BANK_ROUTING + "']", "123456789");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_BANK_ACCOUNT + "']", "1234554321");

		Select_Bank_Account_Type();// Select Bank Account Type

		System.out.println("Step :: Entering Captcha.");
		common.log("<br></br>Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(30);
		common.waitForElement(By.xpath("//ul[@id='messages']"));
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

	}

	/**
	 * Regular SignUp With Basic Info Not Mandatory And ACH Info Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBasicInfoMandatoryAndACHInfoMandatory() throws InterruptedException {

		signupUser(); // SignUp User

		System.out.println("Step :: Entering Captcha.");
		common.log("<br></br>Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		System.out.println("Step :: Selecting Terms Checkbox(Confirmation).");
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmation).");
		common.checkChkBox(terms);

		common.pause(10);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(30);

		String getBankAccountNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_7 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getBankAccountNameWarningMessage);

		String getBankAccountWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][2]")).getText();
		System.out.println("Step :: Bank Account Warning Message >> " + getBankAccountWarningMessage);

		String getBankAccountTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_5 + "'][3]")).getText();
		System.out.println("Step :: Bank Account Type Warning Message >> " + getBankAccountTypeWarningMessage);

		String getBankNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_6 + "'][4]")).getText();
		System.out.println("Step :: Bank Name Warning Message >> " + getBankNameWarningMessage);

		String getBankRoutingTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][5]")).getText();
		System.out.println("Step :: Bank Routing Warning Message >> " + getBankRoutingTypeWarningMessage);

		String phoneNumberWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][6]")).getText();
		System.out.println("Step :: Phone NUmber Warning Message >> " + phoneNumberWarningMessage);

		String firstNameeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][7]")).getText();
		System.out.println("Step :: First Name Warning Message >> " + firstNameeWarningMessage);

		String lastNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][8]")).getText();
		System.out.println("Step :: Last Name Warning Message >> " + lastNameWarningMessage);

		common.assertTwoValuesAreEqual(firstNameeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME_UPDATED_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(lastNameWarningMessage, LEGACY_USER_SIGNUP_Ship_TXT_LAST_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankRoutingTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ROUTING_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankNameWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_BANK_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountNameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_NAME_ALERT_MESSAGE);

		common.pause(20);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_BANK_ROUTING + "']", "123456789");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_BANK_ACCOUNT + "']", "1234554321");

		Select_Billing_Info_Phone_Type(); // Select Phone Type

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		common.log("<br></br>Step :: Billing Phone Number.");
		System.out.println("Step :: Billing Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_BANK_ROUTING + "']", "123456789");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_BANK_ACCOUNT + "']", "1234554321");

		Select_Bank_Account_Type();// Select Bank Account Type

		System.out.println("Step :: Entering Captcha.");
		common.log("<br></br>Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(30);
		common.waitForElement(By.xpath("//ul[@id='messages']"));

		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);
		common.pause(10);
	}

	/**
	 * Regular SignUp With Billing info Mandatory And CC Info Not Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBillingInfoMandatoryAndCCInfoNotMandatory() throws InterruptedException {

		// common.waitForConditionIsElementPresent("//div[@id='" +
		// LEGACY_USER_SIGNUP_REGISTRATION_PANEL + "']");

		signupUser(); // SignUp User

		System.out.println(" Entering Captcha.");
		common.log("<br></br>Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		System.out.println("Selecting Terms Checkbox(Confirmaion).");
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		System.out.println("Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(20);

		common.waitForElement("//span[@id='" + LEGACY_USER_SIGNUP_BILL_LST_COUNTRY + "']");

		String getAddressWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getAddressWarningMessage);

		String getCityWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][2]")).getText();
		System.out.println("Step :: Warning Message >> " + getCityWarningMessage);

		String getCountryWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][3]")).getText();
		System.out.println("Step :: Warning Message >> " + getCountryWarningMessage);

		String getStateWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][4]")).getText();
		System.out.println("Step :: Warning Message >> " + getStateWarningMessage);

		String getZipWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][5]")).getText();
		System.out.println("Step :: Warning Message >> " + getZipWarningMessage);

		common.assertTwoValuesAreEqual(getCountryWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_COUNTRY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getAddressWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCityWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CITY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getStateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_STATE_ALERT_MESSAGE);

		Select_Counrty_and_State(); // Select Country and State from dropdown

		common.pause(5);
		common.log("<br></br>Step :: Enter Address.");
		System.out.println("Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		common.log("<br></br>Step :: Enter City.");
		System.out.println("Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		common.log("<br></br>Step :: Enter Zip.");
		System.out.println("Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(30);
		common.waitForElement(By.xpath("//ul[@id='messages']"));
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);
		common.pause(10);
	}

	/**
	 * Regular SignUp With Billing info Mandatory And CC Info Not Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBillingInfoNotMandatoryAndCCInfoMandatory() throws InterruptedException {

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(50);

		String getAddressWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getAddressWarningMessage);

		String getSecurityCodeWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][2]")).getText();
		System.out.println("Step :: Warning Message >> " + getSecurityCodeWarningMessage);

		String getExpirationDateWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][3]"))
				.getText();
		System.out.println("Step :: Warning Message >> " + getExpirationDateWarningMessage);

		String getCCNumberWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][4]")).getText();
		System.out.println("Step :: Warning Message >> " + getCCNumberWarningMessage);

		String getCCTypeWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][5]")).getText();

		System.out.println("Step :: Warning Message >>" + getCCTypeWarningMessage);

		String getCityWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][6]")).getText();
		System.out.println("Step :: Warning Message >> " + getCityWarningMessage);

		String getCountryWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][7]")).getText();
		System.out.println("Step :: Warning Message >> " + getCountryWarningMessage);

		String getStateWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][8]")).getText();
		System.out.println("Step :: Warning Message >> " + getStateWarningMessage);

		String getZipWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][9]")).getText();
		System.out.println("Step :: Warning Message >> " + getZipWarningMessage);

		common.assertTwoValuesAreEqual(getCountryWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_COUNTRY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getAddressWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCityWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CITY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getStateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_STATE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getZipWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ZIP_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCCTypeWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCCNumberWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_NUMBER_ALERT_MESSAGE);

		common.assertTwoValuesAreEqual(getExpirationDateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_EXPIRY_DATE);
		common.assertTwoValuesAreEqual(getSecurityCodeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_SECURITY_CODE_ALERT_MESSAGE);

		Select_Counrty_and_State(); // Select Country and State from dropdown

		common.log("<br></br>Step :: Enter Address.");
		System.out.println("Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		common.log("<br></br>Step :: Enter City.");
		System.out.println("Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		common.log("<br></br>Step :: Enter Zip.");
		System.out.println("Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		Enter_CC_Details(); // Enter CC Details

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(30);
		common.waitForElement(By.xpath("//ul[@id='messages']"));
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);
		common.pause(10);
	}

	/**
	 * Regular SignUp With Billing info Mandatory And ACH Info Not Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBillingInfoMandatoryAndACHInfoNotMandatory() throws InterruptedException {

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step ::  Click on signUp button.");
		common.jsClick(signUp);

		common.pause(50);

		String getAddressWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getAddressWarningMessage);

		String getCityWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][2]")).getText();
		System.out.println("Step :: Warning Message >> " + getCityWarningMessage);

		String getCountryWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][3]")).getText();
		System.out.println("Step :: Warning Message >> " + getCountryWarningMessage);

		String getStateWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][4]")).getText();
		System.out.println("Step :: Warning Message >> " + getStateWarningMessage);

		String getZipWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][5]")).getText();
		System.out.println("Step :: Warning Message >> " + getZipWarningMessage);

		common.assertTwoValuesAreEqual(getCountryWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_COUNTRY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getAddressWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCityWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CITY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getStateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_STATE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getZipWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ZIP_ALERT_MESSAGE);

		common.log("<br></br>Step :: Enter Address.");
		System.out.println("Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		common.log("<br></br>Step :: Enter City.");
		System.out.println("Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		Select_Counrty_and_State(); // Select Country and State from dropdown

		common.log("<br></br>Step :: Enter Zip.");
		System.out.println("Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(40);
		common.waitForElement(By.xpath("//ul[@id='messages']"));

		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);
		common.pause(10);
	}

	/**
	 * Regular SignUp With Billing info Not Mandatory And ACH Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBillingInfoNotMandatoryAndACHInfoMandatory() throws InterruptedException {

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step ::  Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println(" Step  ::Click on signUp button.");
		common.jsClick(signUp);
		common.pause(50);
		String getBankAccountNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_7 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getBankAccountNameWarningMessage);

		String getBankAccountWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][2]")).getText();
		System.out.println("Step :: Bank Account Warning Message >> " + getBankAccountWarningMessage);

		String getBankAccountTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_5 + "'][3]")).getText();
		System.out.println("Step :: Bank Account Type Warning Message >> " + getBankAccountTypeWarningMessage);

		String getBankNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_6 + "'][4]")).getText();
		System.out.println("Step :: Bank Name Warning Message >> " + getBankNameWarningMessage);

		String getBankRoutingTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][5]")).getText();
		System.out.println("Step :: Bank Routing Warning Message >> " + getBankRoutingTypeWarningMessage);

		common.assertTwoValuesAreEqual(getBankRoutingTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ROUTING_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankNameWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_BANK_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountNameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_NAME_ALERT_MESSAGE);

		Select_Bank_Account_Type();// Select Bank Account Type

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(30);
		common.waitForElement(By.xpath("//ul[@id='messages']"));

		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

	}

	/**
	 * Regular SignUp With Billing info Mandatory And ACH Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 * 
	 */
	public void regularSignUpWithBillingInfoMandatoryAndACHInfoMandatory() throws InterruptedException {

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(50);

		String getAddressWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getAddressWarningMessage);

		String getBankAccountNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_7 + "'][2]")).getText();
		System.out.println("Step :: Warning Message >> " + getBankAccountNameWarningMessage);

		String getBankAccountWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][3]")).getText();
		System.out.println("Step :: Bank Account Warning Message >> " + getBankAccountWarningMessage);

		String getBankAccountTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_5 + "'][4]")).getText();
		System.out.println("Step :: Bank Account Type Warning Message >> " + getBankAccountTypeWarningMessage);

		String getBankNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_6 + "'][5]")).getText();
		System.out.println("Step :: Bank Name Warning Message >> " + getBankNameWarningMessage);

		String getBankRoutingTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][6]")).getText();
		System.out.println("Step :: Bank Routing Warning Message >> " + getBankRoutingTypeWarningMessage);

		String getCityWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][7]")).getText();
		System.out.println("Step :: Warning Message >> " + getCityWarningMessage);

		String getCountryWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][8]")).getText();
		System.out.println("Step :: Warning Message >> " + getCountryWarningMessage);

		String getStateWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][9]")).getText();
		System.out.println("Step :: Warning Message >> " + getStateWarningMessage);

		String getZipWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][10]")).getText();
		System.out.println("Step :: Warning Message >> " + getZipWarningMessage);

		System.out.println("Step :: Warning Message >> " + getBankAccountNameWarningMessage);

		common.assertTwoValuesAreEqual(getCountryWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_COUNTRY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getAddressWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCityWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CITY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getStateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_STATE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getZipWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ZIP_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankRoutingTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ROUTING_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankNameWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_BANK_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountNameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_NAME_ALERT_MESSAGE);

		Select_Counrty_and_State(); // Select Country and State from Dropdown

		common.log("<br></br>Step :: Enter City.");
		System.out.println("Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		common.log("<br></br>Step :: Enter Zip.");
		System.out.println("Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		common.log("<br></br>Step :: Enter Address.");
		System.out.println("Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		Select_Bank_Account_Type();

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Click on signUp button.");
		common.jsClick(signUp);

		common.pause(30);
		common.waitForElement(By.xpath("//ul[@id='messages']"));

		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

	}

	/**
	 * Regular SignUp With CC info Mandatory And ACH info NOT Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithCCInfoMandatoryAndACHInfoNotMandatory() throws InterruptedException {

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(50);

		String getSecurityCodeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getSecurityCodeWarningMessage);

		String getExpirationDateWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][2]")).getText();
		System.out.println("Step :: Warning Message >> " + getExpirationDateWarningMessage);

		String getCCNumberWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][3]")).getText();
		System.out.println("Step :: Warning Message >> " + getCCNumberWarningMessage);

		String getCCTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][4]")).getText();

		System.out.println("Step :: Warning Message >>" + getCCTypeWarningMessage);
		common.assertTwoValuesAreEqual(getCCTypeWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCCNumberWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_NUMBER_ALERT_MESSAGE);

		common.assertTwoValuesAreEqual(getExpirationDateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_EXPIRY_DATE);
		common.assertTwoValuesAreEqual(getSecurityCodeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_SECURITY_CODE_ALERT_MESSAGE);

		Enter_CC_Details(); // Enter CC Details

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Click on signUp button.");
		common.jsClick(signUp);

		common.pause(30);
		common.waitForElement(By.xpath("//ul[@id='messages']"));
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

	}

	/**
	 * Regular SignUp With CC info Not Mandatory And ACH info Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithCCInfoNotMandatoryAndACHInfoMandatory() throws InterruptedException {

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(50);

		String getBankAccountNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_7 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getBankAccountNameWarningMessage);

		String getBankAccountWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][2]")).getText();
		System.out.println("Step :: Bank Account Warning Message >> " + getBankAccountWarningMessage);

		String getBankAccountTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_5 + "'][3]")).getText();
		System.out.println("Step :: Bank Account Type Warning Message >> " + getBankAccountTypeWarningMessage);

		String getBankNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_6 + "'][4]")).getText();
		System.out.println("Step :: Bank Name Warning Message >> " + getBankNameWarningMessage);

		String getBankRoutingTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][5]")).getText();
		System.out.println("Step :: Bank Routing Warning Message >> " + getBankRoutingTypeWarningMessage);

		common.assertTwoValuesAreEqual(getBankRoutingTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ROUTING_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankNameWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_BANK_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountNameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_NAME_ALERT_MESSAGE);

		common.pause(10);
		Select_Bank_Account_Type();

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(30);
		common.waitForElement(By.xpath("//ul[@id='messages']"));
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

	}

	/**
	 * Regular SignUp With CC info Mandatory And ACH info Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithCCInfoMandatoryAndACHInfoMandatory() throws InterruptedException {

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(50);

		String getBankAccountNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_7 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getBankAccountNameWarningMessage);

		String getBankAccountWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][2]")).getText();
		System.out.println("Step :: Bank Account Warning Message >> " + getBankAccountWarningMessage);

		String getBankAccountTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_5 + "'][3]")).getText();
		System.out.println("Step :: Bank Account Type Warning Message >> " + getBankAccountTypeWarningMessage);

		String getBankNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_6 + "'][4]")).getText();
		System.out.println("Step :: Bank Name Warning Message >> " + getBankNameWarningMessage);

		String getBankRoutingTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][5]")).getText();
		System.out.println("Step :: Bank Routing Warning Message >> " + getBankRoutingTypeWarningMessage);

		String getSecurityCodeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][6]")).getText();
		System.out.println("Step :: Warning Message >> " + getSecurityCodeWarningMessage);

		String getExpirationDateWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][7]")).getText();
		System.out.println("Step :: Warning Message >> " + getExpirationDateWarningMessage);

		String getCCNumberWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][8]")).getText();
		System.out.println("Step :: Warning Message >> " + getCCNumberWarningMessage);

		String getCCTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][9]")).getText();

		System.out.println("Step :: Warning Message >>" + getCCTypeWarningMessage);

		common.assertTwoValuesAreEqual(getCCTypeWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCCNumberWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_NUMBER_ALERT_MESSAGE);

		common.assertTwoValuesAreEqual(getExpirationDateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_EXPIRY_DATE);
		common.assertTwoValuesAreEqual(getSecurityCodeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_SECURITY_CODE_ALERT_MESSAGE);

		common.assertTwoValuesAreEqual(getBankRoutingTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ROUTING_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankNameWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_BANK_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountNameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_NAME_ALERT_MESSAGE);

		common.pause(15);
		Select_Bank_Account_Type();

		Enter_CC_Details(); // Enter CC Details

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(30);
		common.waitForElement(By.xpath("//ul[@id='messages']"));
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

	}

	/**
	 * Regular SignUp With Basic info Mandatory Billing address info not Mandatory
	 * CC info not mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBasicInfoMandatoryBillingAddressInfoNotMandatoryAndCCinfoNotMandatory()
			throws InterruptedException {

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(50);

		// rev 3.5 expected [First name *: Required] but found [First name: Required]
		// Need to change

		String getContactWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getContactWarningMessage);
		common.log("Step :: Warning Message >> " + getContactWarningMessage);

		String getFirstnameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][2]")).getText();
		System.out.println("Step :: Warning Message >> " + getFirstnameWarningMessage);
		common.log("Step :: Warning Message >> " + getFirstnameWarningMessage);

		common.assertTwoValuesAreEqual(getFirstnameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getContactWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_CONTACT_TYPE_ALERT_MESSAGE);

		Select_Billing_Info_Phone_Type(); // Select Phone Type

		Select_Counrty_and_State(); // Select Country and State from dropdown

		common.log("<br></br>Step :: Enter Address.");
		System.out.println("Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		common.log("<br></br>Step :: Enter City.");
		System.out.println("Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		common.log("<br></br>Step :: Enter Zip.");
		System.out.println("Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		common.log("<br></br>Step :: Billing First Name.");
		System.out.println("Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		common.log("<br></br>Step :: Billing Last Name.");
		System.out.println("Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		common.log("<br></br>Step :: Billing Phone Number.");
		System.out.println("Step :: Billing Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(30);
		common.waitForElement(By.xpath("//ul[@id='messages']"));
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

	}

	/**
	 * Regular SignUp With Basic info Not Mandatory Billing address info Mandatory
	 * CC info not mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void RegularSignUpWithBasicInfoNotMandatoryBillingAddressInfoMandatoryAndCCinfoNotMandatory()
			throws InterruptedException {

		// common.waitForConditionIsElementPresent("//div[@id='" +
		// LEGACY_USER_SIGNUP_REGISTRATION_PANEL + "']");

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(50);

		String getAddressWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >>  " + getAddressWarningMessage);

		String getCityWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][2]")).getText();
		System.out.println("Step :: Warning Message >>  " + getCityWarningMessage);

		String getCountryWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][3]")).getText();
		System.out.println("Step :: Warning Message >>  " + getCountryWarningMessage);

		String getStateWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][4]")).getText();
		System.out.println("Step :: Warning Message >>  " + getCityWarningMessage);

		String getZipWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][5]")).getText();
		System.out.println("Step :: Warning Message >>  " + getZipWarningMessage);

		common.pause(5);

		System.out.println("Assert Values");
		common.assertTwoValuesAreEqual(getCountryWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_COUNTRY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getAddressWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCityWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CITY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getZipWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ZIP_ALERT_MESSAGE);

		Select_Counrty_and_State();

		common.log("<br></br>Step :: Enter Address.");
		System.out.println("Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		common.log("<br></br>Step :: Enter City.");
		System.out.println("Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		common.log("<br></br>Step :: Enter Zip.");
		System.out.println("Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(30);
		common.waitForElement(By.xpath("//ul[@id='messages']"));
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

	}

	/**
	 * Regular SignUp With Basic info Mandatory Not Billing address info not
	 * Mandatory CC info mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBasicInfoNotMandatoryBillingAddressInfoNotMandatoryAndCCinfoMandatory()
			throws InterruptedException {

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(50);

		String getSecurityCodeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getSecurityCodeWarningMessage);

		String getExpirationDateWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][2]")).getText();
		System.out.println("Step :: Warning Message >> " + getExpirationDateWarningMessage);

		String getCCNumberWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][3]")).getText();
		System.out.println("Step :: Warning Message >> " + getCCNumberWarningMessage);

		String getCCTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][4]")).getText();

		System.out.println("Step :: Warning Message >>" + getCCTypeWarningMessage);

		common.assertTwoValuesAreEqual(getCCTypeWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCCNumberWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_NUMBER_ALERT_MESSAGE);

		common.assertTwoValuesAreEqual(getExpirationDateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_EXPIRY_DATE);
		common.assertTwoValuesAreEqual(getSecurityCodeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_SECURITY_CODE_ALERT_MESSAGE);

		common.log("<br></br>Step :: Enter Address.");
		System.out.println("Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		common.log("<br></br>Step :: Enter City.");
		System.out.println("Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		String State = "California";

		common.log("<br></br>Step :: Enter Zip.");
		System.out.println("Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		common.log("<br></br>Step :: Select Contact Phone Type.");
		System.out.println("Step :: Select Contact Phone Type.");
		String PhoneType = "Work";
		WebElement option = billingInfoSelect.findElement(By.xpath("//span[@id='"
				+ LEGACY_USER_SIGNUP_BILL_LST_CONTACT_TYPE + "']//option[contains(text(),'" + PhoneType + "')]"));

		common.log("<br></br>Step :: Billing First Name.");
		System.out.println("Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		common.log("<br></br>Step :: Billing Last Name.");
		System.out.println("Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		common.log("<br></br>Step :: Billing Phone Number.");
		System.out.println("Step :: Billing Phone Number");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		Select_Billing_Info_Phone_Type(); // Select Phone Type

		Select_Counrty_and_State(); // Select Country and State from dropdown

		Enter_CC_Details(); // Enter CC Details

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(30);
		common.waitForElement(By.xpath("//ul[@id='messages']"));
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

	}

	/**
	 * Regular SignUp With Basic info Not Mandatory Billing address info Mandatory
	 * ACH info Not Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void RegularSignUpWithBasicInfoNotMandatoryBillingAddressInfoMandatoryAndACHinfoNotMandatory()
			throws InterruptedException {

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(50);
		System.out.println("Step :: Verify Validation Error");

		String getAddressWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getAddressWarningMessage);

		String getCityWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][2]")).getText();
		System.out.println("Step :: Warning Message >> " + getCityWarningMessage);

		String getCountryWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][3]")).getText();
		System.out.println("Step :: Warning Message >> " + getCountryWarningMessage);

		String getStateWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][4]")).getText();
		System.out.println("Step :: Warning Message >> " + getStateWarningMessage);

		String getZipWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][5]")).getText();
		System.out.println("Step :: Warning Message >> " + getZipWarningMessage);

		System.out.println("Step :: Verify Assert Values");

		common.assertTwoValuesAreEqual(getCountryWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_COUNTRY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getAddressWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCityWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CITY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getStateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_STATE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getZipWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ZIP_ALERT_MESSAGE);

		Select_Counrty_and_State(); // Select Country and State

		common.log("<br></br>Step :: Enter Address.");
		System.out.println("Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		common.log("<br></br>Step :: Enter City.");
		System.out.println("Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		common.log("<br></br>Step :: Enter gZip.");
		System.out.println("Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		common.pause(5);

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(40);
		common.waitForElement(By.xpath("//ul[@id='messages']"));
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);
	}

	/**
	 * Regular SignUp With Basic info Mandatory Billing address info Mandatory CC
	 * info Mandatory mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBasicInfoMandatoryBillingAddressInfoMandatoryAndCCinfoNotMandatory()
			throws InterruptedException {

		signupUser(); // SignUp User

		System.out.println("Step :: Entering Captcha.");
		common.log("<br></br>Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(50);

		String getAddressWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getAddressWarningMessage);

		String getCityWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_5 + "'][2]")).getText();
		System.out.println("Step :: Warning Message >> " + getCityWarningMessage);

		String getContactWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][3]")).getText();
		System.out.println("Step :: Warning Message >> " + getContactWarningMessage);

		String getCountryWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][4]")).getText();
		System.out.println("Step :: Warning Message >> " + getCountryWarningMessage);

		String getFirstnameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][5]")).getText();
		System.out.println("Step :: Warning Message >> " + getFirstnameWarningMessage);

		String getLastnameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][6]")).getText();
		System.out.println("Step :: Warning Message >> " + getLastnameWarningMessage);

		String getPhoneWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][7]")).getText();
		System.out.println("Step :: Warning Message >> " + getPhoneWarningMessage);

		String getStateWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][8]")).getText();
		System.out.println("Step :: Warning Message >> " + getStateWarningMessage);

		common.assertTwoValuesAreEqual(getFirstnameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getLastnameWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCountryWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_COUNTRY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getAddressWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCityWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CITY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getStateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_STATE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getContactWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_CONTACT_TYPE_ALERT_MESSAGE);

		Select_Billing_Info_Phone_Type(); // Select Phone Type

		Select_Counrty_and_State(); // Select Country and State from dropdown

		common.log("<br></br>Step :: Enter Address.");
		System.out.println("Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		common.log("<br></br>Step :: Enter City.");
		System.out.println("Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		common.log("<br></br>Step :: Enter Zip.");
		System.out.println("Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		System.out.println("Step :: Select Contact Phone Type.");
		common.log("<br></br>Step :: Select Contact Phone Type.");
		String PhoneType = "Work";
		WebElement option = billingInfoSelect.findElement(By.xpath("//span[@id='"
				+ LEGACY_USER_SIGNUP_BILL_LST_CONTACT_TYPE + "']//option[contains(text(),'" + PhoneType + "')]"));

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		common.log("<br></br>Step :: Billing Phone Number.");
		System.out.println("Step :: Billing  Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(30);
		common.waitForElement(By.xpath("//ul[@id='messages']"));
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

	}

	/**
	 * Regular SignUp With Basic info Mandatory Billing address info Mandatory CC
	 * info Mandatory mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBasicInfoMandatoryBillingAddressInfoNotMandatoryAndCCinfoMandatory()
			throws InterruptedException {

		signupUser(); // SignUp User

		System.out.println("Step :: Entering Captcha.");
		common.log("<br></br>Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(50);

		String getSecurityCodeWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getSecurityCodeWarningMessage);

		String getExpirationDateWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][2]"))
				.getText();
		System.out.println("Step :: Warning Message >> " + getExpirationDateWarningMessage);

		String getCCNumberWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][3]")).getText();
		System.out.println("Step :: Warning Message >> " + getCCNumberWarningMessage);

		String getCCTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][4]")).getText();

		System.out.println("Step :: Warning Message >>" + getCCTypeWarningMessage);

		String getPhoneWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][5]")).getText();

		System.out.println("Step :: Warning Message >>" + getPhoneWarningMessage);

		String getFirstnameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][6]")).getText();
		System.out.println("Step :: Warning Message >> " + getFirstnameWarningMessage);

		String getLastnameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][7]")).getText();
		System.out.println("Step :: Warning Message >> " + getLastnameWarningMessage);

		common.assertTwoValuesAreEqual(getFirstnameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getLastnameWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCCTypeWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCCNumberWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_NUMBER_ALERT_MESSAGE);

		common.assertTwoValuesAreEqual(getExpirationDateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_EXPIRY_DATE);
		common.assertTwoValuesAreEqual(getSecurityCodeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_SECURITY_CODE_ALERT_MESSAGE);

		common.log("<br></br>Step :: Enter Address.");
		System.out.println("Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		common.log("<br></br>Step :: Enter City.");
		System.out.println("Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		common.log("<br></br>Step :: Enter Zip.");
		System.out.println("Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		Select_Counrty_and_State(); // Select Country and State from dropdown

		Select_Billing_Info_Phone_Type(); // Select Phone Type

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		common.log("<br></br>Step :: Billing Phone Number.");
		System.out.println("Step :: Billing Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		Enter_CC_Details(); // Enter CC Details

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(30);
		common.waitForElement(By.xpath("//ul[@id='messages']"));

		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

	}

	/**
	 * Regular SignUp With Basic info Not Mandatory Billing address info Mandatory
	 * CC info Mandatory mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBasicInfoNotMandatoryBillingAddressInfoMandatoryAndCCinfoMandatory()
			throws InterruptedException {

		signupUser(); // SignUp User

		System.out.println("Step :: Entering Captcha.");
		common.log("<br></br>Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(50);

		String getAddressWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getAddressWarningMessage);
		String getSecurityCodeWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][2]")).getText();
		System.out.println("Step :: Warning Message >> " + getSecurityCodeWarningMessage);

		String getExpirationDateWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][3]"))
				.getText();
		System.out.println("Step :: Warning Message >> " + getExpirationDateWarningMessage);

		String getCCNumberWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][4]")).getText();
		System.out.println("Step :: Warning Message >> " + getCCNumberWarningMessage);

		String getCCTypeWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][5]")).getText();

		System.out.println("Step :: Warning Message >>" + getCCTypeWarningMessage);

		String getCityWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][6]")).getText();
		System.out.println("Step :: Warning Message >> " + getCityWarningMessage);

		common.assertTwoValuesAreEqual(getAddressWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCityWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CITY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCCTypeWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCCNumberWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_NUMBER_ALERT_MESSAGE);

		common.assertTwoValuesAreEqual(getExpirationDateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_EXPIRY_DATE);
		common.assertTwoValuesAreEqual(getSecurityCodeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_SECURITY_CODE_ALERT_MESSAGE);

		common.log("<br></br>Step :: Enter Address.");
		System.out.println("Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		common.log("<br></br>Step :: Enter City.");
		System.out.println("Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		common.log("<br></br>Step :: Enter Zip.");
		System.out.println("Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		common.log("<br></br>Step :: Billing Pone Number");
		System.out.println("Step :: Billing Phone Number");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		Select_Billing_Info_Phone_Type(); // Select Phone Type

		Select_Counrty_and_State(); // Select Country and State from dropdown

		Enter_CC_Details(); // Enter CC Details

		common.log("<br></br>Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(30);
		common.waitForElement(By.xpath("//ul[@id='messages']"));
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

	}

	/**
	 * Regular SignUp With Basic info Mandatory Billing address info Mandatory CC
	 * info Mandatory mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBasicInfoMandatoryBillingAddressInfoMandatoryAndCCinfoMandatory()
			throws InterruptedException {

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(30);

		String getAddressWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getAddressWarningMessage);

		String getSecurityCodeWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][2]")).getText();
		System.out.println("Step :: Warning Message >> " + getSecurityCodeWarningMessage);

		String getExpirationDateWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][3]"))
				.getText();
		System.out.println("Step :: Warning Message >> " + getExpirationDateWarningMessage);

		String getCCNumberWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][4]")).getText();
		System.out.println("Step :: Warning Message >> " + getCCNumberWarningMessage);

		String getCCTypeWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][5]")).getText();

		System.out.println("Step :: Warning Message >>" + getCCTypeWarningMessage);

		String getCityWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_5 + "'][6]")).getText();
		System.out.println("Step :: Warning Message >> " + getCityWarningMessage);

		String getContactWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][7]")).getText();
		System.out.println("Step :: Warning Message >> " + getContactWarningMessage);

		String getCountryWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][8]")).getText();
		System.out.println("Step :: Warning Message >> " + getCountryWarningMessage);

		String getFirstnameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][9]")).getText();
		System.out.println("Step :: Warning Message >> " + getFirstnameWarningMessage);

		String getLastnameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][10]")).getText();
		System.out.println("Step :: Warning Message >> " + getLastnameWarningMessage);

		String getPhoneWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][11]")).getText();
		System.out.println("Step :: Warning Message >> " + getPhoneWarningMessage);

		String getStateWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][12]")).getText();
		System.out.println("Step :: Warning Message >> " + getStateWarningMessage);

		common.assertTwoValuesAreEqual(getFirstnameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getLastnameWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCountryWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_COUNTRY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getAddressWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCityWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CITY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getStateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_STATE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getContactWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_CONTACT_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCCTypeWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCCNumberWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_NUMBER_ALERT_MESSAGE);

		common.assertTwoValuesAreEqual(getExpirationDateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_EXPIRY_DATE);
		common.assertTwoValuesAreEqual(getSecurityCodeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_SECURITY_CODE_ALERT_MESSAGE);

		Select_Billing_Info_Phone_Type(); // Select Phone Type

		Select_Counrty_and_State(); // Select Country and State from dropdown

		common.log("<br></br>Step :: Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		common.log("<br></br>Step :: City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		common.log("<br></br>Step :: Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		common.log("<br></br>Step :: Billing Phone Number");
		System.out.println("Enter Phone Number...");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);
		Enter_CC_Details(); // Enter CC Details

		common.log("<br></br>Step :: Entering Phone Number.");
		System.out.println("Step :: Enter Phone Number...");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(40);

		common.waitForConditionIsElementPresent("//ul[@id='messages']");
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);
		common.pause(10);
	}

	/**
	 * Regular SignUp With Basic info Mandatory Billing address info Mandatory CC
	 * info Mandatory mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBasicInfoMandatoryBillingAddressInfoNotMandatoryAndACHinfoNotMandatory()
			throws InterruptedException {

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(30);

		String getPhoneWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getPhoneWarningMessage);

		String getFirstnameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][2]")).getText();
		System.out.println("Step :: Warning Message >> " + getFirstnameWarningMessage);

		String getLastnameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][3]")).getText();
		System.out.println("Step :: Warning Message >> " + getLastnameWarningMessage);

		System.out.println("Step :: Verify Assert Values");

		common.assertTwoValuesAreEqual(getFirstnameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getLastnameWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getPhoneWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CONTACT_TYPE_ALERT_MESSAGE);

		Select_Counrty_and_State(); // Select Country and State

		Select_Bank_Account_Type();
		common.log("<br></br>Step :: Address.");
		System.out.println("Step :: Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		common.log("<br></br>Step :: City.");
		System.out.println("Step :: City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		common.log("<br></br>Step :: Zip.");
		System.out.println("Step :: Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		Select_Billing_Info_Phone_Type(); // Select Phone Type

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		common.log("<br></br>Step :: Billing Phone Number");
		System.out.println("Step :: Billing Phone Number");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_BANK_ROUTING + "']", "123456789");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_BANK_ACCOUNT + "']", "1234554321");

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(40);
		common.waitForElement(By.xpath("//ul[@id='messages']"));
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

	}

	/**
	 * Regular SignUp With Basic info Not Mandatory Billing address info Mandatory
	 * ACH info Not Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBasicInfoNotMandatoryBillingAddressInfoMandatoryAndACHinfoNotMandatory()
			throws InterruptedException {

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		System.out.println("Step :: Verify Validation Error");

		String getCountryWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getCountryWarningMessage);

		String getAddressWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][2]")).getText();
		System.out.println("Step :: Warning Message >> " + getAddressWarningMessage);

		String getCityWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][3]")).getText();
		System.out.println("Step :: Warning Message >> " + getCityWarningMessage);

		String getStateWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "']")).getText();
		System.out.println("Step :: Warning Message >> " + getStateWarningMessage);

		String getZipWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles 5']")).getText();
		System.out.println("Step :: Warning Message >> " + getZipWarningMessage);

		System.out.println("Step :: Verify Assert Values");

		common.assertTwoValuesAreEqual(getCountryWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_COUNTRY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getAddressWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCityWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CITY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getStateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_STATE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getZipWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ZIP_ALERT_MESSAGE);

		Select_Counrty_and_State(); // Select Country and State

		common.log("<br></br>Step :: Address.");
		System.out.println("Step :: Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		common.log("<br></br>Step :: City.");
		System.out.println("Step :: City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		common.log("<br></br>Step :: Zip.");
		System.out.println("Step :: Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		Select_Billing_Info_Phone_Type(); // Select Phone Type

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(15);

		common.assertElementPresent("//li[@class='note']");
		String Success_Msg = driver.findElement(By.xpath("//li[@class='note']")).getText();
		System.out.println("Step :: " + Success_Msg);
	}

	/**
	 * Regular SignUp With Basic info Mandatory Billing address info Mandatory ACH
	 * info Not Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBasicInfoMandatoryBillingAddressInfoMandatoryAndACHinfoNotMandatory()
			throws InterruptedException {

		signupUser(); // SignUp User

		System.out.println("Step :: Entering Captcha.");
		common.log("<br></br>Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(40);

		String getAddressWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getAddressWarningMessage);

		String getCityWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_5 + "'][2]")).getText();
		System.out.println("Step :: Warning Message >> " + getCityWarningMessage);

		String getContactWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][3]")).getText();
		System.out.println("Step :: Warning Message >> " + getContactWarningMessage);

		String getCountryWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][4]")).getText();
		System.out.println("Step :: Warning Message >> " + getCountryWarningMessage);

		String getLastnameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][5]")).getText();

		String getFirstnameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][6]")).getText();
		System.out.println("Step :: Warning Message >> " + getFirstnameWarningMessage);

		String getPhoneWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][7]")).getText();
		System.out.println("Step :: Warning Message >> " + getPhoneWarningMessage);
		System.out.println("Step :: Warning Message >> " + getLastnameWarningMessage);

		String getStateWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][8]")).getText();
		System.out.println("Step :: Warning Message >> " + getStateWarningMessage);

		System.out.println("Step :: Verify Assert Values");

		common.assertTwoValuesAreEqual(getCountryWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_COUNTRY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getAddressWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCityWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CITY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getStateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_STATE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getPhoneWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_PHONE_ALERT_MESSAGE);

		Select_Counrty_and_State(); // Select Country and State

		common.log("<br></br>Step :: Enter Zip.");
		System.out.println("Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		Select_Billing_Info_Phone_Type(); // Select Phone Type

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		common.log("<br></br>Step :: Billing Phone Number.");
		System.out.println("Step :: Billing Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		common.log("<br></br>Step :: Enter Address.");
		System.out.println("Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		common.log("<br></br>Step :: Enter City.");
		System.out.println("Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(30);

		common.waitForElement(By.xpath("//ul[@id='messages']"));
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

	}

	/**
	 * Regular SignUp With Basic info Not Mandatory Billing address info Not
	 * Mandatory ACH info Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void RegularSignUpWithBasicInfoNotMandatoryBillingAddressInfoNotMandatoryAndACHinfoNotMandatory()
			throws InterruptedException {

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(30);
		common.waitForElement(By.xpath("//ul[@id='messages']"));
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

		common.log("<br></br>Step :: signup successful<br>");
	}

	/**
	 * Regular SignUp With Basic info Mandatory Billing address info Not Mandatory
	 * ACH info Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBasicInfoMandatoryBillingAddressInfoNotMandatoryAndACHinfoMandatory()
			throws InterruptedException {

		signupUser(); // SignUp User

		System.out.println("Step :: Entering Captcha.");
		common.log("<br></br>Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(30);

		String getBankAccountNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getBankAccountNameWarningMessage);

		String getBankAccountWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][2]")).getText();
		System.out.println("Step :: Bank Account Warning Message >> " + getBankAccountWarningMessage);

		String getBankAccountTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][3]")).getText();
		System.out.println("Step :: Bank Account Type Warning Message >> " + getBankAccountTypeWarningMessage);

		String getBankNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][4]")).getText();
		System.out.println("Step :: Bank Name Warning Message >> " + getBankNameWarningMessage);

		String getBankRoutingTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][5]")).getText();
		System.out.println("Step :: Bank Routing Warning Message >> " + getBankRoutingTypeWarningMessage);
		String getPhoneWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][6]")).getText();
		System.out.println("Step :: Warning Message >> " + getPhoneWarningMessage);
		String getFirstnameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][7]")).getText();
		System.out.println("Step :: Warning Message >> " + getFirstnameWarningMessage);

		String getLastnameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][8]")).getText();
		System.out.println("Step :: Warning Message >> " + getLastnameWarningMessage);

		System.out.println("Step :: Verify Assert Values");

		common.assertTwoValuesAreEqual(getFirstnameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME_UPDATED_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getLastnameWarningMessage, LEGACY_USER_SIGNUP_Ship_TXT_LAST_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankRoutingTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ROUTING_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankNameWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_BANK_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountNameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_NAME_ALERT_MESSAGE);

		Select_Counrty_and_State(); // Select Country and State

		Select_Bank_Account_Type();

		common.log("<br></br>Step :: Enter Address.");
		System.out.println("Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		common.log("<br></br>Step :: Enter City.");
		System.out.println("Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);
		common.waitForElement("//span[@id='" + LEGACY_USER_SIGNUP_BILL_LST_COUNTRY + "']");

		common.log("<br></br>Step :: Enter Zip.");
		System.out.println("Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		Select_Billing_Info_Phone_Type(); // Select Phone Type

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		common.log("<br></br>Step :: Billing Phone Number.");
		System.out.println("Step :: Billing Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(30);
		common.waitForElement(By.xpath("//ul[@id='messages']"));

		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

	}

	/**
	 * Regular SignUp With Basic info Not Mandatory Billing address info Mandatory
	 * ACH info Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBasicInfoNotMandatoryBillingAddressInfoMandatoryAndACHinfoMandatory()
			throws InterruptedException {

		signupUser(); // SignUp User

		System.out.println("Step :: Entering Captcha.");
		common.log("<br></br>Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(30);

		String getAddressWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getAddressWarningMessage);

		String getBankAccountNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][2]")).getText();
		System.out.println("Step :: Warning Message >> " + getBankAccountNameWarningMessage);

		String getBankAccountWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][3]")).getText();
		System.out.println("Step :: Bank Account Warning Message >> " + getBankAccountWarningMessage);

		String getBankAccountTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][4]")).getText();
		System.out.println("Step :: Bank Account Type Warning Message >> " + getBankAccountTypeWarningMessage);

		String getBankNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][5]")).getText();
		System.out.println("Step :: Bank Name Warning Message >> " + getBankNameWarningMessage);

		String getBankRoutingTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][6]")).getText();
		System.out.println("Step :: Bank Routing Warning Message >> " + getBankRoutingTypeWarningMessage);
		String getCityWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][7]")).getText();
		System.out.println("Step :: Warning Message >> " + getCityWarningMessage);

		String getCountryWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][8]")).getText();
		System.out.println("Step :: Warning Message >> " + getCountryWarningMessage);

		String getStateWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][9]")).getText();
		System.out.println("Step :: Warning Message >> " + getStateWarningMessage);

		String getZipWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][10]")).getText();
		System.out.println("Step :: Warning Message >> " + getZipWarningMessage);

		System.out.println("Step :: Verify Assert Values");

		common.assertTwoValuesAreEqual(getCountryWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_COUNTRY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getAddressWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCityWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CITY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getStateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_STATE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getZipWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ZIP_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankRoutingTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ROUTING_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankNameWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_BANK_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountNameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_NAME_ALERT_MESSAGE);

		Select_Counrty_and_State(); // Select State and Country

		Select_Bank_Account_Type();
		common.log("<br></br>Step :: Enter Zip.");
		System.out.println("Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		Select_Billing_Info_Phone_Type(); // Select Phone Type

		common.log("<br></br>Step :: Enter Address.");
		System.out.println("Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		common.log("<br></br>Step :: Enter City.");
		System.out.println("Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);
		common.waitForElement("//span[@id='" + LEGACY_USER_SIGNUP_BILL_LST_COUNTRY + "']");

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		common.log("<br></br>Step :: Billing Phone Number.");
		System.out.println("Step :: Billing Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(30);
		common.waitForElement(By.xpath("//ul[@id='messages']"));

		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

	}

	/**
	 * Regular SignUp With Basic info Mandatory Billing address info Mandatory ACH
	 * info Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBasicInfoMandatoryBillingAddressInfoMandatoryAndACHinfoMandatory()
			throws InterruptedException {

		signupUser(); // SignUp User

		System.out.println("Step :: Entering Captcha.");
		common.log("<br></br>Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(30);

		String getAddressWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getAddressWarningMessage);

		String getBankAccountNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][2]")).getText();
		System.out.println("Step :: Warning Message >> " + getBankAccountNameWarningMessage);

		String getBankAccountWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][3]")).getText();
		System.out.println("Step :: Bank Account Warning Message >> " + getBankAccountWarningMessage);

		String getBankAccountTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][4]")).getText();
		System.out.println("Step :: Bank Account Type Warning Message >> " + getBankAccountTypeWarningMessage);

		String getBankNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][5]")).getText();
		System.out.println("Step :: Bank Name Warning Message >> " + getBankNameWarningMessage);

		String getBankRoutingTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][6]")).getText();
		System.out.println("Step :: Bank Routing Warning Message >> " + getBankRoutingTypeWarningMessage);

		String getCityWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_5 + "'][7]")).getText();
		System.out.println("Step :: Warning Message >> " + getCityWarningMessage);

		String getContactWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][8]")).getText();
		System.out.println("Step :: Warning Message >> " + getContactWarningMessage);

		String getCountryWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][9]")).getText();
		System.out.println("Step :: Warning Message >> " + getCountryWarningMessage);

		String getFirstnameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][10]")).getText();
		System.out.println("Step :: Warning Message >> " + getFirstnameWarningMessage);

		String getLastnameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][11]")).getText();
		System.out.println("Step :: Warning Message >> " + getLastnameWarningMessage);

		String getPhoneWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][12]")).getText();
		System.out.println("Step :: Warning Message >> " + getPhoneWarningMessage);

		String getStateWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][13]")).getText();
		System.out.println("Step :: Warning Message >> " + getStateWarningMessage);

		System.out.println("Step :: Verify Assert Values");

		common.assertTwoValuesAreEqual(getFirstnameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME_UPDATED_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getLastnameWarningMessage, LEGACY_USER_SIGNUP_Ship_TXT_LAST_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCountryWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_COUNTRY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getAddressWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCityWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CITY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getStateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_STATE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getContactWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_CONTACT_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankRoutingTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ROUTING_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankNameWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_BANK_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountNameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_NAME_ALERT_MESSAGE);

		Select_Counrty_and_State(); // Select Country and State

		Select_Bank_Account_Type();

		common.log("<br></br>Step :: Enter Zip.");
		System.out.println("Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		Select_Billing_Info_Phone_Type(); // Select Phone Type

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		common.log("<br></br>Step :: Billing Phone Number.");
		System.out.println("Step :: Billing Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		common.log("<br></br>Step :: Enter Address.");
		System.out.println("Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		common.log("<br></br>Step :: Enter City.");
		System.out.println("Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(30);

		common.waitForElement(By.xpath("//ul[@id='messages']"));
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

	}

	/**
	 * Regular SignUp With Basic info Mandatory CC info Not Mandatory ACH info Not
	 * Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBasicInfoMandatoryCCInfoMandatoryAndACHinfoNotMandatory() throws InterruptedException {

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(15);

		String getSecurityCodeWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getSecurityCodeWarningMessage);

		String getExpirationDateWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][2]"))
				.getText();
		System.out.println("Step :: Warning Message >> " + getExpirationDateWarningMessage);

		String getCCNumberWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][3]")).getText();
		System.out.println("Step :: Warning Message >> " + getCCNumberWarningMessage);

		String getCCTypeWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][4]")).getText();

		System.out.println("Step :: Warning Message >>" + getCCTypeWarningMessage);

		String getphonewarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][5]")).getText();
		System.out.println("Step :: Warning Message >> " + getphonewarningMessage);
		String getFirstnameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][6]")).getText();
		System.out.println("Step :: Warning Message >> " + getFirstnameWarningMessage);

		String getLastnameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][7]")).getText();
		System.out.println("Step :: Warning Message >> " + getLastnameWarningMessage);

		System.out.println("Step :: Verify Assert Values");

		common.assertTwoValuesAreEqual(getFirstnameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getLastnameWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCCTypeWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCCNumberWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_NUMBER_ALERT_MESSAGE);

		Select_Billing_Info_Phone_Type(); // Select Phone Type

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		common.log("<br></br>Step :: Billing Phone Number.");
		System.out.println("Step :: Billing Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		Enter_CC_Details(); // Enter CC Details

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(30);
		common.waitForElement(By.xpath("//ul[@id='messages']"));

		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

		common.log("<br></br>Step :: signup successful<br>");

	}

	/**
	 * Regular SignUp With Basic info Not Mandatory CC info Mandatory ACH info Not
	 * Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBasicInfoNotMandatoryCCInfoMandatoryAndACHinfoNotMandatory()
			throws InterruptedException {

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(30);

		String getSecurityCodeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getSecurityCodeWarningMessage);

		String getExpirationDateWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][2]")).getText();
		System.out.println("Step :: Warning Message >> " + getExpirationDateWarningMessage);

		String getCCNumberWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][3]")).getText();
		System.out.println("Step :: Warning Message >> " + getCCNumberWarningMessage);

		String getCCTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][4]")).getText();

		System.out.println("Step :: Warning Message >>" + getCCTypeWarningMessage);

		System.out.println("Step :: Verify Assert Values");

		common.assertTwoValuesAreEqual(getCCTypeWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCCNumberWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_NUMBER_ALERT_MESSAGE);

		common.assertTwoValuesAreEqual(getExpirationDateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_EXPIRY_DATE);
		common.assertTwoValuesAreEqual(getSecurityCodeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_SECURITY_CODE_ALERT_MESSAGE);

		Enter_CC_Details(); // Enter CC Details

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(30);

		common.waitForElement(By.xpath("//ul[@id='messages']"));
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);
		common.log("<br></br>Step :: signup successful<br>");

	}

	/**
	 * Regular SignUp With Basic info Not Mandatory CC info Mandatory ACH info Not
	 * Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBasicInfoNotMandatoryCCInfoNotMandatoryAndACHinfoMandatory()
			throws InterruptedException {

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(15);

		String getBankAccountNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getBankAccountNameWarningMessage);

		String getBankAccountWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][2]")).getText();
		System.out.println("Step :: Bank Account Warning Message >> " + getBankAccountWarningMessage);

		String getBankAccountTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][3]")).getText();
		System.out.println("Step :: Bank Account Type Warning Message >> " + getBankAccountTypeWarningMessage);

		String getBankNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][4]")).getText();
		System.out.println("Step :: Bank Name Warning Message >> " + getBankNameWarningMessage);

		String getBankRoutingTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][5]")).getText();
		System.out.println("Step :: Bank Routing Warning Message >> " + getBankRoutingTypeWarningMessage);

		System.out.println("Step :: Verify Assert Values");

		common.assertTwoValuesAreEqual(getBankRoutingTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ROUTING_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankNameWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_BANK_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountNameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_NAME_ALERT_MESSAGE);

		Select_Bank_Account_Type();

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(30);

		common.waitForElement(By.xpath("//ul[@id='messages']"));
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

		common.log("<br></br>Step :: signup successful<br>");

	}

	/**
	 * Regular SignUp With Basic info Mandatory CC info Not Mandatory ACH info
	 * Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBasicInfoMandatoryCCInfoNotMandatoryAndACHinfoMandatory() throws InterruptedException {

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(30);

		String getBankAccountNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getBankAccountNameWarningMessage);

		String getBankAccountWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][2]")).getText();
		System.out.println("Step :: Bank Account Warning Message >> " + getBankAccountWarningMessage);

		String getBankAccountTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][3]")).getText();
		System.out.println("Step :: Bank Account Type Warning Message >> " + getBankAccountTypeWarningMessage);

		String getBankNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][4]")).getText();
		System.out.println("Step :: Bank Name Warning Message >> " + getBankNameWarningMessage);

		String getBankRoutingTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][5]")).getText();
		System.out.println("Step :: Bank Routing Warning Message >> " + getBankRoutingTypeWarningMessage);

		String getPhoneWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][6]")).getText();
		System.out.println("Step :: Warning Message >> " + getPhoneWarningMessage);
		String getFirstnameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][7]")).getText();
		System.out.println("Step :: Warning Message >> " + getFirstnameWarningMessage);

		String getLastnameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][8]")).getText();
		System.out.println("Step :: Warning Message >> " + getLastnameWarningMessage);

		System.out.println("Step :: Verify Assert Values");

		common.assertTwoValuesAreEqual(getFirstnameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME_UPDATED_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getLastnameWarningMessage, LEGACY_USER_SIGNUP_Ship_TXT_LAST_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankRoutingTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ROUTING_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankNameWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_BANK_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountNameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getPhoneWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CONTACT_TYPE_ALERT_MESSAGE);

		Select_Billing_Info_Phone_Type(); // Select Phone Type

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		common.log("<br></br>Step :: Billing Phone Number.");
		System.out.println("Step :: Billing Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		System.out.println("Step :: Enter Bank Name.");
		common.log("<br></br>Step :: Enter Bank Name.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_BANK_NAME + "']", "bank of america");

		System.out.println("Step :: Enter Bank Account Name.");
		common.log("<br></br>Step :: Enter Bank Account Name.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_BANK_ACCOUNT_NAME + "']", "rahul account");

		Select_Bank_Account_Type();

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(40);

		common.waitForElement(By.xpath("//ul[@id='messages']"));
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

		common.log("<br></br>Step :: signup successful<br>");
	}

	/**
	 * Regular SignUp With Basic info Not Mandatory CC info Mandatory ACH info
	 * Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBasicInfoNotMandatoryCCInfoMandatoryAndACHinfoMandatory() throws InterruptedException {

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Billing Phone Number.");
		System.out.println("Step :: Billing Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(30);

		String getBankAccountNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getBankAccountNameWarningMessage);

		String getBankAccountWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][2]")).getText();
		System.out.println("Step :: Bank Account Warning Message >> " + getBankAccountWarningMessage);

		String getBankAccountTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][3]")).getText();
		System.out.println("Step :: Bank Account Type Warning Message >> " + getBankAccountTypeWarningMessage);

		String getBankNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][4]")).getText();
		System.out.println("Step :: Bank Name Warning Message >> " + getBankNameWarningMessage);

		String getBankRoutingTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][5]")).getText();
		System.out.println("Step :: Bank Routing Warning Message >> " + getBankRoutingTypeWarningMessage);

		String getSecurityCodeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][6]")).getText();
		System.out.println("Step :: Warning Message >> " + getSecurityCodeWarningMessage);

		String getExpirationDateWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][7]")).getText();
		System.out.println("Step :: Warning Message >> " + getExpirationDateWarningMessage);

		String getCCNumberWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][8]")).getText();
		System.out.println("Step :: Warning Message >> " + getCCNumberWarningMessage);

		String getCCTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][9]")).getText();

		System.out.println("Step :: Warning Message >>" + getCCTypeWarningMessage);

		System.out.println("Step :: Verify Assert Values");

		common.assertTwoValuesAreEqual(getCCTypeWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCCNumberWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_NUMBER_ALERT_MESSAGE);

		common.assertTwoValuesAreEqual(getExpirationDateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_EXPIRY_DATE);
		common.assertTwoValuesAreEqual(getSecurityCodeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_SECURITY_CODE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankRoutingTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ROUTING_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankNameWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_BANK_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountNameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_NAME_ALERT_MESSAGE);

		Select_Billing_Info_Phone_Type(); // Select Phone Type

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		common.log("<br></br>Step :: Billing Phone Number.");
		System.out.println("Step :: Billing Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		Enter_CC_Details(); // Enter CC Details

		Select_Bank_Account_Type();
		common.pause(10);
		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(30);
		common.waitForElement(By.xpath("//ul[@id='messages']"));
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

		common.log("<br></br>Step :: signup successful<br>");
	}

	/**
	 * Regular SignUp With Basic info Mandatory CC info Mandatory ACH info Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBasicInfoMandatoryCCInfoMandatoryAndACHinfoMandatory() throws InterruptedException {

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(30);

		String getBankAccountNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getBankAccountNameWarningMessage);

		String getBankAccountWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][2]")).getText();
		System.out.println("Step :: Bank Account Warning Message >> " + getBankAccountWarningMessage);

		String getBankAccountTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][3]")).getText();
		System.out.println("Step :: Bank Account Type Warning Message >> " + getBankAccountTypeWarningMessage);

		String getBankNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][4]")).getText();
		System.out.println("Step :: Bank Name Warning Message >> " + getBankNameWarningMessage);

		String getBankRoutingTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][5]")).getText();
		System.out.println("Step :: Bank Routing Warning Message >> " + getBankRoutingTypeWarningMessage);

		String getSecurityCodeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][6]")).getText();
		System.out.println("Step :: Warning Message >> " + getSecurityCodeWarningMessage);

		String getExpirationDateWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][7]")).getText();
		System.out.println("Step :: Warning Message >> " + getExpirationDateWarningMessage);

		String getCCNumberWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][8]")).getText();
		System.out.println("Step :: Warning Message >> " + getCCNumberWarningMessage);

		String getCCTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][9]")).getText();

		System.out.println("Step :: Warning Message >>" + getCCTypeWarningMessage);

		String getPhoneWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][10]")).getText();
		System.out.println("Step :: Warning Message >> " + getPhoneWarningMessage);
		String getFirstnameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][11]")).getText();
		System.out.println("Step :: Warning Message >> " + getFirstnameWarningMessage);

		String getLastnameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][12]")).getText();
		System.out.println("Step :: Warning Message >> " + getLastnameWarningMessage);

		System.out.println("Step :: Verify Assert Values");

		common.assertTwoValuesAreEqual(getFirstnameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME_UPDATED_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getLastnameWarningMessage, LEGACY_USER_SIGNUP_Ship_TXT_LAST_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCCTypeWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCCNumberWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_NUMBER_ALERT_MESSAGE);

		common.assertTwoValuesAreEqual(getExpirationDateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_EXPIRY_DATE);
		common.assertTwoValuesAreEqual(getSecurityCodeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_SECURITY_CODE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankRoutingTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ROUTING_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankNameWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_BANK_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountNameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_NAME_ALERT_MESSAGE);

		Select_Billing_Info_Phone_Type(); // Select Phone Type

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		common.log("<br></br>Step :: Billing Phone Number.");
		System.out.println("Step ::  Billing Number");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);
		Enter_CC_Details(); // Enter CC Details

		Select_Bank_Account_Type();// Select Bank Account Type

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(40);
		common.waitForElement(By.xpath("//ul[@id='messages']"));
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

		common.log("<br></br>Step :: signup successful<br>");

	}

	/**
	 * Regular SignUp With Billing info Mandatory CC info Not Mandatory ACH info Not
	 * Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBillingInfoMandatoryCCInfoNotMandatoryAndACHinfoNotMandatory()
			throws InterruptedException {

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(30);

		String getAddressWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getAddressWarningMessage);

		String getCityWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][2]")).getText();
		System.out.println("Step :: Warning Message >> " + getCityWarningMessage);

		String getCountryWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][3]")).getText();
		System.out.println("Step :: Warning Message >> " + getCountryWarningMessage);

		String getStateWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][4]")).getText();
		System.out.println("Step :: Warning Message >> " + getStateWarningMessage);

		String getZiptWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][5]")).getText();
		System.out.println("Step :: Warning Message >> " + getZiptWarningMessage);

		System.out.println("Step :: Verify Assert Values");

		common.assertTwoValuesAreEqual(getCountryWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_COUNTRY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getAddressWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCityWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CITY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getStateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_STATE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getZiptWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ZIP_ALERT_MESSAGE);

		Select_Counrty_and_State(); // Select Countrty and State

		common.log("<br></br>Step :: Enter Address.");
		System.out.println("Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		common.log("<br></br>Step :: Enter City.");
		System.out.println("Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		common.log("<br></br>Step :: Enter Zip.");
		System.out.println("Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(40);
		common.waitForElement(By.xpath("//ul[@id='messages']"));
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

		common.log("<br></br>Step :: signup successful");
	}

	/**
	 * Regular SignUp With Billing info Not Mandatory CC info Mandatory ACH info Not
	 * Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBillingInfoNotMandatoryCCInfoMandatoryAndACHinfoNotMandatory()
			throws InterruptedException {

		// common.waitForConditionIsElementPresent("//div[@id='" +
		// LEGACY_USER_SIGNUP_REGISTRATION_PANEL + "']");

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(35);

		String getSecurityCodeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getSecurityCodeWarningMessage);

		String getExpirationDateWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][2]")).getText();
		System.out.println("Step :: Warning Message >> " + getExpirationDateWarningMessage);

		String getCCNumberWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][3]")).getText();
		System.out.println("Step :: Warning Message >> " + getCCNumberWarningMessage);

		String getCCTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][4]")).getText();

		System.out.println("Step :: Warning Message >>" + getCCTypeWarningMessage);

		common.assertTwoValuesAreEqual(getCCTypeWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCCNumberWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_NUMBER_ALERT_MESSAGE);

		common.assertTwoValuesAreEqual(getExpirationDateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_EXPIRY_DATE);
		common.assertTwoValuesAreEqual(getSecurityCodeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_SECURITY_CODE_ALERT_MESSAGE);

		Select_Counrty_and_State(); // Select Country and state
		Enter_CC_Details(); // Enter CC Details

		common.log("<br></br>Step :: Enter Address.");
		System.out.println("Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		common.log("<br></br>Step :: Enter City.");
		System.out.println("Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		common.log("<br></br>Step :: Enter Zip.");
		System.out.println("Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(40);

		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);
		common.log("<br></br>Step :: signup successful<br>");
	}

	/**
	 * Regular SignUp With Billing info Not Mandatory CC info Not Mandatory ACH info
	 * Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBillingInfoNotMandatoryCCInfoNotMandatoryAndACHinfoMandatory()
			throws InterruptedException {

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(30);

		String getBankAccountNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getBankAccountNameWarningMessage);

		String getBankAccountWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][2]")).getText();
		System.out.println("Step :: Bank Account Warning Message >> " + getBankAccountWarningMessage);

		String getBankAccountTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][3]")).getText();
		System.out.println("Step :: Bank Account Type Warning Message >> " + getBankAccountTypeWarningMessage);

		String getBankNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][4]")).getText();
		System.out.println("Step :: Bank Name Warning Message >> " + getBankNameWarningMessage);

		String getBankRoutingTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][5]")).getText();
		System.out.println("Step :: Bank Routing Warning Message >> " + getBankRoutingTypeWarningMessage);

		common.assertTwoValuesAreEqual(getBankRoutingTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ROUTING_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankNameWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_BANK_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountNameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_NAME_ALERT_MESSAGE);

		Select_Counrty_and_State(); // Select Country and State

		common.log("<br></br>Step :: Enter Address.");
		System.out.println("Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		common.log("<br></br>Step :: Enter City.");
		System.out.println("Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		common.log("<br></br>Step :: Enter Zip.");
		System.out.println("Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		Select_Bank_Account_Type();// Select Bank Account Type

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(40);
		common.waitForElement(By.xpath("//ul[@id='messages']"));
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

		common.log("<br></br>Step :: signup successful<br>");
	}

	/**
	 * Regular SignUp With Billing info Mandatory CC info Mandatory ACH Not info
	 * Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBillingInfoMandatoryCCInfoMandatoryAndACHinfoNotMandatory()
			throws InterruptedException {

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(40);

		String getAddressWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getAddressWarningMessage);

		String getSecurityCodeWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][2]")).getText();
		System.out.println("Step :: Warning Message >> " + getSecurityCodeWarningMessage);
		String getExpirationDateWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][3]"))
				.getText();
		System.out.println("Step :: Warning Message >> " + getExpirationDateWarningMessage);

		String getCCNumberWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][4]")).getText();
		System.out.println("Step :: Warning Message >> " + getCCNumberWarningMessage);

		String getCCTypeWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][5]")).getText();

		System.out.println("Step :: Warning Message >>" + getCCTypeWarningMessage);

		String getCityWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][6]")).getText();
		System.out.println("Step :: Warning Message >> " + getCityWarningMessage);

		String getCountryWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][7]")).getText();
		System.out.println("Step :: Warning Message >> " + getCountryWarningMessage);

		String getStateWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][8]")).getText();
		System.out.println("Step :: Warning Message >> " + getStateWarningMessage);

		common.assertTwoValuesAreEqual(getCountryWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_COUNTRY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getAddressWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCityWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CITY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getStateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_STATE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCCTypeWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCCNumberWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_NUMBER_ALERT_MESSAGE);

		common.assertTwoValuesAreEqual(getExpirationDateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_EXPIRY_DATE);
		common.assertTwoValuesAreEqual(getSecurityCodeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_SECURITY_CODE_ALERT_MESSAGE);

		Select_Counrty_and_State(); // Select Country and State

		common.log("<br></br>Step :: Enter Address.");
		System.out.println("Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		common.log("<br></br>Step :: Enter City.");
		System.out.println("Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		common.log("<br></br>Step :: Enter Zip.");
		System.out.println("Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		Enter_CC_Details();
		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(30);

		common.waitForElement("//ul[@id='messages']");
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

		common.log("<br></br>Step :: signup successful");
	}

	/**
	 * Regular SignUp With Billing info Mandatory CC info Not Mandatory ACH Not info
	 * Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBillingInfoMandatoryCCInfoNotMandatoryAndACHinfoMandatory()
			throws InterruptedException {

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(40);

		String getAddressWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getAddressWarningMessage);

		String getBankAccountNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][2]")).getText();
		System.out.println("Step :: Warning Message >> " + getBankAccountNameWarningMessage);

		String getBankAccountWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][3]")).getText();
		System.out.println("Step :: Bank Account Warning Message >> " + getBankAccountWarningMessage);

		String getBankAccountTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][4]")).getText();
		System.out.println("Step :: Bank Account Type Warning Message >> " + getBankAccountTypeWarningMessage);

		String getBankNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][5]")).getText();
		System.out.println("Step :: Bank Name Warning Message >> " + getBankNameWarningMessage);

		String getBankRoutingTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][6]")).getText();
		System.out.println("Step :: Bank Routing Warning Message >> " + getBankRoutingTypeWarningMessage);

		String getCityWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][7]")).getText();
		System.out.println("Step :: Warning Message >> " + getCityWarningMessage);
		String getCountryWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][8]")).getText();
		System.out.println("Step :: Warning Message >> " + getCountryWarningMessage);

		String getStateWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][9]")).getText();
		System.out.println("Step :: Warning Message >> " + getStateWarningMessage);

		String getZipWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][10]")).getText();
		System.out.println("Step :: Warning Message >> " + getZipWarningMessage);

		common.assertTwoValuesAreEqual(getCountryWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_COUNTRY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getAddressWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCityWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CITY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getStateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_STATE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getZipWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ZIP_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankRoutingTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ROUTING_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankNameWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_BANK_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountNameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_NAME_ALERT_MESSAGE);

		common.log("<br></br>Step :: Enter Address.");
		System.out.println("Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		Select_Counrty_and_State(); // Select Country and state

		common.log("<br></br>Step :: Enter City.");
		System.out.println("Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		common.log("<br></br>Step :: Enter Zip.");
		System.out.println("Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_BANK_ROUTING + "']", "123456789");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_BANK_ACCOUNT + "']", "1234554321");

		Select_Bank_Account_Type();// Select Bank Account Type

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(30);
		common.waitForElement("//ul[@id='messages']");
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

		common.log("<br></br>Step :: signup successful<br>");
	}

	/**
	 * Regular SignUp With Billing info Not Mandatory CC info Mandatory ACH Not info
	 * Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBillingInfoNotMandatoryCCInfoMandatoryAndACHinfoMandatory()
			throws InterruptedException {

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(40);

		String getBankAccountNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getBankAccountNameWarningMessage);

		String getBankAccountWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][2]")).getText();
		System.out.println("Step :: Bank Account Warning Message >> " + getBankAccountWarningMessage);

		String getBankAccountTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][3]")).getText();
		System.out.println("Step :: Bank Account Type Warning Message >> " + getBankAccountTypeWarningMessage);

		String getBankNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][4]")).getText();
		System.out.println("Step :: Bank Name Warning Message >> " + getBankNameWarningMessage);

		String getBankRoutingTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][5]")).getText();
		System.out.println("Step :: Bank Routing Warning Message >> " + getBankRoutingTypeWarningMessage);

		String getSecurityCodeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][6]")).getText();
		System.out.println("Step :: Warning Message >> " + getSecurityCodeWarningMessage);

		String getExpirationDateWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][7]")).getText();
		System.out.println("Step :: Warning Message >> " + getExpirationDateWarningMessage);

		String getCCNumberWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][8]")).getText();
		System.out.println("Step :: Warning Message >> " + getCCNumberWarningMessage);

		String getCCTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][9]")).getText();

		System.out.println("Step :: Warning Message >>" + getCCTypeWarningMessage);

		System.out.println("Step :: Verify Assert Values");

		common.assertTwoValuesAreEqual(getCCTypeWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCCNumberWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_NUMBER_ALERT_MESSAGE);

		common.assertTwoValuesAreEqual(getExpirationDateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_EXPIRY_DATE);
		common.assertTwoValuesAreEqual(getSecurityCodeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_SECURITY_CODE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankRoutingTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ROUTING_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankNameWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_BANK_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountNameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_NAME_ALERT_MESSAGE);

		common.log("<br></br>Step :: Enter Address.");
		System.out.println("Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		Select_Counrty_and_State(); // Select Country and State

		common.log("<br></br>Step :: Enter City.");
		System.out.println("Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		common.log("<br></br>Step :: Enter Zip.");
		System.out.println("Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		Enter_CC_Details(); // Enter CC Details

		Select_Bank_Account_Type();// Select Bank Account Type

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(30);
		common.waitForElement("//ul[@id='messages']");

		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

		common.log("<br></br>Step :: signup successful<br>");
	}

	/**
	 * Regular SignUp With Billing info Mandatory CC info Mandatory ACH Not info
	 * Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBillingInfoMandatoryCCInfoMandatoryAndACHinfoMandatory() throws InterruptedException {

		// common.waitForConditionIsElementPresent("//div[@id='" +
		// LEGACY_USER_SIGNUP_REGISTRATION_PANEL + "']");

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(40);

		String getAddressWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getAddressWarningMessage);

		String getBankAccountNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][2]")).getText();
		System.out.println("Step :: Warning Message >> " + getBankAccountNameWarningMessage);

		String getBankAccountWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][3]")).getText();
		System.out.println("Step :: Bank Account Warning Message >> " + getBankAccountWarningMessage);

		String getBankAccountTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][4]")).getText();
		System.out.println("Step :: Bank Account Type Warning Message >> " + getBankAccountTypeWarningMessage);

		String getBankNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][5]")).getText();
		System.out.println("Step :: Bank Name Warning Message >> " + getBankNameWarningMessage);

		String getBankRoutingTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][6]")).getText();
		System.out.println("Step :: Bank Routing Warning Message >> " + getBankRoutingTypeWarningMessage);

		String getSecurityCodeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][7]")).getText();
		System.out.println("Step :: Warning Message >> " + getSecurityCodeWarningMessage);

		String getExpirationDateWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][8]")).getText();
		System.out.println("Step :: Warning Message >> " + getExpirationDateWarningMessage);

		String getCCNumberWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][9]")).getText();
		System.out.println("Step :: Warning Message >> " + getCCNumberWarningMessage);

		String getCCTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][10]")).getText();

		System.out.println("Step :: Warning Message >>" + getCCTypeWarningMessage);

		String getCityWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][11]")).getText();
		System.out.println("Step :: Warning Message >> " + getCityWarningMessage);

		String getCountryWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][12]")).getText();
		System.out.println("Step :: Warning Message >> " + getCountryWarningMessage);

		String getStateWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][13]")).getText();
		System.out.println("Step :: Warning Message >> " + getStateWarningMessage);

		common.assertTwoValuesAreEqual(getCountryWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_COUNTRY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getAddressWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCityWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CITY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getStateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_STATE_ALERT_MESSAGE);

		common.assertTwoValuesAreEqual(getCCTypeWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCCNumberWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_NUMBER_ALERT_MESSAGE);

		common.assertTwoValuesAreEqual(getExpirationDateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_EXPIRY_DATE);
		common.assertTwoValuesAreEqual(getSecurityCodeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_SECURITY_CODE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankRoutingTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ROUTING_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankNameWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_BANK_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountNameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_NAME_ALERT_MESSAGE);
		Select_Counrty_and_State(); // Select Country and State

		common.log("<br></br>Step :: Enter Address.");
		System.out.println("Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		common.log("<br></br>Step :: Enter City.");
		System.out.println("Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		common.log("<br></br>Step :: Enter Zip.");
		System.out.println("Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		Enter_CC_Details(); // Enter CC Details

		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_BANK_ROUTING + "']", "123456789");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_BANK_ACCOUNT + "']", "1234554321");

		Select_Bank_Account_Type();// Select Bank Account Type

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(30);
		common.waitForElement("//ul[@id='messages']");
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

		common.log("<br></br>Step :: signup successful<br>");
	}

	/**
	 * Regular SignUp With Basic Info Mandatory Billing info Not Mandatory CC info
	 * Not Mandatory ACH info Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBasicInfoMandatoryBillingInfoNotMandatoryCCInfoNotMandatoryAndACHinfoNotMandatory()
			throws InterruptedException {

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(40);

		String getPhoneWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getPhoneWarningMessage);
		String getFirstnameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][2]")).getText();
		System.out.println("Step :: Warning Message >> " + getFirstnameWarningMessage);

		String getLastnameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][3]")).getText();
		System.out.println("Step :: Warning Message >> " + getLastnameWarningMessage);

		Select_Billing_Info_Phone_Type(); // Select Billing Phone Type

		System.out.println("Step :: Verify Assert Values");

		common.assertTwoValuesAreEqual(getFirstnameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getLastnameWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getPhoneWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CONTACT_TYPE_ALERT_MESSAGE);

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		common.log("<br></br>Step :: Billing Phone Number.");
		System.out.println("Step :: Billing Phone Number");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		Select_Counrty_and_State(); // Select State and country

		common.log("<br></br>Step :: Enter Address.");
		System.out.println("Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		common.log("<br></br>Step :: Enter City.");
		System.out.println("Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		common.log("<br></br>Step :: Enter Zip.");
		System.out.println("Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_BANK_ROUTING + "']", "123456789");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_BANK_ACCOUNT + "']", "1234554321");

		Select_Bank_Account_Type();// Select Bank Account Type

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(30);
		common.waitForElement("//ul[@id='messages']");

		common.waitForElement(By.xpath("//ul[@id='messages']"));
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

		common.log("<br></br>Step :: signup successful<br>");
	}

	/**
	 * Regular SignUp With Basic Info Not Mandatory Billing info Mandatory CC info
	 * Not Mandatory ACH info Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */

	public void RegularSignUpWithBasicInfoNotMandatoryBillingInfoMandatoryCCInfoNotMandatoryAndACHinfoNotMandatory()
			throws InterruptedException {

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(30);

		Select_Counrty_and_State(); // Select Country and State

		common.log("<br></br>Step :: Enter Address.");
		System.out.println("Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		common.log("<br></br>Step :: Enter City.");
		System.out.println("Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		common.log("<br></br>Step :: Enter Zip.");
		System.out.println("Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(30);
		common.waitForElement("//ul[@id='messages']");
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);
		common.log("<br></br>Step :: signup successful<br>");
	}

	/**
	 * Regular SignUp With Basic Info Not Mandatory Billing info Not Mandatory CC
	 * info Mandatory ACH info Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBasicInfoNotMandatoryBillingInfoNotMandatoryCCInfoMandatoryAndACHinfoNotMandatory()
			throws InterruptedException {

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(40);

		String getSecurityCodeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getSecurityCodeWarningMessage);

		String getExpirationDateWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][2]")).getText();
		System.out.println("Step :: Warning Message >> " + getExpirationDateWarningMessage);

		String getCCNumberWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][3]")).getText();
		System.out.println("Step :: Warning Message >> " + getCCNumberWarningMessage);

		String getCCTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][4]")).getText();

		System.out.println("Step :: Warning Message >>" + getCCTypeWarningMessage);
		System.out.println("Step :: Verify Assert Values");

		common.assertTwoValuesAreEqual(getCCTypeWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCCNumberWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_NUMBER_ALERT_MESSAGE);

		common.assertTwoValuesAreEqual(getExpirationDateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_EXPIRY_DATE);
		common.assertTwoValuesAreEqual(getSecurityCodeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_SECURITY_CODE_ALERT_MESSAGE);

		Select_Billing_Info_Phone_Type(); // Select Phone Type

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		common.log("<br></br>Step :: Billing Phone Number.");
		System.out.println("Step :: Billing Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		common.log("<br></br>Step :: Enter Address.");
		System.out.println("Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		common.log("<br></br>Step :: Enter City.");
		System.out.println("Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		common.log("<br></br>Step :: Enter Zip.");
		System.out.println("Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		Select_Counrty_and_State(); // Select Country and State

		Enter_CC_Details(); // Enter CC Details

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(30);
		common.waitForElement("//ul[@id='messages']");

		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);
		common.log("<br></br>Step :: signup successful<br>");
	}

	/**
	 * Regular SignUp With Basic Info Not Mandatory Billing info Not Mandatory CC
	 * info Not Mandatory ACH info Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBasicInfoNotMandatoryBillingInfoNotMandatoryCCInfoNotMandatoryAndACHinfoMandatory()
			throws InterruptedException {

		// common.waitForConditionIsElementPresent("//div[@id='" +
		// LEGACY_USER_SIGNUP_REGISTRATION_PANEL + "']");

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(30);

		String getBankAccountNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getBankAccountNameWarningMessage);

		String getBankAccountWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][2]")).getText();
		System.out.println("Step :: Bank Account Warning Message >> " + getBankAccountWarningMessage);

		String getBankAccountTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][3]")).getText();
		System.out.println("Step :: Bank Account Type Warning Message >> " + getBankAccountTypeWarningMessage);

		String getBankNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][4]")).getText();
		System.out.println("Step :: Bank Name Warning Message >> " + getBankNameWarningMessage);

		String getBankRoutingTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][5]")).getText();
		System.out.println("Step :: Bank Routing Warning Message >> " + getBankRoutingTypeWarningMessage);

		common.assertTwoValuesAreEqual(getBankRoutingTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ROUTING_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankNameWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_BANK_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountNameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_NAME_ALERT_MESSAGE);

		Select_Billing_Info_Phone_Type(); // Select Phone Type

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		common.log("<br></br>Step :: Billing Phone Number.");
		System.out.println("Step :: Billing Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		Select_Counrty_and_State(); // Select Country and State

		common.log("<br></br>Step :: Enter Address.");
		System.out.println("Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		common.log("<br></br>Step :: Enter City.");
		System.out.println("Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		common.log("<br></br>Step :: Enter Zip.");
		System.out.println("Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		Select_Bank_Account_Type(); // Select Bank Account Type

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(40);
		common.waitForElement(By.xpath("//ul[@id='messages']"));
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);
		common.log("<br></br>Step :: signup successful<br>");
	}

	/**
	 * Regular SignUp With Basic Info Mandatory Billing info Mandatory CC info Not
	 * Mandatory ACH info Not Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBasicInfoMandatoryBillingInfoMandatoryCCInfoNotMandatoryAndACHinfoNotMandatory()
			throws InterruptedException {

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(30);

		String getAddressWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getAddressWarningMessage);

		String getCityWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_5 + "'][2]")).getText();
		System.out.println("Step :: Warning Message >> " + getCityWarningMessage);

		String getContactWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][3]")).getText();
		System.out.println("Step :: Warning Message >> " + getContactWarningMessage);
		common.log("Step :: Warning Message >> " + getContactWarningMessage);

		String getCountryWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][4]")).getText();
		System.out.println("Step :: Warning Message >> " + getCountryWarningMessage);

		String getFirstnameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][5]")).getText();
		System.out.println("Step :: Warning Message >> " + getFirstnameWarningMessage);

		String getLastnameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][6]")).getText();
		System.out.println("Step :: Warning Message >> " + getLastnameWarningMessage);

		String getPhoneWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][7]")).getText();
		System.out.println("Step :: Warning Message >> " + getPhoneWarningMessage);

		String getStateWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][8]")).getText();
		System.out.println("Step :: Warning Message >> " + getStateWarningMessage);

		String getZipWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][9]")).getText();
		System.out.println("Step :: Warning Message >> " + getZipWarningMessage);

		common.assertTwoValuesAreEqual(getFirstnameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getLastnameWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getContactWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_CONTACT_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCountryWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_COUNTRY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getAddressWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCityWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CITY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getStateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_STATE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getZipWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ZIP_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getPhoneWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_PHONE_ALERT_MESSAGE);

		Select_Billing_Info_Phone_Type(); // Select Phone Type

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		common.log("<br></br>Step :: Billing Phone Number.");
		System.out.println("Step :: Billing Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		Select_Counrty_and_State(); // Select Country and State

		common.log("<br></br>Step :: Enter Address.");
		System.out.println("Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		common.log("<br></br>Step :: Enter City.");
		System.out.println("Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		common.log("<br></br>Step :: Enter Zip.");
		System.out.println("Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_BANK_ROUTING + "']", "123456789");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_BANK_ACCOUNT + "']", "1234554321");

		Select_Bank_Account_Type(); // Select Bank Account Type

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(40);
		common.waitForElement(By.xpath("//ul[@id='messages']"));
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);
		common.log("<br></br>Step :: signup successful<br>");
	}

	/**
	 * Regular SignUp With Basic Info Mandatory Billing info Not Mandatory CC info
	 * Mandatory ACH info Not Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBasicInfoMandatoryBillingInfoNotMandatoryCCInfoMandatoryAndACHinfoNotMandatory()
			throws InterruptedException {

		// common.waitForConditionIsElementPresent("//div[@id='" +
		// LEGACY_USER_SIGNUP_REGISTRATION_PANEL + "']");

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(40);

		String getSecurityCodeWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getSecurityCodeWarningMessage);

		String getExpirationDateWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][2]"))
				.getText();
		System.out.println("Step :: Warning Message >> " + getExpirationDateWarningMessage);

		String getCCNumberWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][3]")).getText();
		System.out.println("Step :: Warning Message >> " + getCCNumberWarningMessage);

		String getCCTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][4]")).getText();

		System.out.println("Step :: Warning Message >>" + getCCTypeWarningMessage);
		String getContactWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][5]")).getText();
		System.out.println("Step :: Warning Message >>" + getContactWarningMessage);
		String getFirstnameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][6]")).getText();
		System.out.println("Step :: Warning Message >> " + getFirstnameWarningMessage);

		String getLastnameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][7]")).getText();
		System.out.println("Step :: Warning Message >> " + getLastnameWarningMessage);

		String getPhoneWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][8]")).getText();
		System.out.println("Step :: Warning Message >>" + getPhoneWarningMessage);
		common.assertTwoValuesAreEqual(getFirstnameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getLastnameWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME_ALERT_MESSAGE);

		common.assertTwoValuesAreEqual(getCCTypeWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCCNumberWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_NUMBER_ALERT_MESSAGE);

		common.assertTwoValuesAreEqual(getExpirationDateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_EXPIRY_DATE);
		common.assertTwoValuesAreEqual(getSecurityCodeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_SECURITY_CODE_ALERT_MESSAGE);

		common.pause(20);

		Select_Billing_Info_Phone_Type();

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		common.log("<br></br>Step :: Billing Phone Number.");
		System.out.println("Step :: Billing Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);
		common.pause(10);

		Enter_CC_Details();

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(40);

		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

	}

	/**
	 * Regular SignUp With Basic Info Mandatory Billing info Not Mandatory CC info
	 * Not Mandatory ACH info Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBasicInfoMandatoryBillingInfoNotMandatoryCCInfoNotMandatoryAndACHinfoMandatory()
			throws InterruptedException {

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(40);

		String getBankAccountNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getBankAccountNameWarningMessage);

		String getBankAccountWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][2]")).getText();
		System.out.println("Step :: Bank Account Warning Message >> " + getBankAccountWarningMessage);

		String getBankAccountTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][3]")).getText();
		System.out.println("Step :: Bank Account Type Warning Message >> " + getBankAccountTypeWarningMessage);

		String getBankNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][4]")).getText();
		System.out.println("Step :: Bank Name Warning Message >> " + getBankNameWarningMessage);

		String getBankRoutingTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][5]")).getText();
		System.out.println("Step :: Bank Routing Warning Message >> " + getBankRoutingTypeWarningMessage);

		String getPhoneWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][6]")).getText();
		System.out.println("Step :: Warning Message >> " + getPhoneWarningMessage);

		String getFirstnameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][7]")).getText();
		System.out.println("Step :: Warning Message >> " + getFirstnameWarningMessage);

		String getLastnameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][8]")).getText();
		System.out.println("Step :: Warning Message >> " + getLastnameWarningMessage);

		common.assertTwoValuesAreEqual(getFirstnameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME_UPDATED_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getLastnameWarningMessage, LEGACY_USER_SIGNUP_Ship_TXT_LAST_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankRoutingTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ROUTING_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankNameWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_BANK_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountNameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_NAME_ALERT_MESSAGE);

		Select_Billing_Info_Phone_Type(); // Select Phone Type

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		common.log("<br></br>Step :: Billing Phone Number.");
		System.out.println("Step :: Billing Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		Select_Counrty_and_State(); // Select Country and State
		common.log("<br></br>Step :: Enter Address.");
		System.out.println("Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		common.log("<br></br>Step :: Enter City.");
		System.out.println("Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		common.log("<br></br>Step :: Enter Zip.");
		System.out.println("Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		Select_Bank_Account_Type(); // Select Bank Account Type

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(40);
		common.waitForElement(By.xpath("//ul[@id='messages']"));
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

		common.log("<br></br>Step :: signup successful<br>");
	}

	/**
	 * Regular SignUp With Basic Info Not Mandatory Billing info Mandatory CC info
	 * Mandatory ACH info Not Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void RegularSignUpWithBasicInfoNotMandatoryBillingInfoMandatoryCCInfoMandatoryAndACHinfoNotMandatory()
			throws InterruptedException {

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(40);

		String getAddressWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getAddressWarningMessage);

		String getCityWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][2]")).getText();
		System.out.println("Step :: Warning Message >> " + getCityWarningMessage);

		String getCountryWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][3]")).getText();
		System.out.println("Step :: Warning Message >> " + getCountryWarningMessage);

		String getStateWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][4]")).getText();
		System.out.println("Step :: Warning Message >> " + getStateWarningMessage);

		String getZipWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][5]")).getText();
		System.out.println("Step :: Warning Message >> " + getZipWarningMessage);

		common.assertTwoValuesAreEqual(getCountryWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_COUNTRY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getAddressWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCityWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CITY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getStateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_STATE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getZipWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ZIP_ALERT_MESSAGE);

		common.log("<br></br>Step :: Enter Address.");
		System.out.println("Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		common.log("<br></br>Step :: Enter City.");
		System.out.println("Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		Select_Counrty_and_State(); // Select Country and State from dropdown

		common.log("<br></br>Step :: Enter Zip.");
		System.out.println("Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		// Enter_CC_Details(); // Enter CC Details

		Select_Bank_Account_Type(); // Select Account Type

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(40);

		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

		common.log("<br></br>Step :: signup successful<br>");
	}

	/**
	 * Regular SignUp With Basic Info Not Mandatory Billing info Mandatory CC info
	 * Not Mandatory ACH info Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void regularSignUpWithBasicInfoNotMandatoryBillingInfoNotMandatoryCCInfoMandatoryAndACHinfoMandatory()
			throws InterruptedException {

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(40);

		String getBankAccountNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getBankAccountNameWarningMessage);

		String getBankAccountWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][2]")).getText();
		System.out.println("Step :: Bank Account Warning Message >> " + getBankAccountWarningMessage);

		String getBankAccountTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][3]")).getText();
		System.out.println("Step :: Bank Account Type Warning Message >> " + getBankAccountTypeWarningMessage);

		String getBankNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][4]")).getText();
		System.out.println("Step :: Bank Name Warning Message >> " + getBankNameWarningMessage);

		String getBankRoutingTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][5]")).getText();
		System.out.println("Step :: Bank Routing Warning Message >> " + getBankRoutingTypeWarningMessage);

		String getSecurityCodeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][6]")).getText();
		System.out.println("Step :: Warning Message >> " + getSecurityCodeWarningMessage);

		String getExpirationDateWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][7]")).getText();
		System.out.println("Step :: Warning Message >> " + getExpirationDateWarningMessage);

		String getCCNumberWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][8]")).getText();
		System.out.println("Step :: Warning Message >> " + getCCNumberWarningMessage);

		String getCCTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][9]")).getText();

		System.out.println("Step :: Warning Message >>" + getCCTypeWarningMessage);

		common.assertTwoValuesAreEqual(getCCTypeWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCCNumberWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_NUMBER_ALERT_MESSAGE);

		common.assertTwoValuesAreEqual(getExpirationDateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_EXPIRY_DATE);
		common.assertTwoValuesAreEqual(getSecurityCodeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_SECURITY_CODE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankRoutingTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ROUTING_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankNameWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_BANK_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountNameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_NAME_ALERT_MESSAGE);

		Select_Billing_Info_Phone_Type(); // Select Phone Type

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		common.log("<br></br>Step :: Billing Phone Number.");
		System.out.println("Step :: Billing Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		Select_Counrty_and_State(); // Select Country and State

		common.log("<br></br>Step :: Enter Address.");
		System.out.println("Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		common.log("<br></br>Step :: Enter City.");
		System.out.println("Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		common.log("<br></br>Step :: Enter Zip.");
		System.out.println("Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		Enter_CC_Details(); // Enter CC Details

		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_BANK_ROUTING + "']", "123456789");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_BANK_ACCOUNT + "']", "1234554321");

		Select_Bank_Account_Type(); // Select Bank Account Type

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(40);

		common.waitForElement(By.xpath("//ul[@id='messages']"));
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

		common.log("<br></br>Step :: signup successful<br>");

	}

	/**
	 * Billing info and CC info mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */

	public void regularSignupWithBillingInfoAndCCInfoMandatory() throws InterruptedException {

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(30);

		String getAddressWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getAddressWarningMessage);

		String getSecurityCodeWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][2]")).getText();
		System.out.println("Step :: Warning Message >> " + getSecurityCodeWarningMessage);

		String getExpirationDateWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][3]"))
				.getText();
		System.out.println("Step :: Warning Message >> " + getExpirationDateWarningMessage);

		String getCCNumberWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][4]")).getText();
		System.out.println("Step :: Warning Message >> " + getCCNumberWarningMessage);

		String getCCTypeWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][5]")).getText();

		System.out.println("Step :: Warning Message >>" + getCCTypeWarningMessage);

		String getCityWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][6]")).getText();
		System.out.println("Step :: Warning Message >> " + getCityWarningMessage);

		String getCountryWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][7]")).getText();
		System.out.println("Step :: Warning Message >> " + getCountryWarningMessage);

		String getStateWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][8]")).getText();
		System.out.println("Step :: Warning Message >> " + getStateWarningMessage);

		String getZipWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][9]")).getText();
		System.out.println("Step :: Warning Message >> " + getZipWarningMessage);
		System.out.println(":: Verify Alert Message ::");

		common.assertTwoValuesAreEqual(getCCTypeWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCCNumberWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_NUMBER_ALERT_MESSAGE);

		common.assertTwoValuesAreEqual(getExpirationDateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_EXPIRY_DATE);
		common.assertTwoValuesAreEqual(getSecurityCodeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_SECURITY_CODE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCountryWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_COUNTRY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getAddressWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCityWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CITY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getStateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_STATE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getZipWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ZIP_ALERT_MESSAGE);

		// Select_User_Info_Phone_Type(); // Select Phone Type

		common.log("<br></br>Step :: Enter Address.");
		System.out.println("Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		common.log("<br></br>Step :: Enter City.");
		System.out.println("Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		Select_Counrty_and_State(); // Select Country and State from dropdown

		common.log("<br></br>Step :: Enter Zip.");
		System.out.println("Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		Enter_CC_Details();

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(40);
		common.waitForElement(net.thucydides.core.annotations.findby.By.xpath("//ul[@id='messages']"));
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);
	}

	/**
	 * Regular SignUp With Basic Info Mandatory Billing info CC info Mandatory ACH
	 * info Not Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void RegularSignUpWithBasicInfoMandatoryBillingInfoMandatoryCCInfoMandatoryAndACHinfoNotMandatory()
			throws InterruptedException {

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(40);

		String getAddressWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][1]")).getText();
		System.out.println("Step :: Warning Messsage >> " + getAddressWarningMessage);

		String getSecurityCodeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][2]")).getText();
		System.out.println("Step :: Warning Message >> " + getSecurityCodeWarningMessage);

		String getExpirationDateWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][3]")).getText();
		System.out.println("Step :: Warning Message >> " + getExpirationDateWarningMessage);

		String getCCNumberWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][4]")).getText();
		System.out.println("Step :: Warning Message >> " + getCCNumberWarningMessage);

		String getCCTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][5]")).getText();

		System.out.println("Step :: Warning Message >>" + getCCTypeWarningMessage);

		String getCityWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_5 + "'][6]")).getText();
		System.out.println("Step :: Warning Messsage >> " + getCityWarningMessage);

		String getContactWarningMessage = driver.findElement(

				By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][7]")).getText();
		System.out.println("Step :: Warning Messsage >> " + getContactWarningMessage);
		String getCountryWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][8]")).getText();
		System.out.println("Step :: Warning Messsage >> " + getCountryWarningMessage);

		String getFirstnameWarningMessage = driver.findElement(

				By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][9]")).getText();
		System.out.println("Step :: Warning Messsage >> " + getFirstnameWarningMessage);

		String getLastnamerWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][10]")).getText();
		System.out.println("Step :: Warning Messsage >> " + getLastnamerWarningMessage);

		String getPhoneWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][11]")).getText();
		System.out.println("Step :: Warning Messsage >> " + getPhoneWarningMessage);

		String getStateWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][12]")).getText();
		System.out.println("Step :: Warning Messsage >> " + getStateWarningMessage);

		String getZipWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][13]")).getText();
		System.out.println("Step :: Warning Messsage >> " + getZipWarningMessage);

		// common.assertTwoValuesAreEqual(getContactTypeWarningMessage,
		// "Required");
		common.assertTwoValuesAreEqual(getFirstnameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME_ALERT_MESSAGE);

		common.assertTwoValuesAreEqual(getLastnamerWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME_ALERT_MESSAGE);

		common.assertTwoValuesAreEqual(getCountryWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_COUNTRY_ALERT_MESSAGE);

		common.assertTwoValuesAreEqual(getAddressWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_ALERT_MESSAGE);

		common.assertTwoValuesAreEqual(getCityWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CITY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getStateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_STATE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getZipWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ZIP_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCCTypeWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_TYPE_ALERT_MESSAGE);

		common.assertTwoValuesAreEqual(getCCNumberWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_NUMBER_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getExpirationDateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_EXPIRY_DATE);

		Select_Billing_Info_Phone_Type();

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		common.log("<br></br>Step :: Billing Phone Number.");
		System.out.println("Step :: Billing Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		Select_Counrty_and_State();

		common.log("<br></br>Step :: Enter Address.");
		System.out.println("Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		common.log("<br></br>Step :: Enter City.");
		System.out.println("Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		common.log("<br></br>Step :: Enter Zip.");
		System.out.println("Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);
		common.pause(10);

		Enter_CC_Details();
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_SECURITY_CODE + "']", "123");

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(40);

		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

	}

	/**
	 * Regular SignUp With Basic Info Mandatory Billing info CC info Not Mandatory
	 * ACH info Mandatory
	 * 
	 * @throws InterruptedException
	 */
	public void regularSignUpWithBasicInfoMandatoryBillingInfoMandatoryCCInfoNotMandatoryAndACHinfoMandatory()
			throws InterruptedException {

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(40);

		String getAddressWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getAddressWarningMessage);

		String getBankAccountNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][2]")).getText();
		System.out.println("Step :: Warning Message >> " + getBankAccountNameWarningMessage);

		String getBankAccountWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][3]")).getText();
		System.out.println("Step :: Bank Account Warning Message >> " + getBankAccountWarningMessage);

		String getBankAccountTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][4]")).getText();
		System.out.println("Step :: Bank Account Type Warning Message >> " + getBankAccountTypeWarningMessage);

		String getBankNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][5]")).getText();
		System.out.println("Step :: Bank Name Warning Message >> " + getBankNameWarningMessage);

		String getBankRoutingTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][6]")).getText();
		System.out.println("Step :: Bank Routing Warning Message >> " + getBankRoutingTypeWarningMessage);

		String getCityWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][7]")).getText();
		System.out.println("Step :: Warning Message >> " + getCityWarningMessage);

		String getContactpWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][8]")).getText();
		System.out.println("Step :: Warning Message >> " + getContactpWarningMessage);

		String getCountryWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][9]")).getText();
		System.out.println("Step :: Warning Message >> " + getCountryWarningMessage);

		String getFirstnameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][10]")).getText();
		System.out.println("Step :: Warning Message >> " + getFirstnameWarningMessage);

		String getLastnameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][11]")).getText();
		System.out.println("Step :: Warning Message >> " + getLastnameWarningMessage);

		String getPhoneWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][12]")).getText();
		System.out.println("Step :: Warning Message >> " + getPhoneWarningMessage);

		String getStateWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][13]")).getText();
		System.out.println("Step :: Warning Message >> " + getStateWarningMessage);

		common.assertTwoValuesAreEqual(getFirstnameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME_UPDATED_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getLastnameWarningMessage, LEGACY_USER_SIGNUP_Ship_TXT_LAST_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCountryWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_COUNTRY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getAddressWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCityWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CITY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getStateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_STATE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getContactpWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_CONTACT_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankRoutingTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ROUTING_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankNameWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_BANK_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountNameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_NAME_ALERT_MESSAGE);

		Select_Billing_Info_Phone_Type(); // Select Phone Type

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		common.log("<br></br>Step :: Billing Phone Number.");
		System.out.println("Step :: Billing Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		Select_Counrty_and_State(); // Select Country and State

		common.log("<br></br>Step :: Enter Address.");
		System.out.println("Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		common.log("<br></br>Step :: Enter City.");
		System.out.println("Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		common.log("<br></br>Step :: Enter Zip.");
		System.out.println("Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_BANK_ROUTING + "']", "123456789");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_BANK_ACCOUNT + "']", "1234554321");

		Select_Bank_Account_Type(); // Select Bank Account

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(40);

		common.waitForElement(By.xpath("//ul[@id='messages']"));
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

		common.log("<br></br>Step :: signup successful<br>");
	}

	/**
	 * Regular SignUp With Basic Info Mandatory Billing info Not Mandatory CC info
	 * Mandatory ACH info Mandatory
	 * 
	 * @throws InterruptedException
	 */
	public void regularSignUpWithBasicInfoMandatoryBillingInfoNotMandatoryCCInfoMandatoryAndACHinfoMandatory()
			throws InterruptedException {

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(40);

		String getBankAccountNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getBankAccountNameWarningMessage);

		String getBankAccountWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][2]")).getText();
		System.out.println("Step :: Bank Account Warning Message >> " + getBankAccountWarningMessage);

		String getBankAccountTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][3]")).getText();
		System.out.println("Step :: Bank Account Type Warning Message >> " + getBankAccountTypeWarningMessage);

		String getBankNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][4]")).getText();
		System.out.println("Step :: Bank Name Warning Message >> " + getBankNameWarningMessage);

		String getBankRoutingTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][5]")).getText();
		System.out.println("Step :: Bank Routing Warning Message >> " + getBankRoutingTypeWarningMessage);

		String getSecurityCodeWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][6]")).getText();
		System.out.println("Step :: Warning Message >> " + getSecurityCodeWarningMessage);

		String getExpirationDateWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][7]"))
				.getText();
		System.out.println("Step :: Warning Message >> " + getExpirationDateWarningMessage);

		String getCCNumberWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][8]")).getText();
		System.out.println("Step :: Warning Message >> " + getCCNumberWarningMessage);

		String getCCTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][9]")).getText();

		System.out.println("Step :: Warning Message >>" + getCCTypeWarningMessage);

		String getPhoneWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][10]")).getText();
		System.out.println("Step :: Warning Message >> " + getPhoneWarningMessage);

		String getFirstnameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][11]")).getText();
		System.out.println("Step :: Warning Message >> " + getFirstnameWarningMessage);

		String getLastnameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][12]")).getText();
		System.out.println("Step :: Warning Message >> " + getLastnameWarningMessage);

		System.out.println("Step :: Verify Assert Values");

		common.assertTwoValuesAreEqual(getFirstnameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME_UPDATED_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getLastnameWarningMessage, LEGACY_USER_SIGNUP_Ship_TXT_LAST_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCCTypeWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCCNumberWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_NUMBER_ALERT_MESSAGE);

		common.assertTwoValuesAreEqual(getExpirationDateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_EXPIRY_DATE);
		common.assertTwoValuesAreEqual(getSecurityCodeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_SECURITY_CODE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankRoutingTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ROUTING_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankNameWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_BANK_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountNameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getPhoneWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CONTACT_TYPE_ALERT_MESSAGE);

		Select_Billing_Info_Phone_Type(); // Select Phone Type

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		common.log("<br></br>Step :: Billing Phone Number.");
		System.out.println("Step :: Billing Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		Select_Counrty_and_State(); // Select Country and State

		common.log("<br></br>Step :: Enter Address.");
		System.out.println("Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		common.log("<br></br>Step :: Enter City.");
		System.out.println("Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		common.log("<br></br>Step :: Enter Zip.");
		System.out.println("Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		Enter_CC_Details(); // Enter CC Details

		Select_Bank_Account_Type(); // Select Bank Account

		common.log("<br></br>Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(40);

		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

		common.log("<br></br>Step :: signup successful<br>");
	}

	/**
	 * Regular SignUp With Basic Info Not Mandatory Billing info Mandatory CC info
	 * Mandatory ACH info Mandatory
	 * 
	 * @throws InterruptedException
	 */
	public void regularSignUpWithBasicInfoNotMandatoryBillingInfoMandatoryCCInfoMandatoryAndACHinfoMandatory()
			throws InterruptedException {

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(40);

		String getAddressWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getAddressWarningMessage);

		String getBankAccountNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][2]")).getText();
		System.out.println("Step :: Warning Message >> " + getBankAccountNameWarningMessage);

		String getBankAccountWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][3]")).getText();
		System.out.println("Step :: Bank Account Warning Message >> " + getBankAccountWarningMessage);

		String getBankAccountTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][4]")).getText();
		System.out.println("Step :: Bank Account Type Warning Message >> " + getBankAccountTypeWarningMessage);

		String getBankNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][5]")).getText();
		System.out.println("Step :: Bank Name Warning Message >> " + getBankNameWarningMessage);

		String getBankRoutingTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][6]")).getText();
		System.out.println("Step :: Bank Routing Warning Message >> " + getBankRoutingTypeWarningMessage);

		String getSecurityCodeWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][7]")).getText();
		System.out.println("Step :: Warning Message >> " + getSecurityCodeWarningMessage);

		String getExpirationDateWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][8]"))
				.getText();
		System.out.println("Step :: Warning Message >> " + getExpirationDateWarningMessage);

		String getCCNumberWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][9]")).getText();
		System.out.println("Step :: Warning Message >> " + getCCNumberWarningMessage);

		String getCCTypeWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][10]")).getText();

		System.out.println("Step :: Warning Message >>" + getCCTypeWarningMessage);

		String getCityWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][11]")).getText();
		System.out.println("Step :: Warning Message >> " + getCityWarningMessage);

		String getCountryWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][12]")).getText();
		System.out.println("Step :: Warning Message >> " + getCountryWarningMessage);

		String getStateWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][13]")).getText();
		System.out.println("Step :: Warning Message >> " + getStateWarningMessage);

		String getZipWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][14]")).getText();
		System.out.println("Step :: Warning Message >> " + getZipWarningMessage);

		System.out.println("Step :: Verify Assert Values");

		common.assertTwoValuesAreEqual(getCountryWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_COUNTRY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getAddressWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCityWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CITY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getStateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_STATE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getZipWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ZIP_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCCTypeWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCCNumberWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_NUMBER_ALERT_MESSAGE);

		common.assertTwoValuesAreEqual(getExpirationDateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_EXPIRY_DATE);
		common.assertTwoValuesAreEqual(getSecurityCodeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_SECURITY_CODE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankRoutingTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ROUTING_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankNameWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_BANK_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountNameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_NAME_ALERT_MESSAGE);

		Select_Billing_Info_Phone_Type(); // Select Phone Type

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		common.log("<br></br>Step :: Billing Phone Number.");
		System.out.println("Step :: Billing Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		Select_Counrty_and_State(); // Select Country and State

		Enter_CC_Details(); // Enter CC Details

		Select_Bank_Account_Type(); // Select Bank Account Type

		common.log("<br></br>Step :: Enter Address.");
		System.out.println("Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		common.log("<br></br>Step :: Enter City.");
		System.out.println("Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		common.log("<br></br>Step :: Enter Zip.");
		System.out.println("Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(40);

		common.waitForElement(By.xpath("//ul[@id='messages']"));
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

		common.log("<br></br>Step :: signup successful<br>");
	}

	/**
	 * Verify Email And Confirmation Email With Account Not Verified
	 * 
	 * @throws InterruptedException
	 */
	public String verifyEmailAndConfirmEmailWithAccountNotVerified(String username) throws InterruptedException {

		common.pause(20);
		System.out.println("Step :: Admin logout front");
		common.log("<br></br> Step :: Admin logout front");

		common.pause(25);

		common.jsClick(signUpLink);

		System.out.println("SignupUser Details");
		common.log("SignupUser Details");

		String EmailUser = common.generateRandomChars(6);

		common.pause(40);

		common.log("<br></br> Step :: SignupUSer Details.");
		System.out.println(" Step :: SignupUSer Details.");
		common.waitForConditionIsElementPresent(("//a"));

		String signUpUser = common.generateRandomChars(6);

		common.log("<br></br> Step :: Enter User Name");
		System.out.println(" Step :: Enter User Name");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']", username);

		common.log("<br></br> Step :: Enter Password");
		System.out.println(" Step :: Enter Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PASSWORD + "']", LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);
		System.out.println("Step :: Random Value :" + signUpUser);
		common.log("<br></br>Step :: Random Value :" + signUpUser);

		common.log("<br></br> Step :: Enter Confirm Password");
		System.out.println(" Step :: Enter Confirm Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_FIRST_NAME + "']", signUpUser);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_LAST_NAME + "']", signUpUser);

		common.log("<br></br> Step :: Enter Email");
		System.out.println(" Step :: Enter Email");
		System.out.println("New User >>" + "  " + username);

		common.log("<br></br> Step :: Enter First Name.");
		System.out.println(" Step :: Enter First Name.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']", username);

		common.log("<br></br> Step :: Enter Last Name.");
		System.out.println(" Step :: Enter Last Name.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_PASSWORD + "']",
				LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);

		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_EMAIL + "']",
				EmailUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);

		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_EMAIL + "']",
				EmailUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);

		// common.jsClick(editBoxOfPhone);

		System.out.println("Enter Phone Number...");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		Select_User_Info_Phone_Type(); // Select Phone Type

		Select_Identification_Type(); // Select Identification Type

		enterBillInfo(signUpUser);

		common.pause(25);
		common.waitForElement(By.xpath("//ul[@id='messages']"));
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

		common.log("<br></br>Step :: signup successful<br>");
		System.out.println("User Name >> " + username);
		return username;

	}

	/**
	 * Regular SignUp With Basic Info Mandatory Billing info Mandatory CC info
	 * Mandatory ACH info Mandatory
	 * 
	 * @throws InterruptedException
	 */
	public void RegularSignUpWithBasicInfoMandatoryBillingInfoMandatoryCCInfoMandatoryAndACHinfoMandatory()
			throws InterruptedException {

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(40);

		String getAddressWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getAddressWarningMessage);

		String getBankAccountNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][2]")).getText();
		System.out.println("Step :: Warning Message >> " + getBankAccountNameWarningMessage);

		String getBankAccountWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][3]")).getText();
		System.out.println("Step :: Bank Account Warning Message >> " + getBankAccountWarningMessage);

		String getBankAccountTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][4]")).getText();
		System.out.println("Step :: Bank Account Type Warning Message >> " + getBankAccountTypeWarningMessage);

		String getBankNameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][5]")).getText();
		System.out.println("Step :: Bank Name Warning Message >> " + getBankNameWarningMessage);

		String getBankRoutingTypeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][6]")).getText();
		System.out.println("Step :: Bank Routing Warning Message >> " + getBankRoutingTypeWarningMessage);

		String getSecurityCodeWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][7]")).getText();
		System.out.println("Step :: Warning Message >> " + getSecurityCodeWarningMessage);

		String getExpirationDateWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][8]"))
				.getText();
		System.out.println("Step :: Warning Message >> " + getExpirationDateWarningMessage);

		String getCCNumberWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][9]")).getText();
		System.out.println("Step :: Warning Message >> " + getCCNumberWarningMessage);

		String getCCTypeWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][10]")).getText();

		System.out.println("Step :: Warning Message >>" + getCCTypeWarningMessage);

		String getCityWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_5 + "'][11]")).getText();
		System.out.println("Step :: Warning Message >> " + getCityWarningMessage);

		String getContactWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][12]")).getText();
		System.out.println("Step :: Warning Message >> " + getContactWarningMessage);
		String getCountryWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][13]")).getText();
		System.out.println("Step :: Warning Message >> " + getCountryWarningMessage);

		String getFirstnameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][14]")).getText();
		System.out.println("Step :: Warning Message >> " + getFirstnameWarningMessage);

		String getLastnameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][15]")).getText();
		System.out.println("Step :: Warning Message >> " + getLastnameWarningMessage);

		String getPhoneWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][16]")).getText();
		System.out.println("Step :: Warning Message >> " + getPhoneWarningMessage);

		String getStateWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles'][17]")).getText();
		System.out.println("Step :: Warning Message >> " + getStateWarningMessage);

		common.assertTwoValuesAreEqual(getFirstnameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME_UPDATED_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getLastnameWarningMessage, LEGACY_USER_SIGNUP_Ship_TXT_LAST_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCountryWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_COUNTRY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getAddressWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCityWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CITY_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getStateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_STATE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getContactWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_CONTACT_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getPhoneWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_PHONE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankRoutingTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ROUTING_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountTypeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankNameWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_BANK_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getBankAccountNameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_BANK_ACCOUNT_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCCTypeWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_TYPE_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getCCNumberWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_NUMBER_ALERT_MESSAGE);

		common.assertTwoValuesAreEqual(getExpirationDateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_EXPIRY_DATE);
		common.assertTwoValuesAreEqual(getSecurityCodeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_SECURITY_CODE_ALERT_MESSAGE);

		Select_Billing_Info_Phone_Type(); // Select Phone Type

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		common.log("<br></br>Step :: Billing Phone Number.");
		System.out.println("Step :: Billing Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		Select_Counrty_and_State(); // Select Country and State

		common.log("<br></br>Step :: Enter Address.");
		System.out.println("Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		common.log("<br></br>Step :: Enter City.");
		System.out.println("Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		common.log("<br></br>Step :: Enter Zip.");
		System.out.println("Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		Enter_CC_Details(); // Enter CC Details

		Select_Bank_Account_Type(); // Select Bank Account Type

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(40);

		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

		common.log("<br></br>Step :: signup successful<br>");

	}

	/**
	 * Verify Email And Confirmation Email With Account Not Verified And Confirm
	 * Email Does Not Match
	 * 
	 * @throws InterruptedException
	 */
	public void verifyEmailAndConfirmEmailWithAccountNotVerifiedAndConfirmEmailDoesNotMatch()
			throws InterruptedException {

		common.pause(20);
		System.out.println("Step :: Admin logout front");
		common.log("<br></br> Step :: Admin logout front");

		common.pause(25);

		common.jsClick(signUpLink);

		System.out.println("Step :: SignupUser Details");
		common.log("<br></br>Step :: SignupUser Details");

		String FistName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);

		common.pause(40);

		common.log("<br></br> Step :: SignupUSer Details.");
		System.out.println(" Step :: SignupUSer Details.");
		common.waitForConditionIsElementPresent(("//a"));

		String signUpUser = common.generateRandomChars(6);

		System.out.println("Step :: Enter Username ::" + signUpUser);
		common.log("<br></br>Step :: Enter New User");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']", signUpUser);

		common.log("<br></br>Step :: Random Value :: " + signUpUser);
		System.out.println("Step :: Random Value :: " + signUpUser);

		System.out.println("Step :: Enter First Name");
		common.log("<br></br> Step :: Enter First Name");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_FIRST_NAME + "']", signUpUser);

		System.out.println("Step :: Enter Last Name");
		common.log("<br></br> Step :: Enter Last Name");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_LAST_NAME + "']", signUpUser);

		System.out.println("Step :: New User >>" + "  " + signUpUser);
		common.log("<br></br>Step : New User >>" + "  " + signUpUser);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']", signUpUser);

		System.out.println("Step :: Enter Password");
		common.log("<br></br> Step :: Enter Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PASSWORD + "']", LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);

		System.out.println("Step :: Enter Confirm Password");
		common.log("<br></br> Step :: Enter Confirm Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_PASSWORD + "']",
				LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);

		System.out.println("Step :: Enter EmailUser :: " + EmailUser);
		common.log("<br></br>Step :: Enter EmailUser :: " + EmailUser);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_EMAIL + "']",
				EmailUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);
		common.pause(20);

		// common.jsClick(editBoxOfPhone);

		System.out.println("Enter Phone Number...");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		Select_User_Info_Phone_Type(); // Select Phone Type

		Select_Identification_Type(); // Select Identificaion Type

		common.pause(5);

		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_EMAIL + "']",
				signUpUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);

		common.pause(5);

		enterBillInfo(signUpUser);

		common.pause(20);
		common.log("<br></br>Step :: Verify Email Warning Message.");
		System.out.println("Step :: Verify Email Warning Message");

		String emailnotmatch = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + emailnotmatch);

//		String confirmemailnotmatch = driver
//				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][2]")).getText();
//		System.out.println("Step :: Warning Message >> " + confirmemailnotmatch);

		System.out.println("Step :: Verify Assert Message");

		common.assertTwoValuesAreEqual(emailnotmatch, LEGACY_USER_SIGNUP_TXT_EMAIL_NOT_MATCH_ALERT);

	}

	/**
	 * Verify Email And Confirmation Email With Account Not Verified And Confirm
	 * Email Does Not Match
	 * 
	 * Verified Email Upon Account Registration
	 * 
	 * @throws InterruptedException
	 */
	public void verifyEmailAndConfirmEmailWithAccountNotVerifiedAndConfirmEmailDoesNotMatchVerifiedEmailUponAccountRegistrationChecked()
			throws InterruptedException {

		common.pause(20);
		System.out.println("Step :: Admin logout front");
		common.log("<br></br> Step :: Admin logout front");

		common.pause(25);

		common.jsClick(signUpLink);

		System.out.println("Step :: SignupUser Details");
		common.log("<br></br>Step :: SignupUser Details");

		String FistName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);

		common.pause(40);

		common.log("<br></br> Step :: SignupUSer Details.");
		System.out.println(" Step :: SignupUSer Details.");
		common.waitForConditionIsElementPresent(("//a"));

		String signUpUser = common.generateRandomChars(6);

		System.out.println("Step :: Enter Username ::" + signUpUser);
		common.log("<br></br>Step :: Enter New User");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']", signUpUser);

		common.log("<br></br>Step :: Random Value :: " + signUpUser);
		System.out.println("Step :: Random Value :: " + signUpUser);

		System.out.println("Step :: Enter First Name");
		common.log("<br></br> Step :: Enter First Name");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_FIRST_NAME + "']", signUpUser);

		System.out.println("Step :: Enter Last Name");
		common.log("<br></br> Step :: Enter Last Name");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_LAST_NAME + "']", signUpUser);

		System.out.println("Step :: New User >>" + "  " + signUpUser);
		common.log("<br></br>Step : New User >>" + "  " + signUpUser);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']", signUpUser);

		System.out.println("Step :: Enter Password");
		common.log("<br></br> Step :: Enter Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PASSWORD + "']", LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);

		System.out.println("Step :: Enter Confirm Password");
		common.log("<br></br> Step :: Enter Confirm Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_PASSWORD + "']",
				LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);

		System.out.println("Step :: Enter EmailUser :: " + EmailUser);
		common.log("<br></br>Step :: Enter EmailUser :: " + EmailUser);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_EMAIL + "']",
				EmailUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);
		common.pause(20);

		System.out.println("Step :: Enter Confirm Email :: " + EmailUser);
		common.log("<br></br>Step :: Enter Confirm Email :: " + EmailUser);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_EMAIL + "']",
				signUpUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);

		System.out.println("Enter Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		Select_User_Info_Phone_Type(); // Select Phone Type

		Select_Identification_Type(); // Select Identification Type

		common.pause(5);

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(30);

		common.log("<br></br>Step :: Verify Email Warning Message.");
		System.out.println("Step :: Verify Email Warning Message");

		String emailnotmatch = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + emailnotmatch);

//		String confirmemailnotmatch = driver
//				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][2]")).getText();
//		System.out.println("Step :: Warning Message >> " + confirmemailnotmatch);

		System.out.println("Step :: Verify Assert Message");

		common.assertTwoValuesAreEqual(emailnotmatch, LEGACY_USER_SIGNUP_TXT_EMAIL_NOT_MATCH_ALERT);

		// common.assertTwoValuesAreEqual(confirmemailnotmatch,
		// LEGACY_USER_SIGNUP_TXT_CONFIRM_EMAIL_DO_NOT_MATCH);

	}

	/**
	 * Verify Email With Require CreditCard On Signup Active
	 * 
	 * @throws InterruptedException
	 */
	public void verifyemailWithRequireCreditCardOnSignUpActive() throws InterruptedException {

		common.pause(20);
		System.out.println("Step :: Admin logout front");
		common.log("<br></br> Step :: Admin logout front");

		common.pause(25);
		common.jsClick(signUpLink);

		System.out.println("Step :: SignupUser Details");
		common.log("<br></br>Step :: SignupUser Details");

		String FistName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);

		common.pause(40);

		common.log("<br></br> Step :: SignupUSer Details.");
		System.out.println(" Step :: SignupUSer Details.");
		common.waitForConditionIsElementPresent(("//a"));

		String signUpUser = common.generateRandomChars(6);

		System.out.println("Step :: Enter Username ::" + signUpUser);
		common.log("<br></br>Step :: Enter New User");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']", signUpUser);

		common.log("<br></br>Step :: Random Value :: " + signUpUser);
		System.out.println("Step :: Random Value :: " + signUpUser);

		System.out.println("Step :: Enter First Name");
		common.log("<br></br> Step :: Enter First Name");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_FIRST_NAME + "']", signUpUser);

		System.out.println("Step :: Enter Last Name");
		common.log("<br></br> Step :: Enter Last Name");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_LAST_NAME + "']", signUpUser);

		System.out.println("Step :: New User >>" + "  " + signUpUser);
		common.log("<br></br>Step : New User >>" + "  " + signUpUser);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']", signUpUser);

		System.out.println("Step :: Enter Password");
		common.log("<br></br> Step :: Enter Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PASSWORD + "']", LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);

		System.out.println("Step :: Enter Confirm Password");
		common.log("<br></br> Step :: Enter Confirm Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_PASSWORD + "']",
				LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);

		System.out.println("Step :: Enter EmailUser :: " + EmailUser);
		common.log("<br></br>Step :: Enter EmailUser :: " + EmailUser);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_EMAIL + "']",
				EmailUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);
		common.pause(20);

		if (common.isElementPresent("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_EMAIL + "']"))

		{
			System.out.println("Step :: Enter Confim Email :: " + EmailUser);
			common.log("<br></br>Step :: Enter Confirm Email :: " + EmailUser);
			common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_EMAIL + "']",
					EmailUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);
		}

		else {
			System.out.println("Step :: Enter Confim Email is not display");
		}

		System.out.println("Enter Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		Select_User_Info_Phone_Type(); // Select Phone Type

		Select_Identification_Type(); // Select Identification type

		common.pause(5);

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(10);

	}

	/**
	 * Verify Email With Require CreditCard On Signup Active And Expired CC
	 * 
	 * @throws InterruptedException
	 */
	public void verifyEmailWithRequireCreditCardOnSignUpActiveAndExpiredCC() throws InterruptedException {

		common.pause(20);
		System.out.println("Step :: Admin logout front");
		common.log("<br></br> Step :: Admin logout front");

		common.pause(25);
		common.jsClick(signUpLink);

		common.log("<br></br>Step :: SignupUser Details");
		System.out.println("Step :: SignupUser Details");
		String FistName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);

		common.pause(40);

		common.log("<br></br> Step :: SignupUSer Details.");
		System.out.println(" Step :: SignupUSer Details.");
		common.waitForConditionIsElementPresent(("//a"));

		String signUpUser = common.generateRandomChars(6);

		common.log("<br></br> Step :: Enter User Name");
		System.out.println(" Step :: Enter User Name");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']", signUpUser);

		common.log("<br></br> Step :: Enter Password");
		System.out.println(" Step :: Enter Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PASSWORD + "']", LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);
		System.out.println("Step :: Random Value :" + signUpUser);
		common.log("<br></br>Step :: Random Value :" + signUpUser);

		common.log("<br></br> Step :: Enter Confirm Password");
		System.out.println(" Step :: Enter Confirm Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_FIRST_NAME + "']", signUpUser);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_LAST_NAME + "']", signUpUser);

		common.log("<br></br> Step :: Enter Email");
		System.out.println(" Step :: Enter Email");
		System.out.println("New User >>" + "  " + signUpUser);

		common.log("<br></br> Step :: Enter First Name.");
		System.out.println(" Step :: Enter First Name.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']", signUpUser);

		common.log("<br></br> Step :: Enter Last Name.");
		System.out.println(" Step :: Enter Last Name.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_PASSWORD + "']",
				LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_EMAIL + "']",
				EmailUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);

		System.out.println("Enter Phone Number...");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		Select_User_Info_Phone_Type();

		Select_Identification_Type();

		common.pause(5);

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(5);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(30);
//		common.waitForElement("//ul[@id='messages']");
//
//		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
//		System.out.println("Application messsage display :: " + str_confirmation);

		System.out.println("Step :: Expiration CC has a BUG");
		common.log("<br></br>Step :: Expiration CC has a BUG.");

		common.log("<br></br>Step ::  signup not successful"
				+ "expired CC error message is displayed in red next to the CC expiration date field");
		System.out.println("Step :: signup not successful"
				+ "expired CC error message is displayed in red next to the CC expiration date field");

	}

	/**
	 * Verify Email With Require CreditCard On Signup Active And Requried Error
	 * Message Is Displayed In Red Next To All The CC Fields.
	 * 
	 * @throws InterruptedException
	 */
	public void verifyemailWithRequireCreditCardOnRequiredErrorMessageIsDisplayedInRedNextToAllTheCCFieldss()
			throws InterruptedException {
		common.pause(20);
		System.out.println("Step :: Admin logout front");
		common.log("<br></br> Step :: Admin logout front");

		common.pause(25);
		common.jsClick(signUpLink);

		common.log("<br></br>Step :: SignupUser Details");
		System.out.println("Step :: SignupUser Details");
		String FistName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);

		common.pause(4);

		common.log("<br></br> Step :: SignupUSer Details.");
		System.out.println(" Step :: SignupUSer Details.");
		common.waitForConditionIsElementPresent(("//a"));

		String signUpUser = common.generateRandomChars(6);

		common.log("<br></br> Step :: Enter User Name");
		System.out.println(" Step :: Enter User Name");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']", signUpUser);

		common.log("<br></br> Step :: Enter Password");
		System.out.println(" Step :: Enter Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PASSWORD + "']", LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);
		System.out.println("Step :: Random Value :" + signUpUser);
		common.log("<br></br>Step :: Random Value :" + signUpUser);

		common.log("<br></br> Step :: Enter Confirm Password");
		System.out.println(" Step :: Enter Confirm Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_FIRST_NAME + "']", signUpUser);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_LAST_NAME + "']", signUpUser);

		common.log("<br></br> Step :: Enter Email");
		System.out.println(" Step :: Enter Email");
		System.out.println("New User >>" + "  " + signUpUser);

		common.log("<br></br> Step :: Enter First Name.");
		System.out.println(" Step :: Enter First Name.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']", signUpUser);

		common.log("<br></br> Step :: Enter Last Name.");
		System.out.println(" Step :: Enter Last Name.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_PASSWORD + "']",
				LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_EMAIL + "']",
				EmailUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);
		// common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_EMAIL +
		// "']", EmailUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);

		// common.jsClick(editBoxOfPhone);

		System.out.println("Enter Phone Number...");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		common.log("<br></br>Step :: Phone Type.");
		System.out.println("Step :: Phone Type.");
		String PhoneType = "Work";
		WebElement option = selectNew.findElement(By.xpath("//span[@id='" + LEGACY_USER_SIGNUP_TXT_PHONE_TYPE
				+ "']//option[contains(text(),'" + PhoneType + "')]"));

		System.out.println("Step :: Phone Type >>> " + PhoneType);
		common.log("<br></br>Step :: Phone Type >>> " + PhoneType);
		option.click();

//		 System.out.println("Step :: Enter Company name");
//		 common.log("<br></br>Step :: Enter Company name.");
//		 common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_COMPANY + "']",
//		 LEGACY_USER_SIGNUP_TXT_COMPANY_VALUE);

		System.out.println("Step :: Identification Type.");
		common.log("<br></br>Step :: Identification Type.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_IDENTIFICATION + "']",
				LEGACY_USER_SIGNUP_TXT_IDENTIFICATION_VALUE);

		String IdentificationType = "2";
		WebElement identificationoption = identificationtype.findElement(By.xpath("//span[@id='"
				+ LEGACY_USER_SIGNUP_LST_IDENTIFICATION_TYPE + "']//option[@value='" + IdentificationType + "']"));

		System.out.println("Step :: Identification Type >>> " + IdentificationType);
		common.log("<br></br>Step :: Identification Type >>> " + IdentificationType);
		identificationoption.click();

		common.pause(5);

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		common.log("<br></br>Step :: Entering Phone Number.");
		System.out.println("Step :: Enter Phone Number...");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		common.log("<br></br>Step :: Select Country.");
		System.out.println("Step :: Select Country.");
		String Country = "United States";
		WebElement country = countryselection.findElement(By.xpath("//span[@id='" + LEGACY_USER_SIGNUP_BILL_LST_COUNTRY
				+ "']//option[contains(text(),'" + Country + "')]"));
		country.click();

		common.log("<br></br>Step :: Enter Address.");
		System.out.println("Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		common.log("<br></br>Step :: Enter City.");
		System.out.println("Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		String State = "California";

		common.log("<br></br>Step :: State.");
		System.out.println("Step :: State.");
		WebElement state = countryselection.findElement(By.xpath(
				"//span[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_STATE + "']//option[contains(text(),'" + State + "')]"));
		state.click();

		common.log("<br></br>Step :: Enter Zip.");
		System.out.println("Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		common.log("<br></br>Step :: Click on Same as billing check box.");
		System.out.println("Step :: Click on Same as billing check box.");
		common.checkChkBox(ship);
		common.pause(5);

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(20);

		// Verify Required Fields
		common.waitForConditionIsElementPresent(
				"//span[@id='" + LEGACY_USER_SIGNUP_LST_CC_TYPE_WARNING_MESSAGE + "']//span");

		String getCCTypeWarningMessage = this.driver
				.findElement(By.xpath("//span[@id='" + LEGACY_USER_SIGNUP_LST_CC_TYPE_WARNING_MESSAGE + "']//span"))
				.getText();
		System.out.println("Step :: Warning Messsage >> " + getCCTypeWarningMessage);

		String getCCNumberWarningMessage = this.driver
				.findElement(By.xpath("//span[@id='" + LEGACY_USER_SIGNUP_TXT_CC_NUMBER_WARNING_MESSAGE + "']//span"))
				.getText();
		System.out.println("Step :: Warning Messsage >> " + getCCNumberWarningMessage);

		String getExpirationMonthWarningMessage = this.driver
				.findElement(By.xpath(
						"//span[@id='" + LEGACY_USER_SIGNUP_LST_EXPIRATION_DATE_MONTH_WARNING_MESSAGE + "']//span"))
				.getText();
		System.out.println("Step :: Warning Messsage >> " + getExpirationMonthWarningMessage);

		String getExpirationDateWarningMessage = this.driver
				.findElement(By.xpath("//span[@id='" + LEGACY_USER_SIGNUP_LST_EXPIRATION_DATE_YEAR_WARNING_MESSAGE
						+ "']//span[@class='" + LEGACY_USER_SIGNUP_TXT_WARNING_MESSAGE + "']"))
				.getText();
		System.out.println("Step :: Warning Messsage >> " + getExpirationDateWarningMessage);

		String getSecurityCodeWarningMessage = this.driver
				.findElement(By.xpath("//span[@id='" + LEGACY_USER_SIGNUP_LST_EXPIRATION_DATE_YEAR_WARNING_MESSAGE
						+ "']//span[@class='" + LEGACY_USER_SIGNUP_TXT_WARNING_MESSAGE + "']"))
				.getText();
		System.out.println("Step :: Warning Messsage >> " + getSecurityCodeWarningMessage);

		common.assertTwoValuesAreEqual(getCCTypeWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_WARNING_MESSAGE_REQUIRED);
		common.assertTwoValuesAreEqual(getCCNumberWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_WARNING_MESSAGE_REQUIRED);
		common.assertTwoValuesAreEqual(getExpirationMonthWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_WARNING_MESSAGE_REQUIRED);
		common.assertTwoValuesAreEqual(getExpirationDateWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_WARNING_MESSAGE_REQUIRED);
		common.assertTwoValuesAreEqual(getSecurityCodeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_WARNING_MESSAGE_REQUIRED);

	}

	/**
	 * Verify Email With Require CreditCard On Signup Active On Registration
	 * Authorize Amount
	 * 
	 * @throws InterruptedException
	 */
	public void verifyemailWithRequireCreditCardOnSignUpActiveOnRegistrationAuthorizeAmount()
			throws InterruptedException {

		String FistName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		common.pause(20);
		System.out.println("Step :: Admin logout front");
		common.log("<br></br> Step :: Admin logout front");

		common.pause(25);
		common.log("<br></br> Step :: SignupUSer Details.");
		System.out.println(" Step :: SignupUSer Details.");
		driver.findElement(By.xpath("//*[text()='Signup']")).click();

		common.waitForConditionIsElementPresent(("//a"));

		String signUpUser = common.generateRandomChars(6);

		common.log("<br></br> Step :: Enter User Name");
		System.out.println(" Step :: Enter User Name");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']", signUpUser);

		common.log("<br></br> Step :: Enter Password");
		System.out.println(" Step :: Enter Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PASSWORD + "']", LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);

		System.out.println("Step :: Random Value :" + signUpUser);
		common.log("<br></br>Step :: Random Value :" + signUpUser);

		common.log("<br></br> Step :: Enter Confirm Password");
		System.out.println(" Step :: Enter Confirm Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_PASSWORD + "']",
				LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);

		common.log("<br></br> Step :: Enter Email");
		System.out.println(" Step :: Enter Email");
		System.out.println("New User >>" + "  " + signUpUser);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_EMAIL + "']",
				EmailUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);

		common.log("<br></br> Step :: Enter First Name.");
		System.out.println(" Step :: Enter First Name.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_FIRST_NAME + "']", signUpUser);

		common.log("<br></br> Step :: Enter Last Name.");
		System.out.println(" Step :: Enter Last Name.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_LAST_NAME + "']", signUpUser);

		System.out.println("Enter Phone Number...");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		common.log("<br></br>Step :: Phone Type.");
		System.out.println("Step :: Phone Type.");
		String PhoneType = "Work";
		WebElement option = signupPhoneType.findElement(By.xpath("//span[@id='" + LEGACY_USER_SIGNUP_TXT_PHONE_TYPE
				+ "']//option[contains(text(),'" + PhoneType + "')]"));
		System.out.println("Step :: Phone Type >>> " + PhoneType);
		common.log("<br></br>Step :: Phone Type >>> " + PhoneType);
		option.click();

		System.out.println("Step :: Identification.");
		common.log("<br></br>Step :: Identification.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_IDENTIFICATION + "']",
				LEGACY_USER_SIGNUP_TXT_IDENTIFICATION_VALUE);

		String IdentificationType = "2";
		WebElement identificationoption = signupIdentificationType.findElement(By.xpath("//span[@id='"
				+ LEGACY_USER_SIGNUP_LST_IDENTIFICATION_TYPE + "']//option[@value='" + IdentificationType + "']"));
		System.out.println("Step :: Identification Type >>> " + IdentificationType);
		common.log("<br></br>Step :: Identification Type >>> " + IdentificationType);
		identificationoption.click();

		common.pause(5);

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		common.log("<br></br>Step :: Billing Phone Number.");
		System.out.println("Step :: Billing Phone Number...");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		common.log("<br></br>Step :: Select Country.");
		System.out.println("Step :: Select Country.");
		String Country = "United States";
		WebElement country = countryselection.findElement(By.xpath("//span[@id='" + LEGACY_USER_SIGNUP_BILL_LST_COUNTRY
				+ "']//option[contains(text(),'" + Country + "')]"));
		country.click();

		common.log("<br></br>Step :: Enter Address.");
		System.out.println("Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		common.log("<br></br>Step :: Enter City.");
		System.out.println("Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		String State = "California";

		common.log("<br></br>Step :: State.");
		System.out.println("Step :: State.");
		WebElement state = countryselection.findElement(By.xpath(
				"//span[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_STATE + "']//option[contains(text(),'" + State + "')]"));
		state.click();

		common.log("<br></br>Step :: Enter Zip.");
		System.out.println("Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		String CCType = "Visa";
		WebElement CCtypeOption = signupcc.findElement(By.xpath("//span[@id='"
				+ LEGACY_USER_SIGNUP_LST_CC_TYPE_WARNING_MESSAGE + "']//option[contains(text(),'" + CCType + "')]"));

		System.out.println("CCType :: " + CCType + "####");
		common.log("<br></br>CCType  ::  " + CCType + "####");
		CCtypeOption.click();

		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CC_NUMBER + "']", "41111111111511111");

		/**
		 * Select Expiration Month
		 * 
		 */
		String Month = "August";
		WebElement augustoption = signupmonth
				.findElement(By.xpath("//span[@id='" + LEGACY_USER_SIGNUP_LST_EXPIRATION_DATE_MONTH_WARNING_MESSAGE
						+ "']//option[contains(text(),'" + Month + "')]"));

		System.out.println("Month :: " + Month + ">>>>");
		common.log("<br></br>Month :: " + Month + ">>>>");
		augustoption.click();

		/**
		 * Select Expiration Year
		 * 
		 */
		String Year = "2018";
		WebElement yearoption = signupyear
				.findElement(By.xpath("//span[@id='" + LEGACY_USER_SIGNUP_LST_EXPIRATION_DATE_YEAR_WARNING_MESSAGE
						+ "']//option[contains(text(),'" + Year + "')]"));

		System.out.println("Year :: " + Year + ">>>>");
		common.log("<br></br>Year :: " + Year + ">>>>");
		yearoption.click();

		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_SECURITY_CODE + "']", "123");

		common.log("<br></br>Step :: Click on Same as billing check box.");
		System.out.println("Step :: Click on Same as billing check box.");
		common.checkChkBox(ship);
		common.pause(5);

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(20);

		common.waitForConditionIsElementPresent("//span[text()='Invalid Credit Card Number']");

		common.assertElementPresent("//span[text()='Invalid Credit Card Number']");

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(15);

		common.log("<br></br> Step :: signup not successful "
				+ "incorrect CC number error message is displayed in red next to the CC number field");
		System.out.println("Step :: signup not successful "
				+ "incorrect CC number error message is displayed in red next to the CC number field");
	}

	/**
	 * Verify Email With Require CreditCard On Signup Active And Expired CC
	 * Authorize Amount
	 * 
	 * @throws InterruptedException
	 */
	public void verify_SignUp_Active_And_ExpiredCC_On_AuthorizeAmount() throws InterruptedException {

		String FistName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		common.pause(20);
		System.out.println("Step :: Admin logout front");
		common.log("<br></br> Step :: Admin logout front");

		common.pause(25);
		common.log("<br></br> Step :: SignupUSer Details.");
		System.out.println(" Step :: SignupUSer Details.");
		driver.findElement(By.xpath("//a[text()='Signup']")).click();

		common.pause(40);
		String signUpUser = common.generateRandomChars(6);

		common.waitForConditionIsElementPresent("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']");
		common.log("<br></br> Step :: Enter User Name");
		System.out.println(" Step :: Enter User Name");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']", signUpUser);

		common.log("<br></br> Step :: Enter Password");
		System.out.println(" Step :: Enter Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PASSWORD + "']", LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);

		common.log("<br></br> Step :: Enter Confirm Password");
		System.out.println(" Step :: Enter Confirm Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_PASSWORD + "']",
				LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);

		common.log("<br></br> Step :: Enter Email");
		System.out.println(" Step :: Enter Email");
		System.out.println("New User >>" + "  " + signUpUser);

		common.log("<br></br> Step :: Enter First Name.");
		System.out.println(" Step :: Enter First Name.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_FIRST_NAME + "']", signUpUser);

		common.log("<br></br> Step :: Enter Last Name.");
		System.out.println(" Step :: Enter Last Name.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_LAST_NAME + "']", signUpUser);

		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_EMAIL + "']",
				EmailUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);

		// common.jsClick(editBoxOfPhone);

		System.out.println("Enter Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		common.log("<br></br>Step :: Phone Type.");
		System.out.println("Step :: Phone Type.");
		String PhoneType = "Work";
		WebElement option = selectNew.findElement(By.xpath("//span[@id='" + LEGACY_USER_SIGNUP_TXT_PHONE_TYPE
				+ "']//option[contains(text(),'" + PhoneType + "')]"));

		Select_User_Info_Phone_Type(); // select phone type

		Select_Identification_Type(); // Select Identification Type

		common.pause(5);

		Enter_Expired_CC_Details(); // Enter Expired CC Details

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(40);

		if (common.isElementPresent("//span[contains(text(),'Signup failed. Please check the following for erro')]")) {
			common.waitForElementIsDisplayed(
					By.xpath("//span[contains(text(),'Signup failed. Please check the following for erro')]"));
			common.assertElementPresent(
					"//span[contains(text(),'CC number *: Problem encountered in your credit ca')]");
		}

		common.waitForConditionIsElementPresent("//span[text()='Billing CC Expiry Date: Invalid']");

		String str = driver.findElement(By.xpath("//span[text()='Billing CC Expiry Date: Invalid']")).getText();

		System.out.println("Error Message Display :: " + str);

	}

	/**
	 * Verify Email With Require CreditCard On Signup Active On Registration
	 * Authorize Amount
	 * 
	 * @throws InterruptedException
	 */
	public void verify_RequireCreditCard_On_SignUpActive_On_RegistrationNoneAmount() throws InterruptedException {

		common.pause(20);
		System.out.println("Step :: Admin logout front");
		common.log("<br></br> Step :: Admin logout front");

		common.pause(25);
		common.jsClick(signUpLink);

		common.log("<br></br>Step :: SignupUser Details");
		System.out.println("Step :: SignupUser Details");
		String FistName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);

		common.pause(40);

		common.log("<br></br> Step :: SignupUSer Details.");
		System.out.println(" Step :: SignupUSer Details.");
		common.waitForConditionIsElementPresent(("//a"));

		String signUpUser = common.generateRandomChars(6);

		common.log("<br></br> Step :: Enter User Name");
		System.out.println(" Step :: Enter User Name");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']", signUpUser);

		common.log("<br></br> Step :: Enter Password");
		System.out.println(" Step :: Enter Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PASSWORD + "']", LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);
		System.out.println("Step :: Random Value :" + signUpUser);
		common.log("<br></br>Step :: Random Value :" + signUpUser);

		common.log("<br></br> Step :: Enter Confirm Password");
		System.out.println(" Step :: Enter Confirm Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_PASSWORD + "']",
				LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);

		common.log("<br></br> Step :: Enter Email");
		System.out.println(" Step :: Enter Email");
		System.out.println("New User >>" + "  " + signUpUser);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_EMAIL + "']",
				EmailUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);

		common.log("<br></br> Step :: Enter First Name.");
		System.out.println(" Step :: Enter First Name.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_FIRST_NAME + "']", signUpUser);

		common.log("<br></br> Step :: Enter Last Name.");
		System.out.println(" Step :: Enter Last Name.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_LAST_NAME + "']", signUpUser);

		System.out.println("Enter Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		Select_User_Info_Phone_Type(); // Select Phone Type

		Select_Identification_Type(); // Select Identification Type

		common.pause(5);

		Enter_CC_Details_With_Invalid_CC_Number();

		common.pause(10);

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(30);

		common.log("<br></br>Step :: Verify Error Message.");
		System.out.println("Step :: Verify Error Message");
		common.waitForElement(By.xpath("//span[text()='CC number *: Invalid']"));
		String getCCNumberWarningMeage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][1]")).getText();

		System.out.println("Step :: Warning Message >> " + getCCNumberWarningMeage);

		common.log("<br></br>Step  ::signup not successful. "
				+ "incorrect CC number error message is displayed in red next to the CC number field");
		System.out.println("Step  ::signup not successful. "
				+ "incorrect CC number error message is displayed in red next to the CC number field");

	}

	/**
	 * Verify Email With Require CreditCard On Signup Active And Requried Error
	 * Message Is Displayed In Red Next To All The CC Fields. No CC
	 * 
	 * @throws InterruptedException
	 */
	public void verify_RequireCreditCard_On_RequiredErrorMessageIsDisplayed_In_All_The_CCFields()
			throws InterruptedException {

		common.log("<br></br>Step :: SignupUser Details");
		System.out.println("Step :: SignupUser Details");

		String FistName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		common.pause(20);
		System.out.println("Step :: Admin logout front");
		common.log("<br></br> Step :: Admin logout front");

		common.pause(25);
		common.pause(30);

		common.log("<br></br> Step :: SignupUSer Details.");
		System.out.println(" Step :: SignupUSer Details.");
		driver.findElement(By.xpath("//*[text()='Signup']")).click();

		common.waitForConditionIsElementPresent(("//a"));
		common.pause(40);
		String signUpUser = common.generateRandomChars(6);

		common.log("<br></br> Step :: Enter User Name");
		System.out.println(" Step :: Enter User Name");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']", signUpUser);

		common.log("<br></br> Step :: Enter Password");
		System.out.println(" Step :: Enter Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PASSWORD + "']", LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);

		System.out.println("Step :: Random Value :" + signUpUser);
		common.log("<br></br>Step :: Random Value :" + signUpUser);

		common.log("<br></br> Step :: Enter Confirm Password");
		System.out.println(" Step :: Enter Confirm Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_FIRST_NAME + "']", signUpUser);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_LAST_NAME + "']", signUpUser);

		common.log("<br></br> Step :: Enter Email");
		System.out.println(" Step :: Enter Email");
		System.out.println("New User >>" + "  " + signUpUser);

		common.log("<br></br> Step :: Enter First Name.");
		System.out.println(" Step :: Enter First Name.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']", signUpUser);

		common.log("<br></br> Step :: Enter Last Name.");
		System.out.println(" Step :: Enter Last Name.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_PASSWORD + "']",
				LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_EMAIL + "']",
				EmailUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);
		// common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_EMAIL
		// + "']", EmailUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);

		// common.jsClick(editBoxOfPhone);

		System.out.println("Step :: Enter Phone Number.");
		common.log("<br></br>Step :: Enter Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		Select_User_Info_Phone_Type(); // Select Phone Type

		Select_Identification_Type(); // Select Identification Type

		common.pause(5);

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);
		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(40);

		// Verify Required Fields

		String getSecurityCodeWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_4 + "'][1]")).getText();

		String getExpirationDateWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_3 + "'][3]")).getText();

		System.out.println("Step :: Warning Message >> " + getExpirationDateWarningMessage);
		System.out.println("Step :: Warning Message >> " + getSecurityCodeWarningMessage);

		String getCCNumberWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][4]")).getText();

		System.out.println("Step :: Warning Message >> " + getCCNumberWarningMessage);

//		common.assertTwoValuesAreEqual(getCCNumberWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_NUMBER_ALERT_MESSAGE);
//		
//		common.assertTwoValuesAreEqual(getExpirationDateWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_CC_EXPIRY_DATE);
//		common.assertTwoValuesAreEqual(getSecurityCodeWarningMessage,
//				LEGACY_USER_SIGNUP_BILL_TXT_SECURITY_CODE_ALERT_MESSAGE);

		common.log("<br><br>Step :: signup not successful"
				+ "required error message is displayed in red next to all the CC fields");
		System.out.println("Step :: signup not successful"
				+ "required error message is displayed in red next to all the CC fields");
	}

	/**
	 * Verify Email With Require CreditCard On Signup Active And Expired CC
	 * Authorize Amount
	 * 
	 * @throws InterruptedException
	 */
	public void verify_RequireCreditCard_On_SignUpActive_And_Expired_CC_OnNoneAmount() throws InterruptedException {

		common.pause(20);
		System.out.println("Step :: Admin logout front");
		common.log("<br></br> Step :: Admin logout front");

		common.pause(25);

		common.log("<br></br>Step :: SignupUser Details");
		System.out.println("Step :: SignupUser Details");
		driver.findElement(By.xpath("//a[text()='Signup']")).click();
		String FistName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);

		common.pause(40);
		String signUpUser = common.generateRandomChars(6);

		common.log("<br></br> Step :: Enter User Name");
		System.out.println(" Step :: Enter User Name");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']", signUpUser);

		common.log("<br></br> Step :: Enter Password");
		System.out.println(" Step :: Enter Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PASSWORD + "']", LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);
		System.out.println("Step :: Random Value :" + signUpUser);
		common.log("<br></br>Step :: Random Value :" + signUpUser);

		common.log("<br></br> Step :: Enter Confirm Password");
		System.out.println(" Step :: Enter Confirm Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_PASSWORD + "']",
				LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);

		common.log("<br></br> Step :: Enter Email");
		System.out.println(" Step :: Enter Email");
		System.out.println("New User >>" + "  " + signUpUser);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_EMAIL + "']",
				EmailUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);

		common.log("<br></br> Step :: Enter First Name.");
		System.out.println(" Step :: Enter First Name.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_FIRST_NAME + "']", signUpUser);

		common.log("<br></br> Step :: Enter Last Name.");
		System.out.println(" Step :: Enter Last Name.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_LAST_NAME + "']", signUpUser);

		System.out.println("Enter Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		Select_User_Info_Phone_Type(); // Select Phone Type

		Select_Identification_Type(); // Select Identification Type

		common.pause(5);

		Enter_Expired_CC_Details();

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(40);

		common.waitForConditionIsElementPresent("//span[text()='Billing CC Expiry Date: Invalid']");

		String str = driver.findElement(By.xpath("//span[text()='Billing CC Expiry Date: Invalid']")).getText();

		System.out.println("Error Message Display :: " + str);

	}

	/**
	 * Verify Email With Require CreditCard On Signup Active And Requried Error
	 * Message Is Displayed In Red Next To All The CC Fields. No CC NONE CC
	 * 
	 * @throws InterruptedException
	 */
	public void verifyemailWithRequireCreditCardOnRequiredErrorMessageIsDisplayedInRedNextToAllTheCCFieldssithNoCCNONECC()
			throws InterruptedException {
		common.pause(20);
		System.out.println("Step :: Admin logout front");
		common.log("<br></br> Step :: Admin logout front");

		common.pause(25);
		String FistName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);

		common.pause(15);

		common.log("<br></br> Step :: SignupUSer Details.");
		System.out.println(" Step :: SignupUSer Details.");
		driver.findElement(By.xpath("//*[text()='Signup']")).click();

		common.waitForConditionIsElementPresent(("//a"));

		String signUpUser = common.generateRandomChars(6);

		common.log("<br></br> Step :: Enter User Name");
		System.out.println(" Step :: Enter User Name");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']", signUpUser);

		common.log("<br></br> Step :: Enter Password");
		System.out.println(" Step :: Enter Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PASSWORD + "']", LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);

		System.out.println("Step :: Random Value :" + signUpUser);
		common.log("<br></br>Step :: Random Value :" + signUpUser);

		common.log("<br></br> Step :: Enter Confirm Password");
		System.out.println(" Step :: Enter Confirm Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_PASSWORD + "']",
				LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);

		common.log("<br></br> Step :: Enter Email");
		System.out.println(" Step :: Enter Email");
		System.out.println("New User >>" + "  " + signUpUser);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_EMAIL + "']",
				EmailUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);

		common.log("<br></br> Step :: Enter First Name.");
		System.out.println(" Step :: Enter First Name.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']", signUpUser);

		common.log("<br></br> Step :: Enter Last Name.");
		System.out.println(" Step :: Enter Last Name.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_LAST_NAME + "']", signUpUser);

		System.out.println("Enter Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		common.log("<br></br>Step :: Phone Type.");
		System.out.println("Step :: Phone Type.");
		String PhoneType = "Work";
		WebElement option = signupPhoneType.findElement(By.xpath("//span[@id='" + LEGACY_USER_SIGNUP_TXT_PHONE_TYPE
				+ "']//option[contains(text(),'" + PhoneType + "')]"));
		System.out.println("Step :: Phone Type >>> " + PhoneType);
		common.log("<br></br>Step :: Phone Type >>> " + PhoneType);
		option.click();

		System.out.println("Step :: Identification.");
		common.log("<br></br>Step :: Identification.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_IDENTIFICATION + "']",
				LEGACY_USER_SIGNUP_TXT_IDENTIFICATION_VALUE);

		String IdentificationType = "2";
		WebElement identificationoption = signupIdentificationType.findElement(By.xpath("//span[@id='"
				+ LEGACY_USER_SIGNUP_LST_IDENTIFICATION_TYPE + "']//option[@value='" + IdentificationType + "']"));
		System.out.println("Step :: Identification Type >>> " + IdentificationType);
		common.log("<br></br>Step :: Identification Type >>> " + IdentificationType);
		identificationoption.click();

		common.pause(5);

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		common.log("<br></br>Step :: Entering Phone Number.");
		System.out.println("Step :: Enter Phone Number...");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		common.log("<br></br>Step :: Select Country.");
		System.out.println("Step :: Select Country.");
		String Country = "United States";
		WebElement country = countryselection.findElement(By.xpath("//span[@id='" + LEGACY_USER_SIGNUP_BILL_LST_COUNTRY
				+ "']//option[contains(text(),'" + Country + "')]"));
		country.click();

		common.log("<br></br>Step :: Enter Address.");
		System.out.println("Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		common.log("<br></br>Step :: Enter City.");
		System.out.println("Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		String State = "California";

		common.log("<br></br>Step :: State.");
		System.out.println("Step :: State.");
		WebElement state = countryselection.findElement(By.xpath(
				"//span[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_STATE + "']//option[contains(text(),'" + State + "')]"));
		state.click();

		common.log("<br></br>Step :: Enter Zip.");
		System.out.println("Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		common.log("<br></br>-----------------------------------------------------------------------------------");

		common.log("<br></br>Step :: Click on Same as billing check box.");
		System.out.println("Step :: Click on Same as billing check box.");
		common.checkChkBox(ship);
		common.pause(5);

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(20);

		// Verify Required Fields
		common.waitForConditionIsElementPresent(
				"//span[@id='" + LEGACY_USER_SIGNUP_LST_CC_TYPE_WARNING_MESSAGE + "']//span");

		String getCCTypeWarningMessage = this.driver
				.findElement(By.xpath("//span[@id='" + LEGACY_USER_SIGNUP_LST_CC_TYPE_WARNING_MESSAGE + "']//span"))
				.getText();
		System.out.println("Step :: Warning Messsage >> " + getCCTypeWarningMessage);

		String getCCNumberWarningMessage = this.driver
				.findElement(By.xpath("//span[@id='" + LEGACY_USER_SIGNUP_TXT_CC_NUMBER_WARNING_MESSAGE + "']//span"))
				.getText();
		System.out.println("Step :: Warning Messsage >> " + getCCNumberWarningMessage);

		String getExpirationMonthWarningMessage = this.driver
				.findElement(By.xpath(
						"//span[@id='" + LEGACY_USER_SIGNUP_LST_EXPIRATION_DATE_MONTH_WARNING_MESSAGE + "']//span"))
				.getText();
		System.out.println("Step :: Warning Messsage >> " + getExpirationMonthWarningMessage);

		String getExpirationDateWarningMessage = this.driver
				.findElement(By.xpath("//span[@id='" + LEGACY_USER_SIGNUP_LST_EXPIRATION_DATE_YEAR_WARNING_MESSAGE
						+ "']//span[@class='" + LEGACY_USER_SIGNUP_TXT_WARNING_MESSAGE + "']"))
				.getText();
		System.out.println("Step :: Warning Messsage >> " + getExpirationDateWarningMessage);

		String getSecurityCodeWarningMessage = this.driver
				.findElement(By.xpath("//span[@id='" + LEGACY_USER_SIGNUP_LST_EXPIRATION_DATE_YEAR_WARNING_MESSAGE
						+ "']//span[@class='" + LEGACY_USER_SIGNUP_TXT_WARNING_MESSAGE + "']"))
				.getText();
		System.out.println("Step :: Warning Messsage >> " + getSecurityCodeWarningMessage);

		common.assertTwoValuesAreEqual(getCCTypeWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_WARNING_MESSAGE_REQUIRED);
		common.assertTwoValuesAreEqual(getCCNumberWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_WARNING_MESSAGE_REQUIRED);
		common.assertTwoValuesAreEqual(getExpirationMonthWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_WARNING_MESSAGE_REQUIRED);
		common.assertTwoValuesAreEqual(getExpirationDateWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_WARNING_MESSAGE_REQUIRED);
		common.assertTwoValuesAreEqual(getSecurityCodeWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_WARNING_MESSAGE_REQUIRED);

		common.log("<br><br>Step :: signup not successful"
				+ "required error message is displayed in red next to all the CC fields");
		System.out.println("Step ::vsignup not successful"
				+ "required error message is displayed in red next to all the CC fields");

	}

	/**
	 * Regular signup for shipping info
	 * 
	 */

	public String regular_SignUp_For_Shipping_Info(String FirstName, String LastName, String EmailUser,
			String signUpUser) throws InterruptedException {

		System.out.println("SignupUser Details");
		common.pause(30);
		System.out.println("Step :: Admin logout front");
		common.log("<br></br> Step :: Admin logout front");

		common.pause(25);

		System.out.println("Step :: SignupUSer Details.");
		common.log("<br></br> Step :: SignupUSer Details.");
		common.jsClick(signUpLink);
		common.pause(30);
		common.log("<br></br> Step :: Enter User Name:" + signUpUser);
		System.out.println(" Step :: Enter User Name:" + signUpUser);
		common.waitForElement(By.xpath("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']"));
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']", signUpUser);

		System.out.println("Step :: Enter Password");
		common.log("<br></br> Step :: Enter Password");
		common.type("//input[@id= '" + LEGACY_USER_SIGNUP_TXT_PASSWORD + "']", LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);

		System.out.println("Random Value :" + signUpUser);

		System.out.println("Step :: Enter Confirm Password");
		common.log("<br></br> Step :: Enter Confirm Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_PASSWORD + "']",
				LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);

		System.out.println("Step :: Enter Email");
		common.log("<br></br> Step :: Enter Email");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_EMAIL + "']",
				EmailUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);

//		System.out.println("Step :: Enter Confim Email :: " + EmailUser);
//		common.log("<br></br>Step :: Enter Confirm Email :: " + EmailUser);
//		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_EMAIL + "']",
//				EmailUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);

		System.out.println("Step :: Enter First Name:" + signUpUser);
		common.log("<br></br> Step :: Enter First Name:" + signUpUser);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_FIRST_NAME + "']", signUpUser);

		System.out.println("Step :: Enter Last Name.");
		common.log("<br></br> Step :: Enter Last Name.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_LAST_NAME + "']", signUpUser);
		common.pause(10);

		// common.jsClick(editBoxOfPhone);
		common.log("<br></br>Enter Phone Number.");
		System.out.println("Enter Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);
		common.pause(10);
		Enter_CC_Details();
		common.pause(10);

		Select_User_Info_Phone_Type();

		common.pause(15);

		Select_Identification_Type(); // Select Identification type

		common.pause(8);

		enterBillInfowithoutselectshippinginfocheckbox(signUpUser);
		return signUpUser;

	}

	public String regular_SignUp_For_Shipping_Info1(String FirstName, String LastName, String EmailUser,
			String signUpUser) throws InterruptedException {

		System.out.println("SignupUser Details");
		common.pause(30);
		System.out.println("Step :: Admin logout front");
		common.log("<br></br> Step :: Admin logout front");

		common.pause(25);

		System.out.println("Step :: SignupUSer Details.");
		common.log("<br></br> Step :: SignupUSer Details.");
		common.jsClick(signUpLink);
		common.pause(30);
		common.log("<br></br> Step :: Enter User Name:" + signUpUser);
		System.out.println(" Step :: Enter User Name:" + signUpUser);
		common.waitForElement(By.xpath("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']"));
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']", signUpUser);

		System.out.println("Step :: Enter Password");
		common.log("<br></br> Step :: Enter Password");
		common.type("//input[@id= '" + LEGACY_USER_SIGNUP_TXT_PASSWORD + "']", LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);

		System.out.println("Random Value :" + signUpUser);

		System.out.println("Step :: Enter Confirm Password");
		common.log("<br></br> Step :: Enter Confirm Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_PASSWORD + "']",
				LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);

		System.out.println("Step :: Enter Email");
		common.log("<br></br> Step :: Enter Email");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_EMAIL + "']",
				EmailUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);

//		System.out.println("Step :: Enter Confim Email :: " + EmailUser);
//		common.log("<br></br>Step :: Enter Confirm Email :: " + EmailUser);
//		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_EMAIL + "']",
//				EmailUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);

		System.out.println("Step :: Enter First Name:" + signUpUser);
		common.log("<br></br> Step :: Enter First Name:" + signUpUser);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_FIRST_NAME + "']", signUpUser);

		System.out.println("Step :: Enter Last Name.");
		common.log("<br></br> Step :: Enter Last Name.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_LAST_NAME + "']", signUpUser);
		common.pause(10);

		// common.jsClick(editBoxOfPhone);
		common.log("<br></br>Enter Phone Number.");
		System.out.println("Enter Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		common.pause(10);

		Select_User_Info_Phone_Type();

		common.pause(15);

		Select_Identification_Type(); // Select Identification type

		common.pause(8);

		enterBillInfowithoutselectshippinginfocheckbox(signUpUser);
		return signUpUser;

	}

	/**
	 * Enter Bill Info with out select shipping info checkbox
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */
	public void enterBillInfowithoutselectshippinginfocheckbox(String signUpUser) throws InterruptedException {

		common.pause(20);
		Select_Billing_Info_Phone_Type(); // Select Phone Type

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", signUpUser);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", signUpUser);

		common.pause(5);

		System.out.println("Step :: Entering Phone Number.");
		common.log("<br></br>Step :: Entering Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		Select_Counrty_and_State(); // Select Country and State

		// Enter_CC_Details(); // Enter CC Details

		System.out.println("Step :: Enter Address.");
		common.log("<br></br>Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		System.out.println("Step :: City.");
		common.log("<br></br>Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);
		common.pause20Sec();
		
		System.out.println("Step :: Enter Zip.");
		common.log("<br></br>Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);
		common.pause20Sec();

		if (common.isElementDisplayed("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']")) {

			System.out.println("Step :: Entering Captcha.");
			common.log("<br></br>Step :: Entering Captcha.");
			common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		} else {

			System.out.println("Step :: Captacha field missing");
			common.log("<br></br>Step :: Captacha field missing");

		}

		common.pause(10);

	}

	/**
	 * Enter shipping info without contact number
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */
	public void enterShippingInfoWithoutContactNumber(String signUpUser) throws InterruptedException

	{

		// Select_Shipping_Info_Phone_Type(); // Select Phone Type

		Select_Shipping_Counrty_and_State(); // Select State and Country

		System.out.println("Step :: Shipping First Name :");
		common.log("<br></br>Step :: Shipping First Name :");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Shipping Last Name :");
		common.log("<br></br>Step :: Shipping Last Name :");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_LAST_NAME + "']", contactLast);

		System.out.println("Step :: Enter Address.");
		common.log("<br></br>Step :: Enter Address.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		System.out.println("Step :: Enter City.");
		common.log("<br></br>Step :: Enter City.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		System.out.println("Step :: Enter Zip.");
		common.log("<br></br>Step :: Enter Zip.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_ZIP + "']", LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(40);
		System.out.println("Step :: Verify missing contact number");
		common.log("<br></br>Step:: Verify enter phone number");

		String getPhoneWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getPhoneWarningMessage);
	}

	/**
	 * 
	 * Verify That user is not able to Register with Missing "First Name" Required
	 * field.
	 */

	public void enterShippingInfoWithoutFirstName(String signUpUser) throws InterruptedException

	{

		Select_Shipping_Info_Phone_Type(); // Select Shipping Phone type

		System.out.println("Step :: Shipping Last Name :");
		common.log("<br></br>Step :: Shipping Last Name :");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_LAST_NAME + "']", contactLast);

		System.out.println("Step :: Entering Phone Number.");
		common.log("<br></br>Step :: Entering Phone Number.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		Select_Shipping_Counrty_and_State(); // Select Shipping State and
												// Country

		System.out.println("Step :: Enter Address.");
		common.log("<br></br>Step :: Enter Address.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		System.out.println("Step :: Enter City.");
		common.log("<br></br>Step :: Enter City.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		System.out.println("Step :: Enter Zip.");
		common.log("<br></br>Step :: Enter Zip.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_ZIP + "']", LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(40);
		System.out.println("Step :: Verify First Name in shipping info");
		common.log("<br></br>Step:: Verify First Name in shipping info");

		String getFirstnameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getFirstnameWarningMessage);
		common.pause(30);
		assertTrue(getFirstnameWarningMessage
				.equals("" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME_UPDATED_ALERT_MESSAGE_dev + "")
				|| getFirstnameWarningMessage
						.equals("" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME_UPDATED_ALERT_MESSAGE_qa36auto + ""));

	}

	/**
	 * Missing Last Name in shipping info
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */

	public void enterShippingInfoWithoutLastName(String signUpUser) throws InterruptedException

	{

		Select_Shipping_Info_Phone_Type(); // Select Shipping info Phone

		System.out.println("Step :: Shipping First Name :");
		common.log("<br></br>Step :: Shipping First Name :");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Entering Phone Number.");
		common.log("<br></br>Step :: Entering Phone Number.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		Select_Shipping_Counrty_and_State(); // Select State and Country

		System.out.println("Step :: Enter Address.");
		common.log("<br></br>Step :: Enter Address.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		System.out.println("Step :: Enter City.");
		common.log("<br></br>Step :: Enter City.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		System.out.println("Step :: Enter Zip.");
		common.log("<br></br>Step :: Enter Zip.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_ZIP + "']", LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(40);
		String getLastnameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getLastnameWarningMessage);
		assertTrue(getLastnameWarningMessage.equals("" + LEGACY_USER_SIGNUP_Ship_TXT_LAST_NAME_ALERT_MESSAGE + "")
				|| getLastnameWarningMessage
						.equals("" + LEGACY_USER_SIGNUP_Ship_TXT_LAST_NAME_ALERT_MESSAGE_qa36auto + ""));
	}

	/**
	 * 
	 * Missing Phone Number in Shipping Info
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */
	public void enterShippingInfoWithoutPhoneNumber(String signUpUser) throws InterruptedException

	{

		Select_Shipping_Info_Phone_Type(); // Select Shipping info phone

		System.out.println("Step :: Shipping First Name :");
		common.log("<br></br>Step :: Shipping First Name :");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Shipping Last Name :");
		common.log("<br></br>Step :: Shipping Last Name :");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_LAST_NAME + "']", contactLast);

		Select_Shipping_Counrty_and_State(); // Select County and state

		System.out.println("Step :: Enter Address.");
		common.log("<br></br>Step :: Enter Address.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		System.out.println("Step :: Enter City.");
		common.log("<br></br>Step :: Enter City.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		System.out.println("Step :: Enter Zip.");
		common.log("<br></br>Step :: Enter Zip.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_ZIP + "']", LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(40);
		String getPhoneNumberWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getPhoneNumberWarningMessage);
		assertTrue(getPhoneNumberWarningMessage.equals("" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE_ALERT_MESSAGE + "")
				|| getPhoneNumberWarningMessage
						.equals("" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE_ALERT_MESSAGE_qa36auto + ""));
	}

	/**
	 * 
	 * Enter Alphabet in phone number
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */
	public void enterAlphabetInPhoneNumberFiledShippingInfo(String signUpUser) throws InterruptedException

	{

		common.waitForConditionIsElementPresent("//*[@id='" + LEGACY_USER_LST_SHIPPING_INFO_CONTACT_TYPE + "']");

		Select_Shipping_Info_Phone_Type(); // Select Phone Type

		System.out.println("Step :: Shipping First Name :");
		common.log("<br></br>Step :: Shipping First Name :");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Shipping Last Name :");
		common.log("<br></br>Step :: Shipping Last Name :");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_LAST_NAME + "']", contactLast);

		System.out.println("Step :: Entering Phone Number.");
		common.log("<br></br>Step :: Entering Phone Number.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_PHONE + "']",
				LEGACY_USER_TXT_SIGNUP_PHONE_VALUE_SHIPPING);

		Select_Shipping_Counrty_and_State(); // Select Country and State

		System.out.println("Step :: Enter Address.");
		common.log("<br></br>Step :: Enter Address.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		System.out.println("Step :: Enter City.");
		common.log("<br></br>Step :: Enter City.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		System.out.println("Step :: Enter Zip.");
		common.log("<br></br>Step :: Enter Zip.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_ZIP + "']", LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(40);
		String getInvalidphWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getInvalidphWarningMessage);
//		common.assertTwoValuesAreEqual(getInvalidphWarningMessage,
//				LEGACY_USER_SIGNUP_BILL_TXT_INVALID_PHONE_ALERT_MESSAGE);
		assertTrue(getInvalidphWarningMessage.equals("" + LEGACY_USER_SIGNUP_BILL_TXT_INVALID_PHONE_ALERT_MESSAGE + "")
				|| getInvalidphWarningMessage
						.equals("" + LEGACY_USER_SIGNUP_BILL_TXT_INVALID_PHONE_ALERT_MESSAGE_qa36auto + ""));

	}

	/**
	 * 
	 * Missing Country Name in Shipping info
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */
	public void missingCountryFiledShippingInfo(String signUpUser) throws InterruptedException

	{

		common.waitForConditionIsElementPresent("//*[@id='" + LEGACY_USER_LST_SHIPPING_INFO_CONTACT_TYPE + "']");

		Select_Shipping_Info_Phone_Type(); // Select Shipping info phone

		System.out.println("Step :: Shipping First Name :");
		common.log("<br></br>Step :: Shipping First Name :");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Shipping Last Name :");
		common.log("<br></br>Step :: Shipping Last Name :");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_LAST_NAME + "']", contactLast);

		System.out.println("Step :: Entering Phone Number.");
		common.log("<br></br>Step :: Entering Phone Number.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		System.out.println("Step :: Enter Address.");
		common.log("<br></br>Step :: Enter Address.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		System.out.println("Step :: Enter City.");
		common.log("<br></br>Step :: Enter City.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		System.out.println("Step :: Enter Zip.");
		common.log("<br></br>Step :: Enter Zip.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_ZIP + "']", LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(40);
		System.out.println("Step :: Verify country field");
		common.log("<br></br>Step:: Verify country field");

		String getCountryWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getCountryWarningMessage);

		String getStateWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][2]")).getText();
		System.out.println("Step :: Warning Message >> " + getStateWarningMessage);

		assertTrue(getCountryWarningMessage.equals("" + LEGACY_USER_SIGNUP_BILL_TXT_COUNTRY_ALERT_MESSAGE + "")
				|| getCountryWarningMessage
						.equals("" + LEGACY_USER_SIGNUP_BILL_TXT_COUNTRY_ALERT_MESSAGE_qa36auto + ""));

		assertTrue(getStateWarningMessage.equals("" + LEGACY_USER_SIGNUP_BILL_TXT_STATE_ALERT_MESSAGE + "")
				|| getStateWarningMessage.equals("" + LEGACY_USER_SIGNUP_BILL_TXT_STATE_ALERT_MESSAGE_qa36auto + ""));

	}

	/**
	 * Missing Address in shipping info
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */
	public void missingAddressFiledShippingInfo(String signUpUser) throws InterruptedException

	{

		common.waitForConditionIsElementPresent("//*[@id='" + LEGACY_USER_LST_SHIPPING_INFO_CONTACT_TYPE + "']");

		Select_Shipping_Info_Phone_Type(); // Select Phone Type

		System.out.println("Step :: Shipping First Name :");
		common.log("<br></br>Step :: Shipping First Name :");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Shipping Last Name :");
		common.log("<br></br>Step :: Shipping Last Name :");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_LAST_NAME + "']", contactLast);

		System.out.println("Step :: Entering Phone Number.");
		common.log("<br></br>Step :: Entering Phone Number.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		Select_Shipping_Counrty_and_State(); // Select Country and State

		System.out.println("Step :: Enter City.");
		common.log("<br></br>Step :: Enter City.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		System.out.println("Step :: Enter Zip.");
		common.log("<br></br>Step :: Enter Zip.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_ZIP + "']", LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(40);

		System.out.println("Step :: Verify Address field");
		common.log("<br></br>Step:: Verify Address field");

		String getAddressWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getAddressWarningMessage);
		assertTrue(getAddressWarningMessage.equals("" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_ALERT_MESSAGE + "")
				|| getAddressWarningMessage
						.equals("" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_ALERT_MESSAGE_qa36auto + ""));

	}

	/**
	 * 
	 * Missing city field in shippinfo
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */

	public void missingCityFiledShippingInfo(String signUpUser) throws InterruptedException

	{

		Select_Shipping_Info_Phone_Type(); // Select Phone Type

		System.out.println("Step :: Shipping First Name :");
		common.log("<br></br>Step :: Shipping First Name :");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Shipping Last Name :");
		common.log("<br></br>Step :: Shipping Last Name :");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_LAST_NAME + "']", contactLast);

		System.out.println("Step :: Entering Phone Number.");
		common.log("<br></br>Step :: Entering Phone Number.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		Select_Shipping_Counrty_and_State(); // Select Country and State

		System.out.println("Step :: Enter Address.");
		common.log("<br></br>Step :: Enter Address.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		System.out.println("Step :: Enter Zip.");
		common.log("<br></br>Step :: Enter Zip.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_ZIP + "']", LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(40);
		System.out.println("Step :: Verify City field");
		common.log("<br></br>Step:: Verify City field");

		String getCityWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getCityWarningMessage);
		assertTrue(getCityWarningMessage.equals("" + LEGACY_USER_SIGNUP_BILL_TXT_CITY_ALERT_MESSAGE + "")
				|| getCityWarningMessage.equals("" + LEGACY_USER_SIGNUP_BILL_TXT_CITY_ALERT_MESSAGE_qa36auto + ""));

	}

	/**
	 * Missing State in shipping info
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */
	public void missingStateFiledShippingInfo(String signUpUser) throws InterruptedException

	{

		Select_Shipping_Info_Phone_Type(); // Select Shipping info Phone

		System.out.println("Step :: Shipping First Name :");
		common.log("<br></br>Step :: Shipping First Name :");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Shipping Last Name :");
		common.log("<br></br>Step :: Shipping Last Name :");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_LAST_NAME + "']", contactLast);

		System.out.println("Step :: Entering Phone Number.");
		common.log("<br></br>Step :: Entering Phone Number.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		System.out.println("Step :: Enter Address.");
		common.log("<br></br>Step :: Enter Address.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		System.out.println("Step :: Enter City.");
		common.log("<br></br>Step :: Enter City.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		System.out.println("Step :: Enter Zip.");
		common.log("<br></br>Step :: Enter Zip.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_ZIP + "']", LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(40);
		System.out.println("Step :: Verify State Filed");
		common.log("<br></br>Step:: Verify State Field");

		String getCountryWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getCountryWarningMessage);

		String getStateWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][2]")).getText();
		System.out.println("Step :: Warning Message >> " + getStateWarningMessage);

		assertTrue(getCountryWarningMessage.equals("" + LEGACY_USER_SIGNUP_BILL_TXT_COUNTRY_ALERT_MESSAGE + "")
				|| getCountryWarningMessage
						.equals("" + LEGACY_USER_SIGNUP_BILL_TXT_COUNTRY_ALERT_MESSAGE_qa36auto + ""));

		assertTrue(getStateWarningMessage.equals("" + LEGACY_USER_SIGNUP_BILL_TXT_STATE_ALERT_MESSAGE + "")
				|| getStateWarningMessage.equals("" + LEGACY_USER_SIGNUP_BILL_TXT_STATE_ALERT_MESSAGE_qa36auto + ""));

	}

	/**
	 * Missing Zip in Shipping info
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */
	public void missingZipFiledShippingInfo(String signUpUser) throws InterruptedException

	{

		common.waitForConditionIsElementPresent("//*[@id='" + LEGACY_USER_LST_SHIPPING_INFO_CONTACT_TYPE + "']");

		Select_Shipping_Info_Phone_Type(); // Select Shipping Phone

		System.out.println("Step :: Shipping First Name :");
		common.log("<br></br>Step :: Shipping First Name :");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Shipping Last Name :");
		common.log("<br></br>Step :: Shipping Last Name :");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_LAST_NAME + "']", contactLast);

		System.out.println("Step :: Entering Phone Number.");
		common.log("<br></br>Step :: Entering Phone Number.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		Select_Shipping_Counrty_and_State(); // Select State and Country

		System.out.println("Step :: Enter Address.");
		common.log("<br></br>Step :: Enter Address.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		System.out.println("Step :: Enter City.");
		common.log("<br></br>Step :: Enter City.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(40);

		System.out.println("Step :: Verify Zip Filed");
		common.log("<br></br>Step:: Verify Zip Field");

		String getZipWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getZipWarningMessage);
		assertTrue(getZipWarningMessage.equals("" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_ALERT_MESSAGE + "")
				|| getZipWarningMessage.equals("" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_ALERT_MESSAGE_qa36auto + ""));

	}

	/**
	 * Missing any one field in shipping info
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */

	public void missing_One_Filed_Shipping_Info(String signUpUser) throws InterruptedException

	{

		common.waitForConditionIsElementPresent("//*[@id='" + LEGACY_USER_LST_SHIPPING_INFO_CONTACT_TYPE + "']");

		Select_Shipping_Info_Phone_Type(); // Select Phone Type

		System.out.println("Step :: Shipping Last Name :");
		common.log("<br></br>Step :: Shipping Last Name :");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_LAST_NAME + "']", contactLast);

		System.out.println("Step :: Entering Phone Number.");
		common.log("<br></br>Step :: Entering Phone Number.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		Select_Shipping_Counrty_and_State(); // Select State And Country

		System.out.println("Step :: Enter Address.");
		common.log("<br></br>Step :: Enter Address.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		System.out.println("Step :: Enter City.");
		common.log("<br></br>Step :: Enter City.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		System.out.println("Step :: Enter Zip.");
		common.log("<br></br>Step :: Enter Zip.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_ZIP + "']", LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(40);

		String getFirstnameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + getFirstnameWarningMessage);
		common.assertTwoValuesAreEqual(getFirstnameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME_UPDATED_ALERT_MESSAGE_dev);
		common.pause(30);
	}

	/**
	 * Fill Shipping info fields.
	 */

	public void fill_All_Filed_Shipping_Info(String signUpUser) throws InterruptedException

	{

		common.waitForConditionIsElementPresent("//*[@id='" + LEGACY_USER_LST_SHIPPING_INFO_CONTACT_TYPE + "']");

		Select_Shipping_Info_Phone_Type(); // Select Phone Type

		System.out.println("Step :: Shipping First Name :");
		common.log("<br></br>Step :: Shipping First Name :");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_FIRST_NAME + "']", signUpUser);

		System.out.println("Step :: Shipping Last Name :");
		common.log("<br></br>Step :: Shipping Last Name :");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_LAST_NAME + "']", signUpUser);

		System.out.println("Step :: Entering Phone Number.");
		common.log("<br></br>Step :: Entering Phone Number.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);
		common.pause(10);

		System.out.println("Step :: Enter Address.");
		common.log("<br></br>Step :: Enter Address.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		System.out.println("Step :: Enter City.");
		common.log("<br></br>Step :: Enter City.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		System.out.println("Step :: Enter Zip.");
		common.log("<br></br>Step :: Enter Zip.");
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_ZIP + "']", LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		Select_Shipping_Counrty_and_State(); // Select Country and State

		common.pause(20);
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst1 = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", signUpUser);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast1 = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", signUpUser);

		System.out.println("Step :: Enter Phone Number.");
		common.log("<br></br>Step :: Enter Phone Number.");

		System.out.println("Enter Phone Number...");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(30);

		common.waitForElement(By.xpath("//ul[@id='messages']"));
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

	}

	/**
	 * 
	 * Verify contact field in shipping info
	 * 
	 */

	public void verifyShippingInfoFields(String signUpUser, String EmailUser) throws InterruptedException

	{

		String IdentificationType = "2"; // Identification Type
		String Identification = "Perfect QA Services";
		String UserRole = "1"; // 1 = "Bidder"
		String Country = "1"; // 1 = United States
		String State = "8"; // 8 = California
		String PhoneType = "1"; // 1 = work
		String PhoneNumber = "718-343-2012";
		String billingAddress = "466 green st";
		String billingCity = "san francisco";
		String zip = "94133";

		System.out.println("Click on profile");

		common.jsClick(selectprofile);
		common.pause(40);

		// Shipping info

		String editshippingInfocontacttype = common
				.getValue("//*[@id='" + LEGACY_USER_LST_SHIPPING_INFO_EDIT_CONTACT_TYPE + "']");

		System.out.println("Step :: Verify Shipping Info Contact Type >> " + editshippingInfocontacttype);
		common.log("<br></br> Step :: Verify Shipping Info Contact Type");

		String editshippingInfofirstname = common
				.getValue("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_FIRST_NAME + "']");
		System.out.println("Step :: Verify Shipping Info First Name >> " + editshippingInfofirstname);
		common.log("<br></br> Step :: Verify Shipping Info First Name");

		String editshippingInfolastname = common
				.getValue("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_LAST_NAME + "']");
		System.out.println("Step :: Verify Shipping Info Last Name >> " + editshippingInfolastname);
		common.log("<br></br> Step :: Verify Shipping Info Last Name");

		String editshippingInfophone = common.getValue("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_PHONE + "']");
		System.out.println("Step :: Verify Shipping Info Phonetype >> " + editshippingInfophone);
		common.log("<br></br> Step :: Verify Shipping Info Phonetype");

		String editshippingInfocountry = driver
				.findElement(By.xpath("//*[@id='" + LEGACY_USER_LST_SHIPPING_INFO_EDIT_COUNTRY + "']")).getText();
		System.out.println("Step :: Verify Shipping Info Country >> " + editshippingInfocountry);
		common.log("<br></br> Step :: Verify Shipping Info Country");

		String editshippingInfoaddress = common
				.getValue("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_ADDRESS + "']");
		System.out.println("Step :: Verify Shipping Info Address >> " + editshippingInfoaddress);
		common.log("<br></br> Step :: Verify Shipping Info Address");

		String editshippingInfocity = common.getValue("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_CITY + "']");
		System.out.println("Step :: Verify Shipping Info City >> " + editshippingInfocity);
		common.log("<br></br> Step :: Verify Shipping Info City");

		String editshippingInfostate = common.getText("//*[@id='" + LEGACY_USER_LST_SHIPPING_INFO_EDIT_STATE + "']");
		System.out.println("Step :: Verify Shipping info State >> " + editshippingInfostate);
		common.log("<br></br> Step :: Verify Shipping info State");

		String editshippingInfozip = common.getValue("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_ZIP + "']");
		System.out.println("Step :: Verify Shipping Zip >> " + editshippingInfozip);
		common.log("<br></br> Step :: Verify Shipping Zip");

	}

	/**
	 * Simplified Signup Field
	 * 
	 * 
	 * @param FirstName
	 * @param LastName
	 * @param EmailUser
	 * @param signUpUser
	 * @throws InterruptedException
	 */
	public void simplifiedSignupFiled(String FirstName, String LastName, String EmailUser, String signUpUser)
			throws InterruptedException {

		System.out.println("SignupUser Details");

		common.pause(20);
		System.out.println("Step :: Admin logout front");
		common.log("<br></br> Step :: Admin logout front");

		common.pause(25);

		System.out.println("Step :: SignupUSer Details.");
		common.log("<br></br> Step :: SignupUSer Details.");
		common.jsClick(signUpLink);

		common.pause(40);

		System.out.println("Step :: Enter User Name : " + signUpUser);
		common.log("<br></br> Step :: Enter User Name : " + signUpUser);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']", signUpUser);

		System.out.println("Step :: Enter Password");
		common.log("<br></br> Step :: Enter Password");
		common.type("//input[@id= '" + LEGACY_USER_SIGNUP_TXT_PASSWORD + "']", LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);
		System.out.println("Random Value :" + signUpUser);

		System.out.println("Step :: Enter Confirm Password");
		common.log("<br></br> Step :: Enter Confirm Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_PASSWORD + "']", signUpUser);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_LAST_NAME + "']", signUpUser);

		System.out.println("Step :: Enter Email");
		common.log("<br></br> Step :: Enter Email");
		System.out.println("New User >>" + "  " + signUpUser);

		System.out.println("Step :: Enter First Name.");
		common.log("<br></br> Step :: Enter First Name.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_FIRST_NAME + "']", signUpUser);

		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']", signUpUser);

		System.out.println("Step :: Enter Last Name.");
		common.log("<br></br> Step :: Enter Last Name.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_PASSWORD + "']",
				LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_EMAIL + "']",
				EmailUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);

		// common.jsClick(editBoxOfPhone);
		common.log("<br></br>Enter Phone Number...");
		System.out.println("Enter Phone Number...");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		Select_User_Info_Phone_Type();
		common.pause(15);

		Select_Identification_Type(); // Select Identification Type

		Enter_CC_Details();

		common.pause(10);

		System.out.println("Step :: Entering Captcha.");
		common.log("<br></br>Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(40);
		common.waitForElement(By.xpath("//ul[@id='messages']"));

	}

	/**
	 * 
	 * Verify simplified signup
	 * 
	 * @param signUpUser
	 * @param EmailUser
	 * @throws InterruptedException
	 */
	public void verifySimplifiedSignup(String signUpUser, String EmailUser) throws InterruptedException

	{

		String IdentificationType = "1"; // Identification Type
		String Identification = "Perfect QA Services";
		String UserRole = "1"; // 1 = "Bidder"
		String Country = "1"; // 1 = United States
		String State = "8"; // 8 = California
		String PhoneType = "1"; // 1 = work
		String PhoneNumber = "718-343-2012";
		String billingAddress = "466 green st";
		String billingCity = "san francisco";

		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		System.out.println("Click on profile");

		common.jsClick(selectprofile);
		common.pause(40);

		common.waitForElement(By.xpath("//*[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']"));

		String editprofileUsername = common.getValue("//*[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']");
		System.out.println(editprofileUsername + " :: verify Profile username");
		common.log("<br></br> Step :: verify profile username");

		String editprofileFirstname = common.getValue("//*[@id='" + LEGACY_USER_TXT_PROFILE_FIRST_NAME + "']");
		System.out.println(editprofileFirstname + "verify Profile first name");
		common.log("<br></br> Step :: verify profile Firstname");

		String editprofileLastname = common.getValue("//*[@id='" + LEGACY_USER_TXT_PROFILE_LAST_NAME + "']");
		System.out.println(editprofileLastname + " :: verify Profile last name");
		common.log("<br></br> Step :: verify profile last name");

		String editprofileEmail = common.getValue("//*[@id='" + LEGACY_USER_TXT_PROFILE_EMAIL + "']");
		System.out.println(editprofileEmail + "  :: verify Profile email address");
		common.log("<br></br> Step :: verify profile email address");

		String editprofilePhone = common.getValue("//*[@id='" + LEGACY_USER_TXT_PROFILE_PHONE + "']");
		System.out.println(editprofilePhone + " :: verify Profile phone");
		common.log("<br></br> Step :: verify profile phone");

		String editprofilePhonetype = common.getValue("//*[@id='" + LEGACY_USER_TXT_PROFILE_PHONE_TYPE + "']");
		System.out.println(editprofilePhonetype + " :: verify phone type");
		common.log("<br></br> Step :: verify profile phone type");

		String editprofileIdentification = common.getValue("//*[@id='" + LEGACY_USER_TXT_PROFILE_IDENTIFICATION + "']");
		System.out.println(editprofileIdentification + " :: verify Profile identification");
		common.log("<br></br> Step :: verify profile identification");

		String editprofileIdentificationtype = common
				.getValue("//*[@id='" + LEGACY_USER_TXT_PROFILE_IDENTIFICATION_TYPE + "']");
		System.out.println(editprofileIdentificationtype + " :: verify Profile identification type");
		common.log("<br></br> Step :: verify profile identificationtype");

		// Simplified Signup

		common.assertTwoValuesAreEqual(editprofileUsername, signUpUser);
		common.assertTwoValuesAreEqual(editprofileFirstname, signUpUser);
		common.assertTwoValuesAreEqual(editprofileLastname, signUpUser);
		common.assertTwoValuesAreEqual(editprofileEmail.substring(0, editprofileEmail.length() - 22), EmailUser);
		common.assertTwoValuesAreEqual(editprofilePhone, PhoneNumber);
		common.assertTwoValuesAreEqual(editprofilePhonetype, PhoneType);
		// common.assertTwoValuesAreEqual(editprofileIdentificationtype,
		// IdentificationType);
		// common.assertTwoValuesAreEqual(editprofileUserole22, UserRole);

	}

	/**
	 * Verify Address
	 * 
	 * @param signUpUser
	 * @param EmailUser
	 * @throws InterruptedException
	 */

	public void verifyaddress(String signUpUser, String EmailUser) throws InterruptedException

	{

		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		System.out.println("Click on profile");

		common.jsClick(selectprofile);

		common.waitForConditionIsElementPresent("//div[@class='form user-info-form']");

		String editprofileUsername = common.getValue("//*[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']");
		System.out.println(editprofileUsername + " :: verify Profile username");
		common.log("<br></br> Step :: verify profile username");

		String editprofileFirstname = common.getValue("//*[@id='" + LEGACY_USER_TXT_PROFILE_FIRST_NAME + "']");
		System.out.println(editprofileFirstname + "verify Profile first name");
		common.log("<br></br> Step :: verify profile Firstname");

		String editprofileLastname = common.getValue("//*[@id='" + LEGACY_USER_TXT_PROFILE_LAST_NAME + "']");
		System.out.println(editprofileLastname + " :: verify Profile last name");
		common.log("<br></br> Step :: verify profile last name");

		String editprofileEmail = common.getValue("//*[@id='" + LEGACY_USER_TXT_PROFILE_EMAIL + "']");
		System.out.println(editprofileEmail + "  :: verify Profile email address");
		common.log("<br></br> Step :: verify profile email address");

		String editprofilePhone = common.getValue("//*[@id='" + LEGACY_USER_TXT_PROFILE_PHONE + "']");
		System.out.println(editprofilePhone + " :: verify Profile phone");
		common.log("<br></br> Step :: verify profile phone");

		String editprofilePhonetype = common.getValue("//*[@id='" + LEGACY_USER_TXT_PROFILE_PHONE_TYPE + "']");
		System.out.println(editprofilePhonetype + " :: verify phone type");
		common.log("<br></br> Step :: verify profile phone type");

		String editprofileIdentification = common.getValue("//*[@id='" + LEGACY_USER_TXT_PROFILE_IDENTIFICATION + "']");
		System.out.println(editprofileIdentification + " :: verify Profile identification");
		common.log("<br></br> Step :: verify profile identification");

		String editprofileIdentificationtype = common
				.getValue("//*[@id='" + LEGACY_USER_TXT_PROFILE_IDENTIFICATION_TYPE + "']");
		System.out.println(editprofileIdentificationtype + " :: verify Profile identification type");
		common.log("<br></br> Step :: verify profile identificationtype");

		String editprofileCompany = common.getValue("//*[@id='" + LEGACY_USER_TXT_PROFILE_USERROLE22 + "']");
		System.out.println(editprofileCompany + " :: verify Profile company");
		common.log("<br></br> Step :: verify profile company");

		String editprofileUserole22 = common.getValue("//*[@id='" + LEGACY_USER_TXT_PROFILE_USERROLE22 + "']");
		System.out.println(editprofileUserole22 + " :: verify Profile userrole");
		common.log("<br></br> Step :: verify profile userrole22");

		// Simplified Signup field verify

	}

	/**
	 * 
	 * Verify Shipping Address During Sale Registration
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */

	public void verifyShippingAddressSaleRegistration(String signUpUser) throws InterruptedException

	{

		// verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		common.waitForElement(By.xpath("//a[text()='Auctions']"));
		common.jsClick(AuctionMenu);
		common.pause(30);

		common.log("<br></br> Step :: Click on register to bid!");
		System.out.println("Step :: Click on register to bid!");
		driver.findElement(By.xpath("//a[text()='Register to bid!']")).click();
		common.pause(30);

		// Sale Registration

		String IdentificationType = "2"; // Identification Type
		String Identification = "Perfect QA Services";
		String UserRole = "1"; // 1 = "Bidder"
		String Country = "2"; // 1 = United States
		String State = "1"; // 8 = California
		String PhoneType = "null"; // 1 = work
		String PhoneNumber = "718-343-2012";
		String billingAddress = "466 green st";
		String billingCity = "san francisco";
		String zip = "94133";

		// Shipping info sale registration

		String editshippingInfocontacttype = common.getValue("//span[@id='psp15_ctl']");
		System.out.println("Step :: Verify Shipping info Contact Type >> " + editshippingInfocontacttype);
		common.log("<br></br> Step :: verify shipping info contact type");

		String editshippingInfofirstname = common
				.getValue("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_FIRST_NAME + "']");
		System.out.println("Step :: Verify Shipping Info first name >>" + editshippingInfofirstname);
		common.log("<br></br> Step :: verify shipping info first name");

		String editshippingInfolastname = common
				.getValue("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_LAST_NAME + "']");
		System.out.println("Step :: Verify Shipping Info Last Name >>" + editshippingInfolastname);
		common.log("<br></br> Step :: verify shipping info last name");

		String editshippingInfophone = common.getValue("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_PHONE + "']");
		System.out.println("Step :: Verify Shipping Info Phone Type >>" + editshippingInfophone);
		common.log("<br></br> Step :: verify shipping info phonetype");

		String editshippingInfocountry = common
				.getValue("//*[@id='" + LEGACY_USER_LST_SHIPPING_INFO_EDIT_COUNTRY + "']");
		System.out.println("Step :: Verify Shipping Info Country >> " + editshippingInfocountry);
		common.log("<br></br> Step :: verify shipping info country");

		String editshippingInfoaddress = common
				.getValue("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_ADDRESS + "']");
		System.out.println("Step :: Verify Shipping Info Address >> " + editshippingInfoaddress);
		common.log("<br></br> Step :: verify shipping info address");

		String editshippingInfocity = common.getValue("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_CITY + "']");
		System.out.println("Step :: Verify Shipping Info City >> " + editshippingInfocity);
		common.log("<br></br> Step :: verify shipping info city");

		String editshippingInfostate = common.getValue("//*[@id='" + LEGACY_USER_LST_SHIPPING_INFO_EDIT_STATE + "']");
		System.out.println("Step :: Verify Shipping Info State >> " + editshippingInfostate);
		common.log("<br></br> Step :: verify shipping info state");

		String editshippingInfozip = common.getValue("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_ZIP + "']");
		System.out.println("Step :: Verify Shipping Info Zip >> " + editshippingInfozip);
		common.log("<br></br> Step :: verify shipping zip");

		// shipping field verify

		// common.assertTwoValuesAreEqual(editshippingInfocontacttype, PhoneType);
		common.assertTwoValuesAreEqual(editshippingInfofirstname, signUpUser);
		common.assertTwoValuesAreEqual(editshippingInfolastname, signUpUser);
		common.assertTwoValuesAreEqual(editshippingInfophone, PhoneNumber);
		common.assertTwoValuesAreEqual(editshippingInfocountry, Country);
		common.assertTwoValuesAreEqual(editshippingInfoaddress, billingAddress);
		common.assertTwoValuesAreEqual(editshippingInfocity, billingCity);
		common.assertTwoValuesAreEqual(editshippingInfostate, State);
		common.assertTwoValuesAreEqual(editshippingInfozip, zip);
	}

	/**
	 * Edit First Name in Shipping info
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */
	public void editFirstNameShippingAddressSaleRegistration(String signUpUser) throws InterruptedException

	{

		// verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		common.waitForConditionIsElementPresent("//a[text()='Auctions']");
		common.jsClick(AuctionMenu);
		common.pause(30);
		common.log("<br></br> Step :: Click on register to bid!");
		System.out.println("Step :: Click on register to bid!");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_USER_BTN_REGISTER_BID + "']")).click();
		common.pause(30);

		// Edit Shipping info sale registration
		String firstname = common.getValue("//input[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_FIRST_NAME + "']");
		System.out.println("Step :: First Name After Edit >> " + firstname);

		String editfirstname = "samfirstname";
		System.out.println("Step :: Edit First Name.");
		common.log("<br></br> Step :: Edit First Name.");
		common.pause(10);
		common.type("//input[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_FIRST_NAME + "']", editfirstname);

		String newfirstname = common.getValue("//input[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_FIRST_NAME + "']");
		System.out.println("Step :: First Name After Edit >> " + newfirstname);

		System.out.println("Step :: Click on submit button.");
		common.log("<br></br> Step :: Click on submit button.");
		// common.waitForElement("//input[@value='Submit']");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		common.pause(25);

		System.out.println("Step :: Select T&C");
		common.log("<br></br> Step :: Select T&C");
		driver.findElement(By.xpath("//label[contains(text(),'I agree to the terms and conditions above')]")).click();
		common.pause(10);
		System.out.println("Step :: Click Confirm button");
		common.log("<br></br> Step :: Click confirm button");
		driver.findElement(By.xpath("//input[@id='tac01']")).click();
		common.pause(20);

		common.assertElementPresent("//ul[@id='messages']");
		String Success_Msg = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Step :: " + Success_Msg);

	}

	/**
	 * 
	 * Edit Last Name shipping during sale registration
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */

	public void editLastNameShippingAddressSaleRegistration(String signUpUser) throws InterruptedException {

		// verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		common.waitForConditionIsElementPresent("//a[text()='Auctions']");
		common.jsClick(AuctionMenu);
		common.pause(30);

		common.log("<br></br> Step :: Click on register to bid!");
		System.out.println("Step :: Click on register to bid!");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_USER_BTN_REGISTER_BID + "']")).click();
		common.pause(40);

		// Edit Shipping info sale registration
		String lastname = common.getValue("//input[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_LAST_NAME + "']");
		System.out.println("Step :: Last Name >> " + lastname);

		String editlastname = "samlastname";
		System.out.println("Step :: Edit Last Name.");
		common.log("<br></br> Step :: Edit Last Name.");
		common.pause(10);
		common.type("//input[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_LAST_NAME + "']", editlastname);

		String newlastname = common.getValue("//input[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_LAST_NAME + "']");
		System.out.println("Step :: Last Name After Edit >> " + newlastname);

		System.out.println("Step :: Click on submit button.");
		common.log("<br></br> Step :: Click on submit button.");
		// common.waitForElement("//input[@value='Submit']");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		common.pause(25);

		System.out.println("Step :: Select T&C");
		common.log("<br></br> Step :: Select T&C");
		driver.findElement(By.xpath("//label[contains(text(),'I agree to the terms and conditions above')]")).click();
		common.pause(10);
		System.out.println("Step :: Click Confirm button");
		common.log("<br></br> Step :: Click confirm button");
		driver.findElement(By.xpath("//input[@id='tac01']")).click();
		common.pause(20);

		common.assertElementPresent("//ul[@id='messages']");
		String Success_Msg = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Step :: " + Success_Msg);

	}

	/**
	 * Edit Phone Number shipping during sale registration
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */
	public void editPhoneNumberShippingAddressSaleRegistration(String signUpUser) throws InterruptedException

	{

		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		common.pause(30);

		common.log("<br></br> Step :: Click on register to bid!");
		System.out.println("Step :: Click on register to bid!");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_USER_BTN_REGISTER_BID + "']")).click();
		common.pause(40);

		// Edit Shipping info sale registration

		String oldphone = common.getValue("//input[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_PHONE + "']");
		System.out.println("Step :: PhoneNumber >> " + oldphone);

		String editphonenumber = "7183232015";
		System.out.println("Step :: Edit Phone Number.");
		common.log("<br></br> Step :: Edit Phone Number.");
		common.pause(10);
		common.type("//input[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_PHONE + "']", editphonenumber);

		String newPhone = common.getValue("//input[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_PHONE + "']");
		System.out.println("Step :: PhoneNumber After Edit >> " + newPhone);

		System.out.println("Step :: Click on submit button.");
		common.log("<br></br> Step :: Click on submit button.");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		common.pause(20);

		System.out.println("Step :: Select T&C");
		common.log("<br></br> Step :: Select T&C");
		driver.findElement(By.xpath("//label[contains(text(),'I agree to the terms and conditions above')]")).click();
		common.pause(20);
		System.out.println("Step :: Click Confirm button");
		common.log("<br></br> Step :: Click confirm button");
		driver.findElement(By.xpath("//input[@id='tac01']")).click();
		common.pause(30);

		common.assertElementPresent("//ul[@id='messages']");
		String Success_Msg = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Step :: " + Success_Msg);

	}

	/**
	 * Edit Address shipping during sale registration
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */

	public void editAddressShippingaddressSaleRegistration(String signUpUser) throws InterruptedException

	{

		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		common.waitForConditionIsElementPresent("//a[text()='Auctions']");
		common.jsClick(AuctionMenu);
		common.pause(30);

		common.log("<br></br> Step :: Click on register to bid!");
		System.out.println("Step :: Click on register to bid!");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_USER_BTN_REGISTER_BID + "']")).click();
		common.pause(40);

		// Edit Shipping info sale registration

		String address = common.getValue("//input[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_ADDRESS + "']");
		System.out.println("Step :: Address >> " + address);

		String editaddress = "555 green st";
		System.out.println("Step :: Edit Address.");
		common.log("<br></br> Step :: Edit Address.");
		common.pause(10);
		common.type("//input[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_ADDRESS + "']", editaddress);

		String newaddress = common.getValue("//input[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_ADDRESS + "']");
		System.out.println("Step :: New Address After Edit >> " + newaddress);

		driver.findElement(By.xpath("//input[@id='pnpsp6']")).sendKeys("7878787878");

		System.out.println("Step :: Click on submit button.");
		common.log("<br></br> Step :: Click on submit button.");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		common.pause(50);

		System.out.println("Step :: Select Terms and Conditions");
		common.log("<br></br> Step :: Select Terms and Conditions");
		driver.findElement(By.xpath("//label[text()='I agree to the terms and conditions above']")).click();

		System.out.println("Step :: Click on Confirm");
		common.log("<br></br> Step :: Click on Confirm");
		driver.findElement(By.xpath("//input[@id='tac01']")).click();

		common.pause(40);
		common.assertElementPresent("//ul[@id='messages']");
		String Success_Msg = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Step :: " + Success_Msg);
	}

	/**
	 * Edit City shipping during sale registration
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */
	public void editCityShippingAddressSaleRegistration(String signUpUser) throws InterruptedException

	{

		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		common.pause(50);

		common.log("<br></br> Step :: Click on register to bid!");
		System.out.println("Step :: Click on register to bid!");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_USER_BTN_REGISTER_BID + "']")).click();
		common.pause(40);

		// Edit Shipping info sale registration

		String city = common.getValue("//input[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_CITY + "']");
		System.out.println("Step :: City >> " + city);

		String editcity = "New York";
		System.out.println("Step :: Edit City.");
		common.log("<br></br> Step :: Edit City.");
		common.pause(10);
		common.type("//input[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_CITY + "']", editcity);

		String newcity = common.getValue("//input[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_CITY + "']");
		System.out.println("Step :: New City After Edit >> " + newcity);

		driver.findElement(By.xpath("//input[@id='pnpsp6']")).sendKeys("7878787878");

		System.out.println("Step :: Click on submit button.");
		common.log("<br></br> Step :: Click on submit button.");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		common.pause(50);

		System.out.println("Step :: Select Terms and Conditions");
		common.log("<br></br> Step :: Select Terms and Conditions");
		driver.findElement(By.xpath("//label[text()='I agree to the terms and conditions above']")).click();

		System.out.println("Step :: Click on Confirm");
		common.log("<br></br> Step :: Click on Confirm");
		driver.findElement(By.xpath("//input[@id='tac01']")).click();

		common.pause(30);
		common.assertElementPresent("//ul[@id='messages']");
		String Success_Msg = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Step :: " + Success_Msg);
	}

	/**
	 * Edit State shipping during sale registration
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */

	public void editStateShippingAddressSaleRegistration(String signUpUser) throws InterruptedException

	{

		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		common.pause(50);

		common.log("<br></br> Step :: Click on register to bid!");
		System.out.println("Step :: Click on register to bid!");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_USER_BTN_REGISTER_BID + "']")).click();
		common.pause(50);
		// Edit Shipping info sale registration

		String state = common.getValue("//select[@id='" + LEGACY_USER_LST_SHIPPING_INFO_EDIT_STATE + "']");
		System.out.println("Step :: State >> " + state);

		// Edit Shipping info sale registration
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 500)", "");
		common.pause(10);

		System.out.println("Step :: Select Country.");
		common.log("<br></br>Step :: Select Country.");
		Actions Country = new Actions(driver);
		common.pause(10);
		WebElement SelectCounrty = driver.findElement(By.xpath("//select[@id='psp7']//..//..//a[@role='button']"));
		SelectCounrty.click();
		common.pause(25);

		// driver.findElement(By.xpath("//select[@id='psp7']//..//..//a[text()='United
		// States']")).click();
//		WebElement select_USA = driver.findElement(By.linkText("United States"));
//		common.pause(10);
//		Country.moveToElement(select_USA);
//		Country.moveToElement(select_USA).click().perform();
//		common.pause(10);

		String newstate = common.getValue("//select[@id='" + LEGACY_USER_LST_SHIPPING_INFO_EDIT_STATE + "']");
		System.out.println("Step :: New State >> " + newstate);

		driver.findElement(By.xpath("//input[@id='pnpsp6']")).sendKeys("7878787878");

		System.out.println("Step :: Click on submit button.");
		common.log("<br></br> Step :: Click on submit button.");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		common.pause(50);

		System.out.println("Step :: Select Terms and Conditions");
		common.log("<br></br> Step :: Select Terms and Conditions");
		driver.findElement(By.xpath("//label[text()='I agree to the terms and conditions above']")).click();

		System.out.println("Step :: Click on Confirm");
		common.log("<br></br> Step :: Click on Confirm");
		driver.findElement(By.xpath("//input[@id='tac01']")).click();

		common.pause(30);
		common.assertElementPresent("//ul[@id='messages']");
		String Success_Msg = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Step :: " + Success_Msg);

	}

	/**
	 * Edit Country
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */

	public void editCountryShippingAddressSaleRegistration(String signUpUser) throws InterruptedException

	{

		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		common.pause(30);

		common.log("<br></br> Step :: Click on register to bid!");
		System.out.println("Step :: Click on register to bid!");
		common.waitForElement(By.xpath("//a[text()='" + LEGACY_USER_BTN_REGISTER_BID + "']"));
		driver.findElement(By.xpath("//a[text()='" + LEGACY_USER_BTN_REGISTER_BID + "']")).click();
		common.pause(50);

		// Edit Shipping info sale registration

		String Counrty = common.getValue(
				"//span[@id='psp7_ctl']//input[@class='custom-combobox-input ui-widget ui-widget-content ui-state-default ui-corner-left ui-autocomplete-input']");
		System.out.println("Step :: Country >> " + Counrty);

		// Edit Shipping info sale registration
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 500)", "");
		common.pause(10);

		System.out.println("Step :: Select Country.");
		common.log("<br></br>Step :: Select Country.");
		Actions Country = new Actions(driver);
		common.pause(10);
		WebElement SelectCounrty = driver.findElement(By.xpath("//select[@id='psp7']//..//..//a[@role='button']"));
		SelectCounrty.click();
		common.pause(10);
		// driver.findElement(By.xpath("//li[@class='profile-shipping-country']//option[2]")).click();
		// driver.findElement(By.xpath("//select[@id='psp7']//option[@data-id='US']")).click();
//		WebElement select_USA = driver.findElement(By.linkText("United States"));
//		common.pause(10);
//		Country.moveToElement(select_USA);
//		Country.moveToElement(select_USA).click().perform();
//		common.pause(10);

		String newCounrty = common.getValue("//select[@id='" + LEGACY_USER_LST_SHIPPING_INFO_EDIT_COUNTRY + "']");
		System.out.println("Step :: New Country >> " + newCounrty);

		driver.findElement(By.xpath("//input[@id='pnpsp6']")).sendKeys("7878787878");

		System.out.println("Step :: Click on submit button.");
		common.log("<br></br> Step :: Click on submit button.");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		common.pause(40);

		System.out.println("Step :: Select Terms and Conditions");
		common.log("<br></br> Step :: Select Terms and Conditions");
		driver.findElement(By.xpath("//label[text()='I agree to the terms and conditions above']")).click();

		System.out.println("Step :: Click on Confirm");
		common.log("<br></br> Step :: Click on Confirm");
		driver.findElement(By.xpath("//input[@id='tac01']")).click();
		common.pause(35);

		common.assertElementPresent("//ul[@id='messages']");
		String Success_Msg = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Step :: " + Success_Msg);

	}

	/**
	 * Edit Zip code
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */

	public void editZipShippingAddressSaleRegistration(String signUpUser) throws InterruptedException

	{

		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		common.waitForConditionIsElementPresent("//a[text()='Auctions']");
		common.jsClick(AuctionMenu);
		common.pause(30);

		common.log("<br></br> Step :: Click on register to bid!");
		System.out.println("Step :: Click on register to bid!");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_USER_BTN_REGISTER_BID + "']")).click();
		common.pause(40);

		// Edit Shipping info sale registration

		String zipcode = common.getValue("//input[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_ZIP + "']");
		System.out.println("Step :: Zip Code >> " + zipcode);

		System.out.println("Step :: Edit Zip.");
		common.log("<br></br>Step :: Edit Zip.");
		common.pause(10);
		common.type("//input[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_ZIP + "']",
				LEGACY_USER_TXT_SHIPPING_INFO_EDIT_ZIP_VALUE_SHIPPING);

		String newzipcode = common.getValue("//input[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_ZIP + "']");
		System.out.println("Step :: New ZipCode >> " + newzipcode);

		driver.findElement(By.xpath("//input[@id='pnpsp6']")).sendKeys("7878787878");

		System.out.println("Step :: Click on submit button.");
		common.log("<br></br> Step :: Click on submit button.");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		common.pause(50);

		System.out.println("Step :: Select Terms and Conditions");
		common.log("<br></br> Step :: Select Terms and Conditions");
		driver.findElement(By.xpath("//label[text()='I agree to the terms and conditions above']")).click();

		System.out.println("Step :: Click on Confirm");
		common.log("<br></br> Step :: Click on Confirm");
		driver.findElement(By.xpath("//input[@id='tac01']")).click();

		common.pause(20);
		common.assertElementPresent("//ul[@id='messages']");
		String Success_Msg = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Step :: " + Success_Msg);

	}

	public void rememberShippingPreferenceAddressSaleRegistration(String signUpUser) throws InterruptedException

	{

		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		common.waitForConditionIsElementPresent("//a[text()='Auctions']");
		common.jsClick(AuctionMenu);
		common.pause(30);

		common.log("<br></br> Step :: Click on register to bid!");
		System.out.println("Step :: Click on register to bid!");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_USER_BTN_REGISTER_BID + "']")).click();
		common.pause(40);

		// Edit Shipping info sale registration

		System.out.println("Step :: Edit Zip.");
		common.log("<br></br>Step :: Edit Zip.");
		common.pause(10);
		common.type("//input[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_ZIP + "']",
				LEGACY_USER_TXT_SHIPPING_INFO_EDIT_ZIP_VALUE_SHIPPING);

		System.out.println("Step :: Click on Remember shipping preference in profile");
		common.log("<br></br>Step :: Click on Remember shipping preference in profile");
		common.waitForElement(
				"//input[@id='" + LEGACY_USER_CHK_CLICK_ON_REMEMBER_SHIPPING_PREFERENCE_IN_PROFILE + "']");
		driver.findElement(
				By.xpath("//input[@id='" + LEGACY_USER_CHK_CLICK_ON_REMEMBER_SHIPPING_PREFERENCE_IN_PROFILE + "']"))
				.click();
		common.pause(10);
		System.out.println("Step :: Click on submit button.");
		common.log("<br></br> Step :: Click on submit button.");

		common.waitForElement("//input[@value='Submit']");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		common.pause(10);
		System.out.println("Click on profile");

		common.jsClick(selectprofile);
		common.pause(40);

		String zip = "32482";
		String editshippingInfozip = driver.findElement(By.xpath("//input[@id='psp13']")).getAttribute("value");
		System.out.println(editshippingInfozip + " :: verify shipping zip");
		common.log("<br></br> Step :: verify shipping zip");
		common.assertTwoValuesAreEqual(editshippingInfozip, zip); // verify zip
																	// code from
																	// account

	}

	/**
	 * Remember shipping refrence
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */

	public void rememberShippingPreferenceCheckboxUncheckAddressSaleRegistration(String signUpUser)
			throws InterruptedException {

		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		common.waitForConditionIsElementPresent("//a[text()='Auctions']");
		common.jsClick(AuctionMenu);
		common.pause(30);

		common.log("<br></br> Step :: Click on register to bid!");
		System.out.println("Step :: Click on register to bid!");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_USER_BTN_REGISTER_BID + "']")).click();
		common.pause(40);

		// Edit Shipping info sale registration

		System.out.println("Step :: Edit Zip.");
		common.log("<br></br>Step :: Edit Zip.");
		common.pause(15);
		common.type("//input[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_ZIP + "']",
				LEGACY_USER_TXT_SHIPPING_INFO_EDIT_ZIP_VALUE_SHIPPING);
		common.pause(10);

		System.out.println("Step :: Click on submit button.");
		common.log("<br></br> Step :: Click on submit button.");
		common.waitForElement("//input[@value='Submit']");
		driver.findElement(By.xpath("//input[@value='Submit']")).click();
		common.pause(10);

		System.out.println("Click on profile");

		common.jsClick(selectprofile);
		common.pause(40);

		String zip = "32482";
		String editshippingInfozip = common.getValue("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_ZIP + "']");
		System.out.println(editshippingInfozip + " :: verify shipping zip");
		common.log("<br></br> Step :: verify shipping zip");
		common.assertTwoValuesAreEqual(editshippingInfozip, zip); // verify zip
																	// code from
																	// account

	}

	/**
	 * Edit First Name in Profile
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */

	public void editFirstNameInProfile(String signUpUser) throws InterruptedException

	{
		// verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		common.waitForConditionIsElementPresent("//a[text()='Auctions']");
		common.jsClick(AuctionMenu);
		common.pause(30);

		System.out.println("Click on profile");
		common.jsClick(selectprofile);
		common.pause(40);
		// common.waitForElement(By.xpath("//div[@id='ProfilePersonalPanel']"));

		String editFirstname = "samfirstname";
		System.out.println("Step :: Enter First Name.");
		common.log("<br></br> Step :: Enter First Name.");
		common.type("//input[@id='" + LEGACY_USER_TXT_PROFILE_FIRST_NAME + "']", editFirstname);

		String newname = common.getValue("//input[@id='" + LEGACY_USER_TXT_PROFILE_FIRST_NAME + "']");
		System.out.println("Step :: First Name after edit >> " + newname);
		common.pause(5);

		System.out.println("Step :: Click on save changes button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_SAVE_CHANGES + "']")).click();
		common.pause(10);

		System.out.println("Step :: verify save message");
		String sucessmsg = driver.findElement(By.xpath("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']"))
				.getText();
		System.out.println("Step :: Success Message >> " + sucessmsg);
		common.assertElementPresent("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']");
		common.pause(5);
	}

	/**
	 * Edit Last Name in Profile
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */
	public void editLastNameInProfile(String signUpUser) throws InterruptedException

	{
		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		common.waitForConditionIsElementPresent("//a[text()='Auctions']");
		common.jsClick(AuctionMenu);
		common.pause(30);

		common.pause(10);
		System.out.println("Click on profile");
		common.jsClick(selectprofile);
		common.pause(40);

		String editlastname = "samlastname";

		System.out.println("Step :: Enter Last Name.");
		common.log("<br></br> Step :: Enter Last Name.");
		common.type("//input[@id='" + LEGACY_USER_TXT_PROFILE_LAST_NAME + "']", editlastname);

		String newlastname = common.getValue("//input[@id='" + LEGACY_USER_TXT_PROFILE_LAST_NAME + "']");
		System.out.println("Step :: Last Name after edit >> " + newlastname);
		common.pause(5);
		System.out.println("Step :: Click on save changes button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_SAVE_CHANGES + "']")).click();
		common.pause(20);

		System.out.println("Step :: verify save message");
		String sucessmsg = driver.findElement(By.xpath("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']"))
				.getText();
		System.out.println("Step :: Success Message >> " + sucessmsg);
		common.assertElementPresent("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']");
		common.pause(5);
	}

	/**
	 * Edit Phone in Profile
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */

	public void editPhoneInProfile(String signUpUser) throws InterruptedException

	{
		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		common.waitForConditionIsElementPresent("//a[text()='Auctions']");
		common.jsClick(AuctionMenu);
		common.pause(30);
		System.out.println("Click on profile");
		common.jsClick(selectprofile);
		common.pause(40);

		String editphonenumber = "4587458774";
		System.out.println("Step :: Enter Phone Number.");
		common.log("<br></br> Step :: Enter Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_TXT_PROFILE_PHONE + "']", editphonenumber);

		String newphoneno = common.getValue("//input[@id='" + LEGACY_USER_TXT_PROFILE_PHONE + "']");
		System.out.println("Step :: New Phone Number After edit >> " + newphoneno);
		common.pause(5);

		System.out.println("Step :: Click on save changes button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_SAVE_CHANGES + "']")).click();
		common.pause(30);

		System.out.println("Step :: verify save message");
		String sucessmsg = driver.findElement(By.xpath("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']"))
				.getText();
		System.out.println("Step :: Success Message >> " + sucessmsg);
		common.assertElementPresent("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']");
		common.pause(5);
	}

	/**
	 * Edit Phone Type in profile
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */
	public void editPhoneTypeInProfile(String signUpUser) throws InterruptedException {

		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		common.waitForConditionIsElementPresent("//a[text()='Auctions']");
		common.jsClick(AuctionMenu);
		common.pause(30);

		System.out.println("Click on profile");
		common.jsClick(selectprofile);

		common.pause(40);

		String phonetype = common.getValue("//select[@id='pip14']");
		System.out.println("Step :: Phone type >> " + phonetype);
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		jse.executeScript("window.scrollBy(0, 550)", "");

		System.out.println("Step :: Edit phone type.");
		common.log("<br></br>Step :: Edit Phone Type.");

		common.pause(10);
		WebElement element = driver.findElement(By.xpath("//select[@id='pip14']//..//..//a[text()='Work']"));
		element.click();
		common.pause(20);

		// Select Phone Type

		driver.findElement(By.xpath("//select[@id='pip14']//..//..//a[text()='Home']")).click();

		String newphonetype = common.getValue("//select[@id='pip14']");
		System.out.println("Step :: After Edit Phone type >> " + newphonetype);
		common.pause(5);
		System.out.println("Step :: Click on save changes button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_SAVE_CHANGES + "']")).click();
		common.pause(25);

		System.out.println("Step :: verify save message");
		String sucessmsg = driver.findElement(By.xpath("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']"))
				.getText();
		System.out.println("Step :: Success Message >> " + sucessmsg);
		common.assertElementPresent("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']");
		common.pause(5);
	}

	/**
	 * Edit First Name in billing info
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */

	public void editFirstNameInBillingInfo(String signUpUser) throws InterruptedException

	{
		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		common.waitForConditionIsElementPresent("//a[text()='Auctions']");
		common.jsClick(AuctionMenu);
		common.pause(30);

		System.out.println("Click on profile");
		common.jsClick(selectprofile);
		common.pause(30);

		String editfirstname = common.getValue("//input[@id='" + LEGACY_USER_TXT_BILLING_FIRST_NAME + "']");
		System.out.println("Step :: First Name >> " + editfirstname);

		String editfirstname1 = "billingfirst";
		System.out.println("Step :: Enter First Name.");
		common.log("<br></br> Step :: Enter First Name.");
		common.type("//input[@id='" + LEGACY_USER_TXT_BILLING_FIRST_NAME + "']", editfirstname1);

		String newfname = common.getValue("//input[@id='" + LEGACY_USER_TXT_BILLING_FIRST_NAME + "']");
		System.out.println("Step :: First Name After Edit >> " + newfname);
		common.pause(5);
		System.out.println("Step :: Click on save changes button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_SAVE_CHANGES + "']")).click();
		common.pause(30);

		System.out.println("Step :: Verify Save Message");
		String sucessmsg = driver.findElement(By.xpath("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']"))
				.getText();
		System.out.println("Step :: Success Message >> " + sucessmsg);
		common.assertElementPresent("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']");
	}

	/**
	 * 
	 * Edit Last name in billing info
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */
	public void editLastNameInBillingInfo(String signUpUser) throws InterruptedException

	{
		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		common.waitForConditionIsElementPresent("//a[text()='Auctions']");
		common.jsClick(AuctionMenu);
		common.pause(30);

		System.out.println("Click on profile");
		common.jsClick(selectprofile);
		common.pause(30);
		common.waitForElement(By.xpath("//div[@id='ProfilePersonalPanel']"));

		String editlastname = "billinglast";
		System.out.println("Step :: Enter Last Name.");
		common.log("<br></br> Step :: Enter Last Name.");
		common.type("//input[@id='" + LEGACY_USER_TXT_BILLING_LAST_NAME + "']", editlastname);
		common.pause(5);

		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_SAVE_CHANGES + "']")).click();
		common.pause(30);

		System.out.println("Step :: verify save message");
		common.assertElementPresent("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']");

	}

	/**
	 * Edit Phone number in billing info
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */

	public void editPhoneNumberInBillingInfo(String signUpUser) throws InterruptedException

	{
		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		common.waitForConditionIsElementPresent("//a[text()='Auctions']");
		common.jsClick(AuctionMenu);
		common.pause(30);

		System.out.println("Click on profile");
		common.jsClick(selectprofile);
		common.pause(30);

		String editphonenumber = "7878523254";
		System.out.println("Step :: Edit Phone Number.");
		common.log("<br></br> Step :: Edit Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_TXT_BILLING_PHONE + "']", editphonenumber);

		common.pause(5);
		System.out.println("Step :: Click on Save");
		common.log("<br></br> Step :: Click on Save");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_SAVE_CHANGES + "']")).click();
		common.pause(30);

		System.out.println("Step :: verify save message");
		common.assertElementPresent("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']");

	}

	/**
	 * Edit address in billing info
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */

	public void editAddressInBillingInfo(String signUpUser) throws InterruptedException

	{
		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		common.waitForConditionIsElementPresent("//a[text()='Auctions']");
		common.jsClick(AuctionMenu);
		common.pause(30);

		System.out.println("Click on profile");
		common.jsClick(selectprofile);
		common.pause(30);
		String address = common.getValue("//input[@id='" + LEGACY_USER_TXT_BILLING_ADDRESS + "']");
		System.out.println("Step :: Address >> " + address);

		String editaddress = "545 Ford Street";
		System.out.println("Step :: Edit Address.");
		common.log("<br></br> Step :: Edit Address.");
		common.type("//input[@id='" + LEGACY_USER_TXT_BILLING_ADDRESS + "']", editaddress);

		String newaddress = common.getValue("//input[@id='" + LEGACY_USER_TXT_BILLING_ADDRESS + "']");
		System.out.println("Step :: Address After Edit >> " + newaddress);

		common.pause(5);
		System.out.println("Step :: Click on save changes button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_SAVE_CHANGES + "']")).click();

		common.pause(30);
		System.out.println("Step :: Verify Save Message");
		String sucessmsg = driver.findElement(By.xpath("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']"))
				.getText();
		System.out.println("Step :: Success Message >> " + sucessmsg);
		common.assertElementPresent("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']");
	}

	/**
	 * 
	 * Edit city in billing info
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */

	public void editCityInBillingInfo(String signUpUser) throws InterruptedException

	{
		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		common.waitForConditionIsElementPresent("//a[text()='Auctions']");
		common.jsClick(AuctionMenu);
		common.pause(30);

		System.out.println("Step :: Click on profile");
		common.jsClick(selectprofile);
		common.pause(30);

		String city = common.getValue("//input[@id='" + LEGACY_USER_TXT_BILLING_CITY + "']");
		System.out.println("Step :: City >> " + city);

		String editcity = "New York";
		System.out.println("Step :: Edit city.");
		common.log("<br></br> Step :: Edit city.");
		common.type("//input[@id='" + LEGACY_USER_TXT_BILLING_CITY + "']", editcity);

		String newcity = common.getValue("//input[@id='" + LEGACY_USER_TXT_BILLING_CITY + "']");
		System.out.println("Step :: City After Edit >> " + newcity);

		common.pause(10);
		System.out.println("Step :: Click on save changes button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_SAVE_CHANGES + "']")).click();
		common.pause(30);
		System.out.println("Step :: Verify Save Message");
		String sucessmsg = driver.findElement(By.xpath("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']"))
				.getText();
		System.out.println("Step :: Success Message >> " + sucessmsg);
		common.assertElementPresent("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']");

	}

	/**
	 * Edit zip in billing info
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */
	public void editZipInBillingInfo(String signUpUser) throws InterruptedException

	{
		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		common.waitForConditionIsElementPresent("//a[text()='Auctions']");
		common.jsClick(AuctionMenu);
		common.pause(30);

		System.out.println("Click on profile");
		common.jsClick(selectprofile);
		common.pause(30);

		String zipcode = common.getValue("//input[@id='" + LEGACY_USER_TXT_BILLING_ZIP + "']");
		System.out.println("Step :: ZipCode >> " + zipcode);
		String editzip = "382145";

		System.out.println("Step :: Edit zip.");
		common.log("<br></br> Step :: Edit zip.");
		common.type("//input[@id='" + LEGACY_USER_TXT_BILLING_ZIP + "']", editzip);

		String newzip = common.getValue("//input[@id='" + LEGACY_USER_TXT_BILLING_ZIP + "']");
		System.out.println("Step :: New Zip Code After edit >> " + newzip);
		common.pause(5);

		System.out.println("Step :: Click on save changes button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_SAVE_CHANGES + "']")).click();
		common.pause(30);

		System.out.println("Step :: verify save message");
		String sucessmsg = driver.findElement(By.xpath("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']"))
				.getText();
		System.out.println("Step :: Success Message >> " + sucessmsg);
		common.assertElementPresent("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']");
	}

	/**
	 * Edit country in profile billing
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */

	public void editCountryInProfileBilling(String signUpUser) throws InterruptedException {

		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		common.waitForConditionIsElementPresent("//a[text()='Auctions']");
		common.jsClick(AuctionMenu);
		common.pause(30);

		System.out.println("Step :: Click on profile");
		common.jsClick(selectprofile);

		common.pause(30);

		System.out.println("Step :: Edit billing Country.");
		common.log("<br></br>Step :: Edit billing Country.");
		// Edit Shipping info sale registration

		String Counrty = common.getValue("//select[@id='" + LEGACY_USER_LST_BILLING_COUNTRY + "']");
		System.out.println("Step :: Country >> " + Counrty);

		// Edit Shipping info sale registration
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 550)", "");

		System.out.println("Step :: Select Country.");
		common.log("<br></br>Step :: Select Country.");
		Actions Country = new Actions(driver);
		common.pause(10);
		WebElement SelectCounrty = driver.findElement(By.xpath("//select[@id='pbp7']//..//..//a[text()='Canada']"));
		SelectCounrty.click();
		common.pause(10);

		driver.findElement(By.xpath("//select[@id='pbp7']//..//..//a[text()='United States']")).click();

		common.pause(10);

		String newCounrty = common.getValue("//select[@id='" + LEGACY_USER_LST_BILLING_COUNTRY + "']");
		System.out.println("Step :: New Country >> " + newCounrty);

		// Select State

		System.out.println("Step :: Select State.");
		common.log("<br></br>Step :: Select State.");
		Actions State = new Actions(driver);
		common.pause(10);
		WebElement State1 = driver.findElement(By.xpath("//select[@id='pbp11']//..//..//a[text()='State/Province *']"));
		State1.click();
		common.pause(10);

		driver.findElement(By.xpath("//select[@id='pbp11']//..//..//a[text()='Alaska']")).click();
		common.pause(10);

		System.out.println("Step :: Click on save changes button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_SAVE_CHANGES + "']")).click();
		common.pause(30);

		System.out.println("Step :: verify save message");
		String sucessmsg = driver.findElement(By.xpath("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']"))
				.getText();
		System.out.println("Step :: Success Message >> " + sucessmsg);
		common.assertElementPresent("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']");

	}

	/**
	 * 
	 * Edit Contact Type in Profile Billing
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */
	public void editContactTypeInProfileBilling(String signUpUser) throws InterruptedException {

		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		common.waitForConditionIsElementPresent("//a[text()='Auctions']");
		common.jsClick(AuctionMenu);
		common.pause(30);

		System.out.println("Click on profile");
		common.jsClick(selectprofile);
		common.pause(30);

		String phonetype = common.getValue("//select[@id='pbp30']");
		System.out.println("Step :: Phone Type >> " + phonetype);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 550)", "");

		System.out.println("Step :: Edit Contact type.");
		common.log("<br></br>Step :: Edit Contact type.");

		Actions actions = new Actions(driver);
		common.pause(10);
		WebElement element = driver.findElement(By.xpath("//select[@id='pbp30']//..//..//a[@class='sbToggle']"));
		element.click();
		common.pause(20);

		// Select Phone Type

		driver.findElement(By.xpath("//select[@id='pbp30']//..//..//a[text()='Home']")).click();

		String newphonetype = common.getValue("//select[@id='pbp30']");
		System.out.println("Step :: Phone Type After Edit >> " + newphonetype);

		common.pause(5);
		System.out.println("Step :: Click on save changes button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_SAVE_CHANGES + "']")).click();

		common.pause(30);

		System.out.println("Step :: verify save message");
		String sucessmsg = driver.findElement(By.xpath("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']"))
				.getText();
		System.out.println("Step :: Success Message >> " + sucessmsg);
		common.assertElementPresent("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']");

	}

	/**
	 * Edit State In Profile Billing
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */
	public void editStateInProfileBilling(String signUpUser) throws InterruptedException {

		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		common.waitForConditionIsElementPresent("//a[text()='Auctions']");
		common.jsClick(AuctionMenu);
		common.pause(30);

		System.out.println("Step :: Click on profile");
		common.jsClick(selectprofile);

		common.pause(30);

		System.out.println("Step :: Edit billing State.");
		common.log("<br></br>Step :: Edit billing State.");
		// Edit Shipping info sale registration

		String State = common.getValue("//select[@id='" + LEGACY_USER_LST_BILLING_STATE + "']");
		System.out.println("Step :: State >> " + State);

		// Select State

		System.out.println("Step :: Select State.");
		common.log("<br></br>Step :: Select State.");
		Actions State2 = new Actions(driver);
		common.pause(10);
		WebElement State1 = driver.findElement(By.xpath("//select[@id='pbp49']//..//..//a[text()='Alberta']"));
		State1.click();
		common.pause(10);

		driver.findElement(By.xpath("//select[@id='pbp49']//..//..//a[text()='Manitoba']")).click();

		String newstate = common.getValue("//select[@id='" + LEGACY_USER_LST_BILLING_STATE + "']");
		System.out.println("Step :: New State >> " + newstate);
		common.pause(10);
		System.out.println("Step :: Click on save changes button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_SAVE_CHANGES + "']")).click();
		common.pause(30);

		System.out.println("Step :: verify save message");
		String sucessmsg = driver.findElement(By.xpath("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']"))
				.getText();
		System.out.println("Step :: Success Message >> " + sucessmsg);
		common.assertElementPresent("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']");

	}

	/**
	 * Regular signup for shipping info
	 * 
	 */

	public String regular_SignUp_For_Shipping_Info11(String FirstName, String LastName, String EmailUser,
			String signUpUser) throws InterruptedException {

		System.out.println("SignupUser Details");
		common.pause(30);
		System.out.println("Step :: Admin logout front");
		common.log("<br></br> Step :: Admin logout front");

		common.pause(25);

		System.out.println("Step :: SignupUSer Details.");
		common.log("<br></br> Step :: SignupUSer Details.");
		common.jsClick(signUpLink);
		common.pause(30);
		common.log("<br></br> Step :: Enter User Name:" + signUpUser);
		System.out.println(" Step :: Enter User Name:" + signUpUser);
		common.waitForElement(By.xpath("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']"));
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']", signUpUser);

		System.out.println("Step :: Enter Password");
		common.log("<br></br> Step :: Enter Password");
		common.type("//input[@id= '" + LEGACY_USER_SIGNUP_TXT_PASSWORD + "']", LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);

		System.out.println("Random Value :" + signUpUser);

		System.out.println("Step :: Enter Confirm Password");
		common.log("<br></br> Step :: Enter Confirm Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_PASSWORD + "']",
				LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);

		System.out.println("Step :: Enter Email");
		common.log("<br></br> Step :: Enter Email");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_EMAIL + "']",
				EmailUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);

//		System.out.println("Step :: Enter Confim Email :: " + EmailUser);
//		common.log("<br></br>Step :: Enter Confirm Email :: " + EmailUser);
//		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_EMAIL + "']",
//				EmailUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);

		System.out.println("Step :: Enter First Name:" + signUpUser);
		common.log("<br></br> Step :: Enter First Name:" + signUpUser);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_FIRST_NAME + "']", signUpUser);

		System.out.println("Step :: Enter Last Name.");
		common.log("<br></br> Step :: Enter Last Name.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_LAST_NAME + "']", signUpUser);
		common.pause(10);

		// common.jsClick(editBoxOfPhone);
		common.log("<br></br>Enter Phone Number.");
		System.out.println("Enter Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);
		common.pause(10);
		// Enter_CC_Details();
		common.pause(10);

		Select_User_Info_Phone_Type();

		common.pause(15);

		Select_Identification_Type(); // Select Identification type

		common.pause(8);

		enterBillInfowithoutselectshippinginfocheckbox1(signUpUser);
		return signUpUser;

	}

	/**
	 * Enter Bill Info with out select shipping info checkbox
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */
	public void enterBillInfowithoutselectshippinginfocheckbox1(String signUpUser) throws InterruptedException {

		common.pause(20);
		Select_Billing_Info_Phone_Type(); // Select Phone Type

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", signUpUser);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", signUpUser);

		common.pause(5);

		System.out.println("Step :: Entering Phone Number.");
		common.log("<br></br>Step :: Entering Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		Select_Counrty_and_State(); // Select Country and State

		// Enter_CC_Details(); // Enter CC Details

		System.out.println("Step :: Enter Address.");
		common.log("<br></br>Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		System.out.println("Step :: City.");
		common.log("<br></br>Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		System.out.println("Step :: Enter Zip.");
		common.log("<br></br>Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		System.out.println("Step :: Entering Captcha.");
		common.log("<br></br>Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

	}

	/**
	 * Simplified Signup With CC
	 * 
	 * @param FirstName
	 * @param LastName
	 * @param EmailUser
	 * @param signUpUser
	 * @throws InterruptedException
	 */
	public void simplifiedsignupfiledwithcc(String FirstName, String LastName, String EmailUser, String signUpUser)
			throws InterruptedException {

		System.out.println("SignupUser Details");

		common.pause(4);
		System.out.println("Step :: SignupUSer Details.");
		common.log("<br></br> Step :: SignupUSer Details.");
		common.jsClick(signUpLink);
		common.waitForConditionIsElementPresent(("//a"));

		System.out.println("Step :: Enter User Name");
		common.log("<br></br> Step :: Enter User Name");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']", signUpUser);

		System.out.println("Step :: Enter Password");
		common.log("<br></br> Step :: Enter Password");
		common.type("//input[@id= '" + LEGACY_USER_SIGNUP_TXT_PASSWORD + "']", LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);

		System.out.println("Step :: Enter Confirm Password");
		common.log("<br></br> Step :: Enter Confirm Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_PASSWORD + "']",
				LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);

		System.out.println("Step :: Enter Email");
		common.log("<br></br> Step :: Enter Email");
		System.out.println("New User >>" + "  " + signUpUser);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_EMAIL + "']",
				EmailUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);

		System.out.println("Step :: Enter First Name.");
		common.log("<br></br> Step :: Enter First Name.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_FIRST_NAME + "']", signUpUser);

		System.out.println("Step :: Enter Last Name.");
		common.log("<br></br> Step :: Enter Last Name.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_LAST_NAME + "']", signUpUser);

		// common.jsClick(editBoxOfPhone);
		common.log("<br></br>Enter Phone Number...");
		System.out.println("Enter Phone Number...");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		System.out.println("Step :: Phone Type.");
		common.log("<br></br>Step :: Phone Type.");

		String PhoneType = "Work";
		WebElement option = signupPhoneType.findElement(By.xpath("//span[@id='" + LEGACY_USER_SIGNUP_TXT_PHONE_TYPE
				+ "']//option[contains(text(),'" + PhoneType + "')]"));
		System.out.println("Step :: Phone Type >>> " + PhoneType);
		common.log("<br></br>Step :: Phone Type >>> " + PhoneType);
		option.click();

		System.out.println("Step :: Identification.");
		common.log("<br></br>Step :: Identification.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_IDENTIFICATION + "']",
				LEGACY_USER_SIGNUP_TXT_IDENTIFICATION_VALUE);

		String IdentificationType = "2";
		WebElement identificationoption = signupIdentificationType.findElement(By.xpath("//span[@id='"
				+ LEGACY_USER_SIGNUP_LST_IDENTIFICATION_TYPE + "']//option[@value='" + IdentificationType + "']"));
		System.out.println("Step :: Identification Type >>> " + IdentificationType);
		common.log("<br></br>Step :: Identification Type >>> " + IdentificationType);
		identificationoption.click();

		enterBillInfowithoutselectshippinginfocheckbox(signUpUser);
		common.pause(8);

	}

	public void simplifiedSignUpWithCCInfoMandatory() throws InterruptedException {

		common.waitForConditionIsElementPresent("//div[@id='" + LEGACY_USER_SIGNUP_REGISTRATION_PANEL + "']");
		/**
		 * Select Visa
		 * 
		 */
		String CCType = "Visa";
		WebElement option = signupcc.findElement(By.xpath("//span[@id='"
				+ LEGACY_USER_SIGNUP_LST_CC_TYPE_WARNING_MESSAGE + "']//option[contains(text(),'" + CCType + "')]"));

		System.out.println("CCType :: " + CCType + "####");
		common.log("<br></br>CCType  ::  " + CCType + "####");
		option.click();

		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CC_NUMBER + "']", "4111111111111111");

		/**
		 * Select Expiration Month
		 * 
		 */
		String Month = "August";
		WebElement augustoption = signupmonth
				.findElement(By.xpath("//span[@id='" + LEGACY_USER_SIGNUP_LST_EXPIRATION_DATE_MONTH_WARNING_MESSAGE
						+ "']//option[contains(text(),'" + Month + "')]"));

		System.out.println("Month :: " + Month + ">>>>");
		common.log("<br></br>Month :: " + Month + ">>>>");
		augustoption.click();

		/**
		 * Select Expiration Year
		 * 
		 */
		String Year = "2018";
		WebElement yearoption = signupyear
				.findElement(By.xpath("//span[@id='" + LEGACY_USER_SIGNUP_LST_EXPIRATION_DATE_YEAR_WARNING_MESSAGE
						+ "']//option[contains(text(),'" + Year + "')]"));

		System.out.println("Year :: " + Year + ">>>>");
		common.log("<br></br>Year :: " + Year + ">>>>");
		yearoption.click();

		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_SECURITY_CODE + "']", "123");

		System.out.println("Step :: Entering Captcha.");
		common.log("<br></br>Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);
		// common.pause(15);
		if (common.isElementPresent("//ul[@id='" + LEGACY_USER_SIGNUP_MESSAGE_VALUE + "']")) {

			common.waitForElementIsDisplayed(By.xpath("//ul[@id='" + LEGACY_USER_SIGNUP_MESSAGE_VALUE + "']"));
			common.assertElementPresent(
					"//li[contains(.,'" + LEGACY_USER_SIGNUP_BILL_TXT_CONGRATULATION_MESSAGE + "')]");

		}

		else if (common.isElementPresent("//span[@class['title']][contains(text(),'Undefined')]")) {

			common.assertElementNotPresent("//span[@class['title']][contains(text(),'Undefined')]");
		}

		System.out.println("Step :: signup successful\n"
				+ "the billing info box was displayed with the following fields:\n" + "billing CC type\n"
				+ "billing CC number\n" + "billing expiration date\n" + "billing security code\n");
		common.log("<br></br>Step :: signup successful<br>"
				+ "the billing info box was displayed with the following fields:<br>" + "billing CC type<br>"
				+ "billing CC number<br>" + "billing expiration date<br>" + "billing security code<br>");
	}

	/**
	 * Edit CC Type in billing info
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */

	public void editCCTypeInBillingInfo(String signUpUser) throws InterruptedException

	{
		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		common.waitForConditionIsElementPresent("//a[text()='Auctions']");
		common.jsClick(AuctionMenu);
		common.pause(30);

		System.out.println("Step :: Click on profile");
		common.jsClick(selectprofile);
		common.pause(20);

//		String CCType = common.getText("//span[@class='info']");
//		System.out.println("Step :: CC Type >> " + CCType);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 700)", "");

		common.pause(30);
		String cctype = driver
				.findElement(By.xpath("//div[@id='billing-ccinfo-container']//div[@class='row info-row'][1]"))
				.getText();
		System.out.println("Step ::" + cctype);
		common.log("Step :: " + cctype);

		common.pause(10);

		System.out.println("Step :: Click on Edit Icon");
		common.log("<br></br> Step :: Click on Edit Icon");
		common.jsClick(editicon);
		common.pause(60);

		/**
		 * Select CC Type
		 */
		System.out.println("Step  :: Select CC Type.");
		common.log("<br></br>Step  :: Select CC Type.");

//	    driver.findElement(By.xpath("//select[@id='pbp13']//..//..//a[@class='sbToggle']")).click();
//		common.pause(20);
//		// select[@id='pbp13']//..//a[contains(text(),'Visa')]
//		driver.findElement(By.xpath("//select[@id='pbp13']//..//a[text()='MasterCard']")).click();
//		common.pause(10);

		driver.findElement(By.xpath("//select[@id='pbp13']//..//..//a[@class='sbToggle']")).click();
		common.pause(40);

		WebElement ele = driver.findElement(By.xpath("//ul[@class='sbOptions']//li//a[text()='MasterCard']"));
		if (common.isElementDisplayed(ele)) {
			System.out.println("Step ::Select Credit Card type");
			common.log("<br></br>Step :: Select Credit Card type");
			driver.findElement(By.xpath("//ul[@class='sbOptions']//li//a[text()='MasterCard']")).click(); // dev

			common.pause(50);
		} else {
			System.out.println("Step ::Select Credit Card type");
			common.log("<br></br>Step :: Select Credit Card type");
			driver.findElement(By.xpath("//ul[@class='sbOptions']//a[contains(text(),'Mastercard')]")).click(); // qa3-6-auto
			common.pause(50);
		}

//		   driver.findElement(By.xpath("//select[@id='pbp13']//..//..//a[@class='sbToggle']")).click();
//			common.pause(20);
//			driver.findElement(By.xpath("//ul[@class='sbOptions']//li//a[text()='MasterCard']")).click();
//			common.pause(10);

		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_EDIT_CC_NUMBER + "']", "5555555555554444");

		common.pause(20);
		System.out.println("Step :: Enter Security Code");
		common.log("<br></br> Step :: Enter Security Code");
		common.type("//input[@id='pbp19']", "123");

//		String newcctype = common.getValue("//select[@id='pbp13']");
//		System.out.println("Step :: New CC Type After edit >> " + newcctype);
		common.pause(5);

		System.out.println("Step :: Click on save changes button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_SAVE_CHANGES + "']")).click();
		common.pause(40);

		System.out.println("Step :: verify save message");
		String sucessmsg = driver.findElement(By.xpath("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']"))
				.getText();
		System.out.println("Step :: Success Message >> " + sucessmsg);
		common.assertElementPresent("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']");

		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("window.scrollBy(0, 700)", "");

		common.pause(30);
		String cctype2 = driver
				.findElement(By.xpath("//div[@id='billing-ccinfo-container']//div[@class='row info-row'][3]"))
				.getText();
		System.out.println("Step ::" + cctype2);
		common.log("Step :: " + cctype2);
	}

	/**
	 * 
	 * Edit CC Number in billing info
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */

	public void editCCNumberInBillingInfo(String signUpUser) throws InterruptedException

	{
		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		common.waitForConditionIsElementPresent("//a[text()='Auctions']");
		common.jsClick(AuctionMenu);
		common.pause(30);

		System.out.println("Step :: Click on profile");
		common.jsClick(selectprofile);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 700)", "");
		common.pause(20);

		System.out.println("Step :: Click on Edit Icon");
		common.log("<br></br> Step :: Click on Edit Icon");
		common.jsClick(editicon);
		common.pause(40);

		driver.findElement(By.xpath("//select[@id='pbp13']//..//a[contains(text(),'Visa')]")).click();

		common.pause(20);

		System.out.println("Step :: Edit CC Number");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_EDIT_CC_NUMBER + "']", "4242424242424242");
		common.pause(20);

		String newccnumber = common.getValue("//input[@id='pbp14']");
		System.out.println("Step :: New CC Type After edit >> " + newccnumber);
		common.pause(20);
		System.out.println("Step :: Enter Security Code");
		common.log("<br></br> Step :: Enter Security Code");
		common.type("//input[@id='pbp19']", "123");
		common.pause(5);

		System.out.println("Step :: Click on save changes button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_SAVE_CHANGES + "']")).click();
		common.pause(40);
		System.out.println("Step :: verify save message");
		String sucessmsg = driver.findElement(By.xpath("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']"))
				.getText();
		System.out.println("Step :: Success Message >> " + sucessmsg);
		common.assertElementPresent("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']");
	}

	/**
	 * Edit Expiration Date in billing info
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */
	public void editExpirationDateInBillingInfo(String signUpUser) throws InterruptedException

	{
		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		common.waitForConditionIsElementPresent("//a[text()='Auctions']");
		common.jsClick(AuctionMenu);
		common.pause(30);

		System.out.println("Step :: Click on profile");
		common.jsClick(selectprofile);
		common.pause(20);

//		String ccmonth = common.getValue("//select[@id='pbp17']");
//		String ccyear = common.getValue("//select[@id='pbp18']");
//		System.out.println("Step :: CC Month >> " + ccmonth);
//		System.out.println("Step :: CC Year >> " + ccyear);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 650)", "");

		common.pause(30);
		String expdate = driver
				.findElement(By.xpath("//div[@id='billing-ccinfo-container']//div[@class='row info-row'][3]"))
				.getText();
		System.out.println("Step ::" + expdate);
		common.log("Step :: " + expdate);

		System.out.println("Step :: Click on Edit Icon");
		common.log("<br></br> Step :: Click on Edit Icon");
		common.jsClick(editicon);
		common.pause(40);

		/**
		 * Select Expiration Month
		 * 
		 */

		System.out.println("Step :: Edit CC Number");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_EDIT_CC_NUMBER + "']", "4242424242424242");
		common.pause(20);
		System.out.println("Step :: Select CC Month.");
		common.log("<br></br>Step :: Select CC Month.");

		Actions CC_month = new Actions(driver);
		common.pause(10);
		WebElement CCmonth = driver.findElement(By.xpath("//select[@id='pbp17']//..//..//a[@class='sbToggle']"));
		CCmonth.click();
		common.pause(20);

		driver.findElement(By.xpath("//select[@id='pbp17']//..//..//a[text()='April']")).click();

		/**
		 * Select Expiration Year
		 * 
		 */

		System.out.println("Step :: Select CC Year.");
		common.log("<br></br>Step :: Select CC Year.");

		Actions CC_year = new Actions(driver);
		common.pause(10);
		WebElement CCyear = driver.findElement(By.xpath("//select[@id='pbp18']//..//..//a[@class='sbToggle']"));
		CCyear.click();
		common.pause(10);

		driver.findElement(By.xpath("//select[@id='pbp18']//..//..//a[text()='2026']")).click();

		common.pause(10);
//		String newccmonth = common.getValue("//select[@id='pbp17']");
//		String newccyear = common.getValue("//select[@id='pbp18']");
//
//		System.out.println("Step :: CC Month >> " + newccmonth);
//		System.out.println("Step :: CC Year >> " + newccyear);
//		common.pause(20);

		WebElement CCtype = driver.findElement(By.xpath("//select[@id='pbp13']//..//a[@class='sbToggle']"));
		CCtype.click();
		common.pause(10);

		driver.findElement(By.xpath("//select[@id='pbp13']//..//..//a[text()='Visa']")).click();
		common.pause(5);

		System.out.println("Step :: Enter Security Code");
		common.log("<br></br> Step :: Enter Security Code");
		common.type("//input[@id='pbp19']", "123");
		common.pause(5);

		System.out.println("Step :: Click on save changes button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_SAVE_CHANGES + "']")).click();
		common.pause(40);

		System.out.println("Step :: verify save message");
		String sucessmsg = driver.findElement(By.xpath("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']"))
				.getText();
		System.out.println("Step :: Success Message >> " + sucessmsg);
		common.assertElementPresent("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']");
		common.pause(10);

		JavascriptExecutor jse1 = (JavascriptExecutor) driver;
		jse1.executeScript("window.scrollBy(0, 650)", "");

		common.pause(30);

		String expdate1 = driver
				.findElement(By.xpath("//div[@id='billing-ccinfo-container']//div[@class='row info-row'][3]"))
				.getText();
		System.out.println("Step ::" + expdate1);
		common.log("Step :: " + expdate1);
	}

	/**
	 * Edit Security code in billing info
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */

	public void editSecurityCodeInBillingInfo(String signUpUser) throws InterruptedException

	{
		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		common.waitForConditionIsElementPresent("//a[text()='Auctions']");
		common.jsClick(AuctionMenu);
		common.pause(30);

		System.out.println("Step :: Click on profile");
		common.jsClick(selectprofile);

		System.out.println("Step :: Click on Edit Icon");
		common.log("<br></br> Step :: Click on Edit Icon");
		common.pause(30);

		String securitycode = common.getValue("//input[@id='" + LEGACY_USER_TXT_BILLING_SECURITY_CODE + "']");
		System.out.println("Step :: Security Code >> " + securitycode);
		/**
		 * Select CC Type
		 */
		System.out.println("Step  :: Select CC Type.");
		common.log("<br></br>Step  :: Select CC Type.");

		Actions CC_Type = new Actions(driver);
		common.pause(10);
		WebElement CCtype = driver.findElement(By.xpath("//select[@id='pbp13']//..//..//a[text()='CC type']"));
		CCtype.click();
		common.pause(20);

		driver.findElement(By.xpath("//select[@id='pbp13']//..//..//a[text()='Visa']")).click();

		System.out.println("Step :: Edit CC Number");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_EDIT_CC_NUMBER + "']", "4242424242424242");
		common.pause(20);

		/**
		 * Select Expiration Month
		 * 
		 */

		System.out.println("Step :: Select CC Month.");
		common.log("<br></br>Step :: Select CC Month.");

		Actions CC_month = new Actions(driver);
		common.pause(10);
		WebElement CCmonth = driver.findElement(By.xpath("//select[@id='pbp17']//..//..//a[@class='sbToggle']"));
		CCmonth.click();
		common.pause(20);

		driver.findElement(By.xpath("//select[@id='pbp17']//..//..//a[text()='April']")).click();

		/**
		 * Select Expiration Year
		 * 
		 */

		System.out.println("Step :: Select CC Year.");
		common.log("<br></br>Step :: Select CC Year.");

		Actions CC_year = new Actions(driver);
		common.pause(10);
		WebElement CCyear = driver.findElement(By.xpath("//select[@id='pbp18']//..//..//a[@class='sbToggle']"));
		CCyear.click();
		common.pause(10);

		driver.findElement(By.xpath("//select[@id='pbp18']//..//..//a[text()='2022']")).click();

		System.out.println("Step :: Edit Security code");
		common.type("//input[@id='" + LEGACY_USER_TXT_BILLING_SECURITY_CODE + "']", "456");

		String newcode = common.getValue("//*[@id='" + LEGACY_USER_TXT_BILLING_SECURITY_CODE + "']");
		System.out.println("Step :: New Security Code >> " + newcode);
		common.pause(5);

		System.out.println("Step :: Click on save changes button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_SAVE_CHANGES + "']")).click();
		common.pause(30);

		System.out.println("Step :: verify save message");
		String sucessmsg = driver.findElement(By.xpath("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']"))
				.getText();
		System.out.println("Step :: Success Message >> " + sucessmsg);
		common.assertElementPresent("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']");

	}

	/**
	 * 
	 * Edit First Name in shipping info
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */

	public void editFirstNameShippingInfo(String signUpUser) throws InterruptedException {

		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		common.waitForConditionIsElementPresent("//a[text()='Auctions']");
		common.jsClick(AuctionMenu);
		common.pause(30);

		System.out.println("Click on profile");
		common.jsClick(selectprofile);

		common.pause(30);

		String shippingfname = common.getValue("//input[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_FIRST_NAME + "']");
		System.out.println("Step :: Shipping First Name >> " + shippingfname);

		System.out.println("Step :: Edit First Name ");
		common.log("<br></br>Step :: Edit First Name ");
		String editfirstnameshipping = "ShippingFirstname";
		common.type("//input[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_FIRST_NAME + "']", editfirstnameshipping);

		String newfname = common.getValue("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_FIRST_NAME + "']");
		System.out.println("Step :: Shipping First Name After Edit >> " + newfname);

		common.pause(5);
		System.out.println("Step :: Click on save changes button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_SAVE_CHANGES + "']")).click();
		common.pause(40);

		System.out.println("Step :: verify save message");
		String sucessmsg = driver.findElement(By.xpath("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']"))
				.getText();
		System.out.println("Step :: Success Message >> " + sucessmsg);
		common.assertElementPresent("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']");
	}

	/**
	 * Edit Last Name in shipping info
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */

	public void editLastNameShippingInfo(String signUpUser) throws InterruptedException {

		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		common.waitForConditionIsElementPresent("//a[text()='Auctions']");
		common.jsClick(AuctionMenu);
		common.pause(30);

		System.out.println("Click on profile");
		common.jsClick(selectprofile);

		common.pause(30);

		String shippinglname = common.getValue("//input[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_LAST_NAME + "']");
		System.out.println("Step :: Shipping Last Name >> " + shippinglname);

		System.out.println("Step :: Edit Last Name ");
		common.log("<br></br>Step :: Edit Last Name ");
		String editlasttnameshipping = "ShippingFirstname";
		common.type("//input[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_LAST_NAME + "']", editlasttnameshipping);

		String newlname = common.getValue("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_LAST_NAME + "']");
		System.out.println("Step :: Shipping Last Name After Edit >> " + newlname);
		common.pause(5);

		System.out.println("Step :: Click on save changes button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_SAVE_CHANGES + "']")).click();
		common.pause(30);

		System.out.println("Step :: verify save message");
		String sucessmsg = driver.findElement(By.xpath("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']"))
				.getText();
		System.out.println("Step :: Success Message >> " + sucessmsg);
		common.assertElementPresent("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']");
	}

	/**
	 * 
	 * Edit Phone in shipping info
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */

	public void editPhoneInShippingInfo(String signUpUser) throws InterruptedException {

		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		common.waitForConditionIsElementPresent("//a[text()='Auctions']");
		common.jsClick(AuctionMenu);
		common.pause(30);

		System.out.println("Step :: Click on profile");
		common.jsClick(selectprofile);

		common.pause(30);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 650)", "");

		String shippingphone = common.getValue("//input[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_PHONE + "']");
		System.out.println("Step :: Shipping Phone Number >> " + shippingphone);

		System.out.println("Step :: Edit Phone number:");
		common.log("<br></br>Step :: Edit Phone number :");
		String editshippingphone = "7878145452";
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_PHONE + "']", editshippingphone);

		String newphone = common.getValue("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_PHONE + "']");
		System.out.println("Step :: Shipping Phone After Edit >> " + newphone);
		common.pause(5);

		System.out.println("Step :: Click on save changes button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_SAVE_CHANGES + "']")).click();
		common.pause(30);

		System.out.println("Step :: verify save message");
		String sucessmsg = driver.findElement(By.xpath("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']"))
				.getText();
		System.out.println("Step :: Success Message >> " + sucessmsg);
		common.assertElementPresent("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']");

	}

	/**
	 * 
	 * Edit country in shipping info
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */
	public void Editcountryinshippinginfo(String signUpUser) throws InterruptedException {

		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		common.waitForConditionIsElementPresent("//a[text()='Auctions']");
		common.jsClick(AuctionMenu);
		common.pause(30);

		System.out.println("Click on profile");
		common.jsClick(selectprofile);
		common.pause(40);

		String oldCountry = common.getValue("//select[@id='psp7']");
		System.out.println("Step :: Country >> " + oldCountry);

		// Select Country

		System.out.println("Step :: Select Country.");
		common.log("<br></br>Step :: Select Country.");
		Actions Country = new Actions(driver);
		common.pause(10);
		WebElement SelectCounrty = driver.findElement(By.xpath("//select[@id='psp7']//..//..//a[text()='Canada']"));
		SelectCounrty.click();
		common.pause(10);

		driver.findElement(By.xpath("//select[@id='psp7']//..//..//a[text()='United States']")).click();

		// Select State

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 700)", "");

		System.out.println("Step :: Select State.");
		common.log("<br></br>Step :: Select State.");
		Actions State1 = new Actions(driver);
		common.pause(20);
		WebElement Shippingstate = driver.findElement(By.xpath("//select[@id='psp12']//..//..//a[@class='sbToggle']"));
		Shippingstate.click();
		common.pause(10);

		driver.findElement(By.xpath("//select[@id='psp12']//..//..//a[text()='Alaska']")).click();

		String newcountry = common.getValue("//select[@id='psp7']");
		System.out.println("Step :: New Selectd Country After edit >> " + newcountry);
		common.pause(5);
		System.out.println("Step :: Click on save changes button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_SAVE_CHANGES + "']")).click();
		common.pause(30);

		System.out.println("Step :: verify save message");
		String sucessmsg = driver.findElement(By.xpath("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']"))
				.getText();
		System.out.println("Step :: Success Message >> " + sucessmsg);
		common.assertElementPresent("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']");

	}

	/**
	 * 
	 * Edit address in shipping info
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */
	public void editAddressInShippingInfo(String signUpUser) throws InterruptedException

	{
		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		common.waitForConditionIsElementPresent("//a[text()='Auctions']");
		common.jsClick(AuctionMenu);
		common.pause(30);

		System.out.println("Step :: Click on profile");
		common.jsClick(selectprofile);

		common.pause(30);

		String address = common.getValue("//input[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_ADDRESS + "']");
		System.out.println("Step :: Shipping Address >> " + address);

		System.out.println("Step :: Edit Address:");
		common.log("<br></br>Step :: Edit Address :");
		String editaddress = "Ford Street 456";
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_ADDRESS + "']", editaddress);

		String newadress = common.getValue("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_ADDRESS + "']");
		System.out.println("Step :: Shipping Address After Edit >> " + newadress);
		common.pause(5);

		System.out.println("Step :: Click on save changes button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_SAVE_CHANGES + "']")).click();
		common.pause(30);

		System.out.println("Step :: verify save message");
		String sucessmsg = driver.findElement(By.xpath("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']"))
				.getText();
		System.out.println("Step :: Success Message >> " + sucessmsg);
		common.assertElementPresent("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']");
	}

	/**
	 * 
	 * Edit city in shipping info
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */
	public void editCityInShippingInfo(String signUpUser) throws InterruptedException

	{
		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		common.waitForConditionIsElementPresent("//a[text()='Auctions']");
		common.jsClick(AuctionMenu);
		common.pause(30);

		System.out.println("Step :: Click on profile");
		common.jsClick(selectprofile);

		common.pause(30);

		String address = common.getValue("//input[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_CITY + "']");
		System.out.println("Step :: Shipping City >> " + address);

		System.out.println("Step :: Edit City ");
		common.log("<br></br>Step :: Edit City ");
		String editcity = "Las Vegas";
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_CITY + "']", editcity);

		String newadress = common.getValue("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_CITY + "']");
		System.out.println("Step :: Shipping City After Edit >> " + newadress);

		common.pause(5);
		System.out.println("Step :: Click on save changes button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_SAVE_CHANGES + "']")).click();
		common.pause(30);

		System.out.println("Step :: verify save message");
		String sucessmsg = driver.findElement(By.xpath("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']"))
				.getText();
		System.out.println("Step :: Success Message >> " + sucessmsg);
		common.assertElementPresent("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']");

	}

	/**
	 * 
	 * Edit zip in shipping info
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */
	public void editZipInShippingInfo(String signUpUser) throws InterruptedException

	{
		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		common.waitForConditionIsElementPresent("//a[text()='Auctions']");
		common.jsClick(AuctionMenu);
		common.pause(30);

		System.out.println("Step :: Click on profile");
		common.jsClick(selectprofile);

		common.pause(30);

		String zip = common.getValue("//input[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_ZIP + "']");
		System.out.println("Step :: Shipping Zip >> " + zip);

		System.out.println("Step :: Edit Zip ");
		common.log("<br></br>Step :: Edit Zip ");
		String editzip = "30005";
		common.type("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_ZIP + "']", editzip);

		String newzip = common.getValue("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_ZIP + "']");
		System.out.println("Step :: Shipping Zip After Edit >> " + newzip);

		common.pause(5);
		System.out.println("Step :: Click on save changes button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_SAVE_CHANGES + "']")).click();
		common.pause(30);

		System.out.println("Step :: verify save message");
		String sucessmsg = driver.findElement(By.xpath("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']"))
				.getText();
		System.out.println("Step :: Success Message >> " + sucessmsg);
		common.assertElementPresent("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']");
	}

	/**
	 * 
	 * kepp blank address field
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */
	public void keepBlankAddressFieldInShippingInfo(String signUpUser) throws InterruptedException

	{
		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		common.waitForConditionIsElementPresent("//a[text()='Auctions']");
		common.jsClick(AuctionMenu);
		common.pause(30);

		System.out.println("Click on profile");
		common.jsClick(selectprofile);

		// common.waitForElement(By.xpath("//div[@id='ProfilePersonalPanel']"));

		common.pause(30);

		System.out.println("Step :: Edit Address:");
		common.log("<br></br>Step :: Edit Address :");

		driver.findElement(By.xpath("//*[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_ADDRESS + "']")).clear();

		common.pause(5);
		System.out.println("Step :: Click on save changes button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_SAVE_CHANGES + "']")).click();

		common.pause(30);
		System.out.println("Step :: Verify required text");
		String GetWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][1]")).getText();
		System.out.println("Step :: Warning Message >> " + GetWarningMessage);

	}

	/**
	 * 
	 * change password not match
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */
	public void changePasswordNotMatch(String signUpUser) throws InterruptedException

	{
		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		common.waitForConditionIsElementPresent("//a[text()='Auctions']");
		common.jsClick(AuctionMenu);
		common.pause(30);

		System.out.println("Click on profile");
		common.jsClick(selectprofile);

		common.pause(30);

		System.out.println("Step :: Click on change password");
		common.log("<br></br>Step :: Click on change password :");
		driver.findElement(By.xpath("//div[@id='change_password_button']")).click();
		common.pause(10);

		System.out.println("Step :: Enter current password");
		common.log("<br></br>Step :: Enter current password");
		String currentpassword = "rahul123";
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_TXT_PASSWORD + "']", currentpassword);

		System.out.println("Step :: Enter new password");
		common.log("<br></br>Step :: Enter new password");
		String newpassword = "rahul1234";
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_PASSWORD + "']", newpassword);

		System.out.println("Step :: Enter confirm new password");
		common.log("<br></br>Step :: Enter confirm new password");
		String confirmnewpassword = "rahul3212";
		common.type("//*[@id='pip4']", confirmnewpassword);

		common.pause(5);
		System.out.println("Step :: Click on save changes button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_SAVE_CHANGES + "']")).click();
		common.pause(30);

		System.out.println("Step :: Verify Password not match");
		String GetWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles']")).getText();
		System.out.println("Step :: Warning Message >> " + GetWarningMessage);

	}

	/**
	 * Verify Change Password Success
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */
	public void changePasswordSuccess(String signUpUser) throws InterruptedException

	{
		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		common.waitForConditionIsElementPresent("//a[text()='Auctions']");
		common.jsClick(AuctionMenu);
		common.pause(30);

		System.out.println("Click on profile");
		common.jsClick(selectprofile);

		common.pause(30);

		System.out.println("Step :: Click on change password");
		common.log("<br></br>Step :: Click on change password :");
		driver.findElement(By.xpath("//div[@id='change_password_button']")).click();
		common.pause(10);

		System.out.println("Step :: Enter current password");
		common.log("<br></br>Step :: Enter current password");
		String currentpassword = "rahul123";
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_TXT_PASSWORD + "']", currentpassword);

		System.out.println("Step :: Enter new password");
		common.log("<br></br>Step :: Enter new password");
		String newpassword = "rahul1234";
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_PASSWORD + "']", newpassword);

		System.out.println("Step :: Enter confirm new password");
		common.log("<br></br>Step :: Enter confirm new password");
		String confirmnewpassword = "rahul1234";
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_TXT_FIRST_NAME + "']", confirmnewpassword);

		common.pause(5);
		System.out.println("Click on save changes button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_SAVE_CHANGES + "']")).click();

		common.pause(30);
		System.out.println("Step :: verify save message");
		String sucessmsg = driver.findElement(By.xpath("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']"))
				.getText();
		System.out.println("Step :: Success Message >> " + sucessmsg);
		common.assertElementPresent("//span[text()='" + LEGACY_USER_TXT_CHANGES_SAVED + "']");
	}

	/**
	 * 
	 * Verify Wrong old password
	 * 
	 * @param signUpUser
	 * @throws InterruptedException
	 */

	public void wrongOldPassword(String signUpUser) throws InterruptedException

	{
		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

		common.waitForConditionIsElementPresent("//a[text()='Auctions']");
		common.jsClick(AuctionMenu);
		common.pause(30);

		System.out.println("Click on profile");
		common.jsClick(selectprofile);

		common.pause(30);

		System.out.println("Step :: Click on change password");
		common.log("<br></br>Step :: Click on change password :");
		driver.findElement(By.xpath("//div[@id='change_password_button']")).click();
		common.pause(10);

		System.out.println("Step :: Enter current password");
		common.log("<br></br>Step :: Enter current password");
		String currentpassword = "rahul12345";
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_TXT_PASSWORD + "']", currentpassword);

		System.out.println("Step :: Enter new password");
		common.log("<br></br>Step :: Enter new password");
		String newpassword = "rahul1234";
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_PASSWORD + "']", newpassword);

		System.out.println("Step :: Enter confirm new password");
		common.log("<br></br>Step :: Enter confirm new password");
		String confirmnewpassword = "rahul1234";
		common.type("//*[@id='pip4']", confirmnewpassword);

		common.pause(5);
		System.out.println("Click on save changes button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_SAVE_CHANGES + "']")).click();

		common.pause(30);
		System.out.println("Step :: Verify Current Password");
		String GetWarningMessage = driver.findElement(By.xpath("//span[@class='sub-titles']")).getText();
		System.out.println("Step :: Warning Message >> " + GetWarningMessage);

	}

	/**
	 * 
	 * Regular Signup For Custom Field
	 * 
	 * @param FirstName
	 * @param LastName
	 * @param EmailUser
	 * @param signUpUser
	 * @throws InterruptedException
	 */
	public void regular_SignUp_For_Custom_Field(String FirstName, String LastName, String EmailUser, String signUpUser)
			throws InterruptedException {

		System.out.println("SignupUser Details");
		common.pause(20);

		System.out.println("Step :: Admin logout front");
		common.log("<br></br> Step :: Admin logout front");

		common.pause(25);

		System.out.println("Step :: SignupUSer Details.");
		common.log("<br></br> Step :: SignupUSer Details.");
		common.jsClick(signUpLink);
		// common.waitForConditionIsElementPresent(("//a"));

		common.pause(40);
		System.out.println("Step :: Enter User Name");
		common.log("<br></br> Step :: Enter User Name");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']", signUpUser);

		System.out.println("Step :: Enter Password");
		common.log("<br></br> Step :: Enter Password");
		common.type("//input[@id= '" + LEGACY_USER_SIGNUP_TXT_PASSWORD + "']", LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);
		System.out.println("Random Value :" + signUpUser);

		System.out.println("Step :: Enter Confirm Password");
		common.log("<br></br> Step :: Enter Confirm Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_PASSWORD + "']", signUpUser);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_LAST_NAME + "']", signUpUser);

		System.out.println("Step :: Enter Email");
		common.log("<br></br> Step :: Enter Email");
		System.out.println("New User >>" + "  " + signUpUser);

		System.out.println("Step :: Enter First Name.");
		common.log("<br></br> Step :: Enter First Name.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_FIRST_NAME + "']", signUpUser);

		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']", signUpUser);

		System.out.println("Step :: Enter Last Name.");
		common.log("<br></br> Step :: Enter Last Name.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_PASSWORD + "']",
				LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_EMAIL + "']",
				EmailUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);

		// common.jsClick(editBoxOfPhone);
		common.log("<br></br>Enter Phone Number...");
		System.out.println("Enter Phone Number...");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		System.out.println("Step :: Phone Type.");
		common.log("<br></br>Step :: Phone Type.");

		Select_User_Info_Phone_Type(); // Select Phone Type

		Select_Identification_Type(); // Select Identification Type

		common.pause(8);

	}

	/**
	 * 
	 * Regular signup with valid number
	 * 
	 * @param FirstName
	 * @param LastName
	 * @param EmailUser
	 * @param signUpUser
	 * @param customeFiled1
	 * @throws InterruptedException
	 */
	public void regularSignupWithValidNumber(String FirstName, String LastName, String EmailUser, String signUpUser,
			String customeFiled1) throws InterruptedException {

		common.pause(15);
		System.out.println("Step :: Enter Number");
		common.log("<br></br> Step :: Enter Number");

		System.out.println("Verify added new field ::" + customeFiled1);
		common.pause(20);
		System.out.println("Step :: Fill Data in New Added Custom Field");
		common.log("<br></br> Step :: Fill Date in New Added Custom Field");
		common.type("//input[@placeholder='" + customeFiled1 + "']", "123");
		// common.type("//input[@placeholder='" + customeFiled1 + " *']", "123");

		enterBillInfo(signUpUser);

		common.pause(15);
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");
	}

	/**
	 * Regular Signup with invalid number
	 * 
	 * @param FirstName
	 * @param LastName
	 * @param EmailUser
	 * @param signUpUser
	 * @param customeFiled1
	 * @throws InterruptedException
	 */

	public void regularSignupWithInValidNumber(String FirstName, String LastName, String EmailUser, String signUpUser,
			String customeFiled1) throws InterruptedException {

		System.out.println("Step :: Enter invalid Number");
		common.log("<br></br> Step :: Enter invalid Number");

		System.out.println("Verify added new field ::" + customeFiled1);

		System.out.println("Step :: Fill New Added Custom Field");
		common.log("<br></br> Step :: Fill New Added Custom Field");
		common.type("//input[@placeholder='" + customeFiled1 + "']", "1232qa");
		enterBillInfo(signUpUser);

		common.pause(15);

		System.out.println("Step :: Verify alert message");
		common.log("<br></br>Verify alert message");
		String getwarningmsg = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][1]")).getText();
		System.out.println("Step :: Warning Messgage >> " + getwarningmsg);
	}

	/**
	 * Signup button.
	 */

	public void signup_button() throws InterruptedException {

		common.pause(20);
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(20);
		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(30);

		common.waitForElement(By.xpath("//ul[@id='messages']"));
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

	}

	/**
	 * Regular Signup with invalid number mandatory
	 * 
	 * @param FirstName
	 * @param LastName
	 * @param EmailUser
	 * @param signUpUser
	 * @param customeFiled1
	 * @throws InterruptedException
	 */

	public void regularSignupWithInvalidNumberMandatory(String FirstName, String LastName, String EmailUser,
			String signUpUser, String customeFiled1) throws InterruptedException {

		System.out.println("Step :: Enter invalid Number");
		common.log("<br></br> Step :: Enter invalid Number");

		System.out.println("Verify added new field ::" + customeFiled1);

		System.out.println("Step :: Fill New Added Custom Field");
		common.log("<br></br> Step :: Fill New Added Custom Field");
		common.type("//input[@placeholder='" + customeFiled1 + " *']", "1232qa");
		enterBillInfo(signUpUser);

		common.pause(15);

		System.out.println("Step :: Verify alert message");
		common.log("<br></br>Verify alert message");
		String getwarningmsg = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][1]")).getText();
		System.out.println("Step :: Warning Messgage >> " + getwarningmsg);
	}

	/**
	 * 
	 * Regular signup with valid number checked checkbox
	 * 
	 * @param FirstName
	 * @param LastName
	 * @param EmailUser
	 * @param signUpUser
	 * @param customeFiled1
	 * @throws InterruptedException
	 */

	public void regularsignupwithvalidnumbercheckedcheckbox(String FirstName, String LastName, String EmailUser,
			String signUpUser, String customeFiled1) throws InterruptedException {

		System.out.println("Step :: Enter valid Number");
		common.log("<br></br> Step :: Enter valid Number");

		System.out.println("Verify added new field ::" + customeFiled1);

		common.type("//div[text()='" + customeFiled1 + ":']//..//input", "123");

		enterBillInfo(signUpUser);

		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

	}

	/**
	 * 
	 * Regualr signup with valid decimal number
	 * 
	 * @param FirstName
	 * @param LastName
	 * @param EmailUser
	 * @param signUpUser
	 * @param customfield1
	 * @throws InterruptedException
	 */
	public void regularSignupWithValidDecimalNumber(String FirstName, String LastName, String EmailUser,
			String signUpUser, String customfield1) throws InterruptedException {

		System.out.println(customfield1);
		System.out.println("Step :: Enter decimal number");
		common.log("<br></br> Step :: Enter decimal number");

		double dec = 12.12;
		// String aString = Double.toString(dec);

		System.out.println("Step :: Fill New Added Custom Field");
		common.log("<br></br> Step :: Fill New Added Custom Field");
		// common.type("//input[@placeholder='" + customfield1 + "']", aString);
		enterBillInfo(signUpUser);

		common.pause(40);
		common.waitForElement(By.xpath("//ul[@id='messages']"));
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

		common.log("<br></br>Step :: signup successful<br>");
	}

	/**
	 * Regular signup with decimal invalid values
	 * 
	 * @param FirstName
	 * @param LastName
	 * @param EmailUser
	 * @param signUpUser
	 * @param customeFiled1
	 * @throws InterruptedException
	 */
	public void regularSignupWithDecimalInvalidValues(String FirstName, String LastName, String EmailUser,
			String signUpUser, String customeFiled1) throws InterruptedException {

		System.out.println("Added custom filed" + customeFiled1);
		System.out.println("Step :: Enter decimal number");
		common.log("<br></br> Step :: Enter decimal number");

		System.out.println("Step :: Fill New Added Custom Field");
		common.log("<br></br> Step :: Fill New Added Custom Field");
		common.type("//input[@placeholder='" + customeFiled1 + "']", "as@@r");
		enterBillInfo(signUpUser);
		common.pause(15);

		System.out.println("Step :: Verify alert message");
		common.log("<br></br>Verify alert message");
		String getwarningmsg = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][1]")).getText();
		System.out.println("Step :: Warning Messgage >> " + getwarningmsg);

	}

	/**
	 * Regular signup with decimal invalid values
	 * 
	 * @param FirstName
	 * @param LastName
	 * @param EmailUser
	 * @param signUpUser
	 * @param customeFiled1
	 * @throws InterruptedException
	 */
	public void regularSignupWithDecimalInvalidValuesMandatory(String FirstName, String LastName, String EmailUser,
			String signUpUser, String customeFiled1) throws InterruptedException {

		System.out.println(customeFiled1);
		System.out.println("Step :: Enter decimal number");
		common.log("<br></br> Step :: Enter decimal number");

		System.out.println("Step :: Fill New Added Custom Field");
		common.log("<br></br> Step :: Fill New Added Custom Field");
		common.type("//input[@placeholder='" + customeFiled1 + " *']", "as@@r");
		enterBillInfo(signUpUser);
		common.pause(40);

		System.out.println("Step :: Verify alert message");
		common.log("<br></br>Verify alert message");
		String getwarningmsg = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][1]")).getText();
		System.out.println("Step :: Warning Messgage >> " + getwarningmsg);

	}

	/**
	 * Regular signup with inputline invalid values
	 * 
	 * @param FirstName
	 * @param LastName
	 * @param EmailUser
	 * @param signUpUser
	 * @param customeFiled1
	 * @throws InterruptedException
	 */
	public void regularSignupWithInputlineValidValues(String FirstName, String LastName, String EmailUser,
			String signUpUser, String customeFiled1) throws InterruptedException {

		System.out.println("Step :: Enter valid values");
		common.log("<br></br> Step :: Enter valid values");

		System.out.println("Verify added new field ::" + customeFiled1);

		System.out.println("Step :: Fill New Added Custom Field");
		common.log("<br></br> Step :: Fill New Added Custom Field");
		common.type("//input[@placeholder='" + customeFiled1 + "']", "123asd");
		enterBillInfo(signUpUser);
		common.pause(35);

		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

	}

	/**
	 * Regular signup with inputline invalid values mandatory
	 * 
	 * @param FirstName
	 * @param LastName
	 * @param EmailUser
	 * @param signUpUser
	 * @param customeFiled1
	 * @throws InterruptedException
	 */
	public void regularSignupWithInputlineValidValuesManadatory(String FirstName, String LastName, String EmailUser,
			String signUpUser, String customeFiled1) throws InterruptedException {

		System.out.println("Step :: Enter valid values");
		common.log("<br></br> Step :: Enter valid values");

		System.out.println("Verify added new field ::" + customeFiled1);

		System.out.println("Step :: Fill New Added Custom Field");
		common.log("<br></br> Step :: Fill New Added Custom Field");
		common.type("//input[@placeholder='" + customeFiled1 + " *']", "@123asd");
		enterBillInfo(signUpUser);
		common.pause(40);

		System.out.println("Step :: Verify alert message");
		common.log("<br></br>Verify alert message");

		String SuccessMessage = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Step :: Verify Success Message >> " + SuccessMessage);
		common.log("<br></br>Step :: Verify Success Message >> " + SuccessMessage);
	}

	/**
	 * 
	 * regualr signup with input line blank
	 * 
	 * @param FirstName
	 * @param LastName
	 * @param EmailUser
	 * @param signUpUser
	 * @param customeFiled1
	 * @throws InterruptedException
	 */

	public void regularSignupWithInputlineInBlank(String FirstName, String LastName, String EmailUser,
			String signUpUser, String customeFiled1) throws InterruptedException {

		System.out.println("Step :: Inputline blank");
		common.log("<br></br> Step :: Inputline blank ");

		System.out.println("Verify added new field ::" + customeFiled1);

		common.type("//input[@placeholder='" + customeFiled1 + " *']", " ");

		enterBillInfo(signUpUser);

		common.pause(40);
		System.out.println("Step :: Verify alert message");
		common.log("<br></br>Verify alert message");
		String getwarningmsg = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][1]")).getText();
		System.out.println("Step :: Warning Messgage >> " + getwarningmsg);

	}

	/**
	 * 
	 * regular signup with dropdown
	 * 
	 * @param FirstName
	 * @param LastName
	 * @param EmailUser
	 * @param signUpUser
	 * @param customeFiled1
	 * @throws InterruptedException
	 */

	public void regularSignupWithDropdown(String FirstName, String LastName, String EmailUser, String signUpUser,
			String customeFiled1) throws InterruptedException {

		System.out.println("Step :: Select value from dropdown");
		common.log("<br></br> Step :: Select value from dropdown");

		System.out.println("Verify added new field ::" + customeFiled1);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0, 650)", "");

		Actions actions = new Actions(driver);
		common.pause(20);
		WebElement element = driver.findElement(By.xpath("//a[text()='" + customeFiled1 + "']"));
		element.click();
		common.pause(10);

		WebElement select_value = driver.findElement(By.linkText("large"));
		common.pause(10);
		actions.moveToElement(select_value);
		actions.moveToElement(select_value).click().perform();
		common.pause(10);
		enterBillInfo(signUpUser);
		common.pause(40);
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

	}

	/**
	 * 
	 * regular signup with dropdown mandatory
	 * 
	 * @param FirstName
	 * @param LastName
	 * @param EmailUser
	 * @param signUpUser
	 * @param customeFiled1
	 * @throws InterruptedException
	 */

	public void regularSignupWithDropdownMandatory(String FirstName, String LastName, String EmailUser,
			String signUpUser, String customeFiled1) throws InterruptedException {

		System.out.println("Step :: Select value from dropdown");
		common.log("<br></br> Step :: Select value from dropdown");

		System.out.println("Verify added new field ::" + customeFiled1);

		Actions actions = new Actions(driver);
		common.pause(30);
		WebElement element = driver.findElement(By.xpath("//a[text()='" + customeFiled1 + " *']"));
		element.click();
		common.pause(10);

		WebElement select_value = driver.findElement(By.linkText("large"));
		common.pause(10);
		actions.moveToElement(select_value);
		actions.moveToElement(select_value).click().perform();
		common.pause(10);
		enterBillInfo(signUpUser);
		common.pause(30);

		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

	}

	/**
	 * regular signup with dropdown blank
	 * 
	 * @param FirstName
	 * @param LastName
	 * @param EmailUser
	 * @param signUpUser
	 * @param customeFiled1
	 * @throws InterruptedException
	 */

	public void regularsignupWithDropdownBlank(String FirstName, String LastName, String EmailUser, String signUpUser,
			String customeFiled1) throws InterruptedException {

		System.out.println("Step :: Dropdown blank");
		common.log("<br></br> Step :: Dropdown blank");

		System.out.println("Verify added new field ::" + customeFiled1);

		common.log("<br></br> Step :: Keep Blank Select Type");
		System.out.println("Step :: Keep Blank Type");

		enterBillInfo(signUpUser);

		common.pause(30);
		System.out.println("Step :: Verify alert message");
		common.log("<br></br>Verify alert message");
		String getwarningmsg = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][1]")).getText();
		System.out.println("Step :: Warning Messgage >> " + getwarningmsg);

	}

	/**
	 * 
	 * Regular signup with text area
	 * 
	 * @param FirstName
	 * @param LastName
	 * @param EmailUser
	 * @param signUpUser
	 * @param customeFiled1
	 * @throws InterruptedException
	 */
	public void regularsignupwithtextarea(String FirstName, String LastName, String EmailUser, String signUpUser,
			String customeFiled1) throws InterruptedException {

		System.out.println("Step :: Enter Number");
		common.log("<br></br> Step :: Enter Number");

		System.out.println("Verify added new field ::" + customeFiled1);
		common.log("Verify added new field ::" + customeFiled1);
		common.pause(10);
		common.type("//textarea[@placeholder='" + customeFiled1 + "']", "rahul");

		enterBillInfo(signUpUser);
		common.pause(30);
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

	}

	/**
	 * 
	 * regular signup with textarea blank
	 * 
	 * @param FirstName
	 * @param LastName
	 * @param EmailUser
	 * @param signUpUser
	 * @param customeFiled1
	 * @throws InterruptedException
	 */

	public void regularSignupWithTextareaBlank(String FirstName, String LastName, String EmailUser, String signUpUser,
			String customeFiled1) throws InterruptedException {

		System.out.println("Step :: Blank Textarea");
		common.log("<br></br> Step :: Blank Textarea");

		System.out.println("Verify added new field ::" + customeFiled1);

		enterBillInfo(signUpUser);

		System.out.println("Step :: Verify alert message");
		common.log("<br></br>Verify alert message");
		String getwarningmsg = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][1]")).getText();
		System.out.println("Step :: Warning Messgage >> " + getwarningmsg);

	}

	/**
	 * regular signup with checkbox checked
	 * 
	 * @param FirstName
	 * @param LastName
	 * @param EmailUser
	 * @param signUpUser
	 * @param customeFiled1
	 * @throws InterruptedException
	 */
	public void regularSignupWithCheckboxCheck(String FirstName, String LastName, String EmailUser, String signUpUser,
			String customeFiled1) throws InterruptedException {

		System.out.println("Step :: Select checkbox");
		common.log("<br></br> Step :: Select checkbox");

		System.out.println("Verify added new field ::" + customeFiled1);
		common.pause(5);
		// driver.findElement(By.xpath("//label[text()='" + customeFiled1 + "
		// *']")).click();

		enterBillInfo(signUpUser);
		common.pause(10);
		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

	}

	/**
	 * 
	 * Regular Signup with checkbox uncheck
	 * 
	 * @param FirstName
	 * @param LastName
	 * @param EmailUser
	 * @param signUpUser
	 * @param customeFiled1
	 * @throws InterruptedException
	 */
	public void regularSignupWithCheckboxUncheck(String FirstName, String LastName, String EmailUser, String signUpUser,
			String customeFiled1) throws InterruptedException {

		System.out.println("Step :: Select Checkbox");
		common.log("<br></br> Step :: Select Checkbox");

		System.out.println("Verify added new field ::" + customeFiled1);
		common.pause(10);
		enterBillInfo(signUpUser);

		common.pause(30);
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);
		verifyNewUserLoggedProperly(signUpUser);
		common.pause(10);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

	}

	/**
	 * Regular signup with checkbox required
	 * 
	 * @param FirstName
	 * @param LastName
	 * @param EmailUser
	 * @param signUpUser
	 * @param customeFiled1
	 * @throws InterruptedException
	 */

	public void regularSignupWithCheckboxRequired(String FirstName, String LastName, String EmailUser,
			String signUpUser, String customeFiled1) throws InterruptedException {

		System.out.println("Step :: Select checkbox");
		common.log("<br></br> Step :: Select checkbox");
		common.pause(5);

		System.out.println("Verify added new field ::" + customeFiled1);
		System.out.println("Verify added new field ::" + customeFiled1);
		common.pause(5);
		driver.findElement(By.xpath("//label[text()='" + customeFiled1 + " *']")).click();
		enterBillInfo(signUpUser);
		common.pause(15);
		System.out.println("Step :: Verify alert message");
		common.log("<br></br>Verify alert message");
		String getwarningmsg = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][1]")).getText();
		System.out.println("Step :: Warning Messgage >> " + getwarningmsg);
	}

	/**
	 * Regular signup with date
	 * 
	 * @param FirstName
	 * @param LastName
	 * @param EmailUser
	 * @param signUpUser
	 * @param customeFiled1
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	public void regularSignupWithDate(String FirstName, String LastName, String EmailUser, String signUpUser,
			String customeFiled1) throws InterruptedException, ParseException {

		System.out.println("Step :: Select Date");
		common.log("<br></br> Step :: Select Date");

		System.out.println("Verify added new field ::" + customeFiled1);

		driver.findElement(By.xpath("//span[@class='" + LEGACY_USER_INFO_DATE_PICKER + "']")).click();

		System.out.println("Step :: Select Date");
		driver.findElement(By.xpath("//span[text()='15']")).click(); // Select
																		// Date
		common.pause(10);

		enterBillInfo(signUpUser);

		common.pause(30);
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

	}

	/**
	 * regular signup with checkbox required
	 * 
	 * @param FirstName
	 * @param LastName
	 * @param EmailUser
	 * @param signUpUser
	 * @param customeFiled1
	 * @throws InterruptedException
	 */
	public void regularSignupWithDateCheckboxRequired(String FirstName, String LastName, String EmailUser,
			String signUpUser, String customeFiled1) throws InterruptedException {

		System.out.println("Step :: Enter Number");
		common.log("<br></br> Step :: Enter Number");

		System.out.println("test message::" + customeFiled1);

		driver.findElement(By.xpath("//span[@class='" + LEGACY_USER_INFO_DATE_PICKER + "']")).click();

		System.out.println("Step :: Select Date");
		driver.findElement(By.xpath("//span[text()='15']")).click(); // Select
																		// Date
		common.pause(10);

		enterBillInfo(signUpUser);

		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

	}

	/**
	 * Regular signup with blank date
	 * 
	 * @param FirstName
	 * @param LastName
	 * @param EmailUser
	 * @param signUpUser
	 * @param customeFiled1
	 * @throws InterruptedException
	 */
	public void regularSignupWithDateBlank(String FirstName, String LastName, String EmailUser, String signUpUser,
			String customeFiled1) throws InterruptedException {

		System.out.println("Step :: Enter Number");
		common.log("<br></br> Step :: Enter Number");

		System.out.println("verify added new field ::" + customeFiled1);

		enterBillInfo(signUpUser);

		common.pause(30);
//		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
//		System.out.println("Application messsage display :: " + str_confirmation);

		System.out.println("Step :: Verify alert message");
		common.log("<br></br>Verify alert message");
		String getwarningmsg = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][1]")).getText();
		System.out.println("Step :: Warning Messgage >> " + getwarningmsg);

	}

	/**
	 * 
	 * Regular signup with text area not required
	 * 
	 * @param FirstName
	 * @param LastName
	 * @param EmailUser
	 * @param signUpUser
	 * @param customeFiled1
	 * @throws InterruptedException
	 */
	public void regularSignupWithTextareaNotRequired(String FirstName, String LastName, String EmailUser,
			String signUpUser, String customeFiled1) throws InterruptedException {

		System.out.println("Step :: Enter Number");
		common.log("<br></br> Step :: Enter Number");

		System.out.println("Verify added new field ::" + customeFiled1);
		common.log("Verify added new field ::" + customeFiled1);
		common.pause(10);
		common.type("//textarea[@placeholder='" + customeFiled1 + "']", "rahul");

		enterBillInfo(signUpUser);
		common.pause(30);
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

	}

	/**
	 * 
	 * Regular signup with text area is required
	 * 
	 * @param FirstName
	 * @param LastName
	 * @param EmailUser
	 * @param signUpUser
	 * @param customeFiled1
	 * @throws InterruptedException
	 */
	public void regularSignupWithTextareaIsRequired(String FirstName, String LastName, String EmailUser,
			String signUpUser, String customeFiled1) throws InterruptedException {

		System.out.println("Step :: Enter Number");
		common.log("<br></br> Step :: Enter Number");

		System.out.println("Verify added new field ::" + customeFiled1);
		common.log("Verify added new field ::" + customeFiled1);
		common.pause(10);
		common.type("//textarea[@placeholder='" + customeFiled1 + " *']", "testdata");

		enterBillInfo(signUpUser);
		common.pause(30);
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

	}

	/**
	 * Regular signup with upload file
	 * 
	 * @param FirstName
	 * @param LastName
	 * @param EmailUser
	 * @param signUpUser
	 * @param customeFiled1
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void regularSignupWithUploadPDFFile(String FirstName, String LastName, String EmailUser, String signUpUser,
			String customeFiled1) throws InterruptedException, AWTException {

		// for window
		String path_win = System.getProperty("user.dir") + "\\test_data\\sample.pdf";

		StringSelection filepath = new StringSelection(path_win);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		// for mac
		// File file = new
		// File("/Users/apple/Documents/workspace/samauctionsoftware/test_data/sample.pdf");

		// StringSelection stringSelection = new
		// StringSelection(path_win.getAbsolutePath());

		// Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path_win, null);

		// String path_ios = String.valueOf(file);

		Robot robot = new Robot();

		// For Mac System
		System.out.println("test message::" + customeFiled1);

		System.out.println("Step :: Click on add file button");
		driver.findElement(By.xpath("//input[@value='Add file']")).click();
		common.pause(50);

		System.out.println("Step :: Click on + Button");
		driver.findElement(By.xpath("//img[@alt='Upload']")).click();

		common.pause(40);
		System.out.println("Step :: Click on Browse.. Button");
		Actions action = new Actions(driver);

		WebElement file1 = driver.findElement(By.xpath("//input[@id='c7']"));
		common.pause(10);
		action.moveToElement(file1);
		action.moveToElement(file1).click().perform();

		common.pause(70);

		robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
		robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
		common.pause(15);

		common.pause(30);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		common.pause(30);

		robot.delay(200);
		robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
		robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
		common.pause(20);
		robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
		robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);

		common.pause(50);
		driver.findElement(By.xpath("//input[@id='c8']")).click();
		common.pause(50);

		System.out.println("Step :: Verify uploaded file");
		common.log("<br></br>Verify uploaded file");

		common.assertElementPresent("//span[@id='c2']");
		common.pause(25);

		enterBillInfo(signUpUser);

		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

	}

	/**
	 * Regular signup with upload image
	 * 
	 * @param FirstName
	 * @param LastName
	 * @param EmailUser
	 * @param signUpUser
	 * @param customeFiled1
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	public void regularSignupWithUploadImageFile(String FirstName, String LastName, String EmailUser, String signUpUser,
			String customeFiled1) throws InterruptedException, AWTException {

		// for window
		String path_win = System.getProperty("user.dir") + "\\test_data\\sample.pdf";

		StringSelection filepath = new StringSelection(path_win);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, null);
		// for mac
		// File file = new
		// File("/Users/apple/Documents/workspace/samauctionsoftware/test_data/sample.pdf");

		// StringSelection stringSelection = new
		// StringSelection(path_win.getAbsolutePath());

		// Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path_win, null);

		// String path_ios = String.valueOf(file);

		Robot robot = new Robot();

		// For Mac Systema
		System.out.println("test message::" + customeFiled1);

		System.out.println("Step :: Click on add file button");
		driver.findElement(By.xpath("//input[@value='Add file']")).click();
		common.pause(50);

		System.out.println("Step :: Click on + Button");
		driver.findElement(By.xpath("//img[@alt='Upload']")).click();

		common.pause(40);
		System.out.println("Step :: Click on Browse.. Button");
		Actions action = new Actions(driver);

		WebElement file1 = driver.findElement(By.xpath("//input[@id='c7']"));
		common.pause(10);
		action.moveToElement(file1);
		action.moveToElement(file1).click().perform();

		common.pause(70);

		robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
		robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
		common.pause(15);

		common.pause(30);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		common.pause(30);

		robot.delay(200);
		robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
		robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
		common.pause(20);
		robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
		robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);

		common.pause(50);
		driver.findElement(By.xpath("//input[@id='c8']")).click();
		common.pause(50);

		System.out.println("Step :: Verify uploaded file");
		common.log("<br></br>Verify uploaded file");

		common.assertElementPresent("//span[@id='c2']");
		common.pause(25);

		enterBillInfo(signUpUser);

		verifyNewUserLoggedProperly(signUpUser);
		common.log("<br></br><font color=#0B610B> Step :: TestCase 1.2 Regular Signup => Working</font>");

	}

	/**
	 * Paypal Payment
	 * 
	 * @param signUpUser
	 * @param EmailUser
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	public void paypalpayment(String signUpUser, String EmailUser) throws InterruptedException, ParseException {

		System.out.println("Step :: Click on Invoices");
		common.log("<br></br> Step :: Click on Invoices");

		driver.findElement(By.xpath("//span[text()='Invoices']")).click();

		driver.findElement(By.xpath("//select[@id='c1']//option[text()='Pending']")).click();

		driver.findElement(
				By.xpath("//a[text()='view']//..//a[@href='http://v3-1.auctionserver.net/my-invoices/view/id/138/']"))
				.click();

		common.pause(30);

		driver.findElement(By.xpath("//input[@id='c31']")).click();

	}

	/**
	 * Select Country and State
	 * 
	 */

	public void Select_Counrty_and_State() {

		// Select Country

		System.out.println("Step :: Select Country.");
		common.log("<br></br>Step :: Select Country.");

		common.pause(20);

		driver.findElement(By.xpath("//span[@id='rbp7_ctl']//a[@class='sbToggle']")).click();
		// common.jsClick(Selectcountry);
		common.pause(10);

		driver.findElement(By.xpath("//span[@id='rbp7_ctl']//..//a[contains(text(),'Canada')]")).click();

		common.pause(10);
		// Select State

		common.pause(15);
		driver.findElement(By.xpath("//span[@id='rbp37_ctl']//a[@class='sbToggle']")).click();
		// common.jsClick(SelectCanada);

		common.pause(10);
		//
		System.out.println("Step :: Select Alberta.");
		common.log("<br></br>Step :: Select Alberta.");
		driver.findElement(By.xpath("//span[@id='rbp37_ctl']//..//a[contains(text(),'Alberta')]")).click();

		common.pause(10);
	}

	/**
	 * Select Country and State
	 * 
	 */

	public void Select_Shipping_Counrty_and_State() {

		// Select Country

		System.out.println("Step :: Select Country.");
		common.log("<br></br>Step :: Select Country.");
		common.pause(10);
		WebElement SelectCounrty = driver.findElement(By.xpath("//span[@id='sip7_ctl']//..//a[@class='sbToggle']"));
		SelectCounrty.click();
		common.pause(10);

		driver.findElement(By.xpath("//select[@id='sip7']//..//..//a[text()='Canada']")).click();
		common.pause(10);

		// Select State

		System.out.println("Step :: Select State.");
		common.log("<br></br>Step :: Select State.");
		common.pause(20);
		common.waitForElement(By.xpath("//span[@id='sip27_ctl']//..//a[@class='sbToggle']"));
		WebElement SelectState = driver
				.findElement(By.xpath("//select[@id='sip27']//..//..//div//a[@class='sbToggle']"));
		SelectState.click();
		common.pause(10);

		driver.findElement(By.xpath("//select[@id='sip27']//..//..//a[text()='Alberta']")).click();

	}

	/**
	 * Select Billing info phone type
	 * 
	 */
	public void Select_Billing_Info_Phone_Type()

	{

		System.out.println("Step :: Phone Type.");
		common.log("<br></br>Step :: Phone Type.");

		Actions actions = new Actions(driver);
		common.pause(10);
		WebElement element = driver.findElement(By.xpath("//span[@id='rbp25_ctl']//..//a[@class='sbToggle']"));
		element.click();
		common.pause(10);
//
//		// Select Phone Type
		driver.findElement(By.xpath("//span[@id='rbp25_ctl']//..//a[contains(text(),'Work')]")).click();

		// WebElement select_Work = driver.findElement(By.linkText("+1 (Canada /
		// USA)"));
		// common.pause(10);
		// actions.moveToElement(select_Work);
		// actions.moveToElement(select_Work).click().perform();
		common.pause(10);

	}

	/**
	 * Select User info phone type
	 * 
	 */
	public void Select_User_Info_Phone_Type()

	{

		System.out.println("Step :: Phone Type.");
		common.log("<br></br>Step :: Phone Type.");
		common.pause(10);
		driver.findElement(By.xpath("//span[@id='pip11_ctl']//..//a[@class='sbToggle']")).click();

		common.pause(10);
		// Select Phone Type
		driver.findElement(By.xpath("//span[@id='pip11_ctl']//..//a[contains(text(),'Work')]")).click();

		common.pause(15);

	}

	/**
	 * Select Identification Type
	 * 
	 */
	public void Select_Identification_Type() {

		System.out.println("Step :: Identification Number.");
		common.log("<br></br>Step :: Identification Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_IDENTIFICATION + "']",
				LEGACY_USER_SIGNUP_TXT_IDENTIFICATION_VALUE);

		// Select Identification Type

		System.out.println("Step :: Select Identification Type.");
		common.log("<br></br>Step :: Select Identification Type.");

		Actions id = new Actions(driver);
		common.pause(10);
		WebElement idtype = driver.findElement(By.xpath("//a[text()='Identification Type']"));
		idtype.click();
		common.pause(15);

		// System.out.println("Step :: Driver's License #");
		// common.log("<br></br>Step :: Driver's License #");
		// driver.findElement(By.xpath("//select[@id='pip13']//option[2]")).click();

		// WebElement Select_Id = driver.findElement(By.linkText("Driver's License #"));
		// common.pause(15);
		// id.moveToElement(Select_Id);
		// id.moveToElement(Select_Id).click().perform();
		// common.pause(10);
	}

	/**
	 * Enter CC Details
	 * 
	 */

	public void Enter_CC_Details() {
		/**
		 * Select CC Type
		 */
		common.pause(40);
		System.out.println("Step :: Select CC Type.");
		common.log("<br></br>Step :: Select CC Type.");
		// common.waitForElement(By.xpath("//input[@id='" +
		// LEGACY_USER_SIGNUP_TXT_CC_NUMBER + "']"));
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CC_NUMBER + "']", "4111111111111111");

		common.pause(15);
		driver.findElement(By.xpath("//span[@id='rbp13_ctl']//a[@class='sbToggle']")).click();
		common.pause(15);
		driver.findElement(By.xpath("//span[@id='rbp13_ctl']//a[contains(text(),'Visa')]")).click();
		common.pause(20);
		/**
		 * Select Expiration Month
		 *
		 */
		System.out.println("Step :: Select CC Month.");
		common.log("<br></br>Step :: Select CC Month.");
		common.pause(15);
		driver.findElement(By.xpath("//span[@id='rbp15_ctl']//a[@class='sbToggle']")).click();
		common.pause(15);
		driver.findElement(By.xpath("//span[@id='rbp15_ctl']//a[contains(text(),'March')]")).click();
		common.pause(20);
		/**
		 * Select Expiration Year
		 *
		 */
		System.out.println("Step :: Select CC Year.");
		common.log("<br></br>Step :: Select CC Year.");
		driver.findElement(By.xpath("//span[@id='rbp16_ctl']//..//a[@class='sbToggle']")).click();
		common.pause(20);
		driver.findElement(By.xpath("//a[contains(text(),'2026')]")).click();
		common.pause(20);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_SECURITY_CODE + "']", "123");
	}

	/**
	 * Select Bank Account Type
	 * 
	 */
	public void Select_Bank_Account_Type()

	{
		System.out.println("Step :: Enter Bank Name.");
		common.log("<br></br>Step :: Enter Bank Name.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_BANK_NAME + "']", "bank of america");

		System.out.println("Step :: Enter Bank Account Name.");
		common.log("<br></br>Step :: Enter Bank Account Name.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_BANK_ACCOUNT_NAME + "']", "rahul account");

		System.out.println("Step :: Select Bank Account Type.");
		common.log("<br></br>Step :: Select Bank Account Type.");

		// Actions actions = new Actions(driver);
		common.pause(10);
		driver.findElement(By.xpath("//span[@id='rbp20_ctl']//a[@class='sbToggle']")).click();

		common.pause(10);

		// Select Account Type
		driver.findElement(By.xpath("//span[@id='rbp20_ctl']//a[contains(text(),'Savings')]")).click();
//		WebElement select_actype = driver.findElement(By.linkText("Savings"));
//		common.pause(20);
//		actions.moveToElement(select_actype);
//		actions.moveToElement(select_actype).click().perform();
		common.pause(20);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_BANK_ROUTING + "']", "123456789");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_BANK_ACCOUNT + "']", "1234554321");

	}

	public void Select_Bank_Account_Type1()

	{
		System.out.println("Step :: Enter Bank Name.");
		common.log("<br></br>Step :: Enter Bank Name.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_BANK_NAME + "']", "bank of america");

		System.out.println("Step :: Enter Bank Account Name.");
		common.log("<br></br>Step :: Enter Bank Account Name.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_BANK_ACCOUNT_NAME + "']", "rahul account");

		System.out.println("Step :: Select Bank Account Type.");
		common.log("<br></br>Step :: Select Bank Account Type.");

		Actions actions = new Actions(driver);
		common.pause(10);
		WebElement actype = driver.findElement(By.xpath("//a[text()='Bank account type']"));
		actype.click();
		common.pause(15);

		// Select Account Type

		WebElement select_actype = driver.findElement(By.linkText("Savings"));
		common.pause(20);
		actions.moveToElement(select_actype);
		actions.moveToElement(select_actype).click().perform();
		common.pause(20);

	}

	/**
	 * Enter Expired CC Details
	 * 
	 */

	public void Enter_Expired_CC_Details()

	{
		/**
		 * Select CC Type
		 */

		common.pause(10);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CC_NUMBER + "']", "4111111111111112");

		System.out.println("Step :: Select CC Type.");
		common.log("<br></br>Step :: Select CC Type.");
		common.pause(15);
		driver.findElement(By.xpath("//span[@id='rbp13_ctl']//a[@class='sbToggle']")).click();
		common.pause(15);
		driver.findElement(By.xpath("//span[@id='rbp13_ctl']//a[contains(text(),'Visa')]")).click();

		common.pause(20);

		/**
		 * Select Expiration Month
		 * 
		 */

		System.out.println("Step :: Select CC Month.");
		common.log("<br></br>Step :: Select CC Month.");

		common.pause(15);
		driver.findElement(By.xpath("//span[@id='rbp15_ctl']//a[@class='sbToggle']")).click();
		common.pause(15);
		driver.findElement(By.xpath("//span[@id='rbp15_ctl']//a[contains(text(),'March')]")).click();

		common.pause(20);

		/**
		 * Select Expiration Year
		 * 
		 */

		System.out.println("Step :: Select CC Year.");
		common.log("<br></br>Step :: Select CC Year.");
		common.pause(15);
		driver.findElement(By.xpath("//span[@id='rbp16_ctl']//..//a[@class='sbToggle']")).click();
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'2022')]")).click();

		common.pause(20);

		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_SECURITY_CODE + "']", "123");

	}

	/**
	 * Enter CC Details With Invalid CC number
	 * 
	 */

	public void Enter_CC_Details_With_Invalid_CC_Number()

	{

		/**
		 * Select CC Type
		 */

		common.pause(10);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CC_NUMBER + "']", "411111111");

		System.out.println("Step :: Select CC Type.");
		common.log("<br></br>Step :: Select CC Type.");
		common.pause(15);
		driver.findElement(By.xpath("//span[@id='rbp13_ctl']//a[@class='sbToggle']")).click();
		common.pause(15);
		driver.findElement(By.xpath("//span[@id='rbp13_ctl']//a[contains(text(),'Visa')]")).click();

		common.pause(20);

		/**
		 * Select Expiration Month
		 * 
		 */

		System.out.println("Step :: Select CC Month.");
		common.log("<br></br>Step :: Select CC Month.");

		common.pause(15);
		driver.findElement(By.xpath("//span[@id='rbp15_ctl']//a[@class='sbToggle']")).click();
		common.pause(15);
		driver.findElement(By.xpath("//span[@id='rbp15_ctl']//a[contains(text(),'March')]")).click();

		common.pause(20);

		/**
		 * Select Expiration Year
		 * 
		 */

		System.out.println("Step :: Select CC Year.");
		common.log("<br></br>Step :: Select CC Year.");
		common.pause(15);
		driver.findElement(By.xpath("//span[@id='rbp16_ctl']//..//a[@class='sbToggle']")).click();
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'2022')]")).click();

		common.pause(20);

		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_SECURITY_CODE + "']", "123");
	}

	/**
	 * Select Shipping info contact type
	 * 
	 */
	public void Select_Shipping_Info_Phone_Type()

	{

		System.out.println("Step :: Phone Type.");
		common.log("<br></br>Step :: Phone Type.");

		Actions actions = new Actions(driver);
		common.pause(10);
		WebElement element = driver.findElement(By.xpath("//span[@id='sip15_ctl']//a[@class='sbToggle']"));
		element.click();
		common.pause(10);

		// Select Phone Type

		driver.findElement(By.xpath(
				"//body/div[@id='wrapper']/form[@id='SignupForm']/div[1]/article[1]/ul[1]/li[3]/div[2]/section[1]/div[1]/div[1]/ul[1]/li[2]/div[1]/span[1]/div[1]/ul[1]/li[2]/a[1]"))
				.click();

//		WebElement select_Work = driver.findElement(By.linkText("Work"));
//		common.pause(10);
//		actions.moveToElement(select_Work);
//		actions.moveToElement(select_Work).click().perform();
		common.pause(10);

	}

	/**
	 * Regular SignUp With Basic info Mandatory CC info Not Mandatory ACH info Not
	 * Mandatory
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void Regular_SignUp_With_Basic_Info_Mandatory_CCInfo_Not_Mandatory_And_ACHinfo_Not_Mandatory()
			throws InterruptedException {

		signupUser(); // SignUp User

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(30);

		String getPhoneNumberWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_2 + "'][1]")).getText();

		System.out.println("Step :: Warning Message >>" + getPhoneNumberWarningMessage);
		String getFirstnameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "'][2]")).getText();
		System.out.println("Step :: Warning Message >> " + getFirstnameWarningMessage);

		String getLastnameWarningMessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_1 + "'][3]")).getText();
		System.out.println("Step :: Warning Message >> " + getLastnameWarningMessage);

		common.pause(10);

		System.out.println("Assert Values");

		common.assertTwoValuesAreEqual(getFirstnameWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getLastnameWarningMessage, LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME_ALERT_MESSAGE);
		common.assertTwoValuesAreEqual(getPhoneNumberWarningMessage,
				LEGACY_USER_SIGNUP_BILL_TXT_CONTACT_TYPE_ALERT_MESSAGE);

		Select_Billing_Info_Phone_Type(); // Select Phone Type

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", contactLast);

		common.log("<br></br>Step :: Billing Phone Number.");
		System.out.println("Step :: Billing Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		common.log("<br></br>Step :: Entering Captcha.");
		System.out.println("Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		common.pause(10);

		common.log("<br></br>Step :: Click on signUp button.");
		System.out.println("Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(40);
		common.waitForElement(By.xpath("//ul[@id='messages']"));
		String str_confirmation = driver.findElement(By.xpath("//ul[@id='messages']")).getText();
		System.out.println("Application messsage display :: " + str_confirmation);

		common.log("<br></br>Step :: signup successful<br>");

	}

	public void verify_400_Bad_Request_Occurred_Or_Not() throws InterruptedException {
		common.pause(25);
		System.out.println("SignupUser Details");

		System.out.println("Step :: SignupUSer Details.");
		common.log("<br></br> Step :: SignupUSer Details.");
		common.jsClick(signUpLink);
		// common.waitForConditionIsElementPresent(("//a"));

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);

		common.pause(30);
		common.assertElementPresent("//span[contains(text(),'Signup failed. Please check the following for erro')]");
		common.waitForElement(
				By.xpath("//span[contains(text(),'Signup failed. Please check the following for erro')]"));
		String str_confirmation = driver
				.findElement(By.xpath("//span[contains(text(),'Signup failed. Please check the following for erro')]"))
				.getText();
		System.out.println("Application messsage display :: " + str_confirmation);

	}

	public void Verify_Regular_Signup() throws InterruptedException {
		String FistName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		common.pause(20);
		System.out.println("Step :: Admin logout front");
		common.log("<br></br> Step :: Admin logout front");

		common.pause(25);

		common.jsClick(signUpLink);
		common.pause(80);

		System.out.println("Step :: Enter SignupUser Details");
		common.log("<br></br> Step :: SignupUSer Details.");
		// common.waitForElementIsDisplayed(By.xpath("//input[@id='" +
		// LEGACY_USER_SIGNUP_TXT_USERNAME + "']"));

		String signUpUser = common.generateRandomChars(6);

		common.waitForElement(By.xpath("//input[@id='\" + LEGACY_USER_SIGNUP_TXT_USERNAME + \"']\""));
		System.out.println("Step :: Enter Username ::" + signUpUser);
		common.log("<br></br>Step :: Enter New User");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']", signUpUser);

		common.log("<br></br>Step :: Random Value :: " + signUpUser);
		System.out.println("Step :: Random Value :: " + signUpUser);

		System.out.println("Step :: Enter First Name");
		common.log("<br></br> Step :: Enter First Name");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_FIRST_NAME + "']", signUpUser);

		System.out.println("Step :: Enter Last Name");
		common.log("<br></br> Step :: Enter Last Name");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_LAST_NAME + "']", signUpUser);

		System.out.println("Step :: New User >>" + "  " + signUpUser);
		common.log("<br></br>Step : New User >>" + "  " + signUpUser);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']", signUpUser);

		System.out.println("Step :: Enter Password");
		common.log("<br></br> Step :: Enter Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PASSWORD + "']", LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);

		System.out.println("Step :: Enter Confirm Password");
		common.log("<br></br> Step :: Enter Confirm Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_PASSWORD + "']",
				LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);

		System.out.println("Step :: Enter EmailUser :: " + EmailUser);
		common.log("<br></br>Step :: Enter EmailUser :: " + EmailUser);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_EMAIL + "']",
				EmailUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);
		common.pause(20);

		if (common.isElementPresent("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_EMAIL + "']"))

		{
			System.out.println("Step :: Enter Confim Email :: " + EmailUser);
			common.log("<br></br>Step :: Enter Confirm Email :: " + EmailUser);
			common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_EMAIL + "']",
					EmailUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);
		}

		else {
			System.out.println("Step :: Enter Confim Email is not display");
		}

		System.out.println("Step :: Enter Phone Number.");
		common.log("<br></br>Step :: Enter Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		System.out.println("Step :: Phone Type.");
		common.log("<br></br>Step :: Phone Type.");
		common.pause(10);
		driver.findElement(By.xpath("//span[@id='pip11_ctl']//..//a[@class='sbToggle']")).click();

		common.pause(10);
		// Select Phone Type
		driver.findElement(By.xpath("//span[@id='pip11_ctl']//..//a[contains(text(),'Work')]")).click();

		common.pause(15);

		System.out.println("Step :: Identification Number.");
		common.log("<br></br>Step :: Identification Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_IDENTIFICATION + "']",
				LEGACY_USER_SIGNUP_TXT_IDENTIFICATION_VALUE);

		System.out.println("Step :: Identification Number.");
		common.log("<br></br>Step :: Identification Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_IDENTIFICATION + "']",
				LEGACY_USER_SIGNUP_TXT_IDENTIFICATION_VALUE);

		// Select Identification Type

		System.out.println("Step :: Select Identification Type.");
		common.log("<br></br>Step :: Select Identification Type.");

		Actions id = new Actions(driver);
		common.pause(10);
		WebElement idtype = driver.findElement(By.xpath("//a[text()='Identification Type']"));
		idtype.click();
		common.pause(15);

		System.out.println("Step :: Verify that captcha code filed is present");
		common.log("Step :: Verify that captcha code field is present");
		common.assertElementPresent("//input[@id='rf3']");

		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);
		common.pause(10);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(20);

	}

	public void verify_Check_Simplified_Sign_up_page_options() {

		common.pause(20);
		common.highlightElement("//span[contains(text(),'" + LEGACY_USER_SIGNUP_USER_INFORMATION_TAB + "')]");
		common.assertElementPresent("//span[contains(text(),'" + LEGACY_USER_SIGNUP_USER_INFORMATION_TAB + "')]");
		System.out.println("\nStep ::Verified User Informations tab.");
		common.log("<br></br>Step ::Verified User Informations tab.");
		common.pause(30);

		common.highlightElement("//span[contains(text(),'" + LEGACY_USER_SIGNUP_BILLING_INFORMATION_TAB + "')]");
		common.assertElementPresent("//span[contains(text(),'" + LEGACY_USER_SIGNUP_BILLING_INFORMATION_TAB + "')]");
		System.out.println("Step ::Verified Billing Informations tab.");
		common.log("<br></br>Step ::Verified Billing Informations tab.");
		common.pause(30);

		common.highlightElement("//span[contains(text(),'" + LEGACY_USER_SIGNUP_SHIPPING_INFORMATION_TAB + "')]");
		common.assertElementPresent("//span[contains(text(),'" + LEGACY_USER_SIGNUP_SHIPPING_INFORMATION_TAB + "')]");
		System.out.println("Step ::Verified Shipping Informations tab.");
		common.log("<br></br>Step ::Verified Shipping Informations tab.");
		common.pause(30);

		common.highlightElement("//span[contains(text(),'" + LEGACY_USER_SIGNUP_CONFIRMATION_TAB + "')]");
		common.assertElementPresent("//span[contains(text(),'" + LEGACY_USER_SIGNUP_CONFIRMATION_TAB + "')]");
		System.out.println("Step ::Verified Confirmation tab.");
		common.log("<br></br>Step ::Verified Confirmation tab.");
		common.pause(30);

	}

	public void verify_Check_the_Alert_Tab_at_Sign_Up_Page() {
		common.pause(20);
		common.highlightElement("//span[contains(text(),'" + LEGACY_FRONT_LOGIN_TXT_ALERT + "')]");
		common.assertElementPresent("//span[contains(text(),'" + LEGACY_FRONT_LOGIN_TXT_ALERT + "')]");
		System.out.println("Step ::Verified User Informations tab.");
		common.log("<br></br>Step ::Verified User Informations tab.");
		common.pause(30);
	}

	public void check_Sameasbilling_Checkbox() throws InterruptedException { 
		
		common.pause(20);
		common.highlightElement("//input[@id='sip1']");
		System.out.println("Step :: Verify Same as billing check box is present");
		common.log("Step :: Verfiy Same as billing checkbox is present");
		common.assertElementPresent("//input[@id='sip1']");

		System.out.println("Step :: Click on Same as billing check box.");
		common.log("<br></br>Step :: Click on Same as billing check box.");
		common.checkChkBox(ship);
		common.pause(30);
		
		}
	}
