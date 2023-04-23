package Other;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DemoWeb {
	@Test
	@Parameters({"first","last","email","pas","pas1"})
	public void login(String fn,String ln,String em,String ps,String ps1)
	{
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\OneDrive\\Desktop\\ChromeDriver 111\\chromedriver_win32\\chromedriver.exe");	
	       WebDriver driver=new ChromeDriver();
	        driver.get("https://demowebshop.tricentis.com/register");
	        driver.manage().window().maximize();    
	        
	      driver.findElement(By.name("Gender")).click();
	      driver.findElement(By.name("FirstName")).sendKeys(fn);
	      driver.findElement(By.name("LastName")).sendKeys(ln);
	      driver.findElement(By.name("Email")).sendKeys(em);
	      driver.findElement(By.name("Password")).sendKeys(ps);
	      driver.findElement(By.name("ConfirmPassword")).sendKeys(ps1);
	      driver.findElement(By.name("register-button")).click();
	      
	      
	}
}
