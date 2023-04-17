package Demo;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoWebShop {

	static Logger log=Logger.getLogger(DemoWebShop.class.getName());
	WebDriver driver;
	@BeforeSuite
	public void broweser()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\OneDrive\\Desktop\\ChromeDriver 112\\chromedriver_win32\\chromedriver.exe");
	         driver=new ChromeDriver();
	         Layout lay=new PatternLayout();
	         Appender ap=new ConsoleAppender(lay);
	         log.addAppender(ap);
	}

	@BeforeTest
	public void getUrl() {
		driver.get("https://demowebshop.tricentis.com/register");
	}

	@BeforeClass
	public void maximize()
	{
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void cookies() 
	{
		Set<Cookie>set=driver.manage().getCookies();
		System.out.println(set.size());
		
		for (Cookie cookie : set)
		{
		   log.info(cookie.getName());
		   log.info(cookie.getDomain());
		   log.info(cookie.getClass());
		   log.info(cookie.getPath());
		   log.info(cookie.getValue());
		   log.info(cookie.getExpiry());
		   log.info(cookie.isHttpOnly());
		   log.info(cookie.isSecure());
		   System.out.println("========================================================================");
		}
	}

	@Test(dataProvider="getData")
	public void login(String fn,String ln,String em,String ps,String ps1)
	{
		log.info("Login Action");
		driver.findElement(By.name("Gender")).click();
		driver.findElement(By.name("FirstName")).sendKeys(fn);
		driver.findElement(By.name("LastName")).sendKeys(ln);
		driver.findElement(By.name("Email")).sendKeys(em);
		driver.findElement(By.name("Password")).sendKeys(ps);
		driver.findElement(By.name("ConfirmPassword")).sendKeys(ps1);
		driver.findElement(By.name("register-button")).click();
		driver.navigate().back();
		driver.findElement(By.name("FirstName")).clear();
		driver.findElement(By.name("LastName")).clear();
		driver.findElement(By.name("Email")).clear();
		driver.findElement(By.name("Password")).clear();
		driver.findElement(By.name("ConfirmPassword")).clear();
	
		
		log.info("Login Action Complete");
	}
	
	@AfterMethod
	public void getScreen() throws IOException
	{
		File img=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(img,new File("C:\\Users\\HP\\OneDrive\\Desktop\\ChromeDriver 112\\chromedriver_win32\\Demo.jpg"));
	}
	
	@AfterSuite
	public void close()
	{
		driver.close();
	}
	@DataProvider
	public Object[][] getData()
	{
	     Object[][] obj=new Object[3][5];
		 obj[0][0]="Tejas";
		 obj[0][1]="Aware";
		 obj[0][2]="AAA@123gmail.com";
		 obj[0][3]="Pass@123";
		 obj[0][4]="Pass@123";
		
		obj[1][0]="Roshan";
		 obj[1][1]="Aware";
		 obj[1][2]="AAA@123gmail.com";
		 obj[1][3]="Pass@123";
		 obj[1][4]="Pass@123";
		
		obj[2][0]="Roshan";
		 obj[2][1]="Aware";
		 obj[2][2]="AAA@123gmail.com";
		 obj[2][3]="Pass@123";
		 obj[2][4]="Pass@123";
		
		return obj;
	}
	
	
	
	
	
	
	












}
