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
import org.testng.Reporter;
import org.testng.annotations.Test;

import lightpole.pageobjects.LoginPage;
import lightpole.pageobjects.SignUpPage;

public class SignUp_ForgotPassword_TestCase extends Launch
{

	@Test(priority=1)
	public void Signup() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver,40);
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
		Thread.sleep(2500);
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


	}

	@Test(priority=2)
	public void ForgotPassword() throws Exception
	{
		SignUpPage signup=new SignUpPage(driver);
		LoginPage l=new LoginPage(driver);
		WebDriverWait wait = new WebDriverWait(driver,90);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@role='status']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Toggle fullscreen view']")));
		signup.Logout();
		l.enter_email(Email);
		l.enter_password(Password);
		l.click();
		logger.info("Sucessfully Logged into the Application using Admin credentials ");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Toggle fullscreen view']")));
		signup.Admin();
		logger.info("Navigated to User Page ");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='btn btn-link p-0 m-0'])[1]")));
		EventFiringWebDriver event=new EventFiringWebDriver(driver);
		event.executeScript("document.querySelector('tbody[class=\"border\"]').scrollTop=5000");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[@class][last()]/td[3]")));
		WebElement x=driver.findElement(By.xpath("//tr[@class][last()]/td[3]"));
		String Email=x.getText();
		System.out.println("Email ID:"+Email);
		logger.info("Email ID successfully extracted from UserList Table");
		signup.Logout();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='resetpwd']")));
		signup.ForgotPassword();
		WebElement Temp1=signup.Email1();
		Temp1.sendKeys(Email);
		signup.Submit();
		logger.info("Succesfully send the Reset Password link ");
		Set<String> handles1=driver.getWindowHandles();
		int count1=handles1.size();
		System.out.println("Total Count of all the tabs:"+count1);
		Thread.sleep(3000);
		String parent=driver.getWindowHandle();
		System.out.println("Page Title before switch is:"+driver.getTitle());
		driver.close();


		for(String Handle2:handles1)
		{
			if(!Handle2.equals(parent))
			{
				driver.switchTo().window(Handle2);
				System.out.println("Page Title after switch is:"+driver.getTitle());
				System.out.println("Key is:"+Handle2);
				wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'LAMP-Reset Password')]")));
				signup.ResetPasswordLink();
				Screen s1 = new Screen();
				Pattern ResetButton = new Pattern(".\\Images\\" + "Reset Password.PNG");
				s1.click(ResetButton);
				logger.info("Succesfully Navigated to Reset Password page ");
			}

		}
		Set<String> handles=driver.getWindowHandles();
		List<String> ls= new ArrayList<String>(handles);
		int count=handles.size();
		System.out.println("Total Count:"+count);
		String Mail=ls.get(0);
		String ResetPassword=ls.get(1);
		System.out.println("Page Title before switch is:"+driver.getTitle());
		System.out.println("Mail Page key is:"+Mail);
		System.out.println("ResetPassword key is:"+ResetPassword);
		driver.switchTo().window(ResetPassword);
		System.out.println("Page Title after switch is:"+driver.getTitle());
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//*[contains(text(),' Reset Password ')])[1]")));
		signup.ConfirmResetPassword();
		Thread.sleep(2000);
		signup.ConfirmRetypePassword();
		Thread.sleep(2000);
		signup.ResetButton();
		logger.info("Password Reset successfully ");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@class='title text-center']")));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@name='email']")));
		LoginPage login=new LoginPage(driver);
		login.enter_email(Email);
		Thread.sleep(2000);
		login.enter_password("Qwerty123456@");
		Thread.sleep(2000);
		login.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Toggle fullscreen view']")));
		logger.info("Successfully logged into the application using updated password");

	}


}

