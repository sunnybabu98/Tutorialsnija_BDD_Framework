package base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public Properties prop;
	WebDriver driver;
	public WebDriver openBrowserApplicationurl(String browserName) {
		
		 prop = new Properties();
		File propFile = new File("src\\test\\resourcess\\data.properties");
		try {
		FileInputStream fis = new FileInputStream(propFile);
		prop.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		if(browserName.equalsIgnoreCase("chrome")) {
			 WebDriverManager.chromedriver().setup();
			 WebDriver driver = new ChromeDriver(); // or FirefoxDriver, etc.
			 this.driver = driver;

			    
		}else if(browserName.equalsIgnoreCase("firefox")) {
			 WebDriverManager.chromedriver().setup();
			    WebDriver  driver = new FirefoxDriver();
			    this.driver = driver;

		}else if(browserName.equalsIgnoreCase("edge")) {
			
			 WebDriverManager.chromedriver().setup();
			    WebDriver  driver = new EdgeDriver();
			    this.driver = driver;
		}
		 driver.manage().window().maximize();
		    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    
		    driver.get(prop.getProperty("url"));
		
		return driver;
	}

}
