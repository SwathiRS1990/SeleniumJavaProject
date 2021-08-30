package webDriverMethods;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverNavigateToUrl_StringArg {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https:/www.licindia.in/");
		Thread.sleep(5000);
		
		URL urlRef = new URL("https:/www.licindia.in/Guidelines/Be-a-Corporate-Agent");
		
		driver.navigate().to(urlRef);
		Thread.sleep(5000);
		
		driver.quit();

	}

}
