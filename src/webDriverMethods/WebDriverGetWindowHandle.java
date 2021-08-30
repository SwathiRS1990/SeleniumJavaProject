//Scenario : Open the browser
//           go to naukri.com
//			 Get all the windowIds
//           Close only the child windows.

package webDriverMethods;

import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverGetWindowHandle {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.naukri.com/");
		
		String parentWindowId = driver.getWindowHandle();
		
		Set<String> allWindowIds = driver.getWindowHandles();
		
		//Removing the parent window id from allWindowIds set.
		//so that we can skip closing the parent window id.
		allWindowIds.remove(parentWindowId);
		
		for(String wid : allWindowIds)
		{
			//Transferring the driver control to each window iteratively
			driver.switchTo().window(wid);
			driver.close();
			
		}
		driver.switchTo().window(parentWindowId);
		System.out.println(driver.getCurrentUrl());
	}
}
