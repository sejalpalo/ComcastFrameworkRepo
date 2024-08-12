package com.comcastcrm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfomationPage {
	WebDriver driver;
	public OrganizationInfomationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	@FindBy(className="dvHeaderText")
	private WebElement headerMsg;
	
	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	
	@FindBy(id="dtlview_Industry")
	private WebElement industryMsg;
	
	@FindBy(id="dtlview_Type")
	private WebElement TypeMsg;
	
	@FindBy(id="dtlview_Phone")
	private WebElement phoneMsg;
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getPhoneMsg() {
		return phoneMsg;
	}

	public WebElement getIndustryMsg() {
		return industryMsg;
	}

	public WebElement getTypeMsg() {
		return TypeMsg;
	}
	
	}


