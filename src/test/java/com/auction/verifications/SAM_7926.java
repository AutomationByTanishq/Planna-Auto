package com.auction.verifications;

import java.awt.AWTException;
import java.text.ParseException;
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
import com.auction.init.ConfigFileReader;
import com.auction.init.SeleniumInit;
import com.auction.pages.DashboardPage;

public class SAM_7926 extends SeleniumInit {

	// String saleno = null;
	// String auctionName = null;
	String lotName = null;
	String uName = null;
	String bidder2 = "rahulbid";
	String bidder2Pass = "123123a";
	Common common = new Common(driver);
	ConfigFileReader configFileReader= new ConfigFileReader();
	/**
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Add_lot_quantity_information_Lot_Name_Lot_description_on_Bid_confirmation_page_8455(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-8455");
		common.log("TC: SAM-8455");

		String tomorrowDate = common.tomorrowDate();

		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); // Create
		adminDashboardPage.approveBidder1();

		String lotname = adminDashboardPage.Add_Lot_With_Quantity_5(1); // User 1
		adminDashboardPage.Set_BP_Value_10();
		adminDashboardPage.Set_Sell_Tax_And_Apply_To_HP("10");
		
		adminDashboardPage.front(); // Open Front End

		// Front user Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verifyLoginPageElements(); // Verify Login Page Elements
		dashboardPage = loginPage.loginUser(UName, password); // Login with
																// valid
																// credentials
		dashboardPage.Place_Bid_160_For_Added_Lot_Livesale(auctionName, lotname);

	}
	/**
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Add_lot_quantity_information_Lot_Name_Lot_description_on_Bid_confirmation_page_8456(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-8456");
		common.log("TC: SAM-8456");

		String tomorrowDate = common.tomorrowDate();

		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); // Create
		adminDashboardPage.approveBidder1();

		String lotname = adminDashboardPage.Add_Lot_With_Quantity_5_sales_tax_10(1); // User 1
		String lotname1 = adminDashboardPage.Add_Lot_With_Quantity_8(1);
		adminDashboardPage.Set_BP_Value_100_5_And_150_10();
		adminDashboardPage.Set_Sell_Tax_And_Apply_To_HP("15");
		
		adminDashboardPage.front(); // Open Front End

		// Front user Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verifyLoginPageElements(); // Verify Login Page Elements
		dashboardPage = loginPage.loginUser(UName, password); // Login with
																// valid
																// credentials
		dashboardPage.Place_Bid_160_and_130_For_Added_Lot_Livesale(auctionName, lotname, lotname1);

	}
	
	/**
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Add_lot_quantity_information_Lot_Name_Lot_description_on_Bid_confirmation_page_8457(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-8457");
		common.log("TC: SAM-8457");

		String tomorrowDate = common.tomorrowDate();

		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); // Create
		adminDashboardPage.approveBidder1();

		String lotname = adminDashboardPage.Add_Lot_With_Quantity_5(1); // User 1
		adminDashboardPage.Set_BP_Value_10();
		adminDashboardPage.Set_Sell_Tax_And_Apply_To_HP_BP("10");
		
		adminDashboardPage.front(); // Open Front End

		// Front user Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verifyLoginPageElements(); // Verify Login Page Elements
		dashboardPage = loginPage.loginUser(UName, password); // Login with
																// valid
																// credentials
		dashboardPage.Place_Bid_160_For_Added_Lot_Livesale(auctionName, lotname);

	}
	/**
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Add_lot_quantity_information_Lot_Name_Lot_description_on_Bid_confirmation_page_8458(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-8458");
		common.log("TC: SAM-8458");

		String tomorrowDate = common.tomorrowDate();

		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); // Create
		adminDashboardPage.approveBidder1();

		String lotname = adminDashboardPage.Add_Lot_With_Quantity_5(1); // User 1
		String lotname1 = adminDashboardPage.Add_Lot_With_Quantity_8(1);
		adminDashboardPage.Set_BP_Value_100_5_And_150_10();
		adminDashboardPage.Set_Sell_Tax_And_Apply_To_HP_BP("15");
		
		adminDashboardPage.front(); // Open Front End

		// Front user Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		loginPage.verifyLoginPageElements(); // Verify Login Page Elements
		dashboardPage = loginPage.loginUser(UName, password); // Login with
																// valid
																// credentials
		dashboardPage.Place_Bid_100_and_200_For_Added_Lot_Livesale(auctionName, lotname, lotname1);

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

