package Log;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Appender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class JpStore {

	static Logger log=Logger.getLogger(JpStore.class.getName());
	WebDriver driver;
	
	@Test
	public void login() throws IOException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\OneDrive\\Desktop\\chromdriver110\\chromedriver_win32\\chromedriver.exe");
        driver=new ChromeDriver();	
        driver.get("https://jpetstore.aspectran.com/account/newAccountForm");
        driver.manage().window().maximize();
        
        Layout lay=new PatternLayout();
        Appender ap=new FileAppender(lay,"Jp.txt");
        log.addAppender(ap);
        
		log.info("username");
		driver.findElement(By.name("username")).sendKeys("Tejas@123");
		log.info("Password");
		driver.findElement(By.name("password")).sendKeys("Pass@123");
	    log.info("New PassWord");
	    driver.findElement(By.name("repeatedPassword")).sendKeys("Pass@123");
	    log.info("firstName");
	    driver.findElement(By.name("firstName")).sendKeys("Tejas");
	    log.info("LastName");
	    driver.findElement(By.name("lastName")).sendKeys("Aware");
	    log.info("email");
	    driver.findElement(By.name("email")).sendKeys("aaa@123gmail.com");
	    log.info("phone");
	    driver.findElement(By.name("phone")).sendKeys("9098798799");
	    log.info("address1");
	    driver.findElement(By.name("address1")).sendKeys("Pune");
	    log.info("Address2");
	    driver.findElement(By.name("address2")).sendKeys("Amravati");
	    log.info("city");
	    driver.findElement(By.name("city")).sendKeys("Paratwada");
	    log.info("state");
	    driver.findElement(By.name("state")).sendKeys("MahaRashtra");
	    log.info("zip");
	    driver.findElement(By.name("zip")).sendKeys("AAAAA");
	    log.info("country");
	    driver.findElement(By.name("country")).sendKeys("India");
	    log.info("languagePreference");
	    WebElement lang=driver.findElement(By.name("languagePreference"));
	             Select sel=new Select(lang);
	             sel.selectByValue("english");
	     log.info("Pet");        
	    WebElement pet=driver.findElement(By.name("favouriteCategoryId"));         
	               Select sele=new Select(pet);
	               sele.selectByValue("DOGS");
	    log.info("listOption");
	    driver.findElement(By.name("listOption")).click();
	    log.info("bannerOption");
	    driver.findElement(By.name("bannerOption")).click();
	    log.info("Submit");
	   // driver.findElement(By.xpath("//*[@id=\"CenterForm\"]/form/div/button")).click();
	    log.info("Programme Complete");
	    
	    }

      @AfterMethod
      public void getScreen() throws IOException
      {
    	  File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
      	FileUtils.copyFile(src,new File("C:\\Users\\HP\\OneDrive\\Desktop\\hm\\JpStore.jpg"));
      }

      @AfterSuite
      public void close()
      {
    	  driver.close();
      }
      
      




}
