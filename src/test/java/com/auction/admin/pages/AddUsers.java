package com.auction.admin.pages;

import org.openqa.selenium.By;
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
//import com.auction.pages.SignupPage;
//import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;

public class AddUsers extends AbstractPage {

	Common common = new Common(driver);

	/**
	 * Constructor
	 * 
	 * @param Dashboard driver
	 */
	public AddUsers(WebDriver driver) {
		super(driver);

	}

	/**
	 * Add Users
	 * 
	 * @param UserName
	 * @param Password
	 * @param ConfirmPassword
	 */
	public void addUsers(String UserName, String Password, String ConfirmPassword) {

		common.pause(5);
		common.jsClick(userinformation);
		System.out.println("Step :: Enter username");
		common.log("<br></br>Step :: Enter username");
		common.type("//input[@id='"+LEGACY_ADMIN_TXT_USER_NAME+"']", UserName);
		System.out.println("Step :: Enter password");
		common.log("<br></br>Step :: Enter password");
		common.type("//input[@id='"+LEGACY_ADMIN_TXT_USER_INFO_PASSWORD+"']", Password);
		System.out.println("Step :: Enter confirm password");
		common.log("<br></br>Step :: Enter confirm password");
		common.type("//input[@id='"+LEGACY_ADMIN_TXT_USER_PASSWORD+"']", ConfirmPassword);
		common.pause(15);
		System.out.println("Step :: Enter mail");
		common.log("<br></br>Step :: Enter mail");
		String str = common.generateRandomChars(5);
		driver.findElement(By.xpath("//input[@id='"+LEGACY_ADMIN_TXT_EMAIL+"']")).sendKeys(str + "@mailinator.com");

		if (driver.findElement(By.xpath("//input[@id='"+LEGACY_ADMIN_CHECK_BIDDER+"']")).isSelected()) {

		} else {
			driver.findElement(By.xpath("//input[@id='"+LEGACY_ADMIN_CHECK_BIDDER+"']")).click();
		}
		common.pause(10);
		driver.findElement(By.xpath("//a[@class='"+LEGACY_ADMIN_CLOSE_BILL_INFO+"']")).click();
		common.pause(5);
		driver.findElement(By.xpath("//select[@id='"+LEGACY_ADMIN_CONTACT_TYPE+"']//option[@value='1']")).click();

		common.pause(5);
		driver.findElement(By.xpath("//a[@class='"+LEGACY_ADMIN_CLOSE_USER_SHIPPING+"']")).click();
		common.pause(5);
		driver.findElement(By.xpath("//select[@id='"+LEGACY_ADMIN_SHIPPING_CONTACT_TYPE+"']//option[@value='1']")).click();
		common.pause(5);

		System.out.println("Step :: Click on Save");
		common.log("<br></br>Step :: Click on Save");
		common.jsClick(savechanges);
		common.pause20Sec();
		common.assertElementPresent("//p[@class='"+LEGACY_ADMIN_TXT_SUCCESS_MESSAGE_CLASS+"']");

		common.pause20Sec();

		common.highlightElement("//input[@id='"+LEGACY_ADMIN_TXT_USER_NAME+"']");
		common.pause20Sec();
		String user = driver.findElement(By.xpath("//input[@id='"+LEGACY_ADMIN_TXT_USER_NAME+"']")).getAttribute("value");
		System.out.println("Step :: Verified user added successfully:" + user);
		common.log("<br></br>Step :: Verified user added successfully:" + user);

	}
}
