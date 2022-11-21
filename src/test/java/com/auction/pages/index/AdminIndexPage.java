package com.auction.pages.index;

//import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.auction.admin.pages.AdminDashboardPage;
import com.auction.init.Common;
import com.auction.pages.LoginPage;
import com.auction.pages.SignupPage;
import com.auction.pages.auctionregistration.AbstractPage;
//import com.thoughtworks.selenium.DefaultSelenium;
//import com.thoughtworks.selenium.HttpCommandProcessor;

public class AdminIndexPage extends AbstractPage {

	Common common = new Common(driver);

	/**
	 * Constructor [Index Page]
	 * 
	 * @param driver
	 */
	public AdminIndexPage(WebDriver driver) {
		super(driver);

	}

	/**
	 * Click on Login link
	 * 
	 * @return
	 */
	public LoginPage clickOnLoginLink() {

		System.out.println("-----------------------------------------------------------------------------------");

		System.out.println("Click on login link.");
		common.log("<br></br> Step 2 : Click on Login link.");
		common.waitForConditionIsElementPresent("//span[text()='Login']");

		common.jsClick(loginlink);

		return new LoginPage(driver);

	}

	/**
	 * Click on Signup Link
	 * 
	 * @return
	 */
	public SignupPage clickOnSignupLink() {

		System.out.println("---------------------------------------------------------------------------------------");

		System.out.println("Click on signup link.");
		common.log("<br></br> Step 2 : Click on Signup link.");
		common.waitForConditionIsElementPresent("//a//span[text()='Signup']");

		common.jsClick(signup);

		return new SignupPage(driver);

	}

	/**
	 * Admin SignIn
	 * 
	 * @param username
	 * @param password
	 */
	public AdminDashboardPage adminSignin(String username, String password) {

		common.waitForConditionIsElementPresent("//input[@id='usr']");
		common.log("Type : Admin Username");
		common.type("//input[@id='usr']", username);
		common.log("Type : Admin Password");
		common.type("//input[@id='pas']", password);
		common.jsClick(submitbutton);

		return new AdminDashboardPage(driver);
	}

}
