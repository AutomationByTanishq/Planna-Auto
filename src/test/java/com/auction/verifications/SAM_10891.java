package com.auction.verifications;

import java.awt.AWTException;
import java.text.ParseException;

import org.testng.annotations.Test;

import com.auction.init.Common;
import com.auction.init.ConfigFileReader;
import com.auction.init.SeleniumInit;
import com.auction.pages.LoginPage;

public class SAM_10891 extends SeleniumInit { 
		// String saleno = null;
		// String auctionName = null;
		String lotName = null;
		String uName = null;
		String bidder2 = "rahulbid";
		String bidder2Pass = "123123a";
		Common common = new Common(driver);
		ConfigFileReader configFileReader = new ConfigFileReader();

		// 1
		
		@Test
		public void Login_from_homepage_10891() throws InterruptedException, ParseException, AWTException {

			driver.get(configFileReader.getdev_auctionUrl()); // Admin URL
			adminDashboardPage = indexPage // Admin Signin
					.adminSignin("admin", "123123");
			adminDashboardPage.set_Maxium_Stored_Searches();
			
			adminDashboardPage.front();
			loginPage=new LoginPage(driver);
			//driver.get(configFileReader.getFrontUrl());
			driver.get(configFileReader.getdevUrl());
			loginPage.Login_page_elemenets();
			
		}
	
}
