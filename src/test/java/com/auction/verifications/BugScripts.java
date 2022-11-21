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

public class BugScripts extends SeleniumInit {
	Common common = new Common(driver);
	ConfigFileReader configFileReader = new ConfigFileReader();
	private int past;

	// 1
	@Test(dataProvider = "regularsignup")
	public void same_As_Billing_Checkbox_Functionality_Not_Work_4340(String adminUserName, String adminPassword)
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-4340");
		common.log("Ticket No. - SAM-4340");
		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.delete_Custom_Field();
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.verifyCheckedCheckboxOnRegistrationSettingsForRegularSignup(); // Verify
		// Checked
		// Check
		// box
		// Registration
		// Settings
		// Module
		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details(); // Go
		// To
		// Front
		// End

		signupPage.regularSignUp(FirstName, LastName, EmailUser, signUpUser); // Regular
																				// Sign
																				// Up
		signupPage.signup_Success_Message(); // Verify Success Message
		driver.quit();

	}

	// 2
	@Test
	public void sometimes_Getting_Php_Error_When_User_Click_On_SignUp_Button_4335() throws InterruptedException {
		System.out.println("Ticket No. - SAM-4335");
		common.log("Ticket No. - SAM-4335");

		driver.get(configFileReader.getqa_MainAutoFront());
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");

		dashboardPage.sometimes_Getting_Php_Error_When_User_Click_On_SignUp_Button();

	}

	// 3
	@Test
	public void trying_To_Get_Property_Of_Non_Object_Error_Displays_When_User_Click_On_BP_Tab_3900()
			throws InterruptedException, ParseException {
		System.out.println("Ticket No. - SAM-3900");
		common.log("Ticket No. - SAM-3900");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.trying_To_Get_Property_Of_Non_Object_Error_Displays_When_User_Click_On_BP_Tab();// Create
																											// Timed
																											// Auction

	}

	// 4
	@Test
	public void you_Dont_Have_Permission_To_Access_Error_Displays_After_Click_On_Create_Auction_3895()
			throws InterruptedException, ParseException {
		System.out.println("Ticket No. - SAM-3895");
		common.log("Ticket No. - SAM-3895");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.you_Dont_Have_Permission_To_Access_Error_Displays_After_Click_On_Create_Auction();// Create
																												// Timed
																												// Auction

	}

	// 5
	// This functionality has been dropped after v3-1
	@Test
	public void ajax_Error_Shown_When_User_Click_On_Save_Changes_Button_3838()
			throws InterruptedException, ParseException {
		System.out.println("Ticket No. - SAM-3838");
		common.log("Ticket No. - SAM-3838");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.ajax_Error_Shown_When_User_Click_On_Save_Changes_Button();
	}

	// 6
	@Test
	public void bad_Request_Error_Message_Displays_When_User_Select_Value_From_Dropdown_menus_3837()
			throws InterruptedException, ParseException {
		System.out.println("Ticket No. - SAM-3837");
		common.log("Ticket No. - SAM-3837");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.bad_Request_Error_Message_Displays_When_User_Select_Value_Form_Dropdown_Menus();
	}

	// 7
	@Test
	public void mySqli_Error_Shown_When_User_Click_On_Save_Changes_Button_From_Settings_3836()
			throws InterruptedException, ParseException {
		System.out.println("Ticket No. - SAM-3836");
		common.log("Ticket No. - SAM-3836");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.mySqli_Error_Shown_When_User_Click_On_Save_Changes_Button_From_Settings();
	}

	// 8
	@Test
	public void blank_Page_Displays_After_Click_On_Generate_New_Invoices_Button_3835()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-3835");
		common.log("Ticket No. - SAM-3835");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		String lotName = adminDashboardPage.addLotRandom(2);
		adminDashboardPage.approveBidder1(); // Approve both bidder
		adminDashboardPage.enter_bids();
		String currenturl = driver.getCurrentUrl();
		System.out.println("Current URL :: " + currenturl);
		adminDashboardPage.blank_Page_Displays_After_Click_On_Generate_New_Invoices_Button(auctionName); // Generate
		// Invoice

	}

	// 9
	@Test
	public void lot_Does_Not_Start_automatically_After_Click_On_Start_Auction_Button_3804()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-3804");
		common.log("Ticket No. - SAM-3804");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		String auctionName = adminDashboardPage.create_Hybrid_Auction(saleno);

		String lotName = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.approveBidder1(); // Approve both bidder
		adminDashboardPage.start_Auction();

		adminDashboardPage.lot_Does_Not_Start_Automatically_After_Click_On_Start_Auction_Button();

	}

	// 10
	@Test
	public void undefined_Variable_Error_Displays_When_User_Search_Category_3803() throws InterruptedException {
		System.out.println("Ticket No. - SAM-3803");
		common.log("Ticket No. - SAM-3803");

		driver.get(configFileReader.getqa_MainAutoFront());
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");

		dashboardPage.undefined_Variable_Error_Displays_When_User_Search_Category();

	}

	// 11
	@Test
	public void page_404_Not_Found_Error_Display_When_User_Click_On_Lot_Preview_Icon_3801()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-3801");
		common.log("Ticket No. - SAM-3801");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		String lotName = adminDashboardPage.addLotRandom(2);

		adminDashboardPage.page_404_Not_Found_Error_Display_When_User_Click_On_Lot_Preview_Icon();

	}

	// 12
	// This functionality has been dropped v3-2
	@Test
	public void this_Page_Is_Not_Working_Displays_When_User_Click_On_Drafts_3745()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-3745");
		common.log("Ticket No. - SAM-3745");

		String tomorrowDate = common.tomorrowDate();
		// String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		driver.get(configFileReader.getAdminUrl() + "/manage-drafts");

		adminDashboardPage.this_Page_Is_Not_Working_Displays_When_User_Click_On_Drafts();

	}
	// 13

	@Test
	public void user_Is_Able_To_Signup_With_Existing_User_Name_3731()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-3731");
		common.log("Ticket No. - SAM-3731");

		driver.get(configFileReader.getqa_MainAutoFront());
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");

		dashboardPage.user_Is_Able_To_Signup_With_Existing_User_Name();
	}

	// 14
	@Test
	public void user_Is_Able_To_Add_New_Category_With_Entering_Blank_Spaces_4483()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-4483");
		common.log("Ticket No. - SAM-4483");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.user_Is_Able_To_Add_New_Category_With_Entering_Blank_Spaces();

	}

	// 15
	@Test
	public void blank_Spaces_Accepted_As_A_Characters_In_Title_And_Code_Field_Coupon_4597()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-4597");
		common.log("Ticket No. - SAM-4597");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.blank_Spaces_Accepted_As_A_Characters_In_Title_And_Code_Field_Coupon();

	}

	// 16
	@Test
	public void coupon_Saved_With_Error_Message_4602() throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-4602");
		common.log("Ticket No. - SAM-4602");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.coupon_Saved_With_Error_Message();

	}

	// 17
	@Test
	public void set_Characters_Limit_For_Coupon_Page_Fields_4603()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-4603");
		common.log("Ticket No. - SAM-4603");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.set_Characters_Limit_For_Coupon_Page_Fields();

	}

	// 18
	@Test
	public void unable_To_Cast_String_Value_Error_Display_When_User_Enter_Alphabetical_Values_In_Percentage_Field_Save_Coupon_4606()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-4606");
		common.log("Ticket No. - SAM-4606");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage
				.unable_To_Cast_String_Value_Error_Display_When_User_Enter_Alphabetical_Values_In_Percentage_Field_Save_Coupon();

	}

	// 19
	@Test
	public void user_Is_Able_To_Add_New_Coupon_With_Past_Dates_4639()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-4639");
		common.log("Ticket No. - SAM-4639");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.user_Is_Able_To_Add_New_Coupon_With_Past_Dates();

	}

	// 20
	@Test
	public void mySqli_Error_Display_When_User_Click_On_Type_Header_In_Coupons_Table_4652()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-4652");
		common.log("Ticket No. - SAM-4652");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.mysql_Error_Display_When_User_Click_On_Type_Header_In_Coupons_Table();

	}

	// 21
	@Test
	public void unable_To_Cast_String_Error_Display_When_User_Enter_Upto_10_Digits_Fixed_Amount_And_Save_Coupon_4707()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-4707");
		common.log("Ticket No. - SAM-4707");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		
		adminDashboardPage
				.unable_To_Cast_String_Error_Display_When_User_Enter_Upto_10_Digits_Fixed_Amount_And_Save_Coupon();

	}

	// 22
	@Test
	public void undefined_GET_Property_Error_Display_When_User_Add_New_Coupon_4715()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-4715");
		common.log("Ticket No. - SAM-4715");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.undefined_GET_Property_Error_Display_When_User_Add_New_Coupon();

	}

	// 23
	@Test
	public void blank_Spaces_Accepted_As_A_Characters_In_Feed_Name_And_Slug_Field_4768()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-4768");
		common.log("Ticket No. - SAM-4768");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.blank_Spaces_Accepted_As_A_Characters_In_Feed_Name_And_Slug_Field();

	}

	// 24
	@Test
	public void set_Character_Limits_For_Feed_Name_And_Slug_Field_4773()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-4773");
		common.log("Ticket No. - SAM-4773");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.set_Character_Limits_For_Feed_Name_And_Slug_Field();

	}

	// 25
	@Test
	public void once_Required_Error_Message_Displays_Then_User_Not_Able_To_Save_Feed_With_Filled_Details_4792()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-4792");
		common.log("Ticket No. - SAM-4792");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.once_Required_Error_Message_Displays_Then_User_Not_Able_To_Save_Feed_With_Filled_Details();

	}

	// 26
	@Test
	public void ungroup_Text_Should_Display_On_Button_Instead_Of_Group_X_The_After_Refreshing_A_Page_In_Run_Live_Auction_Tab_5109()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5109");
		common.log("Ticket No. - SAM-5109");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.ungroup_Text_Should_Display_On_Button_Instead_Of_Group_X_The_After_Refreshing_A_Page_In_Run_Live_Auction_Tab();

	}

	// 27
	@Test
	public void wrong_Validation_Message_Display_For_Start_Date_Field_At_Creating_An_Auction_Time_5514()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5514");
		common.log("Ticket No. - SAM-5514");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.wrong_Validation_Message_Display_For_Start_Date_Field_At_Creating_An_Auction_Time();

	}

	// 28
	@Test
	public void user_Able_To_Save_Category_With_Special_Characters_Only_In_Category_Name_Field_5555()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5555");
		common.log("Ticket No. - SAM-5555");

		//driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		//adminDashboardPage = indexPage // Admin Signin
		//		.adminSignin("admin", "123123");

		//adminDashboardPage.user_Able_To_Save_Category_With_Special_Characters_Only_In_Category_Name_Field();
		System.out.println("Step :: This functionality is updated as user is able to save category with special characters");
		common.log("<br></br>Step :: This functionality is updated as user is able to save category with special characters");
	}

	// 29
	@Test
	public void set_Characters_Limit_For_Create_New_Bp_Rule_Name_Field_5602()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5602");
		common.log("Ticket No. - SAM-5602");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.set_Characters_Limit_For_Create_New_Bp_Rule_Name_Field();

	}

	// 30
	@Test
	public void oops_Error_Display_When_User_Click_Markpaid_For_Invoice_From_Invoices_Page_5643()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5643");
		common.log("Ticket No. - SAM-5643");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.oops_Error_Display_When_User_Click_MarkPaid_For_invoice_From_Invoices_page();

	}

	// 31
	@Test
	public void ajax_Error_Display_When_Search_User_Through_The_Keyword_In_Bidders_Tab_5650()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5650");
		common.log("Ticket No. - SAM-5650");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.ajax_Error_Display_When_Search_User_Through_The_Keyword_In_Bidders_Tab();

	}

	// 5655 pending due to other bug

	// 32
	@Test
	public void by_Default_Assigned_Status_Not_Display_Selected_Under_Available_Items_Section_5674()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5674");
		common.log("Ticket No. - SAM-5674");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.change_Assign_Status_For_Auction_Lots_Page();

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		adminDashboardPage.verify_Changed_Status_For_Auction_Lots_Page();

	}

	// 33
	@Test
	public void by_Default_Search_Page_Not_Opening_At_Front_End_5690()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5690");
		common.log("Ticket No. - SAM-5690");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.settinglayout_Customizationsearch();

		adminDashboardPage.adminLogout();

		driver.get(configFileReader.getqa_MainAutoFront());
		common.pause20Sec();
		common.waitUntillElementPresent("//h3[text()='Advanced Search']");
		
		if (common.isElementPresent("//h3[text()='Advanced Search']")) {
			common.highlightElement("//h3[text()='Advanced Search']");
			System.out.println("Step :: Issue fixed");
			common.log("<br></br>Step :: Issue fixed");
		} else {
			System.out.println("Step :: Issue not fixed");
			common.log("<br></br>Step :: Issue not fixed");
		}

	}

	// 34
	@Test
	public void second_Time_Delete_Confirmation_Popup_Not_Appear_Once_Clicked_On_Cancel_In_Popup_5697()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5697");
		common.log("Ticket No. - SAM-5697");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.second_Time_Delete_Confirmation_Popup_Not_Appear_Once_Clicked_On_Cancel_In_Popup();
	}

	// 35
	@Test
	public void this_Page_Is_Not_Working_Error_Display_When_User_Save_Empty_Inventory_Form_5703()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5703");
		common.log("Ticket No. - SAM-5703");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.check_Inventrypage_With_Blanks();
	}

	// 36
	@Test
	public void this_Page_Is_Not_working_error_appears_when_user_edit_some_invoices_from_list_5756()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5756");
		common.log("Ticket No. - SAM-5756");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.edit_Invoice_And_Verfiy();
	}

	// 37
	@Test
	public void blank_Page_Display_When_User_Click_On_Lots_Tab_5763()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5763");
		common.log("Ticket No. - SAM-5763");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		adminDashboardPage.verify_Blank_Page_Display_For_Lots_Page();

	}

	// 38
	@Test
	public void ajax_Error_Happen_When_User_Remove_One_By_One_Added_Payments_From_Invoice_5765()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5765");
		common.log("Ticket No. - SAM-5765");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.verify_Ajax_Error_Happen_When_User_Remove_One_By_One_Added_Payments_From_Invoice();

	}
	// 39

	@Test
	public void user_Not_Able_To_Download_All_Bids_Report_In_Auctions_Page_5771()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5771");
		common.log("Ticket No. - SAM-5771");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.verfy_User_Not_Able_To_Download_All_Bids_Report_In_Auctions_Page();

	}

	// 40
	@Test
	public void able_To_Add_An_Auctioneer_With_Blank_Spaces_Only_5779()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5779");
		common.log("Ticket No. - SAM-5779");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.verify_Able_To_Add_An_Auctioneer_With_Blank_Spaces_Only();

	}

	// 41
	@Test
	public void ajax_Error_Happen_When_Reload_Inventory_Page_After_Select_10000_From_Pagination_Dropdown_5781()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5781");
		common.log("Ticket No. - SAM-5781");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage
				.verify_Ajax_Error_Happen_When_Reload_Inventory_Page_After_Select_10000_From_Pagination_Dropdown();

	}

	// bug 5789 pending to create because of bug 5763 for qa3-2-auto

	// 42
	@Test
	public void ajax_Error_Happens_When_User_Remove_Added_Dedicated_Clerks_In_Phone_Bidders_Tab_5798()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5798");
		common.log("Ticket No. - SAM-5798");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);

		adminDashboardPage.verify_Ajax_error_happens_when_user_remove_added_dedicated_clerks_in_Phone_Bidders_tab();
	}

	// 43
	@Test
	public void User_not_able_to_save_profile_5808() throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5808");
		common.log("Ticket No. - SAM-5808");

		driver.get(configFileReader.getqa_MainAutoFront());
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");

		dashboardPage.verify_User_Not_Able_To_Save_Profile();
	}

	// 44
	@Test
	public void Not_able_to_send_problems_report_in_Live_Sale_page_at_front_end_side_5811()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5811");
		common.log("Ticket No. - SAM-5811");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.addLot(1);
		adminDashboardPage.approveBidder1(); // Approve both bidder

		adminDashboardPage.front(); // Open Front End
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a"); // Login with
																	// valid
																	// credentials
		dashboardPage.Verify_Not_able_to_send_problems_report_in_Live_Sale_page_at_front_end_side(auctionName);
	}

	// 45
	@Test
	public void Php_error_occurred_when_click_on_Create_new_feed_button_5867()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5867");
		common.log("Ticket No. - SAM-5867");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.Php_error_occurred_when_click_on_Create_new_feed_button();
	}

	// 46
	@Test
	public void Error_message_display_when_user_change_status_and_save_5886()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5886");
		common.log("Ticket No. - SAM-5886");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.Verify_Error_message_display_when_user_change_status_and_save();
	}

	// 47
	@Test
	public void Uploaded_image_not_display_when_user_edit_added_category_in_Categories_tab_6007()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-6007");
		common.log("Ticket No. - SAM-6007");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.verify_uploaded_image_not_display_when_user_edit_added_category_in_Categories();
	}

	// 48
	@Test
	public void Oops_an_error_has_occured_when_user_try_to_add_new_increment_value_with_added_start_value_6250()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-6250");
		common.log("Ticket No. - SAM-6250");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage
				.Verify_Oops_an_error_has_occured_when_user_try_to_add_new_increment_value_with_added_start_value();
	}

	// 49
	@Test
	public void php_error_display_when_adding_new_bidder_with_exist_email_address_5916()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5916");
		common.log("Ticket No. - SAM-5916");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.create_Live_Auction("LiveAuc_5916");
		adminDashboardPage.addlotrandom_5160(2);

		adminDashboardPage.Verify_php_error_display_when_adding_new_bidder_with_exist_email_address();
	}

	// 50
	@Test
	public void Ajax_error_happen_when_user_add_new_lot_in_ongoing_timed_auction_5968()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5968");
		common.log("Ticket No. - SAM-5968");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.Create_Timed_Auction_Ongoing_type_5968(saleno);
		String strlot = adminDashboardPage
				.verify_Ajax_error_happen_when_user_add_new_lot_in_ongoing_timed_auction_5968(1);

	}

	// 51
	@Test
	public void Ajax_error_happen_when_user_create_live_auction_with_entering_Minus1_valu_in_Number_of_days_5971()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5971");
		common.log("Ticket No. - SAM-5971");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage
				.Verify_Ajax_error_happen_when_user_create_live_auction_with_entering_Minus1_valu_in_Number_of_days(
						"testLive_5971");

	}

	// 52
	@Test
	public void Page_Not_Found_404_error_display_when_click_on_Consignor_Sort_button_under_More_Actions_in_Lots_page_5972()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5972");
		common.log("Ticket No. - SAM-5972");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.create_Live_Auction("LiveAuc_5972");
		adminDashboardPage
				.Verify_Page_Not_Found_404_error_display_when_click_on_Consignor_Sort_button_under_More_Actions_in_Lots_page();
	}

	// 53
	@Test
	public void Lots_list_disappear_when_user_select_any_value_from_pagination_dropdown_in_Phone_Bidders_tab_5973()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5973");
		common.log("Ticket No. - SAM-5973");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.create_Live_Auction("LiveAuc_5973");
		adminDashboardPage.addlotrandom_5160(2);
		adminDashboardPage
				.verify_Lots_list_disappear_when_user_select_any_value_from_pagination_dropdown_in_Phone_Bidders_tab();
	}

	// 54
	@Test
	public void php_error_occured_when_user_send_invoice_in_an_Invoices_page_6129()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-6129");
		common.log("Ticket No. - SAM-6129");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.verify_php_error_occured_when_user_send_invoice_in_an_Invoices_page();
	}

	// 55
	@Test
	public void Full_Credit_Card_number_is_exposed_in_My_Profile_html_6540()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-6540");
		common.log("Ticket No. - SAM-6540");

		driver.get(configFileReader.getqa_MainAutoFront());
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");

		dashboardPage.Verify_Credit_card_number_exposed_profile();
	}

	// 56
	@Test
	public void Even_when_the_Limit_Bidding_Info_Permission_is_set_admin_it_shows_asking_bid_for_others_User_6503()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-6503");
		common.log("Ticket No. - SAM-6503");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		String AuctionTimed = adminDashboardPage.allFieldsFillForTimedSale(tomorrowDate, "1", saleno); // Create
		// Auction
		String strlot = adminDashboardPage.addLot(1);
		Thread.sleep(1000);
		adminDashboardPage.Give_Permission();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		dashboardPage.logoutfrontuser();
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		dashboardPage.goto_Catalog_Page_Timed_Sale(AuctionTimed); // credentials
		dashboardPage.verify_Asking_bid_display_Or_not();
	}

	// 57
	@Test
	public void Exhausted_memory_when_editing_user_bidder_6928()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-6928");

		common.log("Ticket No. - SAM-6928");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.verify_user_added_by_field_display_or_not();
	}

	// 58
	@Test
	public void It_shows_mysql_error_on_saving_non_bidder_as_winner_bidder_7461()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-7461");
		common.log("Ticket No. - SAM-7461");

		String name = common.generateRandomChars(5);
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		String aucName = adminDashboardPage.create_Live_Auction(name);
		adminDashboardPage.addLot(1);

		adminDashboardPage.Verify_mySql_error_for_Non_bidder_as_winner(aucName);
	}

	// 59
	@Test
	public void Edit_Lot_Item_Oops_error_on_saving_the_increment_6932()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-6932");
		common.log("Ticket No. - SAM-6932");

		String name = common.generateRandomChars(5);
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		String aucName = adminDashboardPage.create_Live_Auction(name);
		adminDashboardPage.addLot(1);

		adminDashboardPage.Verify_Oops_error_when_save_custom_increment(aucName);
	}

	// 60
	@Test
	public void Blank_page_and_error_displays_in_the_console_when_user_refresh_page_after_clone_lot_7618()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-7618");
		common.log("Ticket No. - SAM-7618");

		String name = common.generateRandomChars(5);
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		String aucName = adminDashboardPage.create_Live_Auction(name);
		adminDashboardPage.addLot(1);

		adminDashboardPage.Verify_blank_page_after_clone_the_lot(aucName);
	}

	// 61
	@Test
	public void Clone_auction_functionality_is_not_working_6871()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-6871");
		common.log("Ticket No. - SAM-6871");

		String name = common.generateRandomChars(5);
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		String aucName = adminDashboardPage.create_Live_Auction(name);

		adminDashboardPage.Verify_Clone_Auction_functionality(aucName);
	}

	// 62
	@Test
	public void Remove_lot_icon_Confirm_popup_is_not_displaying_once_user_cancels_it_6849()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-6849");
		common.log("Ticket No. - SAM-6849");

		String name = common.generateRandomChars(5);
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		String aucName = adminDashboardPage.create_Live_Auction(name);
		adminDashboardPage.addLot(1);
		adminDashboardPage.verify_Confirmation_popup_display_or_not_once_cancle_it(aucName);
	}

	// 63
	@Test
	public void On_create_new_mailing_list_ajax_error_occurs_when_user_select_category_linked_having_sub_categories_6750()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-6750");
		common.log("Ticket No. - SAM-6750");

		String name = common.generateRandomChars(5);
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.Verify_ajax_happen_or_not_when_Create_mailing_lists();
	}

	// 64
	@Test
	public void New_Location_popup_is_not_getting_open_on_create_auction_page_6626()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-6626");
		common.log("Ticket No. - SAM-6626");

		String name = common.generateRandomChars(5);
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.Verify_new_location_popup_appear_or_not_when_create_an_auction();
	}

	// 65
	@Test
	public void error_occurs_when_viewing_invoice_pdf_6614() throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-6614");
		common.log("Ticket No. - SAM-6614");

		String name = common.generateRandomChars(5);
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.Verify_error_occurs_on_pdf_invoice();
	}

	// 66
	@Test
	public void When_clicking_the_edit_button_invoice_and_clearing_the_buyers_premium_the_hammer_price_isnot_pulled_into_the_subtotal_amount_6578()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-6578");
		common.log("Ticket No. - SAM-6578");

		String name = common.generateRandomChars(5);
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.Verify_subtotal_after_clear_buyers_premium();
	}

	// 67
	@Test
	public void php_error_occurs_when_clicking_on_Email_Templates_tab_6493()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-6493");
		common.log("Ticket No. - SAM-6493");

		String name = common.generateRandomChars(5);
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.Verify_Email_templates_tab();
	}

	// 68
	@Test
	public void Bidder_is_able_to_bid_on_the_lot_that_is_marked_as_listing_only_6269()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-6269");
		common.log("Ticket No. - SAM-6269");

		String name = common.generateRandomChars(5);
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		String aucName = adminDashboardPage.create_Live_Auction(name);
		adminDashboardPage.Add_lot_listing_only();
		adminDashboardPage.approveBidder1(); // Approve both bidder
		adminDashboardPage.start_Auction();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		dashboardPage.goto_Catalog_Page_Live_Sale(aucName); // credentials
		dashboardPage.verify_user_able_to_bid_Or_not(aucName);
	}

	// 69
	@Test
	public void Error_occurs_when_creating_user_by_csv_import_6267()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-6267");
		common.log("Ticket No. - SAM-6267");

		String name = common.generateRandomChars(5);
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.verify_user_Adding_through_Csv();

	}

	// 70
	@Test
	public void Error_occurs_when_clicking_on_Back_link_on_auction_report_page_6233()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-6233");
		common.log("Ticket No. - SAM-6233");

		String name = common.generateRandomChars(5);
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.Verify_error_occurs_or_not_when_click_on_back_link_in_reports();

	}

	// 71
	@Test
	public void System_Parameter_Live_Auction_Bidding_UI_section_details_gets_reset_when_reload_the_page_5967()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5967");
		common.log("Ticket No. - SAM-5967");

		String name = common.generateRandomChars(5);
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.Verify_details_get_reset_or_not_for_bidding_Ui_When_reload_page();

	}

	// 72
	@Test
	public void PDF_Invoice_Shipping_Information_details_missing_on_PDF_Invoice_5064()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5064");
		common.log("Ticket No. - SAM-5064");

		String name = common.generateRandomChars(5);
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.verify_shipping_info_display_or_not_in_pdf_invoice();

	}

	// 73
	@Test
	public void setup_a_payment_gateway_link_broken_at_System_Param_Auction_4408()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-4408");
		common.log("Ticket No. - SAM-4408");

		String name = common.generateRandomChars(5);
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.verify_link_broke_or_not_when_click_On_setup_a_payment_gateway();

	}

	// 74
	@Test
	public void All_status_results_displayed_when_I_am_selecting_Open_status_from_dropdown_in_Settlements_page_7643()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-7643");
		common.log("Ticket No. - SAM-7643");

		String name = common.generateRandomChars(5);
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.Verify_open_status_display_or_not_When_Select_Open_Status_from_dropdown_in_settlements();

	}

	// 75
	@Test
	public void Othe_CC_input_popup_not_appearing_on_invoice_details_page_4134()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-4134");
		common.log("Ticket No. - SAM-4134");

		String name = common.generateRandomChars(5);
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.Verify_Other_CC_Popup_Appear_Or_Not();

	}

	// 76
	@Test
	public void Unable_to_access_Auction_listing_page_when_select_landing_page_Search_at_frontend_7628()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-7628");
		common.log("Ticket No. - SAM-7628");

		String name = common.generateRandomChars(5);
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.settinglayout_Customizationsearch();
		adminDashboardPage.front();
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		dashboardPage.Verify_Auction_list_Displaying_or_Not();
	}

	// 77
	@Test
	public void Auction_Bidders_Checkbox_selection_is_not_working_6919()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-6919");
		common.log("Ticket No. - SAM-6919");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.Verify_checkbox_working_or_not_With_email_cheked_user(); // Approve both bidder

	}

	// 78
	@Test
	public void Edit_Lot_Previous_Next_buttons_Redirects_to_PHP_error_page_6547()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-6547");
		common.log("Ticket No. - SAM-6547");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.addLotRandom(2);

		adminDashboardPage.Verify_Previous_Next_buttons(); // Approve both bidder

	}

	// 79
	@Test
	public void Inventery_Detele_button_Oops_PHP_error_occurs_6245()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-6245");
		common.log("Ticket No. - SAM-6245");

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.Verify_Php_Error_When_Delete_Inventory(); // Approve both bidder

	}

	// 80
	@Test
	public void Add_new_bidder_No_asterisk_symbol_is_displayed_for_required_Email_field_6190()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-6190");
		common.log("Ticket No. - SAM-6190");

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.Verify_Asterisk_Symbol_For_Email_Field(); // Approve both bidder

	}

	// 81
	@Test
	public void Admin_Options_Date_Timezone_Saving_empty_timezone_field_Oops_error_is_occured_6109()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-6109");
		common.log("Ticket No. - SAM-6109");

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.Verify_Oops_Error_When_Set_Empty_TimeZone(); // Approve both bidder

	}

	// 82
	@Test
	public void Create_New_Buyer_Group_button_Redirects_to_Oops_error_page_6069()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-6069");
		common.log("Ticket No. - SAM-6069");

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.Verify_Oops_Error_When_Click_On_New_Buyer_Group(); // Approve both bidder

	}

	// 83
	@Test
	public void Inventory_CSV_upload_PHP_error_is_displayed_5931()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5931");
		common.log("Ticket No. - SAM-5931");

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.verify_Inventory_lots_Adding_through_Csv(); // Approve both bidder

	}

	// 84
	@Test
	public void Invoice_Shipping_Handling_Ajax_error_is_displayed_5854()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5854");
		common.log("Ticket No. - SAM-5854");

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.Verify_Ajax_when_Calculate_Shipping_Handling(); // Approve both bidder

	}

	// 85
	@Test
	public void Settlement_Print_view_PHP_error_is_displayed_5852()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5852");
		common.log("Ticket No. - SAM-5852");

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.Verify_Php_Error_On_PrintView(); // Approve both bidder

	}

	// 86
	@Test
	public void Auctions_Email_Templates_cannot_be_edited_disabled_5757()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5757");
		common.log("Ticket No. - SAM-5757");

		String name = common.generateRandomChars(5);
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.create_Live_Auction(name);

		adminDashboardPage.Verify_email_templates_Edited_Disabled_Or_Not(); // Approve both bidder

	}

	// 87
	@Test
	public void Reports_Under_Bidders_PHP_error_is_displayed_5696()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5696");
		common.log("Ticket No. - SAM-5696");

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.Verify_Php_Error_On_Under_Bidders_In_Reports(); // Approve both bidder

	}

	// 88
	@Test
	public void Month_details_are_not_saved_at_first_attempt_5682()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5682");
		common.log("Ticket No. - SAM-5682");

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.Verify_Month_details_are_saved_Or_Not_at_first_attempt(); // Approve both bidder

	}

	// 89
	@Test
	public void Permissions_On_refreshing_page_checked_Hide_unsold_lots_checkbo_gets_unchecked_5611()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5611");
		common.log("Ticket No. - SAM-5611");

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.Verify_On_refreshing_page_checked_Hide_unsold_lots_checkbo_gets_unchecked_or_not();
	}

	// 90
	@Test
	public void On_updating_the_Invoice_status_to_Deleted_500_error_page_is_displayed_5569()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5569");
		common.log("Ticket No. - SAM-5569");

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.verify_On_updating_the_Invoice_status_to_Deleted_500_error_page_is_displayed_or_not();
	}

	// 91
	@Test
	public void Translations_Language_to_use_Validation_issues_on_adding_new_language_5523()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5523");
		common.log("Ticket No. - SAM-5523");

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.Goto_Translation_Tab();
		adminDashboardPage.Verify_Translations_Language_to_use_Validation_issues_on_adding_new_language();
	}

	// 92
	@Test
	public void Auction_Description_On_clicking_Maximize_icon_blank_page_is_displayed_5462()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5462");
		common.log("Ticket No. - SAM-5462");

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.Verify_Auction_Description_On_clicking_Maximize_icon_blank_page_is_displayed_or_not();
	}

	// 93
	@Test
	public void On_clicking_users_tab_dropdown_only_the_search_filter_section_is_wrapped_not_Users_section_5457()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5457");
		common.log("Ticket No. - SAM-5457");

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.Verify_On_clicking_users_tab_dropdown_Users_section_wrapped_or_not();
	}

	// 94
	@Test
	public void On_clicking_the_Name_sorting_icon_an_error_pop_up_is_displayed_5456()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5456");
		common.log("Ticket No. - SAM-5456");

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.Verify_On_clicking_the_Name_sorting_icon_an_error_pop_up_is_displayed_or_not();
	}

	// 95
	@Test
	public void Lot_Item_Add_Custom_Field_On_selecting_custom_fields_Type_the_checkboxes_gets_disappeared_5399()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5399");
		common.log("Ticket No. - SAM-5399");

		String str = common.generateRandomChars(5);
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage
				.Verify_Lot_Item_Add_Custom_Field_On_selecting_custom_fields_Type_the_checkboxes_gets_disappeared_or_not(
						str);
	}

	// 96
	@Test
	public void Issues_for_Additional_confirmations_5395() throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5395");
		common.log("Ticket No. - SAM-5395");

		String str = common.generateRandomChars(5);
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.Verify_Issues_for_Additional_confirmations();
	}

	// 97
	@Test
	public void Add_new_credit_card_Validation_required_for_the_blank_details_saved_5313()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5313");
		common.log("Ticket No. - SAM-5313");

		String str = common.generateRandomChars(5);
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.Verify_Add_new_credit_card_Validation_required_for_the_blank_details_saved();
	}

	// 98
	@Test
	public void Manual_Clerk_404_error_is_displayed_when_user_clicks_on_View_Lot_detail_screen_after_auction_is_stopped_5312()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5312");
		common.log("Ticket No. - SAM-5312");

		String str = common.generateRandomChars(5);
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.create_Hybrid_Auction(str);
		adminDashboardPage.add1Lot();
		adminDashboardPage
				.Verify_Manual_Clerk_404_error_is_displayed_or_not_when_user_clicks_on_View_Lot_detail_screen_after_auction_is_stopped();
	}

	// 99
	@Test
	public void Live_Hybrid_Auction_Error_occurs_for_Reset_functionality_for_recently_created_auction_5058()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5058");
		common.log("Ticket No. - SAM-5058");

		String str = common.generateRandomChars(5);
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.create_Live_Auction(str);

		adminDashboardPage.Verify_Error_occurs_or_not_for_Reset_functionality_for_recently_created_auction(str);
	}

	// 100
	@Test
	public void Custom_Field_Auction_Error_message_is_displayed_or_not_on_adding_new_field_with_the_similar_name_of_deleted_custom_field_5049()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5049");
		common.log("Ticket No. - SAM-5049");

		String str = common.generateRandomChars(5);
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage
				.Verify_Custom_Field_Auction_Error_message_is_displayed_or_not_on_adding_new_field_with_the_similar_name_of_deleted_custom_field();
	}

	// 101
	@Test
	public void Custom_fields_Auction_Validation_message_is_displayed_even_valid_data_filled_in_all_fields_5032()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5032");
		common.log("Ticket No. - SAM-5032");

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		String str_customField = adminDashboardPage.Add_CustomField();
		adminDashboardPage
				.Verify_Custom_fields_Auction_Validation_message_is_displayed_or_not_even_valid_data_filled_in_all_fields(
						str_customField);

	}

	// 102
	@Test
	public void Auction_List_Error_is_displayed_on_reloading_the_page_after_deleting_an_Auction_5002()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-5002");
		common.log("Ticket No. - SAM-5002");

		String str = common.generateRandomChars(5);
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.create_Live_Auction(str);
		adminDashboardPage
				.verify_Auction_List_Error_is_displayed_or_not_on_reloading_the_page_after_deleting_an_Auction(str);

	}

	// 103
	@Test
	public void Auction_Settings_Error_is_displayed_on_editing_Sale_Group_then_saving_4957()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-4957");
		common.log("Ticket No. - SAM-4957");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		String name = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		String AuctionTimed = adminDashboardPage.Create_Timed_auction_with_Reserve_Auction_Checkbox(tomorrowDate, "1",
				saleno, name); // Create

		adminDashboardPage
				.Verify_Auction_Settings_Error_is_displayed_or_not_on_editing_Sale_Group_then_saving(AuctionTimed);

	}

	// 104
	@Test
	public void Timed_Auction_Duplicate_Tax_State_is_displayed_on_adding_more_than_two_states_4946()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-4946");
		common.log("Ticket No. - SAM-4946");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.Verify_Timed_Auction_Duplicate_Tax_State_is_displayed_or_not_on_adding_more_than_two_states(
				tomorrowDate, "1", saleno); // Create

	}

	// 105
	@Test
	public void Auction_Lots_page_Added_Items_section_Change_status_button_is_displayed_even_when_no_lots_are_available_7938()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-7938");
		common.log("Ticket No. - SAM-7938");
		String str = common.generateRandomChars(5);
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.create_Live_Auction(str);

		adminDashboardPage
				.verify_Auction_Lots_page_Added_Items_section_Change_status_button_is_displayed_or_not_even_when_no_lots_are_available();

	}

	// 106
	@Test
	public void Create_Auction_Clerking_style_and_CSV_upload_section_are_active_even_when_no_Auction_type_is_selected_7915()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-7915");
		common.log("Ticket No. - SAM-7915");
		String str = common.generateRandomChars(5);
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage
				.Verify_Create_Auction_Clerking_style_and_CSV_upload_section_are_active_even_when_no_Auction_type_is_selected();

	}

	// 107
	@Test
	public void Lot_bidding_history_page_On_disabling_Date_Time_column_option_pagination_section_is_getting_disappered_7707()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-7707");
		common.log("Ticket No. - SAM-7707");

		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.create_Timed_Auction(saleno);
		adminDashboardPage.addLot(2);
		adminDashboardPage.approveBidder1();

		adminDashboardPage.Submit_bid_for_lot_with_bidder();
		adminDashboardPage
				.Verify_Lot_bidding_history_page_On_disabling_Date_Time_column_option_pagination_section_is_getting_disappered_or_not();

	}

	// 108
	@Test
	public void Add_Credit_Card_Oops_error_occurs_7686() throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-7686");
		common.log("Ticket No. - SAM-7686");

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.Verify_Add_Credit_Card_Oops_error_occurs_or_not();

	}

	// 109
	@Test
	public void Name_exist_error_message_not_removing_automatically_after_click_on_close_icon_when_adding_new_credit_card_7968()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-7968");
		common.log("Ticket No. - SAM-7968");

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage
				.Verify_Name_exist_error_message_not_removing_automatically_after_click_on_close_icon_when_adding_new_credit_card();

	}

	// 110
	@Test
	public void Users_Edit_profile_User_credit_It_does_not_accept_negative_value_7768()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-7768");
		common.log("Ticket No. - SAM-7768");

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.Verify_Users_Edit_profile_User_credit_It_does_not_accept_negative_value();

	}

	// 111
	@Test
	public void Active_tab_is_not_displaye_highlighted_8010()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-8010");
		common.log("Ticket No. - SAM-8010");

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.Verify_Active_tab_Is_Highlighted_or_Not();

	}

	// 112
	@Test
	public void Categories_default_feed_problems_7916() throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-7916");
		common.log("Ticket No. - SAM-7916");

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.Verify_default_category_feed_display_or_Not_when_refresh_the_page();

	}

	// 113
	@Test
	public void At_Add_Edit_Lot_Item_pages_the_New_Category_add_functionality_is_not_working_8965()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-8965");
		common.log("Ticket No. - SAM-8965");

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.Verify_New_Category_Functionality_In_add_inventory(1);

	}

	// 114
	@Test
	public void Auction_Date_type_custom_field_Valid_selected_date_via_date_picker_is_validated_8493()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-8493");
		common.log("Ticket No. - SAM-8493");

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		String strCustom = common.generateRandomChars(5);

		String str = adminDashboardPage.Add_Custom_Date_Field_In_Auction(strCustom);

		adminDashboardPage.Verify_Added_Date_Custom_Field_In_Auction(str);
	}

	// 115
	@Test
	public void Forgot_username_throwing_Please_Contact_Support_error_8026()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-8026");
		common.log("Ticket No. - SAM-8026");

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		driver.get(configFileReader.getqa_MainAutoFront());
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		dashboardPage.logoutfrontuser();

		dashboardPage.Verfiy_Forgot_Password_Functionality();
	}

	// 116
	@Test
	public void Live_bidding_User_is_able_to_send_blank_message_by_entering_blank_space_8032()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-8032");
		common.log("Ticket No. - SAM-8032");

		String name = common.generateRandomChars(5);
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		String aucName = adminDashboardPage.create_Live_Auction(name);
		adminDashboardPage.Add_lot_listing_only();
		adminDashboardPage.approveBidder1(); // Approve both bidder
		adminDashboardPage.start_Auction();
		adminDashboardPage.Verify_Able_To_Send_Blank_Message_In_Chat();
	}

	// 117
	@Test
	public void Oops_An_error_has_occurred_when_user_click_on_Published_header_text_in_Auctions_page_9353()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-9353");
		common.log("Ticket No. - SAM-9353");

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.Verify_Published_Header_Text_In_Auctions_page();
	}

	// 118
	@Test
	public void Ajax_error_happen_when_adding_a_new_category_with_selecting_parent_category_which_is_deleted_from_table_9350()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-9350");
		common.log("Ticket No. - SAM-9350");

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.Verify_Ajax_Happen_Or_Not_When_Add_Category_With_Deleted_Parent_Category();
	}

	// 119
	@Test
	public void BP_values_not_getting_saved_at_Lot_level_8088()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-8088");
		common.log("Ticket No. - SAM-8088");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		String auctionName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno);
		adminDashboardPage.Verify_Adder_premium_saving_or_not_When_Save_Lot();

	}

	// 120
	@Test
	public void Open_redirect_vulnerability_on_v3_2_m_targetdomain_com_path_8581()
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Ticket No. - SAM-8581");
		common.log("Ticket No. - SAM-8088");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		driver.get("https://bid:path@dev3-2.auctionserver.net/admin/manage-settings/system-parameters/option/system");
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.Verify_Open_redirect_vulnerability_on_v3_2_m_targetdomain_com_path();

	}
	// 121

	@Test(dataProvider = "missedliveauction")
	public void Invoice_generation_improvement_by_referencing_latest_invoice_from_LotItem_5162(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-5162");
		common.log("Task No. - SAM-5162");
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		common.pause(5);
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String auctionName = adminDashboardPage.Create_Live_Auction_With_Auctioneer_5160(tomorrowDate, "1", saleno);

		adminDashboardPage.addlotrandom_5162(250);

		// adminDashboardPage.Remove_Auction_Specific_Minimum_Buyer_Premium();

		adminDashboardPage.RunLiveSale_PostFloor_and_Sold_Lot_5160(); // Post
																		// floor
		// bid and
		// sold lot

		adminDashboardPage.Generate_Invoice_5160(auctionName);

	}

	// 122
	@Test(dataProvider = "missedliveauction")
	public void Category_information_from_edit_section_is_not_removed_after_delete_9371(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-9371");
		common.log("Task No. - SAM-9371");
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		common.pause(5);
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_Information_Removed_Or_Not_when_Delete_Category();
	}

	// 123
	@Test(dataProvider = "missedliveauction")
	public void Update_button_is_not_working_in_Users_dashboard_popup_on_Bidders_tab_9364(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-9364");
		common.log("Task No. - SAM-9364");
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		common.pause(5);
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_Update_button_is_working_or_not_in_Users_dashboard_popup_on_Bidders_tab();
	}

	// 124
	@Test(dataProvider = "missedliveauction")
	public void Upload_image_with_inserting_image_URL_functionality_is_not_working_proper_in_Add_lot_page_9418(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-9418");
		common.log("Task No. - SAM-9418");
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		common.pause(5);
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage
				.Verify_Upload_image_with_inserting_image_URL_functionality_is_working_or_not_proper_in_Add_lot_page();
	}

	// 125
	@Test(dataProvider = "missedliveauction")
	public void Settlement_edit_page_Issues_related_to_Edit_settlement_info_functionality_10175(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-10175");
		common.log("Task No. - SAM-10175");
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		common.pause(5);
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_Settlement_edit_page_Issues_related_to_Edit_settlement_info_functionality();
	}

	// 126
	@Test(dataProvider = "missedliveauction")
	public void Settlement_edit_page_Issues_related_to_Edit_settlement_info_functionality_10175_1(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-10175");
		common.log("Task No. - SAM-10175");
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		common.pause(5);
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_Settlement_edit_page_Issues_related_to_Edit_settlement_id_info_functionality();
	}

	// 127
	@Test(dataProvider = "missedliveauction")
	public void Check_search_list_Issues_related_to_Account_Status_filter_10148(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-10148");
		common.log("Task No. - SAM-10148");
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		common.pause(5);
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verify_Check_search_list_Issues_related_to_Account_Status_filter();
	}

	// 128
	@Test(dataProvider = "missedliveauction")
	public void Check_search_list_Issues_related_to_Account_Status_filter_10148_1(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-10148");
		common.log("Task No. - SAM-10148");
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		common.pause(5);
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verify_Check_search_list_Issues_related_to_Account_Status_filter_in_second_page();
	}

	// 129
	@Test(dataProvider = "missedliveauction")

	public void Verify_check_user_tries_Save_and_Print_functionality_without_entering_check_10118(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-10118");
		common.log("Task No. - SAM-10118");
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		common.pause(5);
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_check_user_tries_Save_and_Print_functionality_without_entering_check();
	}

	// 130
	@Test(dataProvider = "missedliveauction")
	public void verify_Settlement_checks_list_page_Issues_related_to_action_buttons_10122(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-10122");
		common.log("Task No. - SAM-10122");
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		String name = common.generateRandomChars(5);

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		common.pause(5);
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.create_timed_auction_with_all_dates(saleno, name);
		adminDashboardPage.Add_lot_with_consignor();
		adminDashboardPage.approvebidderindev();
		adminDashboardPage.enter_bids();
		adminDashboardPage.Generate_invoice_and_edit(name);
		adminDashboardPage.verify_Settlement_print_checks_action_buttons_gets_disables(name);

		adminDashboardPage.verify_Settlement_checks_list_page_Issues_related_to_action_buttons(name);

	}

	// 131
	@Test(dataProvider = "missedliveauction")
	public void Verify_Blank_page_appearing_when_hit_dev_auctionserver_net_m_index_url_10474(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-10474");
		common.log("Task No. - SAM-1044");

		driver.get(configFileReader.getqa_MainAutoFront());
		common.pause(20);
		System.out.println("Step :: Refresh the page");
		common.log("<br></br>Step ::  Refresh the page");
		common.refreshPage();
		common.pause(30);
		common.isElementDisplayed("//a[contains(text(),'Auctions')]");
		System.out.println("Step :: Verified Blank page not appearing when hit dev auctionserver net m index url");
		common.log("<br></br>Step ::  Verified Blank page not appearing when hit dev auctionserver net m index url");
		common.pause(20);

	}

	// 132
	@Test(dataProvider = "missedliveauction")
	public void Verify_Export_CSV_button_is_not_appearing_in_Checks_page_10169(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-10169");
		common.log("Task No. - SAM-10169");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		common.pause(5);
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Verify_Export_CSV_button_is_not_appearing_in_Checks_page();

	}

	// 133
	@Test(dataProvider = "missedliveauction")
	public void Verify_Search_All_Checks_button_is_not_displaying_in_Settlements_page_10155(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-10155");
		common.log("Task No. - SAM-10155");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		common.pause(5);
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Verify_Search_All_Checks_button_is_not_displaying_in_Settlements_page();

	}

	// 134
	@Test(dataProvider = "missedliveauction")
	public void Verify_User_is_not_able_to_place_bid_with_registered_user_for_timed_auction_in_lot_details_page_10229(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-10229");
		common.log("Task No. - SAM-10229");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		common.pause(5);
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String saleno = common.generateRandomNumber1();
		String name = adminDashboardPage.createTimedAuction(saleno);
		adminDashboardPage.add_lot();
		adminDashboardPage.front(); // Open Front End
		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		dashboardPage.Goto_Catalog_Page_Search_Timed_Sale(name);
		dashboardPage.Register_Bidder();
		loginPage = indexPage.clickOnLoginLink();

		// login backend
		driver.get(configFileReader.getqa_MainAutoAdmin());

		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Approve_Bidder(saleno);
		adminDashboardPage.front();

		// User 1 Login

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		dashboardPage.Goto_Catalog_Page_Search_Timed_Sale(name);
		dashboardPage.place_bid_for_timed_auction();

	}

	// 135
	@Test(dataProvider = "missedliveauction")

	public void Verify_Consignor_is_not_saving_in_lot_when_user_use_the_down_key_and_hit_enter_from_keyboard_9566(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-9566");
		common.log("Task No. - SAM-9566");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		common.pause(5);
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String saleno = common.generateRandomNumber1();
		String name = adminDashboardPage.createTimedAuction(saleno);
		adminDashboardPage.add_lot_with_new_consignor();
	}

	// 136
	@Test(dataProvider = "missedliveauction")
	public void Verify_Signup_functionality_is_not_working_proper_9537(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-9537");
		common.log("Task No. - SAM-9537");

		driver.get(configFileReader.getqa_MainAutoFront()); // Admin URL
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		common.pause(30);

		dashboardPage.Signup_with_details();

	}

	// 137
	@Test(dataProvider = "missedliveauction")
	public void Verify_Personal_or_corporate_firewall_error_appear_when_visit_Run_live_auction_page_9935(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-9935");
		common.log("Task No. - SAM-9935");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		common.pause(5);
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String saleno = common.generateRandomNumber1();
		String name = common.generateRandomChars(5);
		adminDashboardPage.createliveauction1(saleno, name);
		adminDashboardPage.simplyAddLot();
		adminDashboardPage.approveBidder1();
		adminDashboardPage.Verify_Personal_or_corporate_firewall_error_appear_when_visit_Run_live_auction_page();

	}

	// 138
	@Test(dataProvider = "missedliveauction")

	public void Verify_Bidders_No_success_message_display_when_remove_registered_bidder_and_No_validation_display_when_click_on_Email_checked_user_7987(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-7987");
		common.log("Task No. - SAM-7989");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		common.pause(5);
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String saleno = common.generateRandomNumber1();
		String name = common.generateRandomChars(5);
		adminDashboardPage.createliveauction1(saleno, name);
		adminDashboardPage.simplyAddLot();
		adminDashboardPage.approveBidder1();
		adminDashboardPage
				.Verify_Bidders_No_success_message_display_when_remove_registered_bidder_and_No_validation_display_when_click_on_Email_checked_user();
	}

	// 139
	public void Verify_generat(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, AWTException, ParseException {
		System.out.println("Task No. - SAM-10479");
		common.log("Task No. - SAM-10479");
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		String aucname1 = common.generateRandomChars(6);
		String aucname2 = common.generateRandomChars(6);
		String lotname1 = common.generateRandomChars(6);
		String lotname2 = common.generateRandomChars(6);

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

	}

	// 140
	@Test(dataProvider = "missedliveauction")
	public void Verify_Delete_category_function_not_working_8062(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-8062");
		common.log("Task No. - SAM-8062");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		common.pause(5);
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Verify_Delete_category_function_not_working();

	}

	// 141
	@Test(dataProvider = "missedliveauction")
	public void Verify_Added_date_automatically_clear_from_the_field_when_the_user_moves_to_next_field_at_creating_auction_time_8061(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-8061");
		common.log("Task No. - SAM-8061");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		common.pause(5);
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage
				.Verify_Added_date_automatically_clear_from_the_field_when_the_user_moves_to_next_field_at_creating_auction_time();

	}

	// 142
	@Test(dataProvider = "missedliveauction")
	public void Verify_Sometime_Oops_error_occurred_when_user_visit_the_Lots_page_6864(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-6864");
		common.log("Task No. - SAM-6864");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		common.pause(5);
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String saleno = common.generateRandomNumber1();
		adminDashboardPage.Create_Hybrid_Auction1(saleno);
		adminDashboardPage.simplyAddLot();
		adminDashboardPage.Verify_lots_page_display_properly_when_click_on_lot_tab();

	}

	// 143
	@Test(dataProvider = "missedliveauction")
	public void Verify_Not_changing_Notes_label_text_in_invoice_after_changed_from_back_end_side_under_Translations_Invoices_menu_6543(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-6543");
		common.log("Task No. - SAM-6543");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		common.pause(5);
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String Notes = adminDashboardPage.Edit_notes_in_translation();
		adminDashboardPage.front();

		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		dashboardPage.Verify_Notes_Label(Notes);

	}

	// 144
	@Test(dataProvider = "missedliveauction")
	public void Verify_Oops_an_error_has_occured_when_try_to_add_new_custom_field_for_User_6615(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-6615");
		common.log("Task No. - SAM-6615");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		common.pause(5);
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Verify_Oops_an_error_has_occured_when_try_to_add_new_custom_field_for_User();

	}

	// 145
	@Test(dataProvider = "missedliveauction")
	public void Verify_Blank_screen_display_when_user_create_live_auction_with_adding_500_lots_csv_file_6322(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-6322");
		common.log("Task No. - SAM-6322");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		common.pause(5);
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String name = common.generateRandomChars(5);
		adminDashboardPage.create_Live_Auction(name);
		adminDashboardPage.Verify_Blank_screen_display_when_user_create_live_auction_with_adding_500_lots_csv_file();
	}

	// 146
	@Test(dataProvider = "missedliveauction")
	public void Verify_Checks_list_page_Export_CSV_button_redirects_to_404_error_page_10164(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-10164");
		common.log("Task No. - SAM-10164");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		common.pause(5);
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String name = common.generateRandomChars(5);
		adminDashboardPage.create_Live_Auction(name);
		adminDashboardPage.add_lot_with_consignor();
		adminDashboardPage.approveBidder1();
		adminDashboardPage.enter_bids();
		adminDashboardPage.Verify_Checks_list_page_Export_CSV_button_redirects_to_404_error_page(name);

	}

	// 147
	@Test(dataProvider = "missedliveauction")
	public void Verify_Checks_list_page_Mark_Posted_and_Apply_as_Payment_button_Check_does_not_get_marked_as_posted_10160(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-10160");
		common.log("Task No. - SAM-10160");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		common.pause(5);
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String name = common.generateRandomChars(5);
		adminDashboardPage.create_Live_Auction(name);
		adminDashboardPage.add_lot_with_consignor();
		adminDashboardPage.approveBidder1();
		adminDashboardPage.enter_bids();
		adminDashboardPage
				.Verify_Checks_list_page_Mark_Posted_and_Apply_as_Payment_button_Check_does_not_get_marked_as_posted(
						name);

	}

	// 148
	@Test(dataProvider = "missedliveauction")
	public void Verify_Frontend_My_Settlements_Printed_date_is_different_from_admin_check_printed_date_10159(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-10159");
		common.log("Task No. - SAM-10159");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		common.pause(5);
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String name = common.generateRandomChars(5);
		adminDashboardPage.create_Live_Auction(name);
		adminDashboardPage.add_lot_with_consignor();
		adminDashboardPage.approveBidder1();
		adminDashboardPage.enter_bids();

		// adminDashboardPage.Verify_Checks_list_page_Mark_Posted_and_Apply_as_Payment_button_Check_does_not_get_marked_as_posted(name);
		String memo = adminDashboardPage.Generate_Settlements(name);
		adminDashboardPage.front();

		// frontend login
		driver.get(configFileReader.getqa_MainAutoFront());
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		common.pause(20);
		driver.get(configFileReader.settlement_Url());

		common.pause(20);
		dashboardPage.Verify_Frontend_My_Settlements_Printed_date_is_different_from_admin_check_printed_date(memo);

	}

	// 149
	@Test(dataProvider = "missedliveauction")
	public void Verify_Check_Search_List_page_Auto_complete_process_for_payee_field_does_not_work_properly_10149(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-10149");
		common.log("Task No. - SAM-10149");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		common.pause(5);
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Verify_Check_Search_List_page_Auto_complete_process_for_payee_field_does_not_work_properly();

	}

	// 150
	@Test(dataProvider = "missedliveauction")
	public void Verify_Validation_issues_on_Settlement_check_edit_form_10109(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-10109");
		common.log("Task No. - SAM-10109");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		common.pause(5);
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Verify_Validation_issues_on_Settlement_check_edit_form();

	}

	// 151
	@Test(dataProvider = "missedliveauction")
	public void Verify_System_parameters_Invoicing_Settlement_checks_Missing_asterisk_sign_for_required_fields_10102(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-10102");
		common.log("Task No. - SAM-10102");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		common.pause(5);
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage
				.Verify_System_parameters_Invoicing_Settlement_checks_Missing_asterisk_sign_for_required_fields();

	}

	// 152
	@Test(dataProvider = "missedliveauction")
	public void Verify_Settlement_check_edit_page_Mark_voided_Apply_as_payment_It_shows_confirmation_message_twice_after_printing_the_check_10113(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-10113");
		common.log("Task No. - SAM-10113");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		common.pause(5);
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String name = common.generateRandomChars(5);
		adminDashboardPage.create_Live_Auction(name);
		adminDashboardPage.add_lot_with_consignor();
		adminDashboardPage.approveBidder1();
		adminDashboardPage.enter_bids();
		adminDashboardPage.Generate_Settlement(name);
		adminDashboardPage
				.Verify_Settlement_check_edit_page_Mark_voided_Apply_as_payment_It_shows_confirmation_message_twice_after_printing_the_check(
						name);

	}

	// 153
	@Test(dataProvider = "missedliveauction")
	public void Verify_Settlement_Check_Edit_page_Populate_Amount_It_does_not_update_the_Amount_field_according_to_balance_due_10112(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-10112");
		common.log("Task No. - SAM-10112");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		common.pause(5);
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		// String name = common.generateRandomChars(5);
		adminDashboardPage
				.Verify_Settlement_Check_Edit_page_Populate_Amount_It_does_not_update_the_Amount_field_according_to_balance_due();

	}

	// 154
	@Test(dataProvider = "missedliveauction")
	public void Verify_Settlement_check_edit_page_Unable_to_print_single_check_10105(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-10105");
		common.log("Task No. - SAM-10105");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		common.pause(5);
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String name = common.generateRandomChars(5);
		adminDashboardPage.create_Live_Auction(name);
		adminDashboardPage.add_lot_with_consignor();
		adminDashboardPage.approveBidder1();
		adminDashboardPage.enter_bids();
		adminDashboardPage.Generate_Settlement(name);
		adminDashboardPage.Verify_Settlement_check_edit_page_Unable_to_print_single_check();

	}

	// 155
	@Test(dataProvider = "missedliveauction")
	public void Verify_Settlement_check_list_pages_Print_checks_field_Page_breaks_and_shows_XML_document_if_user_removes_check_and_hit_Enter_key_10337(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-10337");
		common.log("Task No. - SAM-10337");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		common.pause(5);
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String name = common.generateRandomChars(5);
		adminDashboardPage.create_Live_Auction(name);
		adminDashboardPage.add_lot_with_consignor();
		adminDashboardPage.approveBidder1();
		adminDashboardPage.enter_bids();
		adminDashboardPage.Generate_Settlement(name);
		adminDashboardPage
				.Verify_Settlement_check_list_pages_Print_checks_field_Page_breaks_and_shows_XML_document_if_user_removes_check_and_hit_Enter_key();

	}

	// 156
	@Test(dataProvider = "missedliveauction")
	public void Verify_Redirects_to_Oops_error_page_when_removing_added_payment_in_settlement_10722(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-10722");
		common.log("Task No. - SAM-10722");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		common.pause(5);
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String name = common.generateRandomChars(5);
		adminDashboardPage.create_Live_Auction(name);
		adminDashboardPage.add_lot_with_consignor();
		adminDashboardPage.approveBidder1();
		adminDashboardPage.enter_bids();
		adminDashboardPage.Generate_Settlement(name);
		adminDashboardPage.Verify_Redirects_to_Oops_error_page_when_removing_added_payment_in_settlement();

	}

	// 157
	@Test(dataProvider = "missedliveauction")
	public void Verify_Fix_Auction_Invoice_Unable_to_generate_Invoice_at_auction_level_due_to_this_error_Failed_with_error_Bad_Request_10771(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-10771");
		common.log("Task No. - SAM-10771");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		common.pause(5);
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String name = common.generateRandomChars(5);
		adminDashboardPage.create_Live_Auction(name);
		adminDashboardPage.add_lot_with_consignor();
		adminDashboardPage.approveBidder1();
		adminDashboardPage.enter_bids();
		adminDashboardPage
				.Verify_Fix_Auction_Invoice_Unable_to_generate_Invoice_at_auction_level_due_to_this_error_Failed_with_error_Bad_Request();

	}

	// 158
	@Test(dataProvider = "missedliveauction")
	public void Verify_Settlement_Add_Edit_check_page_It_does_not_render_data_in_Payee_Address_field_if_conditional_logic_is_applied_in_template_10168(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-10168");
		common.log("Task No. - SAM-10168");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		common.pause(5);
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String name = common.generateRandomChars(5);
		String ShippingAddress = adminDashboardPage.add_user_with_shipping_info(name);
		adminDashboardPage.create_Live_Auction(name);
		adminDashboardPage.add_lot_with_consignor();
		adminDashboardPage.approveBidder1();
		adminDashboardPage.enter_bids();
		adminDashboardPage.Generate_Settlement(name);
		adminDashboardPage
				.Verify_Settlement_Add_Edit_check_page_It_does_not_render_data_in_Payee_Address_field_if_conditional_logic_is_applied_in_template(
						ShippingAddress);

	}

	// 159
	@Test(dataProvider = "missedliveauction")
	public void Verify_Check_Search_List_Date_filters_are_not_working_10150(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-10150");
		common.log("Task No. - SAM-10150");
		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		common.pause(5);
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

	}

	// 160

	@Test(dataProvider = "missedliveauction")
	public void Ensure_that_check_amount_has_two_decimal_places_10126(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-10126");
		common.log("Task No. - SAM-10126");
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		String name = common.generateRandomChars(6);

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Timed_auction_with_publish(saleno, name);
		adminDashboardPage.Create_timed_lot_with_consignor();
		adminDashboardPage.Register_and_approve_bidder();
		adminDashboardPage.Sell_bid_for_lot_with_bidder();
		adminDashboardPage.Generate_Invoice_and_update_to_Paid(name);
		adminDashboardPage.Generate_settlement_verify_two_decimals_in_Amount(name);
	}

	// 161

	@Test(dataProvider = "missedliveauction")
	public void Verify_new_BP_range_is_not_added_for_other_auction_sections_10445(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-10445");
		common.log("Task No. - SAM-10445");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Create_user_with_start_range_duplicate();

	}

	// 162

	@Test(dataProvider = "missedliveauction")
	public void Verify_validation_Allow_buyer_select_quantity_checkbox_disabled_for_Reverse_auction_10432(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-10432");
		common.log("Task No. - SAM-10432");
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		String name = common.generateRandomChars(6);

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Create_Reverse_Timed_auction(saleno, name);

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Create_Reverse_Timed_auction(saleno, name);
	}

	// 163

	@Test(dataProvider = "missedliveauction")

	public void Verify_saving_Start_Closing_date_when_Timezone_is_hidden_10699(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-10699");
		common.log("Task No. - SAM-10699");
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		String aucname = common.generateRandomChars(6);
		String lotname1 = common.generateRandomChars(6);

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Hide_Timezone_from_Inventory_page();
		adminDashboardPage.createTimedAuction(saleno);
		adminDashboardPage.Add_Lot_without_Timezone(lotname1);

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Hide_Timezone_from_Inventory_page();
		adminDashboardPage.createTimedAuction(saleno);
		adminDashboardPage.Add_Lot_without_Timezone(lotname1);

	}

	// 164
	@Test(dataProvider = "missedliveauction")
	public void Verify_sorting_of_Languages_title_10385(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, AWTException {
		System.out.println("Task No. - SAM-10385");
		common.log("Task No. - SAM-10385");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Verify_sorting_via_Languages_title_on_Translations_page();

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Verify_sorting_via_Languages_title_on_Translations_page();
	}

	// 165
	@Test(dataProvider = "missedliveauction")
	public void Verify_to_edit_category_with_null_parent_category_9785(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, AWTException, ParseException {
		System.out.println("Task No. - SAM-9785");
		common.log("Task No. - SAM-9785");
		String parentcat = common.generateRandomChars(4);
		String newcatname = common.generateRandomChars(4);

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Create_parent_category(parentcat);
		adminDashboardPage.Create_category_with_required_fields(newcatname, parentcat);
		adminDashboardPage.Edit_category(newcatname, parentcat);

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Create_parent_category(parentcat);
		adminDashboardPage.Create_category_with_required_fields(newcatname, parentcat);
		adminDashboardPage.Edit_category(newcatname, parentcat);

	}

	// 166
	@Test(dataProvider = "missedliveauction")

	public void Verify_deleted_user_updated_on_Buyer_Group_page_9687(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, AWTException, ParseException {
		System.out.println("Task No. - SAM-9687");
		common.log("Task No. - SAM-9687");
		String bgname = common.generateRandomChars(6);
		String newuser = common.generateRandomChars(4);

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Add_new_Buyer_group(bgname);
		adminDashboardPage.Add_new_user_with_Buyer_Group(newuser, bgname);
		adminDashboardPage.Verify_created_user_for_buyer_group(bgname);
		adminDashboardPage.Delete_created_user(newuser);
		adminDashboardPage.Verify_deleted_user_on_edit_Buyer_group_page(bgname);

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Add_new_Buyer_group(bgname);
		adminDashboardPage.Add_new_user_with_Buyer_Group(newuser, bgname);
		adminDashboardPage.Verify_created_user_for_buyer_group(bgname);
		adminDashboardPage.Delete_created_user(newuser);
		adminDashboardPage.Verify_deleted_user_on_edit_Buyer_group_page(bgname);

	}

	// 167
	@Test(dataProvider = "missedliveauction")
	public void Verify_zero_count_for_no_user_in_Buyer_group_9655(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, AWTException, ParseException {
		System.out.println("Task No. - SAM-9655");
		common.log("Task No. - SAM-9655");
		String bgname = common.generateRandomChars(6);

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Add_new_Buyer_group(bgname);
		adminDashboardPage.Verify_user_count_for_Buyer_group(bgname);

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Add_new_Buyer_group(bgname);
		adminDashboardPage.Verify_user_count_for_Buyer_group(bgname);

	}

	// 168
	@Test(dataProvider = "missedliveauction")
	public void Verify_to_save_iFrame_video_details_on_auction_lot_page_SAM_9624(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, AWTException, ParseException {
		System.out.println("Task No. - SAM-9624");
		common.log("Task No. - SAM-9624");
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		String lotname1 = common.generateRandomChars(6);

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.createTimedAuction(saleno);
		adminDashboardPage.Add_lot_with_iFrame_details(lotname1);

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.createTimedAuction(saleno);
		adminDashboardPage.Add_lot_with_iFrame_details(lotname1);

	}

	// 169
	@Test(dataProvider = "missedliveauction")
	public void Verify_to_save_zero_input_for_Barcode_type_Lot_item_custom_fields_SAM_8575(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, AWTException, ParseException {
		System.out.println("Task No. - SAM-8575");
		common.log("Task No. - SAM-8575");

		String code39 = common.generateRandomChars(10);
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		String lotname1 = common.generateRandomChars(6);

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Create_Code_39_barcode_type_lot_item_custom_field(code39);
		adminDashboardPage.createTimedAuction(saleno);
		adminDashboardPage.Create_auction_lot_with_barcode_fields_having_zero_input(lotname1, code39);

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Create_Code_39_barcode_type_lot_item_custom_field(code39);
		adminDashboardPage.createTimedAuction(saleno);
		adminDashboardPage.Create_auction_lot_with_barcode_fields_having_zero_input(lotname1, code39);

	}

	// 170
	@Test(dataProvider = "missedliveauction")
	public void Verify_inline_bid_amount_on_Bid_button_SAM_8814(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, AWTException, ParseException {
		System.out.println("Task No. - SAM-8814");
		common.log("Task No. - SAM-8814");

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		String aucname = common.generateRandomChars(6);
		String lotname1 = common.generateRandomChars(6);

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.enable_Inline_Bid_Confirmation();
		adminDashboardPage.createTimedSale(saleno, aucname);
		adminDashboardPage.Create_time_lot_with_Publish_and_StartBidding_date(lotname1, past);
		adminDashboardPage.Registerbidder();

		driver.get(configFileReader.getqa_MainAutoFront());
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("hinvoice11", "Abc@123");
		dashboardPage.Search_Timed_auction_and_go_to_catalog_page(aucname);
		dashboardPage.Verify_bid_functionality();
	}

	// 171

	@Test(dataProvider = "missedliveauction")
	public void Verify_renew_password_functionality_when_xx_days_set_at_admin_SAM_7669(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, AWTException, ParseException {
		System.out.println("Task No. - SAM-7669");
		common.log("Task No. - SAM-7669");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.User_Option_Password_Settings();

		driver.get(configFileReader.getqa_MainAutoFront());
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulbid", "123123a");
		dashboardPage.Verify_redirection_to_change_password_page();

	}

	// 172

	@Test(dataProvider = "missedliveauction")
	public void Verify_to_edit_invoice_number_SAM_9422(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, AWTException, ParseException {
		System.out.println("Task No. - SAM-9422");
		common.log("Task No. - SAM-9422");

		// String upinvonumber = common.generateRandomChars(3);
		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Edit_Invoice_number();

	}

	// 173

	@Test(dataProvider = "missedliveauction")
	public void Verify_Sold_button_functionality_on_manual_clerking_page_SAM_10372(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, AWTException, ParseException {
		System.out.println("Task No. - SAM-10372");
		common.log("Task No. - SAM-10372");

		String str = common.generateRandomChars(5);
		String saleno = common.generateRandomNumber1();

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.create_Hybrid_Auction(str);
		adminDashboardPage.add1Lot();
		adminDashboardPage.start_Auction_Hybrid();
		adminDashboardPage.generate_Floor_Bidder_Invoice(saleno);

	}

	// 174

	@Test(dataProvider = "missedliveauction")
	public void Verify_to_validate_empty_image_URL_on_create_auction_page_SAM_10313(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, AWTException, ParseException {
		System.out.println("Task No. - SAM-10313");
		common.log("Task No. - SAM-10313");

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.createtimedauction_with_blank_image_URL();

	}

	// 175
	@Test(dataProvider = "missedliveauction")
	public void Verify_create_Lot_and_Item_unchecking_Visible_condition_SAM_10228(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, AWTException, ParseException {
		System.out.println("Task No. - SAM-10228");
		common.log("Task No. - SAM-10228");
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		String itemname = common.generateRandomChars(5);
		String lotname = common.generateRandomChars(6);

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Hide_All_Fields_InventoryPage();
		adminDashboardPage.VerifyADDItem_with_required_data(itemname);
		adminDashboardPage.createTimedAuction(saleno);
		adminDashboardPage.Add_lot_with_required_data(lotname);

	}

	// 176

	@Test(dataProvider = "missedliveauction")
	public void Verify_create_auction_enabling_Visible_condition_after_disabling_SAM_10228(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, AWTException, ParseException {
		System.out.println("Task No. - SAM-10228");
		common.log("Task No. - SAM-10228");
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		String aucname = common.generateRandomChars(6);

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Hide_All_Fields_AuctionInfoPage();
		adminDashboardPage.Create_Timedauction_with_Required_fields(saleno, aucname);

	}

	// 177
	@Test(dataProvider = "missedliveauction")
	public void Verify_referrer_input_in_Custom_Lots_report_SAM_10479(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, AWTException, ParseException {
		System.out.println("Task No. - SAM-10479");
		common.log("Task No. - SAM-10479");
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		String aucname1 = common.generateRandomChars(6);
		String lotname = common.generateRandomChars(6);

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Create_custom_template();
		adminDashboardPage.timedauction1(saleno, aucname1);
		adminDashboardPage.Add_lot_with_required_data(lotname);
		adminDashboardPage.Register_and_approve_bidder();
		adminDashboardPage.Sell_bid_for_lot_with_bidder();
		adminDashboardPage.Generate_Custom_Lots_Report(aucname1);
		adminDashboardPage.Print_custom_lot_Report_and_referrer_data();
	}

	// 178
	@Test(dataProvider = "missedliveauction")
	public void Verify_Image_checkbox_is_editable_in_table_SAM_10479(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, AWTException, ParseException {
		System.out.println("Task No. - SAM-10479");
		common.log("Task No. - SAM-10479");
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		String aucname1 = common.generateRandomChars(6);
		String lotname = common.generateRandomChars(6);

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Create_custom_template_with_Image();
		adminDashboardPage.timedauction1(saleno, aucname1);
		adminDashboardPage.Add_lot_with_required_data(lotname);
		adminDashboardPage.Register_and_approve_bidder();
		adminDashboardPage.Sell_bid_for_lot_with_bidder();
		adminDashboardPage.Generate_Custom_Lots_Report(aucname1);
		adminDashboardPage.Edit_Image_checkbox_under_dropdown();
	}

	// 179
	@Test(dataProvider = "missedliveauction")
	public void Verify_generate_auction_specific_custom_lots_report_SAM_10479(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, AWTException, ParseException {
		System.out.println("Task No. - SAM-10479");
		common.log("Task No. - SAM-10479");
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		String aucname1 = common.generateRandomChars(6);
		String aucname2 = common.generateRandomChars(6);
		String lotname1 = common.generateRandomChars(6);
		String lotname2 = common.generateRandomChars(6);

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Create_custom_template_with_Auction_Name();
		adminDashboardPage.timedauction1(saleno, aucname1);
		adminDashboardPage.timedlot1(lotname1);
		adminDashboardPage.Register_and_approve_bidder();
		adminDashboardPage.Sell_bid_for_lot_with_bidder();
		adminDashboardPage.timedauction2(saleno, aucname2);
		adminDashboardPage.timedlot2(lotname2);
		adminDashboardPage.Register_and_approve_bidder();
		adminDashboardPage.Sell_bid_for_lot_with_bidder();
		adminDashboardPage.Generate_Custom_Lots_Report_with_auction_name(aucname1);
		adminDashboardPage.Verify_auction_name_in_generated_report(aucname1);

	}

	// 180
	@Test(dataProvider = "missedliveauction")
	public void Verify_to_add_auctioneer_by_enter_SAM_10110(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, AWTException, ParseException {
		System.out.println("Task No. - SAM-10110");
		common.log("Task No. - SAM-10110");

		String auctioneer = common.generateRandomChars(6);

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Create_new_auctioneer_with_enter_key(auctioneer);

	}

	// 181
	@Test(dataProvider = "missedliveauction")
	public void Verify_Redirecting_to_Oops_error_when_creating_editing_User_with_file_type_custom_field_10896(
			String adminUserName, String adminPassword, String Name) throws Exception {
		System.out.println("Task No. - SAM-10896");
		common.log("Task No. - SAM-10896");

		String UserName = common.generateRandomChars(6);

		driver.get(configFileReader.getqa_dev_autoadminUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		// adminDashboardPage.Add_new_custom_field_for_User_with_file_type();
		adminDashboardPage.Verify_Redirecting_to_Oops_error_when_creating_editing_User_with_file_type_custom_field();

	}

	// 182
	@Test(dataProvider = "missedliveauction")
	public void Verify_functionality_of_Apply_startend_times_button_SAM_10179(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, AWTException, ParseException {
		System.out.println("Task No. - SAM-10179");
		common.log("Task No. - SAM-10179");

		String saleno = common.generateRandomNumber1();
		String lotname = common.generateRandomChars(6);

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Create_Timed_Auction_Ongoing_type_5968(saleno);
		adminDashboardPage.Public_Add_Lot_With_Time();
		adminDashboardPage.Applystartendtimesbutton();

	}

	// 183
	@Test(dataProvider = "missedliveauction")
	public void Verify_update_Invoice_status_to_Paid_SAM_10101(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-10101");
		common.log("Task No. - SAM-10101");
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		String name = common.generateRandomChars(6);
		String lotname1 = common.generateRandomChars(6);

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Timed_auction_with_publish(saleno, name);
		adminDashboardPage.timedlot1(lotname1);
		adminDashboardPage.Register_and_approve_bidder();
		adminDashboardPage.Sell_bid_for_lot_with_bidder();
		adminDashboardPage.Generate_Invoice_and_update_to_Paid(name);
	}

	// 184
	@Test(dataProvider = "missedliveauction")
	public void Verify_Open_status_on_updating_Paid_invoice_after_removing_payment_SAM_10088(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-10088");
		common.log("Task No. - SAM-10088");
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		String name = common.generateRandomChars(6);
		String lotname1 = common.generateRandomChars(6);

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Timed_auction_with_publish(saleno, name);
		adminDashboardPage.timedlot1(lotname1);
		adminDashboardPage.Register_and_approve_bidder();
		adminDashboardPage.Sell_bid_for_lot_with_bidder();
		adminDashboardPage.Generate_Invoice_and_update_to_Paid(name);
		adminDashboardPage.remove_Payment_For_Paid_Invoice();
	}

	// 185
	@Test(dataProvider = "missedliveauction")
	public void Verify_validations_at_frontend_when_Simplified_is_disabled_SAM_9968(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-9968");
		common.log("Task No. - SAM-9968");
		String usname = common.generateRandomChars(6);
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		String name = common.generateRandomChars(6);
		String lotname1 = common.generateRandomChars(6);

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verifyUncheckedCheckboxSimplifiedSignup();
		adminDashboardPage.createUserWithUsername(usname);
		adminDashboardPage.Timed_auction_with_publish(saleno, name);
		adminDashboardPage.timedlot1(lotname1);
		adminDashboardPage.register_And_Approve_New_Bidder(usname);
		adminDashboardPage.Sell_bid_for_lot_with_bidder();
		adminDashboardPage.generateinvoice_And_Updating_Pending_Status(name, usname);

		driver.get(configFileReader.getqa_MainAutoFront());
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(usname, "Abc@123");
		dashboardPage.Goto_invoice_payment();
	}

	// 186
	@Test(dataProvider = "missedliveauction")
	public void Verify_results_for_blank_input_in_Account_filter_SAM_10152(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-10152");
		common.log("Task No. - SAM-10152");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.Verify_results_with_blank_search_filters_Sales();
		adminDashboardPage.verify_Results_With_Blank_Search_Filters_Payment();
		adminDashboardPage.verify_Results_With_Blank_Search_Filters_Tax();
		adminDashboardPage.verify_Results_With_Blank_Search_Filters_Referrers();
		adminDashboardPage.verify_Results_With_Blank_Search_Filters_Document_Views();
		adminDashboardPage.verify_Results_With_Blank_Search_Filters_Audit_Trail();
		adminDashboardPage.verify_Results_With_Blank_Search_Filters_Special_Terms();
		adminDashboardPage.verify_Results_With_Blank_Search_Filters_Auction();
		adminDashboardPage.verify_Results_With_Blank_Search_Filters_Inventory_Page();
		adminDashboardPage.verify_Results_With_Blank_Search_Filters_Invoices_Page();
		adminDashboardPage.verify_Results_With_Blank_Search_Filters_Settlements_Page();

	}

	// 187
	@Test(dataProvider = "missedliveauction")
	public void Verify_CCinfo_conditions_uneditable_when_Require_CC_is_checked_SAM_9928(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-9928");
		common.log("Task No. - SAM-9928");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verifyCheckedCheckboxRequireCreditCardonSignup();
	}

	// 188
	@Test(dataProvider = "missedliveauction")
	public void Verify_important_security_user_privilege_issue_SAM_9520(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-9520");
		common.log("Task No. - SAM-9520");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.add_User_With_Privileges();
		adminDashboardPage.impersonateuser();
		adminDashboardPage.verify_User_Privilleges_Disabled_Per_Admin_User();
	}

	// 189
	@Test(dataProvider = "missedliveauction")
	public void Verify_lot_with_Special_terms_and_condition_on_My_Items_page_SAM_9003(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-9003");
		common.log("Task No. - SAM-9003");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String usname = common.generateRandomChars(6);
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		String name = common.generateRandomChars(6);
		String lotname1 = common.generateRandomChars(6);
		String specialtext = common.generateRandomChars(8);

		adminDashboardPage.createUserWithUsername(usname);
		adminDashboardPage.Timed_auction_with_publish(saleno, name);
		adminDashboardPage.specialTermsLot1(lotname1, specialtext);
		adminDashboardPage.register_And_Approve_New_Bidder(usname);

		driver.get(configFileReader.getqa_MainAutoFront());
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(usname, "Abc@123");
		dashboardPage.Verify_Timed_Auction_and_goto_catalog_page(name);
		dashboardPage.Verify_to_add_and_view_lot_at_Watchlist_under_MyItems(lotname1);
	}

	// 190
	@Test(dataProvider = "missedliveauction")
	public void Verify_Startingbid_and_BuyNow_value_as_per_selected_category_SAM_5270(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-5270");
		common.log("Task No. - SAM-5270");

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String usname = common.generateRandomChars(6);
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		String name = common.generateRandomChars(6);
		String lotcategory = common.generateRandomChars(6);
		String categoryname = common.generateRandomChars(6);
		String itemname = common.generateRandomChars(5);

		adminDashboardPage.Add_new_category(categoryname);
		adminDashboardPage.Add_item_with_new_category(categoryname, itemname);
		adminDashboardPage.timed_Auction_With_Publish(saleno, name);
		adminDashboardPage.Add_Lot_with_new_category(lotcategory, categoryname);

	}

	// 191
	@Test(dataProvider = "missedliveauction")
	public void Verify_visibility_of_hidden_fields_relating_Allowbuyerselectquantity_on_Edit_Lot_page_SAM_10449(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-10449");
		common.log("Task No. - SAM-10449");

		System.out.println("----Dev----");
		common.log("<br></br>---Dev---");
		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		String name = common.generateRandomChars(6);
		String lotname = common.generateRandomChars(6);

		adminDashboardPage.timed_Auction_With_Publish(saleno, name);
		adminDashboardPage.add_Lot_With_Allowbuynow(lotname);
		adminDashboardPage.edit_Lot_And_Verify_Access_To_Hidden_Fields();

		System.out.println("----qa3-6-auto----");
		common.log("<br></br>---qa3-6-auto---");
		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.timed_Auction_With_Publish(saleno, name);
		adminDashboardPage.add_Lot_With_Allowbuynow(lotname);
		adminDashboardPage.edit_Lot_And_Verify_Access_To_Hidden_Fields();

	}

	// 192

	@Test(dataProvider = "missedliveauction")
	public void Verify_to_upload_Resller_Certificate_on_Registeration_SAM_5051(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-5051");
		common.log("Task No. - SAM-5051");

		System.out.println("----Dev----");
		common.log("<br></br>---Dev---");
		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String usname = common.generateRandomChars(6);
		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		String name = common.generateRandomChars(6);
		String lotname = common.generateRandomChars(6);

		adminDashboardPage.go_To_User_Option_Registration_section();
		adminDashboardPage.enable_Reseller_Registeration();
		adminDashboardPage.verifyToUncheckOtherAuctionRegisterationOption();
		adminDashboardPage.createUserWithUsername(usname);
		adminDashboardPage.enable_Inline_Bid_Confirmation();
		adminDashboardPage.timed_Auction_With_Publish(saleno, name);
		adminDashboardPage.add_Lot_With_Required_Data(lotname);

		driver.get(configFileReader.getqa_MainAutoFront());
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(usname, "Abc@123");
		dashboardPage.goto_Catalog_Page_Time_Sale_dev(name);
		dashboardPage.clickOnRegisterBidCatalog();
		dashboardPage.uploadResellerCertificate();

		System.out.println("----qa3-6-auto----");
		common.log("<br></br>---qa3-6-auto---");
		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.go_To_User_Option_Registration_section();
		adminDashboardPage.enable_Reseller_Registeration();
		adminDashboardPage.verifyToUncheckOtherAuctionRegisterationOption();
		adminDashboardPage.createUserWithUsername(usname);
		adminDashboardPage.enable_Inline_Bid_Confirmation();
		adminDashboardPage.timed_Auction_With_Publish(saleno, name);
		adminDashboardPage.add_Lot_With_Required_Data(lotname);

		driver.get(configFileReader.getqa_MainAutoFront());
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(usname, "Abc@123");
		dashboardPage.goto_Catalog_Page_Time_Sale_qa36auto(name);
		dashboardPage.clickOnRegisterBidCatalog();
		dashboardPage.uploadResellerCertificate();

	}

	// 193
	@Test(dataProvider = "missedliveauction")
	public void Verify_to_upload_lots_having_category_with_spceial_character_SAM_3762(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-3762");
		common.log("Task No. - SAM-3762");

		System.out.println("----Dev----");
		common.log("<br></br>---Dev---");
		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String tomorrowDate = common.tomorrowDate();
		String saleno = common.generateRandomNumber1();
		String name = common.generateRandomChars(6);
		String lotname = common.generateRandomChars(6);

		adminDashboardPage.timed_Auction_With_Publish(saleno, name);
		adminDashboardPage.upload_Lots_via_CSV_with_SpecialcharacterCategory_dev();
		adminDashboardPage.verify_Uploaded_Category_Name();

		System.out.println("----qa3-6-auto----");
		common.log("<br></br>---qa3-6-auto---");
		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.timed_Auction_With_Publish(saleno, name);
		adminDashboardPage.upload_Lots_via_CSV_with_SpecialcharacterCategory_qa36auto();
		adminDashboardPage.verify_Uploaded_Category_Name();

	}

	// 194

	@Test(dataProvider = "missedliveauction")
	public void Verify_Lot_Name_On_CSV_Upload_SAM_11409(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-11409");
		common.log("Task No. - SAM-11409");

		System.out.println("----Dev----");
		common.log("<br></br>---Dev---");
		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String randomEmail = common.generateRandomChars(6);
		String saleno = common.generateRandomNumber1();
		String name = common.generateRandomChars(6);
		String lotname = common.generateRandomChars(6);

		adminDashboardPage.timed_Auction_With_Publish(saleno, name);
		adminDashboardPage.upload_CSV_Without_Lot_Name_On_Dev();

	}

	// 195

	@Test(dataProvider = "missedliveauction")
	public void Verify_Preferred_Bidder_Privillege_On_Signup_SAM_11387(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-11387");
		common.log("Task No. - SAM-11387");

		System.out.println("----Dev----");
		common.log("<br></br>---Dev---");
		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String randomEmail = common.generateRandomChars(6);
		String saleno = common.generateRandomNumber1();
		String name = common.generateRandomChars(6);
		String lotname = common.generateRandomChars(6);
		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		String PhoneType = "Work";

		adminDashboardPage.delete_Custom_Field(); // Delete custom field
		adminDashboardPage.delete_Additional_Confirmation(); // Delete Additional custom field
		adminDashboardPage.expand_Registration_Tab(); // Verify Users
		adminDashboardPage.verifyUncheckedCheckboxSimplifiedSignupAndPreferredConditionOn(); // Enable CC Info on SignUp
		adminDashboardPage.adminLogout(); // Logout From Admin

		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();

		signupPage.regular_SignUp_For_Shipping_Info1(FirstName, LastName, EmailUser, signUpUser); // Regular
		signupPage.check_Sameasbilling_Checkbox(); // Sign
		signupPage.signup_button(); // Click on SignUp button

		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.edit_And_Verify_Preferred_Privileges(signUpUser);

	}

	// 196

	@Test(dataProvider = "missedliveauction")
	public void Verify_Settlement_Blocked_For_Seleted_User_SAM_4829(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-4829");
		common.log("Task No. - SAM-4829");

		System.out.println("----Dev----");
		common.log("<br></br>---Dev---");
		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String conusname = common.generateRandomChars(6);
		String usname = common.generateRandomChars(6);
		String randomEmail = common.generateRandomChars(6);
		String saleno = common.generateRandomNumber1();
		String name = common.generateRandomChars(6);
		String lotname = common.generateRandomChars(6);

		adminDashboardPage.createUserWithUsername(usname);
		adminDashboardPage.createConsignor(conusname);
		adminDashboardPage.timed_Auction_With_Publish(saleno, name);
		adminDashboardPage.add_Lot_With_Consignor_Data(lotname, conusname);
		adminDashboardPage.register_And_Approve_New_Bidder(usname);
		adminDashboardPage.Sell_bid_for_lot_with_bidder();
		adminDashboardPage.generate_Settlement(conusname, lotname);

//			driver.get(configFileReader.getqa_MainAutoFront());
//			loginPage = indexPage.clickOnLoginLink(); // click on login link
//			dashboardPage = loginPage.loginUser(usname, "Abc@123");
//			dashboardPage.goto_Catalog_Page_Time_Sale_dev(name);
//			dashboardPage.placeBidFromCatalogpage();
		//
//			System.out.println("----qa3-6-auto----");
//			common.log("<br></br>---qa3-6-auto---");
//			driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
//			adminDashboardPage = indexPage // Admin Signin
//					.adminSignin(adminUserName, adminPassword);
		//
//			adminDashboardPage.timed_Auction_With_Publish(saleno, name);
//			adminDashboardPage.upload_Lots_via_CSV_with_SpecialcharacterCategory_qa36auto();
//			adminDashboardPage.verify_Uploaded_Category_Name();

	}

	// 197
	@Test(dataProvider = "missedliveauction")
	public void verify_User_Custom_Field_Edit_Redirects_To_Oops_Error_Page_On_Saving_SAM_11330(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-11330");
		common.log("Task No. - SAM-11330");

		System.out.println("----Dev----");
		common.log("<br></br>---Dev---");
		String customField = common.generateRandomChars(6);
		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.add_New_User_Custom_Field(customField);

	}

	// 198

	@Test(dataProvider = "missedliveauction")
	public void verify_Auction_Level_Permissions_Are_Not_Getting_Saved_SAM_11339(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-11339");
		common.log("Task No. - SAM-11339");

		System.out.println("----Dev----");
		common.log("<br></br>---Dev---");
		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verify_Auction_Level_Permissions_Are_Not_Getting_Saved();
	}

	// 199

	@Test(dataProvider = "missedliveauction")
	public void verify_Issues_Related_To_State_Province_Field_At_Frontend_SAM_11341(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-11341");
		common.log("Task No. - SAM-11341");
		System.out.println("----Dev----");
		common.log("<br></br>---Dev---");
		String FirstName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		String signUpUser = common.generateRandomChars(6);
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.delete_Custom_Field();
		adminDashboardPage.remove_New_Signup_Confirmation_Field_From_Additional_Confirmation_One_Per_Line();
		adminDashboardPage.verifyCheckedCheckboxOnRegistrationSettingsForRegularSignup();
		adminDashboardPage.adminLogout(); // Logout From Admin
		signupPage = adminDashboardPage.goto_FrontEnd_And_Enter_Registration_Details();
		signupPage.regularSignUp(FirstName, LastName, EmailUser, signUpUser);
	}

	// 200

	@Test(dataProvider = "missedliveauction")
	public void verify_Issue_In_Fetching_Bidding_Notices_On_Lot_Detail_Page_SAM_11348(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-11348");
		common.log("Task No. - SAM-11348");
		System.out.println("----Dev----");
		common.log("<br></br>---Dev---");
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String saleno = common.generateRandomNumber1();
		String aucname = common.generateRandomChars(6);
		adminDashboardPage.createTimedSale(saleno, aucname);
		String lotName = adminDashboardPage.addLot(1);
		adminDashboardPage.approveBidder1();
		adminDashboardPage.front();

		driver.get(configFileReader.getqa_MainAutoFront());
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		dashboardPage.place_Bid_Timed_Auction(aucname, lotName);

	}

	// 201
	@Test(dataProvider = "missedliveauction")
	public void verify_Error_When_Uploading_Image_Via_Enter_Url_On_Auction_Add_Edit_Action_11342(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-11342");
		common.log("Task No. - SAM-11342");
		System.out.println("----Dev----");
		common.log("<br></br>---Dev---");
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verify_Calc_Button_At_Invoice_Shows_Undefined_Error();
	}

	// 202
	@Test(dataProvider = "missedliveauction")
	public void verify_Custom_Field_Access_To_Bidder_Is_Not_Showing_Field_To_Bidder_SAM_11355(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-11355");
		common.log("Task No. - SAM-11355");
		System.out.println("----Dev----");
		common.log("<br></br>---Dev---");
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String saleno = common.generateRandomNumber1();
		String aucname = common.generateRandomChars(6);
		String name = adminDashboardPage.add_Lot_Item_Custom_Field();
		adminDashboardPage.createTimedSale(saleno, aucname);
		String lotName = adminDashboardPage.addLotWithCustomFieldValue(name);
		adminDashboardPage.approveBidder1();
		adminDashboardPage.front();

		driver.get(configFileReader.getqa_MainAutoFront());
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");
		dashboardPage.verify_Custom_Field_Access_To_Bidder_Is_Not_Showing_Field_To_Bidder(aucname, lotName);

	}

	// 203
	@Test(dataProvider = "missedliveauction")
	public void verify_In_Invoice_Quantity_Is_Not_Displayed_SAM_11343(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-11343");
		common.log("Task No. - SAM-11343");
		System.out.println("----Dev----");
		common.log("<br></br>---Dev---");
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String saleno = common.generateRandomNumber1();
		String name = common.generateRandomChars(6);
		adminDashboardPage.check_Include_Invoice_Quantity_In_Invoice();
		adminDashboardPage.createTimedSale(saleno, name);
		adminDashboardPage.Add_Lot_for_invoice();
		adminDashboardPage.approveBidder1();
		adminDashboardPage.enter_bids();
		adminDashboardPage.Generate_Invoice(name);
		adminDashboardPage.verify_In_Invoice_Quantity_Is_Not_Displayed();
	}

	// 204
	@Test(dataProvider = "missedliveauction")
	public void verify_Consignor_By_Sale_PDF_Report_Generates_500_Error_SAM_11353(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-11343");
		common.log("Task No. - SAM-11343");
		System.out.println("----Dev----");
		common.log("<br></br>---Dev---");
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.verify_Consignor_By_Sale_PDF_Report_Generates_500_Erro();
	}

	// 205
	@Test(dataProvider = "missedliveauction")
	public void verify_Add_Bidder_File_Type_Custom_Field_Oops_Error_Pop_Up_Displayed_On_Clicking_Add_File_Button_SAM_11352_1(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-11343");
		common.log("Task No. - SAM-11343");
		System.out.println("----Dev----");
		common.log("<br></br>---Dev---");
		String saleno = common.generateRandomNumber1();
		String name = common.generateRandomChars(6);
		String customfieldname = common.generateRandomChars(6);
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.add_User_Custom_Field_With_Type_File(customfieldname);
		adminDashboardPage.createTimedSale(saleno, name);
		adminDashboardPage.add_Bidder(customfieldname);

	}

	// 206

	@Test(dataProvider = "missedliveauction")
	public void verify_Auto_Approve_On_Auction_Bidder_Import_SAM_11350(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-11350");
		common.log("Task No. - SAM-11350");
		System.out.println("----Dev----");
		common.log("<br></br>---Dev---");

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String saleno = common.generateRandomNumber1();
		String name = common.generateRandomChars(6);

		adminDashboardPage.timed_Auction_With_Publish(saleno, name);
		adminDashboardPage.upload_Timed_Import_Bidder_CSV();
		adminDashboardPage.verify_ApproveBiddericon_Availability();

	}

	// 207

	@Test(dataProvider = "missedliveauction")
	public void verify_Send_Messages_Dispalyed_twice_On_LiveSale_SAM_11344(String adminUserName, String adminPassword,
			String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-11344");
		common.log("Task No. - SAM-11344");
		System.out.println("----Dev----");
		common.log("<br></br>---Dev---");

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String usname = common.generateRandomChars(6);
		String saleno = common.generateRandomNumber1();
		String name = common.generateRandomChars(6);
		String lotname = common.generateRandomChars(6);

		adminDashboardPage.createUserWithUsername(usname);
		adminDashboardPage.enable_Send_Chat_Message_Settings();
		adminDashboardPage.create_Live_Auction_Simple_Clerking(saleno, name);
		adminDashboardPage.add_Lot_For_Live(lotname);
		adminDashboardPage.add_Lot_For_Live(lotname);
		adminDashboardPage.add_Lot_For_Live(lotname);
		adminDashboardPage.register_And_Approve_New_Bidder(usname);
		adminDashboardPage.start_Auction();

		driver.get(configFileReader.getqa_MainAutoFront());
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(usname, "Abc@123");
		dashboardPage.goto_Catalog_Page_Live_Sale_dev(name);
		dashboardPage.liveSale();

	}

	// 208

	@Test(dataProvider = "missedliveauction")
	public void verify_Error_On_CC_Update_Between_Bid_Placed_Frontend_SAM_11383(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-11383");
		common.log("Task No. - SAM-11383");
		System.out.println("----Dev----");
		common.log("<br></br>---Dev---");

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		String usname1 = common.generateRandomChars(6);
		String usname2 = common.generateRandomChars(6);
		String saleno = common.generateRandomNumber1();
		String name = common.generateRandomChars(6);
		String lotname = common.generateRandomChars(6);

		adminDashboardPage.verify_Visa_Card();
		adminDashboardPage.verify_American_Express_Card();
		adminDashboardPage.createUser1WithCCDetails(usname1);
		adminDashboardPage.createUser2WithCCDetails(usname2);
		adminDashboardPage.timed_Auction_With_Publish(saleno, name);
		adminDashboardPage.add_Lot_With_Required_Data(lotname);
		adminDashboardPage.register_And_Approve_New_Bidder1(usname1);
		adminDashboardPage.register_And_Approve_New_Bidder2(usname2);

		driver.get(configFileReader.getqa_MainAutoFront());
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(usname1, "Abc@123");
		dashboardPage.goto_Catalog_Page_Time_Sale_dev(name);
		dashboardPage.placeBidFromCatalogPage();

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.search_User1(usname1);
		adminDashboardPage.edit_CC_Details();
		adminDashboardPage.verify_Place_Bid_On_CC_Update_dev(name, usname1);

		System.out.println("----qa3-6-auto----");
		common.log("<br></br>---qa3-6-auto---");
		driver.get(configFileReader.getqa_MainAutoAdmin()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);

		adminDashboardPage.verify_Visa_Card();
		adminDashboardPage.verify_American_Express_Card();
		adminDashboardPage.createUser1WithCCDetails(usname1);
		adminDashboardPage.createUser2WithCCDetails(usname2);
		adminDashboardPage.timed_Auction_With_Publish(saleno, name);
		adminDashboardPage.add_Lot_With_Required_Data(lotname);
		adminDashboardPage.register_And_Approve_New_Bidder1(usname1);
		// adminDashboardPage.register_And_Approve_New_Bidder2(usname2);

		driver.get(configFileReader.getqa_MainAutoFront());
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(usname1, "Abc@123");
		dashboardPage.goto_Catalog_Page_Time_Sale_qa36auto(name);
		dashboardPage.placeBidFromCatalogPage();

		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");

		adminDashboardPage.search_User1(usname1);
		adminDashboardPage.edit_CC_Details();
		adminDashboardPage.verify_Place_Bid_On_CC_Update_qa36auto(name, usname1);

	}

	// 209
	@Test(dataProvider = "missedliveauction")
	public void verify_On_File_Custom_Field_Of_Add_Edit_User_Page_And_Signup_Edit_Profile_Page_SAM_11352_2(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-11343");
		common.log("Task No. - SAM-11343");
		System.out.println("----Dev----");
		common.log("<br></br>---Dev---");
		String saleno = common.generateRandomNumber1();
		String name = common.generateRandomChars(6);
		String customfieldname = common.generateRandomChars(6);
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.delete_Custom_Field();
		adminDashboardPage.add_User_Custom_Field_With_Type_File(customfieldname);
		adminDashboardPage.addUserWithCustomFieldFileType(customfieldname, name);
		adminDashboardPage.front();

		dashboardPage = new DashboardPage(driver);
		dashboardPage.verify_On_File_Custom_Field_Of_Signup_Edit_Profile_Page(name);

	}

	// 210
	@Test(dataProvider = "missedliveauction")
	public void verify_On_File_Custom_Field_Of_Add_Edit_User_Page_And_Signup_Edit_Profile_Page_SAM_11352_3(
			String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-11343");
		common.log("Task No. - SAM-11343");
		System.out.println("----Dev----");
		common.log("<br></br>---Dev---");
		String saleno = common.generateRandomNumber1();
		String name = common.generateRandomChars(6);
		String customfieldname = common.generateRandomChars(6);
		String customfieldname2 = common.generateRandomChars(6);
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.delete_Custom_Field();
		adminDashboardPage.add_User_Custom_Field_With_Type_File(customfieldname);
		adminDashboardPage.add_User_Custom_Field_With_Type_File(customfieldname2);
		adminDashboardPage.createTimedAuction(saleno);
		adminDashboardPage.verify_Add_New_Bidder_File_Field_Add_File_Buttons_Are_Hidden_After_Adding_A_File_In_Created_Fields(
						customfieldname, customfieldname2);

	}

	// 211

	@Test(dataProvider = "missedliveauction")
	public void verify_Send_Invoice_Button_Not_Working_At_Stacked_Invoice_SAM_11514(String adminUserName,
			String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {
		System.out.println("Task No. - SAM-11541");
		common.log("Task No. - SAM-11541");
		System.out.println("----Dev----");
		common.log("<br></br>---Dev---");
		String saleno = common.generateRandomNumber1();
		 String name = common.generateRandomChars(5);
		driver.get(configFileReader.getqa_MainAutoAdmin());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.create_timed_auction_with_all_dates(saleno, name);
		String lotName = adminDashboardPage.addLot(1);
		adminDashboardPage.approveBidder1();
		adminDashboardPage.enter_bids();
		adminDashboardPage.verify_Send_Invoice_Button_Not_Working_At_Stacked_Invoice(name);
		
	}
	// 212
		@Test(dataProvider = "missedliveauction")
		public void verify_Auction_Lots_Quick_Edit_Form_Does_Not_Save_Data_SAM_11463(String adminUserName,
				String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {
			System.out.println("Task No. - SAM-11463");
			common.log("Task No. - SAM-1463");
			System.out.println("----Dev----");
			common.log("<br></br>---Dev---");
			String name = common.generateRandomChars(6);
			driver.get(configFileReader.getqa_MainAutoAdmin());
			adminDashboardPage = indexPage // Admin Signin
					.adminSignin(adminUserName, adminPassword);
			adminDashboardPage.uncheck_Timezone();
			adminDashboardPage.create_Live_Auction(name);
			adminDashboardPage.addLot(1);
			adminDashboardPage.verify_Auction_Lots_Quick_Edit_Form_Does_Not_Save_Data();
		}
		// 213
				@Test(dataProvider = "missedliveauction")
				public void verify_Individual_Buyers_Premium_Table_Does_Not_Show_Saved_Data_On_The_Lot_Page_SAM_11451(String adminUserName,
						String adminPassword, String Name) throws InterruptedException, ParseException, AWTException {
					System.out.println("Task No. - SAM-11463");
					common.log("Task No. - SAM-1463");
					System.out.println("----Dev----");
					common.log("<br></br>---Dev---");
					String name = common.generateRandomChars(6);
					driver.get(configFileReader.getqa_MainAutoAdmin());
					common.installation_URL();
					adminDashboardPage = indexPage // Admin Signin
							.adminSignin(adminUserName, adminPassword);
					adminDashboardPage.create_Live_Auction(name);
					adminDashboardPage.add_Lot_With_Individual_Buyers_Premium();
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
	 * Data Provider for Regular Signup Feature
	 * 
	 * @return
	 * @throws Exception
	 */
	@DataProvider(name = "regularsignup")
	public Object[][] getRegularSignup() throws Exception {

		Object[][] retObjectArr = parseRegularSignupCsv();

		return retObjectArr;
	}

	@DataProvider(name = "login")
	public Object[][] getLogin() throws Exception {

		Object[][] retObjectArr = parseCsv();

		return retObjectArr;

	}

	/**
	 * Data Provider for Signup Feature
	 * 
	 * @return
	 * @throws Exception
	 */
	@DataProvider(name = "signup")
	public Object[][] getSignup() throws Exception {

		Object[][] retObjectArr = parseSignUpCsv();

		return retObjectArr;

	}

}
