package openBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumFirstTest {

	/*
	public WebDriver driver = null;
	public void selectBrowser(String browser) {
		if(browser.equals("Chrome")) {
			driver = new ChromeDriver();
			driver.get("");
		}
		else if(browser.equals("Firefox")) {
			driver = new FirefoxDriver();
		}
	} */
	public static void main(String[] args) {
		
		//System.setProperty("webdriver.chrome.driver", "path//chromedriver.exe");
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com");
		
		//locators
		
		//WebElement
		//findElement
		//findElements
		//implicitWait and ExplicitWait
		
		
	}

}
