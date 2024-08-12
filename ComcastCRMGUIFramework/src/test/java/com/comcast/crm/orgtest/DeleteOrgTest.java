package com.comcast.crm.orgtest;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.comcastcrm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcastcrm.objectrepositoryutility.HomePage;
import com.comcastcrm.objectrepositoryutility.LoginPage;
import com.comcastcrm.objectrepositoryutility.OrganizationInfomationPage;
import com.comcastcrm.objectrepositoryutility.OrganizationsPage;

import GenericUtility.ExcelFileUtility;
import GenericUtility.JavaUtility;
import GenericUtility.PropertyFileUtility;
import GenericUtility.WebDriverUtility;

public class DeleteOrgTest {

	public static void main(String[] args) throws IOException {
		PropertyFileUtility pfu=new PropertyFileUtility();
		String URL=pfu.getDataFromPropertiesFile("url");
		String BROWSER=pfu.getDataFromPropertiesFile("browser");
		String USERNAME=pfu.getDataFromPropertiesFile("username");
		String PASSWORD=pfu.getDataFromPropertiesFile("password");
		JavaUtility ju =new JavaUtility();
		WebDriverUtility wu=new WebDriverUtility();
		 ExcelFileUtility efu=new ExcelFileUtility();
		   String ORGNAME = efu.getDataFromExcel("org", 1, 2)+ju.getRandomNumber();
		

		WebDriver driver = null;
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		
		wu.waitForElements(driver);
		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.loginToapp(USERNAME,PASSWORD);
		HomePage hp=new HomePage(driver);
	    hp.getOrglink().click();
	    
	    OrganizationsPage op=new  OrganizationsPage(driver);
	    op.getOrgLookupImage().click();
	    
	    CreatingNewOrganizationPage cop=new CreatingNewOrganizationPage(driver);
	    cop.createOrg(ORGNAME);
		// verify Header msg Expected Result
	    OrganizationInfomationPage oip=new OrganizationInfomationPage(driver);
	    String text = oip.getHeaderMsg().getText();
	    if(text.contains(ORGNAME)) {
	    	System.out.println(ORGNAME + "is created===PASS");
	    }
	    else {
	    	System.out.println(ORGNAME + "is not created===FAIL");
	    }
	    //go back to organization page
	    hp.getOrglink().click();
	    //search for organization
	    op.getSearchTextField().sendKeys(ORGNAME);
	   WebElement drop = op.getDropDownTextField();
	   wu.select(drop,"Organization Name");
	   op.getSearchNowbtn().click();
	    //in dynamic webtable select &delete org
		driver.findElement(By.xpath("(//a[.='"+ORGNAME+"'])/../../td[8]/a[text()=\"del\"]")).click();

	    //hp.logout();
	}

}
