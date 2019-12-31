package pfPack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pfPack.base.BasePage;
import pfPack.util.Constants;

public class LaunchPage extends BasePage{
	
	
	
	
	//Webelements of launch page
	@FindBy(className="zh-customers")
	public WebElement Customers;
	
	@FindBy(className="zh-support")
	public WebElement Support;
	
	@FindBy(className="zh-login")
	public WebElement Login;
	
	@FindBy(className="zh-signup")
	public WebElement Signup;
	
	//Any other locatorse etc
	
	//Constructor code here
	public LaunchPage(WebDriver driver, ExtentTest eTest) {
		this.driver= driver;
		this.eTest=eTest;
	}
	
	//Reusable methods of LauchPage
	public boolean goToLoginPage() throws InterruptedException {
		driver.get(Constants.APP_URL);
		eTest.log(LogStatus.INFO, "Application URL "+Constants.APP_URL+" got opened");
		Login.click();
		eTest.log(LogStatus.INFO, "Login option got clicked");
		
		LoginPage loginPage = new LoginPage(driver,eTest);
		PageFactory.initElements(driver, loginPage);
		
		boolean loginStatus = loginPage.doLogin();
		return loginStatus;
	}
	
	//any other reusable methods
}
