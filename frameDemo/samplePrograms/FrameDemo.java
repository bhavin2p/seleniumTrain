package samplePrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameDemo {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/nestedframes");
		
		driver.switchTo().frame("frame1");
		String parentString = driver.findElement(By.xpath("//body[contains(text(),'Parent frame')]")).getText();
		System.out.println(parentString);
		
		driver.switchTo().frame(0);
		String childString = driver.findElement(By.xpath("//p[contains(text(),'Child Iframe')]")).getText();
		System.out.println(childString);
		driver.switchTo().parentFrame();
		String parentString1 = driver.findElement(By.xpath("//body[contains(text(),'Parent frame')]")).getText();
		System.out.println(parentString1);
		driver.switchTo().defaultContent();
		
		String parentWindowString = driver.findElement(By.xpath("//div[contains(text(),'Nested Iframe')]")).getText();
		
		System.out.println(parentWindowString);
		

	}

}
