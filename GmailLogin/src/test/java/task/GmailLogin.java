package task;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GmailLogin extends ExcelData {
	
	
	
	

	public static WebDriver driver =null;

	@Parameters("browserName")
	@BeforeTest
	public void setup(String browserName) {

		if(browserName.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("Edge")) {

			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else {

			System.out.println("Enter Valid Browser Name");
		}
		
	}


		@Test
		public void login() throws InterruptedException, IOException {
			
			List<LoginDetails> excel_data = ExcelData.readData();
			
			driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
			
			for (LoginDetails loginDetails : excel_data) {
				
			System.out.println(loginDetails);
				
			//		driver.findElement(By.xpath("")).sendKeys("");

			driver.findElement(By.xpath("//input[@name=\"identifier\"]")).sendKeys(loginDetails.getUsername());
			Thread.sleep(4000);
			driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
			Thread.sleep(4000);


			driver.findElement(By.xpath("//input[@name='password']")).sendKeys(loginDetails.getPassword());
			Thread.sleep(4000);
			driver.findElement(By.xpath("//span[contains(text(),'Next')]")).click();
			Thread.sleep(4000);
			
			}
			
		}
		
		
		
	}
