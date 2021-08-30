package actitime.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShwethaTest1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("https://demo.actitime.com/reports/reports.do");
		
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Time-Track")));
		driver.findElement(By.linkText("Time-Track")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("addTaskButtonId")));
		driver.findElement(By.id("addTaskButtonId")).click();
		
//		driver.findElement(By.xpath("//div[@class='selectedItem'and text()='Testing Company']")).click();
		driver.findElement(By.xpath("//tr[@class='selectCustomerRow']//div[@class='comboboxButton']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'New Customer')]")));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebElement customer = driver.findElement(By.xpath("//div[contains(text(),'New Customer')]"));
		jse.executeScript("arguments[0].scrollIntoView(true);", customer);
		customer.click();
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Customer Name']")).sendKeys("Light");
		driver.findElement(By.xpath("//input[@placeholder='Enter Project Name']")).sendKeys("GoldFish");
		
		driver.findElement(By.xpath("(//input[@placeholder='Enter task name'])[1]")).sendKeys("Complete Testing");
		driver.findElement(By.xpath("(//td[@class='estimateCell'])[1]/input")).sendKeys("18");
//		WebElement setDeadLine = driver.findElement(By.xpath("(//button[text()='set deadline'])[1]"));
//		jse.executeScript("arguments[0].value='Jul 31, 2021';", setDeadLine);
		driver.findElement(By.xpath("(//button[text()='set deadline'])[1]")).click();
		driver.findElement(By.xpath("//td[@class='x-date-active']//span[text()='30']")).click();
	
		driver.findElement(By.xpath("//div[@class='commitButtonPlaceHolder']")).click();
//		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='task']")));
		Thread.sleep(2000);
		List<WebElement> tasks = driver.findElements(By.xpath("//div[@class='task']"));
		for (WebElement element : tasks) {
			if ((element.getText()).equals("Complete Testing")) {
				System.out.println("New Task has been created");
				break;
			}
		}
	}
}