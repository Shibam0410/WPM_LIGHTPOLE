package lightpole.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage_Viewer 
{
	WebDriver driver;
	 public LoginPage_Viewer(WebDriver sdriver)
	  {
		  PageFactory.initElements(sdriver,this);
	  }
	  
	  
	  @FindBy(how=How.XPATH,using="//input[@id='Adams Junior High']")
	 
	  WebElement School ;
	  
	  @FindBy(how=How.XPATH,using="//button[@class='download-pdf-btn btn btn-light float-end p-1 text1 mt-1']")
	
	  WebElement DownloadReport_Button ;
	  
	  @FindBy(how=How.XPATH,using="(//*[@type='checkbox'])[1]")
	  
	  WebElement LowPriority_toggle;
	  
	  @FindBy(how=How.XPATH,using="//*[@id='McMeans Junior High']")
	  
	  WebElement School1;
	  
	  @FindBy(how=How.XPATH,using="//*[@class='p-2 mt-2']")
	  
	  WebElement AllSchools;
	  
      @FindBy(how=How.XPATH,using="//*[@id='about']")
	  
	  WebElement About;
      
      @FindBy(how=How.XPATH,using="//*[@aria-label='Close']")
	  
	  WebElement CrossIcon;
      
      @FindBy(how=How.XPATH,using="//*[contains(text(),'Representative Conditions')]")
  	  
	  WebElement Representative_Conditions;
	  
	  
	  
	  
	  
	  public void selectschool()
	  {
		  School.click();
	  }
	  
	  public void DownloadReport()
	  {
		  DownloadReport_Button.click();
	  }
	  
	  public void LowPriority()
	  {
		  LowPriority_toggle.click();
	  }
	  
	  public void selectschool1()
	  {
		  School1.click();
	  }
	  
	  public void Allschool()
	  {
		  AllSchools.click();
	  }
	  
	  public void AboutLink()
	  {
		  About.click();
	  }
	  
	  public void CloseAboutwindow()
	  {
		  CrossIcon.click();
	  }
	  
	  public void Representalive_Conditionslink()
	  {
		  Representative_Conditions.click();
	  }
	  
	 
	  
}
