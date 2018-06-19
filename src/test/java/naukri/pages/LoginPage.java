package naukri.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import appication.utilities.CommonLib;
import application.test.ConfigTest;


public class LoginPage extends PageFactory {
	
	CommonLib objCommonLib = new CommonLib();
	
	@FindBy(xpath="html/body/div[2]/div/ul/li[6]/ahtml/body/div[2]/div/ul/li[6]/a")
	WebElement loginlink;
	
	@FindBy(xpath="//form/div[5]/div[2]/input")
	WebElement username;
	
	@FindBy(xpath="//form/div[6]/div[2]/input")
	WebElement password;
	
	public LoginPage(){
		
		PageFactory.initElements(ConfigTest.driver, this);
		
	}
	
	public void loginToNaukri(){
		objCommonLib.closePopUpWindows();
		objCommonLib.waitforVisibilityOfElement(loginlink,5);
		loginlink.click();
		objCommonLib.defaultwaitforVisibilityOfElement(username);
		username.sendKeys("govindaall@gmail.com");
		password.sendKeys("J0bSearch");
		password.submit();
		
	}
	
	
	
}
