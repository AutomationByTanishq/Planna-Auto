package com.auction.admin.pages;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import com.auction.init.Common;
import com.auction.init.SeleniumInit;

public abstract class AdminAbstractPage extends SeleniumInit {

	Common common = new Common(driver);

	public int DRIVER_WAIT = 5;

	/**
	 * Initialize Admin UserAbstractPage.
	 * 
	 * @param Driver .
	 */
	public AdminAbstractPage(WebDriver driver) {

		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, DRIVER_WAIT);
		PageFactory.initElements(finder, this);
		this.driver = driver;
	}

}
