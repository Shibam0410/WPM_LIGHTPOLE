package lightpole.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Reporter;
import org.testng.annotations.Test;

import lightpole.pageobjects.HighPriorityImage;
import lightpole.pageobjects.LoginPage;
import lightpole.pageobjects.LoginPage_Viewer;

public class HighPriorityTestCase extends Launch
{
	@Test(priority=1)
	public void SetHighPriorityimages() throws Exception
	{
		LoginPage l=new LoginPage(driver);
		l.enter_email(Email);
		l.enter_password(Password);
		l.click();
		logger.info("Login Successful as Viewer");
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@role='status']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Toggle fullscreen view']")));
		driver.findElement(By.xpath("//button[@class='dismissButton']")).click();
		HighPriorityImage high=new HighPriorityImage(driver);
		WebElement AdamSchool=driver.findElement(By.xpath("(//img[@src='https://maps.gstatic.com/mapfiles/transparent.png'])[24]"));
		Thread.sleep(3000);
		Actions actions=new Actions(driver);
		actions.moveToElement(AdamSchool).click().perform();
		Thread.sleep(3000);
		WebElement Poles=driver.findElement(By.xpath("(//img[@src='https://maps.gstatic.com/mapfiles/transparent.png'])[32]"));
		actions.moveToElement(Poles).click().perform();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@role='status']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'P21')])[1]")));
		high.ImagesTab();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@role='status']")));
		high.PoleImage();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='form-check-input float-end pointer ms-2']")));
		high.checkbox();
		logger.info("Successfully Marked the 1st Image");
		Thread.sleep(3000);
		/*JavascriptExecutor js = (JavascriptExecutor) driver;		
		js.executeScript("window.scrollBy(0,-2000)");*/
		high.Close_Button();
		Thread.sleep(3000);
		logger.info("Successfully closed the Image Popup Modal Window");
		Thread.sleep(3000);
		high.PoleImage1();
		//js.executeScript("window.scrollBy(0,-2000)");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='form-check-input float-end pointer ms-2']")));
		high.checkbox();
		logger.info("Successfully Marked the 2nd Image");
		Thread.sleep(3000);
		high.Close_Button();
		Thread.sleep(3000);
		logger.info("Successfully closed the Image Popup Modal Window");

	}
	@Test(priority=2)
	public void DeselectHighPriorityImages() throws Exception
	{
		HighPriorityImage high=new HighPriorityImage(driver);
		WebDriverWait wait = new WebDriverWait(driver,50);
		//JavascriptExecutor js = (JavascriptExecutor) driver;		
		//js.executeScript("window.scrollBy(0,-2000)");
		high.DeselectImages();
		Thread.sleep(3000);
		high.checkbox();
		Thread.sleep(3000);
		logger.info("Successfully Deselected the Marked Image");
		high.Download_Button();
		Thread.sleep(3000);
		logger.info("Successfully Downloaded the Pole Image");
	    Thread.sleep(3000);
		high.Close_Button();
		Thread.sleep(3000);
	    logger.info("Successfully closed the Image Popup Modal Window");
		high.FilterTab();
		Thread.sleep(3000);
		logger.info("Successfully Navigated to the Filter Tab");
		LoginPage_Viewer x=new LoginPage_Viewer(driver);
		x.selectschool();
		Thread.sleep(3000);
		x.DownloadReport();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@role='status']")));
		Thread.sleep(3000);
		logger.info("Successfully Downloaded the Report");
		
	}



}



