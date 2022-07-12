package lightpole.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HighPriorityImage 
{
	WebDriver driver;
	 public HighPriorityImage(WebDriver sdriver)
	  {
		  PageFactory.initElements(sdriver,this);
	  }
	  
	  
	  @FindBy(how=How.XPATH,using="//*[contains(text(),'IMAGES')]")
	  
	  WebElement ImagesTab;
	  
	  @FindBy(how=How.XPATH,using="(//*[@class='image-box '])[1]")
	 
	  WebElement ImageThumbnail;
	  
	  @FindBy(how=How.XPATH,using="(//*[@class='image-box '])[1]")
	 
	  WebElement ImageThumbnail1;
	  
	  @FindBy(how=How.XPATH,using="//*[@class='form-check-input float-end pointer ms-2']")

	  WebElement Checkbox;
	  
	  @FindBy(how=How.XPATH,using="//*[@class='btn btn-primary text-5 pointer text-center align-self-center']")

	  WebElement Download_Button;
	  
	  @FindBy(how=How.XPATH,using="//*[@class='btn btn btn-secondary']")
	
	  WebElement Close_Button;
	  
	  @FindBy(how=How.XPATH,using="(//*[@class='image-box border border-danger border-3'])[2]")
	
	  WebElement DeselectHighPImages;
	  
	  @FindBy(how=How.XPATH,using="//*[@id='filter-tabs']")
	
	  WebElement FilterTab;
	  
	  
	  
	  
	  public void ImagesTab()
	  {
		  ImagesTab.click();
	  }
	  
	  public void PoleImage()
	  {
		  ImageThumbnail.click();
	  }
	  
	  public void PoleImage1()
	  {
		  ImageThumbnail1.click();
	  }
	  
	  public void checkbox()
	  {
		  Checkbox.click();
	  }
	  
	  public void Download_Button()
	  {
		  Download_Button.click();
	  }
	
	  public void Close_Button()
	  {
		  Close_Button.click();
	  }
	  
	  public void DeselectImages()
	  {
		  DeselectHighPImages.click();
	  }
	  
	  public void FilterTab()
	  {
		  FilterTab.click();
	  }
}
