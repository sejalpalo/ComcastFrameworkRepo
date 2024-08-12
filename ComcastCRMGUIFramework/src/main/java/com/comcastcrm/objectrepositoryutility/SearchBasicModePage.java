package com.comcastcrm.objectrepositoryutility;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchBasicModePage {
	WebDriver driver;
	public  SearchBasicModePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
    @FindBy(name="search_text")
    WebElement searchTextField;
    @FindBy(name="search")
    WebElement searchNowbtn;
	public WebDriver getDriver() {
		return driver;
	}
	public WebElement getSearchTextField() {
		return searchTextField;
	}
	public WebElement getSearchNowbtn() {
		return searchNowbtn;
	}
    //business
	public void search(String orgName) {
		searchTextField.sendKeys(orgName);
		searchNowbtn.click();
		
	}
	public void search() {
		Set<String> allids = driver.getWindowHandles();
		for (String id1: allids) {
			String title1 = driver.switchTo().window(id1).getTitle();
			if (title1.contains("Contacts&action")) {
				break;
			}
		}
	}
}

