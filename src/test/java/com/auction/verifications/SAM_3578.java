package com.auction.verifications;

import java.awt.AWTException;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.auction.admin.pages.AddUsers;
import com.auction.admin.pages.AdminDashboardPage;
import com.auction.init.Common;
import com.auction.init.ConfigFileReader;
import com.auction.init.SeleniumInit;
import com.auction.pages.DashboardPage;

public class SAM_3578 extends SeleniumInit {
	Common common = new Common(driver);
	ConfigFileReader configFileReader = new ConfigFileReader();
	private int past;

	// 1
	@Test(dataProvider = "missedliveauction")
	public void verify_To_Create_Newaccount_With_Allowbuyertoquantityonbuynowtimedlots_Condition(String adminUserName,
			String adminPassword, String UName) throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-3578(1)");
		common.log("TC: SAM-3578(1)");

		System.out.println("----Dev----");
		common.log("<br></br>---Dev---");
		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String accountname = common.generateRandomChars(6);

		adminDashboardPage.go_To_Account_Page();
		adminDashboardPage
				.verify_To_Create_New_Account_With_Allowbuyertoquantityonbuynowtimedlots_Condition(accountname);

//		System.out.println("----qa3-6-auto----");
//		common.log("<br></br>---qa3-6-auto---");
//		driver.get(configFileReader.getAdminUrl()); // Admin URL
//		adminDashboardPage = indexPage // Admin Signin
//				.adminSignin(adminUserName, adminPassword);
//
//		adminDashboardPage.go_To_Account_Page();
//		adminDashboardPage
//				.verify_To_Create_New_Account_With_Allowbuyertoquantityonbuynowtimedlots_Condition(accountname);

	}

	// 2
	@Test(dataProvider = "missedliveauction")
	public void verify_Access_Control_Of_Allowbuyertoquantityonbuynowtimedlots_Condition(String adminUserName,
			String adminPassword, String UName) throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-3578(2)");
		common.log("TC: SAM-3578(2)");

		System.out.println("----Dev----");
		common.log("<br></br>---Dev---");
		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno = common.generateRandomNumber1();
		String name = common.generateRandomChars(6);
		String lotname = common.generateRandomChars(6);
		String itemname = common.generateRandomChars(4);

		adminDashboardPage.add_Item_And_Verify_Allowbuyerselectquantity_Access(itemname);
		adminDashboardPage.timed_Auction_With_Publish(saleno, name);
		adminDashboardPage.add_Lot_And_Verify_Allowbuyerselectquantity_Access(lotname);

//		System.out.println("----qa3-6-auto----");
//		common.log("<br></br>---qa3-6-auto---");
//		driver.get(configFileReader.getAdminUrl()); // Admin URL
//		adminDashboardPage = indexPage // Admin Signin
//				.adminSignin(adminUserName, adminPassword);
//
//		adminDashboardPage.add_Item_And_Verify_Allowbuyerselectquantity_Access(itemname);
//		adminDashboardPage.timed_Auction_With_Publish(saleno, name);
//		adminDashboardPage.add_Lot_And_Verify_Allowbuyerselectquantity_Access(lotname);

	}

	// For disabling No Bidding check box and by the time hiding few fields are
	// tested in BugScripts>SAM_10449

	// 3
	@Test(dataProvider = "missedliveauction")
	public void verify_Validation_For_BuyNow_Field_Relating_Allowbuyertoquantityonbuynowtimedlots_Condition(
			String adminUserName, String adminPassword, String UName)
			throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-3578(3)");
		common.log("TC: SAM-3578(3)");

		System.out.println("----Dev----");
		common.log("<br></br>---Dev---");
		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno = common.generateRandomNumber1();
		String name = common.generateRandomChars(6);
		String lotname = common.generateRandomChars(6);

		adminDashboardPage.timed_Auction_With_Publish(saleno, name);
		adminDashboardPage.add_Lot_without_BuyNow_for_enabled_Allowbuyerselectquantity(lotname);

//		System.out.println("----qa3-6-auto----");
//		common.log("<br></br>---qa3-6-auto---");
//		driver.get(configFileReader.getAdminUrl()); // Admin URL
//		adminDashboardPage = indexPage // Admin Signin
//				.adminSignin(adminUserName, adminPassword);
//
//		adminDashboardPage.timed_Auction_With_Publish(saleno, name);
//		adminDashboardPage.add_Lot_without_BuyNow_for_enabled_Allowbuyerselectquantity(lotname);
	}

	// 4
	@Test(dataProvider = "missedliveauction")
	public void verify_To_Upload_CSV_With_Allowbuyertoquantityonbuynowtimedlots_Data(String adminUserName,
			String adminPassword, String UName) throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-3578(4)");
		common.log("TC: SAM-3578(4)");

		System.out.println("----Dev----");
		common.log("<br></br>---Dev---");
		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno = common.generateRandomNumber1();
		String name = common.generateRandomChars(6);
		String lotname = common.generateRandomChars(6);

		adminDashboardPage.timed_Auction_With_Publish(saleno, name);
		adminDashboardPage.upload_Lots_via_CSV_with_Allowbuyerselectquantity_Condition_dev();

//		System.out.println("----qa3-6-auto----");
//		common.log("<br></br>---qa3-6-auto---");
//		driver.get(configFileReader.getAdminUrl()); // Admin URL
//		adminDashboardPage = indexPage // Admin Signin
//				.adminSignin(adminUserName, adminPassword);
//
//		adminDashboardPage.timed_Auction_With_Publish(saleno, name);
//		adminDashboardPage.upload_Lots_via_CSV_with_Allowbuyerselectquantity_Condition_qa36auto();
	}

	// 5
	@Test(dataProvider = "missedliveauction")
	public void verify_To_Sell_Limited_Quantity_At_Frontend(String adminUserName, String adminPassword, String UName)
			throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-3578(5)");
		common.log("TC: SAM-3578(5)");

		System.out.println("----Dev----");
		common.log("<br></br>---Dev---");
		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String usname = common.generateRandomChars(6);
		String saleno = common.generateRandomNumber1();
		String name = common.generateRandomChars(6);
		String lotname = common.generateRandomChars(6);

		adminDashboardPage.createUserWithUsername(usname);
		adminDashboardPage.timed_Auction_With_Publish(saleno, name);
		adminDashboardPage.add_Lot_With_Quantity_And_Allowbuyerselectquantity_Access(lotname);
		adminDashboardPage.register_And_Approve_New_Bidder(usname);

		driver.get(configFileReader.getdevUrl());
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(usname, "Abc@123");
		dashboardPage.goto_Catalog_Page_Time_Sale_dev(name);
		dashboardPage.placeBidFromCatalogpage();

//		System.out.println("----qa3-6-auto----");
//		common.log("<br></br>---qa3-6-auto---");
//		driver.get(configFileReader.getAdminUrl()); // Admin URL
//		adminDashboardPage = indexPage // Admin Signin
//				.adminSignin(adminUserName, adminPassword);
//
//		adminDashboardPage.createUserWithUsername(usname);
//		adminDashboardPage.timed_Auction_With_Publish(saleno, name);
//		adminDashboardPage.add_Lot_With_Quantity_And_Allowbuyerselectquantity_Access(lotname);
//		adminDashboardPage.register_And_Approve_New_Bidder(usname);
//
//		driver.get(configFileReader.getFrontUrl());
//		loginPage = indexPage.clickOnLoginLink(); // click on login link
//		dashboardPage = loginPage.loginUser(usname, "Abc@123");
//		dashboardPage.goto_Catalog_Page_Time_Sale_qa36auto(name);
//		dashboardPage.placeBidFromCatalogpage();

	}

	// 6
	@Test(dataProvider = "missedliveauction")
	public void verify_To_Sell_Complete_Quantity_At_Frontend(String adminUserName, String adminPassword, String UName)
			throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-3578(6)");
		common.log("TC: SAM-3578(6)");

		System.out.println("----Dev----");
		common.log("<br></br>---Dev---");
		driver.get(configFileReader.getdev_auctionUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String usname = common.generateRandomChars(6);
		String saleno = common.generateRandomNumber1();
		String name = common.generateRandomChars(6);
		String lotname = common.generateRandomChars(6);

		adminDashboardPage.createUserWithUsername(usname);
		adminDashboardPage.timed_Auction_With_Publish(saleno, name);
		adminDashboardPage.add_Lot_With_Quantity_And_Allowbuyerselectquantity_Access(lotname);
		adminDashboardPage.register_And_Approve_New_Bidder(usname);

		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		common.installation_URL();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(usname, "Abc@123");
		dashboardPage.goto_Catalog_Page_Time_Sale_dev(name);
		dashboardPage.placeBidFromCatalogPageWithFullQuantity();

//		System.out.println("----qa3-6-auto----");
//		common.log("<br></br>---qa3-6-auto---");
//		driver.get(configFileReader.getAdminUrl()); // Admin URL
//		adminDashboardPage = indexPage // Admin Signin
//				.adminSignin(adminUserName, adminPassword);
//
//		adminDashboardPage.createUserWithUsername(usname);
//		adminDashboardPage.timed_Auction_With_Publish(saleno, name);
//		adminDashboardPage.add_Lot_With_Quantity_And_Allowbuyerselectquantity_Access(lotname);
//		adminDashboardPage.register_And_Approve_New_Bidder(usname);
//
//		driver.get(configFileReader.getFrontUrl());
//		loginPage = indexPage.clickOnLoginLink(); // click on login link
//		dashboardPage = loginPage.loginUser(usname, "Abc@123");
//		dashboardPage.goto_Catalog_Page_Time_Sale_qa36auto(name);
//		dashboardPage.placeBidFromCatalogPageWithFullQuantity();

	}

	// 7
	@Test(dataProvider = "missedliveauction")
	public void verify_Cloned_Lot_For_Sold_Quantity(String adminUserName, String adminPassword, String UName)
			throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-3578(7)");
		common.log("TC: SAM-3578(7)");

		System.out.println("----Dev----");
		common.log("<br></br>---Dev---");
		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String usname = common.generateRandomChars(6);
		String saleno = common.generateRandomNumber1();
		String name = common.generateRandomChars(6);
		String lotname = common.generateRandomChars(6);

		adminDashboardPage.createUserWithUsername(usname);
		adminDashboardPage.timed_Auction_With_Publish(saleno, name);
		adminDashboardPage.add_Lot_With_Quantity_And_Allowbuyerselectquantity_Access(lotname);
		adminDashboardPage.register_And_Approve_New_Bidder(usname);

		driver.get(configFileReader.getdevUrl());
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(usname, "Abc@123");
		dashboardPage.goto_Catalog_Page_Time_Sale_dev(name);
		dashboardPage.placeBidFewQuantityFromCatalogPage();
		
		driver.get(configFileReader.getdev_auctionUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		
		adminDashboardPage.searchAuctionAndVerifyClonedLotNamedev(saleno);
		

//		System.out.println("----qa3-6-auto----");
//		common.log("<br></br>---qa3-6-auto---");
//		driver.get(configFileReader.getAdminUrl()); // Admin URL
//		adminDashboardPage = indexPage // Admin Signin
//				.adminSignin(adminUserName, adminPassword);
//
//		adminDashboardPage.createUserWithUsername(usname);
//		adminDashboardPage.timed_Auction_With_Publish(saleno, name);
//		adminDashboardPage.add_Lot_With_Quantity_And_Allowbuyerselectquantity_Access(lotname);
//		adminDashboardPage.register_And_Approve_New_Bidder(usname);
//
//		driver.get(configFileReader.getFrontUrl());
//		loginPage = indexPage.clickOnLoginLink(); // click on login link
//		dashboardPage = loginPage.loginUser(usname, "Abc@123");
//		dashboardPage.goto_Catalog_Page_Time_Sale_qa36auto(name);
//		dashboardPage.placeBidFewQuantityFromCatalogPage();
//		
//		driver.get(configFileReader.getAdminUrl()); // Admin URL
//		adminDashboardPage = indexPage // Admin Signin
//				.adminSignin(adminUserName, adminPassword);
//		
//		adminDashboardPage.searchAuctionAndVerifyClonedLotNameqa36auto(saleno);

	}
	
	//8
		@Test(dataProvider = "missedliveauction")
		public void verify_Valiadtion_For_Invalid_Amount(String adminUserName, String adminPassword, String UName)
				throws InterruptedException, ParseException, AWTException {

			System.out.println("TC: SAM-3578(8)");
			common.log("TC: SAM-3578(8)");

			System.out.println("----Dev----");
			common.log("<br></br>---Dev---");
			driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
			common.installation_URL();
			adminDashboardPage = indexPage // Admin Signin
					.adminSignin(adminUserName, adminPassword);

			String usname = common.generateRandomChars(6);
			String saleno = common.generateRandomNumber1();
			String name = common.generateRandomChars(6);
			String lotname = common.generateRandomChars(6);

			adminDashboardPage.createUserWithUsername(usname);
			adminDashboardPage.timed_Auction_With_Publish(saleno, name);
			adminDashboardPage.add_Lot_With_Quantity_And_Allowbuyerselectquantity_Access(lotname);
			adminDashboardPage.register_And_Approve_New_Bidder(usname);

			driver.get(configFileReader.getdevUrl());
			loginPage = indexPage.clickOnLoginLink(); // click on login link
			dashboardPage = loginPage.loginUser(usname, "Abc@123");
			dashboardPage.goto_Catalog_Page_Time_Sale_dev(name);
			dashboardPage.placeBidWithInvalidQuantityFromCatalogPage();
		
			

//			System.out.println("----qa3-6-auto----");
//			common.log("<br></br>---qa3-6-auto---");
//			driver.get(configFileReader.getAdminUrl()); // Admin URL
//			adminDashboardPage = indexPage // Admin Signin
//					.adminSignin(adminUserName, adminPassword);
//
//			adminDashboardPage.createUserWithUsername(usname);
//			adminDashboardPage.timed_Auction_With_Publish(saleno, name);
//			adminDashboardPage.add_Lot_With_Quantity_And_Allowbuyerselectquantity_Access(lotname);
//			adminDashboardPage.register_And_Approve_New_Bidder(usname);
//
//			driver.get(configFileReader.getFrontUrl());
//			loginPage = indexPage.clickOnLoginLink(); // click on login link
//			dashboardPage = loginPage.loginUser(usname, "Abc@123");
//			dashboardPage.goto_Catalog_Page_Time_Sale_qa36auto(name);
//			dashboardPage.placeBidWithInvalidQuantityFromCatalogPage();

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

}