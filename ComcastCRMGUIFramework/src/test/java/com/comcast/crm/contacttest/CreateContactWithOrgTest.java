package com.comcast.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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
import com.comcastcrm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcastcrm.objectrepositoryutility.HomePage;
import com.comcastcrm.objectrepositoryutility.LoginPage;
import com.comcastcrm.objectrepositoryutility.OrganizationInfomationPage;
import com.comcastcrm.objectrepositoryutility.OrganizationsPage;
import com.comcastcrm.objectrepositoryutility.SearchBasicModePage;

import GenericUtility.BaseClass;
import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyFileUtility;
import GenericUtility.WebDriverUtility;

public class CreateContactWithOrgTest extends BaseClass {
	@Test
	public void CreateContactwithOrgTest() throws IOException {

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
		if (text.contains(ORGNAME)) {
			System.out.println(ORGNAME + "is created===PASS");
		} else {
			System.out.println(ORGNAME + "is not created===FAIL");
		}

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

		if (data1.trim().equals(ORGNAME)) {
			System.out.println(ORGNAME + " information is verified===PASS");
		} else {
			System.out.println(ORGNAME + " information isnot verified===FAIL");
		}
	}

}
