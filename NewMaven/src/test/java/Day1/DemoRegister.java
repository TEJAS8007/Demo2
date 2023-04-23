
package Day1;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(Day1.TestListner.class)
public class DemoRegister {

	WebDriver driver;
    @BeforeSuite
	public void openBrowser()
	{
    	System.out.println("Before Suite");
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\OneDrive\\Desktop\\chromdriver110\\chromedriver_win32\\chromedriver.exe");
             driver=new ChromeDriver();	
             System.out.println("driver open");
	}
    @BeforeTest
     public void getUrl()
     {
    	driver.get("https://demowebshop.tricentis.com/register");
    	System.out.println("Url passed");
     }
  @BeforeClass
    public void maximizeBrowser()
    {
    	driver.manage().window().maximize();
    	System.out.println("page maximised");
   
    }
    @BeforeMethod
    public void getCookies()
    {
    	 Set<Cookie> set=driver.manage().getCookies();
    	 System.out.println(set.size());
    	 for (Cookie cookie : set) 
    	{
		   System.out.println(cookie.getName());
		   System.out.println(cookie.getValue());
		   System.out.println(cookie.getPath());
		   System.out.println(cookie.getClass());
		   System.out.println(cookie.getDomain());
		   System.out.println(cookie.isSecure());
		   System.out.println(cookie.isHttpOnly());
	System.out.println("===================================================================");	   
		}
    }
    @Test(dataProvider="getData")
     public void Login(String fn,String ln,String gm,String pass,String pass1)
     {
    	 System.out.println("Test Anotation");
    	 
    	 driver.findElement(By.name("Gender")).click();
    	 driver.findElement(By.name("FirstName")).sendKeys(fn);
    	 driver.findElement(By.name("LastName")).sendKeys(ln);
    	 driver.findElement(By.id("Email")).sendKeys(gm);
    	 driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys(pass);
    	 driver.findElement(By.id("ConfirmPassword")).sendKeys(pass1);
    	 driver.findElement(By.name("register-button")).click();
    	 driver.navigate().back();
    	 driver.findElement(By.name("FirstName")).clear();
    	 driver.findElement(By.name("LastName")).clear();
    	 driver.findElement(By.id("Email")).clear();
    	 driver.findElement(By.xpath("//*[@id=\"Password\"]")).clear();
    	 driver.findElement(By.id("ConfirmPassword")).clear();
    	 System.out.println("Login SUCCESS");
    	 
     }
    @AfterMethod
     public void Scren() throws IOException
     {
    	 System.out.println("Screen CPture");
    	 File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	 FileUtils.copyFile(src,new File("C:\\Users\\HP\\OneDrive\\Desktop\\hm\\new.jpg"));
     }
   @AfterClass
    public void delete()
    {
    	driver.manage().deleteAllCookies();
    	System.out.println("delete all cookies");
    }
   @AfterTest
   public void afterTest()
   {
	   System.out.println("Test After");
   }
@AfterSuite
   public void afterSuite()
   {
	   System.out.println("After Suite");
	   driver.close();
   }
  @DataProvider
  public Object getData()
  {
	return new Object[][]
   {
	  new Object[] {"Tejas","Aware","aaa@123gmail.com","pass2123","pass2123"},
	  new Object[] {"QQQQ","Roshan","bbb@123gmail.com","pass2123","pass2123"},
	  new Object[] {"AAAA","aaaaa","ggg@123gmail.com","pass@123","pass@123"}
	  
   };
	  
  }










}
