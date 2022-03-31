package PomClaasses;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilClasses.Utility1;

public class LogInPage extends Utility1{

	WebDriver driver;
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement emailID;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBy(xpath="(//button[@type='submit'])[2]")
	private WebElement submit;
	
	public LogInPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
		this.driver = driver;
	}
	
	public void enterEmail() throws IOException
	{
		emailID.sendKeys(getConfigData("MobileNumber"));
	}
	
	public void enterPassword() throws IOException
	{
		password.sendKeys(getConfigData("Password"));
	}
	
	public void clickSubmit() throws InterruptedException
	{
		submit.click();
		Thread.sleep(2000);
	}
}
