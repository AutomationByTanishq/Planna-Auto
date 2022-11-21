package com.auction.verifications;

import java.awt.AWTException; 
import java.text.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.auction.init.ConfigFileReader;
import com.auction.init.SeleniumInit;

public class AuctionRegistration extends SeleniumInit {
	ConfigFileReader configFileReader = new ConfigFileReader();

	/**
	 * Initial Setup For Auction Registration
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	// 1
	@Test(dataProvider = "missedliveauction")
	public void initialSetupForAuctionRegistration(String adminUserName, String adminPassword, String name)
			throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT" + "\"Initial Setup,TestCase Name: Initial Setup.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyRegistrationWithCCNotRequiredForPlacingBids();
		adminDashboardPage.expand_Registration_Tab(); // Verify Users profile
															// page
		adminDashboardPage.verifyCheckedCheckboxSimplyfiedSignup(); // Verify
																	// Checked
																	// Check box
																	// Simplyfied
																	// Sign up
	}

	/**
	 * Initial Setup For Registration with CC not required for placing bids
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	// 2
	@Test(dataProvider = "missedliveauction")
	public void initialSetupForRegistrationwithCCNotRequired(String adminUserName, String adminPassword, String name)
			throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT" + "\"Login Feature,TestCase Name: Login Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		// Admin URL
		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.expand_Registration_Tab();// Verify Users profile
															// page
		adminDashboardPage.verifyRegistrationWithCCNotRequiredInitialSetup(); // Verify
		// Checked
		// Check box
		// Register With CC Not Required
		// Sign up
	}

	/**
	 * Create Live Auction
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	// 3
	@Test(dataProvider = "liveauction")
	public void createaLiveAuction(String adminUserName, String adminPassword, String Name, String username,
			String password) throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT" + "\"Create Live Auction Feature,TestCase Name: 2.5 Create Live Auction Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl());
		String lotName = generateRandomChars(6);
		initialSetupForAuctionRegistration(adminUserName, adminPassword, Name); // InitialSetup
		// For
		// Auction
		// Registration
		adminDashboardPage.CreateNewAuction(Name); // Create New Auction with
													// Unique Name
		lotVerificationPage = adminDashboardPage.addALot(lotName); // Add Lot
		lotVerificationPage.verifyLot(lotName); // Verified added lot
	}

	/**
	 * Register User with Correct CC to the live sale Feature
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	// 4
	@Test(dataProvider = "liveauction")
	public void registerUserWithCorrectCCtotheLiveSale(String adminUserName, String adminPassword, String name,
			String username, String password) throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"Register User with Correct CC to the live sale Feature,TestCase Name: 2.6 Register User with Correct CC to the live sale Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl());
		String Name = generateRandomChars(6);
		String lotName = generateRandomChars(6);
		// String NewAuction = generateRandomChars(6);
		System.out.println("NewLot ::" + lotName);
		initialSetupForRegistrationwithCCNotRequired(adminUserName, adminPassword, name); // InitialSetup

		// Register User With Correct CC to The Live Sale
		String UName = adminDashboardPage.addnewUsers("4111111111111111");
		System.out.print(UName);
		adminDashboardPage.CreateNewAuction(Name); // Create New Auction with
		// Unique Name
		lotVerificationPage = adminDashboardPage.addALot(lotName); // Add Lot
		lotVerificationPage.verifyLot(lotName); // Verified added lot
		runLiveAuctionPage = lotVerificationPage.clickOnRunLiveAuction(); // Run
																			// Live
																			// Auction
		runLiveAuctionPage.clickOnStartAuction(); // Start New Auction
		adminDashboardPage.adminLogout();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verifyLoginPageElements(); // Verify Login Page Elements
		dashboardPage = loginPage.loginUser(UName, password); // Login with
																// valid
																// credentials
		// adminDashboardPage.VerifyRegisterToBid(Name, 1, "Live");

	}

	/* register user with incorrect CC to the live sale */
	// 5

	@Test(dataProvider = "liveauction")
	public void registeruserwithincorrectCCtothelivesale(String adminUserName, String adminPassword, String name,
			String username, String password) throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"Register user with incorrect CC to the live sale Feature,TestCase Name: 2.7 Register user with incorrect CC to the live sale Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		String Name = generateRandomChars(6);
		String lotName = generateRandomChars(6);
		// String NewAuction = generateRandomChars(6);
		driver.get(configFileReader.getAdminUrl());
		System.out.println("NewLot ::" + lotName);
		initialSetupForRegistrationwithCCNotRequired(adminUserName, adminPassword, Name); // InitialSetup
		// For
		// Register User With Correct CC to The Live Sale
		String UName = adminDashboardPage.addnewUsers("4111111111111112");
		adminDashboardPage.CreateNewAuction(Name); // Create New Auction with
		// Unique Name
		lotVerificationPage = adminDashboardPage.addALot(lotName); // Add Lot
		lotVerificationPage.verifyLot(lotName); // Verified added lot
		runLiveAuctionPage = lotVerificationPage.clickOnRunLiveAuction(); // Run
																			// Live
		// Auction
		runLiveAuctionPage.clickOnStartAuction(); // Start New Auction
		adminDashboardPage.adminLogout();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verifyLoginPageElements(); // Verify Login Page Elements
		dashboardPage = loginPage.loginUser(UName, password); // Login with
																// valid
																// credentials
		// adminDashboardPage.VerifyRegisterToBid(Name, 1, "Live");

	}

	/* Register user with expired CC to the live sale */
	// 6

	@Test(dataProvider = "liveauction")
	public void registeruserwithexpiredCCtothelivesale(String adminUserName, String adminPassword, String name,
			String username, String password) throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"Register user with expired CC to the live sale Feature,TestCase Name: 2.8 Register user with expired CC to the live sale Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		String Name = generateRandomChars(6);
		String lotName = generateRandomChars(6);
		// String NewAuction = generateRandomChars(6);
		driver.get(configFileReader.getAdminUrl());
		System.out.println("NewLot ::" + lotName);
		initialSetupForRegistrationwithCCNotRequired(adminUserName, adminPassword, Name); // InitialSetup
		String UName = adminDashboardPage.addnewUsers("000000");
		// For
		// Register User With Correct CC to The Live Sale
		adminDashboardPage.CreateNewAuction(Name); // Create New Auction with
		// Unique Name
		lotVerificationPage = adminDashboardPage.addALot(lotName); // Add Lot
		lotVerificationPage.verifyLot(lotName); // Verified added lot
		runLiveAuctionPage = lotVerificationPage.clickOnRunLiveAuction(); // Run
																			// Live
																			// Auction
		runLiveAuctionPage.clickOnStartAuction(); // Start New Auction
		adminDashboardPage.adminLogout();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verifyLoginPageElements(); // Verify Login Page Elements
		dashboardPage = loginPage.loginUser(UName, password); // Login with
																// valid
																// credentials
		// adminDashboardPage.VerifyRegisterToBid(Name, 1, "Live");

	}

	/* register user with no CC to the live sale */
	// 7

	@Test(dataProvider = "liveauction")
	public void registeruserwithnoCCtothelivesale(String adminUserName, String adminPassword, String name,
			String username, String password) throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"Register user with no CC to the live sale Feature,TestCase Name: 2.9 register user with no CC to the live sale Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		String Name = generateRandomChars(6);
		String lotName = generateRandomChars(6);
		driver.get(configFileReader.getAdminUrl());
		// String NewAuction = generateRandomChars(6);
		System.out.println("NewLot ::" + lotName);
		initialSetupForRegistrationwithCCNotRequired(adminUserName, adminPassword, Name); // InitialSetup
		String UName = adminDashboardPage.addnewUsers(null);
		// For
		// Register User With Correct CC to The Live Sale
		adminDashboardPage.CreateNewAuction(Name); // Create New Auction with
		// Unique Name
		lotVerificationPage = adminDashboardPage.addALot(lotName); // Add Lot
		lotVerificationPage.verifyLot(lotName); // Verified added lot
		runLiveAuctionPage = lotVerificationPage.clickOnRunLiveAuction(); // Run
																			// Live
																			// Auction
		runLiveAuctionPage.clickOnStartAuction(); // Start New Auction
		adminDashboardPage.adminLogout();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verifyLoginPageElements(); // Verify Login Page Elements
		dashboardPage = loginPage.loginUser(UName, password); // Login with
																// valid
																// credentials
		// adminDashboardPage.VerifyRegisterToBid(Name, 1, "Live");

	}

	/**
	 * Verify Delete_All_Created_Users
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	// 8
	@Test
	public void Delete_All_Created_Users() throws InterruptedException, AWTException {

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.Delete_Created_Users();

	}

	// --------------------------------- DATA PROVIDERS
	// --------------------------------- //

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
	 * Data Provider for Live Auction
	 * 
	 * @return
	 * @throws Exception
	 */

	@DataProvider(name = "liveauction")
	public Object[][] getLiveAuction() throws Exception {

		Object[][] retObjectArr = parseliveauctionCsv();

		return retObjectArr;

	}

}
