package com.comcastcrm.objectrepositoryutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {
	WebDriver driver;

	public CreatingNewContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "lastname")
	private WebElement lastname;

	@FindBy(name = "button")
	private WebElement saveBtn;

	@FindBy(name = "support_end_date")
	private WebElement enddate;

	public WebElement getEnddate() {
		return enddate;
	}

	public WebElement getStartdate() {
		return startdate;
	}

	@FindBy(name = "support_start_date")
	private WebElement startdate;

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement plusIcon;

	public WebElement getPlusIcon() {
		return plusIcon;
	}

	// business
	public void createContact(String name) {
		lastname.sendKeys(name);
		saveBtn.click();
	}

	public String createcontact(String name) {
		lastname.sendKeys(name);
		startdate.clear();
		Date dateobj = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
		String startdate1 = sim.format(dateobj);
		startdate.sendKeys(startdate1);
       return startdate1;
	}
       public String createContact(int days) {
		enddate.clear();
		Date dateobj1 = new Date();
		SimpleDateFormat sim1 = new SimpleDateFormat("yyyy-MM-dd");
		sim1.format(dateobj1);
		Calendar cal = sim1.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String enddate1 = sim1.format(cal.getTime());
		enddate.sendKeys(enddate1);
		return enddate1;

	}

	public void createContact1(String name) {
		lastname.sendKeys(name);
		plusIcon.click();
		Set<String> allid = driver.getWindowHandles();
		for (String id : allid) {
			String title = driver.switchTo().window(id).getTitle();
			if (title.contains("Accounts&action"))

			{
				break;
			}

		}

		

	}

}
