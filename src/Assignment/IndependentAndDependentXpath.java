package Assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndependentAndDependentXpath {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		driver.get("https://www.oracle.com/in/java/technologies/javase/javase-jdk8-downloads.html");
		
		driver.findElement(By.xpath("//a[@id='JDK']/.."
				+ "//td[text() = 'Linux ARM 64 RPM Package']/.."
				+ "//a[@class = 'license-link icn-download-locked']")).click();
		
		WebElement disabledClick = driver.findElement(By.xpath("//div[@class= 'oform-bttns center-bttns']"
				+ "//a[@class = 'download-file icn-download-locked']"));
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", disabledClick);
		
		Thread.sleep(5000);
		driver.quit();
		
	}

}
