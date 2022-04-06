package samplePrograms;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertDemo {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		driver.findElement(By.id("promtButton")).click();
		
		Alert a =  driver.switchTo().alert();
		
		System.out.println(a.getText()); 
		a.accept();
		//driver.switchTo().alert().dismiss();
		
		/*driver.switchTo().alert().sendKeys("Hello Test");
		Thread.sleep(5000);
		driver.switchTo().alert().accept();
*/
	}

}
