package AutomationTool.com;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SwitchToWindow 
{
	WebDriver driver;
	@Test
	public void HandlingWindows() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.automationtesting.in/Register.html");
		WebElement SwithButton = driver.findElement(By.xpath("//a[@href='SwitchTo.html']"));
		Actions act=new Actions(driver);
		act.moveToElement(SwithButton).build().perform();
		driver.findElement(By.xpath("//a[@href='Windows.html']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();
		
		Set<String> windowIds = driver.getWindowHandles();
		String mainwi = windowIds.iterator().next();
		String chilwi = windowIds.iterator().next();
		
		driver.switchTo().window(chilwi);
		
		Thread.sleep(3000);
		
	}
	
	
	@Test
	public void HandlingWindowspopup() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.automationtesting.in/Register.html");
		WebElement SwithButton = driver.findElement(By.xpath("//a[@href='SwitchTo.html']"));
		Actions act=new Actions(driver);
		act.moveToElement(SwithButton).build().perform();
		driver.findElement(By.xpath("//a[@href='Windows.html']")).click();
		driver.findElement(By.xpath("//a[@href='#Seperate']")).click();
		driver.findElement(By.xpath("//button[@onclick='newwindow()']")).click();
		
		Set<String> windowIds = driver.getWindowHandles();
		String mainwi = windowIds.iterator().next();
		String chilwi = windowIds.iterator().next();
		
		driver.switchTo().window(chilwi);
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//img[@src='/images/sponsors/saucelabs.png']")).click();
		
	}
	
	
	

}
