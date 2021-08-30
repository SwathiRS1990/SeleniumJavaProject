package Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelectorBoldTextVerification {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://demo.actitime.com/login.do");
		
		String expFontWeight = "700" ;
		String actFontWeight = driver.findElement(By.id("adminCredentialsHeader")).getCssValue("font-weight");
		
		if(!actFontWeight.isEmpty())
		{
			if(actFontWeight.equals(expFontWeight))
			{
				System.out.println("Pass : Text is bold");
			}
			else
			{
				System.out.println("Fail : Text is not bold"); 
			}
		}
		else
		{
			System.out.println("Fail: CSS proerty name is incorrect");
		}
		
		driver.quit();
	}

}
