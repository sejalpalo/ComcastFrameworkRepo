package pratice;

import org.testng.Assert;
import org.testng.annotations.Test;

import GenericUtility.BaseClass;

public class ActiveSim  extends BaseClass{
	@Test(retryAnalyzer = GenericUtility.RetryListenerimp.class)
	public void activeSim() {
	System.out.println("execute createInvoiceTest ");
	String actTitle = driver.getTitle();
	Assert.assertEquals(actTitle, "Login");// here i am intentinally fail my testscript
	System.out.println("step-1");
	System.out.println("step-2");
	System.out.println("step-3");
	System.out.println("step-4");//this testcase will execute 5 times bcz of retryanalzer or network issue
}
}
