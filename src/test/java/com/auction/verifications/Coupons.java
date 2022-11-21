package com.auction.verifications;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.auction.init.Common;
import com.auction.init.ConfigFileReader;
import com.auction.init.SeleniumInit;

public class Coupons extends SeleniumInit {

	Common common = new Common(driver);
	ConfigFileReader configFileReader= new ConfigFileReader();
	// 1
	@Test
	public void Add_New_Coupon_With_Valid_Details() throws InterruptedException, AWTException, NoClassDefFoundError {

		driver.get(configFileReader.getdev_auctionUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.Add_New_Coupon_With_Valid_Details();

	}

	// 2
	@Test
	public void Add_New_Coupon_Without_Entering_CouponName() throws InterruptedException, AWTException {

		driver.get(configFileReader.getdev_auctionUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.Add_New_Coupon_Without_Entering_CouponName();

	}

	// 3
	@Test
	public void Add_New_Coupon_With_Entering_Alphabetical_Value_In_AmountField()
			throws InterruptedException, AWTException {

		driver.get(configFileReader.getdev_auctionUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.Add_New_Coupon_With_Entering_Alphabetical_Values_In_AmountField();

	}

	// 4
	@Test
	public void Edit_And_Save_Coupon() throws InterruptedException, AWTException {

		driver.get(configFileReader.getdev_auctionUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.Edit_And_Save_Coupon();

	}

	// 5
	@Test
	public void Add_New_Coupon_With_Wrong_Date_Interval() throws InterruptedException, AWTException {

		driver.get(configFileReader.getdev_auctionUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.Add_New_Coupon_With_Wrong_Date_Interval();

	}

	// 6
	@Test
	public void Delete_Added_Coupon() throws InterruptedException, AWTException {

		driver.get(configFileReader.getdev_auctionUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.Delete_Added_Coupon();

	}

	// 7
	@Test
	public void Add_New_Coupon_With_Fixed_Amount_Off() throws InterruptedException, AWTException {

		driver.get(configFileReader.getdev_auctionUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.Add_New_Coupon_With_Fixed_Amount_Off();

	}

	// 8
	@Test
	public void Add_New_Coupon_With_Percentage_Off() throws InterruptedException, AWTException {

		driver.get(configFileReader.getdev_auctionUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.Add_New_Coupon_With_Percentage_Off();

	}

	// 9
	@Test
	public void Deactivate_Added_coupon() throws InterruptedException, AWTException {

		driver.get(configFileReader.getdev_auctionUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.Deactivate_Added_coupon();

	}

	// 10
	@Test
	public void Activate_Added_coupon() throws InterruptedException, AWTException {

		driver.get(configFileReader.getdev_auctionUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.Activate_Added_coupon();

	}

	// 11
	@Test
	public void View_Coupons_Name_In_Asc_Desc_Order_Through_Click_On_Coupons_Header()
			throws InterruptedException, AWTException {

		driver.get(configFileReader.getdev_auctionUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.View_Coupons_Name_In_Asc_Desc_Order();

	}

	// 12
	@Test
	public void View_Coupons_Code_In_Asc_Desc_Order_Through_Click_On_Code_Header()
			throws InterruptedException, AWTException {

		driver.get(configFileReader.getdev_auctionUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.View_Coupons_Code_In_Asc_Desc_Order();

	}

	// 13
	@Test
	public void View_Coupons_Type_In_Asc_Desc_Order_Through_Click_On_Type_Header()
			throws InterruptedException, AWTException {

		driver.get(configFileReader.getdev_auctionUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.View_Coupons_Type_In_Asc_Desc_Order();

	}

	// 14
	@Test
	public void View_Coupons_Min_Purchase_Amt_In_Asc_Desc_Order_Through_Click_On_Min_Amount_Header()
			throws InterruptedException, AWTException {

		driver.get(configFileReader.getdev_auctionUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.View_Coupons_Min_Purchase_Amount_In_Asc_Desc_Order();

	}

	// 15
	@Test
	public void View_Coupons_Per_User_In_Asc_Desc_Order_Through_Click_On_Per_User_Header()
			throws InterruptedException, AWTException {

		driver.get(configFileReader.getdev_auctionUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.View_Coupons_Per_User_In_Asc_Desc_Order();

	}

	// 16
	@Test
	public void Add_New_Coupon_With_Assign_More_Categories() throws InterruptedException, AWTException {

		driver.get(configFileReader.getdev_auctionUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.Add_New_Coupon_With_Assign_More_Categories();

	}

	// 17
	@Test
	public void Try_To_Add_New_Coupon_With_Click_On_Cancel_Button() throws InterruptedException, AWTException {

		driver.get(configFileReader.getdev_auctionUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.Add_New_Coupon_With_Click_On_Cancel_Button();

	}

	// 18
	@Test
	public void Show_All_Active_Coupons() throws InterruptedException, AWTException {

		driver.get(configFileReader.getdev_auctionUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.Show_All_Active_Coupons();

	}
}