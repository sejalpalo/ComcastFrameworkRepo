package com.comcast.crm.orgtest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcastcrm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcastcrm.objectrepositoryutility.HomePage;
import com.comcastcrm.objectrepositoryutility.LoginPage;
import com.comcastcrm.objectrepositoryutility.OrganizationInfomationPage;
import com.comcastcrm.objectrepositoryutility.OrganizationsPage;

import GenericUtility.BaseClass;
import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.ListenerImpleClass;
import GenericUtility.PropertyFileUtility;
import GenericUtility.UtilityClassObject;
import GenericUtility.WebDriverUtility;
@Listeners(GenericUtility.ListenerImpleClass.class)
public class CreateOrganizationTest extends BaseClass {

	@Test(groups = "smokeTest")
	public void createOrgTest() throws IOException {
		UtilityClassObject.getTest().log(Status.INFO,"read data from excel ");

		String ORGNAME = efu.getDataFromExcel("org", 1, 2) + ju.getRandomNumber();

		// lp.getUsernameEdt().sendKeys("admin");
		// lp.getPasswordEdt().sendKeys("password");
		// lp.getLoginBtn().click();
		// or
		UtilityClassObject.getTest().log(Status.INFO,"navigate to org page");
		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		UtilityClassObject.getTest().log(Status.INFO,"navigate to Create org page");
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getOrgLookupImage().click();

		UtilityClassObject.getTest().log(Status.INFO,"Create a new org");
		CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(driver);
		cop.createOrg(ORGNAME);
		
		UtilityClassObject.getTest().log(Status.INFO,ORGNAME+"====>Create a new org");
		// verify Header msg Expected Result
		OrganizationInfomationPage oip = new OrganizationInfomationPage(driver);
		String text = oip.getHeaderMsg().getText();
		Assert.assertTrue(text.contains(ORGNAME));

		// WebElement signout = hp.getAdminlogo();
		// wu.mousemoveOnElement(driver, signout);
		// hp.getSignoutButton().click();
		// or intead of 3 line use 1 line

	}

	@Test(groups = "regressionTest")
	public void createOrgwithIndustrytest() throws IOException {

		String ORGNAME = efu.getDataFromExcel("org", 4, 2) + ju.getRandomNumber();
		String industry = efu.getDataFromExcel("org", 4, 3);
		String Type = efu.getDataFromExcel("org", 4, 4);

		HomePage hp = new HomePage(driver);
		hp.getOrglink().click();

		OrganizationsPage op = new OrganizationsPage(driver);
		op.getOrgLookupImage().click();

		CreatingNewOrganizationPage cop = new CreatingNewOrganizationPage(driver);
		// cop.getOrgName().sendKeys(ORGNAME);
		// WebElement ele = cop.getIndustryTextfield();
		// wu.select(ele, industry);
		// WebElement ele1 = cop.getTypeTextfield();
		// wu.select(ele1, Type);
		// cop.getSaveBtn().click();

		// or
		cop.createOrg(ORGNAME, industry, Type);

		// verify the industries and Type info
		OrganizationInfomationPage oip = new OrganizationInfomationPage(driver);
		String text = oip.getIndustryMsg().getText();
		Assert.assertEquals(text, industry);

		String value = oip.getTypeMsg().getText();
		Assert.assertEquals(value, Type);
	}

	@Test(groups = "regressionTest")
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
		Assert.assertEquals(Phonenumber, number);
	}

}
