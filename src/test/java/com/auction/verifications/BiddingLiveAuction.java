package com.auction.verifications;


import java.awt.AWTException;


import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.auction.admin.pages.LiveSaleAuction;
import com.auction.init.SeleniumInit;
import com.auction.init.Common;
import com.auction.init.ConfigFileReader;
import com.auction.pages.DashboardPage;
import com.auction.pages.LoginPage;

public class BiddingLiveAuction extends SeleniumInit {

	LoginPage loginpage = new LoginPage(driver);
	Common common = new Common(driver);
	String bidder2 = "rahulbid";
	String bidder2Pass = "123123a";
	ConfigFileReader configFileReader = new ConfigFileReader();

	// for script 772
	/**
	 * placeMultipleBid
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	// 1
	@Test(dataProvider = "createauction")
	public void Place_Multiple_Bid(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auctionName = adminDashboardPage.createNewLiveAuction(saleno);

		System.out.println("Step :: auction Name s :" + auctionName);
		common.log("<br></br> Step :: auction Name s :" + auctionName);
		String lotName = adminDashboardPage.addLot(2); // Bidding
														// Run
														// Live
														// Auction
		adminDashboardPage.approveBidder1_2();
		adminDashboardPage.front(); // Open Front End

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.placeBidFromLotDetails(auctionName, lotName);

		// User 2 Login for place bid
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);

		dashboardPage.placeBidFromLotDetails1(auctionName, lotName);

	}

	// for script 769

	/**
	 * bidValueLowerThanAlreadyPlacedBidValue
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws ParseException
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	// 2
	@Test(dataProvider = "createauction")
	public void Bid_Value_Lower_Than_Already_Placed_Bid_Value(String adminUserName, String adminPassword, String UName,
			String password) throws ParseException, InterruptedException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.auction_Bids_Setting_for_V_Three_one(); // Auction
		// Specific
		// Settigs
		// as per
		// v3-0.();
		String auctionName = adminDashboardPage.createNewLiveAuction(saleno); // Create
																				// New
																				// Auction
		System.out.println("auction Name :: " + auctionName);

		String lotName = adminDashboardPage.addLot(1); // Run Live
														// Auction
		System.out.println("Lot Name >> " + lotName);
		adminDashboardPage.approveBidder1_2(); // approve both bidder
		adminDashboardPage.front(); // Open Front End

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.verify_Your_Bid_Has_been_Placed(auctionName, lotName);
		dashboardPage.enter_Lower_Than_Starting_Amount(lotName);

	}

	/**
	 * placeBidNotMetStartingBidAtCatalog
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws ParseException
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	// 3
	@Test(dataProvider = "createauction")
	public void place_Bid_Not_Met_Starting_Bid_At_Catalog(String adminUserName, String adminPassword, String UName,
			String password) throws ParseException, InterruptedException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.auction_Bids_Setting_for_V_Three_one(); // Auction
		// Specific
		// Settigs
		// as per
		// v3-0.();
		String auctionName = adminDashboardPage.createNewLiveAuction(saleno);
		
		String lotName = adminDashboardPage.addLot(1); // Bidding
														// Run
														// Live
														// Auction
		adminDashboardPage.approveBidder1();
		adminDashboardPage.front(); // Open Front End

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.place_Bid_Value_Lower_Than_Starting(saleno, auctionName, lotName);
	}

	/**
	 * placeBidMissingAtCatalog
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws ParseException
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	// 4
	@Test(dataProvider = "createauction")
	public void Place_Bid_Missing_At_Catalog(String adminUserName, String adminPassword, String UName, String password)
			throws ParseException, InterruptedException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auctionName = adminDashboardPage.createNewLiveAuction(saleno);

		String lotName = adminDashboardPage.addLot(1); // Bidding
														// Run
														// Live
														// Auction
		adminDashboardPage.approveBidder1_2();
		adminDashboardPage.front(); // Open Front End

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_With_No_Value(saleno, auctionName, lotName);

	}

	/**
	 * placeBidFromCatalog
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws ParseException
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	// 5
	@Test(dataProvider = "createauction")
	public void Place_Bid_From_Catalog(String adminUserName, String adminPassword, String UName, String password)
			throws ParseException, InterruptedException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auctionName = adminDashboardPage.createNewLiveAuction(saleno);
		System.out.println("Step :: auction Name s :" + auctionName);
		common.log("<br></br> Step :: auction Name s :" + auctionName);
		String lotName = adminDashboardPage.addLot(1);

		adminDashboardPage.approveBidder1_2(); // Approve both bidder
		adminDashboardPage.front(); // Open Front End

		// User 1 login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.placeBidFromCatalog(saleno, auctionName, lotName);

		// User 2 login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);
		dashboardPage.placeBidFromCatalog1(saleno, auctionName, lotName);

		// Goto Admin Side

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.search_Last_Created_Auction(saleno);
		adminDashboardPage.runLiveSaleTab();
		adminDashboardPage.verifyAbsenteeBidValueInNoteField(); // Verify Bid
																// Values

	}

	/**
	 * we 21
	 * 
	 * placeBidWithAlreadyBidAmountAtCatalog
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws ParseException
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	// 6

	@Test(dataProvider = "createauction")
	public void Place_Bid_With_Already_Bid_Amount_At_Catalog(String adminUserName, String adminPassword, String UName,
			String password) throws ParseException, InterruptedException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auctionName = adminDashboardPage.createNewLiveAuction(saleno);

		String lotName = adminDashboardPage.addLot(1); // Bidding
														// Run
														// Live
														// Auction
		adminDashboardPage.approveBidder1_2(); // Approve both bidder
		adminDashboardPage.front(); // Open Front End

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_Already_Amount(saleno, auctionName, lotName);

	}

	// Bidder 2 Place out Bid feature

	/**
	 * bidder2OutBidFeature
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws ParseException
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	// 7
	@Test(dataProvider = "createauction")
	public void Bidder_2_Out_Bid_Feature(String adminUserName, String adminPassword, String UName, String password)
			throws ParseException, InterruptedException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auctionName = adminDashboardPage.createNewLiveAuction(saleno);

		String lotName = adminDashboardPage.addLot(1); // Bidding
														// Run
														// Live
														// Auction
		adminDashboardPage.approveBidder1_2(); // Approve both bidder
		adminDashboardPage.start_Auction();
		adminDashboardPage.front(); // Open Front End

		// User 1 login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		// admin login

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.accept_Live_Bid(auctionName, saleno); // accept user
																	// 1
																	// bid
		// User 2 login
		adminDashboardPage.front(); // Open Front End
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		// admin login
		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.accept_Live_Bid(auctionName, saleno); // accept user
																	// 1
																	// bid

		// User 1 login
		adminDashboardPage.front(); // Open Front End
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.verify_Out_Bid_Live_Auction(saleno, auctionName, lotName);

	}

	/**
	 * placeMultipleBidMissingAtCatalog
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws ParseException
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	// 8
	@Test(dataProvider = "createauction")
	public void Place_Multiple_Bid_Missing_At_Catalog(String adminUserName, String adminPassword, String UName,
			String password) throws ParseException, InterruptedException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auctionName = adminDashboardPage.createNewLiveAuction(saleno);
		System.out.println("Step :: auction Name s :" + auctionName);
		common.log("<br></br> Step :: auction Name s :" + auctionName);
		String lotName = adminDashboardPage.addLot(2); // Bidding
		// Run
		// Live
		// Auction
		adminDashboardPage.approveBidder1_2(); // Approve both bidder
		adminDashboardPage.start_Auction();
		adminDashboardPage.postFloor();
		adminDashboardPage.front(); // Open Front End

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.verifyPlaceMultipleBids(auctionName, lotName);

	}

	/**
	 * placeMultipleBidWithLessThanStartingBidAmountInCatalogPage
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws ParseException
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	// 9
	@Test(dataProvider = "createauction")
	public void Place_Multiple_Bid_With_Less_Than_Starting_Bid_Amount_In_Catalog_Page(String adminUserName,
			String adminPassword, String UName, String password)
			throws ParseException, InterruptedException, AWTException {

		String tomorrowDate = common.tomorrowDate();

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.auction_Bids_Setting_for_V_Three_one(); // Auction
		// Specific
		// Settigs
		// as per
		// v3-0.();
		String auctionName = adminDashboardPage.createNewLiveAuction(saleno);
		
		System.out.println("Step :: auction Name s :" + auctionName);
		common.log("<br></br> Step :: auction Name s :" + auctionName);
		String lotName = adminDashboardPage.addLot(1); // Bidding
		// Run
		// Live
		// Auction
		adminDashboardPage.approveBidder1_2(); // Approve both bidder
		adminDashboardPage.start_Auction();
		adminDashboardPage.postFloor();
		adminDashboardPage.front(); // Open Front End

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.verifyPlaceMultipleBidWithLessThanStartingBidAmountInCatalogPage(lotName, auctionName); // Verify
		// Place
		// Multiple
		// Bid
		// With
		// Less
		// Than
		// Starting
		// Bid
		// Amount
		// In
		// Catalog
		// Page

	}

	/**
	 * placeBidMissingAtLotDetails
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws ParseException
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	// 10
	@Test(dataProvider = "createauction")
	public void Place_Bid_Missing_At_Lot_Details(String adminUserName, String adminPassword, String UName,
			String password) throws ParseException, InterruptedException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.enable_Inline_Bid_Confirmation_Disable();
		String auctionName = adminDashboardPage.createNewLiveAuction(saleno);
		System.out.println("Step :: auction Name s :" + auctionName);
		common.log("<br></br> Step :: auction Name s :" + auctionName);
		String lotName = adminDashboardPage.addLot(2);
		adminDashboardPage.approveBidder1_2(); // Approve both bidder
		adminDashboardPage.front(); // Open Front End

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.placeBidMissingAtLotDetails(lotName, auctionName); // verify
																			// place
																			// bid
																			// Missing
																			// at
																			// lot
																			// details

	}

	/**
	 * placeBidFromLotDetails
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws ParseException
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	// 11
	@Test(dataProvider = "createauction")
	public void Place_Bid_From_Lot_Details(String adminUserName, String adminPassword, String UName, String password)
			throws ParseException, InterruptedException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auctionName = adminDashboardPage.createNewLiveAuction(saleno);
		System.out.println("Step :: auction Name s :" + auctionName);
		common.log("<br></br> Step :: auction Name s :" + auctionName);
		String lotName = adminDashboardPage.addLotRandom(1);
		// Setting
		String lotName1 = adminDashboardPage.addLotRandom(1); // Save
		// Changes
		adminDashboardPage.approveBidder1(); // Approve both bidder
		adminDashboardPage.front(); // Open Front End

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.placeBidFromLotDetails(auctionName, lotName);

	}

	/**
	 * ChangeBidWithLessAmountThanAlreadyPlacedAtLotDetails
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws ParseException
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	// 12
	@Test(dataProvider = "createauction")
	public void Change_Bid_With_Less_Amount_Than_Already_Placed_At_Lot_Details(String adminUserName,
			String adminPassword, String UName, String password)
			throws ParseException, InterruptedException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auctionName = adminDashboardPage.createNewLiveAuction(saleno);
		adminDashboardPage.auction_Bids_Setting_for_V_Three_one();
		String lotName = adminDashboardPage.addLot(1);
		String lotName1 = adminDashboardPage.addLot(1); // Auction
														// Setting
														// Save
														// Changes
		adminDashboardPage.approveBidder1_2(); // Approve both bidder
		adminDashboardPage.front(); // Open Front End

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.enter_Lower_Bid_In_Lot_Details(auctionName, lotName);

	}

	/**
	 * buyLotFromCatalog
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws ParseException
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	// 13
	@Test(dataProvider = "createauction")
	public void Buy_Lot_From_Catalog(String adminUserName, String adminPassword, String UName, String password)
			throws ParseException, InterruptedException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auctionName = adminDashboardPage.createNewLiveAuction(saleno);
		// adminDashboardPage.Auction_Bids_Setting_for_v_Three_one();

		String lotName = adminDashboardPage.addLot(1);
		String lotName1 = adminDashboardPage.addLot(1);

		adminDashboardPage.approveBidder1_2(); // Approve both bidder
		// adminDashboardPage.Start_Auction();
		adminDashboardPage.front(); // Open Front End

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.buy_Lot_From_Catalog(saleno, auctionName, lotName);// Register
																			// to
																			// Bid

	}

	/**
	 * Feature :: Two user Bidding
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws ParseException
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	// 14
	@Test(dataProvider = "twologinUsers")
	public void Two_User_Bidding(String adminUserName, String adminPassword, String UName, String password,
			String Uname1, String password1) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auctionName = adminDashboardPage.createNewLiveAuction(saleno);
		adminDashboardPage.auction_Bids_Setting_for_V_Three_one();
		System.out.println("Step :: auction Name s :" + auctionName);
		common.log("<br></br> Step :: auction Name s :" + auctionName);

		String lotName = adminDashboardPage.addLotRandom(1);
		String lotName1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1_2(); // Approve both bidder
		adminDashboardPage.start_Auction();
		adminDashboardPage.front(); // Open Front End
									// Bidding
									// Run
									// Live*/

		// user 1 login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		// User 2 login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);
		dashboardPage.place_Bid_Live_Auction_End(saleno, auctionName, lotName); // it
																				// display
																				// message
																				// "someone
																				// else
																				// was
																				// faster!!"

		// admin login
		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.accept_Live_Bid(auctionName, saleno);

	}

	/**
	 * Feature :: Sell Lot higher Bidder
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param UName
	 * @param password
	 * @throws ParseException
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	// 15
	@Test(dataProvider = "createauction")
	public void Sell_Lot_High_Bidder(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auctionName = adminDashboardPage.createNewLiveAuction(saleno); // create
		// new
		// auction
		adminDashboardPage.auction_Bids_Setting_for_V_Three_one();

		String lotName = adminDashboardPage.addLot(1); // Bidding
		String lotName1 = adminDashboardPage.addLot(1); // Bidding

		adminDashboardPage.approveBidder1_2(); // Approve both bidder
		adminDashboardPage.start_Auction();
		adminDashboardPage.front(); // Open Front End

		// user 1 login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		// User 2 login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);
		dashboardPage.place_Bid_Live_Auction_End(saleno, auctionName, lotName); // it
																				// display
																				// message
		// "someone else was faster!!"

		// admin login
		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		// Sell Lot to user 1 (High Bidder)
		adminDashboardPage.sold_Live_Lot(auctionName, saleno);

	}

	/**
	 * Not Accept Live Bid
	 * 
	 **/
	// 16
	@Test(dataProvider = "twologinUsers")
	public void Not_Accept_Live_Bid(String adminUserName, String adminPassword, String UName, String password,
			String Uname1, String password1) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auctionName = adminDashboardPage.createNewLiveAuction(saleno);

		String lotName = adminDashboardPage.addLot(2);
		// Bidding
		// Run
		// Live
		// Auction
		adminDashboardPage.approveBidder1_2(); // Approve both bidder
		adminDashboardPage.start_Auction();
		adminDashboardPage.front(); // Open Front End
									// Bidding
									// Run
									// Live*/

		// user 1 login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl()); // Admin login
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_Live_Bid(auctionName, saleno);

		adminDashboardPage.front(); // Open Front End

		// User 2 login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName); // Bid
																		// success
																		// !

		// admin login

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.sold_Lot_With_out_Accept_Bid(auctionName, saleno);

	}

	/**
	 * Sell Lot to Floor Bidder
	 * 
	 **/
	// 17
	@Test(dataProvider = "twologinUsers")
	public void Sell_Lot_To_Floor_Bidder(String adminUserName, String adminPassword, String UName, String password,
			String Uname1, String password1) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.setting_Auto_Create_Record();

		String auctionName = adminDashboardPage.createNewLiveAuction(saleno);

		String lotName = adminDashboardPage.addLot(2); // Bidding
														// Run
														// Live
														// Auction

		adminDashboardPage.approveBidder1_2(); // Approve both bidder
		adminDashboardPage.start_Auction();
		adminDashboardPage.front(); // Open Front End
									// Bidding
									// Run
									// Live*/

		// user 1 login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		// Admin Login
		driver.get(configFileReader.getAdminUrl()); // Admin login
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.accept_Live_Bid(auctionName, saleno);

		adminDashboardPage.front(); // Open Front End

		// User 2 login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName); // Bid
																		// success
																		// !

		// Admin login

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.sold_Lot_With_out_Accept_Bid(auctionName, saleno);

		adminDashboardPage.select_Bidder(); // Sold Lot to Floor Bidder

	}

	/*
	 * Allow users to send chat messages to clerk/asst. clerk" enabled, but
	 * "Allow all users to see everyone's chat messages" disabled (3.128)
	 */
	// 18
	@Test(dataProvider = "twologinUsers")
	public void User_Chat_Enable(String adminUserName, String adminPassword, String UName, String password,
			String UName1, String password1) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.userChatEnable();

		String auctionName = adminDashboardPage.createNewLiveAuction(saleno); // create
		// new
		// auction

		String lotName = adminDashboardPage.addLot(2); // Bidding

		adminDashboardPage.approveBidder1_2(); // Approve both bidder
		adminDashboardPage.runLiveAuctionChat();// messaeg write

		// adminDashboardPage.runlivesale(); // run live sale
		adminDashboardPage.front();

		// user 1 login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.placebidonliveauctionchat_Enable(saleno, auctionName, lotName); // Admin
																						// chat
																						// message
																						// displays.

		// User 2 login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);
		dashboardPage.placebidonliveauctionchat_Enable1(saleno, auctionName, lotName); // Admin
																						// chat
																						// message
																						// displays

	}

	/**
	 * accept and fair warning and accept and sell
	 * 
	 **/
	// 19
	@Test(dataProvider = "twologinUsers")
	public void Accept_and_Fair_Warning_and_Sell(String adminUserName, String adminPassword, String UName,
			String password, String UName1, String password1)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auctionName = adminDashboardPage.createNewLiveAuction(saleno);

		String lotName = adminDashboardPage.addLot(1); // Bidding
														// Run
														// Live
														// Auction
		adminDashboardPage.approveBidder1_2();

		adminDashboardPage.start_Auction();
		adminDashboardPage.front(); // Open Front End
									// Bidding
									// Run
									// Live*/

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.accept_Live_Bid(auctionName, saleno);

		adminDashboardPage.verify_Asking_Bid();

		adminDashboardPage.fairWarning();
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
	 * Stop sale with two bidders
	 * 
	 */
	// 20
	@Test(dataProvider = "twologinUsers")
	public void Stop_Sale_With_Two_Bidders(String adminUserName, String adminPassword, String UName, String password,
			String UName1, String password1) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auctionName = adminDashboardPage.createNewLiveAuction(saleno); // create
		// new
		// auction

		String lotName = adminDashboardPage.addLot(3); // Bidding
		adminDashboardPage.approveBidder1_2(); // Approve both bidder
		adminDashboardPage.start_Auction();
		adminDashboardPage.front(); // Open Front End
		// Bidding
		// Run
		// Live*/

		// user 1 login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.liveSaletab_Bid_Buttonenable(saleno, auctionName);

		// User 2 login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);
		dashboardPage.liveSaletab_Bid_ButtonEnable1(saleno, auctionName); // it
																			// display
																			// message
		// "someone else was faster!!"

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.stopBiddingRunLiveAuction(auctionName, saleno, UName);

		adminDashboardPage.front();

		// user 1 login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.liveSaletab_Bid_ButtonDisable(saleno, auctionName);

		// User 2 login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);
		dashboardPage.liveSaletab_Bid_ButtonDisable(saleno, auctionName); // it
																			// display
																			// message
		// "someone else was faster!!"

	}

	/**
	 * Undo after placing absentee 3.162
	 */
	// 21

	@Test(dataProvider = "createauction")
	public void Undo_After_Placing_Bid(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.confirmMultipleTimedAndLiveAbsenteebids();

		String auctionName = adminDashboardPage.createNewLiveAuction(saleno); // create
		// new
		// auction
		String lotName = adminDashboardPage.addLotRandom(1);
		String lotName1 = adminDashboardPage.addLotRandom(1);
		String lotName2 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1_2(); // Approve both bidder
		adminDashboardPage.start_Auction();
		adminDashboardPage.front(); // Open Front End
		// Bidding
		// Run
		// Live*/

		// user 1 login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);
		driver.get(configFileReader.getAdminUrl());

		// Goto Admin Side

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.undo_After_Placing_Absentee_Bid(saleno); // Click on
																	// undo
		// last
		// action button.

	}

	/**
	 * Undo after placing with auto accept (3.163)
	 * 
	 */
	// 22
	@Test(dataProvider = "createauction")
	public void Undo_After_Placing_With_Auto_Accept(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auctionName = adminDashboardPage.createNewLiveAuction(saleno); // create
		// new
		// auction
		System.out.println("Step :: auction Name s :" + auctionName);
		common.log("<br></br> Step :: auction Name s :" + auctionName);
		adminDashboardPage.addLotRandom(2);

		adminDashboardPage.approveBidder1_2(); // Approve both bidder
		// adminDashboardPage.Online_Bid_Auto_Accept(); // Bidding

		adminDashboardPage.auto_Accept_Bid_Online_TwoBrowser(auctionName, saleno);
		adminDashboardPage.front(); // Open Front End

		// // user 1 login
		// loginPage = indexPage.clickOnLoginLink(); // click on login link
		// dashboardPage = loginPage.loginUser(UName, password);
		// dashboardPage.LiveSaletab_bid_buttonAccepted(saleno, auctionName);
		//
		// driver.get(configFileReader.getAdminUrl());
		// adminDashboardPage = indexPage // Admin Signin
		// .adminSignin(adminUserName, adminPassword);
		// adminDashboardPage.undoBiddingrunliveAuction_auto_Accept(auctionName,
		// saleno, UName);
		//
		// adminDashboardPage.front();
		//
		// loginPage = indexPage.clickOnLoginLink(); // click on login link
		// dashboardPage = loginPage.loginUser(UName, password);
		// dashboardPage.LiveSaletab_bid_button_after_undo(saleno, auctionName);

	}

	/**
	 * as a bidder, place an absentee bid on lot Z from the watchlist page (3.158)
	 * 
	 */
	// 23

	@Test(dataProvider = "twologinUsers")
	public void Place_an_Absentee_Bid_on_Lot_Z_From_Watch_List_Page(String adminUserName, String adminPassword,
			String UName, String password, String Uname1, String password1)
			throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auctionName = adminDashboardPage.createNewLiveAuction(saleno);
		System.out.println("Step :: auction Name s :" + auctionName);
		common.log("<br></br> Step :: auction Name s :" + auctionName);
//		adminDashboardPage.Auction_Bids_Setting_for_v_Three_one();

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);
		String lotname2 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1_2(); // Approve both bidder
		adminDashboardPage.front(); // Open Front End
									// Bidding
									// Run
									// Live*/

		// User 1
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.bid_From_WatchList(saleno, auctionName, lotname); // Bid
																		// From
																		// watchlist
																		// page

		// Admin login

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.postFloorAutoIncrement(auctionName, saleno); // Admin
																		// start
																		// auction
																		// and
																		// accept
																		// absentee
																		// bid

	}

	/**
	 * absentee against online (3.161)
	 * 
	 */
	// 24
	@Test(dataProvider = "twologinUsers")
	public void Absentee_Against_Online(String adminUserName, String adminPassword, String UName, String password,
			String Uname1, String password1) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auctionName = adminDashboardPage.createNewLiveAuction(saleno);

		String lotName = adminDashboardPage.addLot(1);
		String lotName1 = adminDashboardPage.addLot(1);// Bidding
		// Run
		// Live
		// Auction
		adminDashboardPage.approveBidder1_2(); // Approve both bidder

		adminDashboardPage.verify_Absentee_Against_Online_Feature(auctionName, lotName, saleno); // Verify

	}

	/**
	 * 
	 * User chat disable (3.190) (the clerking style is set to advanced)
	 * 
	 */
	// 25
	@Test(dataProvider = "twologinUsers")
	public void User_Chat_Disable_Advance(String adminUserName, String adminPassword, String UName, String password,
			String UName1, String password1) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.userChatDisable();

		String auctionName = adminDashboardPage.create_Live_Auction_Advance(saleno);

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
	 * Allow users to send chat messages to clerk/asst. clerk" enabled, but Allow
	 * all users to see everyone's chat messages" disabled (3.191)
	 */
	// 26
	@Test(dataProvider = "twologinUsers")
	public void User_Chat_Enable_Advance(String adminUserName, String adminPassword, String UName, String password,
			String UName1, String password1) throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.userChatEnable_advance();

		String auctionName = adminDashboardPage.create_Live_Auction_Advance(saleno); // Clearking
		// Style
		// Advance

		String lotName = adminDashboardPage.addLot(2); // Bidding
		adminDashboardPage.approveBidder1_2(); // Approve both bidder

		adminDashboardPage.runLiveAuctionChat();// messaeg write

		// adminDashboardPage.runlivesale(); // run live sale
		adminDashboardPage.front();

		// user 1 login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.placebidonliveauctionchat_Enable(saleno, auctionName, lotName); // Admin
																						// chat
																						// message
																						// displays.

		// User 2 login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);
		dashboardPage.placebidonliveauctionchat_Enable1(saleno, auctionName, lotName); // Admin
																						// chat
																						// message
																						// displays

	}

	/*
	 * pause and restart auction with two user
	 */
	// 27
	@Test(dataProvider = "twologinUsers")
	public void Pause_and_Restart_With_Two_User(String adminUserName, String adminPassword, String UName,
			String password, String UName1, String password1)
			throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auctionName = adminDashboardPage.createNewLiveAuction(saleno);
		System.out.println("Step :: auction Name s :" + auctionName);
		common.log("<br></br> Step :: auction Name s :" + auctionName);
		String lotName = adminDashboardPage.addLotRandomForUser(1); // Bidding
		String lotName1 = adminDashboardPage.addLotRandomForUser(1); // Run
		String lotName2 = adminDashboardPage.addLotRandomForUser(1); // Live
		// Auction

		adminDashboardPage.approveBidder1_2(); // Approve both bidder
		adminDashboardPage.start_Auction();
		adminDashboardPage.front(); // Goto Front end

		// User 1 Login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.verifyLiveSaletab(saleno, auctionName); // Verify Livesale
																// Tab

		// User 2 Login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);
		dashboardPage.verifyLiveSaleTab1(saleno, auctionName); // Verify Livesale
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

		// User 2 Login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);
		dashboardPage.verifyLiveSaleTabNotDisplay(saleno, auctionName);// Live
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

		// User 2 Login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);
		dashboardPage.verifyLiveSaleTab1(saleno, auctionName); // Live sale tab
																// displays

	}

	/**
	 * Start Lot post bids and reset with two users
	 */
	// 28
	@Test(dataProvider = "twologinUsers")
	public void Start_Lot_Post_Bids_and_Reset_With_Two_User(String adminUserName, String adminPassword, String UName,
			String password, String UName1, String password1)
			throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auctionName = adminDashboardPage.createNewLiveAuction(saleno);

		String lotName = adminDashboardPage.addLot(2); // Bidding
														// Run
														// Live
														// Auction
		adminDashboardPage.approveBidder1_2(); // Approve both bidder

		adminDashboardPage.start_Auction();
		adminDashboardPage.front(); // Open Front End
									// Bidding
									// Run
									// Live*/

		// user 1 login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.accept_Live_Bid(auctionName, saleno);

		adminDashboardPage.front();

		// User 2

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl());

		// Goto Admin Side

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.undo_After_Placing_Absentee_Bid(saleno); // Click on
																	// undo
		// last
		// action button.

	}

	/**
	 * as a bidder, place an absentee bid on lot Z from the watchlist page >>
	 * Advance (3.221)
	 * 
	 */
	// 29
	@Test(dataProvider = "twologinUsers")
	public void Place_an_Absentee_Bid_on_Lot_Z_From_Watch_List_Page_Advance(String adminUserName, String adminPassword,
			String UName, String password, String Uname1, String password1)
			throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auctionName = adminDashboardPage.create_Live_Auction_Advance(saleno); // Clearking
		// Style
		// Advance

		String lotName = adminDashboardPage.biddingRunLiveAuctionNotStart(); // Bidding
		// Run
		// Live
		// Auction
		adminDashboardPage.approveBidder1_2(); // Approve both bidder

		adminDashboardPage.front(); // Open Front End
									// Bidding
									// Run
									// Live*/

		// User 1
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.bid_From_WatchList(saleno, auctionName, lotName); // Bid
																		// From
																		// watchlist
																		// page

		// Admin login

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.accept_Bid_Start_Auction(auctionName, saleno); // Admin
																			// start
																			// auction
																			// and
																			// accept
																			// absentee
																			// bid

	}

	/**
	 * absentee against online
	 */
	// 30
	@Test(dataProvider = "twologinUsers")
	public void Absentee_Against_Online_Advance(String adminUserName, String adminPassword, String UName,
			String password, String Uname1, String password1)
			throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auctionName = adminDashboardPage.create_Live_Auction_Advance(saleno);

		String lotName = adminDashboardPage.addLot(1);
		String lotName1 = adminDashboardPage.addLot(1);// Bidding
		// Run
		// Live
		// Auction
		adminDashboardPage.approveBidder1_2(); // Approve both bidder

		adminDashboardPage.verify_Absentee_Against_Online_Feature(auctionName, lotName, saleno);

	}

	@DataProvider(name = "createauction")
	public Object[][] getCreateAuction() throws Exception {

		Object[][] retObjectArr = parsecreateauctionCsv();

		return retObjectArr;
	}

	@DataProvider(name = "twologinUsers")
	public Object[][] getTwoUserAuction() throws Exception {

		Object[][] retObjectArr = parseTwoLoginUsersCsv();

		return retObjectArr;
	}
}
