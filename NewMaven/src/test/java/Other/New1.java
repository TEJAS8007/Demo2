package Other;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.api.Screen;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
@Listeners(Other.TestListner.class)
public class New1 {

	WebDriver driver;
	static Logger log=Logger.getLogger(New1.class.getName());
	@Test(priority = 1)
	public void login()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\OneDrive\\Desktop\\ChromeDriver 112\\chromedriver_win32\\chromedriver.exe");
       	driver=new ChromeDriver();
       	
       	Layout lay=new PatternLayout();
       	Appender ap=new ConsoleAppender(lay);
       	log.addAppender(ap);
       	driver.get("https://jqueryui.com/datepicker/");
       	
       	driver.manage().window().maximize();
       	driver.navigate().refresh();
       	driver.switchTo().frame(0);
       	 String name=driver.getWindowHandle();
       	 System.out.println(name);
       	driver.findElement(By.id("datepicker")).click();
       	
       	while(!driver.findElement(By.cssSelector(" [class='ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all']  [class='ui-datepicker-title']"))
       			 .getText().contains("October 2023"))
       	{
       		log.info("Click");
       		driver.findElement(By.cssSelector(" [class='ui-datepicker ui-widget ui-widget-content ui-helper-clearfix ui-corner-all'] [class='ui-icon ui-icon-circle-triangle-e']"))
               .click();
       	}
       	
       	String dates="15";
       	List<WebElement>date=driver.findElements(By.xpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td"));
       	        int num=date.size();
       	        System.out.println(num);
       	
       	for (WebElement days: date)
       	{
       		
		      if(date.equals(dates))
		      {
		    	  days.click();
		      }
		     
		}
       	
       
       	
	}

	@Test(priority = 2)
	public void rashetty()
	{
		driver.navigate().to("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.manage().window().maximize();
		
		 List  total=driver.findElements(By.tagName("a"));
		  log.info(total.size());
		  
		  WebElement footer=driver.findElement(By.xpath("//*[@id=\"gf-BIG\"]"));
		     List footot=footer.findElements(By.tagName("a"));
		          log.info(footot.size());
	        
		  WebElement dis=driver.findElement(By.xpath("//*[@id=\"gf-BIG\"]/table/tbody/tr/td[1]/ul"));     
	
	             List disc=dis.findElements(By.tagName("a"));
	             int num=disc.size();
	             log.info(num);
	             
	             for(int a=0;a<num;a++)
	             {
	            	 String tab=Keys.chord(Keys.CONTROL,Keys.ENTER);
	            	 dis.findElements(By.tagName("a")).get(a).sendKeys(tab);
	             }
	             
	            Set<String> set=driver.getWindowHandles();
	            log.info(set);
	            
	            ArrayList<String> array=new ArrayList<String>(set); 
	             Iterator<String> itr=array.iterator();
	             while(itr.hasNext())
	             {
	            	 driver.switchTo().window(itr.next());
	            	 String title=driver.getTitle();
	            	 log.info(title);
	            	 String url=driver.getCurrentUrl();
	            	 log.info(url);
	            	 
	            	 if(title.equalsIgnoreCase("REST API Tutorial"))
	            	 {
	            		 log.info("Rest Api Window Opened");
	            	 }

	             }
	             
	             
	             
	      }

	 
      @Test(priority = 3)
      public void redbus() throws InterruptedException
      {
    	  driver.navigate().to("https://www.redbus.in/");
    	  
    	  driver.manage().window().maximize();
    	  Thread.sleep(3000);
    	  WebElement from=driver.findElement(By.id("src"));
    	            from.sendKeys("par");
    	  Thread.sleep(2000);
    	  JavascriptExecutor js=(JavascriptExecutor)driver;
    	  String city="return document.getElementById('src').value";
    	  String cityname=(String)js.executeScript(city);
    	  System.out.println(cityname);
    	  
    	  while(!cityname.equalsIgnoreCase("Paratwada"))
    	  {
    		  Thread.sleep(500);
    		  log.info("Click");
    		  from.sendKeys(Keys.DOWN);
    		  city="return document.getElementById('src').value";
        	  cityname=(String)js.executeScript(city);
        	  System.out.println(cityname);
    		  
    	  }
      
             from.sendKeys(Keys.ENTER);
      
             Thread.sleep(2000);
             WebElement to=driver.findElement(By.id("dest"));
	            to.sendKeys("na");
	         Thread.sleep(2000);
	         JavascriptExecutor js1=(JavascriptExecutor)driver;
	         String citys="return document.getElementById('dest').value";
	         String citynames=(String)js1.executeScript(citys);
	         System.out.println(citynames);
	  
	         
	         while(!citynames.equalsIgnoreCase("Nashik darshan"))
	       {
		       Thread.sleep(500);
		       log.info("Click");
		       to.sendKeys(Keys.DOWN);
		       citys="return document.getElementById('dest').value";
 	           citynames=(String)js1.executeScript(citys);
 	           System.out.println(citynames);
		  
	   }

              to.sendKeys(Keys.ENTER);
      
      
     }

      @Test(priority = 4,dataProvider = "getData")
      public void demo(String fn,String ln,String em,String ps,String ps1)
      {
    	  driver.navigate().to("https://demowebshop.tricentis.com/register");
    	  driver.manage().window().maximize();
    	  
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
    	  String url= driver.getCurrentUrl();
    	  log.info(url);
      }

      @DataProvider
      public Object[][] getData()
      {
    	  Object[][] obj=new Object[2][5];
    	        obj[0][0]="Tejas";
    	        obj[0][1]="Aware";
    	        obj[0][2]="QQQ@123gmail.com";
    	        obj[0][3]="Pass@123";
    	        obj[0][4]="Pass@123";
    	        
    	        obj[1][0]="Roshan";
    	        obj[1][1]="Aware";
    	        obj[1][2]="RRR@123gmail.com";
    	        obj[1][3]="Pass@123";
    	        obj[1][4]="Pass@123";
    	  
    	        return obj;
      }

      
//      @Test(priority = 5)
//      @Parameters({"fnn","lnn","emm","pss","pss1"})
//      public void demowebxml(String f,String l,String e,String p,String pp)
//      {
//    	  driver.get("https://demowebshop.tricentis.com/register");
//    	  driver.manage().window().maximize();
//    	  
//    	  driver.findElement(By.name("Gender")).click();
//    	  driver.findElement(By.name("FirstName")).sendKeys(f);
//    	  driver.findElement(By.name("LastName")).sendKeys(l);
//    	  driver.findElement(By.name("Email")).sendKeys(e);
//    	  driver.findElement(By.name("Password")).sendKeys(p);
//    	  driver.findElement(By.name("ConfirmPassword")).sendKeys(pp);
//    	  driver.findElement(By.name("register-button")).click();
//      }

      @Test(priority = 5)
      public void merLogin()
      {
    	  driver.navigate().to("https://demo.guru99.com/test/newtours/login.php");
    	  
    	  driver.manage().window().maximize();
    	  
    	  Set<Cookie> set1=driver.manage().getCookies();
    	  log.info(set1.size());
    	  
    	  for (Cookie cookie : set1)
    	{
		     log.info(cookie.getName());
		     log.info(cookie.getClass());
		     log.info(cookie.getDomain());
		     log.info(cookie.getPath());
		     log.info(cookie.getValue());
		     log.info(cookie.getExpiry());
		     log.info(cookie.isHttpOnly());
		     log.info(cookie.isSecure());
    	}
    	 
      }
      
      @Test(priority = 6)
      public void cricubuzz()
      {
    	 driver.navigate().to("https://www.cricbuzz.com/live-cricket-scorecard/66404/mi-vs-pbks-31st-match-indian-premier-league-2023");
    	 
    	 driver.manage().window().maximize();
    	 
    	   WebElement inning=driver.findElement(By.xpath("//*[@id=\"innings_1\"]/div[1]"));
      
    	   List row=inning.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms']"));
       
    	            int num=row.size();
                  log.info(num);
          int add=0;
           for(int a=0;a<num-3;a++)
           {
        	 String runs= inning.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] :nth-child(3)")).get(a).getText();
    
                 int run=Integer.parseInt(runs);
                  log.info(run);
                          
                  add=add+run;
                  log.info(add);
           }
      
      
           for(int b=0;b<num-3;b++)
           {
        	 String sixs= inning.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] :nth-child(6)")).get(b).getText();
    
                 int six=Integer.parseInt(sixs);
                  log.info(six);
                          
           }
      
        }

      











}
