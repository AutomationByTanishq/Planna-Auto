package com.auction.verifications;

import java.awt.AWTException;
import java.text.ParseException;
import java.util.jar.Attributes.Name;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.auction.init.Common;
import com.auction.init.ConfigFileReader;
import com.auction.init.SeleniumInit;
import com.auction.pages.DashboardPage;

public class SAM_7660 extends SeleniumInit {

	// String saleno = null;
	// String auctionName = null;
	String lotName = null;
	String uName = null;
	String bidder2 = "rahulbid";
	String bidder2Pass = "123123a";
	Common common = new Common(driver);
	ConfigFileReader configFileReader= new ConfigFileReader();
	/**
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Printable_view_of_Settlement_at_admin_side_8489(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-8489");
		common.log("TC: SAM-8489");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Verify_Printable_view_of_Settlement_at_admin_side();


	}
	/**
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Multiple_Printable_view_of_Settlement_at_admin_side_8490(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-8490");
		common.log("TC: SAM-8490");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Verify_Multiple_Printable_view_of_Settlement_at_admin_side();

	}
	
	/**
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Printable_view_of_Settlement_at_Frontend_8491(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-8491");
		common.log("TC: SAM-8491");

		driver.get(configFileReader.getFrontUrl());
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("rahulqa", "123123a");

		dashboardPage.Verify_Printable_view_of_Settlement_at_Frontend();
		
		
	}
	/**
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Settlement_View_received_at_Email_8492(String adminUserName, String adminPassword, String UName, String password)
			throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-8492");
		common.log("TC: SAM-8492");

		driver.get(configFileReader.getAdminUrl()); // Admin URL
		adminDashboardPage = indexPage // Admin Signin
				.adminSignin(adminUserName, adminPassword);
		adminDashboardPage.Verify_Settlement_View_received_at_Email();
		
		// Next scenario to check mail regrding sent settlement chcked manually and its working fine


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

