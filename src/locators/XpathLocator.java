package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathLocator {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://www.linkedin.com/");
		driver.findElement(By.linkText("Sign in")).click();
		driver.findElement(By.id("username")).sendKeys("swathisubramanya1611@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Aryan123");
		driver.findElement(By.xpath("//button[text() = 'Sign in']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[text()= 'Start a post']")).click();
		
		Thread.sleep(5000);
		driver.quit();
	}

}
