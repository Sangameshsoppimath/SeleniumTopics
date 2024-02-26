package AutomationTool.com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alertsconcept 
{
	WebDriver driver;
	@Test
	public void switch_to_alert() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.automationtesting.in/Register.html");
		WebElement SwithButton = driver.findElement(By.xpath("//a[@href='SwitchTo.html']"));
		Actions act=new Actions(driver);
		act.moveToElement(SwithButton).build().perform();
		driver.findElement(By.xpath("//a[@href='Alerts.html']")).click();
		driver.findElement(By.xpath("//button[@onclick='alertbox()']")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		
		driver.close();
		
	}

}
