package Commons;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class utilis extends Commons {
	@Parameters({"url","browser"})
	  @BeforeClass
	  public void beforeclass(String url, String browser)
	  {
		  Ibrowser(browser, url);
		  log.info("brower launch process completed");
		  
	  }
	  
	  @AfterClass
	  public void Afterclass()
	  {
		 driver.close();
		 log.info("browser closed");
		  
	  }
	  @AfterMethod
	  public void aftermethod()
	  {
		  
	  }
	  @AfterTest
	  public void afterTest() {
		  extent.flush();
		  log.info("report flushed");
	  }
	  @BeforeTest
	  public void beforeTest() {
		// directory where output is to be printed
		  cofigreport();
		//extent.attachReporter(spark);
		  log.info("report started");

	  }
	public static void displayalert(WebDriver driver) throws InterruptedException
	{

		
		JavascriptExecutor je= (JavascriptExecutor)driver;
		je.executeScript("alert('Test completed')");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		log.info("Able to display an alert");
		
	}
	
	public static void WaitForElemnetPresence(By by)
	{
		 WebDriverWait wl= new WebDriverWait(driver,Duration.ofMillis(10000));
			wl.until(ExpectedConditions.presenceOfElementLocated(by));
			log.info("Able to find the presence of elemnt");
			
	}
	
	
	public static void WaitForElemnetVisibility(WebElement ele)
	{
		 WebDriverWait wl= new WebDriverWait(driver,Duration.ofMillis(0));
			wl.until(ExpectedConditions.visibilityOf(ele));
			log.info("Able to find the visibility of elemnt");
	}
	public static void scrollToPageDown(WebDriver driver)
	{
		JavascriptExecutor je= (JavascriptExecutor)driver;
		je.executeScript("window.scrollTo(1,document.body.scrollHeight)");
		log.info("Able to scrollto end of the page");
	}

	public static void blinkelement(WebDriver driver, WebElement ele)
	{
		JavascriptExecutor je=(JavascriptExecutor)driver;
		
		for(int i=0;i<50;i++)
		{
			je.executeScript("arguments[0].style.backgroundColor='rgb(255,0,0)'", ele);
			je.executeScript("arguments[0].style.backgroundColor='rgb(0,255,0)'", ele);
			
		}
		log.info("Able to blink elemnt");
	}
		public static void borderElement(WebDriver driver, WebElement ele)
		{

JavascriptExecutor je=(JavascriptExecutor)driver;
		
		je.executeScript("arguments[0].style.border='3px solid red'", ele);
		log.info("Able to add boder for the elemnt");
		}
}
