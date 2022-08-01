package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		//Download and set the path
		WebDriverManager.chromedriver().setup();
														
		//Launch the ChromeBrowser
		ChromeDriver driver = new ChromeDriver();
														
		//Load the URL
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
														
		//Maximize the window
		driver.manage().window().maximize();
		
		//Enter UserName and Password Using Id Locator
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Click crm/sfa link
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Click on contacts Button
		driver.findElement(By.linkText("Contacts")).click();
		
		//Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		
		//Click on Widget of From Contact
		driver.findElement(By.xpath("//span[text()='From Contact']/following::img")).click();
		
		//Switch to window1
		Set<String> parWindow = driver.getWindowHandles();
		List<String> PArentWindow = new ArrayList<String>(parWindow);
		System.out.println(PArentWindow.size());
		String window1 = PArentWindow.get(1);
		String window2 = PArentWindow.get(0);
		driver.switchTo().window(window1);
		
		Thread.sleep(5000);
		
		//Click on First Resulting Contact
		driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
		
		//Switch to window2
		driver.switchTo().window(window2);
		
		//Click on Widget of To Contact
		driver.findElement(By.xpath("(//span[text()='To Contact']/following::img)[1]")).click();
		
		//Switch to window1
		Set<String> parWindow1 = driver.getWindowHandles();
		List<String> PArentWindow1 = new ArrayList<String>(parWindow1);;
		String windowp = PArentWindow1.get(1);
		driver.switchTo().window(windowp);
		String windowc = PArentWindow1.get(0);
		
		//Click on Second Resulting Contact
		driver.findElement(By.xpath("(//div[@class='x-grid3-row    x-grid3-row-alt']//a)[1]")).click();
		
		//Switch to parent window
		driver.switchTo().window(windowc);
		
		//Click on Merge button using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		
		//Accept the Alert
		driver.switchTo().alert().accept();
		
		//Verify the title of the page
		String title = driver.getTitle();
		if (title.contains("Merge Contacts | opentaps CRM")) {
			System.out.println("Verified the page");
		}else {
			System.out.println("Not verified");
		}

	}

}
