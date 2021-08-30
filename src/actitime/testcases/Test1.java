package actitime.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		driver.get("https://demo.actitime.com/reports/reports.do");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();
		
		driver.findElement(By.linkText("Time-Track")).click();
		driver.findElement(By.xpath("//span[text() = 'New']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text() = 'Select Customer and Project to Add Tasks for']")));
		
		driver.findElement(By.xpath("//div[text() = 'Select Customer and Project to Add Tasks for']/.."
				+ "//tr[@class= 'selectCustomerRow']"
				+ "//div[@class = 'dropdownButton']")).click();
		
		JavascriptExecutor jse = (JavascriptExecutor) driver ;
		jse.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[text() = '- New Customer -']"))); 
		
		driver.findElement(By.xpath("//input[@placeholder= 'Enter Customer Name']")).sendKeys("ABCDE");
		driver.findElement(By.xpath("//input[@placeholder= 'Enter Project Name']")).sendKeys("CRM Project");
		
		driver.findElement(By.xpath("//input[@placeholder = 'Enter task name']")).sendKeys("module1 Testing");
		driver.findElement(By.xpath("//td[@class = 'estimateCell']/input[@placeholder = 'not needed']")).sendKeys("10");
		driver.findElement(By.xpath("//button[text() = 'set deadline']")).click();
		
		driver.findElement(By.xpath("(//span[text()='30'])[2]")).click();
			
		driver.findElement(By.xpath("//div[text() = 'Create Tasks']")).click();
		
		Thread.sleep(2000);
		
		driver.quit();
	}

}
