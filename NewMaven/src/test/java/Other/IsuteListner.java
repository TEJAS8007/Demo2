package Other;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class IsuteListner implements ISuiteListener {
     
	 public void onStart(ISuite p)
	 {
		 System.out.println("On Execution Starts");
	
	 }
      
	  
	 public void onFinish(ISuite l)
	 {
		 System.out.println("On Executon Ends");
		 
	 }
}
