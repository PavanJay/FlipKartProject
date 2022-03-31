package TestClasses;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import BaseClasses.BaseClass1;
import PomClaasses.HomePage;
import PomClaasses.LogInPage;
import PomClaasses.ProfilePage;


public class AddNewAddress {

	WebDriver driver;
	LogInPage lp;
	HomePage hp;
	ProfilePage pp;
	
	ExtentReports reports;
	ExtentTest test;
	
	@Parameters("browser")
	@BeforeClass
	public void beforClass(String a)
	{
		reports = new ExtentReports("ExtentReports.html",true);
		test = reports.startTest("AddNewAddress");
		
		driver = BaseClass1.getChromeDriver(a);
	}
	
	@BeforeMethod
	public void beforeMethod()
	{
		lp = new LogInPage(driver);
		hp = new HomePage(driver);
		pp = new ProfilePage(driver);
		
	}
	
	@Test
	public void verifyUserCanLogin() throws InterruptedException, IOException
	{
		lp.enterEmail();
		lp.enterPassword();
		lp.clickSubmit();
		hp.hoverToProfileName();
		String txt = hp.getLogoutTxt();
		Assert.assertEquals(txt, "Logout");	
		
		test.log(LogStatus.PASS, "Log in Test Passed");
	}
	
	@DataProvider(name="dataSet")
	public String[][] dataToTest()
	{
		String[][] data = {{"Ganesh", "9845124785", "411041", "Nanded city"},  {"Atul", "8745235685", "413512", "KV school"}};
		return data;
	}
	
	
	@Test(priority=1, dataProvider="dataSet", dependsOnMethods="verifyUserCanLogin")
	public void verifyUserCanAddNewAddress(String name, String mobNumber, String pincode, String locality) throws InterruptedException, EncryptedDocumentException, IOException
	{
		hp.hoverToProfileName();
		hp.clickOnMyProfileTxt();
		pp.clickOnManageAddress();
		
		pp.clickOnAddNewAddress();
		
		int oldCount = pp.getAddressCount();

		List<String> dataList = new ArrayList<String>();
		dataList.add(name);
		dataList.add(mobNumber);
		dataList.add(pincode);
		dataList.add(locality);
		pp.getDataForAddress(dataList);	
	
		pp.enterAddressLine1();
		
		pp.clickOnSaveAddressButton();
		Thread.sleep(2000);
		int newCount = pp.getAddressCount();			
		
		Assert.assertEquals(newCount, oldCount+1);
		
		test.log(LogStatus.PASS, "Added new Address");
		
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			test.log(LogStatus.FAIL, test.addScreenCapture(pp.screenCpature(driver)), "Taken Screenshot");
		}
	}
	
	@AfterClass
	public void afterClass()
	{
		reports.endTest(test);
		reports.flush();
		
		driver.quit();
	}
}
