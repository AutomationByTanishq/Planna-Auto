package com.auction.verifications;

import java.awt.AWTException;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.auction.init.Common;
import com.auction.init.ConfigFileReader;
import com.auction.init.SeleniumInit;

public class SAM_9431 extends SeleniumInit {

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
	public void Test_styling_applied_at_settlement_View_Page_at_admin_side(String adminUserName, String adminPassword,
			String UName, String password) throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-9548");
		common.log("TC: SAM-9548");

		String saleno1 = Common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();
		String saleno = Common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String AucName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); //
		// Create
		// Auction

		// Add lots with consignor
		adminDashboardPage.Add_Lot_with_Consignor_rahulqa();
		adminDashboardPage.Add_Lot_with_Consignor_rahulqa();
		adminDashboardPage.Add_Lot_with_Consignor_rahulqa_Unsold_status();

		// Auction
		adminDashboardPage.start_Auction();
		adminDashboardPage.Post_Floor_Bid_Sell_Lot_With_Winner_Name();
		adminDashboardPage.Verify_styling_at_settlement_view(AucName);

	}

	@Test(dataProvider = "createauction")
	public void Test_styling_applied_at_Printable_View_of_settlement(String adminUserName, String adminPassword,
			String UName, String password) throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-9549");
		common.log("TC: SAM-9549");

		String saleno1 = Common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();
		String saleno = Common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String AucName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); //
		// Create
		// Auction

		// Add lots with consignor
		adminDashboardPage.Add_Lot_with_Consignor_rahulqa();
		adminDashboardPage.Add_Lot_with_Consignor_rahulqa();
		adminDashboardPage.Add_Lot_with_Consignor_rahulqa_Unsold_status();

		// Auction
		adminDashboardPage.start_Auction();
		adminDashboardPage.Post_Floor_Bid_Sell_Lot_With_Winner_Name();
		adminDashboardPage.Verify_styling_at_settlement_in_printable_view(AucName);

	}

	@Test(dataProvider = "createauction")
	public void Testing_styling_applied_to_multiple_Print_of_settlement(String adminUserName, String adminPassword,
			String UName, String password) throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-9550");
		common.log("TC: SAM-9550");

		String saleno1 = Common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();
		String saleno = Common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String AucName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); //
		// Create
		// Auction

		// Add lots with consignor
		adminDashboardPage.Add_Lot_with_Consignor_rahulqa();
		adminDashboardPage.Add_Lot_with_Consignor_rahulqa();
		adminDashboardPage.Add_Lot_with_Consignor_rahulqa_Unsold_status();

		// Auction
		adminDashboardPage.start_Auction();
		adminDashboardPage.Post_Floor_Bid_Sell_Lot_With_Winner_Name();
		adminDashboardPage.Verify_styling_at_settlement_in_printable_view(AucName);

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
