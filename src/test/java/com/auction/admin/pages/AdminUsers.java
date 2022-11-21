package com.auction.admin.pages;

/*import java.awt.AWTException;
 import java.awt.Robot;
 import java.awt.event.KeyEvent;
 import java.text.ParseException;
 import org.openqa.selenium.Alert;
 import org.openqa.selenium.By;*/
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.auction.init.Common;
import com.auction.pages.auctionregistration.AbstractPage;

/*import com.auction.pages.SignupPage;
 import com.auction.pages.index.IndexPage;
 import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;*/

public class AdminUsers extends AbstractPage {

	Common common = new Common(driver);

	/**
	 * Constructor
	 * 
	 * @param Admin Users Page driver
	 */
	public AdminUsers(WebDriver driver) {
		super(driver);

	}

	/**
	 * Create Admin Users
	 * 
	 * @return
	 */
	public AddUsers createAdminNewUser() {
		common.pause(30);
		common.jsClick(adduser);
		return new AddUsers(driver);

	}
}
