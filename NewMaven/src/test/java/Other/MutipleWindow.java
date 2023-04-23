package Other;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MutipleWindow {

	WebDriver driver;
	@Test
	public void login()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\OneDrive\\Desktop\\ChromeDriver 111\\chromedriver_win32\\chromedriver.exe");
	          driver=new ChromeDriver();
	          
	          driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	          
	          driver.manage().window().maximize();
	          
	        List total= driver.findElements(By.tagName("a")); 
	           System.out.println(total.size());
	           
	         WebElement footer=driver.findElement(By.xpath("//*[@id=\"gf-BIG\"]")); 
	                  List foot=footer.findElements(By.tagName("a"));
	                    int num=foot.size();
	                    
	                 for(int a=0;a<num;a++)
	                 {
	                	String tab=Keys.chord(Keys.CONTROL,Keys.ENTER);
	                	 footer.findElements(By.tagName("a")).get(a).sendKeys(tab); 
	                 }
	                  
	              Set<String> set=driver.getWindowHandles(); 
	                     System.out.println(set);
	                     
	                 ArrayList<String> array=new ArrayList<String>(set);
	                    Iterator<String> itr=array.iterator();
	                    while(itr.hasNext())
	                    {
	                    	driver.switchTo().window(itr.next());
	                    	 String title=driver.getTitle();
	                    	 System.out.println(title);
	                    	 
	                    	 
	                    }
//	       WebElement discount=driver.findElement(By.xpath("//*[@id=\"gf-BIG\"]/table/tbody/tr/td[1]/ul"));   
//	           List disc= discount.findElements(By.tagName("a"));     
//	                 int num=disc.size();
//	             System.out.println(num);
//	             
//	          for(int a=0;a<num;a++)
//	          {
//	        	  String tab=Keys.chord(Keys.CONTROL,Keys.ENTER);
//	        	  discount.findElements(By.tagName("a")).get(a).sendKeys(tab);
//	          }
//	              
//	                   Set<String> set=driver.getWindowHandles();
//	                    System.out.println(set);
//	                    
//	              ArrayList<String> array=new ArrayList<String>(set);
//	              
//	              Iterator<String> itr=array.iterator();
//	              while(itr.hasNext())
//	              {
//	                   driver.switchTo().window(itr.next());            	 
//	            	   String title=driver.getTitle();
//	            	   System.out.println(title);
//	            	   String url=driver.getCurrentUrl();
//	            	   System.out.println(url);
//	              }
//	        
	              
	        
	}
}
