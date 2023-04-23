package Other;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.udf.UDFFinder;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Name;
import org.apache.poi.ss.usermodel.PictureData;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.SheetVisibility;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class Cricbuzz {

	WebDriver driver;
	@Test(priority = 1)
	public void action()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\OneDrive\\Desktop\\ChromeDriver 111\\chromedriver_win32\\chromedriver.exe");
        ChromeOptions options=new ChromeOptions();
	      options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
	      WebDriver driver=new ChromeDriver(options);
	      driver.get("https://www.cricbuzz.com/live-cricket-scorecard/66253/pbks-vs-gt-18th-match-indian-premier-league-2023");
	      
	      driver.manage().window().maximize();
	      
	      WebElement inning=driver.findElement(By.xpath("//*[@id=\"innings_1\"]/div[1]"));
	       List row=inning.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms']"));
	              int num=row.size();
	              System.out.println(num);
	       System.out.println("name Of Batsmen");
	      for(int a=0 ;a<num-3;a++)
	      {
	    	String names=inning.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] :nth-child(1)")).get(a).getText(); 
	        System.out.println(a);        
	    	System.out.println(names);
	      }
	      System.out.println("Runs");
	      int add=0;
	      for(int b=0 ;b<num-3;b++)
	      {
	    	 String run= inning.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] :nth-child(3)")).get(b).getText();
	    	 
	    	 int runs=Integer.parseInt(run);
	    	    System.out.println(runs);
	    	    add=add+runs;
	    	    System.out.println(add);
	      }
	      System.out.println("six");
	      for(int c=0;c<num-3;c++)
	      {
	    	String six=inning.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] :nth-child(6)")).get(c).getText();
	            int sixes=Integer.parseInt(six);
	            System.out.println(sixes);
	            
	      }
	      System.out.println("Four");
	      for(int d=0;d<num-3;d++)
	      {
	    	 String four=inning.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] :nth-child(5)")).get(d).getText();
	      
	    	           int fours=Integer.parseInt(four);
	    	           System.out.println(fours);
	      }
	 
	   }
	static Logger log=Logger.getLogger(Cricbuzz.class);
	   @Test(priority = 2)
	   public void log()
	   {
		   Layout lay=new PatternLayout();
		   Appender ap=new ConsoleAppender(lay);
		   log.addAppender(ap);
		   
		   log.debug("Main Debug");
		   log.info("Main Info");
		   log.warn("Main Warn");
		   log.error("Main Error");
		   log.fatal("Main Fatal");
	   }
	   Properties pro=new Properties();
	  @Test(priority = 3)
	  public void excel() throws IOException
	  {
		  FileInputStream file=new FileInputStream("C:\\Users\\HP\\OneDrive\\Desktop\\NewCjc\\DemoWebShop.properties");
		      pro.load(file);
		  
		      String a=pro.getProperty("url");
		      log.info(a);
		      
		      String f=pro.getProperty("fn");
		      log.info(f);
		      
		      String l=pro.getProperty("ln");
		      log.info(l);
		      
		      String e=pro.getProperty("em");
		      log.info(e);
	  
		      String ps=pro.getProperty("ps");
	          log.info(ps);
	  
	          String ps1=pro.getProperty("ps1"); 
	          log.info(ps1);
	  
	  }	  
	   
//	   @Test
//	   public void auto() throws IOException 
//	   {
//		   System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\OneDrive\\Desktop\\ChromeDriver 111\\chromedriver_win32\\chromedriver.exe");
//	        ChromeOptions options=new ChromeOptions();
//		      options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
//		      WebDriver driver=new ChromeDriver(options);
//		   driver.get("https://www.ilovepdf.com/jpg_to_pdf");
//		   driver.manage().window().maximize();
//		   driver.findElement(By.xpath("//*[@id=\"pickfiles\"]")).click();
//		   Runtime.getRuntime().exec("C:\\Users\\HP\\OneDrive\\Desktop\\AutoIt\\Gp.exe");
//	   }

	  Properties pro1=new Properties();
	  @Test(priority = 4)
	  public void prop() throws IOException
	  {
		  log.info("Properties File Data");
		  FileInputStream fil=new FileInputStream("C:\\Users\\HP\\OneDrive\\Desktop\\NewCjc\\DemoWebShop.properties");
		  pro1.load(fil);
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\OneDrive\\Desktop\\chromdriver110\\chromedriver_win32\\chromedriver.exe");
	        driver=new ChromeDriver();	
		  driver.navigate().to(pro.getProperty("url"));
		  driver.findElement(By.name("Gender")).click();
		  driver.findElement(By.name("FirstName")).sendKeys(pro1.getProperty("fn"));
		  driver.findElement(By.name("LastName")).sendKeys(pro1.getProperty("ln"));
		  driver.findElement(By.name("Email")).sendKeys(pro1.getProperty("em"));
		  driver.findElement(By.name("Password")).sendKeys(pro1.getProperty("ps"));
		  driver.findElement(By.name("ConfirmPassword")).sendKeys(pro1.getProperty("ps1"));
		  driver.findElement(By.name("register-button")).click();
	  }
	   
	   
	   
	   
}
