package com.auction.verifications;

import java.text.ParseException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.auction.init.Common;
import com.auction.init.ConfigFileReader;
import com.auction.init.SeleniumInit;

public class SAM_9695 extends SeleniumInit {

	Common common = new Common(driver);

	String bidder2 = "rahulbid";
	String bidder2Pass = "rahulbid";
	String UName = "rahulqa";
	String password = "123123a";
	ConfigFileReader configFileReader = new ConfigFileReader();

	//1
	@Test(dataProvider = "missedliveauction")
	public void Checking_the_validation_message_for_always_required_fields_Auction_Type_10028(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Checking_the_validation_message_for_always_required_fields_Auction_Type();

	}

	// 2
	@Test(dataProvider = "missedliveauction")
	public void Checking_the_Visible_option_for_the_always_optional_fields_Listing_only_reverse_auction_and_Clerking_style_10033(
			String adminUserName, String adminPassword, String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Uncheck_the_fields_Listing_only_reverse_auction_and_Clerking_style();
		adminDashboardPage.Checking_the_fields_Listing_only_reverse_auction_and_Clerking_style_not_available();

		adminDashboardPage.Check_the_fields_Listing_only_reverse_auction_and_Clerking_style();
		adminDashboardPage.Checking_the_fields_Listing_only_reverse_auction_and_Clerking_style_available();

	}

	// 3
	@Test(dataProvider = "missedliveauction")
	public void Checking_the_Visible_option_for_the_always_optional_fields_start_date_indicator_and_end_date_indicator_10037(
			String adminUserName, String adminPassword, String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage
				.Uncheck_the_Visible_option_for_the_always_optional_fields_start_date_indicator_and_end_date_indicator();

		adminDashboardPage.create_Live_Auction("Live Auc 1");
		adminDashboardPage
				.Checking_the_Visible_option_for_the_always_optional_fields_start_date_indicator_and_end_date_indicator_not_available();

		adminDashboardPage
				.Check_the_Visible_option_for_the_always_optional_fields_start_date_indicator_and_end_date_indicator();
		adminDashboardPage.create_Live_Auction("Live Auc 2");
		adminDashboardPage
				.Checking_the_Visible_option_for_the_always_optional_fields_start_date_indicator_and_end_date_indicator_available();

	}

	// 4
	@Test(dataProvider = "missedliveauction")
	public void Checking_the_Visible_option_for_the_always_optional_fields_Stream_display_and_enable_parcel_choice_lots_10039(
			String adminUserName, String adminPassword, String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage
				.Check_the_Visible_option_for_the_always_optional_fields_Stream_display_and_enable_parcel_choice_lots();
		adminDashboardPage.Checking_the_fields_Stream_display_and_enable_parcel_choice_lots_available();

		adminDashboardPage
				.Uncheck_the_Visible_option_for_the_always_optional_fields_Stream_display_and_enable_parcel_choice_lots();
		adminDashboardPage.Checking_the_fields_Stream_display_and_enable_parcel_choice_lots_not_available();

	}

	// 5
	@Test(dataProvider = "missedliveauction")
	public void Checking_the_Visible_option_for_the_always_optional_fields_Consignor_Commission_and_Fee_and_Lots_Visibility_options_10040(
			String adminUserName, String adminPassword, String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage
				.Check_the_Visible_option_for_the_always_optional_fields_Consignor_Commission_and_Fee_and_Lots_Visibility_options();
		adminDashboardPage.Checking_the_fields_Consignor_Commission_and_Fee_and_Lots_Visibility_options_available();

		adminDashboardPage
				.Uncheck_the_Visible_option_for_the_always_optional_fields_Consignor_Commission_and_Fee_and_Lots_Visibility_options();
		adminDashboardPage.Checking_the_fields_Consignor_Commission_and_Fee_and_Lots_Visibility_options_Not_available();

	}

	// 6
	@Test(dataProvider = "missedliveauction")
	public void Checking_the_Visible_option_for_the_always_optional_fields_Event_type_Publish_and_unpublish_date_start_and_end_register_date_10056(
			String adminUserName, String adminPassword, String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage
				.Uncheck_the_Visible_option_for_the_always_optional_fields_Event_type_Publish_and_unpublish_date_start_and_end_register_date();
		adminDashboardPage
				.Checking_the_fields_Event_type_Publish_and_unpublish_date_start_and_end_register_date_not_available();

		adminDashboardPage
				.Check_the_Visible_option_for_the_always_optional_fields_Event_type_Publish_and_unpublish_date_start_and_end_register_date();
		adminDashboardPage
				.Checking_the_fields_Event_type_Publish_and_unpublish_date_start_and_end_register_date_available();

	}

	// 7
	@Test(dataProvider = "missedliveauction")
	public void Check_the_required_option_for_the_ields_End_pre_bidding_date_Staggering_closing_and_lots_interval_exclude_closed_lot_and_Sale_10042(
			String adminUserName, String adminPassword, String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage
				.Check_the_required_option_for_the_ields_End_pre_bidding_date_Staggering_closing_and_lots_interval_exclude_closed_lot_and_Sale();
		adminDashboardPage
				.Checking_the_required_option_for_the_ields_End_pre_bidding_date_Staggering_closing_and_lots_interval_exclude_closed_lot_and_Sale_available();

		adminDashboardPage
				.UnCheck_the_required_option_for_the_ields_End_pre_bidding_date_Staggering_closing_and_lots_interval_exclude_closed_lot_and_Sale();
		adminDashboardPage
				.Checking_the_required_option_for_the_ields_End_pre_bidding_date_Staggering_closing_and_lots_interval_exclude_closed_lot_and_Sale_Not_available();

	}

	// 8
	@Test(dataProvider = "missedliveauction")
	public void Check_the_required_option_for_the_fields_Invoice_location_T_n_C_Invoice_notes_shipping_info_10043(
			String adminUserName, String adminPassword, String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage
				.Check_the_required_option_for_the_fields_Invoice_location_T_n_C_Invoice_notes_shipping_info();
		adminDashboardPage
				.Checking_the_required_option_for_the_fields_Invoice_location_T_n_C_Invoice_notes_shipping_info_available();

		adminDashboardPage
				.UnCheck_the_required_option_for_the_fields_Invoice_location_T_n_C_Invoice_notes_shipping_info();
		adminDashboardPage
				.Checking_the_required_option_for_the_fields_Invoice_location_T_n_C_Invoice_notes_shipping_info_not_available();

	}

	// 9
	@Test(dataProvider = "missedliveauction")
	public void Check_the_required_option_for_the_fields_Image_event_location_auction_tax_country_tax_auction_info_link_SEO_fields_10044(
			String adminUserName, String adminPassword, String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage
				.Check_the_required_option_for_the_fields_Image_event_location_auction_tax_country_tax_auction_info_link_SEO_fields();
		adminDashboardPage
				.Checking_the_required_option_for_the_fields_Image_event_location_auction_tax_country_tax_auction_info_link_SEO_fields_available();

		adminDashboardPage
				.UnCheck_the_required_option_for_the_fields_Image_event_location_auction_tax_country_tax_auction_info_link_SEO_fields();
		adminDashboardPage
				.Checking_the_required_option_for_the_fields_Image_event_location_auction_tax_country_tax_auction_info_link_SEO_fields_not_available();

	}

	// 10
	@Test(dataProvider = "missedliveauction")
	public void Check_the_required_option_for_the_custom_fileds_10055(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Check_the_required_option_for_the_custom_fileds();
		adminDashboardPage.Checking_the_required_option_for_the_custom_fileds_available();

		adminDashboardPage.UnCheck_the_required_option_for_the_custom_fileds();
		adminDashboardPage.Checking_the_required_option_for_the_custom_fileds_not_available();

	}

	// 11
	@Test(dataProvider = "missedliveauction")
	public void Check_the_required_options_for_the_fields_Event_type_publish_and_unpublish_date_start_and_end_register_date_10041(
			String adminUserName, String adminPassword, String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage
				.Check_the_required_options_for_the_fields_Event_type_publish_and_unpublish_date_start_and_end_register_date();
		adminDashboardPage
				.Checking_the_required_option_for_the_fields_Event_type_publish_and_unpublish_date_start_and_end_register_date_available();

		adminDashboardPage
				.UnCheck_the_required_options_for_the_fields_Event_type_publish_and_unpublish_date_start_and_end_register_date();
		adminDashboardPage
				.Checking_the_required_option_for_the_fields_Event_type_publish_and_unpublish_date_start_and_end_register_date_not_available();

	}

	// 12
	@Test(dataProvider = "missedliveauction")
	public void Check_the_visible_option_for_the_fields_End_pre_bidding_date_Staggering_closing_and_lots_interval_exclude_closed_lot_and_Sale_10058(
			String adminUserName, String adminPassword, String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage
				.UnCheck_the_visible_option_for_the_fields_End_pre_bidding_date_Staggering_closing_and_lots_interval_exclude_closed_lot_and_Sale();
		adminDashboardPage
				.Checking_the_visible_option_for_the_ields_End_pre_bidding_date_Staggering_closing_and_lots_interval_exclude_closed_lot_and_Sale_not_available();

		adminDashboardPage
				.Check_the_visible_option_for_the_fields_End_pre_bidding_date_Staggering_closing_and_lots_interval_exclude_closed_lot_and_Sale();
		adminDashboardPage
				.Checking_the_visible_option_for_the_ields_End_pre_bidding_date_Staggering_closing_and_lots_interval_exclude_closed_lot_and_Sale_available();

	}

	// 13
	@Test(dataProvider = "missedliveauction")
	public void Check_the_visible_option_for_the_fields_Invoice_location_T_n_C_Invoice_notes_shipping_info_10060(
			String adminUserName, String adminPassword, String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Check_the_visible_option_for_the_fields_Invoice_location_T_n_C_Invoice_notes_shipping_info();
		adminDashboardPage
				.Checking_the_visible_option_for_the_fields_Invoice_location_T_n_C_Invoice_notes_shipping_info_available();

		adminDashboardPage
				.UnCheck_the_visible_option_for_the_fields_Invoice_location_T_n_C_Invoice_notes_shipping_info();
		adminDashboardPage
				.Checking_the_visible_option_for_the_fields_Invoice_location_T_n_C_Invoice_notes_shipping_info_not_available();

	}

	// 14
	@Test(dataProvider = "missedliveauction")
	public void Check_the_visible_option_for_the_fields_Image_event_location_auction_tax_country_tax_auction_info_link_SEO_fields_10061(
			String adminUserName, String adminPassword, String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage
				.Check_the_visible_option_for_the_fields_Image_event_location_auction_tax_country_tax_auction_info_link_SEO_fields();
		adminDashboardPage
				.Checking_the_visible_option_for_the_fields_Image_event_location_auction_tax_country_tax_auction_info_link_SEO_fields_available();

		adminDashboardPage
				.UnCheck_the_visible_option_for_the_fields_Image_event_location_auction_tax_country_tax_auction_info_link_SEO_fields();
		adminDashboardPage
				.Checking_the_visible_option_for_the_fields_Image_event_location_auction_tax_country_tax_auction_info_link_SEO_fields_not_available();

	}

	// 15
	@Test(dataProvider = "missedliveauction")
	public void Check_the_visible_option_for_the_custom_fileds_10063(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Check_the_visible_option_for_the_custom_fileds();
		adminDashboardPage.Checking_the_visible_option_for_the_custom_fileds_available();

		adminDashboardPage.UnCheck_the_visible_option_for_the_custom_fileds();
		adminDashboardPage.Checking_the_visible_option_for_the_custom_fileds_not_available();

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
