package webDriverMethods;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverNavigateTo_UrlArg {

	public static void main(String[] args) throws Exception {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https:/www.licindia.in/");
		Thread.sleep(5000);
		
		URL mainUrl = new URL("https:/www.licindia.in/");
		
		URL subUrl1 = new URL(mainUrl, "Guidelines/Be-a-Corporate-Agent");
		
		URL subUrl2 = new URL(mainUrl, "Guidelines/Be-an-Agent-(Individual)");
		
		driver.navigate().to(subUrl1);
		Thread.sleep(5000);
		
		driver.navigate().to(subUrl2);
		Thread.sleep(5000);
		
		driver.quit();
	}

}
