package GenericUtility;

import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

public class UtilityClassObject {
    public static ThreadLocal<ExtentTest> test= new ThreadLocal<ExtentTest>();
    //i want share my driver object also
    public static ThreadLocal<WebDriver> driver= new ThreadLocal<WebDriver>();
    
    public static ExtentTest getTest() {
    	return test.get();
    }
    public static void setTest(ExtentTest actTest) {
    	 test.set(actTest);
    }
    
    public static WebDriver getdriver() {
    	return driver.get();
    }
    public static void setDriver(WebDriver actDriver) {
    	 driver.set(actDriver);
    }
    //this class help us to share my static variable for multiple thread in case parallell execution
    //static variable have only one static pull that pull cannot be shared but iwant to share my static pull
    // in this way we can share the static pull (above example)
    
}
