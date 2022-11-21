package com.auction.verifications;

import java.awt.AWTException;
import java.text.ParseException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.auction.init.Common;
import com.auction.init.ConfigFileReader;
import com.auction.init.SeleniumInit;
import com.auction.pages.DashboardPage;
import com.auction.pages.SignupPage;

public class SAM_9369 extends SeleniumInit {

	// String saleno = null;
	// String auctionName = null;
	String lotName = null;
	String uName = null;
	String bidder2 = "rahulbid";
	String bidder2Pass = "123123a";
	Common common = new Common(driver); 
	ConfigFileReader configFileReader= new ConfigFileReader();
	/**
	 * Verify Auction Type Missing
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Refactor_play_sound_to_avoid_client_side_caching_of_stale_files_9373(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		
		adminDashboardPage.Verify_sound_settings();

	}
	@Test(dataProvider = "missedliveauction")
	public void Oops_error_occurs_9387(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		
		adminDashboardPage.Verify_oops_error();

	}
	
	
	@Test(dataProvider = "missedliveauction")
	public void Verify_proper_validation_for_lot_number_field_9400(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		String tomorrowDate = common.tomorrowDate();
		log("Feature" + "-" + "UAT" + "\"group items and sell Feature,TestCase Name :: Group item x and ungroup.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		
		adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		adminDashboardPage.veryfy_lot_number_field_with_alphabeticalValue();

	}
	

	@Test(dataProvider = "missedliveauction")
	public void Default_dropdown_check_adv_auction_9401(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		String saleno = common.generateRandomNumber1();

		String tomorrowDate = common.tomorrowDate();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Create_Live_Auction_Advance_9401(saleno);
		adminDashboardPage.simplyAddLot();
		adminDashboardPage.start_Auction();
		adminDashboardPage.selectAndDelInc();
	}
	@Test(dataProvider = "missedliveauction")
	public void Error_in_csvfile_9405(String adminUserName, String adminPassword, String Name) throws InterruptedException, AWTException {
		

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.errorInCSV();


	}
	@Test(dataProvider = "missedliveauction")
	public void Validation_message_verification_9409(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		
		adminDashboardPage.Validation_message_verification();

	}
	@Test(dataProvider = "missedliveauction")
	public void Warning_msg_when_endDate_is_past_9419(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		
		adminDashboardPage.Set_past_endDate();

	}
	
	@Test(dataProvider = "missedliveauction")
	public void Merge_settlement_error_9427(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		
		adminDashboardPage.Merge_settlement();

	}
	
	@Test(dataProvider = "missedliveauction")
	public void Mailing_list_report_Cancel_button_doesNotWork_9434(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		
		adminDashboardPage.mailing_list_cancelButton();

	}
	
	@Test(dataProvider = "missedliveauction")
	public void Overwrite_warning_is_not_displayed_9426(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		
		adminDashboardPage.overwrite_warning_check();

	}
	@Test(dataProvider = "missedliveauction")
	public void Pls_selectUser_validation_msg_9451(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		
		adminDashboardPage.check_validation_message();

	}
	
	@Test(dataProvider = "missedliveauction")
	public void Multiple_add_extra_charge_shows_only_single_remove_button_9456(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		
		adminDashboardPage.add_extra_charge();

	}
	
	@Test(dataProvider = "missedliveauction")
	public void Buyers_premium_value_does_not_save_9460(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		
		adminDashboardPage.edit_and_save_buyers_premium_value();

	}
	
	@Test(dataProvider = "missedliveauction")
	public void Editable_field_for_commission_shows_in_nonEditableMode_9467 (String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		
		adminDashboardPage.edit_settlement();

	}
	

	@Test(dataProvider = "missedliveauction")
	public void Currency_not_displayed_9473(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Create_Live_Auction_Advance_9401("nth");
		adminDashboardPage.check_currency_in_lot_page();

	}
	
	@Test(dataProvider = "missedliveauction")
	public void Bid_updated_as_default_value_9485(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Create_Live_Auction_Advance_9401("nth");
		adminDashboardPage.add_lot();
		adminDashboardPage.inc_and_undo_bid_in_runLive_auction();

	}
	

	@Test(dataProvider = "missedliveauction")
	public void Asking_bid_got_blank_if_starting_bid_or_estimate_amounts_are_not_mentioned_in_lot_9497(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Create_Live_Auction_Advance_9401("nth");
		adminDashboardPage.add_lot();
		adminDashboardPage.Verify_asking_bid();

	}
	
	@Test(dataProvider = "missedliveauction")
	public void Referrer_report_not_showing_data_on_NA_referrer_9386(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.check_for_data_on_NA_referrer();
		

	}
	
	@Test(dataProvider = "missedliveauction")
	public void Upload_image_with_inserting_image_URL_functionality_is_not_working_proper_in_add_lot_page_9418(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.CreateNewAuction("nthh");
		adminDashboardPage.upload_image_in_add_lot();
		
		

	}
	
	@Test(dataProvider = "missedliveauction")
	public void Issues_related_to_QTY_column_at_admin_frontend_9421(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.CreateNewAuction("nthh");
		adminDashboardPage.upload_image_in_add_lot();
		
		
	
	}
	
	@Test(dataProvider = "missedliveauction")
	public void Issues_related_to_QTY_column_at_admin_Frontend_9421(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.quality_coloumn_verification();
		
	}
	
	@Test(dataProvider = "missedliveauction")
	public void When_dropdown_option_has_more_than_two_words_with_space_it_is_not_working_properly_9420(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.add_custom_user_field();
		
	}
	

	@Test(dataProvider = "missedliveauction")
	public void Oops_error_occurs_on_multiple_clicks_on_check_mark_icon_9452(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.multiple_clicks_on_check_icon();
		
	}
	
	@Test(dataProvider = "missedliveauction")
	public void Header_image_disappears_on_saving_twice_9453(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.header_image_disappears_on_saving_twice();

		common.pause(30);
		System.out.println("log in to front end");
		common.log("<br></br>Step :: log in to front end");
		

		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		dashboardPage.Verify_image_at_front_end();
		
		
		
	}
	
	@Test(dataProvider = "missedliveauction")
	public void  Issues_with_print_report_Generate_pdf_buttons_in_consignor_report_9465(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.CreateNewAuction("nthh");
		adminDashboardPage.verify_print_and_generate_report_button();

		
		
	}
	
	@Test(dataProvider = "missedliveauction")
	public void  Profile_frontend_redirecting_to_error_page_9470(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		System.out.println("log in to front end");
		common.log("<br></br>Step :: log in to front end");
		
		driver.get(configFileReader.getFrontUrl());
		common.pause(20);
		//adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		dashboardPage.verify_error_page();

		
		
	}
	
	@Test(dataProvider = "missedliveauction")
	public void  At_adding_lot_page_the_custom_field_of_file_type_do_not_allow_to_add_file_more_than_one_9377(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {


		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String str = adminDashboardPage.create_custom_field_of_file_type();
		adminDashboardPage.CreateNewAuction("nthh");
		adminDashboardPage.add_file_at_lot(str);
		
		
	}
	
	@Test(dataProvider = "missedliveauction")
	public void Category_information_from_edit_section_is_not_removed_after_delete_9371(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {


		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.edit_and_delete_category();
		
		
	}
	
	@Test(dataProvider = "missedliveauction")
	public void per_user_doesnot_display_on_main_coupon_page_if_its_set_to_0_9412(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {


		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.add_coupon_with_zero();
		
		
	}
	
	@Test(dataProvider = "missedliveauction")
	public void Item_consigned_delete_functionality_is_not_working_9402(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {


		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		
		adminDashboardPage.enable_lot_delete_for_consignor();
		adminDashboardPage.CreateNewAuction("nthh");
		adminDashboardPage.add_lot_with_consignor();
		
		System.out.println("log in to front end");
		common.log("<br></br>Step :: log in to front end");
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		
		dashboardPage.verify_delete_functionality();
		
	}
	
	@Test(dataProvider = "missedliveauction")
	public void Oops_error_occurs_while_edit_invoice_number_9422(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {


		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.edit_invoice_number();
		
		
	}
	
	@Test(dataProvider = "missedliveauction")
	public void Invoices_are_not_getting_generated_9439(String adminUserName, String adminPassword, String Name)
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
		adminDashboardPage.approveBidder1_2();
		adminDashboardPage.runlive_postfloor_sold();
		//adminDashboardPage. Generate_Invoice_5160(auctionName);
		adminDashboardPage.verify_invoice_generated(auctionName);
		
		
		
	}
	
	@Test(dataProvider = "missedliveauction")
	public void Type_auctions_validation_stays_on_auction_lots_page_after_cloning_9484(String adminUserName, String adminPassword, String Name)
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
		
		adminDashboardPage.clone_lot();
		
		
	}
	
	@Test(dataProvider = "missedliveauction")
	public void Removed_payment_and_payment_details_displayed_on_confirmation_are_rendered_with_negative_balance_due_9464(String adminUserName, String adminPassword, String Name)
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
		adminDashboardPage.approveBidder1();
		adminDashboardPage.runlive_postfloor_sold();
		adminDashboardPage.verify_invoice_generated(auctionName);
		adminDashboardPage.add_and_remove_payment();
		
		
		
	}
	
	@Test(dataProvider = "missedliveauction")
	public void Lot_custom_fields_at_search_filters_do_not_work_as_expected_9384(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {


		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String name = common.generateRandomChars(5);
		String para = common.generateRandomChars(5);
		
		adminDashboardPage.add_custom_user_field_searchable(name, para);
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.add_lot_with_customField(name,para);
		
	}
	
	@Test(dataProvider = "missedliveauction")
	public void Lot_custom_fields_at_search_filters_do_not_work_as_expected_9384_2(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {


		log("Feature" + "-" + "UAT"
				+ "\"Create Auction type missing Feature,TestCase Name: 3.1 Auction type missing Feature.");
		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String name = common.generateRandomChars(5);
		
		adminDashboardPage.add_custom_user_field_searchable_int(name);
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.add_lot_with_customField_int(name);
		
	}
	
	@Test(dataProvider = "missedliveauction")
	public void This_invoice_has_no_balance_due_validation_is_displayed_even_when_balance_due_is_available_9466(String adminUserName, String adminPassword, String Name)
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
		adminDashboardPage.verify_balance_due_error();
		
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


