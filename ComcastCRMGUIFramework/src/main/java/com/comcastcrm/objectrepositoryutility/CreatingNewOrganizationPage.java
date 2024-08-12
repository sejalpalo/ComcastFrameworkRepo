package com.comcastcrm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {
	WebDriver driver;
	public  CreatingNewOrganizationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	@FindBy(name="accountname")
	private WebElement orgName;
	
	@FindBy(name="button")
	private WebElement saveBtn;
	
	@FindBy(name="industry")
	private WebElement industryTextfield;
	
	@FindBy(name="accounttype")
	private WebElement typeTextfield;
	
	@FindBy(id="phone")
	private WebElement phoneTextField;
	
	
	
	public WebElement getPhoneTextField() {
		return phoneTextField;
	}

	

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public WebElement getIndustryTextfield() {
		return industryTextfield;
	}

	public WebElement getTypeTextfield() {
		return typeTextfield;
	}

	//business librery
	public void createOrg(String ORGNAME) {
		orgName.sendKeys(ORGNAME);
		saveBtn.click();
	}
	public void createOrg(String ORGNAME,String INDUSTRY,String TYPE) {
		orgName.sendKeys(ORGNAME);
		Select sel=new Select(industryTextfield);
		sel.selectByVisibleText(INDUSTRY);
		Select sel1=new Select(typeTextfield);
		sel1.selectByVisibleText(TYPE);
		saveBtn.click();
		
	}
	public void createOrg(String ORGNAME,String PHONENUMBER) {
		orgName.sendKeys(ORGNAME);
		phoneTextField.sendKeys(PHONENUMBER);
		saveBtn.click();
	}
}
