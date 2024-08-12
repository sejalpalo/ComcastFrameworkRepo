package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.comcastcrm.objectrepositoryutility.ContactInfomationPage;
import com.comcastcrm.objectrepositoryutility.ContactsPage;
import com.comcastcrm.objectrepositoryutility.CreatingNewContactPage;
import com.comcastcrm.objectrepositoryutility.HomePage;
import com.comcastcrm.objectrepositoryutility.LoginPage;

import GenericUtility.BaseClass;
import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyFileUtility;
import GenericUtility.WebDriverUtility;

public class CreateContactWithSupportDatetest extends BaseClass {

	@Test
	public void CreateContactwithSupportDatetest() throws IOException {
		String LAST = efu.getDataFromExcel("contacts", 4, 2);

		HomePage hp = new HomePage(driver);
		hp.getConlink().click();
		ContactsPage cp = new ContactsPage(driver);
		cp.getLookUpImageicon().click();
		CreatingNewContactPage cnc = new CreatingNewContactPage(driver);
		String startdate = cnc.createcontact(LAST);
		String enddate = cnc.createContact(30);
		cnc.getSaveBtn().click();
		// verify
		ContactInfomationPage cip = new ContactInfomationPage(driver);
		String actstart = cip.getStartMsg().getText();

		if (actstart.equals(startdate)) {
			System.out.println(startdate + " information is verified===PASS");
		} else {
			System.out.println(startdate + " information isnot verified===FAIL");
		}
		String actend = cip.getEndMsg().getText();
		if (actend.equals(enddate)) {
			System.out.println(enddate + " information is verified===PASS");
		} else {
			System.out.println(enddate + " information isnot verified===FAIL");
		}

	}

}
