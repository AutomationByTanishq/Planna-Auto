package com.auction.verifications;

import java.awt.AWTException;
import java.text.ParseException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.auction.init.Common;
import com.auction.init.ConfigFileReader;
import com.auction.init.SeleniumInit;

public class SAM_9772 extends SeleniumInit {

	Common common = new Common(driver);

	String bidder2 = "rahulbid";
	String bidder2Pass = "rahulbid";
	String UName = "rahulqa";
	String password = "123123a";
	ConfigFileReader configFileReader = new ConfigFileReader();

//1
	@Test(dataProvider = "missedliveauction")
	public void Verify_the_Checks_option_is_there_on_View_Settlement_page_9901(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_Checks_Tab_In_Settlement();

	}

	// 2
	@Test(dataProvider = "missedliveauction")
	public void Verify_it_opens_Checks_list_window_by_clicking_on_Checks_button_9902(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_Checks_list_In_Settlement();

	}
	// 3

	@Test(dataProvider = "missedliveauction")
	public void Verify_checks_form_when_there_are_no_checks_created_for_selected_settlement_9903(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_No_Checks_Created_In_Settlement();

	}

	// 4
	@Test(dataProvider = "missedliveauction")
	public void Verify_checks_form_when_there_only_one_check_created_for_selected_settlement_9904(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_only_one_Checks_Created_In_Settlement();

	}

	// 5
	@Test(dataProvider = "missedliveauction")
	public void Verify_checks_form_when_there_more_than_one_check_created_for_selected_settlement_9905(
			String adminUserName, String adminPassword, String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_More_Than_One_Check_Created_Checks_In_Settlement();

	}

	// 6
	@Test(dataProvider = "missedliveauction")
	public void Verify_loaded_data_on_check_form_9906(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_loaded_data_on_check_form();

	}

	// 7
	@Test(dataProvider = "missedliveauction")
	public void Verify_Info_tabs_where_settlement_edit_view_is_visible_9907(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_Info_tabs_where_settlement_edit_view_is_visible();

	}

	// 8
	@Test(dataProvider = "missedliveauction")
	public void Verify_Checks_tab_where_all_created_checks_are_visible_9908(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_Checks_tab_where_all_created_checks_are_visible();

	}

	// 9
	@Test(dataProvider = "missedliveauction")
	public void Verify_button_name_and_redirection_when_there_is_one_check_assigned_to_settlement_9917(
			String adminUserName, String adminPassword, String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_button_name_and_redirection_when_there_is_one_check_assigned_to_settlement();
	}

	// 10
	@Test(dataProvider = "missedliveauction")
	public void Verify_the_title_of_Settlement_Check_Edit_form_9919(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_the_title_of_Settlement_Check_Edit_form();
	}

	// 11
	@Test(dataProvider = "missedliveauction")
	public void Verify_back_page_link_on_Settlement_Check_Edit_form_if_user_comes_from_Settlement_Edit_page_9920_and_9921(
			String adminUserName, String adminPassword, String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage
				.Verify_back_page_link_on_Settlement_Check_Edit_form_if_user_comes_from_Settlement_Edit_page();
	}

	// 12
	@Test(dataProvider = "missedliveauction")
	public void Verify_fields_on_Settlement_Check_Edit_form_9922(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_fields_on_Settlement_Check_Edit_form();
	}

	// 13
	@Test(dataProvider = "missedliveauction")
	public void Verify_Check_field_on_Settlement_Check_Edit_form_by_entering_invalid_data_9923(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_Check_field_on_Settlement_Check_Edit_form_by_entering_invalid_data();
	}

	// 14
	@Test(dataProvider = "missedliveauction")
	public void Verify_Check_field_on_Settlement_Check_Edit_form_by_entering_valid_data_9924(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_Check_field_on_Settlement_Check_Edit_form_by_entering_valid_data();
	}

	// 15
	@Test(dataProvider = "missedliveauction")
	public void Verify_user_is_able_to_enter_value_in_Check_field_of_Settlement_Check_Edit_page_before_printing_9925(
			String adminUserName, String adminPassword, String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage
				.Verify_user_is_able_to_enter_value_in_Check_field_of_Settlement_Check_Edit_page_before_printing();
	}

	// 16
	@Test(dataProvider = "missedliveauction")
	public void Verify_if_Check_field_is_printed_on_the_check_9927(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_if_Check_field_is_printed_on_the_check();
	}

	// 17
	@Test(dataProvider = "missedliveauction")
	public void Verify_Inline_help_text_for_Check_field_9929(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_Inline_help_text_for_Check_field();
	}

	// 18
	@Test(dataProvider = "missedliveauction")
	public void Verify_Payee_field_on_Settlement_check_edit_page_without_entering_any_data_invalid_data_9930(
			String adminUserName, String adminPassword, String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_Payee_field_on_Settlement_check_edit_page_without_entering_any_data_invalid_data();
	}

	// 19
	@Test(dataProvider = "missedliveauction")
	public void Verify_Payee_field_on_Settlement_Check_edit_form_by_entering_valid_data_9931(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_Payee_field_on_Settlement_Check_edit_form_by_entering_valid_data();
	}

	// 20
	@Test(dataProvider = "missedliveauction")
	public void Verify_consignor_name_is_populated_in_Payee_field_while_creating_new_check_9932(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_consignor_name_is_populated_in_Payee_field_while_creating_new_check();
	}

	// 21
	@Test(dataProvider = "missedliveauction")
	public void Verify_Inline_help_text_for_Payee_field_on_Settlement_Edit_check_form_9934(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_Inline_help_text_for_Payee_field_on_Settlement_Edit_check_form();
	}

	// 22
	@Test(dataProvider = "missedliveauction")
	public void Verify_Populate_payee_button_on_Settlement_checks_edit_page_9937(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_Populate_payee_button_on_Settlement_checks_edit_page();
	}

	// 23
	@Test(dataProvider = "missedliveauction")
	public void Verify_Inline_help_text_for_Populate_Payee_button_9945(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_Inline_help_text_for_Populate_Payee_button();
	}

	// 24
	@Test(dataProvider = "missedliveauction")
	public void Verify_amount_field_on_Add_Edit_check_form_9975(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_amount_field_on_Add_Edit_check_form();
	}

	// 25
	@Test(dataProvider = "missedliveauction")
	public void Verify_to_add_edit_Settlement_check_form_without_entering_Amount_field_9977(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_to_add_edit_Settlement_check_form_without_entering_Amount_field();
	}

	// 26
	@Test(dataProvider = "missedliveauction")
	public void Verify_Inline_help_text_for_Amount_field_on_Settlement_Edit_check_form_9979(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_Inline_help_text_for_Amount_field_on_Settlement_Edit_check_form();
	}

	// 27
	@Test(dataProvider = "missedliveauction")
	public void Verify_Check_Document_rendering_for_check_printing_10072(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Upload_Image_For_Settlement_Check();
		adminDashboardPage.Verify_uploaded_settlement_check_image();
	}

	// 28
	@Test(dataProvider = "missedliveauction")
	public void Verify_Check_Height_field_for_check_printing_10073(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_Check_Height_field_for_check_printing();
	}

	// 29
	@Test(dataProvider = "missedliveauction")
	public void Verify_Checks_Per_page_field_for_check_printing_10074(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_Checks_per_page_field_for_check_printing();
	}

	// 30
	@Test(dataProvider = "missedliveauction")
	public void Verify_Check_content_repetition_field_for_check_printing_10075(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_Check_content_repetition_field_for_check_printing();
	}

	// 31
	@Test(dataProvider = "missedliveauction")
	public void Verify_all_coordinates_for_check_printing_10076(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_coordinates_for_check_printing();
	}

	// 32
	@Test(dataProvider = "missedliveauction")
	public void Verify_Populate_amount_spelling_button_functionality_when_there_invalid_data_in_Amount_field_10111(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_Populate_amount_spelling_button_functionality();
	}

	// 33
	@Test(dataProvider = "missedliveauction")
	public void Verify_Work_with_existing_checks_action_at_Manage_settlement_page_10144(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_Work_with_existing_checks_action_at_Manage_settlement_page();
	}

	// 34
	@Test(dataProvider = "missedliveauction")
	public void Verify_Create_new_checks_action_from_Manage_settlement_check_page_10145(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_Create_new_checks_checks_action_at_Manage_settlement_page();
	}

	// 35
	@Test(dataProvider = "missedliveauction")
	public void Verify_Search_all_checks_button_functionality_and_Check_Search_List_page_10146(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_Search_all_checks_button_functionality_and_Check_Search_List_page();
	}

	// 36
	@Test(dataProvider = "missedliveauction")
	public void Verify_filtered_search_at_Check_Search_list_page_10147(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_filtered_search_at_Check_Search_list_page();
	}

	// 37
	@Test(dataProvider = "missedliveauction")
	public void Verify_user_is_able_to_reset_applied_filter_10153(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_user_is_able_to_reset_applied_filter();
	}

	// 38
	@Test(dataProvider = "missedliveauction")
	public void Verify_Export_CSV_button_on_Settlement_checks_list_page_10163(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {

		log("<br></br> Step 1 :: Enter the URL in browser address bar and hit enter.");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_Export_CSV_button_on_Settlement_checks_list_page();
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
