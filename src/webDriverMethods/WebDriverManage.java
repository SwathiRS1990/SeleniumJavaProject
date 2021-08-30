package webDriverMethods;

import org.openqa.selenium.WebDriver.Window;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManage {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https:/www.google.com/");
		Thread.sleep(5000);
				
		//driver.manage().window().maximize();
		//driver.manage().window().fullscreen();
		
		//Creating multiple objects is not correct. so changed the code as below.
		Window window = driver.manage().window();
		window.maximize();
		Thread.sleep(5000);
		
		window.fullscreen();
		Thread.sleep(5000);
		
		driver.quit();

	}

}
