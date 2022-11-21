package com.auction.verifications;

import java.awt.AWTException;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.auction.init.Common;
import com.auction.init.ConfigFileReader;
import com.auction.init.SeleniumInit;
import com.auction.pages.DashboardPage;

public class HybridAuction extends SeleniumInit {

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
	public void verify_Auction_Type_Missing(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 8.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin()); //Admin URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyAuctionTypeMissing(Name);

	}

	/**
	 * Verify Start date Missing
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void verify_Start_Closing_Date_Missing(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"Create Start date missing Feature,TestCase Name:  8.2 Start date missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verify_Start_Date_Closing_Missing_Hybrid();

	}

	/**
	 * Verify Allow bidding console access date missing
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void verify_Bidding_Console_Date_Missing(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"Create Start date missing Feature,TestCase Name: 8.3 Bidding Console date missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verify_Bidding_Console_Date_Missing_Hybrid();

	}

	/**
	 * Create Auction
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void verify_Create_Auction(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT" + "\"Create New Auction Feature,TestCase Name: 8.4 Create New  Auction Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.create_Hybrid_Auction(saleno); // Select
															// Start
															// Date in
															// past

	}

	/**
	 * Start Date in the Past
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void verify_Create_Auction_Start_Date_Past(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"Create New Auction Feature,TestCase Name: 8.5 Create New  Auction With Start Date in the Past.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.create_Hybrid_Auction_Past_Date(saleno); // Select
																	// Start
																	// Date in
																	// past

	}

	/**
	 * Start Date in the Past
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void verify_Create_Auction_Start_Date_Past_Console(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"Create New Auction Feature,TestCase Name: 8.6 Create New  Auction With Start Date in the Past and console date past.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.create_Hybrid_Auction_Past_Date_Console(saleno); // Select
																			// Start
																			// Date
																			// in
																			// past
																			// and
																			// console
																			// date
																			// start
																			// +
																			// 1

	}

	/**
	 * Do not enter sale number
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void verify_Create_Hybrid_Auction_with_Sale_Number(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT" + "\"Create New Auction Feature,TestCase Name: 8.7 Do not Enter Sale Number.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.create_Hybrid_Auction_With_Sale_Number(saleno);

	}

	/**
	 * Do not enter sale number
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void enter_Invalid_Sale_Number(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT" + "\"Create New Auction Feature,TestCase Name: 8.8 Enter invalid Sale Number.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.create_Hybrid_Auction_Invalid_Saleno();

	}

	/**
	 * Console Date earlier than start date
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void verify_Console_Date_Earlier_Then_Start_Date(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		log("Feature" + "-" + "UAT"
				+ "\"Create New Auction Feature,TestCase Name: 8.9 Create New  Auction With Console date is earlier than start date.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verify_Console_Date_Earlier_Than_Start_Date(saleno); // Select
																				// Start
																				// Date
																				// in
																				// past
																				// and
																				// console
																				// date
																				// start
																				// +
																				// 1

	}

	/**
	 * Create Auction
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void create_Auction_All_Fields(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"Create New Auction Feature,TestCase Name: 8.10 Create New  Auction Feature with all fields fill out.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.enable_Auction_Fields();
		adminDashboardPage.create_Hybrid_Auction_With_All_Fields(saleno); // Auction created

	}

	/**
	 * Enter a Description with special characters
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void enter_Description_With_Special_Characters(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"TestCase Name: 8.12 Enter Description with special characters Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verify_Description_With_Special_Characters_Hybrid(); // Description
		// with special
		// characters.
	}


	/**
	 * Enter enter a text with special characters in terms and condition
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void enter_Text_With_Special_Characters_TandC(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT"
				+ "\"TestCase Name: 8.14 Enter Description with special characters Feature in terms and condition.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verify_Enter_Text_With_Special_Characters_TC_Hybrid(); // Terms
																					// and
																					// condition
		// with special
		// characters.
	}

	/**
	 * Enter a name longer than the max length
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void enter_Sale_Number_Longer_Than_Max_Length(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"TestCase Name: 8.15 enter a name longer than the max length.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verify_Enter_Sale_Number_Longer_Than_The_Max(); // Terms and
																	// condition
		// with special
		// characters.
	}

	/**
	 * Enter a name With Special Characters
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Enter_Name_With_Special_Characters(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"TestCase Name: 8.16 enter a name with special characters.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_Enter_Name_With_Special_Characters(); // Enter
																		// Name
																		// with
																		// special
																		// chatacters
	}

	/**
	 * Upload Picture
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Upload_Picture(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String Sale = common.generateRandomNumber1();
		log("Feature" + "-" + "UAT" + "\"TestCase Name: 8.17 upload a picture save the sale.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionname = adminDashboardPage.verify_Upload_Picture_Hybrid(Sale); // Upload
		// Picture

		adminDashboardPage.front_Hybrid();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verify_Hybrid_Login_Page_Element(); // Verify Login Page
														// Elements
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.verify_Image_Upload_Hybrid(auctionname);
	}

	/**
	 * Do Not Upload Picture
	 * 	
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Do_Not_Upload_Picture(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"TestCase Name: 8.18 Do not upload a picture save the sale.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionname = adminDashboardPage.verify_Do_Not_Upload_Picture_Hybrid(); // Do
																						// Not
																						// Upload
		// Picture

		adminDashboardPage.front_Hybrid();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verify_Hybrid_Login_Page_Element(); // Verify Login Page
														// Elements
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.verify_Do_Not_Upload_Image_Hybrid(auctionname); // Verify
																		// Image
																		// is
																		// not
																		// uploaded

	}

	/**
	 * Upload and change existig picture
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Upload_and_Change_Image(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();

		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\"TestCase Name: 8.19 upload a picture save the sale.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionname = adminDashboardPage.verify_Upload_Picture_Hybrid(saleno); // Upload
		// Picture

		adminDashboardPage.front_Hybrid();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.verify_Image_Upload_Hybrid(auctionname); // Verify Image
																// is uploaded.
		driver.get(configFileReader.getqa_MainAutoAdmin()); 
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verify_Edit_Picture_Hybrid(saleno);

		adminDashboardPage.front_Hybrid();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verify_Hybrid_Login_Page_Element(); // Verify Login Page
														// Elements
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.verify_Updated_Image_Upload_Hybrid(auctionname); // Verify Image
																// is uploaded.

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
		log("Feature" + "-" + "UAT" + "\"TestCase Name: 8.20 Leave checkbox unchecked save Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auctionname = adminDashboardPage.create_Hybrid_Auction_Unpublish(saleno); // Unpublish
																							// Auction
																							// created

		adminDashboardPage.front_Hybrid();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verify_Hybrid_Login_Page_Element(); // Verify Login Page
														// Elements
		dashboardPage = loginPage.loginUser(UName, password); // Login with
																// valid
																// credentials

		dashboardPage.verify_Hybrid_Auction_Not_Present(auctionname);

	}

	/**
	 * Leave checkbox unchecked save
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Auction_Publish(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT" + "\"TestCase Name: 8.21 Publish Auction.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auctionname = adminDashboardPage.create_Hybrid_Auction(saleno); // Auction
																				// created

		// Go to Front End

		adminDashboardPage.front_Hybrid();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verify_Hybrid_Login_Page_Element(); // Verify Login Page
														// Elements
		dashboardPage = loginPage.loginUser(UName, password); // Login with
																// valid
																// credentials

		dashboardPage.verify_Hybrid_Auction_Present(auctionname); // Verify
																	// Auction
																	// is
																	// Present.

	}

	/**
	 * Uncheck the option for an already published auction
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Uncheck_The_Option_For_an_Already_Published_Auction_Hybrid(String adminUserName, String adminPassword,
			String UName, String password) throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"TestCase Name: 8.22 uncheck the option for an already published auction Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);

		adminDashboardPage.front_Hybrid(); // Open Front End
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verify_Hybrid_Login_Page_Element();
		dashboardPage = loginPage.loginUser(UName, password); // Login with
																// valid
																// credentials

		dashboardPage.verify_Hybrid_Auction_Present(auctionName); // Verify
																	// Auction
																	// is
																	// Present.

		driver.get(configFileReader.getqa_MainAutoAdmin()); 

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.unpublishAuction(saleno);

		adminDashboardPage.front_Hybrid();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verify_Hybrid_Login_Page_Element(); // Verify Login Page
														// Elements
		dashboardPage = loginPage.loginUser(UName, password); // Login with
		// valid
		// credentials

		dashboardPage.Verify_Hybrid_Auction_Not_Present1(auctionName); // Verify
																		// Auction
																		// is
																		// not
																		// present.

	}

	/**
	 * Check the option for a previously unpublished auction
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Check_The_Option_For_a_Previously_UnPublished_Auction_Hybrid(String adminUserName, String adminPassword,
			String UName, String password) throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"TestCase Name: 8.23 Check the option for a previously unpublished auction Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auctionname = adminDashboardPage.create_Hybrid_Auction_Unpublish(saleno);

		adminDashboardPage.front_Hybrid(); // Open Front End
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verify_Hybrid_Login_Page_Element(); // Verify Login Page
														// Elements
		dashboardPage = loginPage.loginUser(UName, password); // Login with
		// valid
		// credentials

		dashboardPage.verify_Hybrid_Auction_Not_Present(auctionname); // Verify
																		// Auction
																		// Hybrid
																		// not
		// is
		// present.

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.publishAuction(saleno);

		adminDashboardPage.front_Hybrid(); // Open Front End

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verify_Hybrid_Login_Page_Element(); // Verify Login Page
														// Elements
		dashboardPage = loginPage.loginUser(UName, password); // Login with
		// valid
		// credentials

		dashboardPage.verify_Hybrid_Auction_Present1(auctionname); // Hybrid
																	// Auction
		// present.
	}

	/**
	 * Clone Auction
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Check_Clone_Auction_Hybrid(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"TestCase Name: 8.24 Check the option for a previously unpublished auction Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionname = adminDashboardPage.create_Hybrid_Auction(saleno);

		adminDashboardPage.clone_Auction(auctionname);

	}

	/**
	 * Create Clone Auction
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Create_Clone_Auction_Hybrid(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT" + "\"TestCase Name: 8.25 Create Clone Auction.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionname = adminDashboardPage.create_Hybrid_Auction(saleno);

		adminDashboardPage.create_Clone_Auction(auctionname);

	}

	/**
	 * Edit Auciton and leave blank in lot name
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Edit_Auction_Lot_Name_Blank_Hybrid(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT" + "\"TestCase Name: 8.26 Edit Auciton and leave blank in lot name.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionname = adminDashboardPage.create_Hybrid_Auction(saleno);

		String lotname = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.verify_Lotname_Field_at_Edit(saleno, lotname);

	}

	/**
	 * Edit Auciton and leave blank in lot name
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Edit_Auction_and_Add_Lot_Hybrid(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT" + "\"TestCase Name: 8.27 Edit Auciton and add lot.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionname = adminDashboardPage.create_Hybrid_Auction(saleno);

		adminDashboardPage.verify_Add_Lot_In_Existing_Auction(saleno);

	}

	/**
	 * Verify Create New Lot
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Verify_Create_New_Lot_Hybrid(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Verify Create New Lot Feature,TestCase Name: 8.28 Verify Create New Lot Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String name = adminDashboardPage.create_Hybrid_Auction(saleno);

		String lotname = adminDashboardPage.verify_Add_Lot_For_Hybrid_Auction(); // verify
		// LotAdd
		// LotAdd for time
		// sale
		adminDashboardPage.verify_Hybrid_Lot_Details(saleno, lotname);

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

		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.create_Hybrid_Auction(saleno);

		adminDashboardPage.verify_Lot_Details_With_Erroneous_Values(); // Verify
																		// Lot
																		// Details
	}

	/**
	 * 
	 * Assign one category
	 * 
	 * @throws InterruptedException
	 * 
	 * @throws AWTException
	 * 
	 */

	@Test(dataProvider = "createauction")

	public void Assign_One_Category_Hybrid(String adminUserName, String adminPassword, String UName, String password)

			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"Assign one category Feature,TestCase Name: 8.30 Assign one category Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);

		String lotname = adminDashboardPage.verify_Assign_Category_Hybrid();

		adminDashboardPage.start_Auction_Hybrid();
		adminDashboardPage.front_Hybrid(); // Goto Hybrid Auction Page

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verify_Hybrid_Login_Page_Element(); // Verify Login Page
														// Elements
		dashboardPage = loginPage.loginUser(UName, password); // Login with
		// valid
		// credentials
		dashboardPage.verify_Category_Catalog_Hybrid(auctionName,saleno,lotname);
	}

	/**
	 * assign multiple categories
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Assign_Multiple_Categories_Hybrid(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"assign multiple categories Feature,TestCase Name: 8.31 assign multiple categories Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);

		String lotname = adminDashboardPage.verifyassign_Multiple_Category_Hybrid();
		adminDashboardPage.start_Auction_Hybrid();
		adminDashboardPage.front_Hybrid();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verify_Hybrid_Login_Page_Element();// Verify Login Page
														// Elements
		dashboardPage = loginPage.loginUser(UName, password); // Login with
		// valid
		// credentials
		dashboardPage.verify_Category_Catalog_Hybrid(auctionName,saleno,lotname);

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

		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.addLotRandom(1);

		adminDashboardPage.verify_Existing_Item_Number(saleno);
	}

	/**
	 * Enter an value higher than the allowed max
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Enter_Value_Higher_Than_Max_Hybrid(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"Enter Already exist Item Number Feature,TestCase Name: 8.33 Enter an value higher than the allowed max.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.addLotRandom(1);

		adminDashboardPage.verify_Highr_Than_Max_Number_Hybrid(saleno); // Enter
																		// Higher
																		// than
																		// max
																		// in
																		// item
																		// field.
	}

	/**
	 * Leave Item Number Blank
	 * 
	 * Verify Auto generated No
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Leave_Item_Number_Blank_Hybrid(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"Enter Already exist Item Number Feature,TestCase Name: 8.34 Verify Auto Geerated Item Number.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.addLotRandom(1);

		adminDashboardPage.verify_Auto_Generated_Item_Number_Hybrid(saleno); // Verify
																				// Auto
																				// Generated
																				// Item
																				// Number
	}

	/**
	 * Leave Item Number Blank
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Leave_Item_Number_Blank1_Hybrid(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"Enter Already exist Item Number Feature,TestCase Name: 8.35 Leave item Number Blank .");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.addLotRandom(1);

		adminDashboardPage.Verify_Leave_Item_Number_Hybrid(saleno); // Remove
																	// Item
																	// Number
	}

	/**
	 * Leave Item Number Blank
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Change_Item_Number_Hybrid(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"Enter Already exist Item Number Feature,TestCase Name: 8.36 Change item Number.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.addLotRandom(1);

		adminDashboardPage.verify_Change_Item_Number_Hybrid(saleno); // Change
																		// Item
																		// Number
	}

	/**
	 * Invalid Details in Item Field
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Invalid_Details_In_Item_Number_Hybrid(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"Enter Already exist Item Number Feature,TestCase Name: 8.37 Invalid item Number.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.addLotRandom(1);

		adminDashboardPage.verify_Invalid_Item_Number_Hybrid(saleno); // Verify
																		// Invalid
																		// Item
																		// Number
	}

	/**
	 * Leave Item Number Blank
	 * 
	 * Verify Auto generated No
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Leave_Lot_Number_Blank_Hybrid(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"Enter Already exist Item Number Feature,TestCase Name: 8.38 Verify Auto Geerated Lot Number.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.addLotRandom(1);

		adminDashboardPage.Verify_Auto_Generated_Lot_Number_Hybrid(saleno); // Verify
																			// Auto
																			// Generated
																			// Item
																			// Number
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

		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.addLotRandom(1);

		adminDashboardPage.verify_Existing_Lot_Number(saleno); // Verify
																// Existing
																// Lot
																// Number
	}

	/**
	 * Add a lot in existing auction
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Add_Lot_In_Existing_Auction(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"Enter Already exist Item Number Feature,TestCase Name: 8.40 Enter Already exist Lot Number Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verify_Add_New_lot_Existing_Auction_Hybrid(saleno); // Verify
																				// Add
																				// New
																				// lots
	}

	/**
	 * Invalid Details in Lot Field
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Invalid_Details_In_Lot_Number_Hybrid(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		log("Feature" + "-" + "UAT"
				+ "\"Enter Already exist Item Number Feature,TestCase Name: 8.41 Invalid Lot Number.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.addLotRandom(1);

		adminDashboardPage.verify_Invalid_Lot_Number_Hybrid(saleno); // Verify
																		// Invalid
																		// Lot
																		// Number

	}

	/**
	 * Add Lot Without category
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Add_Lot_Without_Category(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.42 Add Lot Without Category.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);

		String lotname1 = adminDashboardPage.add_Lot_With_Without_Category(1);// Verify
																				// Add
																				// Lot
																				// without
																				// category

	}

	/**
	 * Select one category
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Add_Lot_With_One_Category(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.43 Select One Category.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);

		String lotname = adminDashboardPage.add_Lot_With_Cat2(1);

		adminDashboardPage.front_Hybrid();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.verify_Category_Catalog_Hybrid(auctionName,saleno, lotname);

		dashboardPage.search_Lot_Category(lotname);

	}

	/**
	 * Select one category
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Add_Lot_With_Two_Category(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.44,8.45 Add Lot With Multiple categories.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);

		String lotname = adminDashboardPage.add_lot_with_multiple_category(1);

		adminDashboardPage.front_Hybrid();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.verify_Category_Catalog_Hybrid(auctionName,saleno, lotname);

		dashboardPage.Search_Lot_Category_2_3(lotname);

	}

	/**
	 * Add Lot Without Select Buy Now Checkbox
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Add_Lot_Without_Buy_Now_Checkbox(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.46 Add Lot Without Select Buy Now Checkbox.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);

		String lotname1 = adminDashboardPage.add_Lot_Without_Select_BuyNow_Hybrid(saleno); // Verify
																							// Add
																							// Lot
																							// without
																							// select
																							// Buy
																							// now

		adminDashboardPage.approveBidder1();

		adminDashboardPage.front_Hybrid();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.verify_Buy_Now_Value_Not_Dispaly(auctionName); // Verify
																		// Buy
																		// now
																		// value
																		// not
																		// display
	}

	/**
	 * Add Lot With Buynow check box select
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Add_Lot_With_Buy_Now_Checkbox(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.47 Add Lot With Select Buy Now Checkbox.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);

		String lotname1 = adminDashboardPage.addLot(1);

		adminDashboardPage.approveBidder1();

		adminDashboardPage.front_Hybrid();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.verify_Buy_Now_Value_Dispaly(auctionName); // Verify Buy
																	// Now value
																	// is
																	// display

	}

	/**
	 * Verify Edit an existing auction go to the auction lots tab click on add lot
	 * description: enter a HTML enriched text fill out the other fields
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Verify_Lot_Description_Enriched_Text_Hybrid(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Verify lot description - enriched text Feature,TestCase Name: 8.48 Verify lot description - enriched text Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);
		String lotname1 = adminDashboardPage.add_Lot_Description_For_Hybrid(saleno);

		adminDashboardPage.approveBidder1();
		adminDashboardPage.front_Hybrid();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.verify_Lot_Description_Hybrid(auctionName);

	}

	/**
	 * Specify 2 Working Image Links
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Specify_Two_Working_Image_Links(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Verify lot description - enriched text Feature,TestCase Name: 8.49 Verify lot description - enriched text Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);

		String lotname1 = adminDashboardPage.add_Lot_Description_For_Hybrid(saleno);

		adminDashboardPage.approveBidder1();

		adminDashboardPage.front_Hybrid();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.verify_Lot_Image_Hybrid(auctionName); // Verify Uploaded
																// Image

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
				+ "\"Specify a broken image link Field Feature,TestCase Name: 8.50 Specify a broken image link Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verify_Broken_Image_Link_Hybrid(); // Verify Broken
																// Image link

	}

	/**
	 * Upload several valid images
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Upload_Several_Valid_Images_Hybrid(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"upload several valid images Feature,TestCase Name: 8.51 upload several valid images Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno1 = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionname = adminDashboardPage.create_Hybrid_Auction(saleno1);
		adminDashboardPage.verify_Added_Multiple_Images_Hybrid(); // verfy add
																	// more
																	// image
																	// link for
																	// time
																	// scale

		adminDashboardPage.approveBidder1(); // Approve Bidder

		adminDashboardPage.front_Hybrid();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.verify_Lot_Images_Hybrid(auctionname); // Verify Uploaded
																// Lot
		// Images

	}

	/**
	 * remove existing image link
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Remove_Existing_Imagelink_Hybrid(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"remove existing image link Feature,TestCase Name: 8.52 remove existing image link Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.delete_Image_Link_For_Hybrid(); // delete image link
															// for time scale
	}

	/**
	 * remove existing uploaded image
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Remove_Existing_Uploaded_Image_Hybrid(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"remove existing uploaded image Feature,TestCase Name: 8.53 remove existing uploaded image Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.delete_Image_For_Hybrid();
	}

	/**
	 * remove existing uploaded image
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Upload_Lot_Video_Hybrid(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"remove existing uploaded image Feature,TestCase Name: 8.53 remove existing uploaded image Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verify_Upload_Video_Hybrid(); // Verify Broken
		// Image link();
	}

	/**
	 * Enter the number of an existing lot
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Enter_The_Number_Of_an_Existing_Lot_Hybrid(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Enter the number of an existing lot Feature,TestCase Name: 8.56 Enter the number of an existing lot Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno = common.generateRandomNumber1();
		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);
		String lotname1 = adminDashboardPage.addLot(1);

		adminDashboardPage.verify_Enter_The_Number_Of_Existing_lot_ForHybrid(saleno);

	}

	/**
	 * Change category in lot
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Change_Category_In_Lot(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.57 Change Category.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);
		String lotname1 = adminDashboardPage.addLot(1);

		adminDashboardPage.get_Category(); // Get Lotnumber

		adminDashboardPage.add_Category_In_Lot(saleno); // Verify Edit Lot
														// Number
		adminDashboardPage.get_Category(); // Get Lotnumber

	}

	/**
	 * Add a Category in Lot
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Add_Category_in_Lot(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.58 Add Category.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);
		String lotname1 = adminDashboardPage.lot_Without_Category(1);

		adminDashboardPage.add_Category_In_Lot(saleno); // Verify Edit Lot
														// Number
		adminDashboardPage.get_Category(); // Get Lotnumber

	}

	/**
	 * Change Lot Name
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Change_Lot_Name(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.59 Remove Lot Name.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);
		String lotname1 = adminDashboardPage.addLot(1);

		adminDashboardPage.verify_Change_Lot_Name(saleno); // Verify Remove Lot
															// name
		adminDashboardPage.get_LotName(); // Get Lotname

	}

	/**
	 * Remove Lot Name
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Remove_Lot_Name(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.60 Change Lot Name.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);
		String lotname1 = adminDashboardPage.addLot(1);

		adminDashboardPage.get_LotName(); // Get Lotname

		adminDashboardPage.verify_Remove_Lot_Name(saleno); // Verify Error
															// Message

	}

	/**
	 * Edit Lot Description
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Edit_Lot_Description(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.61 Change Lot Description.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);
		String lotname1 = adminDashboardPage.add_Lot_With_Description();

		adminDashboardPage.verify_Edit_Lot_Description(saleno);

	}

	/**
	 * Edit Lot Description
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Edit_Lot_Terms_And_Condition(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.62 Edit Lot Terms and condition.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);
		String lotname1 = adminDashboardPage.add_Lot_With_SpecialTC();
		adminDashboardPage.approveBidder1_2();

		adminDashboardPage.front_Hybrid();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.verify_Special_Terms(auctionName); // Verify Special TC

		driver.get(configFileReader.getqa_MainAutoAdmin());  // back end

		adminDashboardPage = indexPage.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.edit_Lot_With_SpecialTC(saleno); // Verify edit lot

		adminDashboardPage.front_Hybrid();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.verify_Special_Terms1(auctionName); // Verify Special TC

	}

	/**
	 * Change low est value
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Change_Low_Est_Value_in_Lot(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.63 Change Low Est value.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.get_Lotestvalue(); // Get Lotnumber

		adminDashboardPage.verify_Change_Lot_Est_Value(saleno); // Verify Est
																// Value

		adminDashboardPage.get_Lotestvalue(); // Get Lotnumber

	}

	/**
	 * Change High est value
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Change_High_Est_Value_in_Lot(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.64 Change High Est value.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.get_Lotestvalue(); // Get Lotnumber

		adminDashboardPage.verify_Change_Lot_Est_Value_High(saleno); // Verify
																		// Est
																		// Value

		adminDashboardPage.get_Lotestvalue(); // Get Lotnumber

	}

	/**
	 * Change Starting Bid value
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Change_Starting_Bid_in_Lot(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.65 Change Starting Bid value.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.get_LotStartingBid(); // Get Lotnumber

		adminDashboardPage.verify_Change_Lot_Starting_Bid(saleno); // Verify
																	// Starting
																	// Bid Value

		adminDashboardPage.get_LotStartingBid(); // Get Lotnumber

	}

	/**
	 * Change Lot Reserve Price
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Change_Lot_Reserve_Price(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.65 Change Starting Bid value.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.get_LotReservePrice(); // Get Lotnumber

		adminDashboardPage.verify_Change_Lot_Reserve_Price(saleno); // Verify
																	// Starting
																	// Bid Value

		adminDashboardPage.get_LotReservePrice(); // Get Lotnumber

	}

	/**
	 * Change Lot Status
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Change_Lot_Status(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.65 Change Starting Bid value.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.get_Lot_Status(); // Get Lotnumber

		adminDashboardPage.verify_Change_Lot_Status(saleno); // Verify
																// Starting
																// Bid Value

		adminDashboardPage.get_Lot_Status(); // Get Lotnumber

	}

	/**
	 * Edit Consignor in Lot
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Change_Consignor_in_Lot(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.66 Change Consignor in lot.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);
		String lotname1 = adminDashboardPage.add_Lot_With_Consignor1();

		adminDashboardPage.get_LotConsignor(); // Get Lot Consignor

		adminDashboardPage.verify_Change_Lot_Consignor(saleno); // Verify
																// Starting Bid
																// Value

		adminDashboardPage.get_LotConsignor(); // Get Lot Consignor

	}

	/**
	 * Edit All Fields in Lot
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Edit_All_Fields_in_Lot(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.67 Change Consignor in lot.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);

		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.get_Lot_Details(saleno, lotname1);

		adminDashboardPage.edit_Lot_Details(saleno, lotname1);// Get Lot
																// Consignor

	}

	/**
	 * Edit All Fields in Lot
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Remove_All_Fields_Expect_LotName(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.68 Remove all fields expect lotname.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);

		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.remove_Lot_Details(saleno, lotname1);

	}

	/**
	 * Enter Lot Number in Quick Edit Field
	 *
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Enter_Lot_Number_Quick_Edit(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.69 Search Lot Using Quick edit.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);

		String lotname1 = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.search_Lot_Quick_Edit(saleno);

	}

	/**
	 * Enter the number of a non existing lot in the auction
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Enter_The_Number_Of_an_non_Existing_Lot_In_The_Auction_Hybrid(String adminUserName,
			String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT"
				+ "\"Enter the number of a non existing lot in the auction Feature,TestCase Name: 8.70 Enter the number of a non existing lot in the auction Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno = common.generateRandomNumber1();
		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);
		String lotname1 = adminDashboardPage.addLot(1);

		adminDashboardPage.verify_Enter_The_Number_of_Non_Existing_lot_in_the_Auction_For_Hybrid(); // verify
		// the
		// number
		// of
		// an
		// one
		// exsting
		// lot
		// in
		// the
		// auction
		// for
		// time
		// scale
	}

	/**
	 * Delete Lot
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Delete_Lot_Auction(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.72 Enter valid Email ID.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.addLot(1);
		adminDashboardPage.delete_Lot_From_Auction(saleno); // Delete Lot From
															// Auction

	}

	/**
	 * Enter valid email id
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Enter_Valid_Email_Id(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.72 Enter valid Email ID.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.edit_Hybrid_Auction();

		adminDashboardPage.enter_Valid_Email();

	}

	/**
	 * Enter Blank email id
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Enter_Blank_Email_Id(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.73,8.74 Enter Blank Email ID.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.edit_Hybrid_Auction();

		adminDashboardPage.enter_Blank_Email();

	}

	/**
	 * Enter Wrong Zip With Symbol
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Enter_Wrong_Zip_With_Symbol(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.75,8.76 Enter Wrong Zip With Symbol.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.edit_Hybrid_Auction();

		adminDashboardPage.enter_Wrong_Zip_With_Symbol();

	}

	/**
	 * Enter Wrong CC Number
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Enter_Invalid_CC_Number(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.77,8.78,8.79 Enter Wrong CC Number.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.edit_Hybrid_Auction();

		adminDashboardPage.enter_Wrong_CC_Number();

	}

	/**
	 * Invalid CC Expiration Date
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Enter_Invalid_CC_Expiration_Date(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.80 Enter Invalid CC Expiration Date.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.edit_Hybrid_Auction();

		adminDashboardPage.enter_Invalid_CC_Expiration_Date();

	}

	/**
	 * Enter Valid Info
	 * 
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Enter_valid_All_Info(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.81 Enter Valid Info.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.edit_Hybrid_Auction();

		adminDashboardPage.enter_All_Valid_Info();

	}

	// 8.82 is done in add bidder script.
	/**
	 * Search User By Email
	 * 
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Search_User_By_Email(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.83 Search User By Email.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.edit_Hybrid_Auction();

		adminDashboardPage.search_User_By_Email();
	}

	/**
	 * Edit Lot Number in Existing Auction
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Edit_Lot_Number_Existing_Auction(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.84 Edit Lot Number.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);
		String lotname1 = adminDashboardPage.addLot(1);

		adminDashboardPage.get_LotNumber(); // Get Lotnumber
		adminDashboardPage.approveBidder1();

		adminDashboardPage.verify_Edit_Lot_Number(saleno); // Verify Edit Lot
															// Number
		adminDashboardPage.get_LotNumber(); // Get Lotnumber
		adminDashboardPage.front_Hybrid();

	}

	/**
	 * Enter Lot Number in Quick Edit Field
	 *
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Enter_Wrong_Lot_Number_Quick_Edit(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.85 Enter Wrong lot no in quick edit field.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);

		String lotname1 = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.search_Wrong_Lot_Quick_Edit(saleno);

	}

	/**
	 * Enter Lot Number in Quick Edit Field
	 *
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Enter_Item_Number_Existing_Lot(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.86 Enter Wrong lot no in quick edit field.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);

		String lotname1 = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.search_Existing_Lot_Name_Quick_Edit(saleno);

	}

	/**
	 * Enter Lot Number in Quick Edit Field
	 *
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Enter_Invalid_Item_Number_Existing_Lot(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.87 Enter Wrong lot no in quick edit field.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);

		String lotname1 = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.search_Non_Existing_Lot_Name_Quick_Edit(saleno);

	}

	/**
	 * Verify Winning Bidder
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Verify_Winning_Bidder(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.88 Verify Winning Bidder.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.approveBidder1_2();
		String lotname = adminDashboardPage.addLotRandom(4);

		adminDashboardPage.start_Auction_Hybrid(); // Start Hybrid Auction

		adminDashboardPage.front();

		// User 1
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Hybrid_Auction(auctionName);

		driver.get(configFileReader.getqa_MainAutoAdmin()); 
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.sold_Lot_Hybrid(saleno);

		adminDashboardPage.front();

		// User 2
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);
		dashboardPage.place_Bid_On_Hybrid_Auction1(auctionName);

		driver.get(configFileReader.getqa_MainAutoAdmin()); 
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.sold_Lot_Hybrid(saleno);

		adminDashboardPage.front();

		// User 1
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Hybrid_Auction1(auctionName);

		driver.get(configFileReader.getqa_MainAutoAdmin()); 
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.sold_Lot_Hybrid(saleno);

		adminDashboardPage.front();

		// User 2
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);
		dashboardPage.place_Bid_On_Hybrid_Auction1(auctionName);

		driver.get(configFileReader.getqa_MainAutoAdmin()); 
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.sold_Lot_Hybrid(saleno);

		adminDashboardPage.find_Winner_Bidder(saleno, lotname);

	}

	/**
	 * Verify Consignor
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Verify_Lot_Consignor(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.89 Verify Lot Consignor.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);

		// Add lots with consignor

		String lotname = adminDashboardPage.add_Lot_With_Consignor1();
		String lotname1 = adminDashboardPage.add_Lot_With_Consignor2();
		String lotname2 = adminDashboardPage.add_Lot_with_Consignor3();

		adminDashboardPage.verify_Consignor_In_Lot(saleno);

	}

	/**
	 * Verify Bidder
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Verify_Bidding(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.90 Verify Lot Consignor.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);

		// Add lot

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);
		String lotname2 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1_2();

		adminDashboardPage.front();
		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Absenteebid_Hybrid(saleno, hybridauction, lotname);

		driver.get(configFileReader.getqa_MainAutoAdmin()); 
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.search_Last_Created_Auction(saleno);
		adminDashboardPage.start_Auction_Hybrid();
		adminDashboardPage.front();

		// User 2 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);
		dashboardPage.place_Bid_On_Hybrid_Auction1(hybridauction);

		driver.get(configFileReader.getqa_MainAutoAdmin()); 
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verify_Bidder_In_Lot(saleno);

	}

	/**
	 * Search Category
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Category_Search(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.91 Enter valid Email ID.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);

		// Add lot

		String lotname = adminDashboardPage.add_Lot_With_Cat2(1);
		String lotname1 = adminDashboardPage.add_Lot_With_Cat3(1);

		adminDashboardPage.verify_Lot_Category(); // Verify Lot Category

	}

	/**
	 * Search All Category
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Category_Search_All(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.92 Enter valid Email ID.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);

		// Add lot

		String lotname = adminDashboardPage.add_Lot_With_Cat2(1);
		String lotname1 = adminDashboardPage.add_Lot_With_Cat3(1);

		adminDashboardPage.verify_Lot_Category_All(lotname, lotname1); // Verify
																		// Lot
																		// Category

	}

	/**
	 * Consignor Sort
	 * 
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Consignor_Sort(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.93 Consignor Sort.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno); // Auction
		// created

		// Add Multiple lot with different different consignor

		String addlot1 = adminDashboardPage.add_Lot_With_Consignor();
		String addlot2 = adminDashboardPage.add_Lot_With_Consignor();
		String addlot3 = adminDashboardPage.add_Lot_With_Consignor1();
		String addlot4 = adminDashboardPage.add_Lot_With_Consignor2();

		adminDashboardPage.verify_Consignor_Sort(); // Verify consignor sort

		adminDashboardPage.approveBidder1();

		adminDashboardPage.front_Hybrid();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.goto_Catalog_Page_Hybrid(auctionName);
		dashboardPage.verify_Lot_In_Order();

	}

	/**
	 * Verify Starting Estimate Values
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Verify_Estimate_Values(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.94 Enter valid Email ID.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotname1 = adminDashboardPage.addLot1();

		adminDashboardPage.start_Auction_Hybrid();
		adminDashboardPage.starting_Bid_Estimates(); // Verify values in
														// runlivesale tab

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.goto_Catalog_Page_Hybrid(auctionName);
		dashboardPage.verify_Estimate_Values_Front(auctionName, saleno); // Verify
		// Estimate
		// Values in
		// Livesale
		// tab

	}

	/**
	 * Verify Next Lot Start Automatically
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Next_Lot_Start_Automatically(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name:: 8.95 Next Lot Start Automatically.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotname1 = adminDashboardPage.addLotRandom(3);

		adminDashboardPage.start_Auction_Hybrid();
		adminDashboardPage.lot_Autostart_Enable();
		adminDashboardPage.pass_Lot();

	}

	/**
	 * Start Lot Automatically
	 * 
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Start_Next_Lot_Automatically_Disable_Hybrid(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\" Start next lot automatically disable.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);

		adminDashboardPage.approveBidder1_2(); // approve bidder

		adminDashboardPage.addLotRandom(2);

		adminDashboardPage.start_Auction_Hybrid(); // Start Auction Hybrid

		adminDashboardPage.lot_Autostart_Disable();

		adminDashboardPage.pass_Lot();

		adminDashboardPage.admin_Message_Center(); // admin message center

		adminDashboardPage.start_Second_Lot_Manual(); // Start Second Lot Manual

	}

	/**
	 * validate with Enter
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Validate_With_Enter_Hybrid(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" 8.97 Validate with Enter.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.approveBidder1(); // Approve bider
		String lotname1 = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.start_Auction_Hybrid();
		adminDashboardPage.starting_Bid_Estimates(); // Verify values in
														// runlivesale tab

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.goto_Catalog_Page_Hybrid(auctionName);
		dashboardPage.verify_Starting_Bid_Catalogpage(auctionName, saleno); // Verify
																			// Starting
		// bid

		driver.get(configFileReader.getqa_MainAutoAdmin()); 

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.change_Askingbid_With_Enter_Hybrid(auctionName, saleno, UName);

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.goto_Catalog_Page_Hybrid_Auction(auctionName);
		dashboardPage.verify_Starting_Bid_Message_Center(auctionName, saleno); // Verify
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
	public void Validate_With_Button_Hybrid(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"validate with Enter Feature,TestCase Name : 8.98 validate with button.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);

		adminDashboardPage.approveBidder1(); // Approve bidder
		String lotname1 = adminDashboardPage.addLot1();
		String lotname2 = adminDashboardPage.addLot1();
		adminDashboardPage.start_Auction_Hybrid();
		adminDashboardPage.starting_Bid_Estimates(); // Verify values in
														// runlivesale tab

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.goto_Catalog_Page_Hybrid(auctionName);

		dashboardPage.verify_Starting_Bid_Catalogpage(auctionName, saleno); // Verify
																			// Starting
		// bid

		driver.get(configFileReader.getqa_MainAutoAdmin()); 

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.change_Asking_Bid_Button_Hybrid(auctionName, saleno, UName);

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.goto_Catalog_Page_Hybrid_Auction(auctionName);
		dashboardPage.verify_Starting_Bid_Message_Center(auctionName, saleno); // Verify
																				// new
		// Starting
		// bid

	}

	/**
	 * From_Increment_Column
	 * 
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void From_Increment_Column(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.99  From_Increment_Column.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno); // Auction
		// created

		adminDashboardPage.addLotRandomForUser(3);
		adminDashboardPage.start_Auction_Hybrid();
		adminDashboardPage.increment_Bid();

	}

	// 100 pending...

	/**
	 * Verify post floor and sell
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Post_Floor_And_Sell_Hybrid(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name. 8.101 Accept And Sell Feature");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.setting_Auto_Create_And_Floor_Buyer_Active();
		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.approveBidder1(); // approve bidder

		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.start_Auction_Hybrid();
		adminDashboardPage.sell_Lot_Rahulqa();

		adminDashboardPage.front(); // Open Front End

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

		log("Feature" + "-" + "UAT" + "\"validate with Enter Feature,TestCase Name :: 8.102 accept and undo");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.approveBidder1(); // approve bidder
		adminDashboardPage.addLotRandom(1);
		adminDashboardPage.start_Auction_Hybrid();

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Hybrid_Auction(auctionName);

		driver.get(configFileReader.getqa_MainAutoAdmin()); 

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.accept_And_Undo_Feature_Hybrid(auctionName, saleno);

	}

	/**
	 * Undo after placing absentee
	 */

	@Test(dataProvider = "createauction")
	public void Undo_After_Placing_Bid_Hybrid(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin()); 
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.confirmMultipleTimedAndLiveAbsenteebids();

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno); // create
		// new
		// auction
		String lotName = adminDashboardPage.addLotRandom(1);
		String lotName1 = adminDashboardPage.addLotRandom(1);
		String lotName2 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.approveBidder1_2(); // Approve both bidder
		adminDashboardPage.start_Auction_Hybrid(); // Start Auction
		adminDashboardPage.front(); //

		// user 1 login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Hybrid_Auction(auctionName);
		driver.get(configFileReader.getqa_MainAutoAdmin()); 

		// Goto Admin Side

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.undo_After_Placing_Absentee_Bid_Hybrid(saleno);

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

		log("Feature" + "-" + "UAT" + "\"validate with Enter Feature,TestCase Name: 8.103 accept and pass");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.approveBidder1(); // approve bidder
		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.start_Auction_Hybrid();

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Hybrid_Auction(auctionName);

		driver.get(configFileReader.getqa_MainAutoAdmin()); 

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.accept_And_Pass_Hybrid(auctionName, saleno);
	}

	/**
	 * accept and fair warning and sell
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Accept_and_Fair_Warning_and_Sell(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"validate with Enter Feature,TestCase Name: 8.104 accept and fair");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.approveBidder1(); // approve bidder
		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.start_Auction_Hybrid();

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Hybrid_Auction(auctionName);

		driver.get(configFileReader.getqa_MainAutoAdmin()); 

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.accept_And_Fairwarning_Hybrid(auctionName, saleno);

	}

	/**
	 * Active
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Acitve(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"validate with Enter Feature,TestCase Name: 8.105 Active");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.setting_Auto_Create_Record_Active();

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);

		adminDashboardPage.addLotRandom(2);

		adminDashboardPage.start_Auction_Hybrid();
		String winner_number = adminDashboardPage.post_Floor_Sold_lot_Using_Number_Hybrid();

		adminDashboardPage.verify_Floor_Bidder_User(winner_number);

	}

	/**
	 * Active Floor Buyer
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Acitve_Floor_Buyer(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"validate with Enter Feature,TestCase Name: 8.106 Floor Buyer Active");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.setting_Auto_Create_And_Floor_Buyer_Active();

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);

		adminDashboardPage.addLotRandom(2);

		adminDashboardPage.start_Auction_Hybrid();
		String winner_name = adminDashboardPage.post_Floor_Sold_lot_Using_Name_Hybrid();

		adminDashboardPage.verify_Floor_Bidder_User(winner_name);

	}

	/**
	 * Active Floor Buyer
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Acitve_Floor_Buyer_Disable(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"validate with Enter Feature,TestCase Name: 8.107 Active Floor Buyer Disable");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.auto_Create_Records_For_Non_Existing_Floor_Disable();

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);

		adminDashboardPage.addLotRandom(2);

		adminDashboardPage.start_Auction_Hybrid();
		String winner_no = adminDashboardPage.post_Floor_Sold_lot_Using_Number_Hybrid();

		adminDashboardPage.verify_Floor_bidder_User_Not_Display(winner_no);

	}

	/*
	 * pause and restart auction
	 */

	@Test(dataProvider = "createauction")
	public void Pause_and_Restart(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"validate with Enter Feature,TestCase Name: 8.114 pause and restart auction");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.approveBidder1(); // approve bidder
		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.start_Auction_Hybrid();
		adminDashboardPage.front(); // Open Front End

		// User 1 Login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.verify_Auction_Is_Ongoing(saleno, auctionName); // Verify
																		// Livesale
		// Tab

		driver.get(configFileReader.getqa_MainAutoAdmin()); 
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.bidding_Pause_Auction_Hybrid(saleno); // pause
																	// auction
																	// from
		// admin

		adminDashboardPage.front();

		// User 1 login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.verify_Bidding_Pause_Hybrid(saleno, auctionName); // Live
		// sale
		// tab
		// not
		// display

		driver.get(configFileReader.getqa_MainAutoAdmin()); 
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.bidding_Resume_Auction_Hybrid(saleno); // Resume
																	// auction
																	// from
		// admin side

		adminDashboardPage.front();

		// User 1 Login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.verify_Auction_Is_Ongoing_Or_Not(saleno, auctionName); // Verify
																		// Auction
																		// is
																		// ongoing

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

		log("Feature" + "-" + "UAT" + "\"validate with Enter Feature,TestCase Name: 8.115 Stop sale");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.approveBidder1(); // approve bidder
		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.start_Auction_Hybrid();
		adminDashboardPage.front(); // Open Front End

		// user 1 login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.livesaletab_Bid_Buttonenable_Hybrid(saleno, auctionName);

		driver.get(configFileReader.getqa_MainAutoAdmin()); 

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.stop_Auction_Hybrid(auctionName, saleno, UName);

		adminDashboardPage.front();

		// user 1 login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.verify_Hybrid_Auction_Not_Present(auctionName);

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
				+ "\"start lot, post bids, and reset Feature,TestCase Name: 8.116 start lot, post bids, and reset Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno1 = adminDashboardPage.create_Hybrid_Auction(saleno);

		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.reset_Bidding_Hybrid();

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
		log("Feature" + "-" + "UAT" + "\"test link Feature,TestCase Name: 8.117 test link Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno1 = common.generateRandomNumber1();

		adminDashboardPage.create_Hybrid_Auction(saleno1);
		adminDashboardPage.approveBidder1();

		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.start_Auction_Postfloor();
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
		log("Feature" + "-" + "UAT" + "\"previous lot  Feature,TestCase Name: 8.118 previous lot  Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno1 = common.generateRandomNumber1();
		adminDashboardPage.create_Hybrid_Auction(saleno1);

		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.start_Auction_PostFloor_and_Sold_Lot();
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
		log("Feature" + "-" + "UAT" + "\"Next lot  Feature,TestCase Name: 8.119 Next lot Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno1 = common.generateRandomNumber1();
		adminDashboardPage.create_Hybrid_Auction(saleno1);

		adminDashboardPage.addLotRandom(2);
		adminDashboardPage.start_Auction_PostFloor();
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
		log("Feature" + "-" + "UAT" + "\"content Feature,TestCase Name: 8.120 content Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno1 = common.generateRandomNumber1();
		adminDashboardPage.create_Hybrid_Auction(saleno1);

		adminDashboardPage.addLot(2);
		adminDashboardPage.start_Auction_Hybrid();
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
		log("Feature" + "-" + "UAT" + "\"action Feature,TestCase Name: 8.121 action Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno1 = common.generateRandomNumber1();
		adminDashboardPage.create_Hybrid_Auction(saleno1);

		adminDashboardPage.addLotRandom(2);

		adminDashboardPage.start_Auction_PostFloor_Skiplot();
		// place a few floor and online bids
		adminDashboardPage.skipToLot1();

	}

	/**
	 * Remove Assigned Category
	 *
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Remove_Assign_Category_in_Lot(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.122 Remove Assigned Category.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);
		String lotname1 = adminDashboardPage.verifyassign_Multiple_Category_Hybrid();

		adminDashboardPage.get_Category(); // Get Lotnumber

		adminDashboardPage.remove_Assigned_Category_Lot(saleno);

		adminDashboardPage.get_Category(); // Get Lotnumber

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
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.123 Verify Estimate values in list view.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotname1 = adminDashboardPage.addLot1();

		adminDashboardPage.start_Auction_Hybrid();
		adminDashboardPage.starting_Bid_Estimates(); // Verify values in
														// runlivesale tab

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.goto_Catalog_Page_Hybrid(auctionName);
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
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.124 Verify Place bid from list view.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotname1 = adminDashboardPage.addLot1();
		String lotname2 = adminDashboardPage.addLot1();

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.fill_Place_Bid_List_View(lotname1, auctionName); // Place
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
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.125 Verify Estimate values compact view.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotname1 = adminDashboardPage.addLot1();

		adminDashboardPage.start_Auction_Hybrid();
		adminDashboardPage.starting_Bid_Estimates(); // Verify values in
														// runlivesale tab

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.goto_Catalog_Page_Hybrid(auctionName);
		dashboardPage.verify_Estimate_Values_Front_Compact_View(auctionName, saleno); // Verify
		// Estimate
		// Values in
		// Livesale
		// tab

	}

	/**
	 * Place Bid From compact view
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void PlaceBid_Compact_View(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		log("<br></br>Feature" + "-" + "UAT" + "\"TestCase Name: 8.126 Verify place bid from compact view.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotname1 = adminDashboardPage.addLot1();
		String lotname2 = adminDashboardPage.addLot1();

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.fill_Place_Bid_Compact_View(lotname1, auctionName); // Place
																			// Bid
																			// From
																			// Compact
																			// View

	}

	/**
	 * Save and use new message
	 * 
	 */

	@Test(dataProvider = "twologinUsers")
	public void Save_and_Use_New_Message(String adminUserName, String adminPassword, String UName, String password,
			String UName1, String password1) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"Verify disabled Feature,TestCase Name:  save and use new message.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin()); 
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);

		String lotName = adminDashboardPage.addLotRandom(1);
		adminDashboardPage.approveBidder1_2(); // approve two bidder

		adminDashboardPage.save_And_Use_New_Message_Hybrid();

		adminDashboardPage.front(); // Open Front End

		// user 1 login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.verify_Chat_Message_Hybrid(saleno, auctionName, lotName); // Admin
																				// chat
																				// message
																				// displays.

		// // User 2 login
		//
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);
		dashboardPage.verify_Chat_Message_Hybrid1(saleno, auctionName, lotName); // Admin
																					// chat
																					// message
																					// displays.

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
		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\"regular Feature,TestCase Name:  regular Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno1 = adminDashboardPage.create_Hybrid_Auction(saleno);

		adminDashboardPage.addLot(2);

		adminDashboardPage.start_Auction_Hybrid();
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
		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT" + "\"simplified Feature,TestCase Name: simplified Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno1 = adminDashboardPage.create_Hybrid_Auction(saleno);

		adminDashboardPage.addLot(2);
		adminDashboardPage.start_Auction_Hybrid();
		adminDashboardPage.postFloor();
		adminDashboardPage.projector();
		adminDashboardPage.showInPopUpLink();
	}

	/**
	 * as a bidder, place an absentee bid on lot X from the catalog page with
	 * confirmation advance
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Place_an_Absentee_Bid_On_Lot_x_From_The_Catalog_Page_With_Confirmation(String adminUserName,
			String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Test case Name :  as a bidder, place an absentee bid on lot X from the catalog page with confirmation");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);

		adminDashboardPage.approveBidder1(); // approve bidder
		String lotName = adminDashboardPage.addLotRandom(1);
		String lotName1 = adminDashboardPage.addLotRandom(1);
		String lotName2 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Absenteebid_Hybrid_500(saleno, auctionName, lotName);

		driver.get(configFileReader.getqa_MainAutoAdmin()); 

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.post_Floor_AutoInc_Hybrid(auctionName, saleno);
	}

	/**
	 * as a bidder, place an absentee bid on lot Z from the watchlist page
	 *
	 * 
	 */

	@Test(dataProvider = "twologinUsers")
	public void Place_an_Absentee_Bid_on_Lot_Z_From_Watch_List_Page_Hybrid(String adminUserName, String adminPassword,
			String UName, String password, String Uname1, String password1)
			throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin()); 
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);
		System.out.println("Step :: auction Name s :" + auctionName);
		common.log("<br></br> Step :: auction Name s :" + auctionName);

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandom(1);
		// String lotname2 = adminDashboardPage.addlotrandom(1);

		adminDashboardPage.approveBidder1_2(); // Approve both bidder
		adminDashboardPage.front(); // Open Front End
									// Bidding
									// Run
									// Live*/

		// User 1
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.bid_From_WatchList_Hybrid(saleno, auctionName, lotname); // Bid
		// From
		// watchlist
		// page

		// Admin login

		driver.get(configFileReader.getqa_MainAutoAdmin()); 
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.post_Floor_AutoInc_Hybrid(auctionName, saleno);
	}

	/**
	 * from as a bidder place absentee bids on lots V and W the catalog page with
	 * confirmation
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Place_Absentee_Bids_on_Lot_V_and_W_From_The_Catalog_Page_Hybrid(String adminUserName,
			String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();

		log("Feature" + "-" + "UAT" + "\"as a bidder, place an absentee bid on lot Y from the item details page with "
				+ "confirmation Feature,TestCase Name: as a bidder place absentee bids on lots V and W from the catalog page with confirmation");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.multiBid_Functionality_Enable(); // enable
															// place
															// multiple
		// bid
		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.approveBidder1_2(); // approve bidder

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandomForUser(1);
		String lotname2 = adminDashboardPage.addlotrandom2(1);
		String lotname3 = adminDashboardPage.addLotRandom3(1);

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Absentee_Bid_on_4_Lot_Hybrid(saleno, auctionName, lotname, lotname1, lotname2, lotname3);
		driver.get(configFileReader.getqa_MainAutoAdmin()); 

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.post_Floor_AutoInc_Pass_Lot_Hybrid(auctionName, saleno);
	}

	/**
	 * absentee against online Hybrid
	 * 
	 */

	@Test(dataProvider = "twologinUsers")
	public void Absentee_Against_Online_Hybrid(String adminUserName, String adminPassword, String UName,
			String password, String Uname1, String password1)
			throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin()); 
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);

		String lotName = adminDashboardPage.addLot(1);
		String lotName1 = adminDashboardPage.addLot(1);// Bidding
		// Run
		// Live
		// Auction
		adminDashboardPage.approveBidder1_2(); // Approve both bidder

		adminDashboardPage.verify_Absentee_Against_Online_Feature_Hybrid(auctionName, lotName);

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

		driver.get(configFileReader.getqa_MainAutoAdmin()); 
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.userChatDisable();

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);

		String lotName = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.approveBidder1_2(); // Approve both bidder
		adminDashboardPage.verify_Chat_Message_Hybrid_Admin();// message write

		// adminDashboardPage.runlivesale(); // run live sale
		adminDashboardPage.front();

		// user 1 login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.verify_Chat_Message_Hybrid(saleno, auctionName, lotName); // Admin
		// chat
		// message
		// displays.

		// // User 2 login
		//
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);
		dashboardPage.verify_Chat_Message_Hybrid1(saleno, auctionName, lotName); // Admin
		// chat
		// message
		// displays.
	}

	/**
	 * group items and sell with out select any lot
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Group_Items_and_Sell(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"group items and sell Feature,TestCase Name :: group items and sell Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName1 = adminDashboardPage.addMultipleLot(1);
		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.start_Auction_Hybrid();

		adminDashboardPage.groupChoice_Hybrid_Live(lotName2, lotName3);
		adminDashboardPage.group_item_and_Sell_Hybrid(auctionName,saleno);

	}

	/**
	 * group items and sell select lot 1
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Group_Items_and_Sell_Lot1(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"group items and sell Feature,TestCase Name :: group items and sell Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName1 = adminDashboardPage.addMultipleLot(1);
		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.start_Auction_Hybrid();

		adminDashboardPage.groupChoice_Hybrid_Live(lotName2, lotName3);
		adminDashboardPage.group_item_and_Sell_Lot_Hybrid(saleno, auctionName, lotName1);

	}

	/**
	 * group items and sell select lot 1,2
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Group_Items_and_Sell_Lot_1_2(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"group items and sell Feature,TestCase Name :: group items and sell Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName1 = adminDashboardPage.addMultipleLot(1);
		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.start_Auction_Hybrid();

		adminDashboardPage.groupChoice_Hybrid_Live(lotName2, lotName3);
		adminDashboardPage.group_item_and_Sell_Lot_Hybrid_1_2(saleno, auctionName, lotName1, lotName2);

	}

	/**
	 * group items and sell select lot 1,2,3
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Group_Items_and_Sell_Lot_1_2_3(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"group items and sell Feature,TestCase Name :: group items and sell Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName1 = adminDashboardPage.addMultipleLot(1);
		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.start_Auction_Hybrid();

		adminDashboardPage.groupChoice_Hybrid_Live(lotName2, lotName3);
		adminDashboardPage.group_item_and_Sell_Lot_Hybrid_1_3(saleno, auctionName, lotName1, lotName3);

	}

	/**
	 * group items and Pass select lot 1,2,3
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Group_Items_and_Pass_Lot_1_2_3(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"group items and sell Feature,TestCase Name :: group items and Pass Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName1 = adminDashboardPage.addMultipleLot(1);
		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);
		String lotName4 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.start_Auction_Hybrid();

		adminDashboardPage.groupChoice_Hybrid_Live(lotName2, lotName3);
		adminDashboardPage.group_Item_And_Pass_Lot(saleno, auctionName, lotName1, lotName2);

	}

	/**
	 * group items and Pass select lot 1,2,3
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Group_Items_and_Ungroup_Lot1(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"group items and sell Feature,TestCase Name :: group items and Pass Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName1 = adminDashboardPage.addMultipleLot(1);
		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.start_Auction_Hybrid();

		adminDashboardPage.groupChoice_Hybrid_Live(lotName2, lotName3);
		adminDashboardPage.group_Item_And_Ungroup_Lot1(saleno, auctionName, lotName1, lotName2);

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

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName1 = adminDashboardPage.addMultipleLot(1);
		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);
		String lotName4 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.start_Auction_Hybrid();

		adminDashboardPage.group_All_Four_One_Live_Hybrid(lotName2, lotName3);
		adminDashboardPage.group_All4One(saleno, auctionName, lotName1, lotName3);

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

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName1 = adminDashboardPage.addMultipleLot(1);
		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);
		String lotName4 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.start_Auction_Hybrid();

		adminDashboardPage.group_All_Four_One_Live_Hybrid_Lot_2_4(lotName2, lotName3, lotName4);
		adminDashboardPage.group_All4One(saleno, auctionName, lotName1, lotName3);

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

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName1 = adminDashboardPage.addMultipleLot(1);
		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);
		String lotName4 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.start_Auction_Hybrid();

		adminDashboardPage.group_All_Four_One_Live_Hybrid(lotName2, lotName3);
		adminDashboardPage.group_Item_And_Pass_Lot(saleno, auctionName, lotName1, lotName3);

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

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName1 = adminDashboardPage.addMultipleLot(1);
		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.start_Auction_Hybrid();

		adminDashboardPage.group_All_Four_One_Live_Hybrid(lotName2, lotName3);
		adminDashboardPage.group_Item_And_Ungroup_Lot1(saleno, auctionName, lotName1, lotName2);

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

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName1 = adminDashboardPage.addMultipleLot(1);
		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);
		String lotName4 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.start_Auction_Hybrid();

		adminDashboardPage.group_X_The_Live_Hybrid(lotName2, lotName3);
		adminDashboardPage.group_All4One(saleno, auctionName, lotName1, lotName3);

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

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName1 = adminDashboardPage.addMultipleLot(1);
		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);
		String lotName4 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.start_Auction_Hybrid();

		adminDashboardPage.group_x_Live_Hybrid_Lot_2_4(lotName2, lotName3, lotName4);
		adminDashboardPage.group_All4One(saleno, auctionName, lotName1, lotName3);

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

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName1 = adminDashboardPage.addMultipleLot(1);
		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);
		String lotName4 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.start_Auction_Hybrid();

		adminDashboardPage.group_X_The_Live_Hybrid(lotName2, lotName3);
		adminDashboardPage.group_Item_And_Pass_Lot(saleno, auctionName, lotName1, lotName3);

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

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotName1 = adminDashboardPage.addMultipleLot(1);
		String lotName2 = adminDashboardPage.addMultipleLot(1);
		String lotName3 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.start_Auction_Hybrid();

		adminDashboardPage.group_X_Ungroup_Live_Hybrid(lotName2, lotName3);
		adminDashboardPage.group_Item_And_Ungroup_Lot1(saleno, auctionName, lotName1, lotName2);

	}

	/**
	 * User Chat Disable
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void User_Chat_Disable_Hybridsell(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"TestCase Name :: User Chat Disable");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.user_Chat_Disable_Hybrid_Settings();

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.approveBidder1_2(); // approve bidder

		String lotName1 = adminDashboardPage.addMultipleLot(1);
		String lotName2 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.start_Auction_Hybrid();

		adminDashboardPage.user_Chat_Disable_Hybrid(auctionName); // User Chat
																	// Disable
																	// Hybrid

	}

	/**
	 * User Chat Clerk Enable
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void User_Chat_Clerk_Enable(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT"
				+ "\"TestCase Name :: "
				+ "Allow users to send chat messages to clerk/asst. clerk enabled,but Allow all users to see everyone's chat messages disabled");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		
		adminDashboardPage.allow_To_Send_Msg_Enable_See_Everyone_Disable_Setting();

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.approveBidder1_2(); // approve bidder

		String lotName1 = adminDashboardPage.addMultipleLot(1);
		String lotName2 = adminDashboardPage.addMultipleLot(1);

		adminDashboardPage.start_Auction_Hybrid();

		adminDashboardPage.see_Everyone_Chat_Message_Disable(auctionName); // See
																			// Everyone
																			// Chat
																			// Message

	}

	/**
	 * as 2 different bidders, place absentee bids on the same lot
	 * 
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Place_Absentee_Bids_on_The_Same_Lot_Hybrid(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"as a bidder, place an absentee bid on lot Y from the item details page with "
				+ "confirmation Feature,TestCase Name: as a 2 bidder place absentee bids on the same lot");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);

		adminDashboardPage.Auction_Specific_Auto_Extend_Time_Setting();

		adminDashboardPage.approveBidder1_2(); // approve bidder

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandomForUser(1);
		adminDashboardPage.front(); // Open Front End

		// User 1 Login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Place_Absenteebid_Hybrid(auctionName, lotname);

		// User 2 Login
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);
		dashboardPage.Place_Higher_Absentee_Hybrid(auctionName, lotname); // Higher
																			// than
																			// 1st
																			// bidder

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Goto Admin Side

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Accept_Absentee_Two(auctionName, saleno); // Accept
																		// Absentee
																		// Two
	}

	/**
	 * Post Floor sell and generate Invoice
	 * 
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Post_Floor_Sell_Generate_Invoice_Hybrid(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\" Sell Lot To Post Floor Bidder and generate Invoice");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.setting_Auto_Create_And_Floor_Buyer_Active();

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);

		adminDashboardPage.approveBidder1_2(); // approve bidder

		adminDashboardPage.addLotRandom(2);

		adminDashboardPage.start_Auction_Hybrid(); // Start Auction Hybrid

		String winner = adminDashboardPage.post_Floor_Sold_lot_Using_Name_Hybrid(); // Post
																					// Floor
																					// and
																					// sold
																					// lot

		adminDashboardPage.generate_Invoice_With_Random_Bidder(auctionName, winner); // Generate
																						// Invoice

	}

	/**
	 * use quick change button
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Use_Quick_Change_Button_Hybrid(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"validate with Enter Feature,TestCase Name: 3.112 use quick change button");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		// String saleno = common.generateRandomNumber1(4);

		String saleno = common.generateRandomNumber1();

		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);

		adminDashboardPage.approveBidder1(); // approve bidder
		String lotname1 = adminDashboardPage.addLot1();
		String lotname2 = adminDashboardPage.addLot1();
		String lotname3 = adminDashboardPage.addLot1();
		adminDashboardPage.Verify_StartingBid_Hybrid(); // verify asking bid

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.goto_Catalog_Page_Hybrid(auctionName);
		dashboardPage.verify_Starting_Bid_Catalogpage(auctionName, saleno); // Verify
																			// Starting
		// bid

		driver.get(configFileReader.getqa_MainAutoAdmin()); 

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Use_Quick_Change_Button_Hybrid(auctionName, saleno, UName);

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.goto_Catalog_Page_Hybrid_Auction(auctionName);
		dashboardPage.verify_Starting_Bid_Catalogpage(auctionName, saleno); // Verify
																			// new
		// Starting
		// bid

	}

	/**
	 * restore default increment link Hybrid
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Restore_Default_Increment_Link_Hybrid(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"validate with Enter Feature,TestCase Name: 3.113 restore default increment link.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);

		adminDashboardPage.approveBidder1(); // Approve bidder

		String lotname1 = adminDashboardPage.addLot1();
		String lotname2 = adminDashboardPage.addLot1();

		adminDashboardPage.Verify_StartingBid_Hybrid(); // verify asking bid

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.goto_Catalog_Page_Hybrid(auctionName);
		dashboardPage.verify_Starting_Bid_Catalogpage(auctionName, saleno); // Verify
																			// Starting
		// bid

		driver.get(configFileReader.getqa_MainAutoAdmin()); 

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Restore_Default_Incerement_Hybrid(auctionName, saleno, UName);

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.goto_Catalog_Page_Hybrid_Auction(auctionName);
		dashboardPage.verify_Starting_Bid_Catalogpage(auctionName, saleno); // Verify
																			// new
		// Starting
		// bid

	}

	/**
	 * Sell Lot To Higer bidder automatically
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Sell_Lot_To_Higher_bidder_Auto(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"validate with Enter Feature,TestCase Name :: Sell lot to higher bidder.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.Create_Hybrid_Auction1(saleno);

		adminDashboardPage.approveBidder1_2(); // Approve bidder

		String lotname1 = adminDashboardPage.addLot1();
		String lotname2 = adminDashboardPage.addLot1();
		String lotname3 = adminDashboardPage.addLot1();

		adminDashboardPage.start_Auction_Hybrid(); // Start Auction

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Hybrid_Auction(auctionName);
		// bid

		// User 2 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);
		dashboardPage.place_Bid_On_Hybrid_Auction1(auctionName);
		// bid

		driver.get(configFileReader.getqa_MainAutoAdmin()); 

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Sell_Lot_To_Higher_Bidder_Auto(saleno); // Sell Lot
																	// To Higher
																	// Bidder
																	// Auto
	}

	/**
	 * Sell Lot To Higer bidder automatically
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Lot_Button_Counter_Reset_Bidding_Consol(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"validate with Enter Feature,TestCase Name :: Verify Counter Reset");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);

		adminDashboardPage.approveBidder1_2(); // Approve bidder

		String lotname1 = adminDashboardPage.addLot1();
		String lotname2 = adminDashboardPage.addLot1();

		adminDashboardPage.Verify_Lot_Reset_Counter(); // Verify Lot Reset
														// Counter

	}

	/**
	 * Floor Priority
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Floor_Priority(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"Verify Floor Priority :: Sell Lot to floor bidder");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);

		adminDashboardPage.approveBidder1_2(); // Approve bidder

		String lotname1 = adminDashboardPage.addLot1();
		String lotname2 = adminDashboardPage.addLot1();

		adminDashboardPage.start_Auction_Hybrid(); // Start Auction

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Bid_On_Hybrid_Auction(auctionName);
		// bid

		// User 2 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);
		dashboardPage.place_Bid_On_Hybrid_Auction1(auctionName);
		// bid

		driver.get(configFileReader.getqa_MainAutoAdmin()); 

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_Floor_Priority(saleno); // Verify Floor
															// Priority

	}

	/**
	 * as a bidder place absentee bids on lots V and W from the catalog page with
	 * confirmation
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Place_Multiple_Absentee_Bid_Catalog_Page_Hybrid(String adminUserName, String adminPassword,
			String UName, String password) throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();

		log("Feature" + "-" + "UAT" + "\"as a bidder, place an absentee bid on lot Y from the item details page with "
				+ "confirmation Feature,TestCase Name: as a bidder place absentee bids on lots V and W from the catalog page with confirmation");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.multiBid_Functionality_Enable(); // enable
															// place
															// multiple
		// bid
		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);

		adminDashboardPage.approveBidder1_2(); // approve both bidder

		String lotname = adminDashboardPage.addLotRandom(1);
		String lotname1 = adminDashboardPage.addLotRandomForUser(1);
		String lotname2 = adminDashboardPage.addlotrandom2(1);
		String lotname3 = adminDashboardPage.addLotRandom3(1);

		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.place_Absentee_Bid_on_4_Lot_Hybrid(saleno, auctionName, lotname, lotname1, lotname2, lotname3); // Place
		// multibid

		driver.get(configFileReader.getqa_MainAutoAdmin()); 

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.sold_Lot_Hybrid(saleno); // Sold Lot Hybrid
	}

	/**
	 * Verify Start Lot and Reset Countdown Button Enable
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Start_Lot_Reset_CountDown_Enable(String adminUserName, String adminPassword, String UName,
			String password) throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);
		adminDashboardPage.approveBidder1(); // approve bidder

		String lotname1 = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.verify_Reset_Countdown_Startlot_Button_Enable(); // Verify
																			// Reset
																			// Button
																			// Start
																			// Button
																			// enable

	}

	/**
	 * Change Lot Number
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Change_Lot_NUmber(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);
		String lotname1 = adminDashboardPage.addLotRandom(3);

		adminDashboardPage.verify_Change_Lot_Number(saleno); // Verify Change
																// Lot Number

	}

	/**
	 * Enter Existing Lot ID
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Enter_Existing_Lot_Id(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);
		String lotname1 = adminDashboardPage.addLotRandom(3);

		adminDashboardPage.enter_Existing_Lot_Id(saleno); // Edit Lot ID and
															// verify Existing
															// Number

	}

	/**
	 * Edit Lot ID
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Edit_Lot_Id(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.edit_Lot_Id(saleno); // Edit Lot ID and verify
												// Existing Number

	}

	/**
	 * Edit Lot Quantity
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Edit_Lot_Quantity(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.get_Lotquantity(); // Get Lotnumber

		adminDashboardPage.change_Lot_Quantity(saleno); // Verify
														// Starting
														// Bid Value

		adminDashboardPage.get_Lotquantity(); // Get Lot Quantity

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

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);
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

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);
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

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);
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

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);
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

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);
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

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);
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

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);
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

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);
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

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);
		String lotname1 = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.quick_Edit_Lot_Estimate();

	}

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

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);
		String lotname1 = adminDashboardPage.addLotRandom(1);

		adminDashboardPage.quick_Edit_Lot_Reserve();

	}

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

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);
		String lotname1 = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.quick_Edit_Lot_Estimate_Negative_Value();

	}

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

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);
		String lotname1 = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.quick_Edit_Lot_Start();

	}

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

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);
		String lotname1 = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.quick_Edit_Lot_Price();

	}

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

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);
		String lotname1 = adminDashboardPage.add_Lot_With_Consignor();

		adminDashboardPage.quick_Edit_Lot_Consignor();

	}

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

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);
		String lotname1 = adminDashboardPage.add_Lot_With_Consignor();

		adminDashboardPage.quick_Edit_Lot_Views();

	}

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

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);
		String lotname1 = adminDashboardPage.add_Lot_With_Consignor();

		adminDashboardPage.quick_Edit_Lot_Status();

	}

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

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);
		String lotname1 = adminDashboardPage.add_Lot_With_Consignor();

		adminDashboardPage.lot_Preview();

	}

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

		String hybridauction = adminDashboardPage.create_Hybrid_Auction(saleno);
		String lotname1 = adminDashboardPage.addLotRandom(3);

		adminDashboardPage.delete_Multiple_lot();

	}

	// ***** Lot Number Extension Field Remove - SAM 3023 ****//

//	/**
//	 * Verify Enter lot number Extention
//	 * 
//	 * @throws InterruptedException
//	 * @throws AWTException
//	 */
//	@Test(dataProvider = "createauction")
//	public void Verify_Enter_Lot_Number_Extention(String adminUserName, String adminPassword, String UName,
//			String password) throws InterruptedException, ParseException, AWTException {
//		log("Feature" + "-" + "UAT"
//				+ "\"Verify Enter lot number Extention Feature,TestCase Name: 3.73 Verify Enter lot number Extention Feature.");
//		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
//
//		String saleno = common.generateRandomNumber1();
//		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
//		adminDashboardPage = indexPage // Admin Signin
//				.adminSignin(adminUserName, adminPassword);
//		adminDashboardPage.Create_Hybrid_Auction(saleno); // Create Auction
//
//		String mergenumber = adminDashboardPage.addlot_VerifyPrefix_Extensionfield(1);
//
//		String newlotnumber = adminDashboardPage.Get_LotNumber_return();
//
//		System.out.println("Step :: Verify New Merged Lot Number in table");
//		common.log("Step :: Verify New Merged Lot Number in table");
//		common.assertTwoValuesAreEqual(mergenumber, newlotnumber);
//
//	}

//	/**
//	 * Verify Enter Albhabet value in lot number Extention Field
//	 *
//	 * @throws InterruptedException
//	 * @throws AWTException
//	 */
//	@Test(dataProvider = "createauction")
//	public void Verify_Enter_Albhabet_Value_In_Lot_Number_Extention_Field(String adminUserName, String adminPassword,
//			String UName, String password) throws InterruptedException, ParseException, AWTException {
//		log("Feature" + "-" + "UAT"
//				+ "\"Verify Enter Albhabet value in lot number Extention Field Feature,TestCase Name: 3.74 Verify Enter Albhabet value in lot number Extention Field Feature.");
//		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
//
//		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
//		adminDashboardPage = indexPage // Admin Signin
//				.adminSignin(adminUserName, adminPassword);
//
//		adminDashboardPage.VerifyEnterAlphabetvalueInLotnumberExtention_Hybrid();
//
//	}
//
//	/**
//	 * Verify Enter Symbol value in lot number Extention Field
//	 *
//	 * @throws InterruptedException
//	 * @throws AWTException
//	 */
//	@Test(dataProvider = "createauction")
//	public void Verify_Enter_Symbol__Value_In_Lot_Number_Extention_Field(String adminUserName, String adminPassword,
//			String UName, String password) throws InterruptedException, ParseException, AWTException {
//		log("Feature" + "-" + "UAT"
//				+ "\"Verify Enter Symbol value in lot number Extention Field Feature,TestCase Name: 3.75 Verify Enter Symbol value in lot number Extention Field Feature.");
//		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
//
//		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
//		adminDashboardPage = indexPage // Admin Signin
//				.adminSignin(adminUserName, adminPassword);
//
//		adminDashboardPage.VerifyEnterSymbolvalueInLotnumberExtention_Hybrid();
//
//	}
//
//	/**
//	 * Verify Enter pound sign in lot number Extention Field
//	 *
//	 * @throws InterruptedException
//	 * @throws AWTException
//	 */
//	 @Test(dataProvider = "createauction")
//	 public void Verify_Enter_Pound_Sign_In_Lot_Number_Extention_Field(String
//	 adminUserName, String adminPassword,
//	 String UName, String password) throws InterruptedException,
//	 ParseException, AWTException {
//	 log("Feature" + "-" + "UAT"+ "\"Verify Enter pound sign in lot number Extention Field Feature,TestCase Name: 3.76 Verify Enter pound sign in lot number Extention Field Feature.");
//	 log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
//	
//	 driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
//	 adminDashboardPage = indexPage // Admin Signin
//	 .adminSignin(adminUserName, adminPassword);
//	
//	 adminDashboardPage.VerifyEnterPoundSignInLotnumberExtention_Hybrid();
//	
//	 }

	///////////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * Data Provider :: Hybrid Missing Fields Auction
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
