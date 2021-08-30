package Assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipKartApp {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		driver.get("https://www.flipkart.com/");
		
		driver.findElement(By.xpath("//input[@type = 'text' and not(@name)]")).sendKeys("swathisubramanya1611@gmail.com");
		driver.findElement(By.xpath("//input[@type = 'password']")).sendKeys("Swathiaress90");
		driver.findElement(By.xpath("//button[@class = '_2KpZ6l _2HKlqd _3AWRsL']")).click();
		
		driver.findElement(By.xpath("//input[@maxlength = '10' and @type = 'text']")).sendKeys("8971811096");
		driver.findElement(By.xpath("//span[text() = 'CONTINUE']")).click();
		driver.findElement(By.xpath("//input[@type = 'password']")).sendKeys("Swathiaress90");

		
		driver.findElement(By.xpath("//div[@id = 'container']/following-sibling::div/div/div/button")).click();
		
		driver.findElement(By.name("q")).sendKeys("iphone ");
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class = 'wXpsjT']/following-sibling:: div")));
		
		List<WebElement> autoSuggestions = driver.findElements(By.xpath("//div[@class = 'wXpsjT']/following-sibling:: div"));
		
		System.out.println("autoSuggestions size = "+autoSuggestions.size());
		
		String expText = "iphone 7 plus";
		
		for(WebElement ele:autoSuggestions)
		{
			System.out.println(ele.getText());
			
			if(ele.getText().equals(expText))
			{
				ele.click();
			}
		}
		Thread.sleep(5000);
		driver.quit();
	}

}
