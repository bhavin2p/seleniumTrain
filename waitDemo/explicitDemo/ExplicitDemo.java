package explicitDemo;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitDemo {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://api.jquery.com/dblclick/");
		Actions actions = new Actions(driver);
		WebElement element = driver.findElement(By.xpath("//span[text()='Double click the block']//parent::body/div"));
		System.out.println("Color Before = " +element.getCssValue("background-color"));
		actions.doubleClick(element).build().perform();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated((By) element));
		System.out.println("Color After = " +element.getCssValue("background-color"));
		
		
		

	}

}
