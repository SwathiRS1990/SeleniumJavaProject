//Scenario : Open the browser
//           go to naukri.com
//			 Get all the windowIds
//           Transfer the driver control to cognizant window.
//           Print the URL of cognizant.

package webDriverMethods;

import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverGetWindowHandles_2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.naukri.com/");
		
		Set<String> allWindowIds = driver.getWindowHandles();
		
		for(String wid : allWindowIds)
		{
			//Transferring the driver control to each window iteratively
			driver.switchTo().window(wid);
			//Check whether the control is going to the cognizant window.
			//If the driver control is in cognizant window then break.
			if(driver.getTitle().contains("Cognizant"))
			{
				break;
			}
		}
		System.out.println(driver.getCurrentUrl());
		driver.quit();
	}


}
