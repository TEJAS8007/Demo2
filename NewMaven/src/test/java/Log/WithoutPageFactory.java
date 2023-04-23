package Log;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WithoutPageFactory {

	WebDriver driver;
	
	 @FindBy(name="userName")
	  WebElement uname;
	@FindBy(name="password")
	WebElement pass;
	@FindBy(name="submit")
	WebElement sub;
	
	 public WithoutPageFactory(WebDriver driver)
	 {
		 this.driver=driver;
	 }

	 public void login(String un ,String ps) 
	 {
		 uname.sendKeys(un);
		 pass.sendKeys(ps);
		 sub.click();
	 }


}
