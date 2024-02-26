package AutomationTool.com;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Slider 
{
	WebDriver driver;
	@Test
	public void slide()
	{
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.automationtesting.in/Register.html");
		WebElement SwithButton = driver.findElement(By.xpath("//a[@href='Widgets.html']"));
		Actions act=new Actions(driver);
		act.moveToElement(SwithButton).build().perform();
		driver.findElement(By.xpath("//a[@href='Slider.html']")).click();
		WebElement slideele = driver.findElement(By.id("slider"));
		Actions actions = new Actions(driver);
		actions.dragAndDropBy(slideele, 300, 0).build().perform();
	}
}
