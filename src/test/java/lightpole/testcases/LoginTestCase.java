package lightpole.testcases;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import lightpole.pageobjects.LoginPage;

public class LoginTestCase extends Launch
{
	@Test()
	public void logintest() throws Exception
	{
		LoginPage l=new LoginPage(driver);
		WebDriverWait wait = new WebDriverWait(driver,80);
		l.enter_email(Email);
		logger.info("Entered the Email ID");
		l.enter_password(Password);
		logger.info("Entered Password");
		l.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@role='status']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Toggle fullscreen view']")));
		logger.info("Login Successfully");
	}
	
	@AfterMethod
	public void Takescreenshot(ITestResult result) throws Exception
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			CaptureScreenshots(result.getName());
		}
	}
}
