package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


import com.relevantcodes.extentreports.LogStatus;


import pfPack.pages.LaunchPage;
import pfPack.util.Constants;

import tests.base.BaseTest;

public class LoginTest extends BaseTest {
	
	@Test
	public void testLogin() throws InterruptedException {
		
		eTest = eReport.startTest("LoginTest");
		eTest.log(LogStatus.INFO, "Login Test has started");
		
		openBrowser(Constants.BROWSER_TYPE);
		
		LaunchPage launchpage = new LaunchPage(driver,eTest);
		PageFactory.initElements(driver, launchpage);
		
		boolean loginStatus = launchpage.goToLoginPage();
		
		if(loginStatus) {
			reportPass("LoginTest TestCase passed");
			
			//eTest.log(LogStatus.PASS, "Login Test Passed");
		}else {
			reportFail("Login Test failed");
			//takeScreenshot();
			//eTest.log(LogStatus.FAIL, "Login Test failed");
			//Assert.fail("Login Test failed");
		}
		
		
		
	}
	@AfterMethod
	public void testClosure() {
		if(eReport!=null) {
			eReport.endTest(eTest);
			eReport.flush();
			
	
		}
		if(driver!=null) {
			driver.quit();
		}
	}
}
