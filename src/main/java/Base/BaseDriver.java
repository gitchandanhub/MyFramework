package Base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.sfmc.utility.AllWaits;

public class BaseDriver 
{
   public static WebDriver driver = null;
   public static Properties config = new Properties();
   public static Properties object = new Properties();
   public static Logger log=Logger.getLogger("devpinoyLogger");
   @BeforeTest
   public  void launch() throws Exception
   {
	   FileInputStream fis = new FileInputStream("D:\\Selenium\\new eclipse may 2020-workspace\\MyFramework\\src\\main\\java\\com\\sfmc\\properties\\config.properties");
       config.load(fis);
       FileInputStream objectfis = new FileInputStream("D:\\Selenium\\new eclipse may 2020-workspace\\MyFramework\\src\\main\\java\\com\\sfmc\\properties\\object.properties");
       object.load(objectfis);
       if(config.getProperty("Browser").equalsIgnoreCase("Chrome"))
       {
    	   System.setProperty("webdriver.chrome.driver", config.getProperty("Chromepath"));
    	   driver = new ChromeDriver();
       }
       else  if(config.getProperty("Browser").equalsIgnoreCase("Firefox"))
       {
    	   System.setProperty("webdriver.gecko.driver", config.getProperty("Firefoxpath"));
    	   driver = new FirefoxDriver();
       }
       else  if(config.getProperty("Browser").equalsIgnoreCase("InternetExplorer"))
       {
    	   System.setProperty("webdriver.internetExplorer.driver", config.getProperty("InternetExplorerpath"));
    	   driver = new InternetExplorerDriver();
       }
       /*driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(AllWaits.Implicitwait, TimeUnit.SECONDS);
       driver.navigate().to(config.getProperty("Url"));*/
   }
   
   @AfterTest
   public void closeApp()
   {
	   driver.close();
   }
   
}
