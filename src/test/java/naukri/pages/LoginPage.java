package naukri.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import appication.utilities.CommonLib;
import application.test.ConfigTest;


public class LoginPage extends PageFactory{
	
	CommonLib objCommonLib = new CommonLib();
	/*
	@FindBy(id="login_Layer")
	WebElement loginlink;
	
	@FindBy(xpath="//form/div[5]/div[2]/input")
	WebElement username;
	
	@FindBy(xpath="//form/div[6]/div[2]/input")
	WebElement password;*/
	
	By loginlink = By.id("login_Layer");
	By username = By.xpath("//form/div[5]/div[2]/input");
	By password = By.xpath("//form/div[6]/div[2]/input");
	
	public LoginPage(){
		
		//PageFactory.initElements(ConfigTest.driver,this);
		
	}
	
	public void loginToNaukri(){
		objCommonLib.closePopUpWindows();
		//objCommonLib.waitforVisibilityOfElement(loginlink,5);
		//loginlink.click();
		objCommonLib.clickLocator(loginlink);
		/*objCommonLib.defaultwaitforVisibilityOfElement(username);
		username.sendKeys("govindaall@gmail.com");
		password.sendKeys("J0bSearch");
		password.submit();*/
		
	}
	
	
	
}
