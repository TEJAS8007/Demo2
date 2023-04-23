package Log;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WithoutTest {

	@Test(dataProvider = "getData")
	 public void loginTest(String un,String ps)
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\HP\\OneDrive\\Desktop\\ChromeDriver 111\\chromedriver_win32\\chromedriver.exe");
		        
		        WebDriver driver=new ChromeDriver();
		        
		        driver.get("https://demo.guru99.com/test/newtours/index.php");
		        
		        driver.manage().window().maximize();
		        
		        WithoutPageFactory with=PageFactory.initElements(driver,WithoutPageFactory.class);
		        with.login(un,ps);
		        
	}
	
	 @DataProvider
	 public Object[][] getData()
	 {
		 Object[][] obj=new Object[2][2];
		    obj[0][0]="QQQQ";
		    obj[0][1]="qqqq";
		    
		    obj[1][0]="PPPP";
		    obj[1][1]="pppp";
		
		    return obj;
		 
	 }
	 
	 
	 
	 
	 
	 
	 
	 
	
	
	
	
	
	
	
	
	
	
	
}
