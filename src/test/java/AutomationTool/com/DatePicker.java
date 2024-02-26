package AutomationTool.com;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePicker 
{
	WebDriver driver;
	@Test
	public void Date_Picker()
	{
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.automationtesting.in/Register.html");
		WebElement SwithButton = driver.findElement(By.xpath("//a[@href='Widgets.html']"));
		Actions act=new Actions(driver);
		act.moveToElement(SwithButton).build().perform();
		driver.findElement(By.xpath("//a[@href='Datepicker.html']")).click();
		driver.findElement(By.xpath("//img[@class='imgdp']")).click();
		while(true)
		{
			String Month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String Year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			if(Month.equals("March")&&Year.equals("2024"))
			{
				break;
			}
			else {
				driver.findElement(By.xpath("//a[@data-handler='next']")).click();
			}
		}
		
		List<WebElement> dates = driver.findElements(By.xpath("//tbody//tr//td"));
		for(WebElement day:dates)
		{
			if(day.getText().equals("23"))
			{
				day.click();
			}
		}
		
	}

}
