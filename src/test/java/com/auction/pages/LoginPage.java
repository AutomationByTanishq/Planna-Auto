package com.auction.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.auction.init.Common;
import com.auction.pages.auctionregistration.AbstractPage;
import com.auction.pages.index.IndexPage;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.lang.ObjectUtils.Null;

public class LoginPage extends AbstractPage {

	Common common = new Common(driver);

	/**
	 * Constructor
	 * 
	 * @param Dashboard driver
	 */
	public LoginPage(WebDriver driver) {
		super(driver);

	}

	/**
	 * Verify Login Page Elements
	 * 
	 */
	public void verifyLoginPageElements() {

//		WebElement loginlabel = driver.findElement(By.xpath("//label[text()='" + LEGACY_FRONT_LOGIN_LBL_USERNAME1 + "']"));
//		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//		jsExecutor.executeScript("arguments[0].style.border='2px solid red'", loginlabel); 
		common.assertElementPresent("//label[text()='" + LEGACY_FRONT_LOGIN_LBL_USERNAME + "']");
		 
		System.out.print("\nStep :: Verify Username Text");
		common.log("<br></br> Step :: Verify Username Text");
		common.assertElementPresent("//label[text()='" + LEGACY_FRONT_LOGIN_LBL_USERNAME + "']");
		//common.assertElementPresent("//label[text()='" + LEGACY_FRONT_LOGIN_LBL_USERNAME1 + "']");

		System.out.print("\nStep :: Verify Password");
		common.log("Verify Password,");
		common.assertElementPresent("//label[text()='" + LEGACY_FRONT_LOGIN_LBL_PASSWORD + "']");

		System.out.print("\nStep :: Verify Not a Member text");
		common.log("Verify Not a Member text,");
		common.assertElementPresent("//p[text()='" + LEGACY_FRONT_LOGIN_LBL_NOT_A_MEMBER_YET + "']");

		System.out.print("\nStep :: Verify Auctions text");
		common.log("Verify Auctions text,");
		common.assertElementPresent("//a[text()='" + LEGACY_FRONT_LOGIN_TXT_AUCTIONS + "']");

//		System.out.print("\nStep :: Verify My Items text");
//		common.log("Verify My Items text,");
//		common.assertElementPresent("//a[text()='" + LEGACY_FRONT_LOGIN_TXT_ITEMS + "']");

		System.out.print("\nStep :: Verify Signup text");
		common.log("Verify Signup text,");
		common.assertElementPresent("//a[text()='" + LEGACY_FRONT_LOGIN_TXT_SIGNUP + "']");

		System.out.print("\nStep :: Verify Login text");
		common.log("Verify Login text,");
		common.assertElementPresent("//a[text()='" + LEGACY_FRONT_LOGIN_TXT_LOGIN + "']");

		System.out.print("\nStep :: Verify Forgot Password text");
		common.log("Verify Forgot Password text,");
		common.assertElementPresent("//a[text()='" + LEGACY_FRONT_LOGIN_TXT_FORGOT_PASSWORD + "']");

		System.out.print("\nStep :: Verify Not a Member text");
		common.log("Verify Not a Member text,");
		common.assertElementPresent("//p[text()='" + LEGACY_FRONT_LOGIN_LBL_NOT_A_MEMBER_YET + "']");
		
		System.out.print("\nStep :: Verify Register Now");
		common.log("Verify Register Now,");
		common.assertElementPresent("//a[text()='" + LEGACY_FRONT_LOGIN_LBL_NOT_REGISTER_NOW + "']");
		
//		System.out.print("\nStep :: Verify It's easy");
//		common.log("Verify It's easy");
//		common.assertElementPresent("//p[contains(text(),'It's easy!')]");
		
		System.out.print("\nStep :: Verify SIGN IN");
		common.log("Verify SIGN IN");
		common.assertElementPresent("//h2[contains(text(),'Sign in')]");
	}

	/**
	 * [Dashboard Page]Login Users
	 * 
	 * @throws InterruptedException
	 * 
	 * 
	 */
	public DashboardPage loginUser(String username, String password) throws InterruptedException {

		System.out.println("<br></br>Step :: Enter Login Details.");
		common.log("<br></br> Step :: Enter Login Details.");
		common.pause20Sec();
		System.out.println("Username ::" + username);
	
		common.log("<br></br>Username ::" + username);
		common.type("//input[@id='" + LEGACY_FRONT_LOGIN_TXT_USERNAME + "']", username);
		common.pause20Sec();

		System.out.println("Password ::" + password);
		common.log("<br></br>Password ::" + password);
		common.type("//input[@id='" + LEGACY_FRONT_LOGIN_TXT_PASSWORD + "']", password);
		common.pause20Sec();

		System.out.println("Step :: Click on submit button.");
		common.log("<br></br>Step :: Click on submit button");
		common.jsClick(submitbutton);

		common.pause20Sec();
		common.highlightElement("//p[contains(text(),'"+LEGACY_USER_LOGIN+"')]");
		common.assertElementPresent("//p[contains(text(),'"+LEGACY_USER_LOGIN+"')]");
		common.log("<br></br> Step :: log in is successful");
		System.out.println("Step :: log in is successful");

		common.log("<br></br>Login Feature => Working</font>");
		System.out.println("Step :: Login Feature => Working");
		return new DashboardPage(driver);

	}

	/**
	 * user 1 Login
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public DashboardPage LoginUser1(String username, String password) {

		System.out.println("\n Step :: Enter Login Details.");

		common.log("<br></br> Step :: Enter Login Details.");
		common.waitForConditionIsElementPresent(("//input[@id='" + LEGACY_FRONT_LOGIN_TXT_USERNAME + "']"));

		System.out.println("\n Step :: Username ::" + username);
		common.log("<br></br>Username ::" + username);
		common.type("//input[@id='" + LEGACY_FRONT_LOGIN_TXT_USERNAME + "']", username);

		System.out.println("\n Step :: Password ::" + password);
		common.log("<br></br>Password ::" + password);
		common.type("//input[@id='" + LEGACY_FRONT_LOGIN_TXT_PASSWORD + "']", password);

		System.out.println("\n Step :: Click on submit button.");
		common.log("<br></br>Step :: Click on submit button");
		common.jsClick(submitbutton);

		common.log("log in is successful");
		System.out.println("\n Step :: log in is successful");
		common.log("<br></br>Step :: Login Feature => Working</font>");
		System.out.println("Step :: Login Feature => Working");
		return new DashboardPage(driver);

	}

	public DashboardPage LoginUser2(String username, String password) {

		System.out.println("Enter Login Details.");

		common.log("<br></br> Step :: Enter Login Details.");
		common.waitForConditionIsElementPresent(("//input[@id='" + LEGACY_FRONT_LOGIN_TXT_USERNAME + "']"));

		System.out.println("Username ::" + username);
		common.log("<br></br>Username ::" + username);
		common.type("//input[@id='" + LEGACY_FRONT_LOGIN_TXT_USERNAME + "']", username);

		System.out.println("Password ::" + password);
		common.log("<br></br>Password ::" + password);
		common.type("//input[@id='" + LEGACY_FRONT_LOGIN_TXT_PASSWORD + "']", password);

		System.out.println("Click on submit button.");
		common.log("<br></br>Step :: Click on submit button");
		common.jsClick(submitbutton);

		System.out.println("Verify Logout Link.");
		common.log("<br></br>Step :: Verify Logout Link.");
		common.waitForConditionIsElementPresent("//span[text()='" + LEGACY_FRONT_LOGIN_TXT_LOGOUT + "']");
		common.assertElementPresent("//span[text()='" + LEGACY_FRONT_LOGIN_TXT_LOGOUT + "']");
		// common.jsClick(logout);

		common.log("log in is successful");
		System.out.println("log in is successful");
		common.log("<br></br>Login Feature => Working</font>");
		System.out.println("Login Feature => Working");
		return new DashboardPage(driver);

	}

	/**
	 * Verify Hybrid Login Page Elements
	 * 
	 */
	public void verify_Hybrid_Login_Page_Element() {

		System.out.println("Step :: Verify Login Page Elements");
		common.log("<br></br> Step :: Verify Login Page Elements.");
		common.assertElementPresent("//label[text()='" + LEGACY_FRONT_LOGIN_LBL_USERNAME + "']");

		System.out.print("\nStep :: Verify Username Text");
		common.log("<br></br> Step :: Verify Username Text");
		common.assertElementPresent("//label[text()='" + LEGACY_FRONT_LOGIN_LBL_USERNAME + "']");

		System.out.print("\nStep :: Verify Password");
		common.log("Verify Password,");
		common.assertElementPresent("//label[text()='" + LEGACY_FRONT_LOGIN_LBL_PASSWORD + "']");

		System.out.print("\nStep :: Verify Not a Member text");
		common.log("Verify Not a Member text,");
		common.assertElementPresent("//p[text()='" + LEGACY_FRONT_LOGIN_LBL_NOT_A_MEMBER_YET + "']");

		System.out.print("\nStep :: Verify Auctions text");
		common.log("Verify Auctions text,");
		common.assertElementPresent("//a[text()='" + LEGACY_FRONT_LOGIN_TXT_AUCTIONS + "']");

		System.out.print("\nStep :: Verify Signup text");
		common.log("Verify Signup text,");
		common.assertElementPresent("//a[text()='" + LEGACY_FRONT_LOGIN_TXT_SIGNUP + "']");

		System.out.print("\nStep :: Verify Login text");
		common.log("Verify Login text,");
		common.assertElementPresent("//a[text()='" + LEGACY_FRONT_LOGIN_TXT_LOGIN + "']");

		System.out.print("\nStep :: Verify Forgot Password text");
		common.log("Verify Forgot Password text,");
		common.assertElementPresent("//a[text()='" + LEGACY_FRONT_LOGIN_TXT_FORGOT_PASSWORD + "']");

	}
	//qa-dev-auto
	public void Login_page_elemenets() {
		common.pause(20);
		 
		System.out.print("\nStep :: Verify and click on Search Icon");
		common.log("<br></br> Step :: Verify Search Icon");
		common.highlightElement("//ul[@class='" + LEGACY_FRONT_SEARCH_ICON + "']//li[4]//a[1]");
		common.assertElementPresent("//ul[@class='" + LEGACY_FRONT_SEARCH_ICON + "']//li[4]//a[1]");
		driver.findElement(By.xpath("//ul[@class='" + LEGACY_FRONT_SEARCH_ICON + "']//li[4]//a[1]")).click();

		System.out.print("\nStep ::Verify and click on Signup Button");
		common.log("<br></br>Verify and click on Signup Button");
		common.highlightElement("//a[text()='" + LEGACY_FRONT_LOGIN_TXT_SIGNUP + "']");
		common.assertElementPresent("//a[text()='" + LEGACY_FRONT_LOGIN_TXT_SIGNUP + "']");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_FRONT_LOGIN_TXT_SIGNUP + "']")).click();

		System.out.print("\nStep ::Verify and click on Auctions Button");
		common.log("<br></br>Verify and click on Auctions Button");
		common.highlightElement("//a[text()='" + LEGACY_FRONT_AUCTIONS_BUTTON + "']");
		common.assertElementPresent("//a[text()='" + LEGACY_FRONT_AUCTIONS_BUTTON + "']");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_FRONT_AUCTIONS_BUTTON + "']")).click();
		
		System.out.println("\nStep ::Verify and click on Login Button");
		common.log("<br></br> Step :: Verify and click on Login Login Button");
		common.highlightElement("//a[text()='" + LEGACY_FRONT_LOGIN_TXT_LOGIN + "']");
		common.assertElementPresent("//a[text()='" + LEGACY_FRONT_LOGIN_TXT_LOGIN + "']");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_FRONT_LOGIN_TXT_LOGIN + "']")).click();
		
		System.out.println("\nStep :: Verify Not a member yet?");
		common.log("<br></br> Step :: Verify Login Login Button");
		common.highlightElement("//p[text()='" + LEGACY_FRONT_LOGIN_LBL_NOT_A_MEMBER_YET + "']");
		common.assertElementPresent("//p[text()='" + LEGACY_FRONT_LOGIN_LBL_NOT_A_MEMBER_YET + "']");
		
//		common.pause(20);
//		System.out.println("Step :: Verify Its's easy");
//		common.log("<br></br> Step :: Verify Its's easy");
//		common.highlightElement("//p[text()='It's easy!']");
//		common.assertElementPresent("//p[text()='It's easy!']");
		
		System.out.println("\nStep :: Verify and click on Register Now");
		common.log("<br></br> Step :: Verify and click on Register Now");
		common.highlightElement("//a[text()='" + LEGACY_FRONT_LOGIN_LBL_NOT_REGISTER_NOW + "']");
		common.assertElementPresent("//a[text()='" + LEGACY_FRONT_LOGIN_LBL_NOT_REGISTER_NOW + "']");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_FRONT_LOGIN_LBL_NOT_REGISTER_NOW + "']")).click();
		
		common.pause(20);
		driver.findElement(By.xpath("//a[text()='" + LEGACY_FRONT_LOGIN_TXT_LOGIN + "']")).click();
		
		common.pause(20);
		System.out.println("Step :: Verify and click on Forgot password?");
		common.log("<br></br> Step ::Verify and click on Forgot password?");
		common.highlightElement("//a[text()='" + LEGACY_FRONT_LOGIN_TXT_FORGOT_PASSWORD + "']");
		common.assertElementPresent("//a[text()='" + LEGACY_FRONT_LOGIN_TXT_FORGOT_PASSWORD + "']");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_FRONT_LOGIN_TXT_FORGOT_PASSWORD + "']")).click();
		
		common.pause(20);
		driver.findElement(By.xpath("//a[text()='" + LEGACY_FRONT_LOGIN_TXT_LOGIN + "']")).click();
		
		String username = common.generateRandomChars(6);
		String password = common.generateRandomNumber1();
		System.out.println("Step ::Verify and Enter invalid Username");
		common.log("<br></br> Step :: Verify and Enter invalid Username");
		common.highlightElement("//input[@id='" + LEGACY_ADMIN_SIGNIN_TXT_USERNAME + "']");
		common.assertElementPresent("//input[@id='" + LEGACY_ADMIN_SIGNIN_TXT_USERNAME + "']");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_ADMIN_SIGNIN_TXT_USERNAME + "']")).sendKeys(username);
		
		common.pause(10);
		System.out.println("Step ::Verify and Enter invalid Password");
		common.log("<br></br> Step :: Verify and Enter invalid Password");
		common.highlightElement("//input[@id='" + LEGACY_ADMIN_SIGNIN_TXT_PASSWORD + "']");
		common.assertElementPresent("//input[@id='" + LEGACY_ADMIN_SIGNIN_TXT_PASSWORD + "']");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_ADMIN_SIGNIN_TXT_PASSWORD + "']")).sendKeys(password);
		
		driver.findElement(By.xpath("//input[@id='" + LEGACY_ADMIN_LOGIN_BUTTON + "']")).click();
		
		
		common.pause(10);
		System.out.println("Step ::Verified validation message for invalid username and password");
		common.log("<br></br> Step ::Verified validation message for invalid username and password");
		common.highlightElement("//span[text()='" + LEAGACY_FORNT_TXT_INVALID_USERNAME_AND_PASSWORD + "']");
		common.assertElementPresent("//span[text()='" + LEAGACY_FORNT_TXT_INVALID_USERNAME_AND_PASSWORD + "']");
		String str = driver.findElement(By.xpath("//span[text()='" + LEAGACY_FORNT_TXT_INVALID_USERNAME_AND_PASSWORD + "']")).getText();
		System.out.println("Verify message::" +str);
		
		

		
		System.out.println("Step ::Verify and Enter Username");
		common.log("<br></br> Step :: Verify and Enter Username");
		common.highlightElement("//input[@id='" + LEGACY_ADMIN_SIGNIN_TXT_USERNAME + "']");
		common.assertElementPresent("//input[@id='" + LEGACY_ADMIN_SIGNIN_TXT_USERNAME + "']");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_ADMIN_SIGNIN_TXT_USERNAME + "']")).clear();
		driver.findElement(By.xpath("//input[@id='" + LEGACY_ADMIN_SIGNIN_TXT_USERNAME + "']")).sendKeys("rahulqacons");
		
		common.pause(10);
		System.out.println("Step ::Verify and Enter Password");
		common.log("<br></br> Step :: Verify and Enter Password");
		common.highlightElement("//input[@id='" + LEGACY_ADMIN_SIGNIN_TXT_PASSWORD + "']");
		common.assertElementPresent("//input[@id='" + LEGACY_ADMIN_SIGNIN_TXT_PASSWORD + "']");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_ADMIN_SIGNIN_TXT_PASSWORD + "']")).clear();
		driver.findElement(By.xpath("//input[@id='" + LEGACY_ADMIN_SIGNIN_TXT_PASSWORD + "']")).sendKeys("123123a");
		
		common.pause(10);
		System.out.println("Step ::Verify and click on Login Button");
		common.log("<br></br> Step :: Verify and click on Login Button");
		common.highlightElement("//input[@id='" + LEGACY_ADMIN_LOGIN_BUTTON + "']");
		common.assertElementPresent("//input[@id='" + LEGACY_ADMIN_LOGIN_BUTTON + "']");
		driver.findElement(By.xpath("//input[@id='" + LEGACY_ADMIN_LOGIN_BUTTON + "']")).click();
		
		common.pause(10);
		System.out.println("Step ::Verify and click on Profile tab");
		common.log("<br></br> Step :: Verify and click on Profile tab");
		common.highlightElement("//a[text()='" + LEGACY_USER_PROFILE_TAB + "']");
		common.assertElementPresent("//a[text()='" + LEGACY_USER_PROFILE_TAB + "']");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_USER_PROFILE_TAB + "']")).click();
		
		common.pause(10);
		System.out.println("Step ::Verify and click on Invoices tab");
		common.log("<br></br> Step :: Verify and click on Invoices tab");
		common.highlightElement("//a[text()='" + LEGACY_USER_TXT_INVOICES_FRONTEND + "']");
		common.assertElementPresent("//a[text()='" + LEGACY_USER_TXT_INVOICES_FRONTEND + "']");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_USER_TXT_INVOICES_FRONTEND + "']")).click();
		
		common.pause(10);
		System.out.println("Step ::Verify and click on My Alerts tab");
		common.log("<br></br> Step :: Verify and click on My Alerts tab");
		common.highlightElement("//a[text()='" + LEGACY_FRONT_LOGIN_TXT_MY_ALERT + "']");
		common.assertElementPresent("//a[text()='" + LEGACY_FRONT_LOGIN_TXT_MY_ALERT + "']");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_FRONT_LOGIN_TXT_MY_ALERT + "']")).click();
		
		common.pause(10);
		System.out.println("Step ::Verify and click on My Items tab");
		common.log("<br></br> Step :: Verify and click on My Items tab");
		common.highlightElement("//a[text()='" + LEGACY_FRONT_LOGIN_TXT_ITEMS + "']");
		common.assertElementPresent("//a[text()='" + LEGACY_FRONT_LOGIN_TXT_ITEMS + "']");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_FRONT_LOGIN_TXT_ITEMS + "']")).click();
		
		common.pause(10);
		System.out.print("\nStep :: Verify and click on Auctions tab");
		common.log("<br></br>Verify and click on Auctions tab");
		common.highlightElement("//a[text()='" + LEGACY_FRONT_AUCTIONS_BUTTON + "']");
		common.assertElementPresent("//a[text()='" + LEGACY_FRONT_AUCTIONS_BUTTON + "']");
		driver.findElement(By.xpath("//a[text()='" + LEGACY_FRONT_AUCTIONS_BUTTON + "']")).click();


	}
}