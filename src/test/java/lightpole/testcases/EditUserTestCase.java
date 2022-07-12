package lightpole.testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import lightpole.pageobjects.EditDetails;
import lightpole.pageobjects.LoginPage;
import lightpole.pageobjects.SignUpPage;

public class EditUserTestCase extends Launch
{
	@Test(priority=1)
	public void EditFirst_LastName() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver,40);
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
		WebElement FirstName=user.FirstName();
		FirstName.clear();
		Thread.sleep(2000);
		FirstName.sendKeys("Michael");
		Thread.sleep(2000);
		logger.info("First Name has been entered Successfully");
		WebElement LastName=user.LastName();
		LastName.clear();
		Thread.sleep(2000);
		LastName.sendKeys("Anderson");
		Thread.sleep(2000);
		logger.info("Last Name has been entered Successfully");
		user.Update();
		Thread.sleep(10000);
		signup.Logout();
		logger.info("Logged out of the Application");
		l.enter_email(Email);
		l.enter_password("Qwerty123456@");
		l.click();
		logger.info("Logged into the the Application");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Toggle fullscreen view']")));
		WebElement Name=driver.findElement(By.xpath("//*[@class=\"header-contex float-end pt-1 mt-2\"]"));
		String ActualName=Name.getText();
		System.out.println("Name is:"+ActualName);
		String Expected="Hello Michael";
		Assert.assertEquals(ActualName, Expected);
		logger.info("First Name and Last has been updated Successfully");
		signup.Logout();
	}
	@Test(priority=2)
	public void UpdateRole() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver,40);
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
		user.RadioButton();
		Thread.sleep(2000);
		user.Update();
		logger.info("User Role has been updated to Admin");
		Thread.sleep(8000);
		signup.Logout();
		l.enter_email(Email);
		l.enter_password("Qwerty123456@");
		l.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Toggle fullscreen view']")));
		WebElement Admin=driver.findElement(By.xpath("//*[@id='admin-dash']"));
		if(Admin.isDisplayed()==true)
		{
			logger.info("Succesfully Logged into the Application as Admin");
		}
		signup.Logout();
		logger.info("Logged out of the Application");

	}
	@Test(priority=3)
	public void DisableUser() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver,40);
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
		EventFiringWebDriver event=new EventFiringWebDriver(driver);
		event.executeScript("document.querySelector('tbody[class=\"border\"]').scrollTop=5000");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[@class][last()]/td[3]")));
		WebElement x=driver.findElement(By.xpath("//tr[@class][last()]/td[3]"));
		String Email1=x.getText();
		System.out.println("Email ID:"+Email1);
		EditDetails user=new EditDetails(driver);
		user.EditLink();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Edit User')]")));
		WebElement Disablelink=driver.findElement(By.xpath("//*[contains(text(),'Disable')]"));
		String Disableuser=Disablelink.getText();
		System.out.println("Text is:"+Disableuser);
		String Expected="Disable";
		Assert.assertEquals(Disableuser,Expected);
		user.DisableUser();
		Thread.sleep(8000);
		logger.info("User has been disabled");
		signup.Logout();
		l.enter_email(Email1);
		Thread.sleep(2000);
		l.enter_password("Qwerty123456@");
		l.click();
		WebElement EmailField=driver.findElement(By.xpath("//*[@name='email']"));
		EmailField.clear();
		Thread.sleep(2000);
		EmailField.sendKeys(Email);
		Thread.sleep(2000);
		WebElement Pwd=driver.findElement(By.xpath("//input[@placeholder='Enter Password']"));
		Pwd.clear();
		Thread.sleep(2000);
		Pwd.sendKeys(Password);
		l.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Toggle fullscreen view']")));
		signup.Admin();
		Reporter.log("Navigated to Admin Dashboard Page",true);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='btn btn-link p-0 m-0'])[1]")));
		EventFiringWebDriver event1=new EventFiringWebDriver(driver);
		event1.executeScript("document.querySelector('tbody[class=\"border\"]').scrollTop=5000");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[@class][last()]/td[3]")));
		user.EditLink();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Edit User')]")));
		user.EnableUser();
		Thread.sleep(8000);
		logger.info("User has been Enabled");
		signup.Logout();
		logger.info("Logged out of the Application");

	}
	
	@Test(priority=4)
	public void updateEmail() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver,40);
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
		EventFiringWebDriver event=new EventFiringWebDriver(driver);
		event.executeScript("document.querySelector('tbody[class=\"border\"]').scrollTop=5000");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[@class][last()]/td[3]")));
		WebElement x=driver.findElement(By.xpath("//tr[@class][last()]/td[3]"));
		String UserEmail=x.getText();
		System.out.println("Email ID:"+UserEmail);
		EditDetails user=new EditDetails(driver);
		user.EditLink();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Edit User')]")));
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
		String UpdateEmail=Temp.getAttribute("value");
		System.out.println("Email is:"+UpdateEmail);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='iconx']")).click();
		Thread.sleep(2000);
		driver.switchTo().window(WPM);
		WebElement emailclear=user.EmailField();
		emailclear.clear();
		Thread.sleep(2000);
		emailclear.sendKeys(UpdateEmail);
		Thread.sleep(2000);
		user.Update();
		Thread.sleep(8000);
		logger.info("Email ID has been updated successfully");
		signup.Logout();
		logger.info("Logged out of the Application");
		l.enter_email(UpdateEmail);
		Thread.sleep(2000);
		l.enter_password("Qwerty123456@");
		l.click();
		logger.info("Successfully logged into the application using Updated Email ID");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Toggle fullscreen view']")));
		signup.Logout();
		logger.info("Logged out of the Application");
		
	}
	
	@Test(priority=5)
	public void Deleteuser() throws Exception
	{
		WebDriverWait wait = new WebDriverWait(driver,40);
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
		EventFiringWebDriver event=new EventFiringWebDriver(driver);
		event.executeScript("document.querySelector('tbody[class=\"border\"]').scrollTop=5000");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//tr[@class][last()]/td[3]")));
		WebElement x=driver.findElement(By.xpath("//tr[@class][last()]/td[3]"));
		String UserEmail=x.getText();
		System.out.println("Email ID:"+UserEmail);
		EditDetails user=new EditDetails(driver);
		user.EditLink();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Edit User')]")));
		user.DeleteUser();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[contains(text(),'Confirm')])[1]")));
		user.ConfirmButton();
		Thread.sleep(8000);
		logger.info("User deleted successfully");
		signup.Logout();
		l.enter_email(UserEmail);
		Thread.sleep(2000);
		l.enter_password("Qwerty123456@");
		l.click();
		Thread.sleep(3000);
	}
	
	
	
}
