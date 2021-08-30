package Assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChildElements {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,10);
		driver.get("file:///C:/Selenium/Assignment/index.html");
		
		WebElement parentElement = driver.findElement(By.id("books"));
		
		List<WebElement> childElements = parentElement.findElements(By.xpath("//td[last()]"));
		
		
		int total = 0;
		int sum = 0;
		
		for(int i = 0; i < childElements.size(); i++)
		{
			try
			{
				if(i != childElements.size() - 1)
				{
					sum+= Integer.parseInt(childElements.get(i).getText());
				}
				else
				{
					total = Integer.parseInt(childElements.get(i).getText());
				}
			}
			catch(NumberFormatException e)
			{
				
			}
		}
		System.out.println("sum = "+sum);
		System.out.println("total = "+total);
		
		if(sum == total)
		{
			System.out.println("Pass : The total " +total+ " is correct");
		}
		else
		{
			System.out.println("Fail : The total " +total+ " is not correct");
		}
			
		driver.quit();
	}

}
