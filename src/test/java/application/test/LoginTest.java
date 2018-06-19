package application.test;

import org.testng.annotations.Test;

import naukri.pages.LoginPage;

public class LoginTest extends ConfigTest{
	
	LoginPage login;
	
	@Test
	public void testLogin(){
		 
		login = new LoginPage();
		login.loginToNaukri();	
		
	}

}
