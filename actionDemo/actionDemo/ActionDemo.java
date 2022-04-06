package actionDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionDemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/sortable");
		
		WebElement oneElement = driver.findElement(By.xpath("//div[@id='demo-tabpane-list']//div[contains(text(),'One')]"));
		WebElement twoElement = driver.findElement(By.xpath("//div[@id='demo-tabpane-list']//div[contains(text(),'Two')]"));
		WebElement sixElement = driver.findElement(By.xpath("//div[@id='demo-tabpane-list']//div[contains(text(),'Six')]"));
		WebElement threeElement = driver.findElement(By.xpath("//div[@id='demo-tabpane-list']//div[contains(text(),'Three')]"));
		WebElement fourElement = driver.findElement(By.xpath("//div[@id='demo-tabpane-list']//div[contains(text(),'Four')]"));
		WebElement fiveElement = driver.findElement(By.xpath("//div[@id='demo-tabpane-list']//div[contains(text(),'Five')]"));
				
		
		Actions actions = new Actions(driver);
		actions.dragAndDrop(oneElement, sixElement).dragAndDrop(twoElement, sixElement).dragAndDrop(threeElement, sixElement).
		dragAndDrop(fourElement, sixElement).dragAndDrop(fiveElement, sixElement).build().perform();

		
		
		

	}

}
