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

public class SAM_7672 extends SeleniumInit {

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
	public void Limit_request_routes_that_will_invoke_the_application_8641(String adminUserName, String adminPassword,
			String UName, String password) throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-8641");
		common.log("TC: SAM-8641");

		System.out.println("Enter invalid link for dev-3-4");
		common.log("Enter invalid link for dev-3-4");
		driver.get(configFileReader.getdev3_4Url()+"/not/found");

		String str = driver.findElement(By.xpath("//body//center//h1")).getText();
		System.out.println("Error display:\n" + str);
		common.log("Error display:\n" + str);

	}

	/**
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Limit_request_routes_that_will_invoke_the_application_8644(String adminUserName, String adminPassword,
			String UName, String password) throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-8644");
		common.log("TC: SAM-8644");

		System.out.println("Enter link for dev-3-4");
		common.log("Enter link for dev-3-4");
		driver.get(configFileReader.getdev3_4Url());
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("admin", "123123");
		
		driver.get(configFileReader.getdev3_4Url()+"id/auctions/catalog/id/14/well");
		String str = driver.findElement(By.xpath("//body//center//h1")).getText();
		System.out.println("Error display:\n" + str);
		common.log("Error display:\n" + str);

	}
	/**
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "createauction")
	public void Limit_request_routes_that_will_invoke_the_application_8645(String adminUserName, String adminPassword,
			String UName, String password) throws InterruptedException, ParseException, AWTException {

		System.out.println("TC: SAM-8645");
		common.log("TC: SAM-8645");

		System.out.println("Enter invalid link for dev-3-4");
		common.log("Enter invalid link for dev-3-4");
		driver.get(configFileReader.getdev3_4Url());
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("admin", "123123");
		
		driver.get(configFileReader.getdev3_4Url()+"my-invoices/view/id/idddd/410");
		common.pause(10);
		String str = driver.findElement(By.xpath("//body//h1")).getText();
		System.out.println("Error display:\n" + str);
		common.log("Error display:\n" + str);

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
