package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeftAlignmentVerification {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://en-gb.facebook.com/signup");
				
		driver.findElement(By.xpath("//input[@value ='Log In to Existing Account']")).click();
		
		Rectangle usernameRect = driver.findElement(By.id("email")).getRect();
		Rectangle passwordRect = driver.findElement(By.id("pass")).getRect();
		
		int usernameWidth = usernameRect.getX() + usernameRect.getWidth();
		
		System.out.println("usernameWIdth = "+ usernameWidth);
		System.out.println("passwordStartX = "+passwordRect.getX());
		
		if(usernameWidth < passwordRect.getX())
		{
			System.out.println("Pass : Username and password text fields are left aligned");
		}
		else
		{
			System.out.println("Fail : Username and password text fields are not left aligned.");
		}
		
		driver.quit();
	}

}
