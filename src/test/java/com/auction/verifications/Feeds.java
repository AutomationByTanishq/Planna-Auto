package com.auction.verifications;

import java.awt.AWTException;

import org.testng.annotations.Test;

import com.auction.init.Common;
import com.auction.init.ConfigFileReader;
import com.auction.init.SeleniumInit;

public class Feeds extends SeleniumInit {

	Common common = new Common(driver);
	ConfigFileReader configFileReader= new ConfigFileReader();
	// 1
	@Test
	public void add_New_Feed_With_Valid_Details() throws InterruptedException, AWTException {

		
		driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
		common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.add_New_Feed_With_Valid_Details();

	}

	// 2
	@Test
	public void add_New_Feed_Without_Entering_Feed_Name() throws InterruptedException, AWTException {

			driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
			common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.add_New_Feed_Without_Entering_Feed_Name();

	}

	// 3
	@Test
	public void add_New_Feed_Without_Entering_Slug() throws InterruptedException, AWTException {

			driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
			common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.add_New_Feed_Without_Entering_Slug_Name();

	}

	// 4
	@Test
	public void add_New_Feed_With_Add_More_Custom_Replacements_Field() throws InterruptedException, AWTException {

			driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
			common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.add_New_Feed_With_Add_More_Custom_Replacements_Field();

	}

	// 5
	@Test
	public void edit_And_Save_Already_Added_Feed() throws InterruptedException, AWTException {

			driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
			common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.edit_And_Save_Feed();

	}

	// 6
	@Test
	public void delete_Feed() throws InterruptedException, AWTException {

			driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
			common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.delete_Added_Feed();

	}

	// 7
	@Test
	public void edit_And_Save_Added_Custom_Replacements_Feed() throws InterruptedException, AWTException {

			driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
			common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.edit_And_Save_Custom_Replacement_Field();

	}

	// 8
	@Test
	public void delete_Added_Custom_Replacements_Feed() throws InterruptedException, AWTException {

			driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
			common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.delete_Custom_Replacement_Field();

	}

	// 9
	@Test
	public void add_Feed_With_Entering_Alphabetical_Values_In_Items_per_page_Field()
			throws InterruptedException, AWTException {

			driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
			common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.add_Feed_With_Alphabetical_Values_In_Items_per_page_Field();

	}

	// 10
	@Test
	public void try_To_Add_New_Custom_Replacement_Field_With_Same_Value() throws InterruptedException, AWTException {

			driver.get(configFileReader.getqa_MainAutoAdmin());  // Admin URL
			common.installation_URL();
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin("admin", "123123");
		adminDashboardPage.try_To_Add_Custom_Replacement_Field_With_Same_Value();

	}
}