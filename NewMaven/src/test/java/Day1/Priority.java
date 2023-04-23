package Day1;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(Day1.IsuteListner.class)
public class Priority {

	WebDriver driver;
	@BeforeSuite
	public void browser()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\OneDrive\\Desktop\\chromdriver110\\chromedriver_win32\\chromedriver.exe");
        driver=new ChromeDriver();	
	}

	@BeforeTest
	public void url()
	{
		driver.get("https://www.demoblaze.com/index.html");
	}

	@BeforeClass
	public void maximize()
	{
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void getCookies()
	{
	   Set<Cookie> set=driver.manage().getCookies();
	     System.out.println(set.size());
	     for (Cookie cookie : set)
	    {
		  System.out.println(cookie.getName());	
		}
	}
 
	@Test(priority = 1)
	public void login() throws InterruptedException
	{
		System.out.println("for Signup");
		driver.findElement(By.id("signin2")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("sign-username")).sendKeys("Virat@23");
		driver.findElement(By.id("sign-password")).sendKeys("Kohli@123");
		driver.findElement(By.xpath("//*[@id=\"signInModal\"]/div/div/div[3]/button[2]")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
	
	}
 
	 @Test(priority = 2)
	 public void m1() throws InterruptedException
	 {
		 System.out.println("for login");
	
		 driver.findElement(By.xpath("//*[@id=\"login2\"]")).click();
		 Thread.sleep(2000);
		 driver.findElement(By.id("loginusername")).sendKeys("Virat@23");
		 driver.findElement(By.id("loginpassword")).sendKeys("Kohli@123");
		 driver.findElement(By.xpath("//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")).click();
		 Thread.sleep(2000);
		 
	 }
	
	
      @AfterSuite
      public void close()
      {
    	  driver.close();
      }
















}
