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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Web {

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
		   driver.get("https://demowebshop.tricentis.com/register");
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
			  System.out.println(cookie.getName());
			  System.out.println("==================================================");
			}
	   }

	   @Test(dataProvider = "getData")
	   public void login(String fn,String ln,String em,String ps,String ps1) 
	   {
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
		 
	   }

	   @AfterMethod
	   public void getScreen() throws IOException
	   {
		   File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		   FileUtils.copyFile(src, new File("C:\\Users\\HP\\OneDrive\\Desktop\\ChromeDriver 111\\chromedriver_win32\\Demo.jpg"));
	   }
	   
	   @AfterSuite
	   public void close()
	   {
		   driver.close();
	   }

	   @DataProvider
	   public Object[][] getData()
	   {
		  Object[][] obj=new Object[5][5];
		   obj[0][0]="Tejas";
		   obj[0][1]="Aware";
		   obj[0][2]="aaa@gmail.com";
		   obj[0][3]="pass@123";
		   obj[0][4]="pass@123";
		   
		   obj[1][0]="Roshan";
		   obj[1][1]="Aware";
		   obj[1][2]="aaa@gmail.com";
		   obj[1][3]="pass@123";
		   obj[1][4]="pass@123";
		   
		   obj[2][0]="Chetan";
		   obj[2][1]="Aware";
		   obj[2][2]="aaa@gmail.com";
		   obj[2][3]="pass@123";
		   obj[2][4]="pass@123";
		   
		   obj[3][0]="Bhushan";
		   obj[3][1]="Aware";
		   obj[3][2]="aaa@gmail.com";
		   obj[3][3]="pass@123";
		   obj[3][4]="pass@123";
		   
		   obj[4][0]="SatyaJit";
		   obj[4][1]="Aware";
		   obj[4][2]="aaa@gmail.com";
		   obj[4][3]="pass@123";
		   obj[4][4]="pass@123";
		   return obj;
	   }








}
