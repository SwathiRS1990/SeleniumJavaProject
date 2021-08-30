package Assignment;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;

public class CssColourVerification {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com");
		
		driver.findElement(By.id("username")).sendKeys("hemanth");
		driver.findElement(By.name("pwd")).sendKeys("mohan");
		driver.findElement(By.id("loginButton")).click();
		
		Thread.sleep(5000);
		
		String expectedHexCode = "#ce0100";
		String actualRGB = driver.findElement(By.xpath("//span[@class='errormsg' and not(@id)]")).getCssValue("color");
		
		String actualHexCode = Color.fromString(actualRGB).asHex();
		
		if(actualHexCode.equals(expectedHexCode))
		{
			System.out.println("Pass : colour is correct");
		}
		else
		{
			System.out.println("Fail : colour is incorrect");

		}
		driver.quit();
	}

}
