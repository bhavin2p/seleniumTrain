package hexaWare;

import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CssColor {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.tutorialspoint.com/index.htm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		String colr = driver.findElement(By.xpath("//h2[text()=' Latest Technologies']")).getCssValue("color");

		String bckgclr = driver.findElement(By.xpath("//h2[text()=' Latest Technologies']")).getCssValue("background-color");
		
		System.out.println(colr);
		System.out.println(bckgclr);
		driver.close();
	}

}
