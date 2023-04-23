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
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(Day1.IsuteListner.class)
public class Demo2 {

	WebDriver driver;
	@BeforeSuite
	public void browser()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\OneDrive\\Desktop\\chromdriver110\\chromedriver_win32\\chromedriver.exe");
        driver=new ChromeDriver();	
	}
   @BeforeTest
   public void getUrl()
   {
	   driver.get("https://demowebshop.tricentis.com/register");
   }

   @BeforeClass
   public void maximize()
   {
	   driver.manage().window().maximize();
   }

   @Test(dataProvider = "getData")
   public void login(String un,String ln,String em,String ps,String ps1) throws InterruptedException
   {
	   System.out.println("login");
	   Thread.sleep(2000);
	   driver.findElement(By.name("Gender")).click();
	   driver.findElement(By.name("FirstName")).sendKeys(un);
	   driver.findElement(By.name("LastName")).sendKeys(ln);
	   driver.findElement(By.name("Email")).sendKeys(em);
	   driver.findElement(By.name("Password")).sendKeys(ps);
	   driver.findElement(By.name("ConfirmPassword")).sendKeys(ps1);
	   driver.findElement(By.name("register-button")).click();
	    
	     driver.navigate().back();
	     Thread.sleep(2000);
	   driver.findElement(By.name("FirstName")).clear();
	   driver.findElement(By.name("LastName")).clear();
	   driver.findElement(By.name("Email")).clear();
	   driver.findElement(By.name("Password")).clear();
	   driver.findElement(By.name("ConfirmPassword")).clear();
	   
   }

   @AfterMethod
   public void Scren() throws IOException
   {
  	 System.out.println("Screen CPture");
  	 File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
  	 FileUtils.copyFile(src,new File("C:\\Users\\HP\\OneDrive\\Desktop\\hm\\new.jpg"));
   }
   
   @AfterSuite
   public void close()
   {
	   driver.close();
   }
   
   @DataProvider
   public Object[][] getData()
   {
	   Object[][] obj=new Object[2][5];
	     obj[0][0]="Tejas";
	     obj[0][1]="Aware";
	     obj[0][2]="aaa@123gmail.com";
	     obj[0][3]="pass@123";
	     obj[0][4]="pass@123";
	     
	     obj[1][0]="Tejas";
	     obj[1][1]="Aware";
	     obj[1][2]="aaa@123gmail.com";
	     obj[1][3]="pass@123";
	     obj[1][4]="pass@123";
	     
	     
	     
	   return obj;
	   
   }





















}
