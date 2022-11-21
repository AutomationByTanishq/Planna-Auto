package com.auction.verifications;

import java.awt.AWTException;
import java.text.ParseException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.auction.admin.pages.AdminDashboardPage;
import com.auction.init.Common;
import com.auction.init.ConfigFileReader;
import com.auction.init.SeleniumInit;

public class SAM_8542 extends SeleniumInit {
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
	public void TestCase_Live_sale_simple_clerking_screen_using_post_bid_on_first_click_not_working(String adminUserName,
			String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-8667");
		common.log("TC: SAM-8667");

		String saleno1 = Common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();
		String saleno = Common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String AucName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); //
		// Create
		// Auction
		adminDashboardPage.add1Lot();
		adminDashboardPage.start_Auction();
		adminDashboardPage.ChangeAskingBid();

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
