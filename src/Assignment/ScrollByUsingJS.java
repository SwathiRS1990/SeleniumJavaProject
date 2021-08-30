package Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScrollByUsingJS {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		driver.get("https://www.naukri.com");
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		Thread.sleep(5000);
		jse.executeScript("window.scrollBy(0, document.body.scrollHeight);");
		
		Thread.sleep(5000);
		jse.executeScript("window.scrollBy(0, -document.body.scrollHeight);");
		
		Thread.sleep(5000);
		jse.executeScript("window.scrollBy(document.body.scrollWidth, 0);");
		
		Thread.sleep(5000);
		jse.executeScript("window.scrollBy(-document.body.scrollWidth, 0);");
	
		Thread.sleep(5000);
		
		driver.quit();
	}
	

}
