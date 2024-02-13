package Commons;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Commons {
	public static Logger log= (Logger) LogManager.getLogger(Commons.class);
	public static WebDriver driver;
	public static String fp=System.getProperty("user.dir");
	public ITestResult result;
	//	public ExtentSparkReporter spark = new ExtentSparkReporter(fp+"\\Reports\\spark"+System.currentTimeMillis()+".html");
	public ExtentSparkReporter spark = new ExtentSparkReporter(fp+"\\Reports\\jenkins_extentreport.html");
		
	
	public  ExtentReports extent = new ExtentReports();
		 public ExtentTest test;
	
public void cofigreport()
{
	extent.attachReporter(spark);
	extent.setSystemInfo("Machine","testpc1");
	extent.setSystemInfo("OS", "windows");
	extent.setSystemInfo("browser", "chrome");
	extent.setSystemInfo("user", "Akshara");
	spark.config().setDocumentTitle("final report");
	spark.config().setReportName("amazone report"+System.currentTimeMillis());
	spark.config().setTheme(Theme.DARK);
}
	public static WebDriver Ibrowser(String NameOfBrowser, String url) {
		if(NameOfBrowser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			log.info("chrome browser instansitated");
		}
		else if(NameOfBrowser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
			log.info("Edge browser instansitated");
		}
			driver.manage().window().maximize();
			log.info("Browser Maximized");
			driver.manage().deleteAllCookies();
			driver.get(url);
			log.info("url launched"+url);
			return driver;
	

	}
	
	
	public static void Screenshots( String folder)
	{
		
	
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path=fp+"\\pictures\\"+folder+"\\"+System.currentTimeMillis()+".png";
		File dest= new File(path);
		log.info("screenshot captured");
		try {
			FileHandler.copy(src, dest);
			log.info("screenshot copied to destination");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
		public String CaptureScreeshot(String folder)
		{
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String path=fp+"\\pictures\\"+folder+"\\"+System.currentTimeMillis()+".png";
			File dest= new File(path);
			log.info("screenshot captured in extent report");
			try {
				FileHandler.copy(src, dest);
				log.info("screenshot copied to destination");
			
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return dest.getAbsolutePath();
			
			
		}
	
	
	
	
	
	
}
