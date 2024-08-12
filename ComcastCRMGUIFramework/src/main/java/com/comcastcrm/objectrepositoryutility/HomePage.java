package com.comcastcrm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(linkText = "Organizations")
	private WebElement orglink;

	@FindBy(linkText = "Contacts")
	private WebElement conlink;
	
	@FindBy(css="[src='themes/softed/images/user.PNG']")
	private WebElement adminlogo;
	
	@FindBy(linkText = "Sign Out")
    private WebElement signoutButton;
	
	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getOrglink() {
		return orglink;
	}

	public WebElement getConlink() {
		return conlink;
	}

	public WebElement getAdminlogo() {
		return adminlogo;
	}

	public WebElement getSignoutButton() {
		return signoutButton;
	}
	//business libr
	public void logout() {
		Actions act=new Actions(driver);
		act.moveToElement(adminlogo).perform();
		signoutButton.click(); 
	}
	
}