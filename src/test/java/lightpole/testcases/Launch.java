package lightpole.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


import io.github.bonigarcia.wdm.WebDriverManager;
import lightpole.utilities.Datetime;
import lightpole.utilities.Readconfig;

public class Launch
{
	Readconfig readconfig=new Readconfig();
	public String URL=readconfig.getDevUrl();
	public String Email=readconfig.Email();
	public String Password=readconfig.Password();
	public String Tempmail=readconfig.TempMail();
	public String Viewer_Email=readconfig.Viewer_Email();
	public String Viewer_Password=readconfig.Viewer_Password();
	public String QA_RL=readconfig.QAUrl();
	public String Viewer_EmailQA=readconfig.Viewer_EmailQA();
	public String Viewer_PasswordQA=readconfig.Viewer_PasswordQA();
	
	public  WebDriver driver;
	public Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void LaunchApplication(String br) throws Exception, IOException
	{
		logger=Logger.getLogger("WPMLightPoleApplication");
		PropertyConfigurator.configure("Log4j.properties");
		
		 
		if(br.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(URL);
			logger.info("URL is opened");
		}
        
		else if(br.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			driver.manage().window().maximize();
			driver.get(URL);
			logger.info("URL is opened");
		}
				

	}

	@AfterClass
	public void Quit()
	{
		driver.quit();
	}
	
	public void CaptureScreenshots(String tname) throws Exception
	{
		    Datetime obj = new Datetime();
			String todaydate = obj.GetTodayDateAndTime();
			String dest = System.getProperty("user.dir") + "/Screenshots/" +  tname + " "+ todaydate + ".png";
			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File destination = new File(dest);
			FileUtils.copyFile(source, destination);
			Reporter.log("ScreenShot Taken for Failed Test Case",true);
			logger.info("Screenshot Taken for Failed Test Case");
	}
	
		  
}
