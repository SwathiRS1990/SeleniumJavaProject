package webDriverMethods;

import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverCloseParentWindow {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.naukri.com/");
		driver.close();
		
	}

}
