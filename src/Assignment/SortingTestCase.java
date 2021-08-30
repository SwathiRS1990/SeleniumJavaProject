//Script to print all the window titles in the alphabetical order.

package Assignment;

import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.chrome.ChromeDriver;

public class SortingTestCase {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.naukri.com/");
		
		Set<String> allWindowIds = driver.getWindowHandles();
		Set<String> treeSetRef = new TreeSet<>();
		
				
		//We are fetching each and every window id which is stored in the 
		//allWindowIds reference and we are adding it iteratively in treeset.
		for(String wid :allWindowIds)
		{
			driver.switchTo().window(wid);
			treeSetRef.add(driver.getTitle());
		}
		for(String titles :treeSetRef)
		{
			System.out.println(titles);
		}
		driver.quit();
	}
}
