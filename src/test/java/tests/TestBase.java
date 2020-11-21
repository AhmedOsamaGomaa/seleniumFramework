package tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utilities.Helper;

public class TestBase{

	public static WebDriver driver;

	@BeforeSuite
	@Parameters(("browser"))
	public static void startDriver(@Optional("chrome") String browserName){

		if(browserName.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}

		else if(browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else if(browserName.equalsIgnoreCase("edge")){
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/Drivers/msedgedriver.exe");
			driver = new EdgeDriver();
		}

		//Headless browser testing
		else if(browserName.equalsIgnoreCase("headless")){
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setJavascriptEnabled(true);
			capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, 
					System.getProperty("user.dir") + "/Drivers/phantomjs.exe");
			String [] phantomJsArgs = {"--web-security=no","--ignore-ssl-errors=yes"};
			capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomJsArgs);
			driver = new PhantomJSDriver(capabilities);
		}

		else if(browserName.equalsIgnoreCase("chrome-headless")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--window-size=1920,1080");
			driver = new ChromeDriver(options);
		}

		//Maximize Chrome window
		driver.manage().window().maximize();
		//chromeDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.navigate().to("http://138.68.58.187/login");
		//timeOut after certain loadingTime
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void cleanUp(){

		driver.manage().deleteAllCookies();
	}

	//Take screenshot when test case fails and add it in the "Screenshots" folder
	@AfterMethod
	public void screenshotOnFailure(ITestResult result){

		if(result.getStatus() == ITestResult.FAILURE){
			System.out.println("Failed!");
			System.out.println("Taking screenshot....");
			Helper.captureScreenshot(driver, result.getName());
		}
	}

	@AfterSuite
	public void stopDriver(){

		driver.quit();
	}
}