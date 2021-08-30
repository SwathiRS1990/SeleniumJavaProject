package webDriverMethods;

import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverGetGetTitleClose {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.co.in/");
		String actualTitle = driver.getTitle();
		String expectedTitle = "Google";
		
		if(actualTitle.contains(expectedTitle))
		{
			System.out.println("PASS : Title is correct");
		}
		else
		{
			System.out.println("FAIL : Title is incorrect");
		}
		//driver.close();
		driver.quit();
	}

}
