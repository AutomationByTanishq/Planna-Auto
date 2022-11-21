package com.auction.admin.pages;

/*import java.awt.AWTException;
 import java.awt.Robot;
 import java.awt.event.KeyEvent;
 import java.text.ParseException;
 import org.openqa.selenium.Alert;*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.auction.init.Common;
import com.auction.pages.auctionregistration.AbstractPage;
//import com.auction.pages.SignupPage;
import com.auction.pages.index.IndexPage;

//import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;

public class RunLiveAuction extends AbstractPage {

	Common common = new Common(driver);

	/**
	 * Constructor
	 * 
	 * @param Dashboard driver
	 */
	public RunLiveAuction(WebDriver driver) {
		super(driver);

	}

	/**
	 * Start Auction
	 * 
	 */
	public void clickOnStartAuction() {

		common.pause(30);
		common.waitForElement(By.xpath("//button[@id='btnStartAuction']"));
		this.driver.findElement(By.xpath("//button[@id='btnStartAuction']")).click();

		common.waitForConditionIsElementPresent("//button[@id='btnStopAuction']");
		common.pause(15);
	}

	/**
	 * Open Front End
	 * 
	 * @return
	 */
	public IndexPage openFrontEnd() {

		adminDashboardPage.adminLogout();

		return new IndexPage(driver);
	}
}
