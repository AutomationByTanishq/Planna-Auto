package com.auction.verifications;

import java.awt.AWTException;

import java.text.ParseException;

import org.openqa.selenium.By;

import org.openqa.selenium.InvalidArgumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.auction.init.Common;
import com.auction.init.ConfigFileReader;
import com.auction.init.SeleniumInit;
import com.auction.pages.DashboardPage;

public class SmokeTests extends SeleniumInit {
	// String saleno = null;
	// String auctionName = null;
	String lotName = null;
	String uName = null;
	String bidder2 = "rahulbid";
	String bidder2Pass = "123123a";
	Common common = new Common(driver);
	ConfigFileReader configFileReader = new ConfigFileReader();

	/**
	 * Verify Auction Type Missing
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 * @throws ParseException
	 */
	// 1
	@Test
	public void add_Lot_Manually() throws InterruptedException, AWTException, ParseException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin()); // dev URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		String auctionName = adminDashboardPage.createNewLiveAuction(saleno);
		adminDashboardPage.addLotRandom(1);

	}

	// 2
	@Test
	public void upload_Multiple_Valid_Images() throws InterruptedException, ParseException, AWTException {
		common.log("Feature" + "-" + "UAT"
				+ "\"upload several valid images Feature,TestCase Name: 3.80 upload several valid images Feature.");
		common.log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		 driver.get(configFileReader.getqa_MainAutoAdmin()); // Dev URL
		 common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		String saleno = common.generateRandomNumber1();
		adminDashboardPage.verifyAddMultipleImageLink();

	}

	// 3
	@Test
	public void create_A_New_Test_Auction_CSV() throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin()); // Dev URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.enable_Auction_Fields();
		adminDashboardPage.enable_Inventory_Fields();
		adminDashboardPage.deleteCustomFieldsForLotItem();
		adminDashboardPage.create_Live_Auction(tomorrowDate, "1", saleno);
	}

	// 4
	@Test
	public void create_New_User() throws InterruptedException, ParseException {
		String user = common.generateRandomChars(5);
		driver.get(configFileReader.getqa_MainAutoAdmin());
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminUsersPage = adminDashboardPage.goToUsersPage();
		addUsersPage = adminUsersPage.createAdminNewUser();
		addUsersPage.addUsers(user, "123123a", "123123a");

	}

	// 5
	@Test
	public void find_User_Partial_And_Exact_Search() throws InterruptedException, ParseException, AWTException {
		driver.get(configFileReader.getqa_MainAutoAdmin()); // Dev URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.find_User_Partial_And_Exact_Search();
	}

	// 6
	@Test
	public void find_User_Using_The_Usetype_Filter_Bidder() throws InterruptedException, ParseException, AWTException {
		driver.get(configFileReader.getqa_MainAutoAdmin()); // dev URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.find_User_Using_Filter_Bidder();
	}

	// 7
	@Test
	public void edit_User() throws InterruptedException, ParseException, AWTException {
		driver.get(configFileReader.getqa_MainAutoAdmin()); // Dev URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.edit_User();
	}

	// 8
	@Test
	public void modify_User_Profile() throws InterruptedException, ParseException, AWTException {
		
		driver.get(configFileReader.getqa_MainAutoAdmin()); // dev URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		
		adminDashboardPage.modify_User_Profile();
	}

	// 9
	
	@Test
	public void create_A_New_Item_In_The_Inventory_And_Assign_It_To_The_Auction()
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Dev URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		String name = common.generateRandomChars(5);
		adminDashboardPage.enable_Auction_Fields();
		adminDashboardPage.enable_Inventory_Fields();
		String lotname = adminDashboardPage.verifyAddItemtoTheInventeryCat5();
		adminDashboardPage.create_Live_Auction(name);
		adminDashboardPage.verify_New_Created_Item_Assigned_To_Auction(lotname);

	}

//10
	@Test
	public void group_Choice_Lots() throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Dev URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		String name = common.generateRandomChars(5);
		String saleno = common.generateRandomNumber1();
		adminDashboardPage.create_Live_Auction(name);
		adminDashboardPage.addlotrandom2(2);
		adminDashboardPage.verify_Group_Choice_Lots();

	}

	// 11
	@Test
	public void user_Not_Logged_In_Accessible_Informations() throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getqa_MainAutoFront());
		common.installation_URL();
		dashboardPage = new DashboardPage(driver);
		dashboardPage.verify_User_Not_Logged_In_Accessible_Informations();

	}

	// 12
	@Test(dataProvider = "regularsignup")
	public void regular_Signup(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {
		common.log("<br></br>Feature" + "-" + "UAT" + "\"Regular SignUp Feature,TestCase Name: 1.2 RegularSignUp");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"Regular SignUp Feature,TestCase Name: 1.2 RegularSignUp");
		System.out.println("-----------------------------------------------------------------------------------");
		common.log("<br></br> Step :: Enter the URL in browser address bar and hit enter.");

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		driver.get(configFileReader.getqa_MainAutoAdmin()); // Dev URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.delete_Custom_Field();
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.verifyCheckedCheckboxOnRegistrationSettingsForRegularSignup(); // Verify
		// Checked
		// Check
		// box
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
		signupPage.signup_Success_Message(); // Verify Success Message
		driver.quit();
	}

	// 13
	@Test(dataProvider = "regularsignup")
	public void signup_From_Auctions_Page(String adminUserName, String adminPassword)
			throws InterruptedException, AWTException, ParseException {
		common.log("<br></br>Feature" + "-" + "UAT" + "\"Regular SignUp Feature,TestCase Name: 1.2 RegularSignUp");
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("Feature" + "-" + "UAT" + "\"Regular SignUp Feature,TestCase Name: 1.2 RegularSignUp");
		System.out.println("-----------------------------------------------------------------------------------");
		common.log("<br></br> Step :: Enter the URL in browser address bar and hit enter.");

		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Dev URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.delete_Custom_Field();
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
	
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
		//loginPage = indexPage.clickOnLoginLink(); // click on login link
		//dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		dashboardPage = new DashboardPage(driver);
		dashboardPage.Click_login_to_bid();
		signupPage.regularSignUp(FirstName, LastName, EmailUser, signUpUser); // Regular
		// Sign
		// Up

		driver.quit();

	}

	// 14
	@Test
	public void login_From_Homepage() throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getqa_MainAutoFront());
		common.installation_URL();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");

	}

	// 15
	@Test
	public void login_From_Auctions_Page() throws InterruptedException, ParseException, AWTException {
		
		driver.get(configFileReader.getqa_MainAutoFront());
		common.installation_URL();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verifyLoginPageElements();
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		dashboardPage.Click_login_to_bid();
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
	}

	// 16
	@Test
	public void view_Upcoming_Auctions() throws InterruptedException, ParseException, AWTException {
		
		driver.get(configFileReader.getqa_MainAutoFront());
		common.installation_URL();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		dashboardPage.verify_Auctions();
	}

	// 17
	@Test
	public void go_Into_An_Auction() throws InterruptedException, ParseException, AWTException {
		driver.get(configFileReader.getqa_MainAutoAdmin()); // Dev URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.landing_Page_Check_Auctions_Checkbox();
		adminDashboardPage.front();
		driver.get(configFileReader.getqa_MainAutoFront());
		common.installation_URL();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		dashboardPage.go_Into_An_Auction();

	}


	// 18
	@Test
	public void absentee_Bids_Not_Possible_If_Registration_Not_Approved_Yet()
			throws InterruptedException, ParseException, AWTException {
		
		driver.get(configFileReader.getqa_MainAutoAdmin()); // Dev URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		String name = common.generateRandomChars(6);
		adminDashboardPage.create_Live_Auction(name);
		adminDashboardPage.addLotRandom(1);
		adminDashboardPage.register_Bidder();
		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		dashboardPage.verify_Absentee_Bids_Not_Possible_If_Registration_Not_Approved_Yet(name);
	}

	

	// 19
	@Test
	public void absentee_Bids_Ok_After_Bidder_Is_Approved_By_Admin()
			throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		common.installation_URL();
		driver.get(configFileReader.getqa_MainAutoAdmin());
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.timed_Online_Auction_Force_Bid_Disable();
		adminDashboardPage.disable_Inline_Confirm_Multiple_Checkbox();
		String timedauction = adminDashboardPage.create_TimedAuction_5_Minute(saleno);

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1(); // Approve Bidder

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		dashboardPage.place_TimedBid_Lotdetails(timedauction, lotname); // Place
																		// Bid
																// From
																		// Lot
																		// Details
	}

	

	// 20
	@Test
	public void accept_Floor_Bids() throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin()); // Dev URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.clerking_UI_Additional_Info_On_Online_Bid_Button();
		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); // Create
		// Auction
		adminDashboardPage.approveBidder1(); // Approve both bidder

		String lotname = adminDashboardPage.addLotRandom(1); // User 1

		adminDashboardPage.start_Auction();
		adminDashboardPage.accept_Floor_Bids_With_click_On_Post_Floor(saleno); 
	}

	// 21
	@Test
	public void accept_Online_Bids() throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin()); // Dev URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); // Clearking
		// Style
		// Advance
		adminDashboardPage.approveBidder1(); // approve bidder
		String lotname1 = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.start_Auction(); // Start Auction

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.accept_Live_Bid(auctionName, saleno);

		adminDashboardPage.verify_Asking_Bid();
	}

	// 22
	@Test
	public void absentee_Bids_Are_Correctly_Placed_During_Auction()
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin()); // Dev URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); // Clearking
		// Style
		// Advance
		adminDashboardPage.approveBidder1(); // approve bidder
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		dashboardPage.verify_Absentee_Bids_Are_Correctly_Placed(auctionName, lotname1);
	}

	// 23
	@Test
	public void sell_Lot() throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		common.log("Feature" + "-" + "UAT"
				+ "\"accept and fair warning and accept and sell Feature,TestCase Name: 3.184 accept and fair warning and accept and sell Feature.");
		common.log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin()); // Dev URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.clerking_UI_Additional_Info_On_Online_Bid_Button();
		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); // Clearking
		// Style
		// Advance
		adminDashboardPage.approveBidder1(); // approve bidder
		String lotname1 = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.start_Auction(); // Start Auction

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);
		driver.get(configFileReader.getqa_MainAutoAdmin());
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.post_Floor_And_Sell_Lot(auctionName, saleno);
	}

	// 24
	@Test
	public void sell_Lot_With_Accept_Online_Bid() throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();

		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin()); // Dev URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); // Clearking
		// Style
		// Advance
		adminDashboardPage.approveBidder1(); // approve bidder
		String lotname1 = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.start_Auction(); // Start Auction

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getqa_MainAutoAdmin());
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.accept_Online_Bid_And_Sell_Lot(auctionName, saleno);

	}

	// 25
	@Test
	public void pass_Lot() throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Dev URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder
		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.start_Auction();

		adminDashboardPage.front(); // Open Front End
			
		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getqa_MainAutoAdmin());
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.accept_And_Pass_Feature(auctionName, saleno);

	}

	// 26
	@Test
	public void skip_Lots() throws InterruptedException, ParseException, AWTException {


		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Dev URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder
		adminDashboardPage.addLotRandom(3);
		adminDashboardPage.start_Auction();

		adminDashboardPage.verify_Skip_Lot();

	}

	// 27
	@Test
	public void go_To_Next_Lot() throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Dev URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder
		adminDashboardPage.addLotRandom(3);
		adminDashboardPage.start_Auction();

		adminDashboardPage.nextLot();

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		dashboardPage.verify_bidding_console(saleno, auctionName);

	}

	// 28
	@Test
	public void go_To_Previous_Lot() throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Dev URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder
		adminDashboardPage.addLotRandom(4);
		adminDashboardPage.start_Auction();

		adminDashboardPage.previousLot();

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		dashboardPage.verify_bidding_console(saleno, auctionName);

	}

	
	// 29
	@Test
	public void sell_Group_Choice_Lot() throws InterruptedException, ParseException, AWTException {


		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Dev URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder
		adminDashboardPage.addLotRandom(3);
		adminDashboardPage.start_Auction();
		adminDashboardPage.verify_Group_Choice_Lots();
		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getqa_MainAutoAdmin());
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.accept_Online_Bid_And_Sell_Lot(auctionName, saleno);

		adminDashboardPage.verify_Waiting_Message_Both_Side(auctionName);

	}

	// 30
	@Test
	public void view_Upcoming_Lots_Details() throws InterruptedException, ParseException, AWTException {

		
		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Dev URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder
		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.start_Auction();

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);
		dashboardPage.verify_Upcoming_Lot_list_And_Select_One_From_That();

	}

	// 31
	@Test
	public void check_Absentee_Bids() throws InterruptedException, ParseException, AWTException {

	

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Dev URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder
		adminDashboardPage.addLotRandom(1);
		adminDashboardPage.start_Auction();

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Dev URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.verify_Absentee_Bid(saleno);

	}

	// 32
	@Test
	public void remove_Bidder_From_Auction() throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Dev URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder
		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.start_Auction();

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Dev URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.remove_bidder_from_auction(saleno);

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		dashboardPage.verify_Removed_Bidder(saleno, auctionName);

	}
	
	// 33
	@Test

	public void quick_Edit_Lot_Details() throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();
		String name = common.generateRandomChars(6);
		String lotname = common.generateRandomChars(6);

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Dev URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.create_Timed_Auction(saleno);
		adminDashboardPage.add_Lot_With_Required_Data(lotname);
		adminDashboardPage.quick_Edit_Lot_Number();

	}

	// 34
	@Test

	public void verify_Clone_Lot() throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();
		String name = common.generateRandomChars(6);
		String lotname = common.generateRandomChars(6);

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Dev URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.timed_Auction_With_Publish(saleno, name);
		adminDashboardPage.add_Lot_With_Required_Data(lotname);
		adminDashboardPage.clone_Lot_For_Timed_Sale(name);

	}

	// 35
	@Test

	public void verify_Delete_Lot() throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();
		String name = common.generateRandomChars(6);
		String lotname = common.generateRandomChars(6);

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Dev URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.timed_Auction_With_Publish(saleno, name);
		adminDashboardPage.add_Lot_With_Required_Data(lotname);
		adminDashboardPage.delete_Lot();

	}

	// 36
	@Test

	public void verify_Add_New_Bidder() throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();
		String name = common.generateRandomChars(6);
		String lotname = common.generateRandomChars(6);

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Dev URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.timed_Auction_With_Publish(saleno, name);
		adminDashboardPage.add_Lot_With_Required_Data(lotname);
		adminDashboardPage.enter_All_Valid_Info();

	}

	// 37

	@Test
	public void verify_Remove_Checked_Bidder() throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();
		String name = common.generateRandomChars(6);
		String lotname = common.generateRandomChars(6);

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Dev URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.timed_Auction_With_Publish(saleno, name);
		adminDashboardPage.add_Lot_With_Required_Data(lotname);
		adminDashboardPage.enter_All_Valid_Info();
		adminDashboardPage.remove_Checked_Bidder();
	}

	// 38
	@Test

	public void verify_Email_Checked_Users() throws InterruptedException, ParseException, AWTException {

		String usname = common.generateRandomChars(6);
		String randomEmail = common.generateRandomChars(6);

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Dev URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.createUserWithEmailUsername(usname, randomEmail);
		adminDashboardPage.search_User_And_Email_User(usname);

	}

	// 39
	@Test

	public void verify_Import_User_Through_CSV() throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Dev URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		String url = adminDashboardPage.editAuction();
		adminDashboardPage.import_User_Through_CSV_Bidder_Page(url);
	}

	// 40
	@Test
	public void change_Bidder_Number() throws InterruptedException, ParseException, AWTException {

		String usname = common.generateRandomChars(6);
		String saleno = common.generateRandomNumber1();
		String name = common.generateRandomChars(6);
		
		driver.get(configFileReader.getqa_MainAutoAdmin()); // Dev URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.createUserWithUsername(usname);
		adminDashboardPage.timed_Auction_With_Publish(saleno, name);
		adminDashboardPage.register_And_Approve_New_Bidder(usname);
		adminDashboardPage.update_Bidder_Number();
	}
	
	//41
	@Test
	public void group_Lots_As_Group_Qty() throws ParseException, InterruptedException, AWTException {
		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Dev URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.approveBidder1(); // approve bidder
		adminDashboardPage.addLotRandom(3);
		adminDashboardPage.lot_Group_Qty();		
		
	}
	//42
	@Test
		public void sell_Group_Quantity_Lots() throws ParseException, InterruptedException, AWTException {
			String saleno = common.generateRandomNumber1();
			String tomorrowDate = common.tomorrowDate();

			driver.get(configFileReader.getqa_MainAutoAdmin()); // Dev URL
			common.installation_URL();
			adminDashboardPage = indexPage // Admin Signin
					.adminSignin("admin", "123123");
			adminDashboardPage.clerking_UI_Additional_Info_On_Online_Bid_Button();
			String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
			adminDashboardPage.approveBidder1(); // approve bidder
			adminDashboardPage.addLotRandom(3);
			adminDashboardPage.lot_Group_Qty();		
			adminDashboardPage.sell_Group_Qty_Lots();
			
		}

	
	

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
