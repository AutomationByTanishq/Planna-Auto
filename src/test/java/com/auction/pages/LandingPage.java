package com.auction.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.auction.init.Common;
import com.auction.pages.auctionregistration.AbstractPage;

public class LandingPage extends AbstractPage {

	// ------------------------------------------------------------------------------------------------------------------------//
	// ------------------------------------------- Xpaths
	// -------------------------------------------------------------------//
	// ------------------------------------------------------------------------------------------------------------------------//
	/**
	 * Webelements
	 * 
	 */

	@FindBy(xpath = "//input[@id='btnR123']")
	private WebElement registerToBid;

	Common common = new Common(driver);

	/**
	 * Constructor
	 * 
	 * @param Dashboard driver
	 */
	public LandingPage(WebDriver driver) {
		super(driver);

	}

	/**
	 * OnGoing Event
	 * 
	 * @throws InterruptedException
	 * 
	 */
	public void ongoingEvent() throws InterruptedException {

		common.WaitForAjax();
		common.jsClick(registerToBid);
		common.waitForElement("//span[text()='Ongoing Event']");
	}

}
