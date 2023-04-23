package Day1;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Demo {

	WebDriver driver;
	@BeforeSuite
	public void browser()
	{
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\OneDrive\\Desktop\\ChromeDriver 111\\chromedriver_win32\\chromedriver.exe");	
	        driver=new ChromeDriver();
	}

	@BeforeTest
	public void url()
	{
		driver.get("https://demo.guru99.com/test/newtours/index.php");
	}
	@BeforeClass
	public void maximize()
	{
		driver.manage().window().maximize();
	}

	@Test(dataProvider = "getData")
	public void login(String un,String ps) throws InterruptedException
	{
		System.out.println("login");
		driver.findElement(By.name("userName")).sendKeys(un);
		driver.findElement(By.name("password")).sendKeys(ps);
		driver.findElement(By.name("submit")).click();
		Thread.sleep(2000);
		driver.navigate().back();
		driver.findElement(By.name("userName")).clear();
		driver.findElement(By.name("password")).clear();
		
	}
	@AfterMethod
	public void getScreen() throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\HP\\OneDrive\\Desktop\\ChromeDriver 111\\chromedriver_win32\\Tr.jpg"));
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj=new Object[2][2];
		  obj[0][0]="QQQQ";
		  obj[0][1]="qqqq";
		  
		  obj[1][0]="AAAA";
		  obj[1][1]="aaaa";
		  
		  
		return obj;
		
	}

	
	
	
	
	
	
	
	
	
	
	


}
