//Scenario : Open the browser
//           go to naukri.com
//			 Get all the windowIds
//           Transfer the driver control to each windowiteratively.
//           Print the title of each browser window iteratively.

package webDriverMethods;

import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverGetWindowHandles_1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.naukri.com/");
		
		Set<String> allWindowIds = driver.getWindowHandles();
		
		for(String wid : allWindowIds)
		{
			driver.switchTo().window(wid);
			String title = driver.getTitle();
			System.out.println("title = "+ title);
		}
		driver.quit();
	}

}
