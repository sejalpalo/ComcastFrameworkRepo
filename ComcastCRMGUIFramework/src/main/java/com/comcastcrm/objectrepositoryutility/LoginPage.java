package com.comcastcrm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import GenericUtility.WebDriverUtility;
/**
 * @author Manoj Panda
 * contains login page elements & business lib like login()
 */
public class LoginPage extends WebDriverUtility {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name = "user_name")
	private WebElement usernameEdt;
	@FindBy(name = "user_password")
	private WebElement passwordEdt;
	@FindBy(id = "submitButton")
	private WebElement loginBtn;

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	/**
	 * login to application based username,password
	 * @param username
	 * @param password
	 */
	//provide Action
	//business liberay
	public void loginToapp(String username,String password) {
		//driver.manage().window().maximize();
		maximizeWindow(driver);
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}

 }
