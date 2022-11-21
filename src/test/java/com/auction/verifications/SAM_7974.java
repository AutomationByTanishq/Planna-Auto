package com.auction.verifications;

import java.awt.AWTException;
import java.text.ParseException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.auction.init.Common;
import com.auction.init.ConfigFileReader;
import com.auction.init.SeleniumInit;

public class SAM_7974 extends SeleniumInit {

	String lotName = null;
	String uName = null;
	String bidder2 = "rahulbid";
	String bidder2Pass = "123123a";
	Common common = new Common(driver);
	ConfigFileReader configFileReader= new ConfigFileReader();
	/**
	 * 1
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Creating_Consignor_Commission_Rule_with_Simple_Range_table_and_set_at_Auction_level(
			String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-8966");
		common.log("TC: SAM-8966");

		try {
			try {
				String saleno1 = Common.generateRandomNumber1();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String tomorrowDate = common.tomorrowDate();
		String saleno = Common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String str_rule = adminDashboardPage.Create_Rule_In_Consignor_Commission_Fee();
		String AucName = adminDashboardPage.Create_Live_Auction_With_Rule(tomorrowDate, "1", saleno, str_rule); //
		// Create
		// Auction

		// Add lots with consignor
		adminDashboardPage.Add_Lot_with_Consignor_rahulqa_And_Hammer_Price("1000");

		// Auction
		adminDashboardPage.start_Auction();
		adminDashboardPage.Sell_Lot_With_Winner_Name();
		adminDashboardPage.Verify_Settlements(AucName);

	}

	/**
	 * 2
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Creating_Consignor_Commission_Rule_with_Simple_Range_table_and_set_at_Lot_level(String adminUserName,
			String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-8967");
		common.log("TC: SAM-8967");

		String saleno1 = Common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();
		String saleno = Common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String str_rule = adminDashboardPage.Create_Rule_In_Consignor_Commission_Fee();
		String AucName = adminDashboardPage.Create_Live_Auction_With_select_Other_Than_Created_Rule(tomorrowDate, "1",
				saleno, str_rule); //
		// Create
		// Auction

		// Add lots with consignor
		adminDashboardPage.Add_Lot_with_Consignor_rahulqa_Hammer_Price_Select_Rule("2000", str_rule);

		// Auction
		adminDashboardPage.start_Auction();
		adminDashboardPage.Sell_Lot_With_Winner_Name();
		adminDashboardPage.Verify_Settlements(AucName);

	}

	/**
	 * 3
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Creating_Consignor_Commission_Rule_with_Simple_Range_table_and_set_at_User_level(String adminUserName,
			String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-8968");
		common.log("TC: SAM-8968");

		String saleno1 = Common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();
		String saleno = Common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String str_rule = adminDashboardPage.Create_Rule_In_Consignor_Commission_Fee();
		String AucName = adminDashboardPage.Create_Live_Auction_With_select_Other_Than_Created_Rule(tomorrowDate, "1",
				saleno, str_rule); //
		// Create
		// Auction

		// Add lots with consignor
		adminDashboardPage.Add_Lot_with_Consignor_rahulqa_Hammer_Price_Select_Rule_other_than_created_rule("500", "1");

		adminDashboardPage.Edit_consignor_user_and_set_created_rule(str_rule);
		adminDashboardPage.search_Last_Created_Auction(saleno);
		// Auction
		adminDashboardPage.start_Auction();
		adminDashboardPage.Sell_Lot_With_Winner_Name();
		adminDashboardPage.Verify_Settlements(AucName);

	}

	/**
	 * 4
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Creating_Rule_Setting_Mode_as_Sum_of_Fixed_and_percentage_value_at_both_fixed_and_percentage_Auction_level(
			String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-8982");
		common.log("TC: SAM-8982");

		String saleno1 = Common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();
		String saleno = Common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String str_rule = adminDashboardPage
				.Create_Rule_In_Consignor_Commission_Fee_with_mode_as_Sum_of_Fixed_and_percentag("30","5","1000","35","10","2000","40","15");
		String AucName = adminDashboardPage.Create_Live_Auction_With_Rule(tomorrowDate, "1", saleno, str_rule); //
		// Create
		// Auction

		// Add lots with consignor
		adminDashboardPage.Add_Lot_with_Consignor_rahulqa_And_Hammer_Price("1000");

		// Auction
		adminDashboardPage.start_Auction();
		adminDashboardPage.Sell_Lot_With_Winner_Name();
		adminDashboardPage.Verify_Settlements(AucName);

	}

	/**
	 * 5
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Creating_rule_Setting_Mode_as_Sum_of_Fixed_and_percentage_value_at_both_fixed_and_percentage_and_set_it_at_Lot_level(
			String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-8983");
		common.log("TC: SAM-8983");

		String saleno1 = Common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();
		String saleno = Common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String str_rule = adminDashboardPage
				.Create_Rule_In_Consignor_Commission_Fee_with_mode_as_Sum_of_Fixed_and_percentag("30","5","1000","35","10","2000","40","15");
		String AucName = adminDashboardPage.Create_Live_Auction_With_Rule(tomorrowDate, "1", saleno, str_rule); //
		// Create
		// Auction

		// Add lots with consignor
		adminDashboardPage.Add_Lot_with_Consignor_rahulqa_Hammer_Price_Select_Rule("1000", str_rule);

		// Auction
		adminDashboardPage.start_Auction();
		adminDashboardPage.Sell_Lot_With_Winner_Name();
		adminDashboardPage.Verify_Settlements(AucName);

	}

	/**
	 * 6
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Creating_Rule_Setting_Mode_as_Greater_of_Fixed_and_percentage_value_at_both_fixed_and_percentage_Auction_level(
			String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-8986");
		common.log("TC: SAM-8986");

		String saleno1 = Common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();
		String saleno = Common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String str_rule = adminDashboardPage
				.Create_Rule_In_Consignor_Commission_Fee_with_mode_as_Greater_of_Fixed_and_percentag("30","5","1000","35","10","2000","40","15");
		String AucName = adminDashboardPage.Create_Live_Auction_With_Rule(tomorrowDate, "1", saleno, str_rule); //
		// Create
		// Auction

		// Add lots with consignor
		adminDashboardPage.Add_Lot_with_Consignor_rahulqa_And_Hammer_Price("2000");

		// Auction
		adminDashboardPage.start_Auction();
		adminDashboardPage.Sell_Lot_With_Winner_Name();
		adminDashboardPage.Verify_Settlements(AucName);
	}
	/**
	 * 7
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Creating_Auction_setting_the_rule_for_commission_as_well_as_for_sold_and_unsold_too_and_Let_one_lot_be_sold_and_other_be_unsold(
			String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-8987");
		common.log("TC: SAM-8987");

		String saleno1 = Common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();
		String saleno = Common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String str_rule = adminDashboardPage
				.Create_Rule_In_Consignor_Commission_Fee_with_mode_as_Sum_of_Fixed_and_percentag("30","5","1000","200","10","2000","40","15");
		String AucName = adminDashboardPage.Create_Live_Auction_With_Rule_As_Well_As_Set_Sold_Unsold_Fee(tomorrowDate, "1", saleno, str_rule); //
		// Create
		// Auction

		// Add lots with consignor
		adminDashboardPage.Add_Lot_with_Consignor_rahulqa_And_Hammer_Price("2000");
		adminDashboardPage.Add_Lot_with_Consignor_rahulqa_And_Hammer_Price("2000");
		
		// Auction
		adminDashboardPage.start_Auction();
		adminDashboardPage.Sell_Lot_With_Winner_Name();
		adminDashboardPage.AuctionStop();
		adminDashboardPage.Verify_Settlements(AucName);
	}
	/**
	 * 8
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Creating_Rule_Setting_Mode_as_Greater_of_Fixed_and_percentage_value_at_both_fixed_and_percentage_Lot_level (
			String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-8988");
		common.log("TC: SAM-8988");

		String saleno1 = Common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();
		String saleno = Common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String str_rule = adminDashboardPage
				.Create_Rule_In_Consignor_Commission_Fee_with_mode_as_Greater_of_Fixed_and_percentag("30","5","1000","200","10","2000","350","15");
		String AucName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); //
		// Create
		// Auction

		// Add lots with consignor
		adminDashboardPage.Add_Lot_with_Consignor_rahulqa_Hammer_Price_Select_Rule("2000", str_rule);
		
		// Auction
		adminDashboardPage.start_Auction();
		adminDashboardPage.Sell_Lot_With_Winner_Name();
		adminDashboardPage.Verify_Settlements(AucName);

	}
	/**
	 * 9
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Creating_a_rule_with_option_Default_Commission (
			String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-8989");
		common.log("TC: SAM-8989");

		String saleno1 = Common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();
		String saleno = Common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String str_rule = adminDashboardPage
				.Create_Rule_With_Default_Commission_In_Consignor_Commission_Fee();
		String AucName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); //
		// Create
		// Auction

		// Add lots with consignor
		adminDashboardPage.Add_Lot_with_Consignor_rahulqa_And_Hammer_Price("1000");
		
		// Auction
		adminDashboardPage.start_Auction();
		adminDashboardPage.Sell_Lot_With_Winner_Name();
		adminDashboardPage.Verify_Settlements(AucName);
	}
	/**
	 * 10
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Create_a_rule_with_option_Default_commission_and_default_Sold_fee_checked_with_item_fee_reference_zero (
			String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-8999");
		common.log("TC: SAM-8999");

		String saleno1 = Common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();
		String saleno = Common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String str_rule = adminDashboardPage
				.Create_Rule_With_Default_Commission_And_Sold_Fee_In_Consignor_Commission_Fee();
		String AucName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); //
		// Create
		// Auction

		// Add lots with consignor
		adminDashboardPage.Add_Lot_with_Consignor_rahulqa_And_Hammer_Price("1500");
		
		// Auction
		adminDashboardPage.start_Auction();
		adminDashboardPage.Sell_Lot_With_Winner_Name();
		adminDashboardPage.Verify_Settlements(AucName);

	}
	/**
	 * 11
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Create_a_rule_with_option_Default_commission_and_default_Sold_fee_checked_with_item_fee_reference_Hammer_Price  (
			String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-9000");
		common.log("TC: SAM-9000");

		String saleno1 = Common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();
		String saleno = Common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String str_rule = adminDashboardPage
				.Create_Rule_With_Default_Commission_And_Sold_Fee_In_Consignor_Commission_Fee_Select_Hammer_Price();
		String AucName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); //
		// Create
		// Auction

		// Add lots with consignor
		adminDashboardPage.Add_Lot_with_Consignor_rahulqa_And_Hammer_Price("1000");
		
		// Auction
		adminDashboardPage.start_Auction();
		adminDashboardPage.Sell_Lot_With_Winner_Name();
		adminDashboardPage.Verify_Settlements(AucName);

	}
	/**
	 * 12
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Create_a_rule_with_option_Default_commission_and_calculation_as_Tiered   (
			String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-9002");
		common.log("TC: SAM-9002");

		String saleno1 = Common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();
		String saleno = Common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String str_rule = adminDashboardPage
				.Create_Rule_With_Default_Commission_In_Consignor_Commission_Fee_Select_Calculation_As_Tiered();
		String AucName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); //
		// Create
		// Auction

		// Add lots with consignor
		adminDashboardPage.Add_Lot_with_Consignor_rahulqa_And_Hammer_Price("1500");
		
		// Auction
		adminDashboardPage.start_Auction();
		adminDashboardPage.Sell_Lot_With_Winner_Name();
		adminDashboardPage.Verify_Settlements(AucName);

	}
	/**
	 * 13
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Create_a_rule_with_option_Default_commission_and_default_Sold_fee_and_calculation_as_Tiered   (
			String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-9004");
		common.log("TC: SAM-9004");

		String saleno1 = Common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();
		String saleno = Common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String str_rule = adminDashboardPage
				.Create_Rule_With_Default_Commission_And_Sold_Fee_In_Consignor_Commission_Fee_Select_Calculation_As_Tiered();
		String AucName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); //
		// Create
		// Auction

		// Add lots with consignor
		adminDashboardPage.Add_Lot_with_Consignor_rahulqa_And_Hammer_Price("2000");
		
		// Auction
		adminDashboardPage.start_Auction();
		adminDashboardPage.Sell_Lot_With_Winner_Name();
		adminDashboardPage.Verify_Settlements(AucName);

	}
	/**
	 * 14
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Create_a_simple_rule_and_set_it_to_the_User_having_Tax_as_20  (
			String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-9015");
		common.log("TC: SAM-9015");

		String saleno1 = Common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();
		String saleno = Common.generateRandomNumber1();

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		
		String str_rule = adminDashboardPage
				.Create_Rule_In_Consignor_Commission_Fee_with_mode_as_Greater_of_Fixed_and_percentag("30","5","1000","200","10","2000","350","20");
		
		adminDashboardPage.create_a_user_with_Tax_assigning_Consignor_privilege_along_with_selecting_Hammer_Price_and_Exclusive(UName, str_rule);
		
		String AucName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); //
		// Create
		// Auction

		// Add lots with consignor
		adminDashboardPage.Add_Lot_with_Consignor_rahulqa_And_Hammer_Price("2000");
		
		// Auction
		adminDashboardPage.start_Auction();
		adminDashboardPage.Sell_Lot_With_Winner_Name();
		adminDashboardPage.Verify_Settlements(AucName);

	}
	/**
	 * 15
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Create_a_two_rule_and_assign_one_to_Commission_Rule_and_second_to_Sold_Fee_Rule(
			String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-9162");
		common.log("TC: SAM-9162");

		String saleno1 = Common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();
		String saleno = Common.generateRandomNumber1();
		String title1 = Common.generateRandomChars(5);
		
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String str_rule = adminDashboardPage
				.Create_Two_Rule_In_Consignor_Commission_Fee_with_mode_as_Sum_of_Fixed_and_percentag(title1, "0","10","1000","150","0","2000","0","15");
		String AucName = adminDashboardPage.Create_Live_Auction_With_Both_Rules(tomorrowDate, "1", saleno, str_rule, title1); //
		// Create
		// Auction

		// Add lots with consignor
		adminDashboardPage.Add_Lot_with_Consignor_rahulqa_And_Hammer_Price("2000");
		
		// Auction
		adminDashboardPage.start_Auction();
		adminDashboardPage.Sell_Lot_With_Winner_Name();
		adminDashboardPage.Verify_Settlements(AucName);
	}
	/**
	 * 16
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Create_a_rule_with_Item_reference_as_Hammer_Price_and_assign_the_rule_to_the_UnSold_fee(
			String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-9397");
		common.log("TC: SAM-9397");

		String saleno1 = Common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();
		String saleno = Common.generateRandomNumber1();
		String title1 = Common.generateRandomChars(5);
		
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String str_rule = adminDashboardPage
				.Create_Rule_In_Consignor_Commission_Fee_Select_Hammer_Price();
		String AucName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); //
		// Create
		// Auction

		// Add lots with consignor
		adminDashboardPage.Add_Lot_with_Consignor_rahulqa_Hammer_Price_Select_Unsold_Rule("2000", str_rule);
		
		// Auction
		adminDashboardPage.start_Auction();
		adminDashboardPage.AuctionStop();
		adminDashboardPage.Verify_Settlements(AucName);
	}
	
	/**
	 * 17
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Creating_rule_for_Unsold_fee_with_item_reference_set_as_Start_Price(
			String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-9398");
		common.log("TC: SAM-9398");

		String saleno1 = Common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();
		String saleno = Common.generateRandomNumber1();
		String title1 = Common.generateRandomChars(5);
		
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String str_rule = adminDashboardPage
				.Create_Rule_In_Consignor_Commission_Fee_Select_Starting_Price();
		String AucName = adminDashboardPage.create_Live_Auction_With_Auctioneer(tomorrowDate, "1", saleno); //
		// Create
		// Auction

		// Add lots with consignor
		adminDashboardPage.Add_Lot_with_Consignor_rahulqa_Hammer_Price_Select_Unsold_Rule("2000", str_rule);
		
		// Auction
		adminDashboardPage.start_Auction();
		adminDashboardPage.AuctionStop();
		adminDashboardPage.Verify_Settlements(AucName);
	}

	/**
	 * 18
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Create_a_Custom_rule_at_Auction_level_for_Commission_and_Sold_lot(
			String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-9403");
		common.log("TC: SAM-9403");

		String saleno1 = Common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();
		String saleno = Common.generateRandomNumber1();
		
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String AucName = adminDashboardPage.Create_Live_Auction_With_Custom_Rules(tomorrowDate, "1", saleno);  //
		// Create
		// Auction

		// Add lots with consignor
		adminDashboardPage.Add_Lot_with_Consignor_rahulqa_And_Hammer_Price("2000");
		
		// Auction
		adminDashboardPage.start_Auction();
		adminDashboardPage.Sell_Lot_With_Winner_Name();
		adminDashboardPage.Verify_Settlements(AucName);
	}
	
	/**
	 * 19
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Create_a_Custom_rule_at_Lot_level_for_Commission_and_Sold_lot(
			String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-9404");
		common.log("TC: SAM-9404");

		String saleno1 = Common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();
		String saleno = Common.generateRandomNumber1();
		
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String AucName = adminDashboardPage.Create_Live_Auction_With_Custom_Rules(tomorrowDate, "1", saleno);  //
		// Create
		// Auction

		// Add lots with consignor
		adminDashboardPage.Add_Lot_with_Consignor_rahulqa_And_Custom_Rules("2000");
		
		// Auction
		adminDashboardPage.start_Auction();
		adminDashboardPage.Sell_Lot_With_Winner_Name();
		adminDashboardPage.Verify_Settlements(AucName);
	}

	/**
	 * 20
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Generate_Settlement_not_passing_auction_id_and_also_set_rule_for_sold_fee_and_unsold_fee_with_item_fee_reference_as_Max_bid_Current_bid(
			String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-9411");
		common.log("TC: SAM-9411");

		String saleno1 = Common.generateRandomNumber1();
		String tomorrowDate = common.tomorrowDate();
		String saleno = Common.generateRandomNumber1();
		
		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		String str_rule = adminDashboardPage.Create_Rule_In_Consignor_Commission_Fee_Select_Max_bid_Current();
		String AucName = adminDashboardPage.Create_Live_Auction_With_Created_Sold_Rule(tomorrowDate, "1", saleno, str_rule);  //
		// Create
		// Auction

		// Add lots with consignor
		adminDashboardPage.Add_Lot_with_Consignor_rahulqa_And_Hammer_Price("400");
		
		// Auction
		adminDashboardPage.start_Auction();
		adminDashboardPage.Sell_Lot_With_Winner_Name();
		adminDashboardPage.Verify_Settlements(AucName);
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
