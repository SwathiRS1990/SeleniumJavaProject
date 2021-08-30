package webDriverMethods;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverNavigateTo_StringArg {

	public static void main(String[] args) throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https:/www.licindia.in/");
		
		URL urlRef = new URL("https://www.licindia.in/Guidelines/Be-a-Corporate-Agent");
		
		driver.navigate().to(urlRef);
		
		driver.quit();
	}
}
