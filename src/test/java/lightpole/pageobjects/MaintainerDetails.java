package lightpole.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MaintainerDetails 
{
	 public MaintainerDetails(WebDriver sdriver)
	  {
		  PageFactory.initElements(sdriver,this);
	  }
	 
	  @FindBy(how=How.XPATH,using="(//*[@type='checkbox'])[1]")
		
	  WebElement toggle_on ;
	  
	  @FindBy(how=How.XPATH,using="//*[@id='filter-tabs']")
		
	  WebElement FilterTab ;
	  
	  @FindBy(how=How.XPATH,using="//*[@title='Refresh Map']")
		
	  WebElement Refresh ;
	  
	  @FindBy(how=How.XPATH,using="//*[@class='btn btn-primary']")
		
	  WebElement YesButton ;
	  
	  
	  
	  
	  
	  public void FixIssue()
	  {
		  toggle_on.click();
	  }
	  public void Filtertab()
	  {
		  FilterTab.click();
	  }
	  public void RefreshMap()
	  {
		  Refresh.click();
	  }
	  
	  public void ReopenFixissue()
	  {
		  YesButton.click();
	  }
	   
}
