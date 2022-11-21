package com.auction.pages;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.Desktop.Action;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.awt.Robot;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.auction.init.Common;
import com.auction.init.ConfigFileReader;
import com.auction.pages.auctionregistration.AbstractPage;
//import com.relevantcodes.extentreports.LogStatus;

public class DashboardPage extends AbstractPage {

	Common common = new Common(driver);
	private String TimedAuction;

	ConfigFileReader configFileReader = new ConfigFileReader();

	/**
	 * Constructor
	 * 
	 * @param Dashboard driver
	 * @throws AWTException
	 */
	public DashboardPage(WebDriver driver) {
		super(driver);
	}

	/**
	 * Verify Login Page Elements
	 * 
	 */
	public void verifyLoginPageElements() {

		common.log("<br></br> Step 3 : Verify Login Page Elements.");
		common.waitForConditionIsElementPresent("//input[@id='" + LEGACY_ADMIN_SIGNIN_TXT_USERNAME + "']");

		common.log("<br></br>Step :: Verify Usernsme Text,");
		common.assertElementPresent("//div[text()='" + LEGACY_FRONT_LOGIN_LBL_USERNAME + "']");

		common.log("<br></br>Step :: Verify Password,");
		common.assertElementPresent("//div[text()='" + LEGACY_FRONT_LOGIN_LBL_PASSWORD + "']");

		common.log("<br></br>Step :: Verify Not a Member text,");
		common.assertElementPresent("//h1[text()='" + LEGACY_FRONT_LOGIN_LBL_NOT_A_MEMBER_YET + "']");

		common.log("<br></br>Step :: Verify Auctions text,");
		common.assertElementPresent("//span[text()='" + LEGACY_FRONT_LOGIN_TXT_AUCTIONS + "']");

		common.log("<br></br>Step :: Verify My Items text,");
		common.assertElementPresent("//span[text()='" + LEGACY_FRONT_LOGIN_TXT_ITEMS + "']");

		common.log("<br></br>Step :: Verify My Alerts text,");
		common.assertElementPresent("//span[text()='" + LEGACY_FRONT_LOGIN_TXT_ALERT + "']");

		common.log("<br></br>Step :: Verify Signup text,");
		common.assertElementPresent("//a//span[text()='" + LEGACY_FRONT_LOGIN_TXT_SIGNUP + "']");

		common.log("<br></br>Step :: Verify Login text,");
		common.assertElementPresent("//span[text()='" + LEGACY_FRONT_LOGIN_TXT_LOGIN + "']");

		common.log("<br></br>Step :: Verify Forgot Password text,");
		common.assertElementPresent("//div/a[text()='" + LEGACY_FRONT_LOGIN_TXT_FORGOT_PASSWORD + "']");

		common.log("<br></br>Step :: Verify Forgot Usernam text.");
		common.assertElementPresent("//div/a[text()='" + LEGACY_FRONT_LOGIN_TXT_FORGOT_USERNAME + "']");

	}

	/**
	 * Login User
	 * 
	 */
	public void LoginUser() {

		common.waitForConditionIsElementPresent(("//input[@id='" + LEGACY_ADMIN_SIGNIN_TXT_USERNAME + "']"));
		common.type("//div[text()='Username']", "sagar1");

		common.waitForConditionIsElementPresent(("//input[@id='" + LEGACY_ADMIN_SIGNIN_TXT_PASSWORD + "']"));
		common.type("//div[text()='Username']", "123123");

		common.jsClick(submitbutton);
		common.pause(60);

	}

	/**
	 * Login User 1
	 * 
	 */

	public void LoginUser1() {

		common.waitForConditionIsElementPresent(("//input[@id='" + LEGACY_ADMIN_SIGNIN_TXT_USERNAME + "']"));
		common.type("//div[text()='" + LEGACY_FRONT_LOGIN_TXT_USERNAME1 + "']", "rahulqa");

		common.waitForConditionIsElementPresent(("//input[@id='" + LEGACY_ADMIN_SIGNIN_TXT_PASSWORD + "']"));
		common.type("//div[text()='" + LEGACY_FRONT_LOGIN_TXT_USERNAME1 + "']", "123123");

		common.jsClick(submitbutton);
		common.pause(60);

	}

	/**
	 * Register To Bid
	 * 
	 * @param saleno
	 * @param auctionName
	 * @throws InterruptedException
	 */
	public void RegisterToBid(String saleno, String auctionName) throws InterruptedException {

		common.waitForConditionIsElementPresent("//a[text()='" + LEGACY_FRONT_LOGIN_TXT_AUCTIONS + "']");
		common.jsClick(AuctionMenu);

		System.out.println("Step :: Select Live Auction From Dropdown");
		common.log("<br></br> Step :: Select Live Auction From Dropdown");
		common.waitForElement("//select[@id ='" + LEGACY_ADMIN_LST_AUCTION_LIST + "']");
		common.select("//select[@id ='" + LEGACY_ADMIN_LST_AUCTION_LIST + "']", LEGACY_ADMIN_LST_AUCTION_LIST_LIVE); // select
																														// live

		System.out.println("Step :: Select Auctioneers Sagar From Dropdown");
		common.log("<br></br> Step :: Select Auctioneers Sagar From Dropdown");
		common.waitForElement("//select[@id ='" + LEGACY_ADMIN_LST_INPUT_AUCTIONEER + "']");
		common.select("//select[@id ='" + LEGACY_ADMIN_LST_INPUT_AUCTIONEER + "']",
				LEGACY_ADMIN_LST_INPUT_AUCTIONEER_NAME);// select
														// auctioneer
		// sagar

		System.out.println("Step :: Select 100 From Page dropdown");
		common.log("<br></br> Step :: Select 100 From Page Dropdown");
		common.select("//select[@id='" + LEGACY_ADMIN_LST_ITEMS_PER_PAGE + "']", "100");

		// common.waitForElement("//input[@value='Register to bid!']");

		if (common.isElementPresent("//table//td//a[text()='" + auctionName + "']")) {
			System.out.println("auction " + auctionName + " is present in this page");
			driver.findElement(By.xpath("//table//td//a[text()='" + auctionName + "']/../..//input[@value='"
					+ LEGACY_USER_BTN_REGISTER_BID + "']")).click();
			common.pause(10);

		} else {
			System.out.println("auction " + auctionName + " is not  present in this page");

			driver.findElement(By.xpath("//span[@id='" + LEGACY_ADMIN_PAGE_PAGINATION_WARNING_MESSAGE + "']//a[text()='"
					+ LEGACY_USER_BTN_NEXT + "']")).click();

			common.pause(10);

			if (common.isElementPresent("//table//td//a[text()='" + auctionName + "']")) {
				System.out.println("auction " + auctionName + " is present in this page");
				driver.findElement(By.xpath("//table//td//a[text()='" + auctionName + "']/../..//input[@value='"
						+ LEGACY_USER_BTN_REGISTER_BID + "']")).click();
				common.pause(15);

			} else {
				System.out.println("auction " + auctionName + " is not  present in this page");

				driver.findElement(By.xpath("//span[@id='" + LEGACY_ADMIN_PAGE_PAGINATION_WARNING_MESSAGE
						+ "']//a[text()='" + LEGACY_USER_BTN_NEXT + "']")).click();

				System.out.println("auction " + auctionName + " is present in this page");
				driver.findElement(By.xpath("//table//td//a[text()='" + auctionName + "']/../..//input[@value='"
						+ LEGACY_USER_BTN_REGISTER_BID + "']")).click();
				common.pause(5);
			}

		}

		System.out.println("Step :: Click on Register to Bid !");
		common.waitForElement("//ul[@id='" + LEGACY_USER_SIGNUP_MESSAGES_VALUE + "']");
		System.out.println("Step :: Verify Success Message");
		common.log("<br></br> Step :: Verify Success Message");
		common.assertElementPresent("//ul[@id='" + LEGACY_USER_SIGNUP_MESSAGES_VALUE + "']");
		common.jsClick(logout);

	}

	/**
	 * Live Sale Tab
	 * 
	 * @param saleno
	 * @param auctionName
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	public void LiveSaletab(String saleno, String auctionName) throws InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale(auctionName); // Goto catalog Page

		System.out.println("Step :: Click on catalog button");

		common.pause(10);

		driver.findElement(By.xpath("//input[@value='" + LEGACY_USER_TXT_LIVE_SALE + "']")).click();

		driver.findElement(By.xpath(
				"//div[@class='" + LEGACY_ADMIN_LOTS_BIDDING + "']//..//button[@value='" + LEGACY_ADMIN_BIDDING + "']"))
				.click();

		common.jsClick(logout);
	}

	/**
	 * view Watch List At Catalog Page Place Bid Amount Lower than starting
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param lotName
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public void place_Bid_Value_Lower_Than_Starting(String saleno, String auctionName, String lotName)
			throws AWTException, InterruptedException {

		goto_Catalog_Page_Live_Sale(auctionName);
		common.pause(20);

		System.out.println("Step :: Fill Place bid value");
		common.log("<br></br> Step :: Fill Place  bid value");
		// driver.findElement(By.xpath("//h2//a[text()='" + lotName +
		// "']//..//..//..//input[@class='"
		// + LEGACY_USER_TXT_REGULAR_LIVE_BID + "']")).clear();
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_REGULAR_LIVE_BID + "']")).sendKeys("50");

		System.out.println("Step :: Click on Placebid Button");
		common.log("<br></br> Step :: Click on Placebid Button");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']"))
				.click();
		common.pause(15);

		System.out.println("Step :: Verify Error Message");
		common.log("<br></br> Step :: Verify Error Message");
		String bidnotmet = driver.findElement(By.xpath("//span[text()='" + LEGACY_USER_STARTING_BID_NOT_MET + "']"))
				.getText();
		System.out.println("Step :: Verify Error Message >> " + bidnotmet);
		common.pause(15);

	}

	/**
	 * View Watch List At Catalog Page Place Bid With No Value
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param lotName
	 * @throws AWTException
	 */
	public void place_Bid_With_No_Value(String saleno, String auctionName, String lotName) throws AWTException {

		goto_Catalog_Page_Live_Sale(auctionName); // Goto catalog page on live
													// sale
		common.pause(20);
		System.out.println("Step :: Fill Place bid value");
		common.log("<br></br> Step :: Fill Place  bid value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_REGULAR_LIVE_BID + "']")).sendKeys(" ");

		System.out.println("Step :: Click on Placebid Button");
		common.log("<br></br> Step :: Click on Placebid Button");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']"))
				.click();
		common.pause(15);

		System.out.println("Step :: Verify Error Message");
		common.log("<br></br> Step :: Verify Error Message");
		String errormsg = driver.findElement(By.xpath("//div[@class='" + LEGACY_REGULAR_BID_ERROR + "']")).getText();
		System.out.println("Step :: Verify Error Message >> " + errormsg);
		common.pause(15);

	}

	/**
	 * Place Bid From Catalog
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param lotName
	 * @throws AWTException
	 */
	public void placeBidFromCatalog(String saleno, String auctionName, String lotName) throws AWTException {

		goto_Catalog_Page_Live_Sale(auctionName); // Goto catalog Page
		common.pause(20);

		System.out.println("Step :: Fill Place bid value");
		common.log("<br></br> Step :: Fill Place  bid value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_REGULAR_LIVE_BID + "']")).sendKeys("200");

		System.out.println("Step :: Click on Placebid Button");
		common.log("<br></br> Step :: Click on Placebid Button");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']"))
				.click();
		common.pause(15);
		common.acceptAlert();

		// common.log("<br></br> Step :: Click on confirm button");
		// System.out.println("Step :: Click on confirm button");
		// driver.findElement(By.xpath("//input[@value='" +
		// LEGACY_USER_BTN_CONFIRM + "']")).click();
		common.pause(10);

		common.log("<br></br> Step :: Click on Logout Button");
		System.out.println("Step :: Click on Logout Button");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_FRONT_LOGIN_TXT_LOGOUT + "']")).click(); // Click
		// on
		// logout
	}

	public void placeBidFromCatalog1(String saleno, String auctionName, String lotName)
			throws AWTException, InterruptedException {

		goto_Catalog_Page_Live_Sale_Auction(auctionName); // Goto catalog Page
		common.pause(15);
		System.out.println("Step :: Fill Place bid value");
		common.log("<br></br> Step :: Fill Place  bid value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_REGULAR_LIVE_BID + "']")).sendKeys("300");

		System.out.println("Step :: Click on Placebid Button");
		common.log("<br></br> Step :: Click on Placebid Button");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']"))
				.click();
		common.pause(15);

		// common.log("<br></br> Step :: Click on confirm button");
		// System.out.println("Step :: Click on confirm button");
		// driver.findElement(By.xpath("//input[@value='" +
		// LEGACY_USER_BTN_CONFIRM + "']")).click();
		// common.pause(10);

		common.acceptAlert();
		common.pause(10);

		common.log("<br></br> Step :: Click on Logout Button");
		System.out.println("Step :: Click on Logout Button");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_ADMIN_LNK_LOGOUT + "']")).click(); // Click
		// on
		// logout
	}

	/**
	 * Place bid from catalog Bid Amount with Already Entered
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param lotName
	 * @throws AWTException
	 */
	public void place_Bid_Already_Amount(String saleno, String auctionName, String lotName) throws AWTException {

		goto_Catalog_Page_Live_Sale(auctionName); // goto catalog page
		common.pause(20);
		System.out.println("Step :: Fill Place bid value");
		common.log("<br></br> Step :: Fill Place  bid value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_REGULAR_LIVE_BID + "']")).sendKeys("200");

		System.out.println("Step :: Click on Placebid Button");
		common.log("<br></br> Step :: Click on Placebid Button");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']"))
				.click();
		common.pause(20);
		common.acceptAlert();

		// common.log("<br></br> Step :: Click on confirm button");
		// System.out.println("Step :: Click on confirm button");
		// driver.findElement(By.xpath("//input[@id='" +
		// LEGACY_USER_BTN_PLACE_MULTIBID_CONFIRM + "']")).click();
		// common.pause(15);

		common.pause(30);
		System.out.println("Step :: Click on Change Bid Button");
		common.log("<br></br> Step :: Click on Change Bid Button");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//input[@value='" + LEGACY_USER_BTN_CHANGE_BID + "']"))
				.click();
		common.pause(20);

		System.out.println("Step :: Verify Error Message");
		common.log("<br></br> Step :: Verify Error Message");
		String errormsg = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_SIGNUP_TXT_WARNING_MESSAGE + "']")).getText();
		System.out.println("Step :: Verify Error Message >> " + errormsg);
		common.pause(15);

	}

	/**
	 * Verify Place Multiple Bids
	 * 
	 * @param auctionName
	 * @param lotName
	 * @throws AWTException
	 */
	public void verifyPlaceMultipleBids(String auctionName, String lotName) throws AWTException {

		goto_Catalog_Page_Live_Sale(auctionName); // Goto catalog page

		common.waitForConditionIsElementPresent("//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']");

		System.out.println("Step :: Click on Placebid Button");
		common.log("<br></br> Step :: Click on Placebid Button");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']"))
				.click();
		common.pause(20);

		// System.out.println("Step :: Click on follow button");
		// common.log("<br></br> Step :: Click on follow button");
		// driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_FOLLOW +
		// "']")).click();

	}

	/**
	 * Verify Place Multiple Bid with less than starting bid amount in catalog page
	 * 
	 * @throws AWTException
	 * 
	 */
	public void verifyPlaceMultipleBidWithLessThanStartingBidAmountInCatalogPage(String lotName, String auctionName)
			throws AWTException {

		goto_Catalog_Page_Live_Sale(auctionName); // Goto catalog page livesale

		common.type("//a[text()='" + lotName + "']//..//..//..//div[@class='regular-bid']//input[@type='text']", "20");
		this.driver.findElement(By.xpath("//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']")).click();
		common.pause(25);

		System.out.println("Step :: Click on follow button");
		common.log("<br></br> Step :: Click on follow button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_FOLLOW + "']")).click();
		common.pause(30);

		common.isElementPresent("//span[text()='" + LEGACY_USER_STARTING_BID_NOT_MET + "']");
		common.pause(10);
	}

	/**
	 * Verify Place Multiple Bid with less than starting bid amount in catalog page
	 * 
	 * @throws AWTException
	 * 
	 */
	public void placeBidMissingAtLotDetails(String lotName, String auctionName) throws AWTException {

		goto_Catalog_Page_Live_Sale(auctionName); // goto catalog page livesale

		common.pause(20);
		System.out.println("Step :: Click on Place Bid Button");
		common.log("<br></br> Step :: Click on Place Bid Button");
		common.isElementPresent("//a[text()='" + lotName + "']//..//..//..//div[@class='" + LEGACY_REGULAR_BID
				+ "']//input[@type='" + LEGACY_USER_BUTTON + "']");
		driver.findElement(By.xpath("//a[text()='" + lotName + "']//..//..//..//div[@class='" + LEGACY_REGULAR_BID
				+ "']//input[@type='" + LEGACY_USER_BUTTON + "']")).click();
		common.pause(30);
		common.acceptAlert();
		common.pause(80);
		driver.findElement(By.xpath("//a[text()='" + lotName + "']//..//..//..//div[@class='" + LEGACY_REGULAR_BID
				+ "']//input[@type='" + LEGACY_USER_BUTTON + "']")).click();

		System.out.println("Step :: Verify Error Message");
		common.log("<br></br> Step :: Verify Error Message");
		common.pause(30);
		String errormsg = driver
				.findElement(By.xpath("//span[text()='" + LEGACY_USER_YOU_ALREADY_BID_THAT_AMOUNT + "']")).getText();
		System.out.println("Step :: Verify Error Message >> " + errormsg);
		common.pause(10);
	}

	/**
	 * Place Bid From Lot Details
	 * 
	 * @param lotName
	 * @param auctionName
	 * @throws AWTException
	 */
	public void placeBidFromLotDetails(String auctionName, String lotName) throws AWTException {

		goto_Catalog_Page_Live_Sale_Auction(auctionName); // Goto catalog page

		common.pause(30);
		common.isElementPresent("//a[text()='" + lotName + "']//..//..//..//div[@class='" + LEGACY_REGULAR_BID
				+ "']//input[@type='" + LEGACY_USER_BUTTON + "']");

		System.out.println("Lot Name >> " + lotName);

		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']")).click();

		waitUntillElementPresent("//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']//..//..//..//..//input[@type='"
				+ LEGACY_ADMIN_TXT_LOT_PARCEL_ID_VALUE + "']");

		System.out.println("Step :: Enter Absentee bids");
		common.log("<br></br> Step :: Enter Absentee bids");
		driver.findElement(By.xpath("//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']//..//..//..//..//input[@type='"
				+ LEGACY_ADMIN_TXT_LOT_PARCEL_ID_VALUE + "']")).click();
		driver.findElement(By.xpath("//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']//..//..//..//..//input[@type='"
				+ LEGACY_ADMIN_TXT_LOT_PARCEL_ID_VALUE + "']")).sendKeys("200");

		System.out.println("Step :: Click on place bid button");
		common.log("<br></br> Step :: Click on place bid button");
		driver.findElement(By.xpath("//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']")).click();

		common.pause(15);
//		if (common.isElementPresent("//input[@id='pbloi2']")) {
//			driver.findElement(By.xpath("//input[@id='pbloi2']")).click();
//			common.pause(10);
//			driver.findElement(By.xpath("//a[@id='btnPlaceBid']")).click();
//		} else {
//
//		}
		common.jsClick(logout);
		common.pause(10);

	}

	/**
	 * Place Bid From Lot Details
	 * 
	 * @param lotName
	 * @param auctionName
	 * @throws AWTException
	 */
	public void placeBidFromLotDetails1(String auctionName, String lotName) throws AWTException {

		goto_Catalog_Page_Live_Sale_Auction(auctionName); // Goto catalog page
		common.pause(30);
		common.isElementPresent("//a[text()='" + lotName + "']//..//..//..//div[@class='" + LEGACY_REGULAR_BID
				+ "']//input[@type='" + LEGACY_USER_BUTTON + "']");

		System.out.println("Lot Name >> " + lotName);

		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']")).click();

		waitUntillElementPresent("//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']//..//..//..//..//input[@type='"
				+ LEGACY_ADMIN_TXT_LOT_PARCEL_ID_VALUE + "']");

		System.out.println("Step :: Enter Absentee bids");
		common.log("<br></br> Step :: Enter Absentee bids");
		driver.findElement(By.xpath("//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']//..//..//..//..//input[@type='"
				+ LEGACY_ADMIN_TXT_LOT_PARCEL_ID_VALUE + "']")).click();
		driver.findElement(By.xpath("//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']//..//..//..//..//input[@type='"
				+ LEGACY_ADMIN_TXT_LOT_PARCEL_ID_VALUE + "']")).sendKeys("200");

		System.out.println("Step :: Click on place bid button");
		common.log("<br></br> Step :: Click on place bid button");
		driver.findElement(By.xpath("//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']")).click();

		common.pause(30);
//		common.acceptAlert1();

		common.pause(10);
		common.jsClick(logout);

	}

	/**
	 * Confirm add lots
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param lotName
	 * @param uName
	 */

	public void ConfirmAddLots(String saleno, String auctionName, String lotName, String uName) {

		common.waitForConditionIsElementPresent("//a//span[text()='" + LEGACY_USER_CONFIRM_ADDITIONAL_LOTS + "']");

		/* Add a code for select lot with checkbox selection */

		driver.findElement(By.xpath("//button[@id='" + LEGACY_FRONT_LOGIN_BTN_CONFIRM_ADD_LOT + "']")).click();
		common.jsClick(AuctionMenu);
		common.pause(10); // The selected Lot should be Sold to Bidder 2

	}

	/**
	 * Logout Front User
	 * 
	 */

	public void logoutfrontuser() {

		common.pause(20);
		common.log("<br></br> Step :: Click on Logout Link");
		System.out.println("Step :: Click on Logout Link");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_ADMIN_LNK_LOGOUT + "']")).click();
		common.pause(25);

	}

	/**
	 * Verify Warning Message
	 * 
	 * @param saleno
	 * @param auctionName
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	public void verifyWarningMessage(String saleno, String auctionName) throws InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale_Auction(auctionName); // Goto catalog page

		System.out.println("Catalog button clicked");

		common.pause(40);
		System.out.println("Step :: Click on Live Sale link");
		common.log("<br></br>Step :: Click on Live Sale link");

		if (common.isElementPresent("//a[contains(text(),'Live Sale')]")) {
			// driver.findElement(By.xpath("//a[contains(text(),'Live Sale')]")).click();
			common.jsClick(liveSaleTab);
			common.pause(30);
		} else {
			// driver.findElement(By.xpath("//body/div[@id='wrapper']/div[1]/ol[1]/li[3]/a[1]/span[1]")).click();
			common.jsClick(liveSaleName);
			common.pause(20);
			// driver.findElement(By.xpath("//a[contains(text(),'View live sale
			// now!')]")).click();
			common.jsClick(Viewlivesalenow);
		}

		common.pause(30);

		String usermessage = driver.findElement(By.xpath("//div[@class='" + LEGACY_USER_SIGNUP_MESSAGES_VALUE + "']"))
				.getText();

		System.out.println("Step :: Message center\n :: " + usermessage);
		common.log("<br></br> Step :: Message center\n :: " + usermessage);
		common.jsClick(logout);

	}

	/**
	 * Verify lot sold message
	 * 
	 * @param saleno
	 * @param auctionName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void verifySoldLotMessage(String saleno, String auctionName) throws InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale_Auction(auctionName); // Goto catalog page
		common.pause(20);

		System.out.println("Step :: Click on Live Sale link");
		common.log("<br></br>Step :: Click on Live Sale link");

		if (common.isElementPresent("//a[contains(text(),'Live Sale')]")) {
			// driver.findElement(By.xpath("//a[contains(text(),'Live Sale')]")).click();
			common.jsClick(liveSaleTab);
			common.pause(30);
		} else {
			// driver.findElement(By.xpath("//body/div[@id='wrapper']/div[1]/ol[1]/li[3]/a[1]/span[1]")).click();
			common.jsClick(liveSaleName);
			common.pause(20);
			// driver.findElement(By.xpath("//a[contains(text(),'View live sale
			// now!')]")).click();
			common.jsClick(Viewlivesalenow);
		}

		common.pause(30);

		String usermessage = driver.findElement(By.xpath("//div[@class='" + LEGACY_USER_SIGNUP_MESSAGES_VALUE + "']"))
				.getText();

		System.out.println("Step :: Message center\n :: " + usermessage);
		common.log("<br></br> Step :: Message center\n :: " + usermessage);
		common.jsClick(logout);

	}

	/**
	 * paypal payment enable
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	public void paypalpayment_Enable() throws InterruptedException, ParseException {

		common.pause(10);
		System.out.println("Step  :: Click on Invoices");
		common.log("<br></br> Step  :: Click on Invoices");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_USER_TXT_INVOICES_FRONTEND + "']")).click();

		common.pause(25);

		System.out.println("Step :: Select Pending from dropdown menu");
		common.log("<br></br> Step :: Select Pending from dropdown menu");
		Actions actions = new Actions(driver);
		WebElement ShowDropDown = driver.findElement(By.xpath(
				"//span[@id='" + LEGACY_ADMIN_PENDING_FROM_DROPDOWN + "']//..[@role='" + LEGACY_USER_BUTTON + "']"));
		ShowDropDown.click();

		WebElement select_pending = driver.findElement(By.linkText("Pending"));
		common.pause(10);
		actions.moveToElement(select_pending);
		actions.moveToElement(select_pending).click().perform();
		common.pause(20);

		System.out.println("Step :: Click on view button");
		common.log("<br></br> Step :: Click on view button");
		driver.findElement(By.xpath("//td[text()='" + LEGACY_USER_LST_VALUE_PENDING + "']")).click();

		common.pause(25);

		System.out.println("Step :: Click on Pay Now button");
		common.log("<br></br> Step :: Click on Pay Now button");
		driver.findElement(By.xpath("//input[@value='" + LEGACY_USER_LST_VALUE_PAY_NOW + "']")).click();
		common.pause(10);
		//
		// System.out.println("Step :: Click on payvia paypal button");
		// common.log("<br></br> Step :: Click on payvia paypal button");
		// driver.findElement(By.xpath("//input[@id='login_email']")).sendKeys("sagar222@test.com");
		//
		// System.out.println("Step :: Click on payvia paypal button");
		// common.log("<br></br> Step :: Click on payvia paypal button");
		// driver.findElement(By.xpath("//input[@id='login_email']")).sendKeys("r00tr00t");
		//
		// System.out.println("Step :: Click on login button");
		// common.log("<br></br> Step :: Click on login button");
		// driver.findElement(By.xpath("//input[@id='submitLogin']")).click();
		//
		// System.out.println("Step :: Click on pay button");
		// common.log("<br></br> Step :: Click on pay button");
		// driver.findElement(By.xpath("//input[@id='continue_abovefold']")).click();
		//
		// common.assertElementPresent("//div[@class='body outer nobg
		// clearfix']");
		String Suceess_payment = driver
				.findElement(By.xpath("//section[@class='" + LEGACY_USER_SIGNUP_MESSAGE_VALUE + "']")).getText();
		System.out.println("Step :: Success Message >> " + Suceess_payment);

	}

	/**
	 * paypal payment disable
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	public void paypalpayment_Disable() throws InterruptedException, ParseException {

		System.out.println("Step  :: Click on Invoices");
		common.log("<br></br> Step  :: Click on Invoices");

		driver.findElement(By.xpath("//a[text()='" + LEGACY_USER_TXT_INVOICES_FRONTEND + "']")).click();

		System.out.println("Step :: Select Pending from dropdown menu");
		common.log("<br></br> Step :: Select Pending from dropdown menu");
		Actions actions = new Actions(driver);
		WebElement ShowDropDown = driver.findElement(By.xpath(
				"//span[@id='" + LEGACY_ADMIN_PENDING_FROM_DROPDOWN + "']//..[@role='" + LEGACY_USER_BUTTON + "']"));
		ShowDropDown.click();

		WebElement select_pending = driver.findElement(By.linkText("Pending"));
		common.pause(10);
		actions.moveToElement(select_pending);
		actions.moveToElement(select_pending).click().perform();
		common.pause(20);
		common.pause(10);

		System.out.println("Step :: Click on view button");
		common.log("<br></br> Step :: Click on view button");
		driver.findElement(By.xpath("//td[text()='" + LEGACY_USER_LST_VALUE_PENDING + "']")).click();

		common.pause(25);

		System.out.println("Step :: Click on Pay Now button");
		common.log("<br></br> Step :: Click on Pay Now button");
		driver.findElement(By.xpath("//input[@value='" + LEGACY_USER_LST_VALUE_PAY_NOW + "']")).click();
		common.pause(10);

		System.out.println("Verify billing module form");
		common.log("<br></br> Verify billing module from");
		common.assertElementPresent("//div[@id='" + LEGACY_USER_BUTTON_PAY_NOW + "']");
	}

	/**
	 * paypal buy credit
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	public void paypal_Buy_Credit() throws InterruptedException, ParseException {

		System.out.println("Step  :: Click on Profile");
		common.log("<br></br> Step  :: Click on Profie");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_USER_PROFILE_TAB + "']")).click();
		common.pause(10);

		System.out.println("Step  :: Click on buy more credit.");
		common.log("<br></br> Step  :: Click on buy more credit.");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_USER_TXT_BUY_MORE_CREDITS + "']")).click();
		common.pause(10);

		System.out.println("Step  :: Select package.");
		common.log("<br></br> Step  :: Select package");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_ADMIN_BTN_SELECT_PACKAGE + "']")).click();
		common.pause(20);

		System.out.println("Step  :: Click on paypal button.");
		common.log("<br></br> Step  :: Click on paypal button.");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BUY_CREDIT_BTN_PAY_VIA_PAYPAL + "']")).click();
		common.pause(20);

		System.out.println("Step  :: Verify order summary.");
		common.log("<br></br> Step  :: Verify order summary.");
		// common.assertElementPresent("//div[@id='" +
		// LEGACY_USER_TXT_ORDER_SUMMARY + "']");

	}

	/**
	 * paypal buy credit disable
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 * 
	 * 
	 */
	public void payment_Authorize_Net_Enable() throws InterruptedException, ParseException {

		System.out.println("Step  :: Click on Profile");
		common.log("<br></br> Step  :: Click on Profie");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_USER_PROFILE_TAB + "']")).click();
		common.pause(30);

		System.out.println("Step  :: Click on buy more credits");
		common.log("<br></br> Step  :: Click on buy more credits");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_USER_TXT_BUY_MORE_CREDITS + "']")).click();
		common.pause(20);

		System.out.println("Step  :: Select package");
		common.log("<br></br> Step  :: Select package");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_ADMIN_BTN_SELECT_PACKAGE + "']")).click();
		common.pause(15);

		System.out.println("Step :: Click on paynow button");
		common.log("<br></br> Step :: Click on paynow button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BUY_CREDIT_BTN_PAY_NOW + "']")).click();
		common.pause(15);

		System.out.println("Step  :: Verify payment checkout text");
		common.log("<br></br> Step  :: Verify payment checkout text");
		common.assertElementPresent("//h3");

		String paymentCheckoutText = driver.findElement(By.xpath("//h3")).getText();
		System.out.println("Step :: payment checkout Message >> " + paymentCheckoutText);
		common.pause(10);
	}

	/**
	 * payment authorize net enable
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 * 
	 */
	public void payment_authorize_net_enable() throws InterruptedException, ParseException {

		System.out.println("Step  :: Click on Invoices");
		common.log("<br></br> Step  :: Click on Invoices");

		driver.findElement(By.xpath("//a[text()='" + LEGACY_USER_TXT_INVOICES_FRONTEND + "']")).click();

		common.pause(10);
		System.out.println("Step :: Select Pending from dropdown menu");
		common.log("<br></br> Step :: Select Pending from dropdown menu");
		Actions actions = new Actions(driver);
		WebElement ShowDropDown = driver.findElement(By.xpath(
				"//span[@id='" + LEGACY_ADMIN_PENDING_FROM_DROPDOWN + "']//..[@role='" + LEGACY_USER_BUTTON + "']"));
		ShowDropDown.click();

		WebElement select_pending = driver.findElement(By.linkText("Pending"));
		common.pause(10);
		actions.moveToElement(select_pending);
		actions.moveToElement(select_pending).click().perform();
		common.pause(20);

		System.out.println("Step :: Click on view button");
		common.log("<br></br> Step :: Click on view button");
		driver.findElement(By.xpath("//td[text()='" + LEGACY_USER_LST_VALUE_PENDING + "']")).click();

		common.pause(25);

		System.out.println("Step :: Click on Pay Now button");
		common.log("<br></br> Step :: Click on Pay Now button");
		driver.findElement(By.xpath("//input[@value='" + LEGACY_USER_LST_VALUE_PAY_NOW + "']")).click();
		common.pause(10);

		System.out.println("Step :: Click on edit icon");
		common.log("<br></br> Step :: Click on edit icon");
		driver.findElement(By.xpath("//a[@id='" + LEGACY_USER_BTN_EDIT_CC + "']")).click();
		common.pause(10);

		/**
		 * Select CC Type
		 */
		System.out.println("Step :: Select CC Type.");
		common.log("<br></br>Step :: Select CC Type.");

		Actions CC_Type = new Actions(driver);
		common.pause(10);
		WebElement CCtype = driver.findElement(By.xpath(
				"//select[@id='" + LEGACY_USER_SELECT_CC_TYPE + "']//..//..//a[@role='" + LEGACY_USER_BUTTON + "']"));
		CCtype.click();
		common.pause(10);

		WebElement Select_CC_Type = driver.findElement(By.linkText("Visa"));
		common.pause(20);
		CC_Type.moveToElement(Select_CC_Type);
		CC_Type.moveToElement(Select_CC_Type).click().perform();
		common.pause(20);

		common.type("//input[@id='" + LEGACY_USER_ENTER_CC + "']", "4111111111111111");

		/**
		 * Select Expiration Month
		 * 
		 */

		System.out.println("Step :: Select CC Month.");
		common.log("<br></br>Step :: Select CC Month.");

		Actions CC_month = new Actions(driver);
		common.pause(10);
		WebElement CCmonth = driver.findElement(By.xpath("//select[@id='" + LEGACY_USER_SELECT_CC_MONTH + "']//..//a"));
		CCmonth.click();
		common.pause(20);

		WebElement Select_CC_month = driver.findElement(By.linkText("March"));
		common.pause(20);
		CC_month.moveToElement(Select_CC_month);
		CC_month.moveToElement(Select_CC_month).click().perform();
		common.pause(20);

		/**
		 * Select Expiration Year
		 * 
		 */

		System.out.println("Step :: Select CC Year.");
		common.log("<br></br>Step :: Select CC Year.");

		Actions CC_year = new Actions(driver);
		common.pause(10);
		WebElement CCyear = driver.findElement(By.xpath(
				"//select[@id='" + LEGACY_USER_SELECT_CC_YEAR + "']//..//..//a[@role='" + LEGACY_USER_BUTTON + "']"));
		CCyear.click();
		common.pause(10);

		WebElement Select_CC_Year = driver.findElement(By.linkText("2020"));
		common.pause(20);
		CC_year.moveToElement(Select_CC_Year);
		CC_year.moveToElement(Select_CC_Year).click().perform();
		common.pause(20);

		// enter security code
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_CC_CODE + "']", "123");
		common.pause(10);

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_TXT_BILLING_FIRST_NAME + "']", contactFirst);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_TXT_BILLING_LAST_NAME + "']", contactLast);

		common.log("<br></br>Step :: Billing Phone Number.");
		System.out.println("Step ::  Billing Number");
		common.type("//input[@id='" + LEGACY_USER_TXT_BILLING_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_COUNTRY + "']")).click();
		// Select Country

		System.out.println("Step :: Select Country.");
		common.log("<br></br>Step :: Select Country.");
		Actions Country = new Actions(driver);
		common.pause(10);
		WebElement SelectCounrty = driver.findElement(By.xpath("//select[@id='"
				+ LEGACY_USER_TXT_SHIPPING_INFO_COUNTRY_BUTTON + "']//..//..//a[@role='" + LEGACY_USER_BUTTON + "']"));
		SelectCounrty.click();
		common.pause(10);

		WebElement select_Canada = driver.findElement(By.linkText("Canada"));
		common.pause(10);
		Country.moveToElement(select_Canada);
		Country.moveToElement(select_Canada).click().perform();
		common.pause(10);

		// Select State

		common.log("<br></br>Step :: Enter Address.");
		System.out.println("Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_TXT_SHIPPING_ENTER_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);
		common.pause(10);

		common.log("<br></br>Step :: Enter City.");
		System.out.println("Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_TXT_SHIPPING_ENTER_CITY + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);
		common.pause(10);
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_TXT_SHIPPING_ENTER_ADDRESS + "']"))
				.sendKeys("466 green st");
		common.pause(10);
		driver.findElement(By.xpath("//input[@id='" + LEGACY_ADMIN_LST_ITEMS_PER_PAGE + "']")).sendKeys("Gujarat");
		common.pause(10);
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_ADDRESS + "']"))
				.sendKeys("466 green st");
		common.pause(5);

		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_TXT_SHIPPING_INFO_EDIT_CITY + "']"))
				.sendKeys("calgary");
		common.pause(5);

		System.out.println("Step  :: Click on Pay Via Authorize.net");
		common.log("<br></br> Step  :: Click on Pay Via Authorize.net");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_PAY_VIA_AUTHORIZE_NET + "']")).click();
		common.pause(10);

		System.out.println("Step :: Verify Success Message");
		common.log("<br></br> Step :: Verify Success Message");
		String successmsg = driver.findElement(By.xpath("//section[@class='" + LEGACY_USER_SIGNUP_MESSAGE_VALUE + "']"))
				.getText();
		System.out.println("Step ::Success Message >> " + successmsg);
		common.pause(10);

	}

	/**
	 * payment authorize net disable
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 * 
	 */

	public void payment_Authorize_Net_Disable() throws InterruptedException, ParseException {

		System.out.println("Step  :: Click on Invoices");
		common.log("<br></br> Step  :: Click on Invoices");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_USER_TXT_INVOICES_FRONTEND + "']")).click();
		common.pause(10);

		common.pause(10);
		System.out.println("Step :: Select Pending from dropdown menu");
		common.log("<br></br> Step :: Select Pending from dropdown menu");
		Actions actions = new Actions(driver);
		WebElement ShowDropDown = driver.findElement(By.xpath(
				"//span[@id='" + LEGACY_ADMIN_PENDING_FROM_DROPDOWN + "']//..[@role='" + LEGACY_USER_BUTTON + "']"));
		ShowDropDown.click();

		WebElement select_pending = driver.findElement(By.linkText("Pending"));
		common.pause(10);
		actions.moveToElement(select_pending);
		actions.moveToElement(select_pending).click().perform();
		common.pause(20);

		System.out.println("Step :: Click on view button");
		common.log("<br></br> Step :: Click on view button");
		driver.findElement(By.xpath("//td[text()='" + LEGACY_USER_LST_VALUE_PENDING + "']")).click();

		common.pause(25);

		System.out.println("Step :: Click on Pay Now button");
		common.log("<br></br> Step :: Click on Pay Now button");
		driver.findElement(By.xpath("//input[@value='" + LEGACY_USER_LST_VALUE_PAY_NOW + "']")).click();
		common.pause(10);

		common.assertElementNotPresent("//input[@id='" + LEGACY_USER_BTN_PAY_VIA_AUTHORIZE_NET + "']");
		common.pause(10);
	}

	/**
	 * paypal buy credit disable
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 * 
	 * 
	 */
	public void pay_Buy_Credit_Disable() throws InterruptedException, ParseException {

		System.out.println("Step  :: Click on Profile");
		common.log("<br></br> Step  :: Click on Profie");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_USER_PROFILE_TAB + "']")).click();
		common.pause(30);

		System.out.println("Step  :: Click on buy more credits");
		common.log("<br></br> Step  :: Click on buy more credits");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_USER_TXT_BUY_MORE_CREDITS + "']")).click();
		common.pause(20);

		System.out.println("Step  :: Select package");
		common.log("<br></br> Step  :: Select package");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_ADMIN_BTN_SELECT_PACKAGE + "']")).click();
		common.pause(15);

		System.out.println("Step :: Click on paynow button");
		common.log("<br></br> Step :: Click on paynow button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BUY_CREDIT_BTN_PAY_NOW + "']")).click();
		common.pause(15);

		System.out.println("Step  :: Verify payment checkout text");
		common.log("<br></br> Step  :: Verify payment checkout text");
		common.assertElementPresent("//h3");

		String paymentCheckoutText = driver.findElement(By.xpath("//h3")).getText();
		System.out.println("Step :: payment checkout Message >> " + paymentCheckoutText);
		common.pause(10);
	}

	/**
	 * payment authorize net enable with wrong details
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 * 
	 */

	public void payment_Authorize_Net_Enable_Wrong_Detail() throws InterruptedException, ParseException {

		System.out.println("Step  :: Click on Invoices");
		common.log("<br></br> Step  :: Click on Invoices");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_USER_TXT_INVOICES_FRONTEND + "']")).click();
		common.pause(10);

		common.pause(10);
		System.out.println("Step :: Select Pending from dropdown menu");
		common.log("<br></br> Step :: Select Pending from dropdown menu");
		Actions actions = new Actions(driver);
		WebElement ShowDropDown = driver.findElement(By.xpath(
				"//span[@id='" + LEGACY_ADMIN_PENDING_FROM_DROPDOWN + "']//..[@role='" + LEGACY_USER_BUTTON + "']"));
		ShowDropDown.click();

		WebElement select_pending = driver.findElement(By.linkText("Pending"));
		common.pause(10);
		actions.moveToElement(select_pending);
		actions.moveToElement(select_pending).click().perform();
		common.pause(20);

		System.out.println("Step :: Click on view button");
		common.log("<br></br> Step :: Click on view button");
		driver.findElement(By.xpath("//td[text()='" + LEGACY_USER_LST_VALUE_PENDING + "']")).click();

		common.pause(25);

		System.out.println("Step :: Click on Pay Now button");
		common.log("<br></br> Step :: Click on Pay Now button");
		driver.findElement(By.xpath("//input[@value='" + LEGACY_USER_LST_VALUE_PAY_NOW + "']")).click();
		common.pause(10);

		System.out.println("Step  :: Click on edit icon");
		common.log("<br></br> Step  :: Click on edit icon");
		driver.findElement(By.xpath("//a[@id='" + LEGACY_USER_BTN_EDIT_CC + "']")).click();
		common.pause(10);

		/**
		 * Select CC Type
		 */
		System.out.println("Step :: Select CC Type.");
		common.log("<br></br>Step :: Select CC Type.");

		Actions CC_Type = new Actions(driver);
		common.pause(10);
		WebElement CCtype = driver.findElement(By.xpath(
				"//select[@id='" + LEGACY_USER_SELECT_CC_TYPE + "']//..//..//a[@role='" + LEGACY_USER_BUTTON + "']"));
		CCtype.click();
		common.pause(10);

		WebElement Select_CC_Type = driver.findElement(By.linkText("Visa"));
		common.pause(20);
		CC_Type.moveToElement(Select_CC_Type);
		CC_Type.moveToElement(Select_CC_Type).click().perform();
		common.pause(20);

		common.type("//input[@id='" + LEGACY_USER_ENTER_CC + "']", "4111111111111111");

		/**
		 * Select Expiration Month
		 * 
		 */

		System.out.println("Step :: Select CC Month.");
		common.log("<br></br>Step :: Select CC Month.");

		Actions CC_month = new Actions(driver);
		common.pause(10);
		WebElement CCmonth = driver.findElement(By.xpath("//select[@id='" + LEGACY_USER_SELECT_CC_MONTH + "']//..//a"));
		CCmonth.click();
		common.pause(20);

		WebElement Select_CC_month = driver.findElement(By.linkText("March"));
		common.pause(20);
		CC_month.moveToElement(Select_CC_month);
		CC_month.moveToElement(Select_CC_month).click().perform();
		common.pause(20);

		/**
		 * Select Expiration Year
		 * 
		 */

		System.out.println("Step :: Select CC Year.");
		common.log("<br></br>Step :: Select CC Year.");

		Actions CC_year = new Actions(driver);
		common.pause(10);
		WebElement CCyear = driver.findElement(By.xpath(
				"//select[@id='" + LEGACY_USER_SELECT_CC_YEAR + "']//..//..//a[@role='" + LEGACY_USER_BUTTON + "']"));
		CCyear.click();
		common.pause(10);

		WebElement Select_CC_Year = driver.findElement(By.linkText("2020"));
		common.pause(20);
		CC_year.moveToElement(Select_CC_Year);
		CC_year.moveToElement(Select_CC_Year).click().perform();
		common.pause(20);

		// enter security code
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_CC_CODE + "']", "123");
		common.pause(10);
		System.out.println("Step  :: Click on Pay Via Authorize.net");
		common.log("<br></br> Step  :: Click on Pay Via Authorize.net");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_PAY_VIA_AUTHORIZE_NET + "']")).click();
		common.pause(10);

		System.out.println("Step :: Verify Warning Message");
		common.log("<br></br> Step :: Verify Warning Message");
		common.assertElementPresent("//span[text()='Credit Card Number *: Invalid Credit Card Number']");

	}

	/**
	 * buy credit authorize net success.
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 * 
	 */

	public void buy_Credit_Authorise_Net_Success() throws InterruptedException, ParseException {

		System.out.println("Step  :: Click on Profile");
		common.log("<br></br> Step  :: Click on Profie");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_USER_PROFILE_TAB + "']")).click();
		common.pause(10);

		System.out.println("Step  :: Click on buy more credit.");
		common.log("<br></br> Step  :: Click on buy more credit.");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_USER_TXT_BUY_MORE_CREDITS + "']")).click();
		common.pause(10);

		System.out.println("Step  :: Select package.");
		common.log("<br></br> Step  :: Select package");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_ADMIN_BTN_SELECT_PACKAGE + "']")).click();
		common.pause(10);

		System.out.println("Step :: Click on paynow button");
		common.log("<br></br> Step :: Click on paynow button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BUY_CREDIT_BTN_PAY_NOW + "']")).click();
		common.pause(10);

		System.out.println("Step  :: Click on Pay Via Authorize.net");
		common.log("<br></br> Step  :: Click on Pay Via Authorize.net");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_PAY_THROUGH_AUTHORIZE_NET + "']")).click();

		System.out.println("Step :: Verify Success Message");
		common.log("<br></br> Step :: Verify Success Message");

		String successstr = driver.findElement(By.xpath("//h3")).getText();
		System.out.println("Step :: Success Message >> " + successstr);
		common.pause(10);
	}

	/**
	 * authorize button disable
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 * 
	 */

	public void authorize_Button_Disable() throws InterruptedException, ParseException {

		System.out.println("Step  :: Click on Profile");
		common.log("<br></br> Step  :: Click on Profie");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_USER_PROFILE_TAB + "']")).click();
		common.pause(10);

		System.out.println("Step  :: Click on buy more credit.");
		common.log("<br></br> Step  :: Click on buy more credit.");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_USER_TXT_BUY_MORE_CREDITS + "']")).click();
		common.pause(10);

		System.out.println("Step  :: Select package.");
		common.log("<br></br> Step  :: Select package");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_ADMIN_BTN_SELECT_PACKAGE + "']")).click();
		common.pause(10);

		System.out.println("Step :: Click on paynow button");
		common.log("<br></br> Step :: Click on paynow button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BUY_CREDIT_BTN_PAY_NOW + "']")).click();
		common.pause(10);

		System.out.println("Verify authorize payment button is not present");
		common.log("Verify authorize payment button is not present");
		common.assertElementIsNotDisplayed("//input[@id='" + LEGACY_USER_BTN_PAY_THROUGH_AUTHORIZE_NET + "']");
		common.pause(10);
	}

	/**
	 * buy credit with invalid cc
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 * 
	 */

	public void buy_Credit_Invalid_CC() throws InterruptedException, ParseException {

		System.out.println("Step  :: Click on Profile");
		common.log("<br></br> Step  :: Click on Profie");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_USER_PROFILE_TAB + "']")).click();
		common.pause(10);

		System.out.println("Step  :: Click on buy more credit.");
		common.log("<br></br> Step  :: Click on buy more credit.");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_USER_TXT_BUY_MORE_CREDITS + "']")).click();
		common.pause(10);

		System.out.println("Step  :: Select package.");
		common.log("<br></br> Step  :: Select package");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_ADMIN_BTN_SELECT_PACKAGE + "']")).click();
		common.pause(10);

		System.out.println("Step :: Click on paynow button");
		common.log("<br></br> Step :: Click on paynow button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BUY_CREDIT_BTN_PAY_NOW + "']")).click();
		common.pause(10);

		System.out.println("Step  :: Click on edit icon");
		common.log("<br></br> Step  :: Click on edit icon");
		driver.findElement(By.xpath("//a[@id='" + LEGACY_USER_BTN_EDIT_CC + "']")).click();
		common.pause(10);

		/**
		 * Select CC Type
		 */
		System.out.println("Step :: Select CC Type.");
		common.log("<br></br>Step :: Select CC Type.");

		Actions CC_Type = new Actions(driver);
		common.pause(10);
		WebElement CCtype = driver.findElement(By.xpath(
				"//select[@id='" + LEGACY_USER_SELECT_CC_TYPE + "']//..//..//a[@role='" + LEGACY_USER_BUTTON + "']"));
		CCtype.click();
		common.pause(10);

		WebElement Select_CC_Type = driver.findElement(By.linkText("Visa"));
		common.pause(20);
		CC_Type.moveToElement(Select_CC_Type);
		CC_Type.moveToElement(Select_CC_Type).click().perform();
		common.pause(20);

		common.type("//input[@id='" + LEGACY_USER_ENTER_CC + "']", LEGACY_USER_TXT_CC_NUMBER_VALUE_INVALID);

		/**
		 * Select Expiration Month
		 * 
		 */

		System.out.println("Step :: Select CC Month.");
		common.log("<br></br>Step :: Select CC Month.");

		Actions CC_month = new Actions(driver);
		common.pause(10);
		WebElement CCmonth = driver.findElement(By.xpath("//select[@id='" + LEGACY_USER_SELECT_CC_MONTH + "']//..//a"));
		CCmonth.click();
		common.pause(20);

		WebElement Select_CC_month = driver.findElement(By.linkText("March"));
		common.pause(20);
		CC_month.moveToElement(Select_CC_month);
		CC_month.moveToElement(Select_CC_month).click().perform();
		common.pause(20);

		/**
		 * Select Expiration Year
		 * 
		 */

		System.out.println("Step :: Select CC Year.");
		common.log("<br></br>Step :: Select CC Year.");

		Actions CC_year = new Actions(driver);
		common.pause(10);
		WebElement CCyear = driver.findElement(By.xpath(
				"//select[@id='" + LEGACY_USER_SELECT_CC_YEAR + "']//..//..//a[@role='" + LEGACY_USER_BUTTON + "']"));
		CCyear.click();
		common.pause(10);

		WebElement Select_CC_Year = driver.findElement(By.linkText("2020"));
		common.pause(20);
		CC_year.moveToElement(Select_CC_Year);
		CC_year.moveToElement(Select_CC_Year).click().perform();
		common.pause(20);

		// enter security code
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_CC_CODE + "']", "123");
		common.pause(10);

		System.out.println("Step  :: Click on Pay Via Authorize.net");
		common.log("<br></br> Step  :: Click on Pay Via Authorize.net");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_PAY_THROUGH_AUTHORIZE_NET + "']")).click();

		common.pause(10);

		String usermessage = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_WARNING_SUB_TITLE_0 + "']")).getText();

		System.out.println("Step :: Error Display :: " + usermessage);
		common.log("<br></br> Step :: Error Display :: " + usermessage);
		common.pause(10);
	}

	/**
	 * Buy lot from catalog page
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param lotName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void buy_Lot_From_Catalog(String saleno, String auctionName, String lotName)
			throws InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale(auctionName); // Goto View Catalog Page
		common.pause(10);

		System.out.println("Step :: Fill buy now value");
		common.type("//a[text()='" + lotName + "']//..//..//..//div[@class='regular-bid']//input[@type='text']", "100");

		common.log("<br></br> Step :: Click on buy now button");
		System.out.println("Step :: Click on buy now button");
		driver.findElement(By.xpath("//div[@class='buy-now']")).click();

		common.log("<br></br> Step :: Verify Winner Message");
		System.out.println("Step :: Verify Winner Message");
		common.isElementPresent("//span[contains(text(),'Your high bid!')]");

	}

	/**
	 * Place bid on live auction from livesale tab
	 * 
	 * Click on Green Bid Button
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param lotName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void place_Bid_On_Live_Auction(String saleno, String auctionName) throws InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale(auctionName); // Goto catalog Page

		System.out.println("Step :: Click on catalog button");
		common.log("<br></br> Step :: Click on catalog button");

		common.pause20Sec();
		System.out.println("Step :: Click on Live Sale tab");
		common.log("<br></br> Step :: Click on Live Sale tab");
		common.pause20Sec();
		if (!common.isElementPresent("//a[contains(text(),'"+LEGACY_USER_TXT_LIVE_SALE+"')]")) {

			driver.findElement(By.xpath("//a//span[text()='" + auctionName + "']")).click();

			common.pause20Sec();
			driver.findElement(By.xpath("//a[contains(text(),'"+LEGACY_USER_TXT_LIVE_SALE_NOW+"')]")).click();
			common.pause20Sec();
		} else {

			driver.findElement(By.xpath("//a[contains(text(),'"+LEGACY_USER_TXT_LIVE_SALE+"')]")).click();
			common.pause20Sec();
		}

		common.pause20Sec();
		System.out.println("Step :: Click on bid button");
		common.log("<br></br> Step :: Click on bid button");
		driver.findElement(By.xpath("//a[@id='" + LEGACY_FRONT_LOGIN_BTN_BID + "']")).click();

		System.out.println("Step :: Button Clicked");
		common.log("Step :: Button Clicked");
		common.pause20Sec();

		if (!common.isElementPresent("//a[@class='" + LEGACY_USER_TXT_LIVESALE_DISABLE + "']")) {

			System.out.println("Step :: Click on bid button");
			common.log("<br></br> Step :: Click on bid button");
			driver.findElement(By.xpath("//a[@id='" + LEGACY_FRONT_LOGIN_BTN_BID + "']")).click();

		} else {
			System.out.println("Step :: Bid Button Already Clicked");
		}

		common.pause20Sec();
		common.highlightElement("//div[@class='" + LEGACY_USER_SIGNUP_MESSAGES_VALUE + "']");
		common.assertElementPresent("//div[@class='" + LEGACY_USER_SIGNUP_MESSAGES_VALUE + "']");
		String usermessage = driver.findElement(By.xpath("//div[@class='" + LEGACY_USER_SIGNUP_MESSAGES_VALUE + "']"))
				.getText();

		System.out.println("Step :: Message center\n :: " + usermessage);
		common.log("<br></br> Step :: Message center\n :: " + usermessage);

		common.pause20Sec();

		// common.jsClick(logout);
	}

	/**
	 * place bid live auction out
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param lotName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void place_Bid_Live_Auction_End(String saleno, String auctionName, String lotName)
			throws InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale_Auction(auctionName); // Goto catalog page

		System.out.println("Step :: Click on catalog button");
		common.log("<br></br> Step :: Click on catalog button");
		common.pause(30);

		System.out.println("Step :: Click on Live Sale tab");
		common.log("<br></br> Step :: Click on Live Sale tab");

		common.pause(25);
		if (!common.isElementPresent("//a[contains(text(),'Live Sale')]")) {

			driver.findElement(By.xpath("//a//span[text()='" + auctionName + "']")).click();

			common.pause(20);
			driver.findElement(By.xpath("//a[contains(text(),'View live sale now!')]")).click();
			common.pause(20);
		} else {

			driver.findElement(By.xpath("//a[contains(text(),'Live Sale')]")).click();
			common.pause(20);
		}

		String usermessage = driver.findElement(By.xpath("//div[@class='" + LEGACY_USER_SIGNUP_MESSAGES_VALUE + "']"))
				.getText();

		System.out.println("Step :: Message center\n :: " + usermessage);
		common.log("<br></br> Step :: Message center\n :: " + usermessage);
		common.pause(10);
		common.jsClick(logout);
		common.pause(10);
	}

	/**
	 * 
	 * Verify chat screen in live auction
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param lotName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void verify_Chat_Message_Live_Sale(String auctionName) throws InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale(auctionName); // Goto catalog page

		System.out.println("Step :: Click on catalog button");
		common.log("<br></br> Step :: Click on catalog button");
		common.pause(100);

		System.out.println("Step :: Click on Live Sale tab");
		common.log("<br></br> Step :: Click on Live Sale tab");

		common.pause(25);
		if (!common.isElementPresent("//a[contains(text(),'Live Sale')]")) {

			driver.findElement(By.xpath("//a//span[text()='" + auctionName + "']")).click();

			common.pause(20);
			driver.findElement(By.xpath("//a[contains(text(),'View live sale now!')]")).click();
			common.pause(20);
		} else {

			driver.findElement(By.xpath("//a[contains(text(),'Live Sale')]")).click();
			common.pause(20);
		}

		String usermessage = driver.findElement(By.xpath("//div[@class='" + LEGACY_USER_SIGNUP_MESSAGES_VALUE + "']"))
				.getText();
		System.out.println("Step :: Message center\n :: " + usermessage);
		common.log("<br></br> Step :: Message center\n :: " + usermessage);
		common.jsClick(logout);
	}

	public void verify_Chat_Message_Live_Sale1(String auctionName) throws InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale_Auction(auctionName); // Goto catalog page

		System.out.println("Step :: Click on catalog button");
		common.log("<br></br> Step :: Click on catalog button");
		common.pause(30);

		System.out.println("Step :: Click on Live Sale tab");
		common.log("<br></br> Step :: Click on Live Sale tab");

		common.pause(25);
		if (!common.isElementPresent("//a[contains(text(),'Live Sale')]")) {

			driver.findElement(By.xpath("//a//span[text()='" + auctionName + "']")).click();

			common.pause(20);
			driver.findElement(By.xpath("//a[contains(text(),'View live sale now!')]")).click();
			common.pause(20);
		} else {

			driver.findElement(By.xpath("//a[contains(text(),'Live Sale')]")).click();
			common.pause(20);
		}

		String usermessage = driver.findElement(By.xpath("//div[@class='" + LEGACY_USER_SIGNUP_MESSAGES_VALUE + "']"))
				.getText();
		System.out.println("Step :: Message center\n :: " + usermessage);
		common.log("<br></br> Step :: Message center\n :: " + usermessage);
		common.jsClick(logout);
	}

	/**
	 * 
	 * Verify chat disable in live auction
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param lotName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void placebidonliveauctionchatnotdisplay(String saleno, String auctionName, String lotName)
			throws InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale(auctionName); // Goto catalog page

		System.out.println("Step :: Click on catalog button");
		common.log("<br></br> Step :: Click on catalog button");
		common.pause(30);

		System.out.println("Step :: Click on Live Sale tab");
		common.log("<br></br> Step :: Click on Live Sale tab");

		common.pause(25);
		if (!common.isElementPresent("//a[contains(text(),'Live Sale')]")) {

			driver.findElement(By.xpath("//a//span[text()='" + auctionName + "']")).click();

			common.pause(20);
			driver.findElement(By.xpath("//a[contains(text(),'View live sale now!')]")).click();
			common.pause(20);
		} else {

			driver.findElement(By.xpath("//a[contains(text(),'Live Sale')]")).click();
			common.pause(20);
		}

		common.jsClick(logout);
	}

	/**
	 * 
	 * Verify Green bid button Enable
	 * 
	 * @param saleno
	 * @param auctionName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void liveSaletab_Bid_Buttonenable(String saleno, String auctionName)
			throws InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale(auctionName); // Goto catalog page

		System.out.println("Step :: Click on Live Sale tab");
		common.log("<br></br> Step :: Click on Live Sale tab");

		common.pause(25);
		if (!common.isElementPresent("//a[contains(text(),'Live Sale')]")) {

			driver.findElement(By.xpath("//a//span[text()='" + auctionName + "']")).click();

			common.pause(20);
			driver.findElement(By.xpath("//a[contains(text(),'View live sale now!')]")).click();
			common.pause(20);
		} else {

			driver.findElement(By.xpath("//a[contains(text(),'Live Sale')]")).click();
			common.pause(20);
		}

		System.out.println("Step :: Wait for bid button");
		common.waitForConditionIsElementPresent("//a[@id='" + LEGACY_FRONT_LOGIN_BTN_BID + "']");

		System.out.println("Step :: Enable Bid button verify");
		common.assertElementNotPresent("//a[@class='" + LEGACY_USER_TXT_LIVESALE_DISABLE + "']");

		common.pause(15);
		common.jsClick(logout);

		common.pause(10);
	}

	public void liveSaletab_Bid_ButtonEnable1(String saleno, String auctionName)
			throws InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale_Auction(auctionName); // Goto catalog page

		System.out.println("Step :: Click on Live Sale tab");
		common.log("<br></br> Step :: Click on Live Sale tab");
		common.pause(25);
		if (!common.isElementPresent("//a[contains(text(),'Live Sale')]")) {

			driver.findElement(By.xpath("//a//span[text()='" + auctionName + "']")).click();

			common.pause(20);
			driver.findElement(By.xpath("//a[contains(text(),'View live sale now!')]")).click();
			common.pause(20);
		} else {

			driver.findElement(By.xpath("//a[contains(text(),'Live Sale')]")).click();
			common.pause(20);
		}

		System.out.println("Step :: Wait for bid button");
		common.waitForConditionIsElementPresent("//a[@id='" + LEGACY_FRONT_LOGIN_BTN_BID + "']");

		System.out.println("Step :: Enable Bid button verify");
		common.assertElementNotPresent("//a[@class='" + LEGACY_USER_TXT_LIVESALE_DISABLE + "']");

		common.pause(15);
		common.jsClick(logout);

		common.pause(10);
	}

	/**
	 * Verify live sale is present
	 * 
	 * @param saleno
	 * @param auctionName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void Live_Sale_Is_Present(String name) throws InterruptedException, AWTException {

		common.pause(15);
		common.log("<br></br> Step :: Click on Auction Overview Page");
		System.out.println("Step :: Click on Auction Overview Page");
		common.waitForElement(By.xpath("//a[text()='" + LEGACY_ADMIN_BTN_CREATE_NEW_AUCTION + "']"));
		common.jsClick(auctionsubtab);// Go to Auction overview page
		common.pause(25);

		System.out.println("Step :: Select 100 from dropdown");
		common.log("<br></br> Step :: Select 100 from dropdown");
		driver.findElement(By.xpath("//select[@id='" + LEGACY_ADMIN_LOT_TABLE + "']//option[@value='1']")).click();

		common.pause(30);

		for (int i = 0; i < 20; i++) {

			if (common.isElementPresent("//ul[@class='auclting yura']//a[text()=' " + name + "']"))

			{
				common.log("auction " + name + " is present in this page");
				System.out.println("auction " + name + " is present in this page");
				driver.findElement(By.xpath("//ul[@class='auclting yura']//a[text()=' " + name
						+ "']//..//..//..//..//a[text()='View catalog']")).click();
				common.pause(20);
				break;
			} else {
				common.log("auction " + name + " is not present in this page");
				System.out.println("auction " + name + " is not  present in this page");
				common.pause(60);

				System.out.println("Step :: Click on Next page");
				common.log("<br></br> Step :: Click on Next page");
				driver.findElement(By.xpath("//div[@class='" + LEGACY_USER_PAGE_INIT + "']//span[@id='"
						+ LEGACY_USER_LST_NEXT_PAGE + "']//a[contains(text(),'" + LEGACY_USER_BTN_NEXT + "')]"))
						.click();
				common.pause(20);
			}
		}

	}

	/**
	 * Verify live sale tab does not display
	 * 
	 * @param saleno
	 * @param auctionName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void liveSaletab_Bid_ButtonDisable(String saleno, String auctionName)
			throws InterruptedException, AWTException {

		common.pause(15);
		common.log("<br></br> Step :: Click on Auction Overview Page");
		System.out.println("Step :: Click on Auction Overview Page");
		common.waitForElement(By.xpath("//a[text()='" + LEGACY_ADMIN_BTN_CREATE_NEW_AUCTION + "']"));
		common.jsClick(auctionsubtab);// Go to Auction overview page
		common.pause(25);

		System.out.println("Step :: Select 100 from dropdown");
		common.log("<br></br> Step :: Select 100 from dropdown");
		driver.findElement(By.xpath("//select[@id='" + LEGACY_ADMIN_LOT_TABLE + "']//option[@value='1']")).click();

		common.pause(30);

		for (int i = 0; i < 20; i++) {

			if (common.isElementPresent("//ul[@class='auclting yura']//a[text()=' " + auctionName + "']"))

			{
				common.log("auction " + auctionName + " is present in this page");
				System.out.println("auction " + auctionName + " is present in this page");
				driver.findElement(By.xpath("//ul[@class='auclting yura']//a[text()=' " + auctionName
						+ "']//..//..//..//..//a[text()='View catalog']")).click();
				common.pause(20);
				break;
			} else {
				common.log("auction " + auctionName + " is not present in this page");
				System.out.println("auction " + auctionName + " is not  present in this page");
				common.pause(60);

				System.out.println("Step :: Click on Next page");
				common.log("<br></br> Step :: Click on Next page");
				driver.findElement(By.xpath("//div[@class='" + LEGACY_USER_PAGE_INIT + "']//span[@id='"
						+ LEGACY_USER_LST_NEXT_PAGE + "']//a[contains(text(),'" + LEGACY_USER_BTN_NEXT + "')]"))
						.click();
				common.pause(20);
			}

		}

		System.out.println("Step :: Live Sale Not Displayed");
		common.log("<br></br> Step :: Live Sale Not Displayed ");
		common.assertElementNotPresent("//input[@value='" + LEGACY_USER_TXT_LIVE_SALE + "']");

		common.pause(10);

		common.jsClick(logout);

		common.pause(10);
	}

	/**
	 * Verify live sale tab does not display
	 * 
	 * @param saleno
	 * @param auctionName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void Bid_Button_Disable_Hybrid(String saleno, String auctionName) throws InterruptedException, AWTException {

		goto_Catalog_Page_Hybrid(auctionName); // Goto catalog page

		System.out.println("Step :: Live Sale Not Displayed");
		common.log("<br></br> Step :: Live Sale Not Displayed ");
		common.assertElementNotPresent("//input[@value='" + LEGACY_USER_TXT_LIVE_SALE + "']");

		common.pause(10);

		common.jsClick(logout);

		common.pause(10);
	}

	/**
	 * Click on Place bid button
	 * 
	 * @param saleno
	 * @param auctionName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void livesaletab_Bid_Buttonaccepted(String saleno, String auctionName)
			throws InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale(auctionName); // Goto catalog page

		System.out.println("Step :: Click on Live Sale tab");
		common.log("<br></br> Step :: Click on Live Sale tab");
		common.pause(25);
		if (!common.isElementPresent("//a[contains(text(),'Live Sale')]")) {

			driver.findElement(By.xpath("//a//span[text()='" + auctionName + "']")).click();

			common.pause(20);
			driver.findElement(By.xpath("//a[contains(text(),'View live sale now!')]")).click();
			common.pause(20);
		} else {

			driver.findElement(By.xpath("//a[contains(text(),'Live Sale')]")).click();
			common.pause(20);
		}

		System.out.println("Step :: Wait for bid button");
		common.waitForConditionIsElementPresent("//a[@id='" + LEGACY_FRONT_LOGIN_BTN_BID + "']");

		System.out.println("Step :: Click on bid button");
		common.log("<br></br> Step :: Click on bid button");
		driver.findElement(By.xpath("//a[@id='" + LEGACY_FRONT_LOGIN_BTN_BID + "']")).click();

		common.jsClick(logout);

		common.pause(10);
	}

	/**
	 * Verify place bid button after undo
	 * 
	 * @param saleno
	 * @param auctionName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void livesaletab_Bid_Button_After_Undo(String saleno, String auctionName)
			throws InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale_Auction(auctionName); // Goto catalog page

		System.out.println("Step :: Click on Live Sale tab");
		common.log("<br></br> Step :: Click on Live Sale tab");

		common.pause(25);
		if (!common.isElementPresent("//a[contains(text(),'Live Sale')]")) {

			driver.findElement(By.xpath("//a//span[text()='" + auctionName + "']")).click();

			common.pause(20);
			driver.findElement(By.xpath("//a[contains(text(),'View live sale now!')]")).click();
			common.pause(20);
		} else {

			driver.findElement(By.xpath("//a[contains(text(),'Live Sale')]")).click();
			common.pause(20);
		}
		System.out.println("Step :: Verify Bid Button Enable after undo");
		common.assertElementNotPresent("//a[@class='" + LEGACY_USER_TXT_LIVESALE_DISABLE + "']");

		common.pause(10);

		common.jsClick(logout);

		common.pause(10);
	}

	/**
	 * Verify livesale tab in live auction
	 * 
	 * @param saleno
	 * @param auctionName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void verifyLiveSaletab(String saleno, String auctionName) throws InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale(auctionName); // Go to catalog page

		System.out.println("Step ::Click on catalog button");

		common.pause(20);
		System.out.println("Step :: Verify Lot ");
		common.log("<br></br> Step :: Verify Lot");
		String str_lot = driver.findElement(By.xpath("//a[@class='" + LEGACY_USER_LOT_TXT + "']")).getText();

		System.out.println("Lot Name :: " + str_lot);

		common.jsClick(logout);
	}

	public void verifyLiveSaleTab1(String saleno, String auctionName) throws InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale_Auction(auctionName); // Go to catalog page

		System.out.println("Step ::Click on catalog button");

		common.pause(20);
		System.out.println("Step :: Verify Lot ");
		common.log("<br></br> Step :: Verify Lot");
		String str_lot = driver.findElement(By.xpath("//a[@class='" + LEGACY_USER_LOT_TXT + "']")).getText();

		System.out.println("Lot Name :: " + str_lot);

		common.jsClick(logout);
	}

	/**
	 * Verify live sale tab does not display
	 * 
	 * @param saleno
	 * @param auctionName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void verifyLiveSaleTabNotDisplay(String saleno, String auctionName)
			throws InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale_Auction(auctionName);

		System.out.println("Step :: Click on Live Sale tab");
		common.log("<br></br> Step :: Click on Live Sale tab");
		common.pause(25);
		if (!common.isElementPresent("//a[contains(text(),'Live Sale')]")) {

			driver.findElement(By.xpath("//a//span[text()='" + auctionName + "']")).click();

			common.pause(20);
			driver.findElement(By.xpath("//a[contains(text(),'View live sale now!')]")).click();
			common.pause(20);
		} else {

			driver.findElement(By.xpath("//a[contains(text(),'Live Sale')]")).click();
			common.pause(20);
		}

		System.out.println("Step :: Wait for bid button");
		common.waitForConditionIsElementPresent("//a[@id='" + LEGACY_FRONT_LOGIN_BTN_BID + "']");

		System.out.println("Step :: Click on bid button");
		common.log("<br></br> Step :: Click on bid button");
		driver.findElement(By.xpath("//a[@id='" + LEGACY_FRONT_LOGIN_BTN_BID + "']")).click();

		Thread.sleep(20);

		// System.out.println("Step :: disable button verify");
		// common.assertElementPresent("//a[@class='"
		// + LEGACY_USER_TXT_LIVESALE_DISABLE + "']");
		//
		// common.pause(15);

		common.jsClick(logout);
	}

	/**
	 * Verify livesale tab in live auction
	 * 
	 * @param saleno
	 * @param auctionName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void verify_Auction_Is_Ongoing(String saleno, String auctionName) throws InterruptedException, AWTException {

		goto_Catalog_Page_Hybrid(auctionName); // Go to catalog page

		System.out.println("Step :: Click on Live Sale tab");
		common.log("<br></br> Step :: Click on Live Sale tab");

		for (int i = 0; i < 5; i++) {

			if (!common.isElementDisplayed("//div//a[text()='" + LEGACY_USER_BIDDING_PAUSED + "']")) {

				common.assertElementIsNotDisplayed("//div//a[text()='" + LEGACY_USER_BIDDING_PAUSED + "']");
				System.out.println("Step :: Bidding Pause Not Displays");
				common.log("<br></br> Step :: Bidding Pause Not Dispalys");
				break;

			} else {

				System.out.println("Step :: Check Again");
				common.log("<br></br> Step :: Check Again");

			}

		}
		common.jsClick(logout);
	}

	/**
	 * Verify livesale tab in live auction
	 * 
	 * @param saleno
	 * @param auctionName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void verify_Auction_Is_Ongoing_Or_Not(String saleno, String auctionName)
			throws InterruptedException, AWTException {

		goto_Catalog_Page_Hybrid_Auction(auctionName); // Go to catalog page

		System.out.println("Step :: Click on Live Sale tab");
		common.log("<br></br> Step :: Click on Live Sale tab");

		for (int i = 0; i < 5; i++) {

			if (!common.isElementDisplayed("//div//a[text()='" + LEGACY_USER_BIDDING_PAUSED + "']")) {

				common.assertElementIsNotDisplayed("//div//a[text()='" + LEGACY_USER_BIDDING_PAUSED + "']");
				System.out.println("Step :: Bidding Pause Not Displays");
				common.log("<br></br> Step :: Bidding Pause Not Dispalys");
				break;

			} else {

				System.out.println("Step :: Check Again");
				common.log("<br></br> Step :: Check Again");

			}

		}
		common.jsClick(logout);
	}

	/**
	 * Place absentee bid from catalog page
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param lotName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void place_Absenteebid(String auctionName, String lotName) throws InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale(auctionName); // Goto catalog page

		System.out.println("Step :: Click on catalog button");
		common.log("<br></br> Step :: Click on catalog button");

		System.out.println("Step :: Fill absentee bid value");
		common.log("<br></br> Step :: Fill absentee bid value");
		common.pause(20);

		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_REGULAR_LIVE_BID + "']")).sendKeys("100");
		common.pause(5);

		System.out.println("Step :: Click on placebid button");
		common.log("<br></br> Step :: Click on placebid button");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']"))
				.click();
		common.pause(60);
		if (common.isElementPresent("//input[@id='" + LEGACY_USER_BTN_FOLLOW + "']")) {
			driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_FOLLOW + "']")).click();
			common.pause(10);
//			driver.findElement(By.xpath("//a[@id='"+LEGACY_FRONT_LOGIN_BTN_BID+"']")).click();
//			common.pause(10);
//			driver.findElement(By.xpath("//input[@id='pbloi2']"));
//			
		}
		common.pause(25);
		common.jsClick(logout);
	}

	/**
	 * Place absentee bid from catalog page for 2 user (Higher than 1st bidder)
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param lotName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void placeAbsenteeBid2High(String saleno, String auctionName, String lotName, String lotName1)
			throws InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale_Auction(auctionName); // Goto catalog page

		System.out.println("Step :: Click on catalog button");
		common.log("<br></br> Step :: Click on catalog button");
		common.pause(25);

		// common.waitForConditionIsElementPresent("//div[@class='buy-now']");

		System.out.println("Step :: Fill absentee bid value");
		common.log("<br></br> Step :: Fill absentee bid value");

		common.pause(20);

		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_REGULAR_LIVE_BID + "']")).sendKeys("200");

		System.out.println("Step :: Click on placebid button");
		common.log("<br></br> Step :: Click on placebid button");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']"))
				.click();
		common.pause(40);

		common.acceptAlert1();
		common.pause(10);

		WebElement logout = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
		logout.click();
		common.pause(5);

	}

	public void place_Absenteebid_250(String auctionName, String lotName) throws InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale(auctionName); // Goto catalog page

		System.out.println("Step :: Click on catalog button");
		common.log("<br></br> Step :: Click on catalog button");
		common.pause(40);

		System.out.println("Step :: Fill absentee bid value");
		common.log("<br></br> Step :: Fill absentee bid value");
		common.pause(20);

		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_REGULAR_LIVE_BID + "']")).sendKeys("250");
		common.pause(25);

		System.out.println("Step :: Click on placebid button");
		common.log("<br></br> Step :: Click on placebid button");

		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//input[@value='" + LEGACY_USER_BTN_CHANGE_BID + "']"))
				.click();
		common.pause(40);

		common.acceptAlert1();
		common.pause(35);
//		String str = driver.findElement(By.xpath("//div[@class='bd-info bd-info-17888']//li[1]")).getText();
//		String str1 = driver.findElement(By.xpath("//div[@class='bd-info bd-info-17888']//li[2]")).getText();
//		String str2 = driver.findElement(By.xpath("//div[@class='bd-info bd-info-17888']//li[3]")).getText();
//		String str3 = driver.findElement(By.xpath("//div[@class='bd-info bd-info-17888']//li[4]")).getText();
//		
//		System.out.println("Box values : "+str+"/n"+str1+"/n"+str2+"/n"+str3);
//		common.log("Box values : "+str+"/n"+str1+"/n"+str2+"/n"+str3);
		common.jsClick(logout);
	}

	public void place_Absenteebid_150(String auctionName, String lotName) throws InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale(auctionName); // Goto catalog page

		System.out.println("Step :: Click on catalog button");
		common.log("<br></br> Step :: Click on catalog button");
		common.pause(40);

		System.out.println("Step :: Fill absentee bid value");
		common.log("<br></br> Step :: Fill absentee bid value");
		common.pause(20);

		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_REGULAR_LIVE_BID + "']")).sendKeys("150");
		common.pause(25);

		System.out.println("Step :: Click on placebid button");
		common.log("<br></br> Step :: Click on placebid button");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']"))
				.click();
		common.pause(40);

		common.acceptAlert1();
		common.pause(35);
//		String str = driver.findElement(By.xpath("//div[@class='bd-info bd-info-17888']//li[1]")).getText();
//		String str1 = driver.findElement(By.xpath("//div[@class='bd-info bd-info-17888']//li[2]")).getText();
//		String str2 = driver.findElement(By.xpath("//div[@class='bd-info bd-info-17888']//li[3]")).getText();
//		String str3 = driver.findElement(By.xpath("//div[@class='bd-info bd-info-17888']//li[4]")).getText();
//		
//		System.out.println("Box values : "+str+"/n"+str1+"/n"+str2+"/n"+str3);
//		common.log("Box values : "+str+"/n"+str1+"/n"+str2+"/n"+str3);
		common.jsClick(logout);
	}

	/**
	 * Place absentee bid
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param lotName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void Place_Absenteebid_follow(String auctionName, String lotName) throws InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale(auctionName); // Goto catalog page

		System.out.println("Step :: Click on catalog button");
		common.log("<br></br> Step :: Click on catalog button");
		common.pause(25);

		System.out.println("Step :: Fill absentee bid value");
		common.log("<br></br> Step :: Fill absentee bid value");

		common.pause(20);

		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_REGULAR_LIVE_BID + "']")).sendKeys("200");

		System.out.println("Step :: Click on placebid button");
		common.log("<br></br> Step :: Click on placebid button");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']"))
				.click();
		common.pause(15);

		System.out.println("Step :: Click on follow button");
		common.log("<br></br> Step :: Click on follow button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_FOLLOW + "']")).click();

		common.pause(15);

		common.jsClick(logout);
	}

	/**
	 * 
	 * Place bid from watchlist page
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param lotName
	 * @throws AWTException
	 */

	public void bid_From_WatchList(String saleno, String auctionName, String lotName) throws AWTException {

		goto_Catalog_Page_Live_Sale(auctionName); // Goto catalog page

		common.pause(20);
		System.out.println("Step :: Click on Add to watchlist button >>" + lotName);
		common.log("<br></br> Step :: Click on Add to watchlist button");
		WebElement webele = driver.findElement(By.xpath("//li[@id='lot1']//label[1]"));
		common.jsClick(webele);
		common.pause(15);

		common.acceptAlert1();
		common.log("Step :: Accept Alert");
		System.out.println("Step :: accept alert");
		common.pause(10);

		System.out.println("Step :: Click on View My Watchlist");
		common.log("<br></br> Step :: Click on View My Watchlist");
		driver.findElement(By.xpath("//a[@class='" + LEGACY_USER_CATALOG_VIEW_MY_WATCHLIST + "']")).click();

		common.pause(20);

		System.out.println("Step :: Select 100 from dropdown >> " + lotName);
		common.log("<br></br> Step :: Select 100 from dropdown >> " + lotName);
		driver.findElement(By.xpath("//select[@id='" + LEGACY_USER_LOT_DROPDOWN + "']//option[@value='3']")).click();
		common.pause(15);

		System.out.println("Step :: Fill Placebid value");
		common.log("<br></br> Step :: Fill Placebid value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_REGULAR_LIVE_BID + "']")).sendKeys("350");
		common.pause(5);

		System.out.println("Step :: Click on Placebid button");
		common.log("<br></br> Step :: Click on Placebid button");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']"))
				.click();
		common.pause(30);

//		 System.out.println("Step :: Click on Confirm Button");
//		 common.log("<br></br> Step :: Click on Confirm button");
//		 driver.findElement(By.xpath("//input[@id='" +
//		 LEGACY_USER_BTN_PLACE_MULTIBID_CONFIRM + "']")).click();
//		 common.pause(10);

		common.log("Step :: Accept Alert");
		System.out.println("Step :: accept alert");
		common.acceptAlert1();
		common.pause(15);

	}

	/**
	 * 
	 * Place bid from watchlist page Hybrid
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param lotName
	 * @throws AWTException
	 * @throws InterruptedException
	 */

	public void bid_From_WatchList_Hybrid(String saleno, String auctionName, String lotName)
			throws AWTException, InterruptedException {

		goto_Catalog_Page_Hybrid(auctionName);

		common.waitForConditionIsElementPresent(
				"//h2//a[text()='" + lotName + "']//..//..//..//input[@type='checkbox']");
		System.out.println("Step :: Click on Add to watchlist button >> " + lotName);
		common.log("<br></br> Step :: Click on Add to watchlist button >> " + lotName);
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@type='checkbox']")).click();
		common.pause(15);

		common.acceptAlert();
		common.log("Step :: Accept Alert");
		System.out.println("Step :: accept alert");
		common.pause(10);

		System.out.println("Step :: Click on View My Watchlist");
		common.log("<br></br> Step :: Click on View My Watchlist");
		driver.findElement(By.xpath("//a[@class='" + LEGACY_USER_CATALOG_VIEW_MY_WATCHLIST + "']")).click();

		common.pause(15);

		System.out.println("Step :: Select 48 from dropdown >> " + lotName);
		common.log("<br></br> Step :: Select 48 from dropdown >> " + lotName);
		driver.findElement(By.xpath("//select[@id='" + LEGACY_USER_BTN_PAY_NOW + "']//option[@value='2']")).click();

		System.out.println("Step :: Fill Placebid value");
		common.log("<br></br> Step :: Fill Placebid value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_REGULAR_LIVE_BID + "']")).sendKeys("350");

		System.out.println("Step :: Click on Placebid button");
		common.log("<br></br> Step :: Click on Placebid button");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']"))
				.click();
		common.pause(30);

		// System.out.println("Step :: Click on Confirm Button");
		// common.log("<br></br> Step :: Click on Confirm button");
		// driver.findElement(By.xpath("//input[@id='" +
		// LEGACY_USER_BTN_PLACE_MULTIBID_CONFIRM + "']")).click();
		// common.pause(10);

		common.log("Step :: Accept Alert");
		System.out.println("Step :: accept alert");
		common.acceptAlert1();

	}

	/**
	 * Verify Admin chat message in livesale tab
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param lotName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void placebidonliveauctionchat_Enable(String saleno, String auctionName, String lotName)
			throws InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale(auctionName); // Goto catalog page

		System.out.println("Click on catalog button");
		common.log("<br></br> Step :: Click on catalog button");
		common.pause(40);

		System.out.println("Step :: Click on Live Sale link");
		common.log("<br></br>Step :: Click on Live Sale link");

		common.pause(25);
		if (!common.isElementPresent("//a[contains(text(),'Live Sale')]")) {

			driver.findElement(By.xpath("//a//span[text()='" + auctionName + "']")).click();

			common.pause(20);
			driver.findElement(By.xpath("//a[contains(text(),'View live sale now!')]")).click();
			common.pause(20);
		} else {

			driver.findElement(By.xpath("//a[contains(text(),'Live Sale')]")).click();
			common.pause(20);
		}

		String usermessage = driver.findElement(By.xpath("//div[@class='" + LEGACY_USER_SIGNUP_MESSAGES_VALUE + "']"))
				.getText();
		System.out.println("Step :: Message center\n :: " + usermessage);
		common.log("<br></br> Step :: Message center\n :: " + usermessage);

		common.pause(15);

		common.jsClick(logout);
	}

	public void placebidonliveauctionchat_Enable1(String saleno, String auctionName, String lotName)
			throws InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale_Auction(auctionName); // Goto catalog page

		System.out.println("Click on catalog button");
		common.log("<br></br> Step :: Click on catalog button");
		common.pause(40);

		System.out.println("Step :: Click on Live Sale link");
		common.log("<br></br>Step :: Click on Live Sale link");

		common.pause(25);
		if (!common.isElementPresent("//a[contains(text(),'Live Sale')]")) {

			driver.findElement(By.xpath("//a//span[text()='" + auctionName + "']")).click();

			common.pause(20);
			driver.findElement(By.xpath("//a[contains(text(),'View live sale now!')]")).click();
			common.pause(20);
		} else {

			driver.findElement(By.xpath("//a[contains(text(),'Live Sale')]")).click();
			common.pause(20);
		}

		String usermessage = driver.findElement(By.xpath("//div[@class='" + LEGACY_USER_SIGNUP_MESSAGES_VALUE + "']"))
				.getText();
		System.out.println("Step :: Message center\n :: " + usermessage);
		common.log("<br></br> Step :: Message center\n :: " + usermessage);

		common.pause(15);

		common.jsClick(logout);
	}

	/**
	 * 
	 * Verify admin chat message
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param lotName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void placebidonliveauctionchat_disable(String saleno, String auctionName, String lotName)
			throws InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale(auctionName); // Goto catalog page

		System.out.println("Step :: Click on catalog button");
		common.log("<br></br> Step :: Click on catalog button");
		common.pause(15);

		System.out.println("Step :: Click on Live Sale tab");
		common.log("<br></br> Step :: Click on Live Sale tab");

		common.pause(25);
		if (!common.isElementPresent("//a[contains(text(),'Live Sale')]")) {

			driver.findElement(By.xpath("//a//span[text()='" + auctionName + "']")).click();

			common.pause(20);
			driver.findElement(By.xpath("//a[contains(text(),'View live sale now!')]")).click();
			common.pause(20);
		} else {

			driver.findElement(By.xpath("//a[contains(text(),'Live Sale')]")).click();
			common.pause(20);
		}

		common.assertElementNotPresent("//div[@class='live-chat hide-close']");

		common.pause(15);

		common.jsClick(logout);
	}

	/**
	 * Verify start date in the past auction not started
	 * 
	 * @param name
	 * @param PastDate
	 * @throws AWTException
	 * @throws InterruptedException
	 */

	public void verifyStartDateInThePastAuctionNotStarted(String auctionname, String PastDate)
			throws AWTException, InterruptedException {

		common.log("<br></br> Step :: Click on Auction Overview Page");
		System.out.println("Step :: Click on Auction Overview Page");
		common.jsClick(auctionsubtab);// Go to Auction overview page
		common.pause(25);
		// Select Closed Only From Dropdown

		Actions actions = new Actions(driver);
		System.out.println("Step :: Select Closed Auction");
		common.log("<br></br> Step :: Select Closed Auction");
		common.pause(25);

		WebElement element = driver
				.findElement(By.xpath("//span[@id='" + LEGACY_USER_LST_AUCTION_SHOW + "']//..//..//a"));

		element.click();
		common.pause(20);

		Robot rb = new Robot();
		common.pause(10);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		common.pause(5);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		common.pause(5);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		common.pause(5);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		common.pause(5);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		common.pause(5);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		common.pause(20);
		// Mouse Event

		// Select Auctioneer Sagar

		System.out.println("Step :: Select Sagar Auctioneer");
		common.log("<br></br> Step :: Select Sagar Auctioneer");
		WebElement sagar = driver
				.findElement(By.xpath("//span[@id='" + LEGACY_USER_LST_SELECT_AUCTIONEER_SAGAR + "']//..//a"));

		sagar.click();

		// Mouse Event

		common.pause(5);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		common.pause(5);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		common.pause(5);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		common.pause(20);

		// WebElement select_Sagar = driver.findElement(By.linkText("Sagar"));
		// common.pause(20);
		//
		// actions.moveToElement(select_Sagar);
		// actions.moveToElement(select_Sagar).click().perform();
		// common.pause(20);

		// Select Live Only

		System.out.println("Step :: Select Live Only");
		common.log("<br></br> Step :: Select Live Only");
		WebElement liveonly = driver
				.findElement(By.xpath("//span[@id='" + LEGACY_USER_LST_SELECT_SALE_TYPE + "']//..//a"));

		liveonly.click();

		common.pause(5);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		common.pause(5);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		common.pause(5);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		common.pause(5);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		common.pause(20);
		// WebElement select_liveonly = driver.findElement(By.linkText("Live only"));
		// common.pause(20);
		//
		// actions.moveToElement(select_liveonly);
		// actions.moveToElement(select_liveonly).click().perform();
		// common.pause(20);

		System.out.println("Step :: Select 100 from dropdown");
		common.log("<br></br> Step :: Select 100 from dropdown");
		driver.findElement(By.xpath("//select[@id='" + LEGACY_ADMIN_LOT_TABLE + "']//option[@value='3']")).click();

		common.pause(20);

		common.log("<br></br> Step :: To verify Sale status closed display when show type all selected");
		System.out.println("Step :: To verify Sale status closed display when show type all selected");

		for (int i = 0; i < 20; i++) {

			if (common.isElementPresent("//ul[@class='auclting yura']//a[text()=' " + auctionname
					+ "']//..//..//span[text()='Sale closed']"))

			{
				common.log("auction " + auctionname + " Sale closed display");
				System.out.println("auction " + auctionname + " Sale closed display");

				common.assertElementPresent("//ul[@class='auclting yura']//a[text()=' " + auctionname
						+ "']//..//..//span[text()='Sale closed']");

				common.pause(10);
				break;
			} else {
				common.log("auction " + auctionname + " is not present in this page");
				System.out.println("auction " + auctionname + " is not  present in this page");

//				driver.findElement(By.xpath("//span[@id='" + LEGACY_USER_LST_NEXT_PAGE + "']//a[text()='Next']"))
//						.click();
				common.pause(15);
			}

		}

		/* Bidding now and upcoming */

		common.log("<br></br> Step :: Select show type Bidding now and upcoming from dropdown menu");
		System.out.println("Step :: Select show type Bidding now and upcoming from dropdown menu");

		WebElement biddingnowandupcoming = driver
				.findElement(By.xpath("//span[@id='" + LEGACY_USER_LST_AUCTION_SHOW + "']//..//a"));

		biddingnowandupcoming.click();

		common.pause(5);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		common.pause(5);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		common.pause(5);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		common.pause(20);

		verify_Auction_Not_Display(auctionname);

		/* Bidding now only */

		common.log("<br></br> Step :: Select show type Bidding now only from dropdown menu");
		System.out.println("Step :: Select show type Bidding now only from dropdown menu");

		WebElement biddingnowonly = driver
				.findElement(By.xpath("//span[@id='" + LEGACY_USER_LST_AUCTION_SHOW + "']//..//a"));

		biddingnowonly.click();
		common.pause(5);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		common.pause(5);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		common.pause(5);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		common.pause(5);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		common.pause(20);

		verify_Auction_Not_Display(auctionname); // Verify auction name is not
		// display

		/* Upcoming only */

		common.log("<br></br> Step :: Select show type Upcoming only only from dropdown menu");
		System.out.println("Step :: Select show type Upcoming only from dropdown menu");

		WebElement upcomingonly = driver
				.findElement(By.xpath("//span[@id='" + LEGACY_USER_LST_AUCTION_SHOW + "']//..//a"));

		upcomingonly.click();

		common.pause(5);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		common.pause(5);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		common.pause(5);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		common.pause(5);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		common.pause(5);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		common.pause(20);

		verify_Auction_Not_Display(auctionname); // Verify auction name is not
		// display

		/* Closed */

		common.log("<br></br> Step :: To verify Sale status closed display when show type closed selected");
		System.out.println("Step :: To verify Sale status closed display when show type closed selected");

		WebElement closed = driver.findElement(By.xpath("//span[@id='" + LEGACY_USER_LST_AUCTION_SHOW + "']//..//a"));

		closed.click();
		common.pause(5);

		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		common.pause(5);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		common.pause(5);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		common.pause(5);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		common.pause(5);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		common.pause(5);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		common.pause(20);

		for (int i = 0; i < 20; i++) {

			if (common.isElementPresent("//ul[@class='auclting yura']//a[text()=' " + auctionname
					+ "']//..//..//span[text()='Sale closed']"))

			{
				common.log("auction " + auctionname + " Sale closed display");
				System.out.println("auction " + auctionname + " Sale closed display");

				common.assertElementPresent("//ul[@class='auclting yura']//a[text()=' " + auctionname
						+ "']//..//..//span[text()='Sale closed']");

				common.pause(10);
				break;
			} else {
				common.log("auction " + auctionname + " is not present in this page");
				System.out.println("auction " + auctionname + " is not  present in this page");

				common.pause(15);
			}

		}

	}

	/**
	 * Consigor lot button not displays in my item page
	 * 
	 */

	public void myItemConsignorUploadNotDisplay() {
		System.out.println("\n\n Step:: Go to My item page.");
		common.log("<br></br> Step:: Go to My item page.");
		common.pause(60);
		driver.findElement(By.xpath("//a[contains(text(),'My Items')]")).click();

		common.pause(25);

		common.log("<br></br> Step :: Verify lot upload button not display");
		System.out.println("Step :: Verify lot upload button not display");
		common.assertElementNotPresent("//span[@id='" + LEGACY_USER_BTN_LOT_UPLOAD + "']");
		common.pause(10);

	}

	/**
	 * my item consignor lot button display
	 * 
	 */
	public void myItemConsignorUploadDisplay(String Inventoryname) {

		System.out.println("\n\n Step:: Go to My item page.");
		common.log("<br></br> Step:: Go to My item page.");
		common.pause(40);
		driver.findElement(By.xpath("//a[contains(text(),'My Items')]")).click();

		common.pause(40);
		// items consigned tab not available in new build

	}

	/**
	 * my item consignor lot button display1
	 * 
	 */
	public void MyItemconsignoruploaddisplay2(String Inventoryname) {

		System.out.println("\n\n Step:: Go to My item page.");
		common.log("<br></br> Step:: Go to My item page.");
		common.waitForConditionIsElementPresent("//*[@id='main-menu']/ul/li[2]/a/span");
		driver.findElement(By.xpath("//*[@id='" + LEGACY_FRONT_LOGIN_MYITEMS_TAB + "']/ul/li[2]/a/span")).click();

		common.pause(10);
		common.log("<br></br> Step :: Click on items consigned tab");
		System.out.println("Step :: Click on items consigned tab");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_FRONT_LOGIN_ITEM_CONSIGNED + "']")).click();

		common.log("<br></br> Step :: Verify lot upload button  display");
		System.out.println("Step :: Verify lot upload button  display");
		common.pause(10);

		System.out.println("Step :: Click on upload new lot");
		common.log("<br></br> Step :: Click on upload new lot");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_UPLOAD_NEW_LOT + "']")).click();
		common.pause(10);

		System.out.println("Step :: Verify sale assignment");
		common.assertElementPresent("//legend[text()='Auction & pricing information (optional)']");

		System.out.println("Step :: Verify sale assignment fields");
		common.assertElementPresent("//div[@class='section-auction-and-pricing legall']");

		System.out.println("Step :: Fill Inventory Name" + Inventoryname);
		common.pause(10);
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_TXT_INVENTORY_NAME + "']")).sendKeys(Inventoryname);

		System.out.println("Step :: Click on submit button");
		common.log("<br></br> Step :: Click on submit button");
		driver.findElement(By.xpath("//span[@id='" + LEGACY_USER_BTN_SUBMIT + "']")).click();

		System.out.println("Step :: Verify success message");
		common.log("<br></br> Step :: Verify success message");
		common.assertElementPresent("//div[text()='Success!']");

		common.pause(10);

		common.jsClick(logout);

	}

	/**
	 * consignor upload display
	 * 
	 * @param Inventoryname
	 * @param auctionname
	 */

	public void MyItemconsignoruploaddisplay3(String Inventoryname, String auctionname) {

		System.out.println("\n\n Step:: Go to My item page.");
		common.log("<br></br> Step:: Go to My item page.");
		common.waitForConditionIsElementPresent("//*[@id='" + LEGACY_FRONT_LOGIN_MYITEMS_TAB + "']/ul/li[2]/a/span");
		driver.findElement(By.xpath("//*[@id='" + LEGACY_FRONT_LOGIN_MYITEMS_TAB + "']/ul/li[2]/a/span")).click();

		common.pause(10);
		common.log("<br></br> Step :: Click on items consigned tab");
		System.out.println("Click on items consigned tab");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_FRONT_LOGIN_ITEM_CONSIGNED + "']")).click();

		common.log("<br></br> Step :: Verify lot upload button  display");
		System.out.println("Step :: Verify lot upload button  display");
		common.pause(10);

		System.out.println("Step :: Click on upload new lot");
		common.log("<br></br> Step :: Click on upload new lot");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_UPLOAD_NEW_LOT + "']")).click();
		common.pause(10);

		System.out.println("Step :: Verify sale assignment");
		common.log("<br></br> Step :: Verify sale assignment");
		common.assertElementPresent("//legend[text()='Auction & pricing information (optional)']");

		System.out.println("Step :: Verify sale assignment fields");
		common.assertElementPresent("//div[@class='section-auction-and-pricing legall']");

		System.out.println("Step :: Fill Inventory Name" + Inventoryname);
		common.log("<br></br> Step :: Fill Inventory name");
		common.pause(10);
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_TXT_INVENTORY_NAME + "']")).sendKeys(Inventoryname);

		common.waitForConditionIsElementPresent("//span//select[@id='" + LEGACY_USER_LST_SELECT_AUCTION + "']");
		System.out.println("Step :: Select auction from dropdown");
		common.log("<br></br> Step :: Select auction form dropdown");
		System.out.println("Auction name " + auctionname);
		driver.findElement(By.xpath(
				"//span//select[@id='" + LEGACY_USER_LST_SELECT_AUCTION + "']//option[text()='" + auctionname + "']"))
				.click();

		System.out.println("Step :: Fill start bidding value");
		common.log("<br></br> Step :: Fill start bidding value");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_TXT_START_BIDDING_VALUE + "']")).sendKeys("20");

		System.out.println("Step :: Fill Don't sell the item below  value");
		common.log("<br></br> Step :: Fill Don't sell the item below value");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_TXT_DONT_SALE_ITEM + "']")).sendKeys("50");

		System.out.println("Step :: Fill Estimate Range value");
		common.log("<br></br> Step :: Fill Estimate Range value");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_TXT_ESTIMATE_RANGE + "']")).sendKeys("30");

		System.out.println("Step :: Fill Estimate Range value");
		common.log("<br></br> Step :: Fill Estimate Range value");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_TXT_ESTIMATE_RANGE_1 + "']")).sendKeys("50");

		System.out.println("Step :: Click on submit button");
		common.log("<br></br> Step :: Click on submit button");
		driver.findElement(By.xpath("//span[@id='" + LEGACY_USER_BTN_SUBMIT + "']")).click();

		System.out.println("Step :: Verify success message");
		common.log("<br></br> Step :: Verify success message");
		common.assertElementPresent("//div[text()='Success!']");

		common.pause(10);

		common.jsClick(logout);

	}

	/**
	 * 
	 * Assign view catalog
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param na
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void Assignview_catalog(String saleno, String auctionName, String lotname)
			throws InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale(auctionName); // Goto catalog page

		System.out.println("Step :: Verify catalog page");
		// common.assertElementPresent("//a[@class='aucinfo']");
		common.pause(10);

		System.out.println("Step :: Click on LotDetails Page");
		driver.findElement(By.xpath("//a[@class='" + LEGACY_USER_LOT_TXT + "']")).click();
		common.pause(25);

		System.out.println("Step :: Verify Selected Category");
		String cat = driver.findElement(By.xpath("//span[@class='cat-header']")).getText();
		System.out.println("Verify Created Category Name ::" + cat);
		common.pause(10);

		System.out.println("verify Created lot name ::" + lotname);

	}

	/**
	 * 
	 * Assign view catalog
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param na
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void assignview_Catalog_Timedsale(String saleno, String auctionName, String lotname)
			throws InterruptedException, AWTException {

		goto_Catalog_Page_Timed_Sale(auctionName);

		common.pause(10);

		System.out.println("Step :: Click on LotDetails Page");
		driver.findElement(By.xpath("//a[@class='" + LEGACY_USER_LOT_TXT + "']")).click();
		common.pause(30);

		System.out.println("Step :: Verify Selected Category");
		String cat = driver.findElement(By.xpath("//div[@class='"+LEGACY_USER_SELECTED_CATEGORY+"']")).getText();
		System.out.println("Verify Created Category Name ::" + cat);
		common.pause(10);

		System.out.println("verify Created lot name ::" + lotname);

	}

	/**
	 * Verify Category
	 * 
	 * @param lotname
	 * @throws ParseException
	 * @throws InterruptedException
	 */

	public void VerifyCategory(String lotname, String category) throws ParseException, InterruptedException {

		common.log("<br></br> Step :: Click on Auction link");
		System.out.println("Step :: Click on Auction link");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(15);

		common.log("<br></br> Step :: Search Auction by category");
		System.out.println("Step :: Search Auction by category ");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_TXT_SEARCH_AUCTION_BY_CAT + "']")).sendKeys(category);

		common.log("<br></br> Step :: Click on Search Button");
		System.out.println("Step :: Click on Search Button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_CATEGORY_SEARCH_BTN + "']")).click();
		common.pause(25);

		System.out.println("Step :: Select page from dropdown");
		common.log("<br></br> Step :: Select page from dropdown");
		driver.findElement(By.xpath("//select[@id='" + LEGACY_ADMIN_INVENTORY_PAGINATOR_ID + "']//option[@value='2']"))
				.click();
		common.pause(15);

		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='" + LEGACY_USER_FRONT_BTN_ADVANCE_SEARCH_TOGGLE + "']")).click();
		common.pause(15);

		System.out.println("Step :: Select cat 1");
		common.log("<br></br> Step :: Select cat 1");
		driver.findElement(
				By.xpath("//ul[@class='" + LEGACY_USER_FRONT_RADIO_BTN_CAT_ADVANCE_SEARCH + "']//..[text()='cat1']"))
				.click();

		System.out.println("Step :: Click on Search Button");
		common.log("<br></br> Step :: Click on Search Button");
		driver.findElement(By.xpath("//input[@id=''" + LEGACY_USER_FRONT_BTN_ADVANCE_SEARCH + "'']")).click();

		System.out.println(lotname);

		for (int i = 0; i < 20; i++)

		{
			if (common.isElementPresent("//h2//a[text()='" + lotname + "']")) {

				System.out.println("Step :: Lot Display >> " + lotname);
				break;

			} else {

				System.out.println("Step :: Lot Not Display and click on next button");
				driver.findElement(By.xpath("//span[@class='paginator']//..[text()='Next']")).click();
			}

		}

		System.out.println("Step :: Click on lot details");
		common.log("<br></br> Step :: Click on lot details");
		driver.findElement(By.xpath("//section[@class='item-block-wrapper']//a[text()='" + lotname + "']")).click();

		System.out.println("Step :: Verify Selected Category");
		String cat = driver.findElement(By.xpath("//a[@class='category-link']")).getText();
		System.out.println("Verify Created Category Name ::" + cat);
		common.pause(10);
	}

	/**
	 * Assign view catalog multiple category
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param na
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void Assignview_catlog_multicategory(String saleno, String auctionName, String lotname1)
			throws InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale(auctionName); // Goto catalog page
		common.pause(25);
		System.out.println("Step :: Verify catalog page");
		// common.assertElementPresent("//a[@class='aucinfo']");
		common.pause(20);

		System.out.println("Step :: Click on LotDetails Page");
		driver.findElement(By.xpath("//a[@class='" + LEGACY_USER_LOT_TXT + "']")).click();
		common.pause(40);

		System.out.println("Step :: Verify Selected Category");
		String cat = driver.findElement(By.xpath("//div[@class='content ins_cnt description-info-content']")).getText();
		System.out.println("Step :: Verify Created Category Name >> " + cat);
		common.pause(20);

	}

	/**
	 * Assign view catalog multiple category timedsale
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param na
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void assignview_Catlog_Multicategory_Timedsale(String saleno, String auctionName, String lotname1)
			throws InterruptedException, AWTException {
		common.pause(20);
		goto_Catalog_Page_Timed_Sale(auctionName); // Goto catalog page
		common.pause(30);
		System.out.println("Step :: Click on LotDetails Page");
		common.waitForElement("//a[@class='" + LEGACY_USER_LOT_TXT + "']");
		driver.findElement(By.xpath("//a[@class='" + LEGACY_USER_LOT_TXT + "']")).click();
		common.pause(20);

		System.out.println("Step :: Verify Selected Category");
		String cat = driver.findElement(By.xpath("//div[@class='" + LEGACY_USER_SELECTED_CATEGORY + "']")).getText();
		System.out.println("Step :: Verify Created Category Name >> " + cat);
		common.pause(20);

	}

	/**
	 * verify multiple category
	 * 
	 * @param na
	 * @throws ParseException
	 * @throws InterruptedException
	 */
	public void Verify_multiple_Category(String lotname) throws ParseException, InterruptedException {

		// Search Cat 1

		common.log("<br></br> Step :: Click on Auction link");
		System.out.println("Step :: Click on Auction link");
		driver.findElement(By.xpath("//li//a[text()='" + LEGACY_FRONT_AUCTIONS_BUTTON + "']")).click();
		common.pause(15);

		common.log("<br></br> Step :: Search Category");
		System.out.println("Step :: Search Category");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_TXT_SEARCH_AUCTION_BY_CAT + "']")).sendKeys("cat2");
		common.pause(15);

		common.log("<br></br> Step :: Click on Search Button");
		System.out.println("Step :: Click on Search Button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_TXT_SEARCH_CATEGORY_BUTTON + "']")).click();
		common.pause(25);

		System.out.println("Step :: Select page from dropdown");
		common.log("<br></br> Step :: Select page from dropdown");
		driver.findElement(
				By.xpath("//select[@id='" + LEGACY_USER_SELECT_PAGE_FROM_DROPDOWN + "']//option[@value='2']")).click();
		common.pause(15);

		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='" + LEGACY_USER_BTN_CATEGORY_SEARCH_BTN_ADVANCE + "']")).click();
		common.pause(15);

		System.out.println("Step :: Select cat 2");
		common.log("<br></br> Step :: Select cat 2");
		driver.findElement(By.xpath("//label[text()='" + LEGACY_USER_SELECT_CAT2 + "']//..[@for='"
				+ LEGACY_USER_ADVANCE_SEARCH_CAT2 + "']")).click();
		common.pause(10);

		System.out.println("Step :: Select LiveAuction");
		common.log("<br></br> Step :: Select LiveAuciton");
		driver.findElement(By.xpath("//label[text()='" + LEGACY_USER_SELECT_LIVE_AUCTION + "']")).click();
		common.pause(15);

		System.out.println("Step :: Click on Exclude lot");
		common.log("<br></br> Step :: Click on Exclude lot");
		driver.findElement(By.xpath("//label[text()='" + LEGACY_USER_CLICK_ON_EXCLUDE_LOTS + "']")).click();
		common.pause(15);

		System.out.println("Step :: Click on Search Button");
		common.log("<br></br> Step :: Click on Search Button");
		driver.findElement(By.xpath("//input[@id=''" + LEGACY_USER_FRONT_BTN_ADVANCE_SEARCH + "'']")).click();

		System.out.println(lotname);

		for (int i = 0; i < 20; i++)

		{
			if (common.isElementPresent("//h2//a[text()='" + lotname + "']")) {

				System.out.println("Step :: Lot Display >> " + lotname);
				break;

			} else {

				System.out.println("Step :: Lot Not Display and click on next button");
				driver.findElement(By.xpath("//span[text()='" + LEGACY_USER_BTN_NEXT + "']")).click();
			}

		}

		System.out.println("Step :: Click on lot details");
		common.log("<br></br> Step :: Click on lot details");
		driver.findElement(By.xpath("//section[@class='" + LEGACY_USER_LOT_DETAIL + "']//a[text()='" + lotname + "']"))
				.click();

		System.out.println("Step :: Verify Selected Category");
		String cat = driver.findElement(By.xpath("//a[@class='" + LEGACY_USER_SELECT_CATEGORY + "']")).getText();
		System.out.println("Verify Created Category Name ::" + cat);
		common.pause(10);

		// Search Cat 2

		common.log("<br></br> Step :: Click on Auction link");
		System.out.println("Step :: Click on Auction link");
		driver.findElement(By.xpath("//li//a[text()='" + LEGACY_FRONT_LOGIN_TXT_AUCTIONS + "']")).click();
		common.pause(15);

		common.log("<br></br> Step :: Search Category");
		System.out.println("Step :: Search Category");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_TXT_SEARCH_AUCTION_BY_CAT + "']")).sendKeys("cat3");
		common.pause(15);

		common.log("<br></br> Step :: Click on Search Button");
		System.out.println("Step :: Click on Search Button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_TXT_SEARCH_CATEGORY_BUTTON + "']")).click();
		common.pause(25);

		System.out.println("Step :: Select page from dropdown");
		common.log("<br></br> Step :: Select page from dropdown");
		driver.findElement(
				By.xpath("//select[@id='" + LEGACY_USER_SELECT_PAGE_FROM_DROPDOWN + "']//option[@value='2']")).click();
		common.pause(15);

		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='" + LEGACY_USER_BTN_CATEGORY_SEARCH_BTN_ADVANCE + "']")).click();
		common.pause(15);

		System.out.println("Step :: Select cat 2");
		common.log("<br></br> Step :: Select cat 2");
		driver.findElement(By.xpath("//label[text()='" + LEGACY_USER_SELECT_CAT2 + "']//..[@for='"
				+ LEGACY_USER_ADVANCE_SEARCH_CAT2 + "']")).click();

		System.out.println("Step :: Select LiveAuction");
		common.log("<br></br> Step :: Select LiveAuciton");
		driver.findElement(By.xpath("//label[text()='" + LEGACY_USER_SELECT_LIVE_AUCTION + "']")).click();

		System.out.println("Step :: Click on Search Button");
		common.log("<br></br> Step :: Click on Search Button");
		driver.findElement(By.xpath("//input[@id=''" + LEGACY_USER_FRONT_BTN_ADVANCE_SEARCH + "'']")).click();

		System.out.println(lotname);

		for (int i = 0; i < 20; i++)

		{
			if (common.isElementPresent("//h2//a[text()='" + lotname + "']")) {

				System.out.println("Step :: Lot Display >> " + lotname);
				break;

			} else {

				System.out.println("Step :: Lot Not Display and click on next button");
				driver.findElement(By.xpath("//span[text()='" + LEGACY_USER_BTN_NEXT + "']")).click();
			}

		}

		System.out.println("Step :: Click on lot details");
		common.log("<br></br> Step :: Click on lot details");
		driver.findElement(By.xpath("//section[@class='" + LEGACY_USER_LOT_DETAIL + "']//a[text()='" + lotname + "']"))
				.click();

		System.out.println("Step :: Verify Selected Category");
		String cat1 = driver.findElement(By.xpath("//a[@class='" + LEGACY_USER_SELECT_CATEGORY + "']")).getText();
		System.out.println("Verify Created Category Name ::" + cat1);
		common.pause(10);

	}

	/**
	 * check the option save with upload image
	 * 
	 * 
	 * @param Inventoryname
	 * @param auctionname
	 */

	public void myItemConsignorUploadWithImage(String Inventoryname, String auctionname) {

		System.out.println("\n\n Step:: Go to My item page.");
		common.log("<br></br> Step:: Go to My item page.");
		common.pause(30);
		driver.findElement(By.xpath("//a[text()='" + LEGACY_FRONT_LOGIN_TXT_ITEMS + "']")).click();

		common.pause(10);
		// common.log("<br></br> Step :: Click on items consigned tab");
		// System.out.println("Click on items consigned tab");
		// driver.findElement(By.xpath("//a[text()='Items consigned']")).click();
		//
		// common.log("<br></br> Step :: Verify lot upload button display");
		// System.out.println("Step :: Verify lot upload button display");
		// common.pause(30);

		// System.out.println("Step :: Click on upload new lot");
		// common.log("<br></br> Step :: Click on upload new lot");
		// driver.findElement(By.xpath("//input[@id='" +
		// LEGACY_USER_BTN_UPLOAD_NEW_LOT + "']")).click();
		// common.pause(30);
		//
		// System.out.println("Step :: Verify sale assignment");
		// common.log("<br></br> Step :: Verify sale assignment");
		// common.assertElementPresent("//legend[text()='Auction & pricing
		// information (optional)']");
		//
		// System.out.println("Step :: Verify sale assignment fields");
		// common.assertElementPresent("//div[@class='section-auction-and-pricing
		// legall']");
		//
		// System.out.println("Fill Inventory Name" + Inventoryname);
		// common.log("<br></br> Step :: Fill Inventory name");
		// common.pause(30);
		// driver.findElement(By.xpath("//input[@id='" +
		// LEGACY_USER_TXT_INVENTORY_NAME + "']")).sendKeys(Inventoryname);
		//
		// System.out.println("Step :: Select auction from dropdown");
		// common.log("<br></br> Step :: Select auction form dropdown");
		// WebElement dropdown = driver.findElement(By.xpath("//select[@id='" +
		// LEGACY_USER_LST_SELECT_AUCTION
		// + "']//option[contains(text(),'" + auctionname + "')]"));
		//
		// dropdown.click();
		//
		// System.out.println("Step :: Fill start bidding value");
		// common.log("<br></br> Step :: Fill start bidding value");
		// driver.findElement(By.xpath("//input[@id='" +
		// LEGACY_USER_TXT_START_BIDDING_VALUE + "']")).sendKeys("20");
		//
		// System.out.println("Step :: Fill Don't sell the item below value");
		// common.log("<br></br> Step :: Fill Don't sell the item below value");
		// driver.findElement(By.xpath("//input[@id='" +
		// LEGACY_USER_TXT_DONT_SALE_ITEM + "']")).sendKeys("50");
		//
		// System.out.println("Step :: Fill Estimate Range value");
		// common.log("<br></br> Step :: Fill Estimate Range value");
		// driver.findElement(By.xpath("//input[@id='" +
		// LEGACY_USER_TXT_ESTIMATE_RANGE + "']")).sendKeys("30");
		//
		// System.out.println("Step :: Fill Estimate Range value");
		// common.log("<br></br> Step :: Fill Estimate Range value");
		// driver.findElement(By.xpath("//input[@id='" +
		// LEGACY_USER_TXT_ESTIMATE_RANGE_1 + "']")).sendKeys("50");
		//
		// System.out.println("Step :: Click on upload image button");
		// common.log("<br></br> Step :: Click on upload image button");
		// driver.findElement(By.xpath("//a[@id='" +
		// LEGACY_USER_BTN_IMAGE_UPLOAD + "']")).click();
		//
		// System.out.println("Step :: Enter Image URL");
		// common.log("<br></br> Step :: Enter Image URL");
		// common.type("//input[@id='" + LEGACY_USER_TXT_IMAGE_UPLOAD + "']",
		// LEGACY_ADMIN_AUCTION_UPLOAD_IMAGE_PATH);
		//
		// System.out.println("Step :: Click on upload image button");
		// common.log("<br></br> Step :: Click on upload image button");
		// driver.findElement(By.xpath("//input[@id='" +
		// LEGACY_USER_BTN_IMAGE_SUBMIT + "']")).click();
		//
		// System.out.println("Step :: Click on upload button");
		// common.log("<br></br> Step :: Click on upload button");
		// driver.findElement(By.xpath("//span[@id='" + LEGACY_USER_BTN_SUBMIT +
		// "']")).click();
		//
		// System.out.println("Step :: Verify success message");
		// common.log("<br></br> Step :: Verify success message");
		// common.assertElementPresent("//div[text()='Success!']");
		//
		// common.pause(30);
		//
		// common.jsClick(logout);

	}

	/**
	 * Buylot from catalog multibidder
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param lotName
	 * @param lotName1
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void buyLotFromCatalogmultibidder(String saleno, String auctionName, String lotName, String lotName1)
			throws InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale(auctionName); // Goto catalog Page

		common.pause(15);

		System.out.println("Step :: Fill buy now value");
		common.type("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='" + LEGACY_USER_TXT_REGULAR_LIVE_BID
				+ "']", LEGACY_ADMIN_TXT_BUY_NOW_VALUE);

		common.log("<br></br> Step :: Click on buy now button");
		System.out.println("Step :: Click on buy now button");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@value='Buy now!']")).click();
		common.pause(15);

		common.log("<br></br> Step :: Click on confirm button");
		System.out.println("Step :: Click on confirm button");
		driver.findElement(By.xpath("//input[@value='" + LEGACY_USER_BTN_CONFIRM + "']")).click();

		common.pause(15);

		common.log("<br></br> Step :: Verify Winner Message");
		System.out.println("Step :: Verify Winner Message");
		common.isElementPresent("//span[contains(text(),'Your high bid!')]");

		common.pause(15);

		driver.findElement(By.xpath("//a[text()='" + LEGACY_USER_CATALOG + "']")).click();

		common.pause(15);
		System.out.println("Step :: Buy second number lot >>" + lotName1);

		System.out.println("Step :: Fill buy now value");
		common.type("//h2//a[text()='" + lotName1 + "']//..//..//..//input[@class='" + LEGACY_USER_TXT_REGULAR_LIVE_BID
				+ "']", LEGACY_USER_TXT_BUY_NOW_VALUE);

		common.log("<br></br> Step :: Click on buy now button");
		System.out.println("Step :: Click on buy now button");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName1 + "']//..//..//..//input[@value='Buy now!']"))
				.click();
		common.pause(15);

		common.log("<br></br> Step :: Click on confirm button");
		System.out.println("Step :: Click on confirm button");
		driver.findElement(By.xpath("//input[@value='" + LEGACY_USER_BTN_CONFIRM + "']")).click();

		common.pause(15);

		common.log("<br></br> Step :: Verify Winner Message");
		System.out.println("Step :: Verify Winner Message");
		common.isElementPresent("//span[contains(text(),'Your high bid!')]");

		common.pause(15);

		driver.findElement(By.xpath("//a[text()='" + LEGACY_USER_CATALOG + "']")).click();

		common.pause(15);

		System.out.println("Step :: Click on logout");
		common.jsClick(logout);
	}

	/**
	 * Buy Lot Form catalog multibidder
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param lotName2
	 * @param lotName3
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	public void buyLotFromCatalogmultibidder1(String saleno, String auctionName, String lotName2, String lotName3)
			throws InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale(auctionName); // Goto catalog page

		common.pause(15);

		System.out.println("Step :: Fill buy now value");

		System.out.println("Step :: Click on buy now button" + lotName2);

		common.type("//h2//a[text()='" + lotName2 + "']//..//..//..//input[@class='" + LEGACY_USER_TXT_REGULAR_LIVE_BID
				+ "']", LEGACY_USER_TXT_BUY_NOW_VALUE);

		common.log("<br></br> Step :: Click on buy now button");
		System.out.println("Step :: Click on buy now button");
		driver.findElement(
				By.xpath("//h2//a[text()='" + lotName2 + "']//..//..//..//input[@value='" + LEGACY_USER_BUY_NOW + "']"))
				.click();
		common.pause(15);

		common.log("<br></br> Step :: Click on confirm button");
		System.out.println("Step :: Click on confirm button");
		driver.findElement(By.xpath("//input[@value='" + LEGACY_USER_BTN_CONFIRM + "']")).click();

		common.pause(15);

		common.log("<br></br> Step :: Verify Winner Message");
		System.out.println("Step :: Verify Winner Message");
		common.isElementPresent("//span[contains(text(),'Your high bid!')]");

		common.pause(15);

		driver.findElement(By.xpath("//a[text()='" + LEGACY_USER_CATALOG + "']")).click();

		common.pause(15);

		System.out.println("Step :: Buy second number lot >>" + lotName3);

		System.out.println("Step :: Fill buy now value");
		common.type("//h2//a[text()='" + lotName3 + "']//..//..//..//input[@class='" + LEGACY_USER_TXT_REGULAR_LIVE_BID
				+ "']", LEGACY_USER_TXT_BUY_NOW_VALUE);

		common.log("<br></br> Step :: Click on buy now button");
		System.out.println("Step :: Click on buy now button");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName3 + "']//..//..//..//input[@value='Buy now!']"))
				.click();
		common.pause(15);

		common.log("<br></br> Step :: Click on confirm button");
		System.out.println("Step :: Click on confirm button");
		driver.findElement(By.xpath("//input[@value='" + LEGACY_USER_BTN_CONFIRM + "']")).click();

		common.pause(15);

		common.log("<br></br> Step :: Verify Winner Message");
		System.out.println("Step :: Verify Winner Message");
		common.isElementPresent("//span[contains(text(),'Your high bid!')]");

		common.pause(15);

		driver.findElement(By.xpath("//a[text()='" + LEGACY_USER_CATALOG + "']")).click();

		common.pause(15);

		common.jsClick(logout);
	}

	/**
	 * Catalog Section
	 * 
	 * @param auctionName
	 * @throws ParseException
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void catlogSectionGetPDFText(String auctionName) throws ParseException, InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale(auctionName); // Goto catalog Page
		common.pause(20);
		String pdf = driver.findElement(By.xpath("//a[text()='PDF Catalog']")).getText();

		System.out.println("Step :: PDF TEXT IS DIPLAY ::" + pdf);
		common.pause(10);

	}

	/**
	 * Verify Estimate Values
	 * 
	 * @param auctionName
	 * @throws InterruptedException
	 */
	public void verify_Estimate_Values_Front(String auctionName, String saleno) throws InterruptedException {

		common.pause(30);
		String estimate = driver.findElement(By.xpath(
				"//span[text()='" + LEGACY_USER_ESTIMATE + "']//..//span[@class='" + LEGACY_USER_ESTIMATE_VALUE + "']"))
				.getText();
		System.out.println("Step :: Estimate displayed :: " + estimate);
		common.log("<br></br> Step :: Estimate displayed :: " + estimate);

		String starting = driver.findElement(By.xpath("//span[text()='Starting']//..//span[@class='value']")).getText();
		System.out.println("Step :: Estimate displayed :: " + starting);
		common.log("<br></br> Step :: Estimate displayed :: " + starting);

	}

	/**
	 * Verify Estimate Values List View
	 * 
	 * @param auctionName
	 */
	public void verify_Estimate_Values_Front_List_View(String auctionName, String saleno) {

		System.out.println("Step :: Click on List View");
		common.log("<br></br> Step :: Click on List View");
		common.pause(15);

		if (!common.isElementPresent("//a[@class='lst  current']")) {

			System.out.println("Step :: Click on List View");
			common.log("<br></br> Step :: Click on List View");
			driver.findElement(By.xpath("//a[@class='lst ']")).click();
		}

		common.pause(25);

		String estimate = driver.findElement(By.xpath("//span[text()='Estimates']//..//span[@class='value']"))
				.getText();
		System.out.println("Step :: Estimate displayed :: " + estimate);
		common.log("<br></br> Step :: Estimate displayed :: " + estimate);

		String starting = driver.findElement(By.xpath("//span[text()='Starting']//..//span[@class='value']")).getText();
		System.out.println("Step :: Estimate displayed :: " + starting);
		common.log("<br></br> Step :: Estimate displayed :: " + starting);

	}

	/**
	 * Place Bid List View
	 * 
	 * @param lotName
	 * @param auctionName
	 * @throws AWTException
	 */

	public void fill_Place_Bid_List_View(String lotName, String auctionName) throws AWTException {
		goto_Catalog_Page_Hybrid(auctionName);

		System.out.println("Step :: Click on List View");
		common.log("<br></br> Step :: Click on List View");
		common.pause(15);

		if (!common.isElementPresent("//a[@class='lst  current']")) {

			System.out.println("Step :: Click on List View");
			common.log("<br></br> Step :: Click on List View");
			driver.findElement(By.xpath("//a[@class='lst ']")).click();
		}

		common.pause(25);

		System.out.println("Step :: Fill Place bid value");
		common.log("<br></br> Step :: Fill Place  bid value");
		driver.findElement(
				By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//..//input[@class='textbox live-regularbid']"))
				.sendKeys("200");

		System.out.println("Step :: Click on Placebid Button");
		common.log("<br></br> Step :: Click on Placebid Button");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//..//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']"))
				.click();
		common.pause(20);
		common.acceptAlert();
//		common.log("<br></br> Step :: Click on confirm button");
//		System.out.println("Step :: Click on confirm button");
//		driver.findElement(By.xpath("//input[@value='" + LEGACY_USER_BTN_CONFIRM + "']")).click();
//		common.pause(10);

//		common.acceptAlert1();
		common.pause(20);
		common.log("<br></br> Step :: Click on Logout Button");
		System.out.println("Step :: Click on Logout Button");
		driver.findElement(By.xpath("//a[text()='Logout']")).click(); // Click
																		// on
																		// logout
	}

	/**
	 * Place Bid List View Live Sale
	 * 
	 * @param lotName
	 * @param auctionName
	 * @throws AWTException
	 */

	public void fill_Place_Bid_List_View_LiveSale(String lotName, String auctionName) throws AWTException {

		goto_Catalog_Page_Live_Sale(auctionName);

		System.out.println("Step :: Click on List View");
		common.log("<br></br> Step :: Click on List View");
		common.pause(15);

		if (!common.isElementPresent("//a[@class='lst  current']")) {

			System.out.println("Step :: Click on List View");
			common.log("<br></br> Step :: Click on List View");
			driver.findElement(By.xpath("//a[@class='lst ']")).click();
		}

		common.pause(25);

		System.out.println("Step :: Fill Place bid value");
		common.log("<br></br> Step :: Fill Place  bid value");
		driver.findElement(
				By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//..//input[@class='textbox live-regularbid']"))
				.sendKeys("200");

		System.out.println("Step :: Click on Placebid Button");
		common.log("<br></br> Step :: Click on Placebid Button");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//..//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']"))
				.click();
		common.pause(15);

		// common.log("<br></br> Step :: Click on confirm button");
		// System.out.println("Step :: Click on confirm button");
		// driver.findElement(By.xpath("//input[@value='" +
		// LEGACY_USER_BTN_CONFIRM + "']")).click();
		// common.pause(10);

		common.acceptAlert();

		common.log("<br></br> Step :: Click on Logout Button");
		System.out.println("Step :: Click on Logout Button");
		driver.findElement(By.xpath("//a[text()='Logout']")).click(); // Click
																		// on
																		// logout
	}

	/**
	 * Place Bid From Compact View
	 * 
	 * @param lotName
	 * @param auctionName
	 * @throws AWTException
	 */

	public void fill_Place_Bid_Compact_View(String lotName, String auctionName) throws AWTException {
		goto_Catalog_Page_Hybrid(auctionName);

		System.out.println("Step :: Click on List View");
		common.log("<br></br> Step :: Click on List View");
		common.pause(15);

		if (!common.isElementPresent("//a[@class='com  current']")) {

			System.out.println("Step :: Click on List View");
			common.log("<br></br> Step :: Click on List View");
			driver.findElement(By.xpath("//a[@class='com ']")).click();
		}

		common.pause(25);

		System.out.println("Step :: Fill Place bid value");
		common.log("<br></br> Step :: Fill Place  bid value");
		driver.findElement(
				By.xpath("//a[text()='" + lotName + "']//..//..//..//..//input[@class='textbox live-regularbid']"))
				.sendKeys("200");

		System.out.println("Step :: Click on Placebid Button");
		common.log("<br></br> Step :: Click on Placebid Button");
		driver.findElement(By.xpath(
				"//a[text()='" + lotName + "']//..//..//..//..//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']"))
				.click();
		common.pause(20);
		common.acceptAlert();
//		common.log("<br></br> Step :: Click on confirm button");
//		System.out.println("Step :: Click on confirm button");
//		driver.findElement(By.xpath("//input[@value='" + LEGACY_USER_BTN_CONFIRM + "']")).click();
//		common.pause(10);
//
//		common.acceptAlert1();
		common.pause(20);
		common.log("<br></br> Step :: Click on Logout Button");
		System.out.println("Step :: Click on Logout Button");
		driver.findElement(By.xpath("//a[text()='Logout']")).click(); // Click
																		// on
																		// logout
	}

	/**
	 * Verify Estimate Values List View
	 * 
	 * @param auctionName
	 */
	public void verify_Estimate_Values_Front_Compact_View(String auctionName, String saleno) {

		System.out.println("Step :: Click on Compact View");
		common.log("<br></br> Step :: Click on Compact View");
		common.pause(15);

		if (!common.isElementPresent("//a[@class='com  current']")) {

			System.out.println("Step :: Click on Compact View");
			common.log("<br></br> Step :: Click on Compact View");
			driver.findElement(By.xpath("//a[@class='com ']")).click();
		}

		common.pause(25);

		String estimate = driver.findElement(By.xpath("//span[text()='Estimates']//..//span[@class='value']"))
				.getText();
		System.out.println("Step :: Estimate displayed :: " + estimate);
		common.log("<br></br> Step :: Estimate displayed :: " + estimate);

		String starting = driver.findElement(By.xpath("//span[text()='Starting']//..//span[@class='value']")).getText();
		System.out.println("Step :: Estimate displayed :: " + starting);
		common.log("<br></br> Step :: Estimate displayed :: " + starting);

	}

	/**
	 * Verify Starting bid estimate
	 * 
	 * @param auctionName
	 */
	public void verify_Starting_Bid_Catalogpage(String auctionName, String saleno) {

		System.out.println("Step :: Click on Live Sale tab");
		common.log("<br></br> Step :: Click on Live Sale tab");

		common.pause(25);
		if (!common.isElementPresent("//a[contains(text(),'Live Sale')]")) {

			driver.findElement(By.xpath("//a//span[text()='" + auctionName + "']")).click();

			common.pause(20);
			driver.findElement(By.xpath("//a[contains(text(),'View live sale now!')]")).click();
			common.pause(20);
		} else {

			driver.findElement(By.xpath("//a[contains(text(),'Live Sale')]")).click();
			common.pause(20);
		}

		common.waitForElement(By.xpath("//div[@class='messages']"));
		String usermessage = driver.findElement(By.xpath("//div[@class='messages']")).getText();

		System.out.println("Step :: Message center\n :: " + usermessage);
		common.log("<br></br> Step :: Message center\n :: " + usermessage);

	}

	/**
	 * Verify Starting bid estimate
	 * 
	 * @param auctionName
	 */
	public void verify_Starting_Bid_Message_Center(String auctionName, String saleno) {

		System.out.println("Step :: Click on Live Sale tab");
		common.log("<br></br> Step :: Click on Live Sale tab");

		common.pause(25);
		common.pause(25);
		if (!common.isElementPresent("//a[contains(text(),'Live Sale')]")) {

			driver.findElement(By.xpath("//a//span[text()='" + auctionName + "']")).click();

			common.pause(20);
			driver.findElement(By.xpath("//a[contains(text(),'View live sale now!')]")).click();
			common.pause(20);
		} else {

			driver.findElement(By.xpath("//a[contains(text(),'Live Sale')]")).click();
			common.pause(20);
		}

		String usermessage = driver.findElement(By.xpath("//div[@class='messages']")).getText();

		System.out.println("Step :: Message center\n :: " + usermessage);
		common.log("<br></br> Step :: Message center\n :: " + usermessage);
	}

	/**
	 * Place absentee bid on 2 lot
	 * 
	 * @throws AWTException
	 * 
	 **/

	public void placeAbsenteeBidOn2Lot(String saleno, String auctionName, String lotName, String lotName1)
			throws InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale(auctionName);

		System.out.println("Step :: Click on catalog button");
		common.log("<br></br> Step :: Click on catalog button");
		common.pause(20);

		System.out.println("Step :: Fill absntee bid value in lot1");
		common.log("<br></br> Step :: Fill absntee bid value in lot1");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_REGULAR_LIVE_BID + "']")).sendKeys(LEGACY_USER_TXT_ABSENTEE_BID_VALUE);
		common.pause(5);
		System.out.println("Step :: Fill absntee bid value in lot2");
		common.log("<br></br> Step :: Fill absntee bid value in lot2");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName1 + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_REGULAR_LIVE_BID + "']")).sendKeys(LEGACY_USER_TXT_ABSENTEE_BID_VALUE);
		common.pause(15);
		System.out.println("Step :: Click on place multibid button");
		common.log("<br></br> Step :: Click on place multibid button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_PLACE_MULTIBID + "']")).click();
		common.pause(30);
		System.out.println("Step :: Click on Confirm button");
		common.log("<br></br> Step :: Click on Confirm button");
		// driver.findElement(By.xpath("//input[@value='Confirm']")).click();
		// common.pause(25);
		common.acceptAlert1();
		common.pause(5);

	}

	/**
	 * Place absentee bid on 4 lot
	 * 
	 * @throws AWTException
	 * 
	 **/

	public void placeabsenteebidon4lot(String saleno, String auctionName, String lotName, String lotName1,
			String lotName2, String lotName3) throws InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale(auctionName);

		common.pause(40);

		System.out.println("Step :: Fill absntee bid value in lot1");
		common.log("<br></br> Step :: Fill absntee bid value in lot1");

		System.out.println("Step :: Lot Name >> " + lotName);
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_REGULAR_LIVE_BID + "']")).sendKeys("200");

		System.out.println("Step :: Lot Name >> " + lotName3);
		System.out.println("Step :: Fill absntee bid value in lot2");
		common.log("<br></br> Step :: Fill absntee bid value in lot2");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName3 + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_REGULAR_LIVE_BID + "']")).sendKeys("200");

		System.out.println("Step :: Click on place multibid button");
		common.log("<br></br> Step :: Click on place multibid button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_PLACE_MULTIBID + "']")).click();
		common.pause(50);
		// common.waitForConditionIsElementPresent("//span//input[@id='" +
		// LEGACY_USER_BTN_PLACE_MULTIBID_CONFIRM + "']");
		System.out.println("Step :: Click on Confirm Button");
		common.log("<br></br> Step :: Click on Confirm Button");

		common.log("<br></br> Step :: Click on Confirm button");
		System.out.println("Step :: Click on Confirm button");
		// driver.findElement(By.xpath("//input[@id='pblc2']")).click();
		common.pause(25);
		common.acceptAlert1();
		common.pause(10);
	}

	/**
	 * Place absentee bid on 4 lot Hybrid
	 * 
	 * @throws AWTException
	 * 
	 **/

	public void place_Absentee_Bid_on_4_Lot_Hybrid(String saleno, String auctionName, String lotName, String lotName1,
			String lotName2, String lotName3) throws InterruptedException, AWTException {

		goto_Catalog_Page_Hybrid(auctionName);

		common.pause(30);

		System.out.println("Step :: Fill absntee bid value in lot1");
		common.log("<br></br> Step :: Fill absntee bid value in lot1");

		System.out.println("Step :: Lot Name >> " + lotName);
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_REGULAR_LIVE_BID + "']")).sendKeys("200");

		System.out.println("Step :: Lot Name >> " + lotName3);
		System.out.println("Step :: Fill absntee bid value in lot2");
		common.log("<br></br> Step :: Fill absntee bid value in lot2");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName3 + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_REGULAR_LIVE_BID + "']")).sendKeys("200");

		common.pause(10);
		System.out.println("Step :: Click on place multibid button");
		common.log("<br></br> Step :: Click on place multibid button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_PLACE_MULTIBID + "']")).click();
		common.pause(20);
		common.acceptAlert();

//
//		System.out.println("Step :: Click on Confirm button");
//		common.log("<br></br> Step :: Click on Confirm button");
//		driver.findElement(By.xpath("//input[@value='Confirm']")).click();
//		common.pause(20);
		// common.acceptAlert1();
		common.pause(5);
	}

	/**
	 * Stop absentee bid
	 * 
	 * @throws AWTException
	 * 
	 **/

	public void stopAbsenteeBid(String saleno, String auctionName, String lotName, String lotName1, String lotName2)
			throws InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale(auctionName); // Goto catalog page for place
													// bid

		System.out.println("Step :: Click on catalog button");
		common.log("<br></br> Step :: Click on catalog button");
		common.pause(10);

		System.out.println("Step :: Fill absntee bid value in lot1");
		common.log("<br></br> Step :: Fill absntee bid value in lot1");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_REGULAR_LIVE_BID + "']")).sendKeys(LEGACY_USER_TXT_ABSENTEE_BID_VALUE_FIVE_HUNDRED);
		common.pause(10);

		System.out.println("Step :: Fill absntee bid value in lot2");
		common.log("<br></br> Step :: Fill absntee bid value in lot2");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName1 + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_REGULAR_LIVE_BID + "']")).sendKeys(LEGACY_USER_TXT_ABSENTEE_BID_VALUE_FIVE_HUNDRED);
		common.pause(10);

		System.out.println("Step :: Fill absntee bid value in lot3");
		common.log("<br></br> Step :: Fill absntee bid value in lot3");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName2 + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_REGULAR_LIVE_BID + "']")).sendKeys(LEGACY_USER_TXT_ABSENTEE_BID_VALUE_FIVE_HUNDRED);
		common.pause(30);

		System.out.println("Step :: Click on place multibid button");
		common.log("<br></br> Step :: Click on place multibid button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_PLACE_MULTIBID + "']")).click();
		common.pause(20);

		System.out.println("Step :: Click on Confirm Button");
		common.log("<br></br> Step :: Click on Confirm Button");

		// driver.findElement(By.xpath("//input[@id='pblc2']")).click();
		common.pause(20);
		common.acceptAlert1();
		common.pause(40);

		// stop absentee bid checkbox not display

		// System.out.println("Step :: Click on stop absentee bid checkbox");
		// common.log("<br></br> Step :: Click on stop absentee bid checkbox");
		// driver.findElement(By.xpath("//span//input[@id='" +
		// LEGACY_USER_CHK_STOP_ABST_BID + "']")).click();
		// common.pause(15);
		//
		// System.out.println("Step :: Enter value >> Stop absentee bidding at");
		// common.log("<br></br> Step :: Enter Value >> Stop absentee bidding at");
		// driver.findElement(By.xpath("//span//input[@id='" +
		// LEGACY_USER_TXT_STOP_ABST_BID + "']"))
		// .sendKeys(LEGACY_USER_TXT_STOP_ABST_BID_VALUE);
		// common.pause(10);
		//
		// System.out.println("Step :: Click on Submit Button");
		// common.log("<br></br> Step :: Click on Submit button");
		// driver.findElement(By.xpath("//span//input[@id='" +
		// LEGACY_USER_BTN_STOP_ABST_BID_SAVE + "']")).click();
		//
		// common.pause(10);
	}

	/**
	 * 
	 * Dashboard - Goto catalog page
	 * 
	 * @param auctionName
	 * @throws AWTException
	 */

	public void goto_Catalog_Page_Live_Sale(String auctionName) throws AWTException

	{
		common.pause20Sec();
		common.log("<br></br> Step :: Click on Auction Overview Page");
		System.out.println("Step :: Click on Auction Overview Page");
		common.jsClick(auctionsubtab);// Go to Auction overview page

		// Select Bidding Now and Upcoming Only

		common.pause20Sec();
		System.out.println("Step :: Select Bidding now and upcoming");
		common.log("<br></br> Step :: Select Bidding now and upcoming");
		driver.findElement(By.xpath("//span[@id='"+LEGACY_USER_LST_AUCTION_SHOW+"']//..//a[@role='"+LEGACY_USER_BUTTON+"']")).click();
		common.pause20Sec();

		driver.findElement(By.xpath("//li[@class='"+LEGACY_FRONT_SALE_SELECT_DROPDOWN+"']//div[text()='"+LEGACY_FRONT_TXT_BIDDINGNOW_AND_UPCOMING+"']")).click();
		

		common.pause20Sec();
		// Select Live Only

		System.out.println("Step :: Select Live Only");
		common.log("<br></br> Step :: Select Live Only");

		driver.findElement(By.xpath("//span[@id='"+LEGACY_USER_LST_SELECT_SALE_TYPE+"']//..//a[@role='"+LEGACY_USER_BUTTON+"']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='"+LEGACY_FRONT_SALE_SELECT_DROPDOWN+"']//div[text()='"+LEGACY_FRONT_LIVE_SALE+"']")).click();
		
		common.pause(30);
		// Select Auctioneer Sagar

		System.out.println("Step :: Select Sagar Auctioneer");
		common.log("<br></br> Step :: Select Sagar Auctioneer");
		driver.findElement(By.xpath("//span[@id='"+LEGACY_USER_LST_SELECT_AUCTIONEER_SAGAR+"']//..//a[@role='"+LEGACY_USER_BUTTON+"']")).click();
		

		// Mouse Event
		common.pause20Sec();
		driver.findElement(By.xpath("//li[@class='"+LEGACY_FRONT_SALE_SELECT_DROPDOWN+"']//div[text()='"+LEGACY_ADMIN_LST_INPUT_AUCTIONEER_NAME+"']")).click();
		

		common.pause20Sec();

		System.out.println("Step :: Select 100 from dropdown");
		common.log("<br></br> Step :: Select 100 from dropdown");
		driver.findElement(By.xpath("//select[@id='" + LEGACY_ADMIN_LOT_TABLE + "']//option[@value='3']")).click();

		common.pause20Sec();
		for (int i = 0; i < 20; i++) {

			if (common.isElementPresent("//ul[@class='"+LEGACY_USER_VIEW_CATALOG+"']//a[text()=' " + auctionName + "']"))

			{
				common.log("auction " + auctionName + " is present in this page");
				System.out.println("auction " + auctionName + " is present in this page");
				driver.findElement(By.xpath("//ul[@class='auclting yura']//a[text()=' " + auctionName
						+ "']//..//..//..//..//a[text()='View catalog']")).click();
				common.pause20Sec();
				break;
			} else {
				common.log("auction " + auctionName + " is not present in this page");
				System.out.println("auction " + auctionName + " is not  present in this page");
				common.pause20Sec();

				System.out.println("Step :: Click on Next page");
				common.log("<br></br> Step :: Click on Next page");
				driver.findElement(By.xpath("//div[@class='right pagintn']//span//a[text()='Next']")).click();
				//common.jsClick(Nextpage);
				common.pause20Sec();
			}

		}
	}

	/**
	 * 
	 * Dashboard - Goto catalog page
	 * 
	 * @param auctionName
	 * @throws AWTException
	 */

	public void goto_Catalog_Page_Live_Sale_Auction(String auctionName) throws AWTException

	{
		common.pause(20);
		common.log("<br></br> Step :: Click on Auction Overview Page");
		System.out.println("Step :: Click on Auction Overview Page");
		common.waitForElement(By.xpath("//a[text()='Auctions']"));
		common.jsClick(auctionsubtab);// Go to Auction overview page

		// Select Bidding Now and Upcoming Only

		common.pause(30);
		System.out.println("Step :: Select Bidding now and upcoming");
		common.log("<br></br> Step :: Select Bidding now and upcoming");
		common.waitForElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']"));

		driver.findElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']")).click();
		common.pause(10);

		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Bidding now and upcoming']")).click();

		common.pause(30);
		// Select Live Only

		System.out.println("Step :: Select Live Only");
		common.log("<br></br> Step :: Select Live Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Live only']")).click();
		common.pause(30);
		// Select Auctioneer Sagar

		System.out.println("Step :: Select Sagar Auctioneer");
		common.log("<br></br> Step :: Select Sagar Auctioneer");
		driver.findElement(By.xpath("//span[@id='alf9_ctl']//..//a[@role='button']")).click();

		// Mouse Event
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Sagar']")).click();

		common.pause(30);

		System.out.println("Step :: Select 100 from dropdown");
		common.log("<br></br> Step :: Select 100 from dropdown");
		driver.findElement(By.xpath("//select[@id='" + LEGACY_ADMIN_LOT_TABLE + "']//option[@value='3']")).click();

		common.pause(30);

		for (int i = 0; i < 20; i++) {

			if (common.isElementPresent("//ul[@class='auclting yura']//a[text()=' " + auctionName + "']"))

			{
				common.log("auction " + auctionName + " is present in this page");
				System.out.println("auction " + auctionName + " is present in this page");
				driver.findElement(By.xpath("//ul[@class='auclting yura']//a[text()=' " + auctionName
						+ "']//..//..//..//..//a[text()='View catalog']")).click();
				common.pause(20);
				break;
			} else {
				common.log("auction " + auctionName + " is not present in this page");
				System.out.println("auction " + auctionName + " is not  present in this page");
				common.pause(60);

				System.out.println("Step :: Click on Next page");
				common.log("<br></br> Step :: Click on Next page");
				driver.findElement(
						By.xpath("//div[@class='right pagintn']//span[@id='c2_ctl']//a[contains(text(),'Next')]"))
						.click();
				common.pause(20);
			}

		}
	}

	/**
	 * Place absentee on group
	 * 
	 * @throws AWTException
	 * 
	 **/

	public void placeabsenteebidongroup(String saleno, String auctionName, String lotName, String lotName1,
			String lotName2) throws InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale(auctionName);

		System.out.println("Step :: Click on catalog button");
		common.log("<br></br> Step :: Click on catalog button");
		common.pause(30);

		System.out.println("Step :: Fill absntee bid value in lot1");
		common.log("<br></br> Step :: Fill absntee bid value in lot1");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//..//span//input[@type='text']"))
				.sendKeys(LEGACY_USER_TXT_ABSENTEE_BID_VALUE_FIVE_HUNDRED);
		common.pause(10);
		System.out.println("Step :: Fill absntee bid value in lot2");
		common.log("<br></br> Step :: Fill absntee bid value in lot2");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName1 + "']//..//..//..//..//span//input[@type='text']"))
				.sendKeys(LEGACY_USER_TXT_ABSENTEE_BID_VALUE);
		common.pause(10);
		System.out.println("Step :: Fill absntee bid value in lot3");
		common.log("<br></br> Step :: Fill absntee bid value in lot3");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName2 + "']//..//..//..//..//span//input[@type='text']"))
				.sendKeys("400");
		common.pause(20);
		System.out.println("Step :: Click on place multibid button");
		common.log("<br></br> Step :: Click on place multibid button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_PLACE_MULTIBID + "']")).click();

		System.out.println("Step :: Click on Confirm Button");
		common.log("<br></br> Step :: Click on Confirm Button");
		// driver.findElement(By.xpath("//input[@id='pblc2']")).click();
		common.pause(25);
		common.acceptAlert1();
		common.pause(10);
	}

	/**
	 * Public Void Live Sale
	 * 
	 * @throws InterruptedException
	 */

	public void LiveSaletab1() throws InterruptedException {

		System.out.println("Step :: Click on Live Sale tab");
		common.log("<br></br> Step :: Click on Live Sale tab");
//		 
//		 
		common.pause(25);

		common.pause(25);
		if (!common.isElementPresent("//a[contains(text(),'Live Sale')]")) {

			driver.findElement(By.xpath("//body/div[@id='wrapper']/div[1]/ol[1]/li[3]/a[1]/span[1]")).click();

			common.pause(20);
			driver.findElement(By.xpath("//a[contains(text(),'View live sale now!')]")).click();
			common.pause(20);
		} else {

			driver.findElement(By.xpath("//a[contains(text(),'Live Sale')]")).click();
			common.pause(20);
		}

		String lottitle = driver.findElement(By.xpath("//div[@class='grp-title hide-close']")).getText();
		System.out.println("Step :: Lot Title ::\n" + lottitle);
		common.pause(5);

		String msg_center = driver.findElement(By.xpath("//div[@class='messages']")).getText();
		System.out.println("Step :: Messaeg Center Display::\n" + msg_center);
		common.pause(10);

		System.out.println(" Step :: Click on BID button");
		common.log("<br></br> Step :: Click on BID button");
		driver.findElement(By.xpath("//a[@id='" + LEGACY_FRONT_LOGIN_BTN_BID + "']")).click();

	}

	/**
	 * Livesale tab verify message center
	 * 
	 * @throws InterruptedException
	 */
	public void LiveSaletab2() throws InterruptedException {

		System.out.println("Step :: Click on Live Sale tab");
		common.log("<br></br> Step :: Click on Live Sale tab");

		common.pause(25);
		if (!common.isElementPresent("//a[contains(text(),'Live Sale')]")) {

			driver.findElement(By.xpath("//body/div[@id='wrapper']/div[1]/ol[1]/li[3]/a[1]/span[1]")).click();

			common.pause(20);
			driver.findElement(By.xpath("//a[contains(text(),'View live sale now!')]")).click();
			common.pause(20);
		} else {

			driver.findElement(By.xpath("//a[contains(text(),'Live Sale')]")).click();
			common.pause(20);
		}

		System.out.println(" Step :: Click on OK");
		common.log("<br></br> Step :: Click on OK");
		driver.findElement(By.xpath("//button[text()='Ok']")).click();
		common.pause(15);

		common.acceptAlert();

	}

	/**
	 * 
	 * Livesale tab select lot
	 * 
	 * @param lotname2
	 * @param lotname3
	 * @throws InterruptedException
	 */

	public void LiveSaletabselectlot(String lotname1, String lotname3) throws InterruptedException {

		System.out.println("Step :: Click on Live Sale tab");
		common.log("<br></br> Step :: Click on Live Sale tab");
		common.pause(25);
		if (!common.isElementPresent("//a[contains(text(),'Live Sale')]")) {

			driver.findElement(By.xpath("//body/div[@id='wrapper']/div[1]/ol[1]/li[3]/a[1]/span[1]")).click();

			common.pause(20);
			driver.findElement(By.xpath("//a[contains(text(),'View live sale now!')]")).click();
			common.pause(20);
		} else {

			driver.findElement(By.xpath("//a[contains(text(),'Live Sale')]")).click();
			common.pause(20);
		}

		System.out.println("Step :: Select First Lot");
		common.log("<br></br> Step :: Select First Lot");

		driver.findElement(By.xpath("//a[text()='Lot 1 - " + lotname1 + "']//..//..//input")).click();
		common.pause(10);

		System.out.println("Step :: Click on OK button");
		common.log("<br></br> Step :: Click on OK button");
		driver.findElement(By.xpath("//button[text()='Ok']")).click();

		String usermessage = driver.findElement(By.xpath("//div[@class='messages']")).getText();

		System.out.println("Step :: Message center\n :: " + usermessage);
		common.log("<br></br> Step :: Message center\n :: " + usermessage);

		common.pause(15);

	}

	/**
	 * LiveSale tab select lot2
	 * 
	 * @param lotname2
	 * @param lotname3
	 * @throws InterruptedException
	 */

	public void LiveSaletabselectlot2(String lotname1, String lotname2) throws InterruptedException {

		System.out.println("Step :: Click on Live Sale tab");
		common.log("<br></br> Step :: Click on Live Sale tab");
		common.pause(25);
		if (!common.isElementPresent("//a[contains(text(),'Live Sale')]")) {

			driver.findElement(By.xpath("//body/div[@id='wrapper']/div[1]/ol[1]/li[3]/a[1]/span[1]")).click();

			common.pause(20);
			driver.findElement(By.xpath("//a[contains(text(),'View live sale now!')]")).click();
			common.pause(20);
		} else {

			driver.findElement(By.xpath("//a[contains(text(),'Live Sale')]")).click();
			common.pause(20);
		}

		System.out.println(" Step :: Select First Lot");
		common.log("<br></br> Step :: Select First Lot");
		driver.findElement(By.xpath("//a[text()='Lot 1 - " + lotname1 + "']//..//..//input")).click();
		common.pause(5);

		System.out.println(" Step :: Select Second Lot");
		common.log("<br></br> Step :: Select Second Lot");
		driver.findElement(By.xpath("//a[text()='Lot 2 - " + lotname2 + "']//..//..//input")).click();

		common.pause(5);

		System.out.println(" Step :: Click on OK");
		common.log("<br></br> Step :: Click on OK");
		driver.findElement(By.xpath("//button[text()='Ok']")).click();

		common.pause(5);
		String usermessage = driver.findElement(By.xpath("//div[@class='messages']")).getText();

		System.out.println("Step :: Message center\n :: " + usermessage);
		common.log("<br></br> Step :: Message center\n :: " + usermessage);

		common.pause(15);

	}

	/**
	 * Livesale tab selectlot1_3
	 * 
	 * @param lotname2
	 * @param lotname3
	 * @throws InterruptedException
	 */

	public void LiveSaletabselectlot1_3(String lotname1, String lotname3) throws InterruptedException {

		System.out.println("Step :: Click on Live Sale tab");
		common.log("<br></br> Step :: Click on Live Sale tab");
//		 
//		 
		common.pause(25);
		if (!common.isElementPresent("//a[contains(text(),'Live Sale')]")) {

			driver.findElement(By.xpath("//body/div[@id='wrapper']/div[1]/ol[1]/li[3]/a[1]/span[1]")).click();

			common.pause(20);
			driver.findElement(By.xpath("//a[contains(text(),'View live sale now!')]")).click();
			common.pause(20);
		} else {

			driver.findElement(By.xpath("//a[contains(text(),'Live Sale')]")).click();
			common.pause(20);
		}

		System.out.println(" Step :: Select First Lot");
		common.log("<br></br> Step :: Select First Lot");
		driver.findElement(By.xpath("//a[text()='Lot 1 - " + lotname1 + "']//..//..//input")).click();

		common.pause(5);

		System.out.println(" Step :: Select Third Lot");
		common.log("<br></br> Step :: Select Third Lot");
		driver.findElement(By.xpath("//a[text()='Lot 3 - " + lotname3 + "']//..//..//input")).click();

		common.pause(5);

		System.out.println(" Step :: Click on OK");
		common.log("<br></br> Step :: Click on OK");
		driver.findElement(By.xpath("//button[text()='Ok']")).click();

		common.pause(5);

		String usermessage = driver.findElement(By.xpath("//div[@class='messages']")).getText();

		System.out.println("Step :: Message center\n :: " + usermessage);
		common.log("<br></br> Step :: Message center\n :: " + usermessage);

		common.pause(15);

	}

	/**
	 * Verify auction present.
	 * 
	 * 
	 * @param auctionName
	 * @throws AWTException
	 */

	public void verify_Live_Auction_Present(String auctionName) throws AWTException

	{

		common.pause(25);

		// Select Live Only

		System.out.println("Step :: Select Live Only");
		common.log("<br></br> Step :: Select Live Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Live only']")).click();
		common.pause(30);
		// Select Auctioneer Sagar

		System.out.println("Step :: Select Sagar Auctioneer");
		common.log("<br></br> Step :: Select Sagar Auctioneer");
		driver.findElement(By.xpath("//span[@id='alf9_ctl']//..//a[@role='button']")).click();

		// Mouse Event
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Sagar']")).click();

		common.pause(30);

		System.out.println("Step :: Select 100 from dropdown");
		common.log("<br></br> Step :: Select 100 from dropdown");
		driver.findElement(By.xpath("//select[@id='" + LEGACY_ADMIN_LOT_TABLE + "']//option[@value='1']")).click();

		common.pause(20);

		for (int i = 0; i < 20; i++) {
			if (common.isElementPresent("//ul[@class='auclting yura']//a[text()=' " + auctionName + "']")) {

				System.out.println("auction " + auctionName + " is present in this page");

				common.pause(10);
				break;
			} else if (common.isElementPresent("//span[@id='" + LEGACY_USER_LST_NEXT_PAGE + "']//a[text()='Next']")) {
				System.out.println("auction " + auctionName + " is not present in this page");
				driver.findElement(By.xpath("//span[@id='" + LEGACY_USER_LST_NEXT_PAGE + "']//a[text()='Next']"))
						.click();
				common.pause(15);

			} else {
				System.out.println("auction " + auctionName + " is present in this page");
			}
		}

	}

	public void verify_Live_Auction_Present_At_Frontend(String auctionName) throws AWTException

	{

		common.pause(25);

		// Select Live Only

		System.out.println("Step :: Select Live Only");
		common.log("<br></br> Step :: Select Live Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Live only']")).click();
		common.pause(30);
		// Select Auctioneer Sagar

		System.out.println("Step :: Select Sagar Auctioneer");
		common.log("<br></br> Step :: Select Sagar Auctioneer");
		driver.findElement(By.xpath("//span[@id='alf9_ctl']//..//a[@role='button']")).click();

		// Mouse Event
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Sagar']")).click();

		common.pause(30);

		System.out.println("Step :: Select 100 from dropdown");
		common.log("<br></br> Step :: Select 100 from dropdown");
		driver.findElement(By.xpath("//select[@id='" + LEGACY_ADMIN_LOT_TABLE + "']//option[@value='3']")).click();

		common.pause(20);

		for (int i = 0; i < 20; i++) {
			if (common.isElementPresent("//ul[@class='auclting yura']//a[text()=' " + auctionName + "']")) {

				System.out.println("auction " + auctionName + " is present in this page");
				driver.findElement(By.xpath("//ul[@class='auclting yura']//a[text()=' " + auctionName + "']")).click();

				common.pause(10);
				break;
			} else if (common.isElementPresent("//span[@id='" + LEGACY_USER_LST_NEXT_PAGE + "']//a[text()='Next']")) {
				System.out.println("auction " + auctionName + " is not present in this page");
				driver.findElement(By.xpath("//span[@id='" + LEGACY_USER_LST_NEXT_PAGE + "']//a[text()='Next']"))
						.click();
				common.pause(15);

			} else {
				System.out.println("auction " + auctionName + " is present in this page");
			}
		}

	}

	/**
	 * Verify auction not present.
	 * 
	 * 
	 * @param auctionName
	 * @throws AWTException
	 */

	public void verify_Live_Auction_Not_Present(String auctionName) throws AWTException

	{

		common.pause(30);

		// Select Live Only

		System.out.println("Step :: Select Live Only");
		common.log("<br></br> Step :: Select Live Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Live only']")).click();
		common.pause(30);
		// Select Auctioneer Sagar

		System.out.println("Step :: Select Sagar Auctioneer");
		common.log("<br></br> Step :: Select Sagar Auctioneer");
		driver.findElement(By.xpath("//span[@id='alf9_ctl']//..//a[@role='button']")).click();

		// Mouse Event
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Sagar']")).click();

		common.pause(30);

		System.out.println("Step :: Select 100 from dropdown");
		common.log("<br></br> Step :: Select 100 from dropdown");
		driver.findElement(By.xpath("//select[@id='" + LEGACY_ADMIN_LOT_TABLE + "']//option[@value='3']")).click();

		for (int i = 0; i < 20; i++) {
			if (!common.isElementPresent("//ul[@class='auclting yura']//a[text()=' " + auctionName + "']")) {

				System.out.println("auction " + auctionName + " is not present in this page");

				common.pause(10);
				break;

			} else {
				System.out.println("auction " + auctionName + " is not present in this page");
//				driver.findElement(By.xpath("//span[@id='" + LEGACY_USER_LST_NEXT_PAGE + "']//a[text()='Next']"))
//						.click();
				common.pause(15);

			}
		}
	}

	public void verify_Live_Auction_Not_Present_Frontend(String auctionName) throws AWTException

	{

		common.pause(15);

		// Select Live Only

		System.out.println("Step :: Select Live Only");
		common.log("<br></br> Step :: Select Live Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Live only']")).click();
		common.pause(30);
		// Select Auctioneer Sagar

		System.out.println("Step :: Select Sagar Auctioneer");
		common.log("<br></br> Step :: Select Sagar Auctioneer");
		driver.findElement(By.xpath("//span[@id='alf9_ctl']//..//a[@role='button']")).click();

		// Mouse Event
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Sagar']")).click();

		common.pause(30);

		System.out.println("Step :: Select 100 from dropdown");
		common.log("<br></br> Step :: Select 100 from dropdown");
		driver.findElement(By.xpath("//select[@id='" + LEGACY_ADMIN_LOT_TABLE + "']//option[@value='3']")).click();

		for (int i = 0; i < 20; i++) {
			if (!common.isElementPresent("//ul[@class='auclting yura']//a[text()=' " + auctionName + "']")) {

				System.out.println("auction " + auctionName + " is not present in this page");

				common.pause(10);
				break;

			} else {
				System.out.println("auction " + auctionName + " is not present in this page");
//				driver.findElement(By.xpath("//span[@id='" + LEGACY_USER_LST_NEXT_PAGE + "']//a[text()='Next']"))
//						.click();
				common.pause(15);

			}
		}
	}

	/**
	 * 
	 * Dashboard - Goto settlements
	 * 
	 * @param auctionName
	 */

	public void settlements() {

		System.out.println("Step :: Click on settlements tab");
		common.log("<br></br> Step :: Click on settlements tab");
		driver.findElement(By.xpath("//a//span[text()='Settlements']")).click();

		System.out.println("Step :: Click on view");
		common.log("<br></br> Step :: Click on view");
		driver.findElement(By.xpath("//table//td//a[text()='view']")).click();

		System.out.println("Step :: Verify generated settlements");
		common.log("<br></br> Step :: Verify generated settlemets");
		common.assertElementPresent("//div[@class='address']");

		System.out.println("Step :: Click on printable view");
		common.log("<br></br> Step :: Click on printable view");
		driver.findElement(By.xpath("//a[@text='Printable view']")).click();

	}

	/*
	 * Verify text
	 */

	public void VerifyText() {
		System.out.println("After Login");
		common.pause(20);
		String strtext = driver.findElement(By.xpath("//div[@class='logo-container-inner']")).getText();

		System.out.println("Text is Display ::" + strtext);

		common.jsClick(logout);

		System.out.println("After Logout");
		common.pause(20);
		String strtext1 = driver.findElement(By.xpath("//div[@class='logo-container-inner']")).getText();

		System.out.println("Text is Display ::" + strtext1);
	}

	/**
	 * Verify logo
	 * 
	 */

	public void VerifyLogo() {
		System.out.println("After Login");
		common.pause(15);

		System.out.println("Logo is Diplay");
		common.jsClick(logout);

		System.out.println("After Logout");
		common.pause(10);

		common.assertElementPresent("//a[contains(text(),'Login')]");

		System.out.println("Logo is Diplay");
	}

	/**
	 * verify Live And TimeSearch Not Being Displayed Separately
	 * 
	 */
	public void verifyLiveAndTimeSearchNotBeingDisplayedSeparately() {

		common.pause(20);
		common.assertElementNotPresent("//a[text()='Live search']");
		common.assertElementNotPresent("//a[text()='Timed search']");
	}

	/**
	 * verify Live And TimeSearch Not Being Displayed Separately
	 * 
	 */
	public void verifyLiveAndTimeSearchBeingDisplayedSeparately() {

		common.pause(10);
		// common.assertElementPresent("//a[text()='Live search']");
		// common.assertElementPresent("//a[text()='Timed search']");
	}

	/**
	 * verify Listview
	 * 
	 */
	public void Verify_List_View() {

		common.pause(20);
		// common.assertElementPresent("//a[text()='Live search']");
		// common.assertElementPresent("//a[text()='Timed search']");

		System.out.println("Step :: Click on Timed Search tab");
		common.log("<br></br> Step :: Click on Timed Search tab");
		// driver.findElement(By.xpath("//a[text()='Timed search']")).click();
		common.pause(30);

		if (common.isElementPresent("//a[text()='Table view']")) {
			System.out.println("Step :: Click on Tableview link");
			common.log("<br></br> Step :: Click on Tableview link");
			driver.findElement(By.xpath("//a[text()='Table view']")).click();
			common.pause(10);
		} else {
			System.out.println("Step :: Tableview link not display");
		}

		common.pause(10);

		if (common.isElementPresent("//a[text()='List view']")) {
			System.out.println("Step :: Click on Listview link");
			common.log("<br></br> Step :: Click on Listview link");
			driver.findElement(By.xpath("//a[text()='List view']")).click();
			common.pause(10);
		} else {
			System.out.println("Step :: Listview link not display");
		}

		common.pause(10);

	}

	/**
	 * Verify header tab
	 * 
	 */
	public void Verify_Header_Tab() {
		common.pause(20);

		if (common.isElementPresent("//a[text()='My Items']")) {

			System.out.println("Step :: Script Fail");

		} else {
			System.out.println("Step :: Verify My Items tab not display");
		}

		if (common.isElementPresent("//a//span[text()='My Alerts']")) {

			System.out.println("Step :: Script Fail");

		} else {
			System.out.println("Step :: Verify My Alert tab not display");
		}

	}

	/**
	 * Verify header tab Enable
	 * 
	 */
	public void Verify_Header_Tab_Enable() {

		System.out.println("Step :: Verify My Items tab display");
		common.log("<br></br> Step :: Verify My Items tab not display");
		common.assertElementPresent("//a[text()='My Items']");

	}

	/**
	 * 
	 * Verify new invoice logo
	 */

	public void Verify_Invoice_Logo() {

		System.out.println("Step :: Click on invoice tab");
		common.log("<br></br> Step :: Click on invoice tab");
		driver.findElement(By.xpath("//a[text()='Invoices']")).click();
		common.pause(20);

		driver.findElement(By.xpath("//tbody/tr[1]/td[5]")).click();
		common.pause(20);
		common.assertElementPresent("//img[@alt='sam']");

		String str = driver.findElement(By.xpath("//img[@alt='sam']")).getAttribute("src");

		System.out.println("Uploaded image : " + str);
		common.log("<br></br> Uploaded image : " + str);

	}

	public void Verify_Not_Added_Invoice_Logo() {

		System.out.println("Step :: Click on invoice tab");
		common.log("<br></br> Step :: Click on invoice tab");
		driver.findElement(By.xpath("//a[text()='Invoices']")).click();
		common.pause(20);

		driver.findElement(By.xpath("//tbody/tr[1]/td[5]")).click();
		common.pause(20);
		common.assertElementPresent("//img[@alt='sam']");

	}

	/**
	 * 
	 * Verify new settlemet logo
	 */

	public void Verify_Settlement_Logo() {

		System.out.println("Step :: Click on Settlement tab");
		common.log("<br></br> Step :: Click on Settlement tab");
		// driver.findElement(By.xpath("//a[text()='Settlements']")).click();

		System.out.println("Step :: Verify My Alert tab display");
		common.log("<br></br> Step :: Verify My Alert tab not display");
		driver.findElement(By.xpath("//a[text()='My Items']")).click();

		System.out.println("Step :: Verify new image display");

	}

	/**
	 * Verify New credit card in profile
	 * 
	 * @param strname
	 */
	public void Verify_New_Credit_Card_In_Profile(String strname) {

		System.out.println("Step  :: Click on Profile");
		common.log("<br></br> Step  :: Click on Profie");
		driver.findElement(By.xpath("//a[contains(text(),'Profile')]")).click();
		common.pause(30);

		// System.out.println("Step :: Click on edit");
		// common.log("<br></br> Step :: Click on edit");
		// driver.findElement(By.xpath("//a[@id='" + LEGACY_USER_BTN_CC_EDIT +
		// "']")).click();
		// common.pause(15);

		String newcc = driver.findElement(By.xpath("//select[@id='pbp13']")).getText();

		System.out.println("Step  :: Verify New CC::" + newcc);
		common.jsClick(logout);

	}

	/**
	 * Verify New Credit card info
	 * 
	 */

	public void Verify_New_Credit_Card(String strname) {

		System.out.println("Step :: Click on Signup Link");
		common.log("<br></br> Step :: Click on Signup Link");
		common.pause(20);
		driver.findElement(By.xpath("//a[text()='Signup']")).click();
		common.pause(40);

		System.out.println("Step :: Verify CC Name");
		common.log("<br></br> Step :: Verify CC Name");
		driver.findElement(By.xpath(
				"//span//select[@id='" + LEGACY_USER_SIGNUP_LST_CC_TYPE + "']//option[text()='" + strname + "']"));
		common.pause(10);
		System.out.println("Step :: CC Name" + strname);

	}

	/**
	 * 
	 * Verify Deleted CC In Profile
	 * 
	 * @param strname
	 */

	public void verifydeletedcreditcardinprofile(String deletecc) {

		System.out.println("Step  :: Click on Profile");
		common.log("<br></br> Step  :: Click on Profie");
		driver.findElement(By.xpath("//a[text()='Profile']")).click();
		common.pause(30);

		System.out.println("Step  :: Verify Deleted CC Name");
		common.log("<br></br> Step  :: Verify Deleted CC Name");

		if (common.isElementPresent(
				"//span//select[@id='" + LEGACY_USER_TXT_BILLING_CC_TYPE + "']//option[text()='" + deletecc + "']")) {

			System.out.println("Step :: CC Present >>" + deletecc);

		} else {
			System.out.println("Step :: CC Deleted>> " + deletecc);
		}

		common.jsClick(logout);

	}

	/**
	 * Verify Deleted CC card info
	 * 
	 */

	public void verifydeletedcreditcard(String deletecc) {

		System.out.println("Step :: Click on Signup Link");
		common.log("<br></br> Step :: Click on Signup Link");
		common.pause(20);
		driver.findElement(By.xpath("//a[text()='Signup']")).click();
		common.pause(20);

		System.out.println("Step :: Verify Deleted CC Name");
		common.log("<br></br> Step :: Verify Deleted CC Name");

		if (common.isElementPresent(
				"//span//select[@id='" + LEGACY_USER_SIGNUP_LST_CC_TYPE + "']//option[text()='" + deletecc + "']")) {

			System.out.println("Step :: CC Present >>" + deletecc);

		} else {
			System.out.println("Step :: CC Deleted >> " + deletecc);
		}

	}

	/**
	 * Veriy New credit card in profile
	 * 
	 * @param strccname1
	 */

	public void verifynewcreditcardinprofile1(String strccname1) {

		System.out.println("Step  :: Click on Profile");
		common.log("<br></br> Step  :: Click on Profie");
		driver.findElement(By.xpath("//a[text()='Profile']")).click();
		common.pause(30);

		System.out.println("Step  :: Verify New CC");
		common.log("<br></br> Step  :: Verify New CC");
		// driver.findElement(By.xpath("//span//select[@id='pbp13']//..//a[@class='sbToggle']")).click();
		common.pause(10);
		// driver.findElement(By.xpath("//span//select[@id='" +
		// LEGACY_USER_TXT_BILLING_CC_TYPE + "']//..//option[text()='"
		// + strccname1 + "']")).click();
		common.pause(20);
		String newCC = driver.findElement(By.xpath("//span//select[@id='" + LEGACY_USER_TXT_BILLING_CC_TYPE
				+ "']//..//option[text()='" + strccname1 + "']")).getText();

		System.out.println("Step  :: Verify New CC::" + newCC);
		common.jsClick(logout);
		common.pause(20);

	}

	/**
	 * Verify New Credit card info
	 * 
	 */

	public void verifynewcreditcard1(String str_ccname) {
		common.pause(20);
		System.out.println("Step :: Click on Signup Link");
		common.log("<br></br> Step :: Click on Signup Link");
		driver.findElement(By.xpath("//a[contains(text(),'Signup')]")).click();
		common.pause(30);

		System.out.println("Step :: Click on Signup Link");
		common.log("<br></br> Step :: Click on Signup Link");
		driver.findElement(By.xpath("//select[@id='rbp13']//..//a[@class='sbToggle']")).click();
		common.pause(10);
		String str_ccname1 = driver.findElement(By.xpath("//a[contains(text(),'" + str_ccname + "')]")).getText();
		common.pause(10);
		System.out.println("Step :: CC Name ::" + str_ccname1);

	}

	/**
	 * verify Tableview
	 * 
	 */
	public void verifyTableview() {

		common.pause(10);
		// common.assertElementPresent("//a[text()='Live search']");
		// common.assertElementPresent("//a[text()='Timed search']");

		System.out.println("Step :: Click on Timed Search tab");
		common.log("<br></br> Step :: Click on Timed Search tab");
		// driver.findElement(By.xpath("//a[text()='Timed search']")).click();
		common.pause(30);

		if (common.isElementPresent("//a[text()='Table view']")) {
			System.out.println("Step :: Click on Tableview link");
			common.log("<br></br> Step :: Click on Tableview link");
			driver.findElement(By.xpath("//a[text()='Table view']")).click();
			common.pause(10);
		} else {
			System.out.println("Step :: Tableview link not display");
		}

		common.pause(10);

		if (common.isElementPresent("//a[text()='List view']")) {
			System.out.println("Step :: Click on Listview link");
			common.log("<br></br> Step :: Click on Listview link");
			driver.findElement(By.xpath("//a[text()='List view']")).click();
			common.pause(10);
		} else {
			System.out.println("Step :: Listview link not display");
		}

		common.pause(10);

	}

	/**
	 * verify AuctionsOverview
	 * 
	 */
	public void verifyAuctionOverview() {

		common.pause(15);
		common.assertElementPresent("//a[contains(text(),'Auctions')]");
		System.out.println("Step :: Auction Overview Page display");
		common.pause(10);

	}

	/**
	 * verify Search page
	 * 
	 */
	public void verifySearchPage() {

		common.pause(15);
		common.assertElementPresent("//li[@title='Search']");
		System.out.println("Step :: Search Page display");
		common.pause(10);

	}

	/**
	 * verify Featured lot1
	 * 
	 */
	public void verifyShow1() {

		common.pause(15);
		common.assertElementPresent("//li[@title='Search']");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//input[@value='search']")).click();
		common.pause(20);
		String str = driver.findElement(By.xpath("//li[@id='lot1']//div[@class='bdttle']")).getText();
		System.out.print(str + " is display");
		// common.assertElementPresent("//table[@id='c19']");
		common.pause(10);

	}

	/**
	 * verify Featured lot3
	 * 
	 */
	public void verifyShow3() {

		common.pause(15);
		common.assertElementPresent("//li[@title='Search']");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//input[@value='search']")).click();
		common.pause(20);
		String str = driver.findElement(By.xpath("//li[@id='lot1']//div[@class='bdttle']")).getText();
		System.out.print(str + " is display");
		// common.assertElementPresent("//table[@id='c19']");
		common.pause(10);

	}

	/**
	 * verify Featured lot not display
	 * 
	 */
	public void verifyDisabled() {

		common.pause(15);

		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(10);

		if (common.isElementPresent("//table[@id='c19']")) {
			System.out.print("Script failed");
		} else {
			System.out.print("Script passed");
		}

		common.pause(10);
	}

	/**
	 * Bean Stream Invoice Payment
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 * 
	 */

	public void bean_Stream_Invoice_Payment() throws InterruptedException, ParseException {

		Invoice_Payment_Frontend(); // Enter Credit Card Details

		common.pause(10);

		System.out.println("Step  :: Click on Pay Via Bean Stream");
		common.log("<br></br> Step  :: Click on Pay Via Bean Stream");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_PAY_THROUGH_BEAN_STREAM + "']")).click();
		common.pause(10);
	}

	/**
	 * Verify Payment Success Message
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 */

	public void invoice_Payment_Success_Message() throws InterruptedException, ParseException {

		common.pause(10);
		System.out.println("Step :: Verify Success Message");
		common.log("<br></br> Step :: Verify Success Message");
		common.assertElementPresent("//section[@class='message']");

	}

	/**
	 * Verify Alert Message - BeanStream
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	public void bean_Stream_Invoice_Payment_AlertMessage() throws InterruptedException, ParseException {

		common.pause(10);
		System.out.println("Step :: Verify Success Message");
		common.log("<br></br> Step :: Verify Success Message");
		common.assertElementPresent("//span[text()='Bidder credit card declined.']");

	}

	/**
	 * buy credit with invalid cc Disable
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 * 
	 */

	public void bean_Stream_Invoice_Payment_Disable() throws InterruptedException, ParseException {

		System.out.println("Step  :: Click on Invoices");
		common.log("<br></br> Step  :: Click on Invoices");
		driver.findElement(By.xpath("//a[text()='Invoices']")).click();
		common.pause(10);

		common.pause(10);
		System.out.println("Step :: Select Pending from dropdown menu");
		common.log("<br></br> Step :: Select Pending from dropdown menu");
		Actions actions = new Actions(driver);
		WebElement ShowDropDown = driver.findElement(By.xpath("//span[@id='c1_ctl']//..[@role='button']"));
		ShowDropDown.click();

		WebElement select_pending = driver.findElement(By.linkText("Pending"));
		common.pause(10);
		actions.moveToElement(select_pending);
		actions.moveToElement(select_pending).click().perform();
		common.pause(20);

		System.out.println("Step :: Click on view button");
		common.log("<br></br> Step :: Click on view button");
		driver.findElement(By.xpath("//td[text()='Pending']")).click();

		common.pause(25);

		System.out.println("Step :: Click on Pay Now button");
		common.log("<br></br> Step :: Click on Pay Now button");
		driver.findElement(By.xpath("//input[@value='Pay now']")).click();
		common.pause(10);

		System.out.println("Step  :: Verify Pay Via Bean Stream Button Not Display");
		common.log("<br></br> Step  :: Verify Pay Via Bean Stream Button Not Display");

		if (!common.isElementPresent("//input[@id='" + LEGACY_USER_BTN_PAY_THROUGH_BEAN_STREAM + "']")) {

			System.out.println("Step  :: Verify Pay Via Bean Stream Button Not Display >> Script Pass");
		}

		else {

			System.out.println("Step  :: Script Fail");
		}

	}

	/**
	 *
	 * Bean Stream / PayTrace Invalid CC
	 *
	 */

	public void BS_PT_Invoice_Invalid_CC()

	{

		System.out.println("Step  :: Click on Invoices");
		common.log("<br></br> Step  :: Click on Invoices");

		driver.findElement(By.xpath("//a[text()='Invoices']")).click();

		common.pause(10);
		System.out.println("Step :: Select Pending from dropdown menu");
		common.log("<br></br> Step :: Select Pending from dropdown menu");
		Actions actions = new Actions(driver);
		WebElement ShowDropDown = driver.findElement(By.xpath("//span[@id='c1_ctl']//..[@role='button']"));
		ShowDropDown.click();

		WebElement select_pending = driver.findElement(By.linkText("Pending"));
		common.pause(10);
		actions.moveToElement(select_pending);
		actions.moveToElement(select_pending).click().perform();
		common.pause(20);

		System.out.println("Step :: Click on view button");
		common.log("<br></br> Step :: Click on view button");
		driver.findElement(By.xpath("//td[text()='Pending']")).click();

		common.pause(25);

		System.out.println("Step :: Click on Pay Now button");
		common.log("<br></br> Step :: Click on Pay Now button");
		driver.findElement(By.xpath("//input[@value='Pay now']")).click();
		common.pause(10);

		System.out.println("Step :: Click on edit icon");
		common.log("<br></br> Step :: Click on edit icon");
		driver.findElement(By.xpath("//a[@id='" + LEGACY_USER_BTN_EDIT_CC + "']")).click();
		common.pause(10);

		/**
		 * Select CC Type
		 */
		System.out.println("Step :: Select CC Type.");
		common.log("<br></br>Step :: Select CC Type.");

		Actions CC_Type = new Actions(driver);
		common.pause(10);
		WebElement CCtype = driver.findElement(By.xpath("//select[@id='pbcp13']//..//..//a[@role='button']"));
		CCtype.click();
		common.pause(10);

		WebElement Select_CC_Type = driver.findElement(By.linkText("Visa"));
		common.pause(20);
		CC_Type.moveToElement(Select_CC_Type);
		CC_Type.moveToElement(Select_CC_Type).click().perform();
		common.pause(20);

		common.type("//input[@id='pbcp14']", "411232233445545");

		/**
		 * Select Expiration Month
		 * 
		 */

		System.out.println("Step :: Select CC Month.");
		common.log("<br></br>Step :: Select CC Month.");

		Actions CC_month = new Actions(driver);
		common.pause(10);
		WebElement CCmonth = driver.findElement(By.xpath("//select[@id='pbcp17']//..//a"));
		CCmonth.click();
		common.pause(20);

		WebElement Select_CC_month = driver.findElement(By.linkText("March"));
		common.pause(20);
		CC_month.moveToElement(Select_CC_month);
		CC_month.moveToElement(Select_CC_month).click().perform();
		common.pause(20);

		/**
		 * Select Expiration Year
		 * 
		 */

		System.out.println("Step :: Select CC Year.");
		common.log("<br></br>Step :: Select CC Year.");

		Actions CC_year = new Actions(driver);
		common.pause(10);
		WebElement CCyear = driver.findElement(By.xpath("//select[@id='pbcp18']//..//..//a[@role='button']"));
		CCyear.click();
		common.pause(10);

		WebElement Select_CC_Year = driver.findElement(By.linkText("2020"));
		common.pause(20);
		CC_year.moveToElement(Select_CC_Year);
		CC_year.moveToElement(Select_CC_Year).click().perform();
		common.pause(20);

		// enter security code
		common.type("//input[@id='pbcp19']", "123");
		common.pause(10);
	}

	/**
	 * Invoice Payment with invalid cc
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 * 
	 */

	public void bean_Stream_Invoice_Payment_Invalid_CC() throws InterruptedException, ParseException {

		BS_PT_Invoice_Invalid_CC(); // Bean Stream & PayTrace Invalid CC
		common.pause(10);

		System.out.println("Step  :: Click on Pay Via Bean Stream");
		common.log("<br></br> Step  :: Click on Pay Via Bean Stream");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_PAY_THROUGH_BEAN_STREAM + "']")).click();
		common.pause(20);

		System.out.println("Step :: Verify Alert Message");
		common.log("<br></br> Step :: Verify Alert Message");
		common.assertElementPresent("//span[text()=':Credit Card Number *: Invalid Credit Card Number']");

	}

	/**
	 * buy credit with valid cc
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 * 
	 */

	public void Buy_Credit_FrontEnd_Valid_Details() throws InterruptedException, ParseException {

		System.out.println("Step  :: Click on Profile");
		common.log("<br></br> Step  :: Click on Profile");
		driver.findElement(By.xpath("//a[text()='Profile']")).click();
		common.pause(10);

		System.out.println("Step  :: Click on buy more credit.");
		common.log("<br></br> Step  :: Click on buy more credit.");
		driver.findElement(By.xpath("//a[text()='Buy more credits now!']")).click();
		common.pause(10);

		System.out.println("Step  :: Select Package.");
		common.log("<br></br> Step  :: Select Package.");
		driver.findElement(By.xpath("//span//input[@id='" + LEGACY_USER_BTN_RADIO_SELECT_PACKAGE + "']")).click();

		System.out.println("Step  :: Click on Paynow button.");
		common.log("<br></br> Step  :: Click on paynow button");
		driver.findElement(By.xpath("//span//input[@id='" + LEGACY_USER_BUY_CREDIT_BTN_PAY_NOW + "']")).click();
		common.pause(10);

		System.out.println("Step  :: Click on edit icon");
		common.log("<br></br> Step  :: Click on edit icon");
		driver.findElement(By.xpath("//a[@id='" + LEGACY_USER_BTN_EDIT_CC + "']")).click();
		common.pause(10);

		/**
		 * Select CC Type
		 */
		System.out.println("Step :: Select CC Type.");
		common.log("<br></br>Step :: Select CC Type.");

		Actions CC_Type = new Actions(driver);
		common.pause(10);
		WebElement CCtype = driver.findElement(By.xpath("//select[@id='pbcp13']//..//..//a[@role='button']"));
		CCtype.click();
		common.pause(10);

		WebElement Select_CC_Type = driver.findElement(By.linkText("Visa"));
		common.pause(20);
		CC_Type.moveToElement(Select_CC_Type);
		CC_Type.moveToElement(Select_CC_Type).click().perform();
		common.pause(20);

		common.type("//input[@id='pbcp14']", "4111111111111111");

		/**
		 * Select Expiration Month
		 * 
		 */

		System.out.println("Step :: Select CC Month.");
		common.log("<br></br>Step :: Select CC Month.");

		Actions CC_month = new Actions(driver);
		common.pause(10);
		WebElement CCmonth = driver.findElement(By.xpath("//select[@id='pbcp17']//..//a"));
		CCmonth.click();
		common.pause(20);

		WebElement Select_CC_month = driver.findElement(By.linkText("April"));
		common.pause(20);
		CC_month.moveToElement(Select_CC_month);
		CC_month.moveToElement(Select_CC_month).click().perform();
		common.pause(20);

		/**
		 * Select Expiration Year
		 * 
		 */

		System.out.println("Step :: Select CC Year.");
		common.log("<br></br>Step :: Select CC Year.");

		Actions CC_year = new Actions(driver);
		common.pause(10);
		WebElement CCyear = driver.findElement(By.xpath("//select[@id='pbcp18']//..//..//a[@role='button']"));
		CCyear.click();
		common.pause(10);

		WebElement Select_CC_Year = driver.findElement(By.linkText("2020"));
		common.pause(20);
		CC_year.moveToElement(Select_CC_Year);
		CC_year.moveToElement(Select_CC_Year).click().perform();
		common.pause(20);

		// enter security code
		common.type("//input[@id='pbcp19']", "123");
		common.pause(10);

		driver.findElement(By.xpath("//input[@id='psp1']")).click();
		common.pause(5);
	}

	/**
	 * Pay Through Bean Stream
	 * 
	 * @throws ParseException
	 * @throws InterruptedException
	 * 
	 */
	public void pay_Through_Bean_Stream() throws InterruptedException, ParseException

	{

		Buy_Credit_FrontEnd_Valid_Details(); // Credit Card Details

		System.out.println("Step  :: Click on Pay Via Bean Stream");
		common.log("<br></br> Step  :: Click on Pay Via Bean Stream");
		driver.findElement(By.xpath("//span//input[@id='" + LEGACY_USER_BUTTON_PAY_THROUGH_BEANSTREAM + "']")).click();
		common.pause(10);
	}

	/**
	 * Verify Success Message
	 * 
	 */
	public void payment_Success_Message() {

		common.pause(15);
		String Suceess_payment = driver.findElement(By.xpath("//section[@class='message']")).getText();
		System.out.println("Step :: Verify Message >> " + Suceess_payment);
	}

	/**
	 * 
	 * Verify Error Message
	 */

	public void beanstream_Error_Message() {

		common.pause(10);
		System.out.println("Step  :: Verify Error Message");
		common.log("<br></br> Step  :: Verify Error Message");
		common.assertElementPresent("//span[text()='fake-ctrl: Bidder credit card declined.']");
		common.pause(10);
	}

	// span[text()='Bidder credit card declined.']

	/**
	 * Bean Stream Button Not display
	 * 
	 **/

	public void bean_Stream_Not_Display()

	{

		System.out.println("Step  :: Click on Profile");
		common.log("<br></br> Step  :: Click on Profile");
		driver.findElement(By.xpath("//a[text()='Profile']")).click();
		common.pause(10);

		System.out.println("Step  :: Click on buy more credit.");
		common.log("<br></br> Step  :: Click on buy more credit.");
		driver.findElement(By.xpath("//a[text()='Buy more credits now!']")).click();
		common.pause(10);

		System.out.println("Step  :: Select Package.");
		common.log("<br></br> Step  :: Select Package.");
		driver.findElement(By.xpath("//span//input[@id='" + LEGACY_USER_BTN_RADIO_SELECT_PACKAGE + "']")).click();
		common.pause(5);

		System.out.println("Step  :: Click on Paynow button.");
		common.log("<br></br> Step  :: Click on paynow button");
		driver.findElement(By.xpath("//span//input[@id='" + LEGACY_USER_BUY_CREDIT_BTN_PAY_NOW + "']")).click();
		common.pause(10);

		System.out.println("Step  :: Verify Pay Via Bean Stream button not display");
		common.log("<br></br> Step  :: Verify Pay Via Bean Stream button not dispaly");
		common.assertElementNotPresent("//span//input[@id='" + LEGACY_USER_BUTTON_PAY_THROUGH_BEANSTREAM + "']");

	}

	/**
	 * PayTrace Button Not display
	 * 
	 **/

	public void payTrace_Not_Display()

	{

		System.out.println("Step  :: Click on Profile");
		common.log("<br></br> Step  :: Click on Profile");
		driver.findElement(By.xpath("//a[text()='Profile']")).click();
		common.pause(10);

		System.out.println("Step  :: Click on buy more credit.");
		common.log("<br></br> Step  :: Click on buy more credit.");
		driver.findElement(By.xpath("//a[text()='Buy more credits now!']")).click();
		common.pause(10);

		System.out.println("Step  :: Select Package.");
		common.log("<br></br> Step  :: Select Package.");
		driver.findElement(By.xpath("//span//input[@id='" + LEGACY_USER_BTN_RADIO_SELECT_PACKAGE + "']")).click();

		System.out.println("Step  :: Click on Paynow button.");
		common.log("<br></br> Step  :: Click on paynow button");
		driver.findElement(By.xpath("//span//input[@id='" + LEGACY_USER_BUY_CREDIT_BTN_PAY_NOW + "']")).click();
		common.pause(10);

		System.out.println("Step  :: Verify Pay Trace button not display");
		common.log("<br></br> Step  :: Verify Pay Trace button not dispaly");
		common.assertElementNotPresent("//span//input[@id='" + LEGACY_USER_BUTTON_PAY_THROUGH_PAYTRACE + "']");
		common.pause(5);
	}

	/**
	 * buy credit with invalid cc
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 * 
	 */

	public void Buy_Credit_Invalid_Details_Front_End() throws InterruptedException, ParseException {

		System.out.println("Step  :: Click on Profile");
		common.log("<br></br> Step  :: Click on Profile");
		driver.findElement(By.xpath("//a[text()='Profile']")).click();
		common.pause(15);

		System.out.println("Step  :: Click on buy more credit.");
		common.log("<br></br> Step  :: Click on buy more credit.");
		driver.findElement(By.xpath("//a[text()='Buy more credits now!']")).click();
		common.pause(10);

		System.out.println("Step  :: Select Package.");
		common.log("<br></br> Step  :: Select Package.");
		driver.findElement(By.xpath("//span//input[@id='" + LEGACY_USER_BTN_RADIO_SELECT_PACKAGE + "']")).click();

		System.out.println("Step  :: Click on Paynow button.");
		common.log("<br></br> Step  :: Click on paynow button");
		driver.findElement(By.xpath("//span//input[@id='" + LEGACY_USER_BUY_CREDIT_BTN_PAY_NOW + "']")).click();

		System.out.println("Step  :: Click on edit icon");
		common.log("<br></br> Step  :: Click on edit icon");
		driver.findElement(By.xpath("//a[@id='" + LEGACY_USER_BTN_EDIT_CC + "']")).click();
		common.pause(10);

		/**
		 * Select CC Type
		 */
		System.out.println("Step :: Select CC Type.");
		common.log("<br></br>Step :: Select CC Type.");

		Actions CC_Type = new Actions(driver);
		common.pause(10);
		WebElement CCtype = driver.findElement(By.xpath("//select[@id='pbcp13']//..//..//a[@role='button']"));
		CCtype.click();
		common.pause(10);

		WebElement Select_CC_Type = driver.findElement(By.linkText("Visa"));
		common.pause(20);
		CC_Type.moveToElement(Select_CC_Type);
		CC_Type.moveToElement(Select_CC_Type).click().perform();
		common.pause(20);

		common.type("//input[@id='pbcp14']", LEGACY_USER_TXT_CC_NUMBER_VALUE_INVALID);

		/**
		 * Select Expiration Month
		 * 
		 */

		System.out.println("Step :: Select CC Month.");
		common.log("<br></br>Step :: Select CC Month.");

		Actions CC_month = new Actions(driver);
		common.pause(10);
		WebElement CCmonth = driver.findElement(By.xpath("//select[@id='pbcp17']//..//a"));
		CCmonth.click();
		common.pause(20);

		WebElement Select_CC_month = driver.findElement(By.linkText("April"));
		common.pause(20);
		CC_month.moveToElement(Select_CC_month);
		CC_month.moveToElement(Select_CC_month).click().perform();
		common.pause(20);

		/**
		 * Select Expiration Year
		 * 
		 */

		System.out.println("Step :: Select CC Year.");
		common.log("<br></br>Step :: Select CC Year.");

		Actions CC_year = new Actions(driver);
		common.pause(10);
		WebElement CCyear = driver.findElement(By.xpath("//select[@id='pbcp18']//..//..//a[@role='button']"));
		CCyear.click();
		common.pause(10);

		WebElement Select_CC_Year = driver.findElement(By.linkText("2020"));
		common.pause(20);
		CC_year.moveToElement(Select_CC_Year);
		CC_year.moveToElement(Select_CC_Year).click().perform();
		common.pause(20);

		// enter security code
		common.type("//input[@id='pbcp19']", "123");
		common.pause(10);

	}

	/**
	 * Bean_Stream Invalid CC
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	public void bean_Stream_Invalid_CC_FrontEnd() throws InterruptedException, ParseException {

		Buy_Credit_Invalid_Details_Front_End(); // CC invalid

		System.out.println("Step  :: Click on Pay Via Bean Stream");
		common.log("<br></br> Step  :: Click on Pay Via Bean Stream");
		driver.findElement(By.xpath("//span//input[@id='bcfl12']")).click();
		common.pause(10);

		System.out.println("Step  :: Verify Invalid CC message");
		common.log("<br></br> Step  :: Verify Invalid CC message");
		common.assertElementPresent("//span[text()='Credit Card Number *: Invalid Credit Card Number']");
		common.pause(10);
	}

	/**
	 * Bean_Stream Invalid CC
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	public void payTrace_Invalid_CC_FrontEnd() throws InterruptedException, ParseException {

		Buy_Credit_Invalid_Details_Front_End(); // CC invalid

		System.out.println("Step  :: Click on Pay Through PayTrace");
		common.log("<br></br> Step  :: Click on Pay Through PayTrace");
		driver.findElement(By.xpath("//span//input[@id='" + LEGACY_USER_BUTTON_PAY_THROUGH_PAYTRACE + "']")).click();
		common.pause(10);
		System.out.println("Step  :: Verify Invalid CC message");
		common.log("<br></br> Step  :: Verify Invalid CC message");
		common.assertElementPresent("//span[text()='Credit Card Number *: Invalid Credit Card Number']");
	}

	/**
	 * Common Method For FrontEnd Invoice Payment
	 * 
	 * 
	 */
	public void Invoice_Payment_Frontend() {

		System.out.println("Step  :: Click on Invoices");
		common.log("<br></br> Step  :: Click on Invoices");

		driver.findElement(By.xpath("//a[text()='Invoices']")).click();

		common.pause(10);
		System.out.println("Step :: Select Pending from dropdown menu");
		common.log("<br></br> Step :: Select Pending from dropdown menu");
		Actions actions = new Actions(driver);
		WebElement ShowDropDown = driver.findElement(By.xpath("//span[@id='c1_ctl']//..[@role='button']"));
		ShowDropDown.click();
		common.pause(5);

		WebElement select_pending = driver.findElement(By.linkText("Pending"));
		common.pause(10);
		actions.moveToElement(select_pending);
		actions.moveToElement(select_pending).click().perform();
		common.pause(20);

		System.out.println("Step :: Click on view button");
		common.log("<br></br> Step :: Click on view button");
		driver.findElement(By.xpath("//td[text()='Pending']")).click();

		common.pause(25);

		System.out.println("Step :: Click on Pay Now button");
		common.log("<br></br> Step :: Click on Pay Now button");
		driver.findElement(By.xpath("//input[@value='Pay now']")).click();
		common.pause(10);

		System.out.println("Step  :: Click on edit icon");
		common.log("<br></br> Step  :: Click on edit icon");
		driver.findElement(By.xpath("//a[@id='" + LEGACY_USER_BTN_EDIT_CC + "']")).click();
		common.pause(10);

		/**
		 * Select CC Type
		 */
		System.out.println("Step :: Select CC Type.");
		common.log("<br></br>Step :: Select CC Type.");

		Actions CC_Type = new Actions(driver);
		common.pause(10);
		WebElement CCtype = driver.findElement(By.xpath("//select[@id='pbcp13']//..//..//a[@role='button']"));
		CCtype.click();
		common.pause(10);

		WebElement Select_CC_Type = driver.findElement(By.linkText("Visa"));
		common.pause(20);
		CC_Type.moveToElement(Select_CC_Type);
		CC_Type.moveToElement(Select_CC_Type).click().perform();
		common.pause(20);

		common.type("//input[@id='pbcp14']", "4111111111111111");

		/**
		 * Select Expiration Month
		 * 
		 */

		System.out.println("Step :: Select CC Month.");
		common.log("<br></br>Step :: Select CC Month.");

		Actions CC_month = new Actions(driver);
		common.pause(10);
		WebElement CCmonth = driver.findElement(By.xpath("//select[@id='pbcp17']//..//a"));
		CCmonth.click();
		common.pause(20);

		WebElement Select_CC_month = driver.findElement(By.linkText("March"));
		common.pause(20);
		CC_month.moveToElement(Select_CC_month);
		CC_month.moveToElement(Select_CC_month).click().perform();
		common.pause(20);

		/**
		 * Select Expiration Year
		 * 
		 */

		System.out.println("Step :: Select CC Year.");
		common.log("<br></br>Step :: Select CC Year.");

		Actions CC_year = new Actions(driver);
		common.pause(10);
		WebElement CCyear = driver.findElement(By.xpath("//select[@id='pbcp18']//..//..//a[@role='button']"));
		CCyear.click();
		common.pause(10);

		WebElement Select_CC_Year = driver.findElement(By.linkText("2020"));
		common.pause(20);
		CC_year.moveToElement(Select_CC_Year);
		CC_year.moveToElement(Select_CC_Year).click().perform();
		common.pause(20);

		// enter security code
		common.type("//input[@id='pbcp19']", "123");
		common.pause(10);

		if (driver.findElement(By.xpath("//input[@id='psp1']")).isDisplayed()) {

			driver.findElement(By.xpath("//input[@id='psp1']")).click();

		}

		else {
			System.out.println("Step  :: Shipping info not display");
		}

		driver.findElement(By.xpath("//input[@id='psp1']")).click();
	}

	/**
	 * PayTrace Invoice Payment
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 * 
	 */

	public void payTrace_Invoice_Payment() throws InterruptedException, ParseException {

		Invoice_Payment_Frontend(); // Enter CC Details

		common.pause(10);
		System.out.println("Step  :: Click on Pay Via PayTrace");
		common.log("<br></br> Step  :: Click on Pay Via PayTrace");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BUTTON_PAY_THROUGH_PAYTRACE_INVOICE + "']")).click();
		common.pause(10);
	}

	/**
	 * PayTrace Invoice Payment
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 * 
	 */

	public void payTrace_Invoice_Payment_Button_Disable() throws InterruptedException, ParseException {

		common.pause(10);
		System.out.println("Step  :: Verify Pay Via PayTrace Button Not Display");
		common.log("<br></br> Step  :: Verify Pay Via PayTrace Button Not Display");
		common.assertElementNotPresent("//input[@id='" + LEGACY_USER_BUTTON_PAY_THROUGH_PAYTRACE_INVOICE + "']");

	}

	/**
	 * Invoice Payment with invalid cc
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 * 
	 */

	public void payTrace_Invoice_Payment_Invalid_CC() throws InterruptedException, ParseException {

		BS_PT_Invoice_Invalid_CC(); // Bean Stream & PayTrace Invalid CC

		System.out.println("Step  :: Click on Pay Via PayTrace Invoice");
		common.log("<br></br> Step  :: Click on Pay Via PayTrace Invoice");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BUTTON_PAY_THROUGH_PAYTRACE_INVOICE + "']")).click();
		common.pause(10);
		System.out.println("Step :: Verify Alert Message");
		common.log("<br></br> Step :: Verify Alert Message");
		common.assertElementPresent("//span[text()=':Credit Card Number *: Invalid Credit Card Number']");

	}

	/**
	 * Verify Alert Message - BeanStream
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	public void payTrace_Invoice_Payment_AlertMessage() throws InterruptedException, ParseException {

		System.out.println("Step :: Verify Warning Message");
		common.log("<br></br> Step :: Verify Warning Message");
		common.pause(15);

		String warning = driver.findElement(By.xpath("//span")).getText();
		System.out.println("Step :: Warning Message >> " + warning);

		common.pause(5);
	}

	/**
	 * Pay Through PayTrace
	 * 
	 * @throws ParseException
	 * @throws InterruptedException
	 * 
	 */
	public void pay_Through_PayTrace() throws InterruptedException, ParseException

	{

		Buy_Credit_FrontEnd_Valid_Details(); // Credit Card Details
		common.pause(5);
		System.out.println("Step  :: Click on Pay Through PayTrace");
		common.log("<br></br> Step  :: Click on Pay Through PayTrace");
		driver.findElement(By.xpath("//span//input[@id='" + LEGACY_USER_BUTTON_PAY_THROUGH_PAYTRACE + "']")).click();

	}

	/**
	 * Buy lot from catalog page
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param lotName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void Buy_First_Lot_From_Catalog(String saleno, String auctionName, String lotName1)
			throws InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale(auctionName); // Goto View Catalog Page
		common.pause(50);

		System.out.println("Step :: Fill Buy Now Value");
		common.type("//h2//a[text()='" + lotName1 + "']//..//..//..//input[@class='" + LEGACY_USER_TXT_REGULAR_LIVE_BID
				+ "']", LEGACY_USER_TXT_BUY_NOW_VALUE);

		common.log("<br></br> Step :: Click on buy now button for lot 1");
		System.out.println("Step :: Click on buy now button for lot 1");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName1 + "']//..//..//..//input[@value='Buy now!']"))
				.click();
		common.pause(20);
		System.out.println("Step :: Click on Confirm Button");
		common.log("<br></br> Step ::  Click on Confirm Button");
		driver.findElement(By.xpath("//input[@value='Confirm']")).click();
		common.pause(15);

		common.log("<br></br> Step :: Verify Winner Message");
		System.out.println("Step :: Verify Winner Message");
		common.isElementPresent("//span[contains(text(),'Your high bid!')]");

	}

	/**
	 * Place Bid on 2nd lot
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param lotName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void Place_Bid_Second_Lot(String saleno, String auctionName, String lotName1)
			throws InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale(auctionName); // Goto View Catalog Page
		common.pause(10);

		System.out.println("Step :: Fill Buy Now Value");
		common.type("//a//span[text()='" + lotName1 + "']//..//..//..//div[@class='regular-bid']//input[@type='text']",
				LEGACY_USER_TXT_BUY_NOW_VALUE);

		common.log("<br></br> Step :: Click on buy now button for lot 1");
		System.out.println("Step :: Click on buy now button for lot 1");
		driver.findElement(By.xpath("//a//span[text()='" + lotName1
				+ "']//..//..//..//div[@class='regular-bid']//input[@type='text']//..//..//..//..//..//div[@class='buy-now']"))
				.click();

		common.log("<br></br> Step :: Click on confirm button");
		System.out.println("Step :: Click on confirm button");
		driver.findElement(By.xpath("//span[@id='" + LEGACY_USER_BTN_CONFIRM + "']")).click();

		common.log("<br></br> Step :: Verify Winner Message");
		System.out.println("Step :: Verify Winner Message");
		common.isElementPresent("//span[contains(text(),'Your high bid!')]");

	}

	/**
	 * 
	 * Dashboard - Goto catalog page Timed Sale
	 * 
	 * @param auctionName
	 * @return
	 * @throws AWTException
	 * @throws InterruptedException
	 */

	public String goto_Catalog_Page_Timed_Sale(String TimedAuction) throws AWTException, InterruptedException

	{

		common.pause(20);

		// Select Timed Only

		System.out.println("Step :: Select Timed Only");
		common.log("<br></br> Step :: Select Timed Only");
		common.waitForElement(By.xpath("//span[@id='alf3_ctl']//..//a"));
		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a")).click();
		common.pause(15);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[contains(text(),'Timed only')]")).click();

		common.pause(25);

		// Select Auctioneer Sagar

		System.out.println("Step :: Select Sagar Auctioneer");
		common.log("<br></br> Step :: Select Sagar Auctioneer");
		driver.findElement(By.xpath("//span[@id='alf9_ctl']//..//a")).click();
		common.pause(15);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Sagar']")).click();
		// Mouse Event
		common.pause(25);

		System.out.println("Step :: Select 100 from dropdown");
		common.log("<br></br> Step :: Select 100 from dropdown");
		driver.findElement(By.xpath("//select[@id='" + LEGACY_ADMIN_LOT_TABLE + "']//option[@value='2']")).click();

		common.pause(50);

		for (int i = 0; i < 20; i++) {

			if (common.isElementPresent("//ul[@class='auclting yura']//a[text()=' " + TimedAuction + "']"))

			{
				common.log("auction " + TimedAuction + " is present in this page");
				System.out.println("auction " + TimedAuction + " is present in this page");
				driver.findElement(By.xpath("//ul[@class='auclting yura']//a[text()=' " + TimedAuction
						+ "']//..//..//..//..//a[text()='View catalog']")).click();
				common.pause(45);
				break;
			} else {
				common.log("auction " + TimedAuction + " is not present in this page");
				System.out.println("auction " + TimedAuction + " is not  present in this page");
				common.pause(60);
				if(common.isElementDisplayed("//div[@class='pagintn right']//a[contains(text(),'Next')]")) {
				driver.findElement(By.xpath("//div[@class='pagintn right']//a[contains(text(),'Next')]")).click();
				common.pause(60);
				}else {
					driver.findElement(By.xpath("//div[@class='pagintn right']//span[text()='Next']")).click();
				}
			}

		}
		return TimedAuction;
	}

	public String Goto_Catalog_Page_Timed_Sale_for_All_Auctioneers(String TimedAuction)
			throws AWTException, InterruptedException

	{

		common.pause(20);

		// Select Timed Only

		System.out.println("Step :: Select Timed Only");
		common.log("<br></br> Step :: Select Timed Only");
		common.waitForElement(By.xpath("//span[@id='alf3_ctl']//..//a"));
		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a")).click();
		common.pause(15);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[contains(text(),'Timed only')]")).click();

		common.pause(25);

		// Select Auctioneer All

		System.out.println("Step :: Select All Auctioneer");
		common.log("<br></br> Step :: Select All Auctioneer");
		driver.findElement(By.xpath("//span[@id='alf9_ctl']//..//a")).click();
		common.pause(15);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[contains(text(),'All auctioneers')]")).click();
		// Mouse Event
		common.pause(25);

		System.out.println("Step :: Select 100 from dropdown");
		common.log("<br></br> Step :: Select 100 from dropdown");
		driver.findElement(By.xpath("//select[@id='" + LEGACY_ADMIN_LOT_TABLE + "']//option[@value='3']")).click();

		common.pause(50);

		for (int i = 0; i < 20; i++) {

			if (common.isElementPresent("//ul[@class='auclting yura']//a[text()=' " + TimedAuction + "']"))

			{
				common.log("auction " + TimedAuction + " is present in this page");
				System.out.println("auction " + TimedAuction + " is present in this page");
				driver.findElement(By.xpath("//ul[@class='auclting yura']//a[text()=' " + TimedAuction
						+ "']//..//..//..//..//a[text()='View catalog']")).click();
				common.pause(45);
				break;
			} else {
				common.log("auction " + TimedAuction + " is not present in this page");
				System.out.println("auction " + TimedAuction + " is not  present in this page");
				common.pause(60);
				driver.findElement(By.xpath("//div[@class='pagintn right']//a[contains(text(),'Next')]")).click();
				common.pause(60);
			}

		}
		return TimedAuction;
	}

	public void verify_Asking_bid_display_Or_not() throws InterruptedException, ParseException {

		System.out.println("Step :: Verify Warning Message");
		common.log("<br></br> Step :: Verify Warning Message");

		common.waitForElement(By.xpath(
				"//body/div[@id='wrapper']/form[@id='AdvancedSearch']/div[1]/article[1]/section[1]/div[3]/div[3]/ul[1]/li[1]/section[1]/div[3]"));
		String warning = driver.findElement(By.xpath(
				"//body/div[@id='wrapper']/form[@id='AdvancedSearch']/div[1]/article[1]/section[1]/div[3]/div[3]/ul[1]/li[1]/section[1]/div[3]"))
				.getText();
		System.out.println("Price Info :  >> " + warning);

		System.out.println("If Asking and Current bid display then failed scripts otherwise Passed");
		common.log("<br></br> Step :: Verify Warning Message");

	}

	/**
	 * 
	 * Dashboard - Goto catalog page Timed Sale
	 * 
	 * @param auctionName
	 * @throws AWTException
	 */

	public void Goto_Catalog_Page_Timed_Sale1(String TimedAuction) throws AWTException

	{

		common.pause(40);

		// Select Timed Only

		System.out.println("Step :: Select Timed Only");
		common.log("<br></br> Step :: Select Timed Only");
		common.waitForElement(By.xpath("//span[@id='alf3_ctl']//..//a"));
		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a")).click();
		common.pause(15);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[contains(text(),'Timed only')]")).click();

		common.pause(25);

		// Select Auctioneer Sagar

		System.out.println("Step :: Select Sagar Auctioneer");
		common.log("<br></br> Step :: Select Sagar Auctioneer");
		driver.findElement(By.xpath("//span[@id='alf9_ctl']//..//a")).click();
		common.pause(15);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[contains(text(),'Sagar')]")).click();
		// Mouse Event
		common.pause(25);

		System.out.println("Step :: Select 100 from dropdown");
		common.log("<br></br> Step :: Select 100 from dropdown");
		driver.findElement(By.xpath("//select[@id='" + LEGACY_ADMIN_LOT_TABLE + "']//option[@value='3']")).click();

		common.pause(15);

		for (int i = 0; i < 20; i++) {

			if (common.isElementPresent("//ul[@class='auclting yura']//a[text()=' " + TimedAuction + "']"))

			{
				common.log("auction " + TimedAuction + " is present in this page");
				System.out.println("auction " + TimedAuction + " is present in this page");
				driver.findElement(By.xpath("//ul[@class='auclting yura']//a[text()=' " + TimedAuction
						+ "']//..//..//..//..//a[text()='View catalog']")).click();
				common.pause(20);
				break;
			} else {
				common.log("auction " + TimedAuction + " is not present in this page");
				System.out.println("auction " + TimedAuction + " is not  present in this page");

				driver.findElement(By.xpath("//span[@id='" + LEGACY_USER_LST_NEXT_PAGE + "']//a[text()='Next']"))
						.click();
				common.pause(20);
			}

		}
	}

	/**
	 * Buy lot from catalog page - Timed Auction
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param lotName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void Buy_First_Lot_From_Catalog_Timed(String saleno, String TimedAuction, String lotName3)
			throws InterruptedException, AWTException {

		goto_Catalog_Page_Timed_Sale(TimedAuction); // Goto View Catalog Page
		common.pause(50);

		System.out.println("Step :: Fill Buy Now Value");
		common.log("<br></br> Step :: Fill Buy Now Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName3 + "']//..//..//..//input[@type='text']")).click();
		driver.findElement(By.xpath("//h2//a[text()='" + lotName3 + "']//..//..//..//input[@type='text']"))
				.sendKeys("600");

		common.log("<br></br> Step :: Click on buy now button for lot 1");
		System.out.println("Step :: Click on buy now button for lot 1");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName3 + "']//..//..//..//..//input[@type='button']"))
				.click();
		common.pause(25);
		// common.acceptAlert1();
		driver.findElement(By.xpath("//input[@id='pblc2']")).click();
		common.pause(15);

		// driver.findElement(By.xpath("//a[@id='btnPlaceBid']")).click();

		common.log("<br></br> Step :: Verify Winner Message");
		System.out.println("Step :: Verify Winner Message");
		common.assertElementPresent("//span[contains(text(),'Your high bid!')]");
		// div[@class='winner-msg']
	}

	/**
	 * Place bid in timed auction
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param lotName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void Place_Bid_Value_Timed_Auction(String saleno, String auctionName, String lotName4)
			throws InterruptedException, AWTException {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(50);
		goto_Catalog_Page_Timed_Sale(auctionName); // Goto catalog page

		System.out.println("Step :: Fill Place bid value");
		common.log("<br></br> Step :: Fill Place bid value");

		common.pause(50);
		driver.findElement(By.xpath("//h2//a[text()='" + lotName4 + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMED_MAX_BID + "']")).sendKeys("500");

		System.out.println("Step :: Click on placebid button");
		common.log("<br></br> Step :: Click on placebid button");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName4 + "']//..//..//..//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']"))
				.click();

		common.pause(20);
		// common.acceptAlert1();

		for (int i = 1; i < 5; i++) {

			if (common.isElementPresent("//a[@class='ended']")) {

				common.assertElementPresent("//a[@class='ended']");

				System.out.println("\n Step :: Sale Ended Message Displays");

				break;
			}

			else {

				System.out.print("\n Step :: Wait For Sale Ended");
				common.log("<br></br> Step :: Wait For Sale Ended");
				common.pause(50);
			}
		}

	}

	/**
	 * Verify Quantity in Invoices
	 * 
	 * @param LotQuantity
	 */
	public void Verify_Quantity_Invoices() throws AWTException {

		System.out.println("Step  :: Click on Invoices");
		common.log("<br></br> Step  :: Click on Invoices");
		driver.findElement(By.xpath("//header//a[text()='Invoices']")).click();

		Actions actions = new Actions(driver);
		System.out.println("Step :: Select Pending From Dropdown");
		common.log("<br></br> Step :: Select Pending From Dropdown");
		common.pause(25);
		driver.findElement(By.xpath("//select[@id='mil1']//option[@value='1']")).click();

		common.pause(20);

		System.out.println("Step :: Click on view button");
		common.log("<br></br> Step :: Click on view button");
		driver.findElement(By.xpath("//tbody/tr[1]/td[5]")).click();

		common.pause(10);

		String invoicequantity = driver.findElement(By.xpath("//td[@class='item-category']")).getText();

		System.out.println("Step :: Invoice Quantity" + invoicequantity);

		System.out.println("Step :: Click on Printable Link");
		common.log("<br></br> Step :: Click on Printable Link");
		driver.findElement(By.xpath("//a[text()='Printable view']")).click();
		common.pause(30);
		String invoicequantity1 = driver.findElement(By.xpath("//td[@class='item-category']")).getText();

		System.out.println("Step :: After Click Printable Invoice Quantity" + invoicequantity1);
		common.pause(10);
		Robot robot = new Robot();
		robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
		robot.keyPress(java.awt.event.KeyEvent.VK_1);
		robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
		robot.keyRelease(java.awt.event.KeyEvent.VK_1); // Press CTRL + 1 From
														// Keyboard
		common.pause(25);

		System.out.println("Step :: Click on Pdf Link");
		common.log("<br></br> Step :: Click on Pdf Link");
		driver.findElement(By.xpath("//a[text()='PDF Invoice']")).click();
		common.pause(10);

	}

	/**
	 * Verify Quantity in Invoices Disable
	 * 
	 * @param LotQuantity
	 */
	public void Verify_Quantity_Invoices_Disable(String LotQuantity) {

		System.out.println("Step  :: Click on Invoices");
		common.log("<br></br> Step  :: Click on Invoices");
		driver.findElement(By.xpath("//header//a[text()='Invoices']")).click();

		Actions actions = new Actions(driver);
		System.out.println("Step :: Select Pending From Dropdown");
		common.log("<br></br> Step :: Select Pending From Dropdown");
		common.pause(25);
		driver.findElement(By.xpath("//select[@id='mil1']//option[@value='0']")).click();

		common.pause(20);

		System.out.println("Step :: Click on view button");
		common.log("<br></br> Step :: Click on view button");
		driver.findElement(By.xpath("//tbody/tr[1]/td[5]")).click();
		common.pause(20);
		System.out.println("Step :: Verify Quantity Tab is Not Present.");
		common.log("<br></br> Step :: Verify Quantity Tab is Not Present.");
		common.assertElementNotPresent("//td[@class='item-quantity']");

		System.out.println("Step :: Click on Pdf Link");
		common.log("<br></br> Step :: Click on Pdf Link");
		driver.findElement(By.xpath("//a[text()='PDF Invoice']")).click();

	}

	/**
	 * Verify Quantity in Invoices
	 * 
	 * @param LotQuantity
	 */
	public void Verify_Category_Invoices() throws AWTException {

		System.out.println("Step  :: Click on Invoices");
		common.log("<br></br> Step  :: Click on Invoices");
		common.pause(25);
		driver.findElement(By.xpath("//a[text()='Invoices']")).click();
		common.pause(40);

		Actions actions = new Actions(driver);
		System.out.println("Step :: Select Pending From Dropdown");
		common.log("<br></br> Step :: Select Pending From Dropdown");
		driver.findElement(By.xpath("//select[@id='mil1']")).click();
		common.pause(10);

		driver.findElement(By.xpath("//select[@id='mil1']//option[contains(text(),'Pending')]")).click();

		common.pause(20);

		System.out.println("Step :: Click on search button");
		common.log("<br></br> Step :: Click on search button");
		driver.findElement(By.xpath("//input[@id='mil3']")).click();

		common.pause(20);
		driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).click();
		common.pause(20);
		String invoicecate = driver.findElement(By.xpath("//td[@class='item-category']")).getText();

		System.out.println("Step :: Invoice Category" + invoicecate);

		// common.assertTwoValuesAreEqual(invoiceqty, LotQuantity);
		String strurl = driver.getCurrentUrl();

		System.out.println("Step :: Click on Printable Link");
		common.log("<br></br> Step :: Click on Printable Link");
		driver.findElement(By.xpath("//a[text()='Printable view']")).click();

		String invoicecate1 = driver.findElement(By.xpath("//td[@class='item-category']")).getText();

		System.out.println("Step :: After Click Printable Invoice Category : " + invoicecate1);
		// Keyboard
		common.pause(25);
		driver.get(strurl);
		common.pause(50);

		System.out.println("Step :: Click on Pdf Link");
		common.log("<br></br> Step :: Click on Pdf Link");
		driver.findElement(By.xpath("//a[text()='PDF Invoice']")).click();
		common.pause(25);
//		String invoicecatepdf = driver.findElement(By.xpath("//div[a@class='textLayer']")).getText();
//		System.out.println("Step :: After Click Pdf Invoice Category" + invoicecatepdf);
//		common.pause(10);

	}

	/**
	 * Place bid in timed auction wait for sale end
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param lotName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void Place_Bid_Value_50_Timed_Auction_Wait_For_Sale_End(String saleno, String auctionName, String lotName4)
			throws InterruptedException, AWTException {

		goto_Catalog_Page_Timed_Sale(auctionName); // Goto catalog page
													// timedauction

		System.out.println("Step :: Fill Place bid value");
		common.log("<br></br> Step :: Fill Place bid value");
		common.pause(40);

		driver.findElement(By.xpath("//h2//a[text()='" + lotName4 + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMED_MAX_BID + "']")).sendKeys("50");

		System.out.println("Step :: Click on placebid button");
		common.log("<br></br> Step :: Click on placebid button");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName4 + "']//..//..//..//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']"))
				.click();
		common.pause(20);

		System.out.println("Step :: Click on Confirm Button");
		common.log("<br></br> Step ::  Click on Confirm Button");
		driver.findElement(By.xpath("//input[@value='Confirm']")).click();
		common.pause(15);

		// common.acceptAlert1();
		common.pause(20);

		for (int i = 1; i < 5; i++) {

			if (common.isElementPresent("//span[@class='ended']")) {

				common.assertElementPresent("//span[@class='ended']");

				System.out.println("\n Step :: Sale Ended Message Displays");

				break;
			}

			else {

				System.out.print("\n Step :: Wait For Sale Ended");
				common.log("<br></br> Step :: Wait For Sale Ended");
				common.pause(50);
			}
		}

		common.refreshPage(); // Refresh Page

	}

	/**
	 * Place bid in timed auction wait for sale end 200
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param lotName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void Place_Bid_Value_200_Timed_Auction_Wait_For_Sale_End(String saleno, String auctionName, String lotName4)
			throws InterruptedException, AWTException {

		goto_Catalog_Page_Timed_Sale(auctionName); // Goto catalog page
		// timedauction

		System.out.println("Step :: Fill Place bid value");
		common.log("<br></br> Step :: Fill Place bid value");
		common.pause(20);

		driver.findElement(By.xpath("//h2//a[text()='" + lotName4 + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMED_MAX_BID + "']")).sendKeys("200");

		System.out.println("Step :: Click on placebid button");
		common.log("<br></br> Step :: Click on placebid button");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName4 + "']//..//..//..//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']"))
				.click();
		common.pause(5);

		System.out.println("Step :: Click on Confirm Button");
		common.log("<br></br> Step ::  Click on Confirm Button");

		common.acceptAlert1();
		common.pause(20);

		for (int i = 1; i < 5; i++) {

			if (common.isElementPresent("//span[@class='ended']")) {

				common.assertElementPresent("//span[@class='ended']");

				System.out.println("\nStep :: Sale Ended Message Displays");

				break;
			}

			else {

				System.out.print("\nStep :: Wait For Sale Ended");
				common.log("<br></br> Step :: Wait For Sale Ended");
				common.pause(50);
			}
		}

		common.refreshPage(); // Refresh Page

	}

	/**
	 * Place bid in timed auction wait for sale end 15000
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param lotName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void Place_Bid_Value_15000_Timed_Auction_Wait_For_Sale_End(String saleno, String auctionName,
			String lotName4) throws InterruptedException, AWTException {

		goto_Catalog_Page_Timed_Sale(auctionName); // Goto catalog page
		// timedauction

		System.out.println("Step :: Fill Place bid value");
		common.log("<br></br> Step :: Fill Place bid value");
		common.pause(20);

		driver.findElement(By.xpath("//h2//a[text()='" + lotName4 + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMED_MAX_BID + "']")).sendKeys("15000");

		System.out.println("Step :: Click on placebid button");
		common.log("<br></br> Step :: Click on placebid button");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName4 + "']//..//..//..//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']"))
				.click();
		common.pause(10);

		System.out.println("Step :: Click on Confirm Button");
		common.log("<br></br> Step ::  Click on Confirm Button");
		driver.findElement(By.xpath("//input[@value='Confirm']")).click();
		common.pause(20);

		for (int i = 1; i < 5; i++) {

			if (common.isElementPresent("//span[@class='ended']")) {

				common.assertElementPresent("//span[@class='ended']");

				System.out.println("\nStep :: Sale Ended Message Displays");

				break;
			}

			else {

				System.out.print("\nStep :: Wait For Sale Ended");
				common.log("<br></br> Step :: Wait For Sale Ended");
				common.pause(50);
			}
		}

		common.refreshPage(); // Refresh Page

	}

	/**
	 * Place bid in timed auction wait for sale end
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param lotName
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	public void Place_Bid_Value_400_Timed_Auction_Wait_For_Sale_End(String saleno, String auctionName, String lotName4)
			throws InterruptedException, AWTException {

		goto_Catalog_Page_Timed_Sale(auctionName); // Goto catalog page
		// timedauction

		System.out.println("Step :: Fill Place bid value");
		common.log("<br></br> Step :: Fill Place bid value");
		common.pause(20);

		driver.findElement(By.xpath("//h2//a[text()='" + lotName4 + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMED_MAX_BID + "']")).sendKeys("400");

		System.out.println("Step :: Click on placebid button");
		common.log("<br></br> Step :: Click on placebid button");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName4 + "']//..//..//..//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']"))
				.click();
		common.pause(5);

		System.out.println("Step :: Click on Confirm Button");
		common.log("<br></br> Step ::  Click on Confirm Button");

		common.acceptAlert1();
		common.pause(20);

		for (int i = 1; i < 5; i++) {

			if (common.isElementPresent("//span[@class='ended']")) {

				common.assertElementPresent("//span[@class='ended']");

				System.out.println("\nStep :: Sale Ended Message Displays");

				break;
			}

			else {

				System.out.print("\nStep :: Wait For Sale Ended");
				common.log("<br></br> Step :: Wait For Sale Ended");
				common.pause(50);
			}
		}

		common.refreshPage(); // Refresh Page
	}

	/**
	 * 
	 * Verify Auction status Bidding now and upcoming bidding now only upcoming only
	 * 
	 * @param auctionname1
	 */
	public void verify_Auction_Not_Display(String auctionname) {

		for (int i = 0; i < 20; i++) {

			if (!common.isElementPresent("//ul[@class='auclting yura']//a[text()=' " + auctionname
					+ "']//..//..//span[text()='Sale closed']"))

			{
				common.log("auction " + auctionname + " Sale Not display");
				System.out.println("auction " + auctionname + " Sale Not display");

				common.assertElementNotPresent("//ul[@class='auclting yura']//a[text()=' " + auctionname
						+ "']//..//..//span[text()='Sale closed']");

				common.pause(10);
				break;
			} else if (common.isElementPresent("//span[@id='" + LEGACY_USER_LST_NEXT_PAGE + "']//a[text()='Next']")) {
				driver.findElement(By.xpath("//span[@id='" + LEGACY_USER_LST_NEXT_PAGE + "']//a[text()='Next']"))
						.click();
			} else {
				common.log("auction " + auctionname + " is not present in this page");
				System.out.println("auction " + auctionname + " is not  present in this page");

				common.pause(15);
			}

		}
	}

	/**
	 * 
	 * Verify start date in the past auction start and not closed
	 * 
	 * @param name
	 * @param PastDate
	 * @param auctionname
	 */
	public void Verifystartdateinthepastauctionstartedandnotclosed(String auctionname) {

		common.log("<br></br> Step :: Click on Auction Overview Page");
		System.out.println("Step :: Click on Auction Overview Page");
		common.jsClick(auctionsubtab);// Go to Auction overview page
		common.pause(15);

		// Select Bidding Now and Upcoming Only

		common.pause(30);
		System.out.println("Step :: Select All");
		common.log("<br></br> Step :: Select All");
		common.waitForElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']"));

		driver.findElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']")).click();
		common.pause(10);

		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='All']")).click();

		common.pause(30);
		// Select Live Only

		System.out.println("Step :: Select Live Only");
		common.log("<br></br> Step :: Select Live Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Live only']")).click();
		common.pause(30);
		// Select Auctioneer Sagar

		System.out.println("Step :: Select Sagar Auctioneer");
		common.log("<br></br> Step :: Select Sagar Auctioneer");
		driver.findElement(By.xpath("//span[@id='alf9_ctl']//..//a[@role='button']")).click();

		// Mouse Event
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Sagar']")).click();

		common.pause(30);

		System.out.println("Step :: Select 100 from dropdown");
		common.log("<br></br> Step :: Select 100 from dropdown");
		driver.findElement(By.xpath("//select[@id='" + LEGACY_ADMIN_LOT_TABLE + "']//option[@value='3']")).click();

		common.pause(20);

		common.log("<br></br> Step :: To verify Sale status closed display when show type all selected");
		System.out.println("Step :: To verify Sale status closed display when show type all selected");

		for (int i = 0; i < 20; i++) {

			if (common.isElementPresent("//ul[@class='auclting yura']//a[text()=' " + auctionname
					+ "']//..//..//span[text()='Sale closed']"))

			{
				common.log("auction " + auctionname + " Sale closed display");
				System.out.println("auction " + auctionname + " Sale closed display");

				common.assertElementPresent("//ul[@class='auclting yura']//a[text()=' " + auctionname
						+ "']//..//..//span[text()='Sale closed']");

				common.pause(10);
				break;
			} else {
				common.log("auction " + auctionname + " is not present in this page");
				System.out.println("auction " + auctionname + " is not  present in this page");

				driver.findElement(By.xpath("//span[@id='" + LEGACY_USER_LST_NEXT_PAGE + "']//a[text()='Next']"))
						.click();
				common.pause(15);
			}

		}

		/* Bidding now and upcoming */

		System.out.println("Step :: Select Bidding now and upcoming");
		common.log("<br></br> Step :: Select Bidding now and upcoming");
		common.waitForElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']"));

		driver.findElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']")).click();
		common.pause(10);

		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Bidding now and upcoming']")).click();

		verify_Auction_Not_Display(auctionname);

		/* Bidding now only */

		System.out.println("Step :: Select Bidding now only");
		common.log("<br></br> Step :: Select Bidding now only");
		common.waitForElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']"));

		driver.findElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']")).click();
		common.pause(10);

		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Bidding now only']")).click();

		Verify_Auction_Status_In_Progress(auctionname); // Verify Auction Status
														// in progress

		/* Upcoming only */

		System.out.println("Step :: Select Upcoming only");
		common.log("<br></br> Step :: Select Upcoming only");
		common.waitForElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']"));

		driver.findElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']")).click();
		common.pause(10);

		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Upcoming only']")).click();

		/* Closed */

		common.log("<br></br> Step :: To verify Sale status closed display when show type closed selected");
		System.out.println("Step :: To verify Sale status closed display when show type closed selected");

		System.out.println("Step :: Select Closed");
		common.log("<br></br> Step :: Select Closed");
		common.waitForElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']"));

		driver.findElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']")).click();
		common.pause(10);

		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Closed']")).click();

		verify_Auction_Not_Display(auctionname); // Auction is not display

	}

	/**
	 * 
	 * Verify Auction status in progress
	 * 
	 * 
	 * @param auctionname1
	 */
	public void Verify_Auction_Status_In_Progress(String auctionname) {

		for (int i = 0; i < 20; i++) {

			if (common.isElementPresent("//ul[@class='auclting yura']//a[text()=' " + auctionname
					+ "']//..//..//span[text()='" + LEGACY_USER_LIST_AUCTION_STATUS + "']"))

			{
				common.log("auction " + auctionname + " Sale In Progress display");
				System.out.println("auction " + auctionname + " Sale In Progress display");

				common.assertElementNotPresent("//ul[@class='auclting yura']//a[text()=' " + auctionname
						+ "']//..//..//span[text()='" + LEGACY_USER_LIST_AUCTION_STATUS + "']");

				common.pause(10);
				break;
			} else {
				common.log("auction " + auctionname + " is not present in this page");
				System.out.println("auction " + auctionname + " is not  present in this page");

				driver.findElement(By.xpath("//span[@id='" + LEGACY_USER_LST_NEXT_PAGE + "']//a[text()='Next']"))
						.click();
				common.pause(15);

			}

		}
	}

	/**
	 * 
	 * Verify Auction status Bidding now and upcoming
	 * 
	 * @param auctionname1
	 */
	public void Verify_Auction_Status_Upcoming(String auctionname) {

		for (int i = 0; i < 20; i++) {

			if (common.isElementPresent(
					"//ul[@class='auclting yura']//a[text()=' " + auctionname + "']//..//..//span[text()='Upcoming']"))

			{
				common.log("auction " + auctionname + " Sale Not display");
				System.out.println("auction " + auctionname + " Sale Not display");

				common.assertElementNotPresent("//ul[@class='auclting yura']//a[text()=' " + auctionname
						+ "']//..//..//span[text()='Upcoming']");

				common.pause(10);
				break;
			} else {
				common.log("auction " + auctionname + " is not present in this page");
				System.out.println("auction " + auctionname + " is not  present in this page");

				driver.findElement(By.xpath("//span[@id='" + LEGACY_USER_LST_NEXT_PAGE + "']//a[text()='Next']"))
						.click();

				common.pause(15);
			}

		}
	}

	/**
	 * Place bid in timed auction 12
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param lotName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void Place_Bid_Value_Timed_Auction_12(String saleno, String auctionName, String lotName1, String lotName2,
			String lotName3, String lotName4, String lotName5, String lotName6, String lotName7, String lotName8,
			String lotName9, String lotName10, String lotName11, String lotName12)
			throws InterruptedException, AWTException {

		goto_Catalog_Page_Timed_Sale(auctionName);

		System.out.println("Step :: Fill Place bid value");
		common.log("<br></br> Step :: Fill Place bid value");

		common.pause(30);

		System.out.println("Step :: Fill Place bid value in lot 1 >> " + lotName1);
		common.log("<br></br> Step :: Fill Place bid value in lot 1 >> " + lotName1);
		driver.findElement(By.xpath("//h2//a[text()='" + lotName1 + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMED_MAX_BID + "']")).sendKeys("200");

		System.out.println("Step :: Fill Place bid value in lot2 >> " + lotName2);
		common.log("<br></br> Step :: Fill Place bid value in lot 2 >> " + lotName2);
		driver.findElement(By.xpath("//h2//a[text()='" + lotName2 + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMED_MAX_BID + "']")).sendKeys("200");

		System.out.println("Step :: Fill Place bid value in lot 3 >> " + lotName3);
		common.log("<br></br> Step :: Fill Place bid value in lot 3 >> " + lotName3);
		driver.findElement(By.xpath("//h2//a[text()='" + lotName3 + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMED_MAX_BID + "']")).sendKeys("200");

		System.out.println("Step :: Fill Place bid value in lot 4 >> " + lotName4);
		common.log("<br></br> Step :: Fill Place bid value in lot 4 >> " + lotName4);
		driver.findElement(By.xpath("//h2//a[text()='" + lotName4 + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMED_MAX_BID + "']")).sendKeys("200");

		System.out.println("Step :: Fill Place bid value in lot 5 >> " + lotName5);
		common.log("<br></br> Step :: Fill Place bid value in lot 5 >> " + lotName5);
		driver.findElement(By.xpath("//h2//a[text()='" + lotName5 + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMED_MAX_BID + "']")).sendKeys("200");

		System.out.println("Step :: Fill Place bid value in lot 6 >> " + lotName6);
		common.log("<br></br> Step :: Fill Place bid value in lot 6 >> " + lotName6);
		driver.findElement(By.xpath("//h2//a[text()='" + lotName6 + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMED_MAX_BID + "']")).sendKeys("200");

		System.out.println("Step :: Fill Place bid value in lot 7 >> " + lotName7);
		common.log("<br></br> Step :: Fill Place bid value in lot 7 >> " + lotName7);
		driver.findElement(By.xpath("//h2//a[text()='" + lotName7 + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMED_MAX_BID + "']")).sendKeys("200");

		System.out.println("Step :: Fill Place bid value in lot 8 >> " + lotName8);
		common.log("<br></br> Step :: Fill Place bid value in lot 8 >> " + lotName8);
		driver.findElement(By.xpath("//h2//a[text()='" + lotName8 + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMED_MAX_BID + "']")).sendKeys("200");

		System.out.println("Step :: Fill Place bid value in lot 9 >> " + lotName9);
		common.log("<br></br> Step :: Fill Place bid value in lot 9 >> " + lotName9);
		driver.findElement(By.xpath("//h2//a[text()='" + lotName9 + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMED_MAX_BID + "']")).sendKeys("200");

		System.out.println("Step :: Fill Place bid value in lot 10 >> " + lotName10);
		common.log("<br></br> Step :: Fill Place bid value in lot 10 >> " + lotName10);
		driver.findElement(By.xpath("//h2//a[text()='" + lotName10 + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMED_MAX_BID + "']")).sendKeys("200");

		System.out.println("Step :: Fill Place bid value in lot 11 >> " + lotName11);
		common.log("<br></br> Step :: Fill Place bid value in lot 11 >> " + lotName11);
		driver.findElement(By.xpath("//h2//a[text()='" + lotName11 + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMED_MAX_BID + "']")).sendKeys("200");

		System.out.println("Step :: Fill Place bid value in lot 12 >> " + lotName12);
		common.log("<br></br> Step :: Fill Place bid value in lot 12 >> " + lotName12);
		driver.findElement(By.xpath("//h2//a[text()='" + lotName12 + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMED_MAX_BID + "']")).sendKeys("200");

		System.out.println("Step :: Click on place multibid button");
		common.log("<br></br> Step :: Click on place multibid button");
		driver.findElement(By.xpath("//span[@id='" + LEGACY_USER_BTN_PLACE_MULTIBID + "']")).click();

		System.out.println("Step :: Click on Confirm Button");
		common.log("<br></br> Step :: Click on Confirm button");
		driver.findElement(By.xpath("//span//input[@id='" + LEGACY_USER_BTN_PLACE_MULTIBID_CONFIRM + "']")).click();

		common.acceptAlert();

		common.jsClick(logout);
	}

	/**
	 * Verify Account Label
	 * 
	 */

	public void Verify_Account_Label(String Accountlbl)

	{
		String str_accountlbl = driver.findElement(By.xpath("//li[@class='accounts']")).getText();

		System.out.println("Account Label is :: " + str_accountlbl);

		common.assertTwoValuesAreEqual(str_accountlbl, Accountlbl);

	}

	/**
	 * Verify Auction Label
	 * 
	 */

	public void Verify_Auction_Label(String Accountlbl)

	{
		common.pause(30);
		String str_auctionlbl = driver.findElement(By.xpath("//a[contains(text(),'" + Accountlbl + "')]")).getText();

		System.out.println("Auction Label is :: " + str_auctionlbl);

		common.assertTwoValuesAreEqual(str_auctionlbl, Accountlbl);

	}

	/**
	 * Verify Buy credit Label
	 * 
	 */

	public void Verify_BuyCredit_Label(String BuyCreditlbl) {

		String str_buycreditlbl = driver.findElement(By.xpath("//li[@class='buy-credits']")).getText();

		System.out.println("Buy Credit Label is :: " + str_buycreditlbl);

		common.assertTwoValuesAreEqual(str_buycreditlbl, BuyCreditlbl);

	}

	/**
	 * Verify Login Label
	 * 
	 */

	public void Verify_Login_Label(String Loginlbl) {

		common.pause(20);
		String str_Loginlbl = driver.findElement(By.xpath("//li[@title='Login']")).getText();

		System.out.println("Login Label is :: " + Loginlbl);

		common.assertTwoValuesAreEqual(str_Loginlbl, Loginlbl);

	}

	/**
	 * Verify Logout Label
	 * 
	 */

	public void Verify_Logout_Label(String Logoutlbl) {
		common.pause(10);
		String str_logout = driver.findElement(By.xpath("//a[text()='" + Logoutlbl + "']")).getText();

		System.out.println("Logout Label is :: " + str_logout);

	}

	/**
	 * Verify Invoices Label
	 * 
	 */

	public void Verify_Invoices_Label(String Invoiceslbl) {
		String str_Invoiceslbl = driver.findElement(By.xpath("//li[@title='" + Invoiceslbl + "']")).getText();

		System.out.println("Invoices Label is :: " + str_Invoiceslbl);

		common.assertTwoValuesAreEqual(str_Invoiceslbl, Invoiceslbl);

	}

	/**
	 * Verify My buyers Label
	 * 
	 */

	public void Verify_MyBuyers_Label(String Buyerslbl) {
		String str_Mybuyersname = driver.findElement(By.xpath("//li[@title='" + Buyerslbl + "']")).getText();

		System.out.println("My Buyers Label is :: " + str_Mybuyersname);

		common.assertTwoValuesAreEqual(str_Mybuyersname, Buyerslbl);

	}

	/**
	 * Verify My Item Label
	 * 
	 */

	public void Verify_MyItems_Label(String Itemslbl) {
		String str_Myitemsname = driver.findElement(By.xpath("//li[@title='" + Itemslbl + "']")).getText();

		System.out.println("My Items Label is :: " + str_Myitemsname);

		common.assertTwoValuesAreEqual(str_Myitemsname, Itemslbl);

	}

	/**
	 * Verify My Profile Label
	 * 
	 */

	public void Verify_MyProfile_Label(String Profilelbl) {
		String str_Myprofilename = driver.findElement(By.xpath("//li[@title='" + Profilelbl + "']")).getText();

		System.out.println("My Profile Label is :: " + str_Myprofilename);

		common.assertTwoValuesAreEqual(str_Myprofilename, Profilelbl);

	}

	/**
	 * Verify Settelment Label
	 * 
	 */

	public void Verify_Settelment_Label(String Settelmentlbl) {
		String str_Settelmentname = driver.findElement(By.xpath("//li[@title='" + Settelmentlbl + "']")).getText();

		System.out.println("Settelment Label is :: " + str_Settelmentname);

		common.assertTwoValuesAreEqual(str_Settelmentname, Settelmentlbl);

	}

	/**
	 * Verify Signup Label
	 * 
	 */

	public void Verify_Signup_Label(String Signuplbl) {
		String str_Signupname = driver.findElement(By.xpath("//li[@title='" + Signuplbl + "']")).getText();

		System.out.println("Signup Label is :: " + str_Signupname);

		common.assertTwoValuesAreEqual(str_Signupname, Signuplbl);

	}

	/**
	 * Verify Auction tab Label
	 * 
	 */

	public void Verify_Auction_Tab_Label(String auctionlbl) {
		common.pause(10);
		String str_Auctionlbl = driver.findElement(By.xpath("//li[@title='" + auctionlbl + "']")).getText();

		System.out.println("Auction Label is :: " + str_Auctionlbl);

		common.assertTwoValuesAreEqual(str_Auctionlbl, auctionlbl);

	}

	/**
	 * Verify LiveSearch tab Label
	 * 
	 */

	public void Verify_LiveSeach_Tab_Label(String livesearchlbl) {
		String str_livesearchlbl = driver.findElement(By.xpath("//li[@title='" + livesearchlbl + "']")).getText();

		System.out.println("LiveSearch Label is :: " + str_livesearchlbl);

		common.assertTwoValuesAreEqual(str_livesearchlbl, livesearchlbl);

	}

	/**
	 * Verify TimedSearch tab Label
	 * 
	 */

	public void Verify_TimedSeach_Tab_Label(String timesearchlbl) {
		String str_timesearchlbl = driver.findElement(By.xpath("//li[@class='individual-timed-lots']")).getText();

		System.out.println("TimeSeach Label is :: " + str_timesearchlbl);

		common.assertTwoValuesAreEqual(str_timesearchlbl, timesearchlbl);

	}

	/**
	 * Verify Auctioneer Label
	 * 
	 */

	public void Verify_Auctioneer_Label(String Auctioneerlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		// Auctioneer not display in front end

	}

	/**
	 * Verify Description Label
	 * 
	 */

	public void Verify_Description_Label(String Descriptionlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//div[@class='auclist auchome']//ul[1]//a[@class='cat']")).click();

		common.pause(20);
		System.out.println("Step :: Click on Auction info");
		common.log("<br></br> Step :: Click on Auction info");
		common.waitForElement(By.xpath("//a[@class='aucinfo']"));
		driver.findElement(By.xpath("//a[@class='aucinfo']")).click();

		common.pause(25);
		String str_description = driver.findElement(By.xpath("//a[text()='Description']")).getText();

		System.out.println("Description label is :: " + str_description);

		common.pause(5);

	}

	/**
	 * Verify Auction Email Label
	 * 
	 */

	public void Verify_AuctionEmail_Label(String AuctionEmaillbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		// Auctioneer not display in front end

	}

	/**
	 * Verify Live Now Label
	 * 
	 */

	public void Verify_LiveNow_Label(String LiveNowlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//div[@class='auclist auchome']//ul[1]//a[@class='cat']")).click();

		common.pause(20);
		String livenowlbl = driver.findElement(By.xpath("//a[@class='catalog-live-sale-link']")).getText();

		System.out.println("Live Now label is :: " + livenowlbl);

		// common.assertTwoValuesAreEqual(LiveNowlbl, livenowlbl);

	}

	/**
	 * Verify Location Label
	 * 
	 */

	public void Verify_Location_Label(String LiveNowlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify shipping info Label
	 * 
	 */

	public void Verify_ShippingInfo_Label(String ShippingInfolbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//div[@class='auclist auchome']//ul[1]//a[@class='cat']")).click();

		common.pause(20);
		System.out.println("Step :: Click on Auction info");
		common.log("<br></br> Step :: Click on Auction info");
		driver.findElement(By.xpath("//a[@class='aucinfo']")).click();

		common.pause(15);
		String str_shippinginfo = driver.findElement(By.xpath("//a[text()='Shipping info']")).getText();

		System.out.println("ShippingInfo label is :: " + str_shippinginfo);

		common.pause(5);

	}

	/**
	 * Verify Terms & Condition Label
	 * 
	 */

	public void Verify_Terms_and_Condition_Label(String Terms_condilbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//div[@class='auclist auchome']//ul[1]//a[@class='cat']")).click();

		common.pause(20);
		System.out.println("Step :: Click on Auction info");
		common.log("<br></br> Step :: Click on Auction info");
		driver.findElement(By.xpath("//a[@class='aucinfo']")).click();

		common.pause(15);
		String str_termscondi = driver.findElement(By.xpath("//a[text()='Terms and conditions']")).getText();

		System.out.println("Terms & Condition label is :: " + str_termscondi);

		common.pause(5);

	}

	/**
	 * Verify Time Left Label
	 * 
	 */

	public void Verify_TimeLeft_Label(String Terms_condilbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);

	}

	/**
	 * Verify Auction Type Label
	 * 
	 */

	public void Verify_AuctionType_Label(String Terms_condilbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);

	}

	/**
	 * Verify View All Lots Label
	 * 
	 */

	public void Verify_View_all_Lots_Label(String Terms_condilbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);

	}

	/**
	 * Verify View Live Sale Now Label
	 * 
	 */

	public void Verify_View_LiveSale_Now_Label(String Viewlivsalelbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//div[@class='auclist auchome']//ul[1]//a[@class='cat']")).click();

		common.pause(20);
		System.out.println("Step :: Click on Auction info");
		common.log("<br></br> Step :: Click on Auction info");
		driver.findElement(By.xpath("//a[@class='aucinfo']")).click();
		common.pause(15);
		// String str_viewlivesale =
		// driver.findElement(By.xpath("//button[@class='button
		// participate']")).getText();
		//
		// System.out.println("New label is :: " + str_viewlivesale);
		//
		// common.pause(5);
		// common.assertTwoValuesAreEqual(str_viewlivesale, Viewlivsalelbl);

	}

	/**
	 * Verify View catalog Label
	 * 
	 */

	public void Verify_View_Catalog_Label(String cataloglbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//div[@class='auclist auchome']//ul[1]//a[@class='cat']")).click();

		common.pause(20);

	}

	/**
	 * Verify View Date Label
	 * 
	 */

	public void Verify_Date_Label() {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//div[@class='auclist auchome']//ul[1]//a[@class='cat']")).click();

		common.pause(20);

//		String strcataloglbl = driver.findElement(By.xpath("//h3//span[2]")).getText();
//
//		System.out.println("Step :: New Date Formate " + strcataloglbl);

	}

	/**
	 * Verify View catalog Label
	 * 
	 */

	public void Verify_View_Auction_Tab_Label(String auctionlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//div[@class='auclist auchome']//ul[1]//a[@class='cat']")).click();

		common.pause(20);
	}

	/**
	 * Verify Advanced page Label
	 * 
	 */

	public void Verify_Advanced_Label(String advancedlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
	}

	/**
	 * Verify All Auctioneers Label
	 * 
	 */

	public void Verify_All_Auctioneers_Label(String allAuctioneerlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(40);

		String str_auctionner = driver
				.findElement(By.xpath("//select[@id='alf9']//option[text()='" + allAuctioneerlbl + "']")).getText();
		System.out.println("All Auctioneers label is :: " + str_auctionner);
		common.pause(5);

	}

	/**
	 * Verify All Sales page Label
	 * 
	 */

	public void Verify_All_Sales_Label(String allsalelbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(40);

		String str_allsale = driver.findElement(By.xpath("//select[@id='alf3']//option[text()='" + allsalelbl + "']"))
				.getText();
		System.out.println("All Sale label is :: " + str_allsale);
		common.pause(5);
	}

	/**
	 * Verify View Short Date Label
	 * 
	 */

	public void Verify_Short_Date_Label() {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify live and time sale dropdown
	 * 
	 */

	public void Verify_Live_And_Time_Sale_LST_Label(String liveandtimesalelst) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify live only sale dropdown
	 * 
	 * @throws AWTException
	 * 
	 */

	public void Verify_Live_Only_LST_Label(String liveonlylst) throws AWTException {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		System.out.println("Step :: Select Live Only");
		common.log("<br></br> Step :: Select Live Only");
		WebElement liveonly = driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a"));

		liveonly.click();

		String strliveonly = driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//option[@value='2']")).getText();

		System.out.println("Step :: New Live only label is >> " + strliveonly);
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		common.pause(5);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		common.pause(5);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		common.pause(5);

		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		common.pause(20);

	}

	/**
	 * Verify Date Long Secs Label
	 * 
	 */

	public void Verify_Date_Long_Secs_Label(String datelongsecslbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(5);
	}

	/**
	 * Verify Ongoing Event Label
	 * 
	 */

	public void Verify_Ongoing_Event_Label(String ongoinglbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(5);
	}

	/**
	 * Verify live Label
	 * 
	 * @throws AWTException
	 * 
	 */

	public void Verify_Live_Label(String livelbl) throws AWTException {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(20);

		// Select Live Only

		System.out.println("Step :: Select Live Only");
		common.log("<br></br> Step :: Select Live Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Live only']")).click();

		common.pause(30);

		// ul[@class='auclting yura'][1]//a[text()='cfifq']
		String strlivelable = driver
				.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[text()='" + livelbl + "']")).getText();

		System.out.println("Step :: Live lable display ::" + strlivelable);
		common.log("<br></br> Step :: Live lable display ::" + strlivelable);

	}

	/**
	 * Verify Timed Label
	 * 
	 * @throws AWTException
	 * 
	 */

	public void Verify_Timed_Label(String timelbl) throws AWTException {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(15);

		// Select Timed Only
		System.out.println("Step :: Select Timed Only");
		common.log("<br></br> Step :: Select Timed Only");
		WebElement timedonly = driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a"));

		timedonly.click();
		Robot rb = new Robot();
		common.pause(10);

		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		common.pause(5);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		common.pause(5);
		// rb.keyPress(KeyEvent.VK_DOWN);
		// rb.keyRelease(KeyEvent.VK_DOWN);
		// common.pause(5);

		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		common.pause(20);

		// ul[@class='auclting yura'][1]//a[text()='cfifq']
		String strTimedlable = driver
				.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[text()='" + timelbl + "']")).getText();

		System.out.println("Step :: Timed lable display ::" + strTimedlable);
		common.log("<br></br> Step :: Timed lable display ::" + strTimedlable);

	}

	/**
	 * Verify Hybrid Only Label
	 * 
	 * @throws AWTException
	 * 
	 */

	public void Verify_HybridOnly_Label(String timelbl) throws AWTException {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(20);

		Actions actions = new Actions(driver);

		System.out.println("Step :: Select Hybrid Auction");
		common.log("<br></br> Step :: Select Hybrid Auction");
		common.pause(30);

		WebElement element = driver
				.findElement(By.xpath("//span[@id='" + LEGACY_USER_LST_SELECT_SALE_TYPE + "']//..//a"));

		element.click();
		Robot rb = new Robot();
		common.pause(10);

		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		common.pause(5);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		common.pause(5);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		common.pause(5);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		common.pause(5);

		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		common.pause(20);

		// ul[@class='auclting yura'][1]//a[text()='cfifq']
		// String strTimedlable =
		// driver.findElement(By.xpath("//ul[@class='auclting
		// yura'][1]//a[text()='"+timelbl+"']")).getText();
		//
		// System.out.println("Step :: Timed lable display ::"+strTimedlable);
		// common.log("<br></br> Step :: Timed lable display ::"+strTimedlable);

	}

	/**
	 * Verify live only sale dropdown
	 * 
	 */

	public void Verify_Registered_Label(String registerdlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		String registeredlbl = driver.findElement(By.xpath("//label[contains(text(),'" + registerdlbl + "')]"))
				.getText();

		System.out.println("Step :: New Registered Label is >> " + registeredlbl);
		common.assertTwoValuesAreEqual(registeredlbl, registerdlbl);

	}

	/**
	 * Verify Sorry you don't bidder previlige Label
	 * 
	 */

	public void Verify_Sorry_You_Dont_Have_Bidder_Label(String timelbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a" + "[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Select Live Only");
		common.log("<br></br> Step :: Select Live Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Live only']")).click();
		common.pause(30);
		System.out.println("Step :: Click on Register to Bid  button");
		common.log("<br></br> Step :: Click on Register to Bid button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[text()='Register to bid!']")).click();
		common.pause(15);
	}

	/**
	 * Verify Enter the number of days Label
	 * 
	 */

	public void Verify_Enter_The_Numver_Of_Days_Label(String noofdayslbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(10);
	}

	/**
	 * Verify Lot wich are not display Label
	 * 
	 */

	public void Verify_Lot_Which_Are_Not_Display_Label(String lotlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(10);
	}

	/**
	 * Verify Show Label
	 * 
	 */

	public void Verify_Show_Label(String showlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(30);

		String showlbl1 = driver.findElement(By.xpath("//div[@class='accordionButton']")).getText();
		common.pause(15);

		System.out.println("Step :: New show Label is >> " + showlbl1);

	}

	/**
	 * Verify show all label
	 * 
	 */

	public void Verify_Show_All_Label(String showalllbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(25);

		String showalllbl1 = driver.findElement(By.xpath("//select[@id='alf1']//option[@value='0']")).getText();
		common.pause(15);

		System.out.println("Step :: New show All Label is >> " + showalllbl1);

	}

	/**
	 * Verify show bidding now only label
	 * 
	 */

	public void Verify_Show_Bidding_Now_Only_Label(String showbiddingnowonlylbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		String showbiddingnow = driver.findElement(By.xpath("//select[@id='alf1']//option[@value='2']"))
				.getAttribute("name");
		common.pause(15);

		System.out.println("Step :: New show Bidding Now Label is >> " + showbiddingnow);

	}

	/**
	 * Verify show bidding now and upcoming only label
	 * 
	 */

	public void Verify_Show_Bidding_Now_and_Upcoming_Only_Label(String showbiddingnowupcominglbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		String showbiddingnowupcoming = driver.findElement(By.xpath("//select[@id='alf1']//option[@value='1']"))
				.getAttribute("name");
		common.pause(15);

		System.out.println("Step :: New show Bidding Now and upcoming Label is >> " + showbiddingnowupcoming);

	}

	/**
	 * Verify Pending Approval Label
	 * 
	 */

	public void Verify_Pending_Approval_Label(String pendinglbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(10);
	}

	/**
	 * Verify Register For Auction Label
	 * 
	 */

	public void Verify_Register_For_Auction_Label(String regiterlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(10);
	}

	/**
	 * Verify The Auction Will not visible Label
	 * 
	 */

	public void Verify_Auction_Will_Not_Visible_Label(String auctionlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(10);
	}

	/**
	 * Verify Sales Ends In Label
	 * 
	 */

	public void Verify_Sales_Ends_Label(String saleendlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(10);
	}

	/**
	 * Verify Sales Starts In Label
	 * 
	 */

	public void Verify_Sales_Starts_Label(String salestartlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(10);
	}

	/**
	 * Verify show bidding now and upcoming only label
	 * 
	 */

	public void Verify_Show_Closed_Only_Label(String showclosedlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(25);
		String showclosed = driver.findElement(By.xpath("//select[@id='alf1']//option[@value='4']"))
				.getAttribute("name");
		common.pause(15);

		System.out.println("Step :: New show Closed Label is >> " + showclosed);

	}

	/**
	 * Verify Starts Ending %s Label
	 * 
	 */

	public void Verify_Starts_Ending_Label(String startsendlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(10);
	}

	/**
	 * Verify Account Name Label
	 * 
	 */

	public void Verify_Account_Name_Label(String accnamelbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(10);
	}

	/**
	 * Verify Auction Date Label
	 * 
	 */

	public void Verify_Auction_Date_Label(String aucdatelbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Format Label
	 * 
	 */

	public void Verify_Format_Label(String formatlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Name Label
	 * 
	 */

	public void Verify_Name_Label(String namelbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		common.waitForElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']"));
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(30);

	}

	/**
	 * Verify Status Label
	 * 
	 * @throws AWTException
	 * 
	 */

	public void Verify_Status_Label1(String statuslbl) throws AWTException {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(40);

		// Select Live Only

		System.out.println("Step :: Select Live Only");
		common.log("<br></br> Step :: Select Live Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Live only']")).click();
		common.pause(30);

		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		common.waitForElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']"));
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(30);

		// String status_str = driver.findElement(By.xpath("//th[@class='hdr-alf4
		// alf4-col6 th-auct-status']")).getText();
		// System.out.println("Status label is :: " + status_str);
		// common.pause(10);

		// common.assertTwoValuesAreEqual(status_str, statuslbl);
	}

	/**
	 * Verify Format Test Label
	 * 
	 */

	public void Verify_Format_Test_Label(String formattestlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Lots Label
	 * 
	 */

	public void Verify_Lots_Label(String lotslbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(15);
		String lots_str = driver.findElement(By.xpath("//p[2]")).getText();
		System.out.println("Lots is :: " + lots_str);
		common.pause(10);

	}

	/**
	 * Verify Registration Label
	 * 
	 */

	public void Verify_Registration_Label(String reglbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Sale # Label
	 * 
	 */

	public void Verify_sale_Label(String salelbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Timed Only Dropdown
	 * 
	 */

	public void Verify_Timed_Only_DropDown_Label(String timedlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(30);

		String timed_str = driver.findElement(By.xpath("//select[@id='alf3']//option[@value='1']"))
				.getAttribute("name");
		System.out.println("Dropdown value is :: " + timed_str);
		common.pause(10);

	}

	/**
	 * Verify Catalog label
	 * 
	 */

	public void Verify_Catalog_Label(String cataloglbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(20);

		String catalog_str = driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).getText();
		System.out.println("Catalog label is :: " + catalog_str);
		common.pause(10);

	}

	/**
	 * Verify Price Realized Label
	 * 
	 */

	public void Verify_Price_Realized_Label(String pricelbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Auction Date(s): Label
	 * 
	 */

	public void Verify_Auction_DateS_Label(String Aucdatelbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Auction Date(s): Label
	 * 
	 */

	public void Verify_Account_Label1(String Accountlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Auctioneer Label
	 * 
	 */

	public void Verify_Auctioneer_Label1(String Auctioneerlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Status Label
	 * 
	 */

	public void Verify_Auction_Status_Label(String Auctionstatuslbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Type Label
	 * 
	 */

	public void Verify_Auction_Type_Label(String Auctiontypelbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Type Label
	 * 
	 */

	public void Verify_Last_Updated_Label(String Auctiontypelbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Lot Label
	 * 
	 */

	public void Verify_Lot3_Label(String Lotlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Lots Label
	 * 
	 */

	public void Verify_Lots_Label1(String Lotslbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Lot sold Label
	 * 
	 */

	public void Verify_Lot_Sold_Label(String Lotsoldlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Lot Count Label
	 * 
	 */

	public void Verify_Lot_Count_Label(String Lotcountlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Lot # Label
	 * 
	 */

	public void Verify_Lot_Hash_Label(String Lothashlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Realized Label
	 * 
	 */

	public void Verify_Reliazed_Label(String realizedlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Realized Label
	 * 
	 */

	public void Verify_Reliazed_Result_Label(String realizedlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Auction Result Label
	 * 
	 */

	public void Verify_Reliazed_Auction_Result_Label(String realizedlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Auction Description result
	 * 
	 */

	public void Verify_Auction_Description_Label(String auctionresultlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Auction Agreement Number
	 * 
	 */

	public void Verify_Auction_Agreement_Number_Label(String auctionresultlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Auction Schedule
	 * 
	 */

	public void Verify_Auction_Schedule_Label(String auctionschedulelbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Company
	 */

	public void Verify_Company_Label(String auctionschedulelbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Consignor
	 */

	public void Verify_Consignor_Label(String consignorlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify April Month
	 */

	public void Verify_April_Month_Label(String aprillbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify August Month
	 */

	public void Verify_August_Month_Label(String augustlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify December Month
	 */

	public void Verify_December_Month_Label(String decemberlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify February Month
	 */

	public void Verify_February_Month_Label(String feblbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify July Month
	 */

	public void Verify_July_Month_Label(String julylbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify January Month
	 */

	public void Verify_January_Month_Label(String janlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify June Month
	 */

	public void Verify_June_Month_Label(String junelbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify June Month
	 */

	public void Verify_March_Month_Label(String marchlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify June Month
	 */

	public void Verify_May_Month_Label(String maylbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify November Month
	 */

	public void Verify_November_Month_Label(String novemberlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify October Month
	 */

	public void Verify_October_Month_Label(String octoberlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Septmber Month
	 */

	public void Verify_September_Month_Label(String septlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Cancelled Label
	 */

	public void Verify_Cancelled_Label(String cancelledlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Deleted Label
	 */

	public void Verify_Deleted_Label(String deletedlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Cash Label
	 */

	public void Verify_Cash_Label(String cashlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Cashiers check
	 */

	public void Verify_Cashiers_Check_Label(String cashierchecklbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify check
	 */

	public void Verify_Check_Label(String checklbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Bank Wire
	 */

	public void Verify_BankWire_Label(String bankWirelbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Credit Card
	 */

	public void Verify_CreditCard_Label(String creditcardlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Open Card
	 */

	public void Verify_Open_Label(String openlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Credit Memo
	 */

	public void Verify_CreditMemo_Label(String crdMemolbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Google Checkout
	 */

	public void Verify_GoogleCheckout_Label(String googleChkOutlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Money Order
	 */

	public void Verify_Money_Order_Label(String moneyorderlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Other Option label
	 */

	public void Verify_Other_Label(String otherlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Paypal label
	 */

	public void Verify_Paypal_Label(String paypallbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Shipped Label
	 * 
	 * @throws AWTException
	 * 
	 */

	public void Verify_Shipped_Label(String shippedlbl) throws AWTException {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(30);
		System.out.println("Step  :: Click on Invoices");
		common.log("<br></br> Step  :: Click on Invoices");
		driver.findElement(By.xpath("//a[text()='Invoices']")).click();

		common.pause(30);
		Actions actions = new Actions(driver);
		WebElement Pending = driver.findElement(By.xpath("//select[@id='mil1']"));

		Pending.click();
		Robot rb = new Robot();
		// rb.keyPress(KeyEvent.VK_META);
		// rb.keyPress(KeyEvent.VK_TAB);
		// common.pause(1);
		// rb.keyRelease(KeyEvent.VK_META);
		// rb.keyRelease(KeyEvent.VK_TAB);
		common.pause(10);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		common.pause(5);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		common.pause(5);
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		common.pause(5);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		common.pause(30);

		// WebElement select_Pending = driver.findElement(By.linkText("Shipped"));
		// common.pause(20);
		//
		// actions.moveToElement(select_Pending);
		// actions.moveToElement(select_Pending).click().perform();
		// common.pause(20);

		// String shipped =
		// driver.findElement(By.xpath("//div[@class='action']")).getText();
		// System.out.println("Step :: New shipped Label is >> " + shipped);

		common.pause(25);
	}

	/**
	 * Verify Catalog Label
	 * 
	 */

	public void Verify_Catalog_Label1(String catlglbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Auction Info Label
	 * 
	 */

	public void Verify_AuctionInfo_Label(String pendingbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Live Sale Label
	 * 
	 */

	public void Verify_Live_Sale_Label(String livesalelbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Catalog Label in View Auction
	 * 
	 */

	public void Verify_Catalog1_Label(String catloglbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		common.waitForElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']"));
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();

		common.pause(5);
	}

	/**
	 * Verify Auction Info Label in View Auction
	 * 
	 */

	public void Verify_AucInfo1_Label(String catloglbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		common.waitForElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']"));
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();

		common.pause(5);
	}

	/**
	 * Verify Live Sale Label in View Auction
	 * 
	 */

	public void Verify_LiveSale1_Label(String livesaleglbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		common.waitForElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']"));
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();

		common.pause(5);
	}

	/**
	 * Verify Your Absentee bid not placed Label in Catalog
	 * 
	 */

	public void Verify_Absentee_Bid_Not_Placed_Label(String absentelbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();

		common.pause(5);
	}

	/**
	 * lot has already been awarded in catalog
	 * 
	 */

	public void Verify_Lot_Has_Been_Awarded_Label(String lotlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();

		common.pause(5);
	}

	/**
	 * lot has already been sold in catalog
	 * 
	 */

	public void Verify_Lot_Has_Been_Sold_Label(String lotsoldlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();

		common.pause(5);
	}

	/**
	 * Accept & sell in catalog
	 * 
	 */

	public void Verify_Accept_and_Sell_Label(String accselllbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();

		common.pause(5);
	}

	/**
	 * Accept & sell Has Been Disabled in catalog
	 * 
	 */

	public void Verify_Accept_and_Sell_Disabled_Label(String accselldislbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();

		common.pause(5);
	}

	/**
	 * Add to Watchlist in catalog
	 * 
	 */

	public void Verify_Ad_to_Watchlist1_Label(String adtolistlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();

		common.pause(5);
	}

	/**
	 * Add to Watchlist Button in catalog
	 * 
	 */

	public void Verify_Add_to_Watchlist_Button_Label(String adtolistlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();

		common.pause(40);
		// String addtowatch_str =
		// driver.findElement(By.xpath("//input[@id='lac19']")).getText();
		//
		// System.out.println("Add To Watchlist Button Label is ::" + addtowatch_str);
		//
		// common.pause(5);
	}

	/**
	 * Add Force Bid to %s
	 * 
	 */

	public void Verify_Add_Force_Bid_To_Label(String addforcebidlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
	}

	/**
	 * Catalog Asking Bid
	 * 
	 */

	public void Verify_Catalog_Asking_Bid(String catalogaskinglbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
	}

	/**
	 * Your Current Total
	 * 
	 */

	public void Verify_Your_Current_Total(String currenttotallbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();

	}

	/**
	 * You are higher bidder
	 * 
	 * @throws AWTException
	 * 
	 */

	public void Verify_You_Are_Higher_Bidder_Label(String youarehigherbidder) throws AWTException {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);

		// Select Live Only

		System.out.println("Step :: Select Live Only");
		common.log("<br></br> Step :: Select Live Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Live only']")).click();
		common.pause(30);

		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(10);
	}

	/**
	 * You are higher bidder
	 * 
	 */

	public void Verify_Your_Absenteebid_Placed_Label(String yourabsbidplaced) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(10);
	}

	/**
	 * Place Bid
	 * 
	 * @param lotname
	 * @throws AWTException
	 * 
	 */

	public void verify_Your_Bid_Has_been_Placed(String auctionName, String lotname) throws AWTException {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		goto_Catalog_Page_Live_Sale(auctionName);
		common.pause(15);
		System.out.println("Step :: Fill Bid Value");
		common.log("<br></br> Step :: Fill Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotname + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_REGULAR_LIVE_BID + "']")).sendKeys("250");

		System.out.println("Step :: Click on Placebid button");
		common.log("<br></br> Step :: Click on Placebid button");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotname + "']//..//..//..//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']"))
				.click();
		common.acceptAlert();
		common.pause(20);

	}

	/**
	 * Place Bid 50
	 * 
	 * @param lotname
	 * @throws AWTException
	 * 
	 */

	public void Place_50_Bid(String auctionName, String lotname) throws AWTException {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		goto_Catalog_Page_Live_Sale(auctionName);

		System.out.println("Step :: Fill Bid Value");
		common.log("<br></br> Step :: Fill Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotname + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_REGULAR_LIVE_BID + "']")).sendKeys("50");

		System.out.println("Step :: Click on Placebid button");
		common.log("<br></br> Step :: Click on Placebid button");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotname + "']//..//..//..//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']"))
				.click();
		common.pause(15);

		System.out.println("Step :: Click on follow button");
		common.log("<br></br> Step :: Click on follow button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_FOLLOW + "']")).click();

		common.pause(20);
	}

	/**
	 * You Bid updated successfully
	 */

	public void Verify_Your_Bid_Upadted_Successfully(String yourbidupdatesuccessfully) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(10);
	}

	/**
	 * To Big Amount
	 */

	public void Verify_To_Big_Amount(String toobigamount) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(10);

	}

	/**
	 * To Small Amount
	 */

	public void Verify_To_Small_Amount(String toosmallamount) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(10);
	}

	/**
	 * To verify bid higher than someone
	 * 
	 * @throws AWTException
	 */

	public void Verify_Bid_Higher_Than_Someone(String higherbid) throws AWTException {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);

		// Select Live Only

		System.out.println("Step :: Select Live Only");
		common.log("<br></br> Step :: Select Live Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Live only']")).click();

		common.pause(30);

		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(10);

	}

	/**
	 * To verify bid Lower than someone
	 * 
	 * @throws AWTException
	 */

	public void Verify_Bid_Lower_Than_Someone(String Lowerbid) throws AWTException {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);

		// Select Live Only

		System.out.println("Step :: Select Live Only");
		common.log("<br></br> Step :: Select Live Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Live only']")).click();
		common.pause(30);

		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(10);

	}

	/**
	 * To verify bid Lower than someone
	 * 
	 * @param auctionName
	 * @throws AWTException
	 */

	public void Verify_You_Are_Higher_Bidder(String higherbidder, String auctionName) throws AWTException {

		goto_Catalog_Page_Live_Sale(auctionName);

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		// driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		System.out.println("Step :: Click on View Details button");
		common.log("<br></br> Step :: Click on View Details button");
		driver.findElement(By.xpath("//a[@class='yaaa']")).click();
		common.pause(20);
		driver.findElement(By.xpath("//input[@value='Place bid!']")).click();
		common.pause(50);
		driver.findElement(By.xpath("//input[@id='pbloi2']")).click();
		common.pause(20);
		String higherbidder1 = driver.findElement(By.xpath("//div[@id='lblMessage']")).getText();

		// common.assertTwoValuesAreEqual(higherbidder, higherbidder1);
		System.out.println("Step :: Higher Bidder New Label is >> " + higherbidder);

	}

	/**
	 * To verify low bidder
	 */

	public void Verify_Low_Bidder(String lowbidder) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(10);
	}

	/**
	 * To verify BN
	 */

	public void Verify_BN(String BN) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(10);

	}

	/**
	 * To verify Bulk Group
	 */

	public void Verify_Bulk_Group(String BulkGroup) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(10);
	}

	/**
	 * Place %s or more to win the group
	 */

	public void Verify_Place_S(String PlaceS) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Buy Now
	 * 
	 * @throws AWTException
	 */

	public void Verify_BuyNow(String Buynow, String auc) throws AWTException {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);

		goto_Catalog_Page_Live_Sale(auc);
		driver.findElement(By.xpath("//a[@class='yaaa']")).click();
		common.pause(25);

		String strbuynow = driver.findElement(By.xpath("//input[@value='Place bid!']")).getText();

		System.out.println("Buy now! Button Display :: " + strbuynow);
		common.log("Buy now! Button Display :: " + strbuynow);
		common.pause(10);
	}

	/**
	 * Auction Already Started
	 */

	public void Verify_Already_Started(String Alreadystarted) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(10);

	}

	/**
	 * Can not buy this item
	 */

	public void Verify_You_Can_Not_Buy_This_Item(String cannotbuy) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(10);
	}

	/**
	 * Currently up for bidding
	 */

	public void Verify_Currently_Up_for_Bidding(String currentlyup) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(10);
	}

	/**
	 * Category
	 * 
	 * @throws AWTException
	 */

	public void Verify_Category(String category) throws AWTException {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);

		// Select Live Only

		System.out.println("Step :: Select Live Only");
		common.log("<br></br> Step :: Select Live Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Live only']")).click();
		common.pause(30);

		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
		driver.findElement(By.xpath("//a[@class='yaaa']")).click();
		common.pause(25);

		common.pause(10);
		String cat = driver.findElement(By.xpath("//span[@class='cat-header']")).getText();

		System.out.println("Step :: New Category Label is >>" + cat);
		common.log("<br></br> Step :: New Category Label is >>" + cat);
	}

	/**
	 * Category
	 */

	public void Verify_Place_Bid_On_This_Lot_label(String placebid) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(10);
	}

	/**
	 * Goto lot
	 */

	public void Verify_Goto_Lot(String gotolot) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(10);
	}

	/**
	 * High to Low
	 * 
	 */
	public void Verify_High_To_Low(String hightolow) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(10);
	}

	/**
	 * Invalid or Bid
	 * 
	 */
	public void Verify_Invalid_bid(String invalidbid) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(10);
	}

	/**
	 * Invoice issued shorlty
	 * 
	 * @throws AWTException
	 * 
	 */
	public void Verify_Issued_Shorlty_bid(String issueshort, String auctionName) throws AWTException {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		goto_Catalog_Page_Live_Sale(auctionName);
		common.pause(10);
		System.out.println("Step :: Click on view Details");
		common.log("<br></br> Step :: Click on view Details");
		driver.findElement(By.xpath("//a[@class='yaaa']")).click();
		common.pause(25);

		String invoicemsg = driver.findElement(By.xpath("//div[@class='invoice-lnk']")).getText();

		// common.assertTwoValuesAreEqual(issueshort, invoicemsg);
		System.out.println("Step :: New Invoice Send Label is >>" + invoicemsg);

	}

	/**
	 * Invoice issued shorlty
	 * 
	 */
	public void Verify_Item_Number_bid(String itemnumber) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(10);
	}

	/**
	 * Loading
	 * 
	 */
	public void Verify_Loading_bid(String loading) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(10);
	}

	/**
	 * Lot S
	 * 
	 */
	public void Verify_Lot_S(String lots) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(10);
	}

	/**
	 * You Already Register for that
	 * 
	 */
	public void Verify_You_Already_Register_For_That(String register) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Accept Lot Changes
	 * 
	 */
	public void Verify_Accept_Lot_Changes(String acceptlotchanges) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(10);
	}

	/**
	 * Catalog Ask A Quetion
	 * 
	 */

	public void Verify_Catalog_Ask_A_Quetion(String catalogaskinglbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);

		// Not display at front-end side in v3-1 enviroments

	}

	/**
	 * Catalog AWarded
	 * 
	 */

	public void Verify_Catalog_Awarded(String catalogaskinglbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
	}

	/**
	 * Catalog AWarded With Reservation
	 * 
	 */

	public void Verify_Catalog_Awarded_With_Reservation(String catalogaskinglbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
	}

	/**
	 * Catalog AWarded Through Buy Now
	 * 
	 */

	public void Verify_Catalog_Awarded_Through_BuyNow(String buynowlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
	}

	/**
	 * Catalog Back To List
	 * 
	 */

	public void Verify_Catalog_Back_To_List(String backlistlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);

		// System.out.println("Step :: Click on View Details button");
		// common.log("<br></br> Step :: Click on View Details button");
		// driver.findElement(
		// By.xpath("//td[@class='row0-lac5 lac5-col8 td-cat-biddingcell
		// last']//..//a[text()='View details']"))
		// .click();
		//
		// String backlist =
		// driver.findElement(By.xpath("//div[@class='back-list']")).getText();
		//
		// common.assertTwoValuesAreEqual(backlistlbl, backlist);
		// System.out.println("Step :: New BackTo list Label is >>" + backlist);
	}

	/**
	 * Catalog Be The First bid
	 * 
	 */

	public void Verify_Catalog_Be_The_First_Bid(String firstbidlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
	}

	/**
	 * Catalog Please Bid Again
	 * 
	 */
	public void Verify_Catalog_Please_bid_Again(String bidagainlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
	}

	/**
	 * Catalog BidBuynow
	 * 
	 */

	public void Verify_Catalog_Bid_BuyNow(String bidbuynowlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
	}

	/**
	 * Catalog Big Ammount
	 * 
	 */

	public void Verify_Catalog_Big_Ammount(String bigammountlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
	}

	/**
	 * Catalog Small Ammount
	 * 
	 */

	public void Verify_Catalog_Small_Ammount(String smallammountlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
	}

	/**
	 * Catalog Changes
	 * 
	 */

	public void Verify_Catalog_Changes(String changlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
	}

	/**
	 * Catalog Click Image to Enlarge
	 * 
	 * @throws AWTException
	 * 
	 */

	public void Verify_Catalog_Image_Enlarge(String imagelbl) throws AWTException {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);

		// Select Live Only

		System.out.println("Step :: Select Live Only");
		common.log("<br></br> Step :: Select Live Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Live only']")).click();
		common.pause(30);

		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
		driver.findElement(By.xpath("//a[@class='yaaa']")).click();
		common.pause(25);

		String image = driver.findElement(By.xpath("//div[@class='clicktxt']")).getText();

		System.out.println("Step :: New Click image to enlarge Label is >>" + image);
	}

	/**
	 * Catalog Confirm
	 * 
	 */

	public void Verify_Confirm(String iconfirmlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(40);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
	}

	/**
	 * Catalog Month Day year
	 * 
	 * @throws AWTException
	 * 
	 */

	public void Verify_Month_Day_Year(String mnthdaylbl) throws AWTException {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);

		// Select Live Only

		System.out.println("Step :: Select Live Only");
		common.log("<br></br> Step :: Select Live Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Live only']")).click();
		common.pause(30);

		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
	}

	/**
	 * Catalog Hour Minute Second
	 * 
	 * @throws AWTException
	 * 
	 */

	public void Verify_Hour_Minute_Second(String HMSlbl) throws AWTException {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);

		// Select Live Only

		System.out.println("Step :: Select Live Only");
		common.log("<br></br> Step :: Select Live Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Live only']")).click();
		common.pause(30);

		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
	}

	/**
	 * Catalog Minute m Second s
	 * 
	 * @throws AWTException
	 * 
	 */

	public void Verify_Minutem_Seconds(String HMSlbl) throws AWTException {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		// Select Live Only

		System.out.println("Step :: Select Live Only");
		common.log("<br></br> Step :: Select Live Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Live only']")).click();
		common.pause(30);

		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
	}

	/**
	 * Catalog Second s
	 * 
	 * @throws AWTException
	 * 
	 */

	public void Verify_Seconds(String secondlbl) throws AWTException {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		// Select Live Only

		System.out.println("Step :: Select Live Only");
		common.log("<br></br> Step :: Select Live Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Live only']")).click();
		common.pause(30);

		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
	}

	/**
	 * Catalog Current ABsentee
	 * 
	 */

	public void Verify_Current_Absentee(String absenteelbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
	}

	/**
	 * Catalog Description
	 * 
	 * @throws AWTException
	 * 
	 */

	public void Verify_Description(String desclbl) throws AWTException {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		// Select Live Only

		System.out.println("Step :: Select Live Only");
		common.log("<br></br> Step :: Select Live Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Live only']")).click();
		common.pause(30);

		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
		driver.findElement(By.xpath("//a[@class='yaaa']")).click();
		common.pause(25);

		String desc = driver.findElement(By.xpath("//span[@class='desc-header']")).getText();

		System.out.println("Step :: New Description Label is >>" + desc);
	}

	/**
	 * Catalog Estimate
	 * 
	 * @throws AWTException
	 * 
	 */

	public void Verify_Estimate(String estlbl, String auctionName) throws AWTException {

		goto_Catalog_Page_Live_Sale(auctionName); // Goto Catalog Page

		common.pause(20);
		driver.findElement(By.xpath("//a[@class='yaaa']")).click();
		common.pause(25);

		String str_est = driver.findElement(By.xpath("//span[@class='estimate']")).getText();
		System.out.println("Step :: New Estimate Label is >>" + str_est);

	}

	/**
	 * Catalog Excluded Closed Lots
	 * 
	 * @throws AWTException
	 * 
	 */

	public void Verify_Exclude_Closed_lots(String exclosedlbl) throws AWTException {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		// Select Live Only

		System.out.println("Step :: Select Live Only");
		common.log("<br></br> Step :: Select Live Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Live only']")).click();
		common.pause(30);

		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
		// a[@class='search_toggle_btn']
		System.out.println("Step :: Click on Advance Search");
		common.log("<br></br> Step :: Click on Advance Search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(20);

		String str = driver.findElement(By.xpath("//label[text()='" + exclosedlbl + "']")).getText();
		System.out.println("New Lable Exclused Closed :: " + exclosedlbl);
		common.log("New Lable Exclused Closed :: " + exclosedlbl);
		common.pause(5);
	}

	/**
	 * Catalog All
	 * 
	 */

	public void Verify_All(String Alllbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(30);
		System.out.println("Step :: Select Live Only");
		common.log("<br></br> Step :: Select Live Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Live only']")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);

		common.pause(30);
		String str_All = driver.findElement(By.xpath("//select[@id='c3']//option[@value='0']")).getText();

		System.out.println("All Label is display :: " + str_All);

	}

	/**
	 * Catalog Category
	 * 
	 */

	public void Verify_Category1(String cat_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);

		// String str_Cat = driver.findElement(By.xpath("//div[@class='label
		// catalog-filter-category']")).getText();
		//
		// System.out.println("Category Label is display :: " + str_Cat);

	}

	/**
	 * Catalog please Finalize Your purchase
	 * 
	 */

	public void Verify_Finalize_Your_Purchase(String finalize_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);

	}

	/**
	 * Catalog Paying The Invoice
	 * 
	 */

	public void Verify_Paying_The_Invoice(String paying_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);

	}

	/**
	 * Catalog Finalize Yuor Purchse By
	 * 
	 * @param lotName
	 * @param bidbuynowlbl
	 * @throws AWTException
	 * 
	 */

	public void Verify_Finalize_Your_Purchase_By(String paying_lbl, String lotName, String auctionName)
			throws AWTException {

		goto_Catalog_Page_Live_Sale(auctionName);
		common.pause(20);
		System.out.println("Step :: Fill buy now value");
		common.type("//a[text()='" + lotName + "']//..//..//..//div[@class='regular-bid']//input[@type='text']", "100");

		common.log("<br></br> Step :: Click on buy now button");
		System.out.println("Step :: Click on buy now button");
		driver.findElement(By.xpath("//div[@class='buy-now']")).click();

		common.log("<br></br> Step :: Click on Confirm button");
		System.out.println("Step :: Click on Confirm button");
		driver.findElement(By.xpath("//input[@id='pblc2']")).click();
		common.pause(25);

		String str_finalize = driver.findElement(By.xpath("//div[@style='text-align: center;']")).getText();

		// common.assertTwoValuesAreEqual(paying_lbl, str_finalize);

		System.out.println("Step :: Please Finalize your New text is >> " + str_finalize);

	}

	/**
	 * Catalog Force Bid
	 * 
	 */

	public void Verify_Force_Bid(String Forcebid_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);

	}

	/**
	 * Catalog Invalid Force Bid
	 * 
	 */

	public void Verify_Invalid_Force_Bid(String InForcebid_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);

	}

	/**
	 * Catalog Force Bid Of %
	 * 
	 */

	public void Verify_Force_Bid_Of_Percentage(String Forcebid_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
	}

	/**
	 * Catalog Force Bid To Big For Asking Bid
	 * 
	 */

	public void Verify_Force_Bid_To_Big_For_Asking_Bid(String Forcebid_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);

	}

	/**
	 * Lot Closed
	 * 
	 */

	public void Verify_Lot_Closed(String LotClosed_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
	}

	/**
	 * Verify Image Left/Right
	 * 
	 */

	public void Verify_Image_Left_Right(String imageleftright) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Sell Lot to bidder
	 * 
	 */

	public void Verify_Sell_Lot_To_Bidder(String selllot) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
	}

	/**
	 * Verify Lot %s is already started in the live sale.
	 * 
	 * @throws AWTException
	 * 
	 */

	public void Verify_Lot_Started_Bidder(String lotstarted, String auctionName) throws AWTException {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		goto_Catalog_Page_Live_Sale(auctionName); // Goto Catalog Page
		common.pause(15);

		System.out.println("Step :: Fill value in placebid textbox");
		common.log("<br></br> Step :: Fill value in placebid textbox");
		driver.findElement(By.xpath("//*[@class='" + LEGACY_USER_TXT_REGULAR_LIVE_BID + "']")).sendKeys("200");
		common.pause(5);

		System.out.println("Step :: Click on Placebid button");
		common.log("<br></br> Step :: Click on Placebid button");
		driver.findElement(By.xpath("//*[@value='" + LEGACY_USER_BTN_PLACE_BID + "']")).click();
		common.pause(15);
		System.out.println("Step :: Click on Follow Button");
		common.log("<br></br> Step :: Click on Follow Button");
		driver.findElement(By.xpath("//input[@id='pbloi2']")).click();
		common.pause(30);

		String getmsg = driver.findElement(By.xpath("//div[@class='messages']")).getText();

		System.out.println("Step :: Verify New Updated Message >>" + getmsg);

	}

	/**
	 * Verify Added to watchlist message
	 * 
	 */

	public void Verify_Added_to_Watchlist_Message() {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));
		common.pause(20);

		System.out.println("Step :: Click Checkbox");
		common.log("<br></br> Step :: Click Checkbox");
		driver.findElement(By.xpath("//li[@id='lot1']//div[@class='bd-chk']")).click();
		common.pause(20);

		common.acceptAlert1();

	}

	/**
	 * Low to High
	 * 
	 */

	public void Verify_Low_To_High(String lowtohigh) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
	}

	/**
	 * Verify Max Bid
	 */

	public void Verify_Max_Bid(String maxbid) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
	}

	/**
	 * Verify Bidding on multiple lots.
	 */

	public void Verify_Bidding_On_Multiple_Lots(String bidding) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
	}

	/**
	 * Verify My MaxBid.
	 */

	public void Verify_My_Max_Bid(String mymaxbid) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify My MinBid.
	 */

	public void Verify_My_Min_Bid(String myminbid) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(10);

		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
	}

	/**
	 * Verify Bid.
	 */

	public void Verify_Bid(String bid) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(30);

		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
	}

	/**
	 * Verify Next Label.
	 * 
	 * @throws AWTException
	 */

	public void Verify_Next(String next) throws AWTException {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		// Select Live Only

		System.out.println("Step :: Select Live Only");
		common.log("<br></br> Step :: Select Live Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Live only']")).click();
		common.pause(30);

		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
		// driver.findElement(By.xpath("//a[@class='yaaa']")).click();
		// common.pause(25);

		String next1 = driver.findElement(By.xpath("//span[text()='Next']")).getText();

		System.out.println("Step :: New Next Label is >>" + next1);

	}

	/**
	 * Verify No Valid Bids Yet
	 */

	public void Verify_No_Valid_Bids_Yet(String novalidbid) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
	}

	/**
	 * Verify Change Offer
	 */

	public void Verify_Change_Offer(String changeoffer) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
	}

	/**
	 * Verify Your Offer Has been Declined
	 */

	public void Verify_Your_Offer_Has_Been_Declined(String offerdecline) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
	}

	/**
	 * Verify Make Offer
	 */

	public void Verify_Make_Offer(String makeoffer) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
	}

	/**
	 * Verify You Don't Have Bidder Privileges
	 */

	public void Verify_You_Dont_Have_Bidder_Privileges(String Bidderpri) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
	}

	/**
	 * Verify Your Offer Has been Submited Email Response
	 */

	public void Verify_Offer_Has_Been_Submited_Email(String OfferSubmit) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
	}

	/**
	 * Verify Your Offer Has been Submited
	 */

	public void Verify_Offer_Has_Been_Submited(String OfferESubmit) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
	}

	/**
	 * Your Offer
	 */

	public void Verify_Offer(String offer) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
	}

	/**
	 * Opening Bid
	 */

	public void Verify_Opening_Bid(String offer) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
	}

	/**
	 * Catalog 'In this column you can assign an 'OR Bid Number
	 * 
	 */

	public void Verify_In_This_Column(String InthsiColumn_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);

	}

	/**
	 * Catalog Other Lots In Sale
	 * 
	 * @throws AWTException
	 * 
	 */

	public void Verify_Other_Lots_in_Sale(String OtherlOts_lbl) throws AWTException {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		// Select Live Only

		System.out.println("Step :: Select Live Only");
		common.log("<br></br> Step :: Select Live Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Live only']")).click();
		common.pause(30);

		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
		driver.findElement(By.xpath("//a[@class='yaaa']")).click();
		common.pause(25);

		String otherlots = driver.findElement(By.xpath("//h3[@class='title dk_title']")).getText();

		System.out.println("Step :: New otherlots Label is >>" + otherlots);

	}

	/**
	 * Catalog Lots
	 * 
	 */

	public void Verify_Lots(String Lots_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
	}

	/**
	 * PayPer Bid
	 * 
	 */

	public void Verify_Pay_Per_Bid(String payperbid) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Bids Now
	 * 
	 */

	public void Verify_Bids_Now(String bidsnow) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);

	}

	/**
	 * Pay Per Bids Now
	 * 
	 */

	public void Verify_Pay_Per_Bids_Now(String payperbid) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);

	}

	/**
	 * Verify Spent
	 * 
	 */

	public void Verify_Spent(String spent) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);

	}

	/**
	 * Auction
	 * 
	 */

	public void Verify_Auction(String Auction) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Auction
	 * 
	 */

	public void Verify_PDF_Catalog(String pdfcatalog) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
	}

	/**
	 * Lot
	 * 
	 */

	public void Verify_Lot_Catalog(String Lot) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
	}

	/**
	 * Verify PDF Prices
	 * 
	 */

	public void Verify_PDF_Prices(String PDFprices) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
	}

	/**
	 * Piecemeal Lot
	 * 
	 */

	public void Verify_Piecemeal_Lot(String PDFprices) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Place MultiBid Button
	 * 
	 * @throws AWTException
	 * 
	 */

	public void Verify_Place_Multiple_Bid_Button_Lot(String placembid, String auctionName) throws AWTException {

		goto_Catalog_Page_Live_Sale(auctionName); // Goto Catalog Page
		common.pause(30);

		String str_placeMbid = driver.findElement(By.xpath("//input[@value='" + placembid + "']")).getText();

		System.out.println("Step :: Placemultibid New Label is >>" + str_placeMbid);

	}

	/**
	 * Previous Link
	 * 
	 * @throws AWTException
	 * 
	 */

	public void Verify_Previous_Link_Label(String previous, String auctionName) throws AWTException {

		goto_Catalog_Page_Live_Sale(auctionName); // Goto catalog page
		common.pause(40);

		// System.out.println("Step :: Click on View Details button");
		// common.log("<br></br> Step :: Click on View Details button");
		// driver.findElement(By.xpath("//h2")).click();
		// common.pause(20);

		System.out.println("Step :: Click on Next Button");
		common.log("<br></br> Step :: Click on Next Button");
		driver.findElement(By.xpath("//div[@class='right pagintn']//span[@id='c2_ctl']//a[contains(text(),'Next')]"))
				.click();
		common.pause(10);
		String str_previouslink = driver.findElement(By.xpath("//span[text()='Previous']")).getText();

		System.out.println("Step :: Previous New Label is >>" + str_previouslink);

	}

	/**
	 * Price
	 * 
	 */

	public void Verify_Price(String price) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Price
	 * 
	 */

	public void Verify_Quantity(String price) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify By bidding on this lot you commit to your bid x
	 * 
	 */

	public void Verify_By_Bidding_On_This_Lot(String biddingonthislot) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * We have received your payment
	 * 
	 */

	public void Verify_We_Have_Received_Your_Payment(String biddingonthislot) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
	}

	/**
	 * Remove From WatchList
	 */

	public void Verify_Remove_From_Watch_List(String Remove) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
	}

	/**
	 * Reserve met
	 */

	public void Verify_Reserve_Met(String Reservemet) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
	}

	/**
	 * Reserve Not met
	 */

	public void Verify_Reserve_Not_Met(String Reservemet) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
	}

	/**
	 * Reset search
	 * 
	 */

	public void Verify_Reset_Search(String Resetsearch) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
	}

	/**
	 * Verify Artist Statement
	 * 
	 */

	public void Verify_Artist_Statement(String artiststatment) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
	}

	/**
	 * Verify Translation_Month_Day_Year_Hour_Minute_ampm_TZ
	 * 
	 */

	public void Verify_Month_ampm_TZ(String artiststatment) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
	}

	/**
	 * Verify {hours}h {minutes}m {seconds}s
	 * 
	 */

	public void Verify_Hour_Minute_Second1(String HMS) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
	}

	/**
	 * Verify {minutes}m {seconds}s
	 * 
	 */

	public void Verify_Minute_Second1(String str_MS) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
	}

	/**
	 * Verify {seconds}s
	 * 
	 */

	public void Verify_Second1(String str_S) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Verify Please Select at list one item
	 * 
	 * @param auctionName
	 * @throws AWTException
	 * 
	 */

	public void Verify_Select_at_List_One_Item(String str_selectone, String auctionName) throws AWTException {

		goto_Catalog_Page_Live_Sale(auctionName);
		common.pause(30);

		System.out.println("Step :: Click on Add to button");
		common.log("<br></br> Step :: Click on Add to button");
		driver.findElement(By.xpath("//input[@value='Add to']")).click();

		Alert alert = driver.switchTo().alert();
		String abc = alert.getText();
		System.out.println("Step :: Alert text is >>" + abc);
		common.pause(5);

	}

	/**
	 * Lot2
	 * 
	 */

	public void Verify_Lot2(String str_lot2) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(30);
	}

	/**
	 * Catalog Sold
	 * 
	 * @throws AWTException
	 * 
	 */

	public void Verify_Sold(String Sold_lbl) throws AWTException {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		// Select Live Only

		System.out.println("Step :: Select Live Only");
		common.log("<br></br> Step :: Select Live Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Live only']")).click();
		common.pause(30);

		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(30);

		String solt_str = driver.findElement(By.xpath("//li[@id='lot1']//..//li[@id='item-status']")).getText();

		common.pause(5);
		System.out.println("Sold Label Is :: " + solt_str);

	}

	/**
	 * Catalog Sold With Reservation
	 * 
	 */

	public void Verify_Sold_With_Reservation(String Sold_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(30);

	}

	/**
	 * Catalog Sold Through Buy Now
	 * 
	 */

	public void Verify_Sold_Through_BuyNow(String Sold_buyNow_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(30);

	}

	/**
	 * Catalog Sort label
	 * 
	 * @throws AWTException
	 * 
	 */

	public void Verify_Sort_Label(String sort_lbl) throws AWTException {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		// Select Live Only

		System.out.println("Step :: Select Live Only");
		common.log("<br></br> Step :: Select Live Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Live only']")).click();
		common.pause(30);

		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(30);

		// String sort_str =
		// driver.findElement(By.xpath("//span[@id='lac27']")).getText();
		//
		// common.pause(5);
		// System.out.println("Sort Label Is :: " + sort_str);

		// common.assertTwoValuesAreEqual(sort_lbl, sort_str);
	}

	/**
	 * Catalog Bids label
	 * 
	 */

	public void Verify_Bids_Label(String bids_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(30);

		// String bids_str =
		// driver.findElement(By.xpath("//select[@id='lac28']//option[text()='" +
		// bids_lbl + "']"))
		// .getText();
		//
		// common.pause(5);
		// System.out.println("Bids Label Is :: " + bids_str);

		// common.assertTwoValuesAreEqual(bids_lbl, bids_str);
	}

	/**
	 * Catalog Category label
	 * 
	 */

	public void Verify_Category_Label(String cat_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(30);

	}

	/**
	 * Catalog Estimate label
	 * 
	 */

	public void Verify_Estimate_Label(String est_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(30);

		// String est_str =
		// driver.findElement(By.xpath("//select[@id='lac28']//option[text()='"
		// + est_lbl + "']"))
		// .getText();
		//
		// common.pause(5);
		// System.out.println("Estimate Label Is :: " + est_str);
		//
		// common.assertTwoValuesAreEqual(est_str, est_lbl);
	}

	/**
	 * Catalog Item label
	 * 
	 */

	public void Verify_Item_Label(String item_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(30);

	}

	/**
	 * Catalog Lot# label
	 * 
	 */

	public void Verify_Lot_Label(String lot_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(30);

		// String lot_str =
		// driver.findElement(By.xpath("//select[@id='lac28']//option[text()='" +
		// lot_lbl + "']"))
		// .getText();
		//
		// common.pause(5);
		// System.out.println("Lot# Label Is :: " + lot_str);
		//
		// common.assertTwoValuesAreEqual(lot_str, lot_lbl);
	}

	/**
	 * Catalog Name label
	 * 
	 */

	public void Verify_Name1_Label(String name_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);

	}

	/**
	 * Verify Image
	 * 
	 * @param auctionName
	 * 
	 */

	public void Verify_Image(String image) {
		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));
		common.pause(15);
		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);

	}

	/**
	 * Item Title
	 * 
	 */

	public void Verify_Item_Title(String itemtitle) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);

	}

	/**
	 * Lot #
	 * 
	 */

	public void Verify_Lot_hash(String lothash) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);

	}

	/**
	 * My Max
	 * 
	 */

	public void Verify_My_Max(String mymax) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		common.log("<br><\br>Step :: click on My item");
		System.out.println("Step :: click on My item ");
		driver.findElement(By.xpath("//a[text()='My Items']")).click();

		common.pause(20);

	}

	/**
	 * My Min
	 * 
	 */

	public void Verify_My_Min(String mymin) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * OR #
	 * 
	 */

	public void Verify_OR(String or) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);

		System.out.println("Step :: New OR Label is >>" + or);

	}

	/**
	 * Verify Price
	 * 
	 */

	public void Verify_Price1(String price) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
		//
		//
		// String str_price = driver.findElement(By.xpath("//th[@class='hdr-lac5
		// lac5-col5 th-cat-price']")).getText();
		//
		// System.out.println("Step :: New lot Label is >>" + str_price);

	}

	/**
	 * Verify Asking Bid
	 * 
	 * @throws AWTException
	 * 
	 */

	public void Verify_Asking_Bid(String askingbid) throws AWTException {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		// Select Live Only

		System.out.println("Step :: Select Live Only");
		common.log("<br></br> Step :: Select Live Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Live only']")).click();
		common.pause(30);

		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);

		// String str_price = driver.findElement(By.xpath("//span[text()='" + askingbid
		// + "']")).getText();
		//
		// System.out.println("Step :: New Asking Bid Label is >>" + str_price);
	}

	/**
	 * Verify BuyNow
	 * 
	 * @param auctionName
	 * @throws AWTException
	 * 
	 */

	public void Verify_BuyNow1(String buynow, String auctionName) throws AWTException {

		goto_Catalog_Page_Live_Sale(auctionName);
		common.pause(20);

	}

	/**
	 * Verify Asking Bid
	 * 
	 */

	public void Verify_Current_Bid(String currentbid) {
		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);

	}

	/**
	 * Verify Pay Per Bid
	 * 
	 */

	public void Verify_Pay_Per_Bid1(String paybid) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
	}

	/**
	 * Verify Starting Bid
	 * 
	 * @param auctionName
	 * @throws AWTException
	 * 
	 */

	public void Verify_Starting_Bid(String startingbid, String auctionName) throws AWTException {

		goto_Catalog_Page_Live_Sale(auctionName);
		common.pause(20);
		String startbid_win = driver.findElement(By.xpath("//span[text()='Starting']")).getText();
		String comma = ":";

		System.out.println("Step :: New Starting Bid Label is >>  " + startbid_win);

	}

	/**
	 * Verify Winning Bid
	 * 
	 */

	public void Verify_Winning_Bid(String winningbid) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);

		// String str_win =
		// driver.findElement(By.xpath("//span[@class='label']")).getText();
		// String comma = ":";
		//
		// System.out.println("Step :: New Winning Bid Label is >> " + str_win);

	}

	/**
	 * Verify Quantity
	 * 
	 */

	public void Verify_Quantity1(String paybid) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);

	}

	/**
	 * Verify Time Left
	 * 
	 * @throws AWTException
	 * 
	 */

	public void Verify_Time_Left(String timeleft) throws AWTException {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		// Select Live Only

		System.out.println("Step :: Select Timed Only");
		common.log("<br></br> Step :: Select Timed Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Timed only']")).click();
		common.pause(30);

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);

		String str_timeleft = driver.findElement(By.xpath("//p[@class='timelft time-left']")).getText();

		System.out.println("Step :: New Time Left Label is >> " + str_timeleft);
		//
		// common.assertTwoValuesAreEqual(timeleft, str_timeleft);

	}

	/**
	 * Verify Quantity
	 * 
	 */

	public void Verify_Warranty(String warranty) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);
	}

	/**
	 * Verify ?
	 * 
	 * @throws AWTException
	 * 
	 */

	public void Verify_Question_Mark(String ques) throws AWTException {
		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(30);
		// Select Live Only

		System.out.println("Step :: Select Live Only");
		common.log("<br></br> Step :: Select Live Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Live only']")).click();
		common.pause(30);

		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);

		// String str_que = driver.findElement(By.xpath("//th[@class='hdr-lac5 lac5-col7
		// th-cat-watch']")).getText();
		//
		// common.assertTwoValuesAreEqual(ques, str_que);
		// System.out.println("Step :: New ? Label is >> " + str_que);
	}

	/**
	 * Verify Your Bids
	 */

	public void Verify_Your_Bids(String Yourbid) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);

	}

	/**
	 * Verify Tell a Friend
	 */

	public void Verify_Tell_Friend(String tellfriend) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(20);

	}

	/**
	 * Terms and Condition
	 * 
	 * @param tellfriend
	 * @param auctionName
	 * @throws AWTException
	 */

	public void Verify_Terms_And_Condition(String termsandcon, String auctionName) throws AWTException {

		goto_Catalog_Page_Live_Sale(auctionName);
		common.pause(20);

		System.out.println("Step :: Click on View Details button");
		common.log("<br></br> Step :: Click on View Details button");
		driver.findElement(By.xpath("//a[@class='yaaa']")).click();
		common.pause(20);
		String str_terms = driver.findElement(By.xpath("//a[contains(text(),'Terms and conditions')]")).getText();

		System.out.println("Step :: New Terms and condition Label is >> " + str_terms);

	}

	/**
	 * Catalog Starting/Current Bid label
	 * 
	 * @throws AWTException
	 * 
	 */

	public void Verify_Starting_Current_Bid_Label(String sta_Curbid_lbl) throws AWTException {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		// Select Live Only

		System.out.println("Step :: Select Live Only");
		common.log("<br></br> Step :: Select Live Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Live only']")).click();
		common.pause(30);

		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(30);

		String stadrtcurnbid_str = driver.findElement(By.xpath("//li[@class='item-starting-bid']")).getText();

		common.pause(5);
		System.out.println("Starting/Current Bid Label Is :: " + stadrtcurnbid_str);

		// common.assertTwoValuesAreEqual(sta_Curbid_lbl, stadrtcurnbid_str);
	}

	/**
	 * Catalog Time Left label
	 * 
	 */

	public void Verify_Time_Left_Label(String timeLeft_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(30);
	}

	/**
	 * Catalog Lot
	 * 
	 */

	public void Verify_Lot(String Lots_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath(
				"//table//tr[@id='alf4row0']//..//td[@class='row0-alf4 alf4-col6 td-auct-status']//..//span[text()='In progress']//..//..//..//td[@class='row0-alf4 alf4-col8 td-auct-actions last']//..//input[@value='View catalog']"))
				.click();
		common.pause(10);
	}

	/**
	 * Catalog Views label
	 * 
	 * @throws AWTException
	 * 
	 */

	public void Verify_Views_Label(String views_lbl) throws AWTException {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		// Select Live Only

		System.out.println("Step :: Select Live Only");
		common.log("<br></br> Step :: Select Live Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Live only']")).click();
		common.pause(30);

		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(30);

		String views_str = driver.findElement(By.xpath("//span[text()='View']")).getText();

		common.pause(5);
		System.out.println("View Label Is :: " + views_str);
		common.log("View Label Is :: " + views_str);

		// common.assertTwoValuesAreEqual(views_str, views_lbl);
	}

	/**
	 * Catalog Special Terms label
	 * 
	 */

	public void Verify_Special_Terms_Label(String special_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(30);

	}

	/**
	 * Catalog Starting label
	 * 
	 * @throws AWTException
	 * 
	 */

	public void Verify_Starting_Label(String starting_lbl) throws AWTException {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		// Select Live Only

		System.out.println("Step :: Select Live Only");
		common.log("<br></br> Step :: Select Live Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Live only']")).click();
		common.pause(30);

		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(30);
		// span[text()='Starting']
		String views_str = driver.findElement(By.xpath("//span[text()='Starting']")).getText();

		common.pause(5);
		System.out.println("Starting/Current Bid Label Is :: " + views_str);

	}

	/**
	 * Catalog Status label
	 * 
	 * @throws AWTException
	 * 
	 */

	public void Verify_Status_Label(String status_lbl) throws AWTException {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		// Select Live Only

		System.out.println("Step :: Select Live Only");
		common.log("<br></br> Step :: Select Live Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Live only']")).click();
		common.pause(30);

		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(30);

	}

	/**
	 * Catalog Stop Absentee Bidding At label
	 * 
	 */

	public void Verify_Stop_Absentee_Bidding_At_Label(String stoabs_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(30);

		// String stopAbs_str = driver.findElement(By.xpath("//div[@class='label
		// catalog-stop-at']")).getText();
		//
		// System.out.println("Stop Absentee Bidding At Label is :: " + stopAbs_str);
	}

	/**
	 * Catalog Submit label
	 * 
	 * @throws AWTException
	 * 
	 */

	public void Verify_Submit_Label(String submit_lbl) throws AWTException {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		// Select Live Only

		System.out.println("Step :: Select Live Only");
		common.log("<br></br> Step :: Select Live Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Live only']")).click();
		common.pause(30);

		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(30);

		// String submits_str = driver.findElement(By.xpath("//input[@value='" +
		// submit_lbl + "']")).getAttribute("value");
		//
		// System.out.println("Submit Label is :: " + submits_str);
		//
		// common.assertTwoValuesAreEqual(submit_lbl, submits_str);
	}

	/**
	 * Catalog Buy Now! label
	 * 
	 * @param auctionName d
	 * @throws AWTException
	 */

	public void Verify_BuyNow_Label(String buynow_lbl, String auctionName) throws AWTException {

		goto_Catalog_Page_Live_Sale(auctionName);

		common.pause(20);

		String BuyNow_str = driver.findElement(By.xpath("//input[@value='" + buynow_lbl + "']")).getAttribute("value");

		System.out.println("BuyNow Label is :: " + BuyNow_str);

	}

	/**
	 * Catalog Estimate label
	 * 
	 */

	public void Verify_Estimate_Label1(String est_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(30);

	}

	/**
	 * Winning Bid
	 * 
	 */

	public void Verify_Winning_Bid1(String winbid) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(30);
	}

	/**
	 * You Won
	 * 
	 * @param auctionName
	 * @throws AWTException
	 * 
	 */

	public void Verify_You_Won(String winbid, String auctionName) throws AWTException {

		goto_Catalog_Page_Live_Sale(auctionName);

		System.out.println("Step :: Click on View Details button");
		common.log("<br></br> Step :: Click on View Details button");
		driver.findElement(By.xpath("//a[@class='yaaa']")).click();
		common.pause(20);

		String winmsg = driver.findElement(By.xpath("//div[@class='winner-msg']")).getText();

		common.assertTwoValuesAreEqual(winbid, winmsg);
		System.out.println("Step :: You won New label is >> " + winmsg);

	}

	/**
	 * You won this item with reservation!
	 * 
	 */

	public void Verify_You_Won_Reservation(String wonresver) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(30);
	}

	/**
	 * Catalog Time Left label
	 * 
	 */

	public void Verify_Time_Left_Label1(String timeLeft_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(30);

	}

	/**
	 * Catalog Ended label
	 * 
	 */

	public void Verify_Ended_Label(String ended_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(30);

	}

	/**
	 * Catalog UnAwarded label
	 * 
	 */

	public void Verify_UnAwarded_Label(String awared_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(30);

	}

	/**
	 * Catalog UpComing label
	 * 
	 */

	public void Verify_UpComing_Label(String upcoming_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(30);

	}

	/**
	 * Catalog View Details label
	 * 
	 * @throws AWTException
	 * 
	 */

	public void Verify_ViewDetails_Label(String viewdetails_lbl) throws AWTException {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		// Select Live Only

		System.out.println("Step :: Select Live Only");
		common.log("<br></br> Step :: Select Live Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Live only']")).click();
		common.pause(30);

		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(30);

		String ViewDet_str = driver.findElement(By.xpath("//a[@class='yaaa']")).getText();

		System.out.println("View Details Label is :: " + ViewDet_str);

	}

	/**
	 * Catalog View Full Catalog For label
	 * 
	 * @throws AWTException
	 * 
	 */

	public void Verify_View_Full_Catalog_For_Label(String viewdetails_lbl) throws AWTException {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(30);
		// Select Live Only

		System.out.println("Step :: Select Live Only");
		common.log("<br></br> Step :: Select Live Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Live only']")).click();
		common.pause(30);

		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(40);

		System.out.println("Step :: Click on View Details");
		common.log("<br></br> Step :: Click on View Details");
		driver.findElement(By.xpath("//a[@class='yaaa']")).click();
		common.pause(30);

		String ViewFullCat_str = driver.findElement(By.xpath("//a[contains(text(),'Description')]")).getText();

		System.out.println("View Full Catalog For Label is :: " + ViewFullCat_str);

	}

	/**
	 * Catalog View My WatchList label
	 * 
	 */

	public void Verify_View_My_WatchList_Label(String viewwatch_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(30);

		String ViewMywatch_str = driver.findElement(By.xpath("//a[@class='catalog-mywatchlist-top']")).getText();

		System.out.println("View My Watchlist Label is :: " + ViewMywatch_str);

	}

	/**
	 * Catalog Warranty label
	 * 
	 */

	public void Verify_Warranty_Label(String Warrnty_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(30);
	}

	/**
	 * Catalog In this column you can select multiple items to add to your watch
	 * list using the button 'Add to Watchlist' at the bottom of the page. label
	 * 
	 */

	public void Verify_Add_To_Watchlist_Label(String Watchlist_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(30);

		System.out.println("Step :: Click on View Catalog button");
		common.log("<br></br> Step :: Click on View Catalog button");
		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[@class='cat']")).click();
		common.pause(30);

	}

	/**
	 * Verify Timed Auction not persent.
	 * 
	 * @param auctionName
	 * @throws AWTException
	 */

	public void verify_Timed_Auction_Not_Dispaly(String auctionName) throws AWTException

	{

		// Select All

		common.pause(30);
		System.out.println("Step :: Select All");
		common.log("<br></br> Step :: Select All");

		driver.findElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']")).click();
		common.pause(10);

		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='All']")).click();

		common.pause(30);
		// Select Timed Only

		System.out.println("Step :: Select Timed Only");
		common.log("<br></br> Step :: Select Timed Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Timed only']")).click();
		common.pause(30);
		// Select Auctioneer Sagar

		System.out.println("Step :: Select Sagar Auctioneer");
		common.log("<br></br> Step :: Select Sagar Auctioneer");
		driver.findElement(By.xpath("//span[@id='alf9_ctl']//..//a[@role='button']")).click();

		// Mouse Event
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Sagar']")).click();

		common.pause(30);

		System.out.println("Step :: Select 100 from dropdown");
		common.log("<br></br> Step :: Select 100 from dropdown");
		driver.findElement(By.xpath("//select[@id='" + LEGACY_ADMIN_LOT_TABLE + "']//option[@value='3']")).click();

		common.pause(20);

		for (int i = 0; i < 20; i++) {
			if (!common.isElementPresent("//ul[@class='auclting yura']//a[text()=' " + auctionName + "']")) {

				System.out.println("auction " + auctionName + " is not present in this page");

				common.pause(10);
				break;

			} else {
				System.out.println("auction " + auctionName + " is not present in this page");

				common.pause(15);

			}
		}
	}

	public void verify_Timed_Auction_Not_Dispaly_Frontend(String auctionName) throws AWTException

	{

		// Select All

		common.pause(30);
		System.out.println("Step :: Select All");
		common.log("<br></br> Step :: Select All");
		common.waitForElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']"));

		driver.findElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']")).click();
		common.pause(10);

		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='All']")).click();

		common.pause(30);
		// Select Timed Only

		System.out.println("Step :: Select Timed Only");
		common.log("<br></br> Step :: Select Timed Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Timed only']")).click();
		common.pause(30);
		// Select Auctioneer Sagar

		System.out.println("Step :: Select Sagar Auctioneer");
		common.log("<br></br> Step :: Select Sagar Auctioneer");
		driver.findElement(By.xpath("//span[@id='alf9_ctl']//..//a[@role='button']")).click();

		// Mouse Event
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Sagar']")).click();

		common.pause(30);

		System.out.println("Step :: Select 100 from dropdown");
		common.log("<br></br> Step :: Select 100 from dropdown");
		driver.findElement(By.xpath("//select[@id='" + LEGACY_ADMIN_LOT_TABLE + "']//option[@value='3']")).click();

		common.pause(20);

		for (int i = 0; i < 20; i++) {
			if (!common.isElementPresent("//ul[@class='auclting yura']//a[text()=' " + auctionName + "']")) {

				System.out.println("auction " + auctionName + " is not present in this page");

				common.pause(10);
				break;

			} else {
				System.out.println("auction " + auctionName + " is not present in this page");

				common.pause(20);

			}
		}
	}

	/**
	 * Verify Timed Auction Present.
	 * 
	 * @param auctionName
	 * @throws AWTException
	 */
	public void verify_Timed_Auction_Present(String auctionName) throws AWTException {

		// Select All

		common.pause(30);
		System.out.println("Step :: Select All");
		common.log("<br></br> Step :: Select All");
		common.waitForElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']"));

		driver.findElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']")).click();
		common.pause(10);

		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='All']")).click();

		common.pause(30);
		// Select Timed Only

		System.out.println("Step :: Select Timed Only");
		common.log("<br></br> Step :: Select Timed Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Timed only']")).click();
		common.pause(30);
		// Select Auctioneer Sagar

		System.out.println("Step :: Select Sagar Auctioneer");
		common.log("<br></br> Step :: Select Sagar Auctioneer");
		driver.findElement(By.xpath("//span[@id='alf9_ctl']//..//a[@role='button']")).click();

		// Mouse Event
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Sagar']")).click();

		common.pause(30);

		System.out.println("Step :: Select 100 from dropdown");
		common.log("<br></br> Step :: Select 100 from dropdown");
		driver.findElement(By.xpath("//select[@id='" + LEGACY_ADMIN_LOT_TABLE + "']//option[@value='3']")).click();

		common.pause(20);

		for (int i = 0; i < 20; i++) {
			if (common.isElementPresent("//ul[@class='auclting yura']//a[text()=' " + auctionName + "']")) {

				System.out.println("auction " + auctionName + " is present in this page");

				common.pause(10);
				break;

			} else {
				System.out.println("auction " + auctionName + " is not present in this page");
				driver.findElement(By.xpath("//span[@id='" + LEGACY_USER_LST_NEXT_PAGE + "']//a[text()='Next']"))
						.click();
				common.pause(15);

			}
		}
	}

	public void verify_Timed_Auction_Present_At_Frontend(String auctionName) throws AWTException {

		// Select All

		common.pause(30);
		System.out.println("Step :: Select All");
		common.log("<br></br> Step :: Select All");

		driver.findElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']")).click();
		common.pause(10);

		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='All']")).click();

		common.pause(30);
		// Select Timed Only

		System.out.println("Step :: Select Timed Only");
		common.log("<br></br> Step :: Select Timed Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Timed only']")).click();
		common.pause(30);
		// Select Auctioneer Sagar

		System.out.println("Step :: Select Sagar Auctioneer");
		common.log("<br></br> Step :: Select Sagar Auctioneer");
		driver.findElement(By.xpath("//span[@id='alf9_ctl']//..//a[@role='button']")).click();

		// Mouse Event
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Sagar']")).click();

		common.pause(30);

		System.out.println("Step :: Select 100 from dropdown");
		common.log("<br></br> Step :: Select 100 from dropdown");
		driver.findElement(By.xpath("//select[@id='" + LEGACY_ADMIN_LOT_TABLE + "']//option[@value='3']")).click();

		common.pause(20);

		for (int i = 0; i < 20; i++) {
			if (common.isElementPresent("//ul[@class='auclting yura']//a[text()=' " + auctionName + "']")) {

				System.out.println("auction " + auctionName + " is present in this page");

				common.pause(10);
				break;

			} else {
				System.out.println("auction " + auctionName + " is not present in this page");
				driver.findElement(By.xpath("//div[@class='pagintn right']//a[contains(text(),'Next')]")).click();
				common.pause(15);

			}
		}
		System.out.println("Verified auction " + auctionName + " is present in this page");
		common.log("<br></br> Step :: Verified auction " + auctionName + " is present in this page");

	}

	/**
	 * Verify Lot Description
	 * 
	 * @param timedauction
	 * @throws AWTException
	 * @throws InterruptedException
	 */

	public void Verify_Lot_Description(String timedauction) throws AWTException, InterruptedException

	{

		goto_Catalog_Page_Timed_Sale(timedauction);
		common.pause(25);
		System.out.println("Step :: Click on view details");
		common.log("<br></br> Step :: Click on view details");
		common.jsClick("//a[@class='yaaa']");
		common.pause(30);

		String desc = driver.findElement(By.xpath("//div[@class='content ins_cnt description-info-content']"))
				.getText();
		common.log("Step :: Verify Lot Description >> " + desc);
		System.out.println("Step :: Verify lot description >> " + desc);
		common.pause(10);
	}

	/**
	 * Verify Timesale auction status Past
	 * 
	 * @param auctionname
	 * @throws AWTException
	 */
	public void verify_End_Date_Timedsale_Auction_Status_Past(String auctionname) throws AWTException

	{

		// Select All

		common.pause(30);
		System.out.println("Step :: Select All");
		common.log("<br></br> Step :: Select All");
		common.waitForElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']"));

		driver.findElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']")).click();
		common.pause(10);

		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='All']")).click();

		common.pause(30);
		// Select Timed Only

		System.out.println("Step :: Select Timed Only");
		common.log("<br></br> Step :: Select Timed Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Timed only']")).click();
		common.pause(30);
		// Select Auctioneer Sagar

		System.out.println("Step :: Select Sagar Auctioneer");
		common.log("<br></br> Step :: Select Sagar Auctioneer");
		driver.findElement(By.xpath("//span[@id='alf9_ctl']//..//a[@role='button']")).click();

		// Mouse Event
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Sagar']")).click();

		common.pause(30);

		System.out.println("Step :: Select 100 from dropdown");
		common.log("<br></br> Step :: Select 100 from dropdown");
		driver.findElement(By.xpath("//select[@id='" + LEGACY_ADMIN_LOT_TABLE + "']//option[@value='3']")).click();

		common.pause(20);

		common.log("<br></br> Step :: To verify Sale status closed display when show type all selected");
		System.out.println("Step :: To verify Sale status closed display when show type all selected");

		int rowCount = driver.findElements(By.xpath("//table[@id='" + LEGACY_ADMIN_AUCTION_TABLE + "']/tbody/tr"))
				.size();

		for (int i = 0; i < rowCount; i++) {

			if (common.isElementPresent("//table[@id='" + LEGACY_ADMIN_AUCTION_TABLE + "']//tr//td//..[text()='"
					+ auctionname + "']//..//..//..[text()='Sale closed']"))

			{
				common.log("auction " + auctionname + " Sale closed display");
				System.out.println("auction " + auctionname + " Sale closed display");

				common.assertElementPresent("//table[@id='" + LEGACY_ADMIN_AUCTION_TABLE + "']//tr//td//..[text()='"
						+ auctionname + "']//..//..//..[text()='Sale closed']");

				common.pause(10);
				break;
			} else {
				common.log("auction " + auctionname + " is not present in this page");
				System.out.println("auction " + auctionname + " is not  present in this page");

				driver.findElement(By
						.xpath("//span[@id='" + LEGACY_ADMIN_PAGE_PAGINATION_WARNING_MESSAGE + "']//a[text()='Next']"))
						.click();
				common.pause(15);
			}

		}

		/* Bidding now and upcoming */

		System.out.println("Step :: Select Bidding now and upcoming");
		common.log("<br></br> Step :: Select Bidding now and upcoming");
		common.waitForElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']"));

		driver.findElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']")).click();
		common.pause(10);

		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Bidding now and upcoming']")).click();

		common.pause(30);

		verify_Auction_Not_Display(auctionname);

		/* Bidding now only */

		System.out.println("Step :: Select Bidding now only");
		common.log("<br></br> Step :: Select Bidding now only");
		common.waitForElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']"));

		driver.findElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']")).click();
		common.pause(10);

		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Bidding now only']")).click();

		common.pause(30);

		verify_Auction_Not_Display(auctionname); // Verify auction name is not
		// display

		/* Upcoming only */

		System.out.println("Step :: Select Upcoming only");
		common.log("<br></br> Step :: Select Upcoming only");
		common.waitForElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']"));

		driver.findElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']")).click();
		common.pause(10);

		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Upcoming only']")).click();

		common.pause(30);

		// display

		/* Closed */

		System.out.println("Step :: Select Closed");
		common.log("<br></br> Step :: Select Closed");
		common.waitForElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']"));

		driver.findElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']")).click();
		common.pause(10);

		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Closed']")).click();

		common.pause(30);

		int rowCount1 = driver.findElements(By.xpath("//table[@id='" + LEGACY_ADMIN_AUCTION_TABLE + "']/tbody/tr"))
				.size();

		for (int i = 0; i < rowCount1; i++) {

			if (common.isElementPresent("//table[@id='" + LEGACY_ADMIN_AUCTION_TABLE + "']//tr//td//..[text()='"
					+ auctionname + "']//..//..//..[text()='Sale closed']"))

			{
				common.log("auction " + auctionname + " Sale closed display");
				System.out.println("auction " + auctionname + " Sale closed display");

				common.assertElementPresent("//table[@id='" + LEGACY_ADMIN_AUCTION_TABLE + "']//tr//td//..[text()='"
						+ auctionname + "']//..//..//..[text()='Sale closed']");

				common.pause(10);
				break;
			} else {
				common.log("auction " + auctionname + " is not present in this page");
				System.out.println("auction " + auctionname + " is not  present in this page");

				driver.findElement(By
						.xpath("//span[@id='" + LEGACY_ADMIN_PAGE_PAGINATION_WARNING_MESSAGE + "']//a[text()='Next']"))
						.click();
				common.pause(15);
			}

		}

	}

	/**
	 * Verify Live sale and timed sale auction status Feature
	 * 
	 * @param auctionname
	 * @throws AWTException
	 */
	public void verify_Timed_Auction_Status_Feature(String auctionname) throws AWTException

	{
		// Select Bidding Now and Upcoming Only

		common.pause(30);
		System.out.println("Step :: Select Bidding now and upcoming");
		common.log("<br></br> Step :: Select Bidding now and upcoming");
		// common.waitForElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']"));

		driver.findElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']")).click();
		common.pause(20);

		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Bidding now and upcoming']")).click();

		common.pause(30);
		// Select Timed Only

		System.out.println("Step :: Select Timed Only");
		common.log("<br></br> Step :: Select Timed Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Timed only']")).click();
		common.pause(30);
		// Select Auctioneer Sagar

		System.out.println("Step :: Select Sagar Auctioneer");
		common.log("<br></br> Step :: Select Sagar Auctioneer");
		driver.findElement(By.xpath("//span[@id='alf9_ctl']//..//a[@role='button']")).click();

		// Mouse Event
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Sagar']")).click();

		common.pause(30);

		System.out.println("Step :: Select 100 from dropdown");
		common.log("<br></br> Step :: Select 100 from dropdown");
		driver.findElement(By.xpath("//select[@id='" + LEGACY_ADMIN_LOT_TABLE + "']//option[@value='3']")).click();

		common.pause(25);

		common.log("<br></br> Step :: To verify Sale status closed display when show type all selected");
		System.out.println("Step :: To verify Sale status closed display when show type all selected");

		int rowCount = driver.findElements(By.xpath("//table[@id='" + LEGACY_ADMIN_AUCTION_TABLE + "']/tbody/tr"))
				.size();

		for (int i = 0; i < rowCount; i++) {

			if (common.isElementPresent("//table[@id='" + LEGACY_ADMIN_AUCTION_TABLE + "']//tr//td//..[text()='"
					+ auctionname + "']//..//..//..[text()='Upcoming']"))

			{
				common.log("auction " + auctionname + " Upcoming display");
				System.out.println("auction " + auctionname + " Upcoming display");

				common.assertElementPresent("//table[@id='" + LEGACY_ADMIN_AUCTION_TABLE + "']//tr//td//..[text()='"
						+ auctionname + "']//..//..//..[text()='Upcoming']");

				common.pause(10);
				break;
			} else {
				common.log("auction " + auctionname + " is not present in this page");
				System.out.println("auction " + auctionname + " is not  present in this page");

				driver.findElement(By
						.xpath("//span[@id='" + LEGACY_ADMIN_PAGE_PAGINATION_WARNING_MESSAGE + "']//a[text()='Next']"))
						.click();
				common.pause(15);
			}

		}

		/* Bidding now and upcoming */

		// Select Bidding Now and Upcoming Only

		common.pause(30);
		System.out.println("Step :: Select Bidding now and upcoming");
		common.log("<br></br> Step :: Select Bidding now and upcoming");
		common.waitForElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']"));

		driver.findElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']")).click();
		common.pause(10);

		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Bidding now and upcoming']")).click();

		common.pause(30);

		for (int i = 0; i < rowCount; i++) {

			if (common.isElementPresent("//table[@id='" + LEGACY_ADMIN_AUCTION_TABLE + "']//tr//td//..[text()='"
					+ auctionname + "']//..//..//..[text()='Upcoming']"))

			{
				common.log("auction " + auctionname + " Upcoming display");
				System.out.println("auction " + auctionname + " Upcoming display");

				common.assertElementPresent("//table[@id='" + LEGACY_ADMIN_AUCTION_TABLE + "']//tr//td//..[text()='"
						+ auctionname + "']//..//..//..[text()='Upcoming']");

				common.pause(10);
				break;
			} else {
				common.log("auction " + auctionname + " is not present in this page");
				System.out.println("auction " + auctionname + " is not  present in this page");

				driver.findElement(By
						.xpath("//span[@id='" + LEGACY_ADMIN_PAGE_PAGINATION_WARNING_MESSAGE + "']//a[text()='Next']"))
						.click();
				common.pause(15);
			}

		}

		/* Bidding now only */

		common.pause(30);
		System.out.println("Step :: Select Bidding now only");
		common.log("<br></br> Step :: Select Bidding now only");
		common.waitForElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']"));

		driver.findElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']")).click();
		common.pause(10);

		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Bidding now only']")).click();

		common.pause(30);

		verify_Auction_Not_Display(auctionname); // Verify auction name is not
		// display

		/* Upcoming only Display */

		common.pause(30);
		System.out.println("Step :: Select Upcoming only");
		common.log("<br></br> Step :: Select Upcoming only");
		common.waitForElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']"));

		driver.findElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']")).click();
		common.pause(10);

		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Upcoming only']")).click();

		common.pause(30);

		for (int i = 0; i < rowCount; i++) {

			if (common.isElementPresent("//table[@id='" + LEGACY_ADMIN_AUCTION_TABLE + "']//tr//td//..[text()='"
					+ auctionname + "']//..//..//..[text()='Upcoming']"))

			{
				common.log("auction " + auctionname + " Upcoming display");
				System.out.println("auction " + auctionname + " Upcoming display");

				common.assertElementPresent("//table[@id='" + LEGACY_ADMIN_AUCTION_TABLE + "']//tr//td//..[text()='"
						+ auctionname + "']//..//..//..[text()='Upcoming']");

				common.pause(10);
				break;
			} else {
				common.log("auction " + auctionname + " is not present in this page");
				System.out.println("auction " + auctionname + " is not  present in this page");

				driver.findElement(By
						.xpath("//span[@id='" + LEGACY_ADMIN_PAGE_PAGINATION_WARNING_MESSAGE + "']//a[text()='Next']"))
						.click();
				common.pause(15);
			}

		}

		/* Closed */

		common.pause(30);
		System.out.println("Step :: Select Closed");
		common.log("<br></br> Step :: Select Closed");
		common.waitForElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']"));

		driver.findElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']")).click();
		common.pause(10);

		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Closed']")).click();

		common.pause(30);

		int rowCount1 = driver.findElements(By.xpath("//table[@id='" + LEGACY_ADMIN_AUCTION_TABLE + "']/tbody/tr"))
				.size();

		for (int i = 0; i < rowCount1; i++) {

			if (!common.isElementPresent("//table[@id='" + LEGACY_ADMIN_AUCTION_TABLE + "']//tr//td//..[text()='"
					+ auctionname + "']//..//..//..[text()='Sale closed']"))

			{
				common.log("auction " + auctionname + " Sale not display");
				System.out.println("auction " + auctionname + " Sale not display");

				common.assertElementNotPresent("//table[@id='" + LEGACY_ADMIN_AUCTION_TABLE + "']//tr//td//..[text()='"
						+ auctionname + "']//..//..//..[text()='Sale closed']");

				common.pause(10);
				break;
			} else {
				common.log("auction " + auctionname + " is not present in this page");
				System.out.println("auction " + auctionname + " is not  present in this page");

				driver.findElement(By
						.xpath("//span[@id='" + LEGACY_ADMIN_PAGE_PAGINATION_WARNING_MESSAGE + "']//a[text()='Next']"))
						.click();
				common.pause(15);
			}

		}

	}

	/**
	 * Verify Live sale and timed sale auction status Feature
	 * 
	 * @param auctionname
	 * @throws AWTException
	 */
	public void verify_Live_Auction_Status_Feature(String auctionname) throws AWTException

	{
		common.pause(30);
		common.log("<br></br> Step :: Click on Auction Overview Page");
		System.out.println("Step :: Click on Auction Overview Page");
		common.jsClick(auctionsubtab);// Go to Auction overview page
		common.pause(30);
		// Select Closed Only From Dropdown

		System.out.println("Step :: Select All");
		common.log("<br></br> Step :: Select All");
		common.waitForElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']"));

		driver.findElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']")).click();
		common.pause(10);

		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='All']")).click();

		common.pause(30);
		// Select Timed Only

		System.out.println("Step :: Select Live Only");
		common.log("<br></br> Step :: Select Live Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Live only']")).click();
		common.pause(30);
		// Select Auctioneer Sagar

		System.out.println("Step :: Select Sagar Auctioneer");
		common.log("<br></br> Step :: Select Sagar Auctioneer");
		driver.findElement(By.xpath("//span[@id='alf9_ctl']//..//a[@role='button']")).click();

		// Mouse Event
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Sagar']")).click();

		common.pause(30);

		common.log("<br></br> Step :: To verify Sale status upcoming display when show type all selected");
		System.out.println("Step :: To verify Sale status upcoming display when show type all selected");

		for (int i = 0; i < 20; i++) {

			if (common.isElementPresent(
					"//ul[@class='auclting yura']//a[text()=' " + auctionname + "']//..//..//span[text()='Upcoming']"))

			{
				common.log("auction " + auctionname + " Sale Upcoming display");
				System.out.println("auction " + auctionname + " Sale Upcoming display");

				common.assertElementPresent("//ul[@class='auclting yura']//a[text()=' " + auctionname
						+ "']//..//..//span[text()='Upcoming']");

				common.pause(10);
				break;
			} else {
				common.log("auction " + auctionname + " is not present in this page");
				System.out.println("auction " + auctionname + " is not  present in this page");

				driver.findElement(By.xpath("//span[@id='" + LEGACY_USER_LST_NEXT_PAGE + "']//a[text()='Next']"))
						.click();
				common.pause(15);
			}

		}

		/* Bidding now and upcoming */

		System.out.println("Step :: Select Bidding now and upcoming");
		common.log("<br></br> Step :: Select Bidding now and upcoming");
		common.waitForElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']"));

		driver.findElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']")).click();
		common.pause(10);

		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Bidding now and upcoming']")).click();

		common.pause(30);

		for (int i = 0; i < 20; i++) {

			if (common.isElementPresent(
					"//ul[@class='auclting yura']//a[text()=' " + auctionname + "']//..//..//span[text()='Upcoming']"))

			{
				common.log("auction " + auctionname + " Upcoming display");
				System.out.println("auction " + auctionname + " Upcoming display");

				common.assertElementPresent("//ul[@class='auclting yura']//a[text()=' " + auctionname
						+ "']//..//..//span[text()='Upcoming']");

				common.pause(10);
				break;
			} else {
				common.log("auction " + auctionname + " is not present in this page");
				System.out.println("auction " + auctionname + " is not  present in this page");
				common.pause(10);
				driver.findElement(By.xpath("//span[@id='" + LEGACY_USER_LST_NEXT_PAGE + "']//a[text()='Next']"))
						.click();
				common.pause(15);

			}

		}

		/* Bidding now only */

		System.out.println("Step :: Select Bidding now only");
		common.log("<br></br> Step :: Select Bidding now only");
		common.waitForElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']"));

		driver.findElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']")).click();
		common.pause(10);

		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Bidding now only']")).click();

		common.pause(30);

		verify_Auction_Not_Display(auctionname); // Verify auction name is not
		// display

		/* Upcoming only Display */

		System.out.println("Step :: Select Upcoming only");
		common.log("<br></br> Step :: Select Upcoming only");
		common.waitForElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']"));

		driver.findElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']")).click();
		common.pause(10);

		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Upcoming only']")).click();

		common.pause(30);
		for (int i = 0; i < 20; i++) {

			if (common.isElementPresent(
					"//ul[@class='auclting yura']//a[text()=' " + auctionname + "']//..//..//span[text()='Upcoming']"))

			{
				common.log("auction " + auctionname + " Upcoming display");
				System.out.println("auction " + auctionname + " Upcoming display");

				common.assertElementPresent("//ul[@class='auclting yura']//a[text()=' " + auctionname
						+ "']//..//..//span[text()='Upcoming']");

				common.pause(10);
				break;
			} else {
				common.log("auction " + auctionname + " is not present in this page");
				System.out.println("auction " + auctionname + " is not  present in this page");

				driver.findElement(By.xpath("//span[@id='" + LEGACY_USER_LST_NEXT_PAGE + "']//a[text()='Next']"))
						.click();
				common.pause(15);

			}

		}

		/* Closed */

		common.log("<br></br> Step :: To verify Sale status closed display when show type closed selected");
		System.out.println("Step :: To verify Sale status closed display when show type closed selected");

		for (int i = 0; i < 20; i++) {

			if (!common.isElementPresent("//ul[@class='auclting yura']//a[text()=' " + auctionname
					+ "']//..//..//span[text()='Sale closed']"))

			{
				common.log("auction " + auctionname + " Sale not display");
				System.out.println("auction " + auctionname + " Sale not display");

				common.assertElementNotPresent("//ul[@class='auclting yura']//a[text()=' " + auctionname
						+ "']//..//..//span[text()='Sale closed']");

				common.pause(10);
				break;
			} else {
				common.log("auction " + auctionname + " is not present in this page");
				System.out.println("auction " + auctionname + " is not  present in this page");

				driver.findElement(By.xpath("//span[@id='" + LEGACY_USER_LST_NEXT_PAGE + "']//a[text()='Next']"))
						.click();
				common.pause(15);
			}

		}

	}

	/**
	 * Verify Timesale start date status Past
	 * 
	 * @param auctionname
	 * @throws AWTException
	 */
	public void verify_Start_Date_Timedsale_Auction_Status_Past(String auctionname) throws AWTException

	{

		common.log("<br></br> Step :: Click on Auction Overview Page");
		System.out.println("Step :: Click on Auction Overview Page");
		common.jsClick(auctionsubtab);// Go to Auction overview page
		common.pause(15);
		// Select Closed Only From Dropdown
		// Select All

		common.pause(30);
		System.out.println("Step :: Select All");
		common.log("<br></br> Step :: Select All");
		common.waitForElement(By.xpath("//span[@id='"+LEGACY_USER_LST_AUCTION_SHOW+"']//..//a[@role='"+LEGACY_USER_BUTTON+"']"));

		driver.findElement(By.xpath("//span[@id='"+LEGACY_USER_LST_AUCTION_SHOW+"']//..//a[@role='"+LEGACY_USER_BUTTON+"']")).click();
		common.pause(10);

		driver.findElement(By.xpath("//li[@class='"+LEGACY_FRONT_SALE_SELECT_DROPDOWN+"']//div[text()='All']")).click();

		common.pause(30);
		// Select Timed Only

		System.out.println("Step :: Select Timed Only");
		common.log("<br></br> Step :: Select Timed Only");

		driver.findElement(By.xpath("//span[@id='"+LEGACY_USER_LST_SELECT_SALE_TYPE+"']//..//a[@role='"+LEGACY_USER_BUTTON+"']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='"+LEGACY_FRONT_SALE_SELECT_DROPDOWN+"']//div[text()='Timed only']")).click();
		common.pause(30);
		// Select Auctioneer Sagar

		System.out.println("Step :: Select Sagar Auctioneer");
		common.log("<br></br> Step :: Select Sagar Auctioneer");
		driver.findElement(By.xpath("//span[@id='alf9_ctl']//..//a[@role='button']")).click();

		// Mouse Event
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Sagar']")).click();

		common.pause(30);

		System.out.println("Step :: Select 100 from dropdown");
		common.log("<br></br> Step :: Select 100 from dropdown");
		driver.findElement(By.xpath("//select[@id='" + LEGACY_ADMIN_LOT_TABLE + "']//option[@value='3']")).click();

		common.pause(30);

		common.log("<br></br> Step :: To verify Sale status In Progress display when show type all selected");
		System.out.println("Step :: To verify Sale status In Progress display when show type all selected");

		int rowCount = driver.findElements(By.xpath("//table[@id='" + LEGACY_ADMIN_AUCTION_TABLE + "']/tbody/tr"))
				.size();

		for (int i = 0; i < rowCount; i++) {

			if (common.isElementPresent("//table[@id='" + LEGACY_ADMIN_AUCTION_TABLE + "']//tr//td//..[text()='"
					+ auctionname + "']//..//..//..[text()='" + LEGACY_USER_LIST_AUCTION_STATUS + "']"))

			{
				common.log("auction " + auctionname + " Sale In Progress display");
				System.out.println("auction " + auctionname + " Sale In Progress display");

				common.assertElementPresent("//table[@id='" + LEGACY_ADMIN_AUCTION_TABLE + "']//tr//td//..[text()='"
						+ auctionname + "']//..//..//..[text()='" + LEGACY_USER_LIST_AUCTION_STATUS + "']");

				common.pause(10);
				break;
			} else {
				common.log("auction " + auctionname + " is not present in this page");
				System.out.println("auction " + auctionname + " is not  present in this page");

				driver.findElement(By
						.xpath("//span[@id='" + LEGACY_ADMIN_PAGE_PAGINATION_WARNING_MESSAGE + "']//a[text()='Next']"))
						.click();
				common.pause(15);
			}

		}

		/* Bidding now and upcoming */

		System.out.println("Step :: Select Bidding now and upcoming");
		common.log("<br></br> Step :: Select Bidding now and upcoming");
		common.waitForElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']"));

		driver.findElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']")).click();
		common.pause(10);

		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Bidding now and upcoming']")).click();

		common.pause(30);

		for (int i = 0; i < rowCount; i++) {

			if (common.isElementPresent("//table[@id='" + LEGACY_ADMIN_AUCTION_TABLE + "']//tr//td//..[text()='"
					+ auctionname + "']//..//..//..[text()='" + LEGACY_USER_LIST_AUCTION_STATUS + "']"))

			{
				common.log("auction " + auctionname + " Sale In Progress display");
				System.out.println("auction " + auctionname + " Sale In Progress display");

				common.assertElementPresent("//table[@id='" + LEGACY_ADMIN_AUCTION_TABLE + "']//tr//td//..[text()='"
						+ auctionname + "']//..//..//..[text()='" + LEGACY_USER_LIST_AUCTION_STATUS + "']");

				common.pause(10);
				break;
			} else {
				common.log("auction " + auctionname + " is not present in this page");
				System.out.println("auction " + auctionname + " is not  present in this page");

				driver.findElement(By
						.xpath("//span[@id='" + LEGACY_ADMIN_PAGE_PAGINATION_WARNING_MESSAGE + "']//a[text()='Next']"))
						.click();
				common.pause(15);
			}

		}

		/* Bidding now only */

		System.out.println("Step :: Select Bidding now only");
		common.log("<br></br> Step :: Select Bidding now only");
		common.waitForElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']"));

		driver.findElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']")).click();
		common.pause(10);

		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Bidding now and upcoming']")).click();

		common.pause(30);

		for (int i = 0; i < rowCount; i++) {

			if (common.isElementPresent("//table[@id='" + LEGACY_ADMIN_AUCTION_TABLE + "']//tr//td//..[text()='"
					+ auctionname + "']//..//..//..[text()='" + LEGACY_USER_LIST_AUCTION_STATUS + "']"))

			{
				common.log("auction " + auctionname + " Sale In Progress display");
				System.out.println("auction " + auctionname + " Sale In Progress display");

				common.assertElementPresent("//table[@id='" + LEGACY_ADMIN_AUCTION_TABLE + "']//tr//td//..[text()='"
						+ auctionname + "']//..//..//..[text()='" + LEGACY_USER_LIST_AUCTION_STATUS + "']");

				common.pause(10);
				break;
			} else {
				common.log("auction " + auctionname + " is not present in this page");
				System.out.println("auction " + auctionname + " is not  present in this page");

				driver.findElement(By
						.xpath("//span[@id='" + LEGACY_ADMIN_PAGE_PAGINATION_WARNING_MESSAGE + "']//a[text()='Next']"))
						.click();
				common.pause(15);
			}

		}

		/* Upcoming only */

		System.out.println("Step :: Select Upcoming only");
		common.log("<br></br> Step :: Select Upcoming only");
		common.waitForElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']"));

		driver.findElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']")).click();
		common.pause(10);

		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Upcoming only']")).click();

		common.pause(30);

		System.out.println("Step :: Sale is not display");
		common.assertElementNotPresent("//table[@id='" + LEGACY_ADMIN_AUCTION_TABLE + "']//tr//td//..[text()='"
				+ auctionname + "']//..//..//..[text()='" + LEGACY_USER_LIST_AUCTION_STATUS + "']");
		// display

		/* Closed */

		System.out.println("Step :: Select Closed");
		common.log("<br></br> Step :: Select Closed");
		common.waitForElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']"));

		driver.findElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']")).click();
		common.pause(10);

		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Closed']")).click();

		common.pause(30);

		int rowCount1 = driver.findElements(By.xpath("//table[@id='" + LEGACY_ADMIN_AUCTION_TABLE + "']/tbody/tr"))
				.size();

		for (int i = 0; i < rowCount1; i++) {

			if (!common.isElementPresent("//table[@id='" + LEGACY_ADMIN_AUCTION_TABLE + "']//tr//td//..[text()='"
					+ auctionname + "']//..//..//..[text()='Sale closed']"))

			{
				common.log("auction " + auctionname + " Sale closed not display");
				System.out.println("auction " + auctionname + " Sale closed not display");

				common.assertElementNotPresent("//table[@id='" + LEGACY_ADMIN_AUCTION_TABLE + "']//tr//td//..[text()='"
						+ auctionname + "']//..//..//..[text()='Sale closed not display']");

				common.pause(10);
				break;
			} else {
				common.log("auction " + auctionname + " is not present in this page");
				System.out.println("auction " + auctionname + " is not  present in this page");

				driver.findElement(By
						.xpath("//span[@id='" + LEGACY_ADMIN_PAGE_PAGINATION_WARNING_MESSAGE + "']//a[text()='Next']"))
						.click();
				common.pause(15);
			}

		}

	}

	/**
	 * Verify Lot Time Left
	 * 
	 * @param TimedAuction
	 * @param lot1
	 * @param lot2
	 * @param lot3
	 * @param lot4
	 * @param lot5
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public void verify_Lot_Time_Left(String TimedAuction, String lot1, String lot2, String lot3, String lot4,
			String lot5, String lot6) throws AWTException, InterruptedException

	{

		goto_Catalog_Page_Timed_Sale(TimedAuction); // Goto catalog page

		common.pause(30);

		// Verify Left Time form the table

		String lot1time = driver
				.findElement(By.xpath("//a[text()='" + lot1 + "']//..//..//..//..//p[@class='timelft time-left']"))
				.getText();
		System.out.println("Step :: Lot1 time left >>" + lot1time);

		String lot2time = driver
				.findElement(By.xpath("//a[text()='" + lot2 + "']//..//..//..//..//p[@class='timelft time-left']"))
				.getText();
		System.out.println("Step :: Lot2 time left >>" + lot2time);

		String lot3time = driver
				.findElement(By.xpath("//a[text()='" + lot3 + "']//..//..//..//..//p[@class='timelft time-left']"))
				.getText();
		System.out.println("Step :: Lot3 time left >>" + lot3time);

		String lot4time = driver
				.findElement(By.xpath("//a[text()='" + lot4 + "']//..//..//..//..//p[@class='timelft time-left']"))
				.getText();
		System.out.println("Step :: Lot4 time left >>" + lot4time);

		String lot5time = driver
				.findElement(By.xpath("//a[text()='" + lot5 + "']//..//..//..//..//p[@class='timelft time-left']"))
				.getText();
		System.out.println("Step :: Lot5 time left >>" + lot5time);

		String lot6time = driver
				.findElement(By.xpath("//a[text()='" + lot6 + "']//..//..//..//..//p[@class='timelft time-left']"))
				.getText();
		System.out.println("Step :: Lot6 time left >>" + lot6time);

	}

	/**
	 * Catalog Section
	 * 
	 * @param lotname
	 * @throws ParseException
	 * @throws InterruptedException
	 * @throws AWTException
	 */
	public void catalog_Section(String lotname) throws ParseException, InterruptedException, AWTException {

		common.pause(20);
		System.out.println(" Step :: Click on pdf catlog link");
		common.log("<br></br> Step :: Click on pdf catlog link");
		driver.findElement(By.xpath("//a[text()='PDF Catalog']")).click();

		common.pause(10);
	}

	/**
	 * verify Auction Items In Search Panel
	 * 
	 * @param AucItem_lbl
	 */

	public void Verify_Auction_Items_Label(String AucItem_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(20);

		// String auctionItem =
		// driver.findElement(By.xpath("//div[@class='filter-auction-type']")).getText();
		//
		// System.out.println("Step :: Auction Items Label is :: " + auctionItem);

		common.pause(10);
	}

	/**
	 * 
	 * verify Account Items In Search Panel
	 * 
	 * @param Account_lbl
	 */

	public void Verify_Accountt_Label(String Account_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(20);

	}

	/**
	 * 
	 * verify Auctioneer In Search Panel
	 * 
	 * @param Aucneer_lbl
	 */

	public void Verify_Auctioneerr_Label(String Aucneer_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Live Search button");
		common.log("<br></br> Step :: Click on Live Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(20);

		// String auctionItem =
		// driver.findElement(By.xpath("//div[@class='filter-auctioneer']")).getText();
		//
		// System.out.println("Step :: Auctioneer Items Label is :: " + auctionItem);

		common.pause(10);
	}

	/**
	 * 
	 * verify Auctions In Search Panel
	 * 
	 * @param Auctions_lbl
	 */

	public void Verify_Auctions_Label(String Auctions_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(20);

	}

	/**
	 * 
	 * verify Best Offer In Search Panel
	 * 
	 * @param Bestoff_lbl
	 */

	public void Verify_Best_Offer_Label(String Bestoff_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(20);

	}

	/**
	 * verify Buy Now In Search Panel
	 * 
	 * @param BuyNow_lbl
	 */

	public void Verify_Buy_Now_Label(String BuyNow_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(20);

		// String buyNow =
		// driver.findElement(By.xpath("//div[@class='buy-now']")).getText();
		//
		// System.out.println("Step :: Buy Now Label is :: " + buyNow);
		//
		// common.pause(10);
	}

	/**
	 * verify Featured In Search Panel
	 * 
	 * @param Featured_lbl
	 */

	public void Verify_Featured_Label(String Featured_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();

		common.pause(10);
	}

	/**
	 * verify Featured lot In Search Panel
	 * 
	 * @param Featured_lbl
	 */

	public void Verify_FeaturedLot_Label(String Featured_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(20);

	}

	/**
	 * verify lot in sale label.
	 * 
	 * @param Featured_lbl
	 */

	public void Verify_lotinsale_Label(String s_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);

		if (common.isElementPresent("//a[@id='c17']")) {

			driver.findElement(By.xpath("//a[@id='c17']")).click();

		}

		common.pause(10);

		String str_lotname = driver.findElement(By.xpath("//i[1]")).getText();

		System.out.println("Step :: New lot in Sale Label is >> " + str_lotname);
	}

	/**
	 * verify Lot S label
	 * 
	 */

	public void Verify_S_Label(String Featured_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(20);

	}

	/**
	 * verify Keywords label
	 * 
	 */

	public void Verify_Keywords_Label(String Featured_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);
		String str_keyword = driver.findElement(By.xpath("//input[@id='advsKey']")).getText();

		System.out.println("Step :: Keywords Label is >> " + str_keyword);

		common.pause(10);
	}

	/**
	 * verify ListView label
	 * 
	 */

	public void Verify_List_View_Label(String Featured_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);
	}

	/**
	 * Verify add alert label
	 * 
	 */

	public void Verify_Add_Alert_Label(String Featured_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(20);
	}

	/**
	 * Verify you have reached max label
	 * 
	 */

	public void Verify_You_Have_Reached_Max_Label(String Featured_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(20);

	}

	/**
	 * Verify Save Alert
	 * 
	 */

	public void Verify_Save_Alert_Label(String Featured_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(20);

	}

	/**
	 * Verify Search title
	 * 
	 */

	public void Verify_Search_Title_Label(String Featured_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(20);

	}

	/**
	 * verify Filter By In Serach Panel
	 * 
	 * @param Filter_lbl
	 */

	public void Verify_Filter_By_Label(String Filter_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(20);

	}

	/**
	 * verify Hybrid Auction In Serach Panel
	 * 
	 * @param Hybridauc_lbl
	 */

	public void Verify_Hybrid_Action_Label(String Hybridauc_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(20);

	}

	/**
	 * verify Live Auction In Serach Panel
	 * 
	 * @param Liveauc_lbl
	 */

	public void Verify_Live_Action_Label(String Liveauc_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(20);

		//
		// String live_str =
		// driver.findElement(By.xpath("//li[@class='filter-live']")).getText();
		//
		// System.out.println("Live Auction Label is :: " + live_str);
	}

	/**
	 * verify Lot Number In Serach Panel
	 * 
	 * @param LotNum_lbl
	 */

	public void Verify_Lot_Number_Label(String LotNum_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(20);

	}

	/**
	 * verify Price In Serach Panel
	 * 
	 * @param price_lbl
	 */

	public void Verify_Price_Label(String price_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(20);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);

		//
		// String price_str =
		// driver.findElement(By.xpath("//div[@class='filter-price']")).getText();
		// System.out.println("Price Label is :: " + price_str);
		// common.pause(10);
	}

	/**
	 * verify Max In Serach Panel
	 * 
	 * @param max_lbl
	 */

	public void Verify_Max_Label(String max_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(20);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);

	}

	/**
	 * verify Min In Serach Panel
	 * 
	 * @param min_lbl
	 */

	public void Verify_Min_Label(String min_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);

	}

	/**
	 * verify Sort By In Serach Panel
	 * 
	 * @param sort_lbl
	 */

	public void Verify_Sort_By_Label(String sort_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);

		String sortby_str = driver.findElement(By.xpath("//label[text()='" + sort_lbl + "']")).getText();
		System.out.println("Sort By Label is :: " + sortby_str);
		common.pause(10);
	}

	/**
	 * verify Timed Auction In Serach Panel
	 * 
	 * @param timed_lbl
	 */

	public void Verify_Timed_Auction_Label(String timed_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(20);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);

		String timedauc_str = driver.findElement(By.xpath("//label[text()='" + timed_lbl + "']")).getText();
		System.out.println("Timed Auction Label is :: " + timedauc_str);
		common.pause(10);
	}

	/**
	 * verify Be the First to Bid on This Item! In Serach Panel
	 * 
	 * @param first_lbl
	 */

	public void Verify_Be_The_First_To_Bid_Label(String first_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(20);

	}

	/**
	 * verify Bid now! In Serach Panel
	 * 
	 * @param bidNow_lbl
	 */

	public void Verify_Bid_Now_Label(String bidNow_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(20);

		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);

		String bidNow_str = driver.findElement(By.xpath("//input[@value='" + bidNow_lbl + "']")).getAttribute("value");

		System.out.println("Bid now! Label is :: " + bidNow_str);
		common.pause(10);

	}

	/**
	 * verify Search button label Serach Panel
	 * 
	 * @param search_lbl
	 */

	public void Verify_Search_Label(String search_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(20);

	}

	/**
	 * verify Buy Now! label Serach Panel
	 * 
	 * @param buyNow_lbl
	 */

	public void Verify_BuyNow_Label(String buyNow_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(20);

	}

	/**
	 * verify Categories label Serach Panel
	 * 
	 * @param buyNow_lbl
	 */

	public void Verify_categories_Label(String cat_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(20);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);

		String cate_str = driver.findElement(By.xpath("//span[text()='" + cat_lbl + "']")).getText();

		System.out.println("Categories Label is :: " + cate_str);

		common.pause(10);
	}

	/**
	 * verify All label Serach Panel
	 * 
	 * @param buyNow_lbl
	 */

	public void Verify_All_Label(String buyNow_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(10);
	}

	/**
	 * 
	 * verify Category Match label Serach Panel
	 * 
	 * @param CAtMatch_lbl
	 */

	public void Verify_Category_Match_Label(String CAtMatch_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);
		String catMatch_str = driver.findElement(By.xpath("//label[text()='" + CAtMatch_lbl + "']")).getText();

		System.out.println("Category Match Label is :: " + catMatch_str);

		common.pause(10);
	}

	/**
	 * Verify Search title
	 * 
	 */

	public void Verify_Save_Search_Label(String savesearch_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);

	}

	/**
	 * Verify My Search title
	 * 
	 */

	public void Verify_My_Search_Label(String mysearch_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();

		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);
	}

	/**
	 * Verify Bid S title
	 * 
	 */

	public void Verify_Bid_s_Now_Label(String bids_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();

		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);
	}

	/**
	 * Verify Pay per bid item
	 * 
	 */

	public void Verify_Pay_Per_Bid_Item_Label(String paybids_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();

		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(25);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);
	}

	/**
	 * Verify Spent item
	 * 
	 */

	public void Verify_Spent_Label(String paybids_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();

		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);
	}

	/**
	 * Verify Zip/Postal
	 * 
	 */

	public void Verify_Zip_Postal_Label(String zip_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();

		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);
	}

	/**
	 * Verify Search Radius
	 * 
	 */

	public void Verify_Search_Radius_Label(String radius_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();

		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);
	}

	/**
	 * Verify Miles
	 * 
	 */

	public void Verify_Miles_Label(String miles) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();

		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);
	}

	/**
	 * Verify -Select-
	 * 
	 */

	public void Verify_Select_Label(String select) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();

		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);
	}

	/**
	 * Verify Unawarded
	 * 
	 */

	public void Verify_Unawarded_Label(String select) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();

		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);
	}

	/**
	 * Verify Unsold
	 * 
	 */

	public void Verify_Unsold_Label(String select) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();

		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);
	}

	/**
	 * Verify categories
	 * 
	 */

	public void Verify_Categories_Label(String categories) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();

		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);
	}

	/**
	 * Verify Similar Items
	 * 
	 */

	public void Verify_Similar_Items_Label(String categories) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();

		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);
	}

	/**
	 * Verify All
	 * 
	 */

	public void Verify_All1_Label(String categories) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();

		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);
	}

	/**
	 * Verify All
	 * 
	 */

	public void Verify_Auction1_Label(String categories) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();

		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);
	}

	/**
	 * verify Zip/Postal Code label Serach Panel
	 * 
	 * @param zip_lbl
	 */

	public void Verify_Zip_Postal_Code_Label(String zip_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);

	}

	/**
	 * verify Incorrect Zip/Postal Code label Serach Panel
	 * 
	 * @param Incorrzip_lbl
	 */

	public void Verify_Incorrect_Zip_Postal_Code_Label(String Incorrzip_lbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);

	}

	/**
	 * verify Zip/Postal Code Not Found label Serach Panel
	 * 
	 * @param zipPostalNotFound
	 */

	public void Verify_Zip_Postal_Code_Found_Not_Label(String zipPostalNotFound) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);

	}

	/**
	 * verify Select Radius label Serach Panel
	 * 
	 * @param selectradius
	 */

	public void Verify_Select_Radius_Label(String selectradius) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);

	}

	/**
	 * Bids
	 * 
	 */

	public void Verify_Bids1_Label(String bids) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();

		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);

	}

	public void Verify_Defaults_Label(String defaults) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();

		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);
		String catMatch_str = driver.findElement(By.xpath("//a[text()='" + defaults + "']")).getText();

		System.out.println("Default Label is :: " + catMatch_str);

		common.pause(10);

	}

	/**
	 * Default
	 * 
	 */

	public void Verify_Default_Label(String bids) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();

		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);
	}

	/**
	 * Distance
	 * 
	 */

	public void Verify_Distance_Label(String bids) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();

		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);
	}

	/**
	 * Highest Price
	 * 
	 */

	public void Verify_Highest_Price_Label(String Highprice) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();

		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);
	}

	/**
	 * Lot Name
	 * 
	 */

	public void Verify_Lot_Name_Label(String lotname) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();

		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);
	}

	/**
	 * Lot #
	 * 
	 */

	public void Verify_Lot_Hash1_Label(String Highprice) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();

		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);
	}

	/**
	 * Lowest Price
	 * 
	 */

	public void Verify_Lowest_Price_Label(String lowestprice) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();

		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);
	}

	/**
	 * Newest
	 * 
	 */

	public void Verify_Newest_Label(String newest) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();

		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);
	}

	/**
	 * Time Left
	 * 
	 */

	public void Verify_Time_Left_Search_Label(String timeleft) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();

		common.pause(10);
		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);
	}

	/**
	 * View
	 * 
	 */

	public void Verify_View_Search_Label(String timeleft) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();

		common.pause(10);
		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);
	}

	/**
	 * Max Number Search
	 * 
	 */

	public void Verify_Max_Number_Search_Label(String maxnumber) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();

		common.pause(10);
		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);
	}

	/**
	 * Table View
	 * 
	 */

	public void Verify_Table_View_Search_Label(String tableviewsearch) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);

	}

	/**
	 * Auction
	 * 
	 */

	public void Verify_Auction_Search_Label(String aucitonsearch) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();

		common.pause(10);
		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);
	}

	/**
	 * Auction Date
	 * 
	 */

	public void Verify_Auction_Date_Label1(String auction) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);
	}

	/**
	 * Estimate
	 * 
	 */

	public void Verify_Estimate_Search_Label(String estimate) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();

		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);
	}

	/**
	 * Image
	 * 
	 */

	public void Verify_Image_Label(String image) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);
	}

	public void Verify_Item_Label1(String itemlbl) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);
	}

	public void Verify_Lot_hash_Label(String lothash) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);
	}

	/**
	 * Item Title
	 * 
	 */

	public void Verify_Item_Title_Label(String itemtitle) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);
	}

	/**
	 * Lot #1
	 * 
	 */

	public void Verify_Lot_Has1_Label(String lothas) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);

	}

	/**
	 * My Bid
	 * 
	 */

	public void Verify_My_Bid_Label(String mybid) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();

		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);

	}

	/**
	 * Quantity
	 * 
	 */

	public void Verify_Quantity_Label(String quantity) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();

		common.pause(10);
		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);
	}

	/**
	 * Time Left
	 * 
	 */

	public void Verify_Time_Left1_Label(String timeleft) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);

	}

	/**
	 * Advance Search
	 * 
	 */

	public void Verify_Advance_Search_Label(String advsearch) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();

		common.pause(10);
		driver.findElement(By.xpath("//input[@id='btnSearch']")).click();
		common.pause(20);
		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).click();
		common.pause(15);

		String found_str = driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).getText();

		System.out.println("Total Found Label is :: " + found_str);
		common.pause(10);
	}

	/**
	 * Total Found
	 * 
	 */

	public void Verify_Total_Found_Label(String maxnumber) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();

		common.pause(20);

		String found_str = driver.findElement(By.xpath("//a[@class='search_toggle_btn']")).getText();

		System.out.println("Total Found Label is :: " + found_str);
		common.pause(10);
	}

	/**
	 * Total Found
	 * 
	 */

	public void Verify_Email_Password_Wrong_Label(String maxnumber) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();

		// span[@class='title'] for error msg
		common.pause(10);
	}

	public void Verify_Email_Username_CombinationNotFound_Label(String maxnumber) {

		System.out.println("Step :: Click on Forgot password?");
		common.log("<br></br> Step :: Click on Forgot password?");
		driver.findElement(By.xpath("//a[text()='Forgot password?']")).click();

		common.pause(30);
		System.out.println("Step :: Enter Username");
		common.log("<br></br> Step :: Enter Username");
		driver.findElement(By.id("aq2")).sendKeys("rahulqa");

		System.out.println("Step :: Enter email");
		common.log("<br></br> Step :: Enter email");
		driver.findElement(By.id("aq1")).sendKeys("rahul@samauctionsoftware.com");
		// span[@class='title'] for error msg
		common.pause(10);
		System.out.println("Step :: Enter Captcha");
		common.log("<br></br> Step :: Enter Captcha");
		driver.findElement(By.id("aq5")).sendKeys("azerty-sam-Xchtpac");

		System.out.println("Step :: Click on Submit");
		common.log("<br></br> Step :: Click on Submit");
		driver.findElement(By.id("aq7")).click();
		common.pause(15);

		String forgot_str = driver.findElement(By.xpath("//span[@class='title']")).getText();

		System.out.println("Username/Email combination not found Label is :: " + forgot_str);

	}

	/**
	 * Email Required
	 * 
	 */

	public void Verify_Email_Required_Label(String emailreq) {

		System.out.println("Step :: Click on Forgot password?");
		common.log("<br></br> Step :: Click on Forgot password?");
		driver.findElement(By.xpath("//a[text()='Forgot password?']")).click();

		common.pause(30);
		System.out.println("Step :: Enter Username");
		common.log("<br></br> Step :: Enter Username");
		driver.findElement(By.id("aq2")).sendKeys("rahulqa");

		// System.out.println("Step :: Enter email");
		// common.log("<br></br> Step :: Enter email");
		// driver.findElement(By.id("aq1")).sendKeys("rahul@samauctionsoftware.com");
		// span[@class='title'] for error msg
		common.pause(10);
		System.out.println("Step :: Enter Captcha");
		common.log("<br></br> Step :: Enter Captcha");
		driver.findElement(By.id("aq5")).sendKeys("azerty-sam-Xchtpac");

		System.out.println("Step :: Click on Submit");
		common.log("<br></br> Step :: Click on Submit");
		driver.findElement(By.id("aq7")).click();
		common.pause(15);

		String forgot_str = driver.findElement(By.xpath("//span[@class='sub-titles']")).getText();

		System.out.println("Email required Label is :: " + forgot_str);
		common.pause(10);
	}

	/**
	 * Incorrect text entered
	 * 
	 */

	public void Verify_Incorrect_Text_Entered_Label(String emailreq) {

		System.out.println("Step :: Click on Forgot password?");
		common.log("<br></br> Step :: Click on Forgot password?");
		driver.findElement(By.xpath("//a[text()='Forgot password?']")).click();

		common.pause(30);
		System.out.println("Step :: Enter Username");
		common.log("<br></br> Step :: Enter Username");
		driver.findElement(By.id("aq2")).sendKeys("rahulqa");

		System.out.println("Step :: Enter email");
		common.log("<br></br> Step :: Enter email");
		driver.findElement(By.id("aq1")).sendKeys("rahulsharma1818@gmail.com");
		// span[@class='title'] for error msg
		common.pause(10);
		System.out.println("Step :: Enter Captcha");
		common.log("<br></br> Step :: Enter Captcha");
		driver.findElement(By.id("aq5")).sendKeys("azerc");

		System.out.println("Step :: Click on Submit");
		common.log("<br></br> Step :: Click on Submit");
		driver.findElement(By.id("aq7")).click();
		common.pause(30);

		String incrrct_str = driver.findElement(By.xpath("//span[@class='sub-titles']")).getText();

		System.out.println("Incorrect text entered Label is :: " + incrrct_str);
		common.pause(10);

	}

	/**
	 * Text Required
	 * 
	 */

	public void Verify_Text_Required_Label(String emailreq) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();

		common.pause(10);
	}

	public void Verify_Username_Required_Label(String emailreq) {

		System.out.println("Step :: Click on Forgot password?");
		common.log("<br></br> Step :: Click on Forgot password?");
		driver.findElement(By.xpath("//a[@class='frgt']")).click();

		common.pause(30);
		// System.out.println("Step :: Enter Username");
		// common.log("<br></br> Step :: Enter Username");
		// driver.findElement(By.id("aq2")).sendKeys("rahulqa");

		System.out.println("Step :: Enter email");
		common.log("<br></br> Step :: Enter email");
		driver.findElement(By.id("aq1")).sendKeys("rahul@samauctionsoftware.com");
		// span[@class='title'] for error msg
		common.pause(10);
		System.out.println("Step :: Enter Captcha");
		common.log("<br></br> Step :: Enter Captcha");
		driver.findElement(By.id("aq5")).sendKeys("azerty-sam-Xchtpac");

		System.out.println("Step :: Click on Submit");
		common.log("<br></br> Step :: Click on Submit");
		driver.findElement(By.id("aq7")).click();
		common.pause(15);

		String usr_str = driver.findElement(By.xpath("//span[@class='sub-titles']")).getText();

		System.out.println("Username required Label is :: " + usr_str);
		common.pause(10);
	}

	/**
	 * Check Email
	 * 
	 */

	public void Verify_Check_Email_Label(String emailreq) {

		System.out.println("Step :: Click on Forgot password?");
		common.log("<br></br> Step :: Click on Forgot password?");
		driver.findElement(By.xpath("//a[@class='frgt']")).click();

		common.pause(30);
		System.out.println("Step :: Enter Username");
		common.log("<br></br> Step :: Enter Username");
		driver.findElement(By.id("aq2")).sendKeys("rahulqa");

		System.out.println("Step :: Enter email");
		common.log("<br></br> Step :: Enter email");
		driver.findElement(By.id("aq1")).sendKeys("rahulsharma1818@gmail.com");
		// span[@class='title'] for error msg
		common.pause(10);
		System.out.println("Step :: Enter Captcha");
		common.log("<br></br> Step :: Enter Captcha");
		driver.findElement(By.id("aq5")).sendKeys("azerty-sam-Xchtpac");

		System.out.println("Step :: Click on Submit");
		common.log("<br></br> Step :: Click on Submit");
		driver.findElement(By.id("aq7")).click();
		common.pause(15);

		String usr_str = driver.findElement(By.xpath("//ul[@id='messages']")).getText();

		System.out.println("Please check your email inbox to reset your password Label is :: " + usr_str);
		common.pause(10);
		// ul[@id='messages']
		common.pause(10);
	}

	/**
	 * User Name Sent
	 * 
	 */

	public void Verify_User_Name_Sent_Label(String emailreq) {

		System.out.println("Step :: Click on Forgot password?");
		common.log("<br></br> Step :: Click on Forgot password?");
		driver.findElement(By.xpath("//a[@class='frgt']")).click();

		common.pause(30);
		System.out.println("Step :: Forgot username? utton");
		common.log("<br></br> Step :: Forgot username? button");
		driver.findElement(By.xpath("//a[@class='drkblu']")).click();
		common.pause(15);
		System.out.println("Step :: Enter email");
		common.log("<br></br> Step :: Enter email");
		driver.findElement(By.id("aq1")).sendKeys("rahulsharma1818@gmail.com");
		// span[@class='title'] for error msg
		common.pause(10);
		System.out.println("Step :: Enter Captcha");
		common.log("<br></br> Step :: Enter Captcha");
		driver.findElement(By.id("aq5")).sendKeys("azerty-sam-Xchtpac");

		System.out.println("Step :: Click on Submit");
		common.log("<br></br> Step :: Click on Submit");
		driver.findElement(By.id("aq7")).click();
		common.pause(15);

		String usr_str = driver.findElement(By.xpath("//ul[@id='messages']")).getText();

		System.out.println("Your username has been sent to your registered email address. Label is :: " + usr_str);
		common.pause(10);
		// ul[@id='messages']

	}

	/**
	 * Login
	 * 
	 */

	public void Verify_Login_BTN_Label(String emailreq) {
		common.pause(10);
		String usr_str = driver.findElement(By.xpath("//input[@id='lgn']")).getText();

		System.out.println("Login button Label is :: " + usr_str);

		common.pause(10);
	}

	/**
	 * Congratulation message
	 * 
	 */

	public void Verify_Congratulation_msg_Label(String congratsmsg) {

		common.pause(10);

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Email Verified
	 * 
	 */

	public void Verify_Email_Verified_Label(String congratsmsg) {

		common.pause(10);
		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

	}

	/**
	 * Invalid User Name and Password
	 * 
	 */

	public void Verify_Invalid_Username_Password_Label(String congratsmsg) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();

		common.pause(10);
	}

	/**
	 * Mismatched verification code.
	 * 
	 */

	public void Verify_Mismatched_Verification_Code_Label(String congratsmsg) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(10);
	}

	/**
	 * Unknown Error
	 * 
	 */

	public void Verify_Unknown_Error_Label(String congratsmsg) {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));

		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();

		common.pause(10);
	}

	/**
	 * Verify_Login_Failed_Label
	 * 
	 * @throws InterruptedException
	 * 
	 * 
	 */
	public void Verify_Login_Failed_Label() throws InterruptedException {

		common.pause(15);
		String loginfailed_str = driver.findElement(By.xpath("//div[@class='validation-error']")).getText();

		System.out.println("Login Failed Label is :: " + loginfailed_str);
		common.pause(15);
	}

	/**
	 * verify Forgot Password label Serach Panel
	 * 
	 * @param Forgotpass
	 */

	public void Verify_Forgot_password_Label(String Forgotpass) {

		// common.waitForConditionIsElementPresent("//li[@class='auctions
		// current']");
		common.pause(15);
		System.out.println("Step :: Click On Logout");
		common.log("<br></br> Step :: Click On Logout");
		common.pause(15);
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		common.pause(15);

		String forgot_str = driver.findElement(By.xpath("//a[@class='frgt']")).getText();

		System.out.println("Forgot Password Label is :: " + forgot_str);
	}

	/**
	 * verify It's Easy label Serach Panel
	 * 
	 * @param itsEasy
	 */

	public void Verify_Its_Easy_Label(String itsEasy) {

		common.pause(15);

		String itsEasy_str = driver.findElement(By.xpath("//em")).getText();

		System.out.println("It's Easy Label is :: " + itsEasy_str);

		common.assertTwoValuesAreEqual(itsEasy, itsEasy_str);
	}

	/**
	 * Not a member
	 * 
	 * @param not_member
	 */

	public void Verify_Not_Member_Label(String not_member) {

		common.pause(15);

		// System.out.println("Step :: Click On Logout");
		// common.log("<br></br> Step :: Click On Logout");
		// common.pause(15);
		// driver.findElement(By.xpath("//a[text()='Logout']")).click();
		// common.pause(30);

		String str_member = driver.findElement(By.xpath("//p[text()='" + not_member + "']")).getText();

		System.out.println("Not Member Label is :: " + str_member);

		common.assertTwoValuesAreEqual(str_member, not_member);
	}

	/**
	 * Password
	 * 
	 */

	public void Verify_Password_Label(String password) {

		common.pause(15);
		System.out.println("Step :: Click On Logout");
		common.log("<br></br> Step :: Click On Logout");
		common.pause(15);
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		common.pause(15);

		String str_member = driver.findElement(By.xpath("//label[contains(text(),'" + password + "')]")).getText();

		System.out.println("Password Label is :: " + str_member);

	}

	/**
	 * User Name
	 * 
	 */

	public void Verify_User_Name_Label(String congratsmsg) {

		common.pause(15);
		System.out.println("Step :: Click On Logout");
		common.log("<br></br> Step :: Click On Logout");
		common.pause(15);
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		common.pause(15);

		String str_member = driver.findElement(By.xpath("//label[text()='" + congratsmsg + "']")).getText();

		System.out.println("Username Label is :: " + str_member);
	}

	/**
	 * Register Now!
	 * 
	 * @param register_now
	 */

	public void Verify_Register_Now_Label(String register_now) {

		common.pause(15);

		System.out.println("Step :: Click On Logout");
		common.log("<br></br> Step :: Click On Logout");
		common.pause(15);
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		common.pause(30);

		String str_regnow = driver.findElement(By.xpath("//a[text()='" + register_now + "']")).getText();

		System.out.println("Register Now! Label is :: " + str_regnow);

		common.assertTwoValuesAreEqual(str_regnow, register_now);
	}

	public void Verify_Date_Label_Invoice(String date) {

		common.pause(15);

		System.out.println("Step :: Click On Invoices Menu");
		common.log("<br></br> Step :: Click On Invoices Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);

		String str_date = driver.findElement(By.xpath("//th[contains(text(),'" + date + "')]")).getText();

		System.out.println("New Date Label is :: " + str_date);

		common.assertTwoValuesAreEqual(date, str_date);
	}

	public void Verify_BalanceDue_Label_Invoice(String balanceDue) {

		common.pause(15);

		System.out.println("Step :: Click On Invoices Menu");
		common.log("<br></br> Step :: Click On Invoices Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);

		System.out.println("Step ::Open Invoice");
		common.log("<br></br> Step ::Open Invoice");
		driver.findElement(By.xpath("//tr[1]//td[4]")).click();
		common.pause(15);
		String strbalDue = driver
				.findElement(By.xpath("//div[@class='notes summary']//span[contains(text(),'" + balanceDue + "')]"))
				.getText();

		System.out.println("New Balance Due Label is :: " + strbalDue);

		common.assertTwoValuesAreEqual(balanceDue, strbalDue);
	}

	public void Verify_BillingInformation_Label_Invoice(String billingInfo) {

		common.pause(15);

		System.out.println("Step :: Click On Invoices Menu");
		common.log("<br></br> Step :: Click On Invoices Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);

		System.out.println("Step ::Open Invoice");
		common.log("<br></br> Step ::Open Invoice");
		driver.findElement(By.xpath("//tr[1]//td[4]")).click();
		common.pause(15);
		String strBillingInfo = driver.findElement(By.xpath("//em[contains(text(),'" + billingInfo + ":')]")).getText();

		System.out.println("New Billing Information Label is :: " + strBillingInfo);
	}

	public void Verify_BuyerPremium_Label_Invoice(String buterpre) {

		common.pause(15);

		System.out.println("Step :: Click On Invoices Menu");
		common.log("<br></br> Step :: Click On Invoices Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);

		System.out.println("Step ::Open Invoice");
		common.log("<br></br> Step ::Open Invoice");
		driver.findElement(By.xpath("//tr[1]//td[4]")).click();
		common.pause(15);
		String buyerPre = driver.findElement(By.xpath("//th[@class='item-buyers-premium']")).getText();

		System.out.println("New Buyer Premium Label is :: " + buyerPre);
		common.assertTwoValuesAreEqual(buterpre, buyerPre);

	}

	public void Verify_Category_Label_Invoice(String category) {

		common.pause(15);

		System.out.println("Step :: Click On Invoices Menu");
		common.log("<br></br> Step :: Click On Invoices Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);

		System.out.println("Step ::Open Invoice");
		common.log("<br></br> Step ::Open Invoice");
		driver.findElement(By.xpath("//tr[1]//td[4]")).click();
		common.pause(15);
		String category1 = driver.findElement(By.xpath("//th[@class='item-category']")).getText();

		System.out.println("New Category Label is :: " + category1);
		common.assertTwoValuesAreEqual(category, category1);

	}

	public void Verify_Extra_charges_Label_Invoice(String extraCharges) {

		common.pause(15);

		System.out.println("Step :: Click On Invoices Menu");
		common.log("<br></br> Step :: Click On Invoices Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);

		driver.findElement(By.xpath("//select[@id='c1']//option[@value='1']")).click();
		common.pause(15);

		System.out.println("Step ::Open Invoice");
		common.log("<br></br> Step ::Open Invoice");
		driver.findElement(By.xpath("//tr[2]//td[4]")).click();
		common.pause(15);
		String extracharges = driver.findElement(By.xpath("//span[contains(text(),'" + extraCharges + ":')]"))
				.getText();

		System.out.println("New Extra Label is :: " + extracharges);

	}

	public void Verify_Hammer_Price_Label_Invoice(String hammerPrice) {

		common.pause(15);

		System.out.println("Step :: Click On Invoices Menu");
		common.log("<br></br> Step :: Click On Invoices Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);

		System.out.println("Step ::Open Invoice");
		common.log("<br></br> Step ::Open Invoice");
		driver.findElement(By.xpath("//tr[2]//td[4]")).click();
		common.pause(20);
		String hammerPrice1 = driver.findElement(By.xpath("//th[@class='item-hammer-price']")).getText();

		System.out.println("Hammer price Label is :: " + hammerPrice1);
		common.assertTwoValuesAreEqual(hammerPrice, hammerPrice1);

	}

	public void Verify_Invoice_Hash_Label(String invoiceHash) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);

		driver.findElement(By.xpath("//tr[1]//td[3]")).click();
		common.pause(30);

		String str_invoicehash = driver.findElement(By.xpath("//em[contains(text(),'" + invoiceHash + "')]")).getText();

		System.out.println("Invoice # Label is :: " + str_invoicehash);

	}

	public void Verify_Invoice_Hash1_Label(String invoiceHash) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);

		String str_invoicehash = driver.findElement(By.xpath("//th[contains(text(),'" + invoiceHash + "')]")).getText();

		System.out.println("Invoice # Label is :: " + str_invoicehash);
		common.assertTwoValuesAreEqual(invoiceHash, str_invoicehash);

	}

	public void Verify_Item_Name_Label(String itemName) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);

		driver.findElement(By.xpath("//tr[1]//td[3]")).click();
		common.pause(30);

		String str_itemName = driver.findElement(By.xpath("//th[contains(text(),'" + itemName + "')]")).getText();

		System.out.println("Item Name Label is :: " + str_itemName);

		common.assertTwoValuesAreEqual(itemName, str_itemName);
	}

	public void Verify_Item_Hash_Label(String itemHash) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);

		driver.findElement(By.xpath("//tr[1]//td[3]")).click();
		common.pause(20);

		String str_itemHash = driver.findElement(By.xpath("//th[@class='item-lot-num']")).getText();

		System.out.println("Item # Label is :: " + str_itemHash);
		common.assertTwoValuesAreEqual(itemHash, str_itemHash);

	}

	public void Verify_Lot_Hash_Label1(String lothash) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);

		driver.findElement(By.xpath("//tr[1]//td[3]")).click();
		common.pause(20);

		String str_itemHash = driver.findElement(By.xpath("//th[@class='item-sale-lot-num']")).getText();

		System.out.println("Lot # Label is :: " + str_itemHash);
		common.assertTwoValuesAreEqual(lothash, str_itemHash);

	}

	public void Verify_Notes_Label(String Notes) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(50);

		driver.findElement(By.xpath("//tr[1]//td[3]")).click();
		common.pause(20);

		// String str_notes = driver.findElement(By.xpath("//span[contains(text(),'" +
		// Notes + "')]")).getText();

		// System.out.println("Notes Label is :: " + str_notes);
		// common.assertTwoValuesAreEqual(Notes, str_notes);
		common.assertElementPresent("//span[contains(text(),'" + Notes + "')]");
		System.out.println("Step :: verified Notes label is updated in invoice");
		common.log("<br></br>Step :: verified Notes label is updated in invoice");
		common.pause(30);

	}

	public void Verify_Pay_Now_Label(String payNow) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);

		System.out.println("Step :: Select Pending from dropdown");
		common.log("<br></br> Step :: Select Pending From Dropdown");
		driver.findElement(By.xpath("//select[@id='mil1']//option[@value='1']")).click();
		common.pause(15);
		driver.findElement(By.xpath("//tr[1]//td[3]")).click();
		common.pause(20);

		String str_payNow = driver.findElement(By.xpath("//input[@id='miiv3']")).getAttribute("value");

		System.out.println("Pay now Label is :: " + str_payNow);
		common.assertTwoValuesAreEqual(payNow, str_payNow);

	}

	public void Verify_Qty_Label(String qty) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);

		driver.findElement(By.xpath("//tr[1]//td[3]")).click();
		common.pause(20);

		String str_qty = driver.findElement(By.xpath("//th[@class='item-quantity']")).getText();

		System.out.println("Qty Label is :: " + str_qty);
		common.assertTwoValuesAreEqual(qty, str_qty);

	}

	public void Verify_Sale_Label(String sale) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);

		driver.findElement(By.xpath("//tr[1]//td[3]")).click();
		common.pause(20);

		String str_sale = driver.findElement(By.xpath("//span[contains(text(),'" + sale + ":')]")).getText();

		System.out.println("Sale Label is :: " + str_sale);

	}

	public void Verify_Sale_date_Label(String saleDate) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);

		driver.findElement(By.xpath("//tr[1]//td[3]")).click();
		common.pause(20);

		String str_sale = driver.findElement(By.xpath("//span[contains(text(),'" + saleDate + ":')]")).getText();

		System.out.println("Sale date Label is :: " + str_sale);

	}

	public void Verify_Sales_tax_Label(String salesTax) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);

		driver.findElement(By.xpath("//tr[1]//td[3]")).click();
		common.pause(20);

		String str_sale = driver.findElement(By.xpath("//span[contains(text(),'" + salesTax + ":')]")).getText();

		System.out.println("Sales tax Label is :: " + str_sale);

	}

	public void Verify_Shipping_Handling_Label(String shipping) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);

		driver.findElement(By.xpath("//tr[1]//td[3]")).click();
		common.pause(20);

		String str_shippinge = driver.findElement(By.xpath("//span[contains(text(),'" + shipping + ":')]")).getText();

		System.out.println("Shipping & Handling Label is :: " + str_shippinge);

	}

	public void Verify_Status_Invoice_Label(String status) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);

		driver.findElement(By.xpath("//tr[1]//td[3]")).click();
		common.pause(20);

		String stats = driver.findElement(By.xpath(
				"//body[@class='my-invoices my-invoices-view']/div[@id='wrapper']/form[@id='MyInvoiceItemViewForm']/div[@class='container']/div[@id='c1_ctl']/div[@id='c1']/article[@class='bodybox']/ul[@class='viewinfo']/li[3]/div[1]"))
				.getText();

		System.out.println("Status Label is :: " + stats);

	}

	public void Verify_Subtotal_Invoice_Label(String subTotal) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);

		driver.findElement(By.xpath("//tr[1]//td[3]")).click();
		common.pause(20);

		String str_subtotal = driver.findElement(By.xpath("//th[@class='item-sub-total']")).getText();

		System.out.println("Subtotal Label is :: " + str_subtotal);
		common.assertTwoValuesAreEqual(subTotal, str_subtotal);

	}

	public void Verify_Total_Invoice_Label(String totalInvoice) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);

		driver.findElement(By.xpath("//tr[1]//td[3]")).click();
		common.pause(25);

		String str_subtotal = driver.findElement(By.xpath("//span[contains(text(),'" + totalInvoice + ":')]"))
				.getText();

		System.out.println("TOTAL INVOICE Label is :: " + str_subtotal);

	}

	public void Verify_M_D_Y_Invoice_Label(String mdy) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);

		driver.findElement(By.xpath("//tr[1]//td[3]")).click();
		common.pause(20);

		String stats = driver.findElement(By.xpath(
				"//body[@class='my-invoices my-invoices-view']/div[@id='wrapper']/form[@id='MyInvoiceItemViewForm']/div[@class='container']/div[@id='c1_ctl']/div[@id='c1']/article[@class='bodybox']/ul[@class='viewinfo']/li[3]/div[1]"))
				.getText();

		System.out.println("m/d/y Label is :: " + stats);

	}

	public void Verify_Items_Invoice_Label(String items) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);

		String stats = driver.findElement(By.xpath("//th[contains(text(),'" + items + "')]")).getText();

		System.out.println("Items Label is :: " + stats);

	}

	public void Verify_Invalid_Credit_Invoice_Label(String invalidCredit) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);
		System.out.println("Step :: Select Pending from dropdown");
		common.log("<br></br> Step :: Select Pending From Dropdown");
		driver.findElement(By.xpath("//select[@id='c1']//option[@value='1']")).click();
		common.pause(15);
		driver.findElement(By.xpath("//tr[2]//td[3]")).click();
		common.pause(20);

		System.out.println("Step :: Enter value in textbox");
		common.log("<br></br> Step :: Enter value in textbox");
		driver.findElement(By.xpath("//input[@id='miiv15']")).sendKeys("ABCD");
		common.pause(5);
		System.out.println("Step :: Click on Invalid Credit!");
		common.log("<br></br> Step :: Click on Invalid Credit!");
		driver.findElement(By.xpath("//input[@id='miiv16']")).click();
		common.pause(20);

		String invalidCredit1 = driver.findElement(By.xpath("//span[@class='warning']")).getText();

		System.out.println("Invalid Credit! Label is :: " + invalidCredit1);
		common.assertTwoValuesAreEqual(invalidCredit, invalidCredit1);

	}

	public void Verify_No_Enough_Credit_Invoice_Label(String noEnough) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);
		System.out.println("Step :: Select Pending from dropdown");
		common.log("<br></br> Step :: Select Pending From Dropdown");
		driver.findElement(By.xpath("//select[@id='c1']//option[@value='1']")).click();
		common.pause(15);
		driver.findElement(By.xpath("//tr[2]//td[3]")).click();
		common.pause(20);

		System.out.println("Step :: Enter value in textbox");
		common.log("<br></br> Step :: Enter value in textbox");
		driver.findElement(By.xpath("//input[@id='miiv15']")).sendKeys("100000");
		common.pause(5);
		System.out.println("Step :: Click on Invalid Credit!");
		common.log("<br></br> Step :: Click on Invalid Credit!");
		driver.findElement(By.xpath("//input[@id='miiv16']")).click();
		common.pause(20);

		String NoenoughCredit = driver.findElement(By.xpath("//span[@class='warning']")).getText();

		System.out.println("No enough credit! Label is :: " + NoenoughCredit);
		common.assertTwoValuesAreEqual(noEnough, NoenoughCredit);

	}

	public void Verify_Your_Credit_Have_been_Apllied_Invoice_Label(String Creditapplied) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);
		System.out.println("Step :: Select Pending from dropdown");
		common.log("<br></br> Step :: Select Pending From Dropdown");
		driver.findElement(By.xpath("//select[@id='c1']//option[@value='1']")).click();
		common.pause(15);
		driver.findElement(By.xpath("//tr[2]//td[3]")).click();
		common.pause(20);

		System.out.println("Step :: Enter value in textbox");
		common.log("<br></br> Step :: Enter value in textbox");
		driver.findElement(By.xpath("//input[@id='miiv15']")).clear();
		driver.findElement(By.xpath("//input[@id='miiv15']")).sendKeys("10");
		common.pause(5);
		System.out.println("Step :: Click on Apply Credit");
		common.log("<br></br> Step :: Click on Apply Credit");
		driver.findElement(By.xpath("//input[@id='miiv16']")).click();
		common.pause(20);

		String applycredit = driver.findElement(By.xpath("//div[@class='invoice-credit-success']")).getText();

		System.out.println(
				"%s of your credits have been applied to this invoice. Your new credit balance is %s. Label is :: "
						+ applycredit);
		common.assertTwoValuesAreEqual(Creditapplied, applycredit);

	}

	public void Verify_Payments_Made_Invoice_Label(String paymentsMade) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);
		System.out.println("Step :: Select Pending from dropdown");
		common.log("<br></br> Step :: Select Pending From Dropdown");
		driver.findElement(By.xpath("//select[@id='c1']//option[@value='1']")).click();
		common.pause(15);
		driver.findElement(By.xpath("//tr[2]//td[3]")).click();
		common.pause(20);

		String paymentmade = driver.findElement(By.xpath("//span[contains(text(),'" + paymentsMade + "')]")).getText();

		System.out.println("Payments made label is :: " + paymentmade);
		common.assertTwoValuesAreEqual(paymentsMade, paymentmade);

	}

	public void Verify_Shipping_Information_Invoice_Label(String shipping) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);
		System.out.println("Step :: Select Pending from dropdown");
		common.log("<br></br> Step :: Select Pending From Dropdown");
		driver.findElement(By.xpath("//select[@id='c1']//option[@value='1']")).click();
		common.pause(15);
		driver.findElement(By.xpath("//tr[2]//td[3]")).click();
		common.pause(20);

		String ship = driver.findElement(By.xpath("//em[contains(text(),'" + shipping + ":')]")).getText();

		System.out.println("Shipping Information label is :: " + ship);

	}

	public void Verify_Apply_Coupon_Invoice_Label(String applyCoupon) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);
		System.out.println("Step :: Select Pending from dropdown");
		common.log("<br></br> Step :: Select Pending From Dropdown");
		driver.findElement(By.xpath("//select[@id='c1']//option[@value='1']")).click();
		common.pause(15);
		driver.findElement(By.xpath("//tr[2]//td[3]")).click();
		common.pause(20);

		String applyCoupon1 = driver.findElement(By.xpath("//input[@id='miiv14']")).getAttribute("value");
		;

		System.out.println("Apply Coupon Label is :: " + applyCoupon1);
		common.assertTwoValuesAreEqual(applyCoupon, applyCoupon1);

	}

	public void Verify_Apply_Credits_Invoice_Label(String applyCrdit) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);
		System.out.println("Step :: Select Pending from dropdown");
		common.log("<br></br> Step :: Select Pending From Dropdown");
		driver.findElement(By.xpath("//select[@id='c1']//option[@value='1']")).click();
		common.pause(15);
		driver.findElement(By.xpath("//tr[2]//td[3]")).click();
		common.pause(20);

		String applyCredit1 = driver.findElement(By.xpath("//input[@id='miiv16']")).getAttribute("value");

		System.out.println("Apply Credits Label is :: " + applyCredit1);
		common.assertTwoValuesAreEqual(applyCrdit, applyCredit1);

	}

	public void Verify_Coupon_Code_Invoice_Label(String cpnCode) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);
		System.out.println("Step :: Select Pending from dropdown");
		common.log("<br></br> Step :: Select Pending From Dropdown");
		driver.findElement(By.xpath("//select[@id='c1']//option[@value='1']")).click();
		common.pause(15);
		driver.findElement(By.xpath("//tr[2]//td[3]")).click();
		common.pause(20);

		String coupnCode = driver.findElement(By.xpath("//input[@placeholder='" + cpnCode + "']"))
				.getAttribute("placeholder");

		System.out.println("Coupon Code? Label is :: " + coupnCode);
		common.assertTwoValuesAreEqual(cpnCode, coupnCode);

	}

	public void Verify_Coupon_Code_Invalid_Invoice_Label(String cpnCodeInvalid) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);
		System.out.println("Step :: Select Pending from dropdown");
		common.log("<br></br> Step :: Select Pending From Dropdown");
		driver.findElement(By.xpath("//select[@id='c1']//option[@value='1']")).click();
		common.pause(15);
		driver.findElement(By.xpath("//tr[2]//td[3]")).click();
		common.pause(20);

		driver.findElement(By.xpath("//input[@id='miiv13']")).sendKeys("abc12345");
		driver.findElement(By.xpath("//input[@id='miiv14']")).click();
		common.pause(15);
		String coupnCode = driver.findElement(By.xpath("//span[@class='warning']")).getText();

		System.out.println("Coupon code invalid Label is :: " + coupnCode);
		common.assertTwoValuesAreEqual(cpnCodeInvalid, coupnCode);

	}

	public void Verify_Coupon_Code_required_Invoice_Label(String cpnCodeRequired) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);
		System.out.println("Step :: Select Pending from dropdown");
		common.log("<br></br> Step :: Select Pending From Dropdown");
		driver.findElement(By.xpath("//select[@id='c1']//option[@value='1']")).click();
		common.pause(15);
		driver.findElement(By.xpath("//tr[2]//td[3]")).click();
		common.pause(20);

		driver.findElement(By.xpath("//input[@id='miiv14']")).click();
		common.pause(15);
		String coupnCode = driver.findElement(By.xpath("//span[@class='warning']")).getText();

		System.out.println("Coupon code required Label is :: " + coupnCode);
		common.assertTwoValuesAreEqual(cpnCodeRequired, coupnCode);

	}

	public void Verify_Pay_Via_Authorize_Net_Invoice_Label(String payViaAuthorize) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);
		System.out.println("Step :: Select Pending from dropdown");
		common.log("<br></br> Step :: Select Pending From Dropdown");
		driver.findElement(By.xpath("//select[@id='c1']//option[@value='1']")).click();
		common.pause(15);
		driver.findElement(By.xpath("//tr[2]//td[3]")).click();
		common.pause(20);

		driver.findElement(By.xpath("//input[@id='miiv3']")).click();
		common.pause(15);
		String payViaAuthorize1 = driver.findElement(By.xpath("//input[@id='miiv6']")).getAttribute("value");

		System.out.println("Pay via Authorize.net Label is :: " + payViaAuthorize1);

	}

	public void Verify_PDF_Invoice_Invoice_Label(String pdf) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);
		driver.findElement(By.xpath("//tr[2]//td[3]")).click();
		common.pause(20);

		common.pause(15);
		String pdfInvoice = driver.findElement(By.xpath("//a[contains(text(),'" + pdf + "')]")).getText();

		System.out.println("PDF Invoice Label is :: " + pdfInvoice);
		common.assertTwoValuesAreEqual(pdf, pdfInvoice);

	}

	public void Verify_Printable_view_Invoice_Label(String print) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);
		driver.findElement(By.xpath("//tr[2]//td[3]")).click();
		common.pause(20);

		common.pause(15);
		String printable = driver.findElement(By.xpath("//a[contains(text(),'" + print + "')]")).getText();

		System.out.println("Printable view Label is :: " + print);
		common.assertTwoValuesAreEqual(print, print);

	}

	public void Verify_Sale_Date_MDY_Label(String saleDate) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);

		System.out.println("Step :: Select Pending from dropdown");
		common.log("<br></br> Step :: Select Pending From Dropdown");
		driver.findElement(By.xpath("//select[@id='c1']//option[@value='1']")).click();
		common.pause(15);
		driver.findElement(By.xpath("//tr[1]//td[3]")).click();
		common.pause(20);

		String str_MDY = driver.findElement(By.xpath("//div[@class='sale-date']//span[@class='value']")).getText();

		System.out.println("Sale date m/d/Y Label is :: " + str_MDY);
		common.assertTwoValuesAreEqual(saleDate, str_MDY);

	}

	public void Verify_Search_Invoice_Label(String search) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);

		String str_srch = driver.findElement(By.xpath("//label[contains(text(),'" + search + "')]")).getText();

		System.out.println("Search Label is :: " + str_srch);
		common.assertTwoValuesAreEqual(search, str_srch);

	}

	public void Verify_Show_Invoice_Label(String show) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);

		String str_shw = driver.findElement(By.xpath("//label[contains(text(),'" + show + "')]")).getText();

		System.out.println("Show Label is :: " + str_shw);
		common.assertTwoValuesAreEqual(show, str_shw);

	}

	public void Verify_All_Invoice_Label(String all) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);

		String str_All = driver.findElement(By.xpath("//select[@id='c1']//option[@value='0']")).getText();

		System.out.println("All Label is :: " + str_All);
		common.assertTwoValuesAreEqual(all, str_All);

	}

	public void Verify_Paid_Invoice_Label(String paid) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);

		String str_All = driver.findElement(By.xpath("//select[@id='c1']//option[@value='2']")).getText();

		System.out.println("All Label is :: " + str_All);
		common.assertTwoValuesAreEqual(paid, str_All);

	}

	public void Verify_Pending_Invoice_Label(String pending) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);

		String str_pending = driver.findElement(By.xpath("//select[@id='c1']//option[@value='1']")).getText();

		System.out.println("Pending Label is :: " + str_pending);
		common.assertTwoValuesAreEqual(pending, str_pending);

	}

	public void Verify_Shipped_Invoice_Label(String shipped) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);

		String str_ship = driver.findElement(By.xpath("//select[@id='c1']//option[@value='3']")).getText();

		System.out.println("Shipped Label is :: " + str_ship);
		common.assertTwoValuesAreEqual(shipped, str_ship);

	}

	public void Verify_Invoices_Invoice_Label(String invoices) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);

		String str_invoices = driver.findElement(By.xpath("//h2[contains(text(),'" + invoices + "')]")).getText();

		System.out.println("Invoices Label is :: " + str_invoices);

	}

	public void Verify_Status_Invoice_Label1(String status) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);

		String str_status = driver.findElement(By.xpath("//th[contains(text(),'" + status + "')]")).getText();

		System.out.println("Status Label is :: " + str_status);
		common.assertTwoValuesAreEqual(status, str_status);

	}

	public void Verify_Total_Column_Invoice_Label(String total) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);

		String str_total = driver.findElement(By.xpath("//th[contains(text(),'" + total + "')]")).getText();

		System.out.println("Total Label is :: " + str_total);
		common.assertTwoValuesAreEqual(total, str_total);

	}

	public void Verify_Pay_Via_CC_Epay_Label(String ccEpay) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);

		System.out.println("Step :: Select Pending from dropdown");
		common.log("<br></br> Step :: Select Pending From Dropdown");
		driver.findElement(By.xpath("//select[@id='c1']//option[@value='1']")).click();
		common.pause(15);
		driver.findElement(By.xpath("//tr[1]//td[3]")).click();
		common.pause(20);

		String str_CCepay = driver.findElement(By.xpath("//input[@name='button']")).getAttribute("value");

		System.out.println("Pay via CC (ePay) Label is :: " + str_CCepay);
		common.assertTwoValuesAreEqual(ccEpay, str_CCepay);

	}

	public void Verify_Pay_Via_Paypal_Label(String payPal) {

		common.pause(15);

		System.out.println("Step :: Click On Invoice Menu");
		common.log("<br></br> Step :: Click On Invoice Menu");
		common.pause(15);
		driver.findElement(By.xpath("//a[contains(text(),'Invoices')]")).click();
		common.pause(30);

		System.out.println("Step :: Select Pending from dropdown");
		common.log("<br></br> Step :: Select Pending From Dropdown");
		driver.findElement(By.xpath("//select[@id='c1']//option[@value='1']")).click();
		common.pause(15);
		driver.findElement(By.xpath("//tr[1]//td[3]")).click();
		common.pause(20);

		String str_paypal = driver.findElement(By.xpath("//input[@id='miiv8']")).getAttribute("value");

		System.out.println("Pay via Paypal Label is :: " + str_paypal);
		common.assertTwoValuesAreEqual(payPal, str_paypal);

	}

	/**
	 * User not found
	 * 
	 */

	public void Verify_User_Not_Found_Label(String congratsmsg) {

		common.pause(15);
		System.out.println("Step :: Click on Auction Menu");
		common.log("<br></br> Step :: Click on Auction Menu");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(15);
		System.out.println("Step :: Click On Logout");
		common.log("<br></br> Step :: Click On Logout");
		common.pause(15);
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		common.pause(15);

	}

	/**
	 * This link expire
	 * 
	 */

	public void Verify_This_Link_Expire_Label(String congratsmsg) {

		System.out.println("Step :: Click On Logout");
		common.log("<br></br> Step :: Click On Logout");
		common.pause(15);
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		common.pause(15);

		common.pause(30);
		System.out.println("Step :: Click on Search button");
		common.log("<br></br> Step :: Click on Search button");
		driver.findElement(By.xpath("//li[@title='Search']")).click();

		common.pause(10);
	}

	/**
	 * Password Required
	 * 
	 */

	public void Verify_Password_Required_Label(String pwdrequired) {

		common.pause(15);

		System.out.println("Step :: Click On Logout");
		common.log("<br></br> Step :: Click On Logout");
		common.pause(15);
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		common.pause(15);
		System.out.println("<br></br>Step :: Enter Login Details.");

		common.log("<br></br> Step :: Enter Login Details.");

		common.pause(20);
		common.waitForConditionIsElementPresent(("//input[@id='" + LEGACY_FRONT_LOGIN_TXT_USERNAME + "']"));

		System.out.println("Username ::");
		// test1.log(LogStatus.INFO, "USERNAME");
		// test.log(LogStatus.INFO, "Enter Username : ");

		common.log("<br></br>Username :: rahulqa");
		common.type("//input[@id='" + LEGACY_FRONT_LOGIN_TXT_USERNAME + "']", "rahulqa");
		common.pause(15);

		System.out.println("Step :: Click on submit button.");
		// test1.log(LogStatus.INFO, "SUBMIT");
		// test.log(LogStatus.INFO, "Click on submit button.");
		common.log("<br></br>Step :: Click on submit button");
		common.jsClick(submitbutton);

		common.pause(30);
		String forgot_str = driver.findElement(By.xpath("//span[@class='sub-titles']")).getText();

		System.out.println("Password required Label is :: " + forgot_str);
		common.pause(10);
	}

	/**
	 * Password Reset
	 * 
	 */

	public void Verify_Password_Reset_Label(String pwdrequired) {

		System.out.println("Step :: Click On Logout");
		common.log("<br></br> Step :: Click On Logout");
		common.pause(15);
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		common.pause(15);
	}

	// //////////////////////////////////////////////////////////////////////

	// Hybrid Auction

	/**
	 * Verify Image Upload Functionality
	 * 
	 * @param auctionname
	 * @return
	 * @throws AWTException
	 */

	public String verify_Image_Upload_Hybrid(String auctionname) throws AWTException

	{
		select_Hybrid_Auction(); // Select Hybrid Auction

		for (int i = 0; i < 20; i++) {

			if (common.isElementPresent("//div[@class='auclist auchome']//div//h6//a[text()=' " + auctionname + "']")) {

				common.log("<br></br> Step :: Auction is Present >> " + auctionname);
				System.out.println("Step :: Auction is Present >> " + auctionname);
				break;
			}

			else {

				common.log("<br></br> Step :: Click on Next Button");
				System.out.println("Step :: Click on Next Button");
				common.pause(20);
				driver.findElement(
						By.xpath("//div[@class='right pagintn']//span[@id='c2_ctl']//a[contains(text(),'Next')]"))
						.click();
			}

		}
		common.pause(40);
		common.highlightElement(
				"//body/div[@id='wrapper']/form[@id='AuctionList']/div[1]/div[2]/div[5]/div[1]/div[1]/ul[25]/li[3]/figure[1]/a[1]/img[1]");
		common.assertElementPresent(
				"//body/div[@id='wrapper']/form[@id='AuctionList']/div[1]/div[2]/div[5]/div[1]/div[1]/ul[25]/li[3]/figure[1]/a[1]/img[1]");
		String imagepath = driver.findElement(By.xpath(
				"//body/div[@id='wrapper']/form[@id='AuctionList']/div[1]/div[2]/div[5]/div[1]/div[1]/ul[25]/li[3]/figure[1]/a[1]/img[1]"))
				.getAttribute("src");

		System.out.println("Step :: Created Auction name >>" + auctionname);
		System.out.println("Step :: Image SRC >>" + imagepath);
		return auctionname;

	}

	/**
	 * Verify Image Upload Functionality
	 * 
	 * @param auctionname
	 * @return
	 * @throws AWTException
	 */

	public String verify_Updated_Image_Upload_Hybrid(String auctionname) throws AWTException

	{
		select_Hybrid_Auction(); // Select Hybrid Auction

		for (int i = 0; i < 20; i++) {

			if (common.isElementPresent("//div[@class='auclist auchome']//div//h6//a[text()=' " + auctionname + "']")) {

				common.log("<br></br> Step :: Auction is Present >> " + auctionname);
				System.out.println("Step :: Auction is Present >> " + auctionname);
				break;
			}

			else {

				common.log("<br></br> Step :: Click on Next Button");
				System.out.println("Step :: Click on Next Button");
				common.pause(20);
				driver.findElement(
						By.xpath("//div[@class='right pagintn']//span[@id='c2_ctl']//a[contains(text(),'Next')]"))
						.click();
			}

		}
		common.pause(40);
		String imagepath = driver.findElement(By.xpath("//div[@class='auclist auchome']//div//h6//a[text()=' "
				+ auctionname + "']//..//..//..//..//li[@class='aucimg']//img")).getAttribute("src");

		System.out.println("Step :: Created Auction name >>" + auctionname);
		System.out.println("Step :: Image SRC >>" + imagepath);
		return auctionname;

	}

	/**
	 * Select Hybrid Auction
	 * 
	 * @throws AWTException
	 * 
	 */

	public void select_Hybrid_Auction() throws AWTException

	{
		// Select Hybrid Only
		common.pause(30);
		System.out.println("Step :: Select Hybrid Only");
		common.log("<br></br> Step :: Select Hybrid Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(20);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Hybrid only']")).click();
		common.pause(30);
		// Select Auctioneer Sagar

		System.out.println("Step :: Select Sagar Auctioneer");
		common.log("<br></br> Step :: Select Sagar Auctioneer");
		driver.findElement(By.xpath("//span[@id='alf9_ctl']//..//a[@role='button']")).click();

		// Mouse Event
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Sagar']")).click();

		common.pause(30);
		System.out.println("Step :: Select 100 from dropdown");
		common.log("<br></br> Step :: Select 100 from dropdown");
		driver.findElement(By.xpath("//select[@id='" + LEGACY_USER_LST_HYBRID_SELECT_PAGE + "']//option[@value='3']"))
				.click();
		common.pause(20);
	}

	/**
	 * Select Hybrid Auction
	 * 
	 * @throws AWTException
	 * 
	 */

	public void select_Hybrid_Auction1() throws AWTException

	{

		common.pause(30);
		System.out.println("Step :: Select Hybrid Only");
		common.log("<br></br> Step :: Select Hybrid Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Hybrid only']")).click();
		common.pause(30);
		// Select Auctioneer Sagar

		System.out.println("Step :: Select Sagar Auctioneer");
		common.log("<br></br> Step :: Select Sagar Auctioneer");
		driver.findElement(By.xpath("//span[@id='alf9_ctl']//..//a[@role='button']")).click();

		// Mouse Event
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Sagar']")).click();

		System.out.println("Step :: Select 100 from dropdown");
		common.log("<br></br> Step :: Select 100 from dropdown");
		driver.findElement(By.xpath("//select[@id='" + LEGACY_USER_LST_HYBRID_SELECT_PAGE + "']//option[@value='1']"))
				.click();
		common.pause(20);
	}

	/**
	 * Verify Do not upload an image
	 * 
	 * @param auctionname
	 * @return
	 * @throws AWTException
	 */
	public String verify_Do_Not_Upload_Image_Hybrid(String auctionname) throws AWTException

	{
		select_Hybrid_Auction(); // Select Hybrid Auction

		for (int i = 0; i < 20; i++) {

			if (common.isElementPresent("//div[@class='auclist auchome']//div//h6//a[text()=' " + auctionname + "']")) {

				System.out.println("Step :: Auction is Present >> " + auctionname);
				break;
			}

			else {

				System.out.println("Step :: Click on Next Button");
				driver.findElement(By.xpath("//a[text()='Next']")).click();
			}

		}

		String imagedefaultpath = "http://'" + TEST_ENVIRONMENT + "'images/auction/0_m.jpg";
		String imagepath = driver.findElement(By.xpath("//div[@class='auclist auchome']//div//h6//a[text()=' "
				+ auctionname + "']//..//..//..//..//li[@class='aucimg']//img")).getAttribute("src");
		System.out.println("Step :: Created Auction name >>" + auctionname);
		System.out.println("Step :: Image SRC >>" + imagepath);

		System.out.println("Step :: Verify Default Image path");

		return auctionname;

	}

	/**
	 * Verify hybrid auction not present.
	 * 
	 * 
	 * @param auctionName
	 * @throws AWTException
	 */

	public void verify_Hybrid_Auction_Not_Present(String auctionname) throws AWTException

	{

		select_Hybrid_Auction(); // Select Hybrid Auction

		for (int i = 0; i < 20; i++) {

			if (!common
					.isElementPresent("//div[@class='auclist auchome']//div//h6//a[text()=' " + auctionname + "']")) {

				System.out.println("auction " + auctionname + " is not present in this page");

				common.pause(10);
				break;

			} else {

				common.pause(20);
				driver.findElement(
						By.xpath("//div[@class='right pagintn']//span[@id='c2_ctl']//a[contains(text(),'Next')]"))
						.click();
				common.pause(10);

				System.out.println("auction " + auctionname + " is not present in this page");

			}
		}
	}

	public void Verify_Hybrid_Auction_Not_Present1(String auctionname) throws AWTException

	{

		select_Hybrid_Auction(); // Select Hybrid Auction

		for (int i = 0; i < 20; i++) {

			if (!common
					.isElementPresent("//div[@class='auclist auchome']//div//h6//a[text()=' " + auctionname + "']")) {

				System.out.println("auction " + auctionname + " is not present in this page");

				common.pause(10);
				break;

			} else {

				common.pause(10);
				// driver.findElement(By.xpath("//div[@class='right
				// pagintn']//span[@id='c2_ctl']//a[contains(text(),'Next')]")).click();
				common.pause(10);

				System.out.println("auction " + auctionname + " is not present in this page");

			}
		}
	}

	/**
	 * Verify hybrid auction is present.
	 * 
	 * 
	 * @param auctionName
	 * @throws AWTException
	 */

	public void verify_Hybrid_Auction_Present(String auctionname) throws AWTException

	{

		select_Hybrid_Auction(); // Select Hybrid Auction

		for (int i = 0; i < 20; i++) {

			if (common.isElementPresent("//div[@class='auclist auchome']//div//h6//a[text()=' " + auctionname + "']")) {

				System.out.println("auction " + auctionname + " is present in this page");

				common.pause(10);

				break;
			} else {

				driver.findElement(By.xpath("//a[text()='Next']")).click();

				common.pause(10);

				System.out.println("auction " + auctionname + " is present in this page");

			}
		}
	}

	public void verify_Hybrid_Auction_Present1(String auctionname) throws AWTException

	{

		select_Hybrid_Auction(); // Select Hybrid Auction

		for (int i = 0; i < 20; i++) {

			if (common.isElementPresent("//ul[@class='auclting yura']//a[text()=' " + auctionname + "']")) {

				System.out.println("auction " + auctionname + " is present in this page");

				driver.findElement(By.xpath("//ul[@class='auclting yura']//a[text()=' " + auctionname + "']")).click();
				common.pause(10);

				break;
			} else {
				common.pause(15);
				driver.findElement(
						By.xpath("//div[@class='right pagintn']//span[@id='c2_ctl']//a[contains(text(),'Next')]"))
						.click();

				common.pause(10);

				System.out.println("auction " + auctionname + " is not present in this page");

			}
		}
	}

	/**
	 * 
	 * Goto catalog page for hybrid auction
	 * 
	 * @param auctionName
	 * @throws AWTException
	 * 
	 */

	public void goto_Catalog_Page_Hybrid(String auctionName) throws AWTException

	{

		common.pause(20);
		select_Hybrid_Auction();

		common.pause(30);

		for (int i = 0; i < 30; i++) {

			if (common.isElementPresent("//ul[@class='auclting yura']//a[text()=' " + auctionName + "']"))

			{

				common.log("auction " + auctionName + " is present in this page");
				System.out.println("auction " + auctionName + " is present in this page");

				driver.findElement(By.xpath("//ul[@class='auclting yura']//a[text()=' " + auctionName
						+ "']//..//..//..//..//a[@class='cat']")).click();

				common.log("<br></br> Step :: Click on View Catalog Button");
				System.out.println("Step :: Click on View Catalog Button");
				common.pause(15);
				break;

			} else {

				common.log("auction " + auctionName + " is not present in this page");

				System.out.println("auction " + auctionName + " is not  present in this page");

				common.log("<br></br> Step :: Click on Next Button");
				System.out.println("Step :: Click on Next Button");
				common.pause(30);

				driver.findElement(By.xpath("//span[@id='" + LEGACY_USER_LST_NEXT_PAGE + "']//a[text()='Next']"))
						.click();

				common.pause(30);

			}

		}

	}

	/**
	 * 
	 * Goto catalog page for hybrid auction
	 * 
	 * @param auctionName
	 * @throws AWTException
	 * 
	 */

	public void goto_Catalog_Page_Hybrid_Auction(String auctionName) throws AWTException

	{

		select_Hybrid_Auction();

		common.pause(30);

		for (int i = 0; i < 30; i++) {

			if (common.isElementPresent("//ul[@class='auclting yura']//a[text()=' " + auctionName + "']"))

			{

				common.log("auction " + auctionName + " is present in this page");
				System.out.println("auction " + auctionName + " is present in this page");

				driver.findElement(By.xpath("//ul[@class='auclting yura']//a[text()=' " + auctionName
						+ "']//..//..//..//..//a[@class='cat']")).click();

				common.log("<br></br> Step :: Click on View Catalog Button");
				System.out.println("Step :: Click on View Catalog Button");
				common.pause(15);
				break;

			} else {

				common.log("auction " + auctionName + " is not present in this page");

				System.out.println("auction " + auctionName + " is not  present in this page");

				common.log("<br></br> Step :: Click on Next Button");
				System.out.println("Step :: Click on Next Button");
				common.pause(30);

				driver.findElement(By.xpath("//span[@id='" + LEGACY_USER_LST_NEXT_PAGE + "']//a[text()='Next']"))
						.click();

				// driver.findElement(By.xpath("//span[@id='" + LEGACY_USER_LST_NEXT_PAGE +
				// "']//a[text()='Next']")).click();
				common.pause(30);

			}

		}

	}

	/**
	 * 
	 * 
	 * 
	 * Assign view catalog
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param na
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void verify_Category_Catalog_Hybrid(String auctionName, String saleno, String lotname)
			throws InterruptedException, AWTException {

		goto_Catalog_Page_Hybrid(auctionName); // Goto catalog page

		System.out.println("Step :: Click on LotDetails Page");
		driver.findElement(By.xpath("//a[@class='" + LEGACY_USER_LOT_TXT + "']")).click();
		common.pause(15);

		System.out.println("Step :: Verify Selected Category");
		String cat = driver.findElement(By.xpath("//section[@class='is-open tabshw']")).getText();
		System.out.println("Verify Created Category Name ::" + cat);
		common.pause(30);

		String lot = driver.findElement(By.xpath("//div[@class='tle aucdttle']")).getText();
		System.out.println("verify Created lot name ::" + lot);

	}

	/**
	 * Verify Lot Description Hybrid
	 * 
	 * @param timedauction
	 * @throws AWTException
	 */

	public void verify_Lot_Description_Hybrid(String auctionName) throws AWTException

	{

		goto_Catalog_Page_Hybrid(auctionName);

		System.out.println("Step :: Click on lot details page");
		common.log("<br></br> Step :: Click on lot details page");
		driver.findElement(By.xpath("//a[@class='" + LEGACY_USER_LOT_TXT + "']")).click();
		common.pause(20);

		String desc = driver.findElement(By.xpath("//div[@class='content ins_cnt description-info-content']"))
				.getText();
		System.out.println("Step :: Verify lot description >> " + desc);
	}

	/**
	 * Verify Lot Description Hybrid
	 * 
	 * @param timedauction
	 * @throws AWTException
	 */

	public void verify_Lot_Image_Hybrid(String auctionName) throws AWTException

	{

		goto_Catalog_Page_Hybrid(auctionName);

		System.out.println("Step :: Click on lot details page");
		common.log("<br></br> Step :: Click on lot details page");
		driver.findElement(By.xpath("//a[@class='" + LEGACY_USER_LOT_TXT + "']")).click();
		common.pause(15);

		String desc = driver.findElement(By.xpath("//img[@style='max-width: 500px; max-height: 207px;']"))
				.getAttribute("src");
		System.out.println("Step :: Verify Uploaded Image >> " + desc);
	}

	/**
	 * Verify Buy Now value is not display
	 * 
	 * @param auctionName
	 * @throws AWTException
	 */

	public void verify_Buy_Now_Value_Not_Dispaly(String auctionName) throws AWTException {

		goto_Catalog_Page_Hybrid(auctionName); // Goto Hybrid Auction

		System.out.println("Step :: Verify Buynow Value Not Display");
		common.log("<br></br> Step :: Verify Buynow Value Not Display");
	}

	/**
	 * Verify Buy Now value is display
	 * 
	 * @param auctionName
	 * @throws AWTException
	 */

	public void verify_Buy_Now_Value_Dispaly(String auctionName) throws AWTException {

		goto_Catalog_Page_Hybrid(auctionName); // Goto Hybrid Auction

		System.out.println("Step :: Verify Buynow Button Display");
		common.log("<br></br> Step :: Verify Buynow Button Display");
		common.assertElementPresent("//input[@value='Buy now!']");
		common.pause(15);

		String buynow = driver.findElement(By.xpath("//li[@class='" + LEGACY_USER_TXT_ITEM_BUY_NOW_VALUE + "']"))
				.getText();
		System.out.println("Step :: Buy Now Value >> " + buynow);
	}

	/**
	 * Verify Lot Images
	 * 
	 * @param auctionName
	 * @throws AWTException
	 */
	public void verify_Lot_Images_Hybrid(String auctionName) throws AWTException {
		goto_Catalog_Page_Hybrid(auctionName); // Goto catalog page

		System.out.println("Step :: Click on lot details page");
		common.log("<br></br> Step :: Click on lot details page");
		driver.findElement(By.xpath("//a[@class='" + LEGACY_USER_LOT_TXT + "']")).click();
		common.pause(30);

		common.assertElementPresent("//figure");
	}

	/**
	 * Verify Special TC in lot
	 * 
	 * @param auctionName
	 * @throws AWTException
	 */

	public void verify_Special_Terms(String auctionName) throws AWTException

	{

		goto_Catalog_Page_Hybrid(auctionName); // Goto Catalog Page

		common.pause(30);
		System.out.println("Step :: Click on lot details page");
		common.log("<br></br> Step :: Click on lot details page");
		driver.findElement(By.xpath("//a[@class='" + LEGACY_USER_LOT_TXT + "']")).click();
		common.pause(30);

		System.out.println("Step :: Click on Special Terms and Condition Button");
		driver.findElement(By.xpath("//input[@value='Special Terms']")).click();
		common.pause(30);
		String special_TC = driver.findElement(By.xpath("//div[@class='content ins_cnt terms-content']")).getText();
		System.out.println("Step :: Verify Special TC >> " + special_TC);
	}

	public void verify_Special_Terms1(String auctionName) throws AWTException

	{

		goto_Catalog_Page_Hybrid_Auction(auctionName); // Goto Catalog Page

		common.pause(30);
		System.out.println("Step :: Click on lot details page");
		common.log("<br></br> Step :: Click on lot details page");
		driver.findElement(By.xpath("//a[@class='" + LEGACY_USER_LOT_TXT + "']")).click();
		common.pause(30);

		System.out.println("Step :: Click on Special Terms and Condition Button");
		driver.findElement(By.xpath("//a[contains(text(),'Terms and conditions')]")).click();
		common.pause(30);
		String special_TC = driver.findElement(By.xpath("//div[@class='content ins_cnt terms-content']")).getText();
		System.out.println("Step :: Verify Special TC >> " + special_TC);
	}

	/**
	 * Legacy Login
	 * 
	 * @throws AWTException
	 * 
	 */

	public void legacy_login_for_stop_abs_at(String liveauction) throws AWTException

	{
		// Select Live Only
		common.pause(20);
		System.out.println("Step :: Select Live Only");
		common.log("<br></br> Step :: Select Live Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Live only']")).click();
		common.pause(30);
		// Select Auctioneer Sagar

		System.out.println("Step :: Select Sagar Auctioneer");
		common.log("<br></br> Step :: Select Sagar Auctioneer");
		driver.findElement(By.xpath("//span[@id='alf9_ctl']//..//a[@role='button']")).click();

		// Mouse Event
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Sagar']")).click();

		common.pause(30);

		System.out.println("Step :: Select 100 from dropdown");
		common.log("<br></br> Step :: Select 100 from dropdown");
		driver.findElement(By.xpath("//select[@id='" + LEGACY_ADMIN_LOT_TABLE + "']//option[@value='3']")).click();

		common.pause(30);

		int rowCount = driver.findElements(By.xpath("//table[@id='" + LEGACY_ADMIN_AUCTION_TABLE + "']/tbody/tr"))
				.size();

		for (int i = 0; i < rowCount; i++) {

			if (common.isElementPresent("//table[@id='" + LEGACY_ADMIN_AUCTION_TABLE + "']//tbody//tr//td//a[text()='"
					+ liveauction + "']"))

			{
				common.log("auction " + liveauction + " is present in this page");
				System.out.println("auction " + liveauction + " is present in this page");
				driver.findElement(
						By.xpath("//table[@id='" + LEGACY_ADMIN_AUCTION_TABLE + "']//tbody//tr//td//a[text()='"
								+ liveauction + "']//..//..//td//input[@value='View catalog']"))
						.click();
				common.pause(10);
				break;
			} else {
				common.log("auction " + liveauction + " is not present in this page");
				System.out.println("auction " + liveauction + " is not  present in this page");

				driver.findElement(By
						.xpath("//span[@id='" + LEGACY_ADMIN_PAGE_PAGINATION_WARNING_MESSAGE + "']//a[text()='Next']"))
						.click();
				common.pause(15);

			}

		}

	}

	/**
	 * Enter Lower than starting amount
	 * 
	 * @param lotName
	 */

	public void enter_Lower_Than_Starting_Amount(String lotName) {

		common.pause(30);
		System.out.println("Step :: Fill Bid Value");
		common.log("<br></br> Step :: Fill Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_REGULAR_LIVE_BID + "']")).clear();
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_REGULAR_LIVE_BID + "']")).sendKeys("50");
		common.pause(10);
		System.out.println("Step :: Click on Change Bid Button");
		common.log("<br></br> Step :: Click on Change Bid Button");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//input[@value='" + LEGACY_USER_BTN_CHANGE_BID + "']"))
				.click();
		common.pause(30);

		System.out.println("Step :: Verify Error Message");
		common.log("<br></br> Step :: Verify Error Message");
		String errormsg = driver.findElement(By.xpath("//span[text()='Too small amount']")).getText();
		System.out.println("Step :: Error Message >> " + errormsg);
		common.log("Step :: Error Message >> " + errormsg);
	}

	/**
	 * Place bid on live auction from livesale tab
	 * 
	 * Click on Green Bid Button
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param lotName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void verify_Out_Bid_Live_Auction(String saleno, String auctionName, String lotName)
			throws InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale_Auction(auctionName); // Goto catalog Page

		System.out.println("Step :: Click on catalog button");
		common.log("<br></br> Step :: Click on catalog button");
		common.pause(10);

		common.pause(25);
		if (!common.isElementPresent("//a[contains(text(),'Live Sale')]")) {

			driver.findElement(By.xpath("//a//span[text()='" + auctionName + "']")).click();

			common.pause(20);
			driver.findElement(By.xpath("//a[contains(text(),'View live sale now!')]")).click();
			common.pause(20);
		} else {

			driver.findElement(By.xpath("//a[contains(text(),'Live Sale')]")).click();
			common.pause(20);
		}

		// String outbid =
		// driver.findElement(By.xpath("//span[@id='btn-outbid']")).getText();
		//
		// System.out.println("Step :: Outbid Message :: " + outbid);
		// common.log("<br></br> Step :: Outbid Message :: " + outbid);

		common.pause(50);

		common.jsClick(logout);
	}

	/**
	 * Enter Lower Bid Value
	 * 
	 * @param auctionName
	 * @param lotName
	 */
	public void enter_Lower_Bid_In_Lot_Details(String auctionName, String lotName) throws AWTException {

		goto_Catalog_Page_Live_Sale_Auction(auctionName); // Click on catalog button

		common.pause(40);
		System.out.println("Step :: Click on Lot Details Page");
		common.log("<br></br> Step :: Click on Lot Details Page");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']")).click();
		common.pause(10);

		System.out.println("Step :: Fill Value");
		common.log("<br></br> Step :: Fill Value");
		driver.findElement(By.xpath("//span[@class='maxbid-curr']//..//input[@class='textbox']")).sendKeys("250");

		// driver.findElement(By.xpath("//input[@name='tmbid2600']")).click();
		// driver.findElement(By.xpath("//input[@name='tmbid2600']")).sendKeys("250");
		common.pause(25);
		System.out.println("Step :: Click on place bid button");
		common.log("<br></br> Step :: Click on place bid button");
		driver.findElement(By.xpath("//input[@value='Place bid!']")).click();
		common.pause(25);

		System.out.println("Step :: Fill lower Value");
		common.log("<br></br> Step :: Fill lower Value");
		driver.findElement(By.xpath("//span[@class='maxbid-curr']//..//input[@class='textbox']")).click();
		driver.findElement(By.xpath("//span[@class='maxbid-curr']//..//input[@class='textbox']")).clear();
		driver.findElement(By.xpath("//span[@class='maxbid-curr']//..//input[@class='textbox']")).sendKeys("80");

		System.out.println("Step :: Click on change bid button");
		common.log("<br></br> Step :: Click on change bid button");
		driver.findElement(By.xpath("//input[@value='Change bid!']")).click();
		common.pause(30);

		String errormsg = driver.findElement(By.xpath("//span[contains(text(),'Too small amount')]")).getText();
		System.out.println("Step :: Lot Details Message >> " + errormsg);

	}

	/**
	 * Alternative Post Bid Timed Sale User 1 Bid
	 * 
	 * @param TimedAuction
	 * @param lotName
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public void Alternative_Post_Bid_Timed_Sale(String TimedAuction, String lotName)
			throws AWTException, InterruptedException

	{
		goto_Catalog_Page_Timed_Sale(TimedAuction);

		common.pause(40);
		common.refreshPage();
		common.pause(30);

		String Askingbid = driver.findElement(By.xpath("//li[@class='" + LEGACY_USER_TXT_ITEM_ASKING + "']")).getText();
		System.out.println("Step :: Asking Bid >> " + Askingbid);
		common.log("<br></br> Step :: Asking Bid >> " + Askingbid);

		System.out.println("Step :: Fill Place bid value");
		common.log("<br></br> Step :: Fill Place  bid value");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//input[@class='" + LEGACY_USER_TXT_TIMED_MAX_BID + "']"))
				.sendKeys("10");
		common.pause(15);

		System.out.println("Step :: Click on Placebid Button");
		common.log("<br></br> Step :: Click on Placebid Button");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']"))
				.click();
		common.pause(20);

		common.log("<br></br> Step :: Click on confirm button");
		System.out.println("Step :: Click on confirm button");
		driver.findElement(By.xpath("//input[@value='" + LEGACY_USER_BTN_CONFIRM + "']")).click();
		// common.pause(10);
		// common.acceptAlert1();
		common.pause(20);

		String Askingbid1 = driver.findElement(By.xpath("//li[@class='" + LEGACY_USER_TXT_ITEM_ASKING + "']"))
				.getText();

		System.out.println("Step :: Asking Bid >> " + Askingbid1);
		common.log("<br></br> Step :: Asking Bid >> " + Askingbid1);

		common.pause(15);

	}

	/**
	 * Alternative Post Bid Timed Sale User 1 Bid
	 * 
	 * @param TimedAuction
	 * @param lotName
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public void Alternative_Post_Bid_Timed_Sale_Bid_20(String TimedAuction, String lotName)
			throws AWTException, InterruptedException

	{
		goto_Catalog_Page_Timed_Sale(TimedAuction);

		common.pause(15);

		String Askingbid = driver.findElement(By.xpath("//li[@class='" + LEGACY_USER_TXT_ITEM_ASKING + "']")).getText();
		System.out.println("Step :: Asking Bid >> " + Askingbid);
		common.log("<br></br> Step :: Asking Bid >> " + Askingbid);

		System.out.println("Step :: Fill Place bid value");
		common.log("<br></br> Step :: Fill Place  bid value");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//input[@class='" + LEGACY_USER_TXT_TIMED_MAX_BID + "']"))
				.sendKeys("20");
		common.pause(15);

		System.out.println("Step :: Click on Placebid Button");
		common.log("<br></br> Step :: Click on Placebid Button");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']"))
				.click();
		common.pause(15);

		common.log("<br></br> Step :: Click on confirm button");
		System.out.println("Step :: Click on confirm button");
		driver.findElement(By.xpath("//input[@value='" + LEGACY_USER_BTN_CONFIRM + "']")).click();
		// common.acceptAlert1();
		common.pause(15);

		String Askingbid1 = driver.findElement(By.xpath("//li[@class='" + LEGACY_USER_TXT_ITEM_ASKING + "']"))
				.getText();

		System.out.println("Step :: Asking Bid >> " + Askingbid1);
		common.log("<br></br> Step :: Asking Bid >> " + Askingbid1);

		common.pause(15);

	}

	/**
	 * Alternative Post Bid Timed Sale User 1 Bid
	 * 
	 * @param TimedAuction
	 * @param lotName
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public void Alternative_Post_Bid_Timed_Sale_100(String TimedAuction, String lotName)
			throws AWTException, InterruptedException

	{
		goto_Catalog_Page_Timed_Sale(TimedAuction);

		common.pause(15);

		String Askingbid = driver.findElement(By.xpath("//li[@class='" + LEGACY_USER_TXT_ITEM_ASKING + "']")).getText();
		System.out.println("Step :: Asking Bid >> " + Askingbid);
		common.log("<br></br> Step :: Asking Bid >> " + Askingbid);

		System.out.println("Step :: Fill Place bid value");
		common.log("<br></br> Step :: Fill Place  bid value");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//input[@class='" + LEGACY_USER_TXT_TIMED_MAX_BID + "']"))
				.clear();
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//input[@class='" + LEGACY_USER_TXT_TIMED_MAX_BID + "']"))
				.sendKeys("100");
		common.pause(15);

		System.out.println("Step :: Click on Placebid Button");
		common.log("<br></br> Step :: Click on Placebid Button");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//input[@value='" + LEGACY_USER_BTN_CHANGE_BID + "']"))
				.click();
		common.pause(15);

		common.log("<br></br> Step :: Click on confirm button");
		System.out.println("Step :: Click on confirm button");
		driver.findElement(By.xpath("//input[@value='" + LEGACY_USER_BTN_CONFIRM + "']")).click();
		common.pause(10);

		// common.acceptAlert1();
		common.pause(15);

		String Askingbid1 = driver.findElement(By.xpath("//li[@class='" + LEGACY_USER_TXT_ITEM_ASKING + "']"))
				.getText();

		System.out.println("Step :: Asking Bid >> " + Askingbid1);
		common.log("<br></br> Step :: Asking Bid >> " + Askingbid1);

		System.out.println("Step :: Verify Asking Bid >> " + Askingbid1);
		common.log("<br></br> Step :: Verify Asking Bid >> " + Askingbid1);
		common.pause(15);

	}

	/**
	 * Place bid on Hybrid Auction
	 * 
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param lotName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void place_Bid_On_Hybrid_Auction(String auctionName) throws InterruptedException, AWTException {

		goto_Catalog_Page_Hybrid(auctionName); // Goto catalog Page

		System.out.println("Step :: Click on catalog button");
		common.log("<br></br> Step :: Click on catalog button");
		common.pause(10);

		System.out.println("Step :: Click on Live Sale tab");
		common.log("<br></br> Step :: Click on Live Sale tab");

		common.pause(25);
		if (!common.isElementPresent("//a[contains(text(),'Live Sale')]")) {

			driver.findElement(By.xpath("//a//span[text()='" + auctionName + "']")).click();

			common.pause(20);
			driver.findElement(By.xpath("//a[contains(text(),'View live sale now!')]")).click();
			common.pause(20);
		} else {

			driver.findElement(By.xpath("//a[contains(text(),'Live Sale')]")).click();
			common.pause(20);
		}

		System.out.println("Step :: Click on bid button");
		common.log("<br></br> Step :: Click on bid button");
		common.waitForElement("//a[@id='" + LEGACY_FRONT_LOGIN_BTN_BID + "']");
		common.jsClick(placebidhybrid);

		System.out.println("Step :: Button Clicked");
		common.pause(15);

		String usermessage = driver.findElement(By.xpath("//div[@class='messages']")).getText();

		System.out.println("Step :: Message center\n :: " + usermessage);
		common.log("<br></br> Step :: Message center\n :: " + usermessage);

		common.pause(15);

		// common.jsClick(logout);
	}

	/**
	 * Place bid on Hybrid Auction
	 * 
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param lotName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void place_Bid_On_Hybrid_Auction1(String auctionName) throws InterruptedException, AWTException {

		goto_Catalog_Page_Hybrid(auctionName); // Goto catalog Page

		System.out.println("Step :: Click on catalog button");
		common.log("<br></br> Step :: Click on catalog button");
		common.pause(30);

		System.out.println("Step :: Click on Live Sale link");
		common.log("<br></br>Step :: Click on Live Sale link");

		common.pause(25);
		if (!common.isElementPresent("//a[contains(text(),'Live Sale')]")) {

			driver.findElement(By.xpath("//a//span[text()='" + auctionName + "']")).click();

			common.pause(20);
			driver.findElement(By.xpath("//a[contains(text(),'View live sale now!')]")).click();
			common.pause(20);
		} else {

			driver.findElement(By.xpath("//a[contains(text(),'Live Sale')]")).click();
			common.pause(20);
		}

		System.out.println("Step :: Click on bid button");
		common.log("<br></br> Step :: Click on bid button");
		common.waitForElement("//a[@id='" + LEGACY_FRONT_LOGIN_BTN_BID + "']");
		common.jsClick(placebidhybrid);

		System.out.println("Step :: Button Clicked");
		common.pause(15);

		String usermessage = driver.findElement(By.xpath("//div[@class='messages']")).getText();

		System.out.println("Step :: Message center\n :: " + usermessage);
		common.log("<br></br> Step :: Message center\n :: " + usermessage);

		common.pause(15);

		// common.jsClick(logout);
	}

	/**
	 * Place absentee bid from catalog page
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param lotName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void place_Absenteebid_Hybrid(String saleno, String auctionName, String lotName)
			throws InterruptedException, AWTException {

		goto_Catalog_Page_Hybrid(auctionName); // Goto catalog page

		System.out.println("Step :: Click on catalog button");
		common.log("<br></br> Step :: Click on catalog button");
		common.pause(25);

		System.out.println("Step :: Fill absentee bid value");
		common.log("<br></br> Step :: Fill absentee bid value");

		common.pause(20);

		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_REGULAR_LIVE_BID + "']")).sendKeys(LEGACY_USER_TXT_ABSENTEE_BID_VALUE);

		System.out.println("Step :: Click on placebid button");
		common.log("<br></br> Step :: Click on placebid button");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']"))
				.click();
		common.pause(25);

//		System.out.println("Step :: Click on Confirm Button");
//		common.log("<br></br> Step :: Click on Confirm button");
//		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_PLACE_MULTIBID_CONFIRM + "']")).click();
//		common.pause(10);
		common.acceptAlert();
		common.jsClick(logout);
	}

	/**
	 * Verify live sale tab does not display
	 * 
	 * @param saleno
	 * @param auctionName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void verify_Bidding_Pause_Hybrid(String saleno, String auctionName)
			throws InterruptedException, AWTException {

		goto_Catalog_Page_Hybrid_Auction(auctionName);

		System.out.println("Step :: Click on Live Sale tab");
		common.log("<br></br> Step :: Click on Live Sale tab");

		for (int i = 0; i < 5; i++) {

			if (common.isElementDisplayed("//div//a[text()='Bidding paused']")) {

				common.assertElementPresent("//div//a[text()='Bidding paused']");
				System.out.println("Step :: Bidding Pause Displays");
				common.log("<br></br> Step :: Bidding Pause Dispalys");
				break;

			} else {

				System.out.println("Step :: Check Again");
				common.log("<br></br> Step :: Check Again");

			}

		}

		common.pause(15);

		common.jsClick(logout);
	}

	/**
	 * 
	 * Verify Green bid button Enable
	 * 
	 * @param saleno
	 * @param auctionName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void livesaletab_Bid_Buttonenable_Hybrid(String saleno, String auctionName)
			throws InterruptedException, AWTException {

		goto_Catalog_Page_Hybrid(auctionName); // Goto catalog page

		System.out.println("Step :: Click on Live Sale tab");
		common.log("<br></br> Step :: Click on Live Sale tab");

		common.pause(25);
		if (!common.isElementPresent("//a[contains(text(),'Live Sale')]")) {

			driver.findElement(By.xpath("//a//span[text()='" + auctionName + "']")).click();

			common.pause(20);
			driver.findElement(By.xpath("//a[contains(text(),'View live sale now!')]")).click();
			common.pause(20);
		} else {

			driver.findElement(By.xpath("//a[contains(text(),'Live Sale')]")).click();
			common.pause(20);
		}

		common.waitForConditionIsElementPresent("//a[@id='" + LEGACY_FRONT_LOGIN_BTN_BID + "']");

		common.pause(15);
		common.jsClick(logout);

		common.pause(10);
	}

	/**
	 * 
	 * Verify Lot in order
	 */

	public void verify_Lot_In_Order() {

		common.pause(20);
		List<WebElement> list = driver.findElements(By.xpath("//a[@class='" + LEGACY_USER_LOT_TXT + "']"));
		List<String> lotname = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {

			System.out.println("Lot name::");
			lotname.add(list.get(0).getText());
			System.out.println(list.get(i).getText());
		}

		common.pause(20);

	}

	/**
	 * Search Lot Category
	 * 
	 * @param lotname
	 */

	public void search_Lot_Category(String lotname) {

		common.pause(10);
		common.log("<br></br> Step :: Click on Auction link");
		System.out.println("Step :: Click on Auction link");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_ADMIN_AUCTION_TAB + "']")).click();
		common.pause(30);

		// input[@id='btnSearch']
		driver.findElement(By.xpath("//header/nav[1]/ul[1]/li[1]/a[1]")).click();
		common.pause(10);
		common.log("<br></br> Step :: Search Auction by category");
		System.out.println("Step :: Search Auction by category ");
		driver.findElement(By.xpath("//input[@id='txtSearch']")).sendKeys("cat2");

		common.log("<br></br> Step :: Click on Search Button");
		System.out.println("Step :: Click on Search Button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_CATEGORY_SEARCH_BTN + "']")).click();
		common.pause(25);

		System.out.println("Step :: Select page from dropdown");
		common.log("<br></br> Step :: Select page from dropdown");
		driver.findElement(By.xpath("//span[@id='lstPageTop_ctl']")).click();
		common.pause(20);
		driver.findElement(By.xpath("//select[@id='" + LEGACY_USER_LOT_DROPDOWN + "']//option[@value='2']")).click();
		common.pause(15);

		System.out.println("Step ::Clear keyword");
		common.log("<br></br> Step :: Clear keyword");
		driver.findElement(By.xpath("//input[@placeholder='Keywords']")).clear();
		common.pause(15);

		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath(
				"//body/div[@id='wrapper']/form[@id='AdvancedSearch']/div[1]/article[1]/section[1]/div[3]/div[2]/div[1]/div[2]"))
				.click();
		common.pause(25);

		System.out.println("Step :: Select cat 2");
		common.log("<br></br> Step :: Select cat 2");
		driver.findElement(By.xpath("//div//span[text()='Categories']")).click();
		common.pause(20);
		driver.findElement(By.xpath("//label[contains(text(),'cat2')]")).click();

		common.pause(20);
		System.out.println("Step :: Click on Search Button");
		common.log("<br></br> Step :: Click on Search Button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_FRONT_BTN_ADVANCE_SEARCH + "']")).click();

		common.pause(40);
		System.out.println("Step :: Select 100 from page DD");
		common.log("<br></br> Step :: Select 100 from page DD");
		driver.findElement(By.xpath("//select[@id='lstPageTop']//option[@value='3']")).click();
		common.pause(40);

		System.out.println("Step :: Click on lot name : " + lotname);
		common.log("<br></br> Step :: Click on lot name : " + lotname);

		System.out.println("Step :: Click on lot details");
		common.log("<br></br> Step :: Click on lot details");
		common.waitForElement(By.xpath("//a[text()='" + lotname + "']"));
		driver.findElement(By.xpath("//a[text()='" + lotname + "']")).click();
		common.pause(40);
		System.out.println("Step :: Verify Selected Category");
		String cat = driver.findElement(By.xpath("//span[text()='Categories:']//..//a[@class='category-link']"))
				.getText();
		System.out.println("Verify Created Category Name ::" + cat);
		common.pause(10);
	}

	/**
	 * Search Lot Category
	 * 
	 * @param lotname
	 */

	public void Search_Lot_Category_2_3(String lotname) {

		common.log("<br></br> Step :: Click on Auction link");
		System.out.println("Step :: Click on Auction link");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(15);

		driver.findElement(By.xpath("//header/nav[1]/ul[1]/li[1]/a[1]")).click();
		common.pause(10);
		common.log("<br></br> Step :: Search Auction by category");
		System.out.println("Step :: Search Auction by category ");
		driver.findElement(By.xpath("//input[@id='txtSearch']")).sendKeys("cat2");

		common.log("<br></br> Step :: Click on Search Button");
		System.out.println("Step :: Click on Search Button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_CATEGORY_SEARCH_BTN + "']")).click();
		common.pause(25);

		System.out.println("Step :: Select page from dropdown");
		common.log("<br></br> Step :: Select page from dropdown");
		driver.findElement(By.xpath("//select[@id='" + LEGACY_USER_LOT_DROPDOWN + "']//option[@value='2']")).click();
		common.pause(15);

		System.out.println("Step ::Clear keyword");
		common.log("<br></br> Step :: Clear keyword");
		driver.findElement(By.xpath("//input[@placeholder='Keywords']")).clear();
		common.pause(15);

		System.out.println("Step :: Click on advance search");
		common.log("<br></br> Step :: Click on advance search");
		driver.findElement(By.xpath(
				"//body/div[@id='wrapper']/form[@id='AdvancedSearch']/div[1]/article[1]/section[1]/div[3]/div[2]/div[1]/div[2]"))
				.click();
		common.pause(25);

		System.out.println("Step :: Select category 3");
		common.log("<br></br> Step :: Select category 3");
		driver.findElement(By.xpath("//div//span[text()='Categories']")).click();
		common.pause(20);
		driver.findElement(By.xpath("//label[contains(text(),'category3')]")).click();

		common.pause(20);
		System.out.println("Step :: Select category 3");
		common.log("<br></br> Step :: Select category 3");
		driver.findElement(By.xpath("//label[contains(text(),'@#$%^&*')]")).click();
		common.pause(20);

		System.out.println("Step :: Click on Search Button");
		common.log("<br></br> Step :: Click on Search Button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_FRONT_BTN_ADVANCE_SEARCH + "']")).click();
		common.pause(20);

		System.out.println("Step :: Lot Display >> " + lotname);
		System.out.println("Step :: Select 100 from page DD");
		common.log("<br></br> Step :: Select 100 from page DD");
		driver.findElement(By.xpath("//select[@id='lstPageTop']//option[@value='3']")).click();
		common.pause(40);

		for (int i = 0; i < 20; i++)

		{
			if (common.isElementPresent("//h2//a[text()='" + lotname + "']")) {

				System.out.println("Step :: Lot Display >> " + lotname);
				break;

			} else {

				System.out.println("Step :: Lot Not Display and click on next button");
				driver.findElement(By.xpath("//span[@class='paginator']//..[text()='Next']")).click();
				break;
			}

		}

		System.out.println("Step :: Click on lot details");
		common.log("<br></br> Step :: Click on lot details");
		driver.findElement(By.xpath("//section[@class='item-block-wrapper']//a[text()='" + lotname + "']")).click();

		String cat = driver.findElement(By.xpath("//span[text()='Categories:']//..//a[@class='category-link']"))
				.getText();
		System.out.println("Step :: Verify Selected Category >> " + cat);
		common.pause(10);
	}

	/**
	 * Place absentee bid from catalog page
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param lotName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void place_Absenteebid_Hybrid_500(String saleno, String auctionName, String lotName)
			throws InterruptedException, AWTException {

		goto_Catalog_Page_Hybrid(auctionName); // Goto catalog page

		System.out.println("Step :: Click on catalog button");
		common.log("<br></br> Step :: Click on catalog button");
		common.pause(25);

		System.out.println("Step :: Fill absentee bid value");
		common.log("<br></br> Step :: Fill absentee bid value");

		common.pause(20);

		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_REGULAR_LIVE_BID + "']")).sendKeys("500");

		System.out.println("Step :: Click on placebid button");
		common.log("<br></br> Step :: Click on placebid button");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']"))
				.click();
		common.pause(20);
		common.acceptAlert();
//		System.out.println("Step :: Click on Confirm Button");
//		common.log("<br></br> Step :: Click on Confirm button");
//		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_PLACE_MULTIBID_CONFIRM + "']")).click();
		common.pause(20);

		common.jsClick(logout);
	}

	/**
	 * 
	 * Verify chat screen in Hybrid auction
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param lotName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void verify_Chat_Message_Hybrid(String saleno, String auctionName, String lotName)
			throws InterruptedException, AWTException {

		goto_Catalog_Page_Hybrid(auctionName); // Goto catalog page

		System.out.println("Step :: Click on catalog button");
		common.log("<br></br> Step :: Click on catalog button");
		common.pause(30);

		System.out.println("Step :: Click on Live Sale link");
		common.log("<br></br>Step :: Click on Live Sale link");

		if (common.isElementPresent("//a[contains(text(),'Live Sale')]")) {
			driver.findElement(By.xpath("//a[contains(text(),'Live Sale')]")).click();
			common.pause(30);
		} else {
			driver.findElement(By.xpath("//body/div[@id='wrapper']/div[1]/ol[1]/li[3]/a[1]/span[1]")).click();
			common.pause(20);
			driver.findElement(By.xpath("//a[contains(text(),'View live sale now!')]")).click();
			common.pause(30);
		}

		String usermessage = driver.findElement(By.xpath("//div[@class='messages']")).getText();

		System.out.println("Step :: Message center\n :: " + usermessage);
		common.log("<br></br> Step :: Message center\n :: " + usermessage);
		common.pause(5);
		common.jsClick(logout);
	}

	/**
	 * 
	 * Verify chat screen in Hybrid auction
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param lotName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void verify_Chat_Message_Hybrid1(String saleno, String auctionName, String lotName)
			throws InterruptedException, AWTException {

		goto_Catalog_Page_Hybrid(auctionName); // Goto catalog page

		System.out.println("Step :: Click on catalog button");
		common.log("<br></br> Step :: Click on catalog button");
		common.pause(20);

		System.out.println("Step :: Click on Live Sale link");
		common.log("<br></br>Step :: Click on Live Sale link");

		common.pause(25);
		if (!common.isElementPresent("//a[contains(text(),'Live Sale')]")) {

			driver.findElement(By.xpath("//a//span[text()='" + auctionName + "']")).click();

			common.pause(20);
			driver.findElement(By.xpath("//a[contains(text(),'View live sale now!')]")).click();
			common.pause(20);
		} else {

			driver.findElement(By.xpath("//a[contains(text(),'Live Sale')]")).click();
			common.pause(20);
		}

		String usermessage = driver.findElement(By.xpath("//div[@class='messages']")).getText();

		System.out.println("Step :: Message center\n :: " + usermessage);
		common.log("<br></br> Step :: Message center\n :: " + usermessage);
		common.pause(5);
		common.jsClick(logout);
	}

	/**
	 * Place absentee bid from catalog page
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param lotName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void Place_Absenteebid_Hybrid(String auctionName, String lotName) throws InterruptedException, AWTException {

		goto_Catalog_Page_Hybrid(auctionName); // Goto catalog page

		System.out.println("Step :: Click on catalog button");
		common.log("<br></br> Step :: Click on catalog button");
		common.pause(25);

		System.out.println("Step :: Fill absentee bid value");
		common.log("<br></br> Step :: Fill absentee bid value");

		common.pause(20);

		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_REGULAR_LIVE_BID + "']")).sendKeys(LEGACY_USER_TXT_ABSENTEE_BID_VALUE);

		System.out.println("Step :: Click on placebid button");
		common.log("<br></br> Step :: Click on placebid button");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']"))
				.click();
		common.pause(20);
		common.acceptAlert();

//		System.out.println("Step :: Click on Confirm Button");
//		common.log("<br></br> Step :: Click on Confirm button");
//		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_PLACE_MULTIBID_CONFIRM + "']")).click();
//		common.pause(10);

		// common.acceptAlert1();

		common.jsClick(logout);
	}

	/**
	 * Place absentee bid from catalog page for 2 user (Higher than 1st bidder)
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param lotName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void Place_Higher_Absentee_Hybrid(String auctionName, String lotName)
			throws InterruptedException, AWTException {

		goto_Catalog_Page_Hybrid(auctionName); // Goto catalog page

		System.out.println("Step :: Click on catalog button");
		common.log("<br></br> Step :: Click on catalog button");
		common.pause(25);

		// common.waitForConditionIsElementPresent("//div[@class='buy-now']");

		System.out.println("Step :: Fill absentee bid value");
		common.log("<br></br> Step :: Fill absentee bid value");

		common.pause(20);

		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_REGULAR_LIVE_BID + "']")).sendKeys("250");

		System.out.println("Step :: Click on placebid button");
		common.log("<br></br> Step :: Click on placebid button");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']"))
				.click();
		common.pause(20);
		common.acceptAlert();

		common.pause(10);
		System.out.println("Step :: Confirm bid");
		common.log("<br></br> Step :: Confirm bid");
		driver.findElement(By.xpath("//input[@id='pblc2']")).click();

		common.pause(10);

		logoutfrontuser();

	}

	/**
	 * Place absentee bid from catalog page
	 * 
	 * @param saleno
	 * @param auctionName
	 * @param lotName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void Place_Absenteebid_Hybrid_ListView(String auctionName, String lotName)
			throws InterruptedException, AWTException {

		goto_Catalog_Page_Hybrid(auctionName); // Goto catalog page

		System.out.println("Step :: Click on List View");
		common.log("<br></br> Step :: Click on List View");
		common.pause(15);

		if (!common.isElementPresent("//a[@class='lst  current']")) {

			System.out.println("Step :: Click on List View");
			common.log("<br></br> Step :: Click on List View");
			driver.findElement(By.xpath("//a[@class='lst ']")).click();
		}

		System.out.println("Step :: Fill absentee bid value");
		common.log("<br></br> Step :: Fill absentee bid value");

		common.pause(20);

		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_REGULAR_LIVE_BID + "']")).sendKeys(LEGACY_USER_TXT_ABSENTEE_BID_VALUE);

		System.out.println("Step :: Click on placebid button");
		common.log("<br></br> Step :: Click on placebid button");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']"))
				.click();
		common.pause(15);

		// System.out.println("Step :: Click on Confirm Button");
		// common.log("<br></br> Step :: Click on Confirm button");
		// driver.findElement(By.xpath("//input[@id='" +
		// LEGACY_USER_BTN_PLACE_MULTIBID_CONFIRM + "']")).click();
		// common.pause(10);

		common.acceptAlert();

		common.jsClick(logout);
	}

	public void verify_Two_Chat_Window_Simultaneously_Auction_Live_Sale(String auctionName) throws AWTException

	{

		goto_Catalog_Page_Live_Sale(auctionName); // Goto catalog page

		common.pause(20);
		System.out.println("Step :: Click on Live Sale link");
		common.log("<br></br>Step :: Click on Live Sale link");

		common.pause(25);
		if (!common.isElementPresent("//a[contains(text(),'Live Sale')]")) {

			driver.findElement(By.xpath("//a//span[text()='" + auctionName + "']")).click();

			common.pause(20);
			driver.findElement(By.xpath("//a[contains(text(),'View live sale now!')]")).click();
			common.pause(20);
		} else {

			driver.findElement(By.xpath("//a[contains(text(),'Live Sale')]")).click();
			common.pause(20);
		}

		String msg = driver.findElement(By.xpath("//div[@class='sound']")).getText();
		System.out.println("Step :: Message Center 1 >> " + msg);
		common.pause(15);

	}

	/**
	 * Place Bid From Lot Details Timed Auction
	 * 
	 * @param auctionName
	 * @param lotName
	 * @throws AWTException
	 * @throws InterruptedException
	 */

	public void place_TimedBid_Lotdetails(String auctionName, String lotName) throws AWTException, InterruptedException

	{

		goto_Catalog_Page_Timed_Sale(auctionName); // Goto catalog page

		System.out.println("Step :: Click on Lot Details Page");
		common.log("<br></br> Step :: Click on Lot Details Page");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']")).click();
		common.pause20Sec();

		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//input[@class='"+LEGACY_USER_BID_VALUE+"']")).sendKeys("300");
		common.pause20Sec();

		System.out.println("Step :: Click on Place bid Button");
		common.log("<br></br> Step :: Click on Place Bid Button");
		driver.findElement(By.xpath("//input[@value='"+LEGACY_USER_BTN_PLACE_BID+"']")).click();
		common.pause20Sec();

		common.highlightElement("//span[@class='"+LEGACY_USER_TXT_WINNING_MESSAGE+"']");
		common.assertElementPresent("//span[@class='"+LEGACY_USER_TXT_WINNING_MESSAGE+"']");
		String Highbid = driver.findElement(By.xpath("//span[@class='"+LEGACY_USER_TXT_WINNING_MESSAGE+"']")).getText();
		System.out.println("Step :: Verify Success Message >> " + Highbid);
		common.log("<br></br> Step :: Verify Success Message >> " + Highbid);

	}

	/**
	 * Place Bid Timed Auction
	 * 
	 * @param auctionName
	 * @param lotName
	 * @throws AWTException
	 * @throws InterruptedException
	 */

	public void Place_Bid_Timedsale_With_Bidder_Rahul_Qa(String auctionName) throws AWTException, InterruptedException

	{

		Goto_Catalog_Page_Timed_Sale_for_All_Auctioneers(auctionName); // Goto catalog page
		common.pause(10);
		System.out.println("Step :: Click on Bid $100 button");
		common.log("<br></br> Step :: Click on Bid $100 button");
		driver.findElement(By.xpath("//input[@value='Bid $100']")).click();

		common.pause(20);

		common.acceptAlert();
		common.pause(25);

	}

	/**
	 * Place Bid Timed Auction
	 * 
	 * @param auctionName
	 * @param lotName
	 * @throws AWTException
	 * @throws InterruptedException
	 */

	public void Place_Bid_Timedsale_With_Bidder_Rahul_Bid(String auctionName) throws AWTException, InterruptedException

	{

		Goto_Catalog_Page_Timed_Sale_for_All_Auctioneers(auctionName); // Goto catalog page
		common.pause(10);
		System.out.println("Step ::Click on Bid $90 button");
		common.log("<br></br> Step :: Click on Bid $90 button");
		driver.findElement(By.xpath("//input[@value='Bid $90']")).click();
		common.pause(10);
		common.acceptAlert();
		common.pause(25);

	}

	/**
	 * Place Bid Timed Auction
	 * 
	 * @param auctionName
	 * @param lotName
	 * @throws AWTException
	 * @throws InterruptedException
	 */

	public void Place_Bid_Timedsale_With_Bidder_Rahul_Qa_60_bid_value(String auctionName)
			throws AWTException, InterruptedException

	{

		Goto_Catalog_Page_Timed_Sale_for_All_Auctioneers(auctionName); // Goto catalog page
		common.pause(10);
		System.out.println("Step :: Click on Bid $60 button");
		common.log("<br></br> Step ::Click on Bid $60 button");

		driver.findElement(By.xpath("//input[@value='Bid $60']")).click();
		common.pause(10);

		common.acceptAlert();
		common.pause(25);

	}

	/**
	 * Place Bid Timed Auction
	 * 
	 * @param auctionName
	 * @param lotName
	 * @throws AWTException
	 * @throws InterruptedException
	 */

	public void Place_Bid_Timedsale_With_Bidder_Rahul_Bid_30_bid_value(String auctionName)
			throws AWTException, InterruptedException

	{

		Goto_Catalog_Page_Timed_Sale_for_All_Auctioneers(auctionName); // Goto catalog page
		common.pause(10);
		System.out.println("Step :: Click on Bid $30 button");
		common.log("<br></br> Step :: Click on Bid $30 button");
		driver.findElement(By.xpath("//input[@value='Bid $30']")).click();
		common.pause(10);

		common.acceptAlert();
		common.pause(25);

	}

	/**
	 * Place Force Bid From Lot Details Timed Auction
	 * 
	 * @param auctionName
	 * @param lotName
	 * @throws AWTException
	 * @throws InterruptedException
	 */

	public void Place_Force_bid_TimedBid_Lotdetails(String auctionName, String lotName)
			throws AWTException, InterruptedException

	{

		goto_Catalog_Page_Timed_Sale(auctionName); // Goto catalog page

		System.out.println("Step :: Click on Lot Details Page");
		common.log("<br></br> Step :: Click on Lot Details Page");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']")).click();
		common.pause(30);

		System.out.println("Step :: Enter Force Bid Value");
		common.log("<br></br> Step :: Enter Force Bid Value");
		driver.findElement(By.xpath("//input[@class='txt-force-bid']")).sendKeys("200");
		common.pause(10);

		System.out.println("Step :: Click on Force bid Button");
		common.log("<br></br> Step :: Click on Force Bid Button");
		driver.findElement(By.xpath("//input[@class='orng force-bid']")).click();
		common.pause(30);

		String Highbid = driver.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_HIGH_BID_MESSAGE_CLASS + "']"))
				.getText();
		System.out.println("Step :: Verify Success Message >> " + Highbid);
		common.log("<br></br> Step :: Verify Success Message >> " + Highbid);

		System.out.println("Step :: Verify Success Message Present");
		common.log("<br></br> Step :: Verify Sucess Message Present");
		common.assertElementPresent("// span[text()='Your bid has been placed successfully!']");

	}

	/**
	 * Place Bid Timed Auction
	 * 
	 * @param auctionName
	 * @param lotName
	 * @throws AWTException
	 * @throws InterruptedException
	 */

	public void place_Bid_Timedsale(String auctionName, String lotName) throws AWTException, InterruptedException

	{

		goto_Catalog_Page_Timed_Sale(auctionName); // Goto catalog page
		common.pause(10);
		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMEDSALE_BID_TEXTBOX + "']")).sendKeys("200");
		common.pause(10);

		System.out.println("Step :: Click on Place bid Button");
		common.log("<br></br> Step :: Click on Place Bid Button");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@value='Place bid!']"))
				.click();

		if (driver.findElement(By.xpath(
				"/html[1]/body[1]/div[3]/form[1]/div[1]/article[1]/section[1]/div[5]/div[3]/ul[1]/li[1]/section[1]/div[3]/div[2]/section[2]/div[1]/span[1]/input[1]"))
				.isDisplayed()) {
			common.log("<br></br> Step :: Click on Confirm Button");
			System.out.println("Step :: Click on Confirm Button");
			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[3]/form[1]/div[1]/article[1]/section[1]/div[5]/div[3]/ul[1]/li[1]/section[1]/div[3]/div[2]/section[2]/div[1]/span[1]/input[1]"))
					.click();
			common.pause(20);
			common.acceptAlert();
		} else {
			common.acceptAlert1();
			common.pause(20);
		}
		common.pause(15);
		String priceinfo = driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//ul[@class='" + LEGACY_USER_LOT_PRICE_INFO + "']"))
				.getText();
		System.out.println("Step :: Verify Success Message >> " + priceinfo);
		common.log("<br></br> Step :: Verify Success Message >> " + priceinfo);

	}

	/**
	 * Place Bid Timed Auction
	 * 
	 * @param auctionName
	 * @param lotName
	 * @throws AWTException
	 * @throws InterruptedException
	 */

	public void place_Bid_300_Timedsale(String auctionName, String lotName) throws AWTException, InterruptedException

	{

		goto_Catalog_Page_Timed_Sale(auctionName); // Goto catalog page

		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMEDSALE_BID_TEXTBOX + "']")).sendKeys("300");
		common.pause(10);

		System.out.println("Step :: Click on Place bid Button");
		common.log("<br></br> Step :: Click on Place Bid Button");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@value='Place bid!']"))
				.click();

		if (driver.findElement(By.xpath(
				"/html[1]/body[1]/div[3]/form[1]/div[1]/article[1]/section[1]/div[5]/div[3]/ul[1]/li[1]/section[1]/div[3]/div[2]/section[2]/div[1]/span[1]/input[1]"))
				.isDisplayed()) {
			common.log("<br></br> Step :: Click on Confirm Button");
			System.out.println("Step :: Click on Confirm Button");
			driver.findElement(By.xpath(
					"/html[1]/body[1]/div[3]/form[1]/div[1]/article[1]/section[1]/div[5]/div[3]/ul[1]/li[1]/section[1]/div[3]/div[2]/section[2]/div[1]/span[1]/input[1]"))
					.click();
			common.pause(20);
			common.acceptAlert();
		} else {
			common.acceptAlert1();
			common.pause(20);
		}
		String priceinfo = driver.findElement(By.xpath("//ul[@class='" + LEGACY_USER_LOT_PRICE_INFO + "']")).getText();
		System.out.println("Step :: Verify Success Message >> " + priceinfo);
		common.log("<br></br> Step :: Verify Success Message >> " + priceinfo);
		common.pause(15);
	}

	public void Place_Bid_160_For_Added_Lot_Livesale(String auctionName, String lotName) throws AWTException

	{

		goto_Catalog_Page_Live_Sale(auctionName); // Goto catalog page
		common.pause(15);
		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@type='text']"))
				.sendKeys("160");
		common.pause(10);

		System.out.println("Step :: Click on Place bid Button");
		common.log("<br></br> Step :: Click on Place Bid Button");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@value='Place bid! x5']"))
				.click();

		common.pause(20);

		String str = driver.findElement(By.xpath("//span[@id='pblc1']")).getText();
		System.out.println("Step :: Details on Confirm page: " + str);
		common.log("<br></br> Step :: Details on Confirm page: " + str);

	}

	public void Place_Bid_160_and_130_For_Added_Lot_Livesale(String auctionName, String lotName, String lotname1)
			throws AWTException

	{

		goto_Catalog_Page_Live_Sale(auctionName); // Goto catalog page
		common.pause(15);
		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@type='text']"))
				.sendKeys("160");
		common.pause(10);

		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotname1 + "']//..//..//..//input[@type='text']"))
				.sendKeys("130");
		common.pause(10);

		System.out.println("Step :: Click on Place multiple bid Button");
		common.log("<br></br> Step :: Click on Place multiple Bid Button");
		driver.findElement(By.xpath("//input[@id='lac24']")).click();
		common.pause(20);

		String str = driver.findElement(By.xpath("//span[@id='pblc1']")).getText();
		System.out.println("Step :: Details on Confirm page: " + str);
		common.log("<br></br> Step :: Details on Confirm page: " + str);

	}

	public void Place_Bid_100_and_200_For_Added_Lot_Livesale(String auctionName, String lotName, String lotname1)
			throws AWTException

	{

		goto_Catalog_Page_Live_Sale(auctionName); // Goto catalog page
		common.pause(15);
		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@type='text']"))
				.sendKeys("100");
		common.pause(10);

		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotname1 + "']//..//..//..//input[@type='text']"))
				.sendKeys("200");
		common.pause(10);

		System.out.println("Step :: Click on Place multiple bid Button");
		common.log("<br></br> Step :: Click on Place multiple Bid Button");
		driver.findElement(By.xpath("//input[@id='lac24']")).click();
		common.pause(20);

		String str = driver.findElement(By.xpath("//span[@id='pblc1']")).getText();
		System.out.println("Step :: Details on Confirm page: " + str);
		common.log("<br></br> Step :: Details on Confirm page: " + str);

	}

	/**
	 * Change Bid Timed Auction
	 * 
	 * @param auctionName
	 * @param lotName
	 * @throws AWTException
	 * @throws InterruptedException
	 */

	public void Change_Bid_Timedsale(String auctionName, String lotName) throws AWTException, InterruptedException

	{

		goto_Catalog_Page_Timed_Sale(auctionName); // Goto catalog page

		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMEDSALE_BID_TEXTBOX + "']")).sendKeys("200");
		common.pause(10);

		System.out.println("Step :: Click on Place bid Button");
		common.log("<br></br> Step :: Click on Place Bid Button");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@value='Place bid!']"))
				.click();
		common.pause(20);

		System.out.println("Step :: Accept Alert");
		common.log("<br></br> Step :: Accept Alert");
		common.acceptAlert1();

		common.pause(20);

		String priceinfo = driver.findElement(By.xpath("//ul[@class='" + LEGACY_USER_LOT_PRICE_INFO + "']")).getText();
		System.out.println("Step :: Verify Success Message >> " + priceinfo);
		common.log("<br></br> Step :: Verify Success Message >> " + priceinfo);

		System.out.println("Step :: Clear Last Bid Value");
		common.log("<br></br> Step :: Clear Last Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMEDSALE_BID_TEXTBOX + "']")).clear();
		common.pause(10);

		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMEDSALE_BID_TEXTBOX + "']")).sendKeys("300");
		common.pause(10);

		System.out.println("Step :: Click on Change bid Button");
		common.log("<br></br> Step :: Click on Change Bid Button");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@value='Change bid!']"))
				.click();
		common.pause(15);

		System.out.println("Step :: Accept Alert");
		common.log("<br></br> Step :: Accept Alert");
		common.acceptAlert1();
		common.pause(10);
		String priceinfo1 = driver.findElement(By.xpath("//ul[@class='" + LEGACY_USER_LOT_PRICE_INFO + "']")).getText();
		System.out.println("Step :: Verify Success Message >> " + priceinfo1);
		common.log("<br></br> Step :: Verify Success Message >> " + priceinfo1);

	}

	/**
	 * Place Force Bid Timed Auction
	 * 
	 * @param auctionName
	 * @param lotName
	 * @throws AWTException
	 * @throws InterruptedException
	 */

	public void Place_Force_Bid_Timedsale(String auctionName, String lotName) throws AWTException, InterruptedException

	{

		goto_Catalog_Page_Timed_Sale(auctionName); // Goto catalog page

		common.pause(15);
		System.out.println("Step :: Enter Force Bid Value");
		common.log("<br></br> Step :: Enter Force Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMEDSALE_FORCEBID_TEXTBOX + "']")).sendKeys("250");
		common.pause(10);

		System.out.println("Step :: Click on Force bid Button");
		common.log("<br></br> Step :: Click on Force Bid Button");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//input[@value='" + LEGACY_USER_BTN_FORCE_BID + "']"))
				.click();
		common.pause(30);

		System.out.println("Step :: Accept Alert");
		common.log("<br></br> Step :: Accept Alert");
		common.acceptAlert1();
		common.pause(15);

		String priceinfo = driver.findElement(By.xpath("//ul[@class='" + LEGACY_USER_LOT_PRICE_INFO + "']")).getText();
		System.out.println("Step :: Verify Success Message >> " + priceinfo);
		common.log("<br></br> Step :: Verify Success Message >> " + priceinfo);

	}

	/**
	 * Place Mutiple Bid Timed Auction
	 * 
	 * @param auctionName
	 * @param lotName
	 * @throws AWTException
	 * @throws InterruptedException
	 */

	public void Place_Multiple_Bid_Timedsale(String auctionName, String lotName, String lotName1, String lotName2)
			throws AWTException, InterruptedException

	{

		goto_Catalog_Page_Timed_Sale(auctionName); // Goto catalog page
		common.pause(50);
		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMEDSALE_BID_TEXTBOX + "']")).sendKeys("250");
		common.pause(10);

		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName1 + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMEDSALE_BID_TEXTBOX + "']")).sendKeys("250");
		common.pause(10);

		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName2 + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMEDSALE_BID_TEXTBOX + "']")).sendKeys("250");
		common.pause(40);

		System.out.println("Step :: Click on place multibid button");
		common.log("<br></br> Step :: Click on place multibid button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_PLACE_MULTIBID + "']")).click();
		common.pause(20);
		System.out.println("Step :: Click on Confirm Button");
		common.log("<br></br> Step :: Click on Confirm button");
		driver.findElement(By.xpath("//span//input[@id='" + LEGACY_USER_BTN_PLACE_MULTIBID_CONFIRM + "']")).click();

		common.pause(10);
		System.out.println("Step :: Accept Alert");
		common.log("<br></br> Step :: Accept Alert");
		common.acceptAlert1();
		common.pause(15);

		String priceinfo = driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//ul[@class='" + LEGACY_USER_LOT_PRICE_INFO + "']"))
				.getText();
		System.out.println("Step :: Verify Success Message >> " + priceinfo);
		common.log("<br></br> Step :: Verify Success Message >> " + priceinfo);
		common.pause(15);

		String priceinfo1 = driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName1 + "']//..//..//..//ul[@class='" + LEGACY_USER_LOT_PRICE_INFO + "']"))
				.getText();
		System.out.println("Step :: Verify Success Message >> " + priceinfo1);
		common.log("<br></br> Step :: Verify Success Message >> " + priceinfo1);
		common.pause(15);

		String priceinfo2 = driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName2 + "']//..//..//..//ul[@class='" + LEGACY_USER_LOT_PRICE_INFO + "']"))
				.getText();
		System.out.println("Step :: Verify Success Message >> " + priceinfo2);
		common.log("<br></br> Step :: Verify Success Message >> " + priceinfo2);

	}

	/**
	 * Buy Now Timed sale
	 * 
	 * @param auctionName
	 * @param lotName
	 * @throws AWTException
	 * @throws InterruptedException
	 */

	public void BuyNow_Timedsale(String auctionName, String lotName) throws AWTException, InterruptedException

	{

		goto_Catalog_Page_Timed_Sale(auctionName); // Goto catalog page

		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMEDSALE_BID_TEXTBOX + "']")).sendKeys("250");
		common.pause(10);

		System.out.println("Step :: Click on Buy Now Button");
		common.log("<br></br> Step :: Click on Buy Now Button");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//..//input[@value='Buy now! $500']"))
				.click();
		common.pause(15);

		System.out.println("Step :: Click on Confirm Button");
		common.log("<br></br> Step :: Click on Confirm button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_PLACE_MULTIBID_CONFIRM + "']")).click();
		// common.acceptAlert1();
		common.pause(20);

		String youwon = driver.findElement(By.xpath("//div[@class='winner-msg']")).getText();
		System.out.println("Step :: Verify Won Message >> " + youwon);
		common.log("<br></br> Step :: Verify Won Message >> " + youwon);
		common.pause(15);

	}

	/**
	 * Bid Now x Timed Auction
	 * 
	 * @param auctionName
	 * @param lotName
	 * @throws AWTException
	 * @throws InterruptedException
	 */

	public void BidNow_x_Timedsale(String auctionName, String lotName) throws AWTException, InterruptedException

	{

		goto_Catalog_Page_Timed_Sale(auctionName); // Goto catalog page
		common.pause(25);

		System.out.println("Step :: Click on Bid Now Button");
		common.log("<br></br> Step :: Click on Bid Now Button");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='orng']")).click();
		common.pause(20);

		common.acceptAlert1();
		common.pause(20);

		String priceinfo = driver.findElement(By.xpath("//ul[@class='" + LEGACY_USER_LOT_PRICE_INFO + "']")).getText();
		System.out.println("Step :: Verify Success Message >> " + priceinfo);
		common.log("<br></br> Step :: Verify Success Message >> " + priceinfo);
		common.pause(5);
	}

	public void BidNow_x_Timedsale1(String auctionName, String lotName) throws AWTException, InterruptedException

	{

		goto_Catalog_Page_Timed_Sale(auctionName); // Goto catalog page
		common.pause(15);

		System.out.println("Step :: Click on Bid Now Button");
		common.log("<br></br> Step :: Click on Bid Now Button");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='orng']")).click();
		common.pause(15);

		common.acceptAlert1();
		common.pause(15);

		String priceinfo = driver.findElement(By.xpath("//ul[@class='" + LEGACY_USER_LOT_PRICE_INFO + "']")).getText();
		System.out.println("Step :: Verify Success Message >> " + priceinfo);
		common.log("<br></br> Step :: Verify Success Message >> " + priceinfo);
		common.pause(5);
	}

	/**
	 * Bid x From Lot Details Page.
	 * 
	 * @param auctionName
	 * @param lotName
	 * @throws AWTException
	 * @throws InterruptedException
	 */

	public void BidNow_From_LotDetails_Timedsale(String auctionName, String lotName)
			throws AWTException, InterruptedException

	{

		goto_Catalog_Page_Timed_Sale(auctionName); // Goto catalog page

		System.out.println("Step :: Click on Lot Details Page");
		common.log("<br></br> Step :: Click on Lot Details Page");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']")).click();
		common.pause(30);

		System.out.println("Step :: Click on Bid Now Button");
		common.log("<br></br> Step :: Click on Bid Now Button");
		driver.findElement(By.xpath("//input[@class='" + LEGACY_USER_BTN_PLACEBID_LOTDETAILS + "']")).click();
		common.pause(20);

		String priceinfo = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_HIGH_BID_MESSAGE_CLASS + "']")).getText();
		System.out.println("Step :: Verify Success Message >> " + priceinfo);
		common.log("<br></br> Step :: Verify Success Message >> " + priceinfo);

	}

	/**
	 * Change Bid Lot Details Timed Auction
	 * 
	 * @param auctionName
	 * @param lotName
	 * @throws AWTException
	 * @throws InterruptedException
	 */

	public void Change_Bid_LotDetails_Timedsale(String auctionName, String lotName)
			throws AWTException, InterruptedException

	{

		goto_Catalog_Page_Timed_Sale(auctionName); // Goto catalog page

		System.out.println("Step :: Click on Lot Details Page");
		common.log("<br></br> Step :: Click on Lot Details Page");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']")).click();
		common.pause(15);

		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//input[@class='mrg txt-max-bid']")).sendKeys("200");
		common.pause(10);

		System.out.println("Step :: Click on Place bid Button");
		common.log("<br></br> Step :: Click on Place Bid Button");
		driver.findElement(By.xpath("//input[@value='Place bid!']")).click();
		common.pause(15);

		String priceinfo = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_HIGH_BID_MESSAGE_CLASS + "']")).getText();
		System.out.println("Step :: Verify Success Message >> " + priceinfo);
		common.log("<br></br> Step :: Verify Success Message >> " + priceinfo);

		String Success_msg = driver.findElement(By.xpath("//span[@class='message']")).getText();
		System.out.println("Step :: Verify Success Message >> " + Success_msg);
		common.log("<br></br> Step :: Verify Success Message >> " + Success_msg);

		System.out.println("Step :: Verify Success Message Present");
		common.log("<br></br> Step :: Verify Success Message Present");
		common.assertElementPresent("//span[@class='message']");

		System.out.println("Step :: Clear Last Bid Value");
		common.log("<br></br> Step :: Clear Last Bid Value");
		driver.findElement(By.xpath("//input[@class='mrg txt-max-bid']")).clear();
		common.pause(10);

		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//input[@class='mrg txt-max-bid']")).sendKeys("300");
		common.pause(30);

		System.out.println("Step :: Click on Change bid Button");
		common.log("<br></br> Step :: Click on Change Bid Button");
		driver.findElement(By.xpath("//input[@value='Place bid!']")).click();
		common.pause(10);

		String priceinfo1 = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_HIGH_BID_MESSAGE_CLASS + "']")).getText();
		System.out.println("Step :: Verify Success Message >> " + priceinfo1);
		common.log("<br></br> Step :: Verify Success Message >> " + priceinfo1);

		String Success_msg1 = driver.findElement(By.xpath("//span[@class='message']")).getText();
		System.out.println("Step :: Verify Success Message >> " + Success_msg1);
		common.log("<br></br> Step :: Verify Success Message >> " + Success_msg1);

		System.out.println("Step :: Verify Success Message Present");
		common.log("<br></br> Step :: Verify Success Message Present");
		common.assertElementPresent("//span[@class='message']");

	}

	/**
	 * Buy Now Timed sale Lot Details
	 * 
	 * @param auctionName
	 * @param lotName
	 * @throws AWTException
	 * @throws InterruptedException
	 */

	public void BuyNow_Timedsale_LotDetails(String auctionName, String lotName)
			throws AWTException, InterruptedException

	{

		goto_Catalog_Page_Timed_Sale(auctionName); // Goto catalog page

		common.pause(20);
		System.out.println("Step :: Click on Lot Details Page");
		common.log("<br></br> Step :: Click on Lot Details Page");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']")).click();
		common.pause(20);

		System.out.println("Step :: Click on Buy Now Button");
		common.log("<br></br> Step :: Click on Buy Now Button");
		driver.findElement(By.xpath("//input[@class='orng buy-now']")).click();
		common.pause(30);

		System.out.println("Step :: Click on Confirm Button");
		common.log("<br></br> Step :: Click on Confirm button");
		driver.findElement(By.xpath("//span//input[@id='" + LEGACY_USER_BTN_PLACE_MULTIBID_CONFIRM + "']")).click();

		common.pause(20);

		String youwon = driver.findElement(By.xpath("//div[@class='winner-msg']")).getText();
		System.out.println("Step :: Verify Won Message >> " + youwon);
		common.log("<br></br> Step :: Verify Won Message >> " + youwon);
		common.pause(15);

	}

	/**
	 * Bid x From Watch List
	 * 
	 * @param TimedAuction
	 * @param lotName
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public void Bid_x_From_WatchList(String TimedAuction, String lotName) throws AWTException, InterruptedException

	{

		goto_Catalog_Page_Timed_Sale(TimedAuction);

		common.pause(25);
		System.out.println("Step :: Click on Added to watchlist checkbox");
		common.log("<br><\br> Step :: Click on Added to watchlist checkbox");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//div[@class='bd-chk']")).click();
		common.pause(25);

		System.out.println("Step :: Click on Accept Alert");
		common.log("<br><\br> Step :: Click on Accept Alert");
		common.acceptAlert1();
		common.pause(10);

		System.out.println("Step :: Click on View My Watchlist");
		common.log("<br><\br> Step :: Click on View My Watchlist");
		driver.findElement(By.xpath("//a[@class='catalog-mywatchlist-top']")).click();
		common.pause(20);

		System.out.println("Step :: Select Item Per Page");
		common.log("<br><\br> Step :: Select Item Per Page");
		driver.findElement(By.xpath("//select[@id='lstPageTop']//..//option[@value='3']")).click();
		common.pause(20);

		for (int i = 0; i < 20; i++) {

			if (!common.isElementPresent("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='orng']")) {

				System.out.println("Step :: Lot Not Present >> " + lotName);
				common.log("<br><\br> Step :: Lot Not Present >> " + lotName);

				System.out.println("Step :: Click on Next Button");
				common.log("<br><\br> Step :: Click on Next Button");
				driver.findElement(By.xpath("//span[@class='arrow']//..//span[text()='Next']")).click();

			} else {

				System.out.println("Step :: Lot Present >> " + lotName);
				common.log("<br><\br> Step :: Lot Present >> " + lotName);
				break;

			}

		}

		System.out.println("Step :: Click on Bid Button");
		common.log("<br><\br> Step :: Click on Bid Button");
		common.pause(10);

		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='orng']")).click();
		common.pause(25);

		System.out.println("Step :: Click on Accept Alert");
		common.log("<br><\br> Step :: Click on Accept Alert");
		common.acceptAlert1();
		common.pause(10);
	}

	/**
	 * Place Bid From Watch List
	 * 
	 * @param TimedAuction
	 * @param lotName
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public void Place_Bid_From_WatchList(String TimedAuction, String lotName) throws AWTException, InterruptedException

	{

		goto_Catalog_Page_Timed_Sale(TimedAuction);

		System.out.println("Step :: Click on Added to watchlist checkbox");
		common.log("<br><\br> Step :: Click on Added to watchlist checkbox");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//div[@class='bd-chk']")).click();
		common.pause(15);

		System.out.println("Step :: Click on Accept Alert");
		common.log("<br><\br> Step :: Click on Accept Alert");
		common.acceptAlert1();
		common.pause(10);

		System.out.println("Step :: Click on View My Watchlist");
		common.log("<br><\br> Step :: Click on View My Watchlist");
		driver.findElement(By.xpath("//a[@class='catalog-mywatchlist-top']")).click();
		common.pause(20);

		System.out.println("Step :: Select Item Per Page");
		common.log("<br><\br> Step :: Select Item Per Page");
		driver.findElement(By.xpath("//select[@id='lstPageTop']//..//option[@value='3']")).click();
		common.pause(20);

		for (int i = 0; i < 20; i++) {

			if (!common.isElementPresent("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='orng']")) {

				System.out.println("Step :: Lot Not Present >> " + lotName);
				common.log("<br><\br> Step :: Lot Not Present >> " + lotName);

				System.out.println("Step :: Click on Next Button");
				common.log("<br><\br> Step :: Click on Next Button");
				driver.findElement(By.xpath("//span[@class='arrow']//..//span[text()='Next']")).click();

			} else {

				System.out.println("Step :: Lot Present >> " + lotName);
				common.log("<br><\br> Step :: Lot Present >> " + lotName);
				break;

			}

		}

		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMEDSALE_BID_TEXTBOX + "']")).sendKeys("300");
		common.pause(10);

		System.out.println("Step :: Click on Place bid Button");
		common.log("<br></br> Step :: Click on Place Bid Button");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@value='Place bid!']"))
				.click();
		common.pause(15);

		System.out.println("Step :: Click on Accept Alert");
		common.log("<br><\br> Step :: Click on Accept Alert");
		common.acceptAlert1();
		common.pause(15);

		String price_info = driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//ul[@class='" + LEGACY_USER_LOT_PRICE_INFO + "']"))
				.getText();
		System.out.println("Step :: Price Info >>" + price_info);
		common.log("<br><\br> Step :: Price Info >>" + price_info);

	}

	/**
	 * Change Bid From Watch List
	 * 
	 * @param TimedAuction
	 * @param lotName
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public void Change_Bid_From_WatchList(String TimedAuction, String lotName) throws AWTException, InterruptedException

	{

		goto_Catalog_Page_Timed_Sale(TimedAuction);

		System.out.println("Step :: Click on Added to watchlist checkbox");
		common.log("<br><\br> Step :: Click on Added to watchlist checkbox");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//div[@class='bd-chk']")).click();
		common.pause(15);

		System.out.println("Step :: Click on Accept Alert");
		common.log("<br><\br> Step :: Click on Accept Alert");
		common.acceptAlert1();
		common.pause(10);

		System.out.println("Step :: Click on View My Watchlist");
		common.log("<br><\br> Step :: Click on View My Watchlist");
		driver.findElement(By.xpath("//a[@class='catalog-mywatchlist-top']")).click();
		common.pause(15);

		System.out.println("Step :: Select Item Per Page");
		common.log("<br><\br> Step :: Select Item Per Page");
		driver.findElement(By.xpath("//select[@id='lstPageTop']//..//option[@value='3']")).click();
		common.pause(20);
		for (int i = 0; i < 20; i++) {

			if (!common.isElementPresent("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='orng']")) {

				System.out.println("Step :: Lot Not Present >> " + lotName);
				common.log("<br><\br> Step :: Lot Not Present >> " + lotName);

				System.out.println("Step :: Click on Next Button");
				common.log("<br><\br> Step :: Click on Next Button");
				driver.findElement(By.xpath("//span[@class='arrow']//..//span[text()='Next']")).click();

			} else {

				System.out.println("Step :: Lot Present >> " + lotName);
				common.log("<br><\br> Step :: Lot Present >> " + lotName);
				break;

			}

		}

		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMEDSALE_BID_TEXTBOX + "']")).sendKeys("300");
		common.pause(10);

		System.out.println("Step :: Click on Place bid Button");
		common.log("<br></br> Step :: Click on Place Bid Button");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@value='Place bid!']"))
				.click();
		common.pause(20);

		// common.log("<br></br> Step :: Click on confirm button");
		// System.out.println("Step :: Click on confirm button");
		// driver.findElement(By.xpath("//input[@value='" + LEGACY_USER_BTN_CONFIRM +
		// "']")).click();
		// common.pause(10);

		System.out.println("Step :: Click on Accept Alert");
		common.log("<br><\br> Step :: Click on Accept Alert");
		common.acceptAlert1();
		common.pause(15);

		String price_info = driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//ul[@class='" + LEGACY_USER_LOT_PRICE_INFO + "']"))
				.getText();
		System.out.println("Step :: Price Info >> " + price_info);
		common.log("<br><\br> Step :: Price Info >> " + price_info);
		common.pause(15);

		System.out.println("Step :: Clear Bid Value");
		common.log("<br></br> Step :: Clear Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMEDSALE_BID_TEXTBOX + "']")).clear();
		common.pause(10);

		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMEDSALE_BID_TEXTBOX + "']")).sendKeys("400");
		common.pause(10);

		System.out.println("Step :: Click on Change Bid Button");
		common.log("<br></br> Step :: Click on Change Bid Button");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@value='Change bid!']"))
				.click();
		common.pause(25);

		// common.log("<br></br> Step :: Click on confirm button");
		// System.out.println("Step :: Click on confirm button");
		// driver.findElement(By.xpath("//input[@value='" + LEGACY_USER_BTN_CONFIRM +
		// "']")).click();
		// common.pause(10);

		System.out.println("Step :: Click on Accept Alert");
		common.log("<br><\br> Step :: Click on Accept Alert");
		common.acceptAlert1();
		common.pause(15);

		String price_info1 = driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//ul[@class='" + LEGACY_USER_LOT_PRICE_INFO + "']"))
				.getText();
		System.out.println("Step :: Price Info >> " + price_info1);
		common.log("<br><\br> Step :: Price Info >> " + price_info1);
		common.pause(15);
	}

	/**
	 * Place Bid From Watch List
	 * 
	 * @param TimedAuction
	 * @param lotName
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public void Force_Bid_From_WatchList(String TimedAuction, String lotName) throws AWTException, InterruptedException

	{

		goto_Catalog_Page_Timed_Sale(TimedAuction);

		System.out.println("Step :: Click on Added to watchlist checkbox");
		common.log("<br><\br> Step :: Click on Added to watchlist checkbox");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//div[@class='bd-chk']")).click();
		common.pause(10);

		System.out.println("Step :: Click on Accept Alert");
		common.log("<br><\br> Step :: Click on Accept Alert");
		common.acceptAlert1();
		common.pause(10);

		System.out.println("Step :: Click on View My Watchlist");
		common.log("<br><\br> Step :: Click on View My Watchlist");
		driver.findElement(By.xpath("//a[@class='catalog-mywatchlist-top']")).click();
		common.pause(20);

		System.out.println("Step :: Select Item Per Page");
		common.log("<br><\br> Step :: Select Item Per Page");
		driver.findElement(By.xpath("//select[@id='lstPageTop']//..//option[@value='3']")).click();
		common.pause(20);

		for (int i = 0; i < 20; i++) {

			if (!common.isElementPresent("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='orng']")) {

				System.out.println("Step :: Lot Not Present >> " + lotName);
				common.log("<br><\br> Step :: Lot Not Present >> " + lotName);

				System.out.println("Step :: Click on Next Button");
				common.log("<br><\br> Step :: Click on Next Button");
				driver.findElement(By.xpath("//span[@class='arrow']//..//span[text()='Next']")).click();

			} else {

				System.out.println("Step :: Lot Present >> " + lotName);
				common.log("<br><\br> Step :: Lot Present >> " + lotName);
				break;

			}

		}

		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMEDSALE_FORCEBID_TEXTBOX + "']")).sendKeys("250");
		common.pause(10);

		System.out.println("Step :: Click on Force bid Button");
		common.log("<br></br> Step :: Click on Force Bid Button");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@value='Force Bid']"))
				.click();
		common.pause(30);

		// common.log("<br></br> Step :: Click on confirm button");
		// System.out.println("Step :: Click on confirm button");
		// driver.findElement(By.xpath("//input[@value='" +
		// LEGACY_USER_BTN_CONFIRM + "']")).click();
		// common.pause(10);

		System.out.println("Step :: Click on Accept Alert");
		common.log("<br><\br> Step :: Click on Accept Alert");
		common.acceptAlert1();
		common.pause(15);

		String price_info = driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//ul[@class='" + LEGACY_USER_LOT_PRICE_INFO + "']"))
				.getText();
		System.out.println("Step :: Price Info >>" + price_info);
		common.log("<br><\br> Step :: Price Info >>" + price_info);

	}

	/**
	 * Place Multiple Bid From Watch List
	 * 
	 * @param TimedAuction
	 * @param lotName
	 * @param lotName1
	 * @param lotName2
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public void Place_Multiple_Bid_From_WatchList(String TimedAuction, String lotName, String lotName1)
			throws AWTException, InterruptedException

	{

		goto_Catalog_Page_Timed_Sale(TimedAuction);
		common.pause(15);
		System.out.println("Step :: Click on Add to watchlist checkbox");
		common.log("<br><\br> Step :: Click on Add to watchlist checkbox");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//div[@class='bd-chk']")).click();
		common.pause(15);

		System.out.println("Step :: Click on Accept Alert");
		common.log("<br><\br> Step :: Click on Accept Alert");
		common.acceptAlert1();
		common.pause(15);

		System.out.println("Step :: Click on Add to watchlist checkbox");
		common.log("<br><\br> Step :: Click on Add to watchlist checkbox");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName1 + "']//..//..//..//div[@class='bd-chk']")).click();
		common.pause(20);

		System.out.println("Step :: Click on Accept Alert");
		common.log("<br><\br> Step :: Click on Accept Alert");
		common.acceptAlert1();
		common.pause(20);

		System.out.println("Step :: Click on View My Watchlist");
		common.log("<br><\br> Step :: Click on View My Watchlist");
		driver.findElement(By.xpath("//a[@class='catalog-mywatchlist-top']")).click();
		common.pause(20);

		System.out.println("Step :: Select Item Per Page");
		common.log("<br><\br> Step :: Select Item Per Page");
		driver.findElement(By.xpath("//select[@id='lstPageTop']//..//option[@value='3']")).click();
		common.pause(20);

		for (int i = 0; i < 20; i++) {

			if (!common.isElementPresent("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='orng']")) {

				System.out.println("Step :: Lot Not Present >> " + lotName);
				common.log("<br><\br> Step :: Lot Not Present >> " + lotName);

				System.out.println("Step :: Click on Next Button");
				common.log("<br><\br> Step :: Click on Next Button");
				driver.findElement(By.xpath("//span[@class='arrow']//..//span[text()='Next']")).click();

			} else {

				System.out.println("Step :: Lot Present >> " + lotName);
				common.log("<br><\br> Step :: Lot Present >> " + lotName);
				break;

			}

		}

		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMEDSALE_FORCEBID_TEXTBOX + "']")).sendKeys("250");
		common.pause(10);

		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName1 + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMEDSALE_FORCEBID_TEXTBOX + "']")).sendKeys("250");
		common.pause(10);

		System.out.println("Step :: Click on place multibid button");
		common.log("<br></br> Step :: Click on place multibid button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_PLACE_MULTIBID + "']")).click();
		common.pause(25);

		common.log("<br></br> Step :: Click on confirm button");
		System.out.println("Step :: Click on confirm button");
		driver.findElement(By.xpath("//input[@value='" + LEGACY_USER_BTN_CONFIRM + "']")).click();
		common.pause(10);

		System.out.println("Step :: Click on Accept Alert");
		common.log("<br><\br> Step :: Click on Accept Alert");
		common.acceptAlert1();
		common.pause(25);

		String price_info = driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//ul[@class='" + LEGACY_USER_LOT_PRICE_INFO + "']"))
				.getText();
		System.out.println("Step :: Price Info >>" + price_info);
		common.log("<br><\br> Step :: Price Info >>" + price_info);

		String price_info1 = driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName1 + "']//..//..//..//ul[@class='" + LEGACY_USER_LOT_PRICE_INFO + "']"))
				.getText();
		System.out.println("Step :: Price Info >>" + price_info);
		common.log("<br><\br> Step :: Price Info >>" + price_info);
		common.pause(10);

	}

	/**
	 * Buy Now From Watch List
	 * 
	 * @param TimedAuction
	 * @param lotName
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public void Buy_Now_From_WatchList(String TimedAuction, String lotName) throws AWTException, InterruptedException

	{

		goto_Catalog_Page_Timed_Sale(TimedAuction);

		System.out.println("Step :: Click on Added to watchlist checkbox");
		common.log("<br><\br> Step :: Click on Added to watchlist checkbox");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//div[@class='bd-chk']")).click();
		common.pause(10);

		System.out.println("Step :: Click on Accept Alert");
		common.log("<br><\br> Step :: Click on Accept Alert");
		common.acceptAlert1();
		common.pause(10);

		System.out.println("Step :: Click on View My Watchlist");
		common.log("<br><\br> Step :: Click on View My Watchlist");
		driver.findElement(By.xpath("//a[@class='catalog-mywatchlist-top']")).click();
		common.pause(20);

		System.out.println("Step :: Select Item Per Page");
		common.log("<br><\br> Step :: Select Item Per Page");
		driver.findElement(By.xpath("//select[@id='lstPageTop']//..//option[@value='3']")).click();
		common.pause(20);

		for (int i = 0; i < 20; i++) {

			if (!common.isElementPresent("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='orng']")) {

				System.out.println("Step :: Lot Not Present >> " + lotName);
				common.log("<br><\br> Step :: Lot Not Present >> " + lotName);

				System.out.println("Step :: Click on Next Button");
				common.log("<br><\br> Step :: Click on Next Button");
				driver.findElement(By.xpath("//span[@class='arrow']//..//span[text()='Next']")).click();

			} else {

				System.out.println("Step :: Lot Present >> " + lotName);
				common.log("<br><\br> Step :: Lot Present >> " + lotName);
				break;

			}

		}

		common.log("<br></br> Step :: Click on buy now button");
		System.out.println("Step :: Click on buy now button");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='button orng']"))
				.click();
		common.pause(30);

		common.log("<br></br> Step :: Click on confirm button");
		System.out.println("Step :: Click on confirm button");
		driver.findElement(By.xpath("//input[@value='" + LEGACY_USER_BTN_CONFIRM + "']")).click();

		common.pause(40);

		String strmsg = driver.findElement(By.xpath("//div[contains(text(),'You won!')]")).getText();
		common.log("<br></br> Step :: Verify Winner Message :: " + strmsg);
		System.out.println("Step :: Verify Winner Message :: " + strmsg);
		common.isElementPresent("//div[contains(text(),'You won!')]");

		common.pause(30);

	}

	/**
	 * Bid Now Timed Auction from bid on
	 * 
	 * @param auctionName
	 * @param lotName
	 */

	public void BidNow_Timedsale_Bidon(String lotName)

	{
		common.pause(25);
		System.out.println("Step :: Click on My Items");
		common.log("<br></br> Step :: Click on My Items");
		driver.findElement(By.xpath("//ul/li//a[text()='My Items']")).click();
		common.pause(20);

		System.out.println("Step :: Click on Bidding On");
		common.log("<br></br> Step :: Click on Bidding On");
		driver.findElement(By.xpath("//li[@class='tabnav-tab tab-my-items-bidding selected']")).click();
		common.pause(20);

		System.out.println("Step :: Select page from dropdown");
		common.log("<br></br> Step :: Select page from dropdown");
		driver.findElement(By.xpath("//select[@id='lstPageTop']//option[@value='3']")).click();
		common.pause(15);

		for (int i = 0; i < 20; i++) {

			if (common.isElementPresent("//h2//a[text()='" + lotName + "']//..//..//..//input[@type='text']")) {

				System.out.println("Step :: Lot Dispalys");
				common.log("<br></br> Step :: Lot Displays");
				break;

			} else {

				System.out.println("Step :: Lot Not Display and click on next button");
				driver.findElement(By.xpath("//span[@class='paginator']//..[text()='Next']")).click();
			}

		}

		System.out.println("Step :: Click on Bid Now Button");
		common.log("<br></br> Step :: Click on Bid Now Button");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='orng']")).click();
		common.pause(20);

		// common.log("<br></br> Step :: Click on confirm button");
		// System.out.println("Step :: Click on confirm button");
		// driver.findElement(By.xpath("//input[@value='" +
		// LEGACY_USER_BTN_CONFIRM + "']")).click();

		// common.pause(5);

		common.log("Step :: Accept Alert");
		System.out.println("Step :: Accept Alert");
		common.acceptAlert1();

		common.pause(15);

		String priceinfo = driver.findElement(By.xpath("//ul[@class='" + LEGACY_USER_LOT_PRICE_INFO + "']")).getText();
		System.out.println("Step :: Verify Success Message >> " + priceinfo);
		common.log("<br></br> Step :: Verify Success Message >> " + priceinfo);

	}

	/**
	 * Change Bid Timed Auction from bid on
	 * 
	 * @param auctionName
	 * @param lotName
	 */

	public void Change_Bid_Timedsale_Bidon(String lotName)

	{
		common.pause(25);
		System.out.println("Step :: Click on My Items");
		common.log("<br></br> Step :: Click on My Items");
		driver.findElement(By.xpath("//ul/li//a[text()='My Items']")).click();
		common.pause(15);

		System.out.println("Step :: Click on Bidding On");
		common.log("<br></br> Step :: Click on Bidding On");
		driver.findElement(By.xpath("//li[@class='tabnav-tab tab-my-items-bidding selected']")).click();
		common.pause(20);

		System.out.println("Step :: Select page from dropdown");
		common.log("<br></br> Step :: Select page from dropdown");
		driver.findElement(By.xpath("//select[@id='lstPageTop']//option[@value='3']")).click();
		common.pause(25);

		for (int i = 0; i < 20; i++) {

			if (common.isElementPresent("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='orng']")) {

				System.out.println("Step :: Lot Dispalys");
				common.log("<br></br> Step :: Lot Displays");
				break;

			} else {

				System.out.println("Step :: Lot Not Display and click on next button");
				driver.findElement(By.xpath("//span[@class='paginator']//..[text()='Next']")).click();
			}

		}

		System.out.println("Step :: Clear Bid Value");
		common.log("<br></br> Step :: Clear Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMEDSALE_BID_TEXTBOX + "']")).clear();
		common.pause(15);

		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMEDSALE_BID_TEXTBOX + "']")).sendKeys("400");
		common.pause(10);

		System.out.println("Step :: Click on Change bid Button");
		common.log("<br></br> Step :: Click on Change Bid Button");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@value='Change bid!']"))
				.click();
		common.pause(20);

		common.acceptAlert1();
		common.pause(15);

		String priceinfo = driver.findElement(By.xpath("//ul[@class='" + LEGACY_USER_LOT_PRICE_INFO + "']")).getText();
		System.out.println("Step :: Verify Success Message >> " + priceinfo);
		common.log("<br></br> Step :: Verify Success Message >> " + priceinfo);

	}

	/**
	 * Force Bid Timed Auction from bid on
	 * 
	 * @param auctionName
	 * @param lotName
	 */

	public void Force_Bid_Timedsale_Bidon(String lotName)

	{
		common.pause(25);
		System.out.println("Step :: Click on My Items");
		common.log("<br></br> Step :: Click on My Items");
		driver.findElement(By.xpath("//ul/li//a[text()='My Items']")).click();
		common.pause(15);

		System.out.println("Step :: Click on Bidding On");
		common.log("<br></br> Step :: Click on Bidding On");
		driver.findElement(By.xpath("//li[@class='tabnav-tab tab-my-items-bidding selected']")).click();
		common.pause(20);

		System.out.println("Step :: Select page from dropdown");
		common.log("<br></br> Step :: Select page from dropdown");
		driver.findElement(By.xpath("//select[@id='lstPageTop']//option[@value='3']")).click();
		common.pause(15);

		for (int i = 0; i < 20; i++) {

			if (common.isElementPresent(
					"//h2//a[text()='" + lotName + "']//..//..//..//input[@class='textbox timed-maxbid']")) {

				System.out.println("Step :: Lot Dispalys");
				common.log("<br></br> Step :: Lot Displays");
				break;

			} else {

				System.out.println("Step :: Lot Not Display and click on next button");
				driver.findElement(By.xpath("//span[@class='paginator']//..//span[text()='Next']")).click();
			}

		}

		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMEDSALE_FORCEBID_TEXTBOX + "']")).sendKeys("400");
		common.pause(10);

		System.out.println("Step :: Click on Force bid Button");
		common.log("<br></br> Step :: Click on Force Bid Button");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@value='Force Bid']"))
				.click();
		common.pause(20);

		common.acceptAlert1();
		common.pause(15);

		String priceinfo = driver.findElement(By.xpath("//ul[@class='" + LEGACY_USER_LOT_PRICE_INFO + "']")).getText();
		System.out.println("Step :: Verify Success Message >> " + priceinfo);
		common.log("<br></br> Step :: Verify Success Message >> " + priceinfo);

	}

	/**
	 * BuyNow Timed Auction from bid on
	 * 
	 * @param auctionName
	 * @param lotName
	 */

	public void buyNow_Timedsale_Bidon(String lotName)

	{
		common.pause(25);
		System.out.println("Step :: Click on My Items");
		common.log("<br></br> Step :: Click on My Items");
		driver.findElement(By.xpath("//ul/li//a[text()='My Items']")).click();
		common.pause(15);

//		System.out.println("Step :: Click on Bidding On");
//		common.log("<br></br> Step :: Click on Bidding On");
//		driver.findElement(By.xpath("//li[@class='tabnav-tab tab-my-items-bidding selected']")).click();
//		common.pause(20);

		System.out.println("Step :: Click on Watchlist");
		common.log("<br></br> Step :: Click on Watchlist");
		driver.findElement(By.xpath(
				"//body/div[@id='wrapper']/form[@id='AdvancedSearch']/div[1]/article[1]/section[1]/div[1]/ul[1]/li[2]/a[1]"))
				.click();
		common.pause(20);

		System.out.println("Step :: Select page from dropdown");
		common.log("<br></br> Step :: Select page from dropdown");
		driver.findElement(By.xpath("//select[@id='lstPageTop']//option[@value='2']")).click();
		common.pause(20);

		for (int i = 0; i < 20; i++) {

			if (common.isElementPresent("//h2//a[text()='" + lotName + "']//..//..//..//input[@type='text']")) {

				System.out.println("Step :: Lot Dispalys");
				common.log("<br></br> Step :: Lot Displays");
				break;

			} else {

				System.out.println("Step :: Lot Not Display and click on next button");
				driver.findElement(By.xpath("//div[@class='filters cat_fltr']//span//a[text()='Next']")).click();
				break;
			}

		}

		System.out.println("Step :: Click on Buy Now Button");
		common.log("<br></br> Step :: Click on Buy Now Button");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='button orng']"))
				.click();
		common.pause(15);

		if (driver.findElement(By.xpath("//input[@value='" + LEGACY_USER_BTN_CONFIRM + "']")).isDisplayed()) {
			common.log("<br></br> Step :: Click on Confirm Button");
			System.out.println("Step :: Click on Confirm Button");
			driver.findElement(By.xpath("//input[@value='" + LEGACY_USER_BTN_CONFIRM + "']")).click();
			common.pause(20);
		} else {
			common.acceptAlert1();
			common.pause(20);
		}

		String youwon = driver.findElement(By.xpath("//div[@class='winner-msg']")).getText();
		System.out.println("Step :: Verify Won Message >> " + youwon);
		common.log("<br></br> Step :: Verify Won Message >> " + youwon);
		common.pause(15);

	}

	/**
	 * Bid Now Timed Auction Confirm
	 * 
	 * @param auctionName
	 * @param lotName
	 * @throws AWTException
	 * @throws InterruptedException
	 */

	public void BidNow_Timedsale_Confirm_SingleUser(String auctionName, String lotName, String lotname1)
			throws AWTException, InterruptedException

	{

		goto_Catalog_Page_Timed_Sale(auctionName); // Goto catalog page

		System.out.println("Step :: Click on Bid Now Button");
		common.log("<br></br> Step :: Click on Bid Now Button");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='orng']")).click();
		common.pause(20);

		common.log("<br></br> Step :: Click on confirm button");
		System.out.println("Step :: Click on confirm button");
		driver.findElement(By.xpath("//input[@id='pblc2']")).click();

		common.pause(15);
		common.acceptAlert();
		common.pause(15);

		System.out.println("Step :: Click on Bid Now Button");
		common.log("<br></br> Step :: Click on Bid Now Button");
		driver.findElement(By.xpath("//h2//a[text()='" + lotname1 + "']//..//..//..//input[@class='orng']")).click();
		common.pause(15);

		common.log("<br></br> Step :: Click on confirm button");
		System.out.println("Step :: Click on confirm button");
		driver.findElement(By.xpath("//input[@id='pblc2']")).click();

		common.pause(20);

		common.acceptAlert();
		common.pause(15);

		String priceinfo = driver.findElement(By.xpath("//ul[@class='" + LEGACY_USER_LOT_PRICE_INFO + "']")).getText();
		System.out.println("Step :: Verify Success Message >> " + priceinfo);
		common.log("<br></br> Step :: Verify Success Message >> " + priceinfo);
		common.pause(5);
	}

	/**
	 * Place Bid Timed Auction Confirm
	 * 
	 * @param auctionName
	 * @param lotName
	 * @throws AWTException
	 * @throws InterruptedException
	 */

	public void PlaceBid_Timedsale_Confirm_SingleUser(String auctionName, String lotName, String lotname1)
			throws AWTException, InterruptedException

	{

		goto_Catalog_Page_Timed_Sale(auctionName); // Goto catalog page

		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMEDSALE_BID_TEXTBOX + "']")).sendKeys("200");
		common.pause(10);

		System.out.println("Step :: Click on Place bid Button");
		common.log("<br></br> Step :: Click on Place Bid Button");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@value='Place bid!']"))
				.click();
		common.pause(25);

		common.log("<br></br> Step :: Click on confirm button");
		System.out.println("Step :: Click on confirm button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_PLACE_MULTIBID_CONFIRM + "']")).click();

		common.pause(15);
		common.acceptAlert();
		common.pause(15);

		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotname1 + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMEDSALE_BID_TEXTBOX + "']")).sendKeys("200");
		common.pause(10);

		System.out.println("Step :: Click on Place bid Button");
		common.log("<br></br> Step :: Click on Place Bid Button");
		driver.findElement(By.xpath("//h2//a[text()='" + lotname1 + "']//..//..//..//input[@value='Place bid!']"))
				.click();
		common.pause(25);

		common.log("<br></br> Step :: Click on confirm button");
		System.out.println("Step :: Click on confirm button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_PLACE_MULTIBID_CONFIRM + "']")).click();

		common.pause(15);
		common.acceptAlert();
		common.pause(15);

		String priceinfo = driver.findElement(By.xpath("//ul[@class='" + LEGACY_USER_LOT_PRICE_INFO + "']")).getText();
		System.out.println("Step :: Verify Success Message >> " + priceinfo);
		common.log("<br></br> Step :: Verify Success Message >> " + priceinfo);

	}

	/**
	 * Change Bid Timed Auction Confirm
	 * 
	 * @param auctionName
	 * @param lotName
	 * @throws AWTException
	 * @throws InterruptedException
	 */

	public void ChangeBid_Timedsale_Confirm_SingleUser(String auctionName, String lotName)
			throws AWTException, InterruptedException

	{

		goto_Catalog_Page_Timed_Sale(auctionName); // Goto catalog page

		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMEDSALE_BID_TEXTBOX + "']")).sendKeys("200");
		common.pause(10);

		System.out.println("Step :: Click on Place bid Button");
		common.log("<br></br> Step :: Click on Place Bid Button");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@value='Place bid!']"))
				.click();
		common.pause(10);

		System.out.println("Step :: Click on Confirm Button");
		common.log("<br></br> Step :: Click on Confirm button");
		driver.findElement(By.xpath("//span//input[@id='" + LEGACY_USER_BTN_PLACE_MULTIBID_CONFIRM + "']")).click();

		common.pause(15);
		System.out.println("Step :: Accept Alert");
		common.log("<br></br> Step :: Accept Alert");
		common.acceptAlert();
		common.pause(50);

		String priceinfo = driver.findElement(By.xpath("//ul[@class='" + LEGACY_USER_LOT_PRICE_INFO + "']")).getText();
		System.out.println("Step :: Verify Success Message >> " + priceinfo);
		common.log("<br></br> Step :: Verify Success Message >> " + priceinfo);

		System.out.println("Step :: Clear Last Bid Value");
		common.log("<br></br> Step :: Clear Last Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMEDSALE_BID_TEXTBOX + "']")).clear();
		common.pause(20);

		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMEDSALE_BID_TEXTBOX + "']")).sendKeys("300");
		common.pause(30);

		System.out.println("Step :: Click on Change bid Button");
		common.log("<br></br> Step :: Click on Change Bid Button");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//input[@value='" + LEGACY_USER_BTN_CHANGE_BID + "']"))
				.click();
		common.pause(30);

		System.out.println("Step :: Click on Confirm Button");
		common.log("<br></br> Step :: Click on Confirm Button");
		driver.findElement(By.xpath("//span//input[@id='" + LEGACY_USER_BTN_PLACE_MULTIBID_CONFIRM + "']")).click();
		common.pause(20);

		System.out.println("Step :: Accept Alert");
		common.log("<br></br> Step :: Accept Alert");
		common.acceptAlert();
		common.pause(30);

		System.out.println("Step :: Clear Last Bid Value");
		common.log("<br></br> Step :: Clear Last Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMEDSALE_BID_TEXTBOX + "']")).clear();
		common.pause(20);

		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMEDSALE_BID_TEXTBOX + "']")).sendKeys("400");
		common.pause(20);

		System.out.println("Step :: Click on Change bid Button");
		common.log("<br></br> Step :: Click on Change Bid Button");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//input[@value='" + LEGACY_USER_BTN_CHANGE_BID + "']"))
				.click();
		common.pause(30);

		common.log("<br></br> Step :: Click on confirm button");
		System.out.println("Step :: Click on confirm button");
		driver.findElement(By.xpath("//span//input[@id='" + LEGACY_USER_BTN_PLACE_MULTIBID_CONFIRM + "']")).click();

		common.pause(30);

		System.out.println("Step :: Accept Alert");
		common.log("<br></br> Step :: Accept Alert");
		common.acceptAlert();
		common.pause(30);

		String priceinfo1 = driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//ul[@class='" + LEGACY_USER_LOT_PRICE_INFO + "']"))
				.getText();
		System.out.println("Step :: Verify Success Message >> " + priceinfo1);
		common.log("<br></br> Step :: Verify Success Message >> " + priceinfo1);
		common.pause(10);
	}

	/**
	 * Force Bid Timed Auction Confirm
	 * 
	 * @param auctionName
	 * @param lotName
	 * @throws AWTException
	 * @throws InterruptedException
	 */

	public void ForceBid_Timedsale_Confirm_SingleUser(String auctionName, String lotName)
			throws AWTException, InterruptedException

	{

		goto_Catalog_Page_Timed_Sale(auctionName); // Goto catalog page

		System.out.println("Step :: Enter Force Bid Value");
		common.log("<br></br> Step :: Enter Force Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMEDSALE_FORCEBID_TEXTBOX + "']")).sendKeys("250");
		common.pause(10);

		System.out.println("Step :: Click on Force bid Button");
		common.log("<br></br> Step :: Click on Force Bid Button");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//input[@value='" + LEGACY_USER_BTN_FORCE_BID + "']"))
				.click();
		common.pause(20);
		System.out.println("Step :: Click on Confirm Button");
		common.log("<br></br> Step :: Click on Confirm button");
		driver.findElement(By.xpath("//span//input[@id='" + LEGACY_USER_BTN_PLACE_MULTIBID_CONFIRM + "']")).click();
		common.pause(20);
		System.out.println("Step :: Accept Alert");
		common.log("<br></br> Step :: Accept Alert");
		common.acceptAlert();
		common.pause(15);

		String priceinfo = driver.findElement(By.xpath("//ul[@class='" + LEGACY_USER_LOT_PRICE_INFO + "']")).getText();
		System.out.println("Step :: Verify Success Message >> " + priceinfo);
		common.log("<br></br> Step :: Verify Success Message >> " + priceinfo);

		System.out.println("Step :: Enter Force Bid Value");
		common.log("<br></br> Step :: Enter Force Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMEDSALE_FORCEBID_TEXTBOX + "']")).sendKeys("350");
		common.pause(10);

		System.out.println("Step :: Click on Force bid Button");
		common.log("<br></br> Step :: Click on Force Bid Button");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//input[@value='" + LEGACY_USER_BTN_FORCE_BID + "']"))
				.click();
		common.pause(10);

		System.out.println("Step :: Click on Confirm Button");
		common.log("<br></br> Step :: Click on Confirm button");
		driver.findElement(By.xpath("//span//input[@id='" + LEGACY_USER_BTN_PLACE_MULTIBID_CONFIRM + "']")).click();

		common.pause(10);
		System.out.println("Step :: Accept Alert");
		common.log("<br></br> Step :: Accept Alert");
		common.acceptAlert();
		common.pause(15);

		String priceinfo1 = driver.findElement(By.xpath("//ul[@class='" + LEGACY_USER_LOT_PRICE_INFO + "']")).getText();
		System.out.println("Step :: Verify Success Message >> " + priceinfo1);
		common.log("<br></br> Step :: Verify Success Message >> " + priceinfo1);

	}

	/**
	 * Place Mutiple Bid Confirm Single User Timed Auction
	 * 
	 * @param auctionName
	 * @param lotName
	 * @throws AWTException
	 * @throws InterruptedException
	 */

	public void Place_Multiple_Bid_Timedsale_Confirm_SingleUser(String auctionName, String lotName, String lotName1,
			String lotName2) throws AWTException, InterruptedException

	{

		goto_Catalog_Page_Timed_Sale(auctionName); // Goto catalog page

		common.pause(20);
		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMEDSALE_BID_TEXTBOX + "']")).sendKeys("250");
		common.pause(10);

		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName1 + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMEDSALE_BID_TEXTBOX + "']")).sendKeys("250");
		common.pause(10);

		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName2 + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMEDSALE_BID_TEXTBOX + "']")).sendKeys("250");
		common.pause(10);

		System.out.println("Step :: Click on place multibid button");
		common.log("<br></br> Step :: Click on place multibid button");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_USER_BTN_PLACE_MULTIBID + "']")).click();

		common.pause(10);
		System.out.println("Step :: Accept Alert");
		common.log("<br></br> Step :: Accept Alert");
		common.acceptAlert1();
		common.pause(30);

		String priceinfo = driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//ul[@class='" + LEGACY_USER_LOT_PRICE_INFO + "']"))
				.getText();
		System.out.println("Step :: Verify Success Message >> " + priceinfo);
		common.log("<br></br> Step :: Verify Success Message >> " + priceinfo);
		common.pause(15);

		String priceinfo1 = driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName1 + "']//..//..//..//ul[@class='" + LEGACY_USER_LOT_PRICE_INFO + "']"))
				.getText();
		System.out.println("Step :: Verify Success Message >> " + priceinfo1);
		common.log("<br></br> Step :: Verify Success Message >> " + priceinfo1);
		common.pause(15);

		String priceinfo2 = driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName2 + "']//..//..//..//ul[@class='" + LEGACY_USER_LOT_PRICE_INFO + "']"))
				.getText();
		System.out.println("Step :: Verify Success Message >> " + priceinfo2);
		common.log("<br></br> Step :: Verify Success Message >> " + priceinfo2);

	}

	/**
	 * Bid x From Lot Details Page User Confirmation
	 * 
	 * @param auctionName
	 * @param lotName
	 * @throws AWTException
	 * @throws InterruptedException
	 */

	public void BidNow_From_LotDetails_UserConfirmation_Timedsale(String auctionName, String lotName, String lotname1)
			throws AWTException, InterruptedException

	{

		goto_Catalog_Page_Timed_Sale(auctionName); // Goto catalog page

		System.out.println("Step :: Click on Lot Details Page");
		common.log("<br></br> Step :: Click on Lot Details Page");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']")).click();
		common.pause(15);

		System.out.println("Step :: Click on Bid Now Button");
		common.log("<br></br> Step :: Click on Bid Now Button");
		driver.findElement(
				By.xpath("//div[@class='unibtn bidding bidding-next']//span//input[@class='button orng next-bid']"))
				.click();
		common.pause(30);

		common.log("<br></br> Step :: Click on confirm button");
		System.out.println("Step :: Click on confirm button");
		driver.findElement(By.xpath("//input[@value='" + LEGACY_USER_BTN_CONFIRM + "']")).click();
		common.pause(20);
		common.acceptAlert();
		common.pause(30);

		common.log("<br></br> Step :: Click on catalog");
		System.out.println("Step :: Click on catalog");
		driver.findElement(By.xpath("//section[@class='auctitle auc_dtl_title auc_mob_dis']//a[text()='Catalog']"))
				.click();
		common.pause(20);

		System.out.println("Step :: Click on Lot Details Page");
		common.log("<br></br> Step :: Click on Lot Details Page");
		driver.findElement(By.xpath("//h2//a[text()='" + lotname1 + "']")).click();
		common.pause(15);

		System.out.println("Step :: Click on Bid Now Button");
		common.log("<br></br> Step :: Click on Bid Now Button");
		driver.findElement(
				By.xpath("//div[@class='unibtn bidding bidding-next']//span//input[@class='button orng next-bid']"))
				.click();
		common.pause(30);

		common.log("<br></br> Step :: Click on confirm button");
		System.out.println("Step :: Click on confirm button");
		driver.findElement(By.xpath("//input[@value='" + LEGACY_USER_BTN_CONFIRM + "']")).click();
		common.pause(20);
		common.acceptAlert();
		common.pause(15);

		String higherbidder1 = driver.findElement(By.xpath("//span[@class='bid-status-owner']")).getText();
		System.out.println("Step :: Higher Bidder New Label is >> " + higherbidder1);

	}// li[@class='item-currentbid']

	/**
	 * Place Bid From Lot Details Timed Auction User Confirmation
	 * 
	 * @param auctionName
	 * @param lotName
	 * @throws AWTException
	 * @throws InterruptedException
	 */

	public void Place_TimedBid_Lotdetails_UserConfirmation(String auctionName, String lotName, String lotname1)
			throws AWTException, InterruptedException

	{

		goto_Catalog_Page_Timed_Sale(auctionName); // Goto catalog page

		System.out.println("Step :: Click on Lot Details Page");
		common.log("<br></br> Step :: Click on Lot Details Page");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']")).click();
		common.pause(15);

		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//input[@class='mrg txt-max-bid']")).sendKeys("200");
		common.pause(10);

		System.out.println("Step :: Click on Place bid Button");
		common.log("<br></br> Step :: Click on Place Bid Button");
		driver.findElement(By.xpath("//input[@value='Place bid!']")).click();
		common.pause(10);

		common.log("<br></br> Step :: Click on confirm button");
		System.out.println("Step :: Click on confirm button");
		driver.findElement(By.xpath("//input[@value='" + LEGACY_USER_BTN_CONFIRM + "']")).click();
		common.pause(20);

		common.pause(20);
		common.acceptAlert();
		common.pause(30);

		common.log("<br></br> Step :: Click on catalog");
		System.out.println("Step :: Click on catalog");
		driver.findElement(By.xpath("//section[@class='auctitle auc_dtl_title auc_mob_dis']//a[text()='Catalog']"))
				.click();
		common.pause(20);

		System.out.println("Step :: Click on Lot Details Page");
		common.log("<br></br> Step :: Click on Lot Details Page");
		driver.findElement(By.xpath("//h2//a[text()='" + lotname1 + "']")).click();
		common.pause(15);

		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//input[@class='mrg txt-max-bid']")).sendKeys("300");
		common.pause(10);

		System.out.println("Step :: Click on Place bid Button");
		common.log("<br></br> Step :: Click on Place Bid Button");
		driver.findElement(By.xpath("//input[@value='Place bid!']")).click();
		common.pause(10);

		common.log("<br></br> Step :: Click on confirm button");
		System.out.println("Step :: Click on confirm button");
		driver.findElement(By.xpath("//input[@value='" + LEGACY_USER_BTN_CONFIRM + "']")).click();
		common.pause(30);
		System.out.println("Step :: Click on Accept Alert");
		common.log("<br><\br> Step :: Click on Accept Alert");
		common.pause(30);
		common.acceptAlert();
		common.pause(15);
		String Highbid = driver.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_HIGH_BID_MESSAGE_CLASS + "']"))
				.getText();
		System.out.println("Step :: Verify Success Message >> " + Highbid);
		common.log("<br></br> Step :: Verify Success Message >> " + Highbid);

	}

	/**
	 * Change Bid Lot Details Timed Auction User Confirmation
	 * 
	 * @param auctionName
	 * @param lotName
	 * @throws AWTException
	 * @throws InterruptedException
	 */

	public void Change_Bid_LotDetails_Timedsale_User_Confirmation(String auctionName, String lotName)
			throws AWTException, InterruptedException

	{

		goto_Catalog_Page_Timed_Sale(auctionName); // Goto catalog page

		System.out.println("Step :: Click on Lot Details Page");
		common.log("<br></br> Step :: Click on Lot Details Page");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']")).click();
		common.pause(15);

		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//input[@class='mrg txt-max-bid']")).sendKeys("200");
		common.pause(10);

		System.out.println("Step :: Click on Place bid Button");
		common.log("<br></br> Step :: Click on Place Bid Button");
		driver.findElement(By.xpath("//input[@value='Place bid!']")).click();
		common.pause(20);

		common.log("<br></br> Step :: Click on confirm button");
		System.out.println("Step :: Click on confirm button");
		driver.findElement(By.xpath("//span//input[@id='" + LEGACY_USER_BTN_PLACE_MULTIBID_CONFIRM + "']")).click();
		common.pause(10);

		System.out.println("Step :: Click on Accept Alert");
		common.log("<br><\br> Step :: Click on Accept Alert");
		common.acceptAlert();

		common.pause(30);
		String priceinfo = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_HIGH_BID_MESSAGE_CLASS + "']")).getText();
		System.out.println("Step :: Verify Success Message >> " + priceinfo);
		common.log("<br></br> Step :: Verify Success Message >> " + priceinfo);

		System.out.println("Step :: Clear Last Bid Value");
		common.log("<br></br> Step :: Clear Last Bid Value");
		driver.findElement(By.xpath("//input[@class='mrg txt-max-bid']")).clear();
		common.pause(10);

		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//input[@class='mrg txt-max-bid']")).sendKeys("300");
		common.pause(10);

		System.out.println("Step :: Click on Change bid Button");
		common.log("<br></br> Step :: Click on Change Bid Button");
		driver.findElement(By.xpath("//input[@value='" + LEGACY_USER_BTN_CHANGE_BID + "']")).click();
		common.pause(10);

		common.log("<br></br> Step :: Click on confirm button");
		System.out.println("Step :: Click on confirm button");
		driver.findElement(By.xpath("//span//input[@id='" + LEGACY_USER_BTN_PLACE_MULTIBID_CONFIRM + "']")).click();
		common.pause(10);
		;

		System.out.println("Step :: Clear Last Bid Value");
		common.log("<br></br> Step :: Clear Last Bid Value");
		driver.findElement(By.xpath("//input[@class='mrg txt-max-bid']")).clear();
		common.pause(10);

		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//input[@class='mrg txt-max-bid']")).sendKeys("500");
		common.pause(10);

		System.out.println("Step :: Click on Change bid Button");
		common.log("<br></br> Step :: Click on Change Bid Button");
		driver.findElement(By.xpath("//input[@value='" + LEGACY_USER_BTN_CHANGE_BID + "']")).click();
		common.pause(10);

		System.out.println("Step :: Click on Confirm Button");
		common.log("<br></br> Step :: Click on Confirm button");
		driver.findElement(By.xpath("//span//input[@id='" + LEGACY_USER_BTN_PLACE_MULTIBID_CONFIRM + "']")).click();

		common.pause(10);
		System.out.println("Step :: Accept Alert");
		common.log("<br></br> Step :: Accept Alert");
		common.acceptAlert();
		common.pause(30);

		String priceinfo1 = driver
				.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_HIGH_BID_MESSAGE_CLASS + "']")).getText();
		System.out.println("Step :: Verify Success Message >> " + priceinfo1);
		common.log("<br></br> Step :: Verify Success Message >> " + priceinfo1);

	}

	/**
	 * Place Force Bid From Lot Details User confirmation Timed Auction
	 * 
	 * @param auctionName
	 * @param lotName
	 * @throws AWTException
	 * @throws InterruptedException
	 */

	public void Place_Force_bid_TimedBid_Lotdetails_User_Confirmation(String auctionName, String lotName)
			throws AWTException, InterruptedException

	{

		goto_Catalog_Page_Timed_Sale(auctionName); // Goto catalog page
		common.pause(30);

		System.out.println("Step :: Click on Lot Details Page");
		common.log("<br></br> Step :: Click on Lot Details Page");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']")).click();
		common.pause(15);

		System.out.println("Step :: Enter Force Bid Value");
		common.log("<br></br> Step :: Enter Force Bid Value");
		driver.findElement(By.xpath("//input[@class='txt-force-bid']")).sendKeys("200");
		common.pause(10);

		System.out.println("Step :: Click on Force bid Button");
		common.log("<br></br> Step :: Click on Force Bid Button");
		driver.findElement(By.xpath("//input[@class='orng force-bid']")).click();
		common.pause(20);

		String Highbid = driver.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_HIGH_BID_MESSAGE_CLASS + "']"))
				.getText();
		System.out.println("Step :: Verify Success Message >> " + Highbid);
		common.log("<br></br> Step :: Verify Success Message >> " + Highbid);

	}

	/**
	 * Place Bid Timed Auction Bid Confirmation
	 * 
	 * @param auctionName
	 * @param lotName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void Place_Bid_Timedsale_Bid_Confirmation(String auctionName, String lotName)
			throws InterruptedException, AWTException

	{

		goto_Catalog_Page_Timed_Sale(auctionName); // Goto catalog page

		common.pause(20);

		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMEDSALE_BID_TEXTBOX + "']")).sendKeys("200");
		common.pause(10);

		System.out.println("Step :: Click on Place bid Button");
		common.log("<br></br> Step :: Click on Place Bid Button");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@value='Place bid!']"))
				.click();
		common.pause(10);

		String bidsec = driver
				.findElement(
						By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='blu inline-confirm']"))
				.getAttribute("value");
		System.out.println("Step :: Bid Button Counter >> " + bidsec);
		common.log("<br></br> Step :: Bid Button Counter >> " + bidsec);
		common.pause(5);
		String bidsec1 = driver
				.findElement(
						By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='blu inline-confirm']"))
				.getAttribute("value");
		System.out.println("Step :: Bid Button Counter >> " + bidsec1);
		common.log("<br></br> Step :: Bid Button Counter >> " + bidsec1);
		common.pause(5);
		String bidsec2 = driver
				.findElement(
						By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='blu inline-confirm']"))
				.getAttribute("value");
		System.out.println("Step :: Bid Button Counter >> " + bidsec2);
		common.log("<br></br> Step :: Bid Button Counter >> " + bidsec2);

		Thread.sleep(15000);

		System.out.println("Step :: Click on Place bid Button");
		common.log("<br></br> Step :: Click on Place Bid Button");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@value='Place bid!']"))
				.click();
		common.pause(10);

		System.out.println("Step :: Click on Confirm Bid Now Button");
		common.log("<br></br> Step :: Click on Confirm Bid Now Button");
		driver.findElement(
				By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='blu button inline-confirm']"))
				.click();
		common.pause(15);

		common.acceptAlert1();
		common.pause(10);
		String priceinfo = driver.findElement(By.xpath("//ul[@class='" + LEGACY_USER_LOT_PRICE_INFO + "']")).getText();
		System.out.println("Step :: Verify Success Message >> " + priceinfo);
		common.log("<br></br> Step :: Verify Success Message >> " + priceinfo);

	}

	/**
	 * Bid Now x Timed Auction Bid Confirmation
	 * 
	 * @param auctionName
	 * @param lotName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void BidNow_x_Timedsale_Bid_Confirmation(String auctionName, String lotName)
			throws InterruptedException, AWTException

	{

		goto_Catalog_Page_Timed_Sale(auctionName); // Goto catalog page
		common.pause(20);

		System.out.println("Step :: Click on Bid Now Button");
		common.log("<br></br> Step :: Click on Bid Now Button");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='orng']")).click();
		common.pause(5);

		String bidx = driver
				.findElement(
						By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='orng inline-confirm']"))
				.getAttribute("value");
		System.out.println("Step :: Bid Button Counter >> " + bidx);
		common.log("<br></br> Step :: Bid Button Counter >> " + bidx);
		common.pause(5);
		String bidx1 = driver
				.findElement(
						By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='orng inline-confirm']"))
				.getAttribute("value");
		System.out.println("Step :: Bid Button Counter >> " + bidx1);
		common.log("<br></br> Step :: Bid Button Counter >> " + bidx1);
		common.pause(5);
		String bidx2 = driver
				.findElement(
						By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='orng inline-confirm']"))
				.getAttribute("value");
		System.out.println("Step :: Bid Button Counter >> " + bidx2);
		common.log("<br></br> Step :: Bid Button Counter >> " + bidx2);

		Thread.sleep(15000);

		System.out.println("Step :: Click on Bid Now Button");
		common.log("<br></br> Step :: Click on Bid Now Button");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='orng button']"))
				.click();
		common.pause(10);

		System.out.println("Step :: Click on Confirm Bid Now Button");
		common.log("<br></br> Step :: Click on Confirm Bid Now Button");
		driver.findElement(
				By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='orng button inline-confirm']"))
				.click();
		common.pause(15);
		common.acceptAlert1();
		common.pause(15);
		String priceinfo = driver.findElement(By.xpath("//ul[@class='" + LEGACY_USER_LOT_PRICE_INFO + "']")).getText();
		System.out.println("Step :: Verify Success Message >> " + priceinfo);
		common.log("<br></br> Step :: Verify Success Message >> " + priceinfo);

	}

	/**
	 * Chnage Bid Timed Auction Bid Confirmation
	 * 
	 * @param auctionName
	 * @param lotName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void Change_Bid_Timedsale_Bid_Confirmation(String auctionName, String lotName)
			throws InterruptedException, AWTException

	{

		goto_Catalog_Page_Timed_Sale(auctionName); // Goto catalog page

		common.pause(20);

		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMEDSALE_BID_TEXTBOX + "']")).sendKeys("200");
		common.pause(10);

		System.out.println("Step :: Click on Place bid Button");
		common.log("<br></br> Step :: Click on Place Bid Button");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@value='Place bid!']"))
				.click();
		common.pause(10);

		String bidsec = driver
				.findElement(
						By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='blu inline-confirm']"))
				.getAttribute("value");
		System.out.println("Step :: Bid Button Counter >> " + bidsec);
		common.log("<br></br> Step :: Bid Button Counter >> " + bidsec);
		common.pause(5);
		String bidsec1 = driver
				.findElement(
						By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='blu inline-confirm']"))
				.getAttribute("value");
		System.out.println("Step :: Bid Button Counter >> " + bidsec1);
		common.log("<br></br> Step :: Bid Button Counter >> " + bidsec1);
		common.pause(5);
		String bidsec2 = driver
				.findElement(
						By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='blu inline-confirm']"))
				.getAttribute("value");
		System.out.println("Step :: Bid Button Counter >> " + bidsec2);
		common.log("<br></br> Step :: Bid Button Counter >> " + bidsec2);

		Thread.sleep(15000);

		System.out.println("Step :: Click on Place bid Button");
		common.log("<br></br> Step :: Click on Place Bid Button");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@value='Place bid!']"))
				.click();
		common.pause(5);

		System.out.println("Step :: Click on Confirm Bid Now Button");
		common.log("<br></br> Step :: Click on Confirm Bid Now Button");
		driver.findElement(
				By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='blu button inline-confirm']"))
				.click();
		common.pause(15);

		common.acceptAlert1();
		common.pause(20);

		String priceinfo = driver.findElement(By.xpath("//ul[@class='" + LEGACY_USER_LOT_PRICE_INFO + "']")).getText();
		System.out.println("Step :: Verify Success Message >> " + priceinfo);
		common.log("<br></br> Step :: Verify Success Message >> " + priceinfo);
		common.pause(10);
		// Clear Bid Value

		System.out.println("Step :: Clear Bid Value");
		common.log("<br></br> Step :: Clear Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMEDSALE_BID_TEXTBOX + "']")).clear();
		common.pause(10);
		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMEDSALE_BID_TEXTBOX + "']")).sendKeys("300");
		common.pause(5);

		System.out.println("Step :: Click on Change bid Button");
		common.log("<br></br> Step :: Click on Change Bid Button");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//input[@value='" + LEGACY_USER_BTN_CHANGE_BID + "']"))
				.click();
		common.pause(5);

		String changebidbutton = driver
				.findElement(
						By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='blu inline-confirm']"))
				.getAttribute("value");
		System.out.println("Step :: ChangeBid Button Counter >> " + changebidbutton);
		common.log("<br></br> Step :: ChangeBid Button Counter >> " + changebidbutton);

		String changebidbutton1 = driver
				.findElement(
						By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='blu inline-confirm']"))
				.getAttribute("value");
		System.out.println("Step :: ChangeBid Button Counter >> " + changebidbutton1);
		common.log("<br></br> Step :: ChangeBid Button Counter >> " + changebidbutton1);

		String changebidbutton2 = driver
				.findElement(
						By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='blu inline-confirm']"))
				.getAttribute("value");
		System.out.println("Step :: ChangeBid Button Counter >> " + changebidbutton2);
		common.log("<br></br> Step :: ChangeBid Button Counter >> " + changebidbutton2);

		common.pause(50);

		System.out.println("Step :: Click on Place bid Button");
		common.log("<br></br> Step :: Click on Place Bid Button");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']"))
				.click();
		common.pause(10);

		System.out.println("Step :: Click on Confirm Bid Now Button");
		common.log("<br></br> Step :: Click on Confirm Bid Now Button");
		driver.findElement(
				By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='blu button inline-confirm']"))
				.click();
		common.pause(15);

		common.acceptAlert1();
		common.pause(20);
		String priceinfo1 = driver.findElement(By.xpath("//ul[@class='" + LEGACY_USER_LOT_PRICE_INFO + "']")).getText();
		System.out.println("Step :: Verify Success Message >> " + priceinfo1);
		common.log("<br></br> Step :: Verify Success Message >> " + priceinfo1);

	}

	/**
	 * Force Bid Timed Auction Bid Confirmation
	 * 
	 * @param auctionName
	 * @param lotName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void Force_Bid_Timedsale_Bid_Confirmation(String auctionName, String lotName)
			throws InterruptedException, AWTException

	{

		goto_Catalog_Page_Timed_Sale(auctionName); // Goto catalog page

		common.pause(20);

		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_TXT_TIMEDSALE_FORCEBID_TEXTBOX + "']")).sendKeys("200");
		common.pause(10);

		System.out.println("Step :: Click on Force bid Button");
		common.log("<br></br> Step :: Click on Force Bid Button");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//input[@value='" + LEGACY_USER_BTN_FORCE_BID + "']"))
				.click();
		common.pause(10);

		String bidsec = driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_BTN_FORCE_BID_COUNTER + "']")).getAttribute("value");
		System.out.println("Step :: Bid Button Counter >> " + bidsec);
		common.log("<br></br> Step :: Bid Button Counter >> " + bidsec);
		common.pause(5);
		String bidsec1 = driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_BTN_FORCE_BID_COUNTER + "']")).getAttribute("value");
		System.out.println("Step :: Bid Button Counter >> " + bidsec1);
		common.log("<br></br> Step :: Bid Button Counter >> " + bidsec1);
		common.pause(5);
		String bidsec2 = driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_BTN_FORCE_BID_COUNTER + "']")).getAttribute("value");
		System.out.println("Step :: Bid Button Counter >> " + bidsec2);
		common.log("<br></br> Step :: Bid Button Counter >> " + bidsec2);

		Thread.sleep(15000);

		System.out.println("Step :: Click on Force bid Button");
		common.log("<br></br> Step :: Click on Force Bid Button");
		driver.findElement(By.xpath(
				"//h2//a[text()='" + lotName + "']//..//..//..//input[@value='" + LEGACY_USER_BTN_FORCE_BID + "']"))
				.click();
		common.pause(10);

		System.out.println("Step :: Click on Confirm Bid Now Button");
		common.log("<br></br> Step :: Click on Confirm Bid Now Button");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"
				+ LEGACY_USER_BTN_FORCE_BID_CONFIRM + "']")).click();
		common.pause(25);

		common.acceptAlert1();
		common.pause(20);
		String priceinfo = driver.findElement(By.xpath("//ul[@class='" + LEGACY_USER_LOT_PRICE_INFO + "']")).getText();
		System.out.println("Step :: Verify Success Message >> " + priceinfo);
		common.log("<br></br> Step :: Verify Success Message >> " + priceinfo);

	}

	/**
	 * Bid Now x Timed Auction Bid Confirmation Lot Details
	 * 
	 * @param auctionName
	 * @param lotName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void BidNow_x_Timedsale_Bid_Confirmation_Lot_Details(String auctionName, String lotName)
			throws InterruptedException, AWTException

	{

		goto_Catalog_Page_Timed_Sale(auctionName); // Goto catalog page
		common.pause(20);

		System.out.println("Step :: Click on Lot Details Page");
		common.log("<br></br> Step :: Click on Lot Details Page");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']")).click();
		common.pause(15);

		System.out.println("Step :: Click on Bid Now Button");
		common.log("<br></br> Step :: Click on Bid Now Button");
		driver.findElement(By.xpath("//input[@class='" + LEGACY_USER_BTN_PLACEBID_LOTDETAILS + "']")).click();
		common.pause(5);

		String bidx = driver.findElement(By.xpath("//input[@class='" + LEGACY_USER_BTN_PLACEBID_COUNTER + "']"))
				.getAttribute("value");
		System.out.println("Step :: Bid Button Counter >> " + bidx);
		common.log("<br></br> Step :: Bid Button Counter >> " + bidx);
		common.pause(5);
		String bidx1 = driver.findElement(By.xpath("//input[@class='" + LEGACY_USER_BTN_PLACEBID_COUNTER + "']"))
				.getAttribute("value");
		System.out.println("Step :: Bid Button Counter >> " + bidx1);
		common.log("<br></br> Step :: Bid Button Counter >> " + bidx1);
		common.pause(5);
		String bidx2 = driver.findElement(By.xpath("//input[@class='" + LEGACY_USER_BTN_PLACEBID_COUNTER + "']"))
				.getAttribute("value");
		System.out.println("Step :: Bid Button Counter >> " + bidx2);
		common.log("<br></br> Step :: Bid Button Counter >> " + bidx2);

		Thread.sleep(15000);

		System.out.println("Step :: Click on Bid Now Button");
		common.log("<br></br> Step :: Click on Bid Now Button");
		driver.findElement(By.xpath("//input[@class='" + LEGACY_USER_BTN_PLACEBID_LOTDETAILS + "']")).click();
		common.pause(5);

		System.out.println("Step :: Click on Confirm Bid Now Button");
		common.log("<br></br> Step :: Click on Confirm Bid Now Button");
		driver.findElement(By.xpath("//input[@class='" + LEGACY_USER_BTN_PLACEBID_COUNTER + "']")).click();
		common.pause(15);

		String Highbid = driver.findElement(By.xpath("//span[@class='" + LEGACY_USER_TXT_HIGH_BID_MESSAGE_CLASS + "']"))
				.getText();
		System.out.println("Step :: Verify Success Message >> " + Highbid);
		common.log("<br></br> Step :: Verify Success Message >> " + Highbid);

		System.out.println("Step :: Verify Success Message Present");
		common.log("<br></br> Step :: Verify Sucess Message Present");
		common.assertElementPresent("// span[text()='Your bid has been placed successfully!']");
	}

	/**
	 * Place Bid Timed Auction Bid Confirmation Lot Details
	 * 
	 * @param auctionName
	 * @param lotName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void Place_Bid_Timedsale_Bid_Confirmation_Lot_Details(String auctionName, String lotName)
			throws InterruptedException, AWTException

	{

		goto_Catalog_Page_Timed_Sale(auctionName); // Goto catalog page
		common.pause(20);

		System.out.println("Step :: Click on Lot Details Page");
		common.log("<br></br> Step :: Click on Lot Details Page");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']")).click();
		common.pause(15);

		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//input[@class='mrg txt-max-bid']")).sendKeys("200");
		common.pause(10);

		System.out.println("Step :: Click on Place Bid Button");
		common.log("<br></br> Step :: Click on Place Bid Button");
		driver.findElement(By.xpath("//input[@value='Place bid!']")).click();
		common.pause(5);

		String bidx = driver.findElement(By.xpath("//input[@class='orng place-bid inline-confirm']"))
				.getAttribute("value");
		System.out.println("Step :: Bid Button Counter >> " + bidx);
		common.log("<br></br> Step :: Bid Button Counter >> " + bidx);

		String bidx1 = driver.findElement(By.xpath("//input[@class='orng place-bid inline-confirm']"))
				.getAttribute("value");
		System.out.println("Step :: Bid Button Counter >> " + bidx1);
		common.log("<br></br> Step :: Bid Button Counter >> " + bidx1);

		String bidx2 = driver.findElement(By.xpath("//input[@class='orng place-bid inline-confirm']"))
				.getAttribute("value");
		System.out.println("Step :: Bid Button Counter >> " + bidx2);
		common.log("<br></br> Step :: Bid Button Counter >> " + bidx2);
		common.pause(60);

		System.out.println("Step :: Click on Place Bid Button");
		common.log("<br></br> Step :: Click on Place Bid Button");
		driver.findElement(By.xpath("//input[@value='Place bid!']")).click();
		common.pause(5);

		System.out.println("Step :: Click on Confirm Bid Now Button");
		common.log("<br></br> Step :: Click on Confirm Bid Now Button");
		driver.findElement(By.xpath("//input[@class='orng place-bid button inline-confirm']")).click();
		common.pause(15);

		String Highbid = driver.findElement(By.xpath("//span[@class='left cur_bid']")).getText();
		System.out.println("Step :: Verify Success Message >> " + Highbid);
		common.log("<br></br> Step :: Verify Success Message >> " + Highbid);

		System.out.println("Step :: Verify Success Message Present");
		common.log("<br></br> Step :: Verify Sucess Message Present");
		common.assertElementPresent("//span[text()='Your bid has been placed successfully!']");
	}

	/**
	 * Change Bid Timed Auction Bid Confirmation Lot Details
	 * 
	 * @param auctionName
	 * @param lotName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void Change_Bid_Timedsale_Bid_Confirmation_Lot_Details(String auctionName, String lotName)
			throws InterruptedException, AWTException

	{

		goto_Catalog_Page_Timed_Sale(auctionName); // Goto catalog page
		common.pause(20);

		System.out.println("Step :: Click on Lot Details Page");
		common.log("<br></br> Step :: Click on Lot Details Page");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']")).click();
		common.pause(20);

		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//input[@class='mrg txt-max-bid']")).sendKeys("200");
		common.pause(10);

		System.out.println("Step :: Click on Place Bid Button");
		common.log("<br></br> Step :: Click on Place Bid Button");
		driver.findElement(By.xpath("//input[@value='Place bid!']")).click();
		common.pause(5);

		String bidx = driver.findElement(By.xpath("//input[@class='orng place-bid inline-confirm']"))
				.getAttribute("value");
		System.out.println("Step :: Bid Button Counter >> " + bidx);
		common.log("<br></br> Step :: Bid Button Counter >> " + bidx);

		String bidx1 = driver.findElement(By.xpath("//input[@class='orng place-bid inline-confirm']"))
				.getAttribute("value");
		System.out.println("Step :: Bid Button Counter >> " + bidx1);
		common.log("<br></br> Step :: Bid Button Counter >> " + bidx1);

		String bidx2 = driver.findElement(By.xpath("//input[@class='orng place-bid inline-confirm']"))
				.getAttribute("value");
		System.out.println("Step :: Bid Button Counter >> " + bidx2);
		common.log("<br></br> Step :: Bid Button Counter >> " + bidx2);

		common.pause(60);

		System.out.println("Step :: Click on Place Bid Button");
		common.log("<br></br> Step :: Click on Place Bid Button");
		driver.findElement(By.xpath("//input[@value='Place bid!']")).click();

		common.pause(1);
		System.out.println("Step :: Click on Confirm Bid Now Button");
		driver.findElement(By.xpath("//input[@type='button' and @class='" + LEGACY_USER_BTN_PLACEBID_CONFIRM + "']"))
				.click();
		// driver.findElement(By.xpath("//input[@class='" +
		// LEGACY_USER_BTN_PLACEBID_CONFIRM + "']")).click();
		common.log("<br></br> Step :: Click on Confirm Bid Now Button");

		common.pause(15);

		System.out.println("Step :: Clear Bid Value");
		common.log("<br></br> Step :: Clear Bid Value");
		driver.findElement(By.xpath("//input[@class='mrg txt-max-bid']")).clear();
		common.pause(10);

		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//input[@class='mrg txt-max-bid']")).sendKeys("300");
		common.pause(10);

		System.out.println("Step :: Click on Place bid Button");
		common.log("<br></br> Step :: Click on Place Bid Button");
		driver.findElement(By.xpath("//input[@value='Place bid!']")).click();
		common.pause(20);
		// common.acceptAlert1();

		common.pause(15);
		String changebid = driver.findElement(By.xpath("//input[@class='orng place-bid inline-confirm']"))
				.getAttribute("value");
		System.out.println("Step :: Bid Button Counter >> " + changebid);
		common.log("<br></br> Step :: Bid Button Counter >> " + changebid);

		String changebid1 = driver.findElement(By.xpath("//input[@class='orng place-bid inline-confirm']"))
				.getAttribute("value");
		System.out.println("Step :: Bid Button Counter >> " + changebid1);
		common.log("<br></br> Step :: Bid Button Counter >> " + changebid1);

		String changebid2 = driver.findElement(By.xpath("//input[@class='orng place-bid inline-confirm']"))
				.getAttribute("value");
		System.out.println("Step :: Bid Button Counter >> " + changebid2);
		common.log("<br></br> Step :: Bid Button Counter >> " + changebid2);
		common.pause(60);

		System.out.println("Step :: Click on Place Bid Button");
		common.log("<br></br> Step :: Click on Place Bid Button");
		driver.findElement(By.xpath("//input[@value='Place bid!']")).click();

		common.pause(5);
		System.out.println("Step :: Click on Confirm Bid Now Button");
		common.log("<br></br> Step :: Click on Confirm Bid Now Button");
		driver.findElement(By.xpath("//input[@class='" + LEGACY_USER_BTN_PLACEBID_CONFIRM + "]")).click();
		common.pause(15);

		System.out.println("Step :: Clear Bid Value");
		common.log("<br></br> Step :: Clear Bid Value");
		driver.findElement(By.xpath("//input[@class='mrg txt-max-bid']")).clear();

		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//input[@class='mrg txt-max-bid']")).sendKeys("400");
		common.pause(10);

		System.out.println("Step :: Click on Place Bid Button");
		common.log("<br></br> Step :: Click on Place Bid Button");
		driver.findElement(By.xpath("//input[@value='Place bid!']")).click();

		System.out.println("Step :: Click on Confirm Bid Now Button");
		common.log("<br></br> Step :: Click on Confirm Bid Now Button");
		driver.findElement(By.xpath("//input[@class='" + LEGACY_USER_BTN_PLACEBID_CONFIRM + "]")).click();
		common.pause(15);

		System.out.println("Step :: Clear Bid Value");
		common.log("<br></br> Step :: Clear Bid Value");
		driver.findElement(By.xpath("//input[@class='mrg txt-max-bid']")).clear();

		System.out.println("Step :: Enter Place Bid Value");
		common.log("<br></br> Step :: Enter Place Bid Value");
		driver.findElement(By.xpath("//input[@class='mrg txt-max-bid']")).sendKeys("500");
		common.pause(10);

		System.out.println("Step :: Click on Place Bid Button");
		common.log("<br></br> Step :: Click on Place Bid Button");
		driver.findElement(By.xpath("//input[@value='Place bid!']")).click();

		System.out.println("Step :: Click on Confirm Bid Now Button");
		common.log("<br></br> Step :: Click on Confirm Bid Now Button");
		driver.findElement(By.xpath("//input[@class='" + LEGACY_USER_BTN_PLACEBID_CONFIRM + "]")).click();
		common.pause(15);

		String Highbid = driver.findElement(By.xpath("//span[@class='left cur_bid']")).getText();
		System.out.println("Step :: Verify Success Message >> " + Highbid);
		common.log("<br></br> Step :: Verify Success Message >> " + Highbid);

		System.out.println("Step :: Verify Success Message Present");
		common.log("<br></br> Step :: Verify Sucess Message Present");
		common.assertElementPresent("// span[text()='Your bid has been placed successfully!']");
	}

	/**
	 * Force Bid Timed Auction Bid Confirmation Lot Details
	 * 
	 * @param auctionName
	 * @param lotName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void Force_Bid_Timedsale_Bid_Confirmation_Lot_Details(String auctionName, String lotName)
			throws InterruptedException, AWTException

	{

		goto_Catalog_Page_Timed_Sale(auctionName); // Goto catalog page
		common.pause(20);

		System.out.println("Step :: Click on Lot Details Page");
		common.log("<br></br> Step :: Click on Lot Details Page");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']")).click();
		common.pause(15);

		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//input[@class='txt-force-bid']")).sendKeys("200");
		common.pause(10);

		System.out.println("Step :: Click on Force Bid Button");
		common.log("<br></br> Step :: Click on Force Bid Button");
		driver.findElement(By.xpath("//input[@value='Force Bid']")).click();
		common.pause(5);

		String bidx = driver.findElement(By.xpath("//input[@class='orng force-bid inline-confirm']"))
				.getAttribute("value");
		System.out.println("Step :: Bid Button Counter >> " + bidx);
		common.log("<br></br> Step :: Bid Button Counter >> " + bidx);

		String bidx1 = driver.findElement(By.xpath("//input[@class='orng force-bid inline-confirm']"))
				.getAttribute("value");
		System.out.println("Step :: Bid Button Counter >> " + bidx1);
		common.log("<br></br> Step :: Bid Button Counter >> " + bidx1);

		String bidx2 = driver.findElement(By.xpath("//input[@class='orng force-bid inline-confirm']"))
				.getAttribute("value");
		System.out.println("Step :: Bid Button Counter >> " + bidx2);
		common.log("<br></br> Step :: Bid Button Counter >> " + bidx2);

		common.pause(60);

		System.out.println("Step :: Click on Place Bid Button");
		common.log("<br></br> Step :: Click on Place Bid Button");
		driver.findElement(By.xpath("//input[@value='Force Bid']")).click();
		common.pause(5);

		System.out.println("Step :: Click on Confirm Force Bid Button");
		common.log("<br></br> Step :: Click on Confirm Force Bid Button");
		driver.findElement(By.xpath("//input[@class='orng force-bid button inline-confirm']")).click();
		common.pause(20);

		String Highbid = driver.findElement(By.xpath("//span[@class='left cur_bid']")).getText();
		System.out.println("Step :: Verify Success Message >> " + Highbid);
		common.log("<br></br> Step :: Verify Success Message >> " + Highbid);

		System.out.println("Step :: Verify Success Message Present");
		common.log("<br></br> Step :: Verify Sucess Message Present");
		common.assertElementPresent("// span[text()='Your bid has been placed successfully!']");
	}

	/**
	 * Place Bid Timed Auction Auto Extend
	 * 
	 * @param auctionName
	 * @param lotName
	 * @throws InterruptedException
	 * @throws AWTException
	 */

	public void Place_Bid_Timedsale_AutoExtend(String auctionName, String lotName)
			throws InterruptedException, AWTException

	{

		goto_Catalog_Page_Timed_Sale(auctionName); // Goto catalog page
		common.pause(40);
		String TimeLeft = driver
				.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//a[@class='in-progress']"))
				.getText();
		System.out.println("Step :: Time Left :: " + TimeLeft);
		common.log("<br></br> Step :: Time Left :: " + TimeLeft);

		common.pause(20);

		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(
				By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='textbox timed-maxbid']"))
				.sendKeys("200");
		common.pause(10);

		System.out.println("Step :: Click on Place bid Button");
		common.log("<br></br> Step :: Click on Place Bid Button");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@value='Place bid!']"))
				.click();
		common.pause(10);

		System.out.println("Step :: Accept Alert");
		common.log("<br></br> Step :: Accept Alert");
		common.acceptAlert1();
		common.pause(20);

	}

	public void Same_as_billing_checkbox_functionality_not_work() throws InterruptedException

	{
		common.pause(20);
		common.waitForElement(By.xpath("//a[contains(text(),'Logout')]"));
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		common.pause(20);
		String FistName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);

		common.waitForElement(By.xpath("//a[text()='Signup']"));
		common.jsClick(signUpLink);

		System.out.println("Step :: Enter SignupUser Details");
		common.log("<br></br> Step :: SignupUSer Details.");
		// common.waitForElementIsDisplayed(By.xpath("//input[@id='" +
		// LEGACY_USER_SIGNUP_TXT_USERNAME + "']"));
		common.pause(40);
		String signUpUser = common.generateRandomChars(6);

		System.out.println("Step :: Enter Username ::" + signUpUser);
		common.log("<br></br>Step :: Enter New User");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']", signUpUser);

		common.log("<br></br>Step :: Random Value :: " + signUpUser);
		System.out.println("Step :: Random Value :: " + signUpUser);

		System.out.println("Step :: Enter First Name");
		common.log("<br></br> Step :: Enter First Name");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_FIRST_NAME + "']", signUpUser);

		System.out.println("Step :: Enter Last Name");
		common.log("<br></br> Step :: Enter Last Name");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_LAST_NAME + "']", signUpUser);

		System.out.println("Step :: New User >>" + "  " + signUpUser);
		common.log("<br></br>Step : New User >>" + "  " + signUpUser);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']", signUpUser);

		System.out.println("Step :: Enter Password");
		common.log("<br></br> Step :: Enter Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PASSWORD + "']", LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);

		System.out.println("Step :: Enter Confirm Password");
		common.log("<br></br> Step :: Enter Confirm Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_PASSWORD + "']",
				LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);

		System.out.println("Step :: Enter EmailUser :: " + EmailUser);
		common.log("<br></br>Step :: Enter EmailUser :: " + EmailUser);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_EMAIL + "']",
				EmailUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);
		common.pause(20);

		if (common.isElementPresent("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_EMAIL + "']"))

		{
			System.out.println("Step :: Enter Confim Email :: " + EmailUser);
			common.log("<br></br>Step :: Enter Confirm Email :: " + EmailUser);
			common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_EMAIL + "']",
					EmailUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);
		}

		else {
			System.out.println("Step :: Enter Confim Email is not display");
		}

		System.out.println("Step :: Enter Phone Number.");
		common.log("<br></br>Step :: Enter Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		System.out.println("Step :: Identification Number.");
		common.log("<br></br>Step :: Identification Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_IDENTIFICATION + "']",
				LEGACY_USER_SIGNUP_TXT_IDENTIFICATION_VALUE);
		// Select USer info Phone Type
		System.out.println("Step :: Phone Type.");
		common.log("<br></br>Step :: Phone Type.");
		common.pause(10);
		driver.findElement(By.xpath("//span[@id='pip11_ctl']//a[@class='sbToggle']")).click();

		common.pause(10);

		// Select Phone Type

		driver.findElement(By.xpath("//span[@id='pip11_ctl']//..//a[contains(text(),'Work')]")).click();

		common.pause(10);

		// Select Identification Type

		common.pause(10);
		System.out.println("Step :: Veify Same as billing check box is present");
		common.log("Step :: Verfiy Same as billing checkbox is present");
		common.assertElementPresent("//input[@id='sip1']");

		System.out.println("Step :: Click on Same as billing check box.");
		common.log("<br></br>Step :: Click on Same as billing check box.");
		common.checkChkBox(ship);
		common.pause(10);

		// Billing Information

		// Select Phone Type

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", signUpUser);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", signUpUser);

		System.out.println("Step :: Enter Phone Number.");
		common.log("<br></br>Step :: Enter Phone Number.");

		System.out.println("Enter Phone Number...");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		// Select Country and State from dropdown

		System.out.println("Step :: Select Country.");
		common.log("<br></br>Step :: Select Country.");
		Actions Country = new Actions(driver);
		common.pause(10);
		WebElement SelectCounrty = driver.findElement(By.xpath("//span[@id='rbp7_ctl']//a[@class='sbToggle']"));
		SelectCounrty.click();
		common.pause(10);

		driver.findElement(By.xpath("//span[@id='rbp7_ctl']//..//a[contains(text(),'Canada')]")).click();

		// Select State

		System.out.println("Step :: Select State.");
		common.log("<br></br>Step :: Select State.");
		Actions State = new Actions(driver);
		common.pause(10);
		WebElement State1 = driver.findElement(By.xpath("//span[@id='rbp37_ctl']//a[@class='sbToggle']"));
		State1.click();
		common.pause(10);
		driver.findElement(By.xpath("//span[@id='rbp37_ctl']//a[contains(text(),'Alberta')]")).click();

		System.out.println("Step :: Enter Address.");
		common.log("<br></br>Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		System.out.println("Step :: Enter City.");
		common.log("<br></br>Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		System.out.println("Step :: Enter Zip.");
		common.log("<br></br>Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		// Confirmation Details

		System.out.println("Step :: Verify that captcha code filed is present");
		common.log("Step :: Verify that captcha code field is present");
		common.assertElementPresent("//input[@id='rf3']");

		System.out.println("Step :: Entering Captcha.");
		common.log("<br></br>Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		System.out.println("Step :: Verify that selecting terms checkbox is present");
		common.log("Step :: Verify that selecting terms checkbox is present");
		common.assertElementPresent("//input[@id='rf1']");

		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);
		common.pause(10);

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause(50);

		if (common.isElementPresent("//div[@class='validation-error']")) {

			System.out.println("Bug Not Fixed");
			common.log("Bug Not Fixed");
		} else {
			System.out.println("Bug Fixed");
			common.log("Bug Fixed");
		}

		common.pause(10);
	}

	public void sometimes_Getting_Php_Error_When_User_Click_On_SignUp_Button() throws InterruptedException

	{
		common.pause20Sec();
		System.out.println("Step :: Click on Logout");
		common.log("<br></br>Step :: Click on Logout");
		driver.findElement(By.xpath("//a[contains(text(),'"+LEGACY_FRONT_LOGIN_TXT_LOGOUT+"')]")).click();
		common.pause20Sec();
		String FistName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);
		
		System.out.println("Step :: Click on Signup tab");
		common.log("<br></br>Step :: Click on signup tab");
		common.jsClick(signUpLink);

		System.out.println("Step :: Enter SignupUser Details");
		common.log("<br></br> Step :: SignupUSer Details.");
		common.pause20Sec();

		String signUpUser = common.generateRandomChars(6);

		System.out.println("Step :: Enter Username ::" + signUpUser);
		common.log("<br></br>Step :: Enter New User");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']", signUpUser);

		common.log("<br></br>Step :: Random Value :: " + signUpUser);
		System.out.println("Step :: Random Value :: " + signUpUser);

		System.out.println("Step :: Enter First Name");
		common.log("<br></br> Step :: Enter First Name");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_FIRST_NAME + "']", signUpUser);

		System.out.println("Step :: Enter Last Name");
		common.log("<br></br> Step :: Enter Last Name");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_LAST_NAME + "']", signUpUser);

		System.out.println("Step :: New User >>" + "  " + signUpUser);
		common.log("<br></br>Step : New User >>" + "  " + signUpUser);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']", signUpUser);

		System.out.println("Step :: Enter Password");
		common.log("<br></br> Step :: Enter Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PASSWORD + "']", LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);

		System.out.println("Step :: Enter Confirm Password");
		common.log("<br></br> Step :: Enter Confirm Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_PASSWORD + "']",
				LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);

		System.out.println("Step :: Enter EmailUser :: " + EmailUser);
		common.log("<br></br>Step :: Enter EmailUser :: " + EmailUser);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_EMAIL + "']",
				EmailUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);
		common.pause20Sec();

		if (common.isElementPresent("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_EMAIL + "']"))

		{
			System.out.println("Step :: Enter Confim Email :: " + EmailUser);
			common.log("<br></br>Step :: Enter Confirm Email :: " + EmailUser);
			common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_EMAIL + "']",EmailUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);
		}

		else {
			System.out.println("Step :: Enter Confirm Email is not display");
		}

		System.out.println("Step :: Enter Phone Number.");
		common.log("<br></br>Step :: Enter Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		// Select USer info Phone Type

		System.out.println("Step :: Identification Number.");
		common.log("<br></br>Step :: Identification Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_IDENTIFICATION + "']",
				LEGACY_USER_SIGNUP_TXT_IDENTIFICATION_VALUE);

		System.out.println("Step :: Phone Type.");
		common.log("<br></br>Step :: Phone Type.");
		common.pause(10);
		driver.findElement(By.xpath("//span[@id='"+LEGACY_USER_SIGNUP_TXT_PHONE_TYPE+"']//a[@class='"+LEGACY_USER_SIGNUP_TXT_TOGGLE+"']")).click();
		common.pause20Sec();

		// Select Phone Type

		driver.findElement(By.xpath("//span[@id='"+LEGACY_USER_SIGNUP_TXT_PHONE_TYPE+"']//..//a[contains(text(),'"+LEGACY_USER_PHONE_TYPE_WORK+"')]")).click();

		common.pause20Sec();

		// Billing Information

		// Select Phone Type

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", signUpUser);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", signUpUser);

		System.out.println("Step :: Enter Phone Number.");
		common.log("<br></br>Step :: Enter Phone Number.");

		System.out.println("Enter Phone Number...");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		// Select Country and State from dropdown

		System.out.println("Step :: Select Country.");
		common.log("<br></br>Step :: Select Country.");
		Actions Country = new Actions(driver);
		common.pause20Sec();
		WebElement SelectCounrty = driver.findElement(By.xpath("//span[@id='"+LEGACY_USER_SIGNUP_BILL_LST_COUNTRY+"']//a[@class='"+LEGACY_USER_SIGNUP_TXT_TOGGLE+"']"));
		SelectCounrty.click();
		common.pause20Sec();

		driver.findElement(By.xpath("//span[@id='"+LEGACY_USER_SIGNUP_BILL_LST_COUNTRY+"']//..//a[contains(text(),'"+LEGACY_USER_CITY_CANADA+"')]")).click();

		// Select State

		System.out.println("Step :: Select State.");
		common.log("<br></br>Step :: Select State.");
		Actions State = new Actions(driver);
		common.pause20Sec();
		WebElement State1 = driver.findElement(By.xpath("//span[@id='"+LEGACY_USER_COUNTRY+"']//a[@class='"+LEGACY_USER_SIGNUP_TXT_TOGGLE+"']"));
		State1.click();
		common.pause20Sec();
		driver.findElement(By.xpath("//span[@id='"+LEGACY_USER_COUNTRY+"']//a[contains(text(),'"+LEGACY_USER_CITY_ALBERTA+"')]")).click();
		common.pause20Sec();

		System.out.println("Step :: Enter Address.");
		common.log("<br></br>Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		System.out.println("Step :: Enter City.");
		common.log("<br></br>Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		System.out.println("Step :: Enter Zip.");
		common.log("<br></br>Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		System.out.println("Step :: Veify Same as billing check box is present");
		common.log("Step :: Verfiy Same as billing checkbox is present");
		common.assertElementPresent("//input[@id='sip1']");

		System.out.println("Step :: Click on Same as billing check box.");
		common.log("<br></br>Step :: Click on Same as billing check box.");
		common.checkChkBox(ship);
		common.pause20Sec();

		// Confirmation Details

		System.out.println("Step :: Verify that captcha code filed is present");
		common.log("Step :: Verify that captcha code field is present");
		common.assertElementPresent("//input[@id='"+LEGACY_USER_SIGNUP_TXT_CAPTCHA+"']");

		System.out.println("Step :: Entering Captcha.");
		common.log("<br></br>Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		System.out.println("Step :: Verify that selecting terms checkbox is present");
		common.log("Step :: Verify that selecting terms checkbox is present");
		common.assertElementPresent("//input[@id='"+LEGACY_USER_TERMS_AND_CONDITIONS+"']");

		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);
		common.pause20Sec();

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause20Sec();
		common.highlightElement("//span[contains(text(),'"+LEGACY_TXT_SIGNUP_VALIDATION+"')]");
		if (common.isElementPresent("//span[contains(text(),'"+LEGACY_TXT_SIGNUP_VALIDATION+"')]")) {

			System.out.println("Bug Fixed");
			common.log("Bug Fixed");
		} else {
			System.out.println("Bug Not Fixed");
			common.log("Bug Not Fixed");
		}

		common.pause20Sec();
	}

	public void undefined_Variable_Error_Displays_When_User_Search_Category() throws InterruptedException

	{
		common.pause20Sec();
		System.out.println("Step :: Click On Search Icon");
		common.log("<br></br>Step :: Click On Search Icon");
		driver.findElement(By.xpath("//li[@title='"+LEGACY_ADMIN_SEARCH_ICON+"']//a")).click();
		common.pause20Sec();
	
		System.out.println("Step :: Search Category");
		common.log("<br></br>Step :: Search Category");
		driver.findElement(By.xpath("//input[@id='txtSearch']")).click();
		common.type("//input[@id='txtSearch']", "category1");
		common.pause20Sec();

		System.out.println("Step :: Click On Search Button");
		common.log("<br></br>Step :: Click On Search Button");
		driver.findElement(By.xpath("//input[@id='"+LEGACY_USER_BTN_CATEGORY_SEARCH_BTN+"']")).click();
		common.pause20Sec();
		common.highlightElement("//div[@class='"+LEGACY_USER_PAGE+"']");
		if (common.isElementPresent("//div[@class='"+LEGACY_USER_PAGE+"']")) {

			String Success = driver.findElement(By.xpath("//div[@class='"+LEGACY_USER_PAGE+"']")).getText();
			System.out.println("Step :: Result displays :" + Success);

			System.out.println("Bug Fixed");
			common.log("Bug Fixed");
		} else {
			System.out.println("Bug Not Fixed");
			common.log("Bug Not Fixed");
		}

		common.pause20Sec();
	}

	/**
	 * Verify Outbid Text
	 * 
	 * @param auctionName
	 * @param lotName
	 * @throws AWTException
	 * @throws InterruptedException
	 */

	public void Verify_BidNow_x_Outbid(String auctionName, String lotName) throws AWTException, InterruptedException

	{

		goto_Catalog_Page_Timed_Sale(auctionName); // Goto catalog page

		common.pause(15);

		String priceinfo = driver.findElement(By.xpath("//ul[@class='" + LEGACY_USER_LOT_PRICE_INFO + "']")).getText();
		System.out.println("Step :: Verify Success Message >> " + priceinfo);
		common.log("<br></br> Step :: Verify Success Message >> " + priceinfo);

	}

	public void user_Is_Able_To_Signup_With_Existing_User_Name() throws InterruptedException

	{
		common.pause20Sec();
		driver.findElement(By.xpath("//a[contains(text(),'"+LEGACY_FRONT_LOGIN_TXT_LOGOUT+"')]")).click();
		common.pause20Sec();
		String FistName = common.generateRandomChars(6);
		String LastName = common.generateRandomChars(6);
		String EmailUser = common.generateRandomChars(6);

		common.jsClick(signUpLink);
		common.pause20Sec();
		System.out.println("Step :: Enter SignupUser Details");
		common.log("<br></br> Step :: SignupUSer Details.");
		common.waitForElementIsDisplayed(By.xpath("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']"));

		String signUpUser = common.generateRandomChars(6);

		System.out.println("Step :: Enter Username ::" + "rahulqa");
		common.log("<br></br>Step :: Enter New User");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']", "rahulqa");

		common.log("<br></br>Step :: Random Value :: " + signUpUser);
		System.out.println("Step :: Random Value :: " + signUpUser);

		System.out.println("Step :: Enter First Name");
		common.log("<br></br> Step :: Enter First Name");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_FIRST_NAME + "']", signUpUser);

		System.out.println("Step :: Enter Last Name");
		common.log("<br></br> Step :: Enter Last Name");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_LAST_NAME + "']", signUpUser);
		//
		// System.out.println("Step :: New User >>" + " " + signUpUser);
		// common.log("<br></br>Step : New User >>" + " " + signUpUser);
		// common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_USERNAME + "']",
		// signUpUser);

		System.out.println("Step :: Enter Password");
		common.log("<br></br> Step :: Enter Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PASSWORD + "']", LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);

		System.out.println("Step :: Enter Confirm Password");
		common.log("<br></br> Step :: Enter Confirm Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_PASSWORD + "']",
				LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);

		System.out.println("Step :: Enter EmailUser :: " + EmailUser);
		common.log("<br></br>Step :: Enter EmailUser :: " + EmailUser);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_EMAIL + "']",
				EmailUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);
		common.pause20Sec();

		if (common.isElementPresent("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_EMAIL + "']"))

		{
			System.out.println("Step :: Enter Confim Email :: " + EmailUser);
			common.log("<br></br>Step :: Enter Confirm Email :: " + EmailUser);
			common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_EMAIL + "']",
					EmailUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);
		}

		else {
			System.out.println("Step :: Enter Confirm Email is not display");
		}

		System.out.println("Step :: Enter Phone Number.");
		common.log("<br></br>Step :: Enter Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		// Select USer info Phone Type
		System.out.println("Step :: Phone Type.");
		common.log("<br></br>Step :: Phone Type.");

		Actions actions = new Actions(driver);
		common.pause20Sec();
		WebElement element = driver.findElement(
				By.xpath("//select[@id='" + LEGACY_USER_SIGNUP_TXT_PHONE_TYPE1 + "']//..//..//a[@class='"+LEGACY_USER_SIGNUP_TXT_TOGGLE+"']"));
		element.click();
		common.pause20Sec();

		// Select Phone Type

		driver.findElement(By.xpath("//select[@id='"+LEGACY_USER_SIGNUP_TXT_PHONE_TYPE1+"']//..//a[text()='"+LEGACY_USER_PHONE_TYPE_WORK+"']")).click();
		common.pause20Sec();

		System.out.println("Step :: Identification Number.");
		common.log("<br></br>Step :: Identification Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_IDENTIFICATION + "']",
				LEGACY_USER_SIGNUP_TXT_IDENTIFICATION_VALUE);

		// Select Identification Type
		System.out.println("Step :: Identification Number.");
		common.log("<br></br>Step :: Identification Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_IDENTIFICATION + "']",
				LEGACY_USER_SIGNUP_TXT_IDENTIFICATION_VALUE);

		// Select Identification Type

		System.out.println("Step :: Select Identification Type.");
		common.log("<br></br>Step :: Select Identification Type.");

		Actions id = new Actions(driver);
		common.pause(10);
		WebElement idtype = driver.findElement(By.xpath(
				"//select[@id='" + LEGACY_USER_SIGNUP_LST_IDENTIFICATION_TYPE1 + "']//..//..//a[@class='sbToggle']"));
		idtype.click();
		common.pause20Sec();

		// Billing Information

		// Select Phone Type
		System.out.println("Step :: Phone Type.");
		common.log("<br></br>Step :: Phone Type.");
		common.pause20Sec();

		WebElement element1 = driver.findElement(By.xpath("//select[@id='"
				+ LEGACY_USER_SIGNUP_BILL_LST_CONTACT_TYPE_ELEMENT_PRESENT + "']//..//..//a[@class='"+LEGACY_USER_SIGNUP_TXT_TOGGLE+"']"));
		element1.click();
		common.pause20Sec();

		// Select Phone Type

		WebElement select_Work1 = driver.findElement(By.linkText("+1 (Canada / USA)"));
		common.pause(10);
		actions.moveToElement(select_Work1);
		actions.moveToElement(select_Work1).click().perform();
		common.pause20Sec();

		System.out.println("Step :: Billing First Name.");
		common.log("<br></br>Step :: Billing First Name.");
		String contactFirst = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_FIRST_NAME + "']", signUpUser);

		System.out.println("Step :: Billing Last Name.");
		common.log("<br></br>Step :: Billing Last Name.");
		String contactLast = common.generateRandomChars(8);
		common.type("//*[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_LAST_NAME + "']", signUpUser);

		System.out.println("Step :: Enter Phone Number.");
		common.log("<br></br>Step :: Enter Phone Number.");

		System.out.println("Enter Phone Number...");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		// Select Country and State from dropdown

		System.out.println("Step :: Select Country.");
		common.log("<br></br>Step :: Select Country.");
		Actions Country = new Actions(driver);
		common.pause(10);
		WebElement SelectCounrty = driver.findElement(By.xpath("//select[@id='"+LEGACY_USER_SIGNUP_SELECT_COUNTRY+"']//..//..//a[@class='"+LEGACY_USER_SIGNUP_TXT_TOGGLE+"']"));
		SelectCounrty.click();
		common.pause20Sec();

		WebElement select_Canada = driver.findElement(By.linkText("Canada"));
		common.pause20Sec();
		Country.moveToElement(select_Canada);
		Country.moveToElement(select_Canada).click().perform();
		common.pause(10);

		// Select State

		System.out.println("Step :: Select State.");
		common.log("<br></br>Step :: Select State.");
		Actions State = new Actions(driver);
		common.pause20Sec();
		WebElement State1 = driver.findElement(By.xpath("//select[@id='"+LEGACY_USER_SIGNUP_SELECT_STATE+"']//..//..//a[@class='"+LEGACY_USER_SIGNUP_TXT_TOGGLE+"']"));
		State1.click();
		common.pause20Sec();
		WebElement select_Alberta = driver.findElement(By.linkText("Alberta"));
		common.pause20Sec();
		State.moveToElement(select_Alberta);
		State.moveToElement(select_Alberta).click().perform();
		common.pause20Sec();
		System.out.println("Step :: Enter Address.");
		common.log("<br></br>Step :: Enter Address.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ADDRESS_VALUE);

		System.out.println("Step :: Enter City.");
		common.log("<br></br>Step :: Enter City.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_CITY + "']", LEGACY_USER_SIGNUP_BILL_TXT_CITY_VALUE);

		System.out.println("Step :: Enter Zip.");
		common.log("<br></br>Step :: Enter Zip.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE + "']",
				LEGACY_USER_SIGNUP_BILL_TXT_ZIP_CODE_VALUE);

		System.out.println("Step :: Veify Same as billing check box is present");
		common.log("Step :: Verfiy Same as billing checkbox is present");
		common.assertElementPresent("//input[@id='"+LEGACY_USER_TXT_SAME_AS_BILLING_CHECKBOX+"']");

		System.out.println("Step :: Click on Same as billing check box.");
		common.log("<br></br>Step :: Click on Same as billing check box.");
		common.checkChkBox(ship);
		common.pause20Sec();
		// Confirmation Details

		System.out.println("Step :: Verify that captcha code filed is present");
		common.log("Step :: Verify that captcha code field is present");
		common.assertElementPresent("//input[@id='"+LEGACY_USER_SIGNUP_TXT_CAPTCHA+"']");

		System.out.println("Step :: Entering Captcha.");
		common.log("<br></br>Step :: Entering Captcha.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CAPTCHA + "']", LEGACY_USER_SIGNUP_CAPTCHA_VALUE);

		System.out.println("Step :: Verify that selecting terms checkbox is present");
		common.log("Step :: Verify that selecting terms checkbox is present");
		common.assertElementPresent("//input[@id='rf1']");

		System.out.println("Step :: Selecting Terms Checkbox(Confirmaion).");
		common.log("<br></br>Step :: Selecting Terms Checkbox(Confirmaion).");
		common.checkChkBox(terms);
		common.pause20Sec();

		System.out.println("Step :: Click on signUp button.");
		common.log("<br></br>Step :: Click on signUp button.");
		common.jsClick(signUp);
		common.pause20Sec();
		common.highlightElement("//span[contains,(text(),'Username *: Username already exists')]");
		if (common.isElementPresent("//span[contains(text(),'Username *: Username already exists')]")) {

			System.out.println("Bug is fixed");
			common.log("Bug is fixed");
		} else {
			System.out.println("Bug is not fixed");
			common.log("Bug is not fixed");
		}
			
		common.pause20Sec();
	}

	public void Verify_Changed_Show_Low_High_Estimate_Y(String saleno, String auctionName)
			throws InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale(auctionName); // Goto catalog Page

		System.out.println("Step :: Click on catalog button");
		common.log("<br></br> Step :: Click on catalog button");
		common.pause(50);

		String estimate = driver.findElement(By.xpath("//li//span[text()='Estimates']")).getText();

		System.out.println("Step :: Estimate Text Display :: " + estimate);
		common.log("<br></br> Step :: Estimate Text Display:: " + estimate);

		common.pause(15);

	}

	public void Verify_Changed_Show_Low_High_Estimate_N(String saleno, String auctionName)
			throws InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale(auctionName); // Goto catalog Page

		System.out.println("Step :: Click on catalog button");
		common.log("<br></br> Step :: Click on catalog button");
		common.pause(50);

		common.assertElementNotPresent("//li//span[text()='Estimates']");

	}

	public void Verify_Changed_Show_Seconds_In_Countdown_Y(String lotname)
			throws ParseException, InterruptedException, AWTException {

		common.pause(20);
		String time = driver.findElement(By.xpath("//p[@class='timelft time-left']")).getText();

		System.out.println("Step :: Time Display :: " + time);
		common.log("<br></br> Step :: Time Display:: " + time);

		common.pause(15);
	}

	public void Verify_Changed_Show_Seconds_In_Countdown_N(String lotname)
			throws ParseException, InterruptedException, AWTException {

		common.pause(20);
		String time = driver.findElement(By.xpath("//p[@class='timelft time-left']")).getText();

		System.out.println("Step :: Time Display :: " + time);
		common.log("<br></br> Step :: Time Display:: " + time);

		common.pause(15);
	}

	public void Verify_Display_lot_quantity_in_catalog_Y(String lotname)
			throws ParseException, InterruptedException, AWTException {

		common.pause(20);
		String quan = driver.findElement(By.xpath("//span[contains(text(),'Quantity')]")).getText();

		System.out.println("Step :: Quantity Display :: " + quan);
		common.log("<br></br> Step :: Quantity Display:: " + quan);

		common.pause(15);
	}

	public void Verify_Display_lot_quantity_in_catalog_N(String lotname)
			throws ParseException, InterruptedException, AWTException {

		common.pause(20);

		common.assertElementNotPresent("//span[contains(text(),'Quantity')]");

		common.pause(5);
	}

	public void Verify_Default_Catalog_Items_Per_Page_100(String lotname)
			throws ParseException, InterruptedException, AWTException {

		common.pause(20);
		String ItemsperPage = driver.findElement(By.xpath("//div[@class='frst']")).getText();

		System.out.println("Step :: Items Per Page Display :: " + ItemsperPage);
		common.log("<br></br> Step :: Items Per Page Display:: " + ItemsperPage);

		common.pause(15);
	}

	public void verify_User_Not_Able_To_Save_Profile() throws InterruptedException, AWTException {

		System.out.println("Step :: Click on Profile");
		common.log("<br></br> Step :: Click on Profile");
		driver.findElement(By.xpath("//a[contains(text(),'Profile')]")).click();
		common.pause(30);

		System.out.println("Step :: Click on Save changes");
		common.log("<br></br> Step :: Click on Save changes");
		driver.findElement(By.xpath("//input[@id='pf1']")).click();
		common.pause(30);
		common.assertElementPresent("//span[contains(text(),'Please check the highlighted fields for errors')]");
		if (common.isElementPresent("//span[contains(text(),'Please check the highlighted fields for errors')]")) {

			System.out.println("Step :: Issue Fixed");
			common.log("<br></br> Step :: Issue Fixed");
			String errorMessage = driver
					.findElement(By.xpath("//span[contains(text(),'Please check the highlighted fields for errors')]"))
					.getText();

			System.out.println("Step :: Message Display :: " + errorMessage);
			common.log("<br></br> Step :: Message Display:: " + errorMessage);

			common.pause(10);
		} else {
			System.out.println("Step :: Issue Not Fixed");
			common.log("<br></br> Step :: Isseu Not Fixed");
		}

	}

	public void Verify_Not_able_to_send_problems_report_in_Live_Sale_page_at_front_end_side(String auctionName)
			throws AWTException

	{

		goto_Catalog_Page_Live_Sale(auctionName); // Goto catalog page

		System.out.println("Step :: Click on Live Sale tab");
		common.log("<br></br> Step :: Click on Live Sale tab");
		common.pause(25);
		if (!common.isElementPresent("//a[contains(text(),'Live Sale')]")) {

			driver.findElement(By.xpath("//a//span[text()='" + auctionName + "']")).click();

			common.pause(40);
			driver.findElement(By.xpath("//a[contains(text(),'View live sale now!')]")).click();
			common.pause(20);
		} else {

			driver.findElement(By.xpath("//a[contains(text(),'Live Sale')]")).click();
			common.pause(20);
		}

		System.out.println("Step :: Click on Report Problems");
		common.log("<br></br> Step :: Click on Report Problems");
		driver.findElement(By.xpath("//a[@id='report-problems']")).click();
		common.pause(10);

		System.out.println("Step :: Enter Text In Textarea");
		common.log("<br></br> Step :: Enter Text In Textarea");
		driver.findElement(By.xpath("//textarea[@id='report']")).sendKeys("test123");

		System.out.println("Step :: Click on Send");
		common.log("<br></br> Step :: Click on Send");
		driver.findElement(By.xpath("//button[contains(text(),'Send')]")).click();
		common.pause(10);

		if (common.isElementPresent("//div[@id='dialog-message']")) {

			System.out.println("Step :: Issue Fixed");
			common.log("<br></br> Step :: Issue Fixed");

			common.pause(10);
		} else {
			System.out.println("Step :: Issue Not Fixed");
			common.log("<br></br> Step :: Isseu Not Fixed");
		}

	}

	public void Verify_Credit_card_number_exposed_profile() throws InterruptedException, AWTException {

		System.out.println("Step :: Click on Profile");
		common.log("<br></br> Step :: Click on Profile");
		driver.findElement(By.xpath("//a[contains(text(),'Profile')]")).click();
		common.pause(30);

		String estimate = driver
				.findElement(By.xpath("//span[contains(text(),'CC number *')]//..//span[@class='info']")).getText();

		System.out.println("Step :: Credit card number Display :: " + estimate);
		common.log("<br></br> Step :: Credit card number Display:: " + estimate);

		System.out.println("Fixed - if last 4 digit display");
		System.out.println("Not Fixed - if full CC number display");
		common.pause(10);

	}

	public void verify_user_able_to_bid_Or_not(String auctionName) throws InterruptedException, ParseException {

		System.out.println("Step :: Click on Live Sale link");
		common.log("<br></br>Step :: Click on Live Sale link");

		common.pause(25);
		if (!common.isElementPresent("//a[contains(text(),'Live Sale')]")) {

			driver.findElement(By.xpath("//a//span[text()='" + auctionName + "']")).click();

			common.pause(20);
			driver.findElement(By.xpath("//a[contains(text(),'View live sale now!')]")).click();
			common.pause(20);
		} else {

			driver.findElement(By.xpath("//a[contains(text(),'Live Sale')]")).click();
			common.pause(20);
		}
		if (driver.findElement(By.xpath("//a[@id='btnPlaceBid']")).isDisplayed()) {

			System.out.println("Step :: Issue Not Fixed");
			common.log("<br></br> Step :: Issue Not Fixed");

			common.pause(10);
		} else {
			System.out.println("Step :: Issue Fixed");
			common.log("<br></br> Step :: Isseu Fixed");
		}
	}

	public void Verify_Auction_list_Displaying_or_Not() throws InterruptedException, ParseException {

		common.log("<br></br> Step :: Click on Auction Overview Page");
		System.out.println("Step :: Click on Auction Overview Page");
		common.waitForElement(By.xpath("//span[@id='alf1_ctl']//..[@role='button']"));
		common.jsClick(auctionsubtab);// Go to Auction overview page

		common.pause(25);
		if (common.isElementPresent("//input[@id='advsKey']")) {

			System.out.println("Step :: Issue Not Fixed");
			common.log("<br></br> Step :: Issue Not Fixed");

			common.pause(10);
		} else {
			System.out.println("Step :: Issue Fixed");
			common.log("<br></br> Step :: Issue Fixed");
		}
	}

	public void Verify_Printable_view_of_Settlement_at_Frontend() throws InterruptedException, AWTException {

		System.out.println("Step :: Click on Profile");
		common.log("<br></br> Step :: Click on Profile");
		driver.findElement(By.xpath("//a[contains(text(),'Profile')]")).click();
		common.pause(30);

		// driver.navigate().to(TEST_URL);
		driver.get(configFileReader.getFrontUrl());
		common.pause(30);

		System.out.println("Step :: Click on Printable view");
		common.log("<br></br>Step :: Click on Printable view");
		driver.findElement(By.xpath("//a[contains(text(),'Printable view')]")).click();
		common.pause(30);
		String winHandleBefore = driver.getWindowHandle();

		// Perform the click operation that opens new window

		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		String str = driver.findElement(By.xpath("//body[1]/div[1]/form[1]/article[1]/ul[1]/li[3]/div[1]")).getText();
		System.out.println("Printable details for settlement 1:\n" + str);
		common.log("<Printable details for settlement 1:\n" + str);
		common.pause(10);

	}

	public void Verify_Render_identifiable_class_names_for_user_custom_fields_on_signup_age()
			throws InterruptedException, AWTException {

		System.out.println("Step :: Click on Signup Link");
		common.log("<br></br> Step :: Click on Signup Link");
		common.pause(40);
		driver.findElement(By.xpath("//a[text()='Signup']")).click();
		common.pause(40);

		String str = driver.getPageSource();
		System.out.println("Page source for SignUp:\n" + str);
		common.log("<Page source for SignUp:\n" + str);

	}

	public void verify_Render_identifiable_class_names_for_user_custom_fields_on_profile_page()
			throws InterruptedException, AWTException {

		System.out.println("Step  :: Click on Profile");
		common.log("<br></br> Step  :: Click on Profie");
		driver.findElement(By.xpath("//a[text()='Profile']")).click();
		common.pause(40);

		String str = driver.getPageSource();
		System.out.println("Page source for Profile tab:\n" + str);
		common.log("<Page source for Profile tab:\n" + str);

	}

	public void Verfiy_Forgot_Password_Functionality() throws InterruptedException, AWTException {

		System.out.println("Step :: Click on Forgot Pasword?");
		common.log("<br></br> Step :: Click on Forgot Pasword?");
		driver.findElement(By.xpath("//a[@class='frgt']")).click();
		common.pause(30);

		System.out.println("Step :: Enter username");
		common.log("<br></br> Step :: Enter username");
		driver.findElement(By.xpath("//input[@id='aq2']")).sendKeys("rahulqa");
		common.pause(5);

		System.out.println("Step :: Enter email");
		common.log("<br></br> Step :: Enter email");
		driver.findElement(By.xpath("//input[@id='aq1']")).sendKeys("rahulsharma1818@gmail.com");
		common.pause(5);

		System.out.println("Step :: Enter captcha");
		common.log("<br></br> Step :: Enter captcha");
		driver.findElement(By.xpath("//input[@id='aq5']")).sendKeys(LEGACY_USER_SIGNUP_CAPTCHA_VALUE);
		common.pause(5);

		System.out.println("Step :: Click on Submit button");
		common.log("<br></br> Step :: Click on Submit button");
		driver.findElement(By.xpath("//input[@id='aq7']")).click();
		common.pause(30);

		String successMSg = driver
				.findElement(By.xpath("//li[contains(text(),'Please check your email inbox to reset your passwo')]"))
				.getText();

		if (common.isElementPresent("//li[contains(text(),'Please check your email inbox to reset your passwo')]")) {

			System.out.println("Step :: Message display :: " + successMSg);
			common.log("<br></br> Step :: Message Display:: " + successMSg);

			System.out.println("Bug fixed");
			common.log("Bug fixed");

		} else {
			System.out.println("Bug not fixed");
			common.log("Bug not fixed");
		}

	}

	public DashboardPage verify_User_Not_Logged_In_Accessible_Informations() throws InterruptedException, AWTException {
		common.pause(15);
		if (common.isElementPresent("//a[text()='"+LEGACY_FRONT_LOGIN_TXT_LOGOUT+"']")) {

			System.out.println("Step :: Click on Logout Link");

			WebElement logout = driver.findElement(By.xpath("//a[text()='"+LEGACY_FRONT_LOGIN_TXT_LOGOUT+"']"));
			logout.click();

		} else {

			System.out.println("Click on login link.");

			common.log("<br></br> Step :: Click on Login link.");

			driver.findElement(By.xpath("//a[contains(text(),'"+LEGACY_FRONT_LOGIN_BTN+"')]")).click();
			common.pause(20);
		}
		common.pause(15);
		common.log("<br></br> Step :: Click on Auction Overview Page");
		System.out.println("Step :: Click on Auction Overview Page");
		common.waitForElement(By.xpath("//span[@id='"+LEGACY_USER_LST_AUCTION_SHOW+"']//..[@role='"+LEGACY_USER_BUTTON+"']"));
		common.jsClick(auctionsubtab);// Go to Auction overview page
		common.pause(25);
		common.log("<br></br> Step :: Click on View catalog Page");
		System.out.println("Step :: Click on View catalog Page");
		driver.findElement(
				By.xpath("//ul[@class='"+LEGACY_USER_VIEW_CATALOG+"'][1]//li[@class='"+LEGACY_USER_AUC_LINK+"'][1]//a[text()='View catalog']")).click();
		common.pause(20);

		common.log("<br></br> Step :: Click on Auction Overview Page");
		System.out.println("Step :: Click on Auction Overview Page");
		common.waitForElement(By.xpath("//span[@id='"+LEGACY_USER_LST_AUCTION_SHOW+"']//..[@role='"+LEGACY_USER_BUTTON+"']"));
		common.jsClick(auctionsubtab);// Go to Auction overview page
		common.pause(35);

		common.log("<br></br> Step :: Select Live only");
		System.out.println("Step :: Select Live only");

		driver.findElement(By.xpath("//span[@id='"+LEGACY_USER_LST_SELECT_SALE_TYPE+"']//..//a[@role='"+LEGACY_USER_BUTTON+"']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='"+LEGACY_FRONT_SALE_SELECT_DROPDOWN+"']//div[text()='"+LEGACY_ADMIN_LST_AUCTION_LIST_LIVE+"']")).click();
		common.pause(30);

		common.assertElementPresent("//ul[@class='"+LEGACY_USER_VIEW_CATALOG+"'][1]//p//a[text()='"+LEGACY_USER_AUCTION_TYPE+"']");
		String str_live = driver.findElement(By.xpath("//ul[@class='"+LEGACY_USER_VIEW_CATALOG+"'][1]//p//a[text()='"+LEGACY_USER_AUCTION_TYPE+"']"))
				.getText();

		System.out.println("Step :: Live auction Display :: " + str_live);
		return new DashboardPage(driver);

	}

	public void Click_login_to_bid() throws InterruptedException, AWTException {

		if (common.isElementPresent("//a[text()='Logout']")) {

			System.out.println("Step :: Click on Logout Link");

			WebElement logout = driver.findElement(By.xpath("//a[text()='Logout']"));
			logout.click();

		}
	else{
	// else without code.
	}
		common.pause(20);
		common.log("<br></br> Step :: Click on Auction Overview Page");
		System.out.println("Step :: Click on Auction Overview Page");
		common.waitForElement(By.xpath("//span[@id='alf1_ctl']//..[@role='button']"));
		common.jsClick(auctionsubtab);// Go to Auction overview page
		common.pause(25);
		common.log("<br></br> Step :: Click on Login to bid button");
		System.out.println("Step :: Click on Login to bid button");
		driver.findElement(
				By.xpath("//ul[@class='auclting yura'][1]//li[@class='auclink'][1]//a[text()='Login to bid']")).click();
		common.pause(10);

	}

	public void verify_Auctions() throws InterruptedException, AWTException {
		common.log("<br></br> Step :: Click on Auction Overview Page");
		System.out.println("Step :: Click on Auction Overview Page");
		common.waitForElement(By.xpath("//span[@id='"+LEGACY_FRONT_BIDDINGNOW_UPCOMING+"']//..//a[@role='"+LEGACY_FRONT_BUTTON+"']"));
		common.jsClick(auctionsubtab);// Go to Auction overview page

		// Select Upcoming Only

		common.pause(30);
		System.out.println("Step :: Select Bidding now and upcoming");
		common.log("<br></br> Step :: Select Bidding now and upcoming");
		common.waitForElement(By.xpath("//span[@id='"+LEGACY_FRONT_BIDDINGNOW_UPCOMING+"']//..//a[@role='"+LEGACY_FRONT_BUTTON+"']"));

		driver.findElement(By.xpath("//span[@id='"+LEGACY_FRONT_BIDDINGNOW_UPCOMING+"']//..//a[@role='"+LEGACY_FRONT_BUTTON+"']")).click();
		common.pause(10);

		driver.findElement(By.xpath("//li[@class='"+LEGACY_FRONT_SALE_SELECT_DROPDOWN+"']//div[text()='"+LEGACY_FRONT_SELECT_UPCOMING_ONLY+"']")).click();

		common.assertElementPresent("//ul[@class='"+LEGACY_USER_VIEW_CATALOG+"'][1]//li[@class='"+LEGACY_USER_VERIFY_AUCTION+"']");
		String str_auc = driver.findElement(By.xpath("//ul[@class='"+LEGACY_USER_VIEW_CATALOG+"'][1]//li[@class='"+LEGACY_USER_VERIFY_AUCTION+"']")).getText();

		
		System.out.println("Step :: Auction Display :: " + str_auc);
		common.log("<br></br> Step :: Auction Display:: " + str_auc);

		common.pause(10);
	}

	public void go_Into_An_Auction() throws InterruptedException, AWTException {

		common.log("<br></br> Step :: Select Live only");
		System.out.println("Step :: Select Live only");

		driver.findElement(By.xpath("//span[@id='"+LEGACY_USER_LST_SELECT_SALE_TYPE+"']//..//a[@role='"+LEGACY_USER_BUTTON+"']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='"+LEGACY_FRONT_SALE_SELECT_DROPDOWN+"']//div[text()='"+LEGACY_ADMIN_LST_AUCTION_LIST_LIVE+"']")).click();
		common.pause(30);

		common.log("<br></br> Step :: Click on auction");
		System.out.println("Step :: Click on auction");
		driver.findElement(By.xpath("//ul[@class='"+LEGACY_USER_VIEW_CATALOG+"'][1]//li[@class='"+LEGACY_USER_VERIFY_AUCTION+"'][1]//h6//a")).click();
		common.pause(20);

		common.log("<br></br> Step :: Click on View all lots");
		System.out.println("Step :: Click on View all lots");
		if(common.isElementDisplayed("//a[contains(text(),'"+LEGACY_USER_VIEW_ALL_LOTS+"')]")){
		driver.findElement(By.xpath("//a[contains(text(),'"+LEGACY_USER_VIEW_ALL_LOTS+"')]")).click();
		common.pause(10);
		}else {
			common.log("<br></br> Step :: Click on auction info URL");
			System.out.println("Step :: Click on auction info URL");
			driver.findElement(By.xpath("//a[contains(text(),'"+LEGACY_USER_AUCTION_URL+"')]")).click();
			common.pause(30);
		}
//		common.log("<br></br> Step :: Click on View all lots");
//		System.out.println("Step :: Click on View all lots");
//		driver.findElement(By.xpath("//a[contains(text(),'"+LEGACY_USER_VIEW_ALL_LOTS+"')]")).click();
		common.pause(20);
		common.assertElementPresent("//h2[1]");
		String str_lot = driver.findElement(By.xpath("//h2[1]")).getText();

		System.out.println("Step :: Lot Display :: " + str_lot);
		common.log("<br></br> Step :: Lot Display:: " + str_lot);

		common.pause(10);
	}

	public void verify_Absentee_Bids_Not_Possible_If_Registration_Not_Approved_Yet(String auctionName)
			throws InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale(auctionName);

		common.pause20Sec();
		common.highlightElement("//div[@class='"+LEGACY_FRONT_AUCTIONLIST_BUTTON+"']//a[text()='"+LEGACY_FRONT_PENDING_APPROVAL+"']");
		common.assertElementPresent("//div[@class='"+LEGACY_FRONT_AUCTIONLIST_BUTTON+"']//a[text()='"+LEGACY_FRONT_PENDING_APPROVAL+"']");
		common.pause20Sec();
		String pendingapproval = driver
				.findElement(By.xpath("//div[@class='"+LEGACY_FRONT_AUCTIONLIST_BUTTON+"']//a[text()='"+LEGACY_FRONT_PENDING_APPROVAL+"']")).getText();
		System.out.println("Step :: Verified absentee bid is not possible if registration not approved yet" + pendingapproval);
		common.log("<br></br> Step :: Verified absentee bid is not possible if registration not approved yet" + pendingapproval);

		common.pause20Sec();

	}


	public void verify_Bidding_Console_Bid_Live_Now(String saleno, String auctionName)
			throws InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale(auctionName); // Goto catalog Page

		System.out.println("Step :: Click on catalog button");
		common.log("<br></br> Step :: Click on catalog button");

		common.pause(40);
		System.out.println("Step :: Click on Live Sale link");
		common.log("<br></br>Step :: Click on Live Sale link");

		if (common.isElementPresent("//a[contains(text(),'"+LEGACY_USER_TXT_LIVE_SALE+"')]")) {
			driver.findElement(By.xpath("//a[contains(text(),'"+LEGACY_USER_TXT_LIVE_SALE+"')]")).click();
			common.pause(30);
		} else {
			driver.findElement(By.xpath("//body/div[@id='"+LEGACY_USER_BID_MESSAGE+"']/div[1]/ol[1]/li[3]/a[1]/span[1]")).click();
			common.pause(20);
			driver.findElement(By.xpath("//a[contains(text(),'"+LEGACY_USER_TXT_LIVE_SALE_NOW+"')]")).click();
		}

		common.pause(30);

		System.out.println("Step :: Wait for bid button");
		common.waitForElement(By.xpath("//a[@id='" + LEGACY_FRONT_LOGIN_BTN_BID + "']"));

		System.out.println("Step :: Click on bid button");
		common.log("<br></br> Step :: Click on bid button");
		driver.findElement(By.xpath("//a[@id='"+LEGACY_FRONT_LOGIN_BTN_BID+"']")).click();

		System.out.println("Step :: Button Clicked");
		common.log("Step :: Button Clicked");
		common.pause(25);

		if (!common.isElementPresent("//a[@class='" + LEGACY_USER_TXT_LIVESALE_DISABLE + "']")) {

			System.out.println("Step :: Click on bid button");
			common.log("<br></br> Step :: Click on bid button");
			driver.findElement(By.xpath("//a[@id='"+LEGACY_FRONT_LOGIN_BTN_BID+"']")).click();

		} else {
			System.out.println("Step :: Bid Button Already Clicked");
		}

		common.pause(20);

		common.assertElementPresent("//div[@class='"+LEGACY_USER_SIGNUP_MESSAGES_VALUE+"']");
		String usermessage = driver.findElement(By.xpath("//div[@class='"+LEGACY_USER_SIGNUP_MESSAGES_VALUE+"']")).getText();

		System.out.println("Step :: Message center\n :: " + usermessage);
		common.log("<br></br> Step :: Message center\n :: " + usermessage);

		common.pause(15);

		common.jsClick(logout);
	}

	public void verify_bidding_console(String saleno, String auctionName) throws InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale(auctionName); // Goto catalog Page

		System.out.println("Step :: Click on catalog button");
		common.log("<br></br> Step :: Click on catalog button");

		common.pause(40);
		System.out.println("Step :: Click on Live Sale link");
		common.log("<br></br>Step :: Click on Live Sale link");

		if (common.isElementPresent("//a[contains(text(),'"+LEGACY_USER_TXT_LIVE_SALE+"')]")) {
			driver.findElement(By.xpath("//a[contains(text(),'"+LEGACY_USER_TXT_LIVE_SALE+"')]")).click();
			common.pause(30);
		} else {
			driver.findElement(By.xpath("//body/div[@id='wrapper']/div[1]/ol[1]/li[3]/a[1]/span[1]")).click();
			common.pause(20);
			driver.findElement(By.xpath("//a[contains(text(),'"+LEGACY_USER_TXT_LIVE_SALE_NOW+"')]")).click();
		}

		common.pause(30);

		String usermessage = driver.findElement(By.xpath("//div[@class='"+LEGACY_USER_SIGNUP_MESSAGES_VALUE+"']")).getText();

		System.out.println("Step :: Message center\n :: " + usermessage);
		common.log("<br></br> Step :: Message center\n :: " + usermessage);

		common.pause(15);
		common.assertElementPresent("//div[@id='"+LEGACY_USER_CHAT_MESSAGE+"']");
		common.waitForConditionIsElementPresent("//div[@id='"+LEGACY_USER_CHAT_MESSAGE+"']");
		String message = driver.findElement(By.xpath("//div[@id='"+LEGACY_USER_CHAT_MESSAGE+"']")).getText();
		System.out.println("Step :: Message center for next lot\n :: " + message);
		common.log("<br></br> Step :: Message center for next lot\n :: " + message);

		common.jsClick(logout);
	}

	public void verify_Upcoming_Lot_list_And_Select_One_From_That() throws InterruptedException, AWTException {

		System.out.println("Step :: Click on lot from upcoming lots");
		common.log("<br></br> Step :: Click on lot from upcoming lots");
		driver.findElement(By.xpath("//div[@id='"+LEGACY_USER_LABEL_UPCOMING+"']//..//tr[2]//td[3]")).click();

		common.pause(30);
		String winHandleBefore = driver.getWindowHandle();

		// Perform the click operation that opens new window

		// Switch to new window opened
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
		
		if(common.isElementDisplayed("//div[@id='"+LEGACY_USER_BID_MESSAGE+"']/form[@id='LotDetailsLive']/div[1]/article[1]/section[3]/div[2]/div[3]/div[1]/div[1]")) // dev
		{
			 String usermessage = driver.findElement(By.xpath("//div[@id='"+LEGACY_USER_BID_MESSAGE+"']/form[@id='LotDetailsLive']/div[1]/article[1]/section[3]/div[2]/div[3]/div[1]/div[1]")).getText();
			 System.out.println("Step :: Upcoming lot details\n :: " + usermessage);
			 common.log("<br></br> Step :: Upcoming lot details\n :: " + usermessage);
			 common.pause(20);
		}else {
			String usermessage1 = driver.findElement(By.xpath("//body/div[@id='"+LEGACY_USER_BID_MESSAGE+"']/form[@id='LotDetailsLive']/div[1]/article[1]/section[3]/div[2]/div[3]/div[1]/span[1]")).getText(); // qa3-6-auto
			 System.out.println("Step :: Upcoming lot details\n :: " + usermessage1);
			 common.log("<br></br> Step :: Upcoming lot details\n :: " + usermessage1);
			 common.pause(20);
		}
		
		

		

		common.pause(15);

	}

	public void verify_Removed_Bidder(String saleno, String auctionName) throws InterruptedException, AWTException {

		goto_Catalog_Page_Live_Sale(auctionName); // Goto catalog Page

		System.out.println("Step :: Click on catalog button");
		common.log("<br></br> Step :: Click on catalog button");

		common.pause(40);
		System.out.println("Step :: Click on Live Sale link");
		common.log("<br></br>Step :: Click on Live Sale link");

		if (common.isElementPresent("//a[contains(text(),'"+LEGACY_USER_TXT_LIVE_SALE+"')]")) {
			driver.findElement(By.xpath("//a[contains(text(),'"+LEGACY_USER_TXT_LIVE_SALE+"')]")).click();
			common.pause(30);
		} else {
			driver.findElement(By.xpath("//body/div[@id='"+LEGACY_USER_BID_MESSAGE+"']/div[1]/ol[1]/li[3]/a[1]/span[1]")).click();
			common.pause(20);
			driver.findElement(By.xpath("//a[contains(text(),'"+LEGACY_USER_TXT_LIVE_SALE_NOW+"')]")).click();
		}

		common.pause(40);

		common.waitForElement("//a[text()='"+LEGACY_USER_REGISTER_NOT_BTN+"']");
		String usermessage = driver.findElement(By.xpath("//button[text()='"+LEGACY_USER_REGISTER_NOT_BTN+"']")).getText();

		System.out.println("Step :: Bid now button text\n :: " + usermessage);
		common.log("<br></br> Step :: Bid now button text\n :: " + usermessage);

		common.pause(15);

		// common.jsClick(logout);
	}

	public void BidFrom1() throws InterruptedException, AWTException {

		System.out.println("Step :: Open url");
		common.log("<br></br> Step :: Open url");
		driver.get("https://sam.bp-depot.com/auctions/live-sale/id/4");

		System.out.println("Step :: Click on bid");
		common.log("<br></br> Step :: Click on bid");
		common.waitForElement("//a[@id='btnPlaceBid']");
		driver.findElement(By.xpath("//a[@id='btnPlaceBid']")).click();
		common.pause(10);

	}

	public void verify_Invoice_Sorting() {

		System.out.println("Step :: Click on invoice tab");
		common.log("<br></br> Step :: Click on invoice tab");
		driver.findElement(By.xpath("//a[text()='Invoices']")).click();
		common.pause(20);

		driver.findElement(By.xpath("//thead/tr[1]/th[2]")).click();
		common.pause(20);
		common.assertElementPresent("//thead/tr[1]/th[2]");
		System.out.println("Step :: Issue Fixed");
		common.log("<br></br> Step :: Issue Fixed");

	}

	public void Verify_image_at_front_end() {

		System.out.println("verify the image on front end");
		common.log("<br></br>Step :: verify the image on front end");
		common.assertElementPresent("//body/div[@id='logo-container']/div[1]/a[1]/img[1]");
		System.out.println("image is present at front end after pressing save changes again");
		common.log("<br></br>Step :: image is present at front end after pressing save changes again");

	}

	public void verify_error_page() {

		System.out.println("verify the page is loaded");
		common.log("<br></br>Step :: verify the page is loaded");
		common.assertElementPresent("//a[contains(text(),'Auctions')]");
		System.out.println("the page loaded successfully and bug is fixed");
		common.log("<br></br>Step :: the page loaded successfully and bug is fixed");

	}

	public void verify_delete_functionality() {

		System.out.println("Step :: click on my items tab");
		common.log("<br></br>Step :: click on my items tab. ::");
		driver.findElement(By.xpath("//a[contains(text(),'My Items')]")).click();
		common.pause(30);

		System.out.println("Step :: click on items consigned tab");
		common.log("<br></br>Step :: click on items consigned tab. ::");
		driver.findElement(By.xpath(
				"//body/div[@id='wrapper']/form[@id='AdvancedSearch']/article[1]/section[1]/div[1]/ul[1]/li[5]/a[1]"))
				.click();
		common.pause(30);

		String dellot = driver.findElement(By.xpath(
				"//body[1]/div[3]/form[1]/div[1]/article[1]/section[1]/div[6]/div[3]/ul[1]/li[1]/section[1]/div[1]/i[1]//..//..//h2//a[@class='yaaa']"))
				.getText();
		// String dellot =
		// driver.findElement(By.xpath("//section[@id='ali1221']//..//a[@class='yaaa']").get
		System.out.println("Step :: click on delete button");
		common.log("<br></br>Step :: click on delete button. ::");
		driver.findElement(By.xpath(
				"//body[1]/div[3]/form[1]/div[1]/article[1]/section[1]/div[6]/div[3]/ul[1]/li[1]/section[1]/div[1]/i[1]//..//..//..//input[@value='Delete']"))
				.click();
		common.pause(30);

		common.acceptAlert();
		if (common.isElementDisplayed(
				"//body[1]/div[3]/form[1]/div[1]/article[1]/section[1]/div[6]/div[3]/ul[1]/li[1]/section[1]/div[1]/i[1]//..//..//h2//a[text()='"
						+ dellot + "']")) {
			System.out.println("delete fuctionality is not working");
		} else {
			System.out.println("delete fuctionality is working. lot is deleted");
		}

	}

	public void add_2_Lot_In_Watchlist() {

		common.waitForElement(By.xpath("//a[contains(text(),'Auctions')]"));
		common.pause(20);

		System.out.println("Step :: Click Checkbox");
		common.log("<br></br> Step :: Click Checkbox");
		driver.findElement(By.xpath("//li[@id='lot1']//div[@class='bd-chk']")).click();
		common.pause(20);
		common.acceptAlert1();
		common.pause(20);

		System.out.println("Step :: Click Checkbox");
		common.log("<br></br> Step :: Click Checkbox");
		driver.findElement(By.xpath("//li[@id='lot2']//div[@class='bd-chk']")).click();
		common.pause(20);

		common.acceptAlert1();
		common.pause(20);

//		Alert alert2 = driver.switchTo().alert();
//		String watchlist2 = alert.getText();
//
//		System.out.println("Step :: Verify Add to watchlist message>> " + watchlist2);

	}

	public void verify_time_date() {

		System.out.println("verify the page is loaded");
		common.log("<br></br>Step :: verify the page is loaded");
		common.assertElementPresent("//a[contains(text(),'Auctions')]");
		System.out.println("the page loaded successfully and bug is fixed");
		common.log("<br></br>Step :: the page loaded successfully and bug is fixed");

	}

	public void Verify_My_Alerts_Page() throws InterruptedException

	{
		common.pause(20);
		System.out.println("Click on My Alerts");
		common.log("Click on My Alerts");
		driver.findElement(By.xpath("//a[contains(text(),'My Alerts')]")).click();

		String str = driver.findElement(By.xpath("//h2[contains(text(),'Search Title')]")).getText();
		System.out.println("Page display: " + str);
		common.log("Page display: " + str);

	}

	public void Auction_Info_Link_Redirect_to_Oops_error() throws InterruptedException {
		common.pause(25);
		System.out.println("Step :: Click on Auction Tab");
		common.log("<br></br>Step :: Click on Auction Tab");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(20);

		System.out.println("Step ::Click on View catalog");
		common.log("<br></br>Step :: Click on View catalog");
		common.pause(20);

		driver.findElement(By.xpath("//ul[@class='auclting yura'][1]//a[text()='View catalog']")).click();

		common.pause(20);
		System.out.println("Step ::Click on Auction info");
		common.log("<br></br>Step ::Click on Auction info");
		common.pause(20);

		driver.findElement(By.xpath("//ol[@class='breadcrumbs']//li[3]//a[1]//span[1]")).click();
		common.pause(20);

		if (common.isElementDisplayed("//a[contains(text(),'Auction Info')]")) {
			System.out.println(" Bug is fixed.");
		} else {
			System.out.println(" Bug is not fixed.");
		}

	}

	public void The_change_of_Items_per_page_parameter_should_redirect_to_the_first_page() throws InterruptedException {
		common.pause(25);
		System.out.println("Step :: Click on Auction Tab");
		common.log("<br></br>Step :: Click on Auction Tab");
		driver.findElement(By.xpath("//a[contains(text(),'Auctions')]")).click();
		common.pause(30);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(1000);
		common.pause(30);

		System.out.println("Step :: Click on Dropdown Items per page");
		common.log("<br></br>Step ::  Click on Dropdown Items per page");

		WebElement dropdown_list = driver.findElement(By.xpath("//select[@id='alf5']"));
		Select sel_drpdown = new Select(dropdown_list);
		sel_drpdown.selectByValue("1");
		// sel_drpdown.selectByVisibleText("25");
		common.pause(20);

//
//		JavascriptExecutor jse = (JavascriptExecutor) driver;
//		jse.executeScript("window.scrollBy(0,300)", "");
//		common.pause(20);

		System.out.println("Step :: Click on Next Button");
		common.log("<br></br>Step ::  Click on Next Button");
		driver.findElement(By.xpath(
				"//body/div[@id='wrapper']/form[@id='AuctionList']/div[1]/div[2]/div[1]/div[1]/span[1]/span[1]/span[14]/a[1]"))
				.click();
		common.pause(30);

		if (common.isElementDisplayed("//span[contains(text(),'Show')]")) {
			System.out.println(" Bug is fixed.");
		} else {
			System.out.println(" Bug is not fixed.");
		}
	}

	public void No_validation_error_displayed_for_non_numeric_data() throws InterruptedException, ParseException {

		common.pause(20);
		System.out.println("Click on My Alerts");
		common.log("Click on My Alerts");
		driver.findElement(By.xpath("//a[contains(text(),'My Alerts')]")).click();

		System.out.println("Step :: Click on Search Title");
		common.log("<br></br>Step ::  Click on Search Title");
		driver.findElement(By.xpath("//input[@id='mal10']")).sendKeys("Title");
		common.pause(20);

		System.out.println("Step :: Click on Keywords");
		common.log("<br></br>Step ::   Click on Keywords");
		driver.findElement(By.xpath("//input[@id='mal01']")).sendKeys("abc");
		common.pause(20);

		System.out.println("Step :: Click on Auctioneers");
		common.log("<br></br>Step ::   Click on Auctioneers");
		driver.findElement(
				By.xpath("//html/body/div[3]/form/div/article/ul/li[2]/div[2]/section/ul/li[3]/div[1]/span/div"))
				.click();
		common.pause(15);

		System.out.println("Step :: Select Auctioneer Rahul");
		common.log("<br></br>Step ::Select Auctioneer Rahul");
		driver.findElement(By.xpath("//a[contains(text(),'Rahul')]")).click();
		common.pause(15);

		System.out.println("Step :: Select categories");
		common.log("<br></br>Step ::Select categories");
		driver.findElement(By.xpath("//label[contains(text(),'cat1')]")).click();
		common.pause(15);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,650)", "");

		System.out.println("Step :: Click on Category");
		common.log("<br></br>Step ::Click on Category");
		driver.findElement(
				By.xpath("/html/body/div[3]/form/div/article/ul/li[2]/div[2]/section/ul/li[5]/div[1]/span/div/a[1]"))
				.click();
		common.pause(15);

		System.out.println("Step :: Select categories Match");
		common.log("<br></br>Step ::Select categories Match");
		driver.findElement(By.xpath("//ul[@class='sbOptions']//li[1]//a[text()='ANY of the above']")).click();
		common.pause(15);

		System.out.println("Step :: Enter Integer minimum value");
		common.log("<br></br>Step :: Enter minimum value");
		driver.findElement(By.xpath("//input[@id='cf21min']")).sendKeys("10.22");
		common.pause(15);

		System.out.println("Step :: Enter Integer maximum value");
		common.log("<br></br>Step :: Enter Integer maximum value");
		driver.findElement(By.xpath("//input[@id='cf21max']")).sendKeys("20.21");
		common.pause(15);

		System.out.println("Step :: Enter Decimal minimum value");
		common.log("<br></br>Step :: Enter Decimal minimum value");
		driver.findElement(By.xpath("//input[@id='cf30min']")).sendKeys("ffdf");
		common.pause(15);

		System.out.println("Step :: Enter Decimal maximum value");
		common.log("<br></br>Step :: Enter Decimal maximum value");
		driver.findElement(By.xpath("//input[@id='cf30max']")).sendKeys("dfd");
		common.pause(15);

		System.out.println("Step :: Click on Save Alert");
		common.log("<br></br>Step ::Click on Save Alert");
		driver.findElement(By.xpath("//input[@id='mal13']")).click();
		common.pause(15);

		if (common.isElementDisplayed("//span[contains(text(),'Please check the highlighted fields for errors')]")) {
			System.out.println(" Bug is fixed.");
		} else {
			System.out.println(" Bug is not fixed.");
		}

	}

	public void Public_lots_auto_update_stops_after_one_iteration() throws InterruptedException, ParseException {
//		common.pause(50);
//		WebElement e=driver.findElement(By.xpath("//input[@id='bNext3450']"));
//		boolean actualValue=e.isEnabled();
//		if(actualValue) {
//			System.out.println("Button is enabled");
//		}
//		else {
//			System.out.println("Button is disabled");
//		}
		Thread.sleep(150000);
		if (common.isElementDisplayed("//a[contains(text(),'Lot has ended')]")) {
			System.out.println("Step :: Verified Lot has ended message appear");
			common.log("<br></br>Step :: Verified Lot has ended message appear");
			System.out.println("Step :: Bug is fixed");
			common.log("<br></br>Step :: Bug is fixed");
		} else {
			System.out.println("Step :: Bug is not fixed");
			common.log("<br></br>Step :: Bug is not fixed");
		}

	}

	public String Goto_Catalog_Page_Search_Timed_Sale(String name) throws AWTException

	{

		common.pause(20);

		// Select Timed Only

		System.out.println("Step :: Select Timed Only");
		common.log("<br></br> Step :: Select Timed Only");
		common.waitForElement(By.xpath("//span[@id='alf3_ctl']//..//a"));
		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a")).click();
		common.pause(15);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[contains(text(),'Timed only')]")).click();

		common.pause(25);

		// Select Bidding now and upcoming

		System.out.println("Step :: Select Bidding now and upcoming");
		common.log("<br></br> Step :: Select Bidding now and upcoming");
		driver.findElement(By.xpath("//span[@id='alf1_ctl']//..//a")).click();
		common.pause(15);
		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		common.pause(20);

		System.out.println("Step :: Select 100 from dropdown");
		common.log("<br></br> Step :: Select 100 from dropdown");
		driver.findElement(By.xpath("//select[@id='" + LEGACY_ADMIN_LOT_TABLE + "']//option[@value='2']")).click();

		common.pause(50);

		for (int i = 0; i < 20; i++) {

			if (common.isElementPresent("//ul[@class='auclting yura']//a[text()=' " + name + "']"))

			{
				common.log("auction " + name + " is present in this page");
				System.out.println("auction " + name + " is present in this page");
				driver.findElement(By.xpath("//ul[@class='auclting yura']//a[text()=' " + name
						+ "']//..//..//..//..//a[text()='View catalog']")).click();
				common.pause(45);
				break;
			} else {
				common.log("auction " + name + " is not present in this page");
				System.out.println("auction " + name + " is not  present in this page");
				common.pause(60);
				driver.findElement(By.xpath("//div[@class='pagintn right']//a[contains(text(),'Next')]")).click();
				common.pause(60);
			}

		}
		return TimedAuction;
	}

	public void Register_Bidder() throws AWTException {
		common.pause(15);

		System.out.println("Step :: Click on Image");
		common.log("<br></br> Step :: Click on Image");
		driver.findElement(By.xpath(
				"//body/div[@id='wrapper']/form[@id='AdvancedSearch']/div[1]/article[1]/section[1]/div[5]/div[3]/ul[1]/li[1]/section[1]/figure[1]/a[1]/img[1]"))
				.click();
		common.pause(30);

		System.out.println("Step ::Click on Register to Bid button");
		common.log("<br></br> Step :: Click on Register to Bid button");
		driver.findElement(By.xpath("//input[@value='Register to bid!']")).click();

		common.pause(25);
	}

	public void place_bid_for_timed_auction() throws AWTException {

		common.pause(20);

		System.out.println("Step :: Click on Image");
		common.log("<br></br> Step :: Click on Image");
		driver.findElement(By.xpath(
				"//body/div[@id='wrapper']/form[@id='AdvancedSearch']/div[1]/article[1]/section[1]/div[5]/div[3]/ul[1]/li[1]/section[1]/figure[1]/a[1]/img[1]"))
				.click();
		common.pause(30);

		System.out.println("Step :: Fill Place bid value");
		common.log("<br></br> Step :: Fill Place  bid value");
		driver.findElement(By.xpath("//input[@class='mrg txt-max-bid']")).sendKeys("100");
		common.pause(15);

		System.out.println("Step :: Fill Place bid value");
		common.log("<br></br> Step :: Fill Place  bid value");
		driver.findElement(By.xpath("//input[@value='Place bid!']")).click();
		common.pause(15);

		common.assertElementPresent("//span[text()='Your bid has been placed successfully!']");
		System.out.println(
				"Step :: Verified User is able to place bid with registered user for timed auction in lot details page");
		common.log(
				"<br></br>Step :: Verified User is able to place bid with registered user for timed auction in lot details page");
		System.out.println("Step :: Bug is fixed");

	}

	public void Signup_with_details() throws InterruptedException, AWTException, ParseException {
		common.pause(20);
		common.waitForElement(By.xpath("//a[contains(text(),'Logout')]"));
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		common.pause(20);
		System.out.println("Step :: Click on Signup Tab ");
		common.log("<br></br>Step :Click on Signup Tab ");
		driver.findElement(By.xpath("//a[contains(text(),'Signup')]")).click();
		common.pause(15);
		String username = common.generateRandomChars(7);

		String password = common.generateRandomChars(5);
		String EmailUser = common.generateRandomChars(6);

		System.out.println("Step :: Enter User Name ");
		common.log("<br></br>Step :Enter User Name ");
		driver.findElement(By.xpath("//input[@id='pip1']")).click();
		driver.findElement(By.xpath("//input[@id='pip1']")).sendKeys(username);
		common.pause(15);

		System.out.println("Step :: Enter Password");
		common.log("<br></br> Step :: Enter Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PASSWORD + "']", LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);

		common.pause(15);
		System.out.println("Step :: Enter Confirm Password");
		common.log("<br></br> Step :: Enter Confirm Password");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_PASSWORD + "']",
				LEGACY_USER_SIGNUP_TXT_PASSWORD_VALUE);
//
//		System.out.println("Step :: Enter Password ");
//		common.log("<br></br>Step :Enter Password ");
//		driver.findElement(By.xpath("//span[@id='pip2_ctl']")).click();
//		common.pause(10);
//		driver.findElement(By.xpath("//input[@id='pip2']]")).sendKeys(password);
//		common.pause(15);
//		
//
//		System.out.println("Step :: Confirm Password ");
//		common.log("<br></br>Step :Confirm Password");
//		driver.findElement(By.xpath("//input[@id='pip3']")).click();
//		driver.findElement(By.xpath("//input[@id='pip3']")).sendKeys(password);
//		common.pause(15);

		System.out.println("Step :: Enter First Name ");
		common.log("<br></br>Step :Enter First Name ");
		driver.findElement(By.xpath("//input[@id='pip4']")).sendKeys(username);
		common.pause(15);

		System.out.println("Step :: Enter Last Name ");
		common.log("<br></br>Step :Enter Last Name ");
		driver.findElement(By.xpath("//input[@id='pip5']")).sendKeys(username);
		common.pause(15);

//		System.out.println("Step :: Enter Email  ");
//		common.log("<br></br>Step : Enter Email");
//		driver.findElement(By.xpath("//input[@id='pip6']")).sendKeys("abc@mailinator.com");
//		common.pause(15);
//
//		System.out.println("Step :: Select Phone Type  ");
//		common.log("<br></br>Step :Select Phone Type  ");
//		driver.findElement(By.xpath("//a[@id='sbToggle_10346668']")).click();
//		Robot robot = new Robot();
//		robot.keyPress(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_CONTROL);
//		robot.keyRelease(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//
//		common.pause(15);
//
//		System.out.println("Step :: Enter Phone number  ");
//		common.log("<br></br>Step : Enter Phone number ");
//		driver.findElement(By.xpath("//input[@id='pnpip9']")).sendKeys("4154154141");
//		common.pause(15);

		System.out.println("Step :: Enter EmailUser :: " + EmailUser);
		common.log("<br></br>Step :: Enter EmailUser :: " + EmailUser);
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_EMAIL + "']",
				EmailUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);
		common.pause(20);

		if (common.isElementPresent("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_EMAIL + "']"))

		{
			System.out.println("Step :: Enter Confim Email :: " + EmailUser);
			common.log("<br></br>Step :: Enter Confirm Email :: " + EmailUser);
			common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_CONFIRM_EMAIL + "']",
					EmailUser + LEGACY_USER_SIGNUP_TXT_EMAIL_VALUE);
		}

		else {
			System.out.println("Step :: Enter Confim Email is not display");
		}

		System.out.println("Step :: Enter Phone Number.");
		common.log("<br></br>Step :: Enter Phone Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_PHONE + "']", LEGACY_USER_SIGNUP_TXT_PHONE_VALUE);

		// Select USer info Phone Type

		System.out.println("Step :: Identification Number.");
		common.log("<br></br>Step :: Identification Number.");
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_TXT_IDENTIFICATION + "']",
				LEGACY_USER_SIGNUP_TXT_IDENTIFICATION_VALUE);

		System.out.println("Step :: Phone Type.");
		common.log("<br></br>Step :: Phone Type.");
		common.pause(10);
		driver.findElement(By.xpath("//span[@id='pip11_ctl']//a[@class='sbToggle']")).click();

		common.pause(10);

		// Select Phone Type

		driver.findElement(By.xpath("//span[@id='pip11_ctl']//..//a[contains(text(),'Work')]")).click();

		common.pause(10);

		System.out.println("Step :: Click on I Agree Terms and Conditions above  ");
		common.log("<br></br>Step : Click on I Agree Terms and Conditions above ");
		driver.findElement(By.xpath("//label[contains(text(),'*I Agree to the terms and conditions above')]")).click();
		common.pause(15);

		System.out.println("Step :: Click on Test 1  ");
		common.log("<br></br>Step : Click on Test 1");
		driver.findElement(By.xpath("//label[contains(text(),'*test1')]")).click();
		common.pause(15);

		System.out.println("Step :: Click on Signup Button  ");
		common.log("<br></br>Step : Click on Signup Button");
		driver.findElement(By.xpath("//input[@id='rf2']")).click();
		common.pause(15);

		common.assertElementPresent("//li[contains(text(),'Congratulations, your account has been created and')]");
		System.out.println("Step :: verified Sigup functionality is working properly");
		common.log("<br></br>Step :: verified Sigup functionality is working properly");
		common.pause(50);

	}

	public void Verify_My_Settlements_400_bad_request_page_on_sorting_columns()
			throws InterruptedException, AWTException, ParseException {
		common.pause(40);
		String str = driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText();

		System.out.println("Step :: Click Settlement No  " + str);
		common.log("<br></br>Step : Click Settlement No" + str);

		System.out.println("Step :: Click Settlement No  ");
		common.log("<br></br>Step : Click Settlement No");
		driver.findElement(By.xpath("//thead/tr[1]/th[2]")).click();
		common.pause(15);

		String str1 = driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText();

		System.out.println("Step :: Click Settlement No  " + str1);
		common.log("<br></br>Step : Click Settlement No" + str1);

		common.assertElementPresent("//h2[contains(text(),'Settlements')]");
		System.out.println("Step :: verified sorting functionality is working properly ");
		common.log("<br></br>Step :: verified sorting functionality is working properly ");
		common.pause(50);
	}

	public void Verify_My_Settlements_400_bad_request_page_on_filtering_settlements_with_All_option()
			throws InterruptedException, AWTException, ParseException {
		common.pause(20);
		System.out.println("Step :: Select All from dropdown  ");
		common.log("<br></br>Step : Select All from dropdown");
		driver.findElement(By.xpath(
				"//input[@class='custom-combobox-input ui-widget ui-widget-content ui-state-default ui-corner-left ui-autocomplete-input']"))
				.clear();
		driver.findElement(By.xpath(
				"//input[@class='custom-combobox-input ui-widget ui-widget-content ui-state-default ui-corner-left ui-autocomplete-input']"))
				.sendKeys("All");
		common.pause(10);
		Robot robot = new Robot();
		// common.pause(25);
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		common.pause(15);

		common.assertElementPresent("//h2[contains(text(),'Settlements')]");
		System.out.println("Step :: verified filtering with All option in settlements working properly");
		common.log("<br></br>Step :: verified filtering with All option in settlements working properly ");
		common.pause(50);

	}

	public void Verify_Frontend_My_Settlements_Printed_date_is_different_from_admin_check_printed_date(String memo)
			throws InterruptedException, AWTException, ParseException {
		common.pause(30);
		System.out.println("Step :: Select 100 from dropdown");
		common.log("<br></br> Step :: Select 100 from dropdown");
		WebElement items = driver.findElement(By.xpath("//select[@id='mslf4']"));
		Select s = new Select(items);
		s.selectByValue("3");

		common.pause(50);

		for (int i = 0; i < 20; i++) {

			if (common
					.isElementPresent("//div[@class='container my-settlements-container']//td[text()='" + memo + "']"))

			{
				common.log("memo " + memo + " is present in this page");
				System.out.println("auction " + memo + " is present in this page");
				driver.findElement(
						By.xpath("//div[@class='container my-settlements-container']//td[text()='" + memo + "']"))
						.click();
				common.pause(45);
				break;
			} else {
				common.log("memo " + memo + " is not present in this page");
				System.out.println("memo " + memo + " is not  present in this page");
				common.pause(60);
				driver.findElement(By.xpath("//span[@id='c2']//a[text()='Next']")).click();
				common.pause(60);

				System.out.println("Step ::Click on Printable view button");
				common.log("<br></br> Step ::Click on Printable view button");
				driver.findElement(By.xpath("//a[contains(text(),'Printable view')]")).click();

				// Switch to new window opened
				for (String winHandle : driver.getWindowHandles()) {
					driver.switchTo().window(winHandle);
				}
				String printeddate = driver.findElement(By.xpath("//p[@class='settlement-print-status-and-date ']"))
						.getText();
				common.assertElementPresent("//p[@class='settlement-print-status-and-date ']");
				System.out.println("Step :: verified printed date is same on frontend side. " + printeddate);
				common.log("<br></br>Step :: verified printed date is same on frontend side." + printeddate);
				common.pause(30);

			}
		}
	}

	public void Verify_My_items_Watchlist_Round_checkbox_functionality_is_not_working_properly(String name)
			throws InterruptedException, AWTException, ParseException {
		System.out.println("Step :: Click on Add to watchlist button >> " + name);
		common.log("<br></br> Step :: Click on Add to watchlist button >> " + name);
		// driver.findElement(By.xpath("//li[@id='lot1']//label[1]")).click();
		common.jsClick(addtowatchlist);
		common.pause(15);

		common.acceptAlert();
		common.log("Step :: Accept Alert");
		System.out.println("Step :: accept alert");
		common.pause(10);

		System.out.println("Step :: Click on View My Watchlist");
		common.log("<br></br> Step :: Click on View My Watchlist");
		driver.findElement(By.xpath("//a[@class='catalog-mywatchlist-top']")).click();

		System.out.println("Step :: verified Add to Watchlist button is working properly. ");
		common.log("<br></br>Step :: verified  Add to Watchlist button is working properly..");
		common.pause(30);

	}

	public void Search_Timed_auction_and_go_to_catalog_page(String aucname)
			throws InterruptedException, ParseException {

		common.pause(15);
		common.log("<br></br> Step :: Click on Auction Overview Page");
		System.out.println("Step :: Click on Auction Overview Page");
		common.waitForElement(By.xpath("//a[text()='Auctions']"));
		common.jsClick(auctionsubtab);// Go to Auction overview page
		common.pause(25);
		System.out.println("Step :: Select 100 from dropdown");
		common.log("<br></br> Step :: Select 100 from dropdown");
		driver.findElement(By.xpath("//select[@id='" + LEGACY_ADMIN_LOT_TABLE + "']//option[@value='1']")).click();
		common.pause(60);
		for (int i = 0; i < 20; i++) {
			if (common.isElementPresent("//ul[@class='auclting yura']//a[text()=' " + aucname + "']")) {
				common.log("auction " + aucname + " is present in this page");
				System.out.println("auction " + aucname + " is present in this page");
				driver.findElement(By.xpath("//ul[@class='auclting yura']//a[text()=' " + aucname
						+ "']//..//..//..//..//a[text()='View catalog']")).click();
				common.pause(40);
				break;
			} else {
				common.log("auction " + aucname + " is not present in this page");
				System.out.println("auction " + aucname + " is not  present in this page");
				common.pause(60);
				System.out.println("Step :: Click on Next page");
				common.log("<br></br> Step :: Click on Next page");
				driver.findElement(
						By.xpath("//div[@class='right pagintn']//span[@id='c2_ctl']//a[contains(text(),'Next')]"))
						.click();
				common.pause(40);
			}
		}
		common.pause(10);
	}

	public void Verify_bid_functionality() throws InterruptedException {
		System.out.println("Step ::Click on bid button");
		common.pause(20);
		common.log("<br></br>Step :: Click on bid button");
		driver.findElement(By.xpath("//input[@value='Bid $1,000']")).click();
		common.pause(2);
		System.out.println("Step ::Click on confirmbid button");
		common.log("<br></br>Step :: Click on confirm bid button");
		driver.findElement(By.xpath("//section[@class='item-block-wrapper']//input[contains(@value,'1,000')]")).click();
		common.pause(5);
		common.acceptAlert();
		common.pause(10);

		String str = driver
				.findElement(By.xpath("//section[@class='item-block-wrapper']//input[contains(@value,'Bid $1,050')]"))
				.getAttribute("value");

		System.out.println("Step ::Updated value:: " + str);
		common.log("<br></br>Step ::Updated value:: " + str);

	}

	public void Verify_redirection_to_change_password_page() throws InterruptedException {

		String pagename = driver.findElement(By.xpath("//li[@class='crumb-changepassword']")).getText();
		System.out.println("Step :: Verify reditrection to change password  >> " + pagename);
		common.log("<br></br>Step :: Verify reditrection to change password page >> " + pagename);
	}

	public void Goto_invoice_payment() throws InterruptedException, ParseException {

		common.pause(10);
		System.out.println("Step  :: Click on Invoices");
		common.log("<br></br> Step  :: Click on Invoices");
		driver.findElement(By.xpath("//a[text()='Invoices']")).click();

		common.pause(25);

		System.out.println("Step :: Select Pending from dropdown menu");
		common.log("<br></br> Step :: Select Pending from dropdown menu");
		WebElement dropdown1 = driver.findElement(By.xpath("//select[@id='mil1']"));
		Select s = new Select(dropdown1);
		s.selectByValue("1");
		common.pause(15);
//		Actions actions = new Actions(driver);
//		WebElement ShowDropDown = driver.findElement(By.xpath("//span[@id='c1_ctl']//..[@role='button']"));
//		ShowDropDown.click();
//
//		WebElement select_pending = driver.findElement(By.linkText("Pending"));
//		common.pause(10);
//		//actions.moveToElement(select_pending);
//		//actions.moveToElement(select_pending).click().perform();
//		common.pause(20);

		System.out.println("Step :: Click on view button");
		common.log("<br></br> Step :: Click on view button");
		driver.findElement(By.xpath("//td[text()='Pending']")).click();

		common.pause(25);

		System.out.println("Step :: Click on Pay Now button");
		common.log("<br></br> Step :: Click on Pay Now button");
		driver.findElement(By.xpath("//input[@value='Pay now']")).click();
		common.pause(10);

		waitUntillElementPresent("//input[@id='miiv24']");
		System.out.println("Step :: Click on Pay button ");
		common.log("<br></br> Step :: Click on Pay button");
		driver.findElement(By.xpath("//input[@id='miiv24']")).click();
		common.pause(10);

		String validations = driver.findElement(By.xpath("//div[@id='flash-notification']")).getText();
		System.out.println("Step :: Validations >> " + validations);
		common.log("<br></br> Step :: Validations >>" + validations);

	}

	public void Verify_Timed_Auction_and_goto_catalog_page(String name) throws InterruptedException, AWTException {

		common.log("<br></br> Step :: Click on Auction Overview Page");
		System.out.println("Step :: Click on Auction Overview Page");
		common.waitForElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']"));
		common.jsClick(auctionsubtab);// Go to Auction overview page

		// Select Bidding Now and Upcoming Only

		common.pause(30);
		System.out.println("Step :: Select Bidding now and upcoming");
		common.log("<br></br> Step :: Select Bidding now and upcoming");
		common.waitForElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']"));

		driver.findElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']")).click();
		common.pause(10);

		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Bidding now and upcoming']")).click();
		// Select Timed Only

		System.out.println("Step :: Select Timed Only");
		common.log("<br></br> Step :: Select Timed Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Timed only']")).click();
		common.pause(30);
		// Select Auctioneer Sagar

//		System.out.println("Step :: Select Sagar Auctioneer");
//		common.log("<br></br> Step :: Select Sagar Auctioneer");
//		driver.findElement(By.xpath("//span[@id='alf9_ctl']//..//a[@role='button']")).click();
//
//		// Mouse Event
//		common.pause(10);
//		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Sagar']")).click();

		common.pause(30);

		System.out.println("Step :: Select 100 from dropdown");
		common.log("<br></br> Step :: Select 100 from dropdown");
		driver.findElement(By.xpath("//select[@id='" + LEGACY_ADMIN_LOT_TABLE + "']//option[@value='3']")).click();

		common.pause(60);

		for (int i = 0; i < 20; i++) {

			if (common.isElementPresent("//ul[@class='auclting yura']//a[text()=' " + name + "']"))

			{
				common.log("auction " + name + " is present in this page");
				System.out.println("auction " + name + " is present in this page");
				driver.findElement(By.xpath("//ul[@class='auclting yura']//a[text()=' " + name
						+ "']//..//..//..//..//a[text()='View catalog']")).click();
				common.pause(30);
				break;
			} else {
				common.log("auction " + name + " is not present in this page");
				System.out.println("auction " + name + " is not  present in this page");
				common.pause(40);

				System.out.println("Step :: Click on Next page");
				common.log("<br></br> Step :: Click on Next page");
				driver.findElement(
						By.xpath("//div[@class='right pagintn']//span[@id='c2_ctl']//a[contains(text(),'Next')]"))
						.click();
				common.pause(20);

			}
		}
	}

	public void Verify_to_add_and_view_lot_at_Watchlist_under_MyItems(String lotname1)
			throws InterruptedException, AWTException {

		common.pause(40);
		System.out.println("Step :: Click on Add to watchlist button >>" + lotname1);
		common.log("<br></br> Step :: Click on Add to watchlist button");
		driver.findElement(By.xpath("//li[@class='item-block  '][1]//div[@class='bd-chk']")).click();
		// WebElement webele =
		// common.jsClick(webele);
		common.pause(40);

		common.acceptAlert1();
		common.log("Step :: Accept Alert");
		System.out.println("Step :: accept alert");
		common.pause(10);

		System.out.println("Step :: Click on View My Watchlist");
		common.log("<br></br> Step :: Click on View My Watchlist");
		driver.findElement(By.xpath("//a[@class='catalog-mywatchlist-top']")).click();

		common.pause(20);

	}

	public void goto_Catalog_Page_Time_Sale_dev(String name) throws AWTException

	{
		common.log("<br></br> Step :: Click on Auction Overview Page");
		System.out.println("Step :: Click on Auction Overview Page");
		common.jsClick(auctionsubtab);// Go to Auction overview page

		// Select Bidding Now and Upcoming Only

		common.pause(30);
		System.out.println("Step :: Select Bidding now and upcoming");
		common.log("<br></br> Step :: Select Bidding now and upcoming");

		driver.findElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']")).click();
		common.pause(10);

		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Bidding now and upcoming']")).click();

		common.pause(30);
		// Select Live Only

		System.out.println("Step :: Select Timed Only");
		common.log("<br></br> Step :: Select Timed Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Timed only']")).click();
		common.pause(30);

		System.out.println("Step :: Select 100 from dropdown");
		common.log("<br></br> Step :: Select 100 from dropdown");
		driver.findElement(By.xpath("//select[@id='" + LEGACY_ADMIN_LOT_TABLE + "']//option[@value='3']")).click();

		common.pause(60);

		for (int i = 0; i < 20; i++) {

			if (common.isElementPresent("//ul[@class='auclting yura']//a[text()=' " + name + "']"))

			{
				common.log("auction " + name + " is present in this page");
				System.out.println("auction " + name + " is present in this page");
				driver.findElement(By.xpath("//ul[@class='auclting yura']//a[text()=' " + name
						+ "']//..//..//..//..//a[text()='View catalog']")).click();
				common.pause(30);
				break;
			} else {
				common.log("auction " + name + " is not present in this page");
				System.out.println("auction " + name + " is not  present in this page");
				common.pause(40);

				System.out.println("Step :: Click on Next page");
				common.log("<br></br> Step :: Click on Next page");
				driver.findElement(By.xpath("//span[@id='blkPaginatorBottom']//a[contains(text(),'Next')]")).click();
				common.pause(40);
			}

		}
	}
	
	public void goto_Catalog_Page_Live_Sale_dev(String name) throws AWTException

	{
		common.log("<br></br> Step :: Click on Auction Overview Page");
		System.out.println("Step :: Click on Auction Overview Page");
		common.jsClick(auctionsubtab);// Go to Auction overview page

		// Select Bidding Now and Upcoming Only

		common.pause(30);
		System.out.println("Step :: Select Bidding now and upcoming");
		common.log("<br></br> Step :: Select Bidding now and upcoming");

		driver.findElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']")).click();
		common.pause(10);

		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Bidding now and upcoming']")).click();

		common.pause(30);
		// Select Live Only

		System.out.println("Step :: Select Live Only");
		common.log("<br></br> Step :: Select Live Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Live only']")).click();
		common.pause(30);

		System.out.println("Step :: Select 100 from dropdown");
		common.log("<br></br> Step :: Select 100 from dropdown");
		driver.findElement(By.xpath("//select[@id='" + LEGACY_ADMIN_LOT_TABLE + "']//option[@value='3']")).click();

		common.pause(60);

		for (int i = 0; i < 20; i++) {

			if (common.isElementPresent("//ul[@class='auclting yura']//a[text()=' " + name + "']"))

			{
				common.log("auction " + name + " is present in this page");
				System.out.println("auction " + name + " is present in this page");
				driver.findElement(By.xpath("//ul[@class='auclting yura']//a[text()=' " + name
						+ "']//..//..//..//..//a[text()='View catalog']")).click();
				common.pause(30);
				break;
			} else {
				common.log("auction " + name + " is not present in this page");
				System.out.println("auction " + name + " is not  present in this page");
				common.pause(40);

				System.out.println("Step :: Click on Next page");
				common.log("<br></br> Step :: Click on Next page");
				driver.findElement(By.xpath("//span[@id='blkPaginatorBottom']//a[contains(text(),'Next')]")).click();
				common.pause(40);
			}

		}
	}


	public void placeBidFromCatalogpage() throws AWTException, InterruptedException {


		common.waitForConditionIsElementPresent("//span[@class='" + LEGACY_FRONT_BUY_QUANTITY + "']//input");
		System.out.println("Step :: Fill Place bid value");
		common.log("<br></br> Step :: Fill Place  bid value");
		common.highlightElement("//span['" + LEGACY_FRONT_BUY_QUANTITY + "']//input");
		common.type("//span[@class='" + LEGACY_FRONT_BUY_QUANTITY + "']//input", "330");
		common.pause(5);
		
		//common.waitForConditionIsElementPresent("//div[@class='" + LEGACY_FRONT_AUCTIONLIST_BUTTON
			//	+ "']//input[@value='" + LEGACY_FRONT_BUYNOW_BUTTON + "']");
		System.out.println("Step :: Click on Buy Now Button");
		common.log("<br></br> Step :: Click on Buy Now Button");
		common.highlightElement("//div[@class='" + LEGACY_FRONT_AUCTIONLIST_BUTTON + "']//input[@value='"
				+ LEGACY_FRONT_BUYNOW_BUTTON + "']");
		driver.findElement(By.xpath("//div[@class='" + LEGACY_FRONT_AUCTIONLIST_BUTTON + "']//input[@value='"
				+ LEGACY_FRONT_BUYNOW_BUTTON + "']")).click();

		common.acceptAlert1();
		common.pause(40);

		System.out.println("Exceeded amount is validated");
		common.log("Exceeded amount is validated");

		common.log("<br></br> Step :: Click on Logout Button");
		System.out.println("Step :: Click on Logout Button");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_ADMIN_LNK_LOGOUT + "']")).click(); // Click on logout
	}

	public void placeBidFromCatalogPageWithFullQuantity() throws AWTException, InterruptedException {

		common.waitForConditionIsElementPresent("//div[@class='" + LEGACY_FRONT_AUCTIONLIST_BUTTON
				+ "']//input[@value='" + LEGACY_FRONT_BUYNOW_BUTTON + "']");
		System.out.println("Step :: Click on Buy Now Button");
		common.log("<br></br> Step :: Click on Buy Now Button");
		common.highlightElement("//div[@class='" + LEGACY_FRONT_AUCTIONLIST_BUTTON + "']//input[@value='"
				+ LEGACY_FRONT_BUYNOW_BUTTON + "']");
		driver.findElement(By.xpath("//div[@class='" + LEGACY_FRONT_AUCTIONLIST_BUTTON + "']//input[@value='"
				+ LEGACY_FRONT_BUYNOW_BUTTON + "']")).click();
		
		common.waitForConditionIsElementPresent("//span[@class='" + LEGACY_FRONT_CLICK_BUTTON + "']//input[@value='"
				+ LEGACY_FRONT_CONFIRM_BUTTON + "']");
		System.out.println("Step :: Click on Confirm button");
		common.log("<br></br> Step :: Click on Confirm Button");
		common.highlightElement("//span[@class='" + LEGACY_FRONT_CLICK_BUTTON + "']//input[@value='"
				+ LEGACY_FRONT_CONFIRM_BUTTON + "']");
		driver.findElement(By.xpath("//span[@class='" + LEGACY_FRONT_CLICK_BUTTON + "']//input[@value='" + LEGACY_FRONT_CONFIRM_BUTTON + "']")).click();
		

		System.out.println("Complete quantity is successfully sold");
		common.log("Complete quantity is successfully sold");

		common.log("<br></br> Step :: Click on Logout Button");
		System.out.println("Step :: Click on Logout Button");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_ADMIN_LNK_LOGOUT + "']")).click(); // Click on logout
	}

	public void placeBidFewQuantityFromCatalogPage() throws AWTException, InterruptedException {
		common.waitForConditionIsElementPresent("//span[@class='" + LEGACY_FRONT_BUY_QUANTITY + "']//input");
		System.out.println("Step :: Fill Place bid value");
		common.log("<br></br> Step :: Fill Place  bid value");
		common.highlightElement("//span['" + LEGACY_FRONT_BUY_QUANTITY + "']//input");
		common.type("//span[@class='" + LEGACY_FRONT_BUY_QUANTITY + "']//input", "30");

		common.waitForConditionIsElementPresent("//div[@class='" + LEGACY_FRONT_AUCTIONLIST_BUTTON
				+ "']//input[@value='" + LEGACY_FRONT_BUYNOW_BUTTON + "']");
		System.out.println("Step :: Click on Buy Now Button");
		common.log("<br></br> Step :: Click on Buy Now Button");
		common.highlightElement("//div[@class='" + LEGACY_FRONT_AUCTIONLIST_BUTTON + "']//input[@value='"
				+ LEGACY_FRONT_BUYNOW_BUTTON + "']");
		driver.findElement(By.xpath("//div[@class='" + LEGACY_FRONT_AUCTIONLIST_BUTTON + "']//input[@value='"
				+ LEGACY_FRONT_BUYNOW_BUTTON + "']")).click();

		common.waitForConditionIsElementPresent("//span[@class='" + LEGACY_FRONT_CLICK_BUTTON + "']//input[@value='"
				+ LEGACY_FRONT_CONFIRM_BUTTON + "']");
		System.out.println("Step :: Click on Confirm button");
		common.log("<br></br> Step :: Click on Confirm Button");
		common.highlightElement("//span[@class='" + LEGACY_FRONT_CLICK_BUTTON + "']//input[@value='"
				+ LEGACY_FRONT_CONFIRM_BUTTON + "']");
		driver.findElement(By.xpath("//span[@class='" + LEGACY_FRONT_CLICK_BUTTON + "']//input[@value='" + LEGACY_FRONT_CONFIRM_BUTTON + "']")).click();

		System.out.println("Few quantity is sold");
		common.log("Few quantity is sold");

		common.waitForConditionIsElementPresent("//a[text()='" + LEGACY_ADMIN_LNK_LOGOUT + "']");
		common.log("<br></br> Step :: Click on Logout Button");
		System.out.println("Step :: Click on Logout Button");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_ADMIN_LNK_LOGOUT + "']")).click(); // Click on logout
	}

	public void placeBidWithInvalidQuantityFromCatalogPage() throws AWTException, InterruptedException {

		common.waitForConditionIsElementPresent("//span[@class='" + LEGACY_FRONT_BUY_QUANTITY + "']//input");
		System.out.println("Step :: Fill Place bid value");
		common.log("<br></br> Step :: Fill Place  bid value");
		common.highlightElement("//span['" + LEGACY_FRONT_BUY_QUANTITY + "']//input");
		common.type("//span[@class='" + LEGACY_FRONT_BUY_QUANTITY + "']//input", "30.sfd");

		common.waitForConditionIsElementPresent("//div[@class='" + LEGACY_FRONT_AUCTIONLIST_BUTTON
				+ "']//input[@value='" + LEGACY_FRONT_BUYNOW_BUTTON + "']");
		System.out.println("Step :: Click on Buy Now Button");
		common.log("<br></br> Step :: Click on Buy Now Button");
		common.highlightElement("//div[@class='" + LEGACY_FRONT_AUCTIONLIST_BUTTON + "']//input[@value='"
				+ LEGACY_FRONT_BUYNOW_BUTTON + "']");
		driver.findElement(By.xpath("//div[@class='" + LEGACY_FRONT_AUCTIONLIST_BUTTON + "']//input[@value='"
				+ LEGACY_FRONT_BUYNOW_BUTTON + "']")).click();

		common.acceptAlert1();
		common.pause(40);

		System.out.println("Invalid amount is validated");
		common.log("Invalid amount is validated");

		common.log("<br></br> Step :: Click on Logout Button");
		System.out.println("Step :: Click on Logout Button");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_ADMIN_LNK_LOGOUT + "']")).click(); // Click on logout
	}
	
	
	public void clickOnRegisterBidCatalog() throws AWTException, InterruptedException {

		System.out.println("Step :: Click on Register to Bid !");
		common.log("<br></br>Step :: Click on Register to Bid !");
		common.highlightElement("//div[@class='unibtn auclistbtn']//a[text()='Register to bid!']");
		driver.findElement(By.xpath("//div[@class='unibtn auclistbtn']//a[text()='Register to bid!']")).click();
		common.pause(30);

	}

	public void uploadResellerCertificate() throws AWTException, InterruptedException {

		if (common.isElementPresent("//input[@id='cbo02']")) {
			System.out.println("Step :: Click on Confirm  ");
			common.log("<br></br>Step :: Click on Confirmation Yes button ");
			common.highlightElement("//input[@id='cbo02']");
			driver.findElement(By.xpath("//input[@id='cbo02']")).click();
		}
		common.pause(30);

		System.out.println("Step :: Click on Confirmation Yes button ");
		common.log("<br></br>Step :: Click on Confirmation Yes button ");
		common.highlightElement("//input[@id='tac1']");
		driver.findElement(By.xpath("//input[@id='tac1']")).click();
		common.pause(30);

		System.out.println("Step :: Enter Reseller ID");
		common.log("<br></br>Step :: Enter Reseller ID");
		common.highlightElement("//input[@id='" + LEGACY_FRONT_RESELLER_TXT_FIELD + "']");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_FRONT_RESELLER_TXT_FIELD + "']")).click();
		common.type("//input[@id='" + LEGACY_FRONT_RESELLER_TXT_FIELD + "']", LEGACY_FRONT_RESELLER_ID);
		common.pause(30);

//		System.out.println("Step :: Upload File");
//		common.log("<br></br>Step :: Upload File");
//		common.jsClick(uploadresellercertificate);
//		common.pause(40);

		String path_win = "C:\\Users\\BAPS\\Desktop\\Hardik_29_8\\sam-qa\\test_data\\sample.pdf";
		StringSelection filepath = new StringSelection(path_win);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(filepath, filepath);

		System.out.println("Step :: Click on Browse.. Button");
		common.highlightElement("//input[@id='rdp4']");
		WebElement file1 = driver.findElement(By.xpath("//input[@id='rdp4']"));
		common.pause(10);
		Actions action = new Actions(driver);
		action.moveToElement(file1);
		action.moveToElement(file1).click().perform();
		common.pause(30);

		Robot robot = new Robot();
//		robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
//		robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
		common.pause(15);

		common.pause(30);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		common.pause(5);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		common.pause(30);

		// robot.delay(200);
		robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
		robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
		common.pause(20);
//		robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
//		robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
//		common.pause(50);

		System.out.println("Step :: Click on Submit button ");
		common.log("<br></br>Step :: Click on Submit button ");
		common.highlightElement("//input[@id='rdp5']");
		driver.findElement(By.xpath("//input[@id='rdp5']")).click();
		common.pause(20);

		if (common.isElementPresent("//div[@class='unibtn auclistbtn']//a[text()='Pending approval']")) {
			System.out.println("Step :: Reseller Certificate is uploaded");
			common.log("<br></br>Step :: Reseller Certificate is uploaded");
		} else {
			System.out.println("Step :: Bug is not fixed");
			common.log("<br></br>Step :: Bug is not fixed");
		}

		common.pause(5);
		common.jsClick(logout);
	}

	public void fill_Revise_Billing_Info() throws AWTException, InterruptedException {

		String firstname = common.generateRandomChars(5);
		String lastname = common.generateRandomChars(5);
		String str = common.generateRandomChars(3);
		String email = "hardik" + str + "@bidpath.net";

		if (common.isElementPresent("//input[@id='cbo02']")) {
			System.out.println("Step :: Click on Confirm  ");
			common.log("<br></br>Step :: Click on Confirmation Yes button ");
			common.highlightElement("//input[@id='cbo02']");
			driver.findElement(By.xpath("//input[@id='cbo02']")).click();
		}
		common.pause(30);

		System.out.println("Step :: Enter firstname");
		common.log("<br></br>Step :: Enter firstname");
		common.highlightElement("//input[@id='pbp3']");
		driver.findElement(By.xpath("//input[@id='pbp3']")).sendKeys(firstname);

		System.out.println("Step :: Enter lastname");
		common.log("<br></br>Step :: Enter lastname");
		common.highlightElement("//input[@id='pbp4']");
		driver.findElement(By.xpath("//input[@id='pbp4']")).sendKeys(lastname);

		System.out.println("Step :: Enter Phone number");
		common.log("<br></br>Step :: Enter Phone number");
		common.highlightElement("//input[@id='pnpbp5']");
		driver.findElement(By.xpath("//input[@id='pnpbp5']")).sendKeys("4154154141");

		System.out.println("Step :: Enter Email");
		common.log("<br></br>Step :: Enter Email");
		common.highlightElement("//input[@id='pbp52']");
		driver.findElement(By.xpath("//input[@id='pbp52']")).sendKeys(email);

		System.out.println("Step :: Click on edit icon");
		common.log("<br></br> Step :: Click on edit icon");
		driver.findElement(By.xpath("//a[@id='" + LEGACY_USER_BTN_EDIT_CC + "']")).click();
		common.pause(10);

		/**
		 * Select CC Type
		 */
		System.out.println("Step :: Select CC Type.");
		common.log("<br></br>Step :: Select CC Type.");
		driver.findElement(By.xpath("//select[@id='pbp13']")).click();
		common.pause(20);
		WebElement CCtype = driver.findElement(By.xpath("//select[@id='pbp13']"));
		Select s1 = new Select(CCtype);
		s1.selectByValue("2");
		common.pause(20);

		common.type("///input[@id='pbp14']", "4111111111111111");

		/**
		 * Select Expiration Month
		 * 
		 */

		System.out.println("Step :: Select CC Month.");
		common.log("<br></br>Step :: Select CC Month.");
		driver.findElement(By.xpath("//select[@id='pbp13']")).click();
		common.pause(20);
		WebElement CCmonth = driver.findElement(By.xpath("//select[@id='pbp13']"));
		Select s2 = new Select(CCtype);
		s2.selectByValue("2");
		common.pause(20);

		/**
		 * Select Expiration Years
		 * 
		 */

		System.out.println("Step :: Select CC Year.");
		common.log("<br></br>Step :: Select CC Year.");
		driver.findElement(By.xpath("//select[@id='pbp13']")).click();
		common.pause(20);
		WebElement CCyear = driver.findElement(By.xpath("//select[@id='pbp13']"));
		Select s3 = new Select(CCtype);
		s3.selectByValue("2");
		common.pause(20);

		// enter security code
		common.type("//input[@id='" + LEGACY_USER_SIGNUP_CC_CODE + "']", "123");
		common.pause(10);

	}

	public void goto_Catalog_Page_Time_Sale_qa36auto(String name) throws AWTException
	{
		common.log("<br></br> Step :: Click on Auction Overview Page");
		System.out.println("Step :: Click on Auction Overview Page");
		common.jsClick(auctionsubtab);// Go to Auction overview page

		// Select Bidding Now and Upcoming Only

		common.pause(30);
		System.out.println("Step :: Select Bidding now and upcoming");
		common.log("<br></br> Step :: Select Bidding now and upcoming");

		driver.findElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']")).click();
		common.pause(10);

		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Bidding now and upcoming']")).click();

		common.pause(30);
		// Select Live Only

		System.out.println("Step :: Select Timed Only");
		common.log("<br></br> Step :: Select Timed Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Timed only']")).click();
		common.pause(30);

		System.out.println("Step :: Select 100 from dropdown");
		common.log("<br></br> Step :: Select 100 from dropdown");
		driver.findElement(By.xpath("//select[@id='" + LEGACY_ADMIN_LOT_TABLE + "']//option[@value='3']")).click();

		common.pause(60);

		for (int i = 0; i < 20; i++) {

			if (common.isElementPresent("//ul[@class='auclting yura']//a[text()=' " + name + "']"))

			{
				common.log("auction " + name + " is present in this page");
				System.out.println("auction " + name + " is present in this page");
				driver.findElement(By.xpath("//ul[@class='auclting yura']//a[text()=' " + name
						+ "']//..//..//..//..//a[text()='View catalog']")).click();
				common.pause(30);
				break;
			} else {
				common.log("auction " + name + " is not present in this page");
				System.out.println("auction " + name + " is not  present in this page");
				common.pause(40);

				System.out.println("Step :: Click on Next page");
				common.log("<br></br> Step :: Click on Next page");
				driver.findElement(By.xpath("//span[@id='blkPaginatorBottom']//a[contains(text(),'Next')]")).click();
				common.pause(40);
			}

		}
		
	}

	public void verify_Absentee_Bids_Are_Correctly_Placed(String auctionName, String lotname1) throws AWTException {
		goto_Catalog_Page_Live_Sale(auctionName);
		System.out.println("Step :: Click on Lot Details Page");
		common.log("<br></br> Step :: Click on Lot Details Page");
		driver.findElement(By.xpath("//h2//a[text()='" + lotname1 + "']")).click();
		common.pause(25);

		System.out.println("Step :: Enter Bid Value");
		common.log("<br></br> Step :: Enter Bid Value");
		driver.findElement(By.xpath("//span[@class='"+LEGACY_USER_BIDDING_VALUE+"']//input")).sendKeys("300");
		common.pause(20);

		System.out.println("Step :: Click on Place bid Button");
		common.log("<br></br> Step :: Click on Place Bid Button");
		driver.findElement(By.xpath("//input[@value='"+LEGACY_USER_BTN_PLACE_BID+"']")).click();
		common.pause(20);

		common.assertElementPresent("//span[@class='"+LEGACY_USER_TXT_WINNING_MESSAGE+"']");
		common.pause(20);

		String Highbid = driver.findElement(By.xpath("//span[@class='"+LEGACY_USER_TXT_WINNING_MESSAGE+"']")).getText();
		System.out.println("Step :: Verify Success Message >> " + Highbid);
		common.log("<br></br> Step :: Verify Success Message >> " + Highbid);

	}

	/**
	 * Verify bid message
	 * 
	 * @param auctionName
	 * @param lotName
	 * @throws AWTException
	 * @throws InterruptedException
	 */

	public void verify_Bid_Message(String name, String lotName) throws AWTException, InterruptedException

	{

		goto_Catalog_Page_Live_Sale(name);

		common.pause(40);
		System.out.println("Step :: Enter bid value");
		common.log("<br></br> Step :: Enter bid value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"+ LEGACY_USER_TXT_REGULAR_LIVE_BID + "']")).sendKeys("100.11");
		common.pause(20);

		System.out.println("Step :: Click on placebid button");
		common.log("<br></br> Step :: Click on placebid button");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']")).click();
		common.pause(10);
		common.acceptAlert();
		
		common.waitForConditionIsElementPresent("//div[text()='Your high bid!']");
		common.assertElementPresent("//div[text()='Your high bid!']");
		String Highbid = driver.findElement(By.xpath("//div[text()='Your high bid!']")).getText();
		System.out.println("Step :: Verify Success Message >> " + Highbid);
		common.log("<br></br> Step :: Verify Success Message >> " + Highbid);

	}
	/**
	 * Verify bid message for US number formatting checkbox disable
	 * 
	 * @param auctionName
	 * @param lotName
	 * @throws AWTException
	 * @throws InterruptedException
	 */

	public void verify_Bid_Message_For_US_Number_Formatting_Checkbox_Disable(String name, String lotName) throws AWTException, InterruptedException

	{

		goto_Catalog_Page_Live_Sale(name);

		common.pause(40);
		System.out.println("Step :: Enter bid value");
		common.log("<br></br> Step :: Enter bid value");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@class='"+ LEGACY_USER_TXT_REGULAR_LIVE_BID + "']")).sendKeys("100.11");
		common.pause(20);

		System.out.println("Step :: Click on placebid button");
		common.log("<br></br> Step :: Click on placebid button");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']//..//..//..//input[@value='" + LEGACY_USER_BTN_PLACE_BID + "']")).click();
		common.pause(10);
		
		
		common.waitForConditionIsElementPresent("//span[text()='Too small amount']");
		common.assertElementPresent("//span[text()='Too small amount']");
		String message = driver.findElement(By.xpath("//span[text()='Too small amount']")).getText();
		System.out.println("Step :: Verify Message >> " + message);
		common.log("<br></br> Step :: Verify Message >> " + message);

	}
	
	public void place_Bid_Timed_Auction(String aucname, String lotName) throws AWTException, InterruptedException {
		goto_Catalog_Page_Timed_Sale(aucname);
		common.pause20Sec();
		System.out.println("Step :: Click on Lot Details Page");
		common.log("<br></br> Step :: Click on Lot Details Page");
		driver.findElement(By.xpath("//h2//a[text()='" + lotName + "']")).click();
		common.pause20Sec();
		
		System.out.println("Step :: Fill Value");
		common.log("<br></br> Step :: Fill Value");
		driver.findElement(By.xpath("//input[@class='"+LEGACY_USER_BID_VALUE+"']")).sendKeys("250");
		common.pause20Sec();
		
		System.out.println("Step :: Click on place bid button");
		common.log("<br></br> Step :: Click on place bid button");
		driver.findElement(By.xpath("//input[@value='"+LEGACY_USER_BTN_PLACE_BID+"']")).click();
		common.pause20Sec();
		
		common.assertElementPresent("//div[@class='"+LEGACY_USER_TXT_HIGH_BID_MESSAGE_CLASS+"']");
		String bidmessage = driver.findElement(By.xpath("//div[@class='"+LEGACY_USER_TXT_HIGH_BID_MESSAGE_CLASS+"']")).getText();
		System.out.println("Step :: Bid message :" +bidmessage);
		common.log("<br></br>Step :: Bid message : " +bidmessage);
	}
	
	public void liveSale() throws InterruptedException, AWTException {
		
		common.pause(30);
		System.out.println("Step :: Click on Lot name Link");
		common.log("<br></br> Step :: Click on Lot name Link");
		driver.findElement(By.xpath("//div[@class='bdttle']//a[text()='Lot #1']")).click();
		common.pause(30);

		System.out.println("Step :: Click on Live Sale Link");
		common.log("<br></br> Step :: Click on Live Sale Link");
		driver.findElement(By.xpath("//div[@class='live-sale']")).click();
		common.pause(30);
		
		System.out.println("Step :: Send message on Live Sale page");
		common.log("<br></br> Step ::  Send message on Live Sale page");
		driver.findElement(By.xpath("//input[@id='txtMessage']")).sendKeys("Testing Message!!");
		common.pause20Sec();
		
		System.out.println("Step :: Click on Send button");
		common.log("<br></br> Step ::  Click on Send button");
		driver.findElement(By.xpath("//a[@id='btnSendMessage']")).click();
		common.pause20Sec();
		
		String sendmessage = driver.findElement(By.xpath("//div[@id='chat-messages']")).getText();
		System.out.println("Step :: Verify Sent message >>" + sendmessage);
        common.log("Step :: Verify Sent message >>" + sendmessage);
		common.assertTwoValuesAreEqual(sendmessage, LEGACY_SEND_TXT_MESSAGE);
		common.pause20Sec();

		common.jsClick(logout);
	}


	public void goto_Catalog_Page_Live_Sale_qa36auto(String name) throws AWTException
	{
		common.log("<br></br> Step :: Click on Auction Overview Page");
		System.out.println("Step :: Click on Auction Overview Page");
		common.jsClick(auctionsubtab);// Go to Auction overview page

		// Select Bidding Now and Upcoming Only

		common.pause(30);
		System.out.println("Step :: Select Bidding now and upcoming");
		common.log("<br></br> Step :: Select Bidding now and upcoming");

		driver.findElement(By.xpath("//span[@id='alf1_ctl']//..//a[@role='button']")).click();
		common.pause(10);

		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Bidding now and upcoming']")).click();

		common.pause(30);
		// Select Live Only

		System.out.println("Step :: Select Live Only");
		common.log("<br></br> Step :: Select Live Only");

		driver.findElement(By.xpath("//span[@id='alf3_ctl']//..//a[@role='button']")).click();
		common.pause(10);
		driver.findElement(By.xpath("//li[@class='ui-menu-item']//div[text()='Live only']")).click();
		common.pause(30);

		System.out.println("Step :: Select 100 from dropdown");
		common.log("<br></br> Step :: Select 100 from dropdown");
		driver.findElement(By.xpath("//select[@id='" + LEGACY_ADMIN_LOT_TABLE + "']//option[@value='3']")).click();

		common.pause(60);

		for (int i = 0; i < 20; i++) {

			if (common.isElementPresent("//ul[@class='auclting yura']//a[text()=' " + name + "']"))

			{
				common.log("auction " + name + " is present in this page");
				System.out.println("auction " + name + " is present in this page");
				driver.findElement(By.xpath("//ul[@class='auclting yura']//a[text()=' " + name
						+ "']//..//..//..//..//a[text()='View catalog']")).click();
				common.pause(30);
				break;
			} else {
				common.log("auction " + name + " is not present in this page");
				System.out.println("auction " + name + " is not  present in this page");
				common.pause(40);

				System.out.println("Step :: Click on Next page");
				common.log("<br></br> Step :: Click on Next page");
				driver.findElement(By.xpath("//span[@id='blkPaginatorBottom']//a[contains(text(),'Next')]")).click();
				common.pause(40);
			}

		}
		
	}
	
	public void verify_Custom_Field_Access_To_Bidder_Is_Not_Showing_Field_To_Bidder(String aucname, String lotName) throws AWTException, InterruptedException {
		goto_Catalog_Page_Timed_Sale(aucname);
		common.pause20Sec();
		common.assertElementPresent("//ul[@class='"+LEGACY_USER_CUSTOM_FIELD+"']//li[1]");
		common.pause20Sec();
		String customfield = driver.findElement(By.xpath("//ul[@class='"+LEGACY_USER_CUSTOM_FIELD+"']//li[1]")).getText();
		System.out.println("Step :: Verified dropdown field" +customfield);
		common.log("<br></br>Step :: Verified dropdown field" +customfield);
		common.pause20Sec();
	}
	
	public void placeBidFromCatalogPage() throws AWTException, InterruptedException {
		
		common.waitForConditionIsElementPresent("//div[@class='" + LEGACY_FRONT_AUCTIONLIST_BUTTON
				+ "']//input[@value='" + LEGACY_FRONT_BID_BUTTON + "']");
		System.out.println("Step :: Click on Bid Button");
		common.log("<br></br> Step :: Click on Bid Button");
		common.highlightElement("//div[@class='" + LEGACY_FRONT_AUCTIONLIST_BUTTON + "']//input[@value='"
				+ LEGACY_FRONT_BID_BUTTON + "']");
		driver.findElement(By.xpath("//div[@class='" + LEGACY_FRONT_AUCTIONLIST_BUTTON + "']//input[@value='"
				+ LEGACY_FRONT_BID_BUTTON + "']")).click();

		common.acceptAlert();
		common.pause20Sec();
		
		System.out.println("Bid is placed");
		common.log("Bid is placed");
		
		common.waitForConditionIsElementPresent("//input[@class='" + LEGACY_FRONT_PLACE_BID + "']");
		System.out.println("Step :: Enter and Place Bid ");
		common.log("<br></br> Step :: Enter and Place Bid");
		common.highlightElement("//input[@class='" + LEGACY_FRONT_PLACE_BID + "']");
		driver.findElement(By.xpath("//input[@class='" + LEGACY_FRONT_PLACE_BID + "']")).clear();
		driver.findElement(By.xpath("//input[@class='" + LEGACY_FRONT_PLACE_BID + "']")).sendKeys("200");
		common.pause20Sec();
		
		System.out.println("Step :: Click on Change Bid button ");
		common.log("<br></br> Step :: Click on Change Bid button");
		driver.findElement(By.xpath("//input[@value='Change bid!']")).click();
		common.pause20Sec();
		
		common.acceptAlert();
		common.pause20Sec();
		
		common.waitForConditionIsElementPresent("//a[text()='" + LEGACY_ADMIN_LNK_LOGOUT + "']");
		common.log("<br></br> Step :: Click on Logout Button");
		System.out.println("Step :: Click on Logout Button");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_ADMIN_LNK_LOGOUT + "']")).click(); // Click on logout
	}
	public void verify_On_File_Custom_Field_Of_Signup_Edit_Profile_Page(String name) throws InterruptedException {
		common.pause20Sec();
		common.waitUntillElementPresent("//a[text()='Signup']");
		System.out.println("Step :: SignupUSer Details.");
		common.log("<br></br> Step :: SignupUSer Details.");
		common.jsClick(signUpLink);
		common.pause20Sec();
		
		common.waitUntillElementPresent("//input[@class='addlink']");
		
		driver.findElement(By.xpath("//input[@class='addlink']")).click();
		common.pause20Sec();
		common.assertElementPresent("//img[@alt='Upload']");
		System.out.println("Step :: Verified file type custom field on signup profile page it does not show Oops error popup");
		common.log("<br></br>Step :: Verified file type custom field on signup profile page it does not show Oops error popup");
		common.pause20Sec();
		
//		System.out.println("Step :: Login with valid credentials");
//		common.log("<br></br>Step :: Login with valid credentials");
//		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		common.pause20Sec();
		
		driver.get(configFileReader.getFrontUrl());
		loginPage = new LoginPage(driver);
		loginPage = indexPage.clickOnLoginLink(); // click on login link
		dashboardPage = loginPage.loginUser(name, "123123");
		
		common.pause20Sec();
		System.out.println("Step  :: Click on Profile");
		common.log("<br></br> Step  :: Click on Profie");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_USER_PROFILE_TAB + "']")).click();
		common.pause20Sec();
		
		driver.findElement(By.xpath("//input[@class='addlink']")).click();
		common.pause20Sec();
		common.assertElementPresent("//img[@alt='Upload']");
		System.out.println("Step :: Verified file type custom field on edit profile page it does not show Oops error popup");
		common.log("<br></br>Step :: Verified file type custom field on edit profile page it does not show Oops error popup");
		common.pause20Sec();
		
		
		
		
	}
	
}
