
package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcastcrm.objectrepositoryutility.ContactInfomationPage;
import com.comcastcrm.objectrepositoryutility.ContactsPage;
import com.comcastcrm.objectrepositoryutility.CreatingNewContactPage;
import com.comcastcrm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcastcrm.objectrepositoryutility.HomePage;
import com.comcastcrm.objectrepositoryutility.LoginPage;
import com.comcastcrm.objectrepositoryutility.OrganizationInfomationPage;
import com.comcastcrm.objectrepositoryutility.OrganizationsPage;
import com.comcastcrm.objectrepositoryutility.SearchBasicModePage;

import GenericUtility.BaseClass;
import GenericUtility.ExcelFileUtility;
import GenericUtility.PropertyFileUtility;
import GenericUtility.WebDriverUtility;

public class CreateContactTest extends BaseClass {
	@Test(groups = "smokeTest")
	public void createContactTest() throws IOException {

		// to read the from excelFile
		String LAST = efu.getDataFromExcel("contacts", 1, 2);

		HomePage hp = new HomePage(driver);
		hp.getConlink().click();
		ContactsPage cp = new ContactsPage(driver);
		cp.getLookUpImageicon().click();
		CreatingNewContactPage cnc = new CreatingNewContactPage(driver);
		cnc.createContact(LAST);

		ContactInfomationPage cip = new ContactInfomationPage(driver);
		String name = cip.getHeaderMsg().getText();
		Assert.assertTrue(name.contains(LAST));

	}

	@Test(groups = "regressionTest")
	public void createContactWithSupportDateTest() throws IOException {
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
		Assert.assertEquals(actstart, startdate);
		String actend = cip.getEndMsg().getText();
		Assert.assertEquals(actend, enddate);

	}

	@Test(groups = "regressionTest")
	public void CreateContactWithOrgTest() throws IOException {
		String LAST = efu.getDataFromExcel("contacts", 7, 2);
		String ORGNAME = efu.getDataFromExcel("contacts", 7, 3) + ju.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getOrgLookupImage().click();
		CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(driver);
		cop.createOrg(ORGNAME);
		// verify Header msg Expected Result or orgname
		OrganizationInfomationPage oip = new OrganizationInfomationPage(driver);
		String text = oip.getHeaderMsg().getText();
		Assert.assertTrue(text.contains(ORGNAME));

		hp.getConlink().click();
		ContactsPage cp = new ContactsPage(driver);
		cp.getLookUpImageicon().click();
		CreatingNewContactPage cnc = new CreatingNewContactPage(driver);
		cnc.createContact1(LAST);

		SearchBasicModePage sb = new SearchBasicModePage(driver);
		sb.search(ORGNAME);
		driver.findElement(By.xpath("//a[.='" + ORGNAME + "']")).click();
		sb.search();
		cnc.getSaveBtn().click();

		// verify orgname data flow happening or not
		ContactInfomationPage cip = new ContactInfomationPage(driver);
		String data1 = cip.getOrgMsg().getText();
		Assert.assertEquals(data1.trim(), ORGNAME);
	}
}
