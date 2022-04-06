package hexaWare;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenImages {

	public static void main(String[] args) throws Exception {
		verifyBrokenImage();

	}
	
	public static void verifyBrokenImage() throws Exception {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://www.theworldsworstwebsiteever.com/");
		driver.get("https://www.amazon.in/");
		List<WebElement> images =  driver.findElements(By.tagName("a"));
		System.out.println(images.size());
		
		for(WebElement image : images) {
			String imageSrc = image.getAttribute("href");
			
			HttpsURLConnection httpsURLConnection;
			try {
				URL url = new URL(imageSrc);
				URLConnection urlConnection = url.openConnection();
				httpsURLConnection = (HttpsURLConnection) urlConnection;
				httpsURLConnection.setConnectTimeout(5000);
				httpsURLConnection.connect();
				if(httpsURLConnection.getResponseCode() == 200) {
					System.out.println(imageSrc + " >> " + httpsURLConnection.getResponseCode() + " >> " +httpsURLConnection.getResponseMessage());
				}
				else {
					//System.err.println(imageSrc + " >> " + httpsURLConnection.getResponseCode() + " >> " +httpsURLConnection.getResponseMessage());
					WriteExcel(imageSrc + " >> " + httpsURLConnection.getResponseCode() + " >> " +httpsURLConnection.getResponseMessage());
					httpsURLConnection.setConnectTimeout(5000);
				}
				
				httpsURLConnection.disconnect();
			} 
			catch (Exception e) {
				System.err.println(imageSrc);
				WriteExcel(imageSrc);
			} 
		}
		driver.quit();
	}
	
	public static void WriteExcel(String brokenImg) throws Exception {
		
		File file = new File("C:\\Users\\bhpanchal\\OneDrive - MMI HOLDINGS LTD\\Documents\\Workspace\\SeleniumTrain\\ExcelFile\\Test.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		for(int i=0; i<=100; i++) {
			sheet.getRow(0).createCell(i).setCellValue(brokenImg);
		}
		FileOutputStream fos = new FileOutputStream(file);
		workbook.write(fos);
		workbook.close();
		
	}

}
