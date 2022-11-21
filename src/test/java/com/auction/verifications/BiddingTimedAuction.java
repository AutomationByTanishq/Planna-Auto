package com.auction.verifications;

import java.awt.AWTException;

import java.text.ParseException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.auction.init.SeleniumInit;
import com.auction.init.Common;
import com.auction.init.ConfigFileReader;

public class BiddingTimedAuction extends SeleniumInit {

	Common common = new Common(driver);
	String bidder2 = "rahulbid";
	String bidder2Pass = "123123a";
	ConfigFileReader configFileReader= new ConfigFileReader();
	/**
	 * Bid Now xx testcase - 1
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	//1
	@Test(dataProvider = "createauction")
	public void Bid_Now_xx_Catalog(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Timed_Online_Auction_Next_Button_Setting(); // Timed 
																		// Online
																		// Setting
		adminDashboardPage.confirm_Timed_Live_Absentee_Bids_Disable();

		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);
		String lotname2 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.BidNow_x_Timedsale(timedauction, lotname); // Bid Now From
																	// Catalog

	}

	/**
	 * Place Bid testcase - 2
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	//2
	@Test(dataProvider = "createauction")
	public void Place_Bid_Catalog(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.timed_Online_Auction_Force_Bid_Disable();
		adminDashboardPage.confirm_Timed_Live_Absentee_Bids_Disable();

		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_Timedsale(timedauction, lotname); // Place Bid
																	// Timed
																	// Sale

	}

	/**
	 * Change Bid testcase - 3
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	//3
	@Test(dataProvider = "createauction")
	public void Change_Place_Bid_Catalog(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.timed_Online_Auction_Force_Bid_Disable();
		adminDashboardPage.confirm_Timed_Live_Absentee_Bids_Disable();
		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Change_Bid_Timedsale(timedauction, lotname); // Change Bid

	}

	/**
	 * Force bid enable - 4
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	//4
	@Test(dataProvider = "createauction")
	public void Timed_Sale_Force_Bid_Catalog(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.timed_Online_Auction_Force_Bid_Enable();// Timed
																	// Force Bid
																	// Enable
		adminDashboardPage.confirm_Timed_Live_Absentee_Bids_Disable();
		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Place_Force_Bid_Timedsale(timedauction, lotname); // Place
																		// Force
																		// Bid

	}

	/**
	 * Place Multiple Bid - 5
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	//5
	@Test(dataProvider = "createauction")
	public void Timed_Sale_Multiple_Bid_Catalog(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.multiBid_Functionality_Enable();// Timed
																	// Force Bid
																	// Enable

		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);
		String lotname2 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Place_Multiple_Bid_Timedsale(timedauction, lotname, lotname1, lotname2); // Place
																								// Multiple
																								// Bid
																								// Timed
																								// Sale

	}

	/**
	 * Buy Now - 6
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	//6
	@Test(dataProvider = "createauction")
	public void Timed_Sale_BuyNow_Catalog(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.timed_Online_Auction_Force_Bid_Disable();// Timed
																	// Force Bid
																	// Disable
		adminDashboardPage.confirm_Timed_Live_Absentee_Bids_Disable();
		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);
		String lotname2 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.BuyNow_Timedsale(timedauction, lotname);// Buy Now

	}

	/**
	 * Place Bid From Lot Details - 7
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	//7
	@Test(dataProvider = "createauction")
	public void Timed_Sale_Bid_now_xx_LotDetails(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.timed_Online_Auction_Force_Bid_Disable();// Timed
																	// Force Bid
																	// Disable
		adminDashboardPage.confirm_Timed_Live_Absentee_Bids_Disable();
		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);
		String lotname2 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.BidNow_From_LotDetails_Timedsale(timedauction, lotname); // Bid
																				// x
																				// From
																				// Lot
																				// Details

	}

	/**
	 * Place Bid testcase - 8
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	//8
	@Test(dataProvider = "createauction")
	public void Place_Bid_From_Lot_Details(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.timed_Online_Auction_Force_Bid_Disable();
		adminDashboardPage.confirm_Timed_Live_Absentee_Bids_Disable();
		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_TimedBid_Lotdetails(timedauction, lotname); // Place
																		// Bid
																		// From
																		// Lot
																		// Details
	}

	/**
	 * Change Bid From Lot Details testcase - 9
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	//9
	@Test(dataProvider = "createauction")
	public void Change_Bid_From_Lot_Details(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.timed_Online_Auction_Force_Bid_Disable();
		adminDashboardPage.confirm_Timed_Live_Absentee_Bids_Disable();
		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Change_Bid_LotDetails_Timedsale(timedauction, lotname); // Change
																				// Bid

	}

	/**
	 * Force bid from lot details - 10
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	//10
	@Test(dataProvider = "createauction")
	public void Timed_Sale_Force_Bid_LotDetails(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.timed_Online_Auction_Force_Bid_Enable();// Timed
																	// Force Bid
																	// Enable
		adminDashboardPage.confirm_Timed_Live_Absentee_Bids_Disable();
		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Place_Force_bid_TimedBid_Lotdetails(timedauction, lotname); // Place
		// Force
		// Bid

	}

	/**
	 * Buy Now Lot Details - 11
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	//11
	@Test(dataProvider = "createauction")
	public void Timed_Sale_BuyNow_LotDetails(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.timed_Online_Auction_Force_Bid_Disable();// Timed
																	// Force Bid
																	// Disable

		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);
		String lotname2 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.BuyNow_Timedsale_LotDetails(timedauction, lotname);// Buy
																			// Now

	}

	/**
	 * Bid Now xx Single User Watch List - 12
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	//12
	@Test(dataProvider = "createauction")
	public void Bid_Now_xx_Single_User_WatchList(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Timed_Online_Auction_Next_Button_Setting(); // Timed
																		// Online
																		// Setting

		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Bid_x_From_WatchList(timedauction, lotname); // Bid X From
																	// Watch
																	// list
	}

	/**
	 * Place Bid Single User Watch List - 13
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	//13
	@Test(dataProvider = "createauction")
	public void Place_Bid_Single_User_WatchList(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Timed_Online_Auction_Next_Button_Setting(); // Timed
																		// Online
																		// Setting

		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Place_Bid_From_WatchList(timedauction, lotname); // Place
																		// Bid
																		// From
																		// Watch
																		// List
	}

	/**
	 * Change Bid Single User Watch List - 14
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	//14
	@Test(dataProvider = "createauction")
	public void Change_Bid_Single_User_WatchList(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Timed_Online_Auction_Next_Button_Setting(); // Timed
																		// Online
																		// Setting

		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Change_Bid_From_WatchList(timedauction, lotname); // Change
																		// Bid
																		// From
																		// Watch
																		// List
	}

	/**
	 * Force bid From WatchList - 15
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	//15
	@Test(dataProvider = "createauction")
	public void Timed_Sale_Force_Bid_WatchList(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.timed_Online_Auction_Force_Bid_Enable();// Timed
																	// Force Bid
																	// Enable

		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Force_Bid_From_WatchList(timedauction, lotname); // Force
																		// Bid
																		// From
																		// Watch
																		// List
	}

	/**
	 * Place Bid Multiple Bid Single User Watch List - 16
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	//16
	@Test(dataProvider = "createauction")
	public void Place_Multiple_Bid_Single_User_WatchList(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Timed_Online_Auction_Next_Button_Setting(); // Timed
																		// Online
																		// Setting

		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Place_Multiple_Bid_From_WatchList(timedauction, lotname, lotname1); // Place
																							// Multiple
																							// Bid
																							// From
																							// Watch
																							// List
	}

	/**
	 * Buy Now Watch List - 17
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	//17
	@Test(dataProvider = "createauction")
	public void Timed_Sale_BuyNow_WatchList(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.timed_Online_Auction_Force_Bid_Disable();// Timed
																	// Force Bid
																	// Disable
		adminDashboardPage.confirm_Timed_Live_Absentee_Bids_Disable();

		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);
		String lotname2 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Buy_Now_From_WatchList(timedauction, lotname);// Buy Now
																	// from
																	// watch
																	// list

	}

	/**
	 * Bid Now xx form bidon testcase - 18
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	//18
	@Test(dataProvider = "createauction")
	public void Bid_Now_xx_BidOn(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Timed_Online_Auction_Next_Button_Setting(); // Timed
																		// Online
																		// Setting
		adminDashboardPage.confirm_Timed_Live_Absentee_Bids_Disable();

		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);
		String lotname2 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1_2(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.BidNow_x_Timedsale(timedauction, lotname); // Bid Now From
																	// Catalog

		// User 2 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);
		dashboardPage.BidNow_x_Timedsale1(timedauction, lotname); // Bid Now From
																	// Bid On
																	// tab

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.BidNow_Timedsale_Bidon(lotname); // Bid Now
														// From Bid on

		// User 2 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);
		dashboardPage.BidNow_Timedsale_Bidon(lotname); // Bid Now
														// From
		// Bid On tab

	}

	/**
	 * Change Bid bidon testcase - 19
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	//19
	@Test(dataProvider = "createauction")
	public void Change_Bid_BidOn(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Timed_Online_Auction_Next_Button_Setting(); // Timed
																		// Online
																		// Setting
		// adminDashboardPage.Confirm_Timed_Live_Absentee_Bids_Disable();
		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);
		String lotname2 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1_2(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_Timedsale(timedauction, lotname); // Bid Now
																	// From
																	// Catalog

		// dashboardPage.logoutfrontuser();

		// User 2 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);
		dashboardPage.place_Bid_300_Timedsale(timedauction, lotname); // Bid Now
																		// Bid
																		// From
																		// On
																		// tab

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Change_Bid_Timedsale_Bidon(lotname); // Bid Now
															// From Bid on

	}

	/**
	 * Force Bid bidon testcase - 20
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	//20
	@Test(dataProvider = "createauction")
	public void Force_Bid_BidOn(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.timed_Online_Auction_Force_Bid_Enable(); // Timed
																	// Online
																	// Setting
		adminDashboardPage.confirm_Timed_Live_Absentee_Bids_Disable();

		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1_2(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_Timedsale(timedauction, lotname);

		// User 2 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);
		dashboardPage.place_Bid_Timedsale(timedauction, lotname);

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Force_Bid_Timedsale_Bidon(lotname); // Bid Now
															// From Bid on

	}

	/**
	 * Buy Now testcase - 21
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	//21
	@Test(dataProvider = "createauction")
	public void BuyNow_BidOn(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String name = common.generateRandomChars(5);
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.timed_Online_Auction_Force_Bid_Disable(); // Timed
																		// Online
																		// Setting
		adminDashboardPage.confirm_Timed_Live_Absentee_Bids_Disable();

		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);
		String lotname = adminDashboardPage.addLot(1);
		String lotname1 = adminDashboardPage.addLot(1);

		adminDashboardPage.approveBidder1_2(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_Timedsale(timedauction, lotname);
		dashboardPage.add_2_Lot_In_Watchlist();

		// User 2 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);
		dashboardPage.place_Bid_300_Timedsale(timedauction, lotname);

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.buyNow_Timedsale_Bidon(lotname1); // Bid Now
														// From Bid on

	}

	/**
	 * Bid Now xx confirm screen testcase - 22
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	//22
	@Test(dataProvider = "createauction")
	public void Bid_Now_xx_Catalog_ConfirmScreen(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.timed_Online_Auction_Force_Bid_Disable(); // Force
																		// Bid
																		// Disable
		adminDashboardPage.confirm_Timed_Live_Absentee_Bids_Enable(); // Timed
		// Online
		// Setting

		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.BidNow_Timedsale_Confirm_SingleUser(timedauction, lotname,lotname1); // Bid
																					// Now
																					// From
		// Catalog

	}

	/**
	 * Place Bid xx confirm screen testcase - 23
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	//23
	@Test(dataProvider = "createauction")
	public void Place_Bid_xx_Catalog_ConfirmScreen(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.timed_Online_Auction_Force_Bid_Disable(); // Force
																		// Bid
																		// Disable
		adminDashboardPage.confirm_Timed_Live_Absentee_Bids_Enable(); // Timed
		// Online
		// Setting

		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.PlaceBid_Timedsale_Confirm_SingleUser(timedauction, lotname, lotname1); // Place
																					// Bid

	}

	/**
	 * Change Bid xx confirm screen testcase - 24
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	//24
	@Test(dataProvider = "createauction")
	public void Change_Bid_xx_Catalog_ConfirmScreen(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.timed_Online_Auction_Force_Bid_Disable(); // Force
																		// Bid
																		// Disable
		adminDashboardPage.confirm_Timed_Live_Absentee_Bids_Enable(); // Timed
		// Online
		// Setting

		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.ChangeBid_Timedsale_Confirm_SingleUser(timedauction, lotname); // Change
																						// Bid
																						// Single
																						// User
																						// Confirm

	}

	/**
	 * Force Bid xx confirm screen testcase - 25
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	//25
	@Test(dataProvider = "createauction")
	public void Force_Bid_xx_Catalog_ConfirmScreen(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.timed_Online_Auction_Force_Bid_Enable(); // Force
																	// Bid
																	// Disable
		adminDashboardPage.confirm_Timed_Live_Absentee_Bids_Enable(); // Timed
		// Online
		// Setting

		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.ForceBid_Timedsale_Confirm_SingleUser(timedauction, lotname);

	}

	/**
	 * Place Multi Bid xx confirm screen testcase - 26
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
	public void Place_Multi_Bid_xx_Catalog_ConfirmScreen(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.timed_Online_Auction_Force_Bid_Disable(); // Force
																		// Bid
																		// Disable
		adminDashboardPage.enable_Allow_Multiple_Timed_And_Live_Absentee_Bids(); // Timed
		// Online
		// Setting

		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);
		String lotname2 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Place_Multiple_Bid_Timedsale_Confirm_SingleUser(timedauction, lotname, lotname1, lotname2);
	}

	/**
	 * Bid Now xx Lot Details User Confirmation- 27
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
	public void Timed_Sale_Bid_now_xx_LotDetails_UserConfirmation(String adminUserName, String adminPassword,
			String UName, String password) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.timed_Online_Auction_Force_Bid_Disable();// Timed
		adminDashboardPage.confirm_Timed_Live_Absentee_Bids_Enable(); // Timed
		// Online
		// Setting // Force Bid
		// Disable

		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.BidNow_From_LotDetails_UserConfirmation_Timedsale(timedauction, lotname , lotname1); // Bid
		// x
		// From
		// Lot
		// Details

	}

	/**
	 * Place Bid Lot Details User Confirmation- 28
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
	public void Timed_Sale_Place_Bid_LotDetails_UserConfirmation(String adminUserName, String adminPassword,
			String UName, String password) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.timed_Online_Auction_Force_Bid_Disable();// Timed
																	// Force Bid
																	// Disable
		adminDashboardPage.confirm_Timed_Live_Absentee_Bids_Enable(); // Timed
		// Online
		// Setting

		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Place_TimedBid_Lotdetails_UserConfirmation(timedauction, lotname, lotname1); // Place
																							// Bid

	}

	/**
	 * Change Bid Lot Details Timed Auction User Confirmation- 29
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
	public void Timed_Sale_Change_Bid_LotDetails_UserConfirmation(String adminUserName, String adminPassword,
			String UName, String password) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.timed_Online_Auction_Force_Bid_Disable();// Timed
																	// Force Bid
																	// Disable
		adminDashboardPage.confirm_Timed_Live_Absentee_Bids_Enable(); // Timed
		// Online
		// Setting

		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Change_Bid_LotDetails_Timedsale_User_Confirmation(timedauction, lotname); // Place
																								// Bid

	}

	/**
	 * Force bid from lot details User Confirmation - 30
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
	public void Timed_Sale_Force_Bid_LotDetails_User_Confirm(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.confirm_Timed_Live_Absentee_Bids_Disable();
		adminDashboardPage.timed_Online_Auction_Force_Bid_Enable();// Timed
																	// Force Bid
																	// Enable

		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Place_Force_bid_TimedBid_Lotdetails_User_Confirmation(timedauction, lotname); // Place
		// Force
		// Bid

	}

	/**
	 * Bid Now xx Bid Confirmation Testcase - 31
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
	public void Bid_Now_xx_Catalog_BidConfirmation(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.timed_Online_Auction_Force_Bid_Disable(); // Force
																		// Bid
																		// Disable
		adminDashboardPage.enable_Inline_Bid_Confirmation();

		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.BidNow_x_Timedsale_Bid_Confirmation(timedauction, lotname); // Bid
																					// Now
																					// From
		// Catalog

	}

	/**
	 * Place Bid Confirmation Testcase - 32
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
	public void Place_Bid_xx_Catalog_BidConfirmation(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.timed_Online_Auction_Force_Bid_Disable(); // Force
																		// Bid
																		// Disable
		adminDashboardPage.enable_Inline_Bid_Confirmation();

		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Place_Bid_Timedsale_Bid_Confirmation(timedauction, lotname); // Bid
																					// Now
																					// From
		// Catalog

	}

	/**
	 * Change Bid Confirmation Testcase - 33
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
	public void Change_Bid_xx_Catalog_BidConfirmation(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.timed_Online_Auction_Force_Bid_Disable(); // Force
																		// Bid
																		// Disable
		adminDashboardPage.enable_Inline_Bid_Confirmation();

		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Change_Bid_Timedsale_Bid_Confirmation(timedauction, lotname); // Bid
																					// Now
																					// From
		// Catalog

	}

	/**
	 * Force Bid Confirmation Testcase - 34
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
	public void Force_Bid_xx_Catalog_BidConfirmation(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.timed_Online_Auction_Force_Bid_Enable(); // Force
																	// Bid
																	// Enable
		adminDashboardPage.enable_Inline_Bid_Confirmation();

		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Force_Bid_Timedsale_Bid_Confirmation(timedauction, lotname); // Bid
																					// Now
																					// From
		// Catalog

	}

	/**
	 * Bid Now xx Bid Confirmation Testcase - 35
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
	public void Bid_Now_xx_Catalog_BidConfirmation_LotDetails(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.timed_Online_Auction_Force_Bid_Disable(); // Force
																		// Bid
																		// Disable
		adminDashboardPage.enable_Inline_Bid_Confirmation();

		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.BidNow_x_Timedsale_Bid_Confirmation_Lot_Details(timedauction, lotname); // Bid
																								// Now
																								// From
		// Lot Details
	}

	/**
	 * Place Bid Confirmation Testcase - 36
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
	public void Place_Bid_Catalog_BidConfirmation_LotDetails(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.timed_Online_Auction_Force_Bid_Disable(); // Force
																		// Bid
																		// Disable
		adminDashboardPage.enable_Inline_Bid_Confirmation();

		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Place_Bid_Timedsale_Bid_Confirmation_Lot_Details(timedauction, lotname); // Bid
																								// Now
																								// From
		// Lot Details
	}

	/**
	 * Change Bid Confirmation Testcase - 37
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
	public void Change_Bid_Catalog_BidConfirmation_LotDetails(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.timed_Online_Auction_Force_Bid_Disable(); // Force
																		// Bid
																		// Disable
		adminDashboardPage.enable_Inline_Bid_Confirmation();

		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Change_Bid_Timedsale_Bid_Confirmation_Lot_Details(timedauction, lotname); // Bid
																								// Now
																								// From
	}

	/**
	 * Force Bid Confirmation Lot Details Testcase - 38
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
	public void Force_Bid_xx_Catalog_BidConfirmation_LotDetails(String adminUserName, String adminPassword,
			String UName, String password) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.timed_Online_Auction_Force_Bid_Enable(); // Force
																	// Bid
																	// Enable
		adminDashboardPage.enable_Inline_Bid_Confirmation();

		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Force_Bid_Timedsale_Bid_Confirmation_Lot_Details(timedauction, lotname); // Bid
		// Now
		// From
		// Catalog

	}

	/**
	 * Extend all=yes and Extend from current time=yes functionality - 39
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
	public void Extend_All_Yes(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Timed_Online_Auto_Extend_10(); // Force
															// Bid
															// Disable
		adminDashboardPage.enable_Inline_Bid_Confirmation_Disable();

		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);
		adminDashboardPage.Auction_Setting_Extend_All_Enable_Current_Time_Enable();

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Place_Bid_Timedsale_AutoExtend(timedauction, lotname); // Bid
																				// Now
																				// From
		// Catalog

	}

	/**
	 * Extend all=no and Extend from current time=yes functionality - 40
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
	public void Extend_All_Yes_Current_Time_Yes(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Timed_Online_Auto_Extend_10();

		adminDashboardPage.enable_Inline_Bid_Confirmation_Disable();

		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);
		adminDashboardPage.Auction_Setting_Extend_All_Disable_Current_Time_Enable();

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Place_Bid_Timedsale_AutoExtend(timedauction, lotname); // Bid
																				// Now
																				// From
		// Catalog

	}

	/**
	 * Extend all=no and Extend from current time=no functionality - 41
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
	public void Extend_All_Yes_Current_Time_No(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Timed_Online_Auto_Extend_10();

		adminDashboardPage.enable_Inline_Bid_Confirmation_Disable();

		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);
		adminDashboardPage.Auction_Setting_Extend_All_Disable_Current_Time_Disable();

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Place_Bid_Timedsale_AutoExtend(timedauction, lotname); // Bid
																				// Now
																				// From
		// Catalog

	}

	/**
	 * Bid Now xx testcase Two User - 42
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
	public void Bid_Now_xx_Catalog_Two_User(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.timed_Online_Auction_Force_Bid_Disable(); // Timed
																		// Online
																		// Setting
		adminDashboardPage.confirm_Timed_Live_Absentee_Bids_Disable();

		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);
		String lotname2 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1_2(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.BidNow_x_Timedsale(timedauction, lotname); // Bid Now From
																	// Catalog

		// User 2 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);
		dashboardPage.BidNow_x_Timedsale1(timedauction, lotname); // Bid Now From
																	// Catalog

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Verify_BidNow_x_Outbid(timedauction, lotname); // Bid Now
																		// From
																		// Catalog

	}
	//43
	@Test(dataProvider = "createauction")
	public void Reports_Bid_history_csv_It_shows_only_one_bidder_bid_instead_of_showing_all_bids_Automation_8577(
			String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-8577");
		common.log("Ticket No. - SAM-8577");
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.timed_Online_Auction_Force_Bid_Disable();
		adminDashboardPage.confirm_Timed_Live_Absentee_Bids_Disable();
		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		String lotname = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1_2(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_TimedBid_Lotdetails(timedauction, lotname); // Place
																		// Bid
																		// From
																		// Lot
																		// Details
		// User 2 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);
		dashboardPage.place_TimedBid_Lotdetails(timedauction, lotname); // Place
																		// Bid
																		// From
																		// Lot
																		// Details
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Set_Current_Today_Date_In_Auction(saleno);
		adminDashboardPage.Verify_Bidding_History_Exist_Lot();
	}

	@DataProvider(name = "createauction")
	public Object[][] getCreateAuction() throws Exception {

		Object[][] retObjectArr = parsecreateauctionCsv();

		return retObjectArr;
	}
}
