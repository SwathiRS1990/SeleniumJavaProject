package webDriverMethods;

import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverNavigateMethods {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https:/www.licindia.in/");
		Thread.sleep(5000);
		
		driver.get("https:/www.wikipedia.org/");
		Thread.sleep(5000);
		
		driver.navigate().back();
		Thread.sleep(5000);
		
		driver.navigate().forward();
		Thread.sleep(5000);
		
		driver.navigate().refresh();
		Thread.sleep(5000);
		
		driver.quit();
	}

}
