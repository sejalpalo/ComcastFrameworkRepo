package com.comcastcrm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	// constuctor
	WebDriver driver;
		public OrganizationsPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}

		@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
		private WebElement orgLookupImage;

		public WebElement getOrgLookupImage() {
			return orgLookupImage;
		}
		@FindBy(name="search_text")
		private WebElement SearchTextField;
		@FindBy(id="bas_searchfield")
		private WebElement dropDownTextField;
		@FindBy(name="submit")
		private WebElement searchNowbtn;
		public WebDriver getDriver() {
			return driver;
		}
		public WebElement getSearchTextField() {
			return SearchTextField;
		}
		public WebElement getDropDownTextField() {
			return dropDownTextField;
		}
		public WebElement getSearchNowbtn() {
			return searchNowbtn;
		}
}
