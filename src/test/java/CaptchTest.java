import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CaptchTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new FirefoxDriver ();
		driver.get("https://www.orangehrm.com/en/orangehrm-30-day-trial");
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		JavascriptExecutor jsp=(JavascriptExecutor)driver;
		jsp.executeScript("window.scrollBy(0,700)");
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		driver.findElement(By.name("subdomain")).sendKeys("Raju");
		driver.findElement(By.name("Name")).sendKeys("Basavaraj");
		driver.findElement(By.name("Email")).sendKeys("basu123@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.name("Contact")).sendKeys("4568798565");
		driver.findElement(By.id("Form_getForm_Country")).sendKeys("India");
		Thread.sleep(2000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@title='reCAPTCHA']")));
		driver.findElement(By.cssSelector("div[class='recaptcha-checkbox-border']")).click();
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		driver.quit();
	}

}
