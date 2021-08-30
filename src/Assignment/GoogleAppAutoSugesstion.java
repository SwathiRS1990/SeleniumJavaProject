package Assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleAppAutoSugesstion {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.get("https://www.google.com/");
		
		driver.findElement(By.name("q")).sendKeys("sachin");
		
		List<WebElement> autoSugesstions = driver.findElements(By.xpath("//ul[@class = 'erkvQe']//div[@class = 'wM6W7d']"));
	
		for(WebElement ele : autoSugesstions)
		{
			System.out.println(ele.getText());
		}
		driver.quit();
	}

}
