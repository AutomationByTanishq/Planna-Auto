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

public class SAM_10220 extends SeleniumInit {

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
	 */

	// 1
	@Test(dataProvider = "missedliveauction")
	public void Verify_Quantity_Digits_field_on_Item_page_10341(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		// String saleno = common.generateRandomNumber1();

		// String tomorrowDate = common.tomorrowDate();
		// String auctionName = adminDashboardPage.Create_Live_Auction_Advance(saleno);

		adminDashboardPage.Verify_Quantity_Digits_field_on_Item_page();

	}

	// 2
	@Test(dataProvider = "missedliveauction")
	public void Verify_Quantity_Digits_field_on_Auction_Lot_page_10343(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno = common.generateRandomNumber1();

		String tomorrowDate = common.tomorrowDate();
		String auctionName = adminDashboardPage.create_Timed_Auction(saleno);

		adminDashboardPage.Verify_Quantity_Digits_field_on_Auction_Lot_page();

	}

	// 3
	@Test(dataProvider = "missedliveauction")
	public void Verify_validation_on_Lot_Item_pages_for_invalid_input_in_Quantity_Digits_field_10346(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno = common.generateRandomNumber1();

		String tomorrowDate = common.tomorrowDate();
		String auctionName = adminDashboardPage.create_Timed_Auction(saleno);

		adminDashboardPage.Verify_validation_on_Lot_Item_pages_for_invalid_input_in_Quantity_Digits_field();

	}

	// 4
	@Test(dataProvider = "missedliveauction")
	public void Verify_to_add_edit_Quantity_digits_field_data_on_Category_page_10351(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getdev_auctionUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_to_add_edit_Quantity_digits_field_data_on_Category_page();

	}

	// 5
	@Test(dataProvider = "missedliveauction")
	public void Verify_default_value_zero_0_for_Lot_quantity_digits_10352(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getdev_auctionUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_default_value_zero_0_for_Lot_quantity_digits();

	}

	// 6
	@Test(dataProvider = "missedliveauction")
	public void Verify_rounding_of_Quantity_as_per_Quantity_digits_on_Lot_Item_level_10354(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getdev_auctionUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_rounding_of_Quantity_as_per_Quantity_digits_on_Lot_Item_level();

	}

	// 7
	@Test(dataProvider = "missedliveauction")
	public void Verify_rounding_of_Quantity_as_per_Quantity_digits_on_auction_lot_level_10353(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getdev_auctionUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Verify_rounding_of_Quantity_as_per_Quantity_digits_on_auction_lot_level();
		adminDashboardPage.Verify_functionality_of_Visible_checkbox_on_auction_Lot_page();
		String saleno = common.generateRandomNumber1();
		adminDashboardPage.createTimedAuction(saleno);
		adminDashboardPage.Add_Lot_for_dev_auction();

	}

	// 8
	@Test(dataProvider = "missedliveauction")
	public void Verify_rounding_of_Quantity_as_per_Quantity_digits_on_account_setting_level_10355(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getdev_auctionUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Verify_rounding_of_Quantity_as_per_Quantity_digits_on_account_setting_level();
		adminDashboardPage.Verify_functionality_of_Visible_checkbox_on_auction_Lot_page();
		String saleno = common.generateRandomNumber1();

		String tomorrowDate = common.tomorrowDate();
		adminDashboardPage.createTimedAuction(saleno);
		adminDashboardPage.Add_Lot_for_dev_auction_for_account_setting_level();

	}

	// 9
	@Test(dataProvider = "missedliveauction")
	public void Verify_rounding_of_Quantity_as_per_Quantity_digits_on_category_level_10377(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getdev_auctionUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String cat = common.generateRandomChars(4);
		adminDashboardPage.Verify_rounding_of_Quantity_as_per_Quantity_digits_on_category_level(cat);
		String saleno = common.generateRandomNumber1();

		String tomorrowDate = common.tomorrowDate();
		adminDashboardPage.createTimedAuction(saleno);
		adminDashboardPage.Add_Lot_without_quantity_digits(cat);

	}

	// 10 
	@Test(dataProvider = "missedliveauction")
	public void Verify_rounding_of_Quantity_on_view_invoice_page_as_per_Quantity_digits_value_10359(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getdev_auctionUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String saleno = common.generateRandomNumber1();
		String name = common.generateRandomNumber1();
		adminDashboardPage.Verify_functionality_of_Visible_checkbox_on_auction_Lot_page();
		adminDashboardPage.Verify_rounding_of_Quantity_on_view_settlement_page_as_per_Quantity_digits_value();
		adminDashboardPage.create_timed_auction_with_all_dates(saleno,name);
		//adminDashboardPage.Add_lot_with_publish_date();
		adminDashboardPage.Add_Lot_for_invoice();
		adminDashboardPage.approvebidderindev();
		adminDashboardPage.enter_bids();
		adminDashboardPage.Generate_invoice();

	}

	// 11
	@Test(dataProvider = "missedliveauction")
	public void Verify_rounding_of_Quantity_on_view_settlement_page_as_per_Quantity_digits_value_10441(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getdev_auctionUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String saleno = common.generateRandomNumber1();
		String name = common.generateRandomNumber1();
		adminDashboardPage.Verify_functionality_of_Visible_checkbox_on_auction_Lot_page();
		adminDashboardPage.Verify_rounding_of_Quantity_on_view_settlement_page_as_per_Quantity_digits_value();
		adminDashboardPage.create_timed_auction_with_all_dates(saleno, name);
		adminDashboardPage.add_Lot_With_Publish_Date();
		adminDashboardPage.approvebidderindev();
		adminDashboardPage.enter_bids();
		adminDashboardPage.settlement_search_consignor(name);

	}

	// 12
	@Test(dataProvider = "missedliveauction")
	public void Verify_to_view_Quantity_digits_title_under_Settings_System_Parameters_Admin_Options_Inventory_page_10566(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getdev_auctionUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage
				.Verify_to_view_Quantity_digits_title_under_Settings_System_Parameters_Admin_Options_Inventory_page();
	}

	// 13
	@Test(dataProvider = "missedliveauction")
	public void Verify_functionality_of_Visible_checkbox_on_auction_Lot_page_10567(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getdev_auctionUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String salename = common.generateRandomChars(5);
		adminDashboardPage.Verify_functionality_of_Visible_checkbox_on_auction_Lot_page();
		adminDashboardPage.create_Live_Auction(salename);

		adminDashboardPage.verify_quantity_digits_field_visible_or_not_visible();
		adminDashboardPage.verify_quantity_digit_is_disable_and_check_on_lot_page(salename);

	}

	// 14
	@Test(dataProvider = "missedliveauction")
	public void Verify_functionality_of_Visible_checkbox_on_Item_page_10568(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getdev_auctionUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Verify_functionality_of_Visible_checkbox_on_auction_Lot_page();
		adminDashboardPage.Verify_functionality_of_Visible_checkbox_on_Item_page();
		adminDashboardPage.verify_quantity_digit_is_disabled_and_check_on_item_page();

	}

	// 15
	@Test(dataProvider = "missedliveauction")
	public void Verify_functionality_of_Required_checkbox_on_auction_Lot_page_10569(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getdev_auctionUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Verify_required_for_quantity_digits_is_checked();
		String saleno = common.generateRandomNumber1();
		// String cat = common.generateRandomChars(4);

		String tomorrowDate = common.tomorrowDate();
		adminDashboardPage.createTimedAuction(saleno);
		adminDashboardPage.Verify_functionality_of_Required_checkbox_on_auction_Lot_page();

	}

	// 16
	@Test(dataProvider = "missedliveauction")
	public void Verify_functionality_of_enabling_Required_checkbox_on_Admin_Options_Inventory_page_10571(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getdev_auctionUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Verify_functionality_of_enabling_Required_checkbox_on_Admin_Options_Inventory_page();

	}

	// 17
	@Test(dataProvider = "missedliveauction")
	public void Verify_functionality_of_Required_checkbox_on_Item_page_10574(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getdev_auctionUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		// adminDashboardPage.Verify_functionality_of_enabling_Required_checkbox_on_Admin_Options_Inventory_page();

		adminDashboardPage.Verify_functionality_of_Required_checkbox_on_Item_page();

	}

	// 18
	@Test(dataProvider = "missedliveauction")
	public void Verify_validation_on_Category_page_for_invalid_input_in_Quantity_Digits_field_10606(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getdev_auctionUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Verify_validation_on_Category_page_for_invalid_input_in_Quantity_Digits_field();

	}

	// 19
	@Test(dataProvider = "missedliveauction")
	public void Verify_validation_on_account_settings_page_for_invalid_input_in_Lot_quantity_digits_field_10607(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getdev_auctionUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Verify_validation_on_account_settings_page_for_invalid_input_in_Lot_quantity_digits_field();

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