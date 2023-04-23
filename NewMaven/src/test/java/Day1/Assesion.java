package Day1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Assesion {

	WebDriver driver;
	
	@BeforeSuite
	public void browser()
	{

		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\OneDrive\\Desktop\\chromdriver110\\chromedriver_win32\\chromedriver.exe");
        driver=new ChromeDriver();	
	}

   
	@BeforeTest
	@Parameters({"url"})
	public void getUrl(String url1)
	{
		driver.get(url1);
	   String ur=driver.getCurrentUrl();
	   System.out.println(ur);
	   Assert.assertEquals("https://demowebshop.tricentis.com/register",ur);
	}

	@BeforeClass
	public void maximize()
	{
		driver.manage().window().maximize();
	}

	@Test
	public void login()
	{
		System.out.println("Login");
	}















}
