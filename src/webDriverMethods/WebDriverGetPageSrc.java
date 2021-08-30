package webDriverMethods;

import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverGetPageSrc {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://demo.actitime.com/");
		String actualPageSrc = driver.getPageSource();
		String expectedPageSrc = "Please identify yourself";
		
		if(actualPageSrc.contains(expectedPageSrc))
		{
			System.out.println("PASS : Text is present");
		}
		else
		{
			System.out.println("FAIL : Text is not present");
		}
		
		driver.quit();
	}

}
