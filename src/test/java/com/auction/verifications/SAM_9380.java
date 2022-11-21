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

public class SAM_9380 extends SeleniumInit {

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
	public void Oops_error_displayed_at_header_while_saving_lot_on_quick_edit_mode_10285(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.CreateNewAuction("nthh");
		adminDashboardPage.add_lot();
		adminDashboardPage.quick_edit_lot();

	}

	// 2
	@Test(dataProvider = "missedliveauction")
	public void Save_button_on_quick_edit_functionality_is_not_working_9947(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.CreateNewAuction("nthh");
		adminDashboardPage.add_lot();
		adminDashboardPage.Check_save_button_functionality_in_quick_edit_mode();

	}

	// 3
	@Test(dataProvider = "missedliveauction")
	public void Oops_error_occurred_when_visit_bidders_page_9944(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.CreateNewAuction("nthh");
		adminDashboardPage.add_lot();
		adminDashboardPage.visit_bidders_page();

	}

	// 4
	@Test(dataProvider = "missedliveauction")
	public void Non_existing_post_floor_bidder_redirects_to_400_error_9746(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.CreateNewAuction("nthh");
		adminDashboardPage.add_lot();
		adminDashboardPage.visit_bidders_page();

	}

	// 5
	@Test(dataProvider = "missedliveauction")
	public void Error_on_uploading_and_saving_sound_8018(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.upload_and_save_sound();

	}

	// 6
	@Test(dataProvider = "missedliveauction")
	public void Issues_related_to_additional_currencies_8014(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.set_default_currency_CAD();
		adminDashboardPage.CreateNewAuction("nthh");
		adminDashboardPage.verify_default_currency();

	}

	// 7
	@Test(dataProvider = "missedliveauction")
	public void Lot_details_page_of_live_running_auction_is_showing_error_500_9787(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.CreateNewAuction("nthh");
		adminDashboardPage.add_lot();
		adminDashboardPage.view_lot_detail_screen();

	}

	// 8
	@Test(dataProvider = "missedliveauction")
	public void Other_cc_radio_button_shows_inappropriate_pop_up_security_code_on_invoice_edit_page_10297(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String name = common.generateRandomChars(5);

		adminDashboardPage.enable_cc_info();
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		adminDashboardPage.add_simple_lot();
		adminDashboardPage.approveBidder1();
		adminDashboardPage.runlive_postfloor_sold();
		adminDashboardPage.verify_invoice_generated(auctionName);
		adminDashboardPage.verify_pop_up_security_code();

	}

	// 9
	@Test(dataProvider = "missedliveauction")
	public void Oops_error_occurred_when_user_enters_AuthorizeNet_credentials_and_click_on_save_changes_button_10320(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verify_oops_error_in_payments();

	}

	// 10
	@Test(dataProvider = "missedliveauction")
	public void Cancel_button_at_custom_templates_tab_is_not_responding_on_click_10277(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verify_cancel_button_at_custom_templates();

	}

	// 11
	@Test(dataProvider = "missedliveauction")
	public void Error_on_searching_with_invalid_customer_9831(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		adminDashboardPage.add_simple_lot();
		adminDashboardPage.search_with_invalid_customer();

	}

	// 12
	@Test(dataProvider = "missedliveauction")
	public void Category_image_doesnot_render_or_show_up_anywhere_8046(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String name = common.generateRandomChars(4);
		adminDashboardPage.set_category_with_image(name);
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		adminDashboardPage.verify_category_image(name);

	}

	// 13
	@Test(dataProvider = "missedliveauction")
	public void Not_reflecting_auction_title_date_time_and_live_sale_link_in_auctionCatalog_9760(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();

		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		// dashboardPage = loginPage.loginUser(UName, password);
		dashboardPage.goto_Catalog_Page_Live_Sale(auctionName);
		// dashboardPage.verify_time_date();

	}

	// 14
	@Test(dataProvider = "missedliveauction")
	public void Search_using_keyword_is_not_working_under_lot_section_9794(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {

		String saleno = common.generateRandomNumber1();

		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String lotname = common.generateRandomChars(5);
		String lotname1 = common.generateRandomChars(6);
		adminDashboardPage.CreateNewAuction("nthh");
		adminDashboardPage.add_simple_lot_get_name(lotname);
		adminDashboardPage.add_simple_lot_get_name(lotname1);
		adminDashboardPage.verify_search_functionality(lotname1);

	}

	// 15
	@Test(dataProvider = "missedliveauction")
	public void Click_on_default_icon_of_any_language_Oops_error_message_9680(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verify_error_msg_when_click_on_default_icon_of_language();

	}

	// 16
	@Test(dataProvider = "missedliveauction")
	public void Ajax_and_php_error_by_double_clicking_on_Add_new_button_9678(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.CreateNewAuction("abab");
		adminDashboardPage.Increments_Ajax_and_php_error_by_double_clicking_on_Add_new_button("nmnm");

	}

	// 17
	@Test(dataProvider = "missedliveauction")
	public void Delete_assigned_user_Deleted_user_data_is_not_updated_9687(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Delete_assigned_user_Deleted_user_data_is_not_updated();

	}

	// 18
	@Test(dataProvider = "missedliveauction")
	public void Auction_Info_Link_Redirect_to_Oops_error_9698(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getFrontUrl());
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		dashboardPage.Auction_Info_Link_Redirect_to_Oops_error();

	}

	// 19
	@Test(dataProvider = "missedliveauction")
	public void Click_on_search_button_Its_redirect_to_400_error_page_9702(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Click_on_search_button_Its_redirect_to_400_error_page();

	}

	// 20
	@Test(dataProvider = "missedliveauction")
	public void The_change_of_Items_per_page_parameter_should_redirect_to_the_first_page_9705(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getFrontUrl());
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		dashboardPage.The_change_of_Items_per_page_parameter_should_redirect_to_the_first_page();

	}

	// 21
	@Test(dataProvider = "missedliveauction")
	public void View_Invoice_Item_Name_info_is_missing_at_Admin_and_Frontend_9714(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String saleno = common.generateRandomNumber1();

		String tomorrowDate = common.tomorrowDate();
		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.add_lot();
		adminDashboardPage.approveBidder1_2();
		adminDashboardPage.runLiveSale1();

		adminDashboardPage.View_Invoice_Item_Name_info_is_missing_at_Admin_and_Frontend(auctionName);

	}

	// 22
	@Test(dataProvider = "missedliveauction")
	public void Admin_Reports_Payment_Sorting_is_not_proper_for_B_9717(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Admin_Reports_Payment_Sorting_is_not_proper_for_B();

	}

	// 23
	@Test(dataProvider = "missedliveauction")
	public void Search_field_and_filter_options_got_disappear_if_user_searches_bidder_with_non_matching_data_9720(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String saleno = common.generateRandomNumber1();

		String tomorrowDate = common.tomorrowDate();
		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.enter_All_Valid_Info();

		adminDashboardPage
				.Search_field_and_filter_options_got_disappear_if_user_searches_bidder_with_non_matching_data();

	}

	// 24
	@Test(dataProvider = "missedliveauction")
	public void Error_doesnt_show_up_on_saving_changes_underneath_the_field_at_landing_page_url_9696(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Error_doesnt_show_up_on_saving_changes_underneath_the_field_at_landing_page_url();

	}

	// 25
	@Test(dataProvider = "missedliveauction")
	public void Unable_to_upload_Auction_image_using_upload_file_button_9703(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Unable_to_upload_Auction_image_using_upload_file_button();

	}

	// 26
	@Test(dataProvider = "missedliveauction")
	public void On_searching_blank_input_redirects_to_400_bad_request_page_9948(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.On_searching_blank_input_redirects_to_400_bad_request_page();

	}

	// 27
	@Test(dataProvider = "missedliveauction")
	public void Increment_is_not_saved_in_sequence_9683(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno = common.generateRandomNumber1();

		// String tomorrowDate = common.tomorrowDate();
		String auctionName = adminDashboardPage.create_Live_Auction_Advance(saleno);

		adminDashboardPage.Increment_is_not_saved_in_sequence();

	}

	// 28
	@Test(dataProvider = "missedliveauction")
	public void No_validation_error_displayed_for_non_numeric_data_9699(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {

		driver.get(configFileReader.getFrontUrl());
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		dashboardPage.No_validation_error_displayed_for_non_numeric_data();

	}

	// 29
	@Test(dataProvider = "missedliveauction")
	public void Bp_Rule_doesnt_remain_selected_it_automatically_changes_to_default_after_saving_the_profile_10296(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		// String saleno = common.generateRandomNumber1();

		// String tomorrowDate = common.tomorrowDate();
		// String auctionName = adminDashboardPage.Create_Live_Auction_Advance(saleno);

		adminDashboardPage
				.Bp_Rule_doesnt_remain_selected_it_automatically_changes_to_default_after_saving_the_profile();

	}

	// 30
	@Test(dataProvider = "missedliveauction")
	public void Verify_Settings_Buyers_premium_After_creating_new_bp_rule_it_redirects_to_Live_rule_tab_10314(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_Settings_Buyers_premium_After_creating_new_bp_rule_it_redirects_to_Live_rule_tab();

	}

	// 31
	@Test(dataProvider = "missedliveauction")
	public void Verify_My_Settlements_400_bad_request_page_on_sorting_columns_10269(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getFrontUrl()); // Admin URL
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		common.pause(20);
		driver.get(configFileReader.settlement_Url());
		common.pause(20);

		dashboardPage.Verify_My_Settlements_400_bad_request_page_on_sorting_columns();

	}

	// 32
	@Test(dataProvider = "missedliveauction")
	public void Verify_Auction_bidders_Search_fields_Buttons_disappear_if_user_adds_removes_any_bidder_in_newly_created_auction_9763(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String name = common.generateRandomChars(5);
		int j = 0;
		adminDashboardPage.create_Live_Auction(name);
		adminDashboardPage.add_lot_with_consignor();
		adminDashboardPage.approveBidder1_2();
		adminDashboardPage
				.Verify_Auction_bidders_Search_fields_Buttons_disappear_if_user_adds_removes_any_bidder_in_newly_created_auction();

	}

	// 33
	@Test(dataProvider = "missedliveauction")
	public void Verify_My_Settlements_400_bad_request_page_on_filtering_settlements_with_All_option_10309(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getFrontUrl()); // Admin URL
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		common.pause(20);
		driver.get(configFileReader.settlement_Url());
		common.pause(20);
		dashboardPage.Verify_My_Settlements_400_bad_request_page_on_filtering_settlements_with_All_option();

	}

	// 34
	@Test(dataProvider = "missedliveauction")
	public void Verify_Settings_Accounts_Getting_Oops_error_on_creating_new_account_10305(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String name = common.generateRandomChars(5);
		adminDashboardPage.Verify_Settings_Accounts_Getting_Oops_error_on_creating_new_account(name);
	}

	// 35
	@Test(dataProvider = "missedliveauction")
	public void Verify_Manage_settlements_page_It_shows_Oops_Ajax_error_when_user_tries_to_charge_any_settlement_from_bulk_option_10281(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String name = common.generateRandomChars(5);
		String saleno = common.generateRandomNumber1();
		adminDashboardPage.create_Live_Auction(name);
		adminDashboardPage.add_lot_with_consignor();
		adminDashboardPage.add_lot2_with_consignor();
		adminDashboardPage.approveBidder1_2();
		adminDashboardPage.enter_bids();
		adminDashboardPage.enter_bids1();
		adminDashboardPage
				.Verify_Verify_Manage_settlements_page_It_shows_Oops_Ajax_error_when_user_tries_to_charge_any_settlement_from_bulk_option(
						name);
	}

	// 36
	@Test(dataProvider = "missedliveauction")
	public void Verify_Coupons_Limit_to_the_following_auctions_Auction_does_not_remain_selected_9952(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Verify_Coupons_Limit_to_the_following_auctions_Auction_does_not_remain_selected();

	}

	// 37
	@Test(dataProvider = "missedliveauction")
	public void Verify_Manage_Auction_Auction_hammer_price_gets_reset_on_cancel_option_10227(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String name = common.generateRandomChars(5);
		String saleno = common.generateRandomNumber1();
		adminDashboardPage.createliveauction1(saleno, name);
		adminDashboardPage.add1Lot();
		adminDashboardPage.runlive_postfloor_sold();
		adminDashboardPage.Verify_Manage_Auction_Auction_hammer_price_gets_reset_on_cancel_option(saleno);

	}

	// 38
	@Test(dataProvider = "missedliveauction")
	public void Verify_View_Settlement_page_Charge_with_payment_drop_down_with_Go_button_is_missing_10283(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String name = common.generateRandomChars(5);
		// String saleno = common.generateRandomNumber1();
		adminDashboardPage.create_Live_Auction(name);
		adminDashboardPage.add_lot_with_consignor();
		adminDashboardPage.approveBidder1();
		adminDashboardPage.enter_bids();

		adminDashboardPage.Verify_View_Settlement_page_Charge_with_payment_drop_down_with_Go_button_is_missing(name);

	}

	// 39
	@Test(dataProvider = "missedliveauction")
	public void Verify_Reverse_timed_auction_It_shows_Oops_Php_error_when_asking_bid_amount_reaches_0_10255(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String TimedAuction = common.generateRandomChars(5);
		String saleno = common.generateRandomNumber1();

		adminDashboardPage.Create_Timed_Reserve_Auction_Checkbox(TimedAuction, saleno);
		adminDashboardPage.Public_Add_Lot_With_Time();
		adminDashboardPage.approveBidder1_2();
		adminDashboardPage.front();

		// login to frontend
		driver.get(configFileReader.getFrontUrl()); // Admin URL
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		dashboardPage.Place_Bid_Timedsale_With_Bidder_Rahul_Qa(TimedAuction);

		// User 2 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);
		dashboardPage.Place_Bid_Timedsale_With_Bidder_Rahul_Bid(TimedAuction);

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		dashboardPage.Place_Bid_Timedsale_With_Bidder_Rahul_Qa_60_bid_value(TimedAuction);

		// User 2 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(bidder2, bidder2Pass);
		dashboardPage.Place_Bid_Timedsale_With_Bidder_Rahul_Bid_30_bid_value(TimedAuction);

		loginPage = indexPage.clickOnLoginLink();
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Verify_Reverse_timed_auction_It_shows_Oops_Php_error_when_asking_bid_amount_reaches_0(
				TimedAuction, saleno);

	}

	// 40
	@Test(dataProvider = "missedliveauction")
	public void Verify_Enter_bids_Bidder_validation_is_missing_when_user_tries_to_submit_or_sell_the_lot_without_entering_any_data_9832(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String name = common.generateRandomChars(5);
		adminDashboardPage.create_Live_Auction(name);
		adminDashboardPage.add_lot_with_consignor();
		adminDashboardPage.approveBidder1();
		adminDashboardPage
				.Verify_Enter_bids_Bidder_validation_is_missing_when_user_tries_to_submit_or_sell_the_lot_without_entering_any_data();

	}

	// 41
	@Test(dataProvider = "missedliveauction")
	public void Verify_My_items_Watchlist_Round_checkbox_functionality_is_not_working_properly_9791(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String name = common.generateRandomChars(5);
		String saleno = common.generateRandomNumber1();
		String TimedAuction = adminDashboardPage.createTimedAuction(saleno);
		adminDashboardPage.add_simple_lot_get_name(name);
		adminDashboardPage.approveBidder1();
		adminDashboardPage.front(); // Open Front End

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");

		// String name = common.generateRandomChars(5);;
		dashboardPage.Goto_Catalog_Page_Timed_Sale_for_All_Auctioneers(TimedAuction);
		dashboardPage.Verify_My_items_Watchlist_Round_checkbox_functionality_is_not_working_properly(name);

	}

	// 42
	@Test(dataProvider = "missedliveauction")
	public void Verify_Auction_bidders_Lots_Remaining_users_search_redirects_user_to_top_of_the_page_10212(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String name = common.generateRandomChars(5);
		String saleno = common.generateRandomNumber1();
		adminDashboardPage.createTimedAuction(saleno);
		adminDashboardPage.add_simple_lot_get_name(name);
		adminDashboardPage.Verify_Auction_bidders_Lots_Remaining_users_search_redirects_user_to_top_of_the_page();

	}

	// 43
	@Test(dataProvider = "missedliveauction")
	public void Verify_Settings_System_parameters_Auction_General_Confirmation_text_field_of_Confirm_timed_and_live_absentee_bids_checkbox_gets_hide_on_saving_changes_8073(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT" + "\" Create category,TestCase Name: 5.109");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Verify_Settings_System_parameters_Auction_General_Confirmation_text_field_of_Confirm_timed_and_live_absentee_bids_checkbox_gets_hide_on_saving_changes();
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
