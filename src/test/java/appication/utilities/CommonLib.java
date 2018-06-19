package appication.utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.opencsv.CSVReader;
import application.test.ConfigTest;

public class CommonLib {

	public static ResultSet rs;
	public static WebDriverWait wait;
	public static WebDriverWait dwait;
	String CHAR_LIST = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public void clickLocator(By ele){

		try{

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			WebDriverWait wait = new WebDriverWait(ConfigTest.driver,20);
			wait.until(ExpectedConditions.presenceOfElementLocated(ele));
			ConfigTest.driver.findElement(ele).click();
		}

		catch(org.openqa.selenium.TimeoutException toe){

			System.out.println("Locator identified by "+ele.toString()+" was not clickable after 20 seconds");
		}
	}
	
	public void clickLocatorJS(By ele){	
		try{
			WebElement wele=ConfigTest.driver.findElement(ele);
			WebDriverWait wait = new WebDriverWait(ConfigTest.driver,20);
			wait.until(ExpectedConditions.presenceOfElementLocated(ele));
			JavascriptExecutor js = (JavascriptExecutor)ConfigTest.driver;
			js.executeScript("arguments[0].click();",wele);
	}
		catch(org.openqa.selenium.TimeoutException toe){

			System.out.println("Locator identified by "+ele.toString()+" was not clickable after 20 seconds");
	}
 }
	
	public void enterText(By ele, String text){
		try{	
			WebDriverWait wait = new WebDriverWait(ConfigTest.driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
			ConfigTest.driver.findElement(ele).click();
			ConfigTest.driver.findElement(ele).clear();
			ConfigTest.driver.findElement(ele).sendKeys(text);
		}
		catch(org.openqa.selenium.TimeoutException toe){
			System.out.println("Locator identified by "+ele.toString()+" was not clickable after 20 seconds");
		}
	}

	

	public void enterTextJS(By ele, String text){
		try{	
			WebElement wele=ConfigTest.driver.findElement(ele);
			WebDriverWait wait = new WebDriverWait(ConfigTest.driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
			JavascriptExecutor js = (JavascriptExecutor)ConfigTest.driver;
			js.executeScript("arguments[1].value=arguments[0];",text,wele);
		}
		catch(org.openqa.selenium.TimeoutException toe){

			System.out.println("Locator identified by "+ele.toString()+" was not clickable after 20 seconds");
		}
	   }

	public List<String[]> readDatafromCsv(String csvpath) throws IOException{
		CSVReader reader;
		// this will load content into list
		List<String[]> li=null;
		try{
     		// This will load csv file 
			reader = new CSVReader(new FileReader(csvpath));
			// this will load content into list
			li=reader.readAll();	
			System.out.println("Total rows which we have is "+li.size());
		}
		catch (NoSuchFileException e){
			System.out.println("No such file exists in the specified location");
		}
		return li;
	}

	public void captureScreenShot(WebDriver driver, String folderName, String fileName){
		System.out.println("Taking Screenshot of the failed test case");
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try{
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			Date date = new Date();
			System.out.println(dateFormat.format(date));
			FileUtils.copyFile(src, new File("src"+File.separator+"test"+File.separator+"java"+File.separator+"TI_SDP"+File.separator+"SMC_Restyling"+File.separator+"screenshot"+File.separator+folderName+File.separator+fileName+"-"+dateFormat.format(date)+".png"));
		}

		catch(IOException e){

			e.printStackTrace();
		}

	}
	
	public String getInnerHTML(By ele){
		String innertext;
		WebDriverWait wait = new WebDriverWait(ConfigTest.driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(ele));
		try{
		     innertext=ConfigTest.driver.findElement(ele).getText();
		   }
		catch(NoSuchElementException e){
			innertext=null;
			System.out.println("Message is not displayed or page has been changed.");
		}
		return innertext;
	}
	
	public ResultSet executeDatabaseQuery(String queryStatement) throws SQLException{
    	// This will create statement  
		Statement smt=ConfigTest.con.createStatement();
		System.out.println("Statement created");
		// Now execute the query
		rs=  smt.executeQuery(queryStatement);
		System.out.println("Query Executed");	
		return rs;	
	}
	
	public ArrayList<String> getDataFromColoumnInTable(String columnName) throws SQLException{
		ArrayList<String> results = new ArrayList<String>();		
		while (rs.next()){	
			results.add(rs.getString(columnName));		
		}
		return results;
	}
		
	public void findElement(By ele){	
		try{	
			WebDriverWait wait = new WebDriverWait(ConfigTest.driver, 20);
			wait.until(ExpectedConditions.visibilityOfElementLocated(ele));
			ConfigTest.driver.findElement(ele);
		   }
		catch(NoSuchElementException e){			
		    System.out.println("The Locator "+ele+" is not present in the Page");        
	  } 	    
    }
	
	public String[] saperateMutipleParameters(String parameter) {
		String [] parameters=parameter.split(",");
		return parameters;
	}
	
	public boolean locatorIsDisplayed(By ele){		
		return ConfigTest.driver.findElement(ele).isDisplayed();
	}
	
	public boolean locatorIsEnabled(By ele){		
		return ConfigTest.driver.findElement(ele).isEnabled();
	}
	
	public void waitforVisibilityOfElement(WebElement loginlink, int time){	
		WebDriverWait wait=new WebDriverWait(ConfigTest.driver,time);
		wait.until(ExpectedConditions.visibilityOf(loginlink));
	}	
	
	public void defaultwaitforVisibilityOfElement(WebElement element){	
		WebDriverWait wait=new WebDriverWait(ConfigTest.driver,2);
		wait.until(ExpectedConditions.visibilityOf(element));
	}	
	
	public String generateRandomString(int count){
		int RANDOM_STRING_LENGTH = count;
		Random rnd = new Random();
		StringBuffer randStr = new StringBuffer();
		for(int i=0; i<RANDOM_STRING_LENGTH; i++){
			char c = CHAR_LIST.charAt(rnd.nextInt(CHAR_LIST.length()));
			randStr.append(c);
		}
		String randomString = randStr.toString()+"-"+rnd.nextInt(99);
		System.out.println("Random String is: "+randomString);
		return randomString;
	}

	
	public String generateRandomIp(){
		Random r = new Random();
		return r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256) + "." + r.nextInt(256);
	}
	
	/*
	public String generateRandomCLI(){
		Random r = new Random();
		return "1"+r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9)+r.nextInt(9) + r.nextInt(9) + r.nextInt(9) + r.nextInt(9);
	}
	*/	
	
	public String decodedPassword(String encryptedPassword){ 
		byte[] decryptedPasswordBytes = encryptedPassword.getBytes();
		String decryptedPassword = Base64.decodeBase64(decryptedPasswordBytes).toString();
		return decryptedPassword;
	 }	
	
	
	public void closePopUpWindows(){
		
		Set<String> windowhandles=ConfigTest.driver.getWindowHandles();
		List<String>  whandles= new ArrayList<String>(windowhandles);
		String defaultWindow=ConfigTest.driver.getWindowHandle();
		for(int i=1;i<whandles.size();i++){	
			ConfigTest.driver.switchTo().window(whandles.get(i)).close();	
		}
		
		ConfigTest.driver.switchTo().window(defaultWindow);
		
	}	 
}