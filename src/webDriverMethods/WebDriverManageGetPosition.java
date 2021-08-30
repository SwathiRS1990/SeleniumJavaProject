package webDriverMethods;

import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManageGetPosition {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		Point position = driver.manage().window().getPosition();
		
		System.out.println("StartX = "+position.getX());
		System.out.println("StartY = "+position.getY());
		
		driver.quit();

	}

}
