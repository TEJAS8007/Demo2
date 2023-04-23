package Other;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class New {

	WebDriver driver;
	@BeforeSuite
	public void browser()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\OneDrive\\Desktop\\ChromeDriver 111\\chromedriver_win32");
	          driver=new ChromeDriver();	
	}

	@BeforeTest
	public void openUrl()
	{
		driver.get("https://demo.guru99.com/test/newtours/index.php");
	}

	@BeforeClass
	public void maximize()
	{
		driver.manage().window().maximize();
	}

	@Test
	@Parameters({"uname","pass"})
	public void login(String un,String ps)
	{
		driver.findElement(By.name("userName")).sendKeys(un);;
		driver.findElement(By.name("password")).sendKeys(ps);;
		driver.findElement(By.name("submit"));
	}
	
	@AfterSuite
	public void close()
	{
		driver.close();
	}

	









}
