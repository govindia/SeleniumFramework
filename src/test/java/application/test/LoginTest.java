package application.test;

import org.testng.annotations.Test;

import naukri.pages.LoginPage;

public class LoginTest extends ConfigTest{
	
	LoginPage login=null;
	
	@Test
	public void testLogin(){
		System.out.println("hellotest");
		login = new LoginPage();
		login.loginToNaukri();	
		
	}

}
