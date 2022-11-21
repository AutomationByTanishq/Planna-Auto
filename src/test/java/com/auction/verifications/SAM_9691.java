package com.auction.verifications;

import java.text.ParseException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.auction.init.Common;
import com.auction.init.ConfigFileReader;
import com.auction.init.SeleniumInit;

public class SAM_9691 extends SeleniumInit {

	Common common = new Common(driver);

	String bidder2 = "rahulbid";
	String bidder2Pass = "rahulbid";
	String UName = "rahulqa";
	String password = "123123a";
	ConfigFileReader configFileReader = new ConfigFileReader();

//1
	@Test(dataProvider = "missedliveauction")
	public void Check_the_Reset_default_order_at_Inventory_Page_With_OK_10089(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Verify_Check_the_Reset_default_order_at_Inventory_Page_With_OK();

	}

	// 2
	@Test(dataProvider = "missedliveauction")
	public void Check_the_Reset_default_order_at_Inventory_Page_With_Cancel_10090(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Verify_Check_the_Reset_default_order_at_Inventory_Page_With_Cancel();

	}

	// 3
	@Test(dataProvider = "missedliveauction")
	public void Check_the_Reset_default_order_at_Auction_Info_Page_With_OK_10091(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Verify_Check_the_Reset_default_order_at_Auction_Info_Page_With_OK();

	}

	// 4
	@Test(dataProvider = "missedliveauction")
	public void Check_the_Reset_default_order_at_Auction_Info_Page_With_Cancel_10092(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Verify_Check_the_Reset_default_order_at_Auction_Info_Page_With_Cancel();

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
