package GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void waitForElements(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void visiblityOfElement(WebDriver driver, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	public void elementToBeClickable(WebDriver driver, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	public void waitForElementTitle(WebDriver driver,String title) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.titleContains(title));
	}
	public void waitForElementSelected(WebDriver driver,WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeSelected(ele));
	}
	public void waitForElementTitles(WebDriver driver,String title) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.titleIs(title));
	}

	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}

	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}

	public void switchtoTitle(WebDriver driver,String partialTitle) {
    	Set<String> allids = driver.getWindowHandles();
    	for(String id:allids) {
    		String windowTitle = driver.switchTo().window(id).getTitle();
    		if(windowTitle.contains(partialTitle)) {
    			break;
    		}
    		
    	}
    }
	public void switchToTabonUrl(WebDriver driver,String partialurl) {
		Set<String> allid = driver.getWindowHandles();
		for(String id:allid) {
			String URL = driver.switchTo().window(id).getCurrentUrl();
			if(URL.contains(partialurl)) {
				break;
			}
		}
	}

	// here i am achieveing method overloading concept
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);

	}

	public void switchToFrame(WebDriver driver, String nameID) {
		driver.switchTo().frame(nameID);

	}

	public void switchToFrame(WebDriver driver, WebElement ele) {
		driver.switchTo().frame(ele);

	}

	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void switchToAlertAndcancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void select(WebElement ele, int index) {
		Select se = new Select(ele);
		se.selectByIndex(index);
	}

	public void select(WebElement ele, String text) {
		Select se = new Select(ele);
		se.selectByVisibleText(text);
	}

	public Actions action(WebDriver driver) {
		Actions act = new Actions(driver);
		return act;
	}

	public void mousemoveOnElement(WebDriver driver, WebElement ele) {

		action(driver).moveToElement(ele).perform();
	}

	public void doubleClick(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.doubleClick(ele).perform();
	}

	public void RightClick(WebDriver driver, WebElement ele) {
		Actions act = new Actions(driver);
		act.contextClick(ele).perform();
	}

	public void dragAndDrop(WebDriver driver, WebElement src, WebElement dest) {
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dest).perform();

	}

	public String toTakeScreenshot(WebDriver driver, String screenshotname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);

		File src = new File("./screenshot" + screenshotname + ".png");
		FileHandler.copy(temp, src);
		return src.getAbsolutePath();

	}
	public void scrollToElement(WebDriver driver,WebElement ele) {
	  JavascriptExecutor js=(JavascriptExecutor)driver;	
	  js.executeScript("arguments[0].ScrollIntoview(true)",ele);
	}
	public void clickableToElement(WebDriver driver,WebElement ele) {
		  JavascriptExecutor js=(JavascriptExecutor)driver;	
		  js.executeScript("arguments[0].click();",ele);
		}


}
