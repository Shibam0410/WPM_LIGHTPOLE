package lightpole.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
  WebDriver driver;
 public LoginPage(WebDriver sdriver)
  {
	  PageFactory.initElements(sdriver,this);
  }
  
  @FindBy(how=How.XPATH,using="//*[@name='email']")
  WebElement Email;
  
  @FindBy(how=How.XPATH,using="//input[@placeholder='Enter Password']")
  WebElement Password;
  
  @FindBy(how=How.XPATH,using="//button[@type='submit']")
  
  WebElement Login_Button;
  
  @FindBy(how=How.XPATH,using="//a[@id='logout']")

  WebElement Logout_Button;
  
  @FindBy(how=How.XPATH,using="//*[contains(text(),'Email or password incorrect')]")
 
  WebElement LoginError;
  
  
  public void enter_email(String Username)
  {
	  Email.sendKeys(Username);
  }
  public void enter_password(String passwd)
  {
	  Password.sendKeys(passwd);
  }
  public void click()
  {
	  Login_Button.click();
  }
  public void logout1()
  {
	  Logout_Button.click(); 
  }
  
  public WebElement Error()
  {
	  WebElement ErrorMessage=LoginError;
	  return ErrorMessage;
  }
  
}
