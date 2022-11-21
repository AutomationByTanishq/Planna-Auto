package com.auction.pages.index;


//import java.util.concurrent.TimeUnit;

//import org.openqa.selenium.By;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.auction.admin.pages.AdminDashboardPage;
import com.auction.init.Common;
import com.auction.pages.LoginPage;
import com.auction.pages.SignupPage;
import com.auction.pages.auctionregistration.AbstractPage;
//import com.relevantcodes.extentreports.LogStatus;
//import com.thoughtworks.selenium.DefaultSelenium;
//import com.thoughtworks.selenium.HttpCommandProcessor;

public class IndexPage extends AbstractPage {

	Common common = new Common(driver);

	/**
	 * Constructor [Index Page]
	 * 
	 * @param driver
	 */
	public IndexPage(WebDriver driver) {
		super(driver);

	}

	/**
	 * Click on Login link
	 * 
	 * @return
	 * @throws InterruptedException 
	 */
	public LoginPage clickOnLoginLink() throws InterruptedException {

		common.pause20Sec();
		if (common.isElementPresent("//a[text()='"+LEGACY_FRONT_LOGIN_TXT_LOGOUT+"']")) {

			System.out.println("Step :: Click on Logout Link");

			WebElement logout = driver.findElement(By.xpath("//a[text()='"+LEGACY_FRONT_LOGIN_TXT_LOGOUT+"']"));
			logout.click();

		} else {

			System.out.println("Click on login link.");

			common.log("<br></br> Step :: Click on Login link.");

			driver.findElement(By.xpath("//a[contains(text(),'"+LEGACY_FRONT_LOGIN_TXT+"')]")).click();
			common.pause20Sec();
		}

		return new LoginPage(driver);

	}

	/**
	 * Click on Login link
	 * 
	 * @return
	 * @throws InterruptedException 
	 */
	public LoginPage clickOnLoginLinkLegacy() throws InterruptedException {

		System.out.println("Click on login link.");
		common.log("<br></br> Step :: Click on Login link.");
		common.pause(30);
		driver.findElement(By.xpath("//li[@class='login']")).click();

		return new LoginPage(driver);

	}

	/**
	 * Click on Signup Link
	 * 
	 * @return
	 */
	public SignupPage clickOnSignupLink() {

		System.out.println("-----------------------------------------------------------------------------------");

		System.out.println("Click on signup link.");
		common.log("<br></br> Step :: Click on Signup link.");
		common.waitForConditionIsElementPresent("//a//span[text()='Signup']");

		common.jsClick(signup);

		return new SignupPage(driver);

	}

	/**
	 * Admin SignIn
	 * 
	 * @param username
	 * @param password
	 * @throws InterruptedException 
	 */
	public AdminDashboardPage adminSignin(String username, String password) throws InterruptedException {

		common.pause(15);
		System.out.println("Step :: Click on admin signin.");
		common.log("<br></br> Step :: Click on admin signin.");
		common.isElementPresent("//input[@id='" + LEGACY_ADMIN_SIGNIN_TXT_USERNAME + "");
		common.pause(5);
		System.out.println("Step :: Enter admin User Name :: " + username);
		common.log("<br></br> Step :: Enter admin User Name ::" +username);
		common.type("//input[@id='" + LEGACY_ADMIN_SIGNIN_TXT_USERNAME + "']", username);
		common.pause(5);

		System.out.println("Step :: Enter admin Password :: " + password);
		common.log("<br></br> Step :: Enter admin Password ::" +password);
		common.type("//input[@id='" + LEGACY_ADMIN_SIGNIN_TXT_PASSWORD + "']", password);

		System.out.println("Step :: Click on signin button.");
		common.log("<br></br> Step :: Click on signin button.");
		common.jsClick(submitbutton);
		common.pause(25);

		return new AdminDashboardPage(driver);
	}
	
	/**
	 * Click on Login link
	 * 
	 * @return
	 * @throws InterruptedException 
	 */
	public LoginPage devclickOnLoginLink() throws InterruptedException {

		common.pause(15);
		if (common.isElementPresent("//a[text()='Logout']")) {

			System.out.println("Step :: Click on Logout Link");

			WebElement logout = driver.findElement(By.xpath("//a[text()='Logout']"));
			logout.click();

		} else {

			System.out.println("Click on login link.");

			common.log("<br></br> Step :: Click on Login link.");

			driver.findElement(By.xpath("//input[@id='lgn']")).click();
			common.pause(20);
		}

		return new LoginPage(driver);

	}


}
