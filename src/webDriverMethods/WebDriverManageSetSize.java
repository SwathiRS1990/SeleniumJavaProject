package webDriverMethods;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManageSetSize {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		Dimension targetSize = new Dimension(100,300);
		
		driver.manage().window().setSize(targetSize);
		Thread.sleep(5000);
		
		driver.quit();	

	}

}
