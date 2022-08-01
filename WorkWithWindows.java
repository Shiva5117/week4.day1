package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkWithWindows {

	public static void main(String[] args) {
		//Download and set the path
		WebDriverManager.chromedriver().setup();
														
		//Launch the ChromeBrowser
		ChromeDriver driver = new ChromeDriver();
														
		//Load the URL
		driver.get("http://www.leafground.com/pages/Window.html");
														
		//Maximize the window
		driver.manage().window().maximize();
		
		//Click button to open home page in New Window
		driver.findElement(By.id("home")).click();
		
		//Find the number of opened windows
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> windows = new ArrayList<String>(windowHandles);
		int NoOfWindows = windows.size();
		System.out.println(NoOfWindows);
		
		//Close all except this window
		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> windows1 = new ArrayList<String>(windowHandles1);
		driver.switchTo().window(windows.get(1));
		driver.close();
		
		//Switch to Parent window
		driver.switchTo().window(windows.get(0));
		
		//Explicitly Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//Wait for 2 new Windows to open
		driver.findElement(By.xpath("//button[text()='Wait for 5 seconds']")).click();

	}

}
