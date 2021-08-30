package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelectorLocator {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.naukri.com");
		
		driver.findElement(By.id("login_Layer")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.cssSelector("input[placeholder = 'Enter your active Email ID / Username']")).sendKeys("swathisubramanya1611@gmail.com");
		
		Thread.sleep(3000);
		
		driver.quit();

	}

}
