package Assignment;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActiTimeIncScreenshot {

	public static void main(String[] args) throws Exception {
		LocalDateTime ldt = LocalDateTime.now();
		String timeStamp = ldt.toString().replace(':', '-');
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		
		driver.get("https://demo.actitime.com/login.do");
		
		driver.findElement(By.linkText("actiTIME Inc.")).click();
		
		/*
		 * Set<String> allWindowIds = driver.getWindowHandles(); for(String
		 * wid:allWindowIds) { driver.switchTo().window(wid); }
		 */
		
		TakesScreenshot ts = (TakesScreenshot) driver;		
		File tempFile = ts.getScreenshotAs(OutputType.FILE);
		
		File destFile = new File ("./errorshots/actitimeinc"+timeStamp+".png");
	
		FileUtils.copyFile(tempFile, destFile);
		
		driver.quit();
	}

}
