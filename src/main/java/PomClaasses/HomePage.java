package PomClaasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilClasses.Utility1;

public class HomePage extends Utility1{

WebDriver driver;
	
	@FindBy(xpath="//div[@class='_28p97w']")
	private WebElement profileName;
	
	@FindBy(xpath="//div[text()='My Profile']/parent::a/parent::li")
	private WebElement myProfileTxt;
	
	@FindBy(xpath="(//li[@class='_2NOVgj'])[10]")
	private WebElement logoutTxt;
	
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void hoverToProfileName()
	{
		isElementVisible(driver, profileName);
		moveToElement(driver, profileName);
	}
	
	public void clickOnMyProfileTxt()
	{
		isElementVisible(driver, myProfileTxt);
		myProfileTxt.click();
	}
	
	public String getLogoutTxt()
	{
		return logoutTxt.getText();
	}
	
	public void movePointer() throws InterruptedException
	{
		moveByOffset(driver);
		Thread.sleep(2000);
	}
}
