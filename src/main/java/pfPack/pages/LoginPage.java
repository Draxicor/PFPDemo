package pfPack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pfPack.base.BasePage;
import pfPack.util.Constants;

public class LoginPage extends BasePage {
	
	@FindBy(className="banner_newtoold")
	public WebElement OldPage;
	
	@FindBy(id="nextbtn")
	public WebElement NextButton;
	
	@FindBy(id="login_id")
	public WebElement EmailField;
	
	@FindBy(id="password")
	public WebElement PasswordField;
	
	@FindBy(id="signin_submit")
	public WebElement SignInButton;
	
	//Any other webelements of the page
	
	//Constructor for LoginPage
	public LoginPage(WebDriver driver, ExtentTest eTest) {
		this.driver=driver;
		this.eTest=eTest;
	}
	
	//Reusable methods of Login page
	
	public boolean doLogin() throws InterruptedException {
		//selenium automation for logging in to application
		//OldPage.click();
		EmailField.sendKeys(Constants.USERNAME);
		eTest.log(LogStatus.INFO, "Username "+Constants.USERNAME+" got entered in Email field on Login page");
		NextButton.click();
		Thread.sleep(5000);
		PasswordField.sendKeys(Constants.PASSWORD);
		NextButton.click();
		eTest.log(LogStatus.INFO, "Password "+Constants.PASSWORD+" got entered in Password field on Login page");
		//SignInButton.click();
		eTest.log(LogStatus.INFO, "Sign In button got clicked");
		
		HomePage homePage = new HomePage(driver,eTest);
		PageFactory.initElements(driver, homePage);
		
		boolean loginStatus = homePage.verifyDisplayOfHomePage();
		return loginStatus;
	
	
	}
	
	//any other reusable methods
}
