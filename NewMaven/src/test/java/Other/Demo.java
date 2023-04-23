package Other;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Demo {

	WebDriver driver;
	@Test
	@Parameters({"first","last","phon","user","addr","state","city","post","email","pas","pas1"})
	public void login(String un,String ln,String ph,String us,String ad,String st,String ci,String po,String em,String ps,String ps1)
	{
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\OneDrive\\Desktop\\ChromeDriver 111\\chromedriver_win32\\chromedriver.exe");	
	        driver=new ChromeDriver();
	        driver.get("https://demo.guru99.com/test/newtours/register.php");
	        driver.manage().window().maximize();
	        
	       driver.findElement(By.name("firstName")).sendKeys(un);
	       driver.findElement(By.name("lastName")).sendKeys(ln);
	       driver.findElement(By.name("phone")).sendKeys(ph);
	       driver.findElement(By.name("userName")).sendKeys(us);
	       driver.findElement(By.name("address1")).sendKeys(ad);
	       driver.findElement(By.name("state")).sendKeys(st);
	       driver.findElement(By.name("city")).sendKeys(ci);
	       driver.findElement(By.name("postalCode")).sendKeys(po);
	       WebElement country=driver.findElement(By.name("country"));
	                 Select sel=new Select(country);
	                   sel.selectByValue("INDIA");
	       driver.findElement(By.name("email")).sendKeys(em);
	       driver.findElement(By.name("password")).sendKeys(ps);
	       driver.findElement(By.name("confirmPassword")).sendKeys(ps1);
	       driver.findElement(By.name("submit")).click();
	       
	}
}
