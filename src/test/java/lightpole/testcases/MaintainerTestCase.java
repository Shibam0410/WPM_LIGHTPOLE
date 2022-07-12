package lightpole.testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import lightpole.pageobjects.EditDetails;
import lightpole.pageobjects.LoginPage;
import lightpole.pageobjects.MaintainerDetails;
import lightpole.pageobjects.SignUpPage;

public class MaintainerTestCase extends Launch
{
	@Test(priority=1)
	public void MaintainerUser() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver,4000);
		Actions a=new Actions(driver);
		LoginPage l=new LoginPage(driver);
		l.enter_email(Email);
		l.enter_password(Password);
		l.click();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@role='status']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Toggle fullscreen view']")));
		SignUpPage signup=new SignUpPage(driver);
		signup.Admin();
		logger.info("Navigated to Admin Dashboard Page");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='btn btn-link p-0 m-0'])[1]")));
		((JavascriptExecutor)driver).executeScript("window.open()");
		Set<String> handles=driver.getWindowHandles();
		List<String> ls= new ArrayList<String>(handles);
		int count=handles.size();
		System.out.println("Total Count:"+count);
		String WPM=ls.get(0);
		String Mail=ls.get(1);
		System.out.println("WPM key is:"+WPM);
		System.out.println("Mail key is:"+Mail);
		driver.switchTo().window(Mail);
		driver.get(Tempmail);
		Thread.sleep(5000);
		WebElement Temp=signup.TempEmail();
		String c=Temp.getAttribute("value");
		System.out.println("Email is:"+c);
		driver.findElement(By.xpath("//button[@class='iconx']")).click();
		Thread.sleep(2000);
		driver.switchTo().window(WPM);
		signup.InviteButton();
		signup.Firstname();
		signup.Lastname();
		WebElement EmailField=signup.Email();
		EmailField.sendKeys(c);
		signup.SendInvite();
		logger.info("Invitation Sent Successfully");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@role='status']")));
		EventFiringWebDriver event=new EventFiringWebDriver(driver);
		event.executeScript("document.querySelector('tbody[class=\"border\"]').scrollTop=5000");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[@class][last()]/td[3]")));
		WebElement x=driver.findElement(By.xpath("//tr[@class][last()]/td[3]"));
		String Email=x.getText();
		System.out.println("Email ID entered is:"+Email);
		EditDetails user=new EditDetails(driver);
		user.EditLink();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Edit User')]")));
		user.RadioButton1();
		Thread.sleep(2000);
		user.Update();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[contains(text(),'User updated successfully')]")));
		Thread.sleep(2000);
		driver.close();
		driver.switchTo().window(Mail);
		WebElement Inbox=driver.findElement(By.xpath("//div[@class='inbox-header']/p"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",Inbox);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Welcome to the Katy ISD Light Pole Web Portal') and @class='mail-item-sub']")));
		WebElement MailClick=driver.findElement(By.xpath("\r\n"
				+ "//div[contains(text(),'Welcome to the Katy ISD Light Pole Web Portal') and @class='mail-item-sub']"));
		a.moveToElement(MailClick).click().perform();
		Thread.sleep(3000);
		String parent=driver.getWindowHandle();
		System.out.println("Parent1 Title is:"+driver.getTitle());
		System.out.println("Key is:"+parent);
		Screen s1 = new Screen();
		Pattern Invite = new Pattern(".\\Images\\" + "Invite Button.PNG");
		s1.click(Invite);
		Set<String> handles1=driver.getWindowHandles();
		int count1=handles1.size();
		System.out.println("Total Count of all the tabs:"+count1);
		Thread.sleep(3000);
		for(String Handle2:handles1)
		{
			if(!Handle2.equals(parent))
			{
				driver.switchTo().window(Handle2);
				System.out.println("Child Title is:"+driver.getTitle());
				System.out.println("Key is:"+Handle2);
				Thread.sleep(3000);
				signup.ConfirmPassword();
				Thread.sleep(3000);
				signup.RetypePassword();
				Thread.sleep(3000);
				signup.SignUpButton();
				logger.info("Signup Successfully");
				Thread.sleep(3000);
			}

		}
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Toggle fullscreen view']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='dismissButton']")));
		driver.findElement(By.xpath("//button[@class='dismissButton']")).click();
		WebElement AdamSchool=driver.findElement(By.xpath("(//img[@src='https://maps.gstatic.com/mapfiles/transparent.png'])[24]"));
		Thread.sleep(3000);
		a.moveToElement(AdamSchool).click().perform();
		Thread.sleep(3000);
		WebElement Pole21=driver.findElement(By.xpath("(//img[@src='https://maps.gstatic.com/mapfiles/transparent.png'])[32]"));
		a.moveToElement(Pole21).click().perform();
		Thread.sleep(6000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'P21')])[1]")));
		MaintainerDetails m=new MaintainerDetails(driver);
		m.FixIssue();
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@role='status']")));
		WebElement Information_icon=driver.findElement(By.xpath("(//*[@class='info-icon m-1 ms-2'])[1]"));
		a.moveToElement(Information_icon).build().perform();
		Thread.sleep(3000);
		if(Information_icon.isDisplayed()==true)
		{
			logger.info("This issue has been repaired");
		}
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@value='0']")));
		String Expected="0";
		String Actual=driver.findElement(By.xpath("//*[@value='0']")).getAttribute("value");
		System.out.println("The Value is:"+Actual);
		Assert.assertEquals(Actual, Expected);
		logger.info("The Pole Count has been successfully updated under Pole Marker");
		m.Filtertab();
		logger.info("Navigated to Filter Tab");
		Thread.sleep(2000);
		m.RefreshMap();
		logger.info("Refreshed the Map");
		Thread.sleep(3000);
		WebElement AdamSchool1=driver.findElement(By.xpath("(//img[@src='https://maps.gstatic.com/mapfiles/transparent.png'])[24]"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@src='https://maps.gstatic.com/mapfiles/transparent.png'])[24]")));
		a.moveToElement(AdamSchool1).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='circle p-2 border border-dark text-white bg-danger text-center']")));
		String Expected1="0";
		String Actual1=driver.findElement(By.xpath("//*[@class='circle p-2 border border-dark text-white bg-danger text-center']")).getText();
		System.out.println("The Value is:"+Actual1);
		Assert.assertEquals(Actual1, Expected1);
		logger.info("The Issue Count has been successfully updated under School Marker");	
		Thread.sleep(2000);

	}
	@Test(priority=2)
	public void ReopenFixIssue() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver,4000);
		WebElement AdamSchool1=driver.findElement(By.xpath("(//img[@src='https://maps.gstatic.com/mapfiles/transparent.png'])[24]"));
		Actions a=new Actions(driver);
		a.click(AdamSchool1).build().perform();
		Thread.sleep(4000);
		logger.info("Poles are getting displayed");
		WebElement Pole21=driver.findElement(By.xpath("(//img[@src='https://maps.gstatic.com/mapfiles/transparent.png'])[27]"));
		a.moveToElement(Pole21).click().perform();
		Thread.sleep(6000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'P21')])[1]")));
		logger.info("Navigated to Information Tab");
		MaintainerDetails m=new MaintainerDetails(driver);
		m.FixIssue();
		Thread.sleep(2000);
		m.ReopenFixissue();
		logger.info("Issue has been Reopend");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@role='status']")));
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@value='1'])[2]")));
		String Expected="1";
		String Actual=driver.findElement(By.xpath("(//*[@value='1'])[2]")).getAttribute("value");
		System.out.println("The Value is:"+Actual);
		Assert.assertEquals(Actual, Expected);
		logger.info("The Pole Count has been successfully updated under Pole Marker");
		m.Filtertab();
		logger.info("Navigated to Filter Tab");
		Thread.sleep(2000);
		m.RefreshMap();
		logger.info("Refreshed the Map");
		Thread.sleep(3000);
		WebElement AdamSchool01=driver.findElement(By.xpath("(//img[@src='https://maps.gstatic.com/mapfiles/transparent.png'])[24]"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//img[@src='https://maps.gstatic.com/mapfiles/transparent.png'])[24]")));
		a.moveToElement(AdamSchool01).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='circle p-2 border border-dark text-white bg-danger text-center']")));
		String Expected1="1";
		String Actual1=driver.findElement(By.xpath("//*[@class='circle p-2 border border-dark text-white bg-danger text-center']")).getText();
		System.out.println("The Value is:"+Actual1);
		Assert.assertEquals(Actual1, Expected1);
		logger.info("The Issue Count has been successfully updated under School Marker");	
		Thread.sleep(2000);

	}


}

