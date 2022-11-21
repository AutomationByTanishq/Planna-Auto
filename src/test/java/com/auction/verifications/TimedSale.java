package com.auction.verifications;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.auction.admin.pages.LiveSaleAuction;
import com.auction.init.Common;
import com.auction.init.ConfigFileReader;
import com.auction.init.SeleniumInit;
import com.auction.pages.DashboardPage;

public class TimedSale extends SeleniumInit {

	Common common = new Common(driver);

	String Uname = "rahulqa";
	String Password = "123123a";
	ConfigFileReader configFileReader = new ConfigFileReader();

	/**
	 * 
	 * Verify Sale Number Missing All_Other_Fields_Empty
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Sale_Number_Missing(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Create Sale number missing Feature,TestCase Name: 4.1 Sale number missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifySaleNumberMissingForTimedType(Name); // verify
																		// sale
																		// number
																		// missing
																		// timed
																		// type
		// SALE NO IS GENERATED AUTOMATICALLY
	}

	/**
	 * Verify Start date Missing
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Start_Date_Missing(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Create Start date missing Feature,TestCase Name: 4.2 Start date missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyStartdateMissingForTimedType(); // verify start
																	// date
																	// missiing
																	// timed
																	// type

	}

	/**
	 * Verify End date Missing
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void End_Date_Missing(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Create End date missing Feature,TestCase Name: 4.3 End date missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyEnddateMissingForTimedType(); // verify end
																// date missing
																// timeed tyoe

	}

	/**
	 * Verify All other fields empty
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void All_Other_Fields_Empty(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"All other fields empty Feature,TestCase Name: 4.4 All other fields empty Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyAllotherfieldsemptyForTimedType();

	}

	/**
	 * Create Auction with All fields filled out
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void All_Fields_Filled_Out(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		String tomorrowDate = common.tomorrowDate();
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Create All fields filled out Feature,TestCase Name: 4.5 Create All fields filled out Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.create_Timed_Auction(saleno);

	}

	/**
	 * Verify start date in the past
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Start_Date_In_The_Past(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"start date in the past Feature,TestCase Name: 4.6 start date in the past Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String timedauction = adminDashboardPage.verifyStartDateInThePastForTimedType();

		adminDashboardPage.front();

		// User login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(Uname, Password);
		dashboardPage.verify_Start_Date_Timedsale_Auction_Status_Past(timedauction);

	}

	/**
	 * Verify start date in the future
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Start_Date_In_The_Future(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"start date in the future Feature,TestCase Name: 4.7 start date in the future Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String timedauction = adminDashboardPage.verifystartdateinthefutureForTimedType();

		adminDashboardPage.front();

		// User login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(Uname, Password);
		dashboardPage.verify_Timed_Auction_Status_Feature(timedauction); // Verify
																			// Timed
																			// Auction
																			// Status

	}

	/**
	 * Verify end date in the past
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void End_Date_In_The_Past(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"end date in the past Feature,TestCase Name: 4.8 end date in the past Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String timedauction = adminDashboardPage.verifyenddateinthepastForTimedType(); // verify
																						// end
		// date in
		// the past
		// for timed
		// type

		adminDashboardPage.front();

		// User login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(Uname, Password);
		dashboardPage.verify_End_Date_Timedsale_Auction_Status_Past(timedauction); // Verify
		// Timed
		// Auction
		// Status

	}

	/**
	 * Verify end date in the past
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Staggered_None(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"staggered none Feature,TestCase Name: 4.9 staggered none Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.auctionForTimedType();

		adminDashboardPage.addLotRandom3(3);

		adminDashboardPage.verifyEndDate();

	}

	/**
	 * staggered = 1min and lots per interval = 1
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Stagged1_Min_Lots_Interval1(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"start date in the future Feature,TestCase Name : 4.10 staggered = 1min and lots per interval = 1");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String timedauction = adminDashboardPage.Stagged_Time_Interval1();

		// Add Multiple lots

		String addlot1 = adminDashboardPage.add_Lot_Staggered_Closing(1);
		String addlot2 = adminDashboardPage.add_Lot_Staggered_Closing(1);
		String addlot3 = adminDashboardPage.add_Lot_Staggered_Closing(1);
		String addlot4 = adminDashboardPage.add_Lot_Staggered_Closing(1);
		String addlot5 = adminDashboardPage.add_Lot_Staggered_Closing(1);
		String addlot6 = adminDashboardPage.add_Lot_Staggered_Closing(1);
		adminDashboardPage.approveBidder1();
		adminDashboardPage.front();

		// User login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(Uname, Password);
		dashboardPage.verify_Lot_Time_Left(timedauction, addlot1, addlot2, addlot3, addlot4, addlot5, addlot6);

	}

	/**
	 * staggered = 1min and lots per interval = 3
	 * 
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Stagged1_Min_Lots_Interval3(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"start date in the future Feature,TestCase Name : 4.11 staggered = 1min and lots per interval = 3");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String timedauction = adminDashboardPage.stagged_Time_Interval3();

		// Add Multiple lots

		String addlot1 = adminDashboardPage.add_Lot_Staggered_Closing(1);
		String addlot2 = adminDashboardPage.add_Lot_Staggered_Closing(1);
		String addlot3 = adminDashboardPage.add_Lot_Staggered_Closing(1);
		String addlot4 = adminDashboardPage.add_Lot_Staggered_Closing(1);
		String addlot5 = adminDashboardPage.add_Lot_Staggered_Closing(1);
		String addlot6 = adminDashboardPage.add_Lot_Staggered_Closing(1);
		adminDashboardPage.approveBidder1();
		adminDashboardPage.front();

		// User login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(Uname, Password);
		dashboardPage.verify_Lot_Time_Left(timedauction, addlot1, addlot2, addlot3, addlot4, addlot5, addlot6);

	}

	/**
	 * staggered = 5min and lots per interval = 1
	 * 
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Stagged5_Min_Lots_Interval1(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"start date in the future Feature,TestCase Name : 4.12 staggered = 5min and lots per interval = 1");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String timedauction = adminDashboardPage.Stagged5_Time_Interval1();

		// Add Multiple lots

		String addlot1 = adminDashboardPage.add_Lot_Staggered_Closing(1);
		String addlot2 = adminDashboardPage.add_Lot_Staggered_Closing(1);
		String addlot3 = adminDashboardPage.add_Lot_Staggered_Closing(1);
		String addlot4 = adminDashboardPage.add_Lot_Staggered_Closing(1);
		String addlot5 = adminDashboardPage.add_Lot_Staggered_Closing(1);
		String addlot6 = adminDashboardPage.add_Lot_Staggered_Closing(1);
		adminDashboardPage.approveBidder1();
		adminDashboardPage.front();

		// User login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(Uname, Password);
		dashboardPage.verify_Lot_Time_Left(timedauction, addlot1, addlot2, addlot3, addlot4, addlot5, addlot6);

	}

	/**
	 * staggered = 5min and lots per interval = 3
	 * 
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Stagged5_Min_Lots_Interval3(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"start date in the future Feature,TestCase Name : 4.13 staggered = 1min and lots per interval = 3");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String timedauction = adminDashboardPage.stagged5_Time_Interval3();

		// Add Multiple lots

		String addlot1 = adminDashboardPage.add_Lot_Staggered_Closing(1);
		String addlot2 = adminDashboardPage.add_Lot_Staggered_Closing(1);
		String addlot3 = adminDashboardPage.add_Lot_Staggered_Closing(1);
		String addlot4 = adminDashboardPage.add_Lot_Staggered_Closing(1);
		String addlot5 = adminDashboardPage.add_Lot_Staggered_Closing(1);
		String addlot6 = adminDashboardPage.add_Lot_Staggered_Closing(1);
		adminDashboardPage.approveBidder1();
		adminDashboardPage.front();

		// User login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(Uname, Password);
		dashboardPage.verify_Lot_Time_Left(timedauction, addlot1, addlot2, addlot3, addlot4, addlot5, addlot6);

	}

	/**
	 * higher than allowed max Feature
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Higher_Than_Allowed_Max(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		String tomorrowDate = common.tomorrowDate();
		String strsale = common.generateRandomNumber1();
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"higher than allowed max Feature,TestCase Name: 3.14 higher than allowed max Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verifyhigherthanallowedmaxForTimedSale(tomorrowDate, "1", "2147483648");

		// Bug : Incorrect Warning message and 2147483647 is not accepted
	}

	/**
	 * create live auction 1
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Create_Timed_Auction1(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"create live auction 1 Feature,TestCase Name: 4.15 create timed auction 1 Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.create_Timed_Auction(saleno);// Create Timed Auction

	}

	/**
	 * create Timed auction 2
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Create_Timed_Auction2(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		log("<br></br>Feature" + "-" + "UAT"
				+ "\"create live auction 2 Feature,TestCase Name: 4.16 create timed auction 2 Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.create_Timed_Auction(saleno);// Create Timed Auction

	}

	/**
	 * create Timed auction 3
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Create_Timed_Auction3(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"create live auction 3 Feature,TestCase Name: 4.17 create timed auction 3 Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.create_Timed_Auction(saleno);// Create Timed Auction

	}

	/**
	 * create timed auction 4
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Create_Timed_Auction4(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"create live auction 4 Feature,TestCase Name: 4.18 create timed auction 4 Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.create_Timed_Auction(saleno);// Create Timed Auction

	}

	/**
	 * Create first group
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Create_First_Group(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		String saleno1 = common.generateRandomNumber1();
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Create first group Feature,TestCase Name: 4.19 Create first group Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auctionurl = adminDashboardPage.create_Timed_Auction_Return_URL(saleno); // Create
																						// Timed
																						// Auction

		adminDashboardPage.verifyClickEditLink(saleno);
	}

	/**
	 * default sale group value is N/A
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Default_Sale_Group_Value(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		log("<br></br>Feature" + "-" + "UAT"
				+ "\"default sale group value is N/A Feature,TestCase Name: 4.20 default sale group value is N/A Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.create_Timed_Auction(saleno);
		adminDashboardPage.verifyDefaultSaleGroupValueForTimedSale(); // verify
																		// default
																		// sale
																		// group
																		// value
																		// for
																		// time
																		// sale

	}

	/**
	 * Click edit link
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Click_Edit_Link(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		String tomorrowDate = common.tomorrowDate();
		String saleno1 = common.generateRandomNumber1();
		String saleno2 = common.generateRandomNumber1();
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Click edit link Feature,TestCase Name: 4.21 Click edit link Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno = adminDashboardPage.create_Timed_Auction(saleno1);

		adminDashboardPage.create_Timed_Auction(saleno2);

		adminDashboardPage.verifyEditLink(saleno1);

	}

	/**
	 * Click edit link select another sale update Feature
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Click_Edit_Link_Select_Another_Sale_Update(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		String saleno1 = common.generateRandomNumber1();
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Click edit link select another sale update Feature,TestCase Name: 4.22 Click edit link select another sale update Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String sale = adminDashboardPage.create_Timed_Auction(saleno);
		adminDashboardPage.create_Timed_Auction(saleno1);
		adminDashboardPage.verifyGroupNameMissing(saleno1);

	}

	/**
	 * Verify Cancel Group Feature
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Verify_Cancel(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Verify Cancel Group Feature,TestCase Name: 4.24 Verify Cancel Group Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String time = adminDashboardPage.create_Timed_Auction(saleno);
		adminDashboardPage.verify_Cancel("Perfect QA Group1", saleno);

	}

	/**
	 * Verify Cancel Sale Group Feature
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Verify_Cancel_SaleGroup(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Verify Cancel sale Group Feature,TestCase Name: 4.25 Verify Cancel sale Group Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String AuctionID = adminDashboardPage.create_Timed_Auction(saleno);
		adminDashboardPage.verifyClickEditLink(saleno);
		adminDashboardPage.cancelSaleGroup(saleno);

	}

	/**
	 * Enter a name longer than the max length
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Enter_a_Name_Longer_Than_The_Max_length(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		String tomorrowDate = common.tomorrowDate();
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Enter a name longer than the max length Feature,TestCase Name: 4.26 Enter a name longer than the max length Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verify_Max_Length_Timedsale(); // verify Max length
															// of
		// first name
	}

	/**
	 * Enter a name with special characters
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Enter_a_Name_With_Special_Characters(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		String tomorrowDate = common.tomorrowDate();
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Enter a name with special characters Feature,TestCase Name: 3.27 Enter a name with special characters Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verifyNameWithSpecialCharForTimed(); // verify name
																// with special
																// character
	}

	/**
	 * Enter a Description with special characters
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Enter_a_Description_With_Special_Characters(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		String tomorrowDate = common.tomorrowDate();
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Enter Description with special characters Feature,TestCase Name: 4.28 Enter Description with special characters Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verifyDescriptionWithSpecialCharForTimedSale();
	}

	/**
	 * Enter a description and enhance the text
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Enter_a_Description_and_Enhance_The_Text(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		String tomorrowDate = common.tomorrowDate();
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Enter a description and enhance the text Feature,TestCase Name: 4.29 Enter a description and enhance the text Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verifyDescriptionWithSpecialChar1ForTimedSale(); // verify
																			// description
																			// with
																			// special
																			// character
	}

	/**
	 * Correctly populated from the settings by default
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Correctly_Populated_From_The_Settings_By_Default(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {
		String tomorrowDate = common.tomorrowDate();
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Correctly populated from the settings by default Feature,TestCase Name: 4.30 Correctly populated from the settings by default Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verifySettingByDefault(); // verify Setting By
														// Default

	}

	/**
	 * Enter a Terms and condition with special characters
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Enter_a_Terms_and_Condition_With_Special_Characters(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {
		String tomorrowDate = common.tomorrowDate();
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Enter Terms and condition with special characters Feature,TestCase Name: 4.31 Enter Terms and condition with special characters Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verifyTermsAndConditionForTimedSale(); // verify
																	// h\the
																	// term and
																	// condition
																	// for
																	// particular
																	// time sale
	}

	/**
	 * Enter a Terms and condition and enhance the text
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Enter_a_Terms_and_Condition_and_Enhance_The_Text(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {
		String tomorrowDate = common.tomorrowDate();
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Enter a Terms and condition and enhance the text Feature,TestCase Name: 4.32 Enter a Terms and condition and enhance the text Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.termsAndConditionForTimedSale(); // verify h\the term
															// and condition for
															// particular time
															// sale
	}

	/**
	 * Verify Upload a picture save the sale Feature
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Upload_a_Picture_Save_The_Sale(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Verify Upload a picture save the sale Feature,TestCase Name: 4.33 Verify Upload a picture save the sale Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyUploadPictureForTimedSale(); // verify upload
																// rΩ for time
																// scale

	}

	/**
	 * Do not upload a picture
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Do_Not_Upload_a_Picture(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Do not upload a picture Feature,TestCase Name: 4.34 Do not upload a picture Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyDoNotUploadPictureForTimedSale1(); // verify upload
		// picture for
		// time sale

	}

	/**
	 * upload a picture remove the existing picture
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Upload_a_Picture_Remove_The_Existing_Picture(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		String saleno = common.generateRandomNumber1();

		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Upload a picture remove the existing picture Feature,TestCase Name: 4.35 Upload a picture remove the existing picture Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyUploadPictureForTimedSaleAuction(); // verify upload
		// picture and
		// remove
		// existing
		common.log("<br></br> Delete Picture option is not available.");
		// Delete picture option is not available in info tab

	}

	/**
	 * Leave checkbox unchecked save
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Leave_Checkbox_Unchecked_Save(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Leave checkbox unchecked save Feature,TestCase Name: 4.36 Leave checkbox unchecked save Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String name = adminDashboardPage.createNewAuctionForTimedSaleUnpublish(saleno);

		adminDashboardPage.front(); // Open Front End
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password); // Login with
																// valid
																// credentials

		dashboardPage.verify_Timed_Auction_Not_Dispaly(name); // Verify Timed
																// Auction not
																// display.

	}

	/**
	 * check the checkbox save
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Check_The_Check_Box_Save(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"check the checkbox save Feature,TestCase Name: 4.37 check the checkbox save Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String name = adminDashboardPage.allFieldsFillForTimedSalePublish(saleno);

		adminDashboardPage.front(); // Open Front End
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password); // Login with
																// valid
																// credentials
		dashboardPage.verify_Timed_Auction_Present(name); // Verify Timed
															// Auction display.

	}

	/**
	 * Uncheck the option for an already published auction
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Uncheck_The_Option_For_an_already_Published_Auction(String adminUserName, String adminPassword,
			String UName, String password) throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Uncheck the option for an already published auction Feature,TestCase Name: 4.38 uncheck the option for an already published auction Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auctionName = adminDashboardPage.allFieldsFillForTimedSalePublish(saleno);

		adminDashboardPage.front(); // Open Front End
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password); // Login with
																// valid
																// credentials

		dashboardPage.verify_Timed_Auction_Present(auctionName);

		driver.get(configFileReader.getqa_MainAutoAdmin()); 

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.unpublishAuction(saleno);

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password); // Login with
		// valid
		// credentials

		dashboardPage.verify_Timed_Auction_Not_Dispaly_Frontend(auctionName);

	}

	/**
	 * Check the option for a previously unpublished auction
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Check_The_Option_For_a_Previously_Unpublished_Auction(String adminUserName, String adminPassword,
			String UName, String password) throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Check the option for a previously unpublished auction Feature,TestCase Name: 4.39 Check the option for a previously unpublished auction Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String name = adminDashboardPage.createNewAuctionForTimedSaleUnpublish(saleno);

		adminDashboardPage.front(); // Open Front End
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password); // Login with
																// valid
																// credentials

		dashboardPage.verify_Timed_Auction_Not_Dispaly(name); // Verify Timed
																// Auction not
																// display.

		// adminDashboardPage.FrontLogOut();
		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.publishAuction(saleno);

		adminDashboardPage.front(); // Open Front End
		loginPage = indexPage.clickOnLoginLink(); // click on login link

		dashboardPage = loginPage.loginUser(UName, password); // Login with
																// valid
																// credentials

		dashboardPage.verify_Timed_Auction_Present_At_Frontend(name); // Timed auction
		// display

	}

	/**
	 * Leave checkbox unchecked save
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Leave_Checkbox_Unchecked_Save1(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Leave checkbox unchecked save Feature,TestCase Name: 4.40 Leave checkbox unchecked save Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.disable_Lot_Upload_For_Consignor_Settings();
		String name = adminDashboardPage.allFieldsFillForTimedSalePublish(saleno);

		//adminDashboardPage.enable_Available_Consignor_Upload_Auc_Setting();

		adminDashboardPage.front(); // Open Front End
		loginPage = indexPage.clickOnLoginLink(); // click on login link

		dashboardPage = loginPage.loginUser(UName, password); // Login with
																// valid
																// credentials
		dashboardPage.myItemConsignorUploadNotDisplay(); // Verify Consignor
															// Upload is not
															// available

	}

	/**
	 * check the option save
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Check_The_Option_Save(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"check the option save Feature,TestCase Name: 4.41 check the option save Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String Inventoryname = common.generateRandomChars(4);
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.enable_Lot_Upload_For_Consignor_Allow_Lot_Assignment_Auction_Disable_Settings();
		String name = adminDashboardPage.allFieldsFillForTimedSalePublish(saleno);

		//adminDashboardPage.enable_Available_Consignor_Upload_Auc_Setting();

		adminDashboardPage.front(); // Open Front End
		loginPage = indexPage.clickOnLoginLink(); // click on login link

		dashboardPage = loginPage.loginUser(UName, password); // Login with
																// valid
																// credentials
		dashboardPage.myItemConsignorUploadDisplay(Inventoryname); // Verify
																	// Consignor
																	// Upload is
																	// available
		// items consigned taband upload new lot button not display at front side in
		// qa3-2-auto env.
	}

	/**
	 * check the option save
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Check_The_Option_Save1(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"check the option save Feature,TestCase Name: 4.42 check the option save Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String Inventoryname = common.generateRandomChars(4);
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.enable_Lot_Upload_For_Consignor_Allow_Lot_Assignment_Auction_Enable_Settings();
		String name = adminDashboardPage.allFieldsFillForTimedSalePublish(saleno);

		adminDashboardPage.enable_Available_Consignor_Upload_Auc_Setting();

		adminDashboardPage.front(); // Open Front End
		loginPage = indexPage.clickOnLoginLink(); // click on login link

		dashboardPage = loginPage.loginUser(UName, password); // Login with
																// valid
																// credentials
		dashboardPage.myItemConsignorUploadDisplay(Inventoryname); // Verify
																	// Consignor
																	// Upload is
																	// available
		// items consigned taband upload new lot button not display at front side in
		// qa3-2-auto env.

	}

	/**
	 * check the option save
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Check_The_Option_Save2(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"check the option save Feature,TestCase Name: 4.44 check the option save Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String Inventoryname = common.generateRandomChars(4);
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.enable_Lot_Upload_For_Consignor_Allow_Lot_Assignment_Auction_Enable_Settings();
		String name = adminDashboardPage.allFieldsFillForTimedSalePublish(saleno);

		adminDashboardPage.enable_Available_Consignor_Upload_Auc_Setting();

		adminDashboardPage.front(); // Open Front End
		loginPage = indexPage.clickOnLoginLink(); // click on login link

		dashboardPage = loginPage.loginUser(UName, password); // Login with
																// valid
																// credentials
		dashboardPage.myItemConsignorUploadDisplay(Inventoryname); // Verify
																	// Consignor
																	// Upload is
																	// available
		// items consigned taband upload new lot button not display at front side in
		// qa3-2-auto env.

	}

	/**
	 * check the option save
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Check_The_Option_Save3(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"check the option save Feature,TestCase Name: 4.45 check the option save Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String Inventoryname = common.generateRandomChars(4);
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.enable_Lot_Upload_For_Consignor_Allow_Lot_Assignment_Auction_Enable_Settings();
		String name = adminDashboardPage.allFieldsFillForTimedSalePublish(saleno);

		adminDashboardPage.enable_Available_Consignor_Upload_Auc_Setting();

		adminDashboardPage.front(); // Open Front End
		loginPage = indexPage.clickOnLoginLink(); // click on login link

		dashboardPage = loginPage.loginUser(UName, password); // Login with
																// valid
																// credentials
		dashboardPage.myItemConsignorUploadWithImage(Inventoryname, name); // Verify
		// Consignor
		// Upload is
		// available

		// items consigned taband upload new lot button not display at front side in
		// qa3-2-auto env.

	}

	// 4.46 to 4.59 pending CSV FILE UPLOAD

	/**
	 * Edit an existing auction go to the auction lots tab click on add lot fill out
	 * the fields but not the lot name - 4.60
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Lot_Name_Missing(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Edit an existing auction go to the auction lots tab click on add lot fill out the fields but not the lot name Feature,TestCase Name: 4.60 Edit an existing auction go to the auction lots tab click on add lot fill out the fields but not the lot name Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verifyLotNameMissingForTimedSale("0"); // verify lot
																	// name
																	// missing
																	// for time
																	// scale

	}

	/**
	 * Edit an existing auction go to the auction lots tab click on add lot fill out
	 * the fields but not the starting bid - 4.61
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Starting_Bid_Missing(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Edit an existing auction go to the auction lots tab click on add lot fill out the fields but not the starting bid Feature,TestCase Name: 4.61"
				+ " Edit an existing auction go to the auction lots tab click on add lot fill out the fields but not the starting bid Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String str = common.generateRandomChars(5);
		adminDashboardPage.verifyStartingBidMissingForTimedSale(str); // verify
																		// starting
																		// bid
																		// missing
																		// for
																		// time
																		// sale

	}

	/**
	 * Fill out just the lot name
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Fill_Out_Just_The_Lotname(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Fill out just the lot name Feature,TestCase Name: 4.62 Fill out just the lot name Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String str = common.generateRandomChars(5);
		adminDashboardPage.verifyFillOutJustTheLotNameForTimedSale(str); // verify fill out

	}

	/**
	 * Verify Create New Lot
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Verify_Create_New_Lot(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Verify Create New Lot Feature,TestCase Name: 4.63 Verify Create New Lot Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String name = adminDashboardPage.allFieldsFillForTimedSalePublish(saleno);

		String lotname = adminDashboardPage.verifyLotAddLotForTimedSale(); // verify
																			// LotAdd
		// LotAdd for time
		// sale
		adminDashboardPage.verify_Timed_Sale_Lot_Details(saleno, lotname);

	}

	/**
	 * Verify Fill out all the fields with erroneous values
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Fill_Out_All_The_Fields_With_Erroneous_Values(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Fill out all the fields with erroneous values Feature,TestCase Name: 4.64 Fill out all the fields with erroneous values Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verify_Incorrect_LotDetails_ForTimedSale(); // verify
		// Incorrect
		// lot
		// details
		// for timed
		// for

	}

	/**
	 * Assign one category
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Assign_One_Category(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Assign one category Feature,TestCase Name: 4.65 Assign one category Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();

		String saleno1 = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Timed_Auction(saleno1);
		System.out.println("Step :: auction Name  :" + auctionName);
		common.log("<br></br> Step :: auction Name  :" + auctionName);

		String lotname = adminDashboardPage.verifyAssignOneCategory();

		String assigncat = adminDashboardPage.get_Category_From_Lot_Table();

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link

		dashboardPage = loginPage.loginUser(UName, password); // Login with
		// valid
		// credentials
		dashboardPage.assignview_Catalog_Timedsale(saleno1, auctionName, lotname);

	}

	/**
	 * assign multiple categories
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Assign_Multiple_Categories(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"assign multiple categories Feature,TestCase Name: 4.66 assign multiple categories Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();
		String saleno1 = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Timed_Auction(saleno1);
		System.out.println("Step :: auction Name s :" + auctionName);
		common.log("<br></br> Step :: auction Name s :" + auctionName);

		String lotname = adminDashboardPage.verifyassign_Multiple_Category();
		adminDashboardPage.approveBidder1();
		// String assigncat = adminDashboardPage.Get_Category_From_Lot_Table();

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link

		dashboardPage = loginPage.loginUser(UName, password); // Login with
		// valid
		// credentials
		dashboardPage.assignview_Catlog_Multicategory_Timedsale(saleno1, auctionName, lotname);
		System.out.println("verify lot name ::" + lotname);

	}

	/**
	 * Enter Already exist Item Number
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Enter_Already_Exist_Item_Number(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Enter Already exist Item Number Feature,TestCase Name: 4.67 Enter Already exist Item Number Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String saleno = common.generateRandomNumber1();
		adminDashboardPage.createTimedAuction(saleno);
		adminDashboardPage.add1Lot();
		adminDashboardPage.verifyExistingItemNumberForTimedSale(saleno); // verify
		// existing
		// Item
		// number
		// for time
		// scale

	}

	/**
	 * Enter More than Higher Item Number
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Enter_More_Than_Higher_ItemNumber(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Enter More than Higher Item Number Feature,TestCase Name: 4.68 Enter More than Higher Item Number Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verifyHigherItemNumberForTimedSale(); // verify
																	// higher
																	// Item
																	// number
																	// for Time
																	// scale
	}

	/**
	 * Verify keep Item number blank
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Keep_Item_Number_Blank(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Verify keep Item number blank Feature,TestCase Name: 4.69 Verify keep Item number blank Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verifyItemNumberForTimedSale(); // verify Item Number
															// for time scale
	}

	/**
	 * Enter an available value
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Enter_an_Available_Value(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Enter an available value Feature,TestCase Name: 4.70 Enter an available value Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verifyItemNumber1ForTimed(); // verify Item Number
	}

	/**
	 * Verify Leave item number Empty
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Leave_Item_Number_Empty(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Verify Leave item number Empty Feature,TestCase Name: 4.71 Verify Leave item number Empty Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verifyItemNumberForTimedSale(); // verify Item Number
															// for time scale

		/*
		 * Defect : item number is not empty, Item number is generated Automatically.
		 */
	}

	/**
	 * Verify Existing lot number
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Verify_Existing_Lot_Number(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Verify Existing lot number Feature,TestCase Name: 4.72 Verify Existing lot number Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verifyIncorrectLotnumberForTimedSale(); // verify
																	// Incoorect
																	// Lotnumber
																	// for time
																	// scale

	}

	/**
	 * Verify Enter lot number value that is not yet used
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Verify_Enter_Lot_Number_Value_That_is_Not_Yet_Used(String adminUserName, String adminPassword,
			String UName, String password) throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Verify Enter lot number value that is not yet used Feature,TestCase Name: 4.73 Verify Enter lot number value that is not yet used Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verifyCorrectLotNumberForTimedSale(); // verify
																	// correct
																	// Lot
																	// number
																	// for tine
																	// scale

	}

	/**
	 * Verify Enter lot number value that is non numeric value
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Verify_Enter_Lot_Number_Value_That_is_Nonnumeric_Value(String adminUserName, String adminPassword,
			String UName, String password) throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Verify Enter lot number value that is non numeric value Feature,TestCase Name: 4.74 Verify Enter lot number value that is non numeric value Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verifyNumericLotNumberForTimedSale(); // verify
																	// Numeric
																	// lot
																	// Number
																	// for time
																	// scale

	}

	/**
	 * Verify Enter lot number Extention
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Verify_Enter_Lot_Number_Extention(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Verify Enter lot number Extention Feature,TestCase Name: 4.75 Verify Enter lot number Extention Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verify_Lot_Number_Extention_For_LiveSale(); // verify
		// lotnumber
		// extension
		// for live
		// scale

	}

	/**
	 * Verify Enter Albhabet value in lot number Extention Field
	 * 
	 * @throws InterruptedException
	 * @throws AWTExceptiona
	 */
	@Test(dataProvider = "createauction")
	public void Verify_Enter_Albhabet_Value_in_Lot_Number_Extention_Field(String adminUserName, String adminPassword,
			String UName, String password) throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Verify Enter Albhabet value in lot number Extention Field Feature,TestCase Name: 4.76 Verify Enter Albhabet value in lot number Extention Field Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verify_Enter_Alphabet_Value_In_Lotnumber_ExtentionForTimedSale(); // verify
		// enter
		// alphabet
		// value
		// in
		// lot
		// number
		// extention
		// for
		// time
		// scale
	}

	/**
	 * Verify Enter Symbol value in lot number Extention Field
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Verify_Enter_Symbol_Value_In_Lotnumber_Extention_Field(String adminUserName, String adminPassword,
			String UName, String password) throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Verify Enter Symbol value in lot number Extention Field Feature,TestCase Name: 4.77 Verify Enter Symbol value in lot number Extention Field Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verify_Enter_Symbol_Value_In_LotnumberExtentionForTimedSale(); // verify
		// entered
		// symbol
		// value
		// in
		// lot
		// number
		// extention
		// for
		// time
		// scale

	}

	/**
	 * Verify Enter pound sign in lot number Extention Field
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Verify_Enter_Pound_Sign_in_Lot_Number_Extention_Field(String adminUserName, String adminPassword,
			String UName, String password) throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Verify Enter pound sign in lot number Extention Field Feature,TestCase Name: 4.78 Verify Enter pound sign in lot number Extention Field Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verify_Enter_PoundSign_In_LotnumberExtentionForTimedSale(); // verify
		// Enter
		// pound
		// sign
		// in
		// lot
		// number
		// extention
		// for
		// timed
		// scale

	}

	/**
	 * Verify Edit an existing auction go to the auction lots tab click on add lot
	 * description: enter a HTML enriched text fill out the other fields
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Verify_Lot_Description_Enriched_Text(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Verify lot description - enriched text Feature,TestCase Name: 4.79 Verify lot description - enriched text Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String timedauction = adminDashboardPage.allFieldsFillForTimedSalePublish(saleno);

		String lotname1 = adminDashboardPage.add_Lot_Description_For_TimedSale(saleno);
		adminDashboardPage.approveBidder1();

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

	}

	/**
	 * Specify 2 working image links
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Specify_2_Working_Image_Links(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Specify 2 working image links Field Feature,TestCase Name: 4.80 Specify 2 working image links Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verifyAddMoreImagelink1ForTimedSale(); // verify
																	// addmoreimagelink
																	// for time
																	// scale

		// Lot image is not dispalys in frontend.
	}

	/**
	 * Specify a broken image link
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Specify_a_Broken_Image_Link(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Specify a broken image link Field Feature,TestCase Name: 4.81 Specify a broken image link Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verifyBrokenUrlLinkForTimedSale();

	}

	/**
	 * Upload several valid images
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Upload_Several_Valid_Images(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"upload several valid images Feature,TestCase Name: 4.82 upload several valid images Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verifyAddMoreImagelink1ForTimedSale(); // verfy add
																	// more
																	// image
																	// link for
																	// time
																	// scale

		// Image is not display on front end.

	}

	/**
	 * remove existing image link
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Remove_Existing_Imagelink(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"remove existing image link Feature,TestCase Name: 4.83 remove existing image link Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.deleteImageLinkForTimedSale(); // delete image link
															// for time scale
	}

	/**
	 * remove existing uploaded image
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Remove_Existing_Uploaded_Image(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"remove existing uploaded image Feature,TestCase Name: 4.84 remove existing uploaded image Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.deleteImageLinkForTimedSale();// pending
	}

	// 4.85 - 4.100 Pending

	/**
	 * Enter the number of an existing lot
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Enter_The_Number_Of_an_Existing_Lot(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Enter the number of an existing lot Feature,TestCase Name: 4.101 Enter the number of an existing lot Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
//		String saleno = common.generateRandomNumber1();
//		adminDashboardPage.createtimedauction1(saleno);
		// adminDashboardPage.add1lot();

		adminDashboardPage.VerifyEnterThenumberofanexistinglotForTimedSale();

	}

	/**
	 * Enter the number of a non existing lot in the auction
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Enter_The_Number_Of_an_non_Existing_Lot_In_The_Auction(String adminUserName, String adminPassword,
			String UName, String password) throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Enter the number of a non existing lot in the auction Feature,TestCase Name: 4.102 Enter the number of a non existing lot in the auction Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verifyEnterTheNumberOfAnExistingLotInTheAuctionForTimedSale(); // verify
																							// the
																							// number
		// scale

	}

	/**
	 * Verify more actions
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void More_Actions(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Verify more actions Feature,TestCase Name: 4.106 Verify more actions Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String AuctionTimed = adminDashboardPage.allFieldsFillForTimedSale(tomorrowDate, "1", saleno); // Create
		// Auction
		String strlot = adminDashboardPage.addLot(1);
		Thread.sleep(1000);
		adminDashboardPage.verify_More_Actions();
		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verifyLoginPageElements(); // Verify Login Page Elements
		dashboardPage = loginPage.loginUser(UName, password); // Login with
		// valid
		dashboardPage.goto_Catalog_Page_Timed_Sale(AuctionTimed); // credentials

		dashboardPage.catalog_Section(strlot);
	}

	/**
	 * Reorder lots using consignor sort
	 * 
	 * 
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Recorder_Lots_Using_Consignor_Sort(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"start date in the future Feature,TestCase Name : 4.107 Reorder lots using consignor sort");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String timedauction = adminDashboardPage.createTimedAuction(saleno);

		// Add Multiple lot with different different consignor

		String addlot1 = adminDashboardPage.add_Lot_With_Consignor();
		String addlot2 = adminDashboardPage.Add_Lot_with_Consignorr();
		String addlot3 = adminDashboardPage.add_Lot_With_Consignor1();
		String addlot4 = adminDashboardPage.add_Lot_With_Consignor1();
		String addlot5 = adminDashboardPage.add_Lot_With_Consignor2();
		String addlot6 = adminDashboardPage.add_Lot_With_Consignor2();
		

		adminDashboardPage.verify_Consignor_Sort(); // Verify consignor sort
	}

	/**
	 * Verify Randomly reassign lot numbers
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Randomly_Reassign_Lot_Numbers(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Verify Randomly reassign lot numbers Feature,TestCase Name: 4.108 Verify Randomly reassign lot numbers Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String name = adminDashboardPage.allFieldsFillForTimedSale(tomorrowDate, "1", saleno); // Create
		// Auction
		System.out.print("\n" + name);
		adminDashboardPage.addMultipleLot(10);
		Thread.sleep(1000);
		adminDashboardPage.verifyRandomlyReassignLotNumbers(); // verify
																// randomly
																// assign lot
																// number

	}

	/**
	 * Verify keyword search
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Keyword_Search(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Verify keyword search Feature,TestCase Name: 4.109 Verify keyword search Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.create_Timed_Auction(saleno); // Create
															// Auction

		String lotname = adminDashboardPage.addMultipleLot(3);

		String inventory_lotname = adminDashboardPage.multipleAddItemToTheInventery(5);// Some
																						// time
																						// xpath
		// issue

		adminDashboardPage.search_Last_Created_Auction(saleno); // Create
																// Auction
		adminDashboardPage.verifykeywordSearch(lotname, inventory_lotname); // verify
																			// keyword
																			// search
	}

	/**
	 * Verify Filter(Category)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Category(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"Verify Filter(Category) Feature,TestCase Name: 4.110 Verify Filter(Category) Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		//String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.create_Timed_Auction(saleno);

		//adminDashboardPage.addMultipleLot(1);

		String consignor = adminDashboardPage.multipleAddItemToTheInventery(1);

		adminDashboardPage.search_Last_Created_Auction(saleno);

		adminDashboardPage.verify_Consignor_Item_Category_Timed(consignor);

	}

	/**
	 * Verify Filter(Consignor)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	@Test(dataProvider = "createauction")
	public void Consignor(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"Verify Filter(Consignor) Feature,TestCase Name: 4.111 Verify Filter(Consignor) Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();
		String saleno1 = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.create_Timed_Auction(saleno1);
		// Create
		// Auction

		String lotname = adminDashboardPage.add_Lot_With_Consignor1();
//		String lotname1 = adminDashboardPage.add_Lot_With_Consignor2();
//		String lotname2 = adminDashboardPage.add_Lot_with_Consignor3();

		// adminDashboardPage.Verify_Consignor_in_Lot(saleno1);
		adminDashboardPage.verify_Consignor_Item_Timed(lotname);
	}

	/**
	 * 
	 * Verify Filter(Status)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Status1(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"Verify Filter(Status) Feature,TestCase Name: 4.112 Verify Filter(Status) Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno1 = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.createTimedAuction(saleno);

		adminDashboardPage.addMultipleLot(3);

		adminDashboardPage.multipleAddItemToTheInventery(2);

		adminDashboardPage.search_Last_Created_Auction(saleno);

		adminDashboardPage.verifyStatus();
	}

	/**
	 * Verify Filter(Billing Status)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Billing_Status(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"Verify Filter(Billing Status) Feature,TestCase Name: 4.113 Verify Filter(Billing Status) Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();
		String saleno1 = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.create_Timed_Auction(saleno);
		adminDashboardPage.addMultipleLot(1);
		adminDashboardPage.verify_Billing_Status();

	}

	/**
	 * Verify Combination of all filters
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Combination_Of_All_Filters(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Verify Combination of all filters Feature,TestCase Name: 4.114 Verify Combination of all filters Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno1 = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.create_Timed_Auction(saleno);
		adminDashboardPage.addMultipleLot(3);

		// adminDashboardPage.Create_Timed_Auction(saleno); // Create
		// Auction
		adminDashboardPage.verifyCombinationOfAllFilters(); // verify
															// combination fall
															// filters

	}

	/**
	 * Verify Block sold lots from being assigned to other sales filters
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Block_Sold_Lots_From_Being_Assigned_too_The_Sales(String adminUserName, String adminPassword,
			String UName, String password) throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Verify Block sold lots from being assigned to other sales Feature,TestCase Name: 4.115 Verify Block sold lots from being assigned to other sales Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno1 = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.create_Timed_Auction(saleno);
		String lotname1 = adminDashboardPage.addLot1();

		String lotname2 = adminDashboardPage.addLot1();

		adminDashboardPage.verifyBlockSoldLotsFromBeingAssignedToOtherSales(lotname1, lotname2); // verify
																									// block
																									// sold
																									// lots
																									// from
																									// being
																									// assigned
																									// to
																									// other
																									// sales
	}

	/**
	 * Verify Block sold lots from being assigned to other sales is active
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Block_Sold_Lots_From_Being_Assigned_too_The_Sales_is_Active(String adminUserName, String adminPassword,
			String UName, String password) throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Verify Block sold lots from being assigned to other sales is active Feature,TestCase Name: 4.116 Verify Block sold lots from being assigned to other sales is active Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno1 = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.create_Timed_Auction(saleno); // Create
															// Auction

		String lotname1 = adminDashboardPage.addLot1();

		String lotname2 = adminDashboardPage.addLot1();

		adminDashboardPage.create_Timed_Auction(saleno1); // Create Auction
		adminDashboardPage.verifyBlockSoldLotsFromBeingAssignedToOtherSalesIsActive(lotname1, lotname2); // verify
																											// block
																											// sold
																											// lots
																											// from
																											// being
																											// assigned
																											// to
																											// other
																											// sales
																											// is
																											// active
	}

	/**
	 * Verify Block sold lots from being assigned to other sales is active
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Block_Sold_Lots_From_Being_Assigned_too_The_Sales_is_Active1(String adminUserName, String adminPassword,
			String UName, String password) throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Verify Block sold lots from being assigned to other sales is active Feature,TestCase Name: 4.117 Verify Block sold lots from being assigned to other sales is active Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno1 = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.create_Timed_Auction(saleno); // Create
															// Auction

		String lotname1 = adminDashboardPage.addLot1();

		String lotname2 = adminDashboardPage.addLot1();

		adminDashboardPage.create_Timed_Auction(saleno); // Create Auction
		adminDashboardPage.verifyBlockSoldLotsFromBeingAssignedToOtherSalesIsActive1(lotname1, lotname2); // verfy
																											// block
																											// sold
																											// lots
																											// from
																											// being
																											// lots
																											// from
																											// being																							// assigned
																											// to
																											// other
																											// sales
																											// in
																											// active
	}

	/**
	 * Verify Block sold lots from being assigned to other sales is active
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Block_Sold_Lots_From_Being_Assigned_too_The_Sales_Is_Active2(String adminUserName, String adminPassword,
			String UName, String password) throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Verify Block sold lots from being assigned to other sales is active Feature,TestCase Name: 4.118 Verify Block sold lots from being assigned to other sales is active Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno1 = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.create_Timed_Auction(saleno); // Create Auction

		String lotname1 = adminDashboardPage.addLot1();
		String lotname2 = adminDashboardPage.addLot1();

		adminDashboardPage.create_Timed_Auction(saleno); // Create Auction
		adminDashboardPage.verifyBlockSoldLotsFromBeingAssignedToOtherSalesIsActive2(lotname1, lotname2);
	}

	/**
	 * Verify change page link
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Change_Page_Link(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Verify change page link Feature,TestCase Name: 4.119 Verify change page link Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.create_Timed_Auction(saleno); // Create Auction
		String lotname1 = adminDashboardPage.addLot1();
		String lotname2 = adminDashboardPage.addLot1();
		String lotname3 = adminDashboardPage.addLot1();

		adminDashboardPage.verifyChangePageLinkForTimedSale(saleno);
	}

	// 120
	/**
	 * Quick Edit Lot Number
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Quick_Edit_Lot_Number(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Timed_Auction(saleno);
		String lotname1 = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.quick_Edit_Lot_Number();

	}

	// 121
	/**
	 * Quick Edit New Lot Number
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Quick_Edit_New_Lot_Number(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Timed_Auction(saleno);
		String lotname1 = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.quick_Edit_New_Lot_Number();

	}

	// 122
	/**
	 * Quick Edit New Name
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Quick_Edit_New_Lot_Name(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Timed_Auction(saleno);
		String lotname1 = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.quick_Edit_Lot_Name();

	}

	// 123
	/**
	 * Quick Edit Category
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Quick_Edit_Category(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Timed_Auction(saleno);
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.quick_Edit_Category();

	}

	// 124
	/**
	 * Quick Edit Lot Id
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Quick_Edit_Lot_Id(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Timed_Auction(saleno);
		String lotname1 = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.quick_Edit_Lot_ID();

	}

	// 125
	/**
	 * Quick Edit Lot Id more than 10 values.
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Quick_Edit_Lot_Id_MoreValues(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Timed_Auction(saleno);
		String lotname1 = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.quick_Edit_Lot_ID_More_values();

	}

	// 126
	/**
	 * Quick Edit Lot Id
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Quick_Edit_New_Lot_Id(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Timed_Auction(saleno);
		String lotname1 = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.quick_Edit_New_Lot_ID();

	}

	// 127
	/**
	 * Quick Edit Lot Quantity
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Quick_Edit_Lot_Quantity(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Timed_Auction(saleno);
		String lotname1 = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.quick_Edit_Lot_Quantity();

	}

	// 128
	/**
	 * Quick Edit Lot Estimate
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Quick_Edit_Lot_Estimate(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Timed_Auction(saleno);
		String lotname1 = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.quick_Edit_Lot_Estimate();

	}

	// 129
	/**
	 * Quick Edit Lot Reserve
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Quick_Edit_Lot_Reserve(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Timed_Auction(saleno);
		String lotname1 = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.quick_Edit_Lot_Reserve();

	}

	// 130
	/**
	 * Quick Edit Lot Estimate Negative
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Quick_Edit_Lot_Estimate_Negative(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Timed_Auction(saleno);
		String lotname1 = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.quick_Edit_Lot_Estimate_Negative_Value();

	}

	// 131
	/**
	 * Quick Edit Lot Starting
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Quick_Edit_Lot_Starting(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Timed_Auction(saleno);
		String lotname1 = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.quick_Edit_Lot_Start();

	}

	// 132
	/**
	 * Quick Edit Lot Price
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Quick_Edit_Lot_Price(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Timed_Auction(saleno);
		String lotname1 = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.quick_Edit_Lot_Price();

	}

	// 133
	/**
	 * Quick Edit Lot Consignor
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Quick_Edit_Lot_Consignor(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Timed_Auction(saleno);
		String lotname1 = adminDashboardPage.add_Lot_With_Consignor();

		adminDashboardPage.quick_Edit_Lot_Consignor();
		// consignor field not display at quick edit time
	}

	// 134
	/**
	 * Quick Edit Lot Views
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Quick_Edit_Lot_Views(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Timed_Auction(saleno);
		String lotname1 = adminDashboardPage.add_Lot_With_Consignor();

		adminDashboardPage.quick_Edit_Lot_Views();
		// lot views field not display at quick edit time
	}

	// 135
	/**
	 * Quick Edit Lot Status
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Quick_Edit_Lot_Status(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Timed_Auction(saleno);
		String lotname1 = adminDashboardPage.add_Lot_With_Consignor();

		adminDashboardPage.quick_Edit_Lot_Status();

	}

	// 136
	/**
	 * Quick lot Preview
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Quick_Edit_Lot_Preview(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Timed_Auction(saleno);
		String lotname1 = adminDashboardPage.add_Lot_With_Consignor();

		adminDashboardPage.lot_Preview();

	}

	// 137
	/**
	 * Delete Multiple Lot
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Delete_Multiple_Lot(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Timed_Auction(saleno);
		String lotname1 = adminDashboardPage.addLotRandom(3);

		adminDashboardPage.delete_Multiple_lot();

	}

	@Test(dataProvider = "createauction")
	public void JmeterAuctionTimed(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get("https://sam.bp-depot.com/admin/"); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.timedAuc(saleno);

		adminDashboardPage.uploadLotWithImage1();
		adminDashboardPage.uploadLotWithImage1();
		adminDashboardPage.uploadLotWithImage1();
		adminDashboardPage.uploadLotWithImage1();
		adminDashboardPage.uploadLotWithImage1();
		adminDashboardPage.uploadLotWithImage1();
		adminDashboardPage.uploadLotWithImage1();
		adminDashboardPage.uploadLotWithImage1();
		adminDashboardPage.uploadLotWithImage1();
		adminDashboardPage.uploadLotWithImage1();
		adminDashboardPage.uploadLotWithImage1();
		adminDashboardPage.uploadLotWithImage1();
		adminDashboardPage.uploadLotWithImage1();
		adminDashboardPage.uploadLotWithImage1();
		adminDashboardPage.uploadLotWithImage1();
	}
	// 4.120-4.136- No TC Present

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
