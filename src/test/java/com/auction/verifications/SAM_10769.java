package com.auction.verifications;

import java.awt.AWTException;

import java.text.ParseException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.auction.admin.pages.AdminDashboardPage;
import com.auction.admin.pages.LotVerificationPage;
import com.auction.init.Common;
import com.auction.init.ConfigFileReader;
import com.auction.init.SeleniumInit;
import com.auction.pages.DashboardPage;
import com.auction.pages.SignupPage;

public class SAM_10769 extends SeleniumInit {

	// String saleno = null;
	// String auctionName = null;
	String lotName = null;
	String uName = null;
	String bidder2 = "rahulbid";
	String bidder2Pass = "123123a";
	Common common = new Common(driver);
	ConfigFileReader configFileReader = new ConfigFileReader();
	// SignupPage signupPage = new SignupPage(driver);

	/**
	 * Created Testcase for ticket no-10924 to 10930 in SAM_10891
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	// 1 SAM_11131
	@Test(dataProvider = "missedliveauction")
	public void verify_Check_Simplified_Sign_Up_Page_Options(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Create All fields filled out Feature,TestCase Name: 3 Check Simplified Sign up page options.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getdev_auctionUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyUncheckedSimplifiedSignupCheckbox();
		adminDashboardPage.adminLogout();
		signupPage = adminDashboardPage.goto_FrontEnd();
		signupPage.verify_Check_Simplified_Sign_up_page_options();

	}

	// 2 SAM-11133
	@Test(dataProvider = "missedliveauction")
	public void verify_Check_The_Alert_Tab_At_Sign_Up_Page(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Create All fields filled out Feature,TestCase Name: 3 Check alert tab at signup page.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getdev_auctionUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyIncludeUserPreferencesCheckboxChecked();
		adminDashboardPage.adminLogout();
		signupPage = adminDashboardPage.goto_FrontEnd();
		signupPage.verify_Check_the_Alert_Tab_at_Sign_Up_Page();

	}

	// 3 SAM-11134
	@Test(dataProvider = "missedliveauction")
	public void verify_Check_Trying_Sign_Up_New_User(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Create All fields filled out Feature,TestCase Name: 3 UnCheck Simplified Sign up page options.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getdev_auctionUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		adminDashboardPage.delete_Custom_Field();
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.verifyUncheckedSimplifiedSignupCheckbox();
		adminDashboardPage.adminLogout();
		signupPage = adminDashboardPage.goto_FrontEnd();
		signupPage.regularSignUp(FirstName,LastName,EmailUser,signUpUser);

	}

//////////////////////////////////////////////////////////////////
	/**
	 * Data Provider :: Live Missing Fields Auction
	 * 
	 * @return
	 * @throws Exception
	 */
	@DataProvider(name = "missedliveauction")
	public Object[][] getMissedLiveAuction() throws Exception {

		Object[][] retObjectArr = parsemissedliveauctionCsv();

		return retObjectArr;
	}

}