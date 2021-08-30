package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelectorAletrnateText {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.flipkart.com/");
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//button[@class = '_2KpZ6l _2doB4z']")).click();
		
		String expectedAlternateName = "Flipkart";
		String actualAlternateName = driver.findElement(By.xpath("//img[@title = 'Flipkart']")).getAttribute("alt");
		
		if(actualAlternateName != null)
		{
			if(actualAlternateName.equals(expectedAlternateName))
			{
				System.out.println("Pass : Alternate text is correct");
			}
			else
			{
				System.out.println("Fail : Alternate text is not correct");
			}
		}
		else
		{
			System.out.println("Fail : Attribute name is not correct");
		}
		Thread.sleep(5000);
		driver.quit();
	}

}
