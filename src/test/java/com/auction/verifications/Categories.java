package com.auction.verifications;

import java.awt.AWTException;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.auction.init.Common;
import com.auction.init.ConfigFileReader;
import com.auction.init.SeleniumInit;

public class Categories extends SeleniumInit {

	Common common = new Common(driver);
	ConfigFileReader configFileReader= new ConfigFileReader();
	// 1
	@Test
	public void Add_New_Category_With_Valid_Details() throws InterruptedException, AWTException {

		String cat = common.generateRandomChars(4);
		
		driver.get(configFileReader.getdev_auctionUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.Add_New_Category_With_Valid_Details(cat);

	}
	// 2
	@Test
	public void Add_New_Category_Without_Category_Name() throws InterruptedException, AWTException {

		driver.get(configFileReader.getdev_auctionUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.Add_New_Category_Without_Category_Name();

	}

	// 3
	@Test
	public void Add_New_Sub_Category_Under_The_Parent_Category() throws InterruptedException, AWTException, ParseException {
		
		driver.get(configFileReader.getdev_auctionUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		
		adminDashboardPage.delete_Existing_Parent_Category();
	    adminDashboardPage.add_New_Category_With_Parent_Name();
		adminDashboardPage.add_New_Sub_Category_Under_The_Parent_Category();

	}

	// 4
	@Test
	public void Edit_And_Save_Category() throws InterruptedException, AWTException {

		driver.get(configFileReader.getdev_auctionUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.Edit_And_Save_Category();

	}

	// 5
	@Test
	public void Delete_Added_Category() throws InterruptedException, AWTException {

		driver.get(configFileReader.getdev_auctionUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.Delete_Added_Category();

	}

	// 6
	@Test
	public void Add_New_Sub_Category_In_Already_Added_Category() throws InterruptedException, AWTException {

		driver.get(configFileReader.getdev_auctionUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.Add_New_Sub_Category_In_Already_Added_Category();

	}

	// 7
	@Test
	public void Delete_Added_Sub_Category_Under_The_Parent_Category() throws InterruptedException, AWTException {

		driver.get(configFileReader.getdev_auctionUrl());
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.Delete_Added_Sub_Category_Under_The_Parent_Category();

	}

}