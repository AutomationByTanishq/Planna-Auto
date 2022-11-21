package com.auction.verifications;

import java.awt.AWTException;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.auction.admin.pages.AdminDashboardPage;
//import atu.testng.reports.ATUReports;
//import atu.testng.reports.listeners.ConfigurationListener;
//import atu.testng.reports.listeners.MethodListener;
//import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;
import com.auction.init.Common;
import com.auction.init.ConfigFileReader;
import com.auction.init.SeleniumInit;
//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;

import groovyjarjarasm.asm.commons.Method;

public class Index extends SeleniumInit {
	ConfigFileReader configFileReader= new ConfigFileReader();
	Common common = new Common(driver);

	// ------------------------------------------------------------------------------------------------------------------------//
	// ------------------------------------------- Login Method
	// -------------------------------------------------------------//
	// ------------------------------------------------------------------------------------------------------------------------/

	/**
	 * Verify Login Feature
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test(dataProvider = "login")
	public void Login_Feature(String username, String password) throws InterruptedException, IOException {

		log("<br></br>Feature" + "-" + "UAT" + "\"Login Feature,TestCase Name: 1.1 Login Feature.");
		System.out.println("Feature" + "-" + "UAT" + "\"Login Feature,TestCase Name: 1.1 Login Feature.");
		System.out.println("Script : LoginFeature");

		log("<br></br> Step :: Enter the URL in browser address bar and hit enter.");

		common.getOS();
		
		driver.get(configFileReader.getqa_MainAutoFront());
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verifyLoginPageElements(); // Verify Login Page Elements

//		String user = read_from_excel.RedFromExcelUser();
//		String pass = read_from_excel.RedFromExcelPass();
		dashboardPage = loginPage.loginUser(username, password); // Login with
																	// valid
																	// credentials

	}

	// ------------------------------------------------------------------------------------------------------------------------//
	// ------------------------------------------- Regular Signup
	// ------------------------------------------------------------//
	// ------------------------------------------------------------------------------------------------------------------------//

	/**
	 * Verify Regular Sign up regularSignUp
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException 
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_SignUp(String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		// test = extent.startTest("Regular_SignUp");
		log("<br></br>Feature" + "-" + "UAT" + "\"Regular SignUp Feature,TestCase Name: 1.2 RegularSignUp");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"Regular SignUp Feature,TestCase Name: 1.2 RegularSignUp");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step :: Enter the URL in browser address bar and hit enter.");

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);

		common.getOS();
		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.delete_Custom_Field();
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxRegularSignupWithVerifyRequireCreditCardOnSignUp();
		adminDashboardPage.verifyCheckedCheckboxOnRegistrationSettingsForRegularSignup(); // Verify
																				// Checked
																				// Check
																				// box
																				// On
																				// Registration
																				// Settings
																				// Module
		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End

		signupPage.regularSignUp(FirstName, LastName, EmailUser, signUpUser); // Regular
																				// Sign
																				// Up
		signupPage.signup_Success_Message(); // Verify Succeess Message
		driver.quit();

	}

	/**
	 * Regular Signup With User Edit Profile
	 * 
	 * @param adminUserName
	 * @param adminPasswordjhghjgoppppppppppppppppppppp
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException 
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_User_Edit_Profile(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {
		// test = extent.startTest("Regular_Signup_With_User_Edit_Profile");
		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL

		String FirstName = common.generateRandomChars(6);
		String LastName = Common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.delete_Custom_Field();
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxRegularSignupWithVerifyRequireCreditCardOnSignUp();
		adminDashboardPage.verifyCheckedCheckboxOnRegistrationSettingsForRegularSignup(); // Verify
																				// Checked
																				// Check
																				// box
																				// On
																				// Registration
																				// Settings
																				// Module
		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUp(FirstName, LastName, EmailUser, signUpUser); // Regular
																				// Sign
																				// Up

		signupPage.verifyUserEditProfile(signUpUser, EmailUser); // Verify user
																	// profile

		driver.quit();

	}

	// ------------------------------------------------------------------------------------------------------------------------//
	// ------------------------------------------- Regular Signup with Email
	// Already Exist In The System
	// ------------------------------------------------------------//
	// ------------------------------------------------------------------------------------------------------------------------//

	/**
	 * Verify Regular Sign up With Username Already Exist
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException 
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_Already_Email_Exist(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp with email already exist in the system Name: 1.3 regularSignupalreadyEmailExist");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp with email already exist in the system Name: 1.3 regularSignupalreadyEmailExist");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.delete_Custom_Field();
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxOnRegistrationSettingsForRegularSignup(); // Verify
																				// Checked
																				// Check
																				// box
																				// On
																				// Registration
																				// Settings
																				// Module
		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignupWithExistingEmailUser(); // Regular Sign Up with
		// existing user
		driver.quit();

	}

	// ------------------------------------------------------------------------------------------------------------------------//
	// ------------------------------------------- Regular Signup With Username
	// Already Exist
	// ------------------------------------------------------------//
	// ------------------------------------------------------------------------------------------------------------------------//

	/**
	 * Verify Regular Sign up With Username Already Exist
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException 
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_SignUp_With_Username_Already_Exist(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp with username already exist feature,TestCase Name: 1.2 regularSignUpWithUsernameAlreadyExist");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp with username already exist feature,TestCase Name: 1.2 regularSignUpWithUsernameAlreadyExist");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		
		adminDashboardPage.delete_Custom_Field();
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxOnRegistrationSettingsForRegularSignup(); // Verify
																				// Checked
																				// Check
																				// box
																				// On
																				// Registration
																				// Settings
																				// Module
		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignupWithExistingUser(); // Regular Sign Up with
													// existing user
		driver.quit();

	}

	// ------------------------------------------------------------------------------------------------------------------------//
	// ------------------------------------------- Regular Signup With No
	// Captcha --------------------------------------------//
	// ------------------------------------------------------------------------------------------------------------------------//

	/**
	 * Verify Regular Sign up No Captcha Feature
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException 
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_No_Captcha(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.31 RegularSignUp No Captcha Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.31 RegularSignUp No Captcha Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.delete_Custom_Field();
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxOnRegistrationSettingsForRegularSignup(); // Verify
																				// Checked
																				// Check
																				// box
																				// On
																				// Registration
																				// Settings
																				// Module
		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpNoCaptcha(); // Regular Sign Up No Captcha Value
		driver.quit();
	}

	// ------------------------------------------------------------------------------------------------------------------------//
	// ------------------------------------------- Regualr Signup With Wrong
	// Capcha -----------------------------------------//
	// ------------------------------------------------------------------------------------------------------------------------//

	/**
	 * Verify Regular Sign up Wrong Captcha Feature
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException 
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_Wrong_Captcha(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.32 RegularSignUp Wrong Captcha Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.32 RegularSignUp Wrong Captcha Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.delete_Custom_Field();
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxOnRegistrationSettingsForRegularSignup(); // Verify
																				// Checked
																				// Check
																				// box
																				// on
																				// Registration
																				// Settings
																				// Module
		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWrongCaptcha(); // Regular Sign Up with Wrong
												// Captcha Value
		driver.quit();
	}

	// ------------------------------------------------------------------------------------------------------------------------//
	// ------------------------------------------- Regualr Signup With
	// Confirmation Is Not Checked
	// ------------------------------------------------------------------------------------------------------------------------//

	/**
	 * Verify Regular Sign up Confirmation is not checked
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException 
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_Confirmation_Is_Not_Checked(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String signUpUser = common.generateRandomChars(6);

		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.33 RegularSignUp Confirmation Is Not Checked Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.33 RegularSignUp Confirmation Is Not Checked Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.delete_Custom_Field();
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxOnRegistrationSettingsForRegularSignup(); // Verify
																				// Checked
																				// Check
																				// box
																				// on
																				// Registration
																				// Settings
																				// Module
		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpConfirmationIsNotChecked(signUpUser); // Regular
																		// Sign
																		// Up
		// with Confirmation
		// Is Not Checked
		driver.quit();
	}

	// ------------------------------------------------------------------------------------------------------------------------//
	// ------------------------------------------- Regualr Signup With
	// Basic Information Mandatory
	// All filled out
	// ------------------------------------------------------------------------------------------------------------------------//

	/**
	 * Verify Regular Sign up with Basic informtion mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Mandatory(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.74 Regular SignUp With Basic Information Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.74 Regular SignUp With Basic Information Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.delete_Custom_Field();
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxBasicInfoMandatory(); // Verify
																		// Checked
																		// Check
																		// box
																		// on
																		// Simplyfied
																		// with
																		// Signup
																		// basic
																		// info
																		// mandatory
		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBasicInfoMandatory(); // Regular Sign Up
		// with Basic Information
		// Mandatoryi
		driver.quit();

	}

	// ------------------------------------------------------------------------------------------------------------------------//
	// ------------------------------------------- Regualr Signup With
	// Billing Information Mandatory
	// All filled out
	// ------------------------------------------------------------------------------------------------------------------------//

	/**
	 * Verify Regular Sign up Billing Information
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Billing_Info_Mandatory(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.75 Regular SignUp With Billing Information Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.75 Regular SignUp With Billing Information Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.delete_Custom_Field();
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxBillingInfoMandatory(); // Verify
																		// Checked
																		// Check
																		// box
																		// on
																		// Simplyfied
																		// Signup
																		// with
																		// billing
																		// info
																		// mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End

		signupPage.regularSignUpWithBillingInfoMandatory();

		driver.quit();
	}

	/**
	 * Verify Regular Sign up CC is Mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_CC_Info_Mandatory(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.76 Regular SignUp With CC Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.76 Regular SignUp With CC Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.delete_Custom_Field();
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxCCInfoMandatory(); // Verify
																	// Checked
																	// Check
																	// box
																	// on
																	// Simplyfied
																	// Signup
																	// with
																	// CC
																	// info
																	// mandatory
		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); 
		
		signupPage.regularSignUpWithCCInfoMandatory(); // the billing info box
														// was displayed with
														// the following fields
		
		driver.quit();

	}

	/**
	 * Verify Regular Sign up ACH is checked
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_ACH_Info_Mandatory(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.77 Regular SignUp With ACH Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.77 Regular SignUp With ACH Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.delete_Custom_Field();
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxACHInfoMandatory(); // Verify
																	// Checked
																	// Check
																	// box
																	// on
																	// Simplyfied
																	// Signup
																	// with
																	// ACH
																	// info
																	// mandatory
		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithACHInfoMandatory(); // the billing info box
														// was displayed with
														// the following fields
		// - billing bank routing nb
		// - billing bank account nb
		// - billing bank account type
		// - billing bank name
		// - billing bank account name

		driver.quit();
	}

	/**
	 * Verify Regular Sign up basic info (mandatory) billing address info (not
	 * mandatory)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Mandatory_And_Billing_Address_Info_Not_Mandatory(String adminUserName,
			String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.78 Regular SignUp With * basic info mandatory and billing address info not mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.78 Regular SignUp With * basic info mandatory and billing address info not mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.delete_Custom_Field();
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxBasicInfoMandatoryAndBillingAddressInfoNotMandatory(); //
																										// Verify
																										// Checked
																										// Checkbox
																										// BasicInfo
																										// Mandatory
																										// And
																										// Billing
																										// Address
																										// Info
																										// Not
																										// Mandatory
		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBasicInfoMandatoryAndBillingAddressInfoNotMandatory(); // Basic
																							// Info
																							// Mandatory
																							// And
																							// Billing
																							// Address
																							// Info
																							// Not
																							// Mandatory
		driver.quit();

	}

	/**
	 * Verify Regular Sign up basic info ( Not mandatory) billing address info (
	 * mandatory)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Not_Mandatory_And_Billing_Address_Info_Mandatory(String adminUserName,
			String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.79 Regular SignUp With * basic info not mandatory and billing address info not mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.79 Regular SignUp With * basic info not mandatory and billing address info not mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.delete_Custom_Field();
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxBasicInfoNotMandatoryAndBillingAddressInfoMandatory();
		// Verify
		// Checked
		// Checkbox
		// BasicInfo
		// Mandatory
		// And
		// Billing
		// Address
		// Not
		// Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBasicInfoNotMandatoryAndBillingAddressInfoMandatory(); // Basic
																							// Info
																							// Mandatory
																							// And
																							// Billing
																							// Address
																							// Info
																							// Not
																							// Mandatory
		driver.quit();

	}

	/**
	 * Verify Regular Sign up basic info (mandatory) billing address info (
	 * mandatory)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Mandatory_And_Billing_Address_Info_Mandatory(String adminUserName,
			String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.80 Regular SignUp With * basic info mandatory and billing address info mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.80 Regular SignUp With * basic info mandatory and billing address info mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.delete_Custom_Field();
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxBasicInfoMandatoryAndBillingAddressInfoMandatory(); //
																									// Verify
																									// Checked
																									// Checkbox
																									// BasicInfo
																									// Mandatory
																									// And
																									// Billing
																									// Address
																									// Info
																									// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBasicInfoMandatoryAndBillingAddressInfoMandatory(); // Basic
																						// Info
																						// Mandatory
																						// And
																						// Billing
																						// Address
																						// Info
																						// Not
																						// Mandatory
		driver.quit();

	}

	/**
	 * Verify Regular Sign up basic info (mandatory) CC info ( Not Mandatory)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Mandatory_And_CC_Info_Not_Mandatory(String adminUserName,
			String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.81 Regular SignUp With * basic info mandatory and CC info not mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.81 Regular SignUp With * basic info mandatory and CC info not mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.delete_Custom_Field();
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxBasicInfoMandatoryAndCCInfoNotMandatory(); //
																							// Verify
																							// Checked
																							// Checkbox
																							// BasicInfo
																							// Mandatory
																							// And
																							// CC
																							// Info
																							// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBasicInfoMandatoryAndCCInfoNotMandatory(); // Basic
																				// Info
																				// Mandatory
																				// And
																				// CC
																				// Not
																				// Mandatory
		driver.quit();

	}

	/**
	 * Verify Regular Sign up basic info (Not mandatory) CC info ( Mandatory)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Not_Mandatory_And_CC_Info_Mandatory(String adminUserName,
			String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.82 Regular SignUp With * basic info Not mandatory and CC info mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.82 Regular SignUp With * basic info Not mandatory and CC info mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.delete_Custom_Field();
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxBasicInfoNotMandatoryAndCCInfoMandatory(); //
																							// Verify
																							// Checked
																							// Check
																							// box
																							// BasicInfo
																							// Not
																							// Mandatory
																							// And
																							// CC
																							// Info
																							// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBasicInfoNotMandatoryAndCCInfoMandatory(); // Basic
																				// Info
																				// Mandatory
																				// And
																				// CC
																				// Info
																				// Not
																				// Mandatory
		driver.quit();

	}

	/**
	 * Verify Regular Sign up basic info (mandatory) CC info ( Mandatory)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Mandatory_And_CC_Info_Mandatory(String adminUserName,
			String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.83 Regular SignUp With * basic info  mandatory and CC info mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.83 Regular SignUp With * basic info  mandatory and CC info mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.delete_Custom_Field();
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxBasicInfoMandatoryAndCCInfoMandatory(); //
																						// Verify
																						// Checked
																						// Check
																						// box
																						// BasicInfo
																						// Mandatory
																						// And
																						// CC
																						// Info
																						// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBasicInfoMandatoryAndCCInfoMandatory(); // Basic
																			// Info
																			// Mandatory
																			// And
																			// CC
																			// Info
																			// Mandatory
		driver.quit();

	}

	/**
	 * Verify Regular Sign up basic info (mandatory) ACH info ( Not Mandatory)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Mandatory_And_ACH_Info_Not_Mandatory(String adminUserName,
			String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.84 Regular SignUp With * basic info  mandatory and ACH info mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.84 Regular SignUp With * basic info  mandatory and ACH info mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.delete_Custom_Field();
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxBasicInfoMandatoryAndACHInfoNotMandatory();
		// Verify
		// Checked
		// Check box
		// BasicInfo
		// Mandatory
		// And
		// ACH
		// Info
		// Not
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBasicInfoMandatoryAndACHInfoNotMandatory(); // Basic
																				// Info
																				// Mandatory
																				// And
																				// ACH
																				// Info
																				// Not
																				// Mandatory
		driver.quit();

	}

	/**
	 * Verify Regular Sign up basic info (Not Mandatory) ACH info (Mandatory)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Not_Mandatory_And_ACH_Info_Mandatory(String adminUserName,
			String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.85 Regular SignUp With * basic info Not mandatory and ACH info Not mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.85 Regular SignUp With * basic info Not mandatory and ACH info Not mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.delete_Custom_Field();
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxBasicInfoNotMandatoryAndACHInfoMandatory();
		// Verify
		// Checked
		// Check box
		// BasicInfo
		// Not
		// Mandatory
		// And
		// ACH
		// Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBasicInfoNotMandatoryAndACHInfoMandatory();
		// // Basic
		// Info
		// Not
		// Mandatory
		// And
		// ACH
		// Info
		// Mandatory
		driver.quit();
	}

	/**
	 * Verify Regular Sign up basic info (Mandatory) ACH info (Mandatory)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Mandatory_And_ACH_Info_Mandatory(String adminUserName,
			String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.86 Regular SignUp With * basic info Not mandatory and ACH info Not mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.86 Regular SignUp With * basic info Not mandatory and ACH info Not mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.delete_Custom_Field();
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxBasicInfoMandatoryAndACHInfoMandatory();
		// Verify
		// Checked
		// Check box
		// BasicInfo
		// Mandatory
		// And
		// ACH
		// Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBasicInfoMandatoryAndACHInfoMandatory(); // Basic
																				// Info
																				// Mandatory
																				// And
																				// ACH
																				// Info
																				// Not
																				// Mandatory
		driver.quit();
	}

	/**
	 * Verify Regular Sign up billing info (Mandatory) CC info (Not Mandatory)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Billing_Info_Mandatory_And_CC_Info_Not_Mandatory(String adminUserName,
			String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.87 Regular SignUp With * billing info mandatory and CC info Not mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.87 Regular SignUp With * billing info mandatory and CC info Not mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxBillingInfoMandatoryAndCCInfoNotMandatory();
		// Verify
		// Checked
		// Check box
		// Billing Info
		// Mandatory
		// And
		// CC
		// Info Not
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBillingInfoMandatoryAndCCInfoNotMandatory(); // Billing
																					// Info
																					// Mandatory
																					// And
																					// CC
																					// Info
																					// Not
																					// Mandatory
		driver.quit();
	}

	/**
	 * Verify Regular Sign up billing info (Not Mandatory) CC info (Mandatory)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Billing_Info_Not_Mandatory_And_CC_Info_Mandatory(String adminUserName,
			String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.88 Regular SignUp With * billing info Not mandatory and CC info mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.88 Regular SignUp With * billing info Not mandatory and CC info mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxBillingInfoNotMandatoryAndCCInfoMandatory();
		// Verify
		// Checked
		// Check box
		// Billing Info Not
		// Mandatory
		// And
		// CC
		// Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBillingInfoNotMandatoryAndCCInfoMandatory(); // Billing
																					// Info
																					// Not
																					// Mandatory
																					// And
																					// CC
																					// Info
																					// Mandatory
		driver.quit();
	}

	/**
	 * Verify Regular Sign up billing info (Mandatory) CC info (Mandatory)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Billing_Info_Mandatory_And_CC_Info_Mandatory(String adminUserName,
			String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.89 Regular SignUp With * billing info mandatory and CC info mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.89 Regular SignUp With * billing info mandatory and CC info mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxBillingInfoMandatoryAndCCInfoMandatory();
		// Verify
		// Checked
		// Check box
		// Billing Info
		// Mandatory
		// And
		// CC
		// Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignupWithBillingInfoAndCCInfoMandatory(); // Billing
																		// Info
																		// Mandatory
																		// And
																		// CC
																		// Info
																		// Mandatory
		driver.quit();
	}

	/**
	 * Verify Regular Sign up billing info (Mandatory) ACH info (Not Mandatory)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Billing_Info_Mandatory_And_ACH_Info_Not_Mandatory(String adminUserName,
			String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.90 Regular SignUp With * billing info mandatory and ACH info Not mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.90 Regular SignUp With * billing info mandatory and ACH info Not mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxBillingInfoMandatoryAndACHInfoNotMandatory();
		// Verify
		// Checked
		// Check box
		// Billing Info
		// Mandatory
		// And
		// ACH
		// Info Not
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBillingInfoMandatoryAndACHInfoNotMandatory(); // Billing
																					// Info
																					// Mandatory
																					// And
																					// ACH
																					// Info
																					// Not
																					// Mandatory
		driver.quit();
	}

	/**
	 * Verify Regular Sign up billing info (Not Mandatory) ACH info (Mandatory)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Billing_Info_Not_Mandatory_And_ACH_Info_Mandatory(String adminUserName,
			String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.91 Regular SignUp With * billing info Not mandatory and ACH info mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.91 Regular SignUp With * billing info Not mandatory and ACH info mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxBillingInfoNotMandatoryAndACHInfoMandatory();
		// Verify
		// Checked
		// Check box
		// Billing Info
		// Not Mandatory
		// And
		// ACH
		// Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBillingInfoNotMandatoryAndACHInfoMandatory(); // Billing
																					// Info
																					// Not
																					// Mandatory
																					// And
																					// ACH
																					// Info
																					// Mandatory
		driver.quit();
	}

	/**
	 * Verify Regular Sign up billing info (Mandatory) ACH info (Mandatory)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Billing_Info_Mandatory_And_ACH_Info_Mandatory(String adminUserName,
			String adminPassword) throws InterruptedException, AWTException, ParseException {
		log(">Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.92 Regular SignUp With * billing info mandatory and ACH info mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(">Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.92 Regular SignUp With * billing info mandatory and ACH info mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxBillingInfoMandatoryAndACHInfoMandatory();
		// Verify
		// Checked
		// Check box
		// Billing Info
		// Mandatory
		// And
		// ACH
		// Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBillingInfoMandatoryAndACHInfoMandatory(); // Billing
																				// Info
																				// Mandatory
																				// And
																				// ACH
																				// Info
																				// Mandatory
		driver.quit();
	}

	/**
	 * Verify Regular Sign up CC info (Mandatory) ACH info (Not Mandatory)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_CC_Info_Mandatory_And_ACH_Info_Not_Mandatory(String adminUserName,
			String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.93 Regular SignUp With * CC info mandatory and ACH info Not mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.93 Regular SignUp With * CC info mandatory and ACH info Not mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		
		adminDashboardPage.verifyCheckedCheckboxCCInfoNotMandatoryAndACHInfoNotMandatory();
		// Verify
		// Checked
		// Check box
		// CC Info
		// Mandatory
		// And
		// ACH
		// Info Not
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithCCInfoMandatoryAndACHInfoNotMandatory(); // CC
																				// Info
																				// Mandatory
																				// And
																				// ACH
																				// Info
																				// Not
																				// Mandatory
		driver.quit();
	}

	/**
	 * Verify Regular Sign up CC info (Not Mandatory) ACH info (Mandatory)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_CC_Info_Not_Mandatory_And_ACH_Info_Mandatory(String adminUserName,
			String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.94 Regular SignUp With * CC info Not mandatory and ACH info mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.94 Regular SignUp With * CC info Not mandatory and ACH info mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxCCInfoNotMandatoryAndACHInfoMandatory();
		// Verify
		// Checked
		// Check box
		// CC Info
		// Not Mandatory
		// And
		// ACH
		// Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithCCInfoNotMandatoryAndACHInfoMandatory(); // CC
																				// Info
																				// Not
																				// Mandatory
																				// And
																				// ACH
																				// Info
																				// Mandatory
		driver.quit();
	}

	/**
	 * Verify Regular Sign up CC info (Mandatory) ACH info (Mandatory)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_CC_Info_Mandatory_And_ACH_Info_Mandatory(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.95 Regular SignUp With * CC info mandatory and ACH info mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.95 Regular SignUp With * CC info mandatory and ACH info mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxCCInfoMandatoryAndACHInfoMandatory();
		// Verify
		// Checked
		// Check box
		// CC Info
		// Mandatory
		// And
		// ACH
		// Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithCCInfoMandatoryAndACHInfoMandatory(); // CC
																			// Info
																			// Mandatory
																			// And
																			// ACH
																			// Info
																			// Mandatory
		driver.quit();
	}

	/**
	 * Verify Regular SignUp With Basic info Mandatory Billing address info not
	 * Mandatory CC info not mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Mandatory_Billing_Address_Info_Not_Mandatory_CC_Info_Not_Mandatory(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.96 Regular SignUp With Basic info Mandatory Billing address info not Mandatory CC info not mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.96 Regular SignUp With Basic info Mandatory Billing address info not Mandatory CC info not mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxBasicInfoMandatoryBillingAddressInfoNotMandatoryCCInfoNotMandatory();
		// Verify
		// Checked
		// Check box

		// Basic Info
		// Mandatory
		// And
		// CC
		// Info Not
		// Mandatory
		// Billing Info
		// Not Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBasicInfoMandatoryBillingAddressInfoNotMandatoryAndCCinfoNotMandatory();
		// Basic Info
		// Mandatory
		// And
		// CC
		// Info Not
		// Mandatory
		// Billing Info
		// Not Mandatory
		driver.quit();
	}

	/**
	 * Verify Regular SignUp With Basic info Not Mandatory Billing address info
	 * Mandatory CC info Not mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Not_Mandatory_Billing_Address_Info_Mandatory_CC_Info_Not_Mandatory(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.97 Regular SignUp With Basic info Not Mandatory Billing address info Mandatory CC info Not Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.97 Regular SignUp With Basic info Not Mandatory Billing address info Mandatory CC info Not Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
		// profile
		// page
		adminDashboardPage.VerifyCheckedCheckboxBasicInfoNotMandatoryBillingAddressInfoMandatoryCCInfoNotMandatory();
		// Verify
		// Checked
		// Check box
		// Basic Info
		// Not Mandatory
		// And
		// CC
		// Info Not
		// Mandatory
		// Billing Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.RegularSignUpWithBasicInfoNotMandatoryBillingAddressInfoMandatoryAndCCinfoNotMandatory();
		// Basic Info
		// Not Mandatory
		// And
		// CC
		// Info Not
		// Mandatory
		// Billing Info
		// Mandatory

		driver.quit();
	}

	/**
	 * Verify Regular SignUp With Basic info Not Mandatory Billing address info Not
	 * Mandatory CC info mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Not_Mandatory_Billing_Address_Info_Not_Mandatory_CC_Info_Mandatory(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.98 Regular SignUp With Basic info Not Mandatory Billing address info Not Mandatory CC info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.98 Regular SignUp With Basic info Not Mandatory Billing address info Not Mandatory CC info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxBasicInfoNotMandatoryBillingAddressInfoNotMandatoryCCInfoMandatory();
		// Verify
		// Checked
		// Check box
		// Basic Info
		// Not Mandatory
		// And
		// CC
		// Info
		// Mandatory
		// Billing Info
		// Not Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBasicInfoNotMandatoryBillingAddressInfoNotMandatoryAndCCinfoMandatory();
		// Basic Info
		// Not Mandatory
		// And
		// CC
		// Info
		// Mandatory
		// Billing Info
		// Not Mandatory

		driver.quit();
	}

	/**
	 * Verify Regular SignUp With Basic info Mandatory Billing address info
	 * Mandatory CC info Not mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Mandatory_Billing_Address_Info_Mandatory_CC_Info_Not_Mandatory(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.99 Regular SignUp With Basic info Mandatory Billing address info Mandatory CC info Not Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.99 Regular SignUp With Basic info Mandatory Billing address info Mandatory CC info Not Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxBasicInfoMandatoryBillingAddressInfoMandatoryCCInfoNotMandatory();
		// Verify
		// Checked
		// Check box
		// Basic Info
		// Mandatory
		// And
		// CC
		// Info
		// Mandatory
		// Billing Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBasicInfoMandatoryBillingAddressInfoMandatoryAndCCinfoNotMandatory();
		// Basic Info
		// Mandatory
		// And
		// CC
		// Info
		// Not Mandatory
		// Billing Info
		// Mandatory

		driver.quit();
	}

	/**
	 * Verify Regular SignUp With Basic info Mandatory Billing address info Not
	 * Mandatory CC info mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Mandatory_Billing_Address_Info_Not_Mandatory_CC_Info_Mandatory(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.100 Regular SignUp With Basic info Mandatory Billing address info NotMandatory CC info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.100 Regular SignUp With Basic info Mandatory Billing address info NotMandatory CC info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxBasicInfoMandatoryBillingAddressInfoNotMandatoryCCInfoMandatory();
		// Verify
		// Checked
		// Check box
		// Basic Info
		// Not Mandatory
		// And
		// CC
		// Info
		// Mandatory
		// Billing Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBasicInfoMandatoryBillingAddressInfoNotMandatoryAndCCinfoMandatory();
		// Basic Info
		// Mandatory
		// And
		// CC
		// Info
		// Mandatory
		// Billing Info
		// Not Mandatory

		driver.quit();
	}

	/**
	 * Verify Regular SignUp With Basic info Not Mandatory Billing address info
	 * Mandatory CC info mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Not_Mandatory_Billing_Address_Info_Mandatory_CC_Info_Mandatory(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.101 Regular SignUp With Basic info Not Mandatory Billing address info Mandatory CC info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.101 Regular SignUp With Basic info Not Mandatory Billing address info Mandatory CC info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxBasicInfoNotMandatoryBillingAddressInfoMandatoryCCInfoMandatory();
		// Verify
		// Checked
		// Check box
		// Basic Info
		// Not Mandatory
		// And
		// CC
		// Info
		// Mandatory
		// Billing Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBasicInfoNotMandatoryBillingAddressInfoMandatoryAndCCinfoMandatory();
		// Basic Info
		// Mandatory
		// And
		// CC
		// Info
		// Mandatory
		// Billing Info
		// Not Mandatory

		driver.quit();

	}

	/**
	 * Verify Regular SignUp With Basic info Not Mandatory Billing address info
	 * Mandatory CC info mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Mandatory_Billing_Address_Info_Mandatory_CC_Info_Mandatory(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.102 Regular SignUp With Basic info Mandatory Billing address info Mandatory CC info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.102 Regular SignUp With Basic info Mandatory Billing address info Mandatory CC info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxBasicInfoMandatoryBillingAddressInfoMandatoryCCInfoMandatory();
		// Verify
		// Checked
		// Check box
		// Basic Info
		// Not Mandatory
		// And
		// CC
		// Info
		// Mandatory
		// Billing Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBasicInfoMandatoryBillingAddressInfoMandatoryAndCCinfoMandatory();
		// Basic Info
		// Mandatory
		// And
		// CC
		// Info
		// Mandatory
		// Billing Info
		// Not Mandatory

		driver.quit();

	}

	/**
	 * Verify Regular SignUp With Basic info Mandatory Billing address info Not
	 * Mandatory ACH info Not mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Mandatory_Billing_Address_Info_Not_Mandatory_ACH_Info_Not_Mandatory(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.103 Regular SignUp With Basic info Mandatory Billing address info Not Mandatory ACH info Not Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.103 Regular SignUp With Basic info Mandatory Billing address info Not Mandatory ACH info Not Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxBasicInfoMandatoryBillingAddressInfoNotMandatoryACHInfoNotMandatory();
		// Verify
		// Checked
		// Check box
		// Basic Info
		// Mandatory
		// And
		// ACH
		// Info
		// Not Mandatory
		// Billing Info
		// Not Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBasicInfoMandatoryBillingAddressInfoNotMandatoryAndACHinfoNotMandatory();
		// Basic Info
		// Mandatory
		// And
		// ACH
		// Info
		// Not Mandatory
		// Billing Info
		// Not Mandatory

		driver.quit();

	}

	/**
	 * Verify Regular SignUp With Basic info Not Mandatory Billing address info Not
	 * Mandatory ACH info mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Not_Mandatory_Billing_Address_Info_Not_Mandatory_ACH_Info_Not_Mandatory(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.105 Regular SignUp With Basic info Not Mandatory Billing address info Not Mandatory ACH info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.105 Regular SignUp With Basic info Not Mandatory Billing address info Not Mandatory ACH info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
		// profile
		// page
		adminDashboardPage
				.VerifyCheckedCheckboxBasicInfoNotMandatoryBillingAddressInfoNotMandatoryACHInfoNotMandatory();
		// Verify
		// Checked
		// Check box
		// Basic Info
		// Not Mandatory
		// And
		// ACH
		// InfoRegular_Signup_With_Basic_Info_Not_Mandatory_Billing_Address_Info_Mandatory_ACH_Info_Not_Mandatory
		// Mandatory
		// Billing Info
		// Not Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.RegularSignUpWithBasicInfoNotMandatoryBillingAddressInfoNotMandatoryAndACHinfoNotMandatory();
		// Basic Info
		// Mandatory
		// And
		// ACH
		// Info
		// Not Mandatory
		// Billing Info
		// Not Mandatory

		driver.quit();

	}

	/**
	 * Verify Regular SignUp With Basic info Not Mandatory Billing address info
	 * Mandatory ACH info Not mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Not_Mandatory_Billing_Address_Info_Mandatory_ACH_Info_Not_Mandatory(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.104 Regular SignUp With Basic info Not Mandatory Billing address info Mandatory ACH info Not Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.104 Regular SignUp With Basic info Not Mandatory Billing address info Mandatory ACH info Not Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
		// profile
		// page
		adminDashboardPage.VerifyCheckedCheckboxBasicInfoNotMandatoryBillingAddressInfoMandatoryACHInfoNotMandatory();
		// Verify
		// Checked
		// Check box
		// Basic Info
		// Not Mandatory
		// And
		// ACH
		// Info
		// Not Mandatory
		// Billing Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.RegularSignUpWithBasicInfoNotMandatoryBillingAddressInfoMandatoryAndACHinfoNotMandatory();
		// Basic Info
		// Not Mandatory
		// And
		// ACH
		// Info
		// Not Mandatory
		// Billing Info
		// Mandatory

		driver.quit();

	}

	/**
	 * Verify Regular SignUp With Basic info Mandatory Billing address info
	 * Mandatory ACH info Not mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Mandatory_Billing_Address_Info_Mandatory_ACH_Info_Not_Mandatory(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.106 Regular SignUp With Basic info Mandatory Billing address info Mandatory ACH info Not Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.106 Regular SignUp With Basic info Mandatory Billing address info Mandatory ACH info Not Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxBasicInfoMandatoryBillingAddressInfoMandatoryACHInfoNotMandatory();
		// Verify
		// Checked
		// Check box
		// Basic Info
		// Mandatory
		// And
		// ACH
		// Info
		// Mandatory
		// Billing Info
		// Not Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBasicInfoMandatoryBillingAddressInfoMandatoryAndACHinfoNotMandatory();
		// Basic Info
		// Mandatory
		// And
		// ACH
		// Info
		// Mandatory
		// Billing Info
		// Not Mandatory

		driver.quit();

	}

	/**
	 * Verify Regular SignUp With Basic info Mandatory Billing address info Not
	 * Mandatory ACH info mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Mandatory_Billing_Address_Info_Not_Mandatory_ACH_Info_Mandatory(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.107 Regular SignUp With Basic info Mandatory Billing address info Not Mandatory ACH info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.107 Regular SignUp With Basic info Mandatory Billing address info Not Mandatory ACH info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxBasicInfoMandatoryBillingAddressInfoNotMandatoryACHInfoMandatory();
		// Verify
		// Checked
		// Check box
		// Basic Info
		// Mandatory
		// And
		// ACH
		// Info
		// Not Mandatory
		// Billing Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBasicInfoMandatoryBillingAddressInfoNotMandatoryAndACHinfoMandatory();
		// Basic Info
		// Mandatory
		// And
		// ACH
		// Info
		// Not Mandatory
		// Billing Info
		// Mandatory

		driver.quit();

	}

	/**
	 * Verify Regular SignUp With Basic info Not Mandatory Billing address info
	 * Mandatory ACH info mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Not_Mandatory_Billing_Address_Info_Mandatory_ACH_Info_Mandatory(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.108 Regular SignUp With Basic info Not Mandatory Billing address info Mandatory ACH info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.108 Regular SignUp With Basic info Not Mandatory Billing address info Mandatory ACH info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxBasicInfoNotMandatoryBillingAddressInfoMandatoryACHInfoMandatory();
		// Verify
		// Checked
		// Check box
		// Basic Info
		// Not Mandatory
		// And
		// ACH
		// Info
		// Mandatory
		// Billing Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBasicInfoNotMandatoryBillingAddressInfoMandatoryAndACHinfoMandatory();
		// Basic Info
		// Not Mandatory
		// And
		// ACH
		// Info
		// Mandatory
		// Billing Info
		// Mandatory

		driver.quit();

	}

	/**
	 * Verify Regular SignUp With Basic info Mandatory Billing address info
	 * Mandatory ACH info mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Mandatory_Billing_Address_Info_Mandatory_ACH_Info_Mandatory(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.109 Regular SignUp With Basic info Mandatory Billing address info Mandatory ACH info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.109 Regular SignUp With Basic info Mandatory Billing address info Mandatory ACH info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxBasicInfoMandatoryBillingAddressInfoMandatoryACHInfoMandatory();
		// Verify
		// Checked
		// Check box
		// Basic Info
		// Mandatory
		// And
		// ACH
		// Info
		// Mandatory
		// Billing Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBasicInfoMandatoryBillingAddressInfoMandatoryAndACHinfoMandatory();
		// Basic Info
		// Mandatory
		// And
		// ACH
		// Info
		// Mandatory
		// Billing Info
		// Mandatory

		driver.quit();

	}

	/**
	 * Verify Regular SignUp With Basic info Mandatory CC info Not Mandatory ACH
	 * info Not Mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Mandatory_CC_Info_Not_Mandatory_ACH_Info_Not_Mandatory(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.110 Regular SignUp With Basic info Mandatory CC info Mandatory ACH info Not Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.110 Regular SignUp With Basic info Mandatory CC info Mandatory ACH info Not Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
		// profile
		// page
		adminDashboardPage.verifyCheckedCheckboxBasicInfoMandatoryCCInfoNotMandatoryACHInfoNotMandatory();
		// Verify
		// Checked
		// Check box
		// Basic Info
		// Mandatory
		// And
		// ACH
		// Info
		// Mandatory
		// Billing Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.Regular_SignUp_With_Basic_Info_Mandatory_CCInfo_Not_Mandatory_And_ACHinfo_Not_Mandatory();
		// Basic Info
		// Mandatory
		// And
		// ACH
		// Info
		// Mandatory
		// Billing Info
		// Mandatory

		driver.quit();

	}

	/**
	 * Verify Regular SignUp With Basic info Not Mandatory CC info Mandatory ACH
	 * info Not Mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Not_Mandatory_CC_Info_Mandatory_ACH_Info_Not_Mandatory(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.111 Regular SignUp With Basic info Not Mandatory CC info Mandatory ACH info Not Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.111 Regular SignUp With Basic info Not Mandatory CC info Mandatory ACH info Not Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxBasicInfoNotMandatoryCCInfoMandatoryACHInfoNotMandatory();
		// Verify
		// Checked
		// Check box
		// Basic Info
		// Not Mandatory
		// And
		// ACH
		// Info
		// Not Mandatory
		// CC Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBasicInfoNotMandatoryCCInfoMandatoryAndACHinfoNotMandatory();
		// Basic Info
		// Not Mandatory
		// And
		// ACH
		// Info
		// Not Mandatory
		// CCInfo
		// Mandatory

		driver.quit();

	}

	/**
	 * Verify Regular SignUp With Basic info Not Mandatory CC info Not Mandatory ACH
	 * info Mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Not_Mandatory_CC_Info_Not_Mandatory_ACH_Info_Mandatory(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.112 Regular SignUp With Basic info Not Mandatory CC info Not Mandatory ACH info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.112 Regular SignUp With Basic info Not Mandatory CC info Not Mandatory ACH info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxBasicInfoNotMandatoryCCInfoNotMandatoryACHInfoMandatory();
		// Verify
		// Checked
		// Check box
		// Basic Info
		// Not Mandatory
		// And
		// ACH
		// Info
		// Not Mandatory
		// CC Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBasicInfoNotMandatoryCCInfoNotMandatoryAndACHinfoMandatory();
		// Basic Info
		// Not Mandatory
		// And
		// ACH
		// Info
		// Not Mandatory
		// CCInfo
		// Mandatory

		driver.quit();

	}

	/**
	 * Verify Regular SignUp With Basic info Not Mandatory CC info Not Mandatory ACH
	 * info Mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Mandatory_CC_Info_Mandatory_ACH_Info_Not_Mandatory(String adminUserName,
			String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.113 Regular SignUp With Basic info Mandatory CC info Mandatory ACH info Not Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.113 Regular SignUp With Basic info Mandatory CC info Mandatory ACH info Not Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxBasicInfoMandatoryCCInfoMandatoryACHInfoNotMandatory();
		// Verify
		// Checked
		// Check box
		// Basic Info
		// Mandatory
		// And
		// ACH
		// Info
		// Not Mandatory
		// CC Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBasicInfoMandatoryCCInfoMandatoryAndACHinfoNotMandatory();
		// Basic Info
		// Mandatory
		// And
		// ACH
		// Info
		// Not Mandatory
		// CCInfo
		// Mandatory

		driver.quit();

	}

	/**
	 * Verify Regular SignUp With Basic info Mandatory CC info Not Mandatory ACH
	 * info Mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Mandatory_CC_Info_Not_Mandatory_ACH_Info_Mandatory(String adminUserName,
			String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.114 Regular SignUp With Basic info Mandatory CC info Not Mandatory ACH info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.114 Regular SignUp With Basic info Mandatory CC info Not Mandatory ACH info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxBasicInfoMandatoryCCInfoNotMandatoryACHInfoMandatory();
		// Verify
		// Checked
		// Check box
		// Basic Info
		// Mandatory
		// And
		// ACH
		// Info
		// Not Mandatory
		// CC Info
		// Not Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBasicInfoMandatoryCCInfoNotMandatoryAndACHinfoMandatory();
		// Basic Info
		// Mandatory
		// And
		// ACH
		// Info
		// Not Mandatory
		// CCInfo
		// Not Mandatory

		driver.quit();

	}

	/**
	 * Verify Regular SignUp With Basic info Not Mandatory CC info Mandatory ACH
	 * info Not Mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Not_Mandatory_CC_Info_Mandatory_ACH_Info_Mandatory(String adminUserName,
			String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.115 Regular SignUp With Basic info Not Mandatory CC info Mandatory ACH info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.115 Regular SignUp With Basic info Not Mandatory CC info Mandatory ACH info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxBasicInfoNotMandatoryCCInfoMandatoryACHInfoMandatory();
		// Verify
		// Checked
		// Check box
		// Basic Info
		// Not Mandatory
		// And
		// ACH
		// Info
		// Not Mandatory
		// CC Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBasicInfoNotMandatoryCCInfoMandatoryAndACHinfoMandatory();
		// Basic Info
		// Mandatory
		// And
		// ACH
		// Info
		// Not Mandatory
		// CCInfo
		// Not Mandatory

		driver.quit();

	}

	/**
	 * Verify Regular SignUp With Basic info Mandatory CC info Mandatory ACH info
	 * Mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Mandatory_CC_Info_Mandatory_ACH_Info_Mandatory(String adminUserName,
			String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.116 Regular SignUp With Basic info Mandatory CC info Mandatory ACH info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.116 Regular SignUp With Basic info Mandatory CC info Mandatory ACH info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxBasicInfoMandatoryCCInfoMandatoryACHInfoMandatory();
		// Verify
		// Checked
		// Check box
		// Basic Info
		// Mandatory
		// And
		// ACH
		// Info
		// Not Mandatory
		// CC Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBasicInfoMandatoryCCInfoMandatoryAndACHinfoMandatory();
		// Basic Info
		// Mandatory
		// And
		// ACH
		// Info
		// Mandatory
		// CC Info
		// Not Mandatory

		driver.quit();

	}

	/**
	 * Verify Regular SignUp With Billing info Mandatory CC info Not Mandatory ACH
	 * Not info Mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Billing_Info_Mandatory_CC_Info_Not_Mandatory_ACH_Info_Not_Mandatory(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.117 Regular SignUp With Billing info Mandatory CC info Not Mandatory ACH info Not Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.117 Regular SignUp With Billing info Mandatory CC info Not Mandatory ACH info Not Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxBillingInfoMandatoryCCInfoNotMandatoryACHInfoNotMandatory();
		// Verify
		// Checked
		// Check box
		// Basic Info
		// Mandatory
		// And
		// ACH
		// Info
		// Not Mandatory
		// CC Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBillingInfoMandatoryCCInfoNotMandatoryAndACHinfoNotMandatory();
		// Basic Info
		// Mandatory
		// And
		// ACH
		// Info
		// Mandatory
		// CC Info
		// Not Mandatory

		driver.quit();

	}

	/**
	 * Verify Regular SignUp With Billing info Not Mandatory CC info Mandatory ACH
	 * Not info Mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Billing_Info_Not_Mandatory_CC_Info_Mandatory_ACH_Info_Not_Mandatory(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.118 Regular SignUp With Billing info Not Mandatory CC info Mandatory ACH info Not Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.118 Regular SignUp With Billing info Not Mandatory CC info Mandatory ACH info Not Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxBillingInfoNotMandatoryCCInfoMandatoryACHInfoNotMandatory();
		// Verify
		// Checked
		// Check box
		// Billing Info
		// Not Mandatory
		// And
		// ACH
		// Info
		// Not Mandatory
		// CC Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBillingInfoNotMandatoryCCInfoMandatoryAndACHinfoNotMandatory();
		// Billing Info
		// Not Mandatory
		// And
		// ACH
		// Info
		// Not Mandatory
		// CC Info
		// Mandatory

		driver.quit();

	}

	/**
	 * Verify Regular SignUp With Billing info Not Mandatory CC info Not Mandatory
	 * ACH info Mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Billing_Info_Not_Mandatory_CC_Info_Not_Mandatory_ACH_Info_Mandatory(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.119 Regular SignUp With Billing info Not Mandatory CC info Not Mandatory ACH info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.119 Regular SignUp With Billing info Not Mandatory CC info Not Mandatory ACH info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxBillingInfoNotMandatoryCCInfoNotMandatoryACHInfoMandatory();
		// Verify
		// Checked
		// Check box
		// Billing Info
		// Not Mandatory
		// And
		// ACH
		// Info
		// Mandatory
		// CC Info
		// Not Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBillingInfoNotMandatoryCCInfoNotMandatoryAndACHinfoMandatory();
		// Billing Info
		// Not Mandatory
		// And
		// ACH
		// Info
		// Mandatory
		// CC Info
		// Not Mandatory

		driver.quit();

	}

	/**
	 * Verify Regular SignUp With Billing info Mandatory CC info Mandatory ACH Not
	 * info Mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Billing_Info_Mandatory_CC_Info_Mandatory_ACH_Info_Not_Mandatory(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.120 Regular SignUp With Billing info Mandatory CC info Mandatory ACH info Not Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.120 Regular SignUp With Billing info Mandatory CC info Mandatory ACH info Not Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxBillingInfoMandatoryCCInfoMandatoryACHInfoNotMandatory();
		// Verify
		// Checked
		// Check box
		// Billing Info
		// Mandatory
		// And
		// ACH
		// Info
		// Not Mandatory
		// CC Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBillingInfoMandatoryCCInfoMandatoryAndACHinfoNotMandatory();
		// Billing Info
		// Not Mandatory
		// And
		// ACH
		// Info
		// Mandatory
		// CC Info
		// Not Mandatory

		driver.quit();

	}

	/**
	 * Verify Regular SignUp With Billing info Mandatory CC info Not Mandatory ACH
	 * info Mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Billing_Info_Mandatory_CC_Info_Not_Mandatory_ACH_Info_Mandatory(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.121 Regular SignUp With Billing info Mandatory CC info Not Mandatory ACH info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.121 Regular SignUp With Billing info Mandatory CC info Not Mandatory ACH info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxBillingInfoMandatoryCCInfoNotMandatoryACHInfoMandatory();
		// Verify
		// Checked
		// Check box
		// Billing Info
		// Mandatory
		// And
		// ACH
		// Info
		// Mandatory
		// CC Info
		// Not Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBillingInfoMandatoryCCInfoNotMandatoryAndACHinfoMandatory();
		// Billing Info
		// Mandatory
		// And
		// ACH
		// Info
		// Mandatory
		// CC Info
		// Not Mandatory

		driver.quit();

	}

	/**
	 * Verify Regular SignUp With Billing info Not Mandatory CC info Mandatory ACH
	 * info Mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Billing_Info_Not_Mandatory_CC_Info_Mandatory_ACH_Info_Mandatory(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.122 Regular SignUp With Billing info Not Mandatory CC info Mandatory ACH info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.122 Regular SignUp With Billing info Not Mandatory CC info Mandatory ACH info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxBillingInfoNotMandatoryCCInfoMandatoryACHInfoMandatory();
		// Verify
		// Checked
		// Check box
		// Billing Info
		// Not Mandatory
		// And
		// ACH
		// Info
		// Mandatory
		// CC Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBillingInfoNotMandatoryCCInfoMandatoryAndACHinfoMandatory();
		// Billing Info
		// Mandatory
		// Not And
		// ACH
		// Info
		// Mandatory
		// CC Info
		// Mandatory

		driver.quit();

	}

	/**
	 * Verify Regular SignUp With Billing info Mandatory CC info Mandatory ACH info
	 * Mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Billing_Info_Mandatory_CC_Info_Mandatory_ACH_Info_Mandatory(String adminUserName,
			String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.123 Regular SignUp With Billing info Mandatory CC info Mandatory ACH info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.123 Regular SignUp With Billing info Mandatory CC info Mandatory ACH info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxBillingInfoMandatoryCCInfoMandatoryACHInfoMandatory();
		// Verify
		// Checked
		// Check box
		// Billing Info
		// Mandatory
		// And
		// ACH
		// Info
		// Mandatory
		// CC Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBillingInfoMandatoryCCInfoMandatoryAndACHinfoMandatory();
		// Billing Info
		// Mandatory
		// And
		// ACH
		// Info
		// Mandatory
		// CC Info
		// Mandatory

		driver.quit();

	}

	/**
	 * Verify Regular SignUp With Basic Info Mandatory Billing info Not Mandatory CC
	 * info Not Mandatory ACH info Not Mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Mandatory_Billing_Info_Not_Mandatory_CC_Info_Not_Mandatory_ACH_Info_Not_Mandatory(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.124 Regular SignUp With Basic Info Mandatory Billing info Not Mandatory CC info Not Mandatory ACH info Not Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.124 Regular SignUp With Basic Info Mandatory Billing info Not Mandatory CC info Not Mandatory ACH info Not Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.delete_Custom_Field();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
		// profile
		// page
		adminDashboardPage
				.verifyCheckedCheckboxBasicInfoMandatoryBillingInfoNotMandatoryCCInfoNotMandatoryACHInfoNotMandatory();
		// Verify
		// Checked
		// Check box
		// Billing Info
		// Not Mandatory
		// And
		// ACH
		// Info
		// Not Mandatory
		// CC Info
		// Not Mandatory
		// Basic Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBasicInfoMandatoryBillingInfoNotMandatoryCCInfoNotMandatoryAndACHinfoNotMandatory();
		// Billing Info
		// Not Mandatory
		// And
		// ACH
		// Info
		// Not Mandatory
		// CC Info
		// Not Mandatory
		// Basic Info
		// Mandatory

		driver.quit();

	}

	/**
	 * Verify Regular SignUp With Basic Info Not Mandatory Billing info Mandatory CC
	 * info Not Mandatory ACH info Not Mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Not_Mandatory_Billing_Info_Mandatory_CC_Info_Not_Mandatory_ACH_Info_Not_Mandatory(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.125 Regular SignUp With Basic Info Not Mandatory Billing info Mandatory CC info Not Mandatory ACH info Not Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.125 Regular SignUp With Basic Info Not Mandatory Billing info Mandatory CC info Not Mandatory ACH info Not Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
		// profile
		// page
		adminDashboardPage
				.VerifyCheckedCheckboxBasicInfoNotMandatoryBillingInfoMandatoryCCInfoNotMandatoryACHInfoNotMandatory();
		// Verify
		// Checked
		// Check box
		// Billing Info
		// Mandatory
		// And
		// ACH
		// Info
		// Not Mandatory
		// CC Info
		// Not Mandatory
		// Basic Info
		// Not Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.RegularSignUpWithBasicInfoNotMandatoryBillingInfoMandatoryCCInfoNotMandatoryAndACHinfoNotMandatory();
		// Billing Info
		// Mandatory
		// And
		// ACH
		// Info
		// Not Mandatory
		// CC Info
		// Not Mandatory
		// Basic Info
		// Not Mandatory

		driver.quit();

	}

	/**
	 * Verify Regular SignUp With Basic Info Mandatory Billing info Mandatory CC
	 * info Mandatory ACH info Mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Mandatory_Billing_Info_Mandatory_CC_Info_Mandatory_ACH_Info_Mandatory(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.138 Regular SignUp With Basic Info Mandatory Billing info Mandatory CC info Mandatory ACH info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.138 Regular SignUp With Basic Info Mandatory Billing info Mandatory CC info Mandatory ACH info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
		// profile
		// page
		adminDashboardPage.VerifyCheckedCheckboxBasicInfoMandatoryBillingInfoMandatoryCCInfoMandatoryACHInfoMandatory();
		// Verify
		// Checked
		// Check box
		// Billing Info
		// Mandatory
		// And
		// ACH
		// Info
		// Mandatory
		// CC Info
		// Not Mandatory
		// Basic Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.RegularSignUpWithBasicInfoMandatoryBillingInfoMandatoryCCInfoMandatoryAndACHinfoMandatory();
		// Billing Info
		// Mandatory
		// And
		// ACH
		// Info
		// Mandatory
		// CC Info
		// Not Mandatory
		// Basic Info
		// Mandatory

		driver.quit();

	}

	/**
	 * Verify Regular SignUp With Basic Info Not Mandatory Billing info Not
	 * Mandatory CC info Mandatory ACH info Not Mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Not_Mandatory_Billing_Info_Not_Mandatory_CC_Info_Mandatory_ACH_Info_Not_Mandatory(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.126 Regular SignUp With Basic Info Not Mandatory Billing info Not Mandatory CC info Mandatory ACH info Not Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.126 Regular SignUp With Basic Info Not Mandatory Billing info Not Mandatory CC info Mandatory ACH info Not Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage
				.verifyCheckedCheckboxBasicInfoNotMandatoryBillingInfoNotMandatoryCCInfoMandatoryACHInfoNotMandatory();
		// Verify
		// Checked
		// Check box
		// Billing Info
		// Not Mandatory
		// And
		// ACH
		// Info
		// Not Mandatory
		// CC Info
		// Mandatory
		// Basic Info
		// Not Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBasicInfoNotMandatoryBillingInfoNotMandatoryCCInfoMandatoryAndACHinfoNotMandatory();
		// Billing Info
		// Not Mandatory
		// And
		// ACH
		// Info
		// Not Mandatory
		// CC Info
		// Mandatory
		// Basic Info
		// Not Mandatory

		driver.quit();

	}

	/**
	 * Verify Regular SignUp With Basic Info Not Mandatory Billing info Not
	 * Mandatory CC info Not Mandatory ACH info Mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Not_Mandatory_Billing_Info_Not_Mandatory_CC_Info_Not_Mandatory_ACH_Info_Mandatory(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.127 Regular SignUp With Basic Info Not Mandatory Billing info Not Mandatory CC info Not Mandatory ACH info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.127 Regular SignUp With Basic Info Not Mandatory Billing info Not Mandatory CC info Not Mandatory ACH info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage
				.verifyCheckedCheckboxBasicInfoNotMandatoryBillingInfoNotMandatoryCCInfoNotMandatoryACHInfoMandatory();
		// Verify
		// Checked
		// Check box
		// Billing Info
		// Not Mandatory
		// And
		// ACH
		// Info
		// Not Mandatory
		// CC Info
		// Mandatory
		// Basic Info
		// Not Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBasicInfoNotMandatoryBillingInfoNotMandatoryCCInfoNotMandatoryAndACHinfoMandatory();
		// Billing Info
		// Not Mandatory
		// And
		// ACH
		// Info
		// Mandatory
		// CC Info
		// Not Mandatory
		// Basic Info
		// Not Mandatory

		driver.quit();

	}

	/**
	 * Verify Regular SignUp With Basic Info Mandatory Billing info Mandatory CC
	 * info Not Mandatory ACH info Not Mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Mandatory_Billing_Info_Mandatory_CC_Info_Not_Mandatory_ACH_Info_Not_Mandatory(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.128 Regular SignUp With Basic Info Mandatory Billing info Mandatory CC info Not Mandatory ACH info Not Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.128 Regular SignUp With Basic Info Mandatory Billing info Mandatory CC info Not Mandatory ACH info Not Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage
				.verifyCheckedCheckboxBasicInfoMandatoryBillingInfoMandatoryCCInfoNotMandatoryACHInfoNotMandatory();
		// Verify
		// Checked
		// Check box
		// Billing Info
		// Mandatory
		// And
		// ACH
		// Info
		// Not Mandatory
		// CC Info
		// Not Mandatory
		// Basic Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBasicInfoMandatoryBillingInfoMandatoryCCInfoNotMandatoryAndACHinfoNotMandatory();
		// Billing Info
		// Mandatory
		// And
		// ACH
		// Info
		// Not Mandatory
		// CC Info
		// Not Mandatory
		// Basic Info
		// Mandatory

		driver.quit();

	}

	/**
	 * Verify Regular SignUp With Basic Info Mandatory Billing info Not Mandatory CC
	 * info Mandatory ACH info Not Mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Mandatory_Billing_Info_Not_Mandatory_CC_Info_Mandatory_ACH_Info_Not_Mandatory(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.129 Regular SignUp With Basic Info Mandatory Billing info Not Mandatory CC info Mandatory ACH info Not Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.129 Regular SignUp With Basic Info Mandatory Billing info Not Mandatory CC info Mandatory ACH info Not Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
		// profile
		// page
		adminDashboardPage
				.VerifyCheckedCheckboxBasicInfoMandatoryBillingInfoNotMandatoryCCInfoMandatoryACHInfoNotMandatory();
		// Verify
		// Checked
		// Check box
		// Billing Info
		// Not Mandatory
		// And
		// ACH
		// Info`
		// Not Mandatory
		// CC Info
		// Mandatory
		// Basic Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBasicInfoMandatoryBillingInfoNotMandatoryCCInfoMandatoryAndACHinfoNotMandatory();
		// Billing Info
		// Not Mandatory
		// And
		// ACH
		// Info
		// Not Mandatory
		// CC Info
		// Mandatory
		// Basic Info
		// Mandatory

		driver.quit();

	}

	/**
	 * Verify Regular SignUp With Basic Info Mandatory Billing info Not Mandatory CC
	 * info Not Mandatory ACH info Mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Mandatory_Billing_Info_Not_Mandatory_CC_Info_Not_Mandatory_ACH_Info_Mandatory(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.130 Regular SignUp With Basic Info Mandatory Billing info Not Mandatory CC info Not Mandatory ACH info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.130 Regular SignUp With Basic Info Mandatory Billing info Not Mandatory CC info Not Mandatory ACH info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage
				.verifyCheckedCheckboxBasicInfoMandatoryBillingInfoNotMandatoryCCInfoNotMandatoryACHInfoMandatory();
		// Verify
		// Checked
		// Check box
		// Billing Info
		// Not Mandatory
		// And
		// ACH
		// Info
		// Mandatory
		// CC Info
		// Not Mandatory
		// Basic Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBasicInfoMandatoryBillingInfoNotMandatoryCCInfoNotMandatoryAndACHinfoMandatory();
		// Billing Info
		// Not Mandatory
		// And
		// ACH
		// Info
		// Mandatory
		// CC Info
		// Not Mandatory
		// Basic Info
		// Mandatory

		driver.quit();

	}

	/**
	 * Verify Regular SignUp With Basic Info Not Mandatory Billing info Mandatory CC
	 * info Mandatory ACH info Not Mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Not_Mandatory_Billing_Info_Mandatory_CC_Info_Mandatory_ACH_Info_Not_Mandatory(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.131 Regular SignUp With Basic Info Not Mandatory Billing info Mandatory CC info  Mandatory ACH info Not Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.131 Regular SignUp With Basic Info Not Mandatory Billing info Mandatory CC info  Mandatory ACH info Not Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage
				.VerifyCheckedCheckboxBasicInfoNotMandatoryBillingInfoMandatoryCCInfoMandatoryACHInfoNotMandatory();
		// Verify
		// Checked
		// Check box
		// Billing Info
		// Mandatory
		// And
		// ACH
		// Info
		// Not Mandatory
		// CC Info
		// Not Mandatory
		// Basic Info
		// Not Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.RegularSignUpWithBasicInfoNotMandatoryBillingInfoMandatoryCCInfoMandatoryAndACHinfoNotMandatory();
		// Billing Info
		// Mandatory
		// And
		// ACH
		// Info
		// Not Mandatory
		// CC Info
		// Not Mandatory
		// Basic Info
		// Not Mandatory

		driver.quit();

	}

	/**
	 * Verify Regular SignUp With Basic Info Not Mandatory Billing info Mandatory CC
	 * info Not Mandatory ACH info Mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Not_Mandatory_Billing_Info_Mandatory_CC_Info_Not_Mandatory_ACH_Info_Mandatory(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.132 Regular SignUp With Basic Info Not Mandatory Billing info Mandatory CC info  Not Mandatory ACH info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.132 Regular SignUp With Basic Info Not Mandatory Billing info Mandatory CC info  Not Mandatory ACH info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
		// profile
		// page
		adminDashboardPage
				.VerifyCheckedCheckboxBasicInfoNotMandatoryBillingInfoMandatoryCCInfoMandatoryACHInfoNotMandatory();
		// Verify
		// Checked
		// Check box
		// Billing Info
		// Mandatory
		// And
		// ACH
		// Info
		// Not Mandatory
		// CC Info
		// Not Mandatory
		// Basic Info
		// Not Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.RegularSignUpWithBasicInfoNotMandatoryBillingInfoMandatoryCCInfoMandatoryAndACHinfoNotMandatory();
		// Billing Info
		// Mandatory
		// And
		// ACH
		// Info
		// Not Mandatory
		// CC Info
		// Not Mandatory
		// Basic Info
		// Not Mandatory

		driver.quit();

	}

	/**
	 * Verify Regular SignUp With Basic Info Not Mandatory Billing info Not
	 * Mandatory CC info Mandatory ACH info Mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Not_Mandatory_Billing_Info_Not_Mandatory_CC_Info_Mandatory_ACH_Info_Mandatory(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.133 Regular SignUp With Basic Info Not Mandatory Billing info Not Mandatory CC info Mandatory ACH info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.133 Regular SignUp With Basic Info Not Mandatory Billing info Not Mandatory CC info Mandatory ACH info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage
				.verifyCheckedCheckboxBasicInfoNotMandatoryBillingInfoNotMandatoryCCInfoMandatoryACHInfoMandatory();
		// Verify
		// Checked
		// Check box
		// Billing Info
		// Not Mandatory
		// And
		// ACH
		// Info
		// Mandatory
		// CC Info
		// Mandatory
		// Basic Info
		// Not Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBasicInfoNotMandatoryBillingInfoNotMandatoryCCInfoMandatoryAndACHinfoMandatory();
		// Billing Info
		// Not Mandatory
		// And
		// ACH
		// Info
		// Mandatory
		// CC Info
		// Mandatory
		// Basic Info
		// Not Mandatory

		driver.quit();

	}

	/**
	 * Verify Regular SignUp With Basic Info Mandatory Billing info Mandatory CC
	 * info Mandatory ACH info Not Mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Mandatory_Billing_Info_Mandatory_CC_Info_Mandatory_ACH_Info_Not_Mandatory(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.134 Regular SignUp With Basic Info Mandatory Billing info Mandatory CC info Mandatory ACH info Not Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.134 Regular SignUp With Basic Info Mandatory Billing info Mandatory CC info Mandatory ACH info Not Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
		// profile
		// page
		adminDashboardPage
				.VerifyCheckedCheckboxBasicInfoMandatoryBillingInfoMandatoryCCInfoMandatoryACHInfoNotMandatory();
		// Verify
		// Checked
		// Check box
		// Billing Info
		// Mandatory
		// And
		// Info
		// Not Mandatory
		// CC Info
		// Mandatory
		// Basic Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.RegularSignUpWithBasicInfoMandatoryBillingInfoMandatoryCCInfoMandatoryAndACHinfoNotMandatory();
		// Billing Info
		// Mandatory
		// And
		// ACH
		// Info
		// Not Mandatory
		// CC Info
		// Mandatory
		// Basic Info
		// Mandatory

		driver.quit();

	}

	/**
	 * Verify Regular SignUp With Basic Info Mandatory Billing info Mandatory CC
	 * info Not Mandatory ACH info Mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Mandatory_Billing_Info_Mandatory_CC_Info_Not_Mandatory_ACH_Info_Mandatory(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.135 Regular SignUp With Basic Info Mandatory Billing info Mandatory CC info Not Mandatory ACH info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.135 Regular SignUp With Basic Info Mandatory Billing info Mandatory CC info Not Mandatory ACH info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage
				.verifyCheckedCheckboxBasicInfoMandatoryBillingInfoMandatoryCCInfoNotMandatoryACHInfoMandatory();
		// Verify
		// Checked
		// Check box
		// Billing Info
		// Mandatory
		// And
		// ACH
		// Info
		// Mandatory
		// CC Info
		// Not Mandatory
		// Basic Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBasicInfoMandatoryBillingInfoMandatoryCCInfoNotMandatoryAndACHinfoMandatory();
		// Billing Info
		// Mandatory
		// And
		// ACH
		// Info
		// Mandatory
		// CC Info
		// Not Mandatory
		// Basic Info
		// Mandatory

		driver.quit();

	}

	/**
	 * Verify Regular SignUp With Basic Info Mandatory Billing info Not Mandatory CC
	 * info Mandatory ACH info Mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Mandatory_Billing_Info_Not_Mandatory_CC_Info_Mandatory_ACH_Info_Mandatory(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.136 Regular SignUp With Basic Info Mandatory Billing info Not Mandatory CC info Mandatory ACH info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.136 Regular SignUp With Basic Info Mandatory Billing info Not Mandatory CC info Mandatory ACH info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage
				.verifyCheckedCheckboxBasicInfoMandatoryBillingInfoNotMandatoryCCInfoMandatoryACHInfoMandatory();
		// Verify
		// Checked
		// Check box
		// Billing Info
		// Mandatory
		// And
		// ACH
		// Info
		// Mandatory
		// CC Info
		// Not Mandatory
		// Basic Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBasicInfoMandatoryBillingInfoNotMandatoryCCInfoMandatoryAndACHinfoMandatory();
		// Billing Info
		// Mandatory
		// And
		// ACH
		// Info
		// Mandatory
		// CC Info
		// Not Mandatory
		// Basic Info
		// Mandatory

		driver.quit();

	}

	/**
	 * Verify Regular SignUp With Basic Info Not Mandatory Billing info Mandatory CC
	 * info Mandatory ACH info Mandatory
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Basic_Info_Not_Mandatory_Billing_Info_Mandatory_CC_Info_Mandatory_ACH_Info_Mandatory(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.137 Regular SignUp With Basic Info Not Mandatory Billing info Mandatory CC info Mandatory ACH info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.137 Regular SignUp With Basic Info Not Mandatory Billing info Mandatory CC info Mandatory ACH info Mandatory Feature.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage
				.verifyCheckedCheckboxBasicInfoNotMandatoryBillingInfoMandatoryCCInfoMandatoryACHInfoMandatory();
		// Verify
		// Checked
		// Check box
		// Billing Info
		// Mandatory
		// And
		// ACH
		// Info
		// Mandatory
		// CC Info
		// Not Mandatory
		// Basic Info
		// Mandatory

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.regularSignUpWithBasicInfoNotMandatoryBillingInfoMandatoryCCInfoMandatoryAndACHinfoMandatory();
		// Billing Info
		// Mandatory
		// And
		// ACH
		// Info
		// Mandatory
		// CC Info
		// Not Mandatory
		// Basic Info
		// Mandatory

		driver.quit();

	}

	/**
	 * same settings as for test 1.1 (regular signup) with "verify email upon
	 * account registration" active "Send confirmation link" active => enter the
	 * correct email the 2nd time (link is sent) => don't click the link - check
	 * account status
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Same_Settings_As_For_With_Verify_Email_Upon_Account_Registration_Active_And_Send_Confirmation_Link_With_Verify_The_Message_Account_Not_Verified_Is_Displayed(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.145 Regular SignUp With same settings as for test 1.1 (regular signup) with verify email upon account registration active Send confirmation link.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.145 Regular SignUp With same settings as for test 1.1 (regular signup) with verify email upon account registration active Send confirmation link.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		String username = common.generateRandomChars(5);

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxRegularSignupWithVerifyEmailAccountRegistration();

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		String signUpUser = signupPage.verifyEmailAndConfirmEmailWithAccountNotVerified(username); // Verify
		// Email
		// And
		// Confirm
		// Email
		// With
		// Account
		// Not
		// Verified
		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_Account_Verification_Users(signUpUser);

	}

	/**
	 * same settings as for test 1.1 (regular signup) with "verify email upon
	 * account registration" active "Send confirmation link" active => enter the
	 * correct email the 2nd time (link is sent) => don't click the link - check
	 * account status error message displayed saying that the confirmation email
	 * doesn't match the email
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Same_Settings_As_For_With_Verify_Email_Upon_Account_Registration_Active_And_Send_Confirmation_Link_With_Verify_The_Message_Account_Not_Verified_Is_Displayed_And_Confirmation_Email_Does_Not_Match(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.146 Regular SignUp With same settings as for test 1.1 (regular signup) with verify email upon account registration active Send confirmation link.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.146 Regular SignUp With same settings as for test 1.1 (regular signup) with verify email upon account registration active Send confirmation link.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
		// profile
		// page
		adminDashboardPage.verifyCheckedCheckboxRegularSignupWithVerifyEmailAccountRegistration();

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.verifyEmailAndConfirmEmailWithAccountNotVerifiedAndConfirmEmailDoesNotMatch(); // Verify
		// Email
		// And
		// Confirm
		// Email
		// With
		// Account
		// Not
		// Verified
		// ConfirmationEmail Does Not Match

		driver.quit();

	}

	/**
	 * same settings as for test 1.1 (regular signup) with * "verify email upon
	 * account registration" active * "Send confirmation link" active => enter the
	 * correct email the 2nd time (link is sent) => don't click the link - check
	 * account status error message displayed saying that the confirmation "Verify
	 * email upon account registration" is checked
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Same_Settings_as_For_With_Verify_Email_Upon_Account_Registration_Active_And_Send_Confirmation_Link_With_Verify_Email_Upon_Account_Registration_Is_Checked(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.147 Regular SignUp With same settings as for test 1.1 (regular signup) with Verify Email up on Account Registration Is Checked.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.147 Regular SignUp With same settings as for test 1.1 (regular signup) with Verify Email up on Account Registration Is Checked.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage
				.verifyCheckedCheckboxRegularSignupWithVerifyEmailAccountRegistrationVerifiedEmailUponAccountRegistrationChecked();

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage
				.verifyEmailAndConfirmEmailWithAccountNotVerifiedAndConfirmEmailDoesNotMatchVerifiedEmailUponAccountRegistrationChecked(); // Verify
		// Email
		// And
		// Confirm
		// Email
		// With
		// Account
		// Not
		// Verified
		// ConfirmationEmail Does Not Match

		driver.quit();

	}

	/**
	 * same settings as for test 1.1 (regular signup) with "verify email upon
	 * account registration" active "Send confirmation link" active => enter the
	 * correct email the 2nd time (link is sent) => don't click the link - check
	 * account status error message displayed saying that the confirmation email
	 * doesn't match the email "Verify email upon account registration" is checked
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Same_Settings_As_For_With_Verify_Email_Upon_Account_Registration_Active_And_Send_Confirmation_Link_With_Verify_Email_Upon_Account_Registration_Is_Checked_And_Confirm_Email_Does_Not_Match(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.148 Regular SignUp With same settings as for test 1.1 (regular signup) with Verify Email up on Account Registration Is Checked.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.148 Regular SignUp With same settings as for test 1.1 (regular signup) with Verify Email up on Account Registration Is Checked.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
		// profile
		// page
		adminDashboardPage
				.verifyCheckedCheckboxRegularSignupWithVerifyEmailAccountRegistrationVerifiedEmailUponAccountRegistrationChecked();

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage
				.verifyEmailAndConfirmEmailWithAccountNotVerifiedAndConfirmEmailDoesNotMatchVerifiedEmailUponAccountRegistrationChecked(); // Verify
		// Email
		// And
		// Confirm
		// Email
		// With
		// Account
		// Not
		// Verified
		// ConfirmationEmail Does Not Match

		driver.quit();

	}

	/**
	 * same settings as for test 1.1 (regular signup) with "Require Credit Card on
	 * signup" active On registration = CAPTURE Amount = 10 Expires = -1
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Require_Credit_Card_On_Sign_Up_Active(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.158 same settings as for test 1.1 (regular signup) with Require Credit Card on signup active On registration  CAPTURE Amount 10 Expires minus 1");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.158 same settings as for test 1.1 (regular signup) with Require Credit Card on signup active On registration  CAPTURE Amount 10 Expires minus 1");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
		// profile
		// page
		adminDashboardPage.verifyCheckedCheckboxRegularSignupWithVerifyRequireCreditCardOnSignUp();

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.verifyemailWithRequireCreditCardOnSignUpActive(); // Verify

		driver.quit();

	}

	/**
	 * same settings as for test 1.1 (regular signup) with "Require Credit Card on
	 * signup" active On registration = CAPTURE Amount = 10 Expires = -1 => use
	 * expired CC
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Require_Credit_Card_On_Expired_CC(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.159 same settings as for test 1.1 (regular signup) with Require Credit Card on signup active  On registration CAPTURE Amount 10  Expires -1 use expired CC");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.159 same settings as for test 1.1 (regular signup) with Require Credit Card on signup active  On registration CAPTURE Amount 10  Expires -1 use expired CC");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
		// profile
		// page
		adminDashboardPage.verifyCheckedCheckboxRegularSignupWithVerifyRequireCreditCardOnSignUp();

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.verifyEmailWithRequireCreditCardOnSignUpActiveAndExpiredCC(); // Verify

		driver.quit();

	}

	/**
	 * same settings as for test 1.1 (regular signup) with * "Require Credit Card on
	 * signup" active * * signup not successful "required" error message is
	 * displayed in red next to all the CC fields NO CC
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Require_Credit_Card_On_Required_Error_Message_Is_Displayed_In_Red_Next_To_All_The_CC_Fields(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.160 same settings as for test 1.1 (regular signup) with Require Credit Card on signup active  On same settings as for test regular signup with Require Credit Card on signup active  signup not successful required error message is displayed in red next to all the CC fields");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.160 same settings as for test 1.1 (regular signup) with Require Credit Card on signup active  On same settings as for test regular signup with Require Credit Card on signup active  signup not successful required error message is displayed in red next to all the CC fields");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxRegularSignupWithVerifyRequireCreditCardOnSignUp(); // Verify
																									// Checked
																									// Checkbox
																									// for
																									// Regular
																									// Signup
																									// with
																									// Verify
																									// Required
																									// Credit
																									// Card
																									// On
																									// Sign
																									// up

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.verify_RequireCreditCard_On_RequiredErrorMessageIsDisplayed_In_All_The_CCFields(); // Verify
																										// Required
																										// Fields

		driver.quit();

	}

	/**
	 * same settings as for test 1.1 (regular signup) with "Require Credit Card on
	 * signup" active On registration = Authorize Amount = 10 Expires = -1
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Require_Credit_Card_On_SignUp_Active_On_Registration_Authorize_Amount(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.161 same settings as for test 1.1 (regular signup) with Require Credit Card on signup active On registration Authorize Amount 10 Expires minus 1");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.161 same settings as for test 1.1 (regular signup) with Require Credit Card on signup active On registration Authorize Amount 10 Expires minus 1");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.enable_cc_info();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxRegularSignupWithVerifyRequireCreditCardOnSignUpActiveOnAuthorizeAmount();

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.verify_RequireCreditCard_On_SignUpActive_On_RegistrationNoneAmount(); // Verify
																							// Email
																							// required
																							// Credit
																							// Card
																							// On
																							// Signup
																							// Active
																							// On
																							// Registration
																							// Authorize
																							// Amount

		driver.quit();

	}

	/**
	 * same settings as for test 1.1 (regular signup) with "Require Credit Card on
	 * signup" active On registration = AUTHORIZE Amount = 10 Expires = -1 => use
	 * expired CC
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Require_Credit_Card_On_Signup_Active_On_Registration_Authorize_Amount_With_Expried_CC(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.162 same settings as for test 1.1 (regular signup) with Require Credit Card on signup active  On registration AUTHORIZE Amount 10  Expired -1 use expired CC");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.162 same settings as for test 1.1 (regular signup) with Require Credit Card on signup active  On registration AUTHORIZE Amount 10  Expired -1 use expired CC");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.payment_Authorise_net_cc_CIM_settings_enable();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
		// profile
		// page
		adminDashboardPage.verifyCheckedCheckboxRegularSignupWithVerifyRequireCreditCardOnSignUpOnExpriedCC();

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.verify_SignUp_Active_And_ExpiredCC_On_AuthorizeAmount(); // Verify
		// Email With Required Credit Card On SignuP Active And Expired CC on Authorize Amount

		driver.quit();

	}

	/**
	 * same settings as for test 1.1 (regular signup) with * "Require Credit Card on
	 * signup" active * * signup not successful "required" error message is
	 * displayed in red next to all the CC fields NO CC
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Require_Credit_Card_On_Required_Error_Message_Is_Displayed_In_Red_Next_To_All_The_CC_Fields_With_NO_CC(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.163 same settings as for test 1.1 (regular signup) with Require Credit Card on signup active  On same settings as for test regular signup with Require Credit Card on signup active  signup not successful required error message is displayed in red next to all the CC fields");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.163 same settings as for test 1.1 (regular signup) with Require Credit Card on signup active  On same settings as for test regular signup with Require Credit Card on signup active  signup not successful required error message is displayed in red next to all the CC fields");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxRegularSignupWithVerifyRequireCreditCardOnSignUpWithNoCC(); // Verify
		// Checked
		// Checkbox
		// for
		// Regular
		// Signup
		// with
		// Verify
		// Required
		// Credit
		// Card
		// On
		// Sign
		// up
		// NO CC

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.verify_RequireCreditCard_On_RequiredErrorMessageIsDisplayed_In_All_The_CCFields(); // Verify
		// Required
		// Fields
		// NO CC

		driver.quit();

	}

	/**
	 * same settings as for test 1.1 (regular signup) with "Require Credit Card on
	 * signup" active On registration = None Amount = 10 Expires = -1 NONE CC
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Require_Credit_Card_On_SignUp_Active_On_Registration_None_Amount(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.164 same settings as for test 1.1 (regular signup) with Require Credit Card on signup active On registration None Amount 10 Expires minus 1");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.164 same settings as for test 1.1 (regular signup) with Require Credit Card on signup active On registration None Amount 10 Expires minus 1");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxRegularSignupWithVerifyRequireCreditCardOnSignUpActiveOnNoneAmount();

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.verify_RequireCreditCard_On_SignUpActive_On_RegistrationNoneAmount(); // Verify
																							// Email
																							// required
																							// Credit
																							// Card
																							// On
																							// Signup
																							// Active
																							// On
																							// Registration
																							// None
																							// Amount

		driver.quit();

	}

	/**
	 * same settings as for test 1.1 (regular signup) with "Require Credit Card on
	 * signup" active On registration = None Amount = 10 Expires = -1 => use expired
	 * CC
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Require_Credit_Card_On_SignUp_Active_On_Registration_None_Amount_With_Expried_CC(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.165 same settings as for test 1.1 (regular signup) with Require Credit Card on signup active  On registration None Amount 10  Expired -1 use expired CC");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.165 same settings as for test 1.1 (regular signup) with Require Credit Card on signup active  On registration None Amount 10  Expired -1 use expired CC");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
		// profile
		// page
		adminDashboardPage.verifyCheckedCheckboxRegularSignupWithVerifyRequireCreditCardOnSignUpOnExpriedCCNONECC();

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.verify_RequireCreditCard_On_SignUpActive_And_Expired_CC_OnNoneAmount(); // Verify
		// Email
		// With
		// Required
		// Credit Card On SignuP Active And Expired CC on None Amount

		driver.quit();

	}

	/**
	 * same settings as for test 1.1 (regular signup) with * "Require Credit Card on
	 * signup" active * * signup not successful "required" error message is
	 * displayed in red next to all the CC fields NO CC(None User)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Require_Credit_Card_On_Required_Error_Message_Is_Displayed_In_Red_Next_To_All_The_CC_Fields_With_NO_CC_None_Account(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.166 same settings as for test 1.1 (regular signup) with Require Credit Card on signup active  On same settings as for test regular signup with Require Credit Card on signup active  signup not successful required error message is displayed in red next to all the CC fields For NONE CC");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.166 same settings as for test 1.1 (regular signup) with Require Credit Card on signup active  On same settings as for test regular signup with Require Credit Card on signup active  signup not successful required error message is displayed in red next to all the CC fields For NONE CC");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxRegularSignupWithVerifyRequireCreditCardOnSignUpWithNoCCNoneCC(); // Verify
		// Checked
		// Checkbox
		// for
		// Regular
		// Signup
		// with
		// Verify
		// Required
		// Credit
		// Card
		// On
		// Sign
		// up
		// NO CC

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End
		signupPage.verify_RequireCreditCard_On_RequiredErrorMessageIsDisplayed_In_All_The_CCFields(); // Verify
		// Required
		// Fields
		// NO CC

		driver.quit();

	}

	/**
	 * 1.169 same settings as for test 1.1 (regular signup) with * "Validate user CC
	 * upon registration" active => Make sure that "Require CC on signup" becomes
	 * automatically checked with NONE/0/-1
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Require_Credit_Card_On_Signup_With_Require_Credit_Card_Active_On_Registration_And_Verify_Require_CC_On_SignUp_Becomes_Automatically_Checked(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.169 Selenium  Regular SignUp With same settings as for test 1.1 (regular signup) with require credit card on signup active on registration And Verify Require CC on Signup Becomes automatically checked");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.169 Selenium  Regular SignUp With same settings as for test 1.1 (regular signup) with require credit card on signup active on registration And Verify Require CC on Signup Becomes automatically checked");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage
				.verifyCheckedCheckboxRegularSignupWithVerifyRequireCreditCardOnSignUpWithRequireCCOnSignUpBecomesAutomaticallyChecked(); // Verify
		// Checked
		// Checkbox
		// for
		// Regular
		// Signup
		// with
		// Verify
		// Required
		// Credit
		// Card
		// On
		// Sign
		// up
		// Automatically Checked

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End

		driver.quit();

	}

	/**
	 * 1.170 same settings as for test 2.1 (simplified signup) with * "Validate user
	 * CC upon registration" active => Make sure that "Include CC info" and "make CC
	 * info required" becomes automatically checked under the simplified signup
	 * section
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Require_Credit_Card_On_SignUp_With_Include_CC_Info_Make_CC_Info_Required_Becomes_Automatically_Checked_Under_The_Simplified_Signup_Section(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.170 Selenium  Regular SignUp With same settings as for test 1.1 (regular signup) with require credit card on signup active on registration And Verify Include CC info and make CC info required becomes automatically checked under the simplified signup section");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp Feature,TestCase Name: 1.170 Selenium  Regular SignUp With same settings as for test 1.1 (regular signup) with require credit card on signup active on registration And Verify Include CC info and make CC info required becomes automatically checked under the simplified signup section");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage
				.verifyCheckedCheckboxRegularSignupWithAutoAssignPreferredBidderPrivilegesUpOnSIgnup1(); // Verify
		

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End

		signupPage.simplifiedSignupFiled(FirstName, LastName, EmailUser, signUpUser);

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verify_Registered_User_Field(EmailUser, signUpUser); // Verify
																				// User
																				// Fields

	}

	/**
	 * 1.181 same settings as for test 2.1 (simplified signup) with * "Auto assign
	 * preferred bidder privileges upon signup" active * "Include CC info" is active
	 * * use no CC simplified signup section
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Require_Credit_Card_On_SignUp_With_Auto_Assign_Preferred_Bidder_Privileges_Upon_Signup_Active_Include_CC_Info_Is_Active_And_No_CC(
			String adminUserName, String adminPassword) throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(4);
		String LastName = common.generateRandomChars(4);
		String EmailUser = common.generateRandomChars(4);
		String signUpUser = common.generateRandomChars(5);

		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Selenium  Regular SignUp With same settings as for test 2.1 (regular signup) with Auto assign preferred bidder privileges upon signup active Include CC info is active and use no cc");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Selenium  Regular SignUp With same settings as for test 2.1 (regular signup) with Auto assign preferred bidder privileges upon signup active Include CC info is active and use no cc");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyCheckedCheckboxRegularSignupWithAutoAssignPreferredBidderPrivilegesUpOnSIgnup1(); // "Auto
																													// assign
																													// preferred
																													// bidder
																													// privileges
																													// upon
																													// signup"
																													// active

		// Under The Simplified Signup Section

		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go

		signupPage.simplifiedSignupFiled(FirstName, LastName, EmailUser, signUpUser);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verify_Registered_User_Preferred_Bidder_Filed(EmailUser, signUpUser); // verify
																									// preferred
																									// bidder
																									// checkbox
		driver.quit();

	}

	/**
	 * 1.198 enter all fields but username
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Regular_Signup_With_Enter_All_Fields_But_Verify_User_Name_Fields(String adminUserName,
			String adminPassword) throws InterruptedException, AWTException, ParseException {
		log("<br></br>Feature" + "-" + "UAT" + "\"Regular Signup With Enter All Fields But Verify User Name Fields");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(
				"Feature" + "-" + "UAT" + "\"Regular Signup With Enter All Fields But Verify User Name Fields");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());// Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.add_New_User_Without_UserName();// Verify Users
															// profile
															// page
		adminDashboardPage.adminLogout();
	}

	/**
	 * Verify That user is not able to Register with Missing Contact type Required
	 * field TC_01.
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Missing_Contact_Type_Required_Field(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = Common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Verify That user is not able to Register with Missing Conctact type Required field.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Regular SignUp shipping info Feature,TestCase Name: TC_01 Verify That user is not able to Register with Missing Conctact type Required field.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyMissingContactTypeRequiredFieldInShippingInfo();
		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up
		signupPage.enterShippingInfoWithoutContactNumber(signUpUser);

		driver.quit();
	}

	/**
	 * Verify That user is not able to Register with Missing "First Name" Required
	 * field TC_02.
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */

	@Test(dataProvider = "regularsignup")
	public void Missing_First_Name_In_Shipping_Info(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = Common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Verify That user is not able to Register with Missing First Name Required field.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"RVerify That user is not able to Register with Missing First Name Required field.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyMissingContactTypeRequiredFieldInShippingInfo();
		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info(FirstName, LastName, EmailUser, signUpUser); // Regular

		signupPage.enterShippingInfoWithoutFirstName(signUpUser);

		driver.quit();
	}

	/**
	 * 
	 * Verify That user is Not able to Register with Missing "Last Name" Required
	 * field TC_03.
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */

	@Test(dataProvider = "regularsignup")
	public void Missing_Last_Name_In_Shipping_Info(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);

		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Verify That user is Not able to Register with Missing Last Name Required field.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Verify That user is Not able to Register with Missing Last Name Required field.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyMissingContactTypeRequiredFieldInShippingInfo();
		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.enterShippingInfoWithoutLastName(signUpUser);

		driver.quit();
	}

	/**
	 * Verify That user is not able to Register with Missing "Phone Number" Required
	 * field TC_04.
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	@Test(dataProvider = "regularsignup")
	public void Missing_Phone_Number_In_Shipping_Info(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Verify That user is not able to Register with Missing Phone Number Required field.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Verify That user is not able to Register with Missing Phone Number Required field.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyMissingContactTypeRequiredFieldInShippingInfo();
		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.enterShippingInfoWithoutPhoneNumber(signUpUser);

		driver.quit();
	}

	/**
	 * Verify That user is not able to Register with invalid "Phone Number" Required
	 * field TC_05.
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Enter_Alphabet_In_Phone_Number_Field_Shipping_Info(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Verify That user is not able to Register with invalid Phone Number Required field.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Verify That user is not able to Register with invalid Phone Number Required field.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyMissingContactTypeRequiredFieldInShippingInfo();
		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.enterAlphabetInPhoneNumberFiledShippingInfo(signUpUser);

		driver.quit();
	}

	/**
	 * Verify That user is not able to Register with Missing "Country" Required
	 * field TC_06.
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Missing_Country_In_Shipping_Info(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Verify That user is not able to Register with Missing Country Required field.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Verify That user is not able to Register with Missing  Country Required field.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyMissingContactTypeRequiredFieldInShippingInfo();
		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.missingCountryFiledShippingInfo(signUpUser);

		driver.quit();
	}

	/**
	 * Verify That user is not able to Register with Missing "Address" Required
	 * field TC_07.
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Missing_Address_In_Shipping_Info(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Verify That user is not able to Register with Missing Address Required field.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Verify That user is not able to Register with Missing Address Required field.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyMissingContactTypeRequiredFieldInShippingInfo();
		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.missingAddressFiledShippingInfo(signUpUser);

		driver.quit();
	}

	/**
	 * Verify That user is not able to Register with Missing "City" Required field
	 * TC_08.
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Missing_City_In_Shipping_Info(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Verify That user is not able to Register with Missing City Required field.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Verify That user is not able to Register with Missing City Required field.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyMissingContactTypeRequiredFieldInShippingInfo();
		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.missingCityFiledShippingInfo(signUpUser);

		driver.quit();
	}

	/**
	 * 
	 * Verify That user is not able to Register with Missing "State/Province"
	 * Required field TC_09.
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */

	@Test(dataProvider = "regularsignup")
	public void Missing_State_In_Shipping_Info(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Verify That user is not able to Register with Missing State/Province Required field.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Verify That user is not able to Register with Missing State/Province Required field.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyMissingContactTypeRequiredFieldInShippingInfo();
		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.missingStateFiledShippingInfo(signUpUser);

		driver.quit();
	}

	/**
	 * Verify That user is not able to Register with Missing "Zip/Postal code"
	 * Required field TC_10.
	 **/

	@Test(dataProvider = "regularsignup")
	public void Missing_Zip_In_Shipping_Info(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Verify That user is not able to Register with Missing Zip/Postal code Required field.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Verify That user is not able to Register with Missing Zip/Postal code Required field.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyMissingContactTypeRequiredFieldInShippingInfo();
		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.missingZipFiledShippingInfo(signUpUser);

		driver.quit();
	}

	/**
	 * Verify That user is able to Register Successfully with entering all valid
	 * info in required fields TC_11.
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Fill_All_The_Details_In_Shipping_Info(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Verify That user is able to Register Successfully with entering all valid info in required fields.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Verify That user is able to Register Successfully with entering all valid info in required fields.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyMissingContactTypeRequiredFieldInShippingInfo();
		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.fill_All_Filed_Shipping_Info(signUpUser);

		driver.quit();
	}

	/**
	 * Verify that user is not able to register with keep blank any one required
	 * field and entering all valid info in other required fields TC_12.
	 **/

	@Test(dataProvider = "regularsignup")
	public void Missing_Anyone_Filed_In_Shipping_Info(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Verify that user is not able to register with keep blank any one required field and entering all valid info in other required fields.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"Verify that user is not able to register with keep blank any one required field and entering all valid info in other required fields.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyMissingContactTypeRequiredFieldInShippingInfo();
		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.missing_One_Filed_Shipping_Info(signUpUser);

		driver.quit();
	}

	/**
	 * To verify that "Contact Type" Is display correct value after success fully
	 * registration. From TC_13 to TC_23.
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Verify_Shipping_Info_Fields(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT"
				+ "\"To verify that shipping info fileds display correct value after success fully registration TC_13 - TC_23.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"To verify that shipping info fields Is display correct value after success fully registration.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verifyMissingContactTypeRequiredFieldInShippingInfo();
		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.fill_All_Filed_Shipping_Info(signUpUser);

		signupPage.verifyShippingInfoFields(signUpUser, EmailUser);
		driver.quit();

	}

	/**
	 * 
	 * Verify simplified signup field.
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Verify_Simplified_Signup(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT"
				+ "\"To verify that simplified signup fileds display correct value after success fully registration.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"To verify that simplified signup fileds display correct value after success fully registration.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.verifySimplifiedSignupPageFileds();

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.simplifiedSignupFiled(FirstName, LastName, EmailUser, signUpUser); // Regular
																						// Sign
																						// Up

		signupPage.verifySimplifiedSignup(signUpUser, EmailUser); // Verify
																	// simplified
																	// signup
																	// fields.

		driver.quit();
	}

	/**
	 * 
	 * To verify that Shipping address info form is displays during sale
	 * Registration TC_24.
	 * 
	 *
	 */

	@Test(dataProvider = "regularsignup")
	public void Verify_Shipping_Address_Info_During_Sale_Regstration(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT"
				+ "\"To verify that Require address confirmation upon sale registration. ");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(
				"Feature" + "-" + "UAT" + "\"To verify that Require address confirmation upon sale registration.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page
		adminDashboardPage.verify_Shipping_Address_During_Sale();
		adminDashboardPage.create_Live_Auction("testLive123");

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info(FirstName, LastName, EmailUser, signUpUser); // Regular

		signupPage.fill_All_Filed_Shipping_Info(signUpUser);

		signupPage.verifyShippingAddressSaleRegistration(signUpUser);

		driver.quit();
	}

	/**
	 * To verify that user is able to edit firstname in shipping info.(TC_25)
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Edit_First_Name_Shipping_Address_Info_During_Sale_Registration(String adminUserName,
			String adminPassword) throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify that user is able to edit firstname in shipping info.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out
				.println("Feature" + "-" + "UAT" + "\"To verify that user is able to edit firstname in shipping info.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.delete_Custom_Field(); // Delete custom field
		adminDashboardPage.delete_Additional_Confirmation(); //Delete Additional custom field
		adminDashboardPage.delete_Additional_Registration_Options_Filed(); //Delete Additional Registration Confirmation
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.verify_Shipping_Address_During_Sale();
		adminDashboardPage.registration_Setting();

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info11(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.fill_All_Filed_Shipping_Info(signUpUser);

		signupPage.editFirstNameShippingAddressSaleRegistration(signUpUser);

		driver.quit();
	}

	/**
	 * To verify that user is able to edit lastname in shipping info.(TC_26)
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Edit_Last_Name_Shipping_Address_Info_During_Sale_Registration(String adminUserName,
			String adminPassword) throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify that user is able to edit lastname in shipping info.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out
				.println("Feature" + "-" + "UAT" + "\"To verify that user is able to edit lastname in shipping info.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.delete_Custom_Field(); // Delete custom field
		adminDashboardPage.delete_Additional_Confirmation(); //Delete Additional custom field
		adminDashboardPage.delete_Additional_Registration_Options_Filed(); //Delete Additional Registration Confirmation
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.verify_Shipping_Address_During_Sale();
		adminDashboardPage.registration_Setting();

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info11(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.fill_All_Filed_Shipping_Info(signUpUser);

		signupPage.editLastNameShippingAddressSaleRegistration(signUpUser);

		driver.quit();
	}

	/**
	 * To verify that user is able to edit phonenumber in shipping info.(TC_27)
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Edit_Phone_Number_Shipping_Address_Info_During_Sale_Registration(String adminUserName,
			String adminPassword) throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify that user is able to edit phonenumber in shipping info.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(
				"Feature" + "-" + "UAT" + "\"To verify that user is able to edit phonenumber in shipping info.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.delete_Custom_Field(); // Delete custom field
		adminDashboardPage.delete_Additional_Confirmation(); //Delete Additional custom field
		adminDashboardPage.delete_Additional_Registration_Options_Filed(); //Delete Additional Registration Confirmation
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.verify_Shipping_Address_During_Sale();
		adminDashboardPage.registration_Setting();

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info11(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.fill_All_Filed_Shipping_Info(signUpUser);

		signupPage.editPhoneNumberShippingAddressSaleRegistration(signUpUser);

		driver.quit();
	}

	/**
	 * To verify that user is able to edit country in shipping info.(TC_28)
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Edit_Country_Shipping_Address_Info_During_Sale_Registration(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify that user is able to edit country in shipping info.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify that user is able to edit country in shipping info.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.delete_Custom_Field(); // Delete custom field
		adminDashboardPage.delete_Additional_Confirmation(); //Delete Additional custom field
		adminDashboardPage.delete_Additional_Registration_Options_Filed(); //Delete Additional Registration Confirmation
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.verify_Shipping_Address_During_Sale();
		adminDashboardPage.registration_Setting();

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info11(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.fill_All_Filed_Shipping_Info(signUpUser);

		signupPage.editCountryShippingAddressSaleRegistration(signUpUser);

		driver.quit();
	}

	/**
	 * To verify that user is able to edit Address in shipping info.(TC_29)
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Edit_Shipping_Address_Info_During_Sale_Registration(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify that user is able to edit address in shipping info.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify that user is able to edit address in shipping info.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.delete_Custom_Field(); // Delete custom field

		adminDashboardPage.delete_Custom_Field(); // Delete custom field
		adminDashboardPage.delete_Additional_Confirmation(); //Delete Additional custom field
		adminDashboardPage.delete_Additional_Registration_Options_Filed(); //Delete Additional Registration Confirmation
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.verify_Shipping_Address_During_Sale();
		adminDashboardPage.registration_Setting();
		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info11(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.fill_All_Filed_Shipping_Info(signUpUser);

		signupPage.editAddressShippingaddressSaleRegistration(signUpUser);

		driver.quit();
	}

	/**
	 * To verify that user is able to edit city in shipping info.(TC_30)
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Edit_City_Shipping_Address_Info_During_Sale_Regstration(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify that user is able to edit city in shipping info.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify that user is able to edit city in shipping info.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.delete_Custom_Field(); // Delete custom field
		adminDashboardPage.delete_Additional_Confirmation(); //Delete Additional custom field
		adminDashboardPage.delete_Additional_Registration_Options_Filed(); //Delete Additional Registration Confirmation
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.verify_Shipping_Address_During_Sale();
		adminDashboardPage.registration_Setting();

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info11(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.fill_All_Filed_Shipping_Info(signUpUser);

		signupPage.editCityShippingAddressSaleRegistration(signUpUser);

		driver.quit();
	}

	/**
	 * To verify that user is able to edit State in shipping info.(TC_31)
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Edit_State_Shipping_Address_Info_During_Sale_Registration(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify that user is able to edit state in shipping info.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify that user is able to edit state in shipping info.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.delete_Custom_Field(); // Delete custom field
        adminDashboardPage.delete_Additional_Confirmation(); //Delete Additional custom field
		adminDashboardPage.delete_Additional_Registration_Options_Filed(); //Delete Additional Registration Confirmation
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
		adminDashboardPage.verify_Shipping_Address_During_Sale();
		adminDashboardPage.registration_Setting();

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info11(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.fill_All_Filed_Shipping_Info(signUpUser); // Fill All fiels
																// Shipping info

		signupPage.editStateShippingAddressSaleRegistration(signUpUser);

		driver.quit();
	}

	/**
	 * To verify that user is able to edit zip in shipping info.(TC_32)
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Edit_Zip_Shipping_Address_Info_During_Sale_Registration(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify that user is able to edit zip in shipping info.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify that user is able to edit zip in shipping info.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.delete_Custom_Field(); // Delete custom field
		adminDashboardPage.delete_Additional_Confirmation(); //Delete Additional custom field
		adminDashboardPage.delete_Additional_Registration_Options_Filed(); //Delete Additional Registration Confirmation
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.verify_Shipping_Address_During_Sale();
		adminDashboardPage.registration_Setting();

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info11(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.fill_All_Filed_Shipping_Info(signUpUser);

		signupPage.editZipShippingAddressSaleRegistration(signUpUser);

		driver.quit();
		
	}

	/**
	 * To verify that if "Remember shipping preference in profile" check box is
	 * checked and update any information then it should display in my account of
	 * user TC_33.
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Remember_Shipping_Address_Info_During_Sale_Registration(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"Checked the check box of Remember shipping preference in profile.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(
				"Feature" + "-" + "UAT" + "\"Checked the check box of Remember shipping preference in profile.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.verify_Shipping_Address_During_Sale();

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.fill_All_Filed_Shipping_Info(signUpUser);

		signupPage.rememberShippingPreferenceAddressSaleRegistration(signUpUser);

		driver.quit();
	}

	/**
	 * To verify that if "Remember shipping preference in profile" check box is not
	 * checked and update any inforormation TC_34.
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Remember_Shipping_Checkbox_Uncheck_Address_Info_During_Sale_Registration(String adminUserName,
			String adminPassword) throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"Unchecked the check box of Remember shipping preference in profile.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(
				"Feature" + "-" + "UAT" + "\"Unchecked the check box of Remember shipping preference in profile.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.verify_Shipping_Address_During_Sale();

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.fill_All_Filed_Shipping_Info(signUpUser);

		signupPage.rememberShippingPreferenceCheckboxUncheckAddressSaleRegistration(signUpUser);

		driver.quit();
	}

	/**
	 *
	 * To verify that Edit "First Name" in Basic info -> My Account TC_35.
	 */

	@Test(dataProvider = "regularsignup")
	public void Edit_First_Name_In_Basic_Info(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify that Edit First Name in Basic info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify that Edit First Name in Basic info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.delete_Custom_Field(); // Delete custom field

		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.edit_Details_In_Profile();

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info1(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.fill_All_Filed_Shipping_Info(signUpUser);

		signupPage.editFirstNameInProfile(signUpUser);

		driver.quit();
	}

	/**
	 * To verify that Edit "Last Name" in Basic info -> My Account TC_36.
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Edit_Last_Name_In_Basic_Info(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify that Edit Last Name in Basic info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify that Edit Last Name in Basic info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.delete_Custom_Field(); // Delete custom field

		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.edit_Details_In_Profile();

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info1(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.fill_All_Filed_Shipping_Info(signUpUser);

		signupPage.editLastNameInProfile(signUpUser);

		driver.quit();
	}

	/**
	 * To verify that Edit "Phone" in Basic info -> My Account TC_37.
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Edit_Phone_In_Basic_Info(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify that Edit Phone in Basic info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify that Edit Phone in Basic info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.delete_Custom_Field(); // Delete custom field

		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.edit_Details_In_Profile();

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info1(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.fill_All_Filed_Shipping_Info(signUpUser);

		signupPage.editPhoneInProfile(signUpUser);

		driver.quit();
	}

	/**
	 * To verify that Edit "Phone type" in Basic info -> My Account TC_38.
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Edit_Phone_Type_In_Basic_Info(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify that Edit Phone type Basic info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify that Edit Phone type in Basic info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.delete_Custom_Field(); // Delete custom field

		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.edit_Details_In_Profile();

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info1(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.fill_All_Filed_Shipping_Info(signUpUser);

		signupPage.editPhoneTypeInProfile(signUpUser);

		driver.quit();
	}

	/**
	 * To verify that Edit "First Name" in Biling info -> My Account TC_39.
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Edit_First_Name_In_Billing_info(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify that edit First name in Billing info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify that edit First name in billing info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.delete_Custom_Field(); // Delete custom field

		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.edit_Details_In_Profile();

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info1(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.fill_All_Filed_Shipping_Info(signUpUser);

		signupPage.editFirstNameInBillingInfo(signUpUser);

		driver.quit();
	}

	/**
	 * To verify that Edit "Last Name" in Biling info -> My Account TC_40.
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Edit_Last_Name_In_Billing_Info(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify that edit Last name in billing info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify that edit Last name in billing info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.delete_Custom_Field(); // Delete custom field

		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.edit_Details_In_Profile();

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info1(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.fill_All_Filed_Shipping_Info(signUpUser);

		signupPage.editLastNameInBillingInfo(signUpUser);

		driver.quit();
	}

	/**
	 * To verify that Edit "Phone Number" in Biling info My Account TC_41.
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Edit_Phone_Billing_Info(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify that edit Phone Number in billing info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out
				.println("Feature" + "-" + "UAT" + "\"To verify that edit Phone Number in billing info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.delete_Custom_Field(); // Delete custom field

		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.edit_Details_In_Profile();

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info1(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.fill_All_Filed_Shipping_Info(signUpUser);

		signupPage.editPhoneNumberInBillingInfo(signUpUser);

		driver.quit();
	}

	/**
	 * To verify that Edit "Contact type" in Billing info -> My Account TC_42.
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Edit_Contact_Type_In_Billing_Info(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify that Edit Contact type in billing info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out
				.println("Feature" + "-" + "UAT" + "\"To verify that Edit Contact type in billing info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.delete_Custom_Field(); // Delete custom field

		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.edit_Details_In_Profile();

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info1(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.fill_All_Filed_Shipping_Info(signUpUser);

		signupPage.editContactTypeInProfileBilling(signUpUser);
		driver.quit();
	}

	/**
	 * To verify that Edit "Country" in Billing info -> My Account TC_43.
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Edit_County_In_Billing_Info(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify that Edit Counrty in billing  info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify that Edit Country in billing info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.delete_Custom_Field(); // Delete custom field

		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.edit_Details_In_Profile();

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info1(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.fill_All_Filed_Shipping_Info(signUpUser);

		signupPage.editCountryInProfileBilling(signUpUser);

		driver.quit();
	}

	/**
	 * To verify that Edit "Address" in Biling info My Account TC_44.
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Edit_Address_Billing_Info(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify that edit address in billing info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify that edit address in billing info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.delete_Custom_Field(); // Delete custom field

		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.edit_Details_In_Profile();

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info1(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.fill_All_Filed_Shipping_Info(signUpUser);

		signupPage.editAddressInBillingInfo(signUpUser);

		driver.quit();
	}

	/**
	 * To verify that Edit "city" in Biling info My Account TC_45.
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Edit_City_Billing_Info(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify that edit city in billing info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify that edit city in billing info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.delete_Custom_Field(); // Delete custom field

		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.edit_Details_In_Profile();

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info1(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.fill_All_Filed_Shipping_Info(signUpUser);

		signupPage.editCityInBillingInfo(signUpUser);

		driver.quit();
	}

	/**
	 * To verify that Edit "State" in Billing info -> My Account TC_46.
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Edit_State_In_Billing_Info(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify that Edit State in billing info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify that Edit State in billing info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.delete_Custom_Field(); // Delete custom field
        adminDashboardPage.delete_Additional_Confirmation(); //Delete Additional custom field
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
	    adminDashboardPage.verifyCheckedCheckboxSimplifiedSignupBillingandCC(); // Enable CC Info on SignUp
		adminDashboardPage.uncheckUserSettingExceptSimplifiedandCC();  // Disable settings other than Simplified and CC
		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info1(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
		signupPage.signup_button(); // Click on SignUp button 	

		signupPage.editStateInProfileBilling(signUpUser);

		driver.quit();
	}

	/**
	 * To verify that Edit "zip" in Biling info My Account TC_47.
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Edit_Zip_Billing_Info(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify that edit zip in billing info My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify that edit zip in billing info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.delete_Custom_Field(); // Delete custom field

		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.edit_Details_In_Profile();

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info1(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.fill_All_Filed_Shipping_Info(signUpUser);

		signupPage.editZipInBillingInfo(signUpUser);

		driver.quit();
	}

	/**
	 * To verify that Edit "CC Type" in Billing info -> My Account TC_48.
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Edit_CC_Type_In_Billing_Info(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify that Edit CC Type in billing info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify that Edit CC Type in billing info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.delete_Custom_Field(); // Delete custom field
        adminDashboardPage.delete_Additional_Confirmation(); //Delete Additional custom field
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
	    adminDashboardPage.verifyCheckedCheckboxSimplifiedSignupBillingandCC(); // Enable CC Info on SignUp
		adminDashboardPage.uncheckUserSettingExceptSimplifiedandCC();  // Disable settings other than Simplified and CC
		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info1(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
		signupPage.signup_button(); // Click on SignUp button 	
		signupPage.editCCTypeInBillingInfo(signUpUser);

		driver.quit();
	}

	/**
	 * To verify that Edit "CC Number" in Billing info -> My Account TC_49.
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Edit_CC_Number_In_Billing_Info(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify that Edit CC Number in billing info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify that Edit CC Number in billing info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.delete_Custom_Field(); // Delete custom field
        adminDashboardPage.delete_Additional_Confirmation(); //Delete Additional custom field
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
	    adminDashboardPage.verifyCheckedCheckboxSimplifiedSignupBillingandCC(); // Enable CC Info on SignUp
		adminDashboardPage.uncheckUserSettingExceptSimplifiedandCC();  // Disable settings other than Simplified and CC
		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info1(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
		signupPage.signup_button(); // Click on SignUp button 	
		signupPage.editCCNumberInBillingInfo(signUpUser);

		driver.quit();
	}

	/**
	 * To verify that Edit "Expiration Date" in Billing info -> My Account TC_50.
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Edit_Expiration_Date_In_Billing_Info(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify that Edit Expiration date in billing info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(
				"Feature" + "-" + "UAT" + "\"To verify that Edit Expiration date in billing info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.delete_Custom_Field(); // Delete custom field
        adminDashboardPage.delete_Additional_Confirmation(); //Delete Additional custom field
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
	    adminDashboardPage.verifyCheckedCheckboxSimplifiedSignupBillingandCC(); // Enable CC Info on SignUp
		adminDashboardPage.uncheckUserSettingExceptSimplifiedandCC();  // Disable settings other than Simplified and CC
		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info1(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
		signupPage.signup_button(); // Click on SignUp button 																		// Up
		signupPage.editExpirationDateInBillingInfo(signUpUser);

		driver.quit();
	}

	/**
	 * To verify that Edit "Security code" in Billing info -> My Account TC_51.
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Edit_Security_Code_In_Billing_Info(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify that Edit Security code in billing info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(
				"Feature" + "-" + "UAT" + "\"To verify that Edit Security code in billing info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.delete_Custom_Field(); // Delete custom field
        adminDashboardPage.delete_Additional_Confirmation(); //Delete Additional custom field
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
	    adminDashboardPage.verifyCheckedCheckboxSimplifiedSignupBillingandCC(); // Enable CC Info on SignUp
		adminDashboardPage.uncheckUserSettingExceptSimplifiedandCC();  // Disable settings other than Simplified and CC
		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info1(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.signup_button(); // Click on SignUp button 

		signupPage.editSecurityCodeInBillingInfo(signUpUser); // Update  Security code
		driver.quit();
	}

	/**
	 * To verify that Edit "Firstname" in shipping info -> My Account TC_52.
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Edit_First_Name_In_Shipping_Info(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify that Edit First name in shipping info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out
				.println("Feature" + "-" + "UAT" + "\"To verify that Edit First name in shipping info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.delete_Custom_Field(); // Delete custom field

		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.edit_Details_In_Profile();

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info1(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.fill_All_Filed_Shipping_Info(signUpUser);

		signupPage.editFirstNameShippingInfo(signUpUser);

		driver.quit();
	}

	/**
	 * To verify that Edit "Lastname" in shipping info -> My Account TC_53.
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Edit_Last_Name_In_Shipping_Info(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify that Edit Last name in shipping info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify that Edit Last name in shipping info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.delete_Custom_Field(); // Delete custom field

		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.edit_Details_In_Profile();

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info1(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.fill_All_Filed_Shipping_Info(signUpUser);

		signupPage.editLastNameShippingInfo(signUpUser);

		driver.quit();
	}

	/**
	 * To verify that Edit "phone" in shipping info -> My Account TC_54.
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Edit_Phone_In_Shipping_Info(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify that Edit Last name in shipping info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify that Edit Last name in shipping info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.delete_Custom_Field(); // Delete custom field

		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.edit_Details_In_Profile();

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info1(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.fill_All_Filed_Shipping_Info(signUpUser);

		signupPage.editPhoneInShippingInfo(signUpUser);

		driver.quit();
	}

	/**
	 * To verify that Edit "Country" in shipping info -> My Account TC_55.
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Edit_Country_In_Shipping_Info(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify that Edit country in shipping info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify that Edit country in shipping info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.delete_Custom_Field(); // Delete custom field

		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.edit_Details_In_Profile();

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info1(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.fill_All_Filed_Shipping_Info(signUpUser);

		signupPage.Editcountryinshippinginfo(signUpUser);

		driver.quit();
	}

	/**
	 * To verify that Edit "Address" in shipping info -> My Account TC_56.
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Edit_Address_In_Shipping_Info(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify that Edit address in shipping info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify that Edit address in shipping info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.delete_Custom_Field(); // Delete custom field
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.edit_Details_In_Profile();

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info1(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.fill_All_Filed_Shipping_Info(signUpUser);

		signupPage.editAddressInShippingInfo(signUpUser);

		driver.quit();
	}

	/**
	 * To verify that Edit "city" in shipping info -> My Account TC_57.
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Edit_City_In_Shipping_Info(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify that Edit city in shipping info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify that Edit city in shipping info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.delete_Custom_Field(); // Delete custom field
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.edit_Details_In_Profile();

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info1(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.fill_All_Filed_Shipping_Info(signUpUser);

		signupPage.editCityInShippingInfo(signUpUser);

		driver.quit();
	}

	/**
	 * To verify that Edit "zipcode" in shipping info -> My Account TC_58.
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Edit_Zip_Code_In_Shipping_Info(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify that Edit zip in shipping info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify that Edit zip in shipping info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.delete_Custom_Field(); // Delete custom field

		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.edit_Details_In_Profile();

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info1(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.fill_All_Filed_Shipping_Info(signUpUser);

		signupPage.editZipInShippingInfo(signUpUser);

		driver.quit();
	}

	/**
	 * To Verify that Keep blank any required field and save changes TC_59.
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Keep_Blank_In_Shipping_Info(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT"
				+ "\"To verify that  Keep blank any required field in shipping info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"To verify that  Keep blank any required field in shipping info -> My Account.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.edit_Details_In_Profile();

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info1(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.fill_All_Filed_Shipping_Info(signUpUser);

		signupPage.keepBlankAddressFieldInShippingInfo(signUpUser);

		driver.quit();
	}

	/**
	 * To Verify that confirm password not match TC_60.
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Verify_Confirm_Password(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify that Change Password");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify that Change Password");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.delete_Custom_Field();

		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.edit_Details_In_Profile();

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info1(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.fill_All_Filed_Shipping_Info(signUpUser);

		signupPage.changePasswordNotMatch(signUpUser);

		driver.quit();
	}

	/**
	 * To Verify that change password successfully TC_61.
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Change_Password_Successfully(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify that Change Password successfully.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify that Change Password successfully.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.delete_Custom_Field(); // Delete custom filed
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.edit_Details_In_Profile();

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info1(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.fill_All_Filed_Shipping_Info(signUpUser);

		signupPage.changePasswordSuccess(signUpUser);

		driver.quit();
	}

	/**
	 * To Verify that change password successfully TC_62.
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Enter_Wrong_Old_Password(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify that Change Password");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify that Change Password");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.delete_Custom_Field();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.edit_Details_In_Profile();

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info1(FirstName, LastName, EmailUser, signUpUser); // Regular
																									// Sign
																									// Up

		signupPage.fill_All_Filed_Shipping_Info(signUpUser);

		signupPage.wrongOldPassword(signUpUser);

		driver.quit();
	}

	/**
	 * To Verify that Custom field Type as "Integer" is not required. Enter valid
	 * data TC_63.
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Custom_Field_As_Integer(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";
		String customFiled1 = common.generateRandomChars(6);

		String saleno1 = common.generateRandomNumber1();
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"To Verify that Custom field Type as Integer is not required. Enter valid data");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"To Verify that Custom field Type as Integer is not required. Enter valid data");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.manage_Field_Registration_Settings();

		adminDashboardPage.customfieldsettings(customFiled1);

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Custom_Field(FirstName, LastName, EmailUser, signUpUser);
		signupPage.regularSignupWithValidNumber(FirstName, LastName, EmailUser, signUpUser, customFiled1);

		driver.quit();
	}

	/**
	 * To Verify that Custom field Type as "Integer" is not required. Enter invalid
	 * data TC_64.
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Custom_Field_As_Integer_Enter_Invalid_Data(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";
		String saleno1 = common.generateRandomNumber1();
		String customFiled1 = common.generateRandomChars(6);
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"To Verify that Custom field Type as Integer is not required. Enter invalid data");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"To Verify that Custom field Type as Integer is not required. Enter invalid data");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.manage_Field_Registration_Settings();

		adminDashboardPage.customfieldsettings(customFiled1);

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Custom_Field(FirstName, LastName, EmailUser, signUpUser);
		signupPage.regularSignupWithInValidNumber(FirstName, LastName, EmailUser, signUpUser, customFiled1);

		driver.quit();

	}

	/**
	 * To Verify that Custom field Type as "Integer" is not required. Enter invalid
	 * data TC_65. Checked checkbox required.
	 */

	@Test(dataProvider = "regularsignup")
	public void Custom_Field_As_Integer_Enter_Valid_Data_Checkbox(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";
		String saleno1 = common.generateRandomNumber1();
		String customFiled1 = common.generateRandomChars(6);
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"To Verify that Custom field Type as Integer is not required. Enter invalid data >> Checked");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"To Verify that Custom field Type as Integer is not required. Enter invalid data >> Checked");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.manage_Field_Registration_Settings();

		adminDashboardPage.customFieldSettingsCheckedNotRequired(customFiled1);

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Custom_Field(FirstName, LastName, EmailUser, signUpUser);
		signupPage.regularSignupWithValidNumber(FirstName, LastName, EmailUser, signUpUser, customFiled1);

		driver.quit();
	}

	/**
	 * To Verify that Custom field Type as "integer" is required. Enter invalid data
	 * or keep blank TC_66.
	 *
	 */

	@Test(dataProvider = "regularsignup")
	public void Custom_Field_As_Integer_Enter_Invalid_Data_Checkbox(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";
		String saleno1 = common.generateRandomNumber1();
		String customFiled1 = common.generateRandomChars(6);
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"To Verify that Custom field Type as Integer is required. Enter invalid data or blank");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"To Verify that Custom field Type as Integer is required. Enter invalid data or blank.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.manage_Field_Registration_Settings();

		adminDashboardPage.customfieldsettingscheckedrequired(customFiled1);

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Custom_Field(FirstName, LastName, EmailUser, signUpUser);
		signupPage.regularSignupWithInvalidNumberMandatory(FirstName, LastName, EmailUser, signUpUser, customFiled1);

		driver.quit();
	}

	/**
	 * To Verify that Custom field Type as "Decimal" is not required. Enter valid
	 * data TC_67.
	 *
	 */

	@Test(dataProvider = "regularsignup")
	public void Custom_Field_As_Decimal_Enter_Valid_Data(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";
		String saleno = common.generateRandomNumber1();
		String customfield1 = common.generateRandomChars(6);
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"To Verify that Custom field Type as Decimal is required. Enter valid data");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"To Verify that Custom field Type as Decimal is required. Enter valid data.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.manage_Field_Registration_Settings();

		adminDashboardPage.customfieldsettingsdecimal(customfield1);

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Custom_Field(FirstName, LastName, EmailUser, signUpUser);
		signupPage.regularSignupWithValidDecimalNumber(FirstName, LastName, EmailUser, signUpUser, customfield1);

		driver.quit();
	}

	/**
	 * To Verify that Custom field Type as "decimal" is required. Enter invalid data
	 * TC_68.
	 *
	 */

	@Test(dataProvider = "regularsignup")
	public void Custom_Field_As_Decimal_Invalid_Data(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";
		String saleno = common.generateRandomNumber1();
		String customFiled1 = common.generateRandomChars(6);
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"To Verify that Custom field Type as decimal is required. Enter invalid data");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"To Verify that Custom field Type as decimal is required Enter invalid data.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.manage_Field_Registration_Settings();

		adminDashboardPage.customfieldsettingsdecimal(customFiled1);

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Custom_Field(FirstName, LastName, EmailUser, signUpUser);
		signupPage.regularSignupWithDecimalInvalidValues(FirstName, LastName, EmailUser, signUpUser, customFiled1);

		driver.quit();
	}

	/**
	 * To Verify that Custom field Type as "decimal" is required. Enter valid data
	 * TC_69.
	 *
	 */

	@Test(dataProvider = "regularsignup")
	public void Custom_Field_As_Decimal_Valid_Data_Checked(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";
		String saleno1 = common.generateRandomNumber1();
		String customFiled1 = common.generateRandomChars(6);
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"To Verify that Custom field Type as decimal is required. Enter invalid data >> checked");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"To Verify that Custom field Type as decimal is required Enter invalid data >> checked");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.manage_Field_Registration_Settings();

		adminDashboardPage.customfieldsettingsdecimalcheckboxchecked(customFiled1);

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Custom_Field(FirstName, LastName, EmailUser, signUpUser);
		signupPage.regularSignupWithDecimalInvalidValuesMandatory(FirstName, LastName, EmailUser, signUpUser,
				customFiled1);

		driver.quit();
	}

	/**
	 * To Verify that Custom field Type as "Decimal" is required. Enter invalid data
	 * TC_70.
	 *
	 *
	 */

	@Test(dataProvider = "regularsignup")
	public void Custom_Field_As_Decimal_Invalid_Data_Checked(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";
		String saleno1 = common.generateRandomNumber1();
		String customFiled1 = common.generateRandomChars(6);
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"To Verify that Custom field Type as decimal is required. Enter invalid data >> Check box checked");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"To Verify that Custom field Type as decimal is required Enter invalid data >> Check box checked");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.manage_Field_Registration_Settings();

		adminDashboardPage.customfieldsettingsdecimalcheckboxchecked(customFiled1);

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Custom_Field(FirstName, LastName, EmailUser, signUpUser);
		signupPage.regularSignupWithDecimalInvalidValuesMandatory(FirstName, LastName, EmailUser, signUpUser,
				customFiled1);

		driver.quit();
	}

	/**
	 * To Verify that Custom field Type as "inputline" is required. Enter invalid
	 * data TC_71.
	 *
	 */

	@Test(dataProvider = "regularsignup")
	public void Custom_Field_As_Input_Line_Valid_Data(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";
		String saleno1 = common.generateRandomNumber1();
		String customFiled1 = common.generateRandomChars(6);
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"To Verify that Custom field Type as inputline is required Enter valid data");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"To Verify that Custom field Type as inputline is required Enter valid data.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.manage_Field_Registration_Settings();

		adminDashboardPage.customfieldsettingsinputline(customFiled1);

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Custom_Field(FirstName, LastName, EmailUser, signUpUser);
		signupPage.regularSignupWithInputlineValidValues(FirstName, LastName, EmailUser, signUpUser, customFiled1);

		driver.quit();
	}

	/**
	 * To Verify that Custom field Type as "inputline" is required. Enter invalid
	 * data TC_72
	 *
	 */

	@Test(dataProvider = "regularsignup")
	public void Custom_Field_As_Input_Line_Invalid_Data_Checked(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";
		String saleno1 = common.generateRandomNumber1();
		String customFiled1 = common.generateRandomChars(6);
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"To Verify that Custom field Type as inputline is required Enter valid data");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"To Verify that Custom field Type as inputline is required Enter valid data.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.manage_Field_Registration_Settings();

		adminDashboardPage.customfieldsettingsinputlinechecked(customFiled1);

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Custom_Field(FirstName, LastName, EmailUser, signUpUser);
		signupPage.regularSignupWithInputlineValidValuesManadatory(FirstName, LastName, EmailUser, signUpUser,
				customFiled1);

		driver.quit();

	}

	/**
	 * To Verify that Custom field Type as "inputline" is required. Enter blank
	 * TC_73.
	 *
	 */

	@Test(dataProvider = "regularsignup")
	public void Custom_Field_As_Input_Line_Data_Blank(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";
		String saleno = common.generateRandomNumber1();
		String customFiled1 = common.generateRandomChars(6);
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"To Verify that Custom field Type as inputline is required Enter blank");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(
				"Feature" + "-" + "UAT" + "\"To Verify that Custom field Type as inputline is required Enter blank.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.manage_Field_Registration_Settings();

		adminDashboardPage.customfieldsettingsinputlinechecked(customFiled1);

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Custom_Field(FirstName, LastName, EmailUser, signUpUser);
		signupPage.regularSignupWithInputlineInBlank(FirstName, LastName, EmailUser, signUpUser, customFiled1);

		driver.quit();

	}

	/**
	 * To Verify that Custom field Type as "Dropdown" is required. TC_74.
	 *
	 */

	@Test(dataProvider = "regularsignup")
	public void Custom_Field_As_Dropdown(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";
		String saleno = common.generateRandomNumber1();
		String customFiled1 = common.generateRandomChars(6);
		log("<br></br>Feature" + "-" + "UAT" + "\" To Verify that Custom field Type as Dropdown is required.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\" To Verify that Custom field Type as Dropdown is required.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.manage_Field_Registration_Settings();

		adminDashboardPage.customfieldsettingsdropdown(customFiled1);

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Custom_Field(FirstName, LastName, EmailUser, signUpUser);
		signupPage.regularSignupWithDropdown(FirstName, LastName, EmailUser, signUpUser, customFiled1);

		driver.quit();

	}

	/**
	 * To Verify that Custom field Type as "Dropdown" is required. TC_75.
	 *
	 */

	@Test(dataProvider = "regularsignup")
	public void Custom_Field_As_Dropdown_Checked(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";
		String saleno1 = common.generateRandomNumber1();
		String customFiled1 = common.generateRandomChars(6);
		log("<br></br>Feature" + "-" + "UAT"
				+ "\" To Verify that Custom field Type as Dropdown is required >> checked.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(
				"Feature" + "-" + "UAT" + "\" To Verify that Custom field Type as Dropdown is required >> checked.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.manage_Field_Registration_Settings();

		adminDashboardPage.customfieldsettingsdropdownchecked(customFiled1);

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Custom_Field(FirstName, LastName, EmailUser, signUpUser);
		signupPage.regularSignupWithDropdownMandatory(FirstName, LastName, EmailUser, signUpUser, customFiled1);

		driver.quit();

	}

	/**
	 * To Verify that Custom field Type as "Dropdown" is required Keep blank. TC_76.
	 *
	 */

	@Test(dataProvider = "regularsignup")
	public void Custom_Field_As_Dropdown_Keep_Blank(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";
		String saleno1 = common.generateRandomNumber1();
		String customFiled1 = common.generateRandomChars(6);
		log("<br></br>Feature" + "-" + "UAT"
				+ "\" To Verify that Custom field Type as Dropdown is required >> checked.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(
				"Feature" + "-" + "UAT" + "\" To Verify that Custom field Type as Dropdown is required >> checked.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.manage_Field_Registration_Settings();

		adminDashboardPage.customfieldsettingsdropdownchecked(customFiled1);

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Custom_Field(FirstName, LastName, EmailUser, signUpUser);
		signupPage.regularsignupWithDropdownBlank(FirstName, LastName, EmailUser, signUpUser, customFiled1);

		driver.quit();

	}

	/**
	 * To Verify that Custom field Type as "Date" is not required TC_77.
	 *
	 **/

	@Test(dataProvider = "regularsignup")
	public void Custom_Field_As_Date(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";
		String saleno1 = common.generateRandomNumber1();
		String customFiled1 = common.generateRandomChars(3);
		String tomorrowDate = common.tomorrowDate();
		log("<br></br>Feature" + "-" + "UAT" + "\"To Verify that Custom field Type as date");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To Verify that Custom field Type as date");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
		// page

		adminDashboardPage.manage_Field_Registration_Settings();

		adminDashboardPage.customfieldsettingsDate(customFiled1);

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Custom_Field(FirstName, LastName, EmailUser, signUpUser);
		signupPage.regularSignupWithDate(FirstName, LastName, EmailUser, signUpUser, customFiled1);

		driver.quit();

	}

	/**
	 * To Verify that Custom field Type as "Date" is required.TC_78
	 *
	 */

	@Test(dataProvider = "regularsignup")
	public void Custom_Field_As_Date_Checkbox_Required(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";
		String saleno1 = common.generateRandomNumber1();
		String customFiled1 = common.generateRandomChars(6);
		log("<br></br>Feature" + "-" + "UAT" + "\"To Verify that Custom field Type as textarea");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To Verify that Custom field Type as textarea");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
		// page

		adminDashboardPage.manage_Field_Registration_Settings();

		adminDashboardPage.customfieldsettingsDatecheckboxrequired(customFiled1);

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Custom_Field(FirstName, LastName, EmailUser, signUpUser);
		signupPage.regularSignupWithDateCheckboxRequired(FirstName, LastName, EmailUser, signUpUser, customFiled1);

		driver.quit();

	}

	/**
	 * To Verify that Custom field Type as "Date" is required blank.TC_79
	 *
	 */

	@Test(dataProvider = "regularsignup")
	public void Custom_Field_As_Date_Blank(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";
		String saleno1 = common.generateRandomNumber1();
		String customFiled1 = common.generateRandomChars(6);
		log("<br></br>Feature" + "-" + "UAT" + "\"To Verify that Custom field Type as textarea blank");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To Verify that Custom field Type as textarea blank");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
		// page

		adminDashboardPage.manage_Field_Registration_Settings();

		adminDashboardPage.customfieldsettingsDatecheckboxrequired(customFiled1);

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Custom_Field(FirstName, LastName, EmailUser, signUpUser);
		signupPage.regularSignupWithDateBlank(FirstName, LastName, EmailUser, signUpUser, customFiled1);

		driver.quit();

	}

	/**
	 * To Verify that Custom field Type as "Text Area" is not required TC_80.
	 *
	 */

	@Test(dataProvider = "regularsignup")
	public void Custom_Field_As_Textarea(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";
		String saleno1 = common.generateRandomNumber1();
		String customFiled1 = common.generateRandomChars(6);
		log("<br></br>Feature" + "-" + "UAT" + "\"To Verify that Custom field Type as textarea");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To Verify that Custom field Type as textarea");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.manage_Field_Registration_Settings();

		adminDashboardPage.customfieldsettingstextarea(customFiled1);

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Custom_Field(FirstName, LastName, EmailUser, signUpUser);
		signupPage.regularSignupWithTextareaNotRequired(FirstName, LastName, EmailUser, signUpUser, customFiled1);

		driver.quit();

	}

	/**
	 * To Verify that Custom field Type as "Text Area" is required TC_81.
	 *
	 */

	@Test(dataProvider = "regularsignup")
	public void Custom_Field_As_Textarea_Checked(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";
		String saleno1 = common.generateRandomNumber1();
		String customFiled1 = common.generateRandomChars(6);
		log("<br></br>Feature" + "-" + "UAT" + "\"To Verify that Custom field Type as textarea >> checked");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To Verify that Custom field Type as textarea >> checked");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.manage_Field_Registration_Settings();

		adminDashboardPage.customfieldsettingstextareachecked(customFiled1);

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Custom_Field(FirstName, LastName, EmailUser, signUpUser);
		signupPage.regularSignupWithTextareaIsRequired(FirstName, LastName, EmailUser, signUpUser, customFiled1);

		driver.quit();

	}

	/**
	 * To Verify that Custom field Type as "Text Area" is required TC_82.
	 *
	 */

	@Test(dataProvider = "regularsignup")
	public void Custom_Field_As_Text_Area_Checked_Keep_Blank(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";
		String saleno = common.generateRandomNumber1();
		String customFiled1 = common.generateRandomChars(6);
		log("<br></br>Feature" + "-" + "UAT" + "\"To Verify that Custom field Type as textarea blank >> checked");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To Verify that Custom field Type as textarea blank >> checked");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.manage_Field_Registration_Settings();

		adminDashboardPage.customfieldsettingstextareachecked(customFiled1);

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Custom_Field(FirstName, LastName, EmailUser, signUpUser);
		signupPage.regularSignupWithTextareaBlank(FirstName, LastName, EmailUser, signUpUser, customFiled1);

		driver.quit();

	}

	/**
	 * To Verify that Custom field Type as "checkbox" is not required TC_83.
	 *
	 */

	@Test(dataProvider = "regularsignup")
	public void Custom_Field_As_Checkbox(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";
		String saleno1 = common.generateRandomNumber1();
		String customFiled1 = common.generateRandomChars(6);
		log("<br></br>Feature" + "-" + "UAT" + "\"To Verify that Custom field Type as checkbox is not required.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To Verify that Custom field Type as checkbox is not required.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.manage_Field_Registration_Settings();

		adminDashboardPage.customfieldsettingscheckbox(customFiled1);

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Custom_Field(FirstName, LastName, EmailUser, signUpUser);
		signupPage.regularSignupWithCheckboxUncheck(FirstName, LastName, EmailUser, signUpUser, customFiled1);

		driver.quit();

	}

	/**
	 * To Verify that Custom field Type as "Check Box" is required TC_84.
	 * 
	 */

	@Test(dataProvider = "regularsignup")
	public void Custom_Field_As_Checkbox_Uncheck(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";
		String saleno1 = common.generateRandomNumber1();
		String customFiled1 = common.generateRandomChars(6);
		log("<br></br>Feature" + "-" + "UAT" + "\"To Verify that Custom field Type as checkbox uncheck.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To Verify that Custom field Type as checkbox unc.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.manage_Field_Registration_Settings();

		adminDashboardPage.customfieldsettingscheckboxchecked(customFiled1);

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Custom_Field(FirstName, LastName, EmailUser, signUpUser);
		signupPage.regularSignupWithCheckboxCheck(FirstName, LastName, EmailUser, signUpUser, customFiled1);

		driver.quit();

	}

	/**
	 * To Verify that Custom field Type as "Check Box" is required TC_85.
	 * 
	 **/

	@Test(dataProvider = "regularsignup")
	public void Custom_Field_As_Checkbox_Checked(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";
		String saleno1 = common.generateRandomNumber1();
		String customFiled1 = common.generateRandomChars(6);
		log("<br></br>Feature" + "-" + "UAT" + "\"To Verify that Custom field Type as checkbox required.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To Verify that Custom field Type as checkbox required.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.manage_Field_Registration_Settings();

		adminDashboardPage.customfieldsettingscheckboxchecked(customFiled1);

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Custom_Field(FirstName, LastName, EmailUser, signUpUser);
		signupPage.regularSignupWithCheckboxRequired(FirstName, LastName, EmailUser, signUpUser, customFiled1);

		driver.quit();

	}

	/**
	 * To Verify that Custom field Type as "File" is not required valid file TC_86.
	 * 
	 **/

	@Test(dataProvider = "regularsignup")
	public void Custom_Field_As_Pdf_Unchecked(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";
		String saleno1 = common.generateRandomNumber1();
		String customFiled1 = common.generateRandomChars(6);
		log("<br></br>Feature" + "-" + "UAT" + "\"To Verify that Custom field Type as file not required >> unchecked.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(
				"Feature" + "-" + "UAT" + "\"To Verify that Custom field Type as file not required >> unchecked.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile page
		adminDashboardPage.manage_Field_Registration_Settings();
		adminDashboardPage.customfieldsettingspdffileunchecked(customFiled1);
		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();
		signupPage.regular_SignUp_For_Custom_Field(FirstName, LastName, EmailUser, signUpUser);
		signupPage.regularSignupWithUploadPDFFile(FirstName, LastName, EmailUser, signUpUser, customFiled1);
		driver.quit();

	}

	/**
	 * To Verify that Custom field Type as "File" type is not required TC_87.
	 * 
	 **/

	@Test(dataProvider = "regularsignup")
	public void Custom_Field_As_Invalid_File(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";
		String saleno1 = common.generateRandomNumber1();
		String customFiled1 = common.generateRandomChars(6);
		log("<br></br>Feature" + "-" + "UAT" + "\"To Verify that Custom field Type as File type is not required.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out
				.println("Feature" + "-" + "UAT" + "\"To Verify that Custom field Type as File type is not required.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
		// page

		adminDashboardPage.manage_Field_Registration_Settings();

		adminDashboardPage.customfieldsettingsimagefile(customFiled1);

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Custom_Field(FirstName, LastName, EmailUser, signUpUser);
		signupPage.regularSignupWithUploadImageFile(FirstName, LastName, EmailUser, signUpUser, customFiled1);

		driver.quit();

	}

	/**
	 * To Verify that Custom field Type as "File Type" is required Invalid file
	 * TC_88.
	 * 
	 **/

	@Test(dataProvider = "regularsignup")
	public void Custom_Field_As_Invalid_File_Checked(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";
		String saleno1 = common.generateRandomNumber1();
		String customFiled1 = common.generateRandomChars(6);
		log("<br></br>Feature" + "-" + "UAT" + "\"To Verify that Custom field Type as File Type required >> checked.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(
				"Feature" + "-" + "UAT" + "\"To Verify that Custom field Type as File Type required >> checked.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
		// page

		adminDashboardPage.manage_Field_Registration_Settings();

		adminDashboardPage.customfieldsettingsimagefilechecked(customFiled1);

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Custom_Field(FirstName, LastName, EmailUser, signUpUser);
		signupPage.regularSignupWithUploadImageFile(FirstName, LastName, EmailUser, signUpUser, customFiled1);

		driver.quit();

	}

	/**
	 * To Verify that Custom field Type as "File Type" is required Valid file TC_89.
	 * 
	 **/

	@Test(dataProvider = "regularsignup")
	public void Custom_Field_As_Pdf_File_Checked_Required(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";
		String saleno1 = common.generateRandomNumber1();
		String customFiled1 = common.generateRandomChars(6);
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"To Verify that Custom field Type as File Type is required Valid file >> checked.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"To Verify that Custom field Type as File Type is required Valid file >> checked.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
															// profile
															// page

		adminDashboardPage.manage_Field_Registration_Settings();

		adminDashboardPage.customfieldsettingspdffilecheckboxrequired(customFiled1);

		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Custom_Field(FirstName, LastName, EmailUser, signUpUser);
		signupPage.regularSignupWithUploadPDFFile(FirstName, LastName, EmailUser, signUpUser, customFiled1);

		driver.quit();

	}

	/**
	 * Delete created Custom field
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 * 
	 * 
	 */

	public void Created_Last_Custom_Field(String adminUserName, String adminPassword)
			throws InterruptedException, ParseException

	{
		String customFiled1 = common.generateRandomChars(6);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.delete_Custom_Field(); // delete last created custom
													// field

		adminDashboardPage.adminLogout(); // Logout From Admin

	}

	// PAYPAL PAYAMENT METHOD SCRIPTS. //

	/**
	 * 
	 * To verify user is able to do payment of invoices from front end TC_01.
	 * 
	 * @throws IOException
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Paypal_Payment_Enable(String adminUserName, String adminPassword, String Uname, String password)
			throws InterruptedException, AWTException, ParseException, IOException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify user is able to do payment of invoices from front end.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(
				"Feature" + "-" + "UAT" + "\"To verify user is able to do payment of invoices from front end.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.paypalpayment_enable_settings();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		// loginPage.verifyLoginPageElements(); // Verify Login Page Elements
		dashboardPage = loginPage.loginUser(Uname, password);

		dashboardPage.paypalpayment_Enable();
		driver.quit();

	}

	/**
	 * 
	 * To verify user is not able to do payment of invoices from front end TC_02.
	 * 
	 * @throws IOException
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Paypal_Payment_Disable(String adminUserName, String adminPassword, String Uname, String password)
			throws InterruptedException, AWTException, ParseException, IOException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT"
				+ "\"To verify user is not able to do payment of invoices from front end.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(
				"Feature" + "-" + "UAT" + "\"To verify user is not able to do payment of invoices from front end.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.paypalpayment_disable_settings(); // Admin logout

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verifyLoginPageElements(); // Verify Login Page Elements
		dashboardPage = loginPage.loginUser(Uname, password);

		dashboardPage.paypalpayment_Disable();
		driver.quit();

	}

	/**
	 * 
	 * To verify user is not able to do payment of invoices from front end. TC_03.
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Paypal_Payment_Keep_Blank(String adminUserName, String adminPassword, String Uname, String password)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = Common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT"
				+ "\"To verify user is not able to do payment of invoices from front end.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(
				"Feature" + "-" + "UAT" + "\"To verify user is not able to do payment of invoices from front end.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.paypalpayment_KeepBlank_Settings();

		driver.quit();

	}

	/**
	 * 
	 * To verify user is able to buy credit TC_04.
	 * 
	 * @throws IOException
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Pay_Buy_Credit_Enable(String adminUserName, String adminPassword, String Uname, String password)
			throws InterruptedException, AWTException, ParseException, IOException {

		String FirstName = common.generateRandomChars(6);
		String LastName = Common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify user is able to buy credit.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify user is able to buy credit.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.pay_buy_credit_settings();

		adminDashboardPage.front(); // Logout From Admin

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		// loginPage.verifyLoginPageElements(); // Verify Login Page Elements
		dashboardPage = loginPage.loginUser(Uname, password);

		dashboardPage.paypal_Buy_Credit();
		driver.quit();

	}

	/**
	 * 
	 * To verify user is not able to buy credit TC_05.
	 * 
	 * @throws IOException
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Pay_Buy_Credit_Disable(String adminUserName, String adminPassword, String Uname, String password)
			throws InterruptedException, AWTException, ParseException, IOException {

		String FirstName = common.generateRandomChars(6);
		String LastName = Common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify user is not able to buy credit.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify user is not able to buy credit.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.pay_buy_credit_disable_settings();

		// adminDashboardPage.adminLogout(); // Logout From Admin

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verifyLoginPageElements(); // Verify Login Page Elements
		dashboardPage = loginPage.loginUser(Uname, password);

		dashboardPage.pay_Buy_Credit_Disable();
		driver.quit();

	}

	/**
	 * 
	 * To verify user is not able to buy credit TC_06.
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Pay_Buy_Credit_KeepBlank(String adminUserName, String adminPassword, String Uname, String password)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = Common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify user is not able to buy credit.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify user is not able to buy credit.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.pay_Buy_Credit_Keep_Blank_Settings();

	}

	/**
	 * 
	 * To verify user is able to do payment of invoices from front end TC_07.
	 * 
	 * @throws IOException
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Payment_Authorise_Net_Enable(String adminUserName, String adminPassword, String Uname, String password)
			throws InterruptedException, AWTException, ParseException, IOException {

		String FirstName = common.generateRandomChars(6);
		String LastName = Common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify user is able to do payment of invoices from front end.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(
				"Feature" + "-" + "UAT" + "\"To verify user is able to do payment of invoices from front end.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.payment_Authorise_Net_Settings();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		// loginPage.verifyLoginPageElements(); // Verify Login Page Elements
		dashboardPage = loginPage.loginUser(Uname, password);

		dashboardPage.payment_Authorize_Net_Enable();
		driver.quit();

	}

	/**
	 * 
	 * To verify user is not able to do payment of invoices from front end TC_08.
	 * 
	 * @throws IOException
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Payment_Authorise_Net_Disable_Frontend(String adminUserName, String adminPassword, String Uname,
			String password) throws InterruptedException, AWTException, ParseException, IOException {

		String FirstName = common.generateRandomChars(6);
		String LastName = Common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT"
				+ "\"To verify user is not able to do payment of invoices from front end.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(
				"Feature" + "-" + "UAT" + "\"To verify user is not able to do payment of invoices from front end.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.payment_Authorise_net_disable_settings();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verifyLoginPageElements(); // Verify Login Page Elements
		dashboardPage = loginPage.loginUser(Uname, password);

		dashboardPage.payment_Authorize_Net_Disable();
		driver.quit();

	}

	/**
	 * 
	 * To verify user is not able to do payment of invoices from front end TC_09.
	 * 
	 * @throws IOException
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Payment_Authorise_Net_Enable_Invalid_CC_Info(String adminUserName, String adminPassword, String Uname,
			String password) throws InterruptedException, AWTException, ParseException, IOException {

		String FirstName = common.generateRandomChars(6);
		String LastName = Common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT"
				+ "\"To verify user is not able to do payment of invoices from front end.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(
				"Feature" + "-" + "UAT" + "\"To verify user is not able to do payment of invoices from front end");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.payment_Authorise_Net_Settings();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verifyLoginPageElements(); // Verify Login Page Elements
		dashboardPage = loginPage.loginUser(Uname, password);

		dashboardPage.payment_Authorize_Net_Enable_Wrong_Detail();
		driver.quit();

	}

	/**
	 * 
	 * To verify user is not able to do payment of invoices from front end TC_10.
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Payment_Authorise_Net_Enable_Keep_Blank(String adminUserName, String adminPassword, String Uname,
			String password) throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = Common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT"
				+ "\"To verify user is not able to do payment of invoices from front end.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(
				"Feature" + "-" + "UAT" + "\"To verify user is not able to do payment of invoices from front end.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.payment_Authorise_Net_Keep_Blank_Settings();

	}

	/**
	 * 
	 * To verify admin is able to do payment of invoices from back end TC_11.
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Payment_Invoice_Backend(String adminUserName, String adminPassword, String Uname, String password)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = Common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify admin is able to do payment of invoices from back end.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(
				"Feature" + "-" + "UAT" + "\"To verify admin is able to do payment of invoices from back end.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.payment_Authorise_Net_Settings();
		adminDashboardPage.pending_Invoices();

	}

	/**
	 * 
	 * To verify admin is not able to do payment of invoices from back end TC_12.
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Payment_Invoice_Backend_Disable(String adminUserName, String adminPassword, String Uname,
			String password) throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = Common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT"
				+ "\"To verify admin is not able to do payment of invoices from back end.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(
				"Feature" + "-" + "UAT" + "\"To verify admin is not able to do payment of invoices from back end.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.payment_Authorise_Net_Settings_Disable(); // Authorise.net
																		// payment
																		// Disable

		adminDashboardPage.pending_Invoices_Button_Not_Display();

	}

	/**
	 * 
	 * To verify user is not able to do payment of invoices from back end. TC_13.
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Payment_Invoice_Backend_Enable_Invalid_Details(String adminUserName, String adminPassword, String Uname,
			String password) throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = Common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT"
				+ "\"To verify admin is not able to do payment of invoices from back end >> invalid details.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT"
				+ "\"To verify admin is not able to do payment of invoices from back end >> invalid details");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.payment_Authorise_Net_Settings(); // Authorise.net
																// payment
																// Disable

		adminDashboardPage.pending_invoices_button_invalidccinfo();

	}

	/**
	 * 
	 * To verify user is able to buy credit TC_15.
	 * 
	 * @throws IOException
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Buy_Credit_Authorise_Net(String adminUserName, String adminPassword, String Uname, String password)
			throws InterruptedException, AWTException, ParseException, IOException {

		String FirstName = common.generateRandomChars(6);
		String LastName = Common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify user is able to buy credit.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify user is able to buy credit.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.payment_Authorise_Net_Settings(); // Authorise.net
																// payment
																// Disable
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verifyLoginPageElements(); // Verify Login Page Elements
		dashboardPage = loginPage.loginUser(Uname, password);

		dashboardPage.buy_Credit_Authorise_Net_Success();
		driver.quit();

	}

	/**
	 * 
	 * To verify user is not able to buy credit TC_16.
	 * 
	 * @throws IOException
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Buy_Credit_Authorise_Net_Disable(String adminUserName, String adminPassword, String Uname,
			String password) throws InterruptedException, AWTException, ParseException, IOException {

		String FirstName = common.generateRandomChars(6);
		String LastName = Common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify user is not able to buy credit.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify user is not able to buy credit.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.payment_Authorise_Net_Disable(); // Authorise.net
															// payment
															// Disable
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verifyLoginPageElements(); // Verify Login Page Elements
		dashboardPage = loginPage.loginUser(Uname, password);

		dashboardPage.authorize_Button_Disable();
		driver.quit();

	}

	/**
	 * 
	 * To verify user is not able to buy credit. TC_17.
	 * 
	 * @throws IOException
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Buy_Credit_Authorise_Net_Invalid_CC(String adminUserName, String adminPassword, String Uname,
			String password) throws InterruptedException, AWTException, ParseException, IOException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify user is not able to buy credit.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify user is not able to buy credit.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.payment_Authorise_Net_All_Settings_Enable(); // Authorise.net
																		// payment
																		// Disable
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verifyLoginPageElements(); // Verify Login Page Elements
		dashboardPage = loginPage.loginUser(Uname, password);

		dashboardPage.buy_Credit_Invalid_CC();
		driver.quit();

	}

	// Bean Stream - Payment Method

	/**
	 * 
	 * Bean Stream Payment. TC_31.
	 * 
	 * @throws IOException
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Bean_Stream_Payment_Valid_CC(String adminUserName, String adminPassword, String Uname, String password)
			throws InterruptedException, AWTException, ParseException, IOException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify user should able to payment with bean stream.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify user should able to payment with bean steam.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.payment_BeanStream_Enable_CC(); // Bean
															// Stream
															// Enable
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(Uname, password);

		dashboardPage.bean_Stream_Invoice_Payment();
		dashboardPage.invoice_Payment_Success_Message(); // Verify Success
															// Message
		driver.quit();

	}

	// Bean Stream CC Not Active

	/**
	 * 
	 * To Bean Stream Disable. TC_32.
	 * 
	 * @throws IOException
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Bean_Stream_Payment_Valid_CC_Not_Active(String adminUserName, String adminPassword, String Uname,
			String password) throws InterruptedException, AWTException, ParseException, IOException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify user should not able to payment with bean stream.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify user should not able to payment with bean steam.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.payment_BeanStream_Disable_CC(); // Bean
		// Stream
		// Disable CC
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(Uname, password);

		dashboardPage.bean_Stream_Invoice_Payment_Disable(); // Bean_Stream
																// Button Not
																// Display
		driver.quit();

	}

	// Bean Stream CC Active - invalid CC

	/**
	 * 
	 * Bean Steam Invalid CC Number. TC_33.
	 * 
	 * @throws IOException
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Bean_Stream_Payment_Invalid_CC(String adminUserName, String adminPassword, String Uname,
			String password) throws InterruptedException, AWTException, ParseException, IOException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify user should able to payment with bean stream.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify user should able to payment with bean steam.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.payment_BeanStream_Enable_CC(); // Bean
															// Stream
															// Enable
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(Uname, password);

		dashboardPage.bean_Stream_Invoice_Payment_Invalid_CC();
		driver.quit();

	}

	// Bean Stream - Payment Method Not Setup

	/**
	 * 
	 * Bean Steam Payment Not setup. TC_34.
	 * 
	 * @throws IOException
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Bean_Stream_Payment_Notsetup(String adminUserName, String adminPassword, String Uname, String password)
			throws InterruptedException, AWTException, ParseException, IOException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify user should not able to payment with bean stream.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify user should not able to payment with bean steam.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.payment_BeanStream_NotSetup(); // Bean
															// Stream
															// Not Setup
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(Uname, password);

		dashboardPage.bean_Stream_Invoice_Payment();
		dashboardPage.bean_Stream_Invoice_Payment_AlertMessage(); // Verify
																	// Alert
																	// Message
		driver.quit();

	}

	// Bean Stream - Payment form BackEnd

	/**
	 * 
	 * Bean Steam Payment setup. TC_35.
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Bean_Stream_Payment_Backend(String adminUserName, String adminPassword, String Uname, String password)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify user should able to payment with bean stream. >> BackEnd");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(
				"Feature" + "-" + "UAT" + "\"To verify user should able to payment with bean steam. >> BackEnd");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.payment_BeanStream_Enable_CC(); // Bean
															// Stream
															// Setup

		adminDashboardPage.invoice_Payment_BackEnd();
		adminDashboardPage.bean_Stream_Payment_BackEnd_Active();
		driver.quit();

	}

	// Bean Stream not active- Payment form BackEnd

	/**
	 * 
	 * Bean Steam Payment setup. TC_36.
	 * 
	 * CC Disable
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Bean_Stream_Payment_Backend_Notactive(String adminUserName, String adminPassword, String Uname,
			String password) throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT"
				+ "\"To verify user should not able to payment with bean stream. >> BackEnd");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(
				"Feature" + "-" + "UAT" + "\"To verify user should not able to payment with bean steam. >> BackEnd");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.payment_BeanStream_Disable_CC(); // Bean
		// Stream
		// Setup

		adminDashboardPage.bean_Stream_Payment_BackEnd_Disable();

		driver.quit();

	}

	/**
	 * 
	 * Bean Steam Payment setup. TC_37.
	 * 
	 * Invalid CC Details
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Bean_Stream_Payment_Backend_Invalid_CC(String adminUserName, String adminPassword, String Uname,
			String password) throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT"
				+ "\"To verify user should not able to payment with bean stream. >> BackEnd");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(
				"Feature" + "-" + "UAT" + "\"To verify user should not able to payment with bean steam. >> BackEnd");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.payment_BeanStream_Enable_CC(); // Bean
															// Stream
															// Setup
		adminDashboardPage.enter_Invalid_CC_Details_User_Info();

		adminDashboardPage.bean_Stream_Payment_BackEnd_Active_Verify();

		driver.quit();

	}

	/**
	 * 
	 * Bean Steam Payment setup. TC_38.
	 * 
	 * valid CC Details
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Bean_Stream_Payment_Backend_Valid_CC(String adminUserName, String adminPassword, String Uname,
			String password) throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify user should able to payment with bean stream. >> BackEnd");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(
				"Feature" + "-" + "UAT" + "\"To verify user should able to payment with bean steam. >> BackEnd");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.payment_BeanStream_NotSetup(); // Bean
															// Stream
															// Setup
		adminDashboardPage.enter_Valid_CC_Details_User_Info();

		adminDashboardPage.bean_Stream_Payment_BackEnd_Active_Verify();

		driver.quit();

	}

	// Bean Stream - Buy Credit

	/**
	 * 
	 * Bean Stream Payment. TC_39.
	 * 
	 * @throws IOException
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Bean_Stream_Payment_Valid_CC_Buy_Credit(String adminUserName, String adminPassword, String Uname,
			String password) throws InterruptedException, AWTException, ParseException, IOException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify user should able to buy credit with bean stream.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify user should able to buy credit with bean stream.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.payment_BeanStream_Enable_CC(); // Bean
															// Stream
															// Enable
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(Uname, password);

		dashboardPage.pay_Through_Bean_Stream();
		dashboardPage.payment_Success_Message(); // Verify Success Message

		driver.quit();

	}

	/**
	 * 
	 * Bean Stream Payment. TC_40.
	 * 
	 * CC Disable
	 * 
	 * @throws IOException
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Bean_Stream_Payment_Valid_CC_Disable_Buy_Credit(String adminUserName, String adminPassword,
			String Uname, String password) throws InterruptedException, AWTException, ParseException, IOException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify user should not able to payment with bean stream.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify user should not able to payment with bean steam.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.payment_BeanStream_Disable_CC(); // Bean
		// Stream
		// Disable CC
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(Uname, password);

		dashboardPage.bean_Stream_Not_Display(); // Bean_stream_not_display

		driver.quit();

	}

	/**
	 * 
	 * Bean Stream Payment. TC_41.
	 * 
	 * Invalid CC
	 * 
	 * @throws IOException
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Bean_Stream_Payment_Invalid_CC_Buy_Credit(String adminUserName, String adminPassword, String Uname,
			String password) throws InterruptedException, AWTException, ParseException, IOException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify user should not able to payment with bean stream.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify user should not able to payment with bean steam.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.payment_BeanStream_Enable_CC(); // Bean
		// Stream
		// Enable
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(Uname, password);

		dashboardPage.bean_Stream_Invalid_CC_FrontEnd(); // Bean_stream_not_display

		driver.quit();

	}

	/**
	 * 
	 * Bean Stream Payment. TC_42. Bean Stream Not setup valid CC
	 * 
	 * @throws IOException
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Bean_Stream_Payment_Notsetup_Buy_Credit(String adminUserName, String adminPassword, String Uname,
			String password) throws InterruptedException, AWTException, ParseException, IOException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify user should not able to payment with bean stream.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify user should not able to payment with bean steam.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.payment_BeanStream_NotSetup(); // Bean
		// Stream
		// Enable
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(Uname, password);

		dashboardPage.pay_Through_Bean_Stream();
		dashboardPage.beanstream_Error_Message(); // Verify Error Message

		driver.quit();

	}

	// PAY TRACE PAYMENT METHOD

	/**
	 * 
	 * PayTrace Payment. TC_43.
	 * 
	 * @throws IOException
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Pay_Trace_Payment_Valid_CC(String adminUserName, String adminPassword, String Uname, String password)
			throws InterruptedException, AWTException, ParseException, IOException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify user should able to payment with Pay Trace.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify user should able to payment with Pay Trace.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.payment_PayTrace_Enable_CC(); // Pay Trace Enable
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(Uname, password);

		dashboardPage.payTrace_Invoice_Payment();
		dashboardPage.invoice_Payment_Success_Message(); // Verify Success
															// Message
		driver.quit();

	}

	/**
	 * 
	 * PayTrace Payment. TC_44.
	 * 
	 * CC Disable
	 * 
	 * @throws IOException
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Pay_Trace_Payment_Disable_CC(String adminUserName, String adminPassword, String Uname, String password)
			throws InterruptedException, AWTException, ParseException, IOException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify user should not able to payment with Pay Trace.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify user should not able to payment with Pay Trace.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.payment_PayTrace_Disable_CC(); // Pay Trace Enable
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(Uname, password);

		dashboardPage.payTrace_Invoice_Payment_Button_Disable(); // Verify
																	// Success
																	// PayTrace
																	// Button
																	// Not
																	// Display
		driver.quit();

	}

	/**
	 * 
	 * PayTrace Invalid CC Number. TC_45.
	 * 
	 * @throws IOException
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void PayTrace_Payment_Invalid_CC(String adminUserName, String adminPassword, String Uname, String password)
			throws InterruptedException, AWTException, ParseException, IOException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify user should not able to payment with paytrace.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify user should not able to payment with paytrace.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.payment_PayTrace_Enable_CC(); // PayTrace
															// Enable
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(Uname, password);

		dashboardPage.payTrace_Invoice_Payment_Invalid_CC(); // Verify Error
																// Message
		driver.quit();

	}

	/**
	 * 
	 * PayTrace Payment Not setup. TC_46.
	 * 
	 * @throws IOException
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void PayTrace_Payment_Notsetup(String adminUserName, String adminPassword, String Uname, String password)
			throws InterruptedException, AWTException, ParseException, IOException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify user should not able to payment with Pay Trace.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify user should not able to payment with PayTrace.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.payment_PayTrace_Notsetup(); // PayTrace
														// Not Setup
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(Uname, password);

		dashboardPage.payTrace_Invoice_Payment();
		dashboardPage.payTrace_Invoice_Payment_AlertMessage(); // Verify
																// Alert
																// Message
		driver.quit();

	}

	/**
	 * 
	 * PayTrace Payment BackEnd. TC_47.
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void PayTrace_Payment_Backend(String adminUserName, String adminPassword, String Uname, String password)
			throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify user should able to payment with PayTrace >> BackEnd");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out
				.println("Feature" + "-" + "UAT" + "\"To verify user should able to payment with PayTrace >> BackEnd");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.payment_PayTrace_Enable_CC(); // Pay
															// Trace
															// Setup

		adminDashboardPage.payment_PayTrace_BackEnd_Active();
		driver.quit();

	}

	/**
	 * 
	 * PayTrace Payment BackEnd. TC_48. CC Disable
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void PayTrace_Payment_Backend_Disable_CC(String adminUserName, String adminPassword, String Uname,
			String password) throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify user should not able to payment with PayTrace >> BackEnd");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(
				"Feature" + "-" + "UAT" + "\"To verify user should not able to payment with PayTrace >> BackEnd");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.payment_PayTrace_Disable_CC(); // Pay
															// Trace
															// Setup
		adminDashboardPage.payment_PayTrace_BackEnd_Disable();
		driver.quit();

	}

	/**
	 * 
	 * Bean Steam Payment setup. TC_49.
	 * 
	 * Invalid CC Details
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Paytrace_Payment_Backend_Invalid_CC(String adminUserName, String adminPassword, String Uname,
			String password) throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify user should not able to payment with PayTrace. >> BackEnd");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(
				"Feature" + "-" + "UAT" + "\"To verify user should not able to payment with PayTrace. >> BackEnd");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.payment_PayTrace_Enable_CC(); // PayTrace Payment
															// SetUp
		adminDashboardPage.enter_Invalid_CC_Details_User_Info();

		adminDashboardPage.payment_PayTrace_BackEnd_Active_Verify();

		driver.quit();

	}

	/**
	 * 
	 * Bean Steam Payment setup. TC_50.
	 * 
	 * Invalid CC Details
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Paytrace_Payment_Backend_Blank(String adminUserName, String adminPassword, String Uname,
			String password) throws InterruptedException, AWTException, ParseException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify user should not able to payment with PayTrace. >> BackEnd");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println(
				"Feature" + "-" + "UAT" + "\"To verify user should not able to payment with PayTrace. >> BackEnd");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.payment_PayTrace_Notsetup(); // PayTrace Payment
														// SetUp

		adminDashboardPage.payment_PayTrace_BackEnd_Active_Verify();

		driver.quit();

	}

	/**
	 * 
	 * PayTrace Payment. TC_51.
	 * 
	 * @throws IOException
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Pay_Trace_Payment_Valid_CC_Buy_Credit(String adminUserName, String adminPassword, String Uname,
			String password) throws InterruptedException, AWTException, ParseException, IOException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify user should able to buy credit with PayTrace.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify user should able to buy credit with PayTrace.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.payment_PayTrace_Enable_CC(); // Bean
															// Stream
															// Enable
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(Uname, password);

		dashboardPage.pay_Through_PayTrace(); // Buy Credit Through PayTrace
		dashboardPage.payment_Success_Message(); // Verify Success Message

		driver.quit();

	}

	/**
	 * 
	 * PayTrace Payment. TC_52.
	 * 
	 * @throws IOException
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Pay_Trace_Payment_Valid_CC_Buy_Credit_Disable(String adminUserName, String adminPassword, String Uname,
			String password) throws InterruptedException, AWTException, ParseException, IOException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify user should not able to buy credit with PayTrace.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify user should not able to buy credit with PayTrace.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.payment_PayTrace_Disable_CC();// Bean
															// Stream
															// Enable
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(Uname, password);

		dashboardPage.payTrace_Not_Display(); // PayTrace Button Not Display

		driver.quit();

	}

	/**
	 * 
	 * PayTrace Payment. TC_53.
	 * 
	 * @throws IOException
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Pay_Trace_Payment_Invalid_CC_Buy_Credit(String adminUserName, String adminPassword, String Uname,
			String password) throws InterruptedException, AWTException, ParseException, IOException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify user should not able to buy credit with PayTrace.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify user should not able to buy credit with PayTrace.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.payment_PayTrace_Enable_CC(); // Bean
															// Stream
															// Enable
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(Uname, password);

		dashboardPage.payTrace_Invalid_CC_FrontEnd(); // Verify Alert Message

		driver.quit();

	}

	/**
	 * 
	 * PayTrace Payment. TC_54.
	 * 
	 * @throws IOException
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Pay_Trace_Payment_NotSetup_Buy_Credit(String adminUserName, String adminPassword, String Uname,
			String password) throws InterruptedException, AWTException, ParseException, IOException {

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		log("<br></br>Feature" + "-" + "UAT" + "\"To verify user should not able to buy credit with PayTrace.");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"To verify user should not able to buy credit with PayTrace.");
		System.out.println("-----------------------------------------------------------------------------------");
		log("<br></br> Step 1 : Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.payment_PayTrace_Notsetup(); // Bean
		// Stream
		// Enable
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(Uname, password);

		dashboardPage.pay_Through_PayTrace();
		dashboardPage.payTrace_Invoice_Payment_AlertMessage(); // Verify Error
																// Message

		driver.quit();

	}

//	@AfterTest(alwaysRun = true)
//	 public void endReport(){
//	 // writing everything to document
//	 //flush() - to write or update test information to your report. 
//		extent.endTest(logger);
//	                extent.flush();
//	                //Call close() at the very end of your session to clear all resources. 
//	                //If any of your test ended abruptly causing any side-affects (not all logs sent to ExtentReports, information missing), this method will ensure that the test is still appended to the report with a warning message.
//	                //You should call close() only once, at the very end (in @AfterSuite for example) as it closes the underlying stream. 
//	                //Once this method is called, calling any Extent method will throw an error.
//	                //close() - To close all the operation
//	                extent.close();
//	                
//	    }

	@DataProvider(name = "login")
	public Object[][] getLogin() throws Exception {

		Object[][] retObjectArr = parseCsv();

		return retObjectArr;

	}

	/**
	 * Data Provider for Signup Feature
	 * 
	 * @return
	 * @throws Exception
	 */
	@DataProvider(name = "signup")
	public Object[][] getSignup() throws Exception {

		Object[][] retObjectArr = parseSignUpCsv();

		return retObjectArr;

	}

	/**
	 * Data Provider for Regular Signup Feature
	 * 
	 * @return
	 * @throws Exception
	 */
	@DataProvider(name = "regularsignup")
	public Object[][] getRegularSignup() throws Exception {

		Object[][] retObjectArr = parseRegularSignupCsv();

		return retObjectArr;

	}

	/**
	 * Data Provider :: Create new auction
	 * 
	 * @return
	 * @throws Exception
	 */

	@DataProvider(name = "createauction")
	public Object[][] getCreateAuction() throws Exception {

		Object[][] retObjectArr = parsecreateauctionCsv();

		return retObjectArr;
	}

}
