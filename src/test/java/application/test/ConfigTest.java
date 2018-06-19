package application.test;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.TestNG;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import appication.utilities.CommonLib;
import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;

public class ConfigTest {
	
	public static WebDriver driver;
	public static Connection con;
	
	CommonLib objCommonLib = new CommonLib();	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 
		//Creating object for TestNG Class
		TestNG objRunner = new TestNG();
		
		//Create a list of String
		List<String> suiteFiles = new ArrayList<String>();
		
		//Add XML File to execute
		suiteFiles.add("testng.xml");
		
		//Set XML file for execution
		objRunner.setTestSuites(suiteFiles);
		
		//Execute the Testng using run
		objRunner.run();

	}
	
	
	@Parameters({"appURL","browserName","dbHost","dbUsername","dbEncryptedPassword"})
	@BeforeClass
	public void setup(String strAppURL, String strBrowser, String dbHost, String dbUsername, String dbEncryptedPassword){

		if(strBrowser.equalsIgnoreCase("chrome")){

			ChromeDriverManager.getInstance().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(strAppURL);
			System.out.println("Title of the Page: "+driver.getTitle());

		}	

		else if(strBrowser.equalsIgnoreCase("firefox")){

			FirefoxDriverManager.getInstance().setup();
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.get(strAppURL);
			System.out.println("Title of the Page: "+driver.getTitle());
		}

		else if(strBrowser.equalsIgnoreCase("internetExplorer")){
			

			//InternetExplorerDriverManager.getInstance().setup();
			System.setProperty("webdriver.ie.driver", "drivers"+File.separator+"IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			//driver.manage().window().maximize();
			driver.get(strAppURL);
			System.out.println("Title of the Page: "+driver.getTitle());
		}	

		//Connect to the Database
/*
		try {

			// This will load the driver
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("Oracle Driver Loaded");

			// This will connect with Database , getConnection taking three argument
			//  first argument Test_Oracle is the dsn which you can change as per your system,
			// second argument is username and third argument is password
			String strDbPassword = objCommonLib.decodedPassword(dbEncryptedPassword);
			con = DriverManager.getConnection(dbHost, dbUsername, strDbPassword);
			System.out.println("Connection created");
		}

		catch (Exception e) {

			System.out.println("DataBase Connection Failed");
		}
		
*/
	}
	

	@BeforeMethod
	public void waitBeforeEveryMethod() throws InterruptedException{

		//driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		Thread.sleep(3000);
	}


	@AfterClass
	public void closeBrowser() throws SQLException{
		
		try{
			
			con.close();
			System.out.println("Connection Closed");
		}
		
		catch(SQLException e){
			
			System.out.println("Connection not able to Close");
		}
		
		driver.close();
	}


}
