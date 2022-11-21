package com.auction.admin.pages;

import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.auction.pages.auctionregistration.AbstractPage;

public class TimedSaleAuction extends AbstractPage {

	public TimedSaleAuction(WebDriver driver) {
		super(driver);

	}

	/**
	 * Verify Start Date Missing
	 * 
	 * @throws InterruptedException
	 * @throws ParseException
	 */
	public void CreatenewAuction() throws InterruptedException, ParseException {

		String Description = common.generateRandomChars(500);

		adminDashboardPage.clickOnAuctionPage();
		common.waitForConditionIsElementPresent("//input[@id='alf2']");
		common.jsClick(createnewauction);
		common.waitForConditionIsElementPresent("//div[text()='Create auction']");

		String AuctionType = "Live";
		WebElement option = auctiontype
				.findElement(By.xpath("//span[@id='aip0_ctl']//option[contains(text(),'" + AuctionType + "')]"));
		System.out.println(option + ">>>>");
		option.click();
		String tomorrowDate = common.tomorrowDate();
		common.type("//input[@id='aip2']", tomorrowDate);

		common.type("//input[@id='aip30']", "1");

		common.type("//input[@id='aip40']", "123");

		String name = common.generateRandomChars(7);
		common.type("//input[@id='aip13']", name);

		driver.switchTo().frame(0);
		// driver.findElement(By.xpath("//iframe[@aria-describedby='cke_38']"));
		WebElement editable = driver.switchTo().activeElement();
		editable.sendKeys(Description);
		driver.switchTo().defaultContent();

		common.jsClick(newauctionsavechanges);
		common.acceptAlert();

	}

	public String AllFieldsFill(String date) throws InterruptedException, ParseException {

		String Description = common.generateRandomChars(500);

		adminDashboardPage.clickOnAuctionPage();
		common.waitForConditionIsElementPresent("//input[@id='alf2']");
		common.jsClick(createnewauction);
		common.waitForConditionIsElementPresent("//div[text()='Create auction']");

		String AuctionType = "Live";
		WebElement option = auctiontype
				.findElement(By.xpath("//span[@id='aip0_ctl']//option[contains(text(),'" + AuctionType + "')]"));
		System.out.println(option + ">>>>");
		option.click();

		common.jsClick(clerking); // Click on clerking style

		common.type("//input[@id='aip2']", date);

		common.type("//input[@id='aip30']", "1");

		common.type("//input[@id='aip40']", "123123555");

		String name = common.generateRandomChars(7);

		common.type("//input[@id='aip13']", name);

		driver.switchTo().frame(0);
		// driver.findElement(By.xpath("//iframe[@aria-describedby='cke_38']"));
		WebElement editable = driver.switchTo().activeElement();
		editable.sendKeys(Description);
		driver.switchTo().defaultContent();

		driver.switchTo().frame(1);
		// driver.findElement(By.xpath("//iframe[@aria-describedby='cke_38']"));
		WebElement editable1 = driver.switchTo().activeElement();
		editable1.sendKeys("My Terms");
		driver.switchTo().defaultContent();

		/*
		 * missing fields => Credit Card threshold (Domestic) = 100 000 => Credit Card
		 * threshold (International) = 10 000 => Authorization amount = 0.1 => Auction
		 * held in = United States => Auction Currency = $ => Stream Display = none
		 */

		common.jsClick(Publish);
		common.jsClick(newauctionsavechanges);
		common.acceptAlert();
		return name;
	}

	public void Logout() throws InterruptedException, ParseException {
		common.jsClick(adminLogout);
	}

}
