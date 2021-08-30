package WebElementMethods;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindElementsOrder {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.get("https://uidai.gov.in/");
		
		driver.findElement(By.xpath("//select[@class = 'inputbox advancedSelect']")).click();
		
		List<WebElement> suggestions = driver.findElements(By.xpath("//div[@id = 'header-top']//form[@name = 'lang']/select[@class = 'inputbox advancedSelect']/option"));
		
		for(WebElement ele:suggestions)
		{
			System.out.println(ele.getText());
		}
		
		Thread.sleep(3000);
		driver.quit();
	}

}
