package WebElementMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAadharOrderOfElements {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		driver.get("https://uidai.gov.in/");
		
		driver.findElement(By.xpath("//div[@id = 'header-logo']/following-sibling::div//span[text() = 'My Aadhaar']")).click();

		//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id = 'header-logo']/following-sibling::div//a[contains(text(),'My Aadhaar')]/following-sibling::ul")));
		
		List<WebElement> orderOfElements = driver.findElements(By.xpath("//div[@id = 'header-logo']/following-sibling::div//a[contains(text(),'My Aadhaar')]/following-sibling::ul/li/a"));

		System.out.println("orderOfElements = "+ orderOfElements);
		
		List<String> expOrder = new ArrayList<String> ();
		expOrder.add("Get Aadhaar");
		expOrder.add("Update Your Aadhaar");
		expOrder.add("Aadhaar Services");
		expOrder.add("About Your Aadhaar");
		expOrder.add("Aadhaar on your mobile");
		expOrder.add("Downloads");
				
		List<String> actOrder = new ArrayList<String> ();
		
		for(WebElement ele:orderOfElements)
		{
			System.out.println(ele.getText());
			actOrder.add(ele.getText());
		}
		
		System.out.println("expOrder = "+expOrder);
		System.out.println("actOrder "+actOrder);
		
		if(actOrder.equals(expOrder))
		{
			System.out.println("Pass : Text and order is correct");
		}
		else
		{
			System.out.println("Fail : Text and order is not correct");
		}
		
		driver.quit();
	}
	

}
