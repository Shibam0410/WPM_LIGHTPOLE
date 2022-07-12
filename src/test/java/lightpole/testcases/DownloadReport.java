package lightpole.testcases;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import lightpole.pageobjects.LoginPage;
import lightpole.pageobjects.LoginPage_Viewer;

public class DownloadReport extends Launch
{
	@Test(priority=1)
	public void ReportDownload() throws Exception
	{
		LoginPage l=new LoginPage(driver);
		l.enter_email(Viewer_Email);
		logger.info("Entered the Email ID");
		l.enter_password(Viewer_Password);
		logger.info("Entered the Password");
		l.click();
		WebDriverWait wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@role='status']")));
		LoginPage_Viewer l1=new LoginPage_Viewer(driver);
		logger.info("Login Successfully");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Toggle fullscreen view']")));
		driver.findElement(By.xpath("//button[@class='dismissButton']")).click();
		l1.selectschool();
		Thread.sleep(2000);
		l1.DownloadReport();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@role='status']")));
		logger.info("Report Downloaded Successfully using Download button");
		Thread.sleep(2000);
		Actions actions=new Actions(driver);
		WebElement x= driver.findElement(By.xpath("(//img[@src='https://maps.gstatic.com/mapfiles/transparent.png'])[24]"));
		actions.moveToElement(x).build().perform();
		Thread.sleep(2000);
		WebElement f=driver.findElement(By.xpath("//*[@class='footer-btn mt-1 pointer']"));
		if(f.isDisplayed()==true)
		{
			actions.moveToElement(f).click().perform();
		}
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@role='status']")));
		logger.info("Report Downloaded Successfully by clicking on the Download icon under School Marker");
		Thread.sleep(2000);
	}
	@Test(priority=3)
	public void DownloadReport_Priority() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver,80);
		LoginPage_Viewer l1=new LoginPage_Viewer(driver);
		WebElement AdamJuniorHigh_School=driver.findElement(By.xpath("(//img[@src='https://maps.gstatic.com/mapfiles/transparent.png'])[29]"));
		Thread.sleep(3000);
		Actions actions=new Actions(driver);
		actions.moveToElement( AdamJuniorHigh_School).click().perform();
		Thread.sleep(3000);
		l1.LowPriority();
		logger.info("Successfully disabled the low priority filters");
		Thread.sleep(3000);
		l1.selectschool1();
		Thread.sleep(2000);
		l1.DownloadReport();
		logger.info("Report Downloaded Successfully after applying filter");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@role='status']")));
		Thread.sleep(2000);
	}
	
	@Test(priority=5)
	public void DownloadReport_Allschool() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver,120);
		LoginPage_Viewer l1=new LoginPage_Viewer(driver);
		l1.Allschool();
		Thread.sleep(2000);
		l1.DownloadReport();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@role='status']")));
		logger.info("Report for all the Schools Downloaded Successfully");
		Thread.sleep(3000);
	}
	
	@Test(priority=2)
	public void About_Link() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver,50);
		LoginPage_Viewer l1=new LoginPage_Viewer(driver);
		l1.AboutLink();
		logger.info("About Link is clicked");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),' Light pole Asset Management Portal (LAMP) v1.0')]")));
		Thread.sleep(2000);	
		l1.CloseAboutwindow();
		logger.info("About Link Popup window has been closed successfully");
		Thread.sleep(2000);		
	}
	
	@Test(priority=4)
	public void Representative_Condition() throws Exception
	{
		LoginPage_Viewer l1=new LoginPage_Viewer(driver);
		l1.Representalive_Conditionslink();
		logger.info("Representative_Condition Link is clicked");
		Set<String> handles=driver.getWindowHandles();
		List<String> ls= new ArrayList<String>(handles);
		String PoleInformation_Dashboard=ls.get(0);
		String Basic_Report=ls.get(1);
		driver.switchTo().window(Basic_Report);
		logger.info("Switched to Basic Report page");
		Thread.sleep(85000);
		driver.close();
		driver.switchTo().window(PoleInformation_Dashboard);
		logger.info("Switched back to PoleInformation Page");
	}
	
}
