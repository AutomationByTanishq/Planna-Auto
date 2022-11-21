package com.auction.verifications;



import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.james.mime4j.field.datetime.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

import com.auction.admin.pages.LiveSaleAuction;
import com.auction.init.Common;
import com.auction.init.ConfigFileReader;
import com.auction.init.SeleniumInit;
//import com.relevantcodes.extentreports.ExtentReports;

public class Settings extends SeleniumInit {

	Common common = new Common(driver);
	String strFile = "test_data" + File.separator + "testoutput.csv";
	
	
	//ExtentReports extent = new ExtentReports(strFile);
	String bidder2 = "rahulbid";
	String bidder2Pass = "123123a";
	String UName = "rahulqa";
	String password = "123123a";
	ConfigFileReader configFileReader= new ConfigFileReader();
	/**
	 * Remove all existing ranges
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Remove_All_Existing_Ranges(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"Remove all existing ranges Feature,TestCase Name: 5.1 Remove all existing ranges Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verifyRemoveallexistingranges();

		// no confirmation displayed.
	}

	/**
	 * add a new range: do not specify the starting amount
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Add_a_New_Range_Do_Not_Specify_The_Starting_Amount(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"add a new range: do not specify the starting amount Feature,TestCase Name: 5.2 add a new range: do not specify the starting amount Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyaddanewrange_donotspecifythestartingamount();

	}

	/**
	 * add a new range: leave "0" in the starting range field
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Add_a_New_Range_Leave_0_In_The_Starting_Range(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"add a new range: leave '0' in the starting range field Feature,TestCase Name: 5.3 add a new range: leave '0' in the starting range field Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyaddanewrange_leave0inthestartingrange();

	}

	/**
	 * add a new range: do not specify the increment
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Add_a_New_Range_Do_Not_Specify_The_Increment(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"add a new range: do not specify the increment Feature,TestCase Name: 5.4 add a new range: do not specify the increment Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.donotspecifytheincrement();

	}

	/**
	 * add a new range: leave "0" in the increment field
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Add_a_New_Range_Leave_0_In_The_Increment_Field(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"add a new range: leave '0' in the increment field Feature,TestCase Name: 5.5 add a new range: leave '0' in the increment field Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.leave0intheincrementfield();

	}

	/**
	 * add a new range: specify a starting amount that is already existing
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Add_a_New_Range_Specify_a_Starting_Amount_That_Is_Already_Existing(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"add a new range: specify a starting amount that is already existing Feature,TestCase Name: 5.6 add a new range: specify a starting amount that is already existing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.specifyastartingamountthatisalreadyexisting();

	}

	/**
	 * add a new range: specify new starting amount and increment
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Add_a_New_Range_Specify_a_Starting_Amount_and_Increment(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"add a new range: specify new starting amount and increment Feature,TestCase Name: 5.7 add a new range: specify new starting amount and increment Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Specify_Starting_Amount_And_Increment();

	}

	/**
	 * add a new range: new starting range in between 2 existing ones
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Add_a_New_Range_Specify_a_Starting_Amount_Between_2_Existing_Ones_and_Increment(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"add a new range: specify new starting amount in between 2 existing ones and increment Feature,TestCase Name: 5.8 add a new "
				+ "range: specify new starting amount in between 2 existing ones and increment Feature.");

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.specifyastartingamountbetween2existingonesandincrement();

	}

	/**
	 * Delete an existing range
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Delete_an_Existing_Range_Add_New_One(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"Delete an existing range Feature,TestCase Name: 5.9 Delete an existing range Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Delete_Existing_Range_and_Add_New_Range();

	}

	/**
	 * For an existing range, try to modify the starting range value
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void For_an_Existing_Range_Try_to_Modify_The_Starting_Range_Value(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"For an existing range, try to modify the starting range value Feature,TestCase Name: 5.10 "
				+ "For an existing range, try to modify the starting range value Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Trytomodifythestartingrangevalue();

	}

	/**
	 * For an existing range, try to modify the increment amount value
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void For_an_Existing_Range_Try_to_Modify_The_Increment_Amount_Value(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"For an existing range, try to modify the increment amount value Feature,TestCase Name: 5.11 "
				+ "For an existing range, try to modify the increment amount value Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Try_To_Modify_Increment_Values();

	}

	/**
	 * stay with starting increment = N
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Stay_With_Starting_Increment_N(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\" stay with starting increment = N Feature,TestCase Name: 5.12 "
				+ " stay with starting increment = N Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.AddMultipleIncrements1();
		adminDashboardPage.Stay_With_Starting_Increment_Checkbox_No();

		String auctionName = adminDashboardPage.CreatenewAuction123_Setting(saleno); // create
		// new
		// auction

		String LotName = adminDashboardPage.Lot_Starting_Bid_5(); // Bidding

		adminDashboardPage.start_Auction();

		adminDashboardPage.Stay_With_Starting_Inc_Post_Floor();

	}

	/**
	 * stay with starting increment = Y
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Stay_With_Starting_Increment_Y(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\" stay with starting increment = Y Feature,TestCase Name: 5.13 "
				+ " stay with starting increment = Y Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.AddMultipleIncrements1();
		adminDashboardPage.Stay_With_Starting_Increment_Checkbox_Yes(); //Checkobx not available in qa3-3-auto

		String auctionName = adminDashboardPage.CreatenewAuction123_Setting(saleno); // create
		// new
		// auction

		String lotName = adminDashboardPage.Lot_Starting_Bid_5(); // Bidding

		adminDashboardPage.start_Auction();

		adminDashboardPage.Stay_With_Starting_Inc_Post_Floor();
	}

	/**
	 * stay with starting increment = N1
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Stay_With_Starting_Increment_N1(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\" stay with starting increment = N Feature,TestCase Name: 5.14 "
				+ " stay with starting increment = N Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.AddMultipleIncrements1();
		adminDashboardPage.Stay_With_Starting_Increment_Checkbox_No();// checkbox not available qa3-3-auto

		String auctionName = adminDashboardPage.CreatenewAuction123_Setting(saleno); // create
																						// new
																						// auction
		String lotName = adminDashboardPage.Lot_Starting_Bid_5(); // Add Lot
																	// with
																	// Starting
																	// bid 5
		adminDashboardPage.Add_Auction_Specific_Bid_Increment();
		adminDashboardPage.Stay_With_Starting_Increment_Checkbox_No();
		adminDashboardPage.search_Last_Created_Auction(saleno);

		adminDashboardPage.start_Auction();

		adminDashboardPage.Stay_With_Starting_Inc_Specific_Auction_Post_Floor();

	}

	/**
	 * stay with starting increment = Y
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Stay_With_Starting_Increment_Y1(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\" stay with starting increment = N Feature,TestCase Name: 5.15 "
				+ " stay with starting increment = N Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.AddMultipleIncrements1();
		adminDashboardPage.Stay_With_Starting_Increment_Checkbox_No();

		String auctionName = adminDashboardPage.CreatenewAuction123_Setting(saleno); // create
																						// new
																						// auction

		String lotName = adminDashboardPage.Lot_Starting_Bid_5(); // Add Lot
																	// with
																	// Starting
																	// bid 5

		adminDashboardPage.Add_Auction_Specific_Bid_Increment();
		adminDashboardPage.Stay_With_Starting_Increment_Checkbox_Yes();
		adminDashboardPage.search_Last_Created_Auction(saleno);

		adminDashboardPage.start_Auction();

		adminDashboardPage.Stay_With_Starting_Inc_Specific_Auction_Post_Floor();
	}

	/**
	 * stay with starting increment = N 5.16
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Stay_With_Starting_Increment_NN(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\" stay with starting increment = N Feature,TestCase Name: 5.16 "
				+ " stay with starting increment = N Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.AddMultipleIncrements1();
		adminDashboardPage.Stay_With_Starting_Increment_Checkbox_No();

		String auctionName = adminDashboardPage.CreatenewAuction123_Setting(saleno); // create
																						// new
																						// auction

		adminDashboardPage.Add_Lot_With_Custom_Increment_Starting_5(); // Bidding

		adminDashboardPage.Add_Auction_Specific_Bid_Increment();
		adminDashboardPage.Stay_With_Starting_Increment_Checkbox_No();
		adminDashboardPage.search_Last_Created_Auction(saleno);

		adminDashboardPage.start_Auction();

		adminDashboardPage.Stay_With_Starting_Inc_Specific_Lot_Post_Floor();
	}

	/**
	 * Remove all existing ranges
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Remove_All_Existing_Ranges_TimeSale(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT" + "\"Remove all existing ranges For Timed Sale Feature,"
				+ "TestCase Name: 5.17 Remove all existing ranges For Timed Sale Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Delete_Bid_Increment_Time_Online_Auction_Range_Field();

		// no confirmation message displayed.
	}

	/**
	 * add a new range: do not specify the starting amount
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Add_a_New_Range_Do_Not_Specify_The_Starting_Amount_For_TimedSale(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT" + "\"add a new range: do not specify the starting amount For Timed Sale Feature,"
				+ "TestCase Name: 5.18 add a new range: do not specify the starting amount For Timed Sale Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyaddanewrange_donotspecifythestartingamountForTimedSale();

	}

	/**
	 * add a new range: leave "0" in the starting range field
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Add_a_New_Range_Leave_0_In_The_Starting_Range_For_TimedSale(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT" + "\"add a new range: leave '0' in the starting range field For TimedSale Feature,"
				+ "TestCase Name: 5.19 add a new range: leave '0' in the starting range field For TimedSale Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyaddanewrange_leave0inthestartingrangeForTimedSale();

	}

	/**
	 * add a new range: do not specify the increment
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Add_a_New_Range_Do_Not_Specify_The_Increment_For_TimedSale(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT" + "\"add a new range: do not specify the increment For Timed Sale Feature,"
				+ "TestCase Name: 5.20 add a new range: do not specify the increment For Timed Sale Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.donotspecifytheincrementForTimedSale();

	}

	/**
	 * add a new range: leave "0" in the increment field
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Add_a_New_Range_Leave_0_In_The_Increment_Field_For_TimedSale(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"add a new range: leave '0' in the increment field For timed sale Feature,TestCase Name: 5.21 add a new range: leave '0' in the increment field For timed sale Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.leave0intheincrementfieldForTimedSale();

	}

	/**
	 * add a new range: specify a starting amount that is already existing
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Add_a_New_Range_Specify_a_Starting_Amount_That_Is_Already_Existing_For_TimedSale(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"add a new range: specify a starting amount that is already existing For Timed Sale Feature,"
				+ "TestCase Name: 5.22 add a new range: specify a starting amount that is already existing For Timed Sale Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.specifyastartingamountthatisalreadyexistingForTimedSale();

	}

	/**
	 * add a new range: specify new starting amount and increment
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Add_a_New_Range_Specify_a_Starting_Amount_and_Increment_For_TimedSale(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"add a new range: specify new starting amount and incrementFor Timed Sale Feature,"
				+ "TestCase Name: 5.23 add a new range: specify new starting amount and increment For Timed Sale Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Specify_Starting_Amount_And_Increment_For_Time_Sale();

	}

	/**
	 * add a new range: new starting range in between 2 existing ones
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Add_a_New_Range_Specify_a_Starting_Amount_Between_2_Existing_Ones_and_Increment_For_Timedsale(
			String adminUserName, String adminPassword, String Name) throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"add a new range: specify new starting amount in between 2 existing ones and increment For Timed Sale Feature,"
				+ "TestCase Name: 5.24 add a new "
				+ "range: specify new starting amount in between 2 existing ones and increment For Timed Sale Feature.");

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.specifyastartingamountbetween2existingonesandincrementForTimedSale();

	}

	/**
	 * Delete an existing range
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Delete_an_Existing_Range_And_Add_New_One_For_TimedSale(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"Delete an existing range For Timed Sale Feature,TestCase Name: 5.25 Delete an existing range For Timed Sale Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.DeleteanexistingrangeandaddnewoneForTimedSale();

	}

	/**
	 * For an existing range, try to modify the starting range value
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void For_an_Existing_Range_Try_To_Modify_The_Starting_Range_Value_For_TimedSale(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"For an existing range, try to modify the starting range value Feature,TestCase Name: 5.26 "
				+ "For an existing range, try to modify the starting range value Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.TrytomodifythestartingrangevalueForTimedSale();

	}

	/**
	 * For an existing range, try to modify the increment amount value
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void For_an_Existing_Range_Try_To_Modify_The_Increment_Amount_Value_For_TimedSale(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"For an existing range, try to modify the increment amount value For Timed Sale Feature,TestCase Name: 5.27 "
				+ "For an existing range, try to modify the increment amount value For Timed Sale Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.TrytomodifytheincrementamountvalueForTimedSale();

	}

	/**
	 * stay with starting increment = N
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Stay_With_Starting_Increment_N_For_TimedSale(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\" stay with starting increment = N For Timed Sale Feature,TestCase Name: 5.28 "
				+ " stay with starting increment = N For Timed Sale Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		// adminDashboardPage.DeleteAllStartingIncrementForTimedSale();
		adminDashboardPage.AddMultipleIncrementsForTimedSale();
		String auctionName = adminDashboardPage.create_Timed_Auction(saleno); // create
																									// new
																									// auction
		adminDashboardPage.approveBidder1_2(); // approve biddder
		String LotName = adminDashboardPage.biddingRunLiveAuction_setting_staywithstartingincrementN_ForTimedSale(); // Bidding

		// adminDashboardPage.biddingRunLiveAuction_setting_(); // Bidding
		// adminDashboardPage.Alternativelypostonlinebidsonthelot_setting_timesale_N();

	}

	/**
	 * stay with starting increment = Y
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Stay_With_Starting_Increment_Y_For_TimedSale(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\" stay with starting increment = Y  For Timed Sale Feature,TestCase Name: 5.29 "
				+ " stay with starting increment = Y For Timed Sale Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.AddMultipleIncrementsForTimedSale();

		String auctionName = adminDashboardPage.create_Timed_Auction(saleno); // create
																									// new
																									// auction
		String lotName = adminDashboardPage.Lot_Starting_Bid_5(); // Bidding

		adminDashboardPage.approveBidder1_2(); // approve biddder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login and verify Asking Bid

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Alternative_Post_Bid_Timed_Sale(auctionName, lotName);

		// Logout

		System.out.println("Step :: Click on Logout Link");
		WebElement logout = driver.findElement(By.xpath("//a[text()='Logout']"));
		logout.click();

		// User 2 Login and verify Asking bid

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);
		dashboardPage.Alternative_Post_Bid_Timed_Sale_Bid_20(auctionName, lotName);

		System.out.println("Step :: Click on Logout Link");
		WebElement logout1 = driver.findElement(By.xpath("//a[text()='Logout']"));
		logout1.click();

		// User 1 Login and verify Asking Bid

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Alternative_Post_Bid_Timed_Sale_100(auctionName, lotName);

		// Pending ....

	}

	/**
	 * stay with starting increment = N
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Stay_With_Starting_Increment_N1_For_TimedSale(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\" stay with starting increment = N For Timed Sale Feature,TestCase Name: 5.30 "
				+ " stay with starting increment = N For Timed Sale Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.DeleteAllStartingIncrementForTimedSale();
		adminDashboardPage.AddMultipleIncrementsForTimedSale();
		String auctionName = adminDashboardPage.CreatenewAuction123_Setting(saleno); // create
																						// new
																						// auction
		System.out.println("Step :: auction Name s :" + auctionName);
		common.log("<br></br> Step :: auction Name s :" + auctionName);
		adminDashboardPage.approveBidder1_2(); // Approve bidder
		String LotName = adminDashboardPage.biddingRunLiveAuction_setting_staywithstartingincrementN1_ForTimedSale(); // Bidding

		adminDashboardPage.biddingRunLiveAuction_setting_(); // Bidding
		adminDashboardPage.Alternativelypostonlinebidsonthelot_setting_timesale_N1();
		adminDashboardPage.front(); // Open Front End

	}

	/**
	 * stay with starting increment = Y
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Stay_With_Starting_Increment_Y1_For_TimedSale(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\" stay with starting increment = Y For Timed Sale Feature,TestCase Name: 5.31 "
				+ " stay with starting increment = Y For Timed Sale Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.DeleteAllStartingIncrementForTimedSale();
		adminDashboardPage.AddMultipleIncrementsForTimedSale();
		String auctionName = adminDashboardPage.CreatenewAuction123_Setting(saleno); // create
																						// new
																						// auction
		System.out.println("Step :: auction Name s :" + auctionName);
		common.log("<br></br> Step :: auction Name s :" + auctionName);
		adminDashboardPage.approveBidder1_2(); // approve bidder
		String LotName = adminDashboardPage.biddingRunLiveAuction_setting_staywithstartingincrementY1_ForTimedSale(); // Bidding

	//	adminDashboardPage.biddingRunLiveAuction_setting_(); // Bidding
		adminDashboardPage.Alternativelypostonlinebidsonthelot_setting_timesale_Y1();
		adminDashboardPage.front(); // Open Front End

	}

	/**
	 * stay with starting increment = N
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Stay_With_Starting_Increment_NN_For_TimedSale(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\" stay with starting increment = N For Timed Sale Feature,TestCase Name: 5.32 "
				+ " stay with starting increment = N For Timed Sale Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.DeleteAllStartingIncrementForTimedSale();
		adminDashboardPage.AddMultipleIncrementsForTimedSale();
		String auctionName = adminDashboardPage.CreatenewAuction123_Setting(saleno); // create
																						// new
																						// auction
		System.out.println("Step :: auction Name s :" + auctionName);
		common.log("<br></br> Step :: auction Name s :" + auctionName);

		adminDashboardPage.approveBidder1_2(); // approve bidder
		String LotName = adminDashboardPage.biddingRunLiveAuction_setting_staywithstartingincrementNN_ForTimedSale(); // Bidding

		adminDashboardPage.biddingRunLiveAuction_setting_(); // Bidding
		adminDashboardPage.Alternativelypostonlinebidsonthelot_setting_timesale_NN();
		adminDashboardPage.front(); // Open Front End

	}

	/**
	 * Remove all existing ranges
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Buyers_Premium_Remove_All_Existing_Ranges(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\" Remove all existing ranges Feature,TestCase Name: 5.33 "
				+ " Remove all existing ranges Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.BuyersPremium_Removeallexistingranges();

	}

	/**
	 * add a new range: do not specify the starting amount
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Buyers_Premium_Add_a_New_Range_Do_Not_Specify_The_Starting_Amount(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"add a new range: do not specify the starting amount Feature,TestCase Name: 5.34 add a new range: do not specify the starting amount Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.BuyersPremium_verifyaddanewrange_donotspecifythestartingamount();

	}

	/**
	 * add a new range: leave "0" in the starting range field
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Buyers_Premium_Add_New_Range_Leave_0_In_The_Starting_Range(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"add a new range: leave '0' in the starting range field Feature,TestCase Name: 5.35 add a new range: leave '0' in the starting range field Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.BuyersPremium_verifyaddanewrange_leave0inthestartingrange();

	}

	/**
	 * add a new range: Do not specify the BP percentage
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Buyers_Premium_Adda_New_Range_Do_Not_Specify_The_BP_Percentage(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"add a new range: do not specify the BP percentage Feature,TestCase Name: 5.36 add a new range: do not specify the BP percentage Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.BuyersPremium_verifyaddanewrange_donotspecifytheBPpercentage();

	}

	/**
	 * add a new range: leave "0" in the buyers premium field
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Buyers_Premium_Add_a_New_Range_Leave_0_In_The_Buyers_Premium_Field(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"add a new range:  leave '0' in the buyers premium field Feature,TestCase Name: 5.37 add a new range: leave '0' in the buyers premium field Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.BuyersPremium_verifyaddanewrange_leave0inthebuyerspremiumfield();

	}

	/**
	 * add a new range:specify a starting amount that is already existing
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Buyers_Premium_Add_a_New_Range_Specify_a_Starting_Amount_That_Is_Already_Existing(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"add a new range:  specify a starting amount that is already existing Feature,TestCase Name: 5.38 add a new range: specify a starting amount that is already existing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.BuyersPremium_verifyaddanewrange_specifyastartingamountthatisalreadyexisting();

	}

	/**
	 * add a new range:specify new starting amount and buyers premium percentage
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Buyers_Premium_Add_a_New_Range_Specify_New_Starting_Amount_and_Buyers_Premium_Percentage(
			String adminUserName, String adminPassword, String Name) throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"add a new range:  specify new starting amount and buyers premium percentage Feature,"
				+ "TestCase Name: 5.39 add a new range: specify new starting amount and buyers premium percentage Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.BuyersPremium_verifyaddanewrange_specifynewstartingamountandbuyerspremiumpercentage();

	}

	/**
	 * add a new range: new starting range in between 2 existing ones
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Buyers_Premium_Add_a_New_Range_Specify_a_Starting_Amount_Between_2_Existing_Ones_and_Increment(
			String adminUserName, String adminPassword, String Name) throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"add a new range: specify new starting amount in between 2 existing ones and increment For Timed Sale Feature,"
				+ "TestCase Name: 5.40 add a new "
				+ "range: specify new starting amount in between 2 existing ones and increment For Timed Sale Feature.");

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.BuyersPremium_specifyastartingamountbetween2existingonesandincrement();

	}

	/**
	 * Delete an existing range
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Buyers_Premium_Delete_an_Existing_Range(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"Delete an existing range Feature,TestCase Name: 5.41 Delete an existing range Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Delete_Buyers_Premium_Live_Online_Auction_Range_Field();

	}

	/**
	 * For an existing range, try to modify the starting range value
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Buyers_Premium_For_an_Existing_Range_Try_To_Modify_The_Starting_Range_Value(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"For an existing range, try to modify the starting range value Feature,TestCase Name: 5.42 "
				+ "For an existing range, try to modify the starting range value Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.BuyersPremium_Trytomodifythestartingrangevalue();

	}

	/**
	 * For an existing range, try to modify the BP percentage value
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void For_an_Existing_Range_Try_To_Modify_The_BP_Percentage_Value(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"For an existing range, try to modify the BP percentage value Feature,TestCase Name: 5.43 "
				+ "For an existing range, try to modify the BP percentage value Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.TrytomodifytheBPpercentagevalue();

	}

	/**
	 * start a lot and sell at price in 1st range
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void BP_Range_Lot_Starting_Bid_50_Live(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\" start a lot and sell at price in 1st range Feature,TestCase Name: 5.44 "
				+ "start a lot and sell at price in 1st range Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.setting_Auto_Create_And_Floor_Buyer_Active();
		adminDashboardPage.Buyers_Premium_Live_Online_Auctions_Range_Setting();
		// adminDashboardPage.Internet_Buyer_Premium_0_Disable();

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		adminDashboardPage.approveBidder1_2();

		String lotName1 = adminDashboardPage.Lot_Starting_Bid_50();
		String lotName2 = adminDashboardPage.Lot_Starting_Bid_50();

		// adminDashboardPage.Remove_Auction_Specific_Minimum_Buyer_Premium();

		String floorbidder = adminDashboardPage.RunLiveSale_PostFloor_and_Sold_Lot(); // Post
																						// floor
		// bid and
		// sold lot

		adminDashboardPage.generate_Invoice_With_Random_Bidder(auctionName, floorbidder);
		adminDashboardPage.Verify_Buyers_Premium_Tab_with_bidder(auctionName, saleno, floorbidder);
		adminDashboardPage.Verify_BP_25();
		adminDashboardPage.front();

		// login User 1
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
																			// Bid
																			// and
																			// sold
																			// lot

		adminDashboardPage.Generate_Invoice(auctionName); // Generate Invoices

		adminDashboardPage.Verify_Buyers_Premium_Tab1(auctionName, saleno);
		adminDashboardPage.Verify_BP_25();

	}

	/**
	 * start a lot and sell at price in 1st range
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void BP_Range_Lot_Starting_Bid_200_Live(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\" start a lot and sell at price in 1st range Feature,TestCase Name: 5.45 "
				+ "start a lot and sell at price in 1st range Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.setting_Auto_Create_And_Floor_Buyer_Active();
		adminDashboardPage.Buyers_Premium_Live_Online_Auctions_Range_Setting();
		// adminDashboardPage.Internet_Buyer_Premium_0_Disable();

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		adminDashboardPage.approveBidder1_2();

		String lotName1 = adminDashboardPage.Lot_Starting_Bid_200();
		String lotName2 = adminDashboardPage.Lot_Starting_Bid_200();
		// adminDashboardPage.Remove_Auction_Specific_Minimum_Buyer_Premium();
		String floorbidder = adminDashboardPage.RunLiveSale_PostFloor_and_Sold_Lot(); // Post
																						// floor
		// bid and
		// sold lot

		adminDashboardPage.generate_Invoice_With_Random_Bidder(auctionName, floorbidder);

		adminDashboardPage.Verify_Buyers_Premium_Tab_with_bidder(auctionName, saleno, floorbidder);
		adminDashboardPage.Verify_BP_100();
		adminDashboardPage.front();

		// login User 1
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
																			// Bid
																			// and
																			// sold
																			// lot

		adminDashboardPage.Generate_Invoice(auctionName); // Generate Invoices

		adminDashboardPage.Verify_Buyers_Premium_Tab1(auctionName, saleno);
		adminDashboardPage.Verify_BP_100();
	}

	/**
	 * start a lot and sell at price in 1st range
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void BP_Range_Lot_Starting_Bid_15000_Live(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\" start a lot and sell at price in 1st range Feature,TestCase Name: 5.46 "
				+ "start a lot and sell at price in 1st range Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.setting_Auto_Create_And_Floor_Buyer_Active();
		adminDashboardPage.Buyers_Premium_Live_Online_Auctions_Range_Setting();
		// adminDashboardPage.Internet_Buyer_Premium_0_Disable();

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		adminDashboardPage.approveBidder1_2();

		String lotName1 = adminDashboardPage.Lot_Starting_Bid_15000();
		String lotName2 = adminDashboardPage.Lot_Starting_Bid_15000();
		// adminDashboardPage.Remove_Auction_Specific_Minimum_Buyer_Premium();
		String floorbidder = adminDashboardPage.RunLiveSale_PostFloor_and_Sold_Lot(); // Post
																						// floor
		// bid and
		// sold lot

		adminDashboardPage.generate_Invoice_With_Random_Bidder(auctionName, floorbidder);
		adminDashboardPage.Verify_Buyers_Premium_Tab_with_bidder(auctionName, saleno, floorbidder);
		adminDashboardPage.Verify_BP_1500();
		adminDashboardPage.front();

		// login User 1
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
																			// Bid
																			// and
																			// sold
																			// lot

		adminDashboardPage.Generate_Invoice(auctionName); // Generate Invoices

		adminDashboardPage.Verify_Buyers_Premium_Tab1(auctionName, saleno);
		adminDashboardPage.Verify_BP_1500();
	}

	/**
	 * start a lot and sell at price in 1st range
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void BP_Range_Lot_Starting_Bid_50_Live1(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\" start a lot and sell at price in 1st range Feature,TestCase Name: 5.47 "
				+ "start a lot and sell at price in 1st range Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.setting_Auto_Create_And_Floor_Buyer_Active();

		// adminDashboardPage.Enable_Minimum_BP_Settings(); // Enable Minimum BP
		// settings
		adminDashboardPage.Buyers_Premium_Live_Online_Auctions_Range_Setting();
		// adminDashboardPage.Minimum_Buyer_Premium_100_Setting_Step_Down_Calculation_Disable();

		adminDashboardPage.Internet_Buyer_Premium_00();
		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		adminDashboardPage.approveBidder1_2();

		String lotName1 = adminDashboardPage.Lot_Starting_Bid_50();
		String lotName2 = adminDashboardPage.Lot_Starting_Bid_50();
		// adminDashboardPage.Remove_Auction_Specific_Minimum_Buyer_Premium();
		String floorbidder = adminDashboardPage.RunLiveSale_PostFloor_and_Sold_Lot(); // Post
																						// floor
		// bid and
		// sold lot

		adminDashboardPage.generate_Invoice_With_Random_Bidder(auctionName, floorbidder);
		adminDashboardPage.Verify_Buyers_Premium_Tab_with_bidder(auctionName, saleno, floorbidder);
		adminDashboardPage.Verify_BP_100();
		adminDashboardPage.front();

		// login User 1
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
																			// Bid
																			// and
																			// sold
																			// lot

		adminDashboardPage.Generate_Invoice(auctionName); // Generate Invoices

		adminDashboardPage.Verify_Buyers_Premium_Tab1(auctionName, saleno);
		adminDashboardPage.Verify_BP_100(); // Verify
											// BP
											// Tab
											// from
		// Invocies
	}

	/**
	 * start a lot and sell at price in 1st range
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void BP_Range_Lot_Starting_Bid_15000_Live1(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\" start a lot and sell at price in 1st range Feature,TestCase Name: 5.48 "
				+ "start a lot and sell at price in 1st range Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Enable_Minimum_BP_Settings(); // Enable Minimum BP
															// settings
		adminDashboardPage.Buyers_Premium_Live_Online_Auctions_Range_Setting();
		adminDashboardPage.Minimum_Buyer_Premium_100_Setting_Step_Down_Calculation_Disable();
		adminDashboardPage.Internet_Buyer_Premium_00();
		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		adminDashboardPage.approveBidder1_2();

		String lotName1 = adminDashboardPage.Lot_Starting_Bid_15000();
		String lotName2 = adminDashboardPage.Lot_Starting_Bid_15000();
		adminDashboardPage.Remove_Auction_Specific_Minimum_Buyer_Premium();
		String floorbidder = adminDashboardPage.RunLiveSale_PostFloor_and_Sold_Lot(); // Post
																						// floor
		// bid and
		// sold lot
		adminDashboardPage.generate_Invoice_With_Random_Bidder(auctionName, floorbidder);
		adminDashboardPage.Verify_Buyers_Premium_Tab1(auctionName, saleno);
		adminDashboardPage.Verify_BP_1500();
		adminDashboardPage.front();

		// login User 1
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
																			// Bid
																			// and
																			// sold
																			// lot

		adminDashboardPage.Generate_Invoice(auctionName); // Generate Invoices

		adminDashboardPage.Verify_Buyers_Premium_Tab1(auctionName, saleno);
		adminDashboardPage.Verify_BP_1500();
		// Verify
		// BP
		// Tab
		// from
		// Invocies
	}

	/**
	 * start a lot and sell at price in 1st range
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void BP_Range_Lot_Starting_Bid_50_Live2(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\" start a lot and sell at price in 1st range Feature,TestCase Name: 5.49 "
				+ "start a lot and sell at price in 1st range Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Disable_Minimum_BP_Settings(); // Enable Minimum BP
															// settings
		adminDashboardPage.Buyers_Premium_Live_Online_Auctions_Range_Setting();
		adminDashboardPage.Minimum_Buyer_Premium_0_Setting_Step_Down_Calculation_Disable();
		adminDashboardPage.Internet_Buyer_Premium_3();

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		adminDashboardPage.approveBidder1_2();

		String lotName1 = adminDashboardPage.Lot_Starting_Bid_50();
		String lotName2 = adminDashboardPage.Lot_Starting_Bid_50();
		adminDashboardPage.Remove_Auction_Specific_Minimum_Buyer_Premium();
		String floorbidder = adminDashboardPage.RunLiveSale_PostFloor_and_Sold_Lot(); // Post
																						// floor
		// bid and
		// sold lot

		adminDashboardPage.generate_Invoice_With_Random_Bidder(auctionName, floorbidder);
		adminDashboardPage.Verify_Buyers_Premium_Tab1(auctionName, saleno);
		adminDashboardPage.Verify_BP_25();
		adminDashboardPage.front();

		// login User 1
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
																			// Bid
																			// and
																			// sold
																			// lot

		adminDashboardPage.Generate_Invoice(auctionName); // Generate Invoices

		adminDashboardPage.Verify_Buyers_Premium_Tab1(auctionName, saleno);
		adminDashboardPage.Verify_BP_11_5_Internet_Buyer();// Verify
															// BP
															// Tab
															// from
		// Invocies
	}

	/**
	 * start a lot and sell at price in 1st range
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void BP_Range_Lot_Starting_Bid_15000_Live2(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();

		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\" start a lot and sell at price in 1st range Feature,TestCase Name: 5.50 "
				+ "start a lot and sell at price in 1st range Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Disable_Minimum_BP_Settings(); // Enable Minimum BP
															// settings
		adminDashboardPage.Buyers_Premium_Live_Online_Auctions_Range_Setting();
		adminDashboardPage.Internet_Buyer_Premium_0_Enable(); // Stepdown enable

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		adminDashboardPage.approveBidder1_2();

		String lotName1 = adminDashboardPage.Lot_Starting_Bid_15000();
		String lotName2 = adminDashboardPage.Lot_Starting_Bid_15000();
		String floorbidder = adminDashboardPage.RunLiveSale_PostFloor_and_Sold_Lot(); // Post
																						// floor
		// bid and
		// sold lot

		adminDashboardPage.generate_Invoice_With_Random_Bidder(auctionName, floorbidder);
		adminDashboardPage.Verify_Buyers_Premium_Tab1(auctionName, saleno);
		adminDashboardPage.Verify_BP_1_500();
		adminDashboardPage.front();

		// login User 1
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
																			// Bid
																			// and
																			// sold
																			// lot

		adminDashboardPage.Generate_Invoice(auctionName); // Generate Invoices

		adminDashboardPage.Verify_Buyers_Premium_Tab1(auctionName, saleno);
		adminDashboardPage.Verify_BP_1_500();// Verify
												// BP
												// Tab
												// from
		// Invocies

	}

	/**
	 * start a lot and sell at price in 1st range For LiveSale
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void BP_Range_Lot_Starting_Bid_50_BP_0_Live(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();

		String saleno = common.generateRandomNumber1();
		String auctionname = common.generateRandomChars(5);

		log("Feature" + "-" + "UAT"
				+ "\" start a lot and sell at price in 1st range For TimedSale Feature,TestCase Name: 5.51"
				+ "start a lot and sell at price in 1st range For TimedSale Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		// adminDashboardPage.Enable_Minimum_BP_Settings();
		adminDashboardPage.setting_Auto_Create_And_Floor_Buyer_Active();
		adminDashboardPage.Buyers_Premium_Live_Online_Auctions_Range_Setting();

		adminDashboardPage.Internet_Buyer_Premium_0_Disable();

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		adminDashboardPage.approveBidder1_2();

		String lotName1 = adminDashboardPage.Lot_Starting_Bid_50();
		String lotName2 = adminDashboardPage.Lot_Starting_Bid_50();
		// Starting Bid 50

		adminDashboardPage.Auction_Specific_Buyer_Premium_Ranges();

		adminDashboardPage.Internet_Buyer_Premium_0_Disable_Auction_Specific();

		String floorbidder = adminDashboardPage.RunLiveSale_PostFloor_and_Sold_Lot(); // Post
																						// floor
		// bid and
		// sold lot
		String winner_bidder = adminDashboardPage.generate_Invoice_With_Random_Bidder(auctionName, floorbidder);
		adminDashboardPage.Verify_Buyers_Premium_Tab_with_bidder(auctionName, saleno, winner_bidder);
		adminDashboardPage.Verify_BP_05();
		adminDashboardPage.front();

		// login User 1
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
		// Bid
		// and
		// sold
		// lot

		adminDashboardPage.Generate_Invoice(auctionName); // Generate Invoices

		adminDashboardPage.Verify_Buyers_Premium_Tab1(auctionName, saleno);
		adminDashboardPage.Verify_BP_05();

	}

	/**
	 * start a lot and sell at price in 1st range For LiveSale
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void BP_Range_Lot_Starting_Bid_400_BP_0_Live(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		String auctionname = common.generateRandomChars(5);

		log("Feature" + "-" + "UAT"
				+ "\" start a lot and sell at price in 1st range For TimedSale Feature,TestCase Name: 5.52"
				+ "start a lot and sell at price in 1st range For TimedSale Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.setting_Auto_Create_And_Floor_Buyer_Active();
		// adminDashboardPage.Enable_Minimum_BP_Settings();
		adminDashboardPage.Buyers_Premium_Live_Online_Auctions_Range_Setting();

		adminDashboardPage.Internet_Buyer_Premium_0_Disable();

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		adminDashboardPage.approveBidder1_2();

		String lotName1 = adminDashboardPage.Lot_Starting_Bid_400();
		String lotName2 = adminDashboardPage.Lot_Starting_Bid_400();
		// Starting Bid 50

		adminDashboardPage.Auction_Specific_Buyer_Premium_Ranges();

		adminDashboardPage.Internet_Buyer_Premium_0_Disable_Auction_Specific();

		String floorbidder = adminDashboardPage.RunLiveSale_PostFloor_and_Sold_Lot(); // Post
																						// floor
		// bid and
		// sold lot
		adminDashboardPage.generate_Invoice_With_Random_Bidder(auctionName, floorbidder);
		adminDashboardPage.Verify_Buyers_Premium_Tab1(auctionName, saleno);
		adminDashboardPage.Verify_BP_32();
		adminDashboardPage.front();

		// login User 1
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
		// Bid
		// and
		// sold
		// lot

		adminDashboardPage.Generate_Invoice(auctionName); // Generate Invoices

		adminDashboardPage.Verify_Buyers_Premium_Tab1(auctionName, saleno);
		adminDashboardPage.Verify_BP_32();

	}

	/**
	 * start a lot and sell at price in 1st range For LiveSale
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void BP_Range_Lot_Starting_Bid_15000_BP_0_Live(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		String auctionname = common.generateRandomChars(5);

		log("Feature" + "-" + "UAT"
				+ "\" start a lot and sell at price in 1st range For TimedSale Feature,TestCase Name: 5.53"
				+ "start a lot and sell at price in 1st range For TimedSale Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.setting_Auto_Create_And_Floor_Buyer_Active();
		// adminDashboardPage.Enable_Minimum_BP_Settings();
		adminDashboardPage.Buyers_Premium_Live_Online_Auctions_Range_Setting();

		adminDashboardPage.Internet_Buyer_Premium_0_Disable();

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		adminDashboardPage.approveBidder1_2();

		String lotName1 = adminDashboardPage.Lot_Starting_Bid_15000();
		String lotName2 = adminDashboardPage.Lot_Starting_Bid_15000();
		// Starting Bid 50

		adminDashboardPage.Auction_Specific_Buyer_Premium_Ranges();

		adminDashboardPage.Internet_Buyer_Premium_0_Disable_Auction_Specific();

		String floorbidder = adminDashboardPage.RunLiveSale_PostFloor_and_Sold_Lot(); // Post
																						// floor
		// bid and
		// sold lot
		adminDashboardPage.generate_Invoice_With_Random_Bidder(auctionName, floorbidder);
		adminDashboardPage.Verify_Buyers_Premium_Tab1(auctionName, saleno);
		adminDashboardPage.Verify_BP_300();
		adminDashboardPage.front();

		// login User 1
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
		// Bid
		// and
		// sold
		// lot

		adminDashboardPage.Generate_Invoice(auctionName); // Generate Invoices

		adminDashboardPage.Verify_Buyers_Premium_Tab1(auctionName, saleno);
		adminDashboardPage.Verify_BP_300();

	}

	/**
	 * start a lot and sell at price in 1st range For LiveSale
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void BP_Range_Lot_Starting_Bid_200_BP_0_Live(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		String auctionname = common.generateRandomChars(5);

		log("Feature" + "-" + "UAT"
				+ "\" start a lot and sell at price in 1st range For TimedSale Feature,TestCase Name: 5.54"
				+ "start a lot and sell at price in 1st range For TimedSale Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Enable_Minimum_BP_Settings();

		adminDashboardPage.setting_Auto_Create_And_Floor_Buyer_Active();
		adminDashboardPage.Buyers_Premium_Live_Online_Auctions_Range_Setting();

		adminDashboardPage.Minimum_Buyer_Premium_100_Disable();

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		adminDashboardPage.approveBidder1_2();

		String lotName1 = adminDashboardPage.Lot_Starting_Bid_200();
		String lotName2 = adminDashboardPage.Lot_Starting_Bid_200();
		// Starting Bid 50

		adminDashboardPage.Auction_Specific_Buyer_Premium_Ranges();

		adminDashboardPage.Internet_Buyer_Premium_200_Disable_Auction_Specific();

		String floorbidder = adminDashboardPage.RunLiveSale_PostFloor_and_Sold_Lot(); // Post
																						// floor
		// bid and
		// sold lot
		adminDashboardPage.generate_Invoice_With_Random_Bidder(auctionName, floorbidder);
		adminDashboardPage.Verify_Buyers_Premium_Tab1(auctionName, saleno);

		adminDashboardPage.front();

		// login User 1
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
		// Bid
		// and
		// sold
		// lot

		adminDashboardPage.Generate_Invoice(auctionName); // Generate Invoices

		adminDashboardPage.Verify_Buyers_Premium_Tab1(auctionName, saleno);

	}

	/**
	 * start a lot and sell at price in 1st range For LiveSale
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void BP_Range_Lot_Starting_Bid_15000_BP_0_Live1(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		String auctionname = common.generateRandomChars(5);

		log("Feature" + "-" + "UAT"
				+ "\" start a lot and sell at price in 1st range For TimedSale Feature,TestCase Name: 5.55"
				+ "start a lot and sell at price in 1st range For TimedSale Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Enable_Minimum_BP_Settings();
		adminDashboardPage.Buyers_Premium_Live_Online_Auctions_Range_Setting();

		adminDashboardPage.Minimum_Buyer_Premium_100_Disable();

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		adminDashboardPage.approveBidder1_2();

		String lotName1 = adminDashboardPage.Lot_Starting_Bid_15000();
		String lotName2 = adminDashboardPage.Lot_Starting_Bid_15000();
		// Starting Bid 50

		adminDashboardPage.Auction_Specific_Buyer_Premium_Ranges();

		adminDashboardPage.Internet_Buyer_Premium_200_Disable_Auction_Specific();

		String floorbidder = adminDashboardPage.RunLiveSale_PostFloor_and_Sold_Lot(); // Post
																						// floor
		// bid and
		// sold lot
		adminDashboardPage.generate_Invoice_With_Random_Bidder(auctionName, floorbidder);
		adminDashboardPage.Verify_Buyers_Premium_Tab1(auctionName, saleno);
		adminDashboardPage.Verify_BP_300();
		adminDashboardPage.front();

		// login User 1
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
		// Bid
		// and
		// sold
		// lot

		adminDashboardPage.Generate_Invoice(auctionName); // Generate Invoices

		adminDashboardPage.Verify_Buyers_Premium_Tab1(auctionName, saleno);

	}

	/**
	 * start a lot and sell at price in 1st range For LiveSale
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void BP_Range_Lot_Starting_Bid_50_BP_0_Live1(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		String auctionname = common.generateRandomChars(5);

		log("Feature" + "-" + "UAT"
				+ "\" start a lot and sell at price in 1st range For TimedSale Feature,TestCase Name: 5.56"
				+ "start a lot and sell at price in 1st range For TimedSale Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.setting_Auto_Create_And_Floor_Buyer_Active();
		// adminDashboardPage.Disable_Minimum_BP_Settings(); // Enable minimum
		// buyer
		// premium
		adminDashboardPage.Buyers_Premium_Live_Online_Auctions_Range_Setting();

		adminDashboardPage.Internet_Buyer_Premium_3(); // Buyer Premium

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		adminDashboardPage.approveBidder1_2();

		String lotName1 = adminDashboardPage.Lot_Starting_Bid_50();
		String lotName2 = adminDashboardPage.Lot_Starting_Bid_50();
		// Starting Bid 50

		adminDashboardPage.Auction_Specific_Buyer_Premium_Ranges();

		adminDashboardPage.Internet_Buyer_Premium_Specific_Auction_5(); // Buyer
																		// Premium

		String floorbidder = adminDashboardPage.RunLiveSale_PostFloor_and_Sold_Lot(); // Post
		// floor
		// bid and
		// sold lot
		adminDashboardPage.generate_Invoice_With_Random_Bidder(auctionName, floorbidder);
		adminDashboardPage.Verify_Buyers_Premium_Tab1(auctionName, saleno);
		adminDashboardPage.Verify_BP_05();
		adminDashboardPage.front();

		// login User 2
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
		// Bid
		// and
		// sold
		// lot

		adminDashboardPage.Generate_Invoice(auctionName); // Generate Invoices
		adminDashboardPage.Verify_Buyers_Premium_Tab1(auctionName, saleno);
		adminDashboardPage.Verify_BP_7_5();
	}

	/**
	 * start a lot and sell at price in 1st range For LiveSale
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void BP_Range_Lot_Starting_Bid_15000_BP_0_Live2(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		String auctionname = common.generateRandomChars(5);

		log("Feature" + "-" + "UAT"
				+ "\" start a lot and sell at price in 1st range For TimedSale Feature,TestCase Name: 5.57"
				+ "start a lot and sell at price in 1st range For TimedSale Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Disable_Minimum_BP_Settings(); // Enable minimum
															// buyer
															// premium
		adminDashboardPage.Buyers_Premium_Live_Online_Auctions_Range_Setting();

		adminDashboardPage.Internet_Buyer_Premium_0_Enable(); // Buyer Premium

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		adminDashboardPage.approveBidder1_2();

		String lotName1 = adminDashboardPage.Lot_Starting_Bid_15000();
		String lotName2 = adminDashboardPage.Lot_Starting_Bid_15000();
		// Starting Bid 50

		adminDashboardPage.Auction_Specific_Buyer_Premium_Ranges();

		adminDashboardPage.Internet_Buyer_Premium_Specific_Auction_0(); // Buyer
																		// Premium

		String floorbidder = adminDashboardPage.RunLiveSale_PostFloor_and_Sold_Lot(); // Post
		// floor
		// bid and
		// sold lot
		adminDashboardPage.generate_Invoice_With_Random_Bidder(auctionName, floorbidder);
		adminDashboardPage.Verify_Buyers_Premium_Tab1(auctionName, saleno);
		// adminDashboardPage.Verify_BP_755();
		adminDashboardPage.front();

		// login User 2
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
		// Bid
		// and
		// sold
		// lot

		adminDashboardPage.Generate_Invoice(auctionName); // Generate Invoices
		adminDashboardPage.Verify_Buyers_Premium_Tab1(auctionName, saleno);
		// adminDashboardPage.Verify_BP_755();

	}

	/**
	 * Remove all existing ranges
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Buyers_Premium_Remove_All_Existing_Ranges_For_TimedSale(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\" Remove all existing ranges Feature,TestCase Name: 5.58 "
				+ " Remove all existing ranges Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Delete_Buyers_Premium_Time_Online_Auction_Range_Field();

	}

	/**
	 * add a new range: do not specify the starting amount
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Buyers_Premium_Add_a_New_Range_Do_Not_Specify_The_Starting_Amount_For_TimedSale(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"add a new range: do not specify the starting amount Feature,TestCase Name: 5.59 add a new range: do not specify the starting amount Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.BuyersPremium_RemoveallexistingrangesForTimedSale();
		adminDashboardPage.BuyersPremium_verifyaddanewrange_donotspecifythestartingamountForTimedSale();

	}

	/**
	 * add a new range: leave "0" in the starting range field
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Buyers_Premium_Add_a_New_Range_Leave_0_In_The_Starting_Range_For_TimedSale(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"add a new range: leave '0' in the starting range field Feature,TestCase Name: 5.60 add a new range: leave '0' in the starting range field Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.BuyersPremium_verifyaddanewrange_leave0inthestartingrangeForTimedSale();

	}

	/**
	 * add a new range: do not specify the BP percentage
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Buyers_Premium_Add_a_New_Range_Do_Not_Specify_The_BP_Percentage_For_TimedSale(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"add a new range: do not specify the BP percentage Feature,TestCase Name: 5.61 add a new range: do not specify the BP percentage Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.BuyersPremium_verifyaddanewrange_donotspecifytheBPpercentageForTimedSale();

	}

	/**
	 * add a new range: leave "0" in the buyers premium field
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Buyers_Premium_Add_a_New_Range_Leave_0_In_The_Buyers_Premium_Field_For_TimedSale(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"add a new range:  leave '0' in the buyers premium field Feature,TestCase Name: 5.62 add a new range: leave '0' in the buyers premium field Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.BuyersPremium_verifyaddanewrange_leave0inthebuyerspremiumfieldForTimedSale();

	}

	/**
	 * add a new range:specify a starting amount that is already existing
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Buyers_Premium_Add_a_New_Range_Specify_a_Starting_Amount_That_Is_Already_Existing_For_TimedSale(
			String adminUserName, String adminPassword, String Name) throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"add a new range:  specify a starting amount that is already existing Feature,TestCase Name: 5.63 add a new range: specify a starting amount that is already existing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.BuyersPremium_verifyaddanewrange_specifyastartingamountthatisalreadyexistingForTimedSale();

	}

	/**
	 * add a new range:specify new starting amount and buyers premium percentage
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Buyers_Premium_Add_a_New_Range_Specify_New_Starting_Amount_and_Buyers_Premium_Percentage_For_TimedSale(
			String adminUserName, String adminPassword, String Name) throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"add a new range:  specify new starting amount and buyers premium percentage Feature,"
				+ "TestCase Name: 5.64 add a new range: specify new starting amount and buyers premium percentage Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage
				.BuyersPremium_verifyaddanewrange_specifynewstartingamountandbuyerspremiumpercentageForTimedSale();

	}

	/**
	 * add a new range: new starting range in between 2 existing ones
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Buyers_Premium_Add_a_New_Range_Specify_As_Tarting_Amount_ABetween_2_Existing_Ones_and_Increment_For_TimedSale(
			String adminUserName, String adminPassword, String Name) throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"add a new range: specify new starting amount in between 2 existing ones and increment For Timed Sale Feature,"
				+ "TestCase Name: 5.65 add a new "
				+ "range: specify new starting amount in between 2 existing ones and increment For Timed Sale Feature.");

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.BuyersPremium_specifyastartingamountbetween2existingonesandincrementForTimedSale();

	}

	/**
	 * Delete an existing range
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Buyers_Premium_Delete_an_Existing_Range_For_TimedSale(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"Delete an existing range Feature,TestCase Name: 5.66 Delete an existing range Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Delete_Buyers_Premium_Time_Online_Auction_Range_Field(); // Delete
																					// Buyers
																					// Premium
																					// Existing
																					// Ranges

	}

	/**
	 * For an existing range, try to modify the starting range value
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Buyers_Premium_For_an_Existing_Range_Try_To_Modify_The_Starting_Range_Value_For_TimedSale(
			String adminUserName, String adminPassword, String Name) throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"For an existing range, try to modify the starting range value Feature,TestCase Name: 5.67 "
				+ "For an existing range, try to modify the starting range value Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.BuyersPremium_Trytomodifythestartingrangevalue();

	}

	/**
	 * For an existing range, try to modify the BP percentage value
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void For_an_Existing_Range_Try_To_Modify_The_BP_Percentage_Value_For_TimedSale(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"For an existing range, try to modify the BP percentage value Feature,TestCase Name: 5.68 "
				+ "For an existing range, try to modify the BP percentage value Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.TrytomodifytheBPpercentagevalueForTimedSale();

	}

	/**
	 * start a lot and sell at price in 1st range For TimedSale
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void BP_Range_Lot_Starting_Bid_50_Timed(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		String saleno = common.generateRandomNumber1();

		String auctionname = common.generateRandomChars(5);

		log("Feature" + "-" + "UAT"
				+ "\" start a lot and sell at price in 1st range For TimedSale Feature,TestCase Name: 5.69 "
				+ "start a lot and sell at price in 1st range For TimedSale Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Disable_Minimum_BP_Settings();

		adminDashboardPage.Buyers_Premium_Time_Online_Auctions_Range_Setting();
		adminDashboardPage.Stepdown_Calculation_Disabled_Timed();

		String TimeAuction5Min = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		adminDashboardPage.approveBidder1_2();

		String lotName1 = adminDashboardPage.Lot_Starting_Bid_50();

		adminDashboardPage.front();

		// login User 1
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Place_Bid_Value_50_Timed_Auction_Wait_For_Sale_End(saleno, TimeAuction5Min, lotName1);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Generate_Invoice(TimeAuction5Min); // Generate
																// Invoices

		adminDashboardPage.Verify_Buyers_Premium_Tab1(TimeAuction5Min, saleno);

	}

	/**
	 * start a lot and sell at price in 1st range For TimedSale
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void BP_Range_Lot_Starting_Bid_200_Timed(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		String saleno = common.generateRandomNumber1();

		String auctionname = common.generateRandomChars(5);

		log("Feature" + "-" + "UAT"
				+ "\" start a lot and sell at price in 1st range For TimedSale Feature,TestCase Name: 5.70 "
				+ "start a lot and sell at price in 1st range For TimedSale Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Disable_Minimum_BP_Settings();

		adminDashboardPage.Buyers_Premium_Time_Online_Auctions_Range_Setting();
		adminDashboardPage.Stepdown_Calculation_Disabled_Timed();

		String TimeAuction5Min = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		adminDashboardPage.approveBidder1_2();

		String lotName1 = adminDashboardPage.Lot_Starting_Bid_200();

		adminDashboardPage.front();

		// login User 1
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Place_Bid_Value_200_Timed_Auction_Wait_For_Sale_End(saleno, TimeAuction5Min, lotName1);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Generate_Invoice(TimeAuction5Min); // Generate
																// Invoices

		adminDashboardPage.Verify_Buyers_Premium_Tab1(TimeAuction5Min, saleno);
		// adminDashboardPage.Verify_BP_200();

	}

	/**
	 * start a lot and sell at price in 1st range For TimedSale 15000
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void BP_Range_Lot_Starting_Bid_15000_Timed(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		String saleno = common.generateRandomNumber1();

		String auctionname = common.generateRandomChars(5);

		log("Feature" + "-" + "UAT"
				+ "\" start a lot and sell at price in 1st range For TimedSale Feature,TestCase Name: 5.71 "
				+ "start a lot and sell at price in 1st range For TimedSale Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Disable_Minimum_BP_Settings();

		adminDashboardPage.Buyers_Premium_Time_Online_Auctions_Range_Setting();
		adminDashboardPage.Stepdown_Calculation_Disabled_Timed();

		String TimeAuction5Min = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		adminDashboardPage.approveBidder1_2();

		String lotName1 = adminDashboardPage.Lot_Starting_Bid_15000();

		adminDashboardPage.front();

		// login User 1
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Place_Bid_Value_15000_Timed_Auction_Wait_For_Sale_End(saleno, TimeAuction5Min, lotName1);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Generate_Invoice(TimeAuction5Min); // Generate
																// Invoices

		adminDashboardPage.Verify_Buyers_Premium_Tab1(TimeAuction5Min, saleno);
		// adminDashboardPage.Verify_BP_1500();
	}

	/**
	 * start a lot and sell at price in 1st range For TimedSale BP-100
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void BP_Range_Lot_Starting_Bid_50_BP_100_Timed(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		String saleno = common.generateRandomNumber1();

		String name = common.generateRandomChars(5);

		log("Feature" + "-" + "UAT"
				+ "\" start a lot and sell at price in 1st range For TimedSale Feature,TestCase Name: 5.72 "
				+ "start a lot and sell at price in 1st range For TimedSale Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Enable_Minimum_BP_Settings(); // Enable Minimum BP
															// settings
		adminDashboardPage.Buyers_Premium_Time_Online_Auctions_Range_Setting();
		adminDashboardPage.Minimum_Buyer_Premium_100_Setting_Step_Down_Calculation_Disable_Timed();

		String TimeAuction5Min = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		adminDashboardPage.approveBidder1_2();

		String lotName1 = adminDashboardPage.Lot_Starting_Bid_50();

		adminDashboardPage.Remove_Auction_Specific_Minimum_Buyer_Premium();

		adminDashboardPage.front();

		// login User 1
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Place_Bid_Value_50_Timed_Auction_Wait_For_Sale_End(saleno, TimeAuction5Min, lotName1);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Generate_Invoice(TimeAuction5Min); // Generate
																// Invoices

		adminDashboardPage.Verify_Buyers_Premium_Tab1(TimeAuction5Min, saleno);
		// adminDashboardPage.Verify_BP_100();
	}

	/**
	 * start a lot and sell at price in 1st range For TimedSale
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void BP_Range_Lot_Starting_Bid_15000_BP_100_Timed(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		String saleno = common.generateRandomNumber1();

		String name = common.generateRandomChars(5);

		log("Feature" + "-" + "UAT"
				+ "\" start a lot and sell at price in 1st range For TimedSale Feature,TestCase Name: 5.73"
				+ "start a lot and sell at price in 1st range For TimedSale Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Enable_Minimum_BP_Settings(); // Enable Minimum BP
															// settings
		adminDashboardPage.Buyers_Premium_Time_Online_Auctions_Range_Setting();
		adminDashboardPage.Minimum_Buyer_Premium_100_Setting_Step_Down_Calculation_Disable_Timed();

		String TimeAuction5Min = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		adminDashboardPage.approveBidder1_2();

		String lotName1 = adminDashboardPage.Lot_Starting_Bid_15000();

		adminDashboardPage.Remove_Auction_Specific_Minimum_Buyer_Premium();

		adminDashboardPage.front();

		// login User 1
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Place_Bid_Value_15000_Timed_Auction_Wait_For_Sale_End(saleno, TimeAuction5Min, lotName1);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Generate_Invoice(TimeAuction5Min); // Generate
																// Invoices

		adminDashboardPage.Verify_Buyers_Premium_Tab1(TimeAuction5Min, saleno);
		adminDashboardPage.Verify_BP_1500();

	}

	/* 5.74 Test Case Not Present. */

	/**
	 * start a lot and sell at price in 1st range For TimedSale
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void BP_Range_Lot_Starting_Bid_15000_BP_0_Timed(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		String saleno = common.generateRandomNumber1();

		String name = common.generateRandomChars(5);

		log("Feature" + "-" + "UAT"
				+ "\" start a lot and sell at price in 1st range For TimedSale Feature,TestCase Name: 5.75"
				+ "start a lot and sell at price in 1st range For TimedSale Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Disable_Minimum_BP_Settings(); // Enable Minimum BP
															// settings
		adminDashboardPage.Buyers_Premium_Time_Online_Auctions_Range_Setting();
		adminDashboardPage.Step_Down_Enable_Timed(); // Stepdown enable

		String auctionName = adminDashboardPage.create_TimedAuction_5_Minute(saleno);
		adminDashboardPage.approveBidder1_2();

		String lotName1 = adminDashboardPage.Lot_Starting_Bid_15000();

		adminDashboardPage.front();

		// login User 1
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Place_Bid_Value_15000_Timed_Auction_Wait_For_Sale_End(saleno, auctionName, lotName1);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Generate_Invoice(auctionName); // Generate Invoices

		adminDashboardPage.Verify_Buyers_Premium_Tab1(auctionName, saleno);
		adminDashboardPage.Verify_BP_1_500();
	}

	/**
	 * start a lot and sell at price in 1st range For TimedSale
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void BP_Range_Lot_Starting_Bid_50_BP_0_Timed(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		String saleno = common.generateRandomNumber1();

		String auctionname = common.generateRandomChars(5);

		log("Feature" + "-" + "UAT"
				+ "\" start a lot and sell at price in 1st range For TimedSale Feature,TestCase Name: 5.76"
				+ "start a lot and sell at price in 1st range For TimedSale Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Enable_Minimum_BP_Settings();
		adminDashboardPage.Buyers_Premium_Time_Online_Auctions_Range_Setting();

		adminDashboardPage.Stepdown_Calculation_Disabled_Timed();

		String auctionName = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		adminDashboardPage.approveBidder1_2();

		String lotName1 = adminDashboardPage.Lot_Starting_Bid_50();

		// Starting Bid 50

		adminDashboardPage.Auction_Specific_Buyer_Premium_Ranges();

		adminDashboardPage.Stepdown_Calculation_Disabled_Auction_Specific_Timed();

		adminDashboardPage.front();

		// login User 1
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Place_Bid_Value_50_Timed_Auction_Wait_For_Sale_End(saleno, auctionName, lotName1);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Generate_Invoice(auctionName); // Generate Invoices

		adminDashboardPage.Verify_Buyers_Premium_Tab1(auctionName, saleno);
		// adminDashboardPage.Verify_BP_05();
	}

	/**
	 * start a lot and sell at price in 1st range For TimedSale
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void BP_Range_Lot_Starting_Bid_400_BP_0_Timed(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		String saleno = common.generateRandomNumber1();

		String auctionname = common.generateRandomChars(5);

		log("Feature" + "-" + "UAT"
				+ "\" start a lot and sell at price in 1st range For TimedSale Feature,TestCase Name: 5.77"
				+ "start a lot and sell at price in 1st range For TimedSale Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Enable_Minimum_BP_Settings();
		adminDashboardPage.Buyers_Premium_Time_Online_Auctions_Range_Setting();

		adminDashboardPage.Stepdown_Calculation_Disabled_Timed();

		String auctionName = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		adminDashboardPage.approveBidder1_2();

		String lotName1 = adminDashboardPage.Lot_Starting_Bid_400();

		// Starting Bid 400

		adminDashboardPage.Auction_Specific_Buyer_Premium_Ranges();

		adminDashboardPage.Stepdown_Calculation_Disabled_Auction_Specific_Timed();

		adminDashboardPage.front();

		// login User 1
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Place_Bid_Value_400_Timed_Auction_Wait_For_Sale_End(saleno, auctionName, lotName1);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Generate_Invoice(auctionName); // Generate Invoices

		adminDashboardPage.Verify_Buyers_Premium_Tab1(auctionName, saleno);
		// adminDashboardPage.Verify_BP_32();

	}

	/**
	 * start a lot and sell at price in 1st range For TimedSale
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void BP_Range_Lot_Starting_Bid_15000_BP1_0_Timed(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		String saleno = common.generateRandomNumber1();

		String auctionname = common.generateRandomChars(5);

		log("Feature" + "-" + "UAT"
				+ "\" start a lot and sell at price in 1st range For TimedSale Feature,TestCase Name: 5.78"
				+ "start a lot and sell at price in 1st range For TimedSale Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Enable_Minimum_BP_Settings();
		adminDashboardPage.Buyers_Premium_Time_Online_Auctions_Range_Setting();

		adminDashboardPage.Stepdown_Calculation_Disabled_Timed();

		String auctionName = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		adminDashboardPage.approveBidder1_2();

		String lotName1 = adminDashboardPage.Lot_Starting_Bid_15000();

		// Starting Bid 15000

		adminDashboardPage.Auction_Specific_Buyer_Premium_Ranges();

		adminDashboardPage.Stepdown_Calculation_Disabled_Auction_Specific_Timed();

		adminDashboardPage.front();

		// login User 1
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Place_Bid_Value_15000_Timed_Auction_Wait_For_Sale_End(saleno, auctionName, lotName1);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Generate_Invoice(auctionName); // Generate Invoices

		adminDashboardPage.Verify_Buyers_Premium_Tab1(auctionName, saleno);
		// adminDashboardPage.Verify_BP_300();

	}

	/**
	 * start a lot and sell at price in 1st range For TimedSale
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void BP_Range_Lot_Starting_Bid_15000_BP1_100_Timed(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		String saleno = common.generateRandomNumber1();

		String auctionname = common.generateRandomChars(5);

		log("Feature" + "-" + "UAT"
				+ "\" start a lot and sell at price in 1st range For TimedSale Feature,TestCase Name: 5.79"
				+ "start a lot and sell at price in 1st range For TimedSale Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Enable_Minimum_BP_Settings(); // Enable Minimum BP
															// checkbox
		adminDashboardPage.Buyers_Premium_Time_Online_Auctions_Range_Setting();
		adminDashboardPage.Minimum_Buyer_Premium_100_Disable_Timed(); // Disable
																		// StepDown
																		// Calculation
		// adminDashboardPage.Internet_Buyer_Premium_0_Disable();

		String TimeAuction5Min = adminDashboardPage.create_TimedAuction_5_Minute(saleno);
		adminDashboardPage.approveBidder1();
		String lotName1 = adminDashboardPage.Lot_Starting_Bid_50();
		// Starting Bid 50

		adminDashboardPage.Auction_Specific_Buyer_Premium_Ranges();

		adminDashboardPage.Minimum_Buyer_Premium_200_Setting_Step_Down_Calculation_Disable(); // Disable
																								// StepDown
																								// Calculation
		// adminDashboardPage.Internet_Buyer_Premium_0_Disable(); // Internet
		// premium 0

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Place_Bid_Value_50_Timed_Auction_Wait_For_Sale_End(saleno, TimeAuction5Min, lotName1);

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Generate_Invoice(TimeAuction5Min);
		adminDashboardPage.Verify_Buyers_Premium_Tab1(TimeAuction5Min, saleno);

	}

	/**
	 * start a lot and sell at price in 1st range For TimedSale
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void BP_Range_Lot_Starting_Bid_15000_BP1_200_Timed(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		String saleno = common.generateRandomNumber1();

		String auctionname = common.generateRandomChars(5);

		log("Feature" + "-" + "UAT"
				+ "\" start a lot and sell at price in 1st range For TimedSale Feature,TestCase Name: 5.80"
				+ "start a lot and sell at price in 1st range For TimedSale Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Enable_Minimum_BP_Settings(); // Enable Minimum BP
															// checkbox
		adminDashboardPage.Buyers_Premium_Time_Online_Auctions_Range_Setting();
		adminDashboardPage.Minimum_Buyer_Premium_100_Disable_Timed(); // Disable
																		// StepDown
																		// Calculation
		// adminDashboardPage.Internet_Buyer_Premium_0_Disable();

		String TimeAuction5Min = adminDashboardPage.create_TimedAuction_5_Minute(saleno);
		adminDashboardPage.approveBidder1();
		String lotName1 = adminDashboardPage.Lot_Starting_Bid_50();
		// Starting Bid 50

		adminDashboardPage.Auction_Specific_Buyer_Premium_Ranges();

		adminDashboardPage.Minimum_Buyer_Premium_200_Setting_Step_Down_Calculation_Disable(); // Disable
																								// StepDown
																								// Calculation
		// adminDashboardPage.Internet_Buyer_Premium_0_Disable(); // Internet
		// premium 0

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Place_Bid_Value_15000_Timed_Auction_Wait_For_Sale_End(saleno, TimeAuction5Min, lotName1);

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Generate_Invoice(TimeAuction5Min);
		adminDashboardPage.Verify_Buyers_Premium_Tab1(TimeAuction5Min, saleno);

	}

	/* 5.81 TestCase Not Present */

	/**
	 * start a lot and sell at price in 1st range For TimedSale
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void BP_Range_Lot_Starting_Bid_15000_BP1_15000_Timed(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		String saleno = common.generateRandomNumber1();

		String auctionname = common.generateRandomChars(5);

		log("Feature" + "-" + "UAT"
				+ "\" start a lot and sell at price in 1st range For TimedSale Feature,TestCase Name: 5.82"
				+ "start a lot and sell at price in 1st range For TimedSale Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Disable_Minimum_BP_Settings(); // Enable Minimum BP
															// checkbox
		adminDashboardPage.Buyers_Premium_Time_Online_Auctions_Range_Setting();
		adminDashboardPage.Step_Down_Enable_Timed(); // Disable
														// StepDown
														// Calculation
		// adminDashboardPage.Internet_Buyer_Premium_0_Disable();

		String TimeAuction5Min = adminDashboardPage.create_TimedAuction_5_Minute(saleno);
		adminDashboardPage.approveBidder1();
		String lotName1 = adminDashboardPage.Lot_Starting_Bid_15000();
		// Starting Bid 50

		adminDashboardPage.Auction_Specific_Buyer_Premium_Ranges();

		adminDashboardPage.Step_Down_Enable_Timed(); // Disable
														// StepDown
														// Calculation
		// adminDashboardPage.Internet_Buyer_Premium_0_Disable(); // Internet
		// premium 0

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Place_Bid_Value_15000_Timed_Auction_Wait_For_Sale_End(saleno, TimeAuction5Min, lotName1);

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Generate_Invoice(TimeAuction5Min);
		adminDashboardPage.Verify_Buyers_Premium_Tab1(TimeAuction5Min, saleno);
		// adminDashboardPage.Verify_BP_755();

	}

	/**
	 * start a lot and sell at price in 1st range For TimedSale
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Consignment_Commision(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		String saleno = common.generateRandomNumber1();

		String tomorrowDate = common.tomorrowDate();
		String auctionname = common.generateRandomChars(5);
		String user_name = common.generateRandomChars(4);
		String user_name1 = common.generateRandomChars(4);
		String lotName = common.generateRandomChars(4);
		String lotName1 = common.generateRandomChars(4);
		String lotName2 = common.generateRandomChars(4);
		String lotName3 = common.generateRandomChars(4);
		log("Feature" + "-" + "UAT" + "\" Consignment commission,TestCase Name: 5.83"
				+ "start a lot and sell at price in 1st range For TimedSale Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Consignment_Commission_Settings(); // Set consignment
																// commission

		String consignor1 = adminDashboardPage.Add_User_1(user_name); // add
																		// user
																		// 1
																		// without
																		// consignment
																		// tax
		String consignor2 = adminDashboardPage.Add_User_2_With_Consignment_Tax(user_name1); // add
																							// user
																							// 1
																							// with
																							// consignment
																							// tax

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1_2(); // approve bidder

//		Robot rb = new Robot();
//
//		rb.keyPress(KeyEvent.VK_META);
//		rb.keyPress(KeyEvent.VK_TAB);
//		common.pause(1);
//		rb.keyRelease(KeyEvent.VK_META);
//		rb.keyRelease(KeyEvent.VK_TAB);
		common.pause(10);

		String lot_con1 = adminDashboardPage.Add_Lot_With_Consignor_User1(lotName, consignor1);
		String lot_con2 = adminDashboardPage.Add_Lot_With_Consignor_User1(lotName1, consignor1);
		String lot_con3 = adminDashboardPage.Add_Lot_With_Consignor_Commission(lotName2, consignor2);
		String lot_con4 = adminDashboardPage.Add_Lot_With_Consignor_Commission(lotName3, consignor2);

		adminDashboardPage.start_Auction();

		adminDashboardPage.front(); // Open Front End

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Sell
																			// Lot
																			// 1

		adminDashboardPage.front(); // Open Front End

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Sell
																			// Lot
																			// 2

		adminDashboardPage.front(); // Open Front End

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Sell
																			// Lot
																			// 3

		adminDashboardPage.front(); // Open Front End

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Sell
																			// Lot
																			// 4

		adminDashboardPage.Generate_Invoice_All_Users(auctionname);

		adminDashboardPage.Generate_Settlements_and_Verify("rahul@perfect", saleno, auctionName); // Generate
		// Setellement
		// for RahulQa user

	}

	/**
	 * sales tax defined in the global settings
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Sales_Tax_Defined_In_The_Global_Settings(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();

		String tomorrowDate = common.tomorrowDate();

		String consignor1 = Common.generateRandomChars(4);
		String consignor2 = Common.generateRandomChars(4);
		//String bidder1 = Common.generateRandomChars(4);
	//	String bidder2 = Common.generateRandomChars(4);

		log("Feature" + "-" + "UAT" + "\" sales tax defined in the global settings Feature,TestCase Name: 5.84"
				+ " sales tax defined in the global settings Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.salestaxdefinedintheglobalsettings();

		// Add User
		String consignor_1 = adminDashboardPage.AddUser1withSalesTax(consignor1);
		String consignor_2 = adminDashboardPage.AddUser2withSalesTax(consignor2);
		//String bidder_1 = adminDashboardPage.AddBidder1withSalesTax(bidder1);
		//String bidder_2 = adminDashboardPage.AddBidder2withSalesTax(bidder2);

		// Create Auction
		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		adminDashboardPage.approveBidder1_2();

		// Add Lot
		adminDashboardPage.lot1(1, consignor_1);
		adminDashboardPage.lot2(1, consignor_1);
		adminDashboardPage.lot3(1, consignor_1);
		adminDashboardPage.lot4(1, consignor_1);

		adminDashboardPage.lot5(1, consignor_2);
		adminDashboardPage.lot6(1, consignor_2);
		adminDashboardPage.lot7(1, consignor_2);
		adminDashboardPage.lot8(1, consignor_2);

		adminDashboardPage.start_Auction();

		// Sell Lot 1 (Bidder 1)
		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Sell

		// Sell Lot 2 (Bidder 1)
		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Sell

		// Sell Lot 3 (Bidder 2)
		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Sell

		// Sell Lot 4 (Bidder 2)
		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Sell

		// Sell Lot 5 (Bidder 1)
		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Sell

		// Sell Lot 6 (Bidder 1)
		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Sell

		// Sell Lot 7 (Bidder 2)
		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Sell

		// Sell Lot 8 (Bidder 2)
		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Sell

		adminDashboardPage.Generate_Invoice_All_Users(auctionName); // Generate
																	// Invoices

	}

	/**
	 * Define a cash discount
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Define_Cash_Discount(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\" Define a cash discount Feature,TestCase Name: 5.85"
				+ "Define a cash discount Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Verify_Define_Cash_Discount(); // Add 2% cash
															// discount
		adminDashboardPage.Verify_Invoice_Discount(); // Verify invoice discount

	}

	/**
	 * select apply cash discount = N 5.86
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Define_Cash_Discount_N(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\" Define a cash discount Feature,TestCase Name: 5.86"
				+ "Define a cash discount Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Verify_Define_Cash_Discount(); // Add 2% cash
															// discount
		adminDashboardPage.Verify_Invoice_Discount_N(); // Verify invoice
														// discount

	}

	/**
	 * Disable minimum BP in the settings
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Disable_Minimum_BP_In_The_Settings(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\" Disable minimum BP in the settings Feature,TestCase Name: 5.87"
				+ "Disable minimum BP in the settings Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Disable_Minimum_BP_Settings();
		adminDashboardPage.Buyers_Premium();

	}

	/**
	 * Enable "Charge consignor commission directly"
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Enable_Charge_Consignor_Commission_Directly(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\" Enable Charge consignor commission directly Feature,TestCase Name: 5.88"
				+ "Enable Charge consignor commission directly Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.DisableChargeconsignorcommissiondirectly();
		adminDashboardPage.Settlement();
		adminDashboardPage.EnableChargeconsignorcommissiondirectly();
		adminDashboardPage.Settlement1();

	}

	/**
	 * 
	 * Auto generate timed and live 'Buy it now' invoices - 5.89
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Option_Active(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"Auto generate timed and live 'Buy it now' invoices >> Option Active - 5.89");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();
		String TimedAuction1 = common.generateRandomChars(3);
		String saleno = common.generateRandomNumber1();
		String user_name = common.generateRandomChars(5);
		String lotname1 = common.generateRandomChars(5);
		String lotName = null;

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Auto_Generate_Invoice_Live_Timed_Active();
		adminDashboardPage.setting_Auto_Create_And_Floor_Buyer_Active();

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName1 = adminDashboardPage.addLotRandom(1); // Add Lot
		String lotName2 = adminDashboardPage.addLotRandom(1); // Add Lot
		adminDashboardPage.AddLot_WithOut_BuyNow_Value(1); // Add Lot WithOut
															// Buy Now Value

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Buy_First_Lot_From_Catalog(saleno, auctionName, lotName1);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.search_Last_Created_Auction(saleno); // Search Last
																// Created
																// Auction
		adminDashboardPage.start_Auction();// Run Auction And Start Lot 2
		adminDashboardPage.front(); // Open Front End

		// Place Bid on Lot 2 - Front End

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		// Admin Login

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
																			// Bid
																			// and
																			// Sold
																			// The
																			// Lot
		adminDashboardPage.Post_Floor_Bid_Sell_Lot();

		String consignor1 = adminDashboardPage.Add_User_1(user_name);
		// Timed Auction

		String TimedAuction = adminDashboardPage.create_Timed_Auction(saleno);
		adminDashboardPage.approveBidder1();
		String lotName3 = adminDashboardPage.Add_Lot_With_Consignor_User1(lotname1,consignor1); // Add Lot
		String lotName4 = adminDashboardPage.AddLot_WithOut_BuyNow_Value(1); // Add
																				// Lot
																				// WithOut
		// Buy Now Value

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Buy_First_Lot_From_Catalog_Timed(saleno, TimedAuction, lotName3);
		dashboardPage.Place_Bid_Value_Timed_Auction(saleno, TimedAuction, lotName4);

		driver.get(configFileReader.getAdminUrl()); // Goto Admin
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Generate_Invoice(auctionName);

	}

	/**
	 * 
	 * Auto generate timed and live option not active invoices - 5.90
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Option_Not_Active(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Auto generate timed and live 'Buy it now' invoices >> Option Not Active - 5.90");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();
		String TimedAuction1 = common.generateRandomChars(3);
		String saleno = common.generateRandomNumber1();

		String lotName = null;

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Auto_Generate_Invoice_Live_Timed_Not_Disable(); // Option
																			// Disable
		adminDashboardPage.setting_Auto_Create_And_Floor_Buyer_Active();

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName1 = adminDashboardPage.addLotRandom(1); // Add Lot
		String lotName2 = adminDashboardPage.addLotRandom(1); // Add Lot
		adminDashboardPage.AddLot_WithOut_BuyNow_Value(1); // Add Lot WithOut
															// Buy Now Value

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Buy_First_Lot_From_Catalog(saleno, auctionName, lotName1);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.search_Last_Created_Auction(saleno); // Search Last
																// Created
																// Auction
		adminDashboardPage.start_Auction(); // Run Auction And Start Lot 2
		adminDashboardPage.front(); // Open Front End

		// Place Bid on Lot 2 - Front End

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		// Admin Login

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
																			// Bid
																			// and
																			// Sold
																			// The
																			// Lot
		adminDashboardPage.Post_Floor_Bid_Sell_Lot();

		// Timed Auction

		String TimedAuction = adminDashboardPage.create_Timed_Auction(saleno);
		adminDashboardPage.approveBidder1();
		String lotName3 = adminDashboardPage.addLotRandom(1); // Add Lot
		String lotName4 = adminDashboardPage.AddLot_WithOut_BuyNow_Value(1); // Add
																				// Lot
																				// WithOut
		// Buy Now Value

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Buy_First_Lot_From_Catalog_Timed(saleno, TimedAuction, lotName3);
		dashboardPage.Place_Bid_Value_Timed_Auction(saleno, TimedAuction, lotName4);

		driver.get(configFileReader.getAdminUrl()); // Goto Admin
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Generate_Invoice(auctionName);

	}

	/**
	 * 
	 * Auto generate timed and live 'Buy it now' invoices default shipping 25 - 5.91
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Option_Active_Default_Shipping_25(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"Auto generate timed and live 'Buy it now' invoices >> Option Active - 5.91");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();
		String TimedAuction1 = common.generateRandomChars(3);
		String saleno = common.generateRandomNumber1();

		String lotName = null;

		// Timed Auction

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Auto_Generate_Invoice_Live_Timed_Active_Shipping_Default_25();
		adminDashboardPage.setting_Auto_Create_And_Floor_Buyer_Active();

		String TimedAuction = adminDashboardPage.create_Timed_Auction(saleno);
		adminDashboardPage.approveBidder1();
		String lotName1 = adminDashboardPage.addLotRandom(1); // Add Lot
		String lotName2 = adminDashboardPage.AddLot_WithOut_BuyNow_Value(1); // Add
																				// Lot
																				// WithOut

		adminDashboardPage.front(); // Open Front End

		// User 1 Login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		// Buy Now Value
		dashboardPage.Buy_First_Lot_From_Catalog_Timed(saleno, TimedAuction, lotName1);

		// Place Bid on Lot 2 - Front End
		dashboardPage.Place_Bid_Value_Timed_Auction(saleno, TimedAuction, lotName2);

		driver.get(configFileReader.getAdminUrl());

		// Live Auction
		String saleno1 = common.generateRandomNumber1();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno1);

		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName3 = adminDashboardPage.addLotRandom(1); // Add Lot
		adminDashboardPage.AddLot_WithOut_BuyNow_Value(1); // Add Lot WithOut
															// Buy Now Value

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Buy_First_Lot_From_Catalog(saleno1, auctionName, lotName3);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.search_Last_Created_Auction(saleno1); // Search Last
																	// Created
																	// Auction
		adminDashboardPage.start_Auction(); // Run Auction And Start Lot 2
		adminDashboardPage.front(); // Open Front End

		// place bid for live lot2
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno1, auctionName);

		// Admin Login

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno1);// Accept
																			// Bid
																			// and
																			// Sold
																			// The
																			// Lot

		adminDashboardPage.Generate_Invoice(auctionName);

	}

	/**
	 * 
	 * Auto generate timed and live 'Buy it now' invoices Not Active default
	 * shipping 25 - 5.92
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Option_Not_Active_Default_Shipping_25(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Auto generate timed and live 'Buy it now' invoices >> Option Not Active - 5.92");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();
		String TimedAuction1 = common.generateRandomChars(3);
		String saleno = common.generateRandomNumber1();

		String lotName = null;

		// Timed Auction
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Auto_Generate_Invoice_Live_Timed_Not_Disable();
		adminDashboardPage.setting_Auto_Create_And_Floor_Buyer_Active();

		String TimedAuction = adminDashboardPage.create_Timed_Auction(saleno);
		adminDashboardPage.approveBidder1();
		String lotName1 = adminDashboardPage.addLotRandom(1); // Add Lot
		String lotName2 = adminDashboardPage.AddLot_WithOut_BuyNow_Value(1); // Add
																				// Lot
																				// WithOut

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		// Buy Now Value
		dashboardPage.Buy_First_Lot_From_Catalog_Timed(saleno, TimedAuction, lotName1);

		// Place Bid on Lot 2 - Front End
		dashboardPage.Place_Bid_Value_Timed_Auction(saleno, TimedAuction, lotName2);

		driver.get(configFileReader.getAdminUrl());

		// Live Auction
		String saleno1 = common.generateRandomNumber1();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno1);

		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName3 = adminDashboardPage.addLotRandom(1); // Add Lot
		adminDashboardPage.AddLot_WithOut_BuyNow_Value(1); // Add Lot WithOut
															// Buy Now Value

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Buy_First_Lot_From_Catalog(saleno1, auctionName, lotName3);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.search_Last_Created_Auction(saleno1); // Search Last
																	// Created
																	// Auction
		adminDashboardPage.start_Auction(); // Run Auction And Start Lot 2
		adminDashboardPage.front(); // Open Front End

		// place bid for live lot2
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno1, auctionName);

		// Admin Login

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno1); // Accept
																			// Bid
																			// and
																			// Sold
																			// The
																			// Lot

		adminDashboardPage.Generate_Invoice(auctionName);

	}

	/**
	 * 
	 * Auto generate timed and live 'Buy it now' invoices processing fee 3 - 5.93
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Option_Active_Processing_Fee_3(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"Auto generate timed and live 'Buy it now' invoices >> Option Active - 5.93");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();
		String TimedAuction1 = common.generateRandomChars(5);
		String saleno = common.generateRandomNumber1();
		String lotName = null;

		// Timed Auction

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Auto_Generate_Invoice_Live_Timed_Active_Processing_fee_3();
		adminDashboardPage.setting_Auto_Create_And_Floor_Buyer_Active();

		String TimedAuction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);
		adminDashboardPage.approveBidder1();
		String lotName1 = adminDashboardPage.addLotRandom(1); // Add Lot

		String lotName2 = adminDashboardPage.AddLot_WithOut_BuyNow_Value(1); // Add
																				// Lot
																				// WithOut

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		// Buy Now Value
		dashboardPage.Buy_First_Lot_From_Catalog_Timed(saleno, TimedAuction, lotName1);


		// Place Bid on Lot 2 - Front End
		dashboardPage.Place_Bid_Value_Timed_Auction(saleno, TimedAuction, lotName2);

		driver.get(configFileReader.getAdminUrl());

		// Live Auction
		String saleno1 = common.generateRandomNumber1();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno1);

		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName3 = adminDashboardPage.addLotRandom(1); // Add Lot
		adminDashboardPage.AddLot_WithOut_BuyNow_Value(1); // Add Lot WithOut
															// Buy Now Value

		adminDashboardPage.start_Auction(); // Start Auction

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
	//	dashboardPage.Buy_First_Lot_From_Catalog(saleno1, auctionName, lotName3);


		dashboardPage.place_Bid_On_Live_Auction(saleno1, auctionName);

		// Admin Login

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno1); // Accept
																			// Bid
																			// and
																			// Sold
																			// The
																			// Lot
		adminDashboardPage.Generate_Invoice_And_Verify_Processing_Fee(auctionName);

	}

	/**
	 * 
	 * Auto generate timed and live 'Buy it now' invoices not active processing fee
	 * 3 - 5.94
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Option_Not_Active_Processing_Fee_3(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Auto generate timed and live 'Buy it now' invoices >> Option Not Active - 5.94");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();
		String TimedAuction1 = common.generateRandomChars(3);
		String saleno = common.generateRandomNumber1();

		String lotName = null;

		// Timed Auction

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Auto_Generate_Invoice_Live_Timed_Not_Active_Processing_fee_3();
		adminDashboardPage.setting_Auto_Create_And_Floor_Buyer_Active();

		String TimedAuction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);
		adminDashboardPage.approveBidder1();
		String lotName1 = adminDashboardPage.addLotRandom(1); // Add Lot

		String lotName2 = adminDashboardPage.AddLot_WithOut_BuyNow_Value(1); // Add
																				// Lot
																				// WithOut

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		// Buy Now Value
		dashboardPage.Buy_First_Lot_From_Catalog_Timed(saleno, TimedAuction, lotName1);

		driver.findElement(By.xpath("//header//a[text()='Auctions']")).click();

		// Place Bid on Lot 2 - Front End
		dashboardPage.Place_Bid_Value_Timed_Auction(saleno, TimedAuction, lotName2);

		driver.get(configFileReader.getAdminUrl());

		// Live Auction
		String saleno1 = common.generateRandomNumber1();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno1);

		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName3 = adminDashboardPage.addLotRandom(1); // Add Lot
		adminDashboardPage.AddLot_WithOut_BuyNow_Value(1); // Add Lot WithOut
															// Buy Now Value

		adminDashboardPage.start_Auction(); // Start Auction

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Buy_First_Lot_From_Catalog(saleno1, auctionName, lotName3);

		driver.findElement(By.xpath("//header//a[text()='Auctions']")).click();

		dashboardPage.place_Bid_On_Live_Auction(saleno1, auctionName);

		// Admin Login

		driver.get(configFileReader.getAdminUrl());

	adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno1); // Accept
																			// Bid
																			// and
																			// Sold
																			// The
																			// Lot
		adminDashboardPage.Generate_Invoice_And_Verify_Processing_Fee(auctionName);
	}

	/**
	 * Show where taxes are applied is active
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Show_Where_Taxes_Are_Applied(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\" Show where taxes are applied is active Feature,TestCase Name: 5.95"
				+ "Show where taxes are applied is active Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Show_Where_Sales_Tax_Applied();
		adminDashboardPage.Edit_HP_BP_In_Invoice();

	}

	/**
	 * Allow invoice item change" is active in the settings and "Show where taxes
	 * are applied (invoice)" is not active
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Show_Where_Taxes_Are_Applied_Is_Not_Active(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\" Allow invoice item change is active in the settings and Show where taxes are applied  is not active Feature,TestCase Name: 5.96"
				+ "Allow invoice item change is active in the settings and Show where taxes are applied is not active Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Showwheretaxesareapplied1();
		adminDashboardPage.invoicesPage1();

	}

	/**
	 * "Allow invoice item change" is not active in the settings
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Allow_Invoice_Item_Change_Is_Not_Active(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\" Allow invoice item change is not active in the settings Feature,TestCase Name: 5.97"
				+ "Allow invoice item change is not active in the settings Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.AllowinvoiceitemchangeisnotactiveShowwheretaxesareapplied();
		adminDashboardPage.AllowinvoiceitemchangeisnotactiveinvoicesPage();

	}

	/**
	 * "Include category" in invoice is active in the settings
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Include_Category_Is_Active(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String tomorrowdate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\" Include category is active in the settings Feature,TestCase Name: 5.98"
				+ "Include category is active in the settings.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Include_Category_Is_Active();
		String Auctionname = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowdate, "5", saleno);
		adminDashboardPage.approveBidder1();
		String lotname1 = adminDashboardPage.add1Lot();
		adminDashboardPage.start_Auction();
		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.place_Bid_On_Live_Auction(saleno, Auctionname);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.search_Last_Created_Auction(saleno);
		adminDashboardPage.Accept_Bid_Sold_Lot();

		adminDashboardPage.Generate_Invoices_Edit_Link_Category(Auctionname);

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Category_Invoices();

	}

	/**
	 * "Include category" in invoice is active in the settings
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Include_Category_is_Not_Active(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		String tomorrowdate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\" Include category is active in the settings Feature,TestCase Name: 5.99"
				+ "Include category is not active in the settings.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Include_Category_Is_Not_Active();
		String Auctionname = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowdate, "5", saleno);
		adminDashboardPage.approveBidder1();
		String lotname1 = adminDashboardPage.add1Lot();

		adminDashboardPage.start_Auction();
		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.place_Bid_On_Live_Auction(saleno, Auctionname);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.search_Last_Created_Auction(saleno);
		adminDashboardPage.Accept_Bid_Sold_Lot();

		adminDashboardPage.Generate_Invoices_Edit_Link_Category(Auctionname);

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Category_Invoices();

		
	}

	/**
	 * 
	 * "Include Quantity" in invoice is active in the settings
	 * 
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Include_Quantity_Invoices(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();

		String tomorrowDate = common.tomorrowDate();
		String LotQuantity = "5";
		String consignor = common.generateRandomChars(4);

		log("Feature" + "-" + "UAT" + "\" Include Quantity is active in the settings Feature,TestCase Name: 5.100"
				+ "Include category is active in the settings.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Include_Quantity_Is_Active();

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder
		String lotName1 = adminDashboardPage.AddLot_With_Quantity(LotQuantity, consignor);
		adminDashboardPage.start_Auction();

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Sold
																			// Lot
																			// to
																			// internet
																			// Bidder
		adminDashboardPage.Generate_Invoices_Include_Quantity(consignor, auctionName, LotQuantity);

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Verify_Quantity_Invoices();// Verify Quantity

	}

	/**
	 * "Include Quantity" in invoice is Disable in the settings
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Include_Quantity_Invoices_Disable(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();

		String tomorrowDate = common.tomorrowDate();
		String LotQuantity = "5";
		String consignor = common.generateRandomChars(4);

		log("Feature" + "-" + "UAT" + "\" Include Quantity is Disable in the settings Feature,TestCase Name: 5.101"
				+ "Include category is active in the settings.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Include_Quantity_Is_Disable();

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder
		String lotName1 = adminDashboardPage.AddLot_With_Quantity(LotQuantity, consignor);
		adminDashboardPage.start_Auction();

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Sold
																			// Lot
																			// to
																			// internet
																			// Bidder
		adminDashboardPage.Generate_Invoices_Include_Quantity_Disable(consignor, auctionName, LotQuantity);

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Verify_Quantity_Invoices_Disable(LotQuantity); // Verify
																		// Quantity
																		// Tab
																		// is
																		// Not
																		// Dispaly.

	}

	/**
	 * "Generate Invoice Per User Across Multiple Sales
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Generate_Invoices_Multiple_Sales_Active(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();
		String saleno1 = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();
		String LotQuantity = "5";
		String consignor = common.generateRandomChars(4);
		String auctionname = common.generateRandomChars(5);

		log("Feature" + "-" + "UAT"
				+ "\" Generate Invoice Per User Across Multiple Sales settings Feature,TestCase Name: 5.102"
				+ "Include category is active in the settings.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Invoice_Per_User_Across_Multiple_Sales();

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder
		String lotName1 = adminDashboardPage.addLot(1);
		adminDashboardPage.start_Auction();

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Sold
																			// Lot
																			// to
																			// internet
																			// Bidder

		String auctionName1 = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno1);
		adminDashboardPage.approveBidder1();
		String lotName2 = adminDashboardPage.addLot(1);
		adminDashboardPage.start_Auction();

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName1);

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName1, saleno1); // Sold
																			// Lot
																			// to
																			// internet
																			// Bidder

		String TimedAuction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);
		adminDashboardPage.approveBidder1();
		String lotName4 = adminDashboardPage.addLotRandomForUser(1); // Add Lot

		adminDashboardPage.front();

		// Login User

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Place_Bid_Value_Timed_Auction(saleno, TimedAuction, lotName4);

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Generate_Invoice_Multiple_Sales(tomorrowDate, auctionName1);

	}

	/**
	 * "Generate Invoice Per User Across Multiple Sales
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Generate_Invoices_Multiple_Sales_Not_Active(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();

		String saleno1 = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();
		String LotQuantity = "5";
		String consignor = common.generateRandomChars(4);
		String auctionname = common.generateRandomChars(5);

		log("Feature" + "-" + "UAT"
				+ "\" Generate Invoice Per User Across Multiple Sales settings Feature Disable,TestCase Name: 5.103"
				+ "Include category is active in the settings.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Invoice_Per_User_Across_Multiple_Sales_Not_Active();

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder
		String lotName1 = adminDashboardPage.addLot(1);
		adminDashboardPage.start_Auction();

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Sold
																			// Lot
																			// to
																			// internet
																			// Bidder

		String auctionName1 = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno1);
		adminDashboardPage.approveBidder1(); 
		String lotName2 = adminDashboardPage.addLot(1);
		adminDashboardPage.start_Auction();

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno1, auctionName1);

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName1, saleno1); // Sold
																			// Lot
																			// to
																			// internet

		// Bidder

		String TimedAuction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);
		adminDashboardPage.approveBidder1(); 
		String lotName4 = adminDashboardPage.addLotRandomForUser(1); // Add Lot

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Place_Bid_Value_Timed_Auction(saleno, TimedAuction, lotName4);

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Generate_Invoice_Multiple_Sales(tomorrowDate, auctionName1);

	}

	/**
	 * Edit invoice - 5.104
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Edit_an_Invoice1(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\" Use full descriptions in invoice line items,TestCase Name: 5.104");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Use_Full_Description_Is_Active();
		adminDashboardPage.Edit_Invoice();

	}

	/**
	 * 
	 * Edit an invoice2 - 5.105
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Edit_an_Invoice2(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\" Use full descriptions in invoice line items,TestCase Name: 5.105");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.UsefulldescriptionisNotactive();
		adminDashboardPage.Edit_Invoice();

	}

	/**
	 * Apply Sales tax to HP & BP
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Apply_Sales_Tax_HP_BP(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();
		String saleno1 = common.generateRandomNumber1();
		String saleno2 = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		log("Feature" + "-" + "UAT" + "\" Apply Sales tax HP & BP,TestCase Name: 5.106"
				+ "Include category is active in the settings.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Apply_Sale_Tax_HP_BP();

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder
		String lotName1 = adminDashboardPage.add1Lot();
		adminDashboardPage.start_Auction();

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		// Goto Admin Side
		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Sold
																			// Lot
																			// to
																			// internet
																			// Bidder
		adminDashboardPage.Generate_Invoice(auctionName);

		adminDashboardPage.Edit_Invoice(); // HP & BP Option Display in Invoice
		adminDashboardPage.Verify_Invoice_Table();

		adminDashboardPage.Apply_Sale_Tax_HP(); // Select HP Radio Button

		// Auction For HP

		String auctionName1 = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno1); // New
		// Auction
		adminDashboardPage.approveBidder1(); // approve bidder
		String lotName2 = adminDashboardPage.add1Lot();
		adminDashboardPage.start_Auction();

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno1, auctionName1);

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName1, saleno1); // Sold
																			// Lot
																			// to
																			// internet
																			// Bidder
		adminDashboardPage.Generate_Invoice(auctionName1);

		adminDashboardPage.Edit_Invoice();
		adminDashboardPage.Verify_Invoice_Table(); // HP saletax Display in
													// table

		adminDashboardPage.Apply_Sale_Tax_HP(); // Select HP Radio Button

		// Auction For BP

		String auctionName2 = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno2); // New
		// Auction
		adminDashboardPage.approveBidder1(); // approve bidder
		String lotName3 = adminDashboardPage.add1Lot();
		adminDashboardPage.start_Auction();

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno2, auctionName2);

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName2, saleno2); // Sold
																			// Lot
																			// to
																			// internet
																			// Bidder
		adminDashboardPage.Generate_Invoice(auctionName2);

		adminDashboardPage.Edit_Invoice();
		adminDashboardPage.Verify_Invoice_Table(); // BP option display in table

	}

	/**
	 * Include Quantity - 5.107
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "createauction")
	public void Include_Quantity(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();
		log("Feature" + "-" + "UAT"
				+ "\" Include quantity in settlement is active in the settings,TestCase Name: 5.107");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();
		String lotName = common.generateRandomChars(3);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.includequantitysettlement();

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		adminDashboardPage.approveBidder1_2();
		String consignor = adminDashboardPage.Add_Lot_With_Consignor(lotName);
		adminDashboardPage.start_Auction();

		adminDashboardPage.front();

		// User 1 Login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno);

		adminDashboardPage.Generate_Settlements_and_Verify("rahul@per", saleno, auctionName);// generate
		// new
		// settlements

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		//dashboardPage.settlements();
		//Settlements page not available for qa3-4-auto env
	}

	/**
	 * Include Quantity - 5.108
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "createauction")
	public void Include_Quantity_Not_Active(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();
		log("Feature" + "-" + "UAT"
				+ "\" Include quantity in settlement is active in the settings,TestCase Name: 5.108");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();
		String lotName = common.generateRandomChars(3);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Include_Quantity_Settlement_Not_Active();

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		adminDashboardPage.approveBidder1();
		String consignor = adminDashboardPage.Add_Lot_With_Consignor(lotName);
		adminDashboardPage.start_Auction();

		adminDashboardPage.front();

		// User 1 Login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno);

		adminDashboardPage.Generate_Settlements_and_Verify("rahul@per", saleno, auctionName); // generate
		// new
		// settlements

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		//dashboardPage.settlements();
	}

	/**
	 * 
	 * 5.109 - Create category
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "createauction")
	public void Create_Cat(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();

		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Create_Category(); // Create category

		adminDashboardPage.Add_Additional_Invoice_Line_Items();

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName1 = adminDashboardPage.Lot_1_Category_1();
		String lotName2 = adminDashboardPage.Lot_2_Category_2();
		String lotName3 = adminDashboardPage.Lot_3_Category_2_Subcat_1();
		String lotName4 = adminDashboardPage.Lot_4_Category_3();
		String lotName5 = adminDashboardPage.Lot_5_Category_4();
		String lotName6 = adminDashboardPage.Lot_6_Category_4_Subcat_2();
		String lotName7 = adminDashboardPage.Lot_7_Category_5();
		String lotName8 = adminDashboardPage.Lot_8_Category_6();
		String lotName9 = adminDashboardPage.Lot_9_Category_6_Subcat_3();
		String lotName10 = adminDashboardPage.Lot_10_Category_2_Subcat_4();
		String lotName11 = adminDashboardPage.Lot_11_Category_4_Subcat_5();
		String lotName12 = adminDashboardPage.Lot_12_Category_6_Subcat_6();

		adminDashboardPage.start_Auction();
		adminDashboardPage.front();

		// Lot 1 sell

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName); // Place
																		// bid
																		// on
																		// live
																		// auction.

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
																			// bid
																			// and
																			// sell
																			// lot
																			// to
																			// bidder
		adminDashboardPage.front();

		// Lot 2 sell

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName); // Place
																		// bid
																		// on
																		// live
																		// auction.

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
																			// bid
																			// and
																			// sell
																			// lot
																			// to
																			// bidder
		adminDashboardPage.front();

		// Lot 3 sell

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName); // Place
																		// bid
																		// on
																		// live
																		// auction.

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
																			// bid
																			// and
																			// sell
																			// lot
																			// to
																			// bidder
		adminDashboardPage.front();

		// Lot 4 sell

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName); // Place
																		// bid
																		// on
																		// live
																		// auction.

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
																			// bid
																			// and
																			// sell
																			// lot
																			// to
																			// bidder
		adminDashboardPage.front();

		// Lot 5 sell

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName); // Place
																		// bid
																		// on
																		// live
																		// auction.

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
																			// bid
																			// and
																			// sell
																			// lot
																			// to
																			// bidder
		adminDashboardPage.front();

		// Lot 6 sell

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName); // Place
																		// bid
																		// on
																		// live
																		// auction.

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
																			// bid
																			// and
																			// sell
																			// lot
																			// to
																			// bidder
		adminDashboardPage.front();

		// Lot 7 sell

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName); // Place
																		// bid
																		// on
																		// live
																		// auction.

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
																			// bid
																			// and
																			// sell
																			// lot
																			// to
																			// bidder
		adminDashboardPage.front();

		// Lot 8 sell

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName); // Place
																		// bid
																		// on
																		// live
																		// auction.

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
																			// bid
																			// and
																			// sell
																			// lot
																			// to
																			// bidder
		adminDashboardPage.front();

		// Lot 9 sell

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName); // Place
																		// bid
																		// on
																		// live
																		// auction.

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
																			// bid
																			// and
																			// sell
																			// lot
																			// to
																			// bidder
		adminDashboardPage.front();

		// Lot 10 sell

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName); // Place
																		// bid
																		// on
																		// live
																		// auction.

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
																			// bid
																			// and
																			// sell
																			// lot
																			// to
																			// bidder
		adminDashboardPage.front();

		// Lot 11 sell

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName); // Place
																		// bid
																		// on
																		// live
																		// auction.

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
																			// bid
																			// and
																			// sell
																			// lot
																			// to
																			// bidder
		adminDashboardPage.front();

		// Lot 12 sell

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName); // Place
																		// bid
																		// on
																		// live
																		// auction.

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
																			// bid
																			// and
																			// sell
																			// lot
																			// to
																			// bidder

		adminDashboardPage.Generate_Invoice(auctionName); // Generate Invoices
		adminDashboardPage.Edit_Invoice();
		adminDashboardPage.Verify_Extracharges_Invoices_Sales_Tax();

	}

	/**
	 * 
	 * 5.110 - Create category
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "createauction")
	public void Create_Category_Consolidated(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();

		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\" Create category consolidated,TestCase Name: 5.110");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Create_Category(); // Create category

		adminDashboardPage.Add_Additional_Invoice_Line_Items_Consolidated();

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName1 = adminDashboardPage.Lot_1_Category_1();
		String lotName2 = adminDashboardPage.Lot_2_Category_2();
		String lotName3 = adminDashboardPage.Lot_3_Category_2_Subcat_1();
		String lotName4 = adminDashboardPage.Lot_4_Category_3();
		String lotName5 = adminDashboardPage.Lot_5_Category_4();
		String lotName6 = adminDashboardPage.Lot_6_Category_4_Subcat_2();
		String lotName7 = adminDashboardPage.Lot_7_Category_5();
		String lotName8 = adminDashboardPage.Lot_8_Category_6();
		String lotName9 = adminDashboardPage.Lot_9_Category_6_Subcat_3();
		String lotName10 = adminDashboardPage.Lot_10_Category_2_Subcat_4();
		String lotName11 = adminDashboardPage.Lot_11_Category_4_Subcat_5();
		String lotName12 = adminDashboardPage.Lot_12_Category_6_Subcat_6();

		adminDashboardPage.start_Auction();
		adminDashboardPage.front();

		// Lot 1 sell

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName); // Place
																		// bid
																		// on
																		// live
																		// auction.

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
																			// bid
																			// and
																			// sell
																			// lot
																			// to
																			// bidder
		adminDashboardPage.front();

		// Lot 2 sell

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName); // Place
																		// bid
																		// on
																		// live
																		// auction.

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
																			// bid
																			// and
																			// sell
																			// lot
																			// to
																			// bidder
		adminDashboardPage.front();

		// Lot 3 sell

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName); // Place
																		// bid
																		// on
																		// live
																		// auction.

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
																			// bid
																			// and
																			// sell
																			// lot
																			// to
																			// bidder
		adminDashboardPage.front();

		// Lot 4 sell

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName); // Place
																		// bid
																		// on
																		// live
																		// auction.

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
																			// bid
																			// and
																			// sell
																			// lot
																			// to
																			// bidder
		adminDashboardPage.front();

		// Lot 5 sell

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName); // Place
																		// bid
																		// on
																		// live
																		// auction.

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
																			// bid
																			// and
																			// sell
																			// lot
																			// to
																			// bidder
		adminDashboardPage.front();

		// Lot 6 sell

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName); // Place
																		// bid
																		// on
																		// live
																		// auction.

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
																			// bid
																			// and
																			// sell
																			// lot
																			// to
																			// bidder
		adminDashboardPage.front();

		// Lot 7 sell

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName); // Place
																		// bid
																		// on
																		// live
																		// auction.

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
																			// bid
																			// and
																			// sell
																			// lot
																			// to
																			// bidder
		adminDashboardPage.front();

		// Lot 8 sell

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName); // Place
																		// bid
																		// on
																		// live
																		// auction.

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
																			// bid
																			// and
																			// sell
																			// lot
																			// to
																			// bidder
		adminDashboardPage.front();

		// Lot 9 sell

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName); // Place
																		// bid
																		// on
																		// live
																		// auction.

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
																			// bid
																			// and
																			// sell
																			// lot
																			// to
																			// bidder
		adminDashboardPage.front();

		// Lot 10 sell

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName); // Place
																		// bid
																		// on
																		// live
																		// auction.

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
																			// bid
																			// and
																			// sell
																			// lot
																			// to
																			// bidder
		adminDashboardPage.front();

		// Lot 11 sell

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName); // Place
																		// bid
																		// on
																		// live
																		// auction.

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
																			// bid
																			// and
																			// sell
																			// lot
																			// to
																			// bidder
		adminDashboardPage.front();

		// Lot 12 sell

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName); // Place
																		// bid
																		// on
																		// live
																		// auction.

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
																			// bid
																			// and
																			// sell
																			// lot
																			// to
																			// bidder

		adminDashboardPage.Generate_Invoice(auctionName); // Generate Invoices
		adminDashboardPage.Edit_Invoice();
		adminDashboardPage.Verify_Extracharges_Invoices_Sales_Tax();

	}

	/**
	 * 
	 * 5.111 - Create category
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "createauction")
	public void Create_Category_Sales(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();

		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\" Create category consolidated Sales,TestCase Name: 5.111");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Create_Category(); // Create category

		adminDashboardPage.Add_Additional_Invoice_Line_Items();

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName1 = adminDashboardPage.Lot_1_Category_2();

		adminDashboardPage.start_Auction();
		adminDashboardPage.front();

		// Lot 1 sell

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName); // Place
																		// bid
																		// on
																		// live
																		// auction.

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
																			// bid
																			// and
																			// sell
																			// lot
																			// to
																			// bidder
		adminDashboardPage.Generate_Invoice(auctionName); // Generate Invoices
		adminDashboardPage.Edit_Invoice();
		adminDashboardPage.Verify_Extracharges_Invoices_Sales_Tax();
	}

	/**
	 * 
	 * 5.112 - Create category Timed Auction
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "createauction")
	public void Create_Cat_Timed_Auction(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();

		String tomorrowDate = common.tomorrowDate();
		String Salename = common.generateRandomChars(5);
		log("Feature" + "-" + "UAT" + "\" Create category Timed Auction,TestCase Name: 5.112");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Auto_Generate_Invoice_Live_Timed_Active(); // AutoGenerate
																		// Invoices
																		// enable
		adminDashboardPage.multiBid_Functionality_Enable(); // Multibid enable
		adminDashboardPage.Create_Category(); // Create category

		adminDashboardPage.Add_Additional_Invoice_Line_Items();

		String TimeAuction5Min = adminDashboardPage.create_TimedAuction_5_Minute(saleno); // Create
																							// Time
																							// Auction

		adminDashboardPage.approveBidder1(); // approve bidder

		// Add multiple lot

		String lotName1 = adminDashboardPage.Lot_1_Category_1();
		String lotName2 = adminDashboardPage.Lot_2_Category_2();
		String lotName3 = adminDashboardPage.Lot_3_Category_2_Subcat_1();
		String lotName4 = adminDashboardPage.Lot_4_Category_3();
		String lotName5 = adminDashboardPage.Lot_5_Category_4();
		String lotName6 = adminDashboardPage.Lot_6_Category_4_Subcat_2();
		String lotName7 = adminDashboardPage.Lot_7_Category_5();
		String lotName8 = adminDashboardPage.Lot_8_Category_6();
		String lotName9 = adminDashboardPage.Lot_9_Category_6_Subcat_3();
		String lotName10 = adminDashboardPage.Lot_10_Category_2_Subcat_4();
		String lotName11 = adminDashboardPage.Lot_11_Category_4_Subcat_5();
		String lotName12 = adminDashboardPage.Lot_12_Category_6_Subcat_6();

		adminDashboardPage.front();

		// Place Bid on multiple lot

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Place_Bid_Value_Timed_Auction_12(saleno, TimeAuction5Min, lotName1, lotName2, lotName3, lotName4,
				lotName5, lotName6, lotName7, lotName8, lotName9, lotName10, lotName11, lotName12); // Place
																									// Multibid
																									// on
																									// timeauction

		driver.get(configFileReader.getAdminUrl()); // Admin URL

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Edit_Invoice(); // Edit Invoice
		adminDashboardPage.Verify_Extracharges_Invoices_Sales_Tax(); // Verify
																		// Generated
																		// Invoices

	}

	/**
	 * 
	 * 5.113 - Create Multiple category Live
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "createauction")
	public void Create_Multiple_Category_Live(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();

		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\" Create Multiple category,TestCase Name: 5.113");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Auto_Generate_Invoice_Live_Timed_Not_Disable();

		adminDashboardPage.Create_Category(); // Create category

		adminDashboardPage.Add_Additional_Invoice_Line_Items();

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName1 = adminDashboardPage.Lot_Cat1_Cat2_SubCat1_Cat6_Subcat3();

		adminDashboardPage.start_Auction();
		adminDashboardPage.front();

		// Lot 1 sell

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName); // Place
																		// bid
																		// on
																		// live
																		// auction.

		driver.get(configFileReader.getAdminUrl()); // Admin URL

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
																			// bid
																			// and
																			// sell
																			// lot
																			// to
																			// bidder

		adminDashboardPage.Generate_Invoice(auctionName); // Generate Invoices
		adminDashboardPage.Edit_Invoice(); // Edit Invoices
		adminDashboardPage.Verify_Extracharges_Invoices_Sales_Tax();

	}

	/**
	 * 
	 * 5.114 - Create Multiple category Timed
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "createauction")
	public void Create_Multiple_Category_Timed(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();

		String tomorrowDate = common.tomorrowDate();
		String aucname = common.generateRandomChars(5);
		log("Feature" + "-" + "UAT" + "\" Create Multiple category Timed Auction,TestCase Name: 5.114");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Auto_Generate_Invoice_Live_Timed_Not_Disable();

		adminDashboardPage.Create_Category(); // Create category

		adminDashboardPage.Add_Additional_Invoice_Line_Items();

		String TimedAuction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName1 = adminDashboardPage.Lot_Cat1_Cat2_SubCat1_Cat6_Subcat3();

		adminDashboardPage.front();

		// Lot 1 sell

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Place_Bid_Value_Timed_Auction(saleno, TimedAuction, lotName1); // Place
																						// Bid
																						// on
																						// timed
																						// auction

		driver.get(configFileReader.getAdminUrl()); // Admin URL

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Generate_Invoice(TimedAuction); // Generate Invoices
															// for timed auction
		adminDashboardPage.Edit_Invoice(); // Edit Invoices
		adminDashboardPage.Verify_Extracharges_Invoices_Sales_Tax(); // Verify
																		// Invoices

	}

	/**
	 * 
	 * 5.115- Add New Credit Card
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "createauction")
	public void Add_New_Credit_Card(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\"Add anew credit card and save,TestCase Name: 5.115");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab();
		adminDashboardPage.verifyCheckedCheckboxRegularSignupWithVerifyRequireCreditCardOnSignUp();

		String strname = adminDashboardPage.Add_New_Credit_Card(); // Add new
																	// Credit
																	// card

		adminDashboardPage.Verifynewcreditcardinusertab(strname); // Verify new
																	// credit
																	// card in
																	// User Tab

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		common.pause(25);
		dashboardPage.Verify_New_Credit_Card_In_Profile(strname);
		loginPage = indexPage.clickOnLoginLink();
		dashboardPage.Verify_New_Credit_Card(strname); // Verify NEW CC

	}

	/**
	 * 
	 * 5.116 - Edit Credit Card
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws Exception
	 */

	@Test(dataProvider = "createauction")
	public void Edid_Any_Credit_Card(String adminUserName, String adminPassword, String UName, String password)
			throws Exception {

		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\"	 credit card and save,TestCase Name: 5.116");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		common.pause(20);
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab();
		adminDashboardPage.verifyCheckedCheckboxRegularSignupWithVerifyRequireCreditCardOnSignUp();

		String strccname = adminDashboardPage.editanycreditcard();

		adminDashboardPage.Verifynewcreditcardinusertab1(strccname);

		adminDashboardPage.front();
		// Verify NEW CC

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.verifynewcreditcardinprofile1(strccname);

		dashboardPage.verifynewcreditcard1(strccname);

	}

	/**
	 * Delete Credit card - 5.117
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "createauction")
	public void Delete_Credit_Card(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\"Delete credit card and save,TestCase Name: 5.116");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab();
		adminDashboardPage.verifyCheckedCheckboxRegularSignupWithVerifyRequireCreditCardOnSignUp();

		String deletecc = adminDashboardPage.deletecreditcard(); // Delete
																	// Credit
																	// Card

		adminDashboardPage.Verifydeletedcreditcardinusertab(deletecc); // verify
																		// Deleted
																		// CC In
																		// user
																		// Field

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.verifydeletedcreditcardinprofile(deletecc); // Verify
																	// Deleted
																	// CC in
																	// Profile
		loginPage = indexPage.clickOnLoginLink();
		dashboardPage.verifydeletedcreditcard(deletecc); // Verify Deleted CC

	}

	/**
	 * sales tax defined in the global settings - 1.118
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Sales_Tax_Defined_In_The_Global_Settings_Shipping_Address_In_Nebraska(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();

		String tomorrowDate = common.tomorrowDate();

		String consignor1 = Common.generateRandomChars(4);
		String consignor2 = Common.generateRandomChars(4);
		String bidder1 = Common.generateRandomChars(4);
		String bidder2 = Common.generateRandomChars(4);

		log("Feature" + "-" + "UAT" + "\" sales tax defined in the global settings Feature,TestCase Name: 5.118"
				+ " sales tax defined in the global settings Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.salestaxdefinedintheglobalsettings();
		adminDashboardPage.Autoassignsalestaxbystate_Nebraska();

		// Add User
		String consignor_1 = adminDashboardPage.AddUser1withSalesTax(consignor1);

		String consignor_2 = adminDashboardPage.AddUser2withSalesTax(consignor2);

		String bidder_1 = adminDashboardPage.AddBidder1withSalesTax_Specify_Shipping_Address(bidder1);

		String bidder_2 = adminDashboardPage.AddBidder2withSalesTax_Shipping_info_Nebraska(bidder2);

		// Create Auction
		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		adminDashboardPage.approvebidder(bidder1, bidder2);

		// Add Lot
		adminDashboardPage.lot1(1, consignor_1);
		adminDashboardPage.lot2(1, consignor_1);
		adminDashboardPage.lot3(1, consignor_1);
		adminDashboardPage.lot4(1, consignor_1);

		adminDashboardPage.lot5(1, consignor_2);
		adminDashboardPage.lot6(1, consignor_2);
		adminDashboardPage.lot7(1, consignor_2);
		adminDashboardPage.lot8(1, consignor_2);

		adminDashboardPage.start_Auction();

		// Sell Lot 1 (Bidder 1)
		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder_1, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Sell

		// Sell Lot 2 (Bidder 1)
		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder_1, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Sell

		// Sell Lot 3 (Bidder 2)
		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder_2, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Sell

		// Sell Lot 4 (Bidder 2)
		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder_2, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Sell

		// Sell Lot 5 (Bidder 1)
		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder_1, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Sell

		// Sell Lot 6 (Bidder 1)
		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder_1, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Sell

		// Sell Lot 7 (Bidder 2)
		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder_2, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Sell

		// Sell Lot 8 (Bidder 2)
		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder_2, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Sell

		// Generate Invoice
		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage.Generate_Invoice(auctionName);

	}

	/**
	 * Text 5.119
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "createauction")
	public void Text(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException {

		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\"select text option Enter text to be displayed Save,TestCase Name: 5.119");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.SettingLayout_customizationText();

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.VerifyText();

	}

	/**
	 * Logo URL - 5.120
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "createauction")
	public void Logo_Url(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException {

		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\"Select logo url option Specify URL to look up Save,TestCase Name: 5.120");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.SettingLayout_customizationlogourl();

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.VerifyLogo();

	}

	/**
	 * Upload Logo 5.121
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "createauction")
	public void Upload_Logo(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\"Select upload logo option Upload logo to be used Save,TestCase Name: 5.121");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.SettingLayout_customizationUploadlogo();

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.VerifyLogo();

	}

	/**
	 * Text_Display Address 5.122
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "createauction")
	public void Text_Display_Address(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException {

		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT"
				+ "\"Enter a value for the Display address/Header content field Also select Page header text and save a text,TestCase Name: 5.122");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.SettingLayout_customizationText_Address();

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.VerifyText();

	}

	/**
	 * 
	 * Dafault - 5.123
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(dataProvider = "createauction")
	public void Default(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException {

		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\"Default,TestCase Name: 5.123");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.SettingLayout_customizationDefault();

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.verifyLiveAndTimeSearchNotBeingDisplayedSeparately(); // verify
		// that
		// live
		// and
		// timed
		// search
		// tabs
		// are
		// not
		// being
		// dispalyed
		// separately

	}

	/**
	 * Separate Timed Auction - 5.124
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(dataProvider = "createauction")
	public void Separate_Timed_and_Live(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException {

		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\"Separate timed/live,TestCase Name: 5.124");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.SettingLayout_customizationSeparatelyDisplayedLiveAndTimedSearch();

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.verifyLiveAndTimeSearchBeingDisplayedSeparately(); // verify
		// that
		// live
		// and
		// timed
		// search
		// tabs
		// are
		// not
		// being
		// dispalyed
		// separately

	}

	/**
	 * 
	 * 5.125 - List View
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "createauction")
	public void Listview(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException {

		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\"List View,TestCase Name: 5.125");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.SettingLayout_customizationListview();

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_List_View(); // verify listview

	}

	/**
	 * 
	 * 5.126 - Table View
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "createauction")
	public void Tableview(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException {

		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\"Table View,TestCase Name: 5.126");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.SettingLayout_customizationTableview();

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.verifyTableview(); // verify tableview

	}

	/**
	 * 
	 * 5.127 - Auctions
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "createauction")
	public void Auctions(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException {

		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\"Auction,TestCase Name: 5.127");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.SettingLayout_customizationAuctions();

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.verifyAuctionOverview(); // verify Auctions

	}

	/**
	 * 
	 * Search - 5.128
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(dataProvider = "createauction")
	public void Search(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException {

		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\"Auction,TestCase Name: 5.128");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.settinglayout_Customizationsearch();

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.verifySearchPage(); // verify Search page

	}

	/**
	 * 5.129 - Show member page disable
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "createauction")
	public void Show_Member_Page_Disable(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException {

		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\"Separate timed/live,TestCase Name: 5.129");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Show_Member_PageMenu_Disable();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Verify_Header_Tab();

	}

	/**
	 * 5.130 - Show member page enable
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "createauction")
	public void Show_Member_Page_Enable(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException {

		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\"Enable,TestCase Name: 5.130");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Show_Member_PageMenu_Enable();

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Verify_Header_Tab_Enable();

	}

	/**
	 * 5.131 - show1
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "createauction")
	public void Show1(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException {

		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\"Show 1,TestCase Name: 5.131");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.SettingLayout_customizationShow1();

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.verifyShow1(); // verify show1

	}

	/**
	 * 
	 * Show 3 - 5.132
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(dataProvider = "createauction")
	public void Show3(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException {

		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\"Show 3,TestCase Name: 5.132");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.SettingLayout_customizationShow3();

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.verifyShow3(); // verify show3

	}

	/**
	 * Disabled - 5.133
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws Exception
	 */

	@Test(dataProvider = "createauction")
	public void Disabled(String adminUserName, String adminPassword, String UName, String password) throws Exception {

		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\"Disable,TestCase Name: 5.133");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.SettingLayout_customizationDisabled();

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.verifyDisabled(); // verify show3

	}

	/**
	 * 5.134 - upload invoice logo
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "createauction")
	public void Upload_Invoice_Logo(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\"logo uploaded,TestCase Name: 5.134");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.uploadinvoicelogo();

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Verify_Invoice_Logo();

	}

	/**
	 * 5.135 - remove invoice logo
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "createauction")
	public void Remove_Invoice_Logo(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\"remove uploaded logo,TestCase Name: 5.135");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.remove_invoicelogo();

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Verify_Not_Added_Invoice_Logo();

	}

	/**
	 * 5.136 - upload settlemet logo
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "createauction")
	public void Upload_Settlement_Logo(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\"logo uploaded,TestCase Name: 5.136");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.uploadsettlementlogo();

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Verify_Settlement_Logo();

	}

	/**
	 * 5.137 - remove settlement logo
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "createauction")
	public void Remove_Setllement_Logo(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\"remove uploaded logo,TestCase Name: 5.137");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.remove_settlementlogo();

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Verify_Settlement_Logo();

	}

	@Test(dataProvider = "createauction")
	public void Timed_sale_Force_Bid(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String aucname = common.generateRandomChars(5);
		String saleno = common.generateRandomNumber1();

		String rahul1 = "rahulqa1";
		String rahul2 = "rahulqa2";
		String rahul3 = "rahulqa3";
		String rahul4 = "rahulqa4";
		String rahul5 = "rahulqa5";
		String rahulpwd = "123123";

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String timeAuction = adminDashboardPage.TimedAuction(aucname, saleno);
		adminDashboardPage.approvebidder5();
		String lotName1 = adminDashboardPage.addLotRandomForUser(1); // Add Lot
		String lotName2 = adminDashboardPage.addLotRandomForUser(1); // Add lot
		String lotName3 = adminDashboardPage.addLotRandomForUser(1); // Add Lot
		String lotName4 = adminDashboardPage.addLotRandomForUser(1); // Add lot

		// User 1

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Place_Force_Bid_Timedsale(timeAuction, lotName1);
		// User 2

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(rahul1, rahulpwd);
		dashboardPage.Place_Force_Bid_Timedsale(timeAuction, lotName2);
		// User 3

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(rahul2, rahulpwd);
		dashboardPage.Place_Force_Bid_Timedsale(timeAuction, lotName3);
		// User 4

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(rahul3, rahulpwd);
		dashboardPage.Place_Force_Bid_Timedsale(timeAuction, lotName4);

	}

	// Admin option
	/**
	 * 5.138 - Date_time_zone_section
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	@Test
	public void Date_time_zone_section() throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.Set_Different_TimeZone();
		adminDashboardPage.Verfiy_Chnaged_TimeZone();

	}

	/**
	 * 5.139 - Hide_Unhide_Custom_field_Inventiry_page
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	@Test
	public void Hide_Unhide_Custom_field_Inventiry_page() throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.Hide_CustomField_InventoryPage();
		adminDashboardPage.Verify_Hide_CustomField_InventoryPage();

	}

	/**
	 * 5.140 - Auction_Lots_status
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	@Test
	public void Auction_Lots_status() throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.Change_Auction_Lots_status_Admin_options();
		adminDashboardPage.Verfiy_Chnaged_AuctionLots_Status();

	}

	/**
	 * 5.141 - Show_Low_High_Estimate_Y
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	@Test
	public void Show_Low_High_Estimate_Y() throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();

		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.Change_Show_Low_High_Estimate_Y();

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); // Create
		// Auction
		adminDashboardPage.approveBidder1(); // Approve both bidder

		String lotname = adminDashboardPage.addLotRandom(1); // User 1

		adminDashboardPage.start_Auction();
		adminDashboardPage.front();

		// User 1
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Verify_Changed_Show_Low_High_Estimate_Y(saleno, auctionName);

	}

	/**
	 * 5.142 - Show_Low_High_Estimate_N
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	@Test
	public void Show_Low_High_Estimate_N() throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();

		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.Change_Show_Low_High_Estimate_N();

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); // Create
		// Auction
		adminDashboardPage.approveBidder1(); // Approve both bidder

		String lotname = adminDashboardPage.addLotRandom(1); // User 1

		adminDashboardPage.start_Auction();
		adminDashboardPage.front();

		// User 1
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Verify_Changed_Show_Low_High_Estimate_N(saleno, auctionName);

	}

	/**
	 * 5.143 - Show_Seconds_In_Countdown_Y
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	@Test
	public void Show_Seconds_In_Countdown_Y() throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();

		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.Change_Show_Seconds_In_Countdown_Y();

		String AuctionTimed = adminDashboardPage.allFieldsFillForTimedSale(tomorrowDate, "1", saleno); // Create
		// Auction
		String strlot = adminDashboardPage.addLot(1);
		Thread.sleep(1000);
		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verifyLoginPageElements(); // Verify Login Page Elements
		dashboardPage = loginPage.loginUser(UName, password); // Login with
		// valid
		dashboardPage.goto_Catalog_Page_Timed_Sale(AuctionTimed); // credentials

		dashboardPage.Verify_Changed_Show_Seconds_In_Countdown_Y(strlot);

	}

	/**
	 * 5.144 - Show_Seconds_In_Countdown_N
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	@Test
	public void Show_Seconds_In_Countdown_N() throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();

		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.Change_Show_Seconds_In_Countdown_N();

		String AuctionTimed = adminDashboardPage.allFieldsFillForTimedSale(tomorrowDate, "1", saleno); // Create
		// Auction
		String strlot = adminDashboardPage.addLot(1);
		Thread.sleep(1000);
		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verifyLoginPageElements(); // Verify Login Page Elements
		dashboardPage = loginPage.loginUser(UName, password); // Login with
		// valid
		dashboardPage.goto_Catalog_Page_Timed_Sale(AuctionTimed); // credentials

		dashboardPage.Verify_Changed_Show_Seconds_In_Countdown_N(strlot);

	}

	/**
	 * 5.145 - Display_lot_quantity_in_catalog_Y
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	@Test
	public void Display_lot_quantity_in_catalog_Y() throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();

		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.Change_Display_lot_quantity_in_catalog_Y();

		String AuctionTimed = adminDashboardPage.allFieldsFillForTimedSale(tomorrowDate, "1", saleno); // Create
		// Auction
		String strlot = adminDashboardPage.addLot(1);
		Thread.sleep(1000);
		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verifyLoginPageElements(); // Verify Login Page Elements
		dashboardPage = loginPage.loginUser(UName, password); // Login with
		// valid
		dashboardPage.goto_Catalog_Page_Timed_Sale(AuctionTimed); // credentials

		dashboardPage.Verify_Display_lot_quantity_in_catalog_Y(strlot);

	}

	/**
	 * 5.146 - Display_lot_quantity_in_catalog_N
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	@Test
	public void Display_lot_quantity_in_catalog_N() throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();

		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.Change_Display_lot_quantity_in_catalog_N();

		String AuctionTimed = adminDashboardPage.allFieldsFillForTimedSale(tomorrowDate, "1", saleno); // Create
		// Auction
		String strlot = adminDashboardPage.addLot(1);
		Thread.sleep(1000);
		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verifyLoginPageElements(); // Verify Login Page Elements
		dashboardPage = loginPage.loginUser(UName, password); // Login with
		// valid
		dashboardPage.goto_Catalog_Page_Timed_Sale(AuctionTimed); // credentials

		dashboardPage.Verify_Display_lot_quantity_in_catalog_N(strlot);

	}

	/**
	 * 5.147 - Default_Catalog_Items_Per_Page
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	@Test
	public void Default_Catalog_Items_Per_Page() throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();

		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.Change_Default_Catalog_Items_Per_Page_100();

		String AuctionTimed = adminDashboardPage.allFieldsFillForTimedSale(tomorrowDate, "1", saleno); // Create
		// Auction
		String strlot = adminDashboardPage.addLot(1);
		Thread.sleep(1000);
		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verifyLoginPageElements(); // Verify Login Page Elements
		dashboardPage = loginPage.loginUser(UName, password); // Login with
		// valid

		dashboardPage.Verify_Default_Catalog_Items_Per_Page_100(strlot);

	}

	@Test(dataProvider = "missedliveauction")
	public void Ticket_5160(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\" start a lot and sell at price in 1st range Feature,TestCase Name: 5.44 "
				+ "start a lot and sell at price in 1st range Feature.");
		log("<br></br> tep 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get("http://qa3-3.auctionserver.net/admin"); // Admin URL
		common.pause(5);
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.Create_Live_Auction_With_Auctioneer_5160(tomorrowDate, "1", saleno);

		String lotName1 = adminDashboardPage.addlotrandom_5160(50);

		// adminDashboardPage.Remove_Auction_Specific_Minimum_Buyer_Premium();

		adminDashboardPage.RunLiveSale_PostFloor_and_Sold_Lot_5160(); // Post
																		// floor
		// bid and
		// sold lot

		adminDashboardPage.Generate_Invoice_5160(auctionName);

	}

	/**
	 * Delete Users
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "createauction")
	public void Delete_Users(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Delete_Users();

	}

	/**
	 * 
	 * Sell Lots
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

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

	@DataProvider(name = "twologinUsers")
	public Object[][] getTwoUserAuction() throws Exception {

		Object[][] retObjectArr = parseTwoLoginUsersCsv();

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

	@DataProvider(name = "login")
	public Object[][] getLogin() throws Exception {

		Object[][] retObjectArr = parseCsv();

		return retObjectArr;

	}
}