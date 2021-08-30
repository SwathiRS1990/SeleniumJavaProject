package Assignment;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoSuggestions {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.get("https://www.udemy.com/");
		
		driver.findElement(By.name("q")).sendKeys("python");
		
     	List <WebElement> autoSuggestions = driver.findElements(By.xpath("//a[contains(@id , 'search-form-autocomplete')]"));
     	
     	
     	int count = autoSuggestions.size();
     	System.out.println("autoSuggestions.size = "+ count) ;
     	
     	if(count <=12)
     	{
     		System.out.println("count is correct");
     	}
     	else
     	{
     		System.out.println("count is not correct");
     	}
     	
     	for(WebElement ele : autoSuggestions)
     	{
     		System.out.println(ele.getText());
     	}
     	driver.quit();
	}

}
