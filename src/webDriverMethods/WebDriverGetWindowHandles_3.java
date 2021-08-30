//Scenario : Open the browser
//           go to naukri.com
//			 Get all the windowIds
//           Close only the child windows.

package webDriverMethods;

import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverGetWindowHandles_3 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.naukri.com/");
		
		Set<String> allWindowIds = driver.getWindowHandles();
		
		int count  = 0; // to skip closing the parent window.
		
		for(String wid : allWindowIds)
		{
			count++; //Increment the count
			//Transferring the driver control to each window iteratively
			driver.switchTo().window(wid);
			if(count > 1) // Skipping parent window id.
			{
				driver.close();
			}
			
		}
		
	}

}
