package locators;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class test1 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://demo.actitime.com");
		
		String pageSource = driver.getPageSource();
		
		String expPageText = "Please identify yourself";
		
		if(pageSource.contains(expPageText))
		{
			System.out.println("Pass : text is correct");
		}
		else
		{
			System.out.println("Fail: text is incorrect");
		}
		
		String actualText = driver.findElement(By.id("headerContainer")).getText();

		if(actualText.equals(expPageText))
		{			
			System.out.println("Pass : text is correct");			
		}
		else
		{
			System.out.println("Fail: text is incorrect");
		}
		
	}

}
