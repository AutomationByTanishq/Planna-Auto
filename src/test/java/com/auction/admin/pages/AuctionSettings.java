package com.auction.admin.pages;

import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuctionSettings extends AdminAbstractPage {

	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement adminLogout;

	public AuctionSettings(WebDriver driver) {
		super(driver);

	}

	public void Logout() throws InterruptedException, ParseException {
		common.jsClick(adminLogout);
	}

}
