package Demo;

import java.util.Set;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demoblaze {

	WebDriver driver;
	static Logger log=Logger.getLogger(Demoblaze.class.getName());
	@BeforeSuite
	public void Browser()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\OneDrive\\Desktop\\ChromeDriver 112\\chromedriver_win32\\chromedriver.exe");
        driver=new ChromeDriver();
        Layout lay=new PatternLayout();
        Appender ap=new ConsoleAppender(lay);
        log.addAppender(ap);
	}

	@BeforeTest
	public void getUrl()
	{
		driver.get("https://www.demoblaze.com/index.html");
		log.info("Url Passed");
	}

	@BeforeClass
	public void maxim()
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
	@Test
	public void login() throws InterruptedException
	{
		
		driver.findElement(By.xpath("//*[@id=\"signin2\"]")).click();//signup Button
		Thread.sleep(1000);
		driver.findElement(By.id("sign-username")).sendKeys("Tejas@081");
		driver.findElement(By.id("sign-password")).sendKeys("Pass@123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"login2\"]")).click();//login Button
		Thread.sleep(1000);
		driver.findElement(By.id("loginusername")).sendKeys("Tejas@081");
		driver.findElement(By.id("loginpassword")).sendKeys("Pass@123");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();
		
	}














}
