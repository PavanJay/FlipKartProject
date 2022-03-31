package PomClaasses;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilClasses.Utility1;

public class ProfilePage extends Utility1{

WebDriver driver;
	
	@FindBy(xpath="//div[text()='Manage Addresses']")
	private WebElement manageAddress;
	
	@FindBy(xpath="//div[text()='ADD A NEW ADDRESS']")
	private WebElement addNewAddressTxt;
	
	@FindBy(xpath="//textarea[@name='addressLine1']")
	private WebElement addressLine1;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement saveAddressButton;
	
	@FindBy(xpath="//div[@class='_1CeZIA']")
	private List<WebElement> addressCount;
	
	
	
	public ProfilePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	
	public void clickOnManageAddress()
	{
		isElementVisible(driver, manageAddress);
		manageAddress.click();
	}
	
	public void clickOnAddNewAddress()
	{
		isElementVisible(driver, addNewAddressTxt);
		addNewAddressTxt.click();
	}
	
	public void getDataForAddress(List<String> a) throws EncryptedDocumentException, IOException
	{
		//List<String> list = getMultipleDataFromXcel(0,3);
		
		for(int i=1; i<=4; i++)
		{
			WebElement element = driver.findElement(By.xpath("((//form)[2]//input)["+i+"]"));
			
			element.sendKeys(a.get(i-1));
		}
		
	}
	
	
	
	public int getAddressCount()
	{
		return addressCount.size();
	}
	public void enterAddressLine1()
	{
		addressLine1.sendKeys("Shivaji chowk");
	}
	
	public void clickOnSaveAddressButton()
	{
		saveAddressButton.click();
	}
	
	
	
	
	
}
