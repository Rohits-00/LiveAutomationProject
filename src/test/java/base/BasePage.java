package base;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;

import utility.CommonUtils;

public class BasePage {
	WebDriver driver;
	public WebDriver openBrowserAndApplication () {
		
		Properties prop = CommonUtils.loadproperties();
		String browserName=prop.getProperty("browserName");
		
			    if (browserName.equals("chrome")) {
				   driver=new ChromeDriver();
			}else if (browserName.equals("edge")) {
				driver=new EdgeDriver();
			}
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
			 driver.manage().window().maximize();
			 driver.get(prop.getProperty("appURL"));
			 return driver;
		}
   }
