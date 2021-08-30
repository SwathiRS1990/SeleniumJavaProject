package webDriverMethods;

import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverGetCurrentUrl {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://demo.actitime.com/");
		String actualUrl = driver.getPageSource();
		
		String expectedUrl = "https://demo.actitime.com/login.do";
		
		if(actualUrl.contains(expectedUrl))
		{
			System.out.println("PASS : url is correct");
		}
		else
		{
			System.out.println("FAIL : url is incorrect");
		}

		driver.quit();
	}

}
