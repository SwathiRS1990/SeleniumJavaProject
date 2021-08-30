package Assignment;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleApp {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.get("https://www.google.com/");
		
		driver.findElement(By.name("q")).sendKeys("sachin");
		
		List<WebElement> autoSugesstions = driver.findElements(By.xpath("//ul[@class = 'erkvQe']//div[@class = 'wM6W7d']"));
		
		Set<String> expAutoSugesstions = new HashSet<String>();
		expAutoSugesstions.add("Sachin Tendulkar");
		expAutoSugesstions.add("Sachin Vaze");
		expAutoSugesstions.add("sachin tendulkar age");
		expAutoSugesstions.add("Sachin Pilot");
		expAutoSugesstions.add("Sachin Baby");
		expAutoSugesstions.add("sachin tendulkar net worth");
		expAutoSugesstions.add("sachin tendulkar son");
		expAutoSugesstions.add("Sachin Bansal");
		expAutoSugesstions.add("sachin tendulkar wife");
		expAutoSugesstions.add("sachin tendulkar daughter");
		
		Set<String> actAutoSugesstions = new HashSet<String>();
		
		for(WebElement ele : autoSugesstions)
		{
			actAutoSugesstions.add(ele.getText());
		}
		
		System.out.println("expAutoSugesstions = "+expAutoSugesstions);
		System.out.println("actAutoSugesstions = "+actAutoSugesstions);
		
		if(actAutoSugesstions.equals(expAutoSugesstions)) 
		{
			System.out.println("Pass : Text is correct");
		}
		else
		{
			System.out.println("Fail : Text is incorrect");
		}
		
		driver.quit();
	}

}
