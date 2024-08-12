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
import org.openqa.selenium.support.ui.Select;
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

public class CreateOrgwithIndustryTest extends BaseClass {

	@Test
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
		if (text.contains(industry)) {
			System.out.println(industry + "is created===PASS");
		} else {
			System.out.println(industry + "isnot created===FAIL");
		}

		String value = oip.getTypeMsg().getText();
		if (value.contains(Type)) {
			System.out.println(Type + "is created===PASS");
		} else {
			System.out.println(Type + "isnot created===FAIL");
		}
		
	}

}
