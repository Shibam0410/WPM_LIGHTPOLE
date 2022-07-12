package lightpole.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage 
{
	 WebDriver driver;
	 public SignUpPage(WebDriver sdriver)
	  {
		  PageFactory.initElements(sdriver,this);
	  }
	  
	  
	  @FindBy(how=How.XPATH,using="//a[@id='admin-dash']")
	 
	  WebElement Admin_link;
	  
	  @FindBy(how=How.XPATH,using="(//button[@class='btn btn-link p-0 m-0'])[1]")
	 
	  WebElement Edit;
	  
	  @FindBy(how=How.XPATH,using="//input[@id='i-email']")
	  WebElement TempMail_Email;
	  
	  @FindBy(how=How.XPATH,using="//button[@id='btn btn-invite']")
	 
	  WebElement Invite_Button;
	  
	  @FindBy(how=How.XPATH,using="//input[@placeholder='Enter First Name']")
	  WebElement Firstname;
	  
	  @FindBy(how=How.XPATH,using="//input[@placeholder='Enter Last Name']")
	  WebElement Lastname;
	  
	  @FindBy(how=How.XPATH,using="//input[@id='mail']")
	  WebElement EmailField;
	  
	  @FindBy(how=How.XPATH,using="//button[@id='submit']")
	
	  WebElement SendInvite;
	  
	  @FindBy(how=How.XPATH,using="//input[@placeholder='Enter Password']")
	  WebElement ConfirmPassword ;
	  
	  @FindBy(how=How.XPATH,using="//input[@placeholder='Retype Password']")
	  WebElement RetypePassword;
	  
	  @FindBy(how=How.XPATH,using="//button[@id='submit']")
	
	  WebElement SignUpButton;
	  
	  @FindBy(how=How.XPATH,using="//*[@id='logout']")
	
	  WebElement Logout;
	  
	  @FindBy(how=How.XPATH,using="//*[@id='resetpwd']")
	 
	  WebElement ForgotPassword;
	  
	  @FindBy(how=How.XPATH,using="//*[@id='email']")
	  WebElement Email;
	  
	  @FindBy(how=How.XPATH,using="//*[@class='btn-primary btn btn-primary']")
	
	  WebElement Submit;
	  
	  @FindBy(how=How.XPATH,using="//*[contains(text(),'LAMP-Reset Password')]")
	 
	  WebElement ResetPasswordLink;
	  
	  @FindBy(how=How.XPATH,using="//*[@name='password']")
	  WebElement ResetPassword;
	  
	  @FindBy(how=How.XPATH,using="//*[@name='confirmPassword']")
	  WebElement ConfirmResetPassword;
	  
	  @FindBy(how=How.XPATH,using="(//*[contains(text(),' Reset Password ')])[2]")
	 
	  WebElement ResetButton;
	  
	  
	  
	  
	  
	  
	  public void Admin()
	  {
		 Admin_link.click();
	  }
	  public WebElement TempEmail()
	  {
		  WebElement Temp=TempMail_Email;
		  return Temp;
	  }
	  public void InviteButton()
	  {
		  Invite_Button.click();
	  }
	  public void Firstname()
	  {
		  Firstname.sendKeys("James");
	  }
	  public void Lastname()
	  {
		  Lastname.sendKeys("Halpert");
	  }
	  public WebElement Email()
	  {
		  WebElement Email=EmailField;
		  return Email;
	  }
	  public void SendInvite()
	  {
		  SendInvite.click();
	  }
	  
	  public void ConfirmPassword()
	  {
		  ConfirmPassword.sendKeys("Qwerty12345@");
	  }
	  
	  public void RetypePassword()
	  {
		  RetypePassword.sendKeys("Qwerty12345@");
	  }
	  
	  public void SignUpButton()
	  {
		  SignUpButton.click();
	  }
	  
	  public void Logout()
	  {
		  Logout.click();
	  }
	  
	  public void ForgotPassword()
	  {
		  ForgotPassword.click();
	  }
	  
	  public WebElement Email1()
	  {
		  WebElement Email1=Email;
		  return Email1;
	  }
	  
	  public void Submit()
	  {
		  Submit.click();
	  }
	  
	  public void ResetPasswordLink()
	  {
		  ResetPasswordLink.click();
	  }
	  
	  public void ConfirmResetPassword()
	  {
		  ResetPassword.sendKeys("Qwerty123456@");
	  }
	  
	  public void ConfirmRetypePassword()
	  {
		  ConfirmResetPassword.sendKeys("Qwerty123456@");
	  }
	  
	  public void ResetButton()
	  {
		  ResetButton.click();
	  }
	  
	  
	 
}
