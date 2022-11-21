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

public class SAM_10460 extends SeleniumInit {

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
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	// 1
	@Test(dataProvider = "missedliveauction")
	public void Public_lots_auto_update_stops_after_one_iteration_10460(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String name =adminDashboardPage.create_Timed_Auction(saleno);
		adminDashboardPage.Public_lots_auto_update_stops_after_one_iteration();
		adminDashboardPage.approveBidder1_2();
		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		
		//String name = common.generateRandomChars(5);;
		dashboardPage.goto_Catalog_Page_Timed_Sale(name);
		dashboardPage.Public_lots_auto_update_stops_after_one_iteration();

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