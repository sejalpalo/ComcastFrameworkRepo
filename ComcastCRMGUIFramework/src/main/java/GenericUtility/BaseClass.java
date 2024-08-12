package GenericUtility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcastcrm.objectrepositoryutility.HomePage;
import com.comcastcrm.objectrepositoryutility.LoginPage;

public class BaseClass {
	public DatabaseUtility dblib=new DatabaseUtility();
	public ExcelFileUtility efu=new ExcelFileUtility();
	public PropertyFileUtility pfu=new PropertyFileUtility();
	public WebDriverUtility wu=new WebDriverUtility();
	public JavaUtility ju = new JavaUtility();

	public WebDriver driver = null;
	public static  WebDriver sdriver = null;//this is static variable
	
	
	@BeforeSuite(groups={"smokeTest","regressionTest"})
	public void configBS() throws SQLException {
		System.out.println("===connect to DB,report config====");
		dblib.getDBConnection();
		
	}
	//@Parameters("BROWSER")
	@BeforeClass(groups={"smokeTest","regressionTest"})
	public void configBC() throws IOException {
		String BROWSER=pfu.getDataFromPropertiesFile("browser");
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox") ){
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		sdriver=driver;
		UtilityClassObject.setDriver(driver);
	}
	@BeforeMethod(groups={"smokeTest","regressionTest"})
	public void configBM() throws IOException {
		System.out.println("===login====");
		LoginPage lp=new LoginPage(driver);
		wu.waitForElements(driver);
		String URL=pfu.getDataFromPropertiesFile("url");
		String USERNAME=pfu.getDataFromPropertiesFile("username");
		String PASSWORD=pfu.getDataFromPropertiesFile("password");
		driver.get(URL);
		lp.loginToapp(USERNAME,PASSWORD);
	}
	@AfterMethod(groups={"smokeTest","regressionTest"})
	public void configAM() {
		System.out.println("==Logout===");
		HomePage hp=new HomePage(driver);
		hp.logout();
	}
	@AfterClass(groups={"smokeTest","regressionTest"})
	public void configAC() {
		System.out.println("===close the browser====");
		driver.quit();
	}
	@AfterSuite(groups={"smokeTest","regressionTest"})
	public void configAS() throws SQLException {
		System.out.println("===close to DB====");
		dblib.closeDBconnection();
		
	}
}
