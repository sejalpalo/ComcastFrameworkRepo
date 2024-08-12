package com.comcastcrm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfomationPage {
	WebDriver driver;

	public ContactInfomationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "dvHeaderText")
	private WebElement headerMsg;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	@FindBy(id = "dtlview_Support Start Date")
	private WebElement startMsg;
	@FindBy(id = "dtlview_Support End Date")
	private WebElement endMsg;

	public WebElement getStartMsg() {
		return startMsg;
	}

	public WebElement getEndMsg() {
		return endMsg;
	}

	@FindBy(id = "mouseArea_Organization Name")
	private WebElement orgMsg;

	public WebElement getOrgMsg() {
		return orgMsg;
	}

}
