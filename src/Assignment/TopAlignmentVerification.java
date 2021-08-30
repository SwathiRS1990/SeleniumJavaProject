package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TopAlignmentVerification {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://en-gb.facebook.com/signup");
				
		driver.findElement(By.xpath("//input[@value ='Log In to Existing Account']")).click();
		
		Point firstNamePoint = driver.findElement(By.id("email")).getLocation();
		Point lastNamePoint = driver.findElement(By.id("pass")).getLocation();
		
		if(firstNamePoint.getY() == lastNamePoint.getY())
		{
			System.out.println("Pass : top alignment is correct");
		}
		else
		{
			System.out.println("Fail : top alignment is not correct");
		}

		driver.quit();
	}

}
