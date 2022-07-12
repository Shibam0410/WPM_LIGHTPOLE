package lightpole.testcases;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import lightpole.pageobjects.LoginPage;
import lightpole.utilities.Datetime;

public class TakeFullScreenshot extends Launch
{
	@Test
	public void Takescreenshot() throws Exception
	{
		LoginPage l=new LoginPage(driver);
		WebDriverWait wait = new WebDriverWait(driver,80);
		l.enter_email(Email);
		l.enter_password(Password);
		l.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@role='status']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Toggle fullscreen view']")));
		driver.findElement(By.xpath("(//*[@xmlns='http://www.w3.org/2000/svg'])[7]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@class='icons position-absolute top-0 end-0 mx-2 mt-1 border']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@title='Zoom in']")).click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@style='z-index: 3; position: absolute; height: 100%; width: 100%; padding: 0px; border-width: 0px; margin: 0px; left: 0px; top: 0px; touch-action: pan-x pan-y;']")));
		WebElement map=driver.findElement(By.xpath("//*[@style='z-index: 3; position: absolute; height: 100%; width: 100%; padding: 0px; border-width: 0px; margin: 0px; left: 0px; top: 0px; touch-action: pan-x pan-y;']"));
		File source = map.getScreenshotAs(OutputType.FILE);
		Datetime obj = new Datetime();
		String todaydate = obj.GetTodayDateAndTime();
		String dest = System.getProperty("user.dir") + "/Screenshots/" + todaydate + ".png";
		File destination = new File(dest);
		FileUtils.copyFile(source, destination);
		Reporter.log("ScreenShot Taken",true);
	}
}
