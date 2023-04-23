package Other;

import java.io.IOException;
import java.util.Set;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Xml {

	static Logger log=Logger.getLogger(Xml.class);
	WebDriver driver;
	@BeforeSuite
	public void browser() throws IOException  
 {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\OneDrive\\Desktop\\ChromeDriver 112\\chromedriver_win32\\chromedriver.exe");
        driver=new ChromeDriver();	
        Layout lay=new PatternLayout();
        Appender ap=new FileAppender(lay,"TT.txt");
        log.addAppender(ap);
	}

	@BeforeTest
	@Parameters({"url"})
	public void getUrl(String url1)
	{
		SoftAssert so=new SoftAssert();
		driver.get(url1);
		log.info("Url Passed");
		String ur=driver.getCurrentUrl();
		so.assertEquals("https://demowebshop.tricentis.com/register", ur);
		so.assertAll();
		
	}

	@BeforeClass
	public void maximize()
	{
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void getCookies()
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
		  System.out.println("==================================================================");
		}
	}
	@Test(priority = 1)
	@Parameters({"fn","ln","em","ps","ps1"})
	public void login(String f,String l,String e,String p,String pss)
	{
		log.info("Main Login");
		log.debug("Gender Button Click");
		driver.findElement(By.name("Gender")).click();
		log.debug("First Name");
		driver.findElement(By.name("FirstName")).sendKeys(f);
		log.debug("Last Name");  
	    driver.findElement(By.name("LastName")).sendKeys(l);
	    log.debug("Email");
	    driver.findElement(By.name("Email")).sendKeys(e);
	    log.debug("PassWord");
	    driver.findElement(By.name("Password")).sendKeys(p);
	    log.debug("Confirm Password");
	    driver.findElement(By.name("ConfirmPassword")).sendKeys(pss);
	    log.debug("Submit");
	    driver.findElement(By.name("register-button")).click();
	    log.info("Login Complete on DemoWebShop");
	}
	@Test(priority = 2)
	@Parameters({"fnn","lnn","phh","emm","asd1","cii","stt","poo","id","pas","pas1"})
	public void Login2(String ff,String ll,String phh,String emm,String add1,String cii,String stt,String poo,String uiid,String ppp,String ppp1)
	{
		driver.navigate().to("https://demo.guru99.com/test/newtours/register.php");
		log.info("Mercury Registration");
		Set<Cookie>set1=driver.manage().getCookies();
		log.info(set1.size());
		for (Cookie co : set1) 
		{
		     log.info(co.getName());
		     log.info(co.getDomain());
		     log.info(co.getClass());
		     log.info(co.getValue());
		     log.info(co.getExpiry());
		     log.info(co.getPath());
		     log.info(co.isHttpOnly());
		     log.info(co.isSecure());
		     System.out.println("============================================================");
		}
	
		log.info("Registration Code");
	    driver.findElement(By.name("firstName")).sendKeys(ff);
	    driver.findElement(By.name("lastName")).sendKeys(ll);
	    driver.findElement(By.name("phone")).sendKeys(phh);
	    driver.findElement(By.name("userName")).sendKeys(emm);
	    driver.findElement(By.name("address1")).sendKeys(add1);
	    driver.findElement(By.name("city")).sendKeys(cii);
	    driver.findElement(By.name("state")).sendKeys(stt);
	    driver.findElement(By.name("postalCode")).sendKeys(poo);
	    WebElement coun=driver.findElement(By.name("country"));
	              Select sel=new Select(coun);
	               sel.selectByValue("INDIA");
	    driver.findElement(By.name("email")).sendKeys(uiid);
	    driver.findElement(By.name("password")).sendKeys(ppp);
	    driver.findElement(By.name("confirmPassword")).sendKeys(ppp1);
	    driver.findElement(By.name("submit")).click();
	
	    log.info("Registration Complete");
	
	
	
	
	}
	
	
	
	
	
	
	
	

}
