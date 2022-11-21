package com.auction.verifications;

import java.awt.AWTException;

import java.text.ParseException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.auction.admin.pages.AdminDashboardPage;
import com.auction.admin.pages.LotVerificationPage;
import com.auction.init.Common;
import com.auction.init.ConfigFileReader;
import com.auction.init.SeleniumInit;
import com.auction.pages.DashboardPage;

public class SAM_11243 extends SeleniumInit {

	// String saleno = null;
	// String auctionName = null;
	String lotName = null;
	String uName = null;
	String bidder2 = "rahulbid";
	String bidder2Pass = "123123a";
	Common common = new Common(driver);
	ConfigFileReader configFileReader = new ConfigFileReader();

	/**
	 * 
	 * Invalid max bid placing an decimal amount with US number formatting enabled
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	// 1
	@Test(dataProvider = "missedliveauction")
	public void Invalid_Max_Bid_Error_On_Placing_Decimal_Type_Amount_Values(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		String name = common.generateRandomChars(5);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.enable_US_Number_Formatting();
		adminDashboardPage.create_Live_Auction(name);
		String lotName = adminDashboardPage.addLot(1);
		adminDashboardPage.approveBidder1();
		

		adminDashboardPage.front();
		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		dashboardPage.verify_Bid_Message(name,lotName);
	}

	/**
	 * 
	 * Invalid max bid placing an decimal amount with US number formatting disabled
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	// 2
	@Test(dataProvider = "missedliveauction")
	public void Invalid_Max_Bid_Error_On_Placing_Decimal_Type_Amount_Values_US_Number_Formatting_Disable(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		String name = common.generateRandomChars(5);

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.disable_US_Number_Formatting();
		adminDashboardPage.create_Live_Auction(name);
		String lotName = adminDashboardPage.addLot(1);
		adminDashboardPage.approveBidder1();
		

		adminDashboardPage.front();
		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		dashboardPage.verify_Bid_Message_For_US_Number_Formatting_Checkbox_Disable(name,lotName);
	}

//////////////////////////////////////////////////////////////////
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

}