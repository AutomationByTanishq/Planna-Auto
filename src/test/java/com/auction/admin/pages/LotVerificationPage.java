
package com.auction.admin.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.auction.init.Common;
import com.auction.pages.auctionregistration.AbstractPage;

public class LotVerificationPage extends AbstractPage {

	Common common = new Common(driver);

	/**
	 * Constructor
	 * 
	 * @param Dashboard driver
	 */
	public LotVerificationPage(WebDriver driver) {
		super(driver);

	}

	/**
	 * Verify Lot
	 * 
	 * @param lotName
	 */
	public void verifyLot(String lotName) {

		common.waitForConditionIsElementPresent("//tr[@id='alf5row0']");
		common.log("<br>Verify Added Logs.</br>");
		common.assertElementPresent("//tr//td[contains(.,'" + lotName + "')]");

	}

	/**
	 * Click on Run Live Auction
	 * 
	 * @return
	 */
	public RunLiveAuction clickOnRunLiveAuction() {

		common.waitForConditionIsElementPresent("//a[@title='" + LEGACY_ADMIN_BTN_RUN_LIVE_AUCTION + "']");
		common.jsClick(runLiveAuction); // Click on run live auction
		common.log("<br>Click on run live auction.</br>");
		common.pause(20);

		return new RunLiveAuction(driver);

	}
}
