package webDriverMethods;

import java.util.Set;

import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverGetWindowHandles {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.naukri.com/");
		
		Set<String> allWindowIds = driver.getWindowHandles();
		
		//We are fetching each and every window id which is stored in the 
		//allWindowIds reference and we are printing it iteratively.
		for(String wid :allWindowIds)
		{
			System.out.println(wid);
		}
		
		driver.quit();
	}

}
