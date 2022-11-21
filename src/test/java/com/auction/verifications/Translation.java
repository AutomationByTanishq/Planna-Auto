package com.auction.verifications;

import java.awt.AWTException;

import java.io.File;
import java.text.ParseException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.auction.init.Common;
import com.auction.init.ConfigFileReader;
import com.auction.init.SeleniumInit;
import com.auction.pages.DashboardPage;
//import com.relevantcodes.extentreports.ExtentReports;

public class Translation extends SeleniumInit {

	Common common = new Common(driver);

	String bidder2 = "rahulbid";
	String bidder2Pass = "rahulbid";
	String UName = "rahulqa";
	String password = "123123a";
	ConfigFileReader configFileReader= new ConfigFileReader();
	/**
	 * Verify Auction Translation
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Auctions_Translation(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Main Menu > Auctions  translation TC_002");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String Auctionlbl = adminDashboardPage.Translation_Auctions_label();

		adminDashboardPage.front();

		// Front User Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		// dashboardPage.logoutfrontuser();
		dashboardPage.Verify_Auction_Label(Auctionlbl);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Auctions_label_Rename();

	}

	

	/**
	 * Verify Invoices Translation
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Verify_Invoices_Translation(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Main Menu > Invoices  translation TC_005");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String Invoicelbl = adminDashboardPage.Translation_Invoices_label();

		adminDashboardPage.front();

		// Front User Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Invoices_Label(Invoicelbl);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Invoices_label_Rename();

	}

	/**
	 * Verify Login Translation
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Verify_Login_Translation(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		String loginlbl = "Login";
		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Main Menu > Login  translation TC_006");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String Loginlbl = adminDashboardPage.Translation_Login_label(loginlbl);

		adminDashboardPage.front();

		// Front User Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.logoutfrontuser();
		dashboardPage.Verify_Login_Label(Loginlbl);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Translation_Login_label_Rename();

	}

	/**
	 * Verify Logout Translation
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Verify_Logout_Translation(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Main Menu > Logout  translation TC_007");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String Logoutlbl = adminDashboardPage.Translation_Logout_label();

		adminDashboardPage.front();

		// Front User Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Logout_Label(Logoutlbl);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Translation_Logout_label_Rename();

	}

	/**
	 * Verify MyItems Translation
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Verify_MyItem_Translation(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Main Menu > My Item  translation TC_10");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String MyItemslbl = adminDashboardPage.Translation_MyItems_label();

		adminDashboardPage.front();

		// Front User Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_MyItems_Label(MyItemslbl);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Translation_MyItems_label_Rename();

	}

	/**
	 * My Profile Translation
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_MyProfile_Translation(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Main Menu > My Profile  translation TC_11");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String Myprofilelbl = adminDashboardPage.Translation_MyProfile_label();

		adminDashboardPage.front();

		// Front User Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_MyProfile_Label(Myprofilelbl);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Translation_MyProfile_label_Rename();

	}

	/**
	 * Verify Search Translation
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Verify_Search_Translation(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Main Menu > Search  translation TC_12");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String searchlbl = adminDashboardPage.Translation_Search_label();

		adminDashboardPage.front();

		// Front User Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		// option not present in V-3.0

	}

	/**
	 * Verify Signup Translation
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Verify_Signup_Translation(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Main Menu > Signup  translation TC_16");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String signuplbl = adminDashboardPage.Translation_Signup_label();

		adminDashboardPage.front();

		// Front User Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.logoutfrontuser();
		dashboardPage.Verify_Signup_Label(signuplbl);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Translation_Signup_label_Rename();
	}

	/**
	 * Verify All Tab
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_TabNames_All_Translation(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Main Menu > Verify All TabNames TC_17");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String signuplbl = adminDashboardPage.Translation_All_Tab_label();

		adminDashboardPage.front();

		// Tabs name not display at admin side under settings > system parameters
		// All label text not dispaly in front end
	}

	/**
	 * Verify Auction Tab
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_TabNames_Auction_Translation(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Main Menu > Verify Auction TabNames TC_18");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionlbl = adminDashboardPage.Translation_Auction_Tab_label();

		adminDashboardPage.front();

		// Front User Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.Verify_Auction_Tab_Label(auctionlbl);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Translation_Auction_Tab_label_Rename();

		// Tabs name not display at admin side under settings > system parameters
	}

	/**
	 * Verify Description Translation Auction Menu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Verify_Description_Translation_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Description  translation TC_24");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String descriptionlbl = adminDashboardPage.Translation_Description_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Description_Label(descriptionlbl);
		dashboardPage.logoutfrontuser();
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Description_label_Rename();

	}

	

	/**
	 * Shipping info Tranlslation Auctionmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_ShippingInfo_Translation_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu >Shipping info  translation TC_28");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String shippinglbl = adminDashboardPage.Translation_ShippingInfo_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_ShippingInfo_Label(shippinglbl);

		dashboardPage.logoutfrontuser();
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_ShippingInfo_label_rename();
	}

	/**
	 * Terms and condition translation Auction menu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Verify_Terms_and_Condition_Translation_AuctionMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu >Terms & Condition translation TC_29");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String terms_conlbl = adminDashboardPage.Translation_Terms_and_Condition_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Terms_and_Condition_Label(terms_conlbl);
		dashboardPage.logoutfrontuser();
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Terms_and_Condition_label_rename();
	}

	/**
	 * Livesale now translation auctionmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_View_LiveSale_Now_Translation_AuctionMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu >Livesale translation TC_33");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String viewlivesale_lbl = adminDashboardPage.Translation_View_LiveSale_Now_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_View_LiveSale_Now_Label(viewlivesale_lbl);

		dashboardPage.logoutfrontuser();
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_View_LiveSale_Now_label_rename();
	}

	/**
	 * Translation Auction Menu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Verify_Advanced_Translation_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Advanced translation TC_35");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String advances_lbl = adminDashboardPage.Translation_Advanced_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Advanced_Label(advances_lbl);

		// Advanced not present in front side on qa3-2-auto

	}

	/**
	 * All Auctioneer Translation Auction menu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_ALL_Auctioneer_Translation_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		// String Account1 = "Account_123";
		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > All AUctioneers translation TC_36");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String AllAuctionner_lbl = adminDashboardPage.Translation_All_Auctioneer_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_All_Auctioneers_Label(AllAuctionner_lbl);

		dashboardPage.logoutfrontuser();
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_All_Auctioneer_label_Rename();
	}

	/**
	 * Sales Translation Auction menu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Verify_ALL_Sales_Translation_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		// String Account1 = "Account_123";
		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > All Sales translation TC_37");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String AllSales_lbl = adminDashboardPage.Translation_All_Sales_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_All_Sales_Label(AllSales_lbl);

		dashboardPage.logoutfrontuser();
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_All_Sales_label_Rename();

	}

	/**
	 * Livesale now translation auctionmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_View_Catalog_Translation_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu >> Catalog  translation TC_38");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String catalog_lbl = adminDashboardPage.Translation_View_Catalog_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_View_Catalog_Label(catalog_lbl);

		dashboardPage.logoutfrontuser();
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_View_Catalog_label_Rename();
	}

	/**
	 * Livesale now translation auctionmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Date_Long_Translation_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu >> Date Long translation TC_39");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Date_Long_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Date_Label();
		
		
		// date not display at front side under catalog page
		dashboardPage.logoutfrontuser();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Date_Long_label_Rename();

	}

	/**
	 * Verify Date Long sec Translation
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Date_Long_Secs_Translation_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Date Long Secs translation TC_40");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String Datelongsecs_lbl = adminDashboardPage.Translation_Date_Long_Secs_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Date_Long_Secs_Label(Datelongsecs_lbl);

		// Date Long Secs not present in Front side on qa3-2-auto
	}

	/**
	 * Livesale now translation auctionmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Date_Short_Translation_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu >> Date Short translation TC_41");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Date_Short_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Short_Date_Label();

		// Pending - Short Date is not dispaly in front end

	}

	/**
	 * Verify Ongoing Event Translation
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Ongoing_Event_Translation_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Ongoing Events translation TC_42");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String OngoingEvent_lbl = adminDashboardPage.Translation_Ongoing_Event_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Ongoing_Event_Label(OngoingEvent_lbl);

		// Ongoing Event not present in Front side on qa3-2-auto
	}

	/**
	 * All Auctioneer Translation Auction menu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_ALL_Hybrid_Translation_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Hybrid translation TC_43");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String Hybrid_lbl = adminDashboardPage.Translation_Hybrid_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		// pending - Hybrid Auction not display in frontend
	}

	/**
	 * Verify Live Translation
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Verify_Live_Translation_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Live translation TC_44");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String Live_lbl = adminDashboardPage.Translation_Live_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Live_Label(Live_lbl);

		dashboardPage.logoutfrontuser();
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Live_label_Rename();

	}

	/**
	 * Verify Timed Translation
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Timed_Translation_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		// String Account1 = "Account_123";
		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Timed translation TC_45");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String Timed_lbl = adminDashboardPage.Translation_Timed_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Timed_Label(Timed_lbl);
		dashboardPage.logoutfrontuser();
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Timed_label_Rename();
	}

	/**
	 * Hybrid Only Translation
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Verify_Hybrid_Only_Translation_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		// String Account1 = "Account_123";
		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > hybrid only translation TC_46");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hybrid_lbl = adminDashboardPage.Translation_Hybrid_Only_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_HybridOnly_Label(hybrid_lbl);

	}

	/**
	 * Livesale now translation auctionmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Auction_Tab_Translation_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu >> Auction Info Tab translation TC_47");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String aucinfotab = adminDashboardPage.Translation_Auction_Info_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_View_Auction_Tab_Label(aucinfotab);

		dashboardPage.logoutfrontuser();
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Auction_Info_label_Rename();

	}



	/**
	 * Livesale now translation auctionmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Live_Only_Translation_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu >> Live only translation TC_49");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String lstliveonly = adminDashboardPage.Translation_Auction_Live_Only_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Live_Only_LST_Label(lstliveonly);

		dashboardPage.logoutfrontuser();
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Auction_Live_Only_label_Rename();

	}

	/**
	 * Sorry you do not have bidder privileges
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Sorry_You_Do_Not_Have_Bidder_Privileges_Translation_AuctionMenu(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > hybrid only translation TC_50");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String privileges_lbl = adminDashboardPage.Translation_Sorry_You_Do_Not_Have_Bidder_Privileges_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulbid", "123123a");

		dashboardPage.Verify_Sorry_You_Dont_Have_Bidder_Label(privileges_lbl);

		dashboardPage.logoutfrontuser();
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Sorry_You_Do_Not_Have_Bidder_Privileges_label_Rename();

	}

	/**
	 * Verfify Lot which are not listed translation
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Verify_Lot_Which_Are_Not_Listed_Translation_AuctionMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > hybrid only translation TC_52");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String lot_lbl = adminDashboardPage.Translation_Lot_Which_are_Not_Display_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Lot_Which_Are_Not_Display_Label(lot_lbl);

		// Lot which are not listed is Not present in front side on qa3-2-auto
	}

	/**
	 * Registered
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Registerd_Translation_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu >> Registered translation TC_53");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String registeredlbl = adminDashboardPage.Translation_Registerd_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Registered_Label(registeredlbl);

		dashboardPage.logoutfrontuser();
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Registerd_label_Rename();

	}

	/**
	 * Pending Approval Translation
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Verify_Pending_Approval_Translation_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Pending Approval Translation TC_54");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String pendingappro_lbl = adminDashboardPage.Translation_Pending_approval_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Pending_Approval_Label(pendingappro_lbl);

		// Pending Approval is Not present in front side on qa3-2-auto
	}

	/**
	 * Verify Register For Auction Translation Auction
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Register_For_Auction_Translation_AuctionMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Auction Menu > Verify Register For Auction Translation Auction TC_55");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String register_lbl = adminDashboardPage.Translation_Register_For_Auction_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Register_For_Auction_Label(register_lbl);

		// Register For Auction is Not present in front side on qa3-2-auto
	}

	/**
	 * Verify The Auction Will not be visible translation auction menu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_The_Auction_Will_Not_Be_Visible_Translation_AuctionMenu(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Auction Menu > Verify The Auction Will not be visible translation auction menu TC_56");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String aucnotvis_lbl = adminDashboardPage.Translation_The_Auction_Will_Not_Visible_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Auction_Will_Not_Visible_Label(aucnotvis_lbl);

		// The Auction Will Not Be Visible is Not present in front side on qa3-2-auto
	}

	/**
	 * Show
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Show_Translation_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu >> Show translation TC_59");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String showlbl = adminDashboardPage.Translation_Show_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Show_Label(showlbl);

		dashboardPage.logoutfrontuser();
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Show_label_Rename();

	}

	/**
	 * All Translation Auction Menu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_All_Translation_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu >> All Translation Auction Menu TC_60");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String showlbl = adminDashboardPage.Translation_Show_All_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Show_All_Label(showlbl);

		dashboardPage.logoutfrontuser();
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Show_All_label_Rename();

	}

	/**
	 * Show Bidding now only
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Show_Bidding_Now_Only_Translation_AuctionMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Auction Menu >> Show Bidding now only translation TC_61");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String showbiddingnowonlylbl = adminDashboardPage.Translation_Show_Bidding_Now_Only_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Show_Bidding_Now_Only_Label(showbiddingnowonlylbl);

		dashboardPage.logoutfrontuser();
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Show_Bidding_Now_Only_label_Rename();

	}

	/**
	 * Show Bidding now and upcomig only
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Show_Bidding_Now_And_Upcoming_Only_Translation_AuctionMenu(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Auction Menu >> Show Bidding now and upcoming only translation TC_62");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String showbiddingnowupcomingonlylbl = adminDashboardPage
				.Translation_Show_Bidding_Now_and_Upcoming_Only_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Show_Bidding_Now_and_Upcoming_Only_Label(showbiddingnowupcomingonlylbl);

		dashboardPage.logoutfrontuser();
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Show_Bidding_Now_and_Upcoming_Only_label_Rename();

	}

	/**
	 * Show closed only
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Show_Closed_Only_Translation_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu >> Show Closed only translation TC_63");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String showclosedlbl = adminDashboardPage.Translation_Show_Closed_Only_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Show_Closed_Only_Label(showclosedlbl);

		dashboardPage.logoutfrontuser();
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Show_Closed_Only_label_Rename();

	}

	/**
	 * Show upcoming only
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Show_Upcoming_Only_Translation_AuctionMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Auction Menu >> Show Upcoming only translation TC_64");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String showclosedlbl = adminDashboardPage.Translation_Show_Upcoming_Only_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Show_Closed_Only_Label(showclosedlbl);

		dashboardPage.logoutfrontuser();
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Show_Upcoming_Only_label_Rename();

	}

	/**
	 * 
	 * Date Translation Auction Menu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Verify_Auction_Date_Translation_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Account date only translation TC_67");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String Aucdate_lbl = adminDashboardPage.Translation_Auction_Date_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Auction_Date_Label(Aucdate_lbl);

		dashboardPage.logoutfrontuser();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Auction_Date_label_Rename();
	}

	

	/**
	 * Lots Translation
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Verify_Lots_Translation_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Lots only translation TC_70");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String lots_lbl = adminDashboardPage.Translation_Lots_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Lots_Label(lots_lbl);
		dashboardPage.logoutfrontuser();

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Lots_label_Rename();

	}

	/**
	 * Name Auction Table Menu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Verify_Name_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Auction Menu > Name in auction table translation TC_71");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String name_lbl = adminDashboardPage.Translation_Name_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Name_Label(name_lbl);

		dashboardPage.logoutfrontuser();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Name_label_Rename();

	}

	

	/**
	 * Timed list from dropdown
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Verify_Timed_Only_lst_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Auction Menu > Status in Timed Only translation TC_75");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String timed_lbl = adminDashboardPage.Translation_Timed_Only_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Timed_Only_DropDown_Label(timed_lbl);

		dashboardPage.logoutfrontuser();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Timed_Only_label_Rename();

	}

	/**
	 * Status Auction Table Menu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Verify_View_Catalog_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > View Catalog Only translation TC_76");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String catalog_lbl = adminDashboardPage.Translation_View_Catalog_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Catalog_Label(catalog_lbl);

		dashboardPage.logoutfrontuser();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_View_Catalog_Label_Rename();

	}

	/**
	 * Verify Auctionner
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Auctioneer_Translation_AuctionMenu1(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Auctioneer only translation TC_80");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String Auctioneerlbl = adminDashboardPage.Translation_Auctioneer_label1();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Auctioneer_Label1(Auctioneerlbl);

		// Auctioneer option is not present in front side on qa3-2-auto

	}



	/**
	 * Verify Auction Label Type
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Auction_Last_Updated_Translation_AuctionMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Last Updated translation TC_83");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String lastupdatedlbl = adminDashboardPage.Translation_Last_Updated_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Last_Updated_Label(lastupdatedlbl);

		// Last Updated option is not present in front side on qa3-2-auto

	}

	/**
	 * Verify Lot Label
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Lot_Translation_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Lot translation TC_84");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String lotlbl = adminDashboardPage.Translation_Lot_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Lot_Label(lotlbl);

		// Lot label option is not present in front side on qa3-2-auto

	}

	/**
	 * Verify Lots Label
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Lots_Translation_AuctionMenu1(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Lots translation TC_85");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String lotslbl = adminDashboardPage.Translation_Lots_label1();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Lots_Label1(lotslbl);

		// Lots label option is not present in front side on qa3-2-auto

	}

	/**
	 * Verify Lot count Label
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Lot_Count_Translation_AuctionMenu1(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Lot count translation TC_87");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String lotcountlbl = adminDashboardPage.Translation_Lot_Count_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Lot_Count_Label(lotcountlbl);

		// Lot count option is not present in front side on qa3-2-auto

	}

	/**
	 * Verify Lot# Label
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Lot_Hash_Count_Translation_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Lot# translation TC_88");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String lothashlbl = adminDashboardPage.Translation_Lot_Hash_Count_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Lot_Hash_Label(lothashlbl);

		// Lot# option is not present in front side on qa3-2-auto

	}

	/**
	 * Verify Realized Label
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Realized_Translation_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Realized translation TC_89");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String realizedlbl = adminDashboardPage.Translation_Realized_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Reliazed_Label(realizedlbl);

		// Reliazed option is not present in front side on qa3-2-auto

	}

	/**
	 * Verify Realized Label
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Realized_Result_Translation_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Realized Result translation TC_90");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String realizedlbl = adminDashboardPage.Translation_Realized_Result_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Reliazed_Result_Label(realizedlbl);

		// Reliazed Result option is not present in front side on qa3-2-auto

	}

	/**
	 * Verify Realized Label
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Realized_Auction_Result_Translation_AuctionMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Auction Menu > Realized Auction Result translation TC_91");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String realizedlbl = adminDashboardPage.Translation_Realized_Auction_Result_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Reliazed_Auction_Result_Label(realizedlbl);

		// Reliazed Auction Result option is not present in front side on qa3-2-auto

	}

	/**
	 * Verify Auction Description
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Title_Description_Translation_AuctionMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Title Description translation TC_92");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctiondesclbl = adminDashboardPage.Translation_Auction_Description_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Auction_Description_Label(auctiondesclbl);

		// Auction Description Result option is not present in front side on
		// qa3-2-auto

	}

	/**
	 * Verify Auction Agreement Number
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Auction_Agreement_Translation_AuctionMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Auction Agreement translation TC_93");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String agreementnolbl = adminDashboardPage.Translation_Auction_Agreement_Number_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Auction_Agreement_Number_Label(agreementnolbl);

		// Auction Agreement Number Result option is not present in front side
		// on qa3-2-auto

	}

	/**
	 * Verify Schedule
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Schedule_Translation_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Schedule translation TC_94");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String schedulelbl = adminDashboardPage.Translation_Schedule_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Auction_Schedule_Label(schedulelbl);

		// Schedule option is not present in front side
		// on qa3-2-auto

	}

	/**
	 * Verify Company
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Company_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Schedule translation TC_95");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String companylbl = adminDashboardPage.Translation_Company_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Company_Label(companylbl);

		// company option is not present in front side
		// on qa3-2-auto

	}

	/**
	 * Verify Consignor
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Consignor_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > consignor translation TC_96");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String consignorlbl = adminDashboardPage.Translation_Consignor_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Consignor_Label(consignorlbl);

		// Consignor option is not present in front side
		// on qa3-2-auto

	}

	/**
	 * Verify April Month
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Month_April_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > April translation TC_97");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String Aprillbl = adminDashboardPage.Translation_April_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_April_Month_Label(Aprillbl);

		// April Month option is not present in front side
		// on qa3-2-auto

	}

	/**
	 * Verify August Month
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Month_August_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > August translation TC_98");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String Augustlbl = adminDashboardPage.Translation_August_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_August_Month_Label(Augustlbl);

		// August Month option is not present in front side
		// on qa3-2-auto

	}

	/**
	 * Verify December Month
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Month_December_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > December translation TC_99");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String decemberlbl = adminDashboardPage.Translation_December_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_December_Month_Label(decemberlbl);

		// December Month option is not present in front side
		// on qa3-2-auto

	}

	/**
	 * Verify February Month
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Month_February_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > February translation TC_100");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String feblbl = adminDashboardPage.Translation_February_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_February_Month_Label(feblbl);

		// Feb Month option is not present in front side
		// on qa3-2-auto

	}

	/**
	 * Verify July Month
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Month_July_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > July translation TC_101");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String julylbl = adminDashboardPage.Translation_July_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_July_Month_Label(julylbl);

		// July Month option is not present in front side
		// on qa3-2-auto

	}

	/**
	 * Verify January Month
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Month_January_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > January translation TC_102");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String janlbl = adminDashboardPage.Translation_January_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_January_Month_Label(janlbl);

		// January Month option is not present in front side
		// on qa3-2-auto

	}

	/**
	 * Verify June Month
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Month_June_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > June translation TC_103");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String janlbl = adminDashboardPage.Translation_June_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_June_Month_Label(janlbl);

		// June Month option is not present in front side
		// on qa3-2-auto
	}

	/**
	 * Verify March Month
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Month_March_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > March translation TC_104");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String marchlbl = adminDashboardPage.Translation_March_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_March_Month_Label(marchlbl);

		// March Month option is not present in front side
		// on qa3-2-auto
	}

	/**
	 * Verify May Month
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Month_May_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > May translation TC_105");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String maylbl = adminDashboardPage.Translation_May_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_May_Month_Label(maylbl);

		// May Month option is not present in front side
		// on qa3-2-auto
	}

	/**
	 * Verify November Month
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Month_November_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > May translation TC_106");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String novemberlbl = adminDashboardPage.Translation_November_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_November_Month_Label(novemberlbl);

		// November Month option is not present in front side
		// on qa3-2-auto
	}

	/**
	 * Verify October Month
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Month_October_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > May translation TC_107");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String octoberlbl = adminDashboardPage.Translation_October_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_October_Month_Label(octoberlbl);

		// October Month option is not present in front side
		// on qa3-2-auto
	}

	/**
	 * Verify September Month
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Month_September_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > September translation TC_108");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String septlbl = adminDashboardPage.Translation_May_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_September_Month_Label(septlbl);

		// September Month option is not present in front side
		// on qa3-2-auto
	}

	/**
	 * Verify Cancelled Label
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Cancelled_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Cancelled translation TC_109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String cancelledlbl = adminDashboardPage.Translation_Cancelled_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Cancelled_Label(cancelledlbl);

		// Cancelled option is not present in front side
		// on qa3-2-auto
	}

	/**
	 * Verify Deleted Label
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Deleted_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Deleted translation TC_110");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String deletedlbl = adminDashboardPage.Translation_Deleted_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Deleted_Label(deletedlbl);

		// Deleted option is not present in front side
		// on qa3-2-auto
	}

	/**
	 * Verify Bank Wire
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_BankWire_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Bank Wire translation TC_111");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String bankWirelbl = adminDashboardPage.Translation_BankWire_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_BankWire_Label(bankWirelbl);

		// Bank Wire option is not present in front side
		// on qa3-2-auto
	}

	/**
	 * Verify Cash Label
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Cash_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Cash Label translation TC_112");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String cashlbl = adminDashboardPage.Translation_Cash_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Cash_Label(cashlbl);
		// Cash option is not present in front side
		// on qa3-2-auto
	}

	/**
	 * Verify Cashiers Check Label
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Cashiers_Check_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Auction Menu > Cashiers Check Label translation TC_113");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String cashierchecklbl = adminDashboardPage.Translation_Cashiers_Check_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Cashiers_Check_Label(cashierchecklbl);

		// Cashiers check option is not present in front side
		// on qa3-2-auto
	}

	/**
	 * Verify Cashiers Check Label
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Check_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Check Label translation TC_114");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String checklbl = adminDashboardPage.Translation_Check_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Check_Label(checklbl);

		// Check option is not present in front side
		// on qa3-2-auto
	}

	/**
	 * Verify Cashiers Check Label
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_CreditCard_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > CreditCard Label translation TC_115");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String creditcardlbl = adminDashboardPage.Translation_CreditCard_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_CreditCard_Label(creditcardlbl);
		// Credit Card option is not present in front side
		// on qa3-2-auto
	}

	/**
	 * Verify Credit Memo
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_CreditMemo_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Credit Memo translation TC_116");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String crdMemolbl = adminDashboardPage.Translation_CreditMemo_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_CreditMemo_Label(crdMemolbl);

		// Credit Memo option is not present in front side
		// on qa3-2-auto
	}

	/**
	 * Verify Google Checkout
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Google_Checkout_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Google Checkout translation TC_117");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String googleChkOutlbl = adminDashboardPage.Translation_GoogleCheckoutLabel_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_GoogleCheckout_Label(googleChkOutlbl);

		// Google Checkout osption is not present in front side
		// on qa3-2-auto
	}

	/**
	 * Verify Money Order
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Money_Order_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Money Order translation TC_118");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String moneyorderlbl = adminDashboardPage.Translation_Money_Order_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Money_Order_Label(moneyorderlbl);

		// Money Order option is not present in front side
		// on qa3-2-auto
	}

	/**
	 * Verify Money Order
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Other_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Other translation TC_119");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String otherlbl = adminDashboardPage.Translation_Other_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Other_Label(otherlbl);
		// Other option is not present in front side
		// on qa3-2-auto
	}

	/**
	 * Verify Paypal Label
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Paypal_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Paypal translation TC_120");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String paypallbl = adminDashboardPage.Translation_Paypal_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Paypal_Label(paypallbl);
		// Paypal option is not present in front side
		// on qa3-2-auto
	}

	/**
	 * Verify Open Label
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Open_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Open Label translation TC_121");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String openlbl = adminDashboardPage.Translation_Open_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Open_Label(openlbl);
		// Open option is not present in front side
		// on qa3-2-auto
	}

	
	/**
	 * Verify Shipped Translation
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Verify_Shipped_Translation_AuctionMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Shipped translation TC_124");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String shippd_lbl = adminDashboardPage.Translation_Shipped_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Shipped_Label(shippd_lbl);

		driver.get(configFileReader.getAdminUrl());

		// admin login

		adminDashboardPage = indexPage.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Shipped_label_Rename();

	}


	
	// Catalog Menu

	/**
	 * Lot Has Already Been Awarded translation
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Verify_Lot_Has_Already_Been_Awarded_Translation_CatalogMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Catalog Menu > Lot Has Already Been Awarded translation TC_132");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String lotlbl = adminDashboardPage.Translation_Lot_Has_Already_Been_Awarded_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Lot_Has_Been_Awarded_Label(lotlbl);

		// Lot Has Already Been Awarded not Display in front side on
		// qa3-2-auto

	}

	/**
	 * Verify This lot has already been sold translation
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Verify_This_Lot_Has_Already_Been_Sold_Translation_CatalogMenu(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Catalog Menu > Lot Has Already Been Sold translation TC_133");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String lotsoldlbl = adminDashboardPage.Translation_Lot_Has_Already_Been_Sold_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Lot_Has_Been_Sold_Label(lotsoldlbl);

		// Lot Has Already Been Sold not Display in front side on
		// qa3-2-auto

	}

	/**
	 * 
	 * Verify Accept & sell translation
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Accept_and_Sell_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Accept & sell translation TC_134");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String accsellbl = adminDashboardPage.Translation_Accept_and_Sell_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Accept_and_Sell_Label(accsellbl);

		// Accept & Sell not Display in front side on
		// qa3-2-auto


	}

	/**
	 * Verify Accept and sell has been disable translation
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Verify_Accept_and_Sell_Has_Been_Disabled_Translation_CatalogMenu(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Catalog Menu > Accept & sell has been disable translation TC_135");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String accseldislbl = adminDashboardPage.Translation_Accept_and_Sell_Disable_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Accept_and_Sell_Disabled_Label(accseldislbl);

		// Accept & Sell has been Disabled not Display in front side on
		// qa3-2-auto

	}

	/**
	 * Verify Accept and sell watchlist
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Verify_Add_To_Watchlist1_Translation_CatalogMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Catalog Menu > Accept & sell watchlist translation TC_136");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String adwatchlistlbl = adminDashboardPage.Translation_Add_to_Watchlist1_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Ad_to_Watchlist1_Label(adwatchlistlbl);

		// Add to watchList not Display in front side on
		// qa3-2-auto

	}

	/**
	 * Verify Accept & sell Button translation
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Verify_Add_To_Watchlist_Button_Translation_CatalogMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Catalog Menu > Accept & sell Button translation TC_137");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String adwatchlistlbl = adminDashboardPage.Translation_Add_to_Watchlist_Button_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Add_to_Watchlist_Button_Label(adwatchlistlbl);
		// Add to watchlist not display in qa3-2-auto

	}

	/**
	 * Add Force Bid list translation
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Verify_Add_Force_Bid_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Catalog Menu > Add Force Bid list translation TC_138");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String addforcebidlbl = adminDashboardPage.Translation_Add_Force_Bid_To_Button_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Add_Force_Bid_To_Label(addforcebidlbl);

	}

	/**
	 * Verify Asking bid Translation
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Verify_Catalog_Asking_Bid_Translation_CatalogMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Catalog Menu > Catalog Asking bid list translation TC_139");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String catalogasking = adminDashboardPage.Translation_Catalog_Asking_Bid_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Catalog_Asking_Bid(catalogasking);

	}

	/**
	 * Verify Ask A Question list translation
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Ask_a_Question_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Catalog Menu > Verify Ask A Question list translation TC_140");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String catalogaskque = adminDashboardPage.Translation_Catalog_Ask_A_Quetion_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Catalog_Ask_A_Quetion(catalogaskque);
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Catalog_Ask_A_Quetion_label_Rename();

	}

	/**
	 * Verify Awarded translation
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Awarded_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Verify Awarded translation TC_141");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String catalogAwarded = adminDashboardPage.Translation_Catalog_Awraded_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Catalog_Awarded(catalogAwarded);

	}

	/**
	 * Verify Awarded with Reservation translation
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Verify_Awarded_With_Reservation_Translation_CatalogMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Catalog Menu > Verify Awarded with Reservation translation TC_142");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String catalogAwardedres = adminDashboardPage.Translation_Catalog_Awraded_With_Reservation_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Catalog_Awarded_With_Reservation(catalogAwardedres);

		// Awarded With Reservation Not display at front-end side in qa3-2-auto
		// enviroments

	}

	

	/**
	 * Verify Back To lIst translation
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Back_To_List_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Catalog Menu > Verify Back To lIst translation TC_144");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String backtolist = adminDashboardPage.Translation_Catalog_Back_To_List_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Catalog_Back_To_List(backtolist);
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Catalog_Back_To_List_label();
	}

	/**
	 * Verify Be the first bid translation catalog menu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Verify_Be_The_First_Bid_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Catalog Menu > Verify Be the first bid translation TC_145");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String firtsbid = adminDashboardPage.Translation_Catalog_Bee_The_First_Bid_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Catalog_Be_The_First_Bid(firtsbid);

	}

	/**
	 * Verify Sorry you do not have bidder privileges translation catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Verify_Sorry_You_Do_Not_Have_Bidder_Privileges_Translation_CatalogMenu(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Catalog Menu > Verify Sorry you don't bidder translation TC_146");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String bidderpre = adminDashboardPage.Translation_Catalog_Sorry_You_Do_Not_Have_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulbid", "123123a");

		dashboardPage.Verify_Sorry_You_Dont_Have_Bidder_Label(bidderpre);

	}

	/**
	 * Verify Please bid again transcation catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Verify_Please_Bid_Again_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Catalog Menu > Verify please bid again translation TC_147");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String bidagain = adminDashboardPage.Translation_Catalog_Please_Bid_Again_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Catalog_Please_bid_Again(bidagain);

	}

	/**
	 * Verify Bid Buy Now Translation Catalog menu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Bid_BuyNow_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Catalog Menu > Verify Bid/Buy Now translation TC_148");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String bidbuynow = adminDashboardPage.Translation_Catalog_Bid_BuyNow_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Catalog_Bid_BuyNow(bidbuynow);

	}

	/**
	 * Verify To Big Amount Translation Catalog menu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_To_Big_Ammount_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Catalog Menu > Verify To Big Ammount translation TC_149");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String bigammount = adminDashboardPage.Translation_Catalog_TO_Big_Ammount_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Catalog_Big_Ammount(bigammount);

	}

	/**
	 * Verify to small amount translation catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Verify_To_Small_Ammount_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Catalog Menu > Verify To Small Ammount translation TC_150");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String smallammount = adminDashboardPage.Translation_Catalog_TO_Small_Ammount_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Catalog_Small_Ammount(smallammount);

	}

	/**
	 * Verify you have been outbid translation catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_You_Have_Been_Outbid_Translation_CatalogMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Catalog Menu > You have been outbid translation TC_151");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String catalogoutbid = adminDashboardPage.Translation_You_Have_Been_Out_Bid_label1();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Catalog1_Label(catalogoutbid);

	}

	/**
	 * Verify Current Total
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Your_Current_Total_Spent_View_CatalogMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Auction Menu > Verify Your current total translation TC_152");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String currenttotallbl = adminDashboardPage.Translation_You_Current_Total_Spent_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Your_Current_Total(currenttotallbl);

		// Current Total spent is not Display in front side on qa3-2-auto

	}

	/**
	 * You are the higher bidder
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_You_Are_The_higher_Bidder_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Auction Menu > You Are the Higer Bidder translation TC_153");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String youarehigherbidderlbl = adminDashboardPage.Translation_You_Are_Higher_Bidder_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_You_Are_Higher_Bidder_Label(youarehigherbidderlbl);

		// You are Higer Bidder is not Display in front side on qa3-2-auto

	}

	/**
	 * Your absentee bid was placed
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Your_Absentee_Bid_Placed_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Auction Menu > Your absentee bid placed translation TC_154");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String yourabsbidplaced = adminDashboardPage.Translation_Your_Absentee_Bid_Bidder_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Your_Absenteebid_Placed_Label(yourabsbidplaced);

		// Your absentee bid Placed is not Display in front side on qa3-2-auto

	}

	/**
	 * Your absentee bid has been placed
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Your_Absentee_Bid_Has_Been_Placed_CatalogMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Auction Menu > Your absentee bid has been placed translation TC_155");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); // Create
		// Auction
		adminDashboardPage.approveBidder1(); // Approve both bidder

		String lotname = adminDashboardPage.addLotRandom(1); // Add lot

		adminDashboardPage.start_Auction();

		String yourbidhasbeenplaced = adminDashboardPage.Translation_Your_Bid_Has_Been_Placed_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.verify_Your_Bid_Has_been_Placed(auctionName, lotname);

	}

	/**
	 * Your Bid Updated Successfully
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_SuccessFully_Updated_Bid_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Auction Menu > Your bid updated successfully translation TC_156");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String yourbidupdatesuccessfully = adminDashboardPage.Translation_Your_Bid_Updated_Successfully_label();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Your_Bid_Upadted_Successfully(yourbidupdatesuccessfully);

		// Your bid updated successfully is not Display in front side on qa3-2-auto

	}

	/**
	 * Too Big Amount
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Too_Big_Amount_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Auction Menu > Verify Too Big Amount translation TC_157");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String toobigamount = adminDashboardPage.Translation_To_Big_Amount_label();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_To_Big_Amount(toobigamount);

		// Too big amount is not Display in front side on qa3-2-auto

	}

	/**
	 * Too Small Amount
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Too_Small_Amount_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Auction Menu > Verify Too Small Amount translation TC_158");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String toosmallamount = adminDashboardPage.Translation_To_Small_Amount_label();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_To_Small_Amount(toosmallamount);

		// Too Small amount is not Display in front side on qa3-2-auto

	}

	/**
	 * Your bid was higher than someone
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Your_Bid_Higher_Than_Someone_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Auction Menu > Your bid Higher than someone Amount translation TC_159");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String higherbid = adminDashboardPage.Translation_Your_Bid_Was_Higher_Than_Someone_label();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Bid_Higher_Than_Someone(higherbid);
		// Your bid was higher than someone is not Display in front side on qa3-2-auto

	}

	/**
	 * Your bid was Lower than someone
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Your_Bid_Lower_Than_Someone_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Auction Menu > Your bid Lower than someone Amount translation TC_160");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String Lowerbid = adminDashboardPage.Translation_Your_Bid_Was_Lower_Than_Someone_label();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Bid_Lower_Than_Someone(Lowerbid);
		// Your bid was Lower than someone is not Display in front side on qa3-2-auto

	}

	/**
	 * You are higher bidder
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_You_Are_Higher_Bidder_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Auction Menu > You are higher bidder Amount translation TC_161");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); // Create
		// Auction
		adminDashboardPage.approveBidder1(); // Approve both bidder

		String lotname = adminDashboardPage.addLotRandom(2); // Add lot

		adminDashboardPage.start_Auction();

		String higherbidder = adminDashboardPage.Translation_You_Are_Higer_Bidder_label();
		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_You_Are_Higher_Bidder(higherbidder, auctionName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_You_Are_Higer_Bidder_label_Rename();

	}

	/**
	 * You are Low bidder
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_You_Are_Low_Bidder_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Auction Menu > You are low bidder Amount translation TC_162");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String lowbidder = adminDashboardPage.Translation_You_Are_Low_Bidder_label();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Low_Bidder(lowbidder);
		// Low bidder is not Display in front side on qa3-2-auto

	}

	
	/**
	 * Bulk Group Master
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Bulk_Group_Master_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Auction Menu > Bulk Group Master  translation TC_164");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String BulkGroup = adminDashboardPage.Translation_Bulk_Group_Master_label();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Bulk_Group(BulkGroup);

		// Bulk Group is not Display in front side on qa3-2-auto

	}

	/**
	 * Place %s or more to win the group
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Place_S_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Auction Menu > Place %s or more to win the group  translation TC_165");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String PlaceS = adminDashboardPage.Translation_Place_S_label();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Place_S(PlaceS);

		// Place S is not Display in front side on qa3-2-auto

	}

	/**
	 * Buy now!
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Buy_Now_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Buy now! translation TC_166");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); // Create
		// Auction
		adminDashboardPage.approveBidder1(); // Approve both bidder

		String lotname = adminDashboardPage.addLotRandom(1); // Add lot

		adminDashboardPage.start_Auction();
		String Buynow = adminDashboardPage.Translation_Buy_Now_label();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_BuyNow(Buynow,auctionName);

	}

	/**
	 * The auction has already started. Please bid in the auction to acquire this
	 * lot.
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_The_Auction_Has_Already_Started_CatalogMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Auction Menu > The auction has already started translation TC_167");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String Alreadystarted = adminDashboardPage.Translation_Auction_Already_Started_label();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Already_Started(Alreadystarted);
		// The auction has already started is not Display in front side on qa3-2-auto

	}

	/**
	 * Sorry you cannot buy this item anymore!.
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Sorry_You_Cannot_Buy_This_Item_Started_CatalogMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Auction Menu > Sorry you cannot buy this item anymore! translation TC_168");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String cannotbuy = adminDashboardPage.Translation_Sorry_You_Can_Not_Buy_label();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_You_Can_Not_Buy_This_Item(cannotbuy);

		// Sorry you cannot buy this item anymore!f is not Display in front side
		// on qa3-2-auto

	}

	/**
	 * This lot is currently up for bidding. Please bid in the auction to acquire
	 * it.
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Currentl_Up_For_Biddig_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Auction Menu > This lot is currently up for bidding. Please bid in the auction to acquire it. translation TC_169");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String currentlyup = adminDashboardPage.Translation_Lot_Currently_Up_For_Bidding_label();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Currently_Up_for_Bidding(currentlyup);

		// This lot is currently up for bidding Please bid in the auction to
		// acquire it is not Display in front side
		// on qa3-2-auto

	}

	/**
	 * Categories
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Categories_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Categories translation TC_170");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String category = adminDashboardPage.Translation_Category_Bidding_label();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Category(category);

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Category_Bidding_label_Rename();

	}

	/**
	 * Verify Changes Translation Catalog Menu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Verify_Changes_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Catalog Menu > Your current total spent on this item translation TC_171");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String cahnges = adminDashboardPage.Translation_Changes_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Catalog_Changes(cahnges);

	}

	/**
	 * Verify Click image to Enlarge
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Click_Image_To_EnLarge_Translation_CatalogMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Catalog Menu > Click Image to Enlarge translation TC_172");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String imagstr = adminDashboardPage.Translation_Image_EnLarge_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Catalog_Image_Enlarge(imagstr);

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Image_EnLarge_label_Rename();

	}

	/**
	 * Verify Confirm Translation Catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Confirm_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Confirm translation TC_173");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String confirm_str = adminDashboardPage.Translation_Confirm_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Confirm(confirm_str);

	}

	/**
	 * Verify Month Day Year Translation Catalog
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Month_Day_Year_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Month Day Year translation TC_174");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String mnthday_str = adminDashboardPage.Translation_Month_Day_year_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Month_Day_Year(mnthday_str);

	}

	/**
	 * Verify Hour Minute Second Translation Catalog Menu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Hour_Minute_Second_Translation_CatalogMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Catalog Menu > Hour Minute Second translation TC_175");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String HMS_str = adminDashboardPage.Translation_Hour_Minute_Second_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Hour_Minute_Second(HMS_str);

	}

	/**
	 * Verify Minute Seconds Translations Catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Minutem_Seconds_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Minute m Second s translation TC_176");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String MS_str = adminDashboardPage.Translation_Minutem_Seconds_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Minutem_Seconds(MS_str);

	}

	/**
	 * Verify Second Translation Catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Seconds_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Second s translation TC_177");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String Second_str = adminDashboardPage.Translation_Seconds_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Seconds(Second_str);

	}

	/**
	 * Verify Current Absentee Translation Catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Current_Absentee_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Current Absentee translation TC_178");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String absentee_str = adminDashboardPage.Translation_Current_Absentee_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Current_Absentee(absentee_str);

	}

	/**
	 * Verify Description Translation Catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Description_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Description translation TC_179");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String desc_str = adminDashboardPage.Translation_Description1_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Description(desc_str);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Translation_Description1_label_Rename();

	}

	/**
	 * Verify Estimate Translation Catalog menu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Estimate_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Estimate translation TC_180");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); // Create
		// Auction
		adminDashboardPage.approveBidder1_2(); // Approve both bidder

		String lotname = adminDashboardPage.addLotRandom(1); // Add lot

		adminDashboardPage.start_Auction();

		String est_str = adminDashboardPage.Translation_Estimate_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Estimate(est_str, auctionName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Estimate_label_Rename();

	}

	/**
	 * Verify Exclude Closed lots Translation catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Exclude_Closed_lots_Translation_CatalogMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Catalog Menu > Exclude closed lots translation TC_181");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String execlolot_str = adminDashboardPage.Translation_Exclude_CLosed_Lots_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Exclude_Closed_lots(execlolot_str);

	}

	/**
	 * Verify All Translation Catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_All_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > All translation TC_182");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String All_str = adminDashboardPage.Translation_All_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_All(All_str);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_All_label_Rename();
	}

	/**
	 * Verify Category Translation Catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Category_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Category translation TC_183");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String Cat_str = adminDashboardPage.Translation_Category_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Category1(Cat_str);

//		driver.get(configFileReader.getAdminUrl()); // Admin URL
//		adminDashboardPage = indexPage // Admin Signin
//				.adminSignin(adminUserName, adminPassword);
//
//		adminDashboardPage.Translation_Category_label_Rename();

		// Category label not display in front side qa3-2-auto.
	}

	/**
	 * Verify Please Finilize Your Purchase Translation Catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Please_Finalize_Your_Purchase_Translation_CatalogMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Catalog Menu > Please Finalize Your Purchase translation TC_184");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String plsfinal_str = adminDashboardPage.Translation_Finalize_your_Purchase_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Finalize_Your_Purchase(plsfinal_str);

		// Finalize Your Purchase label not display in front side qa3-2-auto.

	}

	/**
	 * Verify Paying The Invoices Translation Catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Verify_Paying_The_Invoice_Translation_CatalogMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Catalog Menu > Paying The Invoice translation TC_185");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String payingInvoice_str = adminDashboardPage.Translation_paying_The_Invoice_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Paying_The_Invoice(payingInvoice_str);

	}

	/**
	 * Verify Please Finalize Your Purchase By Translation Catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Please_Finalize_Your_Purchase_By_Translation_CatalogMenu(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Catalog Menu > Please Finalize Your Purchase By translation TC_186");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); // Create
		// Auction
		adminDashboardPage.approveBidder1(); // Approve both bidder

		String lotname = adminDashboardPage.addLotRandom(1); // Add lot

		adminDashboardPage.start_Auction();

		String purchaseby_str = adminDashboardPage.Translation_Finalize_Your_Purchase_By_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Finalize_Your_Purchase_By(purchaseby_str, lotname, auctionName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Finalize_Your_Purchase_By_label_Rename();

	}

	/**
	 * Verify Force Bid Translation Catalog menu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Force_Bid_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Force Bid translation TC_187");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String forcebid_str = adminDashboardPage.Translation_Force_Bid_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Force_Bid(forcebid_str);

	}

	/**
	 * Verify Invalid ForceBid Translation catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Invalid_Force_Bid_Translation_CatalogMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Invalid Force Bid translation TC_188");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String Inforcebid_str = adminDashboardPage.Translation_Invalid_Force_Bid_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Invalid_Force_Bid(Inforcebid_str);

	}

	/**
	 * Verify Forcebid of percentage translation catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Force_Bid_Of_Percentage_Translation_CatalogMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Force bid of %s%s translation TC_189");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String forcebid_str = adminDashboardPage.Translation_Force_Bid_Of_Percentage_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Force_Bid_Of_Percentage(forcebid_str);

	}

	/**
	 * Verify Force bid amount to bid for asking bid translation catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Force_Bid_Ammount_To_Big_For_Asking_Bid_Translation_CatalogMenu(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Catalog Menu > Force bid amount is too big for asking bid  translation TC_190");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String forcebid_str = adminDashboardPage.Translation_Force_Bid_Too_Big_For_Asking_bid_label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Force_Bid_To_Big_For_Asking_Bid(forcebid_str);

	}

	/**
	 * To place bids on this lot please go to the live sale page.
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_To_Place_Bid_On_This_Lot_Please_Goto_CatalogMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Auction Menu > To place bids on this lot please go to the live sale page translation TC_191");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String placebid = adminDashboardPage.Translation_To_Place_Bid_On_This_Lot_label();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Place_Bid_On_This_Lot_label(placebid);

		// Please bid in the auction to
		// acquire it is not Display in front side
		// on qa3-2-auto

	}

	
	/**
	 * High To Low
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_High_To_Low_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > High To Low TC_193");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hightolow = adminDashboardPage.Translation_High_To_lOW_label();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_High_To_Low(hightolow);

		// High to low is not Display in front side
		// on qa3-2-auto

	}

	/**
	 * Invalid or Bid
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Invalid_or_Bid_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Invalid Bid >> TC_194");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String invalidbid = adminDashboardPage.Translation_Invalid_or_Bid_label();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Invalid_bid(invalidbid);
		// High to low is not Display in front side
		// on qa3-2-auto

	}

	/**
	 * An invoice will be issued and sent to you shortly.
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Invoice_Issued_Shortly_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Auction Menu > An invoice will be issued and sent to you shortly. >> TC_195");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); // Create
		// Auction
		adminDashboardPage.approveBidder1(); // Approve both bidder

		String lotname = adminDashboardPage.addLotRandom(2); // Add lot

		adminDashboardPage.start_Auction();

		String issueshort = adminDashboardPage.Translation_Invoice_Will_Issued_label();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl()); // Admin Login

		adminDashboardPage = indexPage.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno);

		// User Login

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Issued_Shorlty_bid(issueshort, auctionName);

		driver.get(configFileReader.getAdminUrl());
		// Admin Login

		adminDashboardPage = indexPage.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Invoice_Will_Issued_label_Rename();

	}

	/**
	 * Item Number
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Item_Number_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Item Number >> TC_196");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String itemnumber = adminDashboardPage.Translation_Item_Number_label();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Item_Number_bid(itemnumber);
		// Item Number is not Display in
		// front side
		// on qa3-2-auto

	}

	/**
	 * Loading
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Loading_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Loading >> TC_197");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String loading = adminDashboardPage.Translation_Loading_label();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Loading_bid(loading);
		// Loading is not Display in
		// front side
		// on qa3-2-auto

	}

	/**
	 * Lot %s of %s
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Lot_S_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu >Lot %s of %s >> TC_198");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String lots = adminDashboardPage.Translation_Lot_S_label();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Lot_S(lots);
		// lot s catalog is not Display in
		// front side
		// on qa3-2-auto

	}

	/**
	 * You are already registered for this. Please reload the page
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_You_Already_Register_For_That_CatalogMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Auction Menu >You are already registered for this. Please reload the page >> TC_199");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String register = adminDashboardPage.Translation_You_Already_Registered_For_This_label();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_You_Already_Register_For_That(register);
		// Loading is not Display in
		// front side
		// on qa3-2-auto

	}

	/**
	 * Accept lot changes
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Accept_Lot_Changes_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Accept lot changes >> TC_200");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String acceptlotchanges = adminDashboardPage.Translation_Accept_Lot_Changes_label();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Accept_Lot_Changes(acceptlotchanges);
		// Accept lot changes is not Display in
		// front side
		// on qa3-2-auto

	}

	/**
	 * Lot closed!
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Lot_Closed_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Lot Closed! >> TC_201");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String lotclosed = adminDashboardPage.Translation_Lot_Closed_label();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Lot_Closed(lotclosed);
		// Lot Closed is not Display in
		// front side
		// on qa3-2-auto

	}

	/**
	 * Click on left/ right side of image to see previous/ next image
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Image_Left_Right_Preview_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Auction Menu > Click on left/ right side of image to see previous/ next image >> TC_202");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String strimage = adminDashboardPage.Translation_Image_Left_Right_label();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Image_Left_Right(strimage);
		// Image left right preview is not Display in
		// front side
		// on qa3-2-auto

	}

	/**
	 * Are you sure you want to sell this lot to this bidder at %s
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Sell_Lot_To_Bidder_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Auction Menu > Are you sure you want to sell this lot to this bidder at %s >> TC_203");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String selllot = adminDashboardPage.Translation_Sell_Lot_To_Bidder_label();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Sell_Lot_To_Bidder(selllot);
		// Sell Lot to bidder is not Display in
		// front side
		// on qa3-2-auto

	}

	/**
	 * Lot %s is already started in the live sale.
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Lot_Already_Started_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Auction Menu > Lot %s is already started in the live sale >> TC_204");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); // Create
		// Auction
		adminDashboardPage.approveBidder1(); // Approve both bidder

		String lotname = adminDashboardPage.addLotRandom(1); // Add lot

		adminDashboardPage.start_Auction();

		String lotstarted = adminDashboardPage.Translation_Lot_Already_Started_label();
		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Lot_Started_Bidder(lotstarted, auctionName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Lot_Already_Started_label_Rename();

	}

	/**
	 * %s item(s) successfully added to your watchlist
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Item_Added_Successfully_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Auction Menu > Item Added Successfully to watchlist >> TC_205");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); // Create
		// Auction
		adminDashboardPage.approveBidder1(); // Approve both bidder

		String lotname = adminDashboardPage.addLotRandom(1); // Add lot

		adminDashboardPage.start_Auction();

		adminDashboardPage.Translation_Successfully_Added_To_WatchList_label();

		adminDashboardPage.front();

		// User 1
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.goto_Catalog_Page_Live_Sale(auctionName);

		dashboardPage.Verify_Added_to_Watchlist_Message(); // Verify Watchlist
		// Message

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Translation_Successfully_Added_To_WatchList_label_Rename();

	}

	/**
	 * Low to High
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Low_To_High_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Low to High >> TC_206");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String lowtohigh = adminDashboardPage.Translation_Low_To_High_label();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Low_To_High(lowtohigh);
		// Low to high is not Display in
		// front side
		// on qa3-2-auto

	}

	/**
	 * max bid of %s%s
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Max_Bid_Of_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > max bid of %s%s >> TC_207");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String maxbid = adminDashboardPage.Translation_Max_Bid_Of_label();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Max_Bid(maxbid);
		// max bid of %s%s is not Display in
		// front side
		// on qa3-2-auto

	}

	/**
	 * Bidding on multiple lots at once is not permitted. Please enter your bid
	 * amount and click the bid button for each lot individually.
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Multiple_Lots_Bidding_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Auction Menu > Bidding on multiple lots at once is not permitted. Please enter your bid amount and click the bid button for each lot individually. >> TC_208");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String bidmultiple = adminDashboardPage.Translation_Bidding_On_Multiple_Lots_label();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Bidding_On_Multiple_Lots(bidmultiple);
		// Multiple lots at once is not permitted is not Display in
		// front side
		// on qa3-2-auto

	}

	/**
	 * My Max Bid
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_My_Max_Bid_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > My Max Bid >> TC_209");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String maxbid = adminDashboardPage.Translation_My_Max_Bid_label();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_My_Max_Bid(maxbid);
		// Max Bid is not Display in
		// front side
		// on qa3-2-auto

	}

	/**
	 * My Min Bid
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_My_Min_Bid_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > My Min Bid >> TC_210");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String minbid = adminDashboardPage.Translation_My_Min_Bid_label();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_My_Min_Bid(minbid);
		// Min Bid is not Display in
		// front side
		// on qa3-2-auto

	}

	/**
	 * Bid
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Bid_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Bid >> TC_211");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String bid = adminDashboardPage.Translation_Bid_label();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Bid(bid);
		// Bid is not Display in
		// front side
		// on qa3-2-auto

	}

	/**
	 * Next
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Next_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Next >> TC_212");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String next = adminDashboardPage.Translation_Next_label();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Next(next);
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Next_label_Rename();

	}

	/**
	 * No valid bids yet
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_No_Valid_Bids_Yet_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > No valid bids yet >> TC_213");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String novalidbid = adminDashboardPage.Translation_No_Valid_Bids_Yet_label();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_No_Valid_Bids_Yet(novalidbid);
		// No Valid Bids is not Display in
		// front side
		// on qa3-2-auto

	}

	/**
	 * Change offer
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Change_offer_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Change offer >> TC_214");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String changeoffer = adminDashboardPage.Translation_Change_Offer_label();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Change_Offer(changeoffer);
		// Change Offer is not Display in
		// front side
		// on qa3-2-auto

	}

	/**
	 * Your offer has been declined
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Your_Offer_Has_Been_Declined_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Auction Menu > Your offer has been declined >> TC_215");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String yourofferdecline = adminDashboardPage.Translation_Your_Offer_Has_Been_Declined_label();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Your_Offer_Has_Been_Declined(yourofferdecline);
		// Your Offer Has been Declined is not Display in
		// front side
		// on qa3-2-auto

	}

	/**
	 * Make Offer
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Make_Offer_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Make Offer >> TC_216");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String makeoffer = adminDashboardPage.Translation_Make_Offer_label();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Make_Offer(makeoffer);
		// Make Offer is not Display in
		// front side
		// on qa3-2-auto

	}

	/**
	 * Sorry you don't have bidder privileges to place bid/buy/make offer.
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Sorry_You_Dont_Have_Bidder_Privileges_CatalogMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Auction Menu > Sorry you don't have bidder privileges to place bid/buy/make offer >> TC_217");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String Bidderpri = adminDashboardPage.Translation_Dont_Have_Bidder_Privileges_label();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_You_Dont_Have_Bidder_Privileges(Bidderpri);
		// Sorry you don't have bidder privileges to place bid/buy/make offer is
		// not Display in
		// front side
		// on qa3-2-auto

	}

	/**
	 * Your offer has been submitted - Please check your email for response.
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Your_Offer_Has_Been_Submitted_Email_Response_CatalogMenu(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Auction Menu > Your offer has been submitted - Please check your email for response >> TC_218");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String offersubmit = adminDashboardPage.Translation_Offer_Has_been_Submitted_Email_Label();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Offer_Has_Been_Submited(offersubmit);
		// Your offer has been submitted is not Display in
		// front side
		// on qa3-2-auto

	}

	/**
	 * Your offer has been submitted!
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Your_Offer_Has_Been_Submitted_CatalogMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Auction Menu > Your offer has been submitted! >> TC_219");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String offerEsubmit = adminDashboardPage.Translation_Offer_Has_been_Submitted_Label();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Offer_Has_Been_Submited(offerEsubmit);
		// Your offer has been submitted is not Display in
		// front side
		// on qa3-2-auto

	}

	/**
	 * Your offer
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Your_Offer_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Your offer >> TC_220");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String offer = adminDashboardPage.Translation_Offer_Label();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Offer_Has_Been_Submited(offer);
		// Your offer is not Display in
		// front side
		// on qa3-2-auto

	}

	/**
	 * Opening bid
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Opening_Bid_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Auction Menu > Opening bid >> TC_221");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String openbid = adminDashboardPage.Translation_Opening_Bid_Label();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Opening_Bid(openbid);
		// Opening bid is not Display in
		// front side
		// on qa3-2-auto

	}

	/**
	 * Verify In this Column Translation Catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_In_This_Column_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >In This Column translation TC_222");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String InthisColumn_str = adminDashboardPage.Translation_In_This_Column_You_Can_Assign_An_OR_Bid_Number_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_In_This_Column(InthisColumn_str);

		// Verify in this column is not Display in
		// front side
		// on qa3-2-auto

	}

	/**
	 * 
	 * Verify Other Lots in this sale translation catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Other_Lots_In_This_Sale_Translation_CatalogMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Other Lots In Sale translation TC_223");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String OtherlotinSale_str = adminDashboardPage.Translation_Othe_Lot_In_Sale_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Other_Lots_in_Sale(OtherlotinSale_str);
		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Othe_Lot_In_Sale_Label_Rename();

	}

	/**
	 * Verify Lots Translation Catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Lots_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Lots translation TC_224");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String Lots_str = adminDashboardPage.Translation_Lots_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Lots(Lots_str);

		// Lots is not Display in
		// front side
		// on qa3-2-auto

	}

	
	/**
	 * Auction
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Auction_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Auction TC_229");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String Auction = adminDashboardPage.Translation_Auction_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Auction(Auction);

		// Auction is not displays on front end qa3-2-auto.

	}

	/**
	 * PDF Catalog
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_PDF_Catalog_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > PDF Catalog TC_230");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String pdfcatalog = adminDashboardPage.Translation_PDF_Catalog_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_PDF_Catalog(pdfcatalog);

		// PDF is not displays on front end qa3-2-auto.
	}

	/**
	 * Lot
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Lot_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Lot TC_231");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String Lot = adminDashboardPage.Translation_Lot_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Lot_Catalog(Lot);

		// Lot is not displays on front end qa3-2-auto.
	}

	/**
	 * PDF Prices Realized
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Pdf_Prices_Realized_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Pdf Prices TC_232");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String PDFprices = adminDashboardPage.Translation_PDF_Prices_Realized_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_PDF_Prices(PDFprices);

		// PDF is not displays on front end qa3-2-auto.

	}

	/**
	 * Piecemeal lot Competes against %s
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Piecemeal_Lot_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Catalog Menu > Piecemeal lot Competes against %s TC_233");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String PDFprices = adminDashboardPage.Translation_Piecemeal_Lot_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Piecemeal_Lot(PDFprices);

		// Piecemeal is not displays on front end qa3-2-auto.
	}

	/**
	 * Place multiple bids
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Place_Multiple_Bids_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Place multiple bids TC_234");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); // Create
		// Auction
		adminDashboardPage.approveBidder1(); // Approve both bidder

		String lotname = adminDashboardPage.addLotRandom(1); // Add lot

		adminDashboardPage.start_Auction();

		String placembid = adminDashboardPage.Translation_Place_Multiple_Bids_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Place_Multiple_Bid_Button_Lot(placembid, auctionName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Place_Multiple_Bids_Label_Rename();
	}

	/**
	 * Previous
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Previous_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Previous TC_235");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); // Create
		// Auction
		adminDashboardPage.approveBidder1(); // Approve both bidder

		String lotname = adminDashboardPage.addLotRandom(2); // Add lot

		adminDashboardPage.start_Auction();

		String previous = adminDashboardPage.Translation_Previous_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Previous_Link_Label(previous, auctionName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Previous_Label_Rename();
	}

	/**
	 * Price
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Price_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Price TC_236");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String price = adminDashboardPage.Translation_Price_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Price(price);

		// Price is not display in Front end qa3-2-auto.
	}

	/**
	 * Quantity
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Quantity_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Quantity TC_237");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String quantity = adminDashboardPage.Translation_Quantity_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Quantity(quantity);

		// Quantity is not display in Front end qa3-2-auto.
	}

	/**
	 * By bidding on this lot you commit to your bid x
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_By_Bidding_On_This_Lot_Commit_To_Your_Bid_CatalogMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Catalog Menu > By bidding on this lot you commit to your bid x  TC_238");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String str_bidlot = adminDashboardPage.Translation_Bidding_On_This_Lot_You_Commit_To_Your_Bid_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_By_Bidding_On_This_Lot(str_bidlot);

		// By bidding on this lot you commit to your bid x is not display in
		// Front end qa3-2-auto.
	}

	/**
	 * We have received your payment.
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_We_Have_Received_Your_payments_CatalogMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Catalog Menu > We have received your payment >>  TC_239");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String received = adminDashboardPage.Translation_We_Have_Received_Your_Payment_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_We_Have_Received_Your_Payment(received);

		// Verify We have received your payment is not display in
		// Front end qa3-2-auto.
	}

	/**
	 * Remove From WatchList
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Remove_From_WatchList_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Remove From WatchList >>  TC_240");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String received = adminDashboardPage.Translation_Remove_From_WatchList_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Remove_From_Watch_List(received);

		// Remove From WatchList is not display in
		// Front end qa3-2-auto.
	}

	/**
	 * Reserve met
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Reserve_Met_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Reserve met >>  TC_241");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String Reservemet = adminDashboardPage.Translation_Reserve_Met_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Reserve_Met(Reservemet);

		// Reserve met is not display in
		// Front end qa3-3-auto.
	}

	/**
	 * Reserve not met
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Reserve_Not_Met_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Remove Not Met >>  TC_242");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String Reservemet = adminDashboardPage.Translation_Reserve_Not_Met_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Reserve_Not_Met(Reservemet);

		// Reserve not met is not display in
		// Front end qa3-2-auto.
	}

	/**
	 * Reset search
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Reset_Search_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Reset search >>  TC_243");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String reset = adminDashboardPage.Translation_Reset_Search_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Reset_Search(reset);

		// Reset search is not display in
		// Front end qa3-2-auto.
	}

	/**
	 * Artist's Statement
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Artist_Statement_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Artist's Statement >>  TC_244");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String artiststatment = adminDashboardPage.Translation_Artist_Statement_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Artist_Statement(artiststatment);

		// Artist's Statement is not display in
		// Front end qa3-2-auto.
	}

	

	/**
	 * Please select at least 1 item
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Please_Select_at_List_1_Item_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Catalog Menu >  Please select at least 1 item >>  TC_249");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); // Create
		// Auction
		adminDashboardPage.approveBidder1(); // Approve both bidder

		String lotname = adminDashboardPage.addLotRandom(1); // Add lot

		adminDashboardPage.start_Auction();

		String str_selectone = adminDashboardPage.Translation_Select_at_List_One_Item_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Select_at_List_One_Item(str_selectone, auctionName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Select_at_List_One_Item_Label_Rename();

	}

	/**
	 * Lot
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Lot1_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Lot >>  TC_250");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String str_lot2 = adminDashboardPage.Translation_Lot2_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Lot2(str_lot2);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Lot2_Label_Rename();

	}

	/**
	 * Verify Sold Label Translation Catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Sold_Label_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Sold translation TC_251");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String sold_str = adminDashboardPage.Translation_Sold_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Sold(sold_str);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Sold_Label_Rename();

	}

	/**
	 * Verify Sold With Reservation Label Translation Catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Sold_With_Reservation_Label_Translation_CatalogMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Catalog Menu >Sold With Reservation translation TC_252");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String sold_reservation_str = adminDashboardPage.Translation_Sold_With_Reservation_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Sold_With_Reservation(sold_reservation_str);

		// Sold With Reservation Not Display in front Side on V3

	}

	/**
	 * Verify Sold Through Buy Now Label Translation Catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Sold_Through_Buy_Now_Label_Translation_CatalogMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Catalog Menu >Sold Through Buy Now translation TC_253");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String sold_buynow_str = adminDashboardPage.Translation_Sold_Through_BuyNow_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Sold_Through_BuyNow(sold_buynow_str);

		// Sold Through Buy Now Not Display in front Side on V3

	}

	/**
	 * Verify Sort Label Translation Catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Sort_Label_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Sort translation TC_254");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String sort_str = adminDashboardPage.Translation_Sort_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Sort_Label(sort_str);
		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Sort_Label_Rename();
		// Sort label not display at front qa3-2-auto
	}

	/**
	 * Verify Bids Label Translation Catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Bids_Label_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Bids translation TC_255");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String bids_str = adminDashboardPage.Translation_Bids_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Bids_Label(bids_str);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Bids_Label_Rename();

	}

	/**
	 * 
	 * Verify Catagory Label Translation catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Category_Label_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >category translation TC_256");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String cat_str = adminDashboardPage.Translation_Category_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Category_Label(cat_str);

		// Category Not Display in front Side on V3
	}

	/**
	 * Verify Estimate Label Transalation Catalog
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Estimate_Label_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Estimate translation TC_257");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String est_str = adminDashboardPage.Translation_Estimate_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Estimate_Label(est_str);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Estimate_Label_Rename();

	}

	/**
	 * Verify Item Label Translation Catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Item_Label_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Item translation TC_258");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String item_str = adminDashboardPage.Translation_Item_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Item_Label(item_str);

		// Item Not Display in front Side on V3
	}

	/**
	 * Verify Lot Label Translation Catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Lot_Label_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Lot# translation TC_259");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String lot_str = adminDashboardPage.Translation_Lot_Label1();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Lot_Label(lot_str);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Lot_Label1_Rename();

	}

	/**
	 * Verify Name Label Translation Catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Name_Label_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Name translation TC_260");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String name_str = adminDashboardPage.Translation_Name_Label1();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Name_Label(name_str);

		// Name is Not Display in front Side on V3
	}

	/**
	 * Verify Starting Current Bid Label Translation Catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Starting_Current_Bid_Label_Translation_CatalogMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Catalog Menu >Starting/Current Bid translation TC_261");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String St_CurBid_str = adminDashboardPage.Translation_Starting_Current_Bid_Label1();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Starting_Current_Bid_Label(St_CurBid_str);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Starting_Current_Bid_Label1_Rename();

	}

	/**
	 * Verify Time left label translation catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Time_Left_Label_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Time Left translation TC_262");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String timeleft_str = adminDashboardPage.Translation_Time_Left_Label1();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Time_Left_Label(timeleft_str);

		// Time Left Not Display in front Side on V3
	}

	/**
	 * Verify views label translation catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Views_Label_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Time Left translation TC_263");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String views_str = adminDashboardPage.Translation_Views_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Views_Label(views_str);

	}

	/**
	 * Verify Special terms label translation catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Special_Terms_Label_Translation_CatalogMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Special Terms translation TC_264");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String special_str = adminDashboardPage.Translation_Special_Terms_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Special_Terms_Label(special_str);

		// Special Terms Not Display in front Side on V3

	}

	/**
	 * Verify Starting label translation catalogmenu
	 * 
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Starting_Label_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Starting translation TC_265");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String starting_str = adminDashboardPage.Translation_Starting_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Starting_Label(starting_str);

		// Starting Not changed in front Side on qa3-2-1uto

	}

	/**
	 * Verify Status Label Translation Catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Status_Label_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Status translation TC_266");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String status_Str = adminDashboardPage.Translation_Status_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Status_Label1(status_Str);

		// Status Not Display in front Side on qa3-2-auto

	}

	/**
	 * Verify Stop Absentee Bid Label Translation Catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Stop_Absentee_Bid_Label_Translation_CatalogMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Catalog Menu >Stop Absentee Bidding at translation TC_267");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String stopabs_Str = adminDashboardPage.Translation_Stop_Absentee_Bidding_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Stop_Absentee_Bidding_At_Label(stopabs_Str);

	}

	/**
	 * Verify Submit Label Translation catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Submit_Label_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Submit translation TC_268");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String submit_Str = adminDashboardPage.Translation_Submit_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Submit_Label(submit_Str);

	}

	/**
	 * Verify Buy now label translation catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Buy_Now_Label_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Buy Now translation TC_269");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String buynow_Str = adminDashboardPage.Translation_BuyNow_Label();

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); // Create
		// Auction
		adminDashboardPage.approveBidder1(); // Approve both bidder

		String lotname = adminDashboardPage.addLotRandom(1); // Add lot

		adminDashboardPage.start_Auction();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_BuyNow_Label(buynow_Str, auctionName);

	}

	/**
	 * Verify Estimate Label transaltion catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Estimate_Label1_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Estimate translation TC_270");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String estimate_Str = adminDashboardPage.Translation_Estimate_Label1();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Estimate_Label1(estimate_Str);

		// Estimate label not display in qa3-2-auto at front-end side
	}

	/**
	 * Verify Image
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Image_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >> Image translation TC_271");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String image = adminDashboardPage.Translation_Image_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Image(image);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Image_Label_Rename();

	}

	/**
	 * Item Title
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Item_Title_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >> Image translation TC_272");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String itemtitle = adminDashboardPage.Translation_Item_Title_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Item_Title(itemtitle);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Item_Title_Label_Rename();

		// Item label not display at front-end side in qa3-2-auto environment
	}

	/**
	 * Lot #
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Lot_Hash1_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >> Lot # TC_273");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String lot = adminDashboardPage.Translation_Lot_Has1_Title_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Lot_hash(lot);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Lot_Has1_Title_Label_Rename();
		// Lot # label not display at front-end side in qa3-2-auto environment
	}

	/**
	 * My Max Bid
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Lot_My_Max_Bid_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >> My Max Bid TC_274");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String mymax = adminDashboardPage.Translation_My_Max_Bid_Title_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_My_Max(mymax);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_My_Max_Bid_Title_Label_Rename();

		// My Max Bid label not display changed at front-end side in qa3-2-auto
		// environment

	}

	/**
	 * My Min Bid
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Lot_My_Min_Bid_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >> My Min Bid TC_275");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String mymin = adminDashboardPage.Translation_My_Min_Bid_Title_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_My_Min(mymin);

		// My min is not display in front end qa3-2-auto
	}

	/**
	 * OR
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_OR_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >> OR TC_276");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String or = adminDashboardPage.Translation_OR_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_OR(or);
		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_OR_Label_Rename();
	}

	/**
	 * Price
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Price1_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >> Price TC_277");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String price = adminDashboardPage.Translation_Price_Label1();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Price1(price);
		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Price_Label_Rename();
	}

	/**
	 * Asking Bid
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Asking_Bid_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >> Asking Bid TC_278");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String askingbid = adminDashboardPage.Translation_Asking_Bid();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Asking_Bid(askingbid);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Asking_Bid_Rename();
	}

	/**
	 * Asking Bid
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Buynow_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >> BuyNow TC_279");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); // Create
		// Auction
		adminDashboardPage.approveBidder1(); // Approve both bidder

		String lotname = adminDashboardPage.addLotRandom(1); // Add lot

		adminDashboardPage.start_Auction();

		String buynow = adminDashboardPage.Translation_Buynow_Bid();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_BuyNow1(buynow, auctionName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Buynow_Bid_Rename1();
		// BuyNow label not displayat front side changed in qa3-2-auto enviroment

	}

	/**
	 * Current Bid
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Current_Bid_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >> Current Bid TC_280");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String currentbid = adminDashboardPage.Translation_Current_Bid();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Current_Bid(currentbid);

		// Current bid is not display in frontend qa3-2-auto.
	}

	

	/**
	 * Starting Bid
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Starting_Bid_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >> Starting Bid TC_282");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); // Create
		// Auction
		adminDashboardPage.approveBidder1(); // Approve both bidder

		String lotname = adminDashboardPage.addLotRandom(1); // Add lot

		adminDashboardPage.start_Auction();

		String startingbid = adminDashboardPage.Translation_Starting_Bid();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Starting_Bid(startingbid, auctionName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Starting_Bid_Rename();

	}

	/**
	 * Winning Bid
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Winning_Bid_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >> Winning Bid TC_283");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String winbid = adminDashboardPage.Translation_Winning_Bid();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Winning_Bid(winbid);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Winning_Bid_Rename();

	}

	/**
	 * Quantity
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Quantity1_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >> Quantity TC_284");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String winbid = adminDashboardPage.Translation_Quantity_Label1();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Quantity1(winbid);

		// Verify Quantity is not dispaly in qa3-2-auto front ennd.

	}

	/**
	 * Time Left
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Time_Left_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >> Time Left TC_285");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String timeleft = adminDashboardPage.Translation_Time_Left_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Time_Left(timeleft);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Time_Left_Label_Rename();

	}

	/**
	 * Warranty
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Warranty_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >> Warranty > TC_286");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String warranty = adminDashboardPage.Translation_Warranty_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Warranty(warranty);

		// Warranty is not display in front end qa3-2-auto

	}

	/**
	 * ?
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_QuestionMark_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >> ? > TC_287");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String ques = adminDashboardPage.Translation_Question_Mark_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Question_Mark(ques);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Question_Mark_Label();

	}

	/**
	 * Your bids
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Your_Bids_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >> Your Bids > TC_288");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String Ybids = adminDashboardPage.Translation_Your_Bids_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Your_Bids(Ybids);

		// Verify your bids is not display in front end qa3-2-auto.

	}

	/**
	 * Tell a friend
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Tell_a_Friend_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >> Tell a friend > TC_289");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String TellFriend = adminDashboardPage.Translation_Tell_Friend_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Tell_Friend(TellFriend);

		// Verify Tell a Friend is not display in front end

	}

	/**
	 * Terms and Condition
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Terms_And_Condition_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >> Terms and conditions > TC_290");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); // Create
		// Auction
		adminDashboardPage.approveBidder1(); // Approve both bidder

		String lotname = adminDashboardPage.addLotRandom(1); // Add lot

		adminDashboardPage.start_Auction();

		String termsandcon = adminDashboardPage.Translation_Terms_And_Condition_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Terms_And_Condition(termsandcon, auctionName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Terms_And_Condition_Label_Rename1();

	}

	/**
	 * Verify time left label translation catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Time_Left_Label1_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Time Left translation TC_291");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String timeleft_Str = adminDashboardPage.Translation_TImeLeft_Label1();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Time_Left_Label1(timeleft_Str);

		// Time Left Not Display in front Side on V3
	}

	/**
	 * Verify Ended Label translation catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Ended_Label_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Ended translation TC_292");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String ended_Str = adminDashboardPage.Translation_Ended_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Ended_Label(ended_Str);

		// Ended Not Display in front Side on V3
	}

	/**
	 * Verify Unawarded label translation catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_UnAwarded_Label_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >UnAwarded translation TC_293");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String award_Str = adminDashboardPage.Translation_UnAwarded_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_UnAwarded_Label(award_Str);

		// UnAwarded Not Display in front Side on V3
	}

	/**
	 * Verify upcoming label translation catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Upcoming_Label_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Upcoming translation TC_294");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String upcoming_Str = adminDashboardPage.Translation_UpComing_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_UpComing_Label(upcoming_Str);

		// Upcoming Not Display in front Side on V3
	}

	/**
	 * Verify view details translation catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_View_Details_Translation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >View Details translation TC_295");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String Viewdetail_Str = adminDashboardPage.Translation_ViewDetails_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_ViewDetails_Label(Viewdetail_Str);

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_ViewDetails_Label_Rename();

	}

	/**
	 * Verify view full catalog for translation catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_View_Full_Catalog_For_Translation_CatalogMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Catalog Menu >View Full catalog For translation TC_296");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String ViewFullCat_Str = adminDashboardPage.Translation_View_Full_catalog_For_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_View_Full_Catalog_For_Label(ViewFullCat_Str);

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_View_Full_catalog_For_Label_Rename();

		// View Catalog label not display changed in qa3-2-auto Environment
	}

	/**
	 * Verify view full catalog for translation catalogmenu1
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_View_Full_Catalog_For_Translation_CatalogMenu1(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Catalog Menu >View Full catalog For translation TC_297");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String ViewFullCat_Str = adminDashboardPage.Translation_View_Full_catalog_For_Label1();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_View_Full_Catalog_For_Label(ViewFullCat_Str);
		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_View_Full_catalog_For_Label1_Rename();
	}

	/**
	 * Verify view my watchlist translation catalogmenu1
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_View_My_Watchlist_Translation_CatalogMenu1(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >View My WatchList translation TC_298");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String ViewMywatch_Str = adminDashboardPage.Translation_View_My_watchList_Label1();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_View_My_WatchList_Label(ViewMywatch_Str);
		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_View_My_watchList_Label1_Rename();
	}

	/**
	 * Verify warranty translation catalogmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Warranty_Translation_CatalogMenu1(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Warranty translation TC_299");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String Warranty_Str = adminDashboardPage.Translation_Warranty_Label1();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Warranty_Label(Warranty_Str);

		// Warranty Not Display in front Side on qa3-2-auto environment

	}

	/**
	 * Verify Add to watchlist transaltion
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Add_To_watchlist_Translation_CatalogMenu1(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Warranty translation TC_300");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String AddtoWatchlist_Str = adminDashboardPage.Translation_Add_To_Watchlist_Label1();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Add_To_Watchlist_Label(AddtoWatchlist_Str);
		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Add_To_Watchlist_Label1_Rename();
	}

	/**
	 * Winning Bid
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Winning_Bid1_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >> Winning Bid  > TC_301");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String winbid = adminDashboardPage.Translation_Winning_Bid1_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Winning_Bid1(winbid);

		// Winning Bid is not display in qa3-2-auto.

	}

	/**
	 * You Won
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_You_Won_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >> You Won  > TC_302");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); // Create
		// Auction
		adminDashboardPage.approveBidder1(); // Approve both bidder

		String lotname = adminDashboardPage.addLotRandom(1); // Add lot

		adminDashboardPage.start_Auction();

		String youwon = adminDashboardPage.Translation_You_Won_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.place_Bid_On_Live_Auction(saleno, auctionName);

		driver.get(configFileReader.getAdminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.accept_And_Sell_Feature(auctionName, saleno);

		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_You_Won(youwon, auctionName);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_You_Won_Label_Rename();

	}

	/**
	 * You won this item with reservation!
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_You_Won_Reservation_CatalogMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Catalog Menu >> You won this item with reservation! > TC_303");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String wonres = adminDashboardPage.Translation_You_Won_Reservation_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_You_Won_Reservation(wonres);

		// You Won Reservation is not display in qa3-2-auto.

	}

	// Search Menu

	/**
	 * Veriy Auction items translation serach menu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Auction_Items_Translation_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Auction Items translation TC_304");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String AuctionItem_Str = adminDashboardPage.Translation_Auction_items_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Auction_Items_Label(AuctionItem_Str);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Auction_items_Label_Rename();
	}

	/**
	 * Verify Account transltion search menu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Account_Translation_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Account translation TC_305");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String Account_Str = adminDashboardPage.Translation_Account_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Accountt_Label(Account_Str);

		// Account label is not present in front side on qa3-2-auto
	}

	/**
	 * Verify auctioneer transtion search menu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Auctioneer_Translation_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Auctioneer Items translation TC_306");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String Auctioneer_Str = adminDashboardPage.Translation_Auctioneer_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Auctioneerr_Label(Auctioneer_Str);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Auctioneer_Label_Rename();
	}

	/**
	 * Verify Auction Translation search menu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Auctions_Translation_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Auctions translation TC_307");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String Auctions_Str = adminDashboardPage.Translation_Auctions_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Auctions_Label(Auctions_Str);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Auctions_Label_Rename();

		// Auctions label not display changed at front-end side in qa3-2-auto
		// environment
	}

	/**
	 * Verify Best Offer Translation Search menu
	 *
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Best_Offer_Translation_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Best Offer translation TC_308");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String Bestoff_Str = adminDashboardPage.Translation_Best_Offer_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Best_Offer_Label(Bestoff_Str);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Best_Offer_Label_Rename();

		// Best Offer label not display at front-end side in qa3-2-auto environment
	}

	/**
	 * Verify buy now translation search menu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Buy_Now_Translation_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Buy Now translation TC_309");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String BuyNow_Str = adminDashboardPage.Translation_Buy_Now_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Buy_Now_Label(BuyNow_Str);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Buy_Now_Label_Rename();
	}

	/**
	 * Verify Featured trnaslation search menu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Featured_Translation_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Featured translation TC_310");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String Featured_Str = adminDashboardPage.Translation_Featured_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Featured_Label(Featured_Str);

		// Featured label is not displayed in front side on qa3-2-auto
	}

	/**
	 * Verify Filter Search menu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Filter_By_Translation_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Filter By translation TC_311");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String FilterBy_Str = adminDashboardPage.Translation_Filter_By_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Filter_By_Label(FilterBy_Str);

		// Filter By label is not present in front side on qa3-2-auto
	}

	/**
	 * Verify hybrid auction in search menu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Hybrid_Auctions_Translation_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Hybrid Auctions translation TC_312");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String HybridAuc_Str = adminDashboardPage.Translation_Hybrid_Auctions_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Hybrid_Action_Label(HybridAuc_Str);

		// Hybrid Auctions label is not present in front side on qa3-2-auto
	}

	/**
	 * Verify Live Auction translation search menu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Verify_Live_Auctions_Translation_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Live Auctions translation TC_313");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String LiveAuc_Str = adminDashboardPage.Translation_Live_Auctions_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Live_Action_Label(LiveAuc_Str);

	}

	/**
	 * verify lot number in search menu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Lot_Number_Translation_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Lot Number translation TC_314");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String LotNumber_Str = adminDashboardPage.Translation_Lot_Number_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Lot_Number_Label(LotNumber_Str);

		// Lot Number label is not present in front side on qa3-2-auto
	}

	/**
	 * verify price translation search menu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Price_Translation_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Price translation TC_315");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String Price_Str = adminDashboardPage.Translation_Price_Labell();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Price_Label(Price_Str);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Price_Label_Rename1();

		// price label not display front-end side in qa3-2-auto environment

	}

	/**
	 * Verify max translation search menu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Max_Translation_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Max translation TC_316");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String Max_Str = adminDashboardPage.Translation_Max_Labell();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Max_Label(Max_Str);

		// Max label is not present in front side on V3.1
	}

	/**
	 * verify min translation search menu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Min_Translation_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Min translation TC_317");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String Min_Str = adminDashboardPage.Translation_Min_Labell();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Min_Label(Min_Str);

		// Min label is not present in front side on qa3-2-auto
	}

	/**
	 * Verify sort by translation search menu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Sort_By_Translation_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Sort By translation TC_318");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String Sort_Str = adminDashboardPage.Translation_Sort_By_Labell();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Sort_By_Label(Sort_Str);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Sort_By_Label_Rename();

	}

	/**
	 * Verify timed auction translation search menu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Timed_Auction_Translation_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Timed Auction translation TC_319");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String Timed_Str = adminDashboardPage.Translation_Timed_Auction_Labell();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Timed_Auction_Label(Timed_Str);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Timed_Auction_Label_Rename();

	}


	/**
	 * Verify bid now translation search menu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Bid_Now_Translation_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Bid now! translation TC_321");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String bidNow = adminDashboardPage.Translation_Bid_Now_Labell();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Bid_Now_Label(bidNow);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Bid_Now_Label_Rename();

	}

	/**
	 * Verify search translation search menu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Search_Translation_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Search translation TC_322");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String search = adminDashboardPage.Translation_Search_Labell();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Search_Label(search);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Search_Label_Rename();

	}

	/**
	 * Verify buy now translation searchmenu1
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Buy_Now_Translation_SearchMenu1(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Buy Now translation TC_323");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String buyNow1 = adminDashboardPage.Translation_BuyNow_Labell();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_BuyNow_Label(buyNow1);

		// Buy Now! Label is not displayed in front side on qa3-2-auto

	}

	/**
	 * Verify categories translation
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Categories_Translation_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >categories translation TC_324");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String categories = adminDashboardPage.Translation_Categories_Labell();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_categories_Label(categories);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Categories_Label_Rename();
	}

	/**
	 * Verify All Translation Search menu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_All_Translation_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >All translation TC_325");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String all = adminDashboardPage.Translation_All_Labell();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_All_Label(all);

		// All label is not Present in Front side on qa3-2-auto
	}

	/**
	 * Verify Category Match Translation search menu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Category_Match_Translation_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Category Match translation TC_326");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String catMatch = adminDashboardPage.Translation_Category_Match_Labell();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Category_Match_Label(catMatch);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Translation_Category_Match_Label_Rename();

		// Category Match Label Not Display At Front-End Side in qa3-2-auto Enironment
	}

	/**
	 * Verify Zip postal code
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Zip_Postal_Code_Translation_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Zip/Postal Code translation TC_327");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String zipPostal = adminDashboardPage.Translation_Zip_Postal_Labell();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Zip_Postal_Code_Label(zipPostal);

		// Zip/Postal Code is not present in Front Side on qa3-2-auto.
	}

	/**
	 * Verify Incorrect zip postal code
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Incorrect_Zip_Postal_Code_Translation_SearchMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Catalog Menu >Incorrect Zip/Postal Code translation TC_328");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String Incorr_zipPostal = adminDashboardPage.Translation_Incorrect_Zip_Postal_Labell();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Incorrect_Zip_Postal_Code_Label(Incorr_zipPostal);

		// Incorrect Zip/Postal Code is not present in Front Side on qa3-2-auto.
	}

	/**
	 * Verify zip postal code not found translation
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Zip_Postal_Code_Not_Found_Translation_SearchMenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Catalog Menu >Zip/Postal Code Not Found translation TC_329");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String zip_postalNotFound = adminDashboardPage.Translation_Zip_Postal_Not_Found_Labell();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Zip_Postal_Code_Found_Not_Label(zip_postalNotFound);

		// Zip/Postal Code Not Found is not present in Front Side on qa3-2-auto.
	}

	/**
	 * Verify select radius translation searchmenu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Select_Radius_Translation_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Select Radius translation TC_330");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String Selectradius = adminDashboardPage.Translation_Select_Radius_Labell();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Select_Radius_Label(Selectradius);

		// Select Radius is not present in Front Side on qa3-2-auto.
	}

	/**
	 * Verify Lot in Sale search menu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_LotinSale_Translation_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Lot in Sale TC_333");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String lotsale_Str = adminDashboardPage.Translation_Lot_in_sale_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_lotinsale_Label(lotsale_Str);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Lot_in_sale_Label_Rename();
	}

	
	/**
	 * Verify Keywords in Sale search menu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Keyword_Translation_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Keywords in Sale TC_335");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String keyword_Str = adminDashboardPage.Translation_Keyword_Search_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Keywords_Label(keyword_Str);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Keyword_Search_Label_Rename();

	}



	/**
	 * Verify Add Alert search menu
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Add_Alert_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Add alert TC_337");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String verifyaddalert_Str = adminDashboardPage.Translation_Add_Alert_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Add_Alert_Label(verifyaddalert_Str);

		// Add Alert is not displayed in front side on qa3-2-auto
	}

	/**
	 * Verify You have reached the max. number of alerts. Please remove alerts in
	 * order to add new alerts.
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_You_Reached_Max_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > You have reached the max TC_338");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String max_Str = adminDashboardPage.Translation_You_Have_Reached_Max_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_You_Have_Reached_Max_Label(max_Str);

		// You have reached the max is not displayed in front side on qa3-2-auto
	}

	/**
	 * Verify Search title.
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Search_Title_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Search title TC_339");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String search_Str = adminDashboardPage.Translation_Search_Title_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Search_Label(search_Str);

		// Search Title is not displayed in front side on V3.1
	}

	/**
	 * Verify Save Search.
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Save_Search_Title_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Save Search TC_340");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String savesearch = adminDashboardPage.Translation_Save_Search_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Save_Search_Label(savesearch);

		// Save Search Title is not displayed in front side on V3.1
	}

	/**
	 * Verify My Searchs.
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_My_Searchs_Title_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Save Search TC_341");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String mysearch = adminDashboardPage.Translation_My_Search_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_My_Search_Label(mysearch);

		// My Search is not displayed in front side on V3.1
	}

	

	/**
	 * Search radius
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Search_Radius_Code_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Search radius TC_346");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String radius = adminDashboardPage.Translation_Search_Radius_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Search_Radius_Label(radius);

		// Search Radius is not displayed in front side on qa3-2-auto
	}

	/**
	 * Search radius
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Miles_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Search radius TC_347");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String radius = adminDashboardPage.Translation_Miles_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Miles_Label(radius);

		// miles is not displayed in front side on qa3-2-auto
	}

	/**
	 * Select
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Select_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Select TC_348");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String select = adminDashboardPage.Translation_Select_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Select_Label(select);

		// Select is not displayed in front side on qa3-2-auto
	}

	/**
	 * Unawarded
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Unawarded_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Unawarded TC_349");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String select = adminDashboardPage.Translation_Unawarded_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Unawarded_Label(select);

		// Unawarded is not displayed in front side on qa3-2-auto
	}

	/**
	 * UnSold
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_UnSold_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Unawarded TC_350");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String select = adminDashboardPage.Translation_Unsold_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Unsold_Label(select);

		// Unsold is not displayed in front side on qa3-2-auto
	}

	
	/**
	 * 
	 * Similar items
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Similar_Items_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Similar Items TC_352");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String items = adminDashboardPage.Translation_Similar_Items_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Similar_Items_Label(items);

		// Similar Items is not displayed in front side on qa3-2-auto
	}

	
	/**
	 * 
	 * Auction
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Auction_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Auction TC_354");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String items = adminDashboardPage.Translation_Auction1_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Auction1_Label(items);

		// Auction is not displayed in front side on qa3-2-auto
	}

	/**
	 * 
	 * Bids
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Bids_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Bids TC_355");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String items = adminDashboardPage.Translation_Bids1_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Bids1_Label(items);

		// Bids is not displayed in front side on qa3-2-auto
	}

	/**
	 * 
	 * Default
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Default_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Default TC_356");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String items = adminDashboardPage.Translation_Default_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Bids1_Label(items);

		// Default is not displayed in front side on qa3-2-auto
	}

	/**
	 * 
	 * Distance
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Distance_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Distance TC_357");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String distance = adminDashboardPage.Translation_Distance_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Distance_Label(distance);

		// Distance is not displayed in front side on qa3-2-auto
	}

	/**
	 * 
	 * Highest Price
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Highest_Price_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Highest Price TC_358");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String distance = adminDashboardPage.Translation_Highest_Price_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Highest_Price_Label(distance);

		// Highest Price is not displayed in front side on qa3-2-auto
	}

	/**
	 * 
	 * Lot Name
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Lot_Name_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Lot Name TC_359");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String strLotname = adminDashboardPage.Translation_Lot_Name_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Lot_Name_Label(strLotname);

		// Lot Name is not displayed in front side on qa3-2-auto
	}

	/**
	 * 
	 * Lot #
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Lot_Hash_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Lot # TC_360");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String distance = adminDashboardPage.Translation_Lot_Hash_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Lot_Hash1_Label(distance);

		// Lot # is not displayed in front side on qa3-2-auto
	}

	/**
	 * 
	 * Lowest Price
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Lowest_Price_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Lowest Price TC_361");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String lowest = adminDashboardPage.Translation_Lowest_Price_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Lowest_Price_Label(lowest);

		// Lowest Price is not displayed in front side on qa3-2-auto
	}

	/**
	 * 
	 * Newest
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Newest_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Newest TC_362");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String newest = adminDashboardPage.Translation_Newest_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Newest_Label(newest);

		// Newest is not displayed in front side on qa3-2-auto
	}

	/**
	 * 
	 * Time Left
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_TimeLeft_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Time Left TC_363");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String timeleft = adminDashboardPage.Translation_Time_Left_Search_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Time_Left_Search_Label(timeleft);

		// Time Left is not displayed in front side on qa3-2-auto
	}

	/**
	 * 
	 * Views
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Views_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Views TC_364");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String view = adminDashboardPage.Translation_Views_Search_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_View_Search_Label(view);

		// View is not displayed in front side on qa3-2-auto
	}

	/**
	 * 
	 * Max. number of searches reached
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Max_No_Search_SearchMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Catalog Menu > Max. number of searches reached TC_365");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String maxno = adminDashboardPage.Translation_Max_Number_Search_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Max_Number_Search_Label(maxno);

		// Max. number of searches reached is not displayed in front side on
		// qa3-2-auto
	}


	// Login

	/**
	 * 
	 * Username/email combination not found Please check your entries and try again.
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_User_Name_Email_Combination_Not_Found_Loginmenu(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Total Found TC_378");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String emailUser = adminDashboardPage.Translation_User_Name_Email_Not_Found_Login_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.logoutfrontuser();
		dashboardPage.Verify_Email_Username_CombinationNotFound_Label(emailUser);
		
		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_User_Name_Email_Not_Found_Login_Label_rename();

	}

	
	/**
	 * 
	 * Incorrect text entered
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Incorrect_Text_Entered_Loginmenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Incorrect text entered TC_380");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String incorrecttext = adminDashboardPage.Translation_Incorrect_Text_Entered_Login_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.logoutfrontuser();
		dashboardPage.Verify_Incorrect_Text_Entered_Label(incorrecttext);
		
		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Incorrect_Text_Entered_Login_Label_rename();

	}

	

	/**
	 * 
	 * User name required
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_User_Name_Required_Loginmenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > User Name required TC_382");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String unamerequired = adminDashboardPage.Translation_User_Name_Required_Login_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.logoutfrontuser();
		dashboardPage.Verify_Username_Required_Label(unamerequired);
		
		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_User_Name_Required_Login_Label_rename();

	}

	/**
	 * 
	 * Please check your email inbox to reset your password.
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Email_Inbox_Loginmenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Catalog Menu > Please check your email inbox to reset your password.  TC_383");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String txtrequired = adminDashboardPage.Translation_Email_Inbox_Reset_Password_Login_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.logoutfrontuser();
		dashboardPage.Verify_Check_Email_Label(txtrequired);
		

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Email_Inbox_Reset_Password_Login_Label_rename();

	}

	/**
	 * 
	 * Your username has been sent to your registered email address.
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_User_Name_Sent_LoginMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"To Verify Translation of Catalog Menu > Please check your email inbox to reset your password TC_384");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String username = adminDashboardPage.Translation_User_Name_Sent_Login_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.logoutfrontuser();
		dashboardPage.Verify_User_Name_Sent_Label(username);
		

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_User_Name_Sent_Login_Label_rename();

	}

	/**
	 * Login
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Login_LoginMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Login TC_385");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String username = adminDashboardPage.Translation_Login_BTN_Login_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.logoutfrontuser();
		dashboardPage.Verify_Login_BTN_Label(username);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Login_BTN_Login_Label_rename();
	}

	/**
	 * Congratulations, your account has been verified. Your login details have been
	 * sent to your registered email. You may now register for sales!
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Congratulation_Msg_LoginMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Congratulation Message TC_386");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String message = adminDashboardPage.Translation_Congratulation_Message_Login_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Congratulation_msg_Label(message);

		// Congratulation text is not displayed
		// in front side on qa3-2-auto
	}

	/**
	 * This email has already been verified. You may login with the credentials sent
	 * to your email.
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Email_Verified_LoginMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Email Verified TC_387");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String emailverify = adminDashboardPage.Translation_Email_Verified_Login_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Email_Verified_Label(emailverify);

		// This email has already been verified is not displayed
		// in front side on qa3-2-auto
	}



	/**
	 * Mismatched verification code.
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Mismatched_Verification_Code_LoginMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Mismatched verification code. TC_389");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String emailverify = adminDashboardPage.Translation_Mismatched_Verification_Code_Login_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Mismatched_Verification_Code_Label(emailverify);

		// Mismatched verification code. text is not displayed
		// in front side on qa3-2-auto
	}

	/**
	 * Unknown error occurred.
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Unknown_Error_Occurred_LoginMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Unknown error occurred TC_390");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String error = adminDashboardPage.Translation_Unknown_Error_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Unknown_Error_Label(error);

		// Unknown Error Occurred text is not displayed
		// in front side on qa3-2-auto
	}

	/**
	 * Login Faild Translation
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Login_Failed_Translation_LoginMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Login Failed translation TC_391");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String Loginfailed = adminDashboardPage.Translation_Login_Failed_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password + "1");

		dashboardPage.Verify_Login_Failed_Label();

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Login_Failed_Label_Rename();
	}

	/**
	 * Forgot Password Translation
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Forgot_Password_Translation_LoginMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >Forgot Password translation TC_392");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String ForgotPass = adminDashboardPage.Translation_Forgot_Password_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Forgot_password_Label(ForgotPass);

		driver.get(configFileReader.getAdminUrl());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Forgot_Password_Label_rename(); 
	}

	/**
	 * It Easy Translation
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_It_Easy_Translation_LoginMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu >It's Easy translation TC_393");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String its_Easy = adminDashboardPage.Translation_It_Easy_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.logoutfrontuser();

		dashboardPage.Verify_Its_Easy_Label(its_Easy);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_It_Easy_Label_Rename();
	}

	/**
	 * Not a member yet?
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Not_a_Member_Yet_LoginMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Not a member yet? TC_394");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String not_member = adminDashboardPage.Translation_Not_a_Member_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.logoutfrontuser();
		dashboardPage.Verify_Not_Member_Label(not_member);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Not_a_Member_Label_Rename();
	}

	/**
	 * Password
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Password_LoginMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Password TC_395");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String password1 = adminDashboardPage.Translation_Password_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Password_Label(password1);
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Password_Label_rename();

	}

	/**
	 * Register Now
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Register_Now_LoginMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Register Now TC_396");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String regbutton = adminDashboardPage.Translation_Register_Now_Login_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Register_Now_Label(regbutton);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Register_Now_Login_Label_Rename();
	}

	/**
	 * User Name
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_User_Name_LoginMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > User Name TC_397");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String login = adminDashboardPage.Translation_User_Name_Login_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);
		// dashboardPage.logoutfrontuser();

		dashboardPage.Verify_User_Name_Label(login);

	}
	

	/**
	 * Password Required
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Password_Required_LoginMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Password Required TC_400");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String expire = adminDashboardPage.Translation_Password_Required_Login_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Password_Required_Label(expire);

	}

	/**
	 * Password Has Been Reset
	 * 
	 * @param adminUserName
	 * @param adminPassword
	 * @param Name
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws AWTException
	 */

	@Test(dataProvider = "missedliveauction")
	public void Verify_Password_Reset_LoginMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\"To Verify Translation of Catalog Menu > Password Reset TC_401");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String pwdreset = adminDashboardPage.Translation_Password_Reset_Login_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Password_Reset_Label(pwdreset);

		// Password Reset is not Displayed in Front Side on qa3-2-auto.

	}
	
	//Invoices
	
	@Test(dataProvider = "missedliveauction")
	public void Verify_Date_InvoicesMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String date = adminDashboardPage.Translation_Date_Invoice_Menu();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Date_Label_Invoice(date);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Date_Invoice_Menu_Rename();
	}
	
	@Test(dataProvider = "missedliveauction")
	public void Verify_BalanceDue_InvoicesMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

	
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String balanceDue = adminDashboardPage.Translation_BalanceDue_Invoice_Menu();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_BalanceDue_Label_Invoice(balanceDue);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_BalanceDue_Invoice_Menu_Rename();
	}
	
	@Test(dataProvider = "missedliveauction")
	public void Verify_Billing_Information_InvoicesMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String billinginfo = adminDashboardPage.Translation_Billing_Information_Invoice_Menu();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_BillingInformation_Label_Invoice(billinginfo);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Billing_Information_Invoice_Menu_Rename();
	}
	@Test(dataProvider = "missedliveauction")
	public void Verify_Buyers_Premium_InvoicesMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String buyerpremium = adminDashboardPage.Translation_Buyer_Premium_Invoice_Menu();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_BuyerPremium_Label_Invoice(buyerpremium);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Buyer_Premium_Invoice_Menu_Rename();
	}
	
	@Test(dataProvider = "missedliveauction")
	public void Verify_Category_InvoicesMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String category = adminDashboardPage.Translation_Category_Invoice_Menu();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Category_Label_Invoice(category);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Category_Invoice_Menu_Rename();
	}

	@Test(dataProvider = "missedliveauction")
	public void Verify_Extra_Charges_InvoicesMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String extraCharges = adminDashboardPage.Translation_Extra_Charges_Invoice_Menu();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Extra_charges_Label_Invoice(extraCharges);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Extra_Charges_Invoice_Menu_Rename();
	}

	@Test(dataProvider = "missedliveauction")
	public void Verify_Hammer_Price_InvoicesMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String hammerPrice = adminDashboardPage.Translation_Hammer_Price_Invoice_Menu();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Hammer_Price_Label_Invoice(hammerPrice);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Hammer_Price_Invoice_Menu_Rename();
	}
	
	
	@Test(dataProvider = "missedliveauction")
	public void Verify_Invoice_hash_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String invoiceHash = adminDashboardPage.Translation_Invoice_Hash_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Invoice_Hash_Label(invoiceHash);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Invoice_Hash_Invoice_Label_Rename();
	}
	@Test(dataProvider = "missedliveauction")
	public void Verify_Item_Name_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String itemName = adminDashboardPage.Translation_Item_Name_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Item_Name_Label(itemName);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Item_Name_Invoice_Label_Rename();
	}

	@Test(dataProvider = "missedliveauction")
	public void Verify_Item_Hash_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String itemHash = adminDashboardPage.Translation_Item_Hash_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Item_Hash_Label(itemHash);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Item_Hash_Invoice_Label_Rename();
	}
	@Test(dataProvider = "missedliveauction")
	public void Verify_Lot_Hash_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String LotHash = adminDashboardPage.Translation_Lot_Hash_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Lot_Hash_Label1(LotHash);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Lot_Hash_Invoice_Label_Rename();
	}
	@Test(dataProvider = "missedliveauction")
	public void Verify_Notes_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String Notes = adminDashboardPage.Translation_Notes_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Notes_Label(Notes);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Notes_Invoice_Label_Rename();
	}
	
	@Test(dataProvider = "missedliveauction")
	public void Verify_Pay_now_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String paynow = adminDashboardPage.Translation_Pay_now_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Pay_Now_Label(paynow);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Pay_now_Invoice_Label_Rename();
	}
	@Test(dataProvider = "missedliveauction")
	public void Verify_Qty_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String qty = adminDashboardPage.Translation_Qty_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Qty_Label(qty);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Qty_Invoice_Label_Rename();
	}
	
	@Test(dataProvider = "missedliveauction")
	public void Verify_Sale_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String sale = adminDashboardPage.Translation_Sale_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Sale_Label(sale);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Sale_Invoice_Label_Rename();
	}
	@Test(dataProvider = "missedliveauction")
	public void Verify_Sale_date_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleDate = adminDashboardPage.Translation_Sale_date_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Sale_date_Label(saleDate);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Sale_date_Invoice_Label_Rename();
	}
	@Test(dataProvider = "missedliveauction")
	public void Verify_Sales_tax_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleTax = adminDashboardPage.Translation_Sales_tax_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Sales_tax_Label(saleTax);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Sales_tax_Invoice_Label_Rename();
	}
	@Test(dataProvider = "missedliveauction")
	public void Verify_Shipping_and_Handling_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String shipping = adminDashboardPage.Translation_Shipping_Handling_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Shipping_Handling_Label(shipping);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Shipping_Handling_Invoice_Label_Rename();
		
	}
	
	@Test(dataProvider = "missedliveauction")
	public void Verify_Status_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String status = adminDashboardPage.Translation_Status_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Status_Invoice_Label(status);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Status_Invoice_Label_Rename();
	}
	@Test(dataProvider = "missedliveauction")
	public void Verify_Sub_Total_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String subTotal = adminDashboardPage.Translation_Sub_Total_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Subtotal_Invoice_Label(subTotal);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Sub_Total_Invoice_Label_Rename();
	}
	@Test(dataProvider = "missedliveauction")
	public void Verify_Total_Invoice_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String totalInvoice = adminDashboardPage.Translation_Total_Invoice_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Total_Invoice_Label(totalInvoice);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Total_Invoice_Invoice_Label_Rename();
	}
	@Test(dataProvider = "missedliveauction")
	public void Verify_M_D_Y_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String mdy = adminDashboardPage.Translation_M_D_Y_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_M_D_Y_Invoice_Label(mdy);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_M_D_Y_Invoice_Label_Rename();
	}
	@Test(dataProvider = "missedliveauction")
	public void Verify_Items_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String items = adminDashboardPage.Translation_Items_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Items_Invoice_Label(items);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Items_Invoice_Label_Rename();
	}
	@Test(dataProvider = "missedliveauction")
	public void Verify_Invalid_Credit_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String invaliCre = adminDashboardPage.Translation_Invalid_credit_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Invalid_Credit_Invoice_Label(invaliCre);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Invalid_credit_Invoice_Label_Rename();
	}
	
	@Test(dataProvider = "missedliveauction")
	public void Verify_No_Enough_Credit_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String enoughCredit = adminDashboardPage.Translation_No_Enough_Credit_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_No_Enough_Credit_Invoice_Label(enoughCredit);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_No_Enough_Credit_Invoice_Label_Rename();
	}
	@Test(dataProvider = "missedliveauction")
	public void Verify_Apply_Coupon_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String applyCoupon = adminDashboardPage.Translation_Apply_Coupon_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Apply_Coupon_Invoice_Label(applyCoupon);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Apply_Coupon_Invoice_Label_Rename();
	}
	@Test(dataProvider = "missedliveauction")
	public void Verify_Apply_Credits_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String applyCredit = adminDashboardPage.Translation_Apply_Credits_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Apply_Credits_Invoice_Label(applyCredit);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Apply_Credits_Invoice_Label_Rename();
	}
	@Test(dataProvider = "missedliveauction")
	public void Verify_Coupon_code_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String coupnCde = adminDashboardPage.Translation_Coupon_Code_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Coupon_Code_Invoice_Label(coupnCde);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Coupon_Code_Invoice_Label_Rename();
	}
	
	@Test(dataProvider = "missedliveauction")
	public void Verify_Coupon_code_Invalid_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String coupnCdeInvalid = adminDashboardPage.Translation_Coupon_Code_invalid_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Coupon_Code_Invalid_Invoice_Label(coupnCdeInvalid);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Coupon_Code_invalid_Invoice_Label_Rename();
	}
	@Test(dataProvider = "missedliveauction")
	public void Verify_Coupon_code_required_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String coupnCdeREquired = adminDashboardPage.Translation_Coupon_Code_required_invalid_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Coupon_Code_required_Invoice_Label(coupnCdeREquired);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Coupon_Code_required_invalid_Invoice_Label_Rename();
	}
	@Test(dataProvider = "missedliveauction")
	public void Verify_Pay_Via_Authorize_Net_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String payViaAuhtorize = adminDashboardPage.Translation_Pay_Via_Authorize_Net_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Pay_Via_Authorize_Net_Invoice_Label(payViaAuhtorize);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Pay_Via_Authorize_Net_Invoice_Label_Rename();
	}
	@Test(dataProvider = "missedliveauction")
	public void Verify_PDF_Invoice_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String pdf = adminDashboardPage.Translation_PDF_Invoice_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_PDF_Invoice_Invoice_Label(pdf);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_PDF_Invoice_Invoice_Label_Rename();
	}
	@Test(dataProvider = "missedliveauction")
	public void Verify_Printable_view_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String printView = adminDashboardPage.Translation_Printable_view_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Printable_view_Invoice_Label(printView);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Printable_view_Invoice_Label_Rename();
	}
	@Test(dataProvider = "missedliveauction")
	public void Verify_Invoice_hash1_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String invoiceHash = adminDashboardPage.Translation_Invoice_Hash1_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Invoice_Hash1_Label(invoiceHash);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Invoice_Hash1_Invoice_Label_Rename();
	}
	@Test(dataProvider = "missedliveauction")
	public void Verify_Sale_Date_M_D_Y_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleDate = adminDashboardPage.Translation_Sale_Date_M_D_Y_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Sale_Date_MDY_Label(saleDate);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Sale_Date_M_D_Y_Invoice_Label_Rename();
	}

	@Test(dataProvider = "missedliveauction")
	public void Verify_Search_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String search = adminDashboardPage.Translation_Search_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Search_Invoice_Label(search);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Search_Invoice_Label_Rename();
	}

	@Test(dataProvider = "missedliveauction")
	public void Verify_Show_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String show = adminDashboardPage.Translation_Show_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Show_Invoice_Label(show);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Show_Invoice_Label_Rename();
	}
	@Test(dataProvider = "missedliveauction")
	public void Verify_All_Label_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String show = adminDashboardPage.Translation_All_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_All_Invoice_Label(show);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_All_Invoice_Label_Rename();
	}
	@Test(dataProvider = "missedliveauction")
	public void Verify_Status_Label_Column_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String status = adminDashboardPage.Translation_Status_Column_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Status_Invoice_Label1(status);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Status_Column_Invoice_Label_Rename();
	}

	@Test(dataProvider = "missedliveauction")
	public void Verify_Paid_Label_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String paid = adminDashboardPage.Translation_Paid_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Paid_Invoice_Label(paid);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Paid_Invoice_Label_Rename();
	}
	@Test(dataProvider = "missedliveauction")
	public void Verify_Pending_Label_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String pending = adminDashboardPage.Translation_Pending_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Pending_Invoice_Label(pending);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Pending_Invoice_Label_Rename();
	}
	@Test(dataProvider = "missedliveauction")
	public void Verify_Shipped_Label_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String shipped = adminDashboardPage.Translation_Shipped_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Shipped_Invoice_Label(shipped);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Shipped_Invoice_Label_Rename();
	}
	@Test(dataProvider = "missedliveauction")
	public void Verify_Invoices_Label_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String invoices = adminDashboardPage.Translation_Invoices_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Invoices_Invoice_Label(invoices);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Invoices_Invoice_Label_Rename();
	}
	@Test(dataProvider = "missedliveauction")
	public void Verify_Total_Column_Label_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String total = adminDashboardPage.Translation_Total_Column_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Total_Column_Invoice_Label(total);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Total_Column_Invoice_Label_Rename();
	}
	@Test(dataProvider = "missedliveauction")
	public void Verify_Pay_Via_CC_Epay_Label_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String ccEpay = adminDashboardPage.Translation_Pay_Via_CC_Epay_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Pay_Via_CC_Epay_Label(ccEpay);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Pay_Via_CC_Epay_Invoice_Label_Rename();
	}
	@Test(dataProvider = "missedliveauction")
	public void Verify_Pay_Via_Paypal_Label_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String payPal = adminDashboardPage.Translation_Pay_Via_Paypal_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Pay_Via_Paypal_Label(payPal);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Pay_Via_Paypal_Invoice_Label_Rename();
	}
	@Test(dataProvider = "missedliveauction")
	public void Verify_Your_Credits_Have_Been_Applied_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String applyCredit = adminDashboardPage.Translation_Your_Credits_Have_Been_Applied_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Your_Credit_Have_been_Apllied_Invoice_Label(applyCredit);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Your_Credits_Have_Been_Applied_Invoice_Label_Rename();
	}
	@Test(dataProvider = "missedliveauction")
	public void Verify_Payments_Made_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String paymentMade = adminDashboardPage.Translation_Payments_Made_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Payments_Made_Invoice_Label(paymentMade);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Payments_Made_Invoice_Label_Rename();
	}
	@Test(dataProvider = "missedliveauction")
	public void Verify_Shipping_Information_InvoiceMenu(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String shippingInfo = adminDashboardPage.Translation_Shipping_Information_Invoice_Label();

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(UName, password);

		dashboardPage.Verify_Shipping_Information_Invoice_Label(shippingInfo);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Translation_Shipping_Information_Invoice_Label_Rename();
	}




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
