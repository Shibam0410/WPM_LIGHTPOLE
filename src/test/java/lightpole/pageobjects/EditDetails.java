package lightpole.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class EditDetails 
{
	 public EditDetails(WebDriver sdriver)
	  {
		  PageFactory.initElements(sdriver,this);
	  }
	 
	  
	  @FindBy(how=How.XPATH,using="//tr[@class][last()]/td[5]/button[contains(text(),'Edit')]")
	 
	  WebElement Edit;
	  
	  @FindBy(how=How.XPATH,using="//*[@id='recipient-fname']")
	
	  WebElement Firstname;
	  
	  @FindBy(how=How.XPATH,using="//*[@id='message-lname']")
	
	  WebElement Lastname;
	  
	  @FindBy(how=How.XPATH,using="//*[@id='btn btn-updateEdit']")
	 
	  WebElement UpdateButton;
	  
	  @FindBy(how=How.XPATH,using="//*[@value='Admin']")
	
	  WebElement AdminRadioButton;
	  
	  @FindBy(how=How.XPATH,using="//*[@value='Viewer']")
	
	  WebElement ViewerRadioButton;
	  
	  @FindBy(how=How.XPATH,using="//*[@value='Maintainer']")
		
	  WebElement MaintainerRadioButton;
	  
	  @FindBy(how=How.XPATH,using="//*[contains(text(),'Disable')]")

	  WebElement Disable;
	  
	  @FindBy(how=How.XPATH,using="//*[contains(text(),'Enable')]")
	 
	  WebElement Enable;
	  
	  @FindBy(how=How.XPATH,using="//*[@id='email']")
	  WebElement EmailField;
	  
	  @FindBy(how=How.XPATH,using="//*[contains(text(),'Delete')]")
	  
	  WebElement DeleteUser;
	  
	  @FindBy(how=How.XPATH,using="(//*[contains(text(),'Confirm')])[2]")
	
	  WebElement ConfirmButton;
	   
	  
	  
	  public void EditLink()
	  {
		 Edit.click();
	  }
	  
	  public WebElement FirstName()
	  {
		  WebElement FirstName=Firstname;
		  return FirstName;
	  }
	  
	  public WebElement LastName()
	  {
		  WebElement LastName=Lastname;
		  return LastName;
	  }
	  
	  public void Update()
	  {
		  UpdateButton.click();
	  }
	  
	  public void RadioButton()
	  {
		  AdminRadioButton.click();
	  }
	  public void RadioButton1()
	  {
		  MaintainerRadioButton.click();
	  }
	  
	  public void DisableUser()
	  {
		  Disable.click();
	  }
	  
	  public WebElement EmailField()
	  {
		  WebElement EmailF=EmailField;
		  return EmailF;
	  }
	  public void EnableUser()
	  {
		  Enable.click();
	  }
	  
	  public void DeleteUser()
	  {
		  DeleteUser.click();
	  }
	  
	  public void ConfirmButton()
	  {
		  ConfirmButton.click();
	  }
	  
	  
}
