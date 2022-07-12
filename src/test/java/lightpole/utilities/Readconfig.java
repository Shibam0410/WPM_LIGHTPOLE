package lightpole.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig 
{
  Properties pro;
  public Readconfig()
  {
	  File src=new File("./Configuration/config.properties");
	  try
	  {
		  FileInputStream fis=new FileInputStream(src);
		  pro=new Properties();
		  pro.load(fis);
	  }
	  catch(Exception e)
	  {
		  System.out.println("Exception is:"+e.getMessage());
	  }
  }
  
  public String getDevUrl()
  {
	  String url=pro.getProperty("URL_Dev");
	  return url;
  }
  public String Email()
  {
	  String Email=pro.getProperty("Email");
	  return Email;
  }
  public String Password()
  {
	  String Password=pro.getProperty("Password");
	  return Password;
  }
  public String QAUrl()
  {
	  String QAurl=pro.getProperty("URL_QA");
	  return QAurl;
  }
  public String TempMail()
  {
	  String TempEmail=pro.getProperty("TempMail");
	  return TempEmail;
  }
  public String Viewer_Email()
  {
	  String ViewerEmail=pro.getProperty("Viewer_Email");
	  return ViewerEmail;
  }
  public String Viewer_Password()
  {
	  String ViewerPassword=pro.getProperty("Viewer_Password");
	  return ViewerPassword;
  }
  public String Viewer_EmailQA()
  {
	  String ViewerEmailQA=pro.getProperty("ViewerEmail_QA");
	  return ViewerEmailQA;
  }
  public String Viewer_PasswordQA()
  {
	  String ViewerPasswordQA=pro.getProperty("ViewerPassword_QA");
	  return ViewerPasswordQA;
  }
  
}
