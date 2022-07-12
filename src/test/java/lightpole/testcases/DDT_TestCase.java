package lightpole.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import lightpole.pageobjects.LoginPage;
import lightpole.utilities.ExcelFile;

public class DDT_TestCase extends Launch
{
	@Test(dataProvider="LoginData")
	public void loginDDT(String user,String pwd) throws InterruptedException
	{
		LoginPage l=new LoginPage(driver);
		WebDriverWait wait = new WebDriverWait(driver,30);
		l.enter_email(user);
		l.enter_password(pwd);
		l.click();
		if(isAlertPresent()==true)
		{
			WebElement EmailField=driver.findElement(By.xpath("//*[@name='email']"));
			EmailField.clear();
			Thread.sleep(2000);
			WebElement Pwd=driver.findElement(By.xpath("//input[@placeholder='Enter Password']"));
			Pwd.clear();
			Thread.sleep(2000);
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@role='status']")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@title='Toggle fullscreen view']")));
			Reporter.log("Login Successful",true); 
		    l.logout1();
			Thread.sleep(3000);
			
		}
		
	}
	public boolean isAlertPresent() 
	{
		try
		{
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='Toastify__toast Toastify__toast-theme--light Toastify__toast--error']")));
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}
	
	
	@AfterMethod
	public void Takescreenshot(ITestResult result) throws Exception
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			CaptureScreenshots(result.getName());
		}
	}
	
		
	
	
	
	
	@DataProvider(name="LoginData")
	String [][] getData() throws Exception
	{
		String path=System.getProperty("user.dir") + "/src/test/java/lightpole/testdata/DataDrivenTesting.xlsx";
		
		int rownum=ExcelFile.getRowCount(path, "Sheet1");
		int colcount=ExcelFile.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=ExcelFile.getCellData(path,"Sheet1", i,j);
			}
				
		}
	return logindata;
	}
}
