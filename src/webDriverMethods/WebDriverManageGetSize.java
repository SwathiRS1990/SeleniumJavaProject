package webDriverMethods;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManageGetSize {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		Dimension size = driver.manage().window().getSize();
		
		System.out.println("Width = " +size.getWidth());
		System.out.println("Height = "+ size.getHeight());
		
		driver.quit();
	}

}
