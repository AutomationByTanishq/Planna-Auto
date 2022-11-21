package com.auction.verifications;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.text.ParseException;
import java.util.Properties;
import java.util.jar.Attributes.Name;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.auction.init.Common;
import com.auction.init.SeleniumInit;
import com.auction.init.ConfigFileReader;
import com.auction.pages.DashboardPage;

public class LiveSale extends SeleniumInit {

	// String saleno = null;
	// String auctionName = null;
	String lotName = null;
	String uName = null;
	String bidder2 = "rahulbid";
	String bidder2Pass = "123123a";
	Common common = new Common(driver); 
	
	ConfigFileReader configFileReader= new ConfigFileReader();

	/**
	 * Verify Auction Type Missing
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Auction_Type_Missing(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyAuctionTypeMissing(Name);

	}

	/**
	 * Verify Sale Number Missing
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Sale_Number_Missing(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"Create Sale number missing Feature,TestCase Name: 3.2 Sale number missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifySaleNumberMissing(Name);
		// default sale no generated
	}

	/**
	 * Verify Number of Days Missing
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Number_Of_Days_Missing(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"Create Number of days missing Feature,TestCase Name: 3.3 Number of days missing Feature.");
		log("<br></br> Step :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyDaysNumberMissing();

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
		log("Feature" + "-" + "UAT"
				+ "\"Create Start date missing Feature,TestCase Name: 3.4 Start date missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyStartDateMissing();

	}

	/**
	 * Create Auction
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Create_Auction(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT" + "\"Create New Auction Feature,TestCase Name: 3.5 Create New  Auction Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.createNewLiveAuction(saleno); // Auction created
	}

	/**
	 * Create Auction with All fields filled out
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Allfields_Filled_Out(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT"
				+ "\"Create All fields filled out Feature,TestCase Name: 3.6 Create All fields filled out Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String str = common.generateRandomNumber1();

		System.out.println("Sale number " + str + "\n");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", str); // Fil
																						// auction
		// field.

	}

	/**
	 * Verify start date in the past auction not started
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Start_Date_In_The_Past_Auction_Not_Started(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		String PastDate = common.PastDate(2);
		log("Feature" + "-" + "UAT"
				+ "\"Create start date in the past auction not started Feature,TestCase Name: 3.7 start date in the past auction not started Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String name = adminDashboardPage.create_Live_Auction_With_Auctioneer_Past_Date(PastDate, "1", saleno);
		adminDashboardPage.catalog_Visible_Auction_Status();
		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verifyLoginPageElements(); // Verify Login Page Elements
		dashboardPage = loginPage.loginUser(UName, password); // Login with
																// valid
																// credentials

		dashboardPage.verifyStartDateInThePastAuctionNotStarted(name, PastDate);
	}

	/**
	 * Verify start date in the future Feature
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Start_Date_In_The_Future(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String futureDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT"
				+ "\"Create start date in the future Feature,TestCase Name: 3.9 start date in the future Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String name = adminDashboardPage.create_Live_Auction_With_Auctioneer(futureDate, "1", saleno);

		adminDashboardPage.catalog_Visible_Auction_Status();
		adminDashboardPage.front(); // Open Front End

		// Front user Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verifyLoginPageElements(); // Verify Login Page Elements
		dashboardPage = loginPage.loginUser(UName, password); // Login with
																// valid
																// credentials
		dashboardPage.verify_Live_Auction_Status_Feature(name); // Verify Live
																// Auction
																// Feature
	}

	/**
	 * Number of days = 0 Feature
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Number_Of_Days_0(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"Number of days = 0 Feature,TestCase Name: 3.10 Number of days = 0 Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String name = adminDashboardPage.create_Live_Auction_With_Auctioneer_Number_Of_Days_0(tomorrowDate, "0",
				saleno);

		/*
		 * Bug : The number of days= 0 is accepted. Expected result: The number of days
		 * must be greater than 0
		 */
	}

	/**
	 * Number of days = 1 Feature
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Number_Of_Days_1(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"Number of days = 1 Feature,TestCase Name: 3.11 Number of days = 1 Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String name = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		// adminDashboardPage.Status(name, tomorrowDate, 0, "Live", saleno);
		/*
		 * Pending:
		 * 
		 * check auction status and visibility at day 0 and day 1
		 */
	}

	/**
	 * Number of days = 2 Feature
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Number_Of_Days_2(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"Number of days = 2 Feature,TestCase Name: 3.12 Number of days = 2 Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String name = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "2", saleno);


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
		log("Feature" + "-" + "UAT"
				+ "\"higher than allowed max Feature,TestCase Name: 3.13 higher than allowed max Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verifyHigherThanAllowedMax(tomorrowDate, "1", "2147483648");

	}

	/**
	 * Create live auction 1 Feature
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Create_Live_Auction_1(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT"
				+ "\"Create live auction 1 Feature,TestCase Name: 3.14 create live auction 1 Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.create_Live_Auction("auction group 1"); // Create
																	// auction.

	}

	/**
	 * Create live auction 2 Feature
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Create_Live_Auction_2(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT"
				+ "\"Create live auction 2 Feature,TestCase Name: 3.15 create live auction 2 Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.create_Live_Auction("auction group 2"); // Create
																	// Auction.

	}

	/**
	 * Create live auction 3 Feature
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Create_Live_Auction_3(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		String Name1 = common.generateRandomChars(5);
		log("Feature" + "-" + "UAT"
				+ "\"Create live auction 3 Feature,TestCase Name: 3.16 create live auction 3 Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.create_Live_Auction(Name1);

	}

	/**
	 * Create live auction 4 Feature
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Create_Live_Auction_4(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT"
				+ "\"Create live auction 4 Feature,TestCase Name: 3.17 create live auction 4 Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.create_Live_Auction("auction group 4");

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
		log("Feature" + "-" + "UAT" + "\"Create first group Feature,TestCase Name: 3.18 Create first group Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auctionurl = adminDashboardPage.create_Live_Auction(saleno);

		adminDashboardPage.create_Live_Auction(saleno1); // Create Timed
															// Auction

		adminDashboardPage.verifyClickEditLink(auctionurl);
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

		log("Feature" + "-" + "UAT"
				+ "\"default sale group value is N/A Feature,TestCase Name: 3.19 default sale group value is N/A Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyDefaultSaleGroupValue(tomorrowDate, "1", saleno);

	}

	/**
	 * Click edit link
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Clicked_It_Link(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		String saleno1 = common.generateRandomNumber1();
		String saleno2 = common.generateRandomNumber1();
		log("Feature" + "-" + "UAT" + "\"Click edit link Feature,TestCase Name: 3.20 Click edit link Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno = adminDashboardPage.create_Live_Auction(saleno1);

		adminDashboardPage.create_Live_Auction(saleno2);

		adminDashboardPage.verifyEditLink(saleno);

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

		String saleno = common.generateRandomNumber1();
		String saleno1 = common.generateRandomNumber1();
		log("Feature" + "-" + "UAT"
				+ "\"Click edit link select another sale update Feature,TestCase Name: 3.21 Click edit link select another sale update Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String sale = adminDashboardPage.create_Live_Auction(saleno);
		adminDashboardPage.create_Live_Auction(saleno1);
		adminDashboardPage.verifyGroupNameMissing(sale);

	}

	/**
	 * Enter a group name click edit link select another sale check simultaneous
	 * sales update
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Enter_a_Groupname_Click_Editlink_Select_Another_Sale_Check_Simultaneous_Sales_Update(
			String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		String saleno1 = common.generateRandomNumber1();
		log("Feature" + "-" + "UAT"
				+ "\"Enter a group name click edit link select another sale check simultaneous sales update Feature,TestCase Name: 3.22 Enter a group name click edit link select another sale check simultaneous sales update Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auction1 = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1_2();
		adminDashboardPage.addLotRandomForUser(2);

		String auction2 = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno1);
		adminDashboardPage.approveBidder1_2();
		adminDashboardPage.addLotRandomForUser(2);
		adminDashboardPage.verifySimultaneousSalesUpdate(saleno);
		adminDashboardPage.start_Auction();
		adminDashboardPage.runLiveAuction(saleno1);

		adminDashboardPage.front(); // Open Front End
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verifyLoginPageElements(); // Verify Login Page Elements
		dashboardPage = loginPage.loginUser(UName, password); // Login with
																// valid
																// credentials
		dashboardPage.verify_Two_Chat_Window_Simultaneously_Auction_Live_Sale(auction1);

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

		log("Feature" + "-" + "UAT" + "\"Verify Cancel Group Feature,TestCase Name: 3.23 Verify Cancel Group Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String saleno = adminDashboardPage.create_Live_Auction("Perfect QA Group1");
		adminDashboardPage.verify_Cancel("Perfect QA Group1", saleno);

	}

	/**
	 * Verify Cancel Sale Group Feature
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Verify_Cancel_Sale_Group(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"Verify Cancel sale Group Feature,TestCase Name: 3.24 Verify Cancel sale Group Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String sale = common.generateRandomChars(5);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String saleno = adminDashboardPage.create_Live_Auction(sale);
		String saleno1 = adminDashboardPage.create_Live_Auction(sale);

		adminDashboardPage.verify_Cancel("Perfect QA Group1", saleno1);

	}

	/**
	 * s Enter a name longer than the max length
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Enter_Name_Longer_Than_The_Max_Length(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT"
				+ "\"Enter a name longer than the max length Feature,TestCase Name: 3.25 Enter a name longer than the max length Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verify_Max_Length_Livesale(); // Verify Max Length
	}

	/**
	 * Enter a name with special characters
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Enter_Name_With_Special_Characters(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT"
				+ "\"Enter a name with special characters Feature,TestCase Name: 3.26 Enter a name with special characters Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verifyNameWithSpecialChar(); // Verify name
	}

	/**
	 * Enter a Description with special characters
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Enter_Description_With_Special_Characters(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT"
				+ "\"Enter Description with special characters Feature,TestCase Name: 3.27 Enter Description with special characters Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verifyDescriptionWithSpecialChar(); // Description
																// with special
																// characters.
	}

	/**
	 * Enter a description and enhance the text
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Enter_Description_and_Enhance_The_Text(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT"
				+ "\"Enter a description and enhance the text Feature,TestCase Name: 3.28 Enter a description and enhance the text Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verifyDescriptionWithSpecialCharacter();
	}

	/**
	 * Enter a Terms and condition with special characters
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Enter_Terms_and_Condition_With_Special_Characters(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT"
				+ "\"Enter Terms and condition with special characters Feature,TestCase Name: 3.30 Enter Terms and condition with special characters Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verifyTermsAndCondition(); // verify terms and
														// condition
	}

	/**
	 * Enter a Terms and condition and enhance the text
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Enter_Terms_and_Condition_and_Enhance_The_Text(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT"
				+ "\"Enter a Terms and condition and enhance the text Feature,TestCase Name: 3.31 Enter a Terms and condition and enhance the text Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.termsAndCondition();
	}

	/**
	 * Verify Upload a picture the sale Feature
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")

	public void Upload_Picture_Save_The_Sale(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Verify Upload a picture save the sale Feature,TestCase Name: 3.32 Verify Upload a picture save the sale Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyUploadPicture();

	}

	/**
	 * Do not upload a picture
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Do_Not_Upload_Picture(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"Do not upload a picture Feature,TestCase Name: 3.33 Do not upload a picture Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.create_Live_Auction("PerfectQAServices");

	}

	/**
	 * upload a picture remove the existing picture
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Upload_Picture_Remove_The_Existing_Picture(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"Upload a picture remove the existing picture Feature,TestCase Name: 3.34 Upload a picture remove the existing picture Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyUploadPicture();
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
		log("Feature" + "-" + "UAT"
				+ "\"Leave checkbox unchecked save Feature,TestCase Name: 3.35 Leave checkbox unchecked save Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String name = adminDashboardPage.createNewLiveAuction(saleno);

		adminDashboardPage.front(); // Open Front End
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verifyLoginPageElements(); // Verify Login Page Elements
		dashboardPage = loginPage.loginUser(UName, password); // Login with
																// valid
																// credentials

		dashboardPage.verify_Live_Auction_Not_Present(name);

	}

	/**
	 * check the checkbox save
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Check_The_Checkbox_Save(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"check the checkbox save Feature,TestCase Name: 3.36 check the checkbox save Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String name = adminDashboardPage.fillAllFieldInAuction(saleno);
		adminDashboardPage.front(); // Open Front End
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verifyLoginPageElements(); // Verify Login Page Elements
		dashboardPage = loginPage.loginUser(UName, password); // Login with
																// valid
																// credentials

		dashboardPage.verify_Live_Auction_Present(name);

	}

	/**
	 * Uncheck the option for an already published auction
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Uncheck_The_Option_For_an_Already_Published_Auction(String adminUserName, String adminPassword,
			String UName, String password) throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"Uncheck the option for an already published auction Feature,TestCase Name: 3.37 uncheck the option for an already published auction Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		String tomorrowDate = common.tomorrowDate();

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		adminDashboardPage.front(); // Open Front End
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verifyLoginPageElements(); // Verify Login Page Elements
		dashboardPage = loginPage.loginUser(UName, password); // Login with
																// valid
																// credentials

		dashboardPage.verify_Live_Auction_Present(auctionName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.unpublishAuction(saleno);

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verifyLoginPageElements(); // Verify Login Page Elements
		dashboardPage = loginPage.loginUser(UName, password); // Login with
		// valid
		// credentials

		dashboardPage.verify_Live_Auction_Not_Present(auctionName);

	}

	/**
	 * Check the option for a previously unpublished auction
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Check_The_Option_For_a_Previously_UnPublished_Auction(String adminUserName, String adminPassword,
			String UName, String password) throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"Check the option for a previously unpublished auction Feature,TestCase Name: 3.38 Check the option for a previously unpublished auction Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String name = adminDashboardPage.createLiveUnpublishAuction(saleno);

		adminDashboardPage.front(); // Open Front End
		loginPage = indexPage.clickOnLoginLink(); // click on login link

		dashboardPage = loginPage.loginUser(UName, password); // Login with
		// valid
		// credentials

		dashboardPage.verify_Live_Auction_Not_Present_Frontend(name);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.publishAuction(saleno);

		adminDashboardPage.front(); // Open Front End

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verifyLoginPageElements(); // Verify Login Page Elements
		dashboardPage = loginPage.loginUser(UName, password); // Login with
		// valid
		// credentials

		dashboardPage.verify_Live_Auction_Present_At_Frontend(name); // Live Auction
															// present.
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
		log("Feature" + "-" + "UAT"
				+ "\"Leave checkbox unchecked save Feature,TestCase Name: 3.39 Leave checkbox unchecked save Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.disable_Lot_Upload_For_Consignor_Settings();
		String name = adminDashboardPage.fillAllFieldInAuction(saleno);

		adminDashboardPage.enableconsignorupload();

		adminDashboardPage.front(); // Open Front End
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verifyLoginPageElements(); // Verify Login Page Elements
		dashboardPage = loginPage.loginUser(UName, password); // Login with
																// valid
																// credentials
		common.pause(20);
		dashboardPage.myItemConsignorUploadNotDisplay(); // upload lot button
															// not display

	}

	/**
	 * Edit an existing auction go to the auction lots tab click on add lot fill out
	 * the fields but not the lot name
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Lot_Name_Missing(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"Edit an existing auction go to the auction lots tab click on add lot fill out the fields but not the lot name Feature,TestCase Name: 3.59 Edit an existing auction go to the auction lots tab click on add lot fill out the fields but not the lot name Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verifyLotNameMissing("0");

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
		log("Feature" + "-" + "UAT"
				+ "\"Fill out just the lot name Feature,TestCase Name: 3.60 Fill out just the lot name Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verifyFillOutJustTheLotName("PerfectQAServices");

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

		String lotName = common.generateRandomChars(3);
		log("Feature" + "-" + "UAT"
				+ "\"Verify Create New Lot Feature,TestCase Name: 3.61 Verify Create New Lot Feature.>>Fill out all the fields");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno = common.generateRandomNumber1();

		adminDashboardPage.createNewLiveAuction(saleno);
		adminDashboardPage.addALot(lotName);
	}

	/**
	 * Verify Fill out all the fields with erroneous values
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Fillout_All_The_Fields_With_Erroneous_Values(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"Fill out all the fields with erroneous values Feature,TestCase Name: 8.29 Fill out all the fields with erroneous values Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();

		String saleno1 = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.createNewLiveAuction(saleno1);

		adminDashboardPage.verify_Lot_Details_With_Erroneous_Values(); // Verify
																		// Lot
																		// Details

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
		log("Feature" + "-" + "UAT" + "\"Assign one category Feature,TestCase Name: 3.63 Assign one category Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();

		String saleno1 = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.createNewLiveAuction(saleno1);
		System.out.println("Step :: auction Name  :" + auctionName);
		common.log("<br></br> Step :: auction Name  :" + auctionName);

		String lotname = adminDashboardPage.verifyAssignOneCategory();

		String assigncat = adminDashboardPage.get_Category_From_Lot_Table();

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verifyLoginPageElements(); // Verify Login Page Elements
		dashboardPage = loginPage.loginUser(UName, password); // Login with
		// valid
		// credentials
		dashboardPage.Assignview_catalog(saleno1, auctionName, lotname);

		// dashboardPage.Verify_multiple_Category(lotname);
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
		log("Feature" + "-" + "UAT"
				+ "\"assign multiple categories Feature,TestCase Name: 3.64 assign multiple categories Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();
		String saleno1 = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.createNewLiveAuction(saleno1);
		System.out.println("Step :: auction Name s :" + auctionName);
		common.log("<br></br> Step :: auction Name s :" + auctionName);

		String lotname = adminDashboardPage.verifyassign_Multiple_Category();
		// String assigncat = adminDashboardPage.Get_Category_From_Lot_Table();

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verifyLoginPageElements(); // Verify Login Page Elements
		dashboardPage = loginPage.loginUser(UName, password); // Login with
		// valid
		// credentials
		dashboardPage.Assignview_catlog_multicategory(saleno1, auctionName, lotname);
		System.out.println("verify lot name ::" + lotname);
		// dashboardPage.Verify_multiple_Category(lotname);
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
		log("Feature" + "-" + "UAT"
				+ "\"Enter Already exist Item Number Feature,TestCase Name: 8.32 Enter Already exist Item Number Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();
		String saleno1 = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.createNewLiveAuction(saleno1);
		adminDashboardPage.addLotRandom(1);

		adminDashboardPage.verify_Existing_Item_Number(saleno1);
	}

	/**
	 * Enter More than Higher Item Number
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Enter_More_Than_Higher_Item_Number(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"Enter More than Higher Item Number Feature,TestCase Name: 3.66 Enter More than Higher Item Number Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.VerifyHigherItemNumber();
	}

	/**
	 * Verify keep Item number blank
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void keep_Item_Number_Blank(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"Verify keep Item number blank Feature,TestCase Name: 3.67 Verify keep Item number blank Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verifyItemNumber();
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
		log("Feature" + "-" + "UAT"
				+ "\"Enter an available value Feature,TestCase Name: 3.68 Enter an available value Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verifyItemNumberOnLotPage();
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
		log("Feature" + "-" + "UAT"
				+ "\"Verify Leave item number Empty Feature,TestCase Name: 3.69 Verify Leave item numb er Empty Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verifyItemNumber();

	}

	/**
	 * Enter Already exist Lot Number
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Enter_Already_Existing_Lot_Number(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"Enter Already exist Item Number Feature,TestCase Name: 8.39 Enter Already exist Lot Number Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.addLotRandom(1);

		adminDashboardPage.verify_Existing_Lot_Number(saleno); // Verify
																// Existing
																// Lot
																// Number
	}

	/**
	 * Verify Enter lot number value that is not yet used
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Verify_Enter_Lot_Number_Value_That_Is_Not_Yet_Used(String adminUserName, String adminPassword,
			String UName, String password) throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"Verify Enter lot number value that is not yet used Feature,TestCase Name: 3.71 Verify Enter lot number value that is not yet used Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verifyCorrectLotNumber();

	}

	/**
	 * Verify Enter lot number value that is non numeric value
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Verify_Enter_Lot_Number_Value_That_Is_No_Numeric_Value(String adminUserName, String adminPassword,
			String UName, String password) throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"Verify Enter lot number value that is non numeric value Feature,TestCase Name: 3.72 Verify Enter lot number value that is non numeric value Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verifyNumericLotnumber();

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
		log("Feature" + "-" + "UAT"
				+ "\"Verify lot description - enriched text Feature,TestCase Name: 3.77 Verify lot description - enriched text Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verifyLotDescription();

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
		log("Feature" + "-" + "UAT"
				+ "\"Specify 2 working image links Field Feature,TestCase Name: 3.78 Specify 2 working image links Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verifyAddMultipleImageLink();
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
		log("Feature" + "-" + "UAT"
				+ "\"Specify a broken image link Field Feature,TestCase Name: 3.79 Specify a broken image link Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verifyBrokenUrlLink();
		// Broken image link not accepted
	}

	/**
	 * upload several valid images
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	@Test(dataProvider = "createauction")
	public void Upload_Several_Valid_Images(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"upload several valid images Feature,TestCase Name: 3.80 upload several valid images Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verifyAddMultipleImageLink();

	}

	/**
	 * remove existing image link
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Remove_Existing_Image_Link(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"remove existing image link Feature,TestCase Name: 3.81 remove existing image link Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.deleteImageLink();
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
		log("Feature" + "-" + "UAT"
				+ "\"remove existing uploaded image Feature,TestCase Name: 3.82 remove existing uploaded image Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.deleteImageLink();
	}

	/**
	 * Enter the number of an existing lot
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Enter_The_Number_Of_an_Existing_Lot(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"Enter the number of an existing lot Feature,TestCase Name: 3.83 Enter the number of an existing lot Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		String tomorrowDate = common.tomorrowDate();

		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); // Create
		

		String lotname = adminDashboardPage.addLotRandom(1); // User 1
		adminDashboardPage.verifyEnterTheNumberOfAnExistingLot(saleno);

	}

	/**
	 * Enter the number of a non existing lot in the auction
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Enter_The_Number_Of_an_Non_Existing_Lot_In_The_Auction(String adminUserName, String adminPassword,
			String UName, String password) throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"Enter the number of a non existing lot in the auction Feature,TestCase Name: 3.84 Enter the number of a non existing lot in the auction Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verifyEnterTheNumberOfAnExistingLotInTheAuction();

	}

	/**
	 * Verify winning bidder
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Verify_Winning_Bidder(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"Verify winning bidder Feature,TestCase Name: 3.85 Verify winning bidder Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		String tomorrowDate = common.tomorrowDate();

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); // Create
		// Auction
		adminDashboardPage.approveBidder1_2(); // Approve both bidder

		String lotname = adminDashboardPage.addLotRandom(4); // User 1

		adminDashboardPage.start_Auction();
		adminDashboardPage.front();

		// User 1
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName); // Place
																		// Bid
																		// on
																		// live
																		// auction
		// Goto admin side
		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.sold_Live_Lot(auctionName, saleno); // Sold lot to
																// online bidder

		adminDashboardPage.front();

		// User 2
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName); // Place
																		// Bid
																		// on
																		// live
																		// auction
		// Goto admin side
		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.sold_Live_Lot(auctionName, saleno); // Sold lot to
																// online bidder

		adminDashboardPage.front();

		// User 1
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName); // Place
																		// Bid
																		// on
																		// live
																		// auction
		// Goto admin side
		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.sold_Live_Lot(auctionName, saleno); // Sold lot to
																// online bidder

		adminDashboardPage.front();

		// User 2
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName); // Place
																		// Bid
																		// on
																		// live
																		// auction
		// Goto admin side
		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.sold_Live_Lot(auctionName, saleno);

		adminDashboardPage.find_Winner_Bidder(saleno, lotname); // Verify
																// Winning
																// Bidder

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
		log("Feature" + "-" + "UAT" + "\"Verify more actions Feature,TestCase Name: 3.88 Verify more actions Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admincmd URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionname = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); // Create
		// Auction
		String lotname = adminDashboardPage.addLot(1);
		Thread.sleep(1000);
		adminDashboardPage.verify_More_Actions();
		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verifyLoginPageElements(); // Verify Login Page Elements
		dashboardPage = loginPage.loginUser(UName, password); // Login with
		// valid
		// credentials

		dashboardPage.catlogSectionGetPDFText(auctionname);
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
		log("Feature" + "-" + "UAT"
				+ "\"Verify Randomly reassign lot numbers Feature,TestCase Name: 3.93 Verify Randomly reassign lot numbers Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String name = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); // Create
		// Auction
		// System.out.print("\n" + name);
		adminDashboardPage.addLotRandom(1);
		adminDashboardPage.addLotRandomForUser(1);
		common.pause(10);
		adminDashboardPage.verifyRandomlyReassignLotNumbers();

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

		log("Feature" + "-" + "UAT"
				+ "\"Verify keyword search Feature,TestCase Name: 3.95 Verify keyword search Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); // Create
		// Auction

		String lotname = adminDashboardPage.addMultipleLot(3);

		String lot_inventory = adminDashboardPage.add_Multiple_Inventory(1);
		String lot_inventory1 = adminDashboardPage.add_One_Inventory(1);
		String lot_inventory2 = adminDashboardPage.add_Two_Inventory(1);
		// Some
		// time
		// xpath
		// issue
		// Auction
		adminDashboardPage.search_Last_Created_Auction(saleno);
		adminDashboardPage.verifykeywordSearch(lotname, lot_inventory);
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
				+ "\"Verify Filter(Category) Feature,TestCase Name: 3.96 Verify Filter(Category) Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String saleno1 = common.generateRandomNumber1();

		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno1); // Create
		// Auction
		String lotname1 = adminDashboardPage.add_Lot_With_Cat2(1);
		String lotname2 = adminDashboardPage.add_Lot_With_Cat3(1);

		// Add inventory items

		String item1 = adminDashboardPage.multipleAddItemToTheInventery(1);
		String item2 = adminDashboardPage.verifyAddItemtoTheInventeryCat5();
		// Auction
		adminDashboardPage.search_Last_Created_Auction(saleno1);
		adminDashboardPage.verify_Category(item1, item2, lotname1, lotname2);
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
				+ "\"Verify Filter(Consignor) Feature,TestCase Name: 3.97 Verify Filter(Consignor) Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno1 = Common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();
		String saleno = Common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); //
		// Create
		// Auction

		// Add lots with consignor

		String lotname = adminDashboardPage.add_Lot_With_Consignor1();
		String lotname1 = adminDashboardPage.add_Lot_With_Consignor2();
		String lotname2 = adminDashboardPage.add_Lot_with_Consignor3();
		// Auction
		adminDashboardPage.verify_Consignor_In_Lot(lotname);

	}

	/**
	 * Verify Filter(Status)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Status(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"Verify Filter(Status) Feature,TestCase Name: 3.98 Verify Filter(Status) Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		String tomorrowDate = common.tomorrowDate();
		String saleno1 = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); // Create
		// Auction

		adminDashboardPage.addMultipleLot(3);

		adminDashboardPage.multipleAddItemToTheInventery(2);

		adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno1);

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
				+ "\"Verify Filter(Billing Status) Feature,TestCase Name: 3.99 Verify Filter(Billing Status) Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Setting_blockassign_notactive();

		adminDashboardPage.setting_Auto_Create_And_Floor_Buyer_Active();
		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		String lotname1 = adminDashboardPage.addLotRandom(1);
		String lotname2 = adminDashboardPage.addLotRandom(1);
		String lotname3 = adminDashboardPage.addLotRandom(1);
		String lotname4 = adminDashboardPage.addLotRandom(1);
		String lotname5 = adminDashboardPage.addLotRandom(1);
		String lotname6 = adminDashboardPage.addLotRandom(1);

		String lotname7 = adminDashboardPage.add_Lot_With_Consignor1();
		String lotname8 = adminDashboardPage.add_Lot_With_Consignor1();
		String lotname9 = adminDashboardPage.add_Lot_With_Consignor1();
		String lotname10 = adminDashboardPage.add_Lot_With_Consignor1();
		String lotname11 = adminDashboardPage.add_Lot_With_Consignor1();
		String lotname12 = adminDashboardPage.add_Lot_With_Consignor1();

		System.out.println("Step :: Generated Lot Name 1 >> " + lotname1);
		System.out.println("Step :: Generated Lot Name 2 >> " + lotname2);
		System.out.println("Step :: Generated Lot Name 3 >> " + lotname3);
		System.out.println("Step :: Generated Lot Name 4 >> " + lotname4);
		System.out.println("Step :: Generated Lot Name 5 >> " + lotname5);
		System.out.println("Step :: Generated Lot Name 6 >> " + lotname6);
		System.out.println("Step :: Generated Lot Name 7 >> " + lotname7);
		System.out.println("Step :: Generated Lot Name 8 >> " + lotname8);
		System.out.println("Step :: Generated Lot Name 9 >> " + lotname9);
		System.out.println("Step :: Generated Lot Name 10 >> " + lotname10);
		System.out.println("Step :: Generated Lot Name 11 >> " + lotname11);
		System.out.println("Step :: Generated Lot Name 12 >> " + lotname12);

		adminDashboardPage.start_Auction();

		// Generate Invoice For Floor Bidder

		String biddername = adminDashboardPage.generate_Floor_Bidder_Invoice(saleno); // Post
																						// floor
																						// bid
																						// and
																						// sell
		// lot 1

		adminDashboardPage.generate_Invoice_With_Random_Bidder(auctionName, biddername); // Goto
																							// invoice
																							// tab
		// and generate
		// invoice

		String biddername1 = adminDashboardPage.generate_Floor_Bidder_Invoice_User2(saleno); // Post
																								// floor
																								// bid
																								// and
																								// sell
		// lot 2

		adminDashboardPage.generate_Invoice_With_Random_Bidder(auctionName, biddername1); // Goto
																							// invoice
																							// tab
		// and generate
		// invoice

		String biddername2 = adminDashboardPage.generate_Floor_Bidder_Invoice_User2(saleno); // Post
																								// floor
																								// bid
																								// and
																								// sell
		// lot 3

		adminDashboardPage.generate_Invoice_With_Random_Bidder(auctionName, biddername2); // Goto
																							// invoice
																							// tab
		// and generate
		// invoice
		String biddername3 = adminDashboardPage.generate_Floor_Bidder_Invoice_User2(saleno); // Post
																								// floor
																								// bid
																								// and
																								// sell
		// lot 4

		adminDashboardPage.generate_Invoice_With_Random_Bidder(auctionName, biddername3); // Goto
																							// invoice
																							// tab
		// and generate
		// invoice
		String biddername4 = adminDashboardPage.generate_Floor_Bidder_Invoice_User2(saleno); // Post
																								// floor
																								// bid
																								// and
																								// sell
		// lot 5

		adminDashboardPage.generate_Invoice_With_Random_Bidder(auctionName, biddername4); // Goto
																							// invoice
																							// tab
		// and generate
		// invoice
		String biddername5 = adminDashboardPage.generate_Floor_Bidder_Invoice_User2(saleno); // Post
																								// floor
																								// bid
																								// and
																								// sell
		// lot 6

		adminDashboardPage.generate_Invoice_With_Random_Bidder(auctionName, biddername5); // Goto
																							// invoice
																							// tab
		// and generate
		// invoice

		adminDashboardPage.search_Last_Created_Auction(saleno);

		adminDashboardPage.sell_lot();
		adminDashboardPage.sell_lot();
		adminDashboardPage.sell_lot();
		adminDashboardPage.sell_lot();
		adminDashboardPage.sell_lot();
		adminDashboardPage.sell_lot();

		adminDashboardPage.edit_Invoice_Status_Open(auctionName, biddername);
		adminDashboardPage.edit_Invoice_Status_Pending(auctionName, biddername1);
		adminDashboardPage.edit_Invoice_Status_Paid(auctionName, biddername2);
		adminDashboardPage.edit_Invoice_Status_Shipped(auctionName, biddername3);
		adminDashboardPage.edit_Invoice_Status_Cancelled(auctionName, biddername4);
		adminDashboardPage.edit_Invoice_Status_Deleted(auctionName, biddername5);

		// Change Draft Section

		adminDashboardPage.generate_Draft_In_Transport(saleno, auctionName); // Generate
																				// Draft

		adminDashboardPage.generate_Draft_Delivered(saleno, auctionName); // Generate
		// Draft

		adminDashboardPage.generate_Draft_Void(saleno, auctionName); // Generate
		// Draft
		adminDashboardPage.generate_Draft_Retailed(saleno, auctionName); // Generate
		// Draft
		adminDashboardPage.generate_Draft_Arbitration(saleno, auctionName); // Generate
		// Draft

		String auctionName1 = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		// lot bill verification pending...

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
		log("Feature" + "-" + "UAT"
				+ "\"Verify Combination of all filters Feature,TestCase Name: 3.100 Verify Combination of all filters Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno1 = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		String consignor = common.generateRandomChars(5);

		driver.get(configFileReader.getAdminUrl()); // Admin URL

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); // Create
		// Auction
		 adminDashboardPage.add1lotWithConsignor(consignor);
		adminDashboardPage.addMultipleLot(2);
		
		adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.verifyCombinationOfAllFilters(consignor);

	}

	/**
	 * Verify Block sold lots from being assigned to other sales filters
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Block_Sold_Lots_From_Being_Assigned_To_Other_Sales(String adminUserName, String adminPassword,
			String UName, String password) throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"Verify Block sold lots from being assigned to other sales Feature,TestCase Name: 3.101 Verify Block sold lots from being assigned to other sales Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno1 = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Setting_blockassign_active();
		adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); // Create
		// Auction

		String lotname1 = adminDashboardPage.addLot1();
		adminDashboardPage.runLiveSale1();
		String lotname2 = adminDashboardPage.addLot1();

		// adminDashboardPage.AllFieldsFill(tomorrowDate, "1", saleno1); //
		// Create
		adminDashboardPage.verifyBlockSoldLotsFromBeingAssignedToOtherSales(lotname1, lotname2);
	}

	/*
	 * Verify Block sold lots from being assigned to other sales is active
	 * 
	 * @throws InterruptedException
	 * 
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Block_Sold_Lots_From_Being_Assigned_To_Other_Sales_Is_Active(String adminUserName, String adminPassword,
			String UName, String password) throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"Verify Block sold lots from being assigned to other sales is active Feature,TestCase Name: 3.102 Verify Block sold lots from being assigned to other sales is active Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		String tomorrowDate = common.tomorrowDate();
		String saleno1 = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.setting_Blockassign_Activeandnone();
		adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "7", saleno); // Create
		// Auction

		String lotname1 = adminDashboardPage.addLot1();
		String lotname2 = adminDashboardPage.addALot2();
		adminDashboardPage.runLiveSale1();

		adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "4", saleno1); // Create

		adminDashboardPage.verifyBlockSoldLotsFromBeingAssignedToOtherSalesIsActive(lotname1, lotname2);
	}

	/**
	 * Verify Block sold lots from being assigned to other sales is active
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Block_Sold_Lots_From_Being_Assigned_To_Other_Sales_Is_Active1(String adminUserName,
			String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"Verify Block sold lots from being assigned to other sales is active Feature,TestCase Name: 3.103 Verify Block sold lots from being assigned to other sales is active Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno1 = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.setting_Blockassign_Activeandwarning();

		adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); // Create
		// Auction

		String lotname1 = adminDashboardPage.addLot1();
		String lotname2 = adminDashboardPage.addALot2();
		adminDashboardPage.runLiveSale1();

		adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno1); // Create
		adminDashboardPage.verifyBlockSoldLotsFromBeingAssignedToOtherSalesIsActive1(lotname1, lotname2);

	}

	/**
	 * Verify Block sold lots from being assigned to other sales is active
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Block_Sold_Lots_From_Being_Assigned_To_Other_Sales_Is_Active2(String adminUserName,
			String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"Verify Block sold lots from being assigned to other sales is active Feature,TestCase Name: 3.104 Verify Block sold lots from being assigned to other sales is active Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		String tomorrowDate = common.tomorrowDate();
		String saleno1 = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.setting_Blockassign_Activeandblockcompletely();

		adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); // Create
		// Auction

		String lotname1 = adminDashboardPage.addLot1();
		String lotname2 = adminDashboardPage.addALot2();
		adminDashboardPage.runLiveSale1();

		adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno1); // Create
		// Auction

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
		log("Feature" + "-" + "UAT"
				+ "\"Verify change page link Feature,TestCase Name: 3.105 Verify change page link Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verifyChangePageLink();
	}

	// 3.106 - No testcase present

	/**
	 * Verify check on starting bid, estimates
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Check_On_Starting_Bid_Estimates(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"Verify change page link Feature,TestCase Name: 3.107 Verify check on starting bid, estimates Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotname1 = adminDashboardPage.addLot1();
		String lotname2 = adminDashboardPage.addLot1();
		adminDashboardPage.start_Auction();
		adminDashboardPage.starting_Bid_Estimates(); // Verify values in
														// runlivesale tab

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.goto_Catalog_Page_Live_Sale(auctionName);
		dashboardPage.verify_Estimate_Values_Front(auctionName, saleno); // Verify
		// Estimate
		// Values in
		// Livesale
		// tab

	}

	/**
	 * Verify active
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Active(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT" + "\"Verify active Feature,TestCase Name: 3.108 Verify active Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); // Create
		// Auction

		String lotname1 = adminDashboardPage.addLot1();
		String lotname2 = adminDashboardPage.addLot1();
		adminDashboardPage.runLiveSale1();
		adminDashboardPage.next_Lot_Start_Auto(lotname2);

	}

	/**
	 * Verify disabled
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Disabled(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT" + "\"Verify disabled Feature,TestCase Name: 3.109 Verify disabled Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); // Create
		// Auction

		String lotname1 = adminDashboardPage.addLot1();
		String lotname2 = adminDashboardPage.addLot1();
		adminDashboardPage.runLiveSale1();
		adminDashboardPage.disabled(lotname2);

	}

	/**
	 * validate with Enter
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Validate_With_Enter(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"Validate with Enter Feature,TestCase Name: 3.110 validate with Enter.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // Approve bider
		String lotname1 = adminDashboardPage.addLot1();
		String lotname2 = adminDashboardPage.addLot1();
		adminDashboardPage.verifyAskingbid(); // verify asking bid

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.goto_Catalog_Page_Live_Sale(auctionName);
		dashboardPage.verify_Starting_Bid_Catalogpage(auctionName, saleno); // Verify
																			// Starting
		// bid

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.changeAskingBidWithEnter(auctionName, saleno, UName);

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.goto_Catalog_Page_Live_Sale_Auction(auctionName);
		dashboardPage.verify_Starting_Bid_Catalogpage(auctionName, saleno); // Verify
																			// new
		// Starting
		// bid

	}

	/**
	 * validate with button
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Validate_With_Button(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"validate with Enter Feature,TestCase Name: 3.111 validate with button.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		adminDashboardPage.approveBidder1(); // Approve bidder
		String lotname1 = adminDashboardPage.addLot1();
		String lotname2 = adminDashboardPage.addLot1();
		adminDashboardPage.verifyAskingbid(); // verify asking bid

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.goto_Catalog_Page_Live_Sale(auctionName);

		dashboardPage.verify_Starting_Bid_Catalogpage(auctionName, saleno); // Verify
																			// Starting
		// bid

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.changeAskingBidButton(auctionName, saleno, UName);

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.goto_Catalog_Page_Live_Sale_Auction(auctionName);
		dashboardPage.verify_Starting_Bid_Catalogpage(auctionName, saleno); // Verify
																			// new
		// Starting
		// bid

	}

	/**
	 * use quick change button
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Use_Quick_Change_Button(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"validate with Enter Feature,TestCase Name: 3.112 use quick change button");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		// String saleno = common.generateRandomNumber1(4);

		String saleno = common.generateRandomNumber1();

		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		adminDashboardPage.approveBidder1(); // approve bidder
		String lotname1 = adminDashboardPage.addLot1();
		String lotname2 = adminDashboardPage.addLot1();
		String lotname3 = adminDashboardPage.addLot1();
		adminDashboardPage.verifyAskingbid(); // verify asking bid

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.goto_Catalog_Page_Live_Sale(auctionName);
		dashboardPage.verify_Starting_Bid_Catalogpage(auctionName, saleno); // Verify
																			// Starting
		// bid

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.quickChangeAskingBidButton(auctionName, saleno, UName);

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.goto_Catalog_Page_Live_Sale_Auction(auctionName);
		dashboardPage.verify_Starting_Bid_Catalogpage(auctionName, saleno); // Verify
																			// new
		// Starting
		// bid

	}

	/**
	 * restore default increment link
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Restore_Default_Increment_Link(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"validate with Enter Feature,TestCase Name: 3.113 restore default increment link.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		adminDashboardPage.approveBidder1(); // Approve bidder

		String lotname1 = adminDashboardPage.addLot1();
		String lotname2 = adminDashboardPage.addLot1();
		String lotname3 = adminDashboardPage.addLot1();
		adminDashboardPage.verifyAskingbid(); // verify asking bid

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.goto_Catalog_Page_Live_Sale(auctionName);
		dashboardPage.verify_Starting_Bid_Catalogpage(auctionName, saleno); // Verify
																			// Starting
		// bid

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.restoreDefaultLink(auctionName, saleno, UName);

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.goto_Catalog_Page_Live_Sale_Auction(auctionName);
		dashboardPage.verify_Starting_Bid_Catalogpage(auctionName, saleno); // Verify
																			// new
		// Starting
		// bid

	}

	/**
	 * accept and sell
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Accept_and_Sell_Feature(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();

		String auc_name = common.generateRandomChars(5);
		log("Feature" + "-" + "UAT" + "\"accept and sell Feature,TestCase Name: 3.114 accept and sell Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String saleno1 = adminDashboardPage.create_Live_Auction(auc_name);

		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.start_Auction();
		adminDashboardPage.PostFloorBid1();

	}

	/**
	 * accept and undo
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Accept_and_Undo(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"accept and undo Feature,TestCase Name: 3.115 accept and undo Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String saleno1 = adminDashboardPage.create_Live_Auction("auction group 4");

		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.start_Auction();
		adminDashboardPage.undoLastAuction();

	}

	/**
	 * accept and pass
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Accept_and_Pass(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		String auc_name = common.generateRandomChars(5);

		log("Feature" + "-" + "UAT" + "\"accept and pass Feature,TestCase Name: 3.116 accept and pass Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String saleno1 = adminDashboardPage.create_Live_Auction(auc_name);

		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.start_Auction();
		adminDashboardPage.acceptAndPass();
	}

	/**
	 * accept and fair warning and accept and sell
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	@Test(dataProvider = "createauction")
	public void Accept_and_Fair_Warning_and_Sell(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		String auc_name = common.generateRandomChars(5);

		log("Feature" + "-" + "UAT"
				+ "\"accept and pass Feature,TestCase Name: 3.117 accept and fair warning and accept and sell.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String saleno1 = adminDashboardPage.create_Live_Auction(auc_name);

		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.start_Auction();
		adminDashboardPage.acceptAndFairWarningAndSell();

	}

	/**
	 * accept and sell
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Accept_and_Sell(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"validate with Enter Feature,TestCase Name: 3.118 accept and sell.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder

		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.start_Auction();

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link

		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);
		driver.get(configFileReader.getAdminUrl());

		
		adminDashboardPage = indexPage // Admin Signin
		
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Sold
																			// lot
																			// to
																			// internet
																			// bidder

	}

	/**
	 * accept and undo
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Accept_and_Undo1(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"validate with Enter Feature,TestCase Name: 3.119 accept and undo");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder
		adminDashboardPage.addLotRandom(1);
		adminDashboardPage.start_Auction();

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.accept_And_Undo_Feature(auctionName, saleno);

	}

	/**
	 * accept and pass
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Accept_and_Pass1(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"validate with Enter Feature,TestCase Name: 3.120 accept and pass");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder
		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.start_Auction();

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.accept_And_Pass_Feature(auctionName, saleno);

	}

	/**
	 * accept and fair warning and sell
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Accept_and_Fair_Warning_and_Sell1(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"validate with Enter Feature,TestCase Name: 3.121 accept and fair");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder
		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.start_Auction();

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.acceptAndFairWarningSell(auctionName, saleno);

	}

	/**
	 * active
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Active1(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"active Feature,TestCase Name: 3.122 active Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.setting_Auto_Create_Record_Active();
		adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "7", saleno); // Create
		// Auction

		String lotname1 = adminDashboardPage.addLot1();
		String lotname2 = adminDashboardPage.addALot2();

		String winnernumber = adminDashboardPage.runlivesale_Active();

		adminDashboardPage.verify_User(winnernumber);

	}

	/**
	 * active123
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Active123(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"active123 Feature,TestCase Name: 3.123 active123 Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.setting_Auto_Create_Record();
		adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "7", saleno); // Create
		// Auction

		String lotname1 = adminDashboardPage.addLot1();
		String lotname2 = adminDashboardPage.addALot2();

		String winnernumber = adminDashboardPage.runlivesale_Active();

		adminDashboardPage.verify_User(winnernumber);

	}

	/**
	 * disabled
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Disabled1(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"disabled Feature,TestCase Name: 3.124 disabled Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.auto_Create_Records_For_Non_Existing_Floor_Disable();
		adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "7", saleno); // Create
		// Auction

		String lotname1 = adminDashboardPage.addLot1();
		String lotname2 = adminDashboardPage.addALot2();

		String winnernumber = adminDashboardPage.runlivesale_Active();

		adminDashboardPage.verify_User(winnernumber);
	}

	/**
	 * active (Accept online bid button)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Active2(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"validate with Enter Feature,TestCase Name: 3.125 accept online bid button active");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder
		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.start_Auction();
		adminDashboardPage.autoAcceptOnlineBids(); // Auto accept online bid
													// button enable

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.autoAcceptBidFeature(auctionName, saleno);

	}

	/**
	 * disabled (Auto accept online bid)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Auto_Accept_Online_Disable(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"validate with Enter Feature,TestCase Name: 3.126 accept online bid button disable");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder
		adminDashboardPage.addLotRandom(1);
		adminDashboardPage.start_Auction();
		adminDashboardPage.autoAcceptOnlineBids1(); // Auto accept online bid
													// button disable

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.autoAcceptBidDisable(auctionName, saleno); //

	}

	/**
	 * Group items and sell
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Group_Items_and_Sell(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT"
				+ "\"group items and sell Feature,TestCase Name: 3.131 group items and sell Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName1 = adminDashboardPage.addMultipleLot(1);
		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);
		String lotName4 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.start_Auction();

		adminDashboardPage.groupchoice_Livesale(lotName2, lotName3);
		adminDashboardPage.group_Item_And_Sell_Livesale(auctionName, saleno);

	}

	/**
	 * group items and sell lot 1
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Group_Items_and_Sell1(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT"
				+ "\"group items and sell Feature,TestCase Name: 3.132 group items and sell Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder
		String lotName1 = adminDashboardPage.addMultipleLot(1);
		adminDashboardPage.start_Auction();

		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);
		String lotName4 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.runLiveSaleTab();

		adminDashboardPage.groupChoice_Livesale1(lotName2, lotName3);
		adminDashboardPage.group_Item_And_Sell_Lot1_Livesale(auctionName, lotName1,saleno);

	}

	/**
	 * group items and sell
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Group_Items_and_Sell2(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT"
				+ "\"group items and sell Feature,TestCase Name: 3.133 group items and sell Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder
		String lotName1 = adminDashboardPage.addMultipleLot(1);
		adminDashboardPage.start_Auction();

		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);
		String lotName4 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.runLiveSaleTab();

		adminDashboardPage.groupchoice_Livesale2(lotName2, lotName3);
		adminDashboardPage.group_Item_And_Sell_Lot_Livesale_1_2(saleno, auctionName, lotName1, lotName2);

	}

	/**
	 * group items and sell
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Group_Items_and_Sell3(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT"
				+ "\"group items and sell Feature,TestCase Name: 3.134 group items and sell Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder
		String lotName1 = adminDashboardPage.addMultipleLot(1);
		adminDashboardPage.start_Auction();

		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);
		String lotName4 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.runLiveSaleTab();

		adminDashboardPage.groupchoice_Livesale(lotName2, lotName3);
		adminDashboardPage.group_Item_And_Sell_Lot_Livesale_1_3(saleno, auctionName, lotName1, lotName3);

	}

	/**
	 * group items and pass
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Group_Items_and_Pass(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT"
				+ "\"group items and pass Feature,TestCase Name: 3.135 group items and pass Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName1 = adminDashboardPage.addMultipleLot(1);
		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);
		String lotName4 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.start_Auction();

		adminDashboardPage.groupchoice_Livesale(lotName2, lotName3);
		adminDashboardPage.group_Item_And_Pass_Lot_Livesale(auctionName,saleno, lotName1, lotName2);

	}

	/**
	 * group items and ungroup
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Group_Items_and_Ungroup(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT"
				+ "\"group items and ungroup Feature,TestCase Name: 3.136 group items and ungroup Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder
		String lotName1 = adminDashboardPage.addMultipleLot(1);
		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);
		String lotName4 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.start_Auction();

		adminDashboardPage.groupchoice_Livesale(lotName2, lotName3);
		adminDashboardPage.group_Item_And_Ungroup_Lot1_Livesale(auctionName, lotName1, lotName2, saleno);

	}

	/**
	 * group items and sell lot - Group (All4One)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Group_Items_and_Sell_lot_Group_All_4_One(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"group items and sell Feature,TestCase Name :: group items and sell Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName =adminDashboardPage.Create_Live_Auction_With_Auctioneer_Sagar(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName1 = adminDashboardPage.addMultipleLot(1);
		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);
		String lotName4 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.start_Auction();

		adminDashboardPage.group_All_Four_One_Live_Hybrid(lotName2, lotName3);
		adminDashboardPage.group_All4One_LiveSale(saleno,auctionName,lotName1, lotName3);

	}

	/**
	 * group items and sell lot - Group (All4One)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Group_Items_and_Sell_lot_Group_All_4_Three(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"group items and sell Feature,TestCase Name :: group items and sell Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.Create_Live_Auction_With_Auctioneer_Sagar(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName1 = adminDashboardPage.addMultipleLot(1);
		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);
		String lotName4 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.start_Auction();

		adminDashboardPage.group_All_Four_One_Live_Hybrid_Lot_2_4(lotName2, lotName3, lotName4);
		adminDashboardPage.group_All4One_LiveSale(saleno,auctionName,lotName1, lotName3);

	}

	/**
	 * group items and sell lot - Group (All4One)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Group_Items_and_Pass_lot_Group_All_4_one(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"group items and sell Feature,TestCase Name :: group items and sell Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName1 = adminDashboardPage.addMultipleLot(1);
		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);
		String lotName4 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.start_Auction();

		adminDashboardPage.group_All_Four_One_Live_Hybrid(lotName2, lotName3);
		adminDashboardPage.group_Item_And_Pass_Lot_LiveSale(saleno, auctionName, lotName1, lotName3);

	}

	
	/**
	 * group items and Pass select lot 1,2,3
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Group_Items_4_All_and_Ungroup_Lot1(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT"
				+ "\"group items and sell Feature,TestCase Name :: group items for all and ungroup lot 1.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName1 = adminDashboardPage.addMultipleLot(1);
		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);
		String lotName4 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.start_Auction();

		adminDashboardPage.group_All_Four_One_Live_Hybrid(lotName2, lotName3);
		adminDashboardPage.group_Item_And_Ungroup_Lot1_LiveSale(saleno, auctionName, lotName1, lotName2);

	}

	/**
	 * group items and sell lot - Group (x the $)
	 * 
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Group_Items_and_Sell_lot_Group_x_Money_One(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"group items and sell Feature,TestCase Name :: Group item x and sell lot 2,3.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName1 = adminDashboardPage.addMultipleLot(1);
		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);
		String lotName4 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.start_Auction();

		adminDashboardPage.group_X_The_Live_Hybrid(lotName2, lotName3);
		adminDashboardPage.group_All4One_LiveSale(saleno, auctionName, lotName1, lotName3);

	}

	/**
	 * group items and sell lot - Group (x the $)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Group_Items_and_Sell_lot_Group_x_Three(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"group items and sell Feature,TestCase Name :: Group item x and sell feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName1 = adminDashboardPage.addMultipleLot(1);
		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);
		String lotName4 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.start_Auction();

		adminDashboardPage.group_x_Live_Hybrid_Lot_2_4(lotName2, lotName3, lotName4);
		adminDashboardPage.group_All4One_LiveSale(saleno, auctionName, lotName1, lotName3);

	}

	/**
	 * group items and sell lot - Group (x the $)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Group_Items_and_Pass_lot_Group_x(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"group items and sell Feature,TestCase Name :: Group item x and pass lot.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName1 = adminDashboardPage.addMultipleLot(1);
		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);
		String lotName4 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.start_Auction();

		adminDashboardPage.group_X_The_Live_Hybrid(lotName2, lotName3);
		adminDashboardPage.group_Item_And_Pass_Lot_LiveSale(saleno, auctionName, lotName1, lotName3);

	}

	/**
	 * group items and Pass select lot 1,2,3
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Group_x_All_and_Ungroup_Lot1(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"group items and sell Feature,TestCase Name :: Group item x and ungroup.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName1 = adminDashboardPage.addMultipleLot(1);
		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.start_Auction();

		adminDashboardPage.group_X_Ungroup_Live_Hybrid(lotName2, lotName3);
		adminDashboardPage.group_Item_And_Ungroup_Lot1_LiveSale(saleno, auctionName, lotName1, lotName2);

	}

	/*
	 * pause and restart auction
	 */

	@Test(dataProvider = "createauction")
	public void Pause_and_Restart(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"validate with Enter Feature,TestCase Name: 3.145 pause and restart auction");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder
		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.start_Auction();
		adminDashboardPage.front(); // Open Front End

		// User 1 Login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.verifyLiveSaletab(saleno, auctionName); // Verify Livesale
																// Tab

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.bidding_Pause_Auction(saleno); // pause auction from
															// admin

		adminDashboardPage.front();

		// User 1 login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.verifyLiveSaleTabNotDisplay(saleno, auctionName); // Live
																		// sale
																		// tab
																		// not
																		// display

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.biddingResumeAuction(saleno); // Resume auction from
															// admin side

		adminDashboardPage.front();

		// User 1 Login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.verifyLiveSaleTab1(saleno, auctionName); // Live sale tab
																// displays

	}

	/**
	 * stop sale
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Stop_Sale(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"validate with Enter Feature,TestCase Name: 3.146 Stop sale");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder
		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.start_Auction();
		adminDashboardPage.front(); // Open Front End

		// user 1 login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.liveSaletab_Bid_Buttonenable(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.stopBiddingRunLiveAuction(auctionName, saleno, UName);

		adminDashboardPage.front();

		// user 1 login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.verify_Auction_Not_Display(auctionName);

	}

	/**
	 * start lot, post bids, and reset
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Start_Lot_Post_Bids_and_Reset(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT"
				+ "\"start lot, post bids, and reset Feature,TestCase Name: 3.147 start lot, post bids, and reset Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno1 = adminDashboardPage.create_Live_Auction("auction group 4");

		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.runlivesale_postfloor();
		// place a few floor and online bids
		adminDashboardPage.resetBiddingHistory();

	}

	/**
	 * test link
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Test_Link(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"test link Feature,TestCase Name: 3.148 test link Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno1 = adminDashboardPage.create_Live_Auction("auction group 4");

		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.runlivesale_postfloor();
		// place a few floor
		adminDashboardPage.viewLotDetailsScreen();

	}

	/**
	 * previous lot
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Previous_Lot(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"previous lot  Feature,TestCase Name: 3.149 previous lot  Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno1 = adminDashboardPage.create_Live_Auction("auction group 4");

		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.RunLiveSale_PostFloor_and_Sold_Lot();
		// place a few floor
		adminDashboardPage.previousLot();

	}

	/**
	 * Next lot
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Next_Lot(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"Next lot  Feature,TestCase Name: 3.150 Next lot Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno1 = adminDashboardPage.create_Live_Auction("auction group 4");

		adminDashboardPage.addLotRandom(2);

		adminDashboardPage.runlivesale_postfloor1();
		// place a few floor
		adminDashboardPage.nextLot();

	}

	/**
	 * content
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Content(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"content Feature,TestCase Name: 3.151 content Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno1 = adminDashboardPage.create_Live_Auction("auction group 4");

		adminDashboardPage.addLot(2);
		adminDashboardPage.start_Auction();
		adminDashboardPage.skipToLot();

	}

	/**
	 * action
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Action(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT" + "\"action Feature,TestCase Name: 3.152 action Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno1 = adminDashboardPage.create_Live_Auction("auction group 4");

		adminDashboardPage.addLotRandom(2);

		adminDashboardPage.runlivesale_postfloor_skiplot();
		// place a few floor and online bids
		adminDashboardPage.skipToLot1();

	}

	/**
	 * regular
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Regular(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"regular Feature,TestCase Name: 3.153 regular Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno1 = adminDashboardPage.create_Live_Auction("auction group 4");

		adminDashboardPage.addLot(2);

		adminDashboardPage.start_Auction();
		// place a few floor and online bids
		adminDashboardPage.projector();

		adminDashboardPage.projectorPopupLink(); // Verify lot details in popup

	}

	/**
	 * simplified
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Simplified(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"simplified Feature,TestCase Name: 3.154 simplified Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno1 = adminDashboardPage.create_Live_Auction("auction group 4");

		adminDashboardPage.addLot(2);
		adminDashboardPage.start_Auction();
		adminDashboardPage.postFloor();
		adminDashboardPage.projector();
		adminDashboardPage.showInPopUpLink();
	}

	/**
	 * simplified in popup
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Simplified_In_Popup(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT"
				+ "\"simplified in popup Feature,TestCase Name: 3.155 simplified in popup Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno1 = adminDashboardPage.create_Live_Auction("auction group 4");

		adminDashboardPage.addLot(2);
		adminDashboardPage.start_Auction();
		adminDashboardPage.projector();
		adminDashboardPage.projectorpopuplinksimplified(); // Verify lot details
															// in popup
	}

	/**
	 * as a bidder, place an absentee bid on lot X from the catalog page with
	 * confirmation
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Place_an_Absentee_Bid_On_Lot_X_From_The_Catalog_Page_With_Confirmation(String adminUserName,
			String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Test case Name : 3.156 as a bidder, place an absentee bid on lot X from the catalog page with confirmation");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder
		String lotName = adminDashboardPage.addLotRandom(1);
		String lotName1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Absenteebid(auctionName, lotName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.postFloorAutoIncrement(auctionName, saleno);
	}

	/**
	 * as a bidder, place an absentee bid on lot Y from the item details page with
	 * confirmation
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void As_a_Bidder_Place_an_Absentee_Bid_On_Lot_Y_From_The_Item_Details_Page_With_Confirmation(
			String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"as a bidder, place an absentee bid on lot Y from the item details page with "
				+ "confirmation Feature,TestCase Name: 3.157 as a bidder, place an absentee"
				+ " bid on lot Y from the item details page with confirmation Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder
		String lotName = adminDashboardPage.addLotRandom(1);
		String lotName1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.placeBidFromLotDetails(auctionName, lotName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.postFloorAutoIncrement(auctionName, saleno);
	}

	// as a bidder, place an absentee bid on lot Z from the watchlist page
	// 3.158 done in bidding live sale

	/**
	 * as a bidder place absentee bids on lots V and W from the catalog page with
	 * confirmation
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Place_Absentee_Bids_on_Lot_V_and_W_From_The_Catalog_Page(String adminUserName, String adminPassword,
			String UName, String password) throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();

		log("Feature" + "-" + "UAT" + "\"as a bidder, place an absentee bid on lot Y from the item details page with "
				+ "confirmation Feature,TestCase Name: 3.159 as a bidder place absentee bids on lots V and W from the catalog page with confirmation");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.multiBid_Functionality_Enable(); // enable
															// place
															// multiple
		// bid
		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder
		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandomForUser(1);
		String lotname2 = adminDashboardPage.addlotrandom2(1);
		String lotname3 = adminDashboardPage.addLotRandom3(1);
		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.placeabsenteebidon4lot(saleno, auctionName, lotname, lotname1, lotname2, lotname3); // Place
																											// multibid

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.passandstartlotwithverifynotefield(saleno);
	}

	/**
	 * as 2 different bidders, place absentee bids on the same lot
	 * 
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Place_Absentee_Bids_on_The_Same_Lot(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"as a bidder, place an absentee bid on lot Y from the item details page with "
				+ "confirmation Feature,TestCase Name: 3.160 as a 2 bidder place absentee bids on the same lot");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1_2(); // approve bidder
		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandomForUser(1);
		adminDashboardPage.front(); // Open Front End

		// User 1 Login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Absenteebid(auctionName, lotname);

		// User 2 Login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);
		dashboardPage.placeAbsenteeBid2High(saleno, auctionName, lotname, lotname1); // Higher
																						// than
																						// 1st
																						// bidder

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.twoUserAbsenteeBidAccept(auctionName, saleno);
	}

	/**
	 * 3.161,3.162,3.163 >> Completed in bidding livesale
	 * 
	 */

	/**
	 * place several absentee bids but with a limit - go over the limit
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Place_Serveral_Absentee_Bids_With_Limit(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"place several absentee bids but with a limit - go over the limit >> 3.164 ");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.multiBid_Functionality_Enable();
		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		adminDashboardPage.approveBidder1(); // approve bidder

		String lotname = adminDashboardPage.addlotrandomwithincrementvalue(1);
		String lotname1 = adminDashboardPage.addlotrandomwithincrementvalue1(1);
		String lotname2 = adminDashboardPage.addlotrandomwithincrementvalue2(1);

		// User 1 Login
		adminDashboardPage.front();
		common.pause(20);

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.legacy_login_for_stop_abs_at(auctionName);
		dashboardPage.stopAbsenteeBid(saleno, auctionName, lotname, lotname1, lotname2); // Place
		// multibid

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.absenteeBidWithLimitAndSellLot(saleno);
	}

	/**
	 * place several absentee bids as an OR group
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Place_Several_Absentee_Bids_as_an_Or_Group(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"place several absentee bids as an group >> 3.165 ");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder
		String lotname = adminDashboardPage.addlotrandomwithincrementvalue(1);

		String lotname1 = adminDashboardPage.addlotrandomwithincrementvalue1(1);
		String lotname2 = adminDashboardPage.addlotrandomwithincrementvalue2(1);
		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.placeabsenteebidongroup(saleno, auctionName, lotname, lotname1, lotname2); // Place
																									// multibid

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.absenteeBidWithLimitAndSellLot(saleno); // pending
																	// admin
																	// side
	}

	/**
	 * Verify check on starting bid, estimates advance
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Check_On_Starting_Bid_Estimates_Advance(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"Verify change page link Feature,TestCase Name: 3.166 Verify check on starting bid, estimates advance Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_Advance(saleno);
		adminDashboardPage.approveBidder1(); // approve bidder
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.start_Auction();
		adminDashboardPage.startingbidestimatesadvance();

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.goto_Catalog_Page_Live_Sale(auctionName);
		dashboardPage.verify_Estimate_Values_Front(auctionName, saleno); // Verify
		// Estimate
		// Values in
		// Livesale
		// tab
	}

	/**
	 * Active
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Active7(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"active Feature,TestCase Name: 3.167 Active Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String saleno1 = adminDashboardPage.AllFieldsFilladvance("auction group 4");
		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.start_Auction();
		adminDashboardPage.lot_Autostart_Enable();
		adminDashboardPage.pass_Lot();

	}

	/**
	 * Disabled
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Disabled6(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"Disabled Feature,TestCase Name: 3.168 Disabled Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String saleno1 = adminDashboardPage.AllFieldsFilladvance("auction group 4");
		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.start_Auction();
		adminDashboardPage.lot_Autostart_Disable();
		adminDashboardPage.pass_Lot();
		// adminDashboardPage.startlot();

	}

	/**
	 * validate with Enter advance
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Validate_With_Enter_Advance(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"validate with Enter Feature,TestCase Name: 3.169 validate with Enter Feature >> Advance.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_Advance(saleno);
		adminDashboardPage.approveBidder1(); // approve bidder
		String lotname1 = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.verifyAskingbid(); // verify asking bid

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.goto_Catalog_Page_Live_Sale(auctionName);
		dashboardPage.verify_Starting_Bid_Catalogpage(auctionName, saleno); // Verify
																			// Starting
		// bid

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.changeAskingBidWithEnter(auctionName, saleno, UName); // Asking
																					// bid
																					// updated
																					// after
																					// click
																					// on
																					// enter

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.goto_Catalog_Page_Live_Sale_Auction(auctionName);
		dashboardPage.verify_Starting_Bid_Catalogpage(auctionName, saleno); // Verify
																			// new
		// Starting
		// bid

	}

	/**
	 * Validate with button advance 3.170
	 * 
	 * Change button does not display for change asking bid in advance mode.
	 * 
	 */

	/**
	 * use increments column
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Use_Increments_Column_Advance(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"use increments column Feature,TestCase Name: 3.171 use increments column Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_Advance(saleno); // Clearking
		// Style
		// Advance
		adminDashboardPage.approveBidder1(); // approve bidder
		String lotname1 = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.start_Auction(); // Start Auction

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.goto_Catalog_Page_Live_Sale(auctionName);
		dashboardPage.verify_Starting_Bid_Catalogpage(auctionName, saleno); // Verify
																			// Starting
		// bid in bid
		// button
		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.selectincrementvalueadvance(saleno);
		adminDashboardPage.front();

		// User 1 Login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.goto_Catalog_Page_Live_Sale_Auction(auctionName);
		dashboardPage.verify_Starting_Bid_Catalogpage(auctionName, saleno); // Verify
																			// new
		// Starting
		// bid

		driver.get(configFileReader.getAdminUrl()); // User Logout

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.selectincrementvalueadvance1(saleno); // Select
																	// increment
																	// value
		adminDashboardPage.front();

		// User 1 Login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.goto_Catalog_Page_Live_Sale_Auction(auctionName);
		dashboardPage.verify_Starting_Bid_Catalogpage(auctionName, saleno); // Verify
																			// new
		// Starting
		// bid

	}

	/**
	 * change default increment
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Change_Default_Increment_Advance(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"change default increment Feature,TestCase Name: 3.172 change default increment Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_Advance(saleno); // Clearking
		// Style
		// Advance
		adminDashboardPage.approveBidder1(); // approve bidder
		String lotname1 = adminDashboardPage.addLotRandom(3);

		adminDashboardPage.start_Auction(); // Start Auction

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.goto_Catalog_Page_Live_Sale(auctionName);
		dashboardPage.verify_Starting_Bid_Catalogpage(auctionName, saleno); // Verify
																			// Starting
		// bid in bid
		// button

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.selectincrementvaluefromdropdownmenu(saleno);

	}

	/**
	 * Decrements 3.173
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Decrements_Advance(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"Decrements Feature,TestCase Name: 3.173 Decrements Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_Advance(saleno); // Clearking
		// Style
		// Advance
		String lotname1 = adminDashboardPage.addLotRandom(2);
		adminDashboardPage.start_Auction(); // Start Auction

		adminDashboardPage.selectdecrements(saleno);

	}

	/**
	 * add new increment
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Add_New_Increment_Advance(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();

		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\"add new increment Feature,TestCase Name: 3.174 add new increment Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno1 = adminDashboardPage.create_Live_Auction_Advance(saleno);

		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.start_Auction();
		adminDashboardPage.addincremnetvalue();

	}

	/**
	 * from increments column
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void From_Increments_Column_Advance(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();

		String saleno = common.generateRandomNumber1();
		log("Feature" + "-" + "UAT"
				+ "\"from increments column Feature,TestCase Name: 3.175 from increments column Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno1 = adminDashboardPage.create_Live_Auction_Advance(saleno);

		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.start_Auction();
		adminDashboardPage.fromincremnetlist();

	}

	/**
	 * from post bid column
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	@Test(dataProvider = "createauction")
	public void From_Post_bid_Column_Advance(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();

		String saleno = common.generateRandomNumber1();
		log("Feature" + "-" + "UAT"
				+ "\"from post bid column Feature,TestCase Name: 3.176 from post bid column Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno1 = adminDashboardPage.create_Live_Auction_Advance(saleno);

		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.start_Auction();
		adminDashboardPage.frombidlist();

	}

	/**
	 * accept and sell
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Accept_and_Sell_Advance(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();

		String saleno = common.generateRandomNumber1();
		log("Feature" + "-" + "UAT" + "\"accept and sell Feature,TestCase Name: 3.177 accept and sell Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno1 = adminDashboardPage.create_Live_Auction_Advance(saleno);

		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.runlive_postfloorandsold();
	}

	/**
	 * accept and undo
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Accept_and_Undo_Advance(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\"accept and undo Feature,TestCase Name: 3.178 accept and undo Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno1 = adminDashboardPage.create_Live_Auction_Advance(saleno);

		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.runlive_postfloorandundo();
	}

	/**
	 * accept and pass
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Accept_and_Pass_Advance1(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"accept and pass Feature,TestCase Name: 3.179 accept and pass Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno1 = adminDashboardPage.create_Live_Auction_Advance(saleno);

		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.runlive_postfloorandpass();

	}

	/**
	 * accept and fair warning and accept and sell
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Accept_and_Fair_Warning_and_Accept_and_Sell_Advance1(String adminUserName, String adminPassword,
			String UName, String password) throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();

		String saleno = common.generateRandomNumber1();
		log("Feature" + "-" + "UAT"
				+ "\"accept and fair warning and accept and sell Feature,TestCase Name: 3.180 accept and fair warning and accept and sell Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno1 = adminDashboardPage.create_Live_Auction_Advance(saleno);

		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.runlive_postfloorand_fair_sold();
	}

	/**
	 * accept and sell advance
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Accept_and_Sell_Advance1(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"accept and sell Feature,TestCase Name: 3.181 accept and sell Feature advance.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_Advance(saleno); // Clearking
		// Style
		// Advance
		adminDashboardPage.approveBidder1(); // approve bidder
		String lotname1 = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.start_Auction(); // Start Auction

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName); // Click
		// on
		// green
		// bid
		// button

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno); // Accept
																			// and
																			// sell
																			// lot

	}

	/**
	 * accept and undo advance
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Accept_and_Undo_Advance1(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"accept and undo Feature,TestCase Name: 3.182 accept and undo Feature advance.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_Advance(saleno); // Clearking
		// Style
		// Advance
		adminDashboardPage.approveBidder1(); // approve bidder
		String lotname1 = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.start_Auction(); // Start Auction

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName); // Click
		// on
		// green
		// bid
		// button

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Undo_Feature(auctionName, saleno); // Accept
																			// and
																			// undo

	}

	/**
	 * accept and pass advance
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Accept_and_Pass_Advance(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"accept and pass Feature,TestCase Name: 3.183 accept and pass Feature advance.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_Advance(saleno); // Clearking
		// Style
		// Advance
		adminDashboardPage.approveBidder1(); // approve bidder
		String lotname1 = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.start_Auction(); // Start Auction

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName); // Click
		// on
		// green
		// bid
		// button

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_And_Pass_Feature(auctionName, saleno); // Accept
																			// and
																			// pass
																			// feature

	}

	/**
	 * accept and fair warning and accept and sell
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Accept_and_Fair_Warning_and_Accept_and_Sell_Advance(String adminUserName, String adminPassword,
			String UName, String password) throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT"
				+ "\"accept and fair warning and accept and sell Feature,TestCase Name: 3.184 accept and fair warning and accept and sell Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_Advance(saleno); // Clearking
		// Style
		// Advance
		adminDashboardPage.approveBidder1(); // approve bidder
		String lotname1 = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.start_Auction(); // Start Auction

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.accept_Live_Bid(auctionName, saleno);

		adminDashboardPage.verify_Asking_Bid();
		adminDashboardPage.lot_Autostart_Disable();
		adminDashboardPage.fairWarning(); // Click on fair warning button
		adminDashboardPage.sell_Lot();
		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.verifyWarningMessage(saleno, auctionName); // verify
																	// warning

		// message

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.sold_Live_Lot(auctionName, saleno);

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.verifySoldLotMessage(saleno, auctionName); // verify sold
																	// lot
																	// message
	}

	/**
	 * Verify active
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Active_Advance1(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT" + "\"Verify active Feature,TestCase Name: 3.185 Verify active Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.setting_Auto_Create_Record_Active();
		String saleno1 = adminDashboardPage.create_Live_Auction_Advance(saleno);

		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.runlive_postfloor_sold();
		adminDashboardPage.Verify_user1();
	}

	/**
	 * Verify active
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Active_Advance(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT" + "\"Verify active Feature,TestCase Name: 3.186 Verify active Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.setting_Auto_Create_Record();

		String saleno1 = adminDashboardPage.create_Live_Auction_Advance(saleno);

		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.runlive_postfloor_sold();
		adminDashboardPage.Verify_user1();
	}

	/**
	 * Verify disabled
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Disabled_Advance(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT" + "\"Verify disabled Feature,TestCase Name: 3.187 Verify disabled Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.auto_Create_Records_For_Non_Existing_Floor_Disable();

		String saleno1 = adminDashboardPage.create_Live_Auction_Advance(saleno);

		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.runlive_postfloor_sold();
		adminDashboardPage.Verify_user1();

	}

	/**
	 * Save and use new message (3.193)
	 * 
	 */

	@Test(dataProvider = "twologinUsers")
	public void Save_and_Use_New_Message(String adminUserName, String adminPassword, String UName, String password,
			String UName1, String password1) throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT"
				+ "\"group items and sell Feature,TestCase Name :: group items for all and ungroup lot 1.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		adminDashboardPage.approveBidder1_2(); // approve two bidder
		System.out.println("Step :: auction Name s :" + auctionName);
		common.log("<br></br> Step :: auction Name s :" + auctionName);
		String lotName = adminDashboardPage.addlotrandom2(2);

		adminDashboardPage.start_Auction();

		adminDashboardPage.Save_and_Use_New_Message(); // Message save for
														// message
		// center

		adminDashboardPage.front(); // Open Front End

		// user 1 login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.verify_Chat_Message_Live_Sale(auctionName); // Admin
																	// chat
																	// message
																	// displays.

		// // User 2 login
		//
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);
		dashboardPage.verify_Chat_Message_Live_Sale1(auctionName); // Admin
																	// chat
																	// message
																	// displays.

	}

	/**
	 * Group items and sell
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Group_Items_and_Sell_Advance(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT"
				+ "\"group items and sell Feature,TestCase Name: 3.131 group items and sell Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_Advance(saleno); // Clearking
		// Style
		// Advance
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName1 = adminDashboardPage.addMultipleLot(1);
		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);
		String lotName4 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.start_Auction();

		adminDashboardPage.groupchoice_Livesale(lotName2, lotName3);
		adminDashboardPage.group_Item_And_Sell_Livesale(auctionName, saleno);

	}

	/**
	 * group items and sell lot 1
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Group_Items_and_Sell1_Advance(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT"
				+ "\"group items and sell Feature,TestCase Name: 3.132 group items and sell Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_Advance(saleno); // Clearking
		// Style
		// Advance
		adminDashboardPage.approveBidder1(); // approve bidder
		String lotName1 = adminDashboardPage.addMultipleLot(1);
		adminDashboardPage.start_Auction();

		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);
		String lotName4 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.runLiveSaleTab();

		adminDashboardPage.groupChoice_Livesale1(lotName2, lotName3);
		adminDashboardPage.group_Item_And_Sell_Lot1_Livesale(auctionName,saleno,lotName1);

	}

	/**
	 * group items and sell
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Group_Items_and_Sell_Lot1_2_Advance(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT"
				+ "\"group items and sell Feature,TestCase Name: 3.133 group items and sell Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_Advance(saleno); // Clearking
		// Style
		// Advance
		adminDashboardPage.approveBidder1(); // approve bidder
		String lotName1 = adminDashboardPage.addMultipleLot(1);
		adminDashboardPage.start_Auction();

		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);
		String lotName4 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.runLiveSaleTab();

		adminDashboardPage.groupchoice_Livesale2(lotName2, lotName3);
		adminDashboardPage.group_Item_And_Sell_Lot_Livesale_1_2(auctionName, saleno, lotName1, lotName2);

	}

	/**
	 * group items and sell
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Group_Items_and_Sell3_Advance(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT"
				+ "\"group items and sell Feature,TestCase Name: 3.134 group items and sell Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_Advance(saleno); // Clearking
		// Style
		// Advance
		adminDashboardPage.approveBidder1(); // approve bidder
		String lotName1 = adminDashboardPage.addMultipleLot(1);
		adminDashboardPage.start_Auction();

		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);
		String lotName4 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.runLiveSaleTab();

		adminDashboardPage.groupchoice_Livesale(lotName2, lotName3);
		adminDashboardPage.group_Item_And_Sell_Lot_Livesale_1_3(auctionName,saleno,lotName1, lotName3);

	}

	/**
	 * group items and pass
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Group_Items_and_Pass_Advance(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT"
				+ "\"group items and pass Feature,TestCase Name: 3.135 group items and pass Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_Advance(saleno); // Clearking
		// Style
		// Advance
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName1 = adminDashboardPage.addMultipleLot(1);
		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);
		String lotName4 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.start_Auction();

		adminDashboardPage.groupchoice_Livesale(lotName2, lotName3);
		adminDashboardPage.group_Item_And_Pass_Lot_Livesale(auctionName,saleno, lotName1, lotName2);

	}

	/**
	 * group items and ungroup
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Group_Items_and_Ungroup_Advance(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT"
				+ "\"group items and ungroup Feature,TestCase Name: 3.136 group items and ungroup Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_Advance(saleno); // Clearking
		// Style
		// Advance
		adminDashboardPage.approveBidder1(); // approve bidder
		String lotName1 = adminDashboardPage.addMultipleLot(1);
		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);
		String lotName4 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.start_Auction();

		adminDashboardPage.groupchoice_Livesale(lotName2, lotName3);
		adminDashboardPage.group_Item_And_Ungroup_Lot1_Livesale(auctionName, saleno,lotName1, lotName2);

	}

	/**
	 * group items and sell lot - Group (All4One)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Group_Items_and_Sell_lot_Group_All_4_One_Advance(String adminUserName, String adminPassword,
			String UName, String password) throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"group items and sell Feature,TestCase Name :: group items and sell Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		
		
		String auctionName = adminDashboardPage.create_Live_Auction_Advance(saleno); // Clearking
		// Style
		// Advance
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName1 = adminDashboardPage.addMultipleLot(1);
		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);
		String lotName4 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.start_Auction();

		adminDashboardPage.group_All_Four_One_Live_Hybrid(lotName2, lotName3);
		adminDashboardPage.group_All4One_LiveSale(auctionName,saleno,lotName1, lotName3);

	}

	/**
	 * group items and sell lot - Group (All4One)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Group_Items_and_Sell_lot_Group_All_4_Three_Advance(String adminUserName, String adminPassword,
			String UName, String password) throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"group items and sell Feature,TestCase Name :: group items and sell Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_Advance(saleno); // Clearking
		// Style
		// Advance
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName1 = adminDashboardPage.addMultipleLot(1);
		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);
		String lotName4 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.start_Auction();

		adminDashboardPage.group_All_Four_One_Live_Hybrid_Lot_2_4(lotName2, lotName3, lotName4);
		adminDashboardPage.group_All4One_LiveSale(auctionName,saleno, lotName1, lotName3);

	}

	/**
	 * group items and sell lot - Group (All4One)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Group_Items_and_Pass_lot_Group_All_4_one_Advance(String adminUserName, String adminPassword,
			String UName, String password) throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"group items and sell Feature,TestCase Name :: group items and sell Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_Advance(saleno); // Clearking
		// Style
		// Advance
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName1 = adminDashboardPage.addMultipleLot(1);
		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);
		String lotName4 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.start_Auction();

		adminDashboardPage.group_All_Four_One_Live_Hybrid(lotName2, lotName3);
		adminDashboardPage.group_Item_And_Pass_Lot_LiveSale(auctionName,saleno,lotName1, lotName2);

	}

	/**
	 * group items and Pass select lot 1,2,3
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Group_Items_4_All_and_Ungroup_Lot1_Advance(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT"
				+ "\"group items and sell Feature,TestCase Name :: group items for all and ungroup lot 1.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_Advance(saleno); // Clearking
		// Style
		// Advance
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName1 = adminDashboardPage.addMultipleLot(1);
		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);
		String lotName4 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.start_Auction();

		adminDashboardPage.group_All_Four_One_Live_Hybrid(lotName2, lotName3);
		adminDashboardPage.group_Item_And_Ungroup_Lot1_LiveSale( auctionName,saleno, lotName1, lotName2);

	}

	/**
	 * group items and sell lot - Group (x the $)
	 * 
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Group_Items_and_Sell_lot_Group_x_Money_One_Advance(String adminUserName, String adminPassword,
			String UName, String password) throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"group items and sell Feature,TestCase Name :: Group item x and sell lot 2,3.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_Advance(saleno); // Clearking
		// Style
		// Advance
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName1 = adminDashboardPage.addMultipleLot(1);
		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);
		String lotName4 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.start_Auction();

		adminDashboardPage.group_X_The_Live_Hybrid(lotName2, lotName3);
		adminDashboardPage.group_All4One_LiveSale(auctionName, saleno,lotName1, lotName3);

	}

	/**
	 * group items and sell lot - Group (x the $)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Group_Items_and_Sell_lot_Group_x_Three_Advance(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"group items and sell Feature,TestCase Name :: Group item x and sell feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_Advance(saleno); // Clearking
		// Style
		// Advance
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName1 = adminDashboardPage.addMultipleLot(1);
		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);
		String lotName4 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.start_Auction();

		adminDashboardPage.group_x_Live_Hybrid_Lot_2_4(lotName2, lotName3, lotName4);
		adminDashboardPage.group_All4One_LiveSale(auctionName,saleno, lotName1, lotName3);

	}

	/**
	 * group items and sell lot - Group (x the $)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Group_Items_and_Pass_lot_Group_x_Advance(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"group items and sell Feature,TestCase Name :: Group item x and pass lot.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_Advance(saleno); // Clearking
		// Style
		// Advance
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName1 = adminDashboardPage.addMultipleLot(1);
		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);
		String lotName4 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.start_Auction();

		adminDashboardPage.group_X_The_Live_Hybrid(lotName2, lotName3);
		adminDashboardPage.group_Item_And_Pass_Lot_LiveSale(auctionName,saleno,lotName1, lotName3);

	}

	/**
	 * group items and Pass select lot 1,2,3
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Group_x_All_and_Ungroup_Lot1_Advance(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"group items and sell Feature,TestCase Name :: Group item x and ungroup.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_Advance(saleno); // Clearking
		// Style
		// Advance
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName1 = adminDashboardPage.addMultipleLot(1);
		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.start_Auction();

		adminDashboardPage.group_X_Ungroup_Live_Hybrid(lotName2, lotName3);
		adminDashboardPage.group_Item_And_Ungroup_Lot1_LiveSale(auctionName,saleno,lotName1, lotName2);

	}

	/**
	 * Pause and restart auction advance
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
	public void Pause_and_Restart_Advance(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"validate with Enter Feature,TestCase Name: 3.208 pause and restart auction advance");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_Advance(saleno); // Clearking
		// Style
		// Advance
		adminDashboardPage.approveBidder1(); // approve bidder
		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.start_Auction();
		adminDashboardPage.front(); // Open Front End

		// User 1 Login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.verifyLiveSaletab(saleno, auctionName); // Verify Livesale
																// Tab

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.bidding_Pause_Auction(saleno); // pause auction from
															// admin

		adminDashboardPage.front();

		// User 1 login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.verifyLiveSaleTabNotDisplay(saleno, auctionName); // Live
																		// sale
																		// tab
																		// not
																		// display

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.biddingResumeAuction(saleno); // Resume auction from
															// admin side

		adminDashboardPage.front();

		// User 1 Login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.verifyLiveSaleTab1(saleno, auctionName); // Live sale tab
																// displays

	}

	/**
	 * stop sale
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Stop_Sale_Advance(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"validate with Enter Feature,TestCase Name: 3.209 Stop sale");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_Advance(saleno); // Clearking
		// Style
		// Advance
		
		adminDashboardPage.approveBidder1(); // approve bidder
		
		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.start_Auction();
		adminDashboardPage.front(); // Open Front End

		// user 1 login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.liveSaletab_Bid_Buttonenable(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.stopBiddingRunLiveAuction(auctionName, saleno, UName);

		adminDashboardPage.front();

		// user 1 login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.verify_Auction_Not_Display(auctionName);

	}

	/**
	 * start lot, post bids, and reset ( clerking style is set to advanced)
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Start_Lot_Post_Bids_and_Reset_Advance(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT"
				+ "\"start lot, post bids, and reset Feature,TestCase Name: 3.210 start lot, post bids, and reset Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno1 = adminDashboardPage.allFieldsFill1Advance("auction group 4");

		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.runlivesale_Postflooradvance();
		adminDashboardPage.resetBiddingHistory();

	}

	/**
	 * test link
	 * 
	 * @throws InterruptedException (clerking style is set to advanced)
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Test_Link_Advance(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"test link Feature,TestCase Name: 3.211 test link Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno1 = adminDashboardPage.allFieldsFill1Advance("auction group 4");

		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.runlivesale_Postflooradvance();
		adminDashboardPage.viewLotDetailsScreen();
	}

	/**
	 * previous lot clearking style set to advance
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Previous_Lot_Advance(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"previous lot  Feature,TestCase Name: 3.212 previous lot  Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno1 = adminDashboardPage.allFieldsFill1Advance("auction group 4");

		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.runlivesale_Advance();

		adminDashboardPage.previousLot();

	}

	/**
	 * Next lot to advance
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
	public void Next_Lot_Advance(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"Next lot  Feature,TestCase Name: 3.213 Next lot  Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno1 = adminDashboardPage.allFieldsFill1Advance("auction group 4");

		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.runlivesale_Postflooradvance();
		adminDashboardPage.nextLot();

	}

	/**
	 * Skip lot advance
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
	public void Skip_Lot_Advance(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"Next lot  Feature,TestCase Name: 3.214 Skip lot  Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno1 = adminDashboardPage.allFieldsFill1Advance("auction group 4");

		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.runlivesale_Postflooradvance();
		adminDashboardPage.skipLot();

	}

	/**
	 * Skip lot advance1
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
	public void Skiplot_Advance1(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"Next lot  Feature,TestCase Name: 3.215 Skip lot drop down  Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno1 = adminDashboardPage.allFieldsFill1Advance(saleno);

		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.runlivesale_Postflooradvance();
		adminDashboardPage.skipToLot1();
	}

	/**
	 * Regular Advance
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
	public void Regular_Advance(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"Next lot  Feature,TestCase Name: 3.216 Regular Auction projector  Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();
		String salename = common.generateRandomChars(4);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno1 = adminDashboardPage.allFieldsFill1Advance(salename);

		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.runlivesale_Postflooradvance();
		adminDashboardPage.projector();
		adminDashboardPage.showInPopUpLink();

	}

	/**
	 * Showup Advance
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
	public void Showpopup_Advance(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"Next lot  Feature,TestCase Name: 3.217 Regular Auction projector  Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno1 = adminDashboardPage.allFieldsFill1Advance(saleno);

		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.runlivesale_Postflooradvance();
		adminDashboardPage.projector();
		adminDashboardPage.showInPopUpLink();

	}

	/**
	 * Simplified Advance
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
	public void Simplified_Advance(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT"
				+ "\"Next lot  Feature,TestCase Name: 3.218 Simplified Auction projector  Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno1 = adminDashboardPage.allFieldsFill1Advance(saleno);

		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.runlivesale_Postflooradvance();
		adminDashboardPage.projector();
		adminDashboardPage.showInPopupSimplifiedLink();

	}

	/**
	 * as a bidder, place an absentee bid on lot X from the catalog page with
	 * confirmation advance
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Place_an_Absentee_Bid_On_Lot_x_From_The_Catalog_Page_With_Confirmation_Advance(String adminUserName,
			String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Test case Name : 3.219 as a bidder, place an absentee bid on lot X from the catalog page with confirmation");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_Advance(saleno); // Clearking
		// Style
		// Advance
		adminDashboardPage.approveBidder1(); // approve bidder
		String lotName = adminDashboardPage.addLotRandom(1);
		String lotName1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Absenteebid(auctionName, lotName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.postFloorAutoIncrementAdvance(auctionName, saleno);
	}

	/**
	 * as a bidder, place an absentee bid on lot X from the catalog page with
	 * confirmation advance
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void As_Bidder_Place_an_Absentee_Bid_On_Lot_y_From_The_Item_Details_Page_With_Confirmation_Advance(
			String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Test case Name : 3.220 as a bidder, place an absentee bid on lot Y from the item details page without confirmation");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_Advance(saleno); // Clearking
		// Style
		// Advance
		adminDashboardPage.approveBidder1(); // approve bidder
		String lotName = adminDashboardPage.addLotRandom(1);
		String lotName1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.front(); // Open Front End

		// User 1 Login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.placeBidFromLotDetails(auctionName, lotName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.postFloorAutoIncrement(auctionName, saleno);
	}

	// 3.221 completed in bidding live sale

	/**
	 * as a bidder place absentee bids on lots V and W from the catalog page with
	 * confirmation advance
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Place_Absentee_Bids_On_Lot_v_and_w_From_The_Catalog_Page_Advance(String adminUserName,
			String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"as a bidder, place an absentee bid on lot Y from the item details page with "
				+ "confirmation Feature,TestCase Name: 3.222 as a bidder place absentee bids on lots V and W from the catalog page with confirmation");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.multiBid_Functionality_Enable(); // enable
															// place
															// multiple
		// bid
		String auctionName = adminDashboardPage.create_Live_Auction_Advance(saleno); // Clearking
		// Style
		// Advance
		adminDashboardPage.approveBidder1(); // approve bidder
		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandomForUser(1);
		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.placeAbsenteeBidOn2Lot(saleno, auctionName, lotname1, lotname); // Place
																						// multibid

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.passAndStartLotWithVerifyNoteFieldAdvance(saleno);
	}

	/**
	 * as 2 different bidders, place absentee bids on the same lot
	 * 
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Place_Absentee_Bids_On_The_Same_Lot_Advance(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"as a bidder, place an absentee bid on lot Y from the item details page with "
				+ "confirmation Feature,TestCase Name: 3.223 as a 2 bidder place absentee bids on the same lot");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_Advance(saleno); // Clearking
		// Style
		// Advance
		adminDashboardPage.approveBidder1_2(); // approve both bidder
		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandomForUser(1);
		adminDashboardPage.front(); // Open Front End

		// User 1 Login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Absenteebid(auctionName, lotname);

		// User 2 Login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);
		dashboardPage.placeAbsenteeBid2High(saleno, auctionName, lotname, lotname1); // Higher
																						// than
																						// 1st
																						// bidder

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.twoUserAbsenteeBidAccept(auctionName, saleno);
	}

	/**
	 * absentee against online (3.224)
	 * 
	 */

	@Test(dataProvider = "twologinUsers")
	public void Absentee_Against_Online_Advanced(String adminUserName, String adminPassword, String UName,
			String password, String Uname1, String password1)
			throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		String lotName1 = null;
		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_Advance(saleno); // Clearking
		// Style
		// Advance

		adminDashboardPage.approveBidder1_2(); // approve both bidder

		System.out.println("Step :: auction Name s :" + auctionName);
		common.log("<br></br> Step :: auction Name s :" + auctionName);
		String lotName = adminDashboardPage.biddingRunLiveAuctionNotStart(); // Bidding

		adminDashboardPage.front(); // Open Front End

		// user 1 login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Absenteebid(auctionName, lotName); // Place
		// an
		// absentee
		// bid.

		// Admin login

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.accept_Bid_Start_Auction(auctionName, saleno); // Admin
																			// accept
																			// it

		adminDashboardPage.verifyAbsenteeBidValueInNoteField(); // lot name
																	// verify in
		// notefield

		adminDashboardPage.front();

		// User 2 login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName); // place
																		// bid

		// admin login
		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.accept_Live_Bid(auctionName, saleno); // Admin accept
																	// livebid

		adminDashboardPage.acceptBidder1Bid();

		adminDashboardPage.front();

		// User 2 login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);
		dashboardPage.place_Bid_Live_Auction_End(saleno, auctionName, lotName);

	}

	/**
	 * Undo after placing absentee 3.225
	 */

	@Test(dataProvider = "createauction")
	public void Undo_After_Placing_Bid_Advanced(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.confirmMultipleTimedAndLiveAbsenteebids();

		String auctionName = adminDashboardPage.create_Live_Auction_Advance(saleno); // Clearking
		// Style
		// Advance
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName = adminDashboardPage.biddingRunLiveAuction(); // Bidding
		String lotname1 = null;
		adminDashboardPage.front(); // Open Front End

		// user 1 login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Absenteebid(auctionName, lotName);

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.undo_After_Placing_Absentee_Bid(saleno); // Click on
																	// undo
		// last
		// action button.

	}

	/**
	 * Undo after placing with auto accept (3.226)
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Undo_After_Placing_With_Auto_Accept_Advanced(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_Advance(saleno); // Clearking
		// Style
		// Advance
		adminDashboardPage.approveBidder1(); // approve bidder

		System.out.println("Step :: auction Name s :" + auctionName);
		common.log("<br></br> Step :: auction Name s :" + auctionName);
		adminDashboardPage.addLotRandom(3);

		adminDashboardPage.online_Bid_Auto_Accept(); // Bidding

		// adminDashboardPage.Start_Auction(); // run live sale
		adminDashboardPage.front();

		// user 1 login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.livesaletab_Bid_Buttonaccepted(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.undoBiddingRunLiveAuction_Auto_Accept(auctionName, saleno, UName);

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.livesaletab_Bid_Button_After_Undo(saleno, auctionName);

	}

	/**
	 * place several absentee bids but with a limit - go over the limit
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Place_Serverl_Absentee_Bids_With_Limit_Advanced(String adminUserName, String adminPassword,
			String UName, String password) throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"place several absentee bids but with a limit - go over the limit >> 3.227 ");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_Advance(saleno); // Clearking
		// Style
		// Advance
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotname = adminDashboardPage.addlotrandomwithincrementvalue(1);
		String lotname1 = adminDashboardPage.addlotrandomwithincrementvalue1(1);
		String lotname2 = adminDashboardPage.addlotrandomwithincrementvalue2(1);
		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.stopAbsenteeBid(saleno, auctionName, lotname, lotname1, lotname2); // Place
																							// multibid

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.absenteeBidWithLimitAndSellLot(saleno);
	}

	/**
	 * 
	 * User Chat Disable
	 * 
	 **/
	@Test(dataProvider = "twologinUsers")
	public void User_Chat_Disable(String adminUserName, String adminPassword, String UName, String password,
			String UName1, String password1) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.userChatDisable();

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		String lotName = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.approveBidder1_2(); // Approve both bidder
		adminDashboardPage.runLiveAuctionChat();// message write

		// adminDashboardPage.runlivesale(); // run live sale
		adminDashboardPage.front();

		// user 1 login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.verify_Chat_Message_Live_Sale(auctionName); // Admin
																	// chat
																	// message
																	// displays.

		// // User 2 login
		//
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);
		dashboardPage.verify_Chat_Message_Live_Sale1(auctionName); // Admin
																	// chat
																	// message
																	// displays.
	}

	/**
	 * 
	 * Test json
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Json(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		// adminDashboardPage.Setting_Auto_Create_Record();

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		String lotName = adminDashboardPage.addLotRandom(2);

		// adminDashboardPage.get_pagesource();
		adminDashboardPage.approveBidder1_2(); // Approve both bidder
		adminDashboardPage.start_Auction();
		adminDashboardPage.sell_Lot_Rahulqa();

		String currenturl = driver.getCurrentUrl();
		System.out.println("Current URL :: " + currenturl);

		adminDashboardPage.generate_Invoice_Rahulqa(auctionName); // Generate
																	// Invocie

		driver.get(currenturl);
		//
		//
		//
		adminDashboardPage.json_Array();
	}

	/**
	 * 
	 * DELETE ALL AUCTION
	 * 
	 */

	@Test(dataProvider = "createauction")
	public void Delete(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.deleteall_Active();
	}

	// ***************** INVENTORY MODULE AUTOMATION SCRIPTS
	// **************************//

	/**
	 * Create Inventory
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @param UName1
	 * @param password1
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	@Test(dataProvider = "twologinUsers")
	public void Create_Inventory(String adminUserName, String adminPassword, String UName, String password,
			String UName1, String password1) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();

		String name = common.generateRandomChars(5);

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction(name);

		String lot_inventory = adminDashboardPage.add_Multiple_Inventory(1); // Add

		// inventory

		adminDashboardPage.front(); // Open Front End

	}

	/**
	 * Search Last Created Inventory
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @param UName1
	 * @param password1
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	@Test(dataProvider = "twologinUsers")
	public void Search_Created_Inventory(String adminUserName, String adminPassword, String UName, String password,
			String UName1, String password1) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();

		String name = common.generateRandomChars(5);

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction(name);

		String inventory = adminDashboardPage.add_Multiple_Inventory(1); // Add

		adminDashboardPage.search_Inventory(inventory); // Search Last Created
														// Inventory

	}

	/**
	 * Search Last Created Inventory Using category
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @param UName1
	 * @param password1
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	@Test(dataProvider = "twologinUsers")
	public void Search_Created_Inventory_Category(String adminUserName, String adminPassword, String UName,
			String password, String UName1, String password1)
			throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();

		String name = common.generateRandomChars(5);

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction(name);

		String inventory = adminDashboardPage.add_Inventory_Category_Cat5(); // Add

		adminDashboardPage.search_Inventory_Category(inventory); // Search Last
																	// Created
																	// Inventory

	}

	/**
	 * Delete Multiple Inventory
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @param UName1
	 * @param password1
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	@Test(dataProvider = "twologinUsers")
	public void Delete_Multiple_Inventory(String adminUserName, String adminPassword, String UName, String password,
			String UName1, String password1) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();

		String name = common.generateRandomChars(5);

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.delete_Multiple_Inventory(); // Search Last Created
														// Inventory

	}

	/**
	 * Search Last Created Inventory Using Consignor
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @param UName1
	 * @param password1
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	@Test(dataProvider = "twologinUsers")
	public void Search_Created_Inventory_Consignor(String adminUserName, String adminPassword, String UName,
			String password, String UName1, String password1)
			throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();

		String name = common.generateRandomChars(5);

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction(name);

		String consignor = adminDashboardPage.add_Inventory_Random_Consignor();

		// nothing display when search inventory through consignor
		adminDashboardPage.search_Inventory_Consignor(consignor); // Search Last
																	// Created
																	// Inventory

	}

	/**
	 * Verify Inventory Sorting.
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @param UName1
	 * @param password1
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	@Test(dataProvider = "twologinUsers")
	public void Verify_Inventory_Sorting(String adminUserName, String adminPassword, String UName, String password,
			String UName1, String password1) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String name = common.generateRandomChars(5);

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verify_Inventory_Sorting(); // Search Last Created
														// Inventory

	}

	/**
	 * Verify Inventory Pagination.
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @param UName1
	 * @param password1
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	@Test(dataProvider = "twologinUsers")
	public void Verify_Inventory_Pagination(String adminUserName, String adminPassword, String UName, String password,
			String UName1, String password1) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String name = common.generateRandomChars(5);

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.inventory_Pagination(); // Pagination

	}

	/**
	 * Verify Inventory Sorting.
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @param UName1
	 * @param password1
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	@Test(dataProvider = "twologinUsers")
	public void Verify_Inventory_Sorting_Asc_Desc(String adminUserName, String adminPassword, String UName,
			String password, String UName1, String password1)
			throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String name = common.generateRandomChars(5);

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verify_Inventory_Sorting_Direction(); // Pagination

	}

	/**
	 * Verify Inventory Quick Preview.
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @param UName1
	 * @param password1
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	@Test(dataProvider = "twologinUsers")
	public void Inventory_Quick_Preview(String adminUserName, String adminPassword, String UName, String password,
			String UName1, String password1) throws InterruptedException, ParseException {

		String tomorrowDate = common.tomorrowDate();
		String name = common.generateRandomChars(5);

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verify_Inventory_Quick_Preview(); // Pagination

	}

	// ***************** USERS Search/Filters AUTOMATION SCRIPTS
	// **************************//

	/**
	 * Verify Keywords: Search Filter
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @param UName1
	 * @param password1
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	@Test(dataProvider = "twologinUsers")
	public void Verify_User_Keywords(String adminUserName, String adminPassword, String UName, String password,
			String UName1, String password1) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String name = common.generateRandomChars(5);

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verify_Search_Filter_Keyword(); // Keyword Search

	}

	/**
	 * Verify Postal Code Search Filter
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @param UName1
	 * @param password1
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	@Test(dataProvider = "twologinUsers")
	public void Verify_User_PostalCode(String adminUserName, String adminPassword, String UName, String password,
			String UName1, String password1) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String name = common.generateRandomChars(5);

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verify_Search_Filter_PostalCode(); // Keyword Search

	}

	/**
	 * Verify Checkbox Filter
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @param UName1
	 * @param password1
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	@Test(dataProvider = "twologinUsers")
	public void Verify_User_Checkbox_Filter(String adminUserName, String adminPassword, String UName, String password,
			String UName1, String password1) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String name = common.generateRandomChars(5);

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verify_Search_Filter_CheckBox(); // Keyword Search

	}

	/**
	 * Verify Users Pagination.
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @param UName1
	 * @param password1
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	@Test(dataProvider = "twologinUsers")
	public void Verify_Users_Pagination(String adminUserName, String adminPassword, String UName, String password,
			String UName1, String password1) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String name = common.generateRandomChars(5);

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.users_Pagination(); // Pagination

	}

	/**
	 * Verify Admin Login
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @param UName1
	 * @param password1
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	@Test(dataProvider = "twologinUsers")
	public void Verify_Admin_Login_Invalid_Details(String adminUserName, String adminPassword, String UName,
			String password, String UName1, String password1)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage.admin_Signin_InvalidDetails(adminUserName, "123"); // Pagination

	}

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

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Live_Auction(saleno);
		String lotname1 = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.quick_Edit_Lot_Number();

	}

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

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Live_Auction(saleno);
		String lotname1 = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.quick_Edit_New_Lot_Number();

	}

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

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Live_Auction(saleno);
		String lotname1 = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.quick_Edit_Lot_Name();

	}

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

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Live_Auction(saleno);
		String lotname1 = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.quick_Edit_Category();

	}

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

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Live_Auction(saleno);
		String lotname1 = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.quick_Edit_Lot_ID();

	}

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

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Live_Auction(saleno);
		String lotname1 = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.quick_Edit_Lot_ID_More_values();

	}

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

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Live_Auction(saleno);
		String lotname1 = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.quick_Edit_New_Lot_ID();

	}

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

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Live_Auction(saleno);
		String lotname1 = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.quick_Edit_Lot_Quantity();

	}

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

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Live_Auction(saleno);
		String lotname1 = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.quick_Edit_Lot_Estimate();

	}

	/**
	 * Jump to feature
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Jump_to_feature(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verify_Jump_To_Feature();
	}

	// *******************************//
	// ********** List View,Content View**********//
	// *******************************//

	/**
	 * Verify Starting Estimate Values in list view
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Verify_Estimate_Values_List_View(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotname1 = adminDashboardPage.addLot1();

		adminDashboardPage.start_Auction();
		adminDashboardPage.starting_Bid_Estimates(); // Verify values in
														// runlivesale tab

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.goto_Catalog_Page_Live_Sale(auctionName);
		dashboardPage.verify_Estimate_Values_Front_List_View(auctionName, saleno); // Verify
		// Estimate
		// Values in
		// Livesale
		// tab

	}

	/**
	 * Place Bid From List View
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void PlaceBid_List_View(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotname1 = adminDashboardPage.addLot1();
		String lotname2 = adminDashboardPage.addLot1();

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.fill_Place_Bid_List_View_LiveSale(lotname1, auctionName); // Place
		// Bid
		// From
		// List
		// View

	}

	/**
	 * Verify Starting Estimate Values in compact view
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Verify_Estimate_Values_Compact_View(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotname1 = adminDashboardPage.addLot1();

		adminDashboardPage.start_Auction();
		adminDashboardPage.starting_Bid_Estimates(); // Verify values in
														// runlivesale tab

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.goto_Catalog_Page_Live_Sale(auctionName);
		dashboardPage.verify_Estimate_Values_Front_Compact_View(auctionName, saleno); // Verify
		// Estimate
		// Values in
		// Livesale
		// tab

	}
	@Test(dataProvider = "createauction")
	public void Place_Absentee_Bids_with_User_A_B_C_on_The_X_Lot(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"as a bidder, place an absentee bid on lot Y from the item details page with "
				+ "confirmation Feature,TestCase Name: 3.160 as a 2 bidder place absentee bids on the same lot");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer1(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1_2_3(); // approve bidder
		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandomForUser(1);
		adminDashboardPage.front(); // Open Front End

		// User 1 Login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Absenteebid(auctionName, lotname);

		// User 2 Login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);
		dashboardPage.placeAbsenteeBid2High(saleno, auctionName, lotname, lotname1); // Higher
																						// than
																						// 1st
																						// bidder
		// User 1 Login
				loginPage = indexPage.clickOnLoginLink(); // click on login link
				dashboardPage = loginPage.loginUser(UName, password);
				dashboardPage.place_Absenteebid_250(auctionName, lotname);
				
				// User 3 Login
				loginPage = indexPage.clickOnLoginLink(); // click on login link
				dashboardPage = loginPage.loginUser("Bidder3", "123123a");
				dashboardPage.place_Absenteebid_150(auctionName, lotname);

		
	}
	
	@Test(dataProvider = "createauction")
	public void Verify_lot_estimate_using_csv_upload(
	String adminUserName, String adminPassword, String UName, String password)
	throws InterruptedException, ParseException, AWTException {
		
	String tomorrowDate = common.tomorrowDate();
	String saleno = common.generateRandomNumber1();
	driver.get(configFileReader.getAdminUrl()); // Admin URL
	
	adminDashboardPage = indexPage // Admin Signin
	.adminSignin(adminUserName, adminPassword);
	String auction1 = adminDashboardPage.create_Live_Auction(tomorrowDate, "1", saleno);

	// adminDashboardPage.verify_lot_estimate_with_csv();
	}
	
	/**
	 * Verify Starting Estimate Values in compact view
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Delete_All_Active_Auction(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.deleteall_Active();

	}

	/**
	 * Verify Starting Estimate Values in compact view
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Delete_All_Closed_Auction3(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.deleteall_Closed_3();

	}

	/**
	 * Verify Delete_All_Closed_Auction4
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Delete_All_Closed_Auction4(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.deleteall_Closed_4();

	}
	@Test(dataProvider = "createauction")
	public void JmeterAuction(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"Verify Filter(Billing Status) Feature,TestCase Name: 3.99 Verify Filter(Billing Status) Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get("https://sam.bp-depot.com/admin/"); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		 adminDashboardPage.create_Live_Auction1(tomorrowDate, "1", saleno);

		adminDashboardPage.uploadLotWithImage();
		adminDashboardPage.uploadLotWithImage();
		adminDashboardPage.uploadLotWithImage();
		adminDashboardPage.uploadLotWithImage();
		adminDashboardPage.uploadLotWithImage();
		adminDashboardPage.uploadLotWithImage();
		adminDashboardPage.uploadLotWithImage();
		adminDashboardPage.uploadLotWithImage();
		adminDashboardPage.uploadLotWithImage();
		adminDashboardPage.uploadLotWithImage();
		adminDashboardPage.uploadLotWithImage();
		adminDashboardPage.uploadLotWithImage();
		adminDashboardPage.uploadLotWithImage();
		adminDashboardPage.uploadLotWithImage();
		adminDashboardPage.uploadLotWithImage();
		}
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

	@DataProvider(name = "twologinUsers")
	public Object[][] getTwoUserAuction() throws Exception {

		Object[][] retObjectArr = parseTwoLoginUsersCsv();

		return retObjectArr;
	}
}
