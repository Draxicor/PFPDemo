package pfPack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.relevantcodes.extentreports.ExtentTest;

import pfPack.base.BasePage;

public class HomePage extends BasePage{
	
	
	@FindBy(css="span[class^='zicon-apps-calendar']")
	public WebElement Calendar;
	
	@FindBy(css="span[class^='zicon-apps-chat']")
	public WebElement Cliq;
	
	@FindBy(css="span[class^='zicon-apps-crm']")
	public WebElement CRM;
	
	@FindBy(css="span[class^='zicon-apps-mail']")
	public WebElement Mail;
	
	@FindBy(css="span[class^='zicon-apps-salesiq']")
	public WebElement SalesIQ;
	
	//Constructor code
	public HomePage(WebDriver driver, ExtentTest eTest) {
		this.driver = driver;
		this.eTest = eTest;
	}
	
	
	//reusable  methods
	
	//reusable method to verify if user is Logged in
	public boolean verifyDisplayOfHomePage() {
		try {
			boolean loginStatus = CRM.isDisplayed();
			
			return loginStatus; 
			
		}catch(Exception e) {
			return false;
		}
	
		 
	}
	
}
