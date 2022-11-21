package com.auction.verifications;

import java.awt.AWTException;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.auction.init.Common;
import com.auction.init.ConfigFileReader;
import com.auction.init.SeleniumInit;

public class SAM_10223 extends SeleniumInit {

	// String saleno = null;
	// String auctionName = null;
	String lotName = null;
	String uName = null;
	String bidder2 = "rahulbid";
	String bidder2Pass = "123123a";
	Common common = new Common(driver);

	ConfigFileReader configFileReader = new ConfigFileReader();

	/**
	 * 1 Verify Create_nginx_redirect_rules_10388
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Create_nginx_redirect_rules_10388(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		System.out.println("TC: SAM-10388");
		common.log("TC: SAM-10388");
		driver.get(configFileReader.getdevUrl()); // Admin URL
		driver.get(configFileReader.getdevUrl() + "m/access-error");
		common.pause(5);

		String url = driver.getCurrentUrl();
		System.out.println("URL:" + url);
		common.log("URL: " + url);

		String str = driver.findElement(By.xpath("//div[contains(text(),'have permission to access this page')]"))
				.getText();

		System.out.println("Message display: " + str);
		common.log("Message display: " + str);
	}

	/**
	 * 2 Verify Create_nginx_redirect_rules_10389
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Create_nginx_redirect_rules_10389(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		System.out.println("TC: SAM-10389");
		common.log("TC: SAM-10389");
		driver.get(configFileReader.getdevUrl()); // Admin URL
		driver.get(configFileReader.getdevUrl() + "m/forgot-password");
		common.pause(5);

		String url = driver.getCurrentUrl();
		System.out.println("URL:" + url);
		common.log("URL: " + url);

		String str = driver.findElement(By.xpath("//span[contains(text(),'Forgot password?')]")).getText();
		System.out.println("Page display: " + str);
		common.log("Page display: " + str);
	}

	/**
	 * 3 Verify Create_nginx_redirect_rules_10390
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Create_nginx_redirect_rules_10390(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		System.out.println("TC: SAM-10390");
		common.log("TC: SAM-10390");
		driver.get(configFileReader.getdevUrl()); // Admin URL
		driver.get(configFileReader.getdevUrl() + "m/forgot-username");
		common.pause(5);

		String url = driver.getCurrentUrl();
		System.out.println("URL:" + url);
		common.log("URL: " + url);

		String str = driver.findElement(By.xpath("//span[contains(text(),'Forgot username?')]")).getText();
		System.out.println("Page display: " + str);
		common.log("Page display: " + str);
	}

	/**
	 * 4 Verify Create_nginx_redirect_rules_10390
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Create_nginx_redirect_rules_10391(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		System.out.println("TC: SAM-10391");
		common.log("TC: SAM-10391");
		driver.get(configFileReader.getdevUrl()); // Admin URL
		driver.get(configFileReader.getdevUrl() + "m/index");
		common.pause(5);

		String url = driver.getCurrentUrl();
		System.out.println("URL:" + url);
		common.log("URL: " + url);

		String str = driver.findElement(By.xpath("//span[contains(text(),'Auctions')]")).getText();
		System.out.println("Page display: " + str);
		common.log("Page display: " + str);
	}

	/**
	 * 5 Verify Create_nginx_redirect_rules_10392
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Create_nginx_redirect_rules_10392(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		System.out.println("TC: SAM-10392");
		common.log("TC: SAM-10392");
		driver.get(configFileReader.getdevUrl()); // Admin URL
		driver.get(configFileReader.getdevUrl() + "m/login");
		common.pause(5);

		String url = driver.getCurrentUrl();
		System.out.println("URL:" + url);
		common.log("URL: " + url);

		String str = driver.findElement(By.xpath("//h2[contains(text(),'Sign in')]")).getText();
		System.out.println("Page display: " + str);
		common.log("Page display: " + str);
	}

	/**
	 * 6 Verify Create_nginx_redirect_rules_10393
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Create_nginx_redirect_rules_10393(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		System.out.println("TC: SAM-10393");
		common.log("TC: SAM-10393");
		driver.get(configFileReader.getdevUrl()); // Admin URL
		driver.get(configFileReader.getdevUrl() + "m/logout");
		common.pause(5);

		String url = driver.getCurrentUrl();
		System.out.println("URL:" + url);
		common.log("URL: " + url);

		String str = driver.findElement(By.xpath("//h2[contains(text(),'Sign in')]")).getText();
		System.out.println("Page display: " + str);
		common.log("Page display: " + str);
	}

	// 7
	@Test(dataProvider = "missedliveauction")
	public void Create_nginx_redirect_rules_10395(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		System.out.println("TC: SAM-10395");
		common.log("TC: SAM-10395");

		driver.get(configFileReader.getdevUrl());
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("admin", "123123");

		dashboardPage.Verify_My_Alerts_Page();

	}

	// 8
	@Test(dataProvider = "missedliveauction")
	public void Create_nginx_redirect_rules_10396(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		System.out.println("TC: SAM-10396");
		common.log("TC: SAM-10396");	

		driver.get(configFileReader.getdevUrl());
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("admin", "123123");

		common.pause(20);
		System.out.println("Click on Invoices");
		common.log("Click on Invoices");
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();

		String str = driver.findElement(By.xpath("//h2[contains(text(),'Invoices')]")).getText();
		System.out.println("Page display: " + str);
		common.log("Page display: " + str);

	}

	// 9
	@Test(dataProvider = "missedliveauction")
	public void Create_nginx_redirect_rules_10397(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		System.out.println("TC: SAM-10397");
		common.log("TC: SAM-10397");

		driver.get(configFileReader.getdevUrl());
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("admin", "123123");

		common.waitForElement(By.xpath("//a[contains(text(),'My Items')]"));

		System.out.println("Click on My Items");
		common.log("Click on My Items");
		driver.findElement(By.xpath("//a[contains(text(),'My Items')]")).click();

		String str = driver.findElement(By.xpath(
				"//li[@class='tabnav-tab tab-my-items-bidding selected']//a[text()='Bidding on']"))
				.getText();
		System.out.println("Page display: " + str);
		common.log("Page display: " + str);

	}

	// 10
	@Test(dataProvider = "missedliveauction")
	public void Create_nginx_redirect_rules_10398(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		System.out.println("TC: SAM-10398");
		common.log("TC: SAM-10398");

		driver.get(configFileReader.getdevUrl());
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("admin", "123123");

		common.pause(20);

		System.out.println("Click on My Settlements");
		common.log("Click on My Settlements");
		driver.get(configFileReader.getdevUrl() + "m/my-settlements");

		String str = driver.findElement(By.xpath("//h2[contains(text(),'Settlements')]")).getText();
		System.out.println("Page display: " + str);
		common.log("Page display: " + str);

	}

	/**
	 * 11 Verify Create_nginx_redirect_rules_10399
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Create_nginx_redirect_rules_10399(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		System.out.println("TC: SAM-10399");
		common.log("TC: SAM-10393");
		driver.get(configFileReader.getdevUrl()); // Admin URL
		driver.get(configFileReader.getdevUrl() + "m/notifications");
		common.pause(5);

		String url = driver.getCurrentUrl();
		System.out.println("URL:" + url);
		common.log("URL: " + url);

		String str = driver.findElement(By.xpath("//a[contains(text(),'Continue')]")).getText();
		System.out.println("Page display: " + str);
		common.log("Page display: " + str);
	}

	// 12
	@Test(dataProvider = "missedliveauction")
	public void Create_nginx_redirect_rules_10401(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		System.out.println("TC: SAM-10401");
		common.log("TC: SAM-10401");

		driver.get(configFileReader.getdevUrl());
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("admin", "123123");

		common.pause(20);
		System.out.println("Click on Profile");
		common.log("Click on Profile");
		driver.get(configFileReader.getdevUrl() + "m/profile");

		String str = driver.findElement(By.xpath("//a[contains(text(),'Profile')]")).getText();
		System.out.println("Page display: " + str);
		common.log("Page display: " + str);

	}

	/**
	 * 13 Verify Create_nginx_redirect_rules_10402
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Create_nginx_redirect_rules_10402(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		System.out.println("TC: SAM-10402");
		common.log("TC: SAM-10402");
		driver.get(configFileReader.getdevUrl()); // Admin URL
		driver.get(configFileReader.getdevUrl() + "m/register");
		common.pause(5);

		String url = driver.getCurrentUrl();
		System.out.println("URL:" + url);
		common.log("URL: " + url);

		String str = driver.findElement(By.xpath("//h2[contains(text(),'Signup')]")).getText();
		System.out.println("Page display: " + str);
		common.log("Page display: " + str);
	}

	// 14
	@Test(dataProvider = "missedliveauction")
	public void Create_nginx_redirect_rules_10404(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		System.out.println("TC: SAM-10404");
		common.log("TC: SAM-10404");

		driver.get(configFileReader.getdevUrl());
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("admin", "123123");

		common.pause(20);
		System.out.println("Click on Reset Password");
		common.log("Click on Reset Password");
		driver.get(configFileReader.getdevUrl() + "m/reset-password");

		String str = driver.findElement(By.xpath("//span[@class='title']"))
				.getText();
		System.out.println("Page display: " + str);
		common.log("Page display: " + str);

	}

	/**
	 * 15 Verify Create_nginx_redirect_rules_10405
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Create_nginx_redirect_rules_10405(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		System.out.println("TC: SAM-10405");
		common.log("TC: SAM-10405");
		driver.get(configFileReader.getdevUrl()); // Admin URL
		driver.get(configFileReader.getdevUrl() + "m/search");
		common.pause(5);

		String url = driver.getCurrentUrl();
		System.out.println("URL:" + url);
		common.log("URL: " + url);

		String str = driver.findElement(By.xpath("//label[contains(text(),'Sort by')]")).getText();
		System.out.println("Page display: " + str);
		common.log("Page display: " + str);
	}

	// 16
	@Test(dataProvider = "missedliveauction")
	public void Create_nginx_redirect_rules_10408(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		System.out.println("TC: SAM-10408");
		common.log("TC: SAM-10408");

		driver.get(configFileReader.getdevUrl());
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser("admin", "123123");

		common.pause(20);
		System.out.println("Click on Watchlist");
		common.log("Click on Watchlist");
		driver.get(configFileReader.getdevUrl() + "m/watchlist");

		String str = driver
				.findElement(
						By.xpath("//li[@class='tabnav-tab tab-my-items-watchlist selected']//a[text()='Watchlist']"))
				.getText();
		System.out.println("Page display: " + str);
		common.log("Page display: " + str);

	}

	/**
	 * 17 Verify Create_nginx_redirect_rules_10409
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Create_nginx_redirect_rules_10409(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		System.out.println("TC: SAM-10409");
		common.log("TC: SAM-10409");
		driver.get(configFileReader.getdevUrl()); // Admin URL
		driver.get(configFileReader.getdevUrl() + "view-auctions/individual-lots");
		common.pause(5);

		String url = driver.getCurrentUrl();
		System.out.println("URL:" + url);
		common.log("URL: " + url);

		String str = driver.findElement(By.xpath("//label[contains(text(),'Sort by')]")).getText();
		System.out.println("Page display: " + str);
		common.log("Page display: " + str);
	}

	/**
	 * 18 Verify Create_nginx_redirect_rules_10410
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Create_nginx_redirect_rules_10410(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		System.out.println("TC: SAM-10410");
		common.log("TC: SAM-10410");
		driver.get(configFileReader.getdevUrl()); // Admin URL
		driver.get(configFileReader.getdevUrl() + "view-auctions");
		common.pause(5);

		String url = driver.getCurrentUrl();
		System.out.println("URL:" + url);
		common.log("URL: " + url);

		String str = driver.findElement(By.xpath("//span[contains(text(),'Show')]")).getText();
		System.out.println("Page display: " + str);
		common.log("Page display: " + str);
	}

	/**
	 * 19 Verify Create_nginx_redirect_rules_10411
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Create_nginx_redirect_rules_10411(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		System.out.println("TC: SAM-10411");
		common.log("TC: SAM-10411");
		driver.get(configFileReader.getdevUrl()); // Admin URL
		driver.get(configFileReader.getdevUrl() + "view-auctions/catalog/id/4179/lot/256853");
		common.pause(5);

		String url = driver.getCurrentUrl();
		System.out.println("URL:" + url);
		common.log("URL: " + url);

		String str = driver.findElement(By.xpath("//a[contains(text(),'Catalog')]")).getText();
		System.out.println("Page display: " + str);
		common.log("Page display: " + str);
	}

	/**
	 * 20 Verify Create_nginx_redirect_rules_10411
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Create_nginx_redirect_rules_10400(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		System.out.println("TC: SAM-10400");
		common.log("TC: SAM-10400");
		driver.get(configFileReader.getdevUrl()); // Admin URL
		driver.get(configFileReader.getdevUrl() + "m/other-lots/items");
		common.pause(5);

		String url = driver.getCurrentUrl();
		System.out.println("URL:" + url);
		common.log("URL: " + url);

		String str = driver.findElement(By.xpath("//body")).getText();
		System.out.println("Page display: " + str);
		common.log("Page display: " + str);
	}

	/**
	 * 21 Verify Create_nginx_redirect_rules_10407
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Create_nginx_redirect_rules_10407(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		System.out.println("TC: SAM-10407");
		common.log("TC: SAM-10407");
		driver.get(configFileReader.getdevUrl()); // Admin URL
		driver.get(configFileReader.getdevUrl() + "m/signup");
		common.pause(5);

		String url = driver.getCurrentUrl();
		System.out.println("URL:" + url);
		common.log("URL: " + url);

		String str = driver.findElement(By.xpath("//h2[contains(text(),'Signup')]")).getText();
		System.out.println("Page display: " + str);
		common.log("Page display: " + str);
	}

	/**
	 * 22 Verify Create_nginx_redirect_rules_10394
	 * 
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	@Test(dataProvider = "missedliveauction")
	public void Create_nginx_redirect_rules_10394(String adminUserName, String adminPassword, String Name)
			throws InterruptedException, ParseException {

		System.out.println("TC: SAM-10394");
		common.log("TC: SAM-10394");
		driver.get(configFileReader.getdevUrl()); // Admin URL
		driver.get(configFileReader.getdevUrl() + "m/lot-details");
		common.pause(5);

		String url = driver.getCurrentUrl();
		System.out.println("URL:" + url);
		common.log("URL: " + url);

		String str = driver.findElement(By.xpath("//a[contains(text(),'Go to the homepage')]")).getText();
		System.out.println("Page display: " + str);
		common.log("Page display: " + str);
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
}
