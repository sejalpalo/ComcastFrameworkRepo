package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.comcastcrm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcastcrm.objectrepositoryutility.HomePage;
import com.comcastcrm.objectrepositoryutility.LoginPage;
import com.comcastcrm.objectrepositoryutility.OrganizationInfomationPage;
import com.comcastcrm.objectrepositoryutility.OrganizationsPage;

import GenericUtility.BaseClass;
import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyFileUtility;
import GenericUtility.WebDriverUtility;

public class CreateOrgWithPhoneNumberTest extends BaseClass {

	@Test
	public void CreateOrgWithPhonenumberTest() throws IOException {

		String ORGNAME = efu.getDataFromExcel("org", 8, 2) + ju.getRandomNumber();
		String number = efu.getDataFromExcel("org", 8, 3);

		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getOrgLookupImage().click();

		CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(driver);
		cop.createOrg(ORGNAME, number);
		// verify the phone number
		OrganizationInfomationPage oip = new OrganizationInfomationPage(driver);
		String Phonenumber = oip.getPhoneMsg().getText();
		if (Phonenumber.equals(number)) {
			System.out.println(number + " information is verified===PASS");

		} else {
			System.out.println(number + " information is not verified===PASS");
		}
	}
}
