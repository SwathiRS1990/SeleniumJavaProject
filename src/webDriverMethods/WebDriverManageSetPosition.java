package webDriverMethods;

import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManageSetPosition {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		Point position = new Point(100,400);
		
		driver.manage().window().setPosition(position);
		Thread.sleep(5000);
		
		driver.quit();
		
	}
}
