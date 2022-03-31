package BaseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass1 {

	public static WebDriver getChromeDriver(String a)
	{
		if(a.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();		//here we are using WebDriverManager to set ChromeDriver
			
			//System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\Browsers\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();     //upcasting
			driver.get("https://www.flipkart.com/");
			driver.manage().window().maximize();
			return driver;
		}
		else
		{
			System.setProperty("webdriver.edge.driver", "src\\main\\resources\\Browsers\\msedgedriver.exe");
			WebDriver driver = new EdgeDriver();     //upcasting
			driver.get("https://www.flipkart.com/");
			driver.manage().window().maximize();
			return driver;
		}
	}
}
