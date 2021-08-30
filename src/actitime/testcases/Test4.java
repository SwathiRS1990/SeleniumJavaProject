package actitime.testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test4 {

	public static void main(String[] args) throws InterruptedException, AWTException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the customer name");
		String customerName = scan.nextLine();
		
		System.out.println("Enter the task name");
		String taskName = scan.nextLine();
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,10);
		
		driver.get("https://demo.actitime.com/reports/reports.do");
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();
		
		wait.until(ExpectedConditions.titleContains("Reports Dashboard"));
		
		driver.findElement(By.linkText("Time-Track")).click();
		driver.findElement(By.xpath("//span[text() = 'New']")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text() = 'Select Customer and Project to Add Tasks for']")));
		
		driver.findElement(By.xpath("//div[text() = 'Select Customer and Project to Add Tasks for']/.."
				+ "//tr[@class= 'selectCustomerRow']"
				+ "//div[@class = 'dropdownButton']")).click();
		
		JavascriptExecutor jse = (JavascriptExecutor) driver ;
		jse.executeScript("arguments[0].click();", driver.findElement(By.xpath("//div[text() = '- New Customer -']"))); 
		
		driver.findElement(By.xpath("(//input[@placeholder= 'Enter Customer Name'])[1]")).sendKeys(customerName);
		driver.findElement(By.xpath("(//input[@placeholder= 'Enter Project Name'])[1]")).sendKeys("CRM Project");

		driver.findElement(By.xpath("//div[text() = 'Copy properties from existing tasks']")).click();
		
		driver.findElement(By.xpath("//div[@class = 'addTasksSelectorPanelContent']//td[@class = 'dropdownButton']")).click();
		
		driver.findElement(By.xpath("//td[text() = 'Galaxy Corporation']")).click();
		
		driver.findElement(By.xpath("//div[@class = 'selectAllContainer']//input")).click();
		
		driver.findElement(By.xpath("//span[text() = 'Copy properties']")).click();
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(5000);

		driver.quit();
	}
		
}
